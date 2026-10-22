package com.larus.bmhome.chat.component.list;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.PausingDispatcherKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.keva.Keva;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.auth.ConversationMode;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.auth.douyin.IAiChatOpenDouyinAuthService;
import com.larus.bmhome.chat.ChatActivity;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.adapter.HeaderAreaAdapter;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.bubble.floating.runtime.IBubbleBannerRuntimeService;
import com.larus.bmhome.chat.cache.MessageHeightCache;
import com.larus.bmhome.chat.cell.view.AbstractMessageBoxContainerView;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonType;
import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import com.larus.bmhome.chat.component.ext.ChatFragmentDelegateDialogExtKt;
import com.larus.bmhome.chat.component.ext.ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1;
import com.larus.bmhome.chat.component.list.pipeline.direct_add.UserActiveDeleteTipHelper;
import com.larus.bmhome.chat.component.playback.MessagePlaybackHelper;
import com.larus.bmhome.chat.doc.DocumentMessageProcessor;
import com.larus.bmhome.chat.exposure.ExposureConfig;
import com.larus.bmhome.chat.exposure.TriggerCoordinator;
import com.larus.bmhome.chat.helper.ChatRouterHelper;
import com.larus.bmhome.chat.layout.holder.BotBioHolder;
import com.larus.bmhome.chat.layout.holder.PrivateHolder;
import com.larus.bmhome.chat.layout.holder.progressloading.GenImgLoadingResourceGetter;
import com.larus.bmhome.chat.layout.widget.NestedScrollableContainer;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.stop.PendingAppletActionCancellation;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.praise.IAiChatPraiseTriggerService;
import com.larus.bmhome.utils.LandingRedBadgeHelperDelegate;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.ChatMessageList$applyBottomInset$1;
import com.larus.bmhome.view.MessageMenu;
import com.larus.bmhome.view.actionbar.NonPriorityMessageActionBar;
import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.utils.ViewExtKt$watchOnImeInsetsAnimationEndOnce$callback$1;
import com.larus.extension.offline_message.api.OfflineMessageServiceDelegate;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.home.impl.chat.multi_tab.ChatMultiTabFragment;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.ForkConversationRequest;
import com.larus.im.bean.conversation.ForkSource;
import com.larus.im.bean.conversation.ForkType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.MessageTag;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.legacy.NativeCmdServiceImpl;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.media.MediaResourceManager;
import com.larus.nova.R;
import com.larus.platform.IFlowMessageService;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IAppLaunchReporter;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.larus.platform.model.MessageCollection;
import com.larus.platform.model.NotificationBusiness;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.model.chat.ChatAwemeFeedConfig;
import com.larus.platform.model.music.ThirdPartyMusicPlatform;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.service.AccountService;
import com.larus.platform.spi.IAIChatTtsPlayTraceService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.larus.utils.ActivityTransition$captureExitSharedElement$1;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallConfigServiceDelegate;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000î\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\t\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0010õ\u0002\u0083\u0003\u0086\u0003\u008f\u0003\u0092\u0003\u009e\u0003¥\u0003¶\u0003\u0018\u0000 õ\u00062\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u00042\u00020\u0005:\u0004õ\u0006ö\u0006B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\"H\u0002J\u0016\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\b\u0010:\u001a\u00020)H\u0002J\u001c\u0010þ\u0002\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\b\u0010\u0080\u0003\u001a\u00030\u0081\u0003H\u0002J$\u0010\u0088\u0003\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\u0007\u0010\u0089\u0003\u001a\u00020\u000f2\u0007\u0010\u008a\u0003\u001a\u00020)H\u0002J\u0014\u0010\u008b\u0003\u001a\u00020&2\t\u0010ÿ\u0002\u001a\u0004\u0018\u00010,H\u0002J\u0014\u0010\u008c\u0003\u001a\u00020&2\t\u0010ÿ\u0002\u001a\u0004\u0018\u00010,H\u0002J\u0014\u0010\u008d\u0003\u001a\u00020&2\t\u0010ÿ\u0002\u001a\u0004\u0018\u00010,H\u0002J\u0014\u0010\u009b\u0003\u001a\u00020&2\t\u0010\u009c\u0003\u001a\u0004\u0018\u00010\u000fH\u0002J\u001e\u0010§\u0003\u001a\u00030¨\u00032\t\u0010\u0089\u0003\u001a\u0004\u0018\u00010\u000f2\u0007\u0010©\u0003\u001a\u00020\u000fH\u0002J\t\u0010ª\u0003\u001a\u00020&H\u0002J\t\u0010«\u0003\u001a\u00020&H\u0016J\t\u0010¬\u0003\u001a\u00020&H\u0016J\t\u0010\u00ad\u0003\u001a\u00020\u000fH\u0002J\u0013\u0010®\u0003\u001a\u00030¯\u00032\u0007\u0010°\u0003\u001a\u00020,H\u0002J\u0013\u0010±\u0003\u001a\u00020&2\b\u0010²\u0003\u001a\u00030³\u0003H\u0002J\t\u0010¸\u0003\u001a\u00020&H\u0002J\t\u0010¹\u0003\u001a\u00020&H\u0002J\u0013\u0010º\u0003\u001a\u00020&2\b\u0010»\u0003\u001a\u00030¼\u0003H\u0002J\u0013\u0010½\u0003\u001a\u00020&2\b\u0010¾\u0003\u001a\u00030¿\u0003H\u0016J\t\u0010À\u0003\u001a\u00020&H\u0002J\u001f\u0010Á\u0003\u001a\u00020&2\t\u0010Â\u0003\u001a\u0004\u0018\u00010\u000f2\t\u0010Ã\u0003\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u0010Ä\u0003\u001a\u00020&2\t\u0010\u0089\u0003\u001a\u0004\u0018\u00010\u000fH\u0002J\t\u0010Å\u0003\u001a\u00020&H\u0002J\t\u0010Æ\u0003\u001a\u00020&H\u0002J\t\u0010Ç\u0003\u001a\u00020&H\u0002J\t\u0010È\u0003\u001a\u00020)H\u0002J\t\u0010É\u0003\u001a\u00020&H\u0002J\t\u0010Ê\u0003\u001a\u00020&H\u0002J9\u0010Ë\u0003\u001a\u00020&2\t\u0010ÿ\u0002\u001a\u0004\u0018\u00010,2\u0007\u0010Ì\u0003\u001a\u00020)2\u0007\u0010Í\u0003\u001a\u00020)2\b\u0010Î\u0003\u001a\u00030Ï\u00032\u0007\u0010Ð\u0003\u001a\u00020)H\u0002J\t\u0010Ñ\u0003\u001a\u00020&H\u0002J\t\u0010Ò\u0003\u001a\u00020&H\u0002J\t\u0010Ó\u0003\u001a\u00020&H\u0002J\u0012\u0010Ô\u0003\u001a\u00020&2\u0007\u0010Õ\u0003\u001a\u00020)H\u0002J\t\u0010Ö\u0003\u001a\u00020&H\u0016J\t\u0010×\u0003\u001a\u00020&H\u0016J\t\u0010Ø\u0003\u001a\u00020&H\u0016J\t\u0010Þ\u0003\u001a\u00020&H\u0016J\t\u0010ß\u0003\u001a\u00020&H\u0016J\n\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u0016\u0010à\u0003\u001a\u0005\u0018\u00010¼\u00032\b\u0010¾\u0003\u001a\u00030¿\u0003H\u0016J\n\u0010á\u0003\u001a\u00030¼\u0003H\u0016J\t\u0010â\u0003\u001a\u00020&H\u0016J\u0011\u0010ã\u0003\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0016J\u001b\u0010ä\u0003\u001a\u00020)2\u0007\u0010\u0089\u0003\u001a\u00020\u000f2\u0007\u0010å\u0003\u001a\u00020\tH\u0016J\u001b\u0010æ\u0003\u001a\u00020)2\u0007\u0010ç\u0003\u001a\u00020\u000f2\u0007\u0010å\u0003\u001a\u00020\tH\u0016J#\u0010è\u0003\u001a\u00020)2\u0007\u0010\u0089\u0003\u001a\u00020\u000f2\t\u0010å\u0003\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0003\u0010é\u0003J\u0011\u0010ê\u0003\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0016J\u0018\u0010ë\u0003\u001a\u00020&2\r\u0010ì\u0003\u001a\b\u0012\u0004\u0012\u00020&0EH\u0016J\t\u0010í\u0003\u001a\u00020&H\u0016J\t\u0010î\u0003\u001a\u00020&H\u0002J\u001d\u0010ð\u0003\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\t\b\u0002\u0010ñ\u0003\u001a\u00020)H\u0002J\u0012\u0010ò\u0003\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0002J\u0012\u0010ó\u0003\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0002J\u0011\u0010ô\u0003\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0003\u0010õ\u0003J\t\u0010ö\u0003\u001a\u00020)H\u0002J\f\u0010÷\u0003\u001a\u0005\u0018\u00010ø\u0003H\u0002J\u000b\u0010ù\u0003\u001a\u0004\u0018\u00010\u000fH\u0002J\f\u0010ú\u0003\u001a\u0005\u0018\u00010û\u0003H\u0002J\u000b\u0010ü\u0003\u001a\u0004\u0018\u00010\u000fH\u0002J\t\u0010ý\u0003\u001a\u00020\u000fH\u0002J\u0012\u0010þ\u0003\u001a\u00020&2\u0007\u0010ÿ\u0003\u001a\u00020\u000fH\u0002J\t\u0010\u0080\u0004\u001a\u00020&H\u0002J\t\u0010\u0081\u0004\u001a\u00020&H\u0002J\u0011\u0010\u0082\u0004\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0003\u0010\u0083\u0004J\u0016\u0010\u0086\u0004\u001a\u00020&2\r\u0010\u0087\u0004\u001a\b\u0012\u0004\u0012\u00020&0EJ\u001b\u0010\u0088\u0004\u001a\u00020&2\u0007\u0010\u0089\u0004\u001a\u00020\u000f2\u0007\u0010\u008a\u0004\u001a\u00020)H\u0016J\u001b\u0010\u008b\u0004\u001a\u00020&2\u0007\u0010\u0089\u0004\u001a\u00020\u000f2\u0007\u0010\u008c\u0004\u001a\u00020)H\u0016J$\u0010\u0088\u0004\u001a\u00020&2\u0007\u0010\u0089\u0004\u001a\u00020\u000f2\u0007\u0010\u008c\u0004\u001a\u00020)2\u0007\u0010\u008d\u0004\u001a\u00020)H\u0002J\u001b\u0010\u008e\u0004\u001a\u00020&2\u0007\u0010\u008f\u0004\u001a\u00020\t2\u0007\u0010\u008d\u0004\u001a\u00020)H\u0002J\u0012\u0010\u0090\u0004\u001a\u00020&2\u0007\u0010\u008f\u0004\u001a\u00020\tH\u0016J\t\u0010\u0091\u0004\u001a\u00020&H\u0002J\t\u0010\u0092\u0004\u001a\u00020&H\u0016J\t\u0010\u0093\u0004\u001a\u00020)H\u0016J\u0014\u0010\u0094\u0004\u001a\u00020&2\t\b\u0002\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\t\u0010\u0096\u0004\u001a\u00020&H\u0002J\t\u0010\u0097\u0004\u001a\u00020)H\u0002J\t\u0010\u0098\u0004\u001a\u00020)H\u0002J\u0012\u0010\u0099\u0004\u001a\u00020)2\u0007\u0010\u009a\u0004\u001a\u00020)H\u0002J\u0012\u0010\u009b\u0004\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\t\u0010\u009c\u0004\u001a\u00020&H\u0002J\t\u0010\u009d\u0004\u001a\u00020)H\u0002J\u0012\u0010\u009e\u0004\u001a\u00020)2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\u0012\u0010\u009f\u0004\u001a\u00020\t2\u0007\u0010 \u0004\u001a\u00020\u0016H\u0002J\u0018\u0010¡\u0004\u001a\u00020)2\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u001c\u0010§\u0004\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0^0¨\u0004H\u0016J\u000b\u0010©\u0004\u001a\u0004\u0018\u00010GH\u0016J\t\u0010ª\u0004\u001a\u00020)H\u0002J\t\u0010«\u0004\u001a\u00020&H\u0002J\t\u0010¬\u0004\u001a\u00020&H\u0002J\n\u0010\u00ad\u0004\u001a\u00030®\u0004H\u0002J\n\u0010¯\u0004\u001a\u00030°\u0004H\u0002J\u0015\u0010±\u0004\u001a\u0004\u0018\u00010,2\b\u0010²\u0004\u001a\u00030³\u0004H\u0002J,\u0010´\u0004\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\u000b\b\u0002\u0010µ\u0004\u001a\u0004\u0018\u00010\u000f2\u000b\b\u0002\u0010\u0089\u0003\u001a\u0004\u0018\u00010\u000fH\u0002J\t\u0010¶\u0004\u001a\u00020)H\u0002J\u000b\u0010·\u0004\u001a\u0004\u0018\u00010wH\u0002J\t\u0010¸\u0004\u001a\u00020)H\u0002J\t\u0010¹\u0004\u001a\u00020)H\u0002J\u0012\u0010¼\u0004\u001a\u00020&2\u0007\u0010ÿ\u0003\u001a\u00020\u000fH\u0002J\u0013\u0010½\u0004\u001a\u00030¾\u00042\u0007\u0010ÿ\u0002\u001a\u00020,H\u0002J\u0012\u0010¿\u0004\u001a\u00020)2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0002J\t\u0010À\u0004\u001a\u00020&H\u0002J\u001d\u0010Á\u0004\u001a\u00020\t2\u000b\b\u0002\u0010Â\u0004\u001a\u0004\u0018\u00010\u000fH\u0082@¢\u0006\u0003\u0010Ã\u0004J\t\u0010Ä\u0004\u001a\u00020&H\u0002J\t\u0010Å\u0004\u001a\u00020&H\u0016J\u0012\u0010Æ\u0004\u001a\u00020&2\u0007\u0010Ç\u0004\u001a\u00020)H\u0016J\u0012\u0010È\u0004\u001a\u00020&2\u0007\u0010É\u0004\u001a\u00020)H\u0016J\u0012\u0010Ê\u0004\u001a\u00020&2\u0007\u0010Ë\u0004\u001a\u00020\tH\u0016J\t\u0010Ì\u0004\u001a\u00020)H\u0016J\u0011\u0010Í\u0004\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0003\u0010õ\u0003J\t\u0010Î\u0004\u001a\u00020)H\u0002J\t\u0010Ï\u0004\u001a\u00020&H\u0002J\u001a\u0010Ð\u0004\u001a\u0004\u0018\u00010&2\u0007\u0010ÿ\u0003\u001a\u00020\u000fH\u0002¢\u0006\u0003\u0010Ñ\u0004J\u000b\u0010Ò\u0004\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010Ó\u0004\u001a\u00020&*\u00030¢\u00012\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+2\u0007\u0010ÿ\u0003\u001a\u00020\u000fH\u0002J\u0014\u0010Ô\u0004\u001a\u00020&2\t\u0010Õ\u0004\u001a\u0004\u0018\u00010,H\u0002J\t\u0010Ö\u0004\u001a\u00020&H\u0016J\t\u0010×\u0004\u001a\u00020GH\u0016J\u0018\u0010Ù\u0004\u001a\u00020)2\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\t\u0010Ú\u0004\u001a\u00020&H\u0002J>\u0010Û\u0004\u001a\u00020&*\u00030¢\u00012\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+2\u0007\u0010Ü\u0004\u001a\u0002062\u000b\b\u0002\u0010Ý\u0004\u001a\u0004\u0018\u00010\u000f2\t\b\u0002\u0010Þ\u0004\u001a\u00020)H\u0002J\u0014\u0010ß\u0004\u001a\u00020)2\t\u0010à\u0004\u001a\u0004\u0018\u00010,H\u0002J\u001d\u0010á\u0004\u001a\u000206*\u00030¢\u00012\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\t\u0010â\u0004\u001a\u00020)H\u0002J>\u0010ã\u0004\u001a\u00020)2\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+2\u0007\u0010Ü\u0004\u001a\u0002062\t\u0010Ý\u0004\u001a\u0004\u0018\u00010\u000f2\u0007\u0010â\u0004\u001a\u00020)2\u0007\u0010ä\u0004\u001a\u00020)H\u0002J!\u0010å\u0004\u001a\u00020)2\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+2\u0007\u0010Ü\u0004\u001a\u000206H\u0002J,\u0010æ\u0004\u001a\u00020)2\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+2\u0007\u0010Ü\u0004\u001a\u0002062\t\u0010Ý\u0004\u001a\u0004\u0018\u00010\u000fH\u0002J\t\u0010ç\u0004\u001a\u00020)H\u0002J\u0015\u0010ç\u0004\u001a\u00020)2\n\u0010è\u0004\u001a\u0005\u0018\u00010³\u0003H\u0002J\t\u0010é\u0004\u001a\u00020)H\u0002J\u0015\u0010é\u0004\u001a\u00020)2\n\u0010è\u0004\u001a\u0005\u0018\u00010³\u0003H\u0002J\t\u0010ê\u0004\u001a\u00020\u000fH\u0002J$\u0010ë\u0004\u001a\u00020&2\u0007\u0010Ü\u0004\u001a\u0002062\u0007\u0010Ý\u0004\u001a\u00020\u000f2\u0007\u0010ì\u0004\u001a\u00020)H\u0002J\u0012\u0010í\u0004\u001a\u00020)2\u0007\u0010î\u0004\u001a\u00020,H\u0002J\t\u0010í\u0004\u001a\u00020)H\u0002J\u001a\u0010ï\u0004\u001a\u00020&2\u000f\u0010ð\u0004\u001a\n\u0012\u0005\u0012\u00030¯\u00030ñ\u0004H\u0002J\u001a\u0010ò\u0004\u001a\u00020&2\u000f\u0010ð\u0004\u001a\n\u0012\u0005\u0012\u00030¯\u00030ñ\u0004H\u0002J\u0014\u0010ó\u0004\u001a\u00020&2\t\u0010°\u0003\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010ô\u0004\u001a\u00020)2\u0007\u0010°\u0003\u001a\u00020,H\u0002J\t\u0010õ\u0004\u001a\u00020)H\u0016J\t\u0010ö\u0004\u001a\u000206H\u0016J\t\u0010÷\u0004\u001a\u000206H\u0016J\t\u0010ø\u0004\u001a\u00020)H\u0002J\u0018\u0010ù\u0004\u001a\u0002062\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u0018\u0010ú\u0004\u001a\u0002062\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u001d\u0010û\u0004\u001a\u000206*\u00030¢\u00012\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\u0018\u0010ü\u0004\u001a\u0002062\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\t\u0010ý\u0004\u001a\u000206H\u0002J\t\u0010þ\u0004\u001a\u00020)H\u0002J\t\u0010ÿ\u0004\u001a\u000206H\u0002J\u0018\u0010\u0080\u0005\u001a\u0002062\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+H\u0002J\"\u0010\u0081\u0005\u001a\u0002062\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+2\b\u0010\u0082\u0005\u001a\u00030ø\u0003H\u0002J!\u0010\u0081\u0005\u001a\u0002062\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+2\u0007\u0010\u0083\u0005\u001a\u000206H\u0002J\u0013\u0010\u0084\u0005\u001a\u00020)2\b\u0010\u0082\u0005\u001a\u00030ø\u0003H\u0002J\u000e\u0010\u0085\u0005\u001a\u00020&*\u00030¢\u0001H\u0002J\t\u0010\u0086\u0005\u001a\u00020)H\u0002J\u000b\u0010\u0087\u0005\u001a\u0004\u0018\u00010\u000fH\u0016J\t\u0010\u0088\u0005\u001a\u00020\u000fH\u0002J\u0017\u0010\u0089\u0005\u001a\u0005\u0018\u00010\u008a\u00052\t\u0010\u0089\u0003\u001a\u0004\u0018\u00010\u000fH\u0016J\u0014\u0010\u008b\u0005\u001a\u00020)2\t\u0010\u0089\u0003\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010\u008c\u0005\u001a\u00020&2\b\u0010\u008d\u0005\u001a\u00030\u008a\u0005H\u0016J\u0012\u0010\u008e\u0005\u001a\u00020&2\u0007\u0010\u0089\u0003\u001a\u00020\u000fH\u0002J\u0013\u0010\u008f\u0005\u001a\u00020&2\b\u0010\u008d\u0005\u001a\u00030\u008a\u0005H\u0016J\u0012\u0010\u008f\u0005\u001a\u00020&2\u0007\u0010\u0089\u0003\u001a\u00020\u000fH\u0016J\u000b\u0010\u0090\u0005\u001a\u0004\u0018\u00010\u000fH\u0002J\u0019\u0010\u0091\u0005\u001a\u00020&2\u000e\u0010*\u001a\n\u0012\u0005\u0012\u00030¯\u00030ñ\u0004H\u0002J\"\u0010\u0092\u0005\u001a\n\u0012\u0005\u0012\u00030¯\u00030ñ\u00042\u000f\u0010\u0093\u0005\u001a\n\u0012\u0005\u0012\u00030¯\u00030ñ\u0004H\u0002J\u001a\u0010\u0094\u0005\u001a\u00020&2\u000f\u0010\u0093\u0005\u001a\n\u0012\u0005\u0012\u00030¯\u00030ñ\u0004H\u0002J#\u0010\u0095\u0005\u001a\u00020&2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+2\b\u0010\u0096\u0005\u001a\u00030\u0097\u0005H\u0002JM\u0010\u0098\u0005\u001a\u00020&2\b\u0010\u0096\u0005\u001a\u00030\u0097\u00052\u000b\b\u0002\u0010\u0099\u0005\u001a\u0004\u0018\u00010)2\u000b\b\u0002\u0010\u009a\u0005\u001a\u0004\u0018\u00010)2\u000b\b\u0002\u0010\u009b\u0005\u001a\u0004\u0018\u00010)2\u000b\b\u0002\u0010\u009c\u0005\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0003\u0010\u009d\u0005J\u0013\u0010\u009e\u0005\u001a\u00020)*\b\u0012\u0004\u0012\u00020,0+H\u0002J\u0013\u0010\u009f\u0005\u001a\u00020)*\b\u0012\u0004\u0012\u00020,0+H\u0002J\u001c\u0010 \u0005\u001a\u0005\u0018\u00010\u0080\u00012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0002J\r\u0010¡\u0005\u001a\u00020)*\u00020,H\u0002J\r\u0010¢\u0005\u001a\u00020)*\u00020,H\u0002J\t\u0010£\u0005\u001a\u00020)H\u0002J\u0012\u0010¤\u0005\u001a\u00020)2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0002J\t\u0010¥\u0005\u001a\u00020&H\u0002J\u0012\u0010¦\u0005\u001a\u00020&2\u0007\u0010§\u0005\u001a\u00020)H\u0002J\u0012\u0010¨\u0005\u001a\u00020)2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0002J\t\u0010©\u0005\u001a\u00020&H\u0002J\t\u0010ª\u0005\u001a\u00020&H\u0016J\u0015\u0010«\u0005\u001a\u00020&2\n\u0010¬\u0005\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\u0015\u0010\u00ad\u0005\u001a\u00020&2\n\u0010¬\u0005\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\u0015\u0010®\u0005\u001a\u00020&2\n\u0010¬\u0005\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\u0015\u0010¯\u0005\u001a\u00020&2\n\u0010¬\u0005\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J\u0012\u0010°\u0005\u001a\u00020&2\u0007\u0010±\u0005\u001a\u00020\tH\u0016J(\u0010²\u0005\u001a\u00020&2\u0007\u0010³\u0005\u001a\u00020)2\u0014\u0010´\u0005\u001a\u000f\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020&0µ\u0005H\u0016J\t\u0010¶\u0005\u001a\u00020&H\u0016J\t\u0010·\u0005\u001a\u00020)H\u0002J\u0012\u0010¸\u0005\u001a\u00020&2\u0007\u0010¹\u0005\u001a\u00020)H\u0016J\u0013\u0010º\u0005\u001a\u00020&2\b\u0010»\u0005\u001a\u00030¼\u0005H\u0016J\t\u0010½\u0005\u001a\u00020&H\u0016J\t\u0010¾\u0005\u001a\u00020&H\u0002J\t\u0010¿\u0005\u001a\u00020&H\u0002J\u000b\u0010À\u0005\u001a\u0004\u0018\u00010\\H\u0002J\n\u0010Á\u0005\u001a\u00030Â\u0005H\u0016J\u0012\u0010Ã\u0005\u001a\u00020&2\u0007\u0010Ä\u0005\u001a\u00020)H\u0016J\t\u0010Å\u0005\u001a\u00020&H\u0016J\t\u0010Æ\u0005\u001a\u00020&H\u0016J\t\u0010Ç\u0005\u001a\u00020&H\u0016J\t\u0010È\u0005\u001a\u00020&H\u0016J\u0012\u0010É\u0005\u001a\u00020&2\u0007\u0010°\u0003\u001a\u00020,H\u0016J\t\u0010Ê\u0005\u001a\u00020&H\u0016J\t\u0010Ë\u0005\u001a\u00020&H\u0002J\t\u0010Ì\u0005\u001a\u00020&H\u0002J\t\u0010Í\u0005\u001a\u00020&H\u0002J\t\u0010Î\u0005\u001a\u00020&H\u0002J\t\u0010Ï\u0005\u001a\u00020&H\u0002J\t\u0010Ð\u0005\u001a\u00020&H\u0002J\t\u0010Ñ\u0005\u001a\u00020&H\u0002J\t\u0010Ò\u0005\u001a\u00020&H\u0002J\u0016\u0010Õ\u0005\u001a\u00020)2\u000b\b\u0002\u0010ÿ\u0003\u001a\u0004\u0018\u00010\u000fH\u0002J!\u0010Ö\u0005\u001a\u00020&2\r\u0010¢\u0004\u001a\b\u0012\u0004\u0012\u00020,0+2\u0007\u0010ÿ\u0003\u001a\u00020\u000fH\u0002J\t\u0010×\u0005\u001a\u00020&H\u0002J\u0013\u0010Ø\u0005\u001a\u00020\u000f2\b\u0010\u0082\u0005\u001a\u00030ø\u0003H\u0002J\t\u0010Ù\u0005\u001a\u00020&H\u0002J\t\u0010Ú\u0005\u001a\u00020&H\u0016J\u0012\u0010Ý\u0005\u001a\u00020&2\u0007\u0010Þ\u0005\u001a\u00020)H\u0016J\u000b\u0010ß\u0005\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010à\u0005\u001a\u00020&2\u0007\u0010°\u0003\u001a\u00020,H\u0002J\t\u0010Ü\u0005\u001a\u00020)H\u0016J\u0012\u0010á\u0005\u001a\u00020&2\u0007\u0010â\u0005\u001a\u00020)H\u0016J\t\u0010ã\u0005\u001a\u00020&H\u0002J\t\u0010ä\u0005\u001a\u00020&H\u0016J\t\u0010å\u0005\u001a\u00020&H\u0016J\t\u0010æ\u0005\u001a\u00020&H\u0002J\t\u0010ç\u0005\u001a\u00020&H\u0002J\u0012\u0010è\u0005\u001a\u00020&2\u0007\u0010é\u0005\u001a\u00020\u000fH\u0002J5\u0010ê\u0005\u001a\u00020&2\u0007\u0010\u0089\u0003\u001a\u00020\u000f2\n\u0010ë\u0005\u001a\u0005\u0018\u00010ì\u00052\n\u0010í\u0005\u001a\u0005\u0018\u00010î\u00052\t\u0010ï\u0005\u001a\u0004\u0018\u00010\u000fH\u0016J'\u0010ð\u0005\u001a\u00020&2\b\u0010\u0080\u0003\u001a\u00030ñ\u00052\u0007\u0010\u0089\u0003\u001a\u00020\u000f2\t\u0010Â\u0004\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010ò\u0005\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0007\u0012\u0005\u0018\u00010ó\u0005\u0018\u00010^2\b\u0010\u0080\u0003\u001a\u00030ñ\u0005H\u0016J\u0012\u0010ô\u0005\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0016J[\u0010õ\u0005\u001a\u00020&2\n\u0010ö\u0005\u001a\u0005\u0018\u00010ø\u00032\u0007\u0010÷\u0005\u001a\u00020,2\u0007\u0010ø\u0005\u001a\u00020\u000f2\n\u0010ù\u0005\u001a\u0005\u0018\u00010ú\u00052\u0007\u0010û\u0005\u001a\u00020)2\t\u0010ü\u0005\u001a\u0004\u0018\u00010\u000f2\u0007\u0010ý\u0005\u001a\u0002062\t\u0010þ\u0005\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0080\u0006\u001a\u00020&2\r\u0010ì\u0003\u001a\b\u0012\u0004\u0012\u00020&0EH\u0016J<\u0010\u0081\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\u0007\u0010\u0082\u0006\u001a\u00020\u000f2\u0016\u0010\u0083\u0006\u001a\u0011\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0084\u00062\u0007\u0010\u0085\u0006\u001a\u00020)H\u0016J\u001b\u0010\u0086\u0006\u001a\u00020&2\u0007\u0010\u0087\u0006\u001a\u00020)2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0016J\u001b\u0010\u0088\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\u0007\u0010\u0089\u0006\u001a\u00020\u000fH\u0016J\u0012\u0010\u008a\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0016J\u0012\u0010\u008b\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0016J\t\u0010\u008c\u0006\u001a\u00020)H\u0016J\u0017\u0010\u008d\u0006\u001a\u00020&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\u0014\u0010\u008e\u0006\u001a\u0004\u0018\u00010\u000f2\u0007\u0010²\u0003\u001a\u00020,H\u0002J#\u0010\u008f\u0006\u001a\u00020&2\u0007\u0010°\u0003\u001a\u00020,2\t\u0010\u0080\u0003\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0003\u0010\u0090\u0006JE\u0010\u0091\u0006\u001a\u00020&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0007\u0010Â\u0004\u001a\u00020\u000f2\b\u0010\u0092\u0006\u001a\u00030\u0093\u00062\b\u0010\u0094\u0006\u001a\u00030\u0095\u00062\u000f\u0010\u0096\u0006\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010EH\u0016J9\u0010\u0097\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\t\u0010\u0080\u0003\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0098\u0006\u001a\u000f\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020&0µ\u0005H\u0016¢\u0006\u0003\u0010\u0099\u0006J#\u0010\u009a\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\t\u0010\u0080\u0003\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0003\u0010\u0090\u0006J#\u0010\u009b\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\t\u0010\u0080\u0003\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0003\u0010\u0090\u0006J\u001a\u0010\u009c\u0006\u001a\u00020\u000f2\t\u0010\u0080\u0003\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0003\u0010\u009d\u0006J\u001c\u0010\u009e\u0006\u001a\u0004\u0018\u00010\t2\t\u0010ç\u0003\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0003\u0010\u009f\u0006J\u0012\u0010 \u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0016J\u0012\u0010¡\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0016J \u0010¢\u0006\u001a\u00020&2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0007\u0010£\u0006\u001a\u00020)H\u0016J\t\u0010¤\u0006\u001a\u00020&H\u0016J\t\u0010¥\u0006\u001a\u00020&H\u0002J\u001c\u0010¦\u0006\u001a\u00020&2\u0007\u0010\u0089\u0003\u001a\u00020\u000f2\b\u0010§\u0006\u001a\u00030¨\u0006H\u0016J\u001c\u0010©\u0006\u001a\u00020&2\u0007\u0010\u0089\u0003\u001a\u00020\u000f2\b\u0010§\u0006\u001a\u00030¨\u0006H\u0016J\t\u0010ª\u0006\u001a\u00020&H\u0016J\u0012\u0010«\u0006\u001a\u00020&2\u0007\u0010³\u0005\u001a\u00020)H\u0016J\u0015\u0010¬\u0006\u001a\u0005\u0018\u00010»\u00042\u0007\u0010\u0089\u0003\u001a\u00020\u000fH\u0016J\u0013\u0010\u00ad\u0006\u001a\u00020&2\b\u0010®\u0006\u001a\u00030³\u0003H\u0016J\t\u0010¯\u0006\u001a\u00020&H\u0016J\t\u0010°\u0006\u001a\u00020&H\u0016J\t\u0010±\u0006\u001a\u00020)H\u0016J3\u0010²\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,2\u0007\u0010³\u0006\u001a\u00020\u000f2\u0016\u0010´\u0006\u001a\u0011\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0084\u0006H\u0002J\u0012\u0010µ\u0006\u001a\u00020&2\u0007\u0010ÿ\u0002\u001a\u00020,H\u0002J\u0019\u0010¸\u0006\u001a\u00020&2\u000e\u0010¹\u0006\u001a\t\u0012\u0005\u0012\u00030·\u00060+H\u0016J\f\u0010º\u0006\u001a\u0005\u0018\u00010»\u0006H\u0016J\u0012\u0010¼\u0006\u001a\u00020&2\u0007\u0010\u0099\u0005\u001a\u00020)H\u0016J \u0010½\u0006\u001a\u00020&2\u0015\u0010¾\u0006\u001a\u0010\u0012\u0005\u0012\u00030¿\u0006\u0012\u0004\u0012\u00020&0µ\u0005H\u0016J\t\u0010À\u0006\u001a\u00020)H\u0002J\t\u0010Á\u0006\u001a\u00020)H\u0002J\t\u0010Â\u0006\u001a\u00020)H\u0002J\t\u0010Ã\u0006\u001a\u00020)H\u0002J\t\u0010Ä\u0006\u001a\u00020)H\u0002J\t\u0010Æ\u0006\u001a\u00020)H\u0002J\u0012\u0010Ç\u0006\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\u0012\u0010È\u0006\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J!\u0010É\u0006\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000f2\r\u0010ì\u0003\u001a\b\u0012\u0004\u0012\u00020&0EH\u0002J\u0012\u0010Ê\u0006\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\t\u0010Ë\u0006\u001a\u00020)H\u0002J\t\u0010Ì\u0006\u001a\u00020&H\u0002J\t\u0010Í\u0006\u001a\u00020)H\u0002J\t\u0010Î\u0006\u001a\u00020&H\u0002J\t\u0010Ï\u0006\u001a\u00020&H\u0002J\u0012\u0010Ð\u0006\u001a\u00020&2\u0007\u0010Ñ\u0006\u001a\u00020)H\u0002J\u0012\u0010Ò\u0006\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\u0012\u0010Ó\u0006\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\u000b\u0010Ô\u0006\u001a\u0004\u0018\u00010,H\u0002J\u000b\u0010Õ\u0006\u001a\u0004\u0018\u00010,H\u0002J\t\u0010Ö\u0006\u001a\u00020)H\u0002J\t\u0010×\u0006\u001a\u00020&H\u0002J\u001b\u0010Ø\u0006\u001a\u00020&2\u0007\u0010\u008f\u0004\u001a\u00020\t2\u0007\u0010Ù\u0006\u001a\u00020\tH\u0002J\u0012\u0010Ú\u0006\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\u0012\u0010Û\u0006\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J$\u0010Ü\u0006\u001a\u00020\t2\u0007\u0010Ý\u0006\u001a\u00020\t2\u0007\u0010Þ\u0006\u001a\u00020\t2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\u001a\u0010ß\u0006\u001a\u0004\u0018\u00010\t2\u0007\u0010à\u0006\u001a\u00020\tH\u0002¢\u0006\u0003\u0010á\u0006J,\u0010â\u0006\u001a\u0004\u0018\u00010\t2\u0007\u0010à\u0006\u001a\u00020\t2\u0007\u0010ã\u0006\u001a\u00020\t2\u0007\u0010Ù\u0006\u001a\u00020\tH\u0002¢\u0006\u0003\u0010ä\u0006J\u0012\u0010å\u0006\u001a\u00020&2\u0007\u0010\u0095\u0004\u001a\u00020\u000fH\u0002J\t\u0010æ\u0006\u001a\u00020)H\u0002J\t\u0010é\u0006\u001a\u00020&H\u0016J\u0016\u0010ê\u0006\u001a\u00020)2\r\u0010ì\u0003\u001a\b\u0012\u0004\u0012\u00020)0EJ\t\u0010ë\u0006\u001a\u00020)H\u0016J\t\u0010ì\u0006\u001a\u00020\tH\u0016J\t\u0010í\u0006\u001a\u00020\tH\u0002J\t\u0010î\u0006\u001a\u00020&H\u0002J\t\u0010ï\u0006\u001a\u00020)H\u0002J\u0012\u0010ð\u0006\u001a\u00020&2\u0007\u0010°\u0003\u001a\u00020,H\u0002J\t\u0010ñ\u0006\u001a\u00020&H\u0017J\f\u0010ò\u0006\u001a\u0005\u0018\u00010ó\u0006H\u0016J\u0014\u0010ô\u0006\u001a\u00020)2\t\u0010\u0089\u0003\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001a\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001a\u001a\u0004\b7\u00108R\u000e\u0010;\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010D\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u001a\u001a\u0004\bH\u0010IR\u001b\u0010K\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u001a\u001a\u0004\bL\u00103R\u001b\u0010N\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u001a\u001a\u0004\bP\u0010QR\u001b\u0010S\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u001a\u001a\u0004\bT\u00103R\u001b\u0010V\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u001a\u001a\u0004\bW\u00103R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010_\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010i\u001a\u0004\u0018\u00010j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bm\u0010\u001a\u001a\u0004\bk\u0010lR\u001d\u0010n\u001a\u0004\u0018\u00010o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\u001a\u001a\u0004\bp\u0010qR\u001b\u0010s\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\u001a\u001a\u0004\bt\u00103R\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010x\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010{\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010|\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010}\u001a\b\u0012\u0004\u0012\u00020\u000f0~X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000RE\u0010\u0083\u0001\u001a8\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0^\u0012\u0004\u0012\u00020)0\u0084\u0001j\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0^\u0012\u0004\u0012\u00020)`\u0085\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0087\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u008d\u0001\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u008f\u00010\u008e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0090\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0091\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0092\u0001\u001a\t\u0012\u0004\u0012\u00020\u000f0\u0091\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0001\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R,\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0095\u00018BX\u0083\u0084\u0002¢\u0006\u0014\n\u0003\b\u009a\u0001\u0012\u0005\b\u0097\u0001\u0010\u0007\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R!\u0010\u009b\u0001\u001a\u00030\u009c\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\"\u0010¡\u0001\u001a\u0005\u0018\u00010¢\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¥\u0001\u0010\u001a\u001a\u0006\b£\u0001\u0010¤\u0001R\"\u0010¦\u0001\u001a\u0005\u0018\u00010§\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bª\u0001\u0010\u001a\u001a\u0006\b¨\u0001\u0010©\u0001R\"\u0010«\u0001\u001a\u0005\u0018\u00010¬\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¯\u0001\u0010\u001a\u001a\u0006\b\u00ad\u0001\u0010®\u0001R\"\u0010°\u0001\u001a\u0005\u0018\u00010±\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b´\u0001\u0010\u001a\u001a\u0006\b²\u0001\u0010³\u0001R\"\u0010µ\u0001\u001a\u0005\u0018\u00010¶\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¹\u0001\u0010\u001a\u001a\u0006\b·\u0001\u0010¸\u0001R\"\u0010º\u0001\u001a\u0005\u0018\u00010»\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¾\u0001\u0010\u001a\u001a\u0006\b¼\u0001\u0010½\u0001R\"\u0010¿\u0001\u001a\u0005\u0018\u00010À\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÃ\u0001\u0010\u001a\u001a\u0006\bÁ\u0001\u0010Â\u0001R\"\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÈ\u0001\u0010\u001a\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\"\u0010É\u0001\u001a\u0005\u0018\u00010Ê\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÍ\u0001\u0010\u001a\u001a\u0006\bË\u0001\u0010Ì\u0001R\"\u0010Î\u0001\u001a\u0005\u0018\u00010Ï\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÒ\u0001\u0010\u001a\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\"\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b×\u0001\u0010\u001a\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\"\u0010Ø\u0001\u001a\u0005\u0018\u00010Ù\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÜ\u0001\u0010\u001a\u001a\u0006\bÚ\u0001\u0010Û\u0001R\"\u0010Ý\u0001\u001a\u0005\u0018\u00010Þ\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bá\u0001\u0010\u001a\u001a\u0006\bß\u0001\u0010à\u0001R\"\u0010â\u0001\u001a\u0005\u0018\u00010ã\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bæ\u0001\u0010\u001a\u001a\u0006\bä\u0001\u0010å\u0001R \u0010ç\u0001\u001a\u00030è\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bë\u0001\u0010\u001a\u001a\u0006\bé\u0001\u0010ê\u0001R\"\u0010ì\u0001\u001a\u0005\u0018\u00010í\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bð\u0001\u0010\u001a\u001a\u0006\bî\u0001\u0010ï\u0001R\u0012\u0010ñ\u0001\u001a\u0005\u0018\u00010ò\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010ó\u0001\u001a\u0005\u0018\u00010ô\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b÷\u0001\u0010\u001a\u001a\u0006\bõ\u0001\u0010ö\u0001R\"\u0010ø\u0001\u001a\u0005\u0018\u00010ù\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bü\u0001\u0010\u001a\u001a\u0006\bú\u0001\u0010û\u0001R\"\u0010ý\u0001\u001a\u0005\u0018\u00010þ\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0081\u0002\u0010\u001a\u001a\u0006\bÿ\u0001\u0010\u0080\u0002R\"\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0086\u0002\u0010\u001a\u001a\u0006\b\u0084\u0002\u0010\u0085\u0002R\"\u0010\u0087\u0002\u001a\u0005\u0018\u00010\u0088\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u008b\u0002\u0010\u001a\u001a\u0006\b\u0089\u0002\u0010\u008a\u0002R\"\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008d\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0090\u0002\u0010\u001a\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002R\u001a\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u0092\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002R\"\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0096\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0099\u0002\u0010\u001a\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002R\u001a\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u009b\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002R\"\u0010\u009e\u0002\u001a\u0005\u0018\u00010\u009f\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¢\u0002\u0010\u001a\u001a\u0006\b \u0002\u0010¡\u0002R\"\u0010£\u0002\u001a\u0005\u0018\u00010¤\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b§\u0002\u0010\u001a\u001a\u0006\b¥\u0002\u0010¦\u0002R\"\u0010¨\u0002\u001a\u0005\u0018\u00010©\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¬\u0002\u0010\u001a\u001a\u0006\bª\u0002\u0010«\u0002R\"\u0010\u00ad\u0002\u001a\u0005\u0018\u00010®\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b±\u0002\u0010\u001a\u001a\u0006\b¯\u0002\u0010°\u0002R\"\u0010²\u0002\u001a\u0005\u0018\u00010³\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¶\u0002\u0010\u001a\u001a\u0006\b´\u0002\u0010µ\u0002R\"\u0010·\u0002\u001a\u0005\u0018\u00010¸\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b»\u0002\u0010\u001a\u001a\u0006\b¹\u0002\u0010º\u0002R\"\u0010¼\u0002\u001a\u0005\u0018\u00010½\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÀ\u0002\u0010\u001a\u001a\u0006\b¾\u0002\u0010¿\u0002R\"\u0010Á\u0002\u001a\u0005\u0018\u00010Â\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÅ\u0002\u0010\u001a\u001a\u0006\bÃ\u0002\u0010Ä\u0002R\"\u0010Æ\u0002\u001a\u0005\u0018\u00010Ç\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÊ\u0002\u0010\u001a\u001a\u0006\bÈ\u0002\u0010É\u0002R\"\u0010Ë\u0002\u001a\u0005\u0018\u00010Ì\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÏ\u0002\u0010\u001a\u001a\u0006\bÍ\u0002\u0010Î\u0002R\"\u0010Ð\u0002\u001a\u0005\u0018\u00010Ñ\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÔ\u0002\u0010\u001a\u001a\u0006\bÒ\u0002\u0010Ó\u0002R\"\u0010Õ\u0002\u001a\u0005\u0018\u00010Ö\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÙ\u0002\u0010\u001a\u001a\u0006\b×\u0002\u0010Ø\u0002R\"\u0010Ú\u0002\u001a\u0005\u0018\u00010Û\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÞ\u0002\u0010\u001a\u001a\u0006\bÜ\u0002\u0010Ý\u0002R\"\u0010ß\u0002\u001a\u0005\u0018\u00010à\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bã\u0002\u0010\u001a\u001a\u0006\bá\u0002\u0010â\u0002R\"\u0010ä\u0002\u001a\u0005\u0018\u00010å\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bè\u0002\u0010\u001a\u001a\u0006\bæ\u0002\u0010ç\u0002R\"\u0010é\u0002\u001a\u0005\u0018\u00010ê\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bí\u0002\u0010\u001a\u001a\u0006\bë\u0002\u0010ì\u0002R\u0012\u0010î\u0002\u001a\u0005\u0018\u00010ï\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ð\u0002\u001a\u0005\u0018\u00010ñ\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ò\u0002\u001a\u00030ó\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010ô\u0002\u001a\u00030õ\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ö\u0002R\"\u0010÷\u0002\u001a\u0005\u0018\u00010ø\u00028BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bû\u0002\u0010\u001a\u001a\u0006\bù\u0002\u0010ú\u0002R\u001c\u0010ü\u0002\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020)0ý\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0082\u0003\u001a\u00030\u0083\u0003X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0084\u0003R\u0013\u0010\u0085\u0003\u001a\u00030\u0086\u0003X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0087\u0003R\u0013\u0010\u008e\u0003\u001a\u00030\u008f\u0003X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0090\u0003R\u0013\u0010\u0091\u0003\u001a\u00030\u0092\u0003X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u0093\u0003R\u0018\u0010\u0094\u0003\u001a\u000b\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0095\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0096\u0003\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0097\u0003\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0098\u0003\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0099\u0003\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u009a\u0003\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u009d\u0003\u001a\u00030\u009e\u0003X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u009f\u0003R\u0010\u0010 \u0003\u001a\u00030¡\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010¢\u0003\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010£\u0003\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¤\u0003\u001a\u00030¥\u0003X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¦\u0003R\u0011\u0010´\u0003\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010µ\u0003\u001a\u00030¶\u0003X\u0082\u000e¢\u0006\u0005\n\u0003\u0010·\u0003R\"\u0010Ù\u0003\u001a\u0005\u0018\u00010Ú\u00038BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÝ\u0003\u0010\u001a\u001a\u0006\bÛ\u0003\u0010Ü\u0003R\u000f\u0010ï\u0003\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0084\u0004\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0E0\u0085\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010£\u0004\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\t0^0¤\u0004X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b¥\u0004\u0010¦\u0004R\u0017\u0010º\u0004\u001a\n\u0012\u0005\u0012\u00030»\u00040\u0091\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010Ø\u0004\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ó\u0005\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ô\u0005\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Û\u0005\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ü\u0005\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010ÿ\u0005\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0E0\u0085\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010¶\u0006\u001a\n\u0012\u0005\u0012\u00030·\u00060\u0085\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Å\u0006\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ç\u0006\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010è\u0006\u001a\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\t\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ò\u0006\u001a\u0005\u0018\u00010ó\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006÷\u0006"}, d2 = {"Lcom/larus/bmhome/chat/component/list/ChatListComponent;", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/ui/arch/component/external/api/receiver/CardReceiver;", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "TAG", "", "REFRESH_FLOW_TAG", "continuousTtsMessageIdObserver", "Lcom/obric/assistant/spi/audio/ContinuousTtsMessageIdObserver;", "CHANGE_TAG", "SCREEN_RECORD_TAG", "messageList", "Lcom/larus/bmhome/view/ChatMessageList;", "getMessageList", "()Lcom/larus/bmhome/view/ChatMessageList;", "messageList$delegate", "Lkotlin/Lazy;", "toppingPageInstanceId", "toppingPageScopeId", "getToppingPageScopeId", "()Ljava/lang/String;", "chatModeAbility", "Lcom/larus/bmhome/chat/mode/IChatModeAbility;", "suggestContentAlpha", "", "modeSlideProgressListener", "Lcom/larus/bmhome/chat/mode/IChatModeAbility$ModeSlideProgressListener;", "updateSuggestAlpha", "", "alpha", "hasStaleNewConversationWcbScene", "", "messages", "", "Lcom/larus/im/bean/message/Message;", "fastButtonLastShow", "cachedChatReadPositionBugfixConfig", "Lcom/larus/platform/model/chat/ChatReadPositionBugfixConfig;", "cachedEnableKeepScreenOnReply", "cachedEnableSearchLandingHighlight", "getCachedEnableSearchLandingHighlight", "()Z", "cachedEnableSearchLandingHighlight$delegate", "cachedSearchLandingHighlightDurationMs", "", "getCachedSearchLandingHighlightDurationMs", "()J", "cachedSearchLandingHighlightDurationMs$delegate", "isKeepScreenOnReplyEnabled", "scrollToBottomIntentUntilMs", "scrollToBottomIntentCorrectionCount", "scrollToBottomIntentConversationId", "scrollToBottomIntentLatestMsgId", "scrollToBottomPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "pendingUnreadFastClickDecisionDeferred", "needToppingScroll", "conversationIdCache", "initFastButtonTask", "Lkotlin/Function0;", "chatMessageReadTrace", "Lcom/larus/bmhome/chat/trace/IChatMessageReadTrace;", "getChatMessageReadTrace", "()Lcom/larus/bmhome/chat/trace/IChatMessageReadTrace;", "chatMessageReadTrace$delegate", "audioEnable", "getAudioEnable", "audioEnable$delegate", "cellCutType", "Lcom/larus/bmhome/chat/list/cell/text/TextCellCutType;", "getCellCutType", "()Lcom/larus/bmhome/chat/list/cell/text/TextCellCutType;", "cellCutType$delegate", "enableMessageHover", "getEnableMessageHover", "enableMessageHover$delegate", "fastButtonEnable", "getFastButtonEnable", "fastButtonEnable$delegate", "adapter", "Lcom/larus/bmhome/chat/adapter/MessageAdapter;", "headerAreaAdapter", "Lcom/larus/bmhome/chat/adapter/HeaderAreaAdapter;", "listCurrentPosition", "Lkotlin/Pair;", "listRestorePosition", "musicAuthResultHandler", "Lcom/larus/platform/api/IAiChatRequestMusicListAuthResultCallback;", "localLifeAuthResultHandler", "Lcom/larus/bmhome/auth/douyin/IAiChatDouyinAuthResultHandler;", "blankScreenMonitor", "Lcom/larus/bmhome/chat/component/list/ChatListBlankScreenMonitor;", "searchLandingHighlightExpireAt", "searchLandingHighlightDismissed", "searchLandingHighlightSessionId", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "chatListHostAbilityService", "Lcom/larus/platform/api/IChatListHostAbility;", "getChatListHostAbilityService", "()Lcom/larus/platform/api/IChatListHostAbility;", "chatListHostAbilityService$delegate", "enablePreloadChatList", "getEnablePreloadChatList", "enablePreloadChatList$delegate", "lastRefreshMessageListJob", "Lkotlinx/coroutines/Job;", "lastRefreshMessageListTraceId", "lastRefreshReachedDifferTerminal", "layoutCreated", "lastMessageList", "isStreamContentUpdate", "streamBreakStatusSyncedIds", "", "boundBreakTarget", "Lcom/larus/bmhome/chat/stop/BreakTarget;", "boundBreakScene", "breakButtonEventsBound", "inputStopMoaModeByRound", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "keepScreenOnReplyOwner", "isKeepScreenOnReplyAcquired", "hasAutoOpenVoiceCall", "firstTimeCheck", "logger", "Lcom/larus/utils/logger/FlowFormatLogger;", "needForceScrollToLatestMsg", "chatListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/bmhome/chat/event/OnChatChangedListener;", "answerFirstShownMsgIds", "Ljava/util/concurrent/CopyOnWriteArraySet;", "foldedStreamPipelineRefreshedMsgIds", "scrollToLatestAfterFoldRefresh", "swipingControl", "Lkotlin/Lazy;", "Lcom/larus/bmhome/view/utils/SwipingControlVm;", "getSwipingControl$annotations", "getSwipingControl", "()Lkotlin/Lazy;", "swipingControl$delegate", "viewModel", "Lcom/larus/bmhome/chat/component/list/ChatListComponentViewModel;", "getViewModel", "()Lcom/larus/bmhome/chat/component/list/ChatListComponentViewModel;", "viewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "getBinding", "()Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "binding$delegate", "chatFragmentAbility", "Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "chatFragmentAbility$delegate", "chatWcbAbility", "Lcom/larus/suggest/api/IChatWcbAbility;", "getChatWcbAbility", "()Lcom/larus/suggest/api/IChatWcbAbility;", "chatWcbAbility$delegate", "chatListPreloadAbility", "Lcom/larus/bmhome/chat/component/list/preload/IChatListPreloadAbility;", "getChatListPreloadAbility", "()Lcom/larus/bmhome/chat/component/list/preload/IChatListPreloadAbility;", "chatListPreloadAbility$delegate", "progressLoadingAbility", "Lcom/larus/bmhome/chat/component/loading/IProgressLoadingAbility;", "getProgressLoadingAbility", "()Lcom/larus/bmhome/chat/component/loading/IProgressLoadingAbility;", "progressLoadingAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "chatMessageAbility", "Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "getChatMessageAbility", "()Lcom/larus/bmhome/chat/component/IChatMessageAbility;", "chatMessageAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "obricCoreInputAbility", "Lcom/obric/assistant/ability/chat/input/IObricCoreInputAbility;", "getObricCoreInputAbility", "()Lcom/obric/assistant/ability/chat/input/IObricCoreInputAbility;", "obricCoreInputAbility$delegate", "chatShareBottomAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getChatShareBottomAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "chatShareBottomAbility$delegate", "chatTitleAbility", "Lcom/larus/chat/api/IChatTitleAbility;", "getChatTitleAbility", "()Lcom/larus/chat/api/IChatTitleAbility;", "chatTitleAbility$delegate", "chatTraceAbility", "Lcom/larus/bmhome/chat/component/trace/IChatTraceComponentAbility;", "getChatTraceAbility", "()Lcom/larus/bmhome/chat/component/trace/IChatTraceComponentAbility;", "chatTraceAbility$delegate", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "chatPageMetrics", "Lcom/larus/bmhome/chat/ChatPageMetrics;", "receiveServiceAbility", "Lcom/larus/bmhome/chat/component/receive/IChatReceiveServiceAbility;", "getReceiveServiceAbility", "()Lcom/larus/bmhome/chat/component/receive/IChatReceiveServiceAbility;", "receiveServiceAbility$delegate", "immerseAbility", "Lcom/larus/bmhome/chat/component/immerse/IImmerseComponentAbility;", "getImmerseAbility", "()Lcom/larus/bmhome/chat/component/immerse/IImmerseComponentAbility;", "immerseAbility$delegate", "creationAbility", "Lcom/larus/bmhome/chat/component/creation/ICreationComponentAbility;", "getCreationAbility", "()Lcom/larus/bmhome/chat/component/creation/ICreationComponentAbility;", "creationAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "referenceAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceAbility$delegate", "multimodalInputAbility", "Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "getMultimodalInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/multimodal/IMultimodalInputAbility;", "multimodalInputAbility$delegate", "bottomMenuAbility", "Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "getBottomMenuAbility", "()Lcom/larus/bmhome/chat/component/bottom/bottommenu/IBottomMenuAbility;", "douyinAuthService", "Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService;", "getDouyinAuthService", "()Lcom/larus/bmhome/auth/douyin/IAiChatOpenDouyinAuthService;", "douyinAuthService$delegate", "collectionAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectionAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "caseAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "getCaseAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "caseAbility$delegate", "playbackAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatPlaybackAbility;", "getPlaybackAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatPlaybackAbility;", "playbackAbility$delegate", "floatingButtonAbility", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "getFloatingButtonAbility", "()Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "floatingButtonAbility$delegate", "awemeFeedAbility", "Lcom/larus/bmhome/double_post/drag_panel/IChatAwemeFeedAbility;", "getAwemeFeedAbility", "()Lcom/larus/bmhome/double_post/drag_panel/IChatAwemeFeedAbility;", "awemeFeedAbility$delegate", "regenAnswerAbility", "Lcom/larus/bmhome/chat/component/regen/IRegenAnswerAbility;", "getRegenAnswerAbility", "()Lcom/larus/bmhome/chat/component/regen/IRegenAnswerAbility;", "regenAnswerAbility$delegate", "pushReminderAbility", "Lcom/larus/bmhome/chat/component/push/IPushReminderAbility;", "getPushReminderAbility", "()Lcom/larus/bmhome/chat/component/push/IPushReminderAbility;", "pushReminderAbility$delegate", "clickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "clickTalkAbility$delegate", "chatCameraAbility", "Lcom/larus/bmhome/camera/IChatCameraAbility;", "getChatCameraAbility", "()Lcom/larus/bmhome/camera/IChatCameraAbility;", "chatCameraAbility$delegate", "simultaneousTranslatorAbility", "Lcom/larus/bmhome/audio/ISimultaneousTranslatorAbility;", "getSimultaneousTranslatorAbility", "()Lcom/larus/bmhome/audio/ISimultaneousTranslatorAbility;", "simultaneousTranslatorAbility$delegate", "obricFloatChatPageStateCoreAbility", "Lcom/obric/assistant/ability/chat/page/IObricFloatChatPageStateCoreAbility;", "getObricFloatChatPageStateCoreAbility", "()Lcom/obric/assistant/ability/chat/page/IObricFloatChatPageStateCoreAbility;", "obricFloatChatPageStateCoreAbility$delegate", "chatHostConfigAbility", "Lcom/larus/bmhome/chat/component/host/IChatHostConfigAbility;", "getChatHostConfigAbility", "()Lcom/larus/bmhome/chat/component/host/IChatHostConfigAbility;", "chatHostConfigAbility$delegate", "topFloatButtonAbility", "Lcom/larus/bmhome/ability/IChatTopFloatingButtonAbility;", "getTopFloatButtonAbility", "()Lcom/larus/bmhome/ability/IChatTopFloatingButtonAbility;", "topFloatButtonAbility$delegate", "floatChatFoldCoreAbility", "Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "getFloatChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IFloatChatFoldCoreAbility;", "floatChatFoldCoreAbility$delegate", "aiFloatChatFoldCoreAbility", "Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "getAiFloatChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "aiFloatChatFoldCoreAbility$delegate", "aiChatMessageLogicAbility", "Lcom/larus/business/floatchat/api/ability/IAIChatMessageLogicAbility;", "getAiChatMessageLogicAbility", "()Lcom/larus/business/floatchat/api/ability/IAIChatMessageLogicAbility;", "aiChatMessageLogicAbility$delegate", "promptFilterAbility", "Lcom/larus/bmhome/ability/IPromptFilterAbility;", "getPromptFilterAbility", "()Lcom/larus/bmhome/ability/IPromptFilterAbility;", "promptFilterAbility$delegate", "flowFeedbackManager", "Lcom/larus/feedback/api/manager/BaseIMFeedbackManager;", "tickTask", "Lcom/larus/platform/api/ISdkTick$Task;", "playbackHelper", "Lcom/larus/bmhome/chat/component/playback/MessagePlaybackHelper;", "launchInfoObserver", "com/larus/bmhome/chat/component/list/ChatListComponent$launchInfoObserver$1", "Lcom/larus/bmhome/chat/component/list/ChatListComponent$launchInfoObserver$1;", "traceService", "Lcom/larus/platform/api/IFlowTraceService;", "getTraceService", "()Lcom/larus/platform/api/IFlowTraceService;", "traceService$delegate", "getCreditInfoMsgIdCache", "Landroid/util/LruCache;", "getCreditInfoWhenMsgChanged", "message", "scene", "Lcom/larus/commercecredit/api/CreditInfoScene;", "streamObserver", "com/larus/bmhome/chat/component/list/ChatListComponent$streamObserver$1", "Lcom/larus/bmhome/chat/component/list/ChatListComponent$streamObserver$1;", "offlineMessageSessionListener", "com/larus/bmhome/chat/component/list/ChatListComponent$offlineMessageSessionListener$1", "Lcom/larus/bmhome/chat/component/list/ChatListComponent$offlineMessageSessionListener$1;", "handleNotifyItemChanged", "messageId", "notifySuggest", "handleMessageExtWhenStreamEnd", "handleClearContextMessage", "handleExposeFakeMessage", "adapterObserver", "com/larus/bmhome/chat/component/list/ChatListComponent$adapterObserver$1", "Lcom/larus/bmhome/chat/component/list/ChatListComponent$adapterObserver$1;", "messageAddRemoveObserver", "com/larus/bmhome/chat/component/list/ChatListComponent$messageAddRemoveObserver$1", "Lcom/larus/bmhome/chat/component/list/ChatListComponent$messageAddRemoveObserver$1;", "locationLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "preCvsId", "gotServerLoading", "serverLoadingMsgId", "lastVisibleMsgId", "lastSentMsgId", "asrWaitReplyEnd", "processingMessageId", "changeListener", "com/larus/bmhome/chat/component/list/ChatListComponent$changeListener$1", "Lcom/larus/bmhome/chat/component/list/ChatListComponent$changeListener$1;", "touristModeMessageSyncModel", "Lcom/larus/bmhome/social/userchat/model/TouristModeMessageSyncModel;", "hasInitOnBoardingBigAvatar", "showingLoadingLottieToast", "ttsFailedStateObserver", "com/larus/bmhome/chat/component/list/ChatListComponent$ttsFailedStateObserver$1", "Lcom/larus/bmhome/chat/component/list/ChatListComponent$ttsFailedStateObserver$1;", "buildNotificationRequest", "Lcom/larus/platform/model/NotificationRequest;", DBDefinition.TASK_ID, "sendAsrReplayEnd", "onAttach", WidgetCostModule.TYPE_ON_CREATE, "getArgumentPushContentId", "tryTransformToState", "Lcom/larus/bmhome/chat/cell/BaseMessageCellState;", "msg", "onDislikeFeedbackResult", "data", "Landroid/os/Bundle;", "aiRecordingStatusJob", "aiRecordingStatusListener", "com/larus/bmhome/chat/component/list/ChatListComponent$aiRecordingStatusListener$1", "Lcom/larus/bmhome/chat/component/list/ChatListComponent$aiRecordingStatusListener$1;", "setupAiRecordingStatusObserver", "observePluginAuthMessage", "tryShowSaveChatHistoryDialog", "chatFragment", "Landroidx/fragment/app/Fragment;", "onViewCreated", "view", "Landroid/view/View;", "setupContinuousTtsMessageObserver", "handleContinuousTtsMessageIdChanged", "oldMessageId", "newMessageId", "refreshContinuousTtsMessageActionBar", "setupDolaTips", "setupMessageClickInterceptor", "preloadMsg", "isInputDialogShow", "initMusicAuthHandler", "initLocalLifeAuthHandler", "processAuthResult", "isRequestAuthSuccess", "isMessageIdFromQuery", "musicPlatform", "Lcom/larus/platform/model/music/ThirdPartyMusicPlatform;", "needReQueryOrReply", "observeMessageNeedAuth", "handlePushMessage", "observeStateChange", "handleLocationPermissionResult", "isGranted", "onResume", "onPause", "onStop", "lynxMarkdownAbility", "Lcom/larus/component/ability/LynxMarkdownAbility;", "getLynxMarkdownAbility", "()Lcom/larus/component/ability/LynxMarkdownAbility;", "lynxMarkdownAbility$delegate", "onFragmentViewDestroyed", LiveCommonConstants.REASON_ON_DEDTROY, "getChatFragment", "hostFragment", "updateForCommon", "getCurrentList", "notifyItemChanged", "contentType", "notifyLocalMessageIdItemChanged", "localMessageId", "notifyAllRelatedCell", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "getLastMessageList", "runAfterInitialMessageListReady", "action", "setSelfSendMsgExceptAsrTriggerNoLoading", "setUpReadMessageTrace", "latestLocFailureToastTime", "locationAndModify", "retryStrategy", "reportLocUpdateError", "tryRequestLocationAuthMessage", "getBotType", "()Ljava/lang/Integer;", "getBotIsOwner", "getConversion", "Lcom/larus/im/bean/conversation/Conversation;", "getConversationId", "getBot", "Lcom/larus/im/bean/bot/BotModel;", "getBotId", "getChatType", "registerStream", "conversationId", "updateItemOnDisplay", "unregisterStream", "setupFastButton", "()Lkotlin/Unit;", "scrollToLatestMessageCallBackList", "", "addScrollToLatestMessageCallBack", "callback", "scrollToMessage", "targetMsgId", "toastWhenFaled", "scrollToMessageAlignTop", "toastWhenFailed", "alignTop", "scrollToMessagePosition", "position", "scrollToPosition", "scrollToLatestMessage", "updateFastButton", "needShowFastScrollButton", "startScrollToBottomIntent", "source", "clearScrollToBottomIntent", "isScrollToBottomIntentCorrectionEnabled", "isScrollToBottomIntentActive", "tryCorrectPendingScrollToBottomBeforeDraw", "shouldShowFastButton", "scheduleScrollToBottomPreDrawCorrection", "requestScrollToBottomPreDrawFrame", "removeScrollToBottomPreDrawListener", "correctPendingScrollToBottomBeforeDraw", "getScrollToBottomCorrectionDistance", "msgList", "shouldStartEntryScrollToBottomIntent", "result", "messageListOnScrolledFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getMessageListOnScrolledFlow", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "getFloatChatCloseStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getChatMessageReadTraceInstance", "isAsrAnimationPlay", "initFlowFeedbackManagerIfNeeded", "releaseFlowFeedbackManager", "buildFlowFeedbackHost", "Lcom/larus/feedback/api/model/FlowFeedbackHost;", "buildFlowFeedbackListener", "Lcom/larus/feedback/api/listener/IFeedbackListener;", "findFlowFeedbackMessage", "delivery", "Lcom/larus/feedback/api/model/FlowFeedbackDelivery;", "showFlowFeedbackLikeHint", "feedbackScene", "isFlowFeedbackInputting", "setupRecycler", "isLastMessageSuggestPrompt", "isCurrentSectionLatestQueryVisible", "cacheMarkdownInfoList", "Lcom/larus/bmhome/chat/component/list/CacheMarkdownInfo;", "handleClearSection", "selectModifyMode", "Lcom/larus/bmhome/chat/adapter/MessageModifyMode;", "isLatestEditableMessageOrSameCollection", "setupClearSection", "getCurrentBotType", "botId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupAdapterEventHelper", "scrollPositionItemTopIme", "scrollToLatest", "force", "scrollToLatestOnNextLayout", "smooth", "performLayoutCompensationScroll", "deltaY", "isFollowingLatestMessage", "getImmerseBackColor", "isImmerseStyle", "setupTouristMode", "setupList", "(Ljava/lang/String;)Lkotlin/Unit;", "getOfflineMessageLocalId", "handleListUpdated", "checkMessageListVisible", "firstMessage", "autoScrollToAnchorView", "currentChatMessageReadTrace", "lastNewestMsgId", "isNewMessageCome", "handleOnBoardingTts", "scrollListToTargetPosition", "targetMsgLocalIndex", "targetMsgLocalId", "usePendingUnreadTarget", "shouldRunEntryPositioning", "lastMessage", "getUnreadEntryTargetMsgLocalIndex", "hasUnreadEntryTargetSource", "preparePendingUnreadTargetForEntry", "shouldPrepareFromUnreadEntry", "preparePendingUnreadTargetFromUnreadEntry", "shouldRestoreSavedPendingUnreadTargetOnEntry", "isReadonlyForwardDetail", "arguments", "isReadonlyForwardDetailContainer", "getPreviewCollectionId", "processSearchTargetPos", "visible", "shouldUseSearchLandingPrecisionScroll", "targetMessage", "handleMessageEventFlow", "it", "Lcom/larus/bmhome/social/page/datasource/event/ListUpdateEvent;", "handleColdLaunchMessageEventFlow", "updateInstructionVisibility", "isClearContextMsg", "isLastMsgIsClearContext", "getLocalIndex", "getPushLocalIndex", "isFromImagePreview", "getPushMessageIndex", "getLatestSenderMsgIndex", "getRedDotSenderMsgIndex", "getRedDotEntrySenderMsgIndex", "getRedDotEntryAnchorLocalIndex", "hasUnreadQueryTarget", "getUnreadQueryAnchorLocalIndex", "getUnreadQueryTargetMsgLocalIndex", "getUnreadSenderMsgIndex", "conversation", "readMessageIndex", "isConversationUnreadAnchorValid", "disableUnreadMiddleLoadIfNeeded", "isChatReadPositionBugfixEnabled", "getSearchKeyword", "getSearchLandingHighlightText", "getSearchLandingHighlightParams", "Lcom/larus/bmhome/ability/SearchLandingHighlightParams;", "isSearchLandingTarget", "markSearchLandingHighlightShown", "params", "markSearchLandingHighlightShownInternal", "clearSearchLandingHighlight", "getSearchLandingTargetMessageId", "createRecoverAction", "filterWcbMessages", "event", "tryScrollToTopping", "updateKeepScreenOnReply", "trigger", "Lcom/larus/bmhome/chat/component/list/ChatListComponent$KeepScreenOnReplyTrigger;", "releaseKeepScreenOnReply", "enabled", "supported", "replying", "messageCount", "(Lcom/larus/bmhome/chat/component/list/ChatListComponent$KeepScreenOnReplyTrigger;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "hasReplyInProgress", "isWaitingForReplyFirstPackage", "resolvePendingRoundTarget", "canTriggerReply", "shouldShowReplyLoading", "isKeepScreenOnReplySupported", "isReplyInProgress", "handleInputBreakStatus", "setLayoutCreated", "isCreated", "isNoContent", "handleAutoOpenVoiceCall", "doAutoOpenVoiceCall", "addChatListener", "listener", "removeChatListener", "addChatChangedListener", "removeChatChangedListener", "updateBottomPadding", GXTemplateKey.FLEXBOX_PADDING, "clipToPadding", "enable", "valueBeforeSet", "Lkotlin/Function1;", "onKeyboardShow", "isCurrentFragment", "setCancelModifyAreaClickable", "clickable", "updateInSets", "insets", "Landroidx/core/graphics/Insets;", "resetImeInsets", "handleStartRealtimeCall", "setupAdapter", "initHeaderAreaAdapterIfNeed", "getListPosInScreen", "", "updateDataWithLastRound", "onlyShowLastRoundChat", "refreshListWithCurrentData", "refreshListWithCurrentDataAndScrollToLatest", "resetFoldedStreamPipelineRefreshMarkers", "reloadCurrentConversationMessages", "refreshExistedMessage", "resetLoadingStatus", "observeConversationChanged", "observeBotIdOrDynamicImgChange", "observeBotIdOrStatusChange", "observeConversationIdOrIconImageChange", "observeSectionIdChange", "observeOfflineMessageChange", "observeConversationIdOrSectionIdChange", "observeConversationIdOrStatusChange", "enterWithRedDot", "redDotEntryAnchorCancelledConversationId", "isRedDotEntryAnchorCancelledByReplyInProgress", "cancelRedDotEntryAnchorIfReplyInProgress", "observeConversationIdOrRedDotChange", "getStreamListenerCvsId", "observeConversationIdOrTypeChange", "onActionBarShow", "lastCheckBotId", "checkOnBoardingWhenBotInfoReady", "checkOnBoardingTTS", "lastBotIdCheck", "getToCheckMessage", "startTTS", "setCheckOnBoardingWhenBotInfoReady", "value", "checkOnBoardingTTSByUpdate", DyPayConstant.KEY_SHOW_LOADING, "dismissLoading", "setupChatTTSTrace", "clearChatTTSTrace", "changeCvsObserver", "newConversationId", "createAndGoSubConversation", "forkType", "Lcom/larus/im/bean/conversation/ForkType;", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "conversationForkTaskParam", "requireBotActionCard", "Lcom/larus/bmhome/auth/OnboardingActionCardData$CardScene;", "getOnBoardingActionCardData", "Lcom/larus/bmhome/auth/OnboardingActionCardData;", "checkVideoAvailable", "regenerateWithCheck", "currentConversation", TeaEventTrack.ACTION_DRAMA_PRE, "clickFrom", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "isImmersive", "requestId", "chatKey", "regenInstruction", "mDestroyActionList", "appendToDestroyActionList", "replaceMsgOnModifySendAfterAck", "replaceText", "extras", "", "location", "replaceMessageForAuth", "isQuestionMessage", "updateMessageContent", "text", "deletePluginAuth", "hideMessage", "isLimited", "onReportMessage", "getReportID", "onDislikeMessage", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;)V", "onDeleteMessages", "traceInfo", "Lorg/json/JSONObject;", "deleteScene", "Lcom/larus/bmhome/chat/bean/ChatMsgDeleteScene;", "confirmOperation", "likeMessage", "resultCallback", "(Lcom/larus/im/bean/message/Message;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "cancelLikeMessage", "cancelDislikeMessage", "resolveFeedbackClickFrom", "(Ljava/lang/Integer;)Ljava/lang/String;", "getLastLikeOrDislikeMessageStatus", "(Ljava/lang/String;)Ljava/lang/Integer;", "collectMessage", "cancelCollectMessage", "updateQaCollectState", "collected", "mockLoadingByBotSay", "removeMockLoadingByBotSay", "updateLocalRecordMessage", "recordCardData", "Lcom/larus/bmhome/chat/bean/RecordCardData;", "updateRemoteRecordMessage", "scrollToRecordCard", "setTTsPlayEnable", "getFinishedCacheMarkdownInfo", "checkScrollLast", "bundle", "cancelCasePlayBack", "showAllCase", "checkCaseMessageHasMore", "checkIfNeedHandleDocBlock", "from", "ext", "checkIfNeedHandleCommerceCreditBlock", "mCollectedCards", "Lcom/larus/ui/arch/component/external/api/feature/ComponentCard;", "handleCards", "cardList", "getMessageListView", "Landroidx/recyclerview/widget/RecyclerView;", "setFollowBottomOnViewportShrinkEnabled", "onInterceptTouchEvent", "onTouch", "Landroid/view/MotionEvent;", "isNeedToUnreadTop", "shouldAnchorToRedDotEntryUnreadTop", "shouldAnchorToRedDotUnreadTop", "shouldAnchorToLegacyRedDotUnreadTop", "isPendingUnreadTargetEnabled", "pendingUnreadProgrammaticScrollActive", "hasPendingUnreadTarget", "startPendingUnreadProgrammaticScroll", "clearPendingUnreadProgrammaticScroll", "runPendingUnreadProgrammaticScroll", "scheduleClearPendingUnreadProgrammaticScrollIfIdle", "shouldSkipPendingUnreadRecordForProgrammaticScroll", "handleFastScrollButtonClick", "shouldDeferPendingUnreadFastClickDecision", "deferPendingUnreadFastClickDecision", "performFastScrollButtonClick", "emitClickBackBottomEvent", "goPendingUnread", "logPendingUnreadFastClickState", "logFastScrollClickChainState", "getLatestPendingUnreadMessage", "getPendingUnreadRecordTargetMessage", "shouldRecordPendingUnreadPosition", "recordPendingUnreadPosition", "recordPendingUnreadGroupPosition", "visibleBottom", "ensurePendingUnreadTargetForLatestIfNeeded", "clearPendingUnreadTargetIfConsumedByViewport", "normalizePendingUnreadGroupProgress", "rawProgress", "savedProgress", "getPendingUnreadGroupProgressFromViewport", "targetPosition", "(I)Ljava/lang/Integer;", "getPendingUnreadGroupProgressFromPosition", "visiblePosition", "(III)Ljava/lang/Integer;", "clearPendingUnreadTarget", "updateForPendingUnreadScroll", "shouldShowBackToLastViewedButton", "lastViewedRestoreInfo", "setLastReadRestore", "checkLayoutCreated", "isChatAwemeFeedImmerseMode", "getMessageListHeight", "getMessageListHeightChangeOffset", "setUpBackToLastViewedButton", "isLatestMsgFromCurrentSession", "updateCurrentSessionMessageIfNeeded", "clearCurrentMessageListData", "exposureManager", "Lcom/larus/bmhome/chat/exposure/ExposureManager;", "hasContainedMessage", "Companion", "KeepScreenOnReplyTrigger", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatListComponent extends BaseContentWidget implements u7, o1a.a, va8.p {
    public static final /* synthetic */ int W3 = 0;
    public long A;
    public String A3;
    public int B;
    public String B3;
    public String C;
    public final ChatListComponent$changeListener$1 C3;
    public String D;
    public final com.larus.bmhome.social.userchat.model.g0 D3;
    public h E;
    public final Lazy E2;
    public boolean E3;
    public boolean F;
    public final Lazy F2;
    public final ChatListComponent$ttsFailedStateObserver$1 F3;
    public boolean G;
    public boolean G1;
    public final Lazy G2;
    public Job G3;
    public String H;
    public String H0;
    public boolean H1;
    public final Lazy H2;
    public final b H3;
    public e3 I;
    public final Lazy I2;
    public final Lazy I3;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f300882J;
    public final Lazy J2;
    public long J3;
    public final Lazy K;
    public final Lazy K2;
    public final List<Function0<Unit>> K3;
    public final Lazy L;
    public boolean L0;
    public final f2a.d L1;
    public final Lazy L2;
    public final MutableSharedFlow<Pair<Boolean, Integer>> L3;
    public final Lazy M;
    public boolean M1;
    public final Lazy M2;
    public boolean M3;
    public final Lazy N;
    public final Lazy N2;
    public String N3;
    public MessageAdapter O;
    public com.larus.bmhome.chat.i1 O2;
    public String O3;
    public HeaderAreaAdapter P;
    public boolean P0;
    public final CopyOnWriteArrayList<te8.c> P1;
    public final Lazy P2;
    public boolean P3;
    public Pair<Integer, Integer> Q;
    public final CopyOnWriteArraySet<String> Q1;
    public final Lazy Q2;
    public final List<Function0<Unit>> Q3;
    public Pair<Integer, Integer> R;
    public final Lazy R2;
    public final List<m1a.b> R3;
    public ChatListComponent$initMusicAuthHandler$1 S;
    public final CopyOnWriteArraySet<String> S1;
    public final Lazy S2;
    public boolean S3;
    public q5 T;
    public boolean T1;
    public final Lazy T2;
    public boolean T3;
    public com.larus.bmhome.chat.component.list.c U;
    public final Lazy U2;
    public Pair<Long, Integer> U3;
    public long V;
    public List<Message> V0;
    public final Lazy V1;
    public final Lazy V2;
    public final com.larus.bmhome.chat.exposure.a V3;
    public boolean W;
    public final Lazy W2;
    public final long X;
    public final Lazy X2;
    public final Lazy Y;
    public final Lazy Y2;
    public final Lazy Z;
    public final Lazy Z2;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public final Lazy f300883a3;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f300884b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final com.larus.ui.arch.vm.internal.l f300885b2;

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public final Lazy f300886b3;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public final Lazy f300887c3;

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public final Lazy f300888d3;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public final Lazy f300889e3;

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public final Lazy f300890f3;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final Set<String> f300891g1;

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public final Lazy f300892g2;

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public final Lazy f300893g3;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public com.larus.bmhome.chat.stop.a f300894h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public final Lazy f300895h2;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public final Lazy f300896h3;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public final Lazy f300897i3;

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public final Lazy f300898j3;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Lazy f300899k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public String f300900k1;

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public final Lazy f300901k3;

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public final Lazy f300902l3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f300903m;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public p99.d f300904m3;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f300905n;

    /* JADX INFO: renamed from: n3, reason: collision with root package name */
    public com.larus.platform.api.r3.b f300906n3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f300907o;

    /* JADX INFO: renamed from: o3, reason: collision with root package name */
    public final MessagePlaybackHelper f300908o3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.larus.bmhome.chat.component.list.d f300909p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public Job f300910p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f300911p1;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public final Lazy f300912p2;

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public final ChatListComponent$launchInfoObserver$1 f300913p3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f300914q;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    public final Lazy f300915q3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f300916r;

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    public final LruCache<String, Boolean> f300917r3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.larus.bmhome.chat.mode.e f300918s;

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    public final ChatListComponent$streamObserver$1 f300919s3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f300920t;

    /* JADX INFO: renamed from: t3, reason: collision with root package name */
    public final f f300921t3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b2 f300922u;

    /* JADX INFO: renamed from: u3, reason: collision with root package name */
    public final ChatListComponent$adapterObserver$1 f300923u3;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f300924v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final LinkedHashMap<Pair<String, String>, Boolean> f300925v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final Lazy f300926v2;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    public final ChatListComponent$messageAddRemoveObserver$1 f300927v3;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.larus.platform.model.chat.k f300928w;

    /* JADX INFO: renamed from: w3, reason: collision with root package name */
    public ActivityResultLauncher<String> f300929w3;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f300930x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public final String f300931x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public final Lazy f300932x2;

    /* JADX INFO: renamed from: x3, reason: collision with root package name */
    public String f300933x3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f300934y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public boolean f300935y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    public final Lazy f300936y2;

    /* JADX INFO: renamed from: y3, reason: collision with root package name */
    public boolean f300937y3;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f300938z;

    /* JADX INFO: renamed from: z3, reason: collision with root package name */
    public String f300939z3;

    /* JADX INFO: loaded from: classes25.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/component/list/ChatListComponent$KeepScreenOnReplyTrigger;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RESUME", "PAUSE", "STOP", "VIEW_DESTROYED", "DESTROY", "LIST_UPDATED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum KeepScreenOnReplyTrigger extends Enum<KeepScreenOnReplyTrigger> {
        public static final KeepScreenOnReplyTrigger DESTROY = null;
        public static final KeepScreenOnReplyTrigger LIST_UPDATED = null;
        public static final KeepScreenOnReplyTrigger PAUSE = null;
        public static final KeepScreenOnReplyTrigger RESUME = null;
        public static final KeepScreenOnReplyTrigger STOP = null;
        public static final KeepScreenOnReplyTrigger VIEW_DESTROYED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KeepScreenOnReplyTrigger[] f300940a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f300941b = null;
        private final String value;

        public static EnumEntries<KeepScreenOnReplyTrigger> getEntries() {
            return f300941b;
        }

        static {
            KeepScreenOnReplyTrigger r100 = new KeepScreenOnReplyTrigger("RESUME", 0, "resume");
            RESUME = r100;
            KeepScreenOnReplyTrigger r101 = new KeepScreenOnReplyTrigger("PAUSE", 1, "pause");
            PAUSE = r101;
            KeepScreenOnReplyTrigger r102 = new KeepScreenOnReplyTrigger("STOP", 2, "stop");
            STOP = r102;
            KeepScreenOnReplyTrigger r103 = new KeepScreenOnReplyTrigger("VIEW_DESTROYED", 3, "viewDestroyed");
            VIEW_DESTROYED = r103;
            KeepScreenOnReplyTrigger r104 = new KeepScreenOnReplyTrigger("DESTROY", 4, MapMonitorConst.EVENT_DESTROY);
            DESTROY = r104;
            KeepScreenOnReplyTrigger r105 = new KeepScreenOnReplyTrigger("LIST_UPDATED", 5, "listUpdated");
            LIST_UPDATED = r105;
            KeepScreenOnReplyTrigger[] r110 = {r100, r101, r102, r103, r104, r105};
            f300940a = r110;
            f300941b = EnumEntriesKt.enumEntries(r110);
        }

        public static KeepScreenOnReplyTrigger[] values() {
            return (KeepScreenOnReplyTrigger[]) f300940a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static KeepScreenOnReplyTrigger valueOf(String r100) {
            return (KeepScreenOnReplyTrigger) r27.a.a(KeepScreenOnReplyTrigger.class, r100);
        }

        public KeepScreenOnReplyTrigger(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
        public static int a(boolean r100) {
            if (com.larus.platform.service.z2.f365865a.enableRenameRenewSection() == false) goto L7;
            if (r100 == false) goto L6;
            return R.string.larus_settings_clear_context_new;
        L6:
            return R.string.larus_settings_clear_context_failed_toast_new;
        L7:
            if (r100 == false) goto L9;
            return R.string.larus_context_cleared;
        L9:
            return R.string.larus_clear_context_failed;
        }
    }

    public static final class b implements p68.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatListComponent f300943a;

        @Override // p68.c
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "meetingId");
        }

        @Override // p68.c
        public final void c(int r100) {
        }

        @Override // p68.c
        public final void e(String r100) {
        }

        @Override // p68.c
        public final void f(byte[] r100) {
        }

        public b(ChatListComponent r100) {
            this.f300943a = r100;
        }

        @Override // p68.c
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "meetingId");
            final ChatListComponent r101 = this.f300943a;
            com.larus.utils.t0.c(new k5(r101));
        }

        @Override // p68.c
        public final void d(int r100, String r101) {
            final ChatListComponent r102 = this.f300943a;
            com.larus.utils.t0.c(new j5(r102));
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class c implements IIMCallback<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatListComponent f300944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Message f300945b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger.f375446a.i(this.f300944a.f300905n, "cancelCollectMessage onFailure = " + r100.getTips());
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            MessageAdapter r101 = this.f300944a.O;
            if (r101 == null) goto L9;
            String r102 = this.f300945b.getMessageId();
            if (r102 != null) goto L7;
            r102 = "";
        L7:
            r101.x7(r102, this.f300945b.getContentType());
            return;
        }

        public c(ChatListComponent r100, Message r101) {
            this.f300944a = r100;
            this.f300945b = r101;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class d implements IIMCallback<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatListComponent f300952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Message f300953b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger.f375446a.e(this.f300952a.f300905n, "collectMessage onFailure = " + r100.getTips());
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            MessageAdapter r101 = this.f300952a.O;
            if (r101 == null) goto L9;
            String r102 = this.f300953b.getMessageId();
            if (r102 != null) goto L7;
            r102 = "";
        L7:
            r101.x7(r102, this.f300953b.getContentType());
            return;
        }

        public d(ChatListComponent r100, Message r101) {
            this.f300952a = r100;
            this.f300953b = r101;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class e implements hq9.a3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Message f300954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatListComponent f300955b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f300956c;

        public e(Message r100, ChatListComponent r101, boolean r102) {
            this.f300954a = r100;
            this.f300955b = r101;
            this.f300956c = r102;
        }

        @Override // hq9.a3
        public final void a(LocationResult r100, Integer r101, GeoLocationInfo r110) {
            Intrinsics.checkNotNullParameter(r100, "code");
            PendingAppletActionCancellation r102 = PendingAppletActionCancellation.f309941a;
            Message r111 = this.f300954a;
            r102.getClass();
            if (PendingAppletActionCancellation.b(r111) == false) goto L7;
            FLogger.f375446a.i(ChatListComponentViewModel.LOCATION_TAG, "drop cancelled location result, messageId[" + this.f300954a.getMessageId() + ']');
            return;
        L7:
            if (r100 != LocationResult.SUCCESS) goto L15;
            FLogger.f375446a.i(this.f300955b.f300905n, "locationAndModify triggered success");
            LarusPageChatBinding r103 = this.f300955b.h4();
            if (r103 == null) goto L13;
            ChatMessageList r104 = r103.f311098n;
            if (r104 == null) goto L13;
            com.larus.bmhome.chat.api.b0.a.a(r104, false, 0, null, null, 0, 31);
        L13:
            this.f300955b.U5().replaceMessageForLocation(this.f300954a);
            return;
        L15:
            if (this.f300956c == false) goto L17;
            FLogger.f375446a.i(this.f300955b.f300905n, "locationAndModify fail code " + r100 + " retryStrategy true");
            this.f300955b.Y6(this.f300954a, false);
            return;
        L17:
            FLogger.f375446a.i(this.f300955b.f300905n, "locationAndModify fail code " + r100 + " retryStrategy false");
            long r105 = SystemClock.elapsedRealtime();
            ChatListComponent r106 = this.f300955b;
            if ((r105 - r106.J3) <= 5000) goto L20;
            t19.s r107 = t19.s.f544207a;
            Context r108 = r106.getContext();
            r107.getClass();
            t19.s.b(r108, R.string.larus_RetryGeolocationRequestFailed2, false);
            this.f300955b.J3 = SystemClock.elapsedRealtime();
        L20:
            ChatListComponent r109 = this.f300955b;
            Message r112 = this.f300954a;
            r109.getClass();
            NativeCmdServiceImpl r113 = com.larus.im.d.b();
            ArrayList r114 = new ArrayList();
            r114.add(new vc9.b(MusicAppletPage.KEY_MESSAGE_ID, r112.getMessageId()));
            wc9.e r115 = r109.R4();
            if (r115 == null) goto L25;
            Integer r116 = r115.f559207j;
            if (r116 == null) goto L25;
            r114.add(new vc9.b("conversation_type", String.valueOf(r116.intValue())));
        L25:
            r113.sendBizCmd(new vc9.a(r114, "report_loc_update_error"), new k6());
        }
    }

    public static final class f {
        public f() {
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class g implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatListComponent f300957a;

        public g(ChatListComponent r100) {
            this.f300957a = r100;
        }

        @Override // com.larus.bmhome.chat.component.cvs.y.a
        public final void c(wc9.e r110) {
            wc9.e r111 = r110;
            Intrinsics.checkNotNullParameter(r111, "new");
            com.larus.bmhome.chat.component.list.c r100 = this.f300957a.U;
            if (r100 != null) goto L5;
        L8:
            String r112 = r111.f559198a;
            final ChatListComponent r101 = this.f300957a;
            Function1 r102 = new g6(r101);
            int r103 = ChatListComponent.W3;
            long r104 = -1;
            if (r101.f1().B() == false) goto L11;
            long r105 = this.f300957a.Mg();
        L13:
            if (r105 == (-1)) goto L15;
        L24:
            List<Message> r106 = this.f300957a.getCurrentList();
            if (r106 != null) goto L27;
            r106 = CollectionsKt.emptyList();
        L27:
            this.f300957a.V3(r106, r112);
            if (r105 != (-1)) goto L49;
            if (this.f300957a.f1().y() == false) goto L33;
            r105 = this.f300957a.E5(r106);
            goto L49
        L33:
            if (this.f300957a.G7() == false) goto L41;
            ChatListComponent r107 = this.f300957a;
            if (r107.G7() == false) goto L47;
            long r108 = r107.f1().s();
            if (r108 != 0) goto L40;
            FLogger.f375446a.i(r107.f300905n, "load latest messages for red dot entry without a read position");
            goto L47
        L40:
            r105 = (r108 + 1) * 1000;
        L47:
            r105 = -1;
            goto L49
        L41:
            ChatListComponent r109 = this.f300957a;
            r109.getClass();
            if (com.larus.platform.service.z2.f365865a.G1() == true) goto L44;
            boolean r113 = r109.M3;
        L45:
            if (r113 == false) goto L47;
            this.f300957a.getClass();
            r105 = ChatListComponent.i5(r106);
            goto L49
        L44:
            r113 = r109.I7();
        L49:
            if (r105 != (-1)) goto L57;
            Bundle r114 = this.f300957a.f1().f468086b;
            boolean r115 = false;
            if (r114 == null) goto L53;
            r115 = r114.getBoolean("is_push_source", false);
        L53:
            if (r115 == false) goto L55;
            r104 = this.f300957a.z5();
        L55:
            r105 = r104;
        L57:
            if (com.larus.utils.o0.d(r112) == false) goto L59;
            this.f300957a.U5().setStartAnchor(Long.valueOf(r105));
        L60:
            r102.invoke(Long.valueOf(r105));
            return;
        L59:
            this.f300957a.U5().setStartAnchor(Long.valueOf(r105));
            goto L60
        L15:
            if (this.f300957a.o6() == false) goto L24;
            Bundle r116 = this.f300957a.f1().f468086b;
            if (r116 == null) goto L19;
            long r117 = r116.getLong("unread_query_read_message_index", -1);
        L21:
            if (r117 < 0) goto L23;
            r105 = (r117 + 1) * 1000;
            goto L24
        L23:
            r105 = -1;
            goto L24
        L19:
            r117 = -1;
            goto L21
        L11:
            r105 = -1;
            goto L13
        L5:
            if (r100.f301042e == true) goto L8;
            r100.f301042e = true;
            r100.f301043f = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime() - r100.f301046i, 0);
            goto L8
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class h implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatListComponent f300958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f300959b;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            ChatListComponent r100 = this.f300958a;
            int r101 = ChatListComponent.W3;
            if (r100.X6() == true) goto L6;
            this.f300958a.l7();
            return true;
        L6:
            ChatListComponent r102 = this.f300958a;
            String r103 = this.f300959b;
            ChatMessageList r104 = r102.o5();
            boolean r105 = false;
            if (r104 != null) goto L10;
        L29:
            if (r105 == true) goto L35;
            ChatListComponent r106 = this.f300958a;
            ChatMessageList r107 = r106.o5();
            if (r107 == null) goto L35;
            r107.postOnAnimation(new com.larus.bmhome.chat.component.list.g(r106, r107));
        L35:
            return !r105;
        L10:
            if (r102.X6() == false) goto L29;
            RecyclerView.LayoutManager r108 = r104.getLayoutManager();
            if ((r108 instanceof LinearLayoutManager) == false) goto L15;
            LinearLayoutManager r109 = (LinearLayoutManager) r108;
        L16:
            if (r109 != null) goto L18;
            int r110 = r104.B();
        L23:
            if (r110 <= 0) goto L29;
            r102.B++;
            FLogger.f375446a.i(r102.f300905n, "correct pending scroll to bottom before draw, source=" + r103 + " count=" + r102.B + " distance=" + r110);
            r104.scrollBy(0, r110);
            if (r102.B < 3) goto L28;
            r102.a4();
        L28:
            r105 = true;
            goto L29
        L18:
            View r111 = r109.findViewByPosition(0);
            if (r111 == null) goto L21;
            int r112 = r109.getDecoratedBottom(r111) - (r104.getHeight() - r104.getPaddingBottom());
        L22:
            r110 = Math.max(r112, Math.max(r104.B(), 0));
            goto L23
        L21:
            r112 = 0;
            goto L22
        L15:
            r109 = null;
            goto L16
        }

        public h(ChatListComponent r100, String r101) {
            this.f300958a = r100;
            this.f300959b = r101;
        }
    }

    public static final class i implements Function0<maa.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f300960a;

        public i(AttachReceiver r100) {
            this.f300960a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [maa.e, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final maa.e invoke() {
            AttachReceiver r100 = this.f300960a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(maa.e.class));
        }
    }

    public static final class j implements Function0<taa.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f300962a;

        public j(AttachReceiver r100) {
            this.f300962a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, taa.a] */
        @Override // kotlin.jvm.functions.Function0
        public final taa.a invoke() {
            AttachReceiver r100 = this.f300962a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(taa.a.class));
        }
    }

    public static final class k implements Function0<sd8.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f300963a;

        public k(AttachReceiver r100) {
            this.f300963a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [sd8.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final sd8.a invoke() {
            AttachReceiver r100 = this.f300963a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(sd8.a.class));
        }
    }

    public static final class l implements Function0<u29.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f300964a;

        public l(AttachReceiver r100) {
            this.f300964a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, u29.b] */
        @Override // kotlin.jvm.functions.Function0
        public final u29.b invoke() {
            AttachReceiver r100 = this.f300964a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(u29.b.class));
        }
    }

    public static final class m implements Function0<LifecycleOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f300966a;

        public m(ComponentFeature r100) {
            this.f300966a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            return this.f300966a;
        }
    }

    public static final class n implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f300968a;

        public n(ComponentFeature r100) {
            this.f300968a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return this.f300968a;
        }
    }

    public static final class o implements Function0<ViewModelProvider.Factory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f300969a = null;

        static {
            f300969a = new o();
        }

        public o() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.ChatListComponent$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes25.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$onViewCreated$1", f = "ChatListComponent.kt", i = {}, l = {1927}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $completionExtJson;
        int label;
        final /* synthetic */ ChatListComponent this$0;

        /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.ChatListComponent$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$onViewCreated$1$1", f = "ChatListComponent.kt", i = {0, 1, 1, 1, 2}, l = {1939, 1954, 1990}, m = "invokeSuspend", n = {"completionExt", "completionExt", "targetConversationId", MapMonitorConst.ATTEMPT, "completionExt"}, s = {"L$0", "L$0", "L$2", "I$2", "L$0"})
        public static final class C40451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $completionExtJson;
            int I$0;
            int I$1;
            int I$2;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ ChatListComponent this$0;

            public C40451(ChatListComponent r100, String r101, Continuation<? super C40451> r102) {
                this.this$0 = r100;
                this.$completionExtJson = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                C40451 r102 = new C40451(this.this$0, this.$completionExtJson, r101);
                r102.L$0 = r100;
                return r102;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C40451) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x0255 -> B:106:0x0257). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r210) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                long r102 = 200;
                String r103 = null;
                if (r101 == 0) goto L12;
                if (r101 == 1) goto L11;
                if (r101 == 2) goto L10;
                if (r101 != 3) goto L9;
                int r104 = this.I$1;
                int r110 = this.I$0;
                ChatListComponent r111 = (ChatListComponent) this.L$1;
                Map<? extends String, ? extends String> r112 = (Map) this.L$0;
                ResultKt.throwOnFailure(r210);
                long r105 = 200;
                ChatListComponent r113 = r111;
                Map<? extends String, ? extends String> r114 = r112;
                int r115 = r110;
                C40451 r116 = this;
            L106:
                r104 = r104 + 1;
                r102 = r105;
                r103 = null;
            L25:
                if (r104 >= r115) goto L107;
                Bundle r117 = s1a.a.c(r113).getArguments();
                if (r117 != null) goto L29;
            L31:
                boolean r106 = false;
            L32:
                if (r106 == false) goto L38;
                r116.L$0 = r114;
                r116.L$1 = r113;
                r116.I$0 = r115;
                r116.I$1 = r104;
                r116.label = 1;
                if (DelayKt.delay(r102, r116) != r100) goto L37;
                return r100;
            L37:
                r105 = r102;
                r114 = r114;
                goto L106
            L38:
                int r107 = ChatListComponent.W3;
                wc9.e r108 = r113.R4();
                if (r108 == null) goto L41;
                String r109 = r108.f559198a;
            L42:
                if (r109 != null) goto L44;
                final String r118 = "";
            L45:
                List<Message> r119 = r113.V0;
                if (r119 != null) goto L48;
                r119 = CollectionsKt.emptyList();
            L48:
                Iterator r120 = SequencesKt.filter(CollectionsKt.asSequence(r119), new j6(r118)).iterator();
                if (r120.hasNext() == true) goto L51;
                Object r121 = r103;
            L60:
                Message r122 = (Message) r121;
                if (r122 == null) goto L63;
                String r123 = r122.getMessageId();
            L64:
                if (r123 != null) goto L67;
                r123 = "";
            L67:
                if ((!StringsKt.isBlank(r123)) == true) goto L70;
                r123 = r103;
            L70:
                if (r123 == null) goto L76;
                RepoDispatcher.f307729a.getClass();
                ChatRepo r124 = RepoDispatcher.f307732d;
                r116.L$0 = r114;
                r116.L$1 = r113;
                r116.L$2 = r118;
                r116.I$0 = r115;
                r116.I$1 = r104;
                r116.I$2 = r104;
                r116.label = 2;
                Object r125 = r124.E1(r123, r116);
                if (r125 != r100) goto L74;
                return r100;
            L74:
                C40451 r126 = r116;
                int r127 = r104;
            L75:
                Message r128 = (Message) r125;
            L77:
                if (r128 == 0) goto L79;
                String r129 = r128.getConversationId();
            L81:
                if (Intrinsics.areEqual(r129, r118) == false) goto L98;
                Map<String, String> r130 = r128.getExt();
                if (r130 != null) goto L85;
                r130 = MapsKt.emptyMap();
            L85:
                Map<String, String> r131 = MapsKt.toMutableMap(r130);
                r131.putAll(r114);
                Iterator r132 = CollectionsKt.listOf(new String[]{"reply_mode", "agent_task_param", "need_deep_think", "force_enable_deepthink", "disable_deepthink", "model_item_key", "mode_id", "agent_mode", "reasoning_effort", "conversation_mode"}).iterator();
            L87:
                if (r132.hasNext() == false) goto L89;
                r131.remove((String) r132.next());
                goto L87
            L89:
                r131.put("conversation_fork_auto_route_reanswer", "1");
                IFlowMessageService r133 = (IFlowMessageService) ServiceManager.get().getService(IFlowMessageService.class);
                if (r133 == null) goto L96;
                String r134 = r128.getMessageId();
                if (r134 != null) goto L94;
                String r135 = "";
            L95:
                r133.d(r135, true, r131, "edit", (ChatPageContext) s1a.d.a(r113).a(ChatPageContext.class));
                goto L96
            L94:
                r135 = r134;
            L96:
                FLogger.f375446a.i(r113.f300905n, "auto-route fork reanswer requested, conversationId=" + r118 + ", messageId=" + r128.getMessageId());
                return Unit.INSTANCE;
            L98:
                if (r104 > 0) goto L100;
            L102:
                r126.L$0 = r114;
                r126.L$1 = r113;
                r126.L$2 = r103;
                r126.I$0 = r115;
                r126.I$1 = r127;
                r126.label = 3;
                r105 = 200;
                if (DelayKt.delay(200, r126) != r100) goto L105;
                return r100;
            L105:
                r104 = r127;
                r116 = r126;
                goto L106
            L100:
                if ((r104 % 5) != 0) goto L102;
                r113.cE();
                goto L102
            L79:
                r129 = r103;
                goto L81
            L76:
                r128 = r103;
                r126 = r116;
                r127 = r104;
                goto L77
            L63:
                r123 = r103;
                goto L64
            L51:
                r121 = r120.next();
                if (r120.hasNext() == false) goto L60;
                long r136 = ((Message) r121).getLocalIndex();
            L55:
                Object r137 = r120.next();
                long r211 = ((Message) r137).getLocalIndex();
                if (r136 >= r211) goto L59;
                r121 = r137;
                r136 = r211;
            L59:
                if (r120.hasNext() == true) goto L55;
            L44:
                r118 = r109;
                goto L45
            L41:
                r109 = r103;
                goto L42
            L29:
                if (r117.containsKey("reply_mode") != true) goto L31;
                r106 = true;
                goto L32
            L107:
                FLogger.f375446a.e(r116.this$0.f300905n, "auto-route fork reanswer failed: copied query unavailable");
                t19.s r138 = t19.s.f544207a;
                Context r139 = s1a.a.c(r116.this$0).requireContext();
                r138.getClass();
                t19.s.b(r139, R.string.larus_create_new_chat_failed, false);
                return Unit.INSTANCE;
            L9:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L10:
                r104 = this.I$2;
                r127 = this.I$1;
                r115 = this.I$0;
                r118 = (String) this.L$2;
                r113 = (ChatListComponent) this.L$1;
                r114 = (Map) this.L$0;
                ResultKt.throwOnFailure(r210);
                r125 = r210;
                r126 = this;
                goto L75
            L11:
                r104 = this.I$1;
                int r140 = this.I$0;
                ChatListComponent r141 = (ChatListComponent) this.L$1;
                Map<? extends String, ? extends String> r142 = (Map) this.L$0;
                ResultKt.throwOnFailure(r210);
                r113 = r141;
                r115 = r140;
                r116 = this;
                r105 = 200;
                r114 = r142;
                goto L106
            L12:
                ResultKt.throwOnFailure(r210);
                CoroutineScope r143 = (CoroutineScope) this.L$0;
                String r144 = this.$completionExtJson;
                Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L19
                JSONObject r146 = new JSONObject(r144);     // Catch: Throwable -> L19
                Sequence r147 = SequencesKt.asSequence(r146.keys());     // Catch: Throwable -> L19
                LinkedHashMap r148 = new LinkedHashMap();     // Catch: Throwable -> L19
                Iterator r149 = r147.iterator();     // Catch: Throwable -> L19
            L15:
                if (r149.hasNext() == false) goto L17;
                Object r150 = r149.next();     // Catch: Throwable -> L19
                r148.put(r150, r146.optString((String) r150));     // Catch: Throwable -> L19
                goto L15
            L17:
                Object r151 = Result.m9449constructorimpl(r148);     // Catch: Throwable -> L19
            L21:
                Map r152 = MapsKt.emptyMap();
                if (Result.m9455isFailureimpl(r151) == false) goto L24;
                r151 = r152;
            L24:
                r115 = 50;
                r114 = (Map) r151;
                r113 = this.this$0;
                r104 = 0;
                r116 = this;
            L19:
                th = move-exception;
                Result.Companion r153 = Result.Companion;
                r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));
                goto L21
            }
        }

        public AnonymousClass1(ChatListComponent r100, String r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$completionExtJson = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$completionExtJson, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Lifecycle r103 = s1a.a.c(this.this$0).getLifecycle();
            C40451 r104 = new C40451(this.this$0, this.$completionExtJson, null);
            this.label = 1;
            if (PausingDispatcherKt.whenResumed(r103, r104, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void Rc() {
        this.P3 = false;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final int[] dZ() {
        int[] r100 = new int[2];
        LarusPageChatBinding r101 = h4();
        if (r101 == null) goto L7;
        ChatMessageList r102 = r101.f311098n;
        if (r102 == null) goto L7;
        r102.getLocationOnScreen(r100);
    L7:
        return r100;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void z50() {
        this.T1 = true;
        C90();
    }

    public final ry8.b B4() {
        return (ry8.b) this.J2.getValue();
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void BN() {
        FLogger.f375446a.i(this.f300905n, "mockLoadingByBotSay");
        LarusPageChatBinding r100 = h4();
        if (r100 == null) goto L7;
        ChatMessageList r101 = r100.f311098n;
        if (r101 == null) goto L7;
        com.larus.bmhome.chat.api.b0.a.a(r101, false, 0, null, null, 0, 31);
    L7:
        MessageAdapter r102 = this.O;
        if (r102 == null) goto L56;
        Iterator r103 = ((ArrayList) r102.getCurrentList()).iterator();
    L11:
        if (r103.hasNext() == false) goto L49;
        Object r104 = r103.next();
        Message r105 = (Message) r104;
        boolean r106 = false;
        if (com.larus.bmhome.chat.bean.d.i0(r105) == false) goto L18;
        if (com.larus.bmhome.chat.bean.d.w(r105) == true) goto L18;
    L37:
        boolean r107 = false;
    L38:
        if (r107 == false) goto L47;
        if (com.larus.bmhome.social.userchat.model.b0.f(r105) == false) goto L46;
        Integer r108 = com.larus.bmhome.social.userchat.model.b0.c(r105);
        if (r108 == null) goto L47;
        if (r108.intValue() != 3) goto L47;
    L46:
        r106 = true;
    L47:
        if (r106 == false) goto L11;
    L50:
        final Message r109 = (Message) r104;
        if (r109 == null) goto L56;
        RepoDispatcher.f307729a.getClass();
        ChatRepo r110 = RepoDispatcher.f307732d;
        String r111 = r109.getLocalMessageId();
        if (r111 != null) goto L55;
        r111 = "";
    L55:
        r110.r1(r111, new r(r109));
    L18:
        if (com.larus.bmhome.chat.bean.d.T(r105) == true) goto L37;
        if (com.larus.bmhome.chat.bean.d.p0(r105) == true) goto L37;
        if (com.larus.bmhome.chat.bean.d.C0(r105) == true) goto L25;
    L27:
        MessageStatus r112 = r105.getMessageStatus();
        if (r112 != null) goto L30;
    L32:
        boolean r113 = false;
    L33:
        if (r113 == false) goto L35;
    L36:
        r107 = true;
        goto L38
    L35:
        if (com.larus.bmhome.social.userchat.model.b0.f(r105) == false) goto L37;
    L30:
        if (r112.isVisible() != true) goto L32;
        r113 = true;
        goto L33
    L25:
        if (r105.getRegenVisible() == true) goto L27;
    L49:
        r104 = null;
    L56:
        SafeExtKt.b(F2(), new s(this), 60000);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void G2() {
        MessageAdapter r100 = this.O;
        if (r100 == null) goto L15;
        List<xc8.b> r101 = r100.z2();
        if (r101 == null) goto L16;
        List<xc8.b> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r103.add(((xc8.b) r104.next()).getMessage());
        goto L8
    L10:
        ChatMessageList r105 = o5();
        if (r105 == null) goto L17;
        Lazy<IObricChatUIService> r106 = ChatMessageList.V0;
        r105.Z(r103, null, null, null, false);
        return;
    L17:
        return;
    L16:
        return;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final boolean Hl() {
        return W3(new x3(this));
    }

    public final boolean J7() {
        boolean r100 = com.larus.platform.exp.h.f365384a;
        if (r100 == false) goto L5;
    L7:
        String r101 = Q5();
        if (r101 != null) goto L10;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == false) goto L16;
        return false;
    L16:
        if (r100 == false) goto L21;
        if (((Boolean) this.f300934y.getValue()).booleanValue() == true) goto L21;
        return false;
    L21:
        if (I5().length() <= 0) goto L24;
        return true;
    L24:
        return false;
    L10:
        if (r101.length() == 0) goto L13;
        r102 = false;
        goto L14
    L5:
        if (com.larus.platform.service.z2.f365865a.B3() == true) goto L7;
        return false;
    }

    @Override // va8.p
    public final Fragment M() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return com.larus.ui.arch.component.internal.attach.a.b(this, this);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void Os() {
        this.S1.clear();
        this.T1 = false;
    }

    public final ICoreInputAbility T4() {
        return (ICoreInputAbility) this.F2.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ChatListComponentViewModel U5() {
        return (ChatListComponentViewModel) this.f300885b2.getValue();
    }

    public final IAiChatOpenDouyinAuthService V4() {
        return (IAiChatOpenDouyinAuthService) this.V2.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.larus.bmhome.chat.component.list.e1] */
    /* JADX WARN: Type inference failed for: r1v88, types: [com.larus.bmhome.chat.component.list.h1] */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.larus.bmhome.chat.component.list.i1] */
    public final void V5() {
        List<Message> r100 = this.V0;
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        int r101 = 20;
        List<Message> r102 = r100.subList(0, Math.min(r100.size(), 20));
        int r103 = ra9.a.f536860a;
        com.larus.bmhome.chat.stop.c r104 = new com.larus.bmhome.chat.stop.c(null);
        AtomicReference<ga9.a.C5998a> r105 = ga9.a.f480591a;
        ga9.e.f480599a.getClass();
        final com.larus.bmhome.chat.stop.c r110 = (com.larus.bmhome.chat.stop.c) ga9.e.a(ga9.a.c("mobile_input_stop_scene_config_v2", ga9.e.c(r104)), com.larus.bmhome.chat.stop.c.class, r104);
        if (r110.b() > 0) goto L8;
    L396:
        this.f300925v1.clear();
        this.f300894h1 = null;
        va8.o r106 = q4();
        if (r106 == null) goto L475;
        r106.D60(false);
        return;
    L475:
        return;
    L8:
        if (r110.a() == false) goto L396;
        final wc9.e r107 = R4();
        IFlowSdkDepend r108 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r108 == null) goto L13;
        r108.N();
        final com.larus.home.impl.sdk.n1 r109 = com.larus.home.impl.sdk.n1.f346205a;
    L14:
        ?? r111 = 1;
        if (r109 != null) goto L17;
    L19:
        final boolean r112 = false;
    L20:
        Object r113 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        com.larus.bmhome.instruction.c r114 = com.larus.bmhome.instruction.c.f311900a;
        String r115 = getBotId();
        String r116 = "";
        if (r115 != null) goto L23;
        r115 = "";
    L23:
        final boolean r117 = com.larus.bmhome.view.actionbar.custom.cache.e.i(r114.a(r115, ActiveSwitchType.DEEPTHINK.getValue()));
        final ?? r118 = new e1(this, r107, r112, r109, r117);
        Function1 r119 = new f1(r118, r110);
        Intrinsics.checkNotNullParameter(r119, "canStopTarget");
        if (r102 != null) goto L26;
        String r210 = "";
    L241:
        com.larus.bmhome.chat.stop.a r120 = null;
    L275:
        if (r120 != null) goto L365;
        List<Message> r121 = r102;
        if (r121 != null) goto L279;
    L282:
        boolean r122 = true;
    L283:
        if (r122 == true) goto L345;
        List<Message> r123 = r102;
        Iterator<T> r124 = r123.iterator();
    L287:
        if (r124.hasNext() == false) goto L291;
        Object r125 = r124.next();
        if (com.larus.bmhome.chat.bean.d.H0((Message) r125) == false) goto L287;
    L292:
        Message r126 = (Message) r125;
        if (r126 == null) goto L345;
        int r127 = r126.getMessageStatusLocal();
        if (r127 != 10) goto L298;
        boolean r128 = Q3(r126);
    L344:
        if (r128 == false) goto L345;
        ArrayList r129 = new ArrayList();
        Iterator<T> r130 = r123.iterator();
        boolean r131 = false;
    L348:
        if (r130.hasNext() == false) goto L358;
        Object r132 = r130.next();
        if (r131 == true) goto L351;
        if (((Message) r132) == r126) goto L355;
        boolean r133 = true;
    L356:
        if (r133 == true) goto L348;
        r129.add(r132);
        r131 = true;
        goto L348
    L355:
        r133 = false;
        goto L356
    L351:
        r129.add(r132);
        goto L348
    L358:
        ArrayList r134 = new ArrayList();
        Iterator r135 = r129.iterator();
    L360:
        if (r135.hasNext() == false) goto L364;
        Object r136 = r135.next();
        if (com.larus.bmhome.social.userchat.model.b0.f((Message) r136) == true) goto L360;
        r134.add(r136);
        goto L360
    L364:
        r120 = new com.larus.bmhome.chat.stop.a(r126, r126, r134);
        goto L365
    L298:
        if (r127 == 11) goto L301;
    L341:
        r128 = false;
        goto L344
    L301:
        if (Q3(r126) == true) goto L303;
    L307:
        boolean r137 = false;
    L308:
        if (r137 == false) goto L341;
        String r138 = r126.getMessageId();
        if (r138 != null) goto L313;
        String r139 = r210;
    L315:
        if (r139.length() != 0) goto L317;
        boolean r140 = true;
    L318:
        if (r140 == false) goto L320;
    L342:
        r128 = true;
        goto L344
    L320:
        if ((r123 instanceof Collection) == true) goto L322;
    L324:
        Iterator<T> r141 = r123.iterator();
    L326:
        if (r141.hasNext() == false) goto L338;
        Message r142 = (Message) r141.next();
        if (com.larus.bmhome.chat.bean.d.G0(r142) == true) goto L335;
        if (Intrinsics.areEqual(r142.getReplyId(), r139) == false) goto L335;
        if (r142.getMessageStatusLocal() == 24) goto L335;
        boolean r143 = true;
    L336:
        if (r143 == false) goto L326;
        boolean r144 = false;
    L339:
        if (r144 == false) goto L341;
    L335:
        r143 = false;
    L338:
        r144 = true;
        goto L339
    L322:
        if (r123.isEmpty() == false) goto L324;
    L317:
        r140 = false;
        goto L318
    L313:
        r139 = r138;
        goto L315
    L303:
        if (com.larus.bmhome.social.userchat.model.b0.i(r126) == false) goto L305;
    L306:
        r137 = true;
        goto L308
    L305:
        if (com.larus.bmhome.chat.bean.d.M(r126) == false) goto L307;
    L291:
        r125 = null;
    L345:
        r120 = null;
        goto L365
    L279:
        if (r121.isEmpty() == true) goto L282;
        r122 = false;
    L365:
        if (r120 != null) goto L370;
        this.f300925v1.clear();
        this.f300894h1 = null;
        va8.o r145 = q4();
        if (r145 == null) goto L472;
        r145.D60(false);
        return;
    L472:
        return;
    L370:
        String r146 = (String) r118.invoke(r120);
        if (r146 != null) goto L373;
    L375:
        boolean r147 = false;
    L376:
        if (r146 == null) goto L381;
        if (r147 == true) goto L381;
        if (r110.c(r146) == false) goto L381;
        boolean r148 = true;
    L382:
        if (r148 == true) goto L387;
        this.f300894h1 = null;
        va8.o r149 = q4();
        if (r149 == null) goto L473;
        r149.D60(false);
        return;
    L473:
        return;
    L387:
        this.f300894h1 = r120;
        this.f300900k1 = r146;
        ICoreInputAbility r150 = T4();
        if (this.f300911p1 == true) goto L391;
        if (r150 == 0) goto L391;
        r150.uU(new h1(this), new i1(this));
        boolean r151 = true;
        this.f300911p1 = true;
    L392:
        va8.o r152 = q4();
        if (r152 == null) goto L474;
        r152.D60(r151);
        return;
    L474:
        return;
    L391:
        r151 = true;
    L381:
        r148 = false;
        goto L382
    L373:
        if (com.larus.bmhome.chat.stop.b.a(r120, r146) == false) goto L375;
        r147 = true;
        goto L376
    L26:
        boolean[] r153 = new boolean[r102.size()];
        List<Message> r154 = r102;
        Iterator<Integer> r155 = CollectionsKt.getIndices(r154).iterator();
        boolean r156 = false;
    L28:
        if (r155.hasNext() == false) goto L32;
        int r157 = ((IntIterator) r155).nextInt();
        r153[r157] = r156;
        if (com.larus.bmhome.chat.bean.d.H0((Message) ListProtector.get(r102, r157)) == false) goto L28;
        r156 = true;
        goto L28
    L32:
        IntRange r158 = CollectionsKt.getIndices(r154);
        ArrayList r159 = new ArrayList();
        Iterator<Integer> r160 = r158.iterator();
    L34:
        if (r160.hasNext() == false) goto L239;
        int r161 = ((IntIterator) r160).nextInt();
        Message r162 = (Message) ListProtector.get(r102, r161);
        if (com.larus.bmhome.chat.bean.d.H0(r162) == false) goto L39;
    L55:
        Iterator<Integer> r211 = r160;
        String r212 = r116;
    L235:
        Pair r163 = null;
    L236:
        if (r163 == null) goto L238;
        r159.add(r163);
    L238:
        r160 = r211;
        r116 = r212;
        r101 = 20;
        r111 = 1;
        goto L34
    L39:
        if (com.larus.im.bean.message.a.y0(r162) == true) goto L55;
        if (com.larus.im.bean.message.a.x0(r162) == true) goto L55;
        Map<String, String> r164 = r162.getExt();
        if (r164 == null) goto L46;
        String r165 = r164.get("onboarding");
    L48:
        if (Intrinsics.areEqual(r165, "1") == true) goto L55;
        String r166 = r162.getLocalMessageId();
        if (r166 != null) goto L54;
        r166 = r116;
    L54:
        if (StringsKt.contains(r166, "-onBoarding", r111) == true) goto L55;
        if (r162.getMessageStatusLocal() != r101) goto L60;
    L64:
        r211 = r160;
        r212 = r116;
    L145:
        boolean r167 = true;
    L147:
        if (r167 == false) goto L235;
        String r168 = r162.getReplyId();
        if (r168 == null) goto L235;
        if ((!StringsKt.isBlank(r168)) == true) goto L155;
        r168 = null;
    L155:
        if (r168 == null) goto L235;
        List<Message> r169 = r102;
        Iterator r170 = CollectionsKt.drop(r169, r161).iterator();
    L159:
        if (r170.hasNext() == false) goto L170;
        Object r171 = r170.next();
        Message r172 = (Message) r171;
        if (Intrinsics.areEqual(r172.getMessageId(), r168) == true) goto L165;
        if (Intrinsics.areEqual(r172.getLocalMessageId(), r168) == true) goto L165;
    L167:
        boolean r173 = false;
    L168:
        if (r173 == false) goto L159;
    L171:
        Message r174 = (Message) r171;
        if (r174 == null) goto L235;
        List r175 = CollectionsKt.listOfNotNull(new String[]{r162.getMessageId(), r162.getLocalMessageId()});
        ArrayList r176 = new ArrayList();
        Iterator r177 = r175.iterator();
    L176:
        if (r177.hasNext() == false) goto L180;
        Object r178 = r177.next();
        if ((!StringsKt.isBlank((String) r178)) == false) goto L176;
        r176.add(r178);
        goto L176
    L180:
        Set r179 = CollectionsKt.toSet(r176);
        ArrayList r180 = new ArrayList();
        Iterator r181 = r169.iterator();
        int r182 = 0;
    L182:
        if (r181.hasNext() == false) goto L206;
        Object r183 = r181.next();
        int r184 = r182 + 1;
        if (r182 >= 0) goto L186;
        CollectionsKt.throwIndexOverflow();
    L186:
        Message r213 = (Message) r183;
        if (r182 != r161) goto L189;
    L201:
        Iterator r214 = r181;
    L202:
        boolean r185 = false;
    L203:
        if (r185 == false) goto L205;
        r180.add(r183);
    L205:
        r182 = r184;
        r181 = r214;
        goto L182
    L189:
        if (com.larus.im.bean.message.a.y0(r213) == false) goto L191;
    L192:
        String r186 = com.larus.im.bean.message.a.D(r213);
        if (r186 == null) goto L197;
        r214 = r181;
        if (r179.contains(r186) != true) goto L198;
        boolean r187 = true;
    L199:
        if (r187 == false) goto L202;
        r185 = true;
    L198:
        r187 = false;
        goto L199
    L197:
        r214 = r181;
        goto L198
    L191:
        if (com.larus.im.bean.message.a.x0(r213) == false) goto L201;
    L206:
        List r188 = CollectionsKt.plus(CollectionsKt.listOf(r162), r180);
        List r189 = CollectionsKt.drop(r169, r161 + 1);
        ArrayList r190 = new ArrayList();
        Iterator r191 = r189.iterator();
    L208:
        if (r191.hasNext() == false) goto L228;
        Object r192 = r191.next();
        Message r193 = (Message) r192;
        if (com.larus.im.bean.message.a.y0(r193) == false) goto L212;
    L215:
        String r194 = com.larus.im.bean.message.a.D(r193);
        if (r194 == null) goto L220;
        Set r195 = r179;
        if (r179.contains(r194) != true) goto L221;
        boolean r196 = true;
    L222:
        if (r196 == false) goto L224;
        boolean r197 = true;
    L225:
        if (r197 == true) goto L227;
        r190.add(r192);
    L227:
        r179 = r195;
    L224:
        r197 = false;
    L221:
        r196 = false;
        goto L222
    L220:
        r195 = r179;
        goto L221
    L212:
        if (com.larus.im.bean.message.a.x0(r193) == true) goto L215;
        r195 = r179;
        goto L224
    L228:
        List r198 = CollectionsKt.plus(r188, r190);
        ArrayList r199 = new ArrayList();
        Iterator r200 = r198.iterator();
    L230:
        if (r200.hasNext() == false) goto L234;
        Object r201 = r200.next();
        if (com.larus.bmhome.social.userchat.model.b0.f((Message) r201) == true) goto L230;
        r199.add(r201);
        goto L230
    L234:
        r163 = TuplesKt.to(Integer.valueOf(r161), new com.larus.bmhome.chat.stop.a(r162, r174, r199));
    L165:
        if (com.larus.bmhome.chat.bean.d.H0(r172) == false) goto L167;
        r173 = true;
        goto L168
    L170:
        r171 = null;
        goto L171
    L60:
        if (r162.getMessageStatusLocal() == 24) goto L64;
        if (com.larus.bmhome.chat.bean.d.Q0(r162) == true) goto L64;
        String[] r202 = new String[2];
        r202[0] = r162.getMessageId();
        r202[r111] = r162.getLocalMessageId();
        List r203 = CollectionsKt.listOfNotNull(r202);
        ArrayList r204 = new ArrayList();
        Iterator r205 = r203.iterator();
    L67:
        if (r205.hasNext() == false) goto L72;
        Object r206 = r205.next();
        if ((!StringsKt.isBlank((String) r206)) == false) goto L67;
        r204.add(r206);
        goto L67
    L72:
        Set r207 = CollectionsKt.toSet(r204);
        List<Message> r208 = r162.getSubList();
        if (r208 != null) goto L75;
        r208 = CollectionsKt.emptyList();
    L75:
        List r209 = CollectionsKt.filterNotNull(r208);
        List<List<Message>> r215 = r162.getSubListGroup();
        if (r215 != null) goto L78;
        r215 = CollectionsKt.emptyList();
    L78:
        List r216 = CollectionsKt.plus(r209, CollectionsKt.filterNotNull(CollectionsKt.flatten(r215)));
        ArrayList r1100 = new ArrayList();
        Iterator<T> r217 = r102.iterator();
        r211 = r160;
        int r218 = 0;
    L80:
        if (r217.hasNext() == false) goto L104;
        String r219 = r116;
        Object r1101 = r217.next();
        int r220 = r218 + 1;
        if (r218 >= 0) goto L84;
        CollectionsKt.throwIndexOverflow();
    L84:
        Message r221 = (Message) r1101;
        if (r218 != r161) goto L87;
    L99:
        Set r222 = r207;
    L100:
        boolean r223 = false;
    L101:
        if (r223 == false) goto L103;
        r1100.add(r1101);
    L103:
        r116 = r219;
        r218 = r220;
        r207 = r222;
        goto L80
    L87:
        if (com.larus.im.bean.message.a.y0(r221) == false) goto L89;
    L90:
        String r224 = com.larus.im.bean.message.a.D(r221);
        if (r224 == null) goto L95;
        r222 = r207;
        if (r207.contains(r224) != true) goto L96;
        boolean r225 = true;
    L97:
        if (r225 == false) goto L100;
        r223 = true;
    L96:
        r225 = false;
        goto L97
    L95:
        r222 = r207;
        goto L96
    L89:
        if (com.larus.im.bean.message.a.x0(r221) == false) goto L99;
    L104:
        r212 = r116;
        List r226 = CollectionsKt.plus(r216, r1100);
        if ((r226 instanceof Collection) == true) goto L107;
    L109:
        Iterator r227 = r226.iterator();
    L111:
        if (r227.hasNext() == false) goto L123;
        Message r228 = (Message) r227.next();
        if (r228.getMessageStatusLocal() != 20) goto L115;
    L120:
        boolean r229 = true;
    L121:
        if (r229 == false) goto L111;
        boolean r230 = true;
    L124:
        if (r230 == true) goto L145;
        Map<String, String> r231 = r162.getBusinessExt();
        if (r231 == null) goto L129;
        String r232 = r231.get("is_mock_receiving");
    L131:
        if (Intrinsics.areEqual(r232, "1") == false) goto L146;
        Message r233 = (Message) CollectionsKt.getOrNull(r102, r161 + 1);
        if (r233 == null) goto L135;
        String r234 = r233.getContent();
    L136:
        if (r234 != null) goto L138;
    L141:
        boolean r235 = true;
    L142:
        boolean r236 = !r235;
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.j(r162), "is_mock_sending") == false) goto L145;
        if (r236 == false) goto L146;
    L138:
        if (r234.length() == 0) goto L141;
        r235 = false;
        goto L142
    L135:
        r234 = null;
    L146:
        r167 = false;
        goto L147
    L129:
        r232 = null;
        goto L131
    L115:
        if (r228.getMessageStatusLocal() == 24) goto L120;
        if (com.larus.im.bean.message.a.w0(r228) == true) goto L120;
        r229 = false;
    L123:
        r230 = false;
        goto L124
    L107:
        if (r226.isEmpty() == false) goto L109;
    L46:
        r165 = null;
        goto L48
    L239:
        r210 = r116;
        if (r159.isEmpty() == true) goto L241;
        ArrayList r237 = new ArrayList();
        Iterator r238 = r159.iterator();
    L244:
        if (r238.hasNext() == false) goto L249;
        Object r239 = r238.next();
        if (r153[((Number) ((Pair) r239).component1()).intValue()] == false) goto L244;
        r237.add(r239);
        goto L244
    L249:
        if (r237.isEmpty() == false) goto L251;
        r120 = (com.larus.bmhome.chat.stop.a) ((Pair) CollectionsKt.first(r159)).getSecond();
        goto L275
    L251:
        Iterator r240 = r237.iterator();
    L253:
        if (r240.hasNext() == false) goto L257;
        Object r241 = r240.next();
        if (((Boolean) r119.invoke((com.larus.bmhome.chat.stop.a) ((Pair) r241).component2())).booleanValue() == false) goto L253;
    L258:
        Pair r242 = (Pair) r241;
        if (r242 == null) goto L264;
        com.larus.bmhome.chat.stop.a r243 = (com.larus.bmhome.chat.stop.a) r242.getSecond();
        if (r243 == null) goto L264;
        r120 = r243;
    L264:
        Iterator r244 = r159.iterator();
    L266:
        if (r244.hasNext() == false) goto L270;
        Object r245 = r244.next();
        if (((Boolean) r119.invoke((com.larus.bmhome.chat.stop.a) ((Pair) r245).component2())).booleanValue() == false) goto L266;
    L271:
        Pair r246 = (Pair) r245;
        if (r246 == null) goto L274;
        r120 = (com.larus.bmhome.chat.stop.a) r246.getSecond();
        goto L275
    L274:
        r120 = (com.larus.bmhome.chat.stop.a) ((Pair) CollectionsKt.first(r237)).getSecond();
        goto L275
    L270:
        r245 = null;
        goto L271
    L257:
        r241 = null;
        goto L258
    L17:
        if (r109.w() != true) goto L19;
        r112 = true;
        goto L20
    L13:
        r109 = null;
        goto L14
    }

    public final boolean W4() {
        return ((Boolean) this.f300899k0.getValue()).booleanValue();
    }

    public final void X5() {
        AudioServiceDelegate r100 = AudioServiceDelegate.f288288a;
        if (r100.getAudioConfig().m() == true) goto L5;
    L7:
        boolean r110 = false;
    L8:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r101 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        wc9.e r102 = R4();
        if (r102 == null) goto L11;
        String r103 = r102.f559198a;
    L12:
        wc9.e r104 = R4();
        if (r104 == null) goto L15;
        String r410 = r104.I;
    L16:
        wc9.e r105 = R4();
        if (r105 == null) goto L19;
        String r106 = r105.B;
    L20:
        wc9.e r107 = R4();
        if (r107 == null) goto L23;
        Long r108 = r107.f559214q;
    L24:
        BotModel r109 = j0();
        RecommendFrom r111 = f1().f468088d;
        ChatControlTrace r112 = ChatControlTrace.f309996b;
        wc9.e r113 = R4();
        if (r113 == null) goto L27;
        Integer r114 = r113.f559219v;
    L28:
        String r115 = r112.g(r114, j4(), i4());
        SearchMobParam r116 = f1().f468089e;
        Intrinsics.checkNotNullParameter(this, "<this>");
        ActivityResultCaller r117 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r117 instanceof by7.e) == false) goto L31;
        by7.e r118 = (by7.e) r117;
    L32:
        VoiceCallServiceDelegate.f377087a.t(new b3a.c(r101, r103, r106, r108, r109, r111, r115, "chat", "click_chat_icon", null, r110, r116, null, r118, f1().e(), f1().d(), 0, null, null, null, null, null, null, null, null, null, null, ChatControlTrace.L, ChatControlTrace.M, ChatControlTrace.P, null, null, null, null, null, r410, -939585024, 63), false);
        return;
    L31:
        r118 = null;
        goto L32
    L27:
        r114 = null;
        goto L28
    L23:
        r108 = null;
        goto L24
    L19:
        r106 = null;
        goto L20
    L15:
        r410 = null;
        goto L16
    L11:
        r103 = null;
        goto L12
    L5:
        if (r100.getAudioConfig().D(true) == true) goto L7;
        r110 = true;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void cE() {
        FLogger.f375446a.i(this.f300905n, "reloadCurrentConversationMessages");
        MessageAdapter r100 = this.O;
        if (r100 == null) goto L5;
        r100.f297041z = false;
    L5:
        if (r100 == null) goto L9;
        MutableLiveData<Boolean> r101 = r100.f297040y;
        if (r101 == null) goto L9;
        r101.setValue(Boolean.FALSE);
    L9:
        ChatListComponentViewModel r102 = U5();
        Function0<wc9.e> r103 = new b0(this);
        Function0<BotModel> r104 = new c0(this);
        boolean r105 = pl();
        com.larus.bmhome.chat.component.collection.o r106 = F4();
        if (r106 == null) goto L12;
        MessageCollection r107 = r106.lA();
    L13:
        com.larus.bmhome.chat.component.showcase.x r108 = l4();
        if (r108 == null) goto L16;
        Case r109 = r108.mz(true);
    L17:
        r102.updateChatMessageReceiverModel(r103, r104, r105, r107, r109, com.larus.utils.o0.d(f1().i()), f1().B());
        return;
    L16:
        r109 = null;
        goto L17
    L12:
        r107 = null;
        goto L13
    }

    public final ld8.n d5() {
        return (ld8.n) this.Y2.getValue();
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void dismissLoading() {
        com.larus.common_ui.dialog.l0 r100 = (com.larus.common_ui.dialog.l0) this.Y.getValue();
        if (r100 == null) goto L21;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r102 == null) goto L18;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L7:
        if (Looper.myLooper() == r101.getLooper()) goto L9;
        r101.post(DialogLancet.createDismissRunnable(r100));
        return;
    }

    public final de8.c f1() {
        return (de8.c) this.M2.getValue();
    }

    /* JADX WARN: Type inference failed for: r10v4, types: [com.larus.bmhome.chat.component.list.x0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v12, types: [com.larus.bmhome.chat.component.list.w0, java.lang.Object] */
    public final void f7() {
        b7("perform_start");
        ChatMessageList r100 = o5();
        if (r100 == null) goto L5;
        int r101 = r100.getChildCount();
    L6:
        if (r101 > 0) goto L9;
        b7("perform_drop_child_empty");
        return;
    L9:
        ChatMessageList r102 = o5();
        if (r102 == null) goto L13;
        r102.setShowTopButton(false);
    L13:
        if (wi8.d.a().c() == true) goto L16;
    L143:
        final ChatListComponent r103 = this;
        boolean r110 = false;
    L173:
        r103.b7("perform_after_pending_unread goPendingUnread=" + r110);
        if (r110 == true) goto L176;
        r103.N7("unknown");
        r103.b7("perform_scroll_to_bottom_before");
        z7();
        r103.w7("click_back_bottom");
    L177:
        com.larus.bmhome.chat.component.immerse.a r104 = (com.larus.bmhome.chat.component.immerse.a) r103.Q2.getValue();
        if (r104 == null) goto L180;
        r104.t60();
    L180:
        ChatMessageList r105 = o5();
        if (r105 == null) goto L183;
        r105.post(new t0(r103));
    L183:
        by7.a r106 = new by7.a("click_back_bottom");
        TrackParams r107 = new TrackParams();
        JSONObject r108 = new JSONObject();
        r108.put("current_page", "chat");
        BotModel r109 = j0();
        if (r109 == null) goto L186;
        String r111 = r109.getBotId();
    L187:
        r108.put("bot_id", r111);
        wc9.e r112 = R4();
        if (r112 == null) goto L190;
        String r113 = ic8.n.f(r112);
    L191:
        r108.put("chat_type", r113);
        if (r110 == false) goto L194;
        String r114 = "to_unread";
    L195:
        r108.put("action_step", r114);
        Unit r115 = Unit.INSTANCE;
        r106.f21463a.merge(r107.merge(r108));
        r106.b();
        r103.b7("perform_end goPendingUnread=" + r110);
        return;
    L194:
        r114 = "to_bottom";
        goto L195
    L190:
        r113 = null;
        goto L191
    L186:
        r111 = null;
        goto L187
    L176:
        r103.b7("perform_scroll_to_pending_unread");
        goto L177
    L16:
        if (F6() == true) goto L18;
    L20:
        boolean r116 = false;
    L21:
        if (r116 == false) goto L23;
    L25:
        final ChatMessageList r117 = o5();
        if (r117 == null) goto L143;
        RecyclerView.LayoutManager r118 = r117.getLayoutManager();
        if ((r118 instanceof LinearLayoutManager) == false) goto L31;
        LinearLayoutManager r119 = (LinearLayoutManager) r118;
    L32:
        if (r119 == null) goto L143;
        if (r117.getScrollState() == 0) goto L37;
        r117.stopScroll();
    L37:
        String r120 = G4();
        c4("click_down_arrow");
        if (F6() == false) goto L40;
        g7();
    L40:
        com.larus.bmhome.chat.manager.d0 r121 = com.larus.bmhome.chat.manager.e0.a(r120);
        MessageAdapter r122 = this.O;
        int r123 = -1;
        if (r122 == null) goto L55;
        Iterator r124 = ((ArrayList) r122.getCurrentList()).iterator();
        int r125 = 0;
    L44:
        if (r124.hasNext() == false) goto L55;
        String r126 = ((Message) r124.next()).getLocalMessageId();
        if (r121 == null) goto L50;
        Message r127 = r121.f306711a;
        if (r127 == null) goto L50;
        String r128 = r127.getLocalMessageId();
    L52:
        if (Intrinsics.areEqual(r126, r128) == true) goto L53;
        r125 = r125 + 1;
        goto L44
    L53:
        final int r129 = r125;
    L57:
        if (r129 >= 0) goto L59;
        FLogger.f375446a.i("pending-unread-scroll-click", "pos < 0, Abort.");
        goto L143
    L59:
        View r130 = r119.getChildAt(0);
        if (r130 == null) goto L143;
        int r131 = r119.getPosition(r130);
        Rect r132 = new Rect();
        r130.getLocalVisibleRect(r132);
        int r133 = r132.bottom;
        int r134 = k70();
        if (F6() == false) goto L82;
        int r135 = r117.G(r129);
        int r136 = r117.F(r129);
        if (r131 >= r136) goto L67;
        FLogger.f375446a.i("pending-unread-scroll-click", "pending unread group has been passed, scroll to latest: currentPos=" + r131 + " bottomPos=" + r136);
        Z3("click_passed_group");
        goto L143
    L67:
        if (r135 <= 0) goto L92;
        int r137 = r117.H(r129, r131, r133);
        if (r121 == null) goto L71;
        int r138 = r121.f306712b;
    L72:
        int r139 = d7(r137, r138, "click_down_arrow");
        if (r117.M(r129, r139, r134) == false) goto L75;
        FLogger.f375446a.i("pending-unread-scroll-click", "pending unread group has been read, scroll to latest: currentProgress=" + r139 + " groupHeight=" + r135);
        Z3("click_group_read");
        goto L143
    L75:
        if (r121 == null) goto L77;
        int r140 = r121.f306712b;
    L78:
        if (r140 > 0) goto L92;
        if (r135 > r134) goto L92;
        FLogger.f375446a.i("pending-unread-scroll-click", "pending unread group height <= messageList height, scroll to latest: groupHeight=" + r135 + " messageListHeight=" + r134);
        Z3("click_group_in_one_screen");
        goto L143
    L77:
        r140 = 0;
        goto L78
    L71:
        r138 = 0;
    L92:
        if (r129 <= r131) goto L94;
        FLogger.f375446a.i("pending-unread-scroll-click", "pos > lastItemPos, Abort.");
        goto L143
    L94:
        if (r121 == null) goto L96;
        final int r141 = r121.f306712b;
    L97:
        FLogger r142 = FLogger.f375446a;
        r142.i("pending-unread-scroll-click", "msgProgress = " + r141 + ", messageList height = " + r134);
        if (F6() == false) goto L112;
        if (r135 > 0) goto L112;
        if (r141 > 0) goto L112;
        r142.i("pending-unread-scroll-click", "resolve unknown pending unread group height before first scroll: pos=" + r129 + " messageListHeight=" + r134);
        ?? r143 = new w0(this);
        ?? r144 = new x0(r129, this, r117);
        Intrinsics.checkNotNullParameter(r143, "onGroupWithinOneScreen");
        Intrinsics.checkNotNullParameter(r144, "onNeedScrollToPendingUnread");
        if (r117.getScrollState() == 0) goto L104;
        r117.stopScroll();
    L104:
        RecyclerView.LayoutManager r145 = r117.getLayoutManager();
        if ((r145 instanceof ChatMessageList.ChatLayoutManager) == false) goto L107;
        ChatMessageList.ChatLayoutManager r146 = (ChatMessageList.ChatLayoutManager) r145;
    L108:
        if (r146 != null) goto L110;
        r144.invoke();
    L124:
        r103 = this;
        r110 = true;
        goto L173
    L110:
        r146.scrollToPositionWithOffset(0, 0);
        r117.getViewTreeObserver().addOnPreDrawListener(new com.larus.bmhome.view.y0(r117, r129, r134, r143, r144));
        goto L124
    L107:
        r146 = null;
    L112:
        if (F6() == false) goto L126;
        if (r135 > 0) goto L115;
    L117:
        if (r141 <= 0) goto L126;
        if (r117.N(r131, r133, r129, r141, r134) == true) goto L121;
        r142.i("pending-unread-scroll-click", "group distance < messageList height, scroll to latest: posA=" + r131 + " posB=" + r129 + " progress=" + r141 + " distance=" + r134);
        Z3("click_distance_less_than_screen");
        goto L143
    L121:
        if (r141 > r134) goto L123;
        r142.i("pending-unread-scroll-click", "saved pending unread progress within first screen, scroll target top: pos=" + r129 + " progress=" + r141 + " messageListHeight=" + r134);
        v7("click_saved_pending_unread_first_screen", new y0(r117, r129));
        goto L124
    L123:
        r142.i("pending-unread-scroll-click", "scroll to saved pending unread progress: pos=" + r129 + " progress=" + r141);
        v7("click_saved_pending_unread_progress", new z0(r117, r129, r141));
        goto L124
    L115:
        if (r117.M(r129, r141, r134) == false) goto L117;
        r142.i("pending-unread-scroll-click", "saved pending unread progress has been read, scroll to latest: msgProgress=" + r141 + " groupHeight=" + r135 + " messageListHeight=" + r134);
        Z3("click_saved_group_read");
    L126:
        if (F6() == true) goto L154;
        if (r141 < r134) goto L154;
        MessageHeightCache r147 = MessageHeightCache.INSTANCE;
        MessageAdapter r148 = this.O;
        if (r148 == null) goto L134;
        Message r149 = (Message) CollectionsKt.getOrNull(r148.getCurrentList(), r129);
        if (r149 == null) goto L134;
        String r150 = r149.getMessageId();
        if (r150 == null) goto L134;
    L135:
        Integer r151 = (Integer) r147.get(r150);
        if (r151 == null) goto L138;
        int r152 = r151.intValue();
    L139:
        if (r131 == r129) goto L141;
    L144:
        ChatMessageList r153 = o5();
        if (r153 == null) goto L149;
        String r154 = " distance=";
        int r155 = r134;
        ChatMessageList r156 = r117;
        int r157 = r131;
        String r158 = "scroll to pos ";
        String r159 = "pending-unread-scroll-click";
        int r160 = r129;
        r110 = true;
        if (r153.O(r131, r129, r133 - r130.getHeight(), r141 - r152, r155) != true) goto L150;
        boolean r161 = true;
    L151:
        if (r161 == true) goto L153;
        r142.i(r159, "distance < messageList height, Abort: posA=" + r157 + " posB=" + r160 + " offsetA=" + (r133 - r130.getHeight()) + " offsetB=" + (r141 - r152) + r154 + r155);
    L163:
        r110 = false;
        r103 = this;
        goto L173
    L153:
        r142.i(r159, r158 + r160 + " with top offset " + r141);
        r156.g0(r160, r141);
        r103 = this;
    L169:
        if (F6() == true) goto L173;
        ChatMessageList r162 = o5();
        if (r162 == null) goto L173;
        r162.postDelayed(new b1(r103), 200);
    L150:
        r161 = false;
        goto L151
    L149:
        r156 = r117;
        r158 = "scroll to pos ";
        r154 = " distance=";
        r155 = r134;
        r157 = r131;
        r159 = "pending-unread-scroll-click";
        r160 = r129;
        r110 = true;
        goto L150
    L141:
        if (r130.getHeight() == r152) goto L144;
        r142.i("pending-unread-scroll-click", "msg height change: old:" + r152 + " new:" + r130.getHeight());
        goto L143
    L138:
        r152 = 0;
    L134:
        r150 = "";
    L154:
        final int r163 = r129;
        r110 = true;
        if (u6() == false) goto L164;
        if (r141 <= 0) goto L160;
        if (r131 != r163) goto L160;
        if (r133 < r141) goto L160;
        boolean r164 = true;
    L161:
        if (r164 == false) goto L164;
        r142.i("pending-unread-scroll-click", "pending unread target has been reached, scroll to latest: pos=" + r163 + " currentProgress=" + r133 + " msgProgress=" + r141 + " messageListHeight=" + r134);
    L160:
        r164 = false;
    L164:
        r142.i("pending-unread-scroll-click", "scroll to pos " + r163);
        if (F6() == false) goto L167;
        r103 = this;
        r103.v7("click_pending_unread_target_top", new a1(r117, r163));
        goto L169
    L167:
        r103 = this;
        r117.e(r163);
        goto L169
    L96:
        r141 = 0;
        goto L97
    L82:
        if (u6() == false) goto L91;
        if (r121 == null) goto L85;
        r123 = r121.f306714d;
    L85:
        if (r121 == null) goto L87;
        int r165 = r121.f306712b;
    L88:
        if (r123 <= 0) goto L91;
        if (r165 < r123) goto L91;
        FLogger.f375446a.i("pending-unread-scroll-click", "action bar has been read, scroll to latest: msgVis=" + r165 + ", contentH=" + r123);
        goto L143
    L87:
        r165 = 0;
    L91:
        r135 = 0;
    L50:
        r128 = null;
    L55:
        r129 = -1;
        goto L57
    L31:
        r119 = null;
        goto L32
    L23:
        if (C6() == true) goto L25;
    L18:
        if (j6() == false) goto L20;
        r116 = true;
        goto L21
    L5:
        r101 = 0;
        goto L6
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final boolean fJ() {
        List<Message> r100 = this.V0;
        if (r100 == null) goto L5;
        Message r101 = (Message) CollectionsKt.firstOrNull(r100);
    L7:
        if (r101 != null) goto L10;
        return false;
    L10:
        if (com.larus.bmhome.social.userchat.model.b0.f(r101) == false) goto L25;
        Map<String, String> r102 = r101.getBusinessExt();
        if (r102 == null) goto L21;
        String r103 = r102.get("fake_message_type");
        if (r103 == null) goto L21;
        Integer r104 = StringsKt.toIntOrNull(r103);
        if (r104 == null) goto L21;
        if (r104.intValue() != 3) goto L21;
        boolean r105 = true;
    L22:
        if (r105 == false) goto L26;
        return true;
    L26:
        return false;
    L21:
        r105 = false;
        goto L22
    L25:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    @Override // va8.p
    public final List<Message> getCurrentList() {
        MessageAdapter r100 = this.O;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentList();
    }

    public final LarusPageChatBinding h4() {
        return (LarusPageChatBinding) this.f300892g2.getValue();
    }

    public final boolean j6() {
        Map<String, com.larus.bmhome.chat.manager.d0> r100 = com.larus.bmhome.chat.manager.e0.f306718a;
        com.larus.bmhome.chat.manager.d0 r101 = com.larus.bmhome.chat.manager.e0.a(G4());
        if (r101 == null) goto L5;
        Message r102 = r101.f306711a;
    L6:
        if (r102 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public final void k7() {
        FLogger.f375446a.i(this.f300905n, "removeMockLoadingByBotSay");
        MessageAdapter r100 = this.O;
        if (r100 == null) goto L64;
        Iterator<T> r101 = r100.getCurrentList().iterator();
    L5:
        String r102 = null;
        if (r101.hasNext() == false) goto L45;
        Object r103 = r101.next();
        Message r104 = (Message) r103;
        boolean r105 = true;
        if (com.larus.bmhome.chat.bean.d.i0(r104) == false) goto L13;
        if (com.larus.bmhome.chat.bean.d.w(r104) == true) goto L13;
    L32:
        boolean r106 = false;
    L33:
        if (r106 == true) goto L35;
    L42:
        r105 = false;
    L43:
        if (r105 == false) goto L5;
    L46:
        Message r107 = (Message) r103;
        if (r107 == null) goto L65;
        Map<String, String> r108 = r107.getBusinessExt();
        if (r108 == null) goto L52;
        r102 = r108.get("send_loading");
    L52:
        if (Intrinsics.areEqual(r102, "2") == false) goto L66;
        RepoDispatcher.f307729a.getClass();
        ChatRepo r109 = RepoDispatcher.f307732d;
        String r110 = r107.getLocalMessageId();
        if (r110 != null) goto L56;
        r110 = "";
    L56:
        r109.r1(r110, new k4());
        return;
    L66:
        return;
    L65:
        return;
    L35:
        if (com.larus.bmhome.social.userchat.model.b0.f(r104) == false) goto L43;
        Integer r111 = com.larus.bmhome.social.userchat.model.b0.c(r104);
        if (r111 == null) goto L42;
        if (r111.intValue() != 3) goto L42;
    L13:
        if (com.larus.bmhome.chat.bean.d.T(r104) == true) goto L32;
        if (com.larus.bmhome.chat.bean.d.p0(r104) == true) goto L32;
        if (com.larus.bmhome.chat.bean.d.C0(r104) == true) goto L20;
    L22:
        MessageStatus r112 = r104.getMessageStatus();
        if (r112 != null) goto L25;
    L27:
        boolean r113 = false;
    L28:
        if (r113 == false) goto L30;
    L31:
        r106 = true;
        goto L33
    L30:
        if (com.larus.bmhome.social.userchat.model.b0.f(r104) == false) goto L32;
    L25:
        if (r112.isVisible() != true) goto L27;
        r113 = true;
        goto L28
    L20:
        if (r104.getRegenVisible() == true) goto L22;
    L45:
        r103 = null;
        goto L46
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final int k70() {
        boolean r100 = true;
        Integer r101 = null;
        if (W3(new s3(this)) == false) goto L28;
        Rect r102 = new Rect();
        ChatMessageList r103 = o5();
        if (r103 == null) goto L7;
        r103.getGlobalVisibleRect(r102);
    L7:
        Integer r104 = Integer.valueOf(r102.height());
        if (r104.intValue() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L14;
        r104 = null;
    L14:
        if (r104 != null) goto L40;
        ChatMessageList r106 = o5();
        if (r106 == null) goto L24;
        Integer r107 = Integer.valueOf(r106.getHeight());
        if (r107.intValue() > 0) goto L22;
        r100 = false;
    L22:
        if (r100 == false) goto L24;
        r101 = r107;
    L24:
        if (r101 == null) goto L27;
        return r101.intValue();
    L27:
        return com.larus.utils.i.c(getContext());
    L40:
        return r104.intValue();
    L10:
        r105 = false;
        goto L11
    L28:
        ChatMessageList r108 = o5();
        if (r108 == null) goto L39;
        Integer r109 = Integer.valueOf(r108.getHeight());
        if (r109.intValue() > 0) goto L34;
        r100 = false;
    L34:
        if (r100 == false) goto L36;
        r101 = r109;
    L36:
        if (r101 == null) goto L39;
        return r101.intValue();
    L39:
        return com.larus.utils.i.c(getContext());
    }

    public final com.larus.bmhome.chat.component.showcase.x l4() {
        return (com.larus.bmhome.chat.component.showcase.x) this.W2.getValue();
    }

    public final boolean l7() {
        h r100 = this.E;
        if (r100 != null) goto L5;
        return false;
    L5:
        this.E = null;
        ChatMessageList r101 = o5();
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.getViewTreeObserver().isAlive() == false) goto L13;
        r101.getViewTreeObserver().removeOnPreDrawListener(r100);
        return true;
    L13:
        return true;
    }

    @Override // va8.p
    public final void n2() {
        MessageAdapter r100 = this.O;
        if (r100 == null) goto L8;
        ChatMessageList r101 = r100.f297036u;
        if (r101 == null) goto L9;
        Lazy<IObricChatUIService> r102 = ChatMessageList.V0;
        r101.l0(null, false);
        return;
    L9:
        return;
    }

    public final ChatMessageList o5() {
        return (ChatMessageList) this.f300914q.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        super.onCreate();
        this.O2 = (com.larus.bmhome.chat.i1) s1a.d.a(this).a(com.larus.bmhome.chat.i1.class);
        IAppLaunchReporter r100 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r100 == null) goto L5;
        r100.c("chat_message_show", null);
    L5:
        Iterator r101 = ((ArrayList) this.R3).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        m1a.b r102 = (m1a.b) r101.next();
        CopyOnWriteArraySet<xc8.f.a> r103 = xc8.f.f563237a;
        xc8.f.a(r102);
        goto L7
    L9:
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r104 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r104.setFragmentResultListener("dislikeDialogClose", com.larus.ui.arch.component.internal.attach.a.b(this, this), new y3(this));
        ChatListComponentViewModel r105 = U5();
        de8.c r106 = f1();
        String r107 = "";
        if (r106 == null) goto L14;
        Bundle r108 = r106.f468086b;
        if (r108 == null) goto L14;
        String r109 = r108.getString("argPushContentId", "");
    L15:
        if (r109 != null) goto L17;
        String r110 = "";
    L18:
        long r111 = de8.d.a(f1());
        long r112 = f1().l();
        boolean r113 = pl();
        com.larus.bmhome.chat.component.showcase.x r114 = l4();
        boolean r115 = true;
        if (r114 != null) goto L21;
    L23:
        boolean r116 = false;
    L24:
        boolean r210 = f1().E();
        Bundle r117 = f1().f468086b;
        if (r117 != null) goto L27;
    L29:
        boolean r211 = false;
    L30:
        r105.init(new a4(this), new c4(this), new d4(this), r110, r111, r112, r113, r116, new e4(this), new f4(this), new g4(this), new h4(this), new i4(this), r210, r211, this.O2);
        v4().onCreate();
        this.P0 = false;
        MessagePlaybackHelper r118 = this.f300908o3;
        com.larus.bmhome.chat.component.showcase.x r119 = l4();
        if (r119 != null) goto L33;
    L35:
        r115 = false;
    L36:
        r118.f301331i = r115;
        MessagePlaybackHelper r120 = this.f300908o3;
        com.larus.bmhome.chat.component.showcase.x r121 = l4();
        if (r121 == null) goto L44;
        Case r122 = r121.mz(false);
        if (r122 == null) goto L44;
        String r123 = r122.getCaseId();
        if (r123 == null) goto L44;
        r107 = r123;
    L44:
        r120.getClass();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r120.f301332j = r107;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.bmhome.chat.component.list.c r124 = new com.larus.bmhome.chat.component.list.c(com.larus.ui.arch.component.internal.attach.a.b(this, this), u0(), U5());
        com.larus.platform.model.chat.h r125 = com.larus.platform.service.z2.f365865a.getChatBlankScreenMonitorConfig();
        if (r125.b() == false) goto L48;
        long r126 = RangesKt.coerceIn(r125.a(), 0, 10000);
        r124.f301041d = false;
        r124.f301042e = false;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r124.f301038a), Dispatchers.getMain(), null, new ChatListBlankScreenMonitor$scheduleAfterCreate$1(r126, r124, null), 2, null);
    L48:
        this.U = r124;
        com.larus.bmhome.chat.component.cvs.y r127 = u0();
        if (r127 == null) goto L51;
        r127.rh(new j4(), new g(this));
    L51:
        int r128 = com.larus.utils.d.f375378a;
        FragmentActivity r129 = s1a.a.getActivity(this);
        Function1 r130 = new z3();
        Intrinsics.checkNotNullParameter(r130, "onCapture");
        if (r129 == null) goto L55;
        ActivityCompat.setExitSharedElementCallback(r129, new ActivityTransition$captureExitSharedElement$1(r130));
    L55:
        ChatParam r131 = (ChatParam) this.N2.getValue();
        if (r131 == null) goto L58;
        r131.f296895g = f1().e();
        r131.f296896h = f1().d();
    L58:
        GenImgLoadingResourceGetter.b();
        com.larus.bmhome.chat.auth.o0.f297364a = null;
        return;
    L33:
        if (r119.e6() != true) goto L35;
    L27:
        if (r117.getBoolean("arg_show_ai_generated_footer", false) != true) goto L29;
        r211 = true;
        goto L30
    L21:
        if (r114.e6() != true) goto L23;
        r116 = true;
        goto L24
    L17:
        r110 = r109;
    L14:
        r109 = null;
        goto L15
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        com.larus.bmhome.chat.mode.e r100 = this.f300918s;
        if (r100 == null) goto L5;
        r100.TJ(this.f300922u);
    L5:
        ChatMessageList r101 = o5();
        if (r101 == null) goto L8;
        r101.setAlpha(1.0f);
    L8:
        j7(this, KeepScreenOnReplyTrigger.DESTROY);
        a4();
        MessageHeightCache.INSTANCE.clear();
        k7();
        AuthModelDelegate.f297134b.c().removeObserver(this.f300913p3);
        ChatControlTrace.f309996b.getClass();
        ChatControlTrace.A = false;
        com.larus.bmhome.social.userchat.model.g0 r102 = this.D3;
        String r103 = r102.f314131d;
        if (r103 == null) goto L13;
        NativeMessageServiceImpl r104 = r102.f314133f;
        if (r104 == null) goto L13;
        r104.unregisterOnMessageChangedObserver(r103, r102.f314135h);
    L13:
        this.M1 = false;
        v4().onDestroy();
        ActivityResultLauncher<String> r105 = this.f300929w3;
        if (r105 == null) goto L16;
        r105.unregister();
    L16:
        IAiChatOpenDouyinAuthService r106 = V4();
        if (r106 == null) goto L19;
        r106.m(this.T);
    L19:
        IFlowSdkDepend r107 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r107 == null) goto L22;
        r107.K0();
        com.larus.music.i.f359475a.i(this.S);
    L22:
        NativeMessageServiceImpl r108 = com.larus.im.d.e();
        String r109 = G4();
        String r110 = "";
        if (r109 != null) goto L25;
        r109 = "";
    L25:
        r108.unregisterOnMessageChangedObserver(r109, this.C3);
        wc9.e r111 = R4();
        if (r111 == null) goto L30;
        String r112 = r111.f559198a;
        if (r112 == null) goto L30;
        ConcurrentHashMap<com.larus.bmhome.utils.u3, com.larus.bmhome.utils.j3> r113 = com.larus.bmhome.utils.v3.f315132a;
        Intrinsics.checkNotNullParameter(r112, "conversationId");
        com.larus.bmhome.utils.v3.f315133b.remove(r112);
        String r114 = R5();
        Intrinsics.checkNotNullParameter(r112, "conversationId");
        com.larus.bmhome.utils.v3.f315132a.remove(new com.larus.bmhome.utils.u3(r112, r114));
    L30:
        ConcurrentHashMap<String, List<xc8.b>> r115 = s7.f301256a;
        String r116 = G4();
        if (r116 != null) goto L33;
        r116 = "";
    L33:
        Intrinsics.checkNotNullParameter(r116, "conversationId");
        ConcurrentHashMap<String, List<xc8.b>> r117 = s7.f301256a;
        r117.remove(r116);
        FLogger.f375446a.i("ChatMessageCache", "cache size: " + r117.size());
        WeakReference<MessageMenu> r118 = MessageMenu.f315548x;
        com.larus.utils.l0.b(new com.larus.bmhome.view.q3());
        WeakReference<ef8.o> r119 = ef8.o.f472556v;
        com.larus.utils.l0.b(new ef8.m());
        com.larus.bmhome.bigimg.g.f295983a = false;
        ps8.d.f530467a.b("default");
        IFlowMainBot.Companion r120 = IFlowMainBot.f358419a;
        IFlowMainBot.a.a(r120, this.O, true, null, 4);
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new ChatListComponent$cancelCasePlayBack$1(this, null), 3, null);
        r120.k8();
        com.larus.bmhome.double_post.utils.c.f311606a = false;
        if (this.f300904m3 == null) goto L42;
        FlowFeedbackServiceDelegate r121 = FlowFeedbackServiceDelegate.f343027a;
        String r122 = G4();
        if (r122 == null) goto L40;
        r110 = r122;
    L40:
        r121.b(r110);
        this.f300904m3 = null;
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
        j7(this, KeepScreenOnReplyTrigger.PAUSE);
        v4().onPause();
        g7();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        boolean r101 = false;
        if (r100 == null) goto L11;
        Lifecycle r102 = r100.getLifecycle();
        if (r102 == null) goto L11;
        Lifecycle.State r103 = r102.getCurrentState();
        if (r103 == null) goto L11;
        if (r103.isAtLeast(Lifecycle.State.STARTED) != true) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L29;
        List<Activity> r105 = AppHost.f326268a.a().m();
        if ((r105 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r106 = r105.iterator();
    L20:
        if (r106.hasNext() == false) goto L27;
        if (((Activity) r106.next()) == r100) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L20;
        boolean r108 = true;
    L28:
        if (r108 == true) goto L29;
    L31:
        if (r101 == false) goto L40;
        wc9.e r109 = R4();
        if (r109 == null) goto L40;
        dh8.b r110 = dh8.b.f468639a;
        StringBuilder r111 = new StringBuilder();
        r111.append(r109.f559198a);
        r111.append(':');
        String r112 = r109.B;
        if (r112 != null) goto L37;
        r112 = "";
    L37:
        r111.append(r112);
        String r113 = r111.toString();
        r110.getClass();
        Intrinsics.checkNotNullParameter(r113, "scope");
        if (Intrinsics.areEqual(dh8.b.f468640b, r113) == false) goto L40;
        dh8.b.f468640b = null;
    L40:
        j7(this, KeepScreenOnReplyTrigger.STOP);
        v4().onStop();
        p99.d r114 = this.f300904m3;
        if (r114 == null) goto L43;
        r114.h();
    L43:
        IAIChatTtsPlayTraceService.Companion r115 = IAIChatTtsPlayTraceService.f365902a;
        r115.c(null, null);
        r115.b(null);
        return;
    L24:
        r107 = false;
    L27:
        r108 = false;
        goto L28
    L16:
        if (r105.isEmpty() == false) goto L18;
    L29:
        r101 = true;
    L11:
        r104 = false;
        goto L12
    }

    public final sd8.a p4() {
        return (sd8.a) this.f300893g3.getValue();
    }

    public final va8.o q4() {
        return (va8.o) this.G2.getValue();
    }

    public final void q5() {
        OfflineMessageServiceDelegate.f342907b.d(f1().l());
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void showLoading() {
        com.larus.common_ui.dialog.l0 r100 = (com.larus.common_ui.dialog.l0) this.Y.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.L2.getValue();
    }

    public final boolean u6() {
        boolean r100 = com.larus.platform.exp.h.f365384a;
        if (com.larus.platform.exp.h.f365384a == false) goto L10;
        com.larus.platform.model.chat.k r101 = this.f300928w;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.a() != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return com.larus.platform.service.z2.f365865a.getChatReadPositionBugfixConfig().a();
    }

    public final com.larus.bmhome.chat.trace.l0 v4() {
        return (com.larus.bmhome.chat.trace.l0) this.f300882J.getValue();
    }

    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.S2.getValue();
    }

    public final boolean w6() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r100 == null) goto L7;
        FragmentManager r101 = r100.getSupportFragmentManager();
        if (r101 == null) goto L7;
        Fragment r102 = r101.findFragmentByTag("TimeStampHolder");
    L8:
        if (r102 == null) goto L10;
        return true;
    L10:
        return false;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void w70() {
        if (((Boolean) wi8.d.f559859b.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        ChatMessageList r100 = o5();
        int r101 = 0;
        if (r100 == null) goto L8;
        r100.setShowTopButton(false);
    L8:
        ChatMessageList r102 = o5();
        if (r102 == null) goto L11;
        r102.setMiddleLoad(false);
    L11:
        ChatMessageList r103 = o5();
        LinearLayoutManager r104 = null;
        if (r103 == null) goto L14;
        RecyclerView.LayoutManager r105 = r103.getLayoutManager();
    L16:
        if ((r105 instanceof LinearLayoutManager) == false) goto L18;
        r104 = (LinearLayoutManager) r105;
    L18:
        if (r104 != null) goto L20;
        return;
    L20:
        View r106 = r104.getChildAt(0);
        if (r106 == null) goto L42;
        int r107 = r104.getPosition(r106);
        List<Message> r108 = getCurrentList();
        if (r108 == null) goto L43;
        Message r109 = (Message) CollectionsKt.getOrNull(r108, r107);
        if (r109 == null) goto L45;
        ChatMessageList r110 = o5();
        if (r110 == null) goto L30;
        int r111 = r110.getInitialHeight();
    L31:
        ChatMessageList r112 = o5();
        if (r112 == null) goto L34;
        int r113 = r112.getInitialHeight();
        int r114 = k70();
        FLogger.f375446a.i(this.f300905n, "[MessageList Change Offset]: initHeight=" + r113 + " currentHeight=" + r114);
        r101 = r113 - r114;
    L34:
        ChatMessageList r115 = o5();
        if (r115 == null) goto L37;
        int r116 = r115.B();
    L38:
        int r117 = r116 - r101;
        FLogger.f375446a.i(this.f300905n, "distanceToBottom = " + r117 + ", check height = " + r111 + ", messageList height = " + k70());
        if (r117 <= r111) goto L44;
        this.T3 = true;
        Rect r118 = new Rect();
        r106.getLocalVisibleRect(r118);
        this.U3 = new Pair(Long.valueOf(r109.getLocalIndex()), Integer.valueOf(r118.bottom + r101));
        return;
    L44:
        return;
    L37:
        r116 = r101;
        goto L38
    L30:
        r111 = k70();
        goto L31
    L45:
        return;
    L43:
        return;
    L42:
        return;
    L14:
        r105 = null;
        goto L16
    }

    public final com.larus.bmhome.chat.component.showcase.y x5() {
        return (com.larus.bmhome.chat.component.showcase.y) this.X2.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, u7.class);
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.f300929w3 = com.larus.ui.arch.component.internal.attach.a.b(this, this).registerForActivityResult(new ActivityResultContracts.RequestPermission(), new k3(this));
    }

    public final void z7() {
        Iterator r100 = ((ArrayList) this.K3).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Function0) r100.next()).invoke();
        goto L4
    L6:
        wc9.e r101 = R4();
        Long r102 = null;
        if (r101 == null) goto L9;
        Long r103 = r101.f559212o;
    L10:
        MessageAdapter r104 = this.O;
        if (r104 == null) goto L21;
        Iterator r105 = ((ArrayList) r104.getCurrentList()).iterator();
        if (r105.hasNext() == false) goto L21;
        r102 = Long.valueOf(((Message) r105.next()).getServerIndex());
    L17:
        if (r105.hasNext() == false) goto L21;
        Long r106 = Long.valueOf(((Message) r105.next()).getServerIndex());
        if (r102.compareTo(r106) >= 0) goto L17;
        r102 = r106;
    L21:
        ChatMessageList r107 = o5();
        if (r107 == null) goto L24;
        r107.n0(true);
    L24:
        o5();
        ChatMessageList r108 = o5();
        if (r108 == null) goto L27;
        r108.setMiddleLoad(false);
    L27:
        if (r103 == null) goto L48;
        if (r102 == null) goto L48;
        if (r103.longValue() <= r102.longValue()) goto L48;
        if (f1().B() == false) goto L34;
    L40:
        MessageAdapter r109 = this.O;
        if (r109 == null) goto L43;
        r109.f297041z = false;
    L43:
        if (r109 == null) goto L47;
        MutableLiveData<Boolean> r110 = r109.f297040y;
        if (r110 == null) goto L47;
        r110.setValue(Boolean.FALSE);
    L47:
        U5().refreshCurChangeCvsId(new com.larus.bmhome.chat.component.list.e(this), new com.larus.bmhome.chat.component.list.f(this));
        this.M1 = true;
    L51:
        FLogger.f375446a.i(this.f300905n, "finish scrollToLatestMessage cvsMaxIndex=" + r103 + " msgListMaxIndex=" + r102);
        return;
    L34:
        if (z5() != (-1)) goto L40;
        Bundle r111 = f1().f468086b;
        if (r111 == null) goto L38;
        boolean r112 = r111.getBoolean("is_from_image_preview", false);
    L39:
        if (r112 == false) goto L48;
    L38:
        r112 = false;
    L48:
        ChatMessageList r113 = o5();
        if (r113 == null) goto L51;
        com.larus.bmhome.chat.api.b0.a.b(r113, false, 15);
        goto L51
    L9:
        r103 = null;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.larus.bmhome.chat.component.list.b2] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.bmhome.chat.component.list.d] */
    /* JADX WARN: Type inference failed for: r1v100, types: [com.larus.bmhome.chat.component.list.ChatListComponent$messageAddRemoveObserver$1] */
    /* JADX WARN: Type inference failed for: r1v101, types: [com.larus.bmhome.chat.component.list.ChatListComponent$changeListener$1] */
    /* JADX WARN: Type inference failed for: r1v103, types: [com.larus.bmhome.chat.component.list.ChatListComponent$ttsFailedStateObserver$1] */
    /* JADX WARN: Type inference failed for: r1v93, types: [com.larus.bmhome.chat.component.list.ChatListComponent$launchInfoObserver$1] */
    /* JADX WARN: Type inference failed for: r1v99, types: [com.larus.bmhome.chat.component.list.ChatListComponent$adapterObserver$1] */
    /* JADX WARN: Type inference failed for: r5v23, types: [com.larus.bmhome.chat.component.list.c3] */
    public ChatListComponent() {
        this.f300903m = R.id.chat_root;
        this.f300905n = "ChatListComponentWrapper-" + hashCode();
        this.f300907o = "MsgRefreshFlow_ChatListComponent";
        this.f300909p = new com.larus.bmhome.chat.component.list.d(this);
        this.f300914q = LazyKt.lazy(new z(this));
        this.f300916r = "ChatListComponent-" + UUID.randomUUID();
        this.f300920t = 1.0f;
        this.f300922u = new b2(this);
        boolean r100 = com.larus.platform.exp.h.f365384a;
        com.larus.bmhome.chat.exposure.a r101 = null;
        if (r100 == false) goto L5;
        com.larus.platform.model.chat.k r102 = com.larus.platform.service.z2.f365865a.getChatReadPositionBugfixConfig();
    L6:
        this.f300928w = r102;
        if (r100 == true) goto L9;
    L11:
        boolean r103 = false;
    L12:
        this.f300930x = r103;
        this.f300934y = LazyKt.lazy(new n2());
        this.f300938z = LazyKt.lazy(new z2());
        this.H = "";
        this.I = new e3(this);
        this.f300882J = LazyKt.lazy(new g3(this));
        this.K = LazyKt.lazy(new h3());
        this.L = LazyKt.lazy(new i3());
        this.M = LazyKt.lazy(new j3());
        this.N = LazyKt.lazy(new y1());
        this.X = SystemClock.elapsedRealtime();
        this.Y = LazyKt.lazy(new j2(this));
        this.Z = LazyKt.lazy(new u2());
        this.f300899k0 = LazyKt.lazy(new f3(this));
        this.H0 = "";
        this.f300891g1 = new LinkedHashSet();
        this.f300925v1 = new LinkedHashMap();
        this.f300931x1 = "ChatListComponent-" + hashCode();
        this.H1 = true;
        this.L1 = new f2a.d("Chat", "ChatListComponent");
        this.P1 = new CopyOnWriteArrayList();
        this.Q1 = new CopyOnWriteArraySet();
        this.S1 = new CopyOnWriteArraySet();
        this.V1 = LazyKt.lazy(new q3(this));
        this.f300885b2 = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(ChatListComponentViewModel.class), Reflection.getOrCreateKotlinClass(ChatListComponentState.class), new m(this), new n(this), o.f300969a);
        this.f300892g2 = LazyKt.lazy(new b4(this));
        this.f300895h2 = LazyKt.lazy(new m4(this));
        this.f300912p2 = LazyKt.lazy(new x4(this));
        this.f300926v2 = LazyKt.lazy(new i5(this));
        this.f300932x2 = LazyKt.lazy(new com.larus.bmhome.chat.component.list.o(this));
        this.f300936y2 = LazyKt.lazy(new k0(this));
        this.E2 = LazyKt.lazy(new v0(this));
        this.F2 = LazyKt.lazy(new g1(this));
        this.G2 = LazyKt.lazy(new r1(this));
        this.H2 = LazyKt.lazy(new u1(this));
        this.I2 = LazyKt.lazy(new v1(this));
        this.J2 = LazyKt.lazy(new w1(this));
        this.K2 = LazyKt.lazy(new x1(this));
        this.L2 = LazyKt.lazy(new z1(this));
        this.M2 = LazyKt.lazy(new a2(this));
        this.N2 = LazyKt.lazy(new c2(this));
        this.P2 = LazyKt.lazy(new d2(this));
        this.Q2 = LazyKt.lazy(new e2(this));
        this.R2 = LazyKt.lazy(new f2(this));
        this.S2 = LazyKt.lazy(new g2(this));
        this.T2 = LazyKt.lazy(new h2(this));
        this.U2 = LazyKt.lazy(new i2(this));
        this.V2 = LazyKt.lazy(new k2());
        this.W2 = LazyKt.lazy(new l2(this));
        this.X2 = LazyKt.lazy(new m2(this));
        this.Y2 = LazyKt.lazy(new o2(this));
        this.Z2 = LazyKt.lazy(new p2(this));
        this.f300883a3 = LazyKt.lazy(new q2(this));
        this.f300886b3 = LazyKt.lazy(new r2(this));
        this.f300887c3 = LazyKt.lazy(new i(this));
        this.f300888d3 = LazyKt.lazy(new s2(this));
        this.f300889e3 = LazyKt.lazy(new t2(this));
        this.f300890f3 = LazyKt.lazy(new j(this));
        this.f300893g3 = LazyKt.lazy(new k(this));
        this.f300896h3 = LazyKt.lazy(new v2(this));
        this.f300897i3 = LazyKt.lazy(new w2(this));
        this.f300898j3 = LazyKt.lazy(new x2(this));
        this.f300901k3 = LazyKt.lazy(new y2(this));
        this.f300902l3 = LazyKt.lazy(new a3(this));
        MessagePlaybackHelper r104 = new MessagePlaybackHelper();
        r104.f301334l = new ChatListComponent$playbackHelper$1$1(this, null);
        r104.f301335m = new ChatListComponent$playbackHelper$1$2(this, null);
        this.f300908o3 = r104;
        this.f300913p3 = new ChatListComponent$launchInfoObserver$1(this);
        this.f300915q3 = LazyKt.lazy(new b3());
        this.f300917r3 = new LruCache(10);
        this.f300919s3 = new ChatListComponent$streamObserver$1(this);
        this.f300921t3 = new f();
        this.f300923u3 = new ChatListComponent$adapterObserver$1(this);
        this.f300927v3 = new ChatListComponent$messageAddRemoveObserver$1(this);
        this.C3 = new ChatListComponent$changeListener$1(this);
        this.D3 = new com.larus.bmhome.social.userchat.model.g0(LifecycleOwnerKt.getLifecycleScope(this), new c3(this));
        this.F3 = new ChatListComponent$ttsFailedStateObserver$1(this);
        this.H3 = new b(this);
        this.I3 = LazyKt.lazy(new l(this));
        this.K3 = new ArrayList();
        this.L3 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        new CopyOnWriteArraySet();
        this.O3 = "";
        this.Q3 = new ArrayList();
        this.R3 = new ArrayList();
        if (com.larus.platform.service.z2.f365865a.getECommerceSettingsConfig().getEnableAutoExposureManager() == false) goto L15;
        int r105 = com.larus.bmhome.chat.exposure.a.f302979g;
        Function1 r106 = new d3();
        Intrinsics.checkNotNullParameter(r106, "block");
        ExposureConfig.a r107 = new ExposureConfig.a();
        r106.invoke(r107);
        r101 = new com.larus.bmhome.chat.exposure.a(new ExposureConfig(r107.f302960a, r107.f302961b, r107.f302962c, r107.f302963d, r107.f302964e, r107.f302965f, r107.f302966g));
    L15:
        this.V3 = r101;
        return;
    L9:
        if (com.larus.platform.service.z2.f365865a.enableKeepScreenOnReply() == false) goto L11;
        r103 = true;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        wc9.e r100 = R4();
        if (r100 == null) goto L10;
        dh8.b r101 = dh8.b.f468639a;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.f559198a);
        r102.append(':');
        String r103 = r100.B;
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r102.append(r103);
        String r104 = r102.toString();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r104, "scope");
        if (Intrinsics.areEqual(dh8.b.f468640b, r104) == false) goto L10;
        dh8.b.f468640b = null;
    L10:
        j7(this, KeepScreenOnReplyTrigger.VIEW_DESTROYED);
        ChatMessageList r105 = o5();
        if (r105 == null) goto L13;
        r105.setAdapter(null);
    L13:
        Iterator r106 = ((ArrayList) this.Q3).iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        ((Function0) r106.next()).invoke();
        goto L15
    L17:
        u29.b r107 = (u29.b) this.I3.getValue();
        if (r107 == null) goto L21;
        r107.Gd();
    L21:
        if (this.I != null) goto L31;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L28
        MessageAdapter r109 = this.O;     // Catch: Throwable -> L28
        if (r109 == null) goto L25;
        r109.unregisterAdapterDataObserver(this.f300923u3);     // Catch: Throwable -> L28
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L28
    L26:
        Result.m9449constructorimpl(r110);     // Catch: Throwable -> L28
        goto L31
    L25:
        r110 = null;
    L28:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L31:
        if (f1().C() == true) goto L59;
    L40:
        ld8.n r112 = d5();
        if (r112 == null) goto L43;
        boolean r113 = r112.uo(BottomFloatingButtonType.FAST_SCROLL_BUTTON);
    L44:
        this.f300924v = r113;
        com.larus.platform.api.r3.b r114 = this.f300906n3;
        if (r114 == null) goto L47;
        r114.end();
    L47:
        int r115 = com.larus.im.d.f347134a;
        com.larus.im.internal.stream.b r116 = com.larus.im.internal.stream.b.f350138a;
        ChatListComponent$streamObserver$1 r117 = this.f300919s3;
        r116.e(r117.f300985a, r117);
        this.f300891g1.clear();
        this.f300894h1 = null;
        this.f300911p1 = false;
        this.R = this.Q;
        OfflineMessageServiceDelegate.f342907b.h(f1().l(), this.f300921t3);
        AudioServiceDelegate r118 = AudioServiceDelegate.f288288a;
        r118.r0().k(this.F3);
        r118.P().k(this.H3);
        IObricContinuousTalkService r119 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        if (r119 == null) goto L50;
        r119.d(this.f300909p);
    L50:
        Job r120 = this.G3;
        if (r120 == null) goto L53;
        Job.DefaultImpls.cancel$default(r120, null, 1, null);
    L53:
        this.G3 = null;
        gw8.c.f483071a.getClass();
        gw8.c r121 = gw8.c.a.b();
        if (r121 == null) goto L62;
        r121.clearMarkdownDrawableCachePool();
        return;
    L62:
        return;
    L43:
        r113 = false;
        goto L44
    L59:
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L38
        MessageAdapter r123 = this.O;     // Catch: Throwable -> L38
        if (r123 == null) goto L35;
        r123.unregisterAdapterDataObserver(this.f300927v3);     // Catch: Throwable -> L38
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L38
    L36:
        Result.m9449constructorimpl(r124);     // Catch: Throwable -> L38
        goto L40
    L35:
        r124 = null;
    L38:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    }

    public final boolean C6() {
        String r100 = G4();
        String r101 = null;
        if (u6() == false) goto L31;
        List<Message> r102 = getCurrentList();
        if (r102 == null) goto L19;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L17;
        Object r104 = r103.next();
        Message r105 = (Message) r104;
        if (com.larus.bmhome.social.userchat.model.b0.f(r105) == false) goto L12;
    L14:
        boolean r106 = false;
    L15:
        if (r106 == false) goto L8;
    L18:
        Message r107 = (Message) r104;
    L20:
        Map<String, com.larus.bmhome.chat.manager.d0> r108 = com.larus.bmhome.chat.manager.e0.f306718a;
        if (r107 == null) goto L23;
        r101 = r107.getMessageId();
    L23:
        if (r100 == null) goto L63;
        if (r101 == null) goto L64;
        com.larus.bmhome.chat.manager.d0 r109 = (com.larus.bmhome.chat.manager.d0) ((LinkedHashMap) com.larus.bmhome.chat.manager.e0.f306718a).get(r100);
        if (r109 != null) goto L30;
        return false;
    L30:
        return Intrinsics.areEqual(r109.f306713c, r101);
    L64:
        return false;
    L63:
        return false;
    L12:
        if (r105.getContentType() == 2) goto L14;
        r106 = true;
        goto L15
    L17:
        r104 = null;
        goto L18
    L19:
        r107 = null;
        goto L20
    L31:
        List<Message> r110 = getCurrentList();
        if (r110 == null) goto L41;
        Iterator<T> r111 = r110.iterator();
    L35:
        if (r111.hasNext() == false) goto L39;
        Object r112 = r111.next();
        if (com.larus.bmhome.chat.bean.d.G0((Message) r112) == false) goto L35;
    L40:
        Message r113 = (Message) r112;
    L42:
        Map<String, com.larus.bmhome.chat.manager.d0> r114 = com.larus.bmhome.chat.manager.e0.f306718a;
        if (r113 == null) goto L45;
        r101 = r113.getMessageId();
    L45:
        if (r100 != null) goto L47;
    L46:
        return false;
    L47:
        com.larus.bmhome.chat.manager.d0 r115 = (com.larus.bmhome.chat.manager.d0) ((LinkedHashMap) com.larus.bmhome.chat.manager.e0.f306718a).get(r100);
        if (r115 == null) goto L46;
        String r116 = r115.f306713c;
        if (r116 != null) goto L54;
        return true;
    L54:
        return Intrinsics.areEqual(r116, r101);
    L39:
        r112 = null;
        goto L40
    L41:
        r113 = null;
        goto L42
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void C90() {
        ChatListComponentViewModel r100 = U5();
        com.larus.bmhome.chat.component.cvs.y r101 = u0();
        BotModel r102 = null;
        if (r101 == null) goto L5;
        wc9.e r103 = r101.h();
    L6:
        com.larus.bmhome.chat.component.cvs.y r104 = u0();
        if (r104 == null) goto L9;
        r102 = r104.j0();
    L9:
        r100.refreshListWithCurrentData(r103, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final boolean D6() {
        if (wi8.d.a().b() == true) goto L6;
        return false;
    L6:
        if (f1().y() == false) goto L8;
    L11:
        return true;
    L8:
        if (G7() == true) goto L11;
        if (I7() == true) goto L11;
        return false;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final boolean D80() {
        LarusPageChatBinding r100 = h4();
        if (r100 == null) goto L10;
        ChatMessageList r101 = r100.f311098n;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.P() != true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final com.larus.bmhome.chat.component.collection.o F4() {
        return (com.larus.bmhome.chat.component.collection.o) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.collection.o.class);
    }

    public final boolean F6() {
        if (u6() == true) goto L5;
    L7:
        return false;
    L5:
        if (wi8.d.a().c() == false) goto L7;
        return true;
    }

    public final String G4() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.Y1();
    }

    public final boolean G7() {
        if (V6(G4()) == false) goto L6;
        return false;
    L6:
        if (u6() == true) goto L8;
        return false;
    L8:
        de8.c r100 = f1();
        r100.getClass();
        if (wi8.d.a().b() == false) goto L14;
        Bundle r101 = r100.f468086b;
        if (r101 == null) goto L14;
        int r102 = r101.getInt("red_dot_entry_unread_count", 0);
    L15:
        if (r102 > 0) goto L18;
        return false;
    L18:
        if (f1().s() < 0) goto L21;
        return true;
    L21:
        return false;
    L14:
        r102 = 0;
        goto L15
    }

    public final String I5() {
        Bundle r100 = f1().f468086b;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString("search_highlight_keyword", null);
    L6:
        if (r102 == null) goto L8;
        r101 = StringsKt.trim(r102).toString();
    L8:
        if (r101 != null) goto L11;
        return "";
    L11:
        return r101;
    L5:
        r102 = null;
        goto L6
    }

    public final boolean I7() {
        if (V6(G4()) == false) goto L6;
        return false;
    L6:
        if (this.M3 == true) goto L9;
        return false;
    L9:
        if (u6() == true) goto L11;
        return true;
    L11:
        wc9.e r100 = R4();
        if (r100 != null) goto L14;
        return true;
    L14:
        Integer r101 = r100.f559209l;
        if (r101 == null) goto L17;
        int r102 = r101.intValue();
    L18:
        Integer r103 = r100.f559210m;
        if (r103 == null) goto L21;
        int r104 = r103.intValue();
    L22:
        if (r102 <= r104) goto L25;
        return true;
    L25:
        return false;
    L21:
        r104 = 0;
        goto L22
    L17:
        r102 = 0;
        goto L18
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final boolean IS() {
        LarusPageChatBinding r100 = h4();
        if (r100 == null) goto L78;
        int r101 = r100.f311098n.B();
        int r102 = v19.i5.Z();
        boolean r103 = com.larus.bmhome.double_post.utils.c.f311606a;
        List<Message> r104 = getCurrentList();
        if (r104 == null) goto L7;
        Message r105 = (Message) CollectionsKt.firstOrNull(r104);
    L8:
        Lazy r106 = com.larus.bmhome.double_post.utils.c.f311607b;
        if (((ChatAwemeFeedConfig) r106.getValue()).canEntryAwemeFeed() == true) goto L11;
    L26:
        int r107 = 0;
    L28:
        if (r101 >= (r102 + r107)) goto L30;
    L32:
        boolean r108 = false;
    L33:
        com.larus.bmhome.instruction.g r109 = vc();
        if (r109 != null) goto L36;
    L38:
        boolean r110 = false;
    L39:
        if (r110 == false) goto L41;
    L58:
        r108 = false;
    L59:
        if (r108 == false) goto L77;
        de8.c r111 = f1();
        Bundle r112 = r111.f468086b;
        if (r112 != null) goto L63;
    L65:
        boolean r113 = false;
    L66:
        if (r113 == false) goto L68;
        boolean r114 = true;
    L72:
        if (r114 == false) goto L77;
        if (r100.f311098n.canScrollVertically(1) == true) goto L77;
        FLogger.f375446a.d(this.f300905n, "hide fast scroll btn");
        return false;
    L68:
        if (r111.n() == false) goto L70;
        com.larus.platform.service.z2.f365865a.w3();
    L70:
        r114 = false;
        goto L72
    L63:
        if (r112.getBoolean("argEnableFastScrollButtonReachBottomCheck", false) != true) goto L65;
        r113 = true;
    L77:
        return r108;
    L41:
        if (r6() == true) goto L58;
        taa.a r115 = (taa.a) this.f300890f3.getValue();
        if (r115 != null) goto L45;
    L47:
        boolean r116 = false;
    L48:
        if (r116 == true) goto L58;
        com.larus.bmhome.chat.component.bottom.reference.a r117 = (com.larus.bmhome.chat.component.bottom.reference.a) this.T2.getValue();
        if (r117 != null) goto L52;
    L54:
        boolean r118 = false;
    L55:
        if (r118 == true) goto L58;
        if (W3(new u3(this)) == false) goto L59;
    L52:
        if (r117.Qj() != true) goto L54;
        r118 = true;
        goto L55
    L45:
        if (r115.YQ() != true) goto L47;
        r116 = true;
        goto L48
    L36:
        if (r109.z0() != true) goto L38;
        r110 = true;
        goto L39
    L30:
        if (W3(new t3(this)) == true) goto L32;
        r108 = true;
        goto L33
    L11:
        if (((ChatAwemeFeedConfig) r106.getValue()).getShouldFullyDisplay() == true) goto L26;
        if (r105 != null) goto L15;
    L17:
        boolean r119 = false;
    L18:
        if (r105 != null) goto L20;
    L22:
        boolean r120 = false;
    L23:
        if (r119 == true) goto L25;
        if (r120 == false) goto L26;
    L25:
        r107 = com.larus.bmhome.double_post.utils.c.a();
        goto L28
    L20:
        if (com.larus.bmhome.chat.bean.d.W(r105) != true) goto L22;
        r120 = true;
        goto L23
    L15:
        if (com.larus.bmhome.chat.bean.d.E0(r105) != true) goto L17;
        r119 = true;
        goto L18
    L7:
        r105 = null;
        goto L8
    L78:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void JE() {
        U5().setSelfSendMsgExceptAsrTriggerNoLoading();
    }

    @Override // va8.p
    public final RecyclerView Ly() {
        return o5();
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final long Mg() {
        Bundle r100 = f1().f468086b;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getLong("target_middle_msg_local_index", -1);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final com.larus.bmhome.chat.trace.l0 ON() {
        return v4();
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void P80() {
        LarusPageChatBinding r100 = h4();
        if (r100 == null) goto L8;
        final ChatMessageList r101 = r100.f311098n;
        if (r101 == null) goto L9;
        FLogger.f375446a.i(this.f300905n, "startModify watchOnImeInsetsAnimationEndOnce set");
        Function0 r102 = new u(this, r101);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r101, new ViewExtKt$watchOnImeInsetsAnimationEndOnce$callback$1(r102, r101));
        return;
    L9:
        return;
    }

    public final String Q5() {
        Bundle r100 = f1().f468086b;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getString(MusicAppletPage.KEY_MESSAGE_ID, null);
    L6:
        if (r102 != null) goto L14;
        Bundle r103 = f1().f468086b;
        if (r103 == null) goto L10;
        r101 = r103.getString("target_middle_msg_id", null);
    L10:
        if (r101 != null) goto L13;
        return f1().t();
    L13:
        return r101;
    L14:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    public final boolean Q6() {
        if (U6(f1().f468086b) == false) goto L5;
    L10:
        return true;
    L5:
        if (U6(f1().f468085a) == true) goto L10;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (U6(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments()) == true) goto L10;
        return false;
    }

    public final wc9.e R4() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    public final String R5() {
        sd8.a r100 = p4();
        if (r100 == null) goto L9;
        qy8.a r101 = r100.yu();
        if (r101 == null) goto L9;
        Boolean r102 = r101.f535211h;
        if (r102 == null) goto L9;
        r102.booleanValue();
        return this.f300916r;
    L9:
        return null;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void U1() {
        LarusPageChatBinding r100 = h4();
        if (r100 != null) goto L5;
        return;
    L5:
        if (((Boolean) this.N.getValue()).booleanValue() == false) goto L13;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L12;
        r100.f311085a.post(new l3(this));
        return;
    L12:
        return;
    }

    @Override // com.larus.bmhome.chat.component.list.u7, va8.p
    public final boolean W1() {
        return U5().isLimited();
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void W70() {
        U5().resetLoadingStatus();
    }

    public final boolean X6() {
        if (F6() == true) goto L6;
        return false;
    L6:
        if (this.B < 3) goto L9;
        return false;
    L9:
        if (SystemClock.elapsedRealtime() <= this.A) goto L13;
        a4();
        return false;
    L13:
        if (Intrinsics.areEqual(this.C, G4()) == true) goto L16;
        a4();
        return false;
    L16:
        String r100 = this.D;
        MessageAdapter r101 = this.O;
        if (r101 == null) goto L21;
        Message r102 = (Message) CollectionsKt.firstOrNull(r101.getCurrentList());
        if (r102 == null) goto L21;
        String r103 = r102.getMessageId();
    L23:
        if (Intrinsics.areEqual(r100, r103) == true) goto L26;
        a4();
        return false;
    L26:
        return true;
    L21:
        r103 = null;
        goto L23
    }

    public final void a4() {
        l7();
        this.A = 0;
        this.B = 0;
        this.C = null;
        this.D = null;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void a90() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatListComponent$showAllCase$1(this, null), 3, null);
    }

    public final Integer f5() {
        if (com.larus.utils.o0.d(f1().f468092h) == true) goto L5;
        return null;
    L5:
        if (pl() == false) goto L13;
        return Integer.valueOf(Color.parseColor(f1().f468092h));
    L8:
        FLogger.f375446a.e(this.f300905n, "bgPickedColor is not formatted");
        return null;
    L13:
        return null;
    }

    public final void g7() {
        ChatMessageList r100 = o5();
        if (r100 == null) goto L111;
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        Object r102 = null;
        if ((r101 instanceof LinearLayoutManager) == false) goto L7;
        LinearLayoutManager r103 = (LinearLayoutManager) r101;
    L8:
        if (r103 == null) goto L119;
        int r104 = r103.findFirstVisibleItemPosition();
        int r105 = -1;
        if (r104 == (-1)) goto L112;
        View r106 = r103.findViewByPosition(r104);
        if (r106 == null) goto L120;
        Rect r107 = new Rect();
        r106.getLocalVisibleRect(r107);
        int r108 = r107.bottom - r106.getHeight();
        int r109 = r106.getHeight() + r108;
        if (r108 <= 0) goto L18;
        return;
    L18:
        if (F6() == false) goto L86;
        int r110 = 0;
        if (X6() == true) goto L47;
        boolean r111 = true;
        if (F6() == true) goto L25;
    L29:
        boolean r112 = false;
    L30:
        if (r112 == true) goto L47;
        if (F6() == true) goto L35;
    L37:
        boolean r113 = false;
    L38:
        if (r113 == false) goto L40;
    L42:
        Message r114 = w5();
        if (r114 == null) goto L47;
        if (com.larus.bmhome.chat.bean.d.G0(r114) == true) goto L47;
    L48:
        if (r111 == false) goto L121;
        ChatMessageList r115 = o5();
        if (r115 == null) goto L122;
        List<Message> r116 = getCurrentList();
        if (r116 == null) goto L123;
        Message r117 = w5();
        if (r117 == null) goto L124;
        Iterator<Message> r118 = r116.iterator();
    L61:
        if (r118.hasNext() == false) goto L66;
        if (Intrinsics.areEqual(r118.next().getLocalMessageId(), r117.getLocalMessageId()) == true) goto L67;
        r110 = r110 + 1;
    L67:
        if (r110 < 0) goto L125;
        Map<String, com.larus.bmhome.chat.manager.d0> r119 = com.larus.bmhome.chat.manager.e0.f306718a;
        com.larus.bmhome.chat.manager.d0 r120 = com.larus.bmhome.chat.manager.e0.a(G4());
        if (r120 == null) goto L126;
        Message r121 = r120.f306711a;
        if (r121 == null) goto L76;
        r102 = r121.getLocalMessageId();
    L76:
        if (Intrinsics.areEqual(r102, r117.getLocalMessageId()) == false) goto L127;
        Integer r122 = s5(r110, r104, r109);
        if (r122 == null) goto L114;
        int r123 = r122.intValue();
        int r124 = r120.f306712b;
        int r125 = Math.max(r124, d7(r123, r124, "record_group_position"));
        if (r115.M(r110, r125, k70()) == false) goto L83;
        com.larus.bmhome.chat.manager.e0.b(G4(), r117, r125, -1);
        Z3("record_group_read");
        return;
    L83:
        if (r125 <= r124) goto L128;
        com.larus.bmhome.chat.manager.e0.b(G4(), r117, r125, -1);
        return;
    L128:
        return;
    L114:
        return;
    L127:
        return;
    L126:
        return;
    L125:
        return;
    L66:
        r110 = -1;
        goto L67
    L124:
        return;
    L123:
        return;
    L122:
        return;
    L121:
        return;
    L40:
        if (C6() == true) goto L42;
    L35:
        if (j6() == false) goto L37;
        r113 = true;
        goto L38
    L25:
        if (this.S3 == false) goto L29;
        if (j6() == false) goto L29;
        r112 = true;
    L47:
        r111 = false;
        goto L48
    L86:
        List<Message> r126 = getCurrentList();
        if (r126 == null) goto L117;
        Message r127 = (Message) CollectionsKt.getOrNull(r126, r104);
        if (r127 != null) goto L91;
        return;
    L91:
        if ((r106 instanceof AbstractMessageBoxContainerView) == false) goto L93;
        AbstractMessageBoxContainerView r128 = (AbstractMessageBoxContainerView) r106;
    L94:
        if (r128 == null) goto L107;
        View r129 = r128.getBoxView();
        if (r129 == null) goto L107;
        if (com.larus.im.bean.message.a.w0(r127) == true) goto L107;
        if ((r129 instanceof com.larus.bmhome.chat.layout.item.i) == false) goto L102;
        r102 = (com.larus.bmhome.chat.layout.item.i) r129;
    L102:
        if (r102 == null) goto L107;
        NonPriorityMessageActionBar r130 = (NonPriorityMessageActionBar) com.larus.bmhome.chat.layout.item.i.h(r129, NonPriorityMessageActionBar.class);
        if (r130 == null) goto L107;
        r105 = ((com.larus.bmhome.chat.layout.item.i) r129).getHeight() - r130.getHeight();
    L107:
        Map<String, com.larus.bmhome.chat.manager.d0> r131 = com.larus.bmhome.chat.manager.e0.f306718a;
        com.larus.bmhome.chat.manager.e0.b(G4(), r127, r109, r105);
        return;
    L93:
        r128 = null;
        goto L94
    L117:
        return;
    L120:
        return;
    L112:
        return;
    L119:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public final String getBotId() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBotId();
    }

    public final Message h5() {
        List<Message> r100 = getCurrentList();
        Object r101 = null;
        if (r100 == null) goto L22;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        Message r104 = (Message) r103;
        if (com.larus.bmhome.social.userchat.model.b0.f(r104) == false) goto L10;
    L12:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L6;
        r101 = r103;
        goto L16
    L10:
        if (r104.getContentType() == 2) goto L12;
        r105 = true;
    L16:
        return (Message) r101;
    L22:
        return null;
    }

    public final boolean i4() {
        BotModel r100 = j0();
        if (r100 == null) goto L7;
        BotCreatorInfo r101 = r100.getBotCreatorInfo();
        if (r101 == null) goto L7;
        String r102 = r101.getId();
    L9:
        return Intrinsics.areEqual(r102, AccountService.f365697a.getUserId());
    L7:
        r102 = null;
        goto L9
    }

    public final BotModel j0() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.j0();
    }

    public final Integer j4() {
        BotModel r100 = j0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getBotType();
    }

    public final com.larus.bmhome.chat.component.bottom.bottommenu.f1 k4() {
        return (com.larus.bmhome.chat.component.bottom.bottommenu.f1) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.bottom.bottommenu.f1.class);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final com.larus.bmhome.chat.trace.l0 ku() {
        return v4();
    }

    public final boolean o6() {
        Bundle r100 = f1().f468086b;
        long r101 = -1;
        if (r100 == null) goto L6;
        r101 = r100.getLong("unread_query_read_message_index", -1);
    L6:
        if (r101 < 0) goto L8;
        return true;
    L8:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.larus.bmhome.chat.component.list.h0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        wc9.e r100 = R4();
        by7.e r101 = null;
        if (r100 == null) goto L22;
        dh8.b r102 = dh8.b.f468639a;
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.f559198a);
        r103.append(':');
        String r104 = r100.B;
        String r105 = "";
        if (r104 != null) goto L7;
        r104 = "";
    L7:
        r103.append(r104);
        String r106 = r103.toString();
        r102.getClass();
        dh8.b.a(r106);
        StringBuilder r107 = new StringBuilder();
        r107.append(r100.f559198a);
        r107.append(':');
        String r108 = r100.B;
        if (r108 == null) goto L11;
        r105 = r108;
    L11:
        r107.append(r105);
        String r109 = r107.toString();
        MessageAdapter r110 = this.O;
        if (r110 == null) goto L14;
        List<xc8.b> r111 = r110.z2();
    L15:
        if (r111 != null) goto L17;
        r111 = CollectionsKt.emptyList();
    L17:
        List<xc8.b> r112 = r111;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
    L19:
        if (r114.hasNext() == false) goto L21;
        r113.add(((xc8.b) r114.next()).getMessage());
        goto L19
    L21:
        dh8.b.k(r109, r113);
        goto L22
    L14:
        r111 = null;
    L22:
        LarusPageChatBinding r115 = h4();
        if (r115 == null) goto L35;
        ChatMessageList r116 = r115.f311098n;
        if (r116 == null) goto L35;
        int r117 = r116.getChildCount();
        int r118 = 0;
    L27:
        if (r118 >= r117) goto L35;
        View r119 = r116.getChildAt(r118);
        if ((r119 instanceof AbstractMessageBoxContainerView) == false) goto L31;
        AbstractMessageBoxContainerView r120 = (AbstractMessageBoxContainerView) r119;
    L32:
        if (r120 == null) goto L34;
        r120.requestLayout();
    L34:
        r118 = r118 + 1;
        goto L27
    L31:
        r120 = null;
    L35:
        C90();
        U7(this.V0, KeepScreenOnReplyTrigger.RESUME);
        if (((Boolean) com.larus.bmhome.utils.g3.f315020a.getValue()).booleanValue() == true) goto L38;
    L56:
        LarusPageChatBinding r121 = h4();
        if (r121 == null) goto L61;
        ChatMessageList r122 = r121.f311098n;
        if (r122 == null) goto L61;
        r122.requestLayout();
    L61:
        LandingRedBadgeHelperDelegate.f314918b.c();
        AudioServiceDelegate.f288288a.i0().b(G4());
        v4().onResume();
        LarusPageChatBinding r123 = h4();
        if (r123 == null) goto L66;
        ChatConstraintLayout r124 = r123.f311085a;
        if (r124 == null) goto L66;
        r124.postDelayed(new r3(this), 16);
    L66:
        e3 r125 = this.I;
        if (r125 == null) goto L69;
        r125.invoke();
    L69:
        this.I = null;
        IAIChatTtsPlayTraceService.Companion r126 = IAIChatTtsPlayTraceService.f365902a;
        r126.b(new h0(this));
        Intrinsics.checkNotNullParameter(this, "<this>");
        ActivityResultCaller r127 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r127 instanceof by7.e) == false) goto L72;
        r101 = (by7.e) r127;
    L72:
        r126.c(r101, this.O);
        com.larus.bmhome.chat.component.regen.a r128 = (com.larus.bmhome.chat.component.regen.a) this.f300883a3.getValue();
        if (r128 == null) goto L75;
        r128.qb(true);
    L75:
        com.larus.platform.api.m0 r129 = (com.larus.platform.api.m0) this.f300915q3.getValue();
        if (r129 == null) goto L83;
        r129.b();
        return;
    L83:
        return;
    L38:
        if (ic8.n.u(R4()) == false) goto L56;
        MessageAdapter r130 = this.O;
        if (r130 == null) goto L42;
        Message r131 = (Message) CollectionsKt.getOrNull(r130.getCurrentList(), 0);
    L43:
        if (r131 != null) goto L45;
    L47:
        boolean r132 = false;
    L48:
        if (r132 == false) goto L56;
        if (com.larus.bmhome.chat.bean.d.z0(r131) == true) goto L56;
        if (((AppHost.f326268a.getAppClock().currentTimeMillis() / ((long) 1000)) - r131.getCreateTime()) < com.larus.bmhome.utils.g3.a()) goto L56;
        MessageAdapter r133 = this.O;
        if (r133 == null) goto L56;
        r133.notifyItemChanged(0);
        goto L56
    L45:
        if (com.larus.bmhome.chat.bean.d.O0(r131) != true) goto L47;
        r132 = true;
        goto L48
    L42:
        r131 = null;
        goto L43
    }

    public final boolean pl() {
        return f1().C();
    }

    public final boolean r6() {
        ChatMessageList r100 = o5();
        LinearLayoutManager r101 = null;
        if (r100 == null) goto L5;
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
    L7:
        if ((r102 instanceof LinearLayoutManager) == false) goto L10;
        r101 = (LinearLayoutManager) r102;
    L10:
        if (r101 != null) goto L12;
        return false;
    L12:
        View r103 = r101.findViewByPosition(r101.findFirstVisibleItemPosition());
        if (r103 != null) goto L16;
        return false;
    L16:
        if (r103.getTranslationY() <= 0.0f) goto L19;
        return true;
    L19:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public final Message w5() {
        if (F6() == false) goto L27;
        Map<String, com.larus.bmhome.chat.manager.d0> r100 = com.larus.bmhome.chat.manager.e0.f306718a;
        com.larus.bmhome.chat.manager.d0 r101 = com.larus.bmhome.chat.manager.e0.a(G4());
        Object r102 = null;
        if (r101 == null) goto L7;
        Message r103 = r101.f306711a;
    L8:
        if (r103 == null) goto L27;
        List<Message> r104 = getCurrentList();
        if (r104 == null) goto L33;
        Iterator<T> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L25;
        Object r106 = r105.next();
        Message r107 = (Message) r106;
        if (com.larus.bmhome.social.userchat.model.b0.f(r107) == false) goto L17;
    L21:
        boolean r108 = false;
    L22:
        if (r108 == false) goto L13;
        r102 = r106;
        goto L25
    L17:
        if (r107.getContentType() == 2) goto L21;
        if (Intrinsics.areEqual(r107.getLocalMessageId(), r103.getLocalMessageId()) == false) goto L21;
        r108 = true;
    L25:
        return (Message) r102;
    L33:
        return null;
    L7:
        r103 = null;
    L27:
        return h5();
    }

    public final boolean x6() {
        wc9.e r100 = R4();
        if (ic8.n.u(r100) == false) goto L5;
    L12:
        return true;
    L5:
        if (ic8.n.D(r100) == true) goto L12;
        if (ic8.n.B(r100) == true) goto L12;
        if (f1().E() == true) goto L12;
        return false;
    }

    public final String y5() {
        Bundle r100 = f1().f468086b;
        if (r100 == null) goto L6;
        String r101 = r100.getString("preview_collection_id");
        if (r101 == null) goto L6;
        return r101;
    L6:
        Bundle r102 = f1().f468085a;
        if (r102 == null) goto L9;
        String r103 = r102.getString("preview_collection_id");
    L10:
        if (r103 != null) goto L19;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r104 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r104 == null) goto L14;
        String r105 = r104.getString("preview_collection_id");
    L15:
        if (r105 != null) goto L20;
        return "";
    L20:
        return r105;
    L14:
        r105 = null;
        goto L15
    L19:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void z() {
        if (pl() == false) goto L11;
        com.larus.bmhome.chat.component.immerse.a r100 = (com.larus.bmhome.chat.component.immerse.a) this.Q2.getValue();
        boolean r101 = false;
        if (r100 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L11;
    L12:
        if (r101 == true) goto L14;
        return;
    L14:
        if (o5() == null) goto L16;
        v4().z();
    L16:
        wc9.e r103 = R4();
        if (r103 == null) goto L30;
        String r104 = r103.f559198a;
        if (r104 != null) goto L21;
        return;
    L21:
        if ((true ^ StringsKt.isBlank(r104)) == true) goto L24;
        r104 = null;
    L24:
        if (r104 == null) goto L32;
        int r105 = com.larus.bmhome.chat.bubble.floating.runtime.k.f297555a;
        Intrinsics.checkNotNullParameter(r104, "conversationId");
        IBubbleBannerRuntimeService r106 = com.larus.bmhome.chat.bubble.floating.runtime.k.c();
        if (r106 == null) goto L33;
        r106.e(r104);
        return;
    L33:
        return;
    L32:
        return;
    L30:
        return;
    L7:
        if (r100.b50() != true) goto L9;
        r102 = true;
    L11:
        r101 = true;
        goto L12
    }

    public final long z5() {
        Bundle r100 = f1().f468086b;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.getLong("target_middle_push_msg_local_index", -1);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final StateFlowImpl Le() {
        return DocumentMessageProcessor.f302868f;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final MessageAdapter MF() {
        return this.O;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final boolean Qf() {
        return this.P3;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f300903m;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void lm() {
        X5();
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final MutableSharedFlow m30() {
        return this.L3;
    }

    @Override // va8.p
    public final com.larus.bmhome.chat.exposure.a vQ() {
        return this.V3;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final List<Message> zj() {
        return this.V0;
    }

    public static final void D3(ChatListComponent r100) {
        if (r100.E3 == false) goto L5;
        r100.E3 = false;
        t19.s.f544207a.a();
    L5:
        Lazy r101 = MediaResourceManager.f358950a;
        String r102 = r100.U5().getReader().o6();
        if (com.larus.media.o.a() == false) goto L9;
        MediaResourceManager.a r103 = new MediaResourceManager.a();
        r103.f358957a = 2;
        r103.f358958b = r102;
        r103.f358959c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        MediaResourceManager.d(r103);
        return;
    }

    public static boolean H6(Bundle r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L14;
        if (r100 == null) goto L11;
        String r102 = r100.getString("as_container");
    L13:
        if (Intrinsics.areEqual(r102, "READONLY_FORWARD_DETAIL") == true) goto L14;
        return false;
    L11:
        r102 = null;
    L14:
        return true;
    L5:
        if (r100.getBoolean("preview_collection_readonly") != true) goto L7;
        r101 = true;
        goto L8
    }

    public static boolean Q3(Message r100) {
        Map<String, String> r101 = r100.getExt();
        if (r101 == null) goto L12;
        String r102 = r101.get("empty_response");
        if (r102 == null) goto L12;
        Integer r103 = StringsKt.toIntOrNull(r102);
        if (r103 == null) goto L12;
        if (r103.intValue() != 1) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        return false;
    L15:
        Map<String, String> r105 = r100.getExt();
        String r106 = null;
        if (r105 == null) goto L18;
        String r107 = r105.get("dora_upper_screen_user_message");
    L20:
        if (Intrinsics.areEqual(r107, "1") == false) goto L22;
        return false;
    L22:
        Map<String, String> r108 = r100.getBusinessExt();
        if (r108 == null) goto L26;
        r106 = r108.get("send_loading");
    L26:
        if (Intrinsics.areEqual(r106, "0") == false) goto L28;
        return false;
    L28:
        return true;
    L18:
        r107 = null;
    L12:
        r104 = false;
        goto L13
    }

    public static boolean W6(Message r100) {
        if (com.larus.bmhome.chat.bean.d.G0(r100) == false) goto L12;
        if (r100.getMessageStatusLocal() == 10) goto L7;
    L9:
        return false;
    L7:
        if (Q3(r100) == false) goto L9;
        return true;
    L12:
        if (r100.getMessageStatusLocal() != 20) goto L14;
        return true;
    L14:
        if (r100.getMessageStatusLocal() != 24) goto L16;
        return true;
    L16:
        if (com.larus.im.bean.message.a.w0(r100) == false) goto L18;
        return true;
    L18:
        if (com.larus.bmhome.chat.bean.d.I0(r100) == false) goto L20;
        return true;
    L20:
        if (com.larus.bmhome.chat.bean.d.Q0(r100) == true) goto L35;
        Map<String, String> r101 = r100.getBusinessExt();
        if (r101 == null) goto L24;
        String r102 = r101.get("is_mock_receiving");
    L26:
        if (Intrinsics.areEqual(r102, "1") == true) goto L36;
        return false;
    L36:
        return true;
    L24:
        r102 = null;
        goto L26
    L35:
        return true;
    }

    public static long i5(List r100) {
        if (wi8.d.a().b() == true) goto L5;
        return -1;
    L5:
        Iterator r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L16;
        Object r102 = r101.next();
        Message r103 = (Message) r102;
        if (com.larus.bmhome.social.userchat.model.b0.f(r103) == false) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == false) goto L7;
    L17:
        Message r105 = (Message) r102;
        if (r105 != null) goto L20;
        return -1;
    L20:
        int r106 = r100.indexOf(r105) + 1;
        int r107 = r100.size();
    L21:
        if (r106 >= r107) goto L26;
        Message r108 = (Message) ListProtector.get(r100, r106);
        if (Intrinsics.areEqual(r108.getSenderId(), r105.getSenderId()) == false) goto L26;
        r106 = r106 + 1;
        r105 = r108;
    L26:
        return r105.getLocalIndex();
    L11:
        if (com.larus.bmhome.chat.bean.d.G0(r103) == true) goto L13;
        r104 = true;
        goto L14
    L16:
        r102 = null;
        goto L17
    }

    public static final String m3(ChatListComponent r100) {
        r100.getClass();
        ChatControlTrace r101 = ChatControlTrace.f309996b;
        wc9.e r102 = r100.R4();
        if (r102 == null) goto L5;
        Integer r103 = r102.f559219v;
    L7:
        return r101.g(r103, r100.j4(), r100.i4());
    L5:
        r103 = null;
        goto L7
    }

    public static boolean m6(List r100) {
        List r101 = r100;
        boolean r102 = r101 instanceof Collection;
        if (r102 == true) goto L5;
    L7:
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (W6((Message) r103.next()) == false) goto L9;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L65;
        Message r105 = (Message) CollectionsKt.firstOrNull(r100);
        if (r105 != null) goto L19;
    L62:
        boolean r106 = false;
    L64:
        if (r106 == true) goto L65;
        return false;
    L19:
        if (com.larus.bmhome.chat.bean.d.G0(r105) == false) goto L62;
        if (r105.getMessageStatusLocal() != 10) goto L25;
        r106 = Q3(r105);
        goto L64
    L25:
        if (r105.getMessageStatusLocal() != 11) goto L62;
        if (Q3(r105) == true) goto L30;
    L34:
        boolean r107 = false;
    L35:
        if (r107 == false) goto L62;
        String r108 = r105.getMessageId();
        if (r108 != null) goto L41;
        r108 = "";
    L41:
        if (r108.length() != 0) goto L43;
        boolean r109 = true;
    L44:
        if (r109 == true) goto L63;
        if (r102 == true) goto L48;
    L50:
        Iterator r110 = r101.iterator();
    L52:
        if (r110.hasNext() == false) goto L63;
        Message r111 = (Message) r110.next();
        if (com.larus.bmhome.chat.bean.d.G0(r111) == false) goto L56;
    L60:
        boolean r112 = false;
    L61:
        if (r112 == false) goto L52;
    L56:
        if (Intrinsics.areEqual(r111.getReplyId(), r108) == false) goto L60;
        if (r111.getMessageStatusLocal() == 24) goto L60;
        r112 = true;
        goto L61
    L48:
        if (r101.isEmpty() == false) goto L50;
    L63:
        r106 = true;
        goto L64
    L43:
        r109 = false;
        goto L44
    L30:
        if (com.larus.bmhome.social.userchat.model.b0.i(r105) == false) goto L32;
    L33:
        r107 = true;
        goto L35
    L32:
        if (com.larus.bmhome.chat.bean.d.M(r105) == false) goto L34;
    L65:
        return true;
    L13:
        r104 = false;
        goto L14
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    public static String p7(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 != null) goto L10;
    L12:
        return "";
    L10:
        if (r100.intValue() != 9) goto L12;
        return "message_answer_action";
    L5:
        if (r100.intValue() != 8) goto L7;
        return "message_menu_action";
    }

    public static final boolean q7(MessageAdapter r100) {
        if (Intrinsics.areEqual(r100.f297040y.getValue(), Boolean.TRUE) == true) goto L29;
        List<xc8.b> r101 = r100.z2();
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L8;
        Message r103 = ((xc8.b) r102.next()).getMessage();
        if (com.larus.bmhome.social.userchat.model.b0.f(r103) == false) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L11;
        boolean r105 = true;
    L20:
        if (r105 == true) goto L30;
        return false;
    L30:
        return true;
    L15:
        if (com.larus.bmhome.chat.bean.d.W0(r103) == true) goto L17;
        r104 = true;
    L8:
        r105 = false;
        goto L20
    L7:
        if (r101.isEmpty() == false) goto L9;
    L29:
        return true;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void A5(boolean r100) {
        U5().setTTsPlayEnable(r100);
    }

    @Override // o1a.a
    public final void C(List<? extends m1a.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "cardList");
        FLogger.f375446a.i("ComponentArch", this + " handleCards " + r100);
        ((ArrayList) this.R3).addAll(r100);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void CX(final List<Message> r110) {
        Intrinsics.checkNotNullParameter(r110, "messages");
        ICoreInputAbility r100 = T4();
        if (r100 == null) goto L6;
        r100.qp(false);
    L6:
        if (r110.size() <= 1) goto L8;
        int r101 = 18;
    L10:
        if (AppHost.f326268a.isOversea() == false) goto L16;
        LarusPageChatBinding r102 = h4();
        if (r102 == null) goto L18;
        ChatConstraintLayout r103 = r102.f311085a;
        if (r103 == null) goto L19;
        com.larus.platform.service.z1 r104 = com.larus.platform.service.z1.f365863a;
        com.larus.platform.api.b3.a.a(r103, r101, getBotId(), CollectionsKt.joinToString$default(r110, null, null, null, 0, null, new v3(this), 31, null), null, 16);
        return;
    L19:
        return;
    L18:
        return;
    L16:
        SafeExtKt.b(F2(), new w3(this, r110), 200);
        return;
    L8:
        r101 = 2;
        goto L10
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void E4(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        U5().refreshExistedMessage(r100);
    }

    public final long E5(List<Message> r110) {
        if (wi8.d.a().b() == true) goto L5;
        return -1;
    L5:
        if (r110.isEmpty() == true) goto L41;
        Bundle r100 = f1().f468086b;
        if (r100 == null) goto L14;
        String r101 = r100.getString("message_index", "-1");
        if (r101 == null) goto L14;
        Long r102 = StringsKt.toLongOrNull(r101);
        if (r102 == null) goto L14;
        long r103 = r102.longValue();
    L16:
        if (r103 != (-1)) goto L18;
        return r103;
    L18:
        Iterator<T> r111 = r110.iterator();
    L20:
        if (r111.hasNext() == false) goto L29;
        Object r104 = r111.next();
        Message r105 = (Message) r104;
        if (r105.getServerIndex() == r103) goto L24;
    L26:
        boolean r106 = false;
    L27:
        if (r106 == false) goto L20;
    L30:
        Message r107 = (Message) r104;
        if (r107 != null) goto L33;
        return -1;
    L33:
        return r107.getLocalIndex();
    L24:
        if (com.larus.bmhome.social.userchat.model.b0.f(r105) == true) goto L26;
        r106 = true;
        goto L27
    L29:
        r104 = null;
    L14:
        r103 = -1;
        goto L16
    L41:
        return -1;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void J80(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        U5().collectMessage(r100, new d(this, r100));
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void MQ(boolean r100) {
        ChatListComponentViewModel r101 = U5();
        com.larus.bmhome.chat.component.cvs.y r102 = u0();
        BotModel r103 = null;
        if (r102 == null) goto L5;
        wc9.e r104 = r102.h();
    L6:
        com.larus.bmhome.chat.component.cvs.y r105 = u0();
        if (r105 == null) goto L9;
        r103 = r105.j0();
    L9:
        r101.updateDataWithLastRound(r104, r103, Boolean.valueOf(r100));
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void N7(String r100) {
        if (F6() == true) goto L5;
        return;
    L5:
        this.A = SystemClock.elapsedRealtime() + 1000;
        this.B = 0;
        this.C = G4();
        MessageAdapter r101 = this.O;
        if (r101 == null) goto L10;
        Message r102 = (Message) CollectionsKt.firstOrNull(r101.getCurrentList());
        if (r102 == null) goto L10;
        String r103 = r102.getMessageId();
    L11:
        this.D = r103;
        FLogger.f375446a.i(this.f300905n, "start scroll to bottom intent, source=" + r100 + " latestMsgId=" + this.D);
        return;
    L10:
        r103 = null;
        goto L11
    }

    @Override // com.larus.bmhome.chat.component.list.u7, va8.p
    public final void O5(boolean r100) {
        LarusPageChatBinding r101 = h4();
        if (r101 == null) goto L8;
        ChatMessageList r102 = r101.f311098n;
        if (r102 == null) goto L9;
        com.larus.bmhome.chat.api.b0.a.b(r102, r100, 14);
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final boolean O7(String r100) {
        return U5().hasContainedMessage(r100);
    }

    public final void P7(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r100) {
        if (this.G == false) goto L14;
        this.G = false;
        int r101 = RangesKt.coerceAtLeast(r100.f314033a.size() - 1, 0);
        ChatMessageList r102 = o5();
        LinearLayoutManager r103 = null;
        if (r102 == null) goto L7;
        RecyclerView.LayoutManager r104 = r102.getLayoutManager();
    L9:
        if ((r104 instanceof LinearLayoutManager) == false) goto L11;
        r103 = (LinearLayoutManager) r104;
    L11:
        if (r103 == null) goto L15;
        r103.scrollToPositionWithOffset(r101, 0);
        return;
    L15:
        return;
    L7:
        r104 = null;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [T, com.larus.bmhome.chat.component.list.f0] */
    /* JADX WARN: Type inference failed for: r10v1, types: [T, com.larus.bmhome.chat.component.list.g0] */
    @Override // com.larus.bmhome.chat.component.list.u7
    public final void PI(final Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        final MessageAdapter r100 = this.O;
        if (r100 != null) goto L7;
        FLogger.f375446a.e(this.f300905n, "runAfterInitialMessageListReady failed, adapter is null");
        return;
    L7:
        if (q7(r100) == false) goto L10;
        r110.invoke();
        return;
    L10:
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        r102.element = new f0(r101, r100, r102, r103, r110);
        r103.element = new g0(r101, r100, r102, r103, r110);
        MediatorLiveData<List<xc8.b>> r111 = r100.K;
        Intrinsics.checkNotNullParameter(this, "<this>");
        LifecycleOwner r104 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner();
        T r105 = r102.element;
        Observer<? super Boolean> r106 = null;
        if (r105 != 0) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("listObserver");
        Observer<? super List<xc8.b>> r107 = null;
    L14:
        r111.observe(r104, r107);
        if (r101.element == true) goto L22;
        MutableLiveData<Boolean> r112 = r100.f297040y;
        Intrinsics.checkNotNullParameter(this, "<this>");
        LifecycleOwner r108 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner();
        T r109 = r103.element;
        if (r109 != 0) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("loadObserver");
    L20:
        r112.observe(r108, r106);
        return;
    L19:
        r106 = (Observer) r109;
        goto L20
    L22:
        return;
    L13:
        r107 = (Observer) r105;
        goto L14
    }

    @Override // va8.p
    public final void Py(va8.q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (r100.f553976d == this.X) goto L6;
        FLogger.f375446a.d("search_landing", "skip mark shown: stale session targetMessageId=" + r100.f553973a + ", session=" + r100.f553976d + ", currentSession=" + this.X);
        return;
    L6:
        String r101 = r100.f553973a;
        va8.q0 r102 = z60(r101);
        if (r102 != null) goto L10;
        return;
    L10:
        if (this.V != 0) goto L12;
        this.V = SystemClock.elapsedRealtime() + r102.f553975c;
    L12:
        FLogger.f375446a.d("search_landing", "mark shown targetMessageId=" + r101 + ", expireAt=" + this.V + ", durationMs=" + r102.f553975c + ", session=" + this.X);
    }

    @Override // va8.p
    public final boolean Q80(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(r100, Q5()) == false) goto L15;
        return true;
    L15:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void R7(Message r100) {
        FLogger.f375446a.i(this.f300905n, "updateInstructionVisibility");
        if (r100 != null) goto L6;
        return;
    L6:
        if (com.larus.platform.service.z2.f365865a.getInstructionEntranceShowConfig().c() == false) goto L11;
        com.larus.bmhome.instruction.g r101 = vc();
        if (r101 == null) goto L12;
        r101.SF();
        return;
    L12:
        return;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final Pair<Boolean, OnboardingActionCardData> TM(OnboardingActionCardData.CardScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        return U5().getOnBoardingActionCardData(r100);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void TP(boolean r100) {
        if (r100 == false) goto L14;
        LarusPageChatBinding r101 = h4();
        LinearLayoutManager r102 = null;
        if (r101 == null) goto L8;
        ChatMessageList r103 = r101.f311098n;
        if (r103 == null) goto L8;
        RecyclerView.LayoutManager r104 = r103.getLayoutManager();
    L10:
        if ((r104 instanceof LinearLayoutManager) == false) goto L12;
        r102 = (LinearLayoutManager) r104;
    L12:
        if (r102 == null) goto L20;
        r102.scrollToPositionWithOffset(0, 0);
        return;
    L20:
        return;
    L8:
        r104 = null;
        goto L10
    L14:
        LarusPageChatBinding r105 = h4();
        if (r105 == null) goto L22;
        ChatMessageList r106 = r105.f311098n;
        if (r106 == null) goto L23;
        com.larus.bmhome.chat.api.b0.a.a(r106, false, 0, null, null, 0, 31);
        return;
    L23:
        return;
    }

    public final boolean U6(Bundle r100) {
        if (r100 == null) goto L4;
        String r101 = r100.getString("as_container");
    L6:
        return Intrinsics.areEqual(r101, "READONLY_FORWARD_DETAIL");
    L4:
        r101 = null;
        goto L6
    }

    public final boolean V6(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (Intrinsics.areEqual(this.N3, r100) == false) goto L6;
        return true;
    }

    public final boolean W3(Function0<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (this.P0 == true) goto L5;
        return false;
    L5:
        return r100.invoke().booleanValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f300903m = r100;
    }

    public final void X3(String r100) {
        if (this.S3 == true) goto L5;
        return;
    L5:
        this.S3 = false;
        FLogger.f375446a.i("pending-unread-record", "resume record after programmatic scroll: " + r100);
    }

    public final void Y7(float r110) {
        MessageAdapter r100 = this.O;
        Integer r101 = null;
        if (r100 == null) goto L10;
        List<xc8.b> r102 = r100.z2();
        if (r102 == null) goto L10;
        List<xc8.b> r103 = r102;
        List r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L11;
        r104.add(((xc8.b) r105.next()).getMessage());
    L11:
        if (r104 != null) goto L13;
        r104 = CollectionsKt.emptyList();
    L13:
        boolean r106 = true;
        if ((!r104.isEmpty()) == false) goto L77;
        List r107 = r104;
        if ((r107 instanceof Collection) == true) goto L18;
    L20:
        Iterator r108 = r107.iterator();
    L22:
        if (r108.hasNext() == false) goto L19;
        if (((Message) r108.next()).getContentType() != 2) goto L26;
        boolean r109 = true;
    L27:
        if (r109 == true) goto L22;
        boolean r111 = false;
    L29:
        if (r111 == false) goto L77;
        ChatMessageList r112 = o5();
        if (r112 == null) goto L93;
        r112.setVisibility(0);
        com.larus.bmhome.chat.mode.e r113 = this.f300918s;
        if (r113 == null) goto L73;
        kotlinx.coroutines.flow.i1<ConversationMode> r114 = r113.Si();
        if (r114 == null) goto L73;
        ConversationMode r115 = r114.getValue();
        if (r115 == null) goto L73;
        String r116 = r115.a();
        if (r116 == null) goto L73;
        Iterator r117 = r107.iterator();
    L43:
        if (r117.hasNext() == false) goto L58;
        Message r118 = (Message) r117.next();
        Map<String, String> r119 = r118.getBusinessExt();
        if (r119 == null) goto L50;
        String r120 = r119.get("next_pulse_scene");
        if (r120 == null) goto L50;
        Integer r121 = StringsKt.toIntOrNull(r120);
        if (r121 == null) goto L50;
    L56:
        if (r121 == null) goto L43;
        r101 = r121;
    L50:
        Map<String, String> r122 = r118.getExt();
        if (r122 == null) goto L55;
        String r123 = r122.get("next_pulse_scene");
        if (r123 == null) goto L55;
        r121 = StringsKt.toIntOrNull(r123);
    L55:
        r121 = null;
    L58:
        if (r101 == null) goto L73;
        int r124 = r101.intValue();
        if (Intrinsics.areEqual(r116, "office") == false) goto L63;
        int r125 = 11;
    L65:
        if (r124 == 12) goto L69;
        if (r124 == 11) goto L69;
        boolean r126 = false;
    L70:
        if (r126 == false) goto L73;
        if (r124 == r125) goto L73;
    L74:
        if (r106 == false) goto L76;
        r110 = 0.0f;
    L76:
        r112.setAlpha(r110);
        return;
    L69:
        r126 = true;
        goto L70
    L63:
        if (Intrinsics.areEqual(r116, "chat") == false) goto L73;
        r125 = 12;
    L73:
        r106 = false;
        goto L74
    L93:
        return;
    L26:
        r109 = false;
    L19:
        r111 = true;
        goto L29
    L18:
        if (r107.isEmpty() == false) goto L20;
    L77:
        ChatMessageList r127 = o5();
        if (r127 == null) goto L95;
        r127.setVisibility(0);
        r127.setAlpha(1.0f);
        return;
    L95:
        return;
    L10:
        r104 = null;
        goto L11
    }

    public final void Z3(String r100) {
        X3("clear_target_" + r100);
        FLogger.f375446a.i("pending-unread-record", "clear target from " + r100);
        Map<String, com.larus.bmhome.chat.manager.d0> r101 = com.larus.bmhome.chat.manager.e0.f306718a;
        com.larus.bmhome.chat.manager.d0 r102 = (com.larus.bmhome.chat.manager.d0) ((LinkedHashMap) com.larus.bmhome.chat.manager.e0.f306718a).get(G4());
        if (r102 == null) goto L10;
        Message r103 = r102.f306711a;
        if (r103 == null) goto L8;
        r102.f306715e = r103.getMessageId();
        r102.f306716f = r103.getLocalMessageId();
    L8:
        r102.f306711a = null;
        r102.f306712b = 0;
        r102.f306714d = -1;
        return;
    }

    @Override // va8.p
    public final void ZN(boolean r100) {
        ChatMessageList r101 = o5();
        if (r101 == null) goto L6;
        r101.setFollowBottomOnViewportShrinkEnabled$impl_mainlandRelease(r100);
        return;
    }

    @Override // va8.p
    public final void aI(te8.c r100) {
        mA(r100);
    }

    public final void b7(String r110) {
        ChatMessageList r100 = o5();
        Boolean r101 = null;
        if (r100 == null) goto L5;
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
    L7:
        if ((r102 instanceof LinearLayoutManager) == false) goto L9;
        LinearLayoutManager r103 = (LinearLayoutManager) r102;
    L11:
        if (r103 == null) goto L13;
        int r104 = r103.findFirstVisibleItemPosition();
    L14:
        if (r103 == null) goto L16;
        int r105 = r103.findLastVisibleItemPosition();
    L17:
        if (r100 == null) goto L19;
        int r106 = r100.B();
    L20:
        FLogger r107 = FLogger.f375446a;
        StringBuilder r108 = new StringBuilder("chat_state source=");
        r108.append(r110);
        r108.append(" lifecycle=");
        Intrinsics.checkNotNullParameter(this, "<this>");
        r108.append(com.larus.ui.arch.component.internal.attach.a.b(this, this).getLifecycle().getCurrentState());
        r108.append(" childCount=");
        if (r100 == null) goto L23;
        int r111 = r100.getChildCount();
    L24:
        r108.append(r111);
        r108.append(" adapterCount=");
        MessageAdapter r112 = this.O;
        if (r112 == null) goto L27;
        int r113 = r112.getItemCount();
    L28:
        r108.append(r113);
        r108.append(" scrollState=");
        if (r100 == null) goto L31;
        int r114 = r100.getScrollState();
    L32:
        r108.append(r114);
        r108.append(" firstPos=");
        r108.append(r104);
        r108.append(" lastPos=");
        r108.append(r105);
        r108.append(" distanceToBottom=");
        r108.append(r106);
        r108.append(" reachBottom=");
        if (r100 == null) goto L35;
        Boolean r115 = Boolean.valueOf(r100.P());
    L36:
        r108.append(r115);
        r108.append(" canScrollDown=");
        if (r100 == null) goto L39;
        Boolean r116 = Boolean.valueOf(r100.canScrollVertically(1));
    L40:
        r108.append(r116);
        r108.append(" canScrollUp=");
        if (r100 == null) goto L43;
        r101 = Boolean.valueOf(r100.canScrollVertically(-1));
    L43:
        r108.append(r101);
        r108.append(" pendingUnreadEnabled=");
        r108.append(F6());
        r108.append(" hasPendingUnread=");
        r108.append(j6());
        r108.append(" programmaticActive=");
        r108.append(this.S3);
        r108.append(" deferred=");
        r108.append(this.F);
        r108.append(" scrollToBottomIntentActive=");
        r108.append(X6());
        r107.i("fast-scroll-click-chain", r108.toString());
        return;
    L39:
        r116 = null;
        goto L40
    L35:
        r115 = null;
        goto L36
    L31:
        r114 = -1;
        goto L32
    L27:
        r113 = -1;
        goto L28
    L23:
        r111 = -1;
        goto L24
    L19:
        r106 = -1;
        goto L20
    L16:
        r105 = -1;
        goto L17
    L13:
        r104 = -1;
        goto L14
    L9:
        r103 = null;
        goto L11
    L5:
        r102 = null;
        goto L7
    }

    public final void c4(String r110) {
        if (F6() == true) goto L5;
        return;
    L5:
        ChatMessageList r100 = o5();
        boolean r101 = true;
        if (r100 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L14;
        return;
    L14:
        if (X6() == false) goto L17;
        return;
    L17:
        if (C6() == true) goto L19;
        return;
    L19:
        Message r103 = h5();
        if (r103 != null) goto L23;
        return;
    L23:
        if (com.larus.bmhome.chat.bean.d.G0(r103) == false) goto L25;
        return;
    L25:
        List<Message> r104 = getCurrentList();
        if (r104 != null) goto L28;
        return;
    L28:
        Iterator<Message> r105 = r104.iterator();
        int r106 = 0;
    L30:
        if (r105.hasNext() == false) goto L35;
        if (Intrinsics.areEqual(r105.next().getLocalMessageId(), r103.getLocalMessageId()) == true) goto L36;
        r106 = r106 + 1;
    L36:
        if (r106 >= 0) goto L38;
        return;
    L38:
        Map<String, com.larus.bmhome.chat.manager.d0> r107 = com.larus.bmhome.chat.manager.e0.f306718a;
        com.larus.bmhome.chat.manager.d0 r108 = com.larus.bmhome.chat.manager.e0.a(G4());
        Integer r109 = null;
        if (r108 == null) goto L41;
        String r111 = r108.f306715e;
    L42:
        if (r111 != null) goto L44;
    L45:
        if (r108 == null) goto L47;
        String r112 = r108.f306716f;
    L48:
        if (r112 != null) goto L50;
    L52:
        if (r108 == null) goto L56;
        Message r113 = r108.f306711a;
        if (r113 == null) goto L56;
        String r114 = r113.getLocalMessageId();
    L58:
        if (Intrinsics.areEqual(r114, r103.getLocalMessageId()) == false) goto L60;
        return;
    L60:
        ChatMessageList r115 = o5();
        if (r115 == null) goto L74;
        RecyclerView.LayoutManager r116 = r115.getLayoutManager();
        if ((r116 instanceof LinearLayoutManager) == false) goto L66;
        LinearLayoutManager r117 = (LinearLayoutManager) r116;
    L67:
        if (r117 == null) goto L74;
        int r118 = r117.findFirstVisibleItemPosition();
        if (r118 == (-1)) goto L74;
        View r119 = r117.findViewByPosition(r118);
        if (r119 == null) goto L74;
        Rect r120 = new Rect();
        r119.getLocalVisibleRect(r120);
        Integer r121 = s5(r106, r118, r120.bottom);
    L76:
        if (r121 == null) goto L82;
        int r122 = r121.intValue();
        if (r108 == null) goto L80;
        int r123 = r108.f306712b;
    L81:
        r109 = Integer.valueOf(d7(r122, r123, "ensure_latest"));
        goto L82
    L80:
        r123 = 0;
    L82:
        if (r109 == null) goto L91;
        ChatMessageList r124 = o5();
        if (r124 != null) goto L86;
    L88:
        r101 = false;
    L89:
        if (r101 == false) goto L91;
        return;
    L86:
        if (r124.M(r106, r109.intValue(), k70()) != true) goto L88;
    L91:
        com.larus.bmhome.chat.manager.e0.b(G4(), r103, 0, -1);
        FLogger.f375446a.i("pending-unread-record", "ensure target from " + r110 + ", msgId=" + r103.getMessageId() + ", localId=" + r103.getLocalMessageId());
        return;
    L66:
        r117 = null;
    L74:
        r121 = null;
    L56:
        r114 = null;
        goto L58
    L50:
        if (Intrinsics.areEqual(r108.f306716f, r103.getLocalMessageId()) == false) goto L52;
        return;
    L47:
        r112 = null;
        goto L48
    L44:
        if (Intrinsics.areEqual(r108.f306715e, r103.getMessageId()) == false) goto L45;
        return;
    L41:
        r111 = null;
        goto L42
    L35:
        r106 = -1;
        goto L36
    L8:
        if (r100.P() != true) goto L10;
        r102 = true;
        goto L11
    }

    public final void c7(String r110) {
        if (F6() == true) goto L5;
        return;
    L5:
        ChatMessageList r100 = o5();
        if (r100 != null) goto L8;
        return;
    L8:
        RecyclerView.LayoutManager r101 = r100.getLayoutManager();
        Boolean r102 = null;
        if ((r101 instanceof LinearLayoutManager) == false) goto L11;
        LinearLayoutManager r103 = (LinearLayoutManager) r101;
    L12:
        if (r103 != null) goto L14;
        return;
    L14:
        View r104 = r103.getChildAt(0);
        if (r104 == null) goto L17;
        int r105 = r103.getPosition(r104);
    L18:
        if (r104 == null) goto L20;
        Rect r106 = new Rect();
        r104.getLocalVisibleRect(r106);
        int r107 = r106.bottom;
    L21:
        if (r104 == null) goto L23;
        int r111 = r104.getHeight();
    L24:
        Map<String, com.larus.bmhome.chat.manager.d0> r108 = com.larus.bmhome.chat.manager.e0.f306718a;
        com.larus.bmhome.chat.manager.d0 r109 = com.larus.bmhome.chat.manager.e0.a(G4());
        MessageAdapter r112 = this.O;
        if (r112 == null) goto L41;
        Iterator r113 = ((ArrayList) r112.getCurrentList()).iterator();
        int r114 = 0;
    L28:
        if (r113.hasNext() == false) goto L39;
        String r115 = ((Message) r113.next()).getLocalMessageId();
        if (r109 == null) goto L34;
        Message r116 = r109.f306711a;
        if (r116 == null) goto L34;
        String r117 = r116.getLocalMessageId();
    L36:
        if (Intrinsics.areEqual(r115, r117) == true) goto L40;
        r114 = r114 + 1;
    L40:
        int r118 = r114;
    L42:
        int r119 = k70();
        if (r109 == null) goto L45;
        int r120 = r109.f306712b;
    L46:
        if (r118 < 0) goto L48;
        int r121 = r100.G(r118);
    L49:
        if (r118 < 0) goto L53;
        if (r105 == (-1)) goto L53;
        if (r107 < 0) goto L53;
        Integer r122 = s5(r118, r105, r107);
    L54:
        if (r118 < 0) goto L58;
        if (r105 == (-1)) goto L58;
        if (r120 <= 0) goto L58;
        r102 = Boolean.valueOf(r100.N(r105, r107, r118, r120, r119));
    L58:
        FLogger.f375446a.i("pending-unread-scroll-click", "state source=" + r110 + " scrollState=" + r100.getScrollState() + " programmaticActive=" + this.S3 + " deferred=" + this.F + " childCount=" + r100.getChildCount() + " firstPos=" + r105 + " firstBottom=" + r107 + " firstHeight=" + r111 + " targetPos=" + r118 + " savedProgress=" + r120 + " currentProgress=" + r122 + " groupHeight=" + r121 + " listHeight=" + r119 + " distanceAtLeast=" + r102 + " reachBottom=" + r100.P());
        return;
    L53:
        r122 = null;
        goto L54
    L48:
        r121 = -1;
        goto L49
    L45:
        r120 = 0;
    L34:
        r117 = null;
        goto L36
    L39:
        r114 = -1;
        goto L40
    L41:
        r118 = -1;
        goto L42
    L23:
        r111 = -1;
        goto L24
    L20:
        r107 = -1;
        goto L21
    L17:
        r105 = -1;
        goto L18
    L11:
        r103 = null;
        goto L12
    }

    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> d4(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r110) {
        fx9.a r100 = (fx9.a) this.f300912p2.getValue();
        if (r100 == null) goto L9;
        List<xc8.b> r101 = r110.f314033a;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.add(((xc8.b) r103.next()).getMessage());
        goto L6
    L8:
        Set<Message> r104 = r100.h9(r102);
    L10:
        if (r104 != null) goto L13;
        r104 = SetsKt.emptySet();
    L13:
        if (r104.isEmpty() == true) goto L29;
        List<xc8.b> r105 = r110.f314033a;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L17:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        if (r104.contains(((xc8.b) r108).getMessage()) == true) goto L17;
        r106.add(r108);
        goto L17
    L22:
        return com.larus.bmhome.social.page.datasource.event.c.a(r110, r106, 0, null, null, 14);
    L29:
        return r110;
    L9:
        r104 = null;
        goto L10
    }

    public final Message e4(q99.e r100) {
        String r101 = r100.f532145b;
        if (r101 != null) goto L5;
        return null;
    L5:
        MessageAdapter r102 = this.O;
        if (r102 == null) goto L23;
        List<xc8.b> r103 = r102.z2();
        if (r103 == null) goto L24;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((xc8.b) r105).getMessage().getMessageId(), r101) == false) goto L11;
    L16:
        xc8.b r106 = (xc8.b) r105;
        if (r106 != null) goto L19;
        return null;
    L19:
        return r106.getMessage();
    L15:
        r105 = null;
        goto L16
    L24:
        return null;
    L23:
        return null;
    }

    public final void h7(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        MessageAdapter r102 = this.O;
        Message r103 = null;
        if (r102 == null) goto L25;
        List<xc8.b> r104 = r102.z2();
        if (r104 == null) goto L25;
        Iterator<T> r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((xc8.b) r106).getMessage().getMessageId(), r100) == false) goto L17;
    L22:
        xc8.b r107 = (xc8.b) r106;
        if (r107 == null) goto L25;
        r103 = r107.getMessage();
        goto L25
    L21:
        r106 = null;
    L25:
        if (r103 != null) goto L28;
        FLogger.f375446a.i(this.f300905n, "refreshContinuousTtsMessageActionBar skip, messageId=" + r100 + " not in current list");
        return;
    L28:
        W5(r103, r100, false);
        FLogger.f375446a.i(this.f300905n, "refreshContinuousTtsMessageActionBar, messageId=" + r100 + ", contentType=" + r103.getContentType() + ", replyId=" + r103.getReplyId());
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // va8.p
    public final void hy(te8.c r100) {
        um(r100);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void ln(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        if (r100.getBoolean("is_need_scroll_last", false) == false) goto L6;
        TP(false);
        return;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void mA(te8.c r100) {
        this.P1.remove(r100);
    }

    @Override // va8.p
    public final Fragment me(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L28
        Object r103 = getContext();     // Catch: Throwable -> L28
        if ((r103 instanceof ChatActivity) == false) goto L7;
        Fragment r104 = ((ChatActivity) r103).O1();     // Catch: Throwable -> L28
    L26:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r105) == true) goto L35;
        r101 = r105;
    L35:
        return (Fragment) r101;
    L7:
        if ((r103 instanceof com.larus.bmhome.chat.j4) == false) goto L15;
        if ((r103 instanceof FragmentActivity) == false) goto L11;
        FragmentActivity r106 = (FragmentActivity) r103;     // Catch: Throwable -> L28
    L12:
        if (r106 == null) goto L24;
        r104 = com.larus.utils.v.c(r106, ChatFragment.class);     // Catch: Throwable -> L28
    L24:
        r104 = null;
        goto L26
    L11:
        r106 = null;
        goto L12
    L15:
        if ((r103 instanceof ci8.a) == true) goto L17;
        Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Throwable -> L28
        r104 = FragmentManager.findFragment(r100);     // Catch: Throwable -> L28
        goto L26
    L17:
        if ((r103 instanceof ci8.a) == false) goto L19;
        ci8.a r107 = (ci8.a) r103;     // Catch: Throwable -> L28
    L20:
        if (r107 == null) goto L24;
        ChatMultiTabFragment r108 = r107.c1();     // Catch: Throwable -> L28
        if (r108 == null) goto L24;
        r104 = r108.S90(PageType.Chat.getType());     // Catch: Throwable -> L28
        goto L26
    L19:
        r107 = null;
    L28:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    @Override // va8.p
    public final void mi(String r100) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        if (Intrinsics.areEqual(r100, Q5()) == false) goto L6;
        this.W = true;
        this.V = 0;
        FLogger.f375446a.d("search_landing", "clear params targetMessageId=" + r100 + ", session=" + this.X);
        return;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final Integer n00(String r100) {
        return U5().getLastLikeOrDislikeMessageStatus(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v94, types: [com.larus.bmhome.chat.component.list.ChatListComponent$initMusicAuthHandler$1] */
    /* JADX WARN: Type inference failed for: r1v27, types: [com.larus.bmhome.chat.component.list.c5] */
    /* JADX WARN: Type inference failed for: r1v28, types: [com.larus.bmhome.chat.component.list.d5] */
    /* JADX WARN: Type inference failed for: r1v70, types: [com.larus.bmhome.chat.component.list.w4] */
    /* JADX WARN: Type inference failed for: r1v71, types: [com.larus.bmhome.chat.component.list.v4] */
    /* JADX WARN: Type inference failed for: r3v28, types: [com.larus.bmhome.chat.component.list.l4] */
    /* JADX WARN: Type inference failed for: r3v29, types: [com.larus.bmhome.chat.component.list.n4] */
    /* JADX WARN: Type inference failed for: r3v30, types: [com.larus.bmhome.chat.component.list.o4] */
    /* JADX WARN: Type inference failed for: r3v36, types: [com.larus.bmhome.chat.component.list.s4] */
    /* JADX WARN: Type inference failed for: r3v37, types: [com.larus.bmhome.chat.component.list.t4] */
    /* JADX WARN: Type inference failed for: r4v22, types: [com.larus.bmhome.chat.component.list.k] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r310) {
        Intrinsics.checkNotNullParameter(r310, "view");
        LarusPageChatBinding r100 = h4();
        if (r100 == null) goto L7;
        ChatMessageList r101 = r100.f311098n;
        if (r101 == null) goto L7;
        r101.setChatUniqueKey(de8.d.a(f1()));
    L7:
        LarusPageChatBinding r102 = h4();
        if (r102 == null) goto L12;
        ChatMessageList r103 = r102.f311098n;
        if (r103 == null) goto L12;
        r103.setToppingPageScopeId(R5());
    L12:
        com.larus.bmhome.chat.mode.e r104 = (com.larus.bmhome.chat.mode.e) s1a.d.a(this).getAbility(com.larus.bmhome.chat.mode.e.class);
        this.f300918s = r104;
        if (r104 == null) goto L15;
        r104.j80(this.f300922u);
    L15:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r105 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if (ChatFragment.N == true) goto L19;
        AuthModelDelegate.f297134b.c().observe(r105.getViewLifecycleOwner(), this.f300913p3);
    L19:
        Bundle r106 = f1().f468086b;
        if (r106 == null) goto L23;
        String r107 = r106.getString("notify_strategy", "");
        if (r107 == null) goto L23;
    L24:
        Bundle r108 = f1().f468086b;
        if (r108 == null) goto L28;
        String r109 = r108.getString("qst3");
        if (r109 == null) goto L28;
    L29:
        FLogger.f375446a.i(this.f300905n, "handlePushMessage: notifyStrategy = " + r107 + ", pushQST = " + r109);
        if (Intrinsics.areEqual(r107, "1") == true) goto L32;
    L46:
        LarusPageChatBinding r110 = h4();
        ViewGroup r111 = null;
        if (r110 == null) goto L59;
        ChatConstraintLayout r112 = r110.f311085a;
        if (r112 == null) goto L59;
        LarusPageChatBinding r113 = h4();
        if (r113 == null) goto L53;
        NestedScrollableContainer r114 = r113.f311099o;
    L54:
        com.larus.bmhome.chat.component.bottom.p1 r115 = (com.larus.bmhome.chat.component.bottom.p1) this.f300936y2.getValue();
        if (r115 == null) goto L57;
        View r116 = r115.bo();
    L58:
        r112.f315393n = r114;
        r112.f315394o = r116;
        goto L59
    L57:
        r116 = null;
        goto L58
    L53:
        r114 = null;
    L59:
        final LarusPageChatBinding r117 = h4();
        if (r117 == null) goto L104;
        r6 r118 = new r6(this);
        s6 r119 = new s6(this);
        ChatParam r120 = (ChatParam) this.N2.getValue();
        if (r120 != null) goto L64;
        r120 = new ChatParam(null, null, null, null, null, 255);
    L64:
        this.O = new MessageAdapter(r118, r120, new com.larus.bmhome.chat.component.list.i(this), f5(), new com.larus.bmhome.chat.component.list.j(this), this, r119);
        if (f1().C() == false) goto L69;
        MessageAdapter r121 = this.O;
        if (r121 == null) goto L69;
        r121.registerAdapterDataObserver(this.f300927v3);
    L69:
        MessageAdapter r122 = this.O;
        if (r122 == null) goto L72;
        com.larus.platform.service.m3 r123 = com.larus.platform.service.m3.f365766a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r124 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Bundle r125 = f1().f468086b;
        Intrinsics.checkNotNullParameter(this, "<this>");
        ActivityResultCaller r126 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
        r122.f297034s = r123.f(r124, r125, (by7.e) r126);
    L72:
        Intrinsics.checkNotNullParameter(this, "<this>");
        ChatMessageList.ChatLayoutManager r127 = new ChatMessageList.ChatLayoutManager(com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext(), r117.f311098n, new com.larus.bmhome.chat.component.list.k(this));
        r117.f311098n.setLayoutManager(r127);
        if (pl() == false) goto L75;
    L79:
        final ChatMessageList r128 = r117.f311098n;
        if (pl() == false) goto L82;
        final int r129 = 0;
    L83:
        r128.f315425b = r129;
        if (r128.getItemDecorationCount() <= 0) goto L86;
        r128.removeItemDecorationAt(0);
    L86:
        r128.addItemDecoration(new ChatMessageList$applyBottomInset$1(r128, r129), 0);
        r117.f311098n.setOnListTouchedCallback(new com.larus.bmhome.chat.component.list.l(this, r117));
        ChatMessageList r130 = r117.f311098n;
        Function1 r131 = new com.larus.bmhome.chat.component.list.m(this);
        r130.getClass();
        Intrinsics.checkNotNullParameter(r131, "onTouch");
        ((ArrayList) r130.M).add(r131);
        LarusPageChatBinding r132 = h4();
        if (r132 == null) goto L91;
        View r133 = r132.f311090f;
        if (r133 == null) goto L91;
        r133.setOnClickListener(new com.larus.bmhome.chat.component.list.n(this));
    L91:
        LarusPageChatBinding r134 = h4();
        if (r134 == null) goto L96;
        View r135 = r134.f311090f;
        if (r135 == null) goto L96;
        r135.setClickable(false);
    L96:
        r117.f311098n.addOnScrollListener(new ChatListComponent$setupRecycler$1$8(this, r117));
        r117.f311085a.setOnBottomInsetUpdateListener(new q6(r117, this));
        r117.f311085a.setSideBarOpen(new p(this));
        ChatMessageList r136 = r117.f311098n;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r136.setTag(R.id.tag_key_fragment, com.larus.ui.arch.component.internal.attach.a.b(this, this));
        r117.f311098n.setAdapter(this.O);
        com.larus.bmhome.chat.component.list.c r137 = this.U;
        if (r137 == null) goto L99;
        r137.f301047j = this.O;
    L99:
        BotModel r138 = j0();
        if (r138 == null) goto L102;
        String r139 = r138.getBotId();
    L103:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ChatListComponent$setupRecycler$1$11(this, r139, null), 2, null);
        goto L104
    L102:
        r139 = null;
        goto L103
    L82:
        r129 = AppHost.f326268a.getApplication().getResources().getDimensionPixelOffset(R.dimen.larus_message_item_spacing);
        goto L83
    L75:
        if (r127.getReverseLayout() != true) goto L77;
        boolean r140 = true;
    L78:
        r127.setStackFromEnd(r140);
        goto L79
    L77:
        r140 = false;
    L104:
        Bundle r141 = f1().f468086b;
        if (r141 != null) goto L107;
    L109:
        boolean r142 = false;
    L110:
        if (r142 == false) goto L124;
        Bundle r143 = f1().f468086b;
        if (r143 == null) goto L114;
        String r144 = r143.getString("conversation_fork_ext");
    L115:
        if (r144 != null) goto L117;
        r144 = "";
    L117:
        Bundle r145 = f1().f468086b;
        if (r145 == null) goto L120;
        r145.remove("conversation_fork_auto_route_reanswer");
    L120:
        Bundle r146 = f1().f468085a;
        if (r146 == null) goto L123;
        r146.remove("conversation_fork_auto_route_reanswer");
    L123:
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)), null, null, new AnonymousClass1(this, r144, null), 3, null);
        goto L124
    L114:
        r144 = null;
    L124:
        Long r147 = Long.valueOf(de8.d.a(f1()));
        if (r147.longValue() == 0) goto L127;
        boolean r148 = true;
    L128:
        if (r148 == true) goto L131;
        r147 = null;
    L131:
        if (r147 == null) goto L135;
        String r149 = "chat:" + r147.longValue();
        if (r149 == null) goto L135;
    L144:
        String r150 = r149;
    L146:
        if (r150 == null) goto L159;
        Iterator r151 = ServiceManager.get().getServices(ChatMessageListPageObserver.class).iterator();
    L149:
        if (r151.hasNext() == false) goto L159;
        ChatMessageListPageObserver r152 = (ChatMessageListPageObserver) r151.next();
        Result.Companion r153 = Result.Companion;     // Catch: Throwable -> L153
        Intrinsics.checkNotNullParameter(this, "<this>");     // Catch: Throwable -> L153
        r152.a(r150, com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner());     // Catch: Throwable -> L153
        Object r154 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L153
    L155:
        Throwable r155 = Result.m9452exceptionOrNullimpl(r154);
        if (r155 == null) goto L149;
        FLogger.f375446a.e(this.f300905n, "notify message list page observer failed, observer=".concat(r152.getClass().getSimpleName()), r155);
    L153:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        r154 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L159:
        if (W4() == false) goto L170;
        com.larus.bmhome.chat.component.list.preload.g r157 = (com.larus.bmhome.chat.component.list.preload.g) this.f300926v2.getValue();
        if (r157 == null) goto L164;
        List<xc8.b> r158 = r157.Ji();
    L165:
        com.larus.bmhome.chat.component.list.preload.g r159 = (com.larus.bmhome.chat.component.list.preload.g) this.f300926v2.getValue();
        if (r159 == null) goto L168;
        List<Message> r160 = r159.Rd();
    L169:
        U5().preloadMessages(r158, r160, new com.larus.bmhome.chat.component.list.h(this));
        goto L170
    L168:
        r160 = null;
        goto L169
    L164:
        r158 = null;
    L170:
        RepoDispatcher.f307729a.getClass();
        RepoDispatcher.f307732d.f307630b.observe(this, new t6(new o3(this)));
        if (f1().B() == false) goto L173;
    L174:
        LarusPageChatBinding r161 = h4();
        if (r161 == null) goto L179;
        ChatMessageList r162 = r161.f311098n;
        if (r162 == null) goto L179;
        ViewExtKt.n(r162, null, null, new p3(this), 3);
    L179:
        com.larus.platform.service.z2.f365865a.w3();
        ComponentViewModel.onEach$default(U5(), ChatListComponent$observeStateChange$1.INSTANCE, null, new ChatListComponent$observeStateChange$2(this, null), 2, null);
        ComponentViewModel.onEach$default(U5(), ChatListComponent$observeStateChange$3.INSTANCE, null, new ChatListComponent$observeStateChange$4(this, null), 2, null);
        a6 r163 = new a6(this);
        com.larus.bmhome.chat.component.cvs.y r164 = u0();
        if (r164 == null) goto L182;
        r164.rh(new h5(), r163);
    L182:
        com.larus.bmhome.chat.component.cvs.y r165 = u0();
        if (r165 == null) goto L185;
        r165.rh(new y(), new d6(this));
    L185:
        com.larus.bmhome.chat.component.cvs.y r166 = u0();
        if (r166 == null) goto L188;
        r166.rh(new v(), new c6());
    L188:
        com.larus.bmhome.chat.component.cvs.y r167 = u0();
        if (r167 == null) goto L191;
        r167.rh(new d0(), new b6(this));
    L191:
        com.larus.bmhome.chat.component.cvs.y r168 = u0();
        if (r168 == null) goto L194;
        r168.rh(new g5(), new z5(this));
    L194:
        com.larus.bmhome.chat.component.cvs.y r169 = u0();
        if (r169 == null) goto L197;
        r169.ll(new q(), new y5(this));
    L197:
        com.larus.bmhome.chat.component.cvs.y r170 = u0();
        if (r170 == null) goto L200;
        r170.ll(new t(), new v5(this));
    L200:
        com.larus.bmhome.chat.component.cvs.y r171 = u0();
        if (r171 == null) goto L203;
        r171.rh(new e5(), new f6(this));
    L203:
        OfflineMessageServiceDelegate.f342907b.c(f1().l(), this.f300921t3);
        com.larus.bmhome.chat.trace.l0 r172 = v4();
        LarusPageChatBinding r173 = h4();
        if (r173 == null) goto L206;
        ChatMessageList r174 = r173.f311098n;
    L207:
        r172.s(r174);
        v4().r(this.O);
        v4().x(new c5(this));
        v4().t(new d5(this));
        LarusPageChatBinding r175 = h4();
        if (r175 == null) goto L212;
        ChatMessageList r176 = r175.f311098n;
        if (r176 == null) goto L212;
        ExposureTrackerExtKt.b(r176);
    L212:
        LarusPageChatBinding r177 = h4();
        if (r177 == null) goto L217;
        ChatMessageList r178 = r177.f311098n;
        if (r178 == null) goto L217;
        ExposeXTrackerExtKt.c(r178);
    L217:
        AudioServiceDelegate r179 = AudioServiceDelegate.f288288a;
        r179.r0().m(this.F3);
        com.larus.audio.j0 r180 = r179.P();
        if (r180.g() == true) goto L227;
        IFlowSdkDepend r181 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r181 == null) goto L224;
        r181.y();
        if (com.larus.home.impl.sdk.t1.f346241a.y0() != true) goto L224;
        boolean r182 = true;
    L225:
        if (r182 == true) goto L227;
        boolean r183 = true;
    L228:
        ry8.b r184 = B4();
        if (r184 == null) goto L231;
        r184.setAudioBtnEnabled(r183);
    L231:
        com.larus.bmhome.chat.component.bottom.bottommenu.f1 r185 = k4();
        if (r185 == null) goto L234;
        r185.setAudioBtnEnabled(r183);
    L234:
        r180.j(this.H3);
        Job r186 = this.G3;
        if (r186 == null) goto L237;
        Job.DefaultImpls.cancel$default(r186, null, 1, null);
    L237:
        this.G3 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ChatListComponent$setupAiRecordingStatusObserver$1(this, null), 2, null);
        if (this.T != null) goto L240;
        this.T = new q5(this);
    L240:
        IAiChatOpenDouyinAuthService r187 = V4();
        if (r187 == null) goto L244;
        r187.j(this.T);
    L244:
        if (this.S != null) goto L248;
        this.S = new ChatListComponent$initMusicAuthHandler$1(this);
        IFlowSdkDepend r188 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r188 == null) goto L248;
        r188.K0();
        com.larus.music.i.f359475a.d(this.S);
    L248:
        IAiChatOpenDouyinAuthService r189 = V4();
        if (r189 == null) goto L251;
        r189.o(this, new x(this));
    L251:
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new ChatListComponent$setupClearSection$1(this, null), 3, null);
        U5().getContextClearSuccess().observe(this, new t6(new f5(this)));
        if (((Boolean) wi8.d.f559859b.getValue()).booleanValue() == false) goto L261;
        va8.w r190 = (va8.w) this.f300896h3.getValue();
        if (r190 == 0) goto L257;
        r190.VP(new v4(this));
    L257:
        va8.w r191 = (va8.w) this.f300896h3.getValue();
        if (r191 == 0) goto L261;
        r191.v90(new w4(this));
    L261:
        if (AppHost.f326268a.isOversea() == true) goto L340;
    L267:
        ChatMessageList r192 = o5();
        if (r192 != null) goto L270;
        FLogger.f375446a.w(this.f300905n, "[ClickInterceptor] messageList is null, skip setup");
    L274:
        IObricContinuousTalkService r193 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        if (r193 == null) goto L277;
        r193.h(this.f300909p);
    L277:
        FLogger r194 = FLogger.f375446a;
        r194.i(this.f300905n, "setupContinuousTtsMessageObserver");
        if (this.f300904m3 == null) goto L281;
    L288:
        LarusPageChatBinding r195 = h4();
        if (r195 == null) goto L347;
        ChatMessageList r196 = r195.f311098n;
        if (r196 == null) goto L348;
        final com.larus.bmhome.chat.exposure.a r197 = this.V3;
        if (r197 == null) goto L349;
        com.larus.bmhome.chat.exposure.b r198 = r197.f302982c;
        r198.getClass();
        r198.f302992f = new WeakReference(r196);
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r199 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        Intrinsics.checkNotNullParameter(r196, "recyclerView");
        Intrinsics.checkNotNullParameter(r199, "lifecycleOwner");
        r194.i("ExposureManager", "bind: recyclerView=ChatMessageList, lifecycle=" + r199.getClass().getSimpleName() + ", config=" + r197.f302980a);
        TriggerCoordinator r200 = r197.f302984e;
        r200.getClass();
        Intrinsics.checkNotNullParameter(r196, "recyclerView");
        r200.f302973g = r196;
        r196.addOnScrollListener(r200.f302975i);
        RecyclerView.Adapter r201 = r196.getAdapter();
        if (r201 == null) goto L297;
        r201.registerAdapterDataObserver(r200.f302976j);
    L297:
        r199.getLifecycle().addObserver(r197.f302984e);
        r196.setRecyclerListener(new ue8.h(r197));
        if (com.larus.platform.service.g0.f365740a.f() == false) goto L322;
        FragmentActivity r202 = s1a.a.getActivity(this);
        Intrinsics.checkNotNullParameter(r202, "activity");
        ue8.f r203 = r197.f302985f;
        if (r203 != null) goto L302;
    L304:
        boolean r204 = false;
    L305:
        if (r204 == true) goto L351;
        ue8.f r205 = new ue8.f(r202);
        Intrinsics.checkNotNullParameter(r197, "manager");
        if (r205.f549814c == true) goto L321;
        r205.f549814c = true;
        final ue8.f.a r206 = new ue8.f.a(r205.f549812a);
        r206.setManager(r197);
        r205.f549813b = r206;
        FrameLayout.LayoutParams r207 = new FrameLayout.LayoutParams(-1, -1);
        View r208 = r205.f549812a.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L316;
        r194.i("DecorViewLancet", "getDecorView");
        Thread r209 = ThreadMethodProxy.currentThread();
        if (r209 == com.larus.home.impl.utils.c.f346341a) goto L316;
        com.larus.home.impl.utils.c.a(r209, "getDecorView");
    L316:
        if ((r208 instanceof ViewGroup) == false) goto L318;
        r111 = (ViewGroup) r208;
    L318:
        if (r111 == null) goto L321;
        r111.addView(r206, r207);
        r206.setClickable(false);
        r206.setFocusable(false);
        r206.post(new ue8.e(r206));
    L321:
        r197.f302985f = r205;
        return;
    L351:
        return;
    L302:
        if (r203.f549814c != true) goto L304;
        r204 = true;
        goto L305
    L322:
        ue8.f r210 = r197.f302985f;
        if (r210 != null) goto L325;
    L336:
        r197.f302985f = null;
        return;
    L325:
        if (r210.f549814c == false) goto L336;
        r210.f549814c = false;
        ue8.f.a r211 = r210.f549813b;
        if (r211 == null) goto L335;
        ViewParent r212 = r211.getParent();
        if ((r212 instanceof ViewGroup) == false) goto L332;
        ViewGroup r213 = (ViewGroup) r212;
    L333:
        if (r213 == null) goto L335;
        r213.removeView(r211);
        goto L335
    L332:
        r213 = null;
    L335:
        r210.f549813b = null;
        goto L336
    L349:
        return;
    L348:
        return;
    L347:
        return;
    L281:
        if (com.larus.platform.service.z2.f365865a.getGlobalFeedbackConfig().getFeedbackEnable() == false) goto L288;
        FlowFeedbackServiceDelegate r214 = FlowFeedbackServiceDelegate.f343027a;
        String r1100 = String.valueOf(f1().l());
        String r215 = G4();
        if (r215 != null) goto L286;
        String r1101 = "";
    L287:
        this.f300904m3 = r214.e(new q99.i(r1100, "im", r1101, null, new l4(this), new n4(this), new o4(this), new p4(this), new q4(this), CollectionsKt.listOf(new String[]{"chat", "immersive"}), NotificationBusiness.IM_MSG_FEEDBACK, new r4(this), new s4(this), new t4(), new u4(this), new l5(this), 4104));
        goto L288
    L286:
        r1101 = r215;
        goto L287
    L270:
        Intrinsics.checkNotNullParameter(this, "<this>");
        final ss8.g r216 = (ss8.g) s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this)).getAbility(ss8.g.class);
        if (r216 != null) goto L273;
        FLogger.f375446a.w(this.f300905n, "[ClickInterceptor] IChatUIBlockAbility is null, skip setup");
        goto L274
    L273:
        FLogger.f375446a.i(this.f300905n, "[ClickInterceptor] setup OK, ability=" + r216);
        r192.addOnChildAttachStateChangeListener(new ChatListComponent$setupMessageClickInterceptor$childListener$1(r216, this));
        r216.ds(new n6(this, r192));
        goto L274
    L340:
        PackageInfo r217 = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);     // Catch: Exception -> L265
        long r218 = r217.firstInstallTime;     // Catch: Exception -> L265
        long r219 = r217.lastUpdateTime;     // Catch: Exception -> L265
        FLogger.f375446a.i(this.f300905n, "setupDolaTips firstInstallTime=" + r218 + ", lastUpdateTime=" + r219);     // Catch: Exception -> L265
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatListComponent$setupDolaTips$1(this, r219, r218, null), 3, null);     // Catch: Exception -> L265
    L265:
        e = move-exception;
        FLogger.f375446a.e(this.f300905n, "setupDolaTips error e=" + e.getMessage());
    L224:
        r182 = false;
    L227:
        r183 = false;
        goto L228
    L206:
        r174 = null;
        goto L207
    L173:
        if (z5() == (-1)) goto L179;
    L135:
        Long r220 = Long.valueOf(f1().l());
        if (r220.longValue() <= 0) goto L138;
        boolean r221 = true;
    L139:
        if (r221 == true) goto L142;
        r220 = null;
    L142:
        if (r220 == null) goto L145;
        r149 = "session:" + r220.longValue();
        goto L144
    L145:
        r150 = null;
        goto L146
    L138:
        r221 = false;
        goto L139
    L127:
        r148 = false;
        goto L128
    L107:
        if (r141.getBoolean("conversation_fork_auto_route_reanswer", false) != true) goto L109;
        r142 = true;
        goto L110
    L32:
        if (r109.length() != 0) goto L34;
        boolean r222 = true;
    L35:
        if (r222 == false) goto L46;
        Bundle r223 = f1().f468086b;
        if (r223 == null) goto L40;
        String r224 = r223.getString("group_id", "");
        if (r224 == null) goto L40;
    L41:
        String r225 = AccountService.f365697a.getUserId();
        if (com.larus.utils.o0.d(r224) == false) goto L46;
        if (com.larus.utils.o0.d(r225) == false) goto L46;
        U5().requirePushContent(r224, r225);
    L40:
        r224 = "";
        goto L41
    L34:
        r222 = false;
    L28:
        r109 = "";
    L23:
        r107 = "";
        goto L24
    }

    @Override // va8.p
    public final void rW(final Function1<? super MotionEvent, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onTouch");
        ChatMessageList r101 = o5();
        if (r101 == null) goto L6;
        Function1 r102 = new a0(r100);
        Intrinsics.checkNotNullParameter(r102, "onTouch");
        ((ArrayList) r101.M).add(r102);
        return;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void tJ(boolean r100) {
        LarusPageChatBinding r101 = h4();
        if (r101 == null) goto L8;
        View r102 = r101.f311090f;
        if (r102 == null) goto L9;
        r102.setClickable(r100);
        return;
    L9:
        return;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void tU(int r100) {
        LarusPageChatBinding r101 = h4();
        if (r101 == null) goto L8;
        ChatMessageList r102 = r101.f311098n;
        if (r102 == null) goto L9;
        r102.setPaddingRelative(0, 0, 0, r100);
        return;
    L9:
        return;
    }

    @Override // va8.p
    public final void ud(va8.q0 r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (r100.f553976d == this.X) goto L6;
        FLogger.f375446a.d("search_landing", "skip clear params: stale session targetMessageId=" + r100.f553973a + ", session=" + r100.f553976d + ", currentSession=" + this.X);
        return;
    L6:
        mi(r100.f553973a);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void um(te8.c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.P1.contains(r100) == true) goto L9;
        this.P1.add(r100);
        return;
    }

    @Override // va8.p
    public final void v60(xf8.g r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ((ArrayList) this.Q3).add(r100);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void vv(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        U5().hideMessage(r100);
    }

    public final void w7(String r100) {
        ChatMessageList r101 = o5();
        if (r101 != null) goto L6;
        return;
    L6:
        if (X6() == true) goto L9;
        return;
    L9:
        if (this.E == null) goto L11;
        return;
    L11:
        h r102 = new h(this, r100);
        this.E = r102;
        r101.getViewTreeObserver().addOnPreDrawListener(r102);
        ChatMessageList r103 = o5();
        if (r103 == null) goto L16;
        r103.postOnAnimation(new com.larus.bmhome.chat.component.list.g(this, r103));
        return;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void wt(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        U5().deletePluginAuth(r100);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void ye(boolean r110) {
        com.larus.platform.service.z2.f365865a.w3();
        com.larus.bmhome.chat.api.e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        boolean r101 = false;
        if (r100 == null) goto L7;
        LaunchInfo r102 = r100.f297186a;
        if (r102 == null) goto L7;
        boolean r103 = Intrinsics.areEqual(r102.b0(), Boolean.TRUE);
    L8:
        if (r103 == false) goto L12;
        FLogger.f375446a.i(this.f300905n, "checkOnBoardingTTS check fail, disable_auto_tts");
        return;
    L12:
        if (((Boolean) this.K.getValue()).booleanValue() == true) goto L15;
        FLogger.f375446a.i(this.f300905n, "checkOnBoardingTTS check fail, audio disable");
        return;
    L15:
        AccountService r104 = AccountService.f365697a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (r104.i(com.larus.ui.arch.component.internal.attach.a.b(this, this)) == false) goto L19;
        FLogger.f375446a.i(this.f300905n, "checkOnBoardingTTS check fail, force bind dialog show");
        return;
    L19:
        boolean r105 = Intrinsics.areEqual(f1().k(), "slide_in_immersive");
        boolean r106 = VoiceCallConfigServiceDelegate.f377084b.l();
        FLogger r107 = FLogger.f375446a;
        r107.i(this.f300905n, "fromSlide: " + r105 + ", isCalling: " + r106);
        if (r106 == false) goto L24;
        if (r105 == true) goto L24;
        r107.i(this.f300905n, "checkOnBoardingTTS check fail, is calling");
        return;
    L24:
        if (r106 == true) goto L30;
        if (r105 == true) goto L30;
        if (AudioServiceDelegate.f288288a.n(j0()) == false) goto L30;
        r107.i(this.f300905n, "checkOnBoardingTTS check fail, call bot disable");
        return;
    L30:
        Bundle r108 = f1().f468085a;
        if (r108 != null) goto L33;
    L35:
        boolean r109 = false;
    L36:
        if (r109 == false) goto L39;
        r107.i(this.f300905n, "checkOnBoardingTTS check fail, disable by args");
        return;
    L39:
        AudioServiceDelegate.f288288a.i0().b(G4());
        String r111 = getBotId();
        String r112 = "";
        if (r111 != null) goto L42;
        r111 = "";
    L42:
        wc9.e r113 = R4();
        if (Intrinsics.areEqual(this.O3, r111) == false) goto L46;
        if (r110 == false) goto L46;
        boolean r114 = true;
    L47:
        List<Message> r115 = this.V0;
        if (r115 != null) goto L50;
    L53:
        boolean r116 = true;
    L54:
        ry8.b r117 = B4();
        if (r117 == null) goto L57;
        com.larus.platform.api.g0 r118 = r117.C5();
    L58:
        if (r118 != null) goto L60;
        boolean r119 = true;
    L61:
        if (r114 == true) goto L156;
        if (r116 == true) goto L156;
        if (r119 == true) goto L156;
        List<Message> r120 = this.V0;
        if (r120 != null) goto L69;
        Message r121 = null;
    L100:
        if (r121 != null) goto L102;
        return;
    L102:
        String r122 = r121.getContent();
        if (r122 != null) goto L105;
    L108:
        boolean r123 = true;
    L109:
        if (r123 == false) goto L112;
        FLogger.f375446a.i(this.f300905n, "checkOnBoardingTTS check fail, msgContentEmpty: " + r123);
        return;
    L112:
        this.O3 = r111;
        if (r113 != null) goto L115;
    L117:
        boolean r124 = false;
    L118:
        if (r124 == true) goto L120;
    L122:
        boolean r125 = false;
    L123:
        if (r125 == true) goto L125;
    L127:
        Keva r126 = vc8.e.f554133a;
        String r127 = this.f300905n;
        MessageTag r128 = com.larus.bmhome.chat.bean.d.D(r121);
        String r129 = r121.getMessageId();
        if (r129 == null) goto L131;
        r112 = r129;
    L131:
        Intrinsics.checkNotNullParameter(r127, "tag");
        Intrinsics.checkNotNullParameter(r111, "botId");
        Intrinsics.checkNotNullParameter(r128, "onBoarding");
        Intrinsics.checkNotNullParameter(r112, RemoteMessageConst.MSGID);
        int r130 = vc8.e.a.f554134a[r128.ordinal()];
        if (r130 != 1) goto L134;
        vc8.e.a(r111);
        r101 = true;
    L140:
        List<Message> r131 = this.V0;
        if (r131 == null) goto L167;
        ListIterator<Message> r132 = r131.listIterator(r131.size());
    L144:
        if (r132.hasPrevious() == false) goto L148;
        Message r133 = r132.previous();
        if ((!com.larus.bmhome.social.userchat.model.b0.f(r133)) == false) goto L144;
    L149:
        Message r134 = r133;
        if (r134 != null) goto L152;
        return;
    L152:
        if (com.larus.bmhome.chat.bean.d.z0(r134) == false) goto L169;
        if (r101 == false) goto L170;
        f2a.c r135 = this.L1.b("[TTS] start OnBoarding TTS");
        r135.f475230c.f475254b = CollectionsKt.listOf("TtsPlay");
        r135.d(MapsKt.mapOf(TuplesKt.to(f2a.f.f475239i, r134)));
        f2a.c.c(r135, null, 15);
        LifecycleCoroutineScope r136 = LifecycleOwnerKt.getLifecycleScope(this);
        RepoDispatcher.f307729a.getClass();
        BuildersKt.launch$default(r136, RepoDispatcher.f307730b, null, new ChatListComponent$startTTS$1(this, r134, null), 2, null);
        return;
    L170:
        return;
    L169:
        return;
    L148:
        r133 = null;
        goto L149
    L167:
        return;
    L134:
        if (r130 != 2) goto L136;
    L138:
        FLogger.f375446a.i(r127, "checkOnBoardingTTS type:" + r128 + ", switch is off");
        goto L140
    L136:
        if (r130 == 3) goto L138;
        FLogger.f375446a.i(r127, "checkOnBoardingTTS type:" + r128 + ", onBoarding is invalid");
        goto L140
    L125:
        if (com.larus.bmhome.chat.bean.d.k0(r121) == false) goto L127;
        FLogger.f375446a.i(this.f300905n, "FirstMeet and subConversation not onBoarding");
        return;
    L120:
        if (com.larus.bmhome.utils.i.f(r113) == false) goto L122;
        r125 = true;
        goto L123
    L115:
        if (ic8.n.D(r113) != true) goto L117;
        r124 = true;
        goto L118
    L105:
        if (r122.length() == 0) goto L108;
        r123 = false;
        goto L109
    L69:
        if (r120.size() >= 20) goto L83;
        ArrayList r137 = new ArrayList();
        Iterator<T> r138 = r120.iterator();
    L72:
        if (r138.hasNext() == false) goto L81;
        Object r139 = r138.next();
        Message r140 = (Message) r139;
        if (r140.getContentType() != 2) goto L76;
    L78:
        boolean r141 = false;
    L79:
        if (r141 == false) goto L72;
        r137.add(r139);
        goto L72
    L76:
        if (com.larus.bmhome.social.userchat.model.b0.f(r140) == true) goto L78;
        r141 = true;
        goto L79
    L81:
        r120 = CollectionsKt.sortedWith(r137, new o5());
    L83:
        if (r120.size() <= 1) goto L94;
        Message r142 = (Message) CollectionsKt.firstOrNull(r120);
        long r143 = 0;
        if (r142 == null) goto L88;
        long r144 = r142.getLocalIndex();
    L89:
        Message r145 = (Message) CollectionsKt.lastOrNull(r120);
        if (r145 == null) goto L93;
        r143 = r145.getLocalIndex();
    L93:
        if (r144 < r143) goto L94;
        boolean r146 = false;
    L96:
        if (r146 == false) goto L98;
        Object r147 = CollectionsKt.lastOrNull(r120);
    L99:
        r121 = (Message) r147;
        goto L100
    L98:
        r147 = CollectionsKt.firstOrNull(r120);
        goto L99
    L88:
        r144 = 0;
    L94:
        r146 = true;
    L156:
        String r148 = this.f300905n;
        StringBuilder r149 = new StringBuilder("checkOnBoardingTTS check fail, ");
        r149.append("botIdChecked: " + r114 + ", ");
        r149.append("msgListEmpty: " + r116 + ", ");
        StringBuilder r150 = new StringBuilder("titleBarIsNull: ");
        r150.append(r119);
        r149.append(r150.toString());
        Unit r151 = Unit.INSTANCE;
        r107.i(r148, r149.toString());
        return;
    L60:
        r119 = false;
        goto L61
    L57:
        r118 = null;
        goto L58
    L50:
        if (r115.isEmpty() == true) goto L53;
        r116 = false;
    L46:
        r114 = false;
        goto L47
    L33:
        if (r108.getBoolean("disable_onboarding_tts") != true) goto L35;
        r109 = true;
    L7:
        r103 = false;
        goto L8
    }

    @Override // va8.p
    public final va8.q0 z60(String r210) {
        boolean r100 = com.larus.platform.exp.h.f365384a;
        if (r100 == false) goto L5;
    L7:
        String r101 = Q5();
        if (r101 != null) goto L11;
        return null;
    L11:
        if (Intrinsics.areEqual(r210, r101) == true) goto L13;
        return null;
    L13:
        if (r100 == false) goto L18;
        if (((Boolean) this.f300934y.getValue()).booleanValue() == true) goto L18;
        return null;
    L18:
        if (this.W == false) goto L21;
        FLogger.f375446a.d("search_landing", "skip params: dismissed targetMessageId=".concat(r101));
        return null;
    L21:
        String r102 = I5();
        if (r102.length() != 0) goto L24;
        boolean r103 = true;
    L25:
        if (r103 == false) goto L28;
        FLogger.f375446a.d("search_landing", "skip params: highlight empty targetMessageId=".concat(r101));
        return null;
    L28:
        long r104 = SystemClock.elapsedRealtime();
        long r110 = this.V;
        if (r110 > 0) goto L31;
    L34:
        if (r110 <= 0) goto L36;
        long r105 = RangesKt.coerceAtLeast(r110 - r104, 0);
    L39:
        FLogger r111 = FLogger.f375446a;
        StringBuilder r112 = new StringBuilder("provide params targetMessageId=");
        r112.append(r101);
        r112.append(", keyword=");
        String r106 = StringsKt.replace$default(StringsKt.replace$default(r102, "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (r106.length() <= 32) goto L43;
        r106 = StringsKt.take(r106, 32) + "...";
    L43:
        r112.append(r106);
        r112.append(", durationMs=");
        r112.append(r105);
        r112.append(", expireAt=");
        r112.append(this.V);
        r112.append(", session=");
        r112.append(this.X);
        r111.d("search_landing", r112.toString());
        return new va8.q0(r101, r102, r105, this.X);
    L36:
        if (r100 == false) goto L38;
        r105 = ((Number) this.f300938z.getValue()).longValue();
        goto L39
    L38:
        r105 = com.larus.platform.service.z2.f365865a.W2();
        goto L39
    L31:
        if (r104 <= r110) goto L34;
        this.W = true;
        FLogger.f375446a.d("search_landing", "skip params: expired targetMessageId=".concat(r101));
        return null;
    L24:
        r103 = false;
        goto L25
    L5:
        if (com.larus.platform.service.z2.f365865a.B3() == true) goto L7;
        return null;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void zZ(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        U5().cancelCollectMessage(r100, new c(this, r100));
    }

    public static final void B3(ChatListComponent r100, boolean r101) {
        r100.getClass();
        FLogger.f375446a.i(ChatListComponentViewModel.LOCATION_TAG, "request loc permission result: " + r101);
        com.larus.platform.service.l1 r102 = com.larus.platform.service.l1.f365760a;
        if (r102.c() == false) goto L5;
        r100.U5().onLocationPermission(r101, new ChatListComponent$handleLocationPermissionResult$1(r100), new ChatListComponent$handleLocationPermissionResult$2(r100));
        return;
    L5:
        r102.d(s1a.a.getActivity(r100));
    }

    public static final void H3(ChatListComponent r100, Message r101) {
        r100.getClass();
        FLogger.f375446a.i(r100.f300905n, "tryRequestLocationAuthMessage: message = " + r101);
        r100.U5().tryRequestNewLocationAuthMessage(r101);
    }

    public static long T5(List r100, long r101) {
        if (wi8.d.a().b() == true) goto L5;
        return -1;
    L5:
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L18;
        Object r103 = r102.next();
        Message r104 = (Message) r103;
        if (com.larus.bmhome.social.userchat.model.b0.f(r104) == false) goto L11;
    L15:
        boolean r105 = false;
    L16:
        if (r105 == false) goto L7;
    L19:
        Message r106 = (Message) r103;
        if (r106 != null) goto L22;
        return -1;
    L22:
        ArrayList r107 = (ArrayList) r100;
        int r108 = r107.indexOf(r106) + 1;
        int r109 = r107.size();
    L23:
        if (r108 >= r109) goto L34;
        Message r110 = (Message) ListProtector.get(r100, r108);
        if (com.larus.bmhome.social.userchat.model.b0.f(r110) == true) goto L34;
        if (com.larus.bmhome.chat.bean.d.G0(r110) == true) goto L34;
        if (Intrinsics.areEqual(r110.getSenderId(), r106.getSenderId()) == false) goto L34;
        if (r110.getServerIndex() <= r101) goto L34;
        r108 = r108 + 1;
        r106 = r110;
    L34:
        return r106.getLocalIndex();
    L11:
        if (com.larus.bmhome.chat.bean.d.G0(r104) == true) goto L15;
        if (r104.getServerIndex() <= r101) goto L15;
        r105 = true;
        goto L16
    L18:
        r103 = null;
        goto L19
    }

    public static final void h3(ChatListComponent r100, com.larus.bmhome.social.page.datasource.event.c r110) {
        Job r101 = r100.f300910p0;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        r100.f300910p0 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new ChatListComponent$createRecoverAction$1(r100, r110, null), 3, null);
    }

    public static /* synthetic */ void j7(ChatListComponent r100, KeepScreenOnReplyTrigger r101) {
        r100.i7(r101, null, null, null, null);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void Bm(Message r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "text");
        U5().updateMessageContent(r100, r101);
    }

    public final void E7(int r100, boolean r101) {
        if (r101 == false) goto L6;
        ChatMessageList r102 = o5();
        if (r102 == null) goto L9;
        r102.f0(r100);
    L9:
        ChatMessageList r103 = o5();
        if (r103 == null) goto L12;
        r103.setBottomReached(false);
    L12:
        U1();
        return;
    L6:
        ChatMessageList r104 = o5();
        if (r104 == null) goto L9;
        r104.e(r100);
        goto L9
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void Mf(final Message r100, final Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ICoreInputAbility r102 = T4();
        if (r102 == null) goto L5;
        r102.qp(false);
    L5:
        SafeExtKt.b(F2(), new p0(this, r100, r101), 200);
        U5().onDislikeMessage(r100);
    }

    @Override // va8.p
    public final boolean S3(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "localMessageId");
        MessageAdapter r102 = this.O;
        if (r102 == null) goto L5;
        r102.S3(r100, r101);
        return true;
    L5:
        return false;
    }

    public final void U7(List<Message> r100, KeepScreenOnReplyTrigger r101) {
        if (com.larus.platform.exp.h.f365384a == true) goto L5;
        boolean r102 = com.larus.platform.service.z2.f365865a.enableKeepScreenOnReply();
    L6:
        int r103 = 0;
        if (r100 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        boolean r105 = x6();
        if (r102 == false) goto L25;
        if (r105 == false) goto L25;
        if (r104 == false) goto L25;
        if (this.f300935y1 == false) goto L20;
        return;
    L20:
        this.f300935y1 = true;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("acquire trigger=");
        r107.append(r101.getValue());
        r107.append(" enabled=");
        r107.append(r102);
        r107.append(" supported=");
        r107.append(r105);
        r107.append(" replying=");
        r107.append(r104);
        r107.append(" messages=");
        if (r100 == null) goto L23;
        r103 = r100.size();
    L23:
        r107.append(r103);
        r107.append(" ownerHash=");
        r107.append(this.f300931x1.hashCode());
        r106.i("KeepScreenOnReply", r107.toString());
        fa9.e.f476067a.a("reply", this.f300931x1);
        return;
    L25:
        Boolean r108 = Boolean.valueOf(r102);
        Boolean r109 = Boolean.valueOf(r105);
        Boolean r110 = Boolean.valueOf(r104);
        if (r100 == null) goto L28;
        r103 = r100.size();
    L28:
        i7(r101, r108, r109, r110, Integer.valueOf(r103));
        return;
    L9:
        if (m6(r100) != true) goto L11;
        r104 = true;
        goto L12
    L5:
        r102 = this.f300930x;
        goto L6
    }

    public final void V3(List<Message> r100, String r101) {
        if (com.larus.platform.service.z2.f365865a.G1() == true) goto L6;
        return;
    L6:
        if (this.P0 == false) goto L8;
        return;
    L8:
        if (V6(r101) == false) goto L11;
        return;
    L11:
        if (G7() == false) goto L13;
    L15:
        Iterator<T> r102 = r100.iterator();
    L17:
        if (r102.hasNext() == false) goto L28;
        Object r103 = r102.next();
        Message r104 = (Message) r103;
        if (Intrinsics.areEqual(r104.getConversationId(), r101) == true) goto L21;
    L25:
        boolean r105 = false;
    L26:
        if (r105 == false) goto L17;
    L29:
        Message r106 = (Message) r103;
        if (r106 != null) goto L32;
        return;
    L32:
        this.N3 = r101;
        this.M3 = false;
        FLogger.f375446a.i(this.f300905n, "cancel red dot entry anchor because reply is in progress, conversationId=" + r101 + ", messageId=" + r106.getMessageId());
        return;
    L21:
        if (com.larus.bmhome.chat.bean.d.G0(r104) == true) goto L25;
        if (W6(r104) == false) goto L25;
        r105 = true;
        goto L26
    L28:
        r103 = null;
        goto L29
    L13:
        if (this.M3 == true) goto L15;
    }

    public final void Y6(Message r100, boolean r101) {
        PendingAppletActionCancellation.f309941a.getClass();
        if (PendingAppletActionCancellation.b(r100) == false) goto L6;
        FLogger.f375446a.i(ChatListComponentViewModel.LOCATION_TAG, "skip cancelled location request, messageId[" + r100.getMessageId() + ']');
        return;
    L6:
        com.larus.platform.service.l1.f365760a.a(LocateScene.MSG_NEED_LOC, new e(r100, this, r101));
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void Y70(Message r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        ChatListComponentViewModel r102 = U5();
        wc9.e r103 = R4();
        if (r103 == null) goto L6;
        String r104 = r103.B;
        if (r104 == null) goto L6;
    L7:
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r102.cancelDislikeMessage(r100, r101, r104, p7(r101));
        return;
    L6:
        r104 = r100.getSectionId();
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void fh(final Message r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        ChatListComponentViewModel r102 = U5();
        wc9.e r103 = R4();
        if (r103 == null) goto L6;
        String r104 = r103.B;
        if (r104 == null) goto L6;
    L7:
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r102.cancelLikeMessage(r100, r101, r104, p7(r101), new m0(r100));
        return;
    L6:
        r104 = r100.getSectionId();
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void iE(List<Message> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "messages");
        U5().updateQaCollectState(r100, r101);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void kx(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "targetMsgId");
        MessageAdapter r100 = this.O;
        boolean r101 = false;
        if (r100 == null) goto L16;
        List<xc8.b> r102 = r100.z2();
        if (r102 == null) goto L16;
        Iterator<xc8.b> r103 = r102.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(r103.next().getMessage().getMessageId(), r110) == true) goto L14;
        r104 = r104 + 1;
    L14:
        if (r104 < 0) goto L16;
        r101 = true;
        E7(r104, true);
        goto L16
    L13:
        r104 = -1;
    L16:
        if (r101 == true) goto L22;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatListComponent$scrollToMessage$3(this, r110, r111, true, null), 3, null);
        return;
    }

    @Override // va8.p
    public final boolean l3(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        MessageAdapter r102 = this.O;
        if (r102 == null) goto L5;
        r102.l3(r100, r101);
        return true;
    L5:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void lB(String r100, ic8.p0 r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "recordCardData");
        U5().updateLocalRecordMessage(r100, r101);
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void pe(String r100, ic8.p0 r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "recordCardData");
        U5().updateRemoteRecordMessage(r100, r101);
    }

    public final void v7(final String r100, Function0<Unit> r101) {
        if (F6() == true) goto L6;
    L12:
        r101.invoke();
        final ChatMessageList r102 = o5();
        if (r102 == null) goto L17;
        r102.postDelayed(new l1(r102, this, r100), 300);
        return;
    L17:
        return;
    L6:
        if (j6() == false) goto L12;
        if (this.S3 == true) goto L11;
        FLogger.f375446a.i("pending-unread-record", "suppress record from programmatic scroll: ".concat(r100));
    L11:
        this.S3 = true;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void vk(boolean r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "valueBeforeSet");
        ChatMessageList r102 = o5();
        if (r102 != null) goto L5;
        return;
    L5:
        r101.invoke(Boolean.valueOf(r102.getClipToPadding()));
        r102.setClipToPadding(r100);
    }

    @Override // va8.p
    public final boolean x7(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        MessageAdapter r102 = this.O;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.x7(r100, 1);
    }

    public static final void E3(ChatListComponent r100, int r101, View r102) {
        if ((r102 instanceof ViewGroup) == true) goto L6;
        FLogger.f375446a.d(r100.f300905n, "[ClickInterceptor] child is not ViewGroup: ".concat(r102.getClass().getSimpleName()));
        return;
    L6:
        if (r102.getTag(r101) != null) goto L11;
        ViewGroup r103 = (ViewGroup) r102;
        View r104 = new View(r103.getContext());
        ConstraintLayout.LayoutParams r105 = new ConstraintLayout.LayoutParams(0, 0);
        r105.topToTop = 0;
        r105.bottomToBottom = 0;
        r105.startToStart = 0;
        r105.endToEnd = 0;
        r104.setLayoutParams(r105);
        r104.setClickable(true);
        r104.setFocusable(true);
        r104.setElevation(100.0f);
        r103.addView(r104);
        r102.setTag(r101, r104);
        FLogger.f375446a.i(r100.f300905n, "[ClickInterceptor] added overlay to child: " + r102.getClass().getSimpleName() + '@' + Integer.toHexString(r102.hashCode()));
        return;
    }

    public static final void G3(int r100, ChatListComponent r101, View r102) {
        if ((r102 instanceof ViewGroup) == false) goto L13;
        Object r103 = r102.getTag(r100);
        if ((r103 instanceof View) == false) goto L8;
        View r104 = (View) r103;
    L9:
        if (r104 == null) goto L14;
        ((ViewGroup) r102).removeView(r104);
        r102.setTag(r100, null);
        FLogger.f375446a.i(r101.f300905n, "[ClickInterceptor] removed overlay from child: " + r102.getClass().getSimpleName() + '@' + Integer.toHexString(r102.hashCode()));
        return;
    L14:
        return;
    L8:
        r104 = null;
        goto L9
    }

    public static final void p3(ChatListComponent r100, Message r101, CreditInfoScene r110) {
        if (r100.f300917r3.get(r101.getMessageId()) != null) goto L13;
        Map<String, String> r102 = r101.getExt();
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.containsKey("credit_order_id") != true) goto L9;
    L10:
        if (r103 == false) goto L14;
        r100.f300917r3.put(r101.getMessageId(), Boolean.TRUE);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new ChatListComponent$getCreditInfoWhenMsgChanged$1(r110, null), 3, null);
        return;
    L14:
        return;
    L9:
        r103 = false;
        goto L10
    }

    public static final Object z3(ChatListComponent r110, String r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof ChatListComponent$getCurrentBotType$1) == false) goto L7;
        ChatListComponent$getCurrentBotType$1 r100 = (ChatListComponent$getCurrentBotType$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ChatListComponent$getCurrentBotType$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        int r105 = -1;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L41:
        BotModel r114 = (BotModel) r113;
        if (r114 == null) goto L47;
        Integer r115 = r114.getBotType();
        if (r115 == null) goto L47;
        r105 = r115.intValue();
    L47:
        return Boxing.boxInt(r105);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        Bundle r116 = r110.f1().f468086b;
        if (r116 == null) goto L17;
        Integer r117 = Boxing.boxInt(r116.getInt("argBotType", Integer.MIN_VALUE));
    L18:
        if (r117 != null) goto L20;
    L22:
        if (r111 != null) goto L24;
    L27:
        boolean r118 = true;
    L28:
        if (r118 == false) goto L31;
        return Boxing.boxInt(-1);
    L31:
        if (Intrinsics.areEqual(r110.getBotId(), r111) == false) goto L38;
        BotModel r119 = r110.j0();
        if (r119 == null) goto L50;
        Integer r120 = r119.getBotType();
        if (r120 == null) goto L50;
        r105 = r120.intValue();
    L50:
        return Boxing.boxInt(r105);
    L38:
        RepoDispatcher.f307729a.getClass();
        BotRepo r106 = RepoDispatcher.f307735g;
        r102.label = 1;
        r113 = IBotRepoService.b.a(r106, r111, false, null, false, r102, 30);
        if (r113 != r103) goto L41;
        return r103;
    L24:
        if (r111.length() == 0) goto L27;
        r118 = false;
        goto L28
    L20:
        if (r117.intValue() == Integer.MIN_VALUE) goto L22;
        return r117;
    L17:
        r117 = null;
    L7:
        r100 = new ChatListComponent$getCurrentBotType$1(r110, r112);
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void OD(final Message r100, Integer r101, final Function1<? super Boolean, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r110, "resultCallback");
        ChatListComponentViewModel r102 = U5();
        wc9.e r103 = R4();
        if (r103 == null) goto L6;
        String r104 = r103.B;
        if (r104 == null) goto L6;
    L7:
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r102.likeMessage(r100, r101, r104, p7(r101), new s0(r100, r110));
        return;
    L6:
        r104 = r100.getSectionId();
        goto L7
    }

    public final void W5(Message r100, String r101, boolean r102) {
        Integer r103 = com.larus.im.bean.message.a.M(r100);
        if (com.larus.bmhome.chat.bean.d.x0(r100) == false) goto L12;
        MessageAdapter r104 = this.O;
        if (r104 == null) goto L7;
        r104.x7(r101, 66);
    L7:
        if (r102 == false) goto L40;
        MessageAdapter r105 = this.O;
        if (r105 == null) goto L41;
        r105.x7(r101, 2);
        return;
    L41:
        return;
    L40:
        return;
    L12:
        if (com.larus.im.bean.message.a.y0(r100) == false) goto L22;
        com.larus.bmhome.chat.helper.n0.f303117a.getClass();
        int r106 = com.larus.bmhome.utils.w2.a(r101);
        if (r103 != null) goto L17;
        return;
    L17:
        if (r103.intValue() != r106) goto L43;
        MessageAdapter r107 = this.O;
        if (r107 == null) goto L44;
        r107.x7(r101, 66);
        return;
    L44:
        return;
    L43:
        return;
    L22:
        if (com.larus.bmhome.chat.bean.d.a0(r100) == false) goto L24;
    L31:
        int r108 = r100.getContentType();
    L32:
        MessageAdapter r109 = this.O;
        if (r109 == null) goto L35;
        r109.x7(r101, r108);
    L35:
        if (r102 == false) goto L46;
        MessageAdapter r110 = this.O;
        if (r110 == null) goto L47;
        r110.x7(r101, 2);
        return;
    L47:
        return;
    L46:
        return;
    L24:
        if (com.larus.bmhome.chat.bean.d.N(r100) == true) goto L31;
        if (com.larus.bmhome.chat.bean.d.k(r100) == true) goto L31;
        if (com.larus.im.bean.message.a.b0(r100) == true) goto L31;
        r108 = 1;
        goto L32
    }

    public final int d7(int r100, int r101, String r102) {
        if (F6() == true) goto L5;
        return r100;
    L5:
        int r103 = k70();
        if (r103 <= 0) goto L13;
        if (r100 <= r101) goto L13;
        int r104 = RangesKt.coerceAtMost(r100, r101 + r103);
        if (r104 == r100) goto L12;
        FLogger.f375446a.i("pending-unread-record", "cap group progress from " + r102 + " raw=" + r100 + " saved=" + r101 + " normalized=" + r104 + " listHeight=" + r103);
    L12:
        return r104;
    L13:
        return r100;
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void l10(OnboardingActionCardData.CardScene r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        U5().requireBotActionCard(r100, r101, r102);
    }

    public final Integer s5(int r100, int r101, int r102) {
        ChatMessageList r103 = o5();
        if (r103 != null) goto L5;
        return null;
    L5:
        int r104 = r103.F(r100);
        if (r101 <= r100) goto L8;
        return null;
    L8:
        boolean r105 = true;
        if (r101 >= r104) goto L17;
        Integer r106 = Integer.valueOf(r103.G(r100));
        if (r106.intValue() > 0) goto L14;
        r105 = false;
    L14:
        if (r105 == true) goto L16;
        return null;
    L16:
        return r106;
    L17:
        Integer r107 = Integer.valueOf(r103.H(r100, r101, r102));
        if (r107.intValue() > 0) goto L21;
        r105 = false;
    L21:
        if (r105 == true) goto L23;
        return null;
    L23:
        return r107;
    }

    public static final void L7(ChatListComponent r110, String r111, String r112, Message r113) {
        IAiChatPraiseTriggerService r100 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        String r103 = "";
        if (r102 == false) goto L19;
        t19.s r114 = t19.s.f544207a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Context r115 = com.larus.ui.arch.component.internal.attach.a.b(r110, r110).getContext();
        r114.getClass();
        t19.s.o(r115, R.string.larus_text_liked_tip, false);
        Activity r116 = AppHost.f326268a.a().getCurrentActivity();
        if ((r116 instanceof FlowCommonAppCompatActivity) == false) goto L13;
        FlowCommonAppCompatActivity r117 = (FlowCommonAppCompatActivity) r116;
    L14:
        if (r117 == null) goto L16;
        r103 = r117.k();
    L16:
        String r104 = r103;
        IAiChatPraiseTriggerService r105 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        if (r105 == null) goto L32;
        r105.b(0, r104, r111, r112);
        return;
    L32:
        return;
    L13:
        r117 = null;
        goto L14
    L19:
        ld8.n r118 = r110.d5();
        if (r118 == null) goto L28;
        CollectFrom r119 = CollectFrom.LIKE;
        String r120 = r113.getMessageId();
        if (r120 == null) goto L26;
        r103 = r120;
    L26:
        if (r118.Ho(r119, r103) != true) goto L28;
    L29:
        if (r101 == true) goto L34;
        t19.s r121 = t19.s.f544207a;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Context r122 = com.larus.ui.arch.component.internal.attach.a.b(r110, r110).getContext();
        r121.getClass();
        t19.s.o(r122, R.string.larus_text_liked_tip, false);
        return;
    L34:
        return;
    L28:
        r101 = false;
        goto L29
    L5:
        if (r100.a() != true) goto L7;
        r102 = true;
        goto L8
    }

    public static final void Y2(ChatListComponent r100, final Message r101, String r102, Map r103) {
        r100.getClass();
        FLogger r104 = FLogger.f375446a;
        String r105 = r100.f300905n;
        StringBuilder r106 = new StringBuilder("[checkIfNeedHandleDocBlock] ");
        r106.append(r101.getMessageId());
        r106.append(" from:");
        r106.append(r102);
        r106.append("， extSize: ");
        String r107 = null;
        if (r103 == null) goto L5;
        Integer r108 = Integer.valueOf(r103.size());
    L6:
        r106.append(r108);
        r106.append(", isFromChunk: ");
        r106.append(com.larus.im.bean.message.a.h0(r103));
        r104.d(r105, r106.toString());
        if (com.larus.im.bean.message.a.h0(r103) == true) goto L9;
        return;
    L9:
        if (com.larus.bmhome.chat.bean.d.G0(r101) == true) goto L26;
        Message r109 = DocumentMessageProcessor.f302863a;
        final Context r110 = r100.getContext();
        List<Message> r111 = r100.V0;
        final boolean r112 = false;
        if (r111 == null) goto L15;
        Message r113 = (Message) CollectionsKt.getOrNull(r111, 0);
        if (r113 == null) goto L15;
        r107 = r113.getMessageId();
    L15:
        final boolean r114 = Intrinsics.areEqual(r107, r101.getMessageId());
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r100, r100).getLifecycle().getCurrentState() != Lifecycle.State.RESUMED) goto L18;
        r112 = true;
    L18:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "message");
        r104.d(DocumentMessageProcessor.f302865c, "tryToHandleDocBlock begin " + r101.getMessageId());
        if (DocumentMessageProcessor.f302866d != null) goto L21;
        PthreadHandlerThreadV2 r115 = new PthreadHandlerThreadV2("document_block_checker");
        ThreadMethodProxy.start(r115);
        DocumentMessageProcessor.f302866d = new Handler(r115.getLooper());
    L21:
        Handler r116 = DocumentMessageProcessor.f302866d;
        if (r116 == null) goto L27;
        r116.post(new com.larus.bmhome.chat.doc.b(r101, r114, r112, r110));
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r108 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3 */
    @Override // com.larus.bmhome.chat.component.list.u7
    public final void Ee(final String r310, ForkType r311, final ReplyOption r410, String r411) {
        Intrinsics.checkNotNullParameter(r310, "messageId");
        boolean r100 = false;
        String r101 = null;
        if (r311 == null) goto L262;
        final wc9.e r110 = R4();
        if (r110 != null) goto L7;
        return;
    L7:
        if (r410 == null) goto L363;
        ModelItemIdentity r102 = r410.getModel();
        if (r102 == null) goto L364;
        String r103 = r102.getKey();
        if (r103 == null) goto L365;
        com.larus.bmhome.instruction.g r111 = vc();
        if (r111 == null) goto L35;
        List<com.larus.bmhome.actionbar.model.z0> r112 = r111.tq();
        if (r112 == null) goto L35;
        Iterator r113 = r112.iterator();
    L19:
        if (r113.hasNext() == false) goto L31;
        Object r114 = r113.next();
        com.larus.bmhome.actionbar.model.p0 r115 = ((com.larus.bmhome.actionbar.model.z0) r114).f295619o;
        if (r115 == null) goto L28;
        Integer r116 = r115.f295366a;
        int r117 = ActiveSwitchType.DEEPTHINK.getValue();
        if (r116 == null) goto L28;
        if (r116.intValue() != r117) goto L28;
        boolean r118 = true;
    L29:
        if (r118 == false) goto L19;
    L32:
        com.larus.bmhome.actionbar.model.z0 r119 = (com.larus.bmhome.actionbar.model.z0) r114;
        if (r119 == null) goto L35;
        com.larus.bmhome.actionbar.model.p0 r120 = r119.f295619o;
    L36:
        if (r120 == null) goto L38;
        boolean r121 = Intrinsics.areEqual(r120.f295376k, Boolean.TRUE);
    L39:
        if (r121 == false) goto L68;
        com.larus.bmhome.actionbar.model.s0 r122 = r120.f295375j;
        if (r122 == null) goto L43;
        boolean r123 = Intrinsics.areEqual(r122.f295434d, Boolean.TRUE);
    L44:
        if (r123 == false) goto L68;
        com.larus.bmhome.actionbar.model.s0 r124 = r120.f295375j;
        if (r124 == null) goto L50;
        com.larus.bmhome.actionbar.model.u0 r125 = r124.f295431a;
        if (r125 == null) goto L50;
        List r126 = r125.f295485a;
    L51:
        if (r126 != null) goto L53;
        r126 = CollectionsKt.emptyList();
    L53:
        Iterator r127 = r126.iterator();
    L55:
        if (r127.hasNext() == false) goto L59;
        Object r128 = r127.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.t0) r128).f295450a, r410.getModeId()) == false) goto L55;
    L60:
        com.larus.bmhome.actionbar.model.t0 r129 = (com.larus.bmhome.actionbar.model.t0) r128;
        if (r129 == null) goto L65;
        com.larus.bmhome.actionbar.model.a2 r130 = r129.f295467r;
        if (r130 == null) goto L65;
        List r131 = r130.f294974a;
    L66:
        if (r131 != null) goto L69;
        r131 = CollectionsKt.emptyList();
    L69:
        Iterator r132 = r131.iterator();
    L71:
        if (r132.hasNext() == false) goto L75;
        Object r133 = r132.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.b2) r133).b(), r410.getModel()) == false) goto L71;
    L76:
        com.larus.bmhome.actionbar.model.b2 r134 = (com.larus.bmhome.actionbar.model.b2) r133;
        if (r134 != null) goto L93;
        if (r120 == null) goto L82;
        com.larus.bmhome.actionbar.model.a2 r135 = r120.d();
        if (r135 == null) goto L82;
        List r136 = r135.f294974a;
    L83:
        if (r136 != null) goto L85;
        r136 = CollectionsKt.emptyList();
    L85:
        Iterator r137 = r136.iterator();
    L87:
        if (r137.hasNext() == false) goto L91;
        Object r138 = r137.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.b2) r138).b(), r410.getModel()) == false) goto L87;
    L92:
        r134 = (com.larus.bmhome.actionbar.model.b2) r138;
        goto L93
    L91:
        r138 = null;
    L82:
        r136 = null;
    L93:
        if (r134 == null) goto L97;
        com.larus.bmhome.actionbar.model.z1 r139 = r134.f295007n;
        if (r139 == null) goto L97;
        boolean r140 = Intrinsics.areEqual(r139.f295635b, Boolean.TRUE);
    L98:
        String r141 = "";
        if (r140 == false) goto L110;
        com.larus.bmhome.actionbar.model.z1 r104 = r134.f295007n;
        if (r104 == null) goto L103;
        r101 = r104.f295634a;
    L103:
        if (r101 == null) goto L106;
        r141 = r101;
    L106:
        t19.s r105 = t19.s.f544207a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r105.g(com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext(), R.string.larus_model_menu_click_toast_upgrade_cn, false);
        int r106 = com.larus.platform.service.n3.f365779a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        com.larus.platform.service.n3.a(com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext(), r141);
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r107 = ICommerceMembershipService.a.a();
        if (r107 == null) goto L362;
        r107.w(r141, r103);
        Unit r108 = Unit.INSTANCE;
        return;
    L362:
        return;
    L110:
        Map r142 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("reply_mode", r103)});
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L117
        String r143 = r110.f559215r;     // Catch: Throwable -> L117
        if (r143 == null) goto L115;
        r141 = r143;
    L115:
        Object r144 = Result.m9449constructorimpl(new JSONObject(r141));     // Catch: Throwable -> L117
    L119:
        JSONObject r145 = new JSONObject();
        if (Result.m9455isFailureimpl(r144) == false) goto L122;
        r144 = r145;
    L122:
        JSONObject r146 = (JSONObject) r144;
        if (r310.length() <= 0) goto L125;
        boolean r147 = true;
    L126:
        if (r147 == false) goto L144;
        List<Message> r148 = this.V0;
        if (r148 != null) goto L130;
        r148 = CollectionsKt.emptyList();
    L130:
        Iterator r149 = SequencesKt.flatMap(CollectionsKt.asSequence(r148), new m3()).iterator();
    L132:
        if (r149.hasNext() == false) goto L142;
        Object r150 = r149.next();
        Message r151 = (Message) r150;
        if (Intrinsics.areEqual(r151.getMessageId(), r310) == false) goto L136;
    L139:
        boolean r152 = true;
    L140:
        if (r152 == false) goto L132;
    L143:
        Message r153 = (Message) r150;
    L146:
        if (r310.length() <= 0) goto L148;
        boolean r154 = true;
    L150:
        if (r154 == false) goto L165;
        if (r153 == null) goto L162;
        Map<String, String> r155 = r153.getExt();
        if (r155 == null) goto L162;
        String r156 = r155.get("agent_task_param");
        if (r156 == null) goto L162;
        if ((!StringsKt.isBlank(r156)) == true) goto L160;
        r156 = null;
    L160:
        if (r156 == null) goto L162;
    L170:
        if (r156 == null) goto L182;
        Set r157 = SetsKt.setOf(new Integer[]{1, 2});
        Result.Companion r158 = Result.Companion;     // Catch: Throwable -> L174
        Object r159 = Result.m9449constructorimpl(Integer.valueOf(new JSONObject(r156).optInt("runtime_type")));     // Catch: Throwable -> L174
    L177:
        if (Result.m9455isFailureimpl(r159) == false) goto L180;
        r159 = null;
    L180:
        if (CollectionsKt.contains(r157, r159) != true) goto L182;
        boolean r160 = true;
    L183:
        Object r161 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        if (com.larus.bmhome.view.actionbar.custom.cache.e.c(r410) != AgentMode.MOA.getValue()) goto L186;
        boolean r162 = true;
    L187:
        if (r162 == false) goto L230;
        if (r411 != null) goto L190;
    L196:
        if (r160 == false) goto L205;
        if (r156 != null) goto L199;
    L202:
        boolean r163 = true;
    L203:
        if (r163 == true) goto L205;
    L229:
        r142.put("agent_task_param", r156);
        goto L230
    L199:
        if (StringsKt.isBlank(r156) == true) goto L202;
        r163 = false;
    L205:
        be8.a r164 = (be8.a) s1a.d.a(this).getAbility(be8.a.class);
        if (r164 == null) goto L208;
        be8.e r165 = r164.getSelectedFolder();
    L209:
        JSONObject r166 = new JSONObject().put("runtime_type", 1);
        if (r165 == null) goto L219;
        String r167 = r165.f18771a;
        if (r167 == null) goto L219;
        if ((!StringsKt.isBlank(r167)) == true) goto L217;
        r167 = null;
    L217:
        if (r167 == null) goto L219;
        r166.put("folder_name", r167);
    L219:
        if (r165 == null) goto L228;
        String r168 = r165.f18772b;
        if (r168 == null) goto L228;
        if ((!StringsKt.isBlank(r168)) == true) goto L226;
        r168 = null;
    L226:
        if (r168 == null) goto L228;
        r166.put("workspace", r168);
        Unit r169 = Unit.INSTANCE;
    L228:
        r156 = r166.toString();
        Intrinsics.checkNotNull(r156);
        goto L229
    L208:
        r165 = null;
        goto L209
    L190:
        if ((!StringsKt.isBlank(r411)) == false) goto L192;
        String r170 = r411;
    L193:
        if (r170 == null) goto L196;
        r156 = r170;
        goto L229
    L192:
        r170 = null;
    L230:
        ChatPageContext r171 = (ChatPageContext) s1a.d.a(this).a(ChatPageContext.class);
        if (r171 == null) goto L233;
        Map<String, String> r172 = r171.getReqExt();
    L234:
        if (r172 != null) goto L236;
        r172 = MapsKt.emptyMap();
    L236:
        String r173 = r172.get("select_project_id");
        if (r173 != null) goto L239;
    L241:
        r173 = null;
    L242:
        ChatRouterHelper r174 = ChatRouterHelper.f303050a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r175 = com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext();
        String r176 = getBotId();
        String r177 = f1().k();
        Intrinsics.checkNotNullParameter(this, "<this>");
        ActivityResultCaller r178 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r178 instanceof by7.e) == false) goto L245;
        by7.e r210 = (by7.e) r178;
    L246:
        ChatPassThroughParams r211 = (ChatPassThroughParams) s1a.d.a(this).a(ChatPassThroughParams.class);
        if (r310.length() <= 0) goto L249;
        r100 = true;
    L249:
        if (r100 == false) goto L251;
        ForkSource r179 = new ForkSource.Message(r110.f559198a, r310);
    L252:
        String r180 = r110.I;
        if (r180 != null) goto L255;
    L260:
        ChatRouterHelper.h(r175, r176, r110, null, r177, "chat", null, null, null, null, null, null, null, false, false, false, false, r210, null, r211, null, null, false, new ForkConversationRequest(r179, r311, r173, r142), new n3(r110, r310, r410), 7667656);
        return;
    L255:
        if ((true ^ StringsKt.isBlank(r180)) == false) goto L257;
        r101 = r180;
    L257:
        if (r101 == null) goto L260;
        r173 = r101;
        goto L260
    L251:
        r179 = new ForkSource.Conversation(r110.f559198a);
        goto L252
    L245:
        r210 = null;
        goto L246
    L239:
        if ((!StringsKt.isBlank(r173)) == false) goto L241;
    L233:
        r172 = null;
        goto L234
    L186:
        r162 = false;
    L174:
        th = move-exception;
        Result.Companion r181 = Result.Companion;
        r159 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L182:
        r160 = false;
    L162:
        r156 = r146.optString("agent_task_param");
        Intrinsics.checkNotNull(r156);
        if ((!StringsKt.isBlank(r156)) == true) goto L170;
    L168:
        r156 = null;
        goto L170
    L165:
        r156 = r146.optString("agent_task_param");
        Intrinsics.checkNotNull(r156);
        if ((!StringsKt.isBlank(r156)) == false) goto L168;
    L148:
        r154 = false;
        goto L150
    L136:
        if (Intrinsics.areEqual(r151.getLocalMessageId(), r310) == true) goto L139;
        r152 = false;
        goto L140
    L142:
        r150 = null;
        goto L143
    L144:
        r153 = null;
        goto L146
    L125:
        r147 = false;
    L117:
        th = move-exception;
        Result.Companion r182 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L97:
        r140 = false;
        goto L98
    L75:
        r133 = null;
    L65:
        r131 = null;
        goto L66
    L59:
        r128 = null;
    L50:
        r126 = null;
        goto L51
    L43:
        r123 = false;
    L68:
        r131 = CollectionsKt.emptyList();
        goto L69
    L38:
        r121 = false;
    L28:
        r118 = false;
        goto L29
    L31:
        r114 = null;
    L35:
        r120 = null;
        goto L36
    L365:
        return;
    L364:
        return;
    L363:
        return;
    L262:
        String r183 = getBotId();
        List<Message> r184 = this.V0;
        if (r184 == null) goto L272;
        Iterator r185 = r184.iterator();
    L266:
        if (r185.hasNext() == false) goto L270;
        Object r186 = r185.next();
        if (Intrinsics.areEqual(((Message) r186).getMessageId(), r310) == false) goto L266;
    L271:
        Message r187 = (Message) r186;
    L273:
        if (r184 == null) goto L305;
        ArrayList r188 = new ArrayList();
        Iterator r189 = r184.iterator();
    L276:
        if (r189.hasNext() == false) goto L293;
        Object r190 = r189.next();
        Message r191 = (Message) r190;
        String r192 = r191.getSectionId();
        if (r187 == null) goto L280;
        String r193 = r187.getSectionId();
    L282:
        if (Intrinsics.areEqual(r192, r193) == false) goto L290;
        long r194 = r191.getLocalIndex();
        if (r187 == null) goto L286;
        long r195 = r187.getLocalIndex();
    L288:
        if (r194 < r195) goto L290;
        boolean r196 = true;
    L291:
        if (r196 == false) goto L276;
        r188.add(r190);
        goto L276
    L286:
        r195 = 0;
    L290:
        r196 = false;
        goto L291
    L280:
        r193 = null;
        goto L282
    L293:
        ?? r197 = new ArrayList();
        Iterator r198 = r188.iterator();
    L295:
        if (r198.hasNext() == false) goto L306;
        Object r199 = r198.next();
        String r1100 = ((Message) r199).getMessageId();
        if (r1100 != null) goto L299;
    L301:
        boolean r1101 = false;
    L303:
        if ((!r1101) == false) goto L295;
        r197.add(r199);
        goto L295
    L299:
        if (StringsKt.contains$default(r1100, "fake", false, 2, null) != true) goto L301;
        r1101 = true;
    L306:
        sd8.a r200 = p4();
        if (r200 == null) goto L311;
        qy8.a r201 = r200.yu();
        if (r201 == null) goto L311;
        qy8.f r202 = r201.f535205b;
    L312:
        if (r202 == null) goto L314;
        r202.a();
    L314:
        ChatRouterHelper r203 = ChatRouterHelper.f303050a;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r204 = com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext();
        wc9.e r205 = R4();
        String r206 = f1().k();
        List r207 = CollectionsKt.take((Iterable) r197, 100);
        Intrinsics.checkNotNullParameter(this, "<this>");
        ActivityResultCaller r208 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r208 instanceof by7.e) == false) goto L317;
        by7.e r1102 = (by7.e) r208;
    L318:
        ChatRouterHelper.h(r204, r183, r205, r310, r206, "chat", null, r207, null, null, null, null, null, false, false, false, false, r1102, null, (ChatPassThroughParams) s1a.d.a(this).a(ChatPassThroughParams.class), null, null, false, null, null, 32833344);
        com.larus.platform.service.z2 r209 = com.larus.platform.service.z2.f365865a;
        r209.w3();
        if (r209.enableChatWithTab() == true) goto L366;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.bmhome.b0.b(com.larus.ui.arch.component.internal.attach.a.b(this, this)) == true) goto L367;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r212 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if (r212 == null) goto L368;
        r212.finish();
        Unit r213 = Unit.INSTANCE;
        return;
    L368:
        return;
    L367:
        return;
    L366:
        return;
    L317:
        r1102 = null;
    L311:
        r202 = null;
        goto L312
    L305:
        r197 = CollectionsKt.emptyList();
        goto L306
    L270:
        r186 = null;
        goto L271
    L272:
        r187 = null;
        goto L273
    }

    @Override // com.larus.bmhome.chat.component.list.u7
    public final void HL(Message r100, String r101, Map<String, String> r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "replaceText");
        U5().replaceMsgOnModifySendAfterAck(r100, r101, r102, r103);
    }

    public final void y7(final LarusPageChatBinding r110, List r111, long r112, boolean r113) {
        HeaderAreaAdapter r100 = this.P;
        if (r100 == null) goto L14;
        PrivateHolder r101 = r100.f297011c;
        if (r101 == null) goto L9;
        View r102 = r101.f303490a;
        if (r102 == null) goto L9;
        com.larus.utils.e1.x(r102);
        r102.setAlpha(1.0f);
    L9:
        BotBioHolder r103 = r100.f297010b;
        if (r103 == null) goto L14;
        View r104 = r103.f303488a;
        if (r104 == null) goto L14;
        com.larus.utils.e1.x(r104);
        r104.setAlpha(1.0f);
    L14:
        boolean r105 = true;
        this.P0 = true;
        Message r106 = (Message) CollectionsKt.firstOrNull(r111);
        if (com.larus.bmhome.chat.helper.f.a(R4()) == false) goto L19;
        if (r106 == null) goto L19;
        com.larus.bmhome.chat.bean.d.k0(r106);
    L19:
        int r107 = 0;
        if (o6() == false) goto L23;
    L61:
        boolean r108 = true;
    L62:
        if (r108 == true) goto L64;
        return;
    L64:
        if (r113 == false) goto L66;
        v7("entry_unread_anchor_to_pending_unread", new m1(r110));
    L237:
        FLogger.f375446a.i(this.f300905n, "finish scrollListToTargetPosition " + r112 + " null");
        return;
    L66:
        Object r109 = null;
        String r114 = "";
        if (f1().B() == false) goto L69;
    L151:
        MessageAdapter r115 = this.O;
        if (r115 == null) goto L154;
        List<xc8.b> r116 = r115.z2();
    L156:
        if (r116 == null) goto L210;
        Iterator<T> r117 = r116.iterator();
    L159:
        if (r117.hasNext() == false) goto L172;
        Object r118 = r117.next();
        xc8.b r119 = (xc8.b) r118;
        if ("".length() <= 0) goto L163;
        boolean r120 = true;
    L164:
        if (r120 == false) goto L167;
        boolean r121 = Intrinsics.areEqual(r119.getMessage().getLocalMessageId(), "");
    L170:
        if (r121 == false) goto L159;
    L173:
        xc8.b r122 = (xc8.b) r118;
        if (r122 == null) goto L210;
        int r123 = r116.indexOf(r122);
        if (com.larus.bmhome.social.userchat.model.b0.f(r122.getMessage()) == false) goto L187;
        int r124 = r123 + 1;
        xc8.b r125 = (xc8.b) CollectionsKt.getOrNull(r116, r124);
        if (r125 == null) goto L184;
        Message r126 = r125.getMessage();
        if (r126 == null) goto L184;
        if (r126.getLocalIndex() != r112) goto L184;
        boolean r127 = true;
    L185:
        if (r127 == false) goto L187;
        r123 = r124;
    L184:
        r127 = false;
    L187:
        xc8.b r128 = (xc8.b) CollectionsKt.getOrNull(r116, r123);
        if (r128 == null) goto L191;
        r122 = r128;
    L191:
        FLogger r129 = FLogger.f375446a;
        r129.i(this.f300905n, "is search model! tarPosInDataList=" + r123 + " msgId=" + r122.getMessage().getMessageId() + " dataSize=" + r116.size());
        Message r130 = r122.getMessage();
        if (J7() == true) goto L194;
        boolean r131 = false;
    L195:
        if (r131 == false) goto L204;
        r129.d("search_landing", "use precision prepare scroll targetMessageId=" + r122.getMessage().getMessageId() + ", position=" + r123);
        ChatMessageList r132 = o5();
        if (r132 != null) goto L199;
    L201:
        r105 = false;
    L202:
        if (r105 == false) goto L204;
    L199:
        if (r132.h0(r123, I5(), Q5()) != true) goto L201;
    L204:
        ChatMessageList r133 = o5();
        if (r133 == null) goto L207;
        r133.e(r123);
        Unit r134 = Unit.INSTANCE;
    L208:
        if (r134 != null) goto L237;
    L207:
        r134 = null;
        goto L208
    L194:
        r131 = Intrinsics.areEqual(r130.getMessageId(), Q5());
        goto L195
    L167:
        if (r119.getMessage().getLocalIndex() != r112) goto L169;
        r121 = true;
        goto L170
    L169:
        r121 = false;
        goto L170
    L163:
        r120 = false;
        goto L164
    L172:
        r118 = null;
    L210:
        if (J7() == true) goto L221;
        if (r116 == null) goto L213;
        r107 = r116.size();
    L213:
        int r135 = r107 / 2;
        if (r116 == null) goto L216;
        xc8.b r136 = (xc8.b) CollectionsKt.getOrNull(r116, r135);
    L217:
        if (r136 == null) goto L229;
        ChatMessageList r137 = o5();
        if (r137 == null) goto L229;
        r137.e(r135);
    L229:
        FLogger r138 = FLogger.f375446a;
        String r139 = this.f300905n;
        StringBuilder r140 = new StringBuilder("is search model! but did not find tar data bean. dataSize=");
        if (r116 == null) goto L232;
        r109 = Integer.valueOf(r116.size());
    L232:
        r140.append(r109);
        r140.append(" targetMsgLocalIndex=");
        r140.append(r112);
        r140.append(" targetMsgLocalId=");
        r140.append("");
        r140.append(" targetMessageId=");
        String r141 = Q5();
        if (r141 == null) goto L236;
        r114 = r141;
    L236:
        r140.append(r114);
        r138.e(r139, r140.toString());
        goto L237
    L216:
        r136 = null;
        goto L217
    L221:
        FLogger r142 = FLogger.f375446a;
        StringBuilder r143 = new StringBuilder("target message not found in feed targetMessageId=");
        String r144 = Q5();
        if (r144 != null) goto L224;
        r144 = "";
    L224:
        r143.append(r144);
        r143.append(", targetMsgLocalIndex=");
        r143.append(r112);
        r143.append(", targetMsgLocalId=");
        r143.append("");
        r143.append(", keyword=");
        r143.append(I5());
        r143.append(", dataSize=");
        if (r116 == null) goto L227;
        Integer r145 = Integer.valueOf(r116.size());
    L228:
        r143.append(r145);
        r142.i("search_landing", r143.toString());
        goto L229
    L227:
        r145 = null;
        goto L228
    L154:
        r116 = null;
        goto L156
    L69:
        if (z5() != (-1)) goto L151;
        if (r112 != (-1)) goto L151;
        if (com.larus.utils.o0.d(null) == true) goto L151;
        if (Q6() == false) goto L91;
        com.larus.utils.t0.c(new n1(r110));
        FLogger r146 = FLogger.f375446a;
        String r147 = this.f300905n;
        StringBuilder r148 = new StringBuilder("scroll readonly forward detail to top, collectionId=");
        r148.append(y5());
        r148.append(", resultSize=");
        r148.append(((ArrayList) r111).size());
        r148.append(", latestMsgId=");
        Message r149 = (Message) CollectionsKt.firstOrNull(r111);
        if (r149 == null) goto L80;
        String r150 = r149.getMessageId();
    L81:
        if (r150 != null) goto L83;
        r150 = "";
    L83:
        r148.append(r150);
        r148.append(", oldestMsgId=");
        Message r151 = (Message) CollectionsKt.lastOrNull(r111);
        if (r151 == null) goto L86;
        r109 = r151.getMessageId();
    L86:
        if (r109 == null) goto L89;
        r114 = r109;
    L89:
        r148.append(r114);
        r146.i(r147, r148.toString());
        goto L237
    L80:
        r150 = null;
        goto L81
    L91:
        if (com.larus.utils.o0.d(f1().t()) == false) goto L94;
        a4();
        goto L237
    L94:
        if (V6(G4()) == false) goto L96;
    L142:
        com.larus.bmhome.chat.component.collection.o r152 = F4();
        if (r152 != null) goto L145;
    L147:
        r105 = false;
    L148:
        if (r105 == false) goto L150;
        com.larus.utils.t0.c(new p1(r110));
        goto L237
    L150:
        N7("entry_scroll_to_latest");
        com.larus.bmhome.chat.api.b0.a.b(r110.f311098n, false, 15);
        goto L237
    L145:
        if (r152.i0() != true) goto L147;
    L96:
        if (f1().x() == false) goto L142;
        if (C6() == false) goto L142;
        if (F6() == false) goto L128;
        Map<String, com.larus.bmhome.chat.manager.d0> r153 = com.larus.bmhome.chat.manager.e0.f306718a;
        com.larus.bmhome.chat.manager.d0 r154 = com.larus.bmhome.chat.manager.e0.a(G4());
        if (r154 == null) goto L139;
        Message r155 = r154.f306711a;
        if (r155 == null) goto L139;
        Iterator r156 = ((ArrayList) r111).iterator();
        int r157 = 0;
    L110:
        if (r156.hasNext() == false) goto L115;
        if (Intrinsics.areEqual(((Message) r156.next()).getLocalMessageId(), r155.getLocalMessageId()) == true) goto L116;
        r157 = r157 + 1;
    L116:
        if (r157 < 0) goto L139;
        int r158 = r154.f306714d;
        if (r158 > 0) goto L121;
    L123:
        boolean r159 = false;
    L124:
        if (r159 == false) goto L126;
        Z3("entry_action_bar_read");
        goto L139
    L126:
        ChatMessageList r160 = o5();
        if (r160 == null) goto L128;
        int r161 = r160.G(r157);
        int r162 = k70();
        if (r160.M(r157, r154.f306712b, r162) == false) goto L133;
        Z3("entry_saved_group_read");
        goto L139
    L133:
        if (r154.f306712b > 0) goto L137;
        if (r161 <= 0) goto L137;
        if (r161 > r162) goto L137;
    L138:
        FLogger.f375446a.i(this.f300905n, "entry scroll to bottom intent check, targetPosition=" + r157 + " groupHeight=" + r161 + " messageListHeight=" + r162 + " shouldStart=" + r105);
    L137:
        r105 = false;
        goto L138
    L121:
        if (r154.f306712b <= r158) goto L123;
        r159 = true;
        goto L124
    L115:
        r157 = -1;
    L139:
        if (r105 == false) goto L141;
        N7("chat_list_entry_scroll_to_latest");
    L141:
        v7("entry_scroll_to_pending_unread", new o1(r110, this));
    L128:
        r105 = false;
        goto L139
    L23:
        if (F6() == true) goto L61;
        MessageAdapter r163 = this.O;
        if (r163 == null) goto L28;
        int r164 = r163.getItemCount();
    L29:
        if (r164 > 2) goto L61;
        wc9.e r165 = R4();
        if (com.larus.platform.service.z2.f365865a.getSubConversationNewShowSuggest() == true) goto L33;
    L35:
        boolean r166 = false;
    L36:
        if (r166 == true) goto L38;
    L47:
        boolean r167 = false;
    L48:
        if (r167 == true) goto L61;
        if (H6(f1().f468086b) == false) goto L52;
    L57:
        boolean r168 = true;
    L58:
        if (r168 == true) goto L61;
        r108 = false;
        goto L62
    L52:
        if (H6(f1().f468085a) == true) goto L57;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (H6(com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments()) == true) goto L57;
        r168 = false;
        goto L58
    L38:
        if (com.larus.bmhome.chat.helper.f.a(r165) == false) goto L43;
        if (r106 != null) goto L42;
    L44:
        boolean r169 = false;
    L45:
        if (r169 == false) goto L47;
        r167 = true;
        goto L48
    L42:
        if (com.larus.bmhome.chat.bean.d.k0(r106) != true) goto L44;
    L43:
        r169 = true;
        goto L45
    L33:
        if (com.larus.bmhome.chat.helper.f.c(r165) == false) goto L35;
        r166 = true;
        goto L36
    L28:
        r164 = 0;
        goto L29
    }

    public static final void s7(Ref.BooleanRef r100, MessageAdapter r101, Ref.ObjectRef<Observer<List<xc8.b>>> r102, Ref.ObjectRef<Observer<Boolean>> r103, Function0<Unit> r104) {
        if (r100.element == false) goto L5;
        return;
    L5:
        if (q7(r101) == false) goto L17;
        r100.element = true;
        MediatorLiveData<List<xc8.b>> r105 = r101.K;
        Observer<List<xc8.b>> r106 = r102.element;
        Observer<Boolean> r107 = null;
        if (r106 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("listObserver");
        Observer<List<xc8.b>> r108 = null;
    L10:
        r105.removeObserver(r108);
        MutableLiveData<Boolean> r109 = r101.f297040y;
        Observer<Boolean> r110 = r103.element;
        if (r110 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("loadObserver");
    L14:
        r109.removeObserver(r107);
        r104.invoke();
        return;
    L13:
        r107 = r110;
        goto L14
    L9:
        r108 = r106;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.bmhome.chat.component.list.r0] */
    @Override // com.larus.bmhome.chat.component.list.u7
    public final void V70(final List<Message> r110, final String r111, final JSONObject r210, final ChatMsgDeleteScene r211, final Function0<Unit> r212) {
        Intrinsics.checkNotNullParameter(r110, "messages");
        Intrinsics.checkNotNullParameter(r111, "botId");
        Intrinsics.checkNotNullParameter(r210, "traceInfo");
        Intrinsics.checkNotNullParameter(r211, "deleteScene");
        Intrinsics.checkNotNullParameter(this, "<this>");
        Context r112 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getContext();
        if (r112 == null) goto L23;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentManager r113 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getChildFragmentManager();
        final LifecycleCoroutineScope r100 = LifecycleOwnerKt.getLifecycleScope(this);
        final Integer r114 = j4();
        final ?? r101 = new r0(this, r110, r212);
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "fragmentManager");
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r110, "messages");
        Intrinsics.checkNotNullParameter(r111, "botId");
        Intrinsics.checkNotNullParameter(r210, "traceInfo");
        Intrinsics.checkNotNullParameter(r211, "deleteScene");
        int r102 = UserActiveDeleteTipHelper.f301196a;
        int r103 = ra9.a.f536860a;
        boolean r104 = Intrinsics.areEqual(ga9.a.e("delete_msg_tip_display", "0"), "2");
        if (r104 == false) goto L12;
        int r105 = ((ArrayList) r110).size();
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r105 <= 1) goto L9;
        int r106 = R.string.larus_deleteMessage_title_recallMsgs;
    L10:
        String r107 = r112.getString(r106);
    L15:
        if (r104 == false) goto L17;
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r108 = r112.getString(R.string.larus_deleteMessage_desc_cannotUndone);
    L18:
        if (r104 == false) goto L20;
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r109 = r112.getString(R.string.larus_responseMenu_option_recall);
    L21:
        CommonDialog.a r115 = new CommonDialog.a();
        r115.i(r107);
        r115.g(r108);
        com.larus.common_ui.dialog.p0 r116 = new ChatFragmentDelegateDialogExtKt$showDeleteMessagesDialog$1(r110, r100, r101, r111, r210, r211, r114);
        CommonDialog.a.f(r115, r116, r109, false, 12);
        CommonDialog.a.e(r115, new com.larus.bmhome.chat.component.ext.b(r110, r111, r114, r210), r112.getString(R.string.larus_delete_message_btn_cancel), 4);
        ChatFragmentDelegateDialogExtKt.a(r115.a(), r113);
        return;
    L20:
        r109 = r112.getString(R.string.larus_delete_message_btn_confirm);
        Intrinsics.checkNotNull(r109);
        goto L21
    L17:
        r108 = r112.getString(R.string.larus_deleteMessage_modalDesc_canNotUndone);
        Intrinsics.checkNotNull(r108);
        goto L18
    L9:
        r106 = R.string.larus_deleteMessage_title_recallMsg;
        goto L10
    L12:
        if (((ArrayList) r110).size() <= 1) goto L14;
        r107 = r112.getString(R.string.larus_delete_multi_messages_dialog_title);
        Intrinsics.checkNotNull(r107);
        goto L15
    L14:
        r107 = r112.getString(R.string.larus_delete_message_toast_text);
        Intrinsics.checkNotNull(r107);
        goto L15
    }

    public final void i7(KeepScreenOnReplyTrigger r100, Boolean r101, Boolean r102, Boolean r103, Integer r104) {
        if (this.f300935y1 == true) goto L5;
        return;
    L5:
        int r105 = 0;
        this.f300935y1 = false;
        if (r101 == null) goto L9;
        boolean r106 = r101.booleanValue();
    L12:
        if (r102 == null) goto L14;
        boolean r107 = r102.booleanValue();
    L15:
        if (r103 == null) goto L17;
        boolean r108 = r103.booleanValue();
    L23:
        if (r104 == null) goto L25;
        r105 = r104.intValue();
    L28:
        FLogger.f375446a.i("KeepScreenOnReply", "release trigger=" + r100.getValue() + " enabled=" + r106 + " supported=" + r107 + " replying=" + r108 + " messages=" + r105 + " ownerHash=" + this.f300931x1.hashCode());
        fa9.e.f476067a.f("reply", this.f300931x1);
        return;
    L25:
        List<Message> r109 = this.V0;
        if (r109 == null) goto L28;
        r105 = r109.size();
        goto L28
    L17:
        List<Message> r110 = this.V0;
        if (r110 != null) goto L20;
    L22:
        r108 = false;
        goto L23
    L20:
        if (m6(r110) != true) goto L22;
        r108 = true;
        goto L23
    L14:
        r107 = x6();
        goto L15
    L9:
        if (com.larus.platform.exp.h.f365384a == true) goto L11;
        r106 = com.larus.platform.service.z2.f365865a.enableKeepScreenOnReply();
        goto L12
    L11:
        r106 = this.f300930x;
        goto L12
    }

    public static final void C3(ChatListComponent r100, Message r110, boolean r111, boolean r112, ThirdPartyMusicPlatform r113, boolean r114) {
        r100.getClass();
        if (VoiceCallConfigServiceDelegate.f377084b.l() == true) goto L19;
        ChatListComponentViewModel r101 = r100.U5();
        if (r110 == null) goto L7;
        String r102 = com.larus.bmhome.chat.bean.d.G(r110);
    L9:
        if (r101.isInDoraCallAndMsgFromVUI(r102) == true) goto L21;
        if (r110 == null) goto L22;
        if (r114 == false) goto L23;
        if (r111 == false) goto L17;
        Intrinsics.checkNotNullParameter(r110, "message");
        r100.U5().replaceMessageForAuth(r112, r110);
        return;
    L17:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), null, null, new ChatListComponent$processAuthResult$1(r112, r110, r113, r100, null), 3, null);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L7:
        r102 = null;
        goto L9
    }

    @Override // com.larus.bmhome.chat.component.list.u7, va8.p
    public final void g3(wc9.e r110, Message r111, String r112, by7.e r113, boolean r114, String r115, long r210, String r211) {
        Intrinsics.checkNotNullParameter(r111, TeaEventTrack.ACTION_DRAMA_PRE);
        Intrinsics.checkNotNullParameter(r112, "clickFrom");
        U5().updateChatPageContext((ChatPageContext) s1a.d.a(this).a(ChatPageContext.class));
        ConcurrentHashMap<com.larus.bmhome.utils.u3, com.larus.bmhome.utils.j3> r100 = com.larus.bmhome.utils.v3.f315132a;
        sd8.a r101 = p4();
        if (r101 == null) goto L7;
        qy8.a r102 = r101.yu();
        if (r102 == null) goto L7;
        Boolean r103 = r102.f535211h;
    L8:
        com.larus.bmhome.utils.v3.f(r110, r103, R5());
        ChatListComponentViewModel r104 = U5();
        Context r105 = F2().getContext();
        if (R5() != null) goto L11;
        boolean r116 = true;
    L12:
        r104.regenerateWithCheck(r110, r111, r112, r105, r113, r114, r115, r210, r211, r116);
        return;
    L11:
        r116 = false;
    L7:
        r103 = null;
        goto L8
    }
}
