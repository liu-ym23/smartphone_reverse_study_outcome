package com.larus.bmhome.bot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.auth.CocoSetting;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.bot.dialog.BotAvatarViewerCanChangeIconDialog;
import com.larus.bmhome.bot.dialog.BotAvatarViewerDialog;
import com.larus.bmhome.bot.share.ShareBotController;
import com.larus.bmhome.bot.share.ShareBotController$performShareBot$1;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.auth.PluginManager;
import com.larus.bmhome.chat.auth.PluginManagerDelegate;
import com.larus.bmhome.chat.auth.model.PluginItem;
import com.larus.bmhome.chat.manager.ExpertSwitchManager;
import com.larus.bmhome.chat.model.api.DefaultActiveModeSettingValue;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuConfigV2;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuData;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuDataV2;
import com.larus.bmhome.chat.model.api.DefaultReplyMenuItem;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuConfig;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuItem;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchMenuMode;
import com.larus.bmhome.chat.model.api.DefaultReplySwitchModeConfig;
import com.larus.bmhome.chat.model.api.UserConfigActiveMode;
import com.larus.bmhome.chat.model.api.UserConfigActiveModeMenu;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.databinding.LarusPageChatSettingBinding;
import com.larus.bmhome.databinding.LarusPageChatSettingMainBotBinding;
import com.larus.bmhome.input.api.EnterKeyAction;
import com.larus.bmhome.input.api.EnterKeyBehaviorHostDelegate;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.bmhome.view.AppInfoLayout;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemLongTextArrow;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextMenu;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.common_res.common_ui.databinding.LarusShareButtonCenterLayoutBinding;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.widget.TagTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.AudioPreview;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotMemoryConfig;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.ShareInfo;
import com.larus.im.bean.bot.ShowTagInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.internal.core.conversation.bot.BotServiceImpl;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IAudioSettingRuntimeProvider;
import com.larus.platform.api.IFlowSettingThemeConfigProvider;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.model.UserConfigItem;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.platform.spi.IAIChatConversationService;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.FragmentExtKt$addOnBackPressed$callback$1;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.account.ObricAccountSPIServiceDelegate;
import com.obric.assistant.spi.task.ObricTaskSkillDelegate;
import com.skydoves.balloon.Balloon;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000È\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u008d\u0002\u0018\u0000 \u0095\u00032\u00020\u00012\u00020\u0002:\u0002\u0095\u0003B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u008a\u0001\u001a\u00030\u008b\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\u0014\u0010\u008e\u0001\u001a\u00030\u008b\u00012\b\u0010\u008f\u0001\u001a\u00030\u008d\u0001H\u0016J\n\u0010\u0090\u0001\u001a\u00030\u008b\u0001H\u0002J.\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\t\u0010\u0097\u0001\u001a\u00020\u0006H\u0002J\n\u0010\u0098\u0001\u001a\u00030\u008b\u0001H\u0002J \u0010\u0099\u0001\u001a\u00030\u008b\u00012\b\u0010\u009a\u0001\u001a\u00030\u0092\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0016J\n\u0010\u009b\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u009c\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u009d\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u009e\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u009f\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010 \u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010¢\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010¤\u0001\u001a\u00030\u008b\u0001H\u0016J\n\u0010¥\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010¦\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010§\u0001\u001a\u00030\u008b\u0001H\u0016J\u0011\u0010¨\u0001\u001a\u00030\u008b\u00012\u0007\u0010©\u0001\u001a\u00020\u0006J\u0013\u0010ª\u0001\u001a\u00030\u008b\u00012\u0007\u0010«\u0001\u001a\u00020!H\u0002J\u0012\u0010¬\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\f\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0002J\t\u0010°\u0001\u001a\u00020xH\u0002J\n\u0010±\u0001\u001a\u00030\u008b\u0001H\u0002J\t\u0010²\u0001\u001a\u00020!H\u0002J\u0014\u0010³\u0001\u001a\u00030\u008b\u00012\b\u0010´\u0001\u001a\u00030µ\u0001H\u0002J\u0012\u0010¶\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010·\u0001\u001a\u00030\u008b\u0001H\u0002J\u0016\u0010¸\u0001\u001a\u00030\u008b\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010\u0096\u0001H\u0002J\u001f\u0010º\u0001\u001a\u00030\u008b\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u0007\u0010»\u0001\u001a\u00020!H\u0002J\n\u0010¼\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010½\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010¾\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010¿\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010À\u0001\u001a\u00030\u008b\u0001H\u0002J\f\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0002J\u001d\u0010Ã\u0001\u001a\u0004\u0018\u00010\t2\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0002¢\u0006\u0003\u0010Å\u0001J\u0017\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010Ä\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0002J\u0017\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010Ç\u0001\u001a\u0005\u0018\u00010È\u0001H\u0002J\u0015\u0010É\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030\u008b\u0001H\u0002J\u001e\u0010Í\u0001\u001a\u00030\u008b\u00012\b\u0010Î\u0001\u001a\u00030\u0092\u00012\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0002J\u0014\u0010Ï\u0001\u001a\u00030\u008b\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0002J\u0014\u0010Ò\u0001\u001a\u00030\u008b\u00012\b\u0010Ð\u0001\u001a\u00030Ñ\u0001H\u0002J\n\u0010Ó\u0001\u001a\u00030\u008b\u0001H\u0002J\u001f\u0010Ô\u0001\u001a\u00030\u008b\u00012\b\u0010Ç\u0001\u001a\u00030È\u00012\t\u0010Õ\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010Ö\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010×\u0001\u001a\u00030\u008b\u0001H\u0002J\u0014\u0010Ø\u0001\u001a\u00030\u008b\u00012\b\u0010Ù\u0001\u001a\u00030Ú\u0001H\u0002J\n\u0010Û\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010Ü\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010Ý\u0001\u001a\u00030\u008b\u0001H\u0002J\u0013\u0010Þ\u0001\u001a\u00020\u00062\b\u0010ß\u0001\u001a\u00030à\u0001H\u0002J\n\u0010á\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010â\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ã\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ä\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010å\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\f\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u0001H\u0002J\n\u0010è\u0001\u001a\u00030\u008b\u0001H\u0002J\u0013\u0010é\u0001\u001a\u00020\u00062\b\u0010ê\u0001\u001a\u00030ë\u0001H\u0002J\u0012\u0010ì\u0001\u001a\u00020\u00062\u0007\u0010í\u0001\u001a\u000202H\u0002J\u0013\u0010î\u0001\u001a\u00020\u00062\b\u0010ï\u0001\u001a\u00030ð\u0001H\u0002J\n\u0010ñ\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ò\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ó\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ô\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010õ\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ö\u0001\u001a\u00030\u008b\u0001H\u0002J\f\u0010÷\u0001\u001a\u0005\u0018\u00010ø\u0001H\u0002J\n\u0010ù\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010ú\u0001\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010û\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ü\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ý\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010þ\u0001\u001a\u00030\u008b\u0001H\u0002J\n\u0010ÿ\u0001\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010\u0080\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010\u0081\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u001e\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0083\u0002H\u0002¢\u0006\u0003\u0010\u0084\u0002J\t\u0010\u0085\u0002\u001a\u00020!H\u0002J\u000b\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\t\u0010\u0087\u0002\u001a\u00020!H\u0002J\f\u0010\u0088\u0002\u001a\u0005\u0018\u00010ç\u0001H\u0002J\u0012\u0010\u0089\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0014\u0010\u008a\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0016J\n\u0010\u008f\u0002\u001a\u00030\u008b\u0001H\u0002J\t\u0010\u0090\u0002\u001a\u00020!H\u0002J\u0012\u0010\u0091\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010\u0092\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010\u0093\u0002\u001a\u00030\u008b\u0001H\u0002J\u001e\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u008b\u00012\n\u0010\u0095\u0002\u001a\u0005\u0018\u00010\u0096\u0002H\u0002¢\u0006\u0003\u0010\u0097\u0002J\u001d\u0010\u0098\u0002\u001a\u0004\u0018\u00010\t2\n\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u009a\u0002H\u0002¢\u0006\u0003\u0010\u009b\u0002J\u0015\u0010\u009e\u0002\u001a\u00030\u008b\u00012\t\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J-\u0010 \u0002\u001a\u00030\u008b\u00012\t\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u00062\t\u0010¡\u0002\u001a\u0004\u0018\u00010\u00062\u000b\b\u0002\u0010¢\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010£\u0002\u001a\u00020\t2\t\u0010¤\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\t\u0010¥\u0002\u001a\u00020!H\u0002J\u0012\u0010¦\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010§\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\f\u0010¨\u0002\u001a\u0005\u0018\u00010©\u0002H\u0002J\u0012\u0010ª\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010«\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\t\u0010¬\u0002\u001a\u00020!H\u0002J\u0012\u0010\u00ad\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\t\u0010®\u0002\u001a\u00020!H\u0002J\u0014\u0010¯\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0002J\u001b\u0010°\u0002\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010±\u0002\u001a\u00020'H\u0002¢\u0006\u0003\u0010²\u0002J\u0012\u0010³\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0014\u0010´\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0002J\u0018\u0010µ\u0002\u001a\u00030\u008b\u00012\f\b\u0002\u0010Ð\u0001\u001a\u0005\u0018\u00010¶\u0002H\u0002J\u0014\u0010·\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0002J\n\u0010¸\u0002\u001a\u00030\u008b\u0001H\u0002J\u001d\u0010¹\u0002\u001a\u00030\u008b\u00012\u0011\u0010º\u0002\u001a\f\u0012\u0005\u0012\u00030¼\u0002\u0018\u00010»\u0002H\u0002J\u0014\u0010½\u0002\u001a\u00030\u008b\u00012\b\u0010\u008b\u0002\u001a\u00030\u008d\u0001H\u0002J\n\u0010¾\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010¿\u0002\u001a\u00030\u008b\u0001H\u0002JH\u0010À\u0002\u001a\u00030\u008b\u00012\u0006\u0010&\u001a\u00020'2\u0007\u0010Á\u0002\u001a\u00020!2+\b\u0002\u0010Â\u0002\u001a$\u0012\u0016\u0012\u00140!¢\u0006\u000f\bÄ\u0002\u0012\n\bÅ\u0002\u0012\u0005\b\b(Æ\u0002\u0012\u0005\u0012\u00030\u008b\u0001\u0018\u00010Ã\u0002H\u0002J\u0012\u0010Ç\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010È\u0002\u001a\u00030\u008b\u0001H\u0002J\u001c\u0010É\u0002\u001a\u00030Ê\u00022\u0006\u0010&\u001a\u00020'2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0012\u0010Ë\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0015\u0010Ì\u0002\u001a\u00030\u008b\u00012\t\u0010Å\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010Í\u0002\u001a\u0005\u0018\u00010\u008b\u00012\u0006\u0010&\u001a\u00020'H\u0002¢\u0006\u0003\u0010²\u0002J\n\u0010Î\u0002\u001a\u00030\u008b\u0001H\u0016J\u0013\u0010Ï\u0002\u001a\u00030\u008b\u00012\u0007\u0010Ð\u0002\u001a\u00020\u0006H\u0002J\f\u0010Ñ\u0002\u001a\u0005\u0018\u00010ç\u0001H\u0002J\u000b\u0010Ò\u0002\u001a\u0004\u0018\u00010\u000bH\u0002J\u000b\u0010Ó\u0002\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010Ô\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010Õ\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010Ö\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010×\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010Ø\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010Ù\u0002\u001a\u00030\u008b\u0001H\u0002J\u001e\u0010Ú\u0002\u001a\u00030\u008b\u00012\u0007\u0010Û\u0002\u001a\u00020!2\t\b\u0002\u0010Ü\u0002\u001a\u00020\u0006H\u0002J\n\u0010Ý\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010Þ\u0002\u001a\u00030\u008b\u0001H\u0002J\u0014\u0010ß\u0002\u001a\u00030\u008b\u00012\b\u0010\u009a\u0001\u001a\u00030ç\u0001H\u0002J\u0014\u0010à\u0002\u001a\u00030\u008b\u00012\b\u0010á\u0002\u001a\u00030â\u0002H\u0002J\n\u0010ã\u0002\u001a\u00030\u008b\u0001H\u0002J\u000b\u0010ä\u0002\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010å\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010æ\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0013\u0010ç\u0002\u001a\u00030\u008b\u00012\u0007\u0010è\u0002\u001a\u00020\u0006H\u0002J\u0012\u0010é\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u001d\u0010ê\u0002\u001a\u0005\u0018\u00010\u008b\u00012\t\u0010ë\u0002\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0003\u0010ì\u0002J\u0012\u0010í\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0013\u0010î\u0002\u001a\u00030\u008b\u00012\u0007\u0010ï\u0002\u001a\u00020!H\u0002J\u000b\u0010ð\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u000b\u0010ñ\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\u000b\u0010ò\u0002\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010ó\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010ô\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010õ\u0002\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010ö\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010÷\u0002\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010ø\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\u0012\u0010ù\u0002\u001a\u0005\u0018\u00010\u008b\u0001H\u0002¢\u0006\u0003\u0010\u00ad\u0001J\n\u0010ú\u0002\u001a\u00030\u008b\u0001H\u0002J\u000b\u0010û\u0002\u001a\u0004\u0018\u00010xH\u0002J\n\u0010ü\u0002\u001a\u00030\u008b\u0001H\u0002J\n\u0010ý\u0002\u001a\u00030\u008b\u0001H\u0002J\u0017\u0010þ\u0002\u001a\u00030\u008b\u0001*\u00020'2\u0007\u0010±\u0002\u001a\u00020'H\u0002J\u001b\u0010ÿ\u0002\u001a\u0004\u0018\u00010#2\u0007\u0010\u0080\u0003\u001a\u00020\u0006H\u0082@¢\u0006\u0003\u0010\u0081\u0003J>\u0010\u0082\u0003\u001a\u0004\u0018\u00010'2\u0007\u0010\u0080\u0003\u001a\u00020\u00062\t\b\u0002\u0010\u0083\u0003\u001a\u00020!2\t\b\u0002\u0010\u0084\u0003\u001a\u00020\u00062\u000b\b\u0002\u0010\u0085\u0003\u001a\u0004\u0018\u00010!H\u0082@¢\u0006\u0003\u0010\u0086\u0003J#\u0010\u0087\u0003\u001a\u00030\u008b\u00012\u0007\u0010\u0080\u0003\u001a\u00020\u00062\u0007\u0010\u0088\u0003\u001a\u00020\u0006H\u0082@¢\u0006\u0003\u0010\u0089\u0003J\u0013\u0010\u008a\u0003\u001a\u00030\u008b\u00012\u0007\u0010\u008b\u0003\u001a\u00020\u0006H\u0002J\t\u0010\u008c\u0003\u001a\u00020!H\u0002J\t\u0010\u008d\u0003\u001a\u00020\u0006H\u0016J\u0014\u0010\u008e\u0003\u001a\u00030\u008b\u00012\b\u0010\u008f\u0003\u001a\u00030\u0090\u0003H\u0016J\t\u0010\u0091\u0003\u001a\u00020!H\u0016J\n\u0010\u0092\u0003\u001a\u00030\u008b\u0001H\u0016J\t\u0010\u0093\u0003\u001a\u00020!H\u0002J\t\u0010\u0094\u0003\u001a\u00020!H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0004\n\u0002\b\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0015\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0015\u001a\u0004\bA\u0010BR\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001d\u0010J\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0015\u001a\u0004\bK\u0010LR\u001b\u0010N\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0015\u001a\u0004\bN\u0010GR\u001b\u0010P\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0015\u001a\u0004\bQ\u0010GR\u001b\u0010S\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010\u0015\u001a\u0004\bS\u0010GR\u001b\u0010U\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\u0015\u001a\u0004\bW\u0010XR\u001b\u0010Z\u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\u0015\u001a\u0004\b[\u0010GR\u001d\u0010]\u001a\u0004\u0018\u00010^8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010\u0015\u001a\u0004\b_\u0010`R\u001b\u0010b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bd\u0010\u0015\u001a\u0004\bc\u0010LR\u000e\u0010e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010f\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\u0015\u001a\u0004\bg\u0010LR\u001d\u0010i\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\u0015\u001a\u0004\bj\u0010LR\u001d\u0010l\u001a\u0004\u0018\u00010m8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\u0015\u001a\u0004\bn\u0010oR\u000e\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\u00020t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0010\u0010w\u001a\u0004\u0018\u00010xX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020{X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010|\u001a\r\u0012\t\u0012\u00070~¢\u0006\u0002\b\u007f0}8BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0082\u0001\u0010\u0015\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0012\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0085\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010¡\u0001\u001a\u0004\u0018\u00010xX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u008c\u0002\u001a\u00030\u008d\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008e\u0002R\u000f\u0010\u009c\u0002\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009d\u0002\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0096\u0003"}, d2 = {"Lcom/larus/bmhome/bot/CommonSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/IResultInterface;", "<init>", "()V", "TAG", "", "TAG$1", "RESULT_CODE", "", "binding", "Lcom/larus/bmhome/setting/ICommonSettingBinding;", "multiAccountUiController", "Lcom/larus/platform/api/MultiAccountUiController;", "keyboardReturnBehaviorPopup", "Lcom/skydoves/balloon/Balloon;", "botSettingViewModel", "Lcom/larus/bmhome/bot/BotSettingViewModel;", "getBotSettingViewModel", "()Lcom/larus/bmhome/bot/BotSettingViewModel;", "botSettingViewModel$delegate", "Lkotlin/Lazy;", "appSettingModel", "Lcom/larus/bmhome/bot/AppSettingModel;", "getAppSettingModel", "()Lcom/larus/bmhome/bot/AppSettingModel;", "appSettingModel$delegate", "trace", "Lcom/larus/bmhome/bot/BotSettingTrace;", "cvsType", "conversationId", "conversationName", "isConversationLocal", "", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "conversationType", "Ljava/lang/Integer;", "botInfo", "Lcom/larus/im/bean/bot/BotModel;", "editPos", "Lcom/larus/platform/model/EditPos;", "prePage", "backPressCallback", "Landroidx/activity/OnBackPressedCallback;", "newConversationId", "autoSendMessage", "searchMobParam", "Lcom/larus/platform/model/SearchMobParam;", "searchStartTime", "", "isImmersiveBot", "isRefreshBot", "hasReportSearchBarShow", "hasRequestedMembershipEntry", "feedbackNavigationInProgress", "hasRequestedAppletDebuggerEntry", "isOpeningAppletDebugger", "continueCallConfig", "Lcom/larus/platform/model/audio/ContinueTalkV2Config;", "getContinueCallConfig", "()Lcom/larus/platform/model/audio/ContinueTalkV2Config;", "continueCallConfig$delegate", "shareBotController", "Lcom/larus/bmhome/bot/share/ShareBotController;", "getShareBotController", "()Lcom/larus/bmhome/bot/share/ShareBotController;", "shareBotController$delegate", "llmTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "isAppSettingPage", "()Z", "setAppSettingPage", "(Z)V", "disclaimerUrlSetting", "getDisclaimerUrlSetting", "()Ljava/lang/String;", "disclaimerUrlSetting$delegate", "isSideBar", "isSideBar$delegate", "enterEditBgImageAb", "getEnterEditBgImageAb", "enterEditBgImageAb$delegate", "isShowLLMDisclaimerPoweredHint", "isShowLLMDisclaimerPoweredHint$delegate", "llmDisclaimerPageUrlConfig", "Lcom/larus/platform/model/LLMDisclaimerPageUrlConfig;", "getLlmDisclaimerPageUrlConfig", "()Lcom/larus/platform/model/LLMDisclaimerPageUrlConfig;", "llmDisclaimerPageUrlConfig$delegate", "showSettingPageDrive", "getShowSettingPageDrive", "showSettingPageDrive$delegate", "loadingDialog", "Lcom/larus/common_ui/dialog/CommonLoadDialog;", "getLoadingDialog", "()Lcom/larus/common_ui/dialog/CommonLoadDialog;", "loadingDialog$delegate", "localConversationId", "getLocalConversationId", "localConversationId$delegate", "botId", "fromActivityName", "getFromActivityName", "fromActivityName$delegate", "fromActivityModule", "getFromActivityModule", "fromActivityModule$delegate", "recommendFrom", "Lcom/larus/platform/model/RecommendFrom;", "getRecommendFrom", "()Lcom/larus/platform/model/RecommendFrom;", "recommendFrom$delegate", "listener", "Lcom/larus/im/service/OnBotChangedListener;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/audio/IChatSpeakerSettingViewModel;", "getModel", "()Lcom/larus/audio/IChatSpeakerSettingViewModel;", "audioReadyJob", "Lkotlinx/coroutines/Job;", "isAudioReadyForVoiceSetting", "optionManager", "Lcom/larus/bmhome/chat/manager/settings/SettingOptionManager;", "shareBtnCenterViewStub", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/common_res/common_ui/databinding/LarusShareButtonCenterLayoutBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getShareBtnCenterViewStub", "()Lcom/larus/common_ui/view/ViewStubManager;", "shareBtnCenterViewStub$delegate", "chatSettingContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "isRestoring", "settingOptionConfig", "Lcom/larus/platform/model/SettingOptionConfig;", "needDefaultReplyModeToast", "needDefaultActiveModeToast", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "attachComponent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "getPrePage", "notifyPrePage", "onViewCreated", "view", "updateFinalItems", "adaptItemsVisibilityAtTargetAppMode", "preloadDynamicIcons", "requestAppletDebuggerEntrance", "onResume", "setupDoraRedDotObserver", "updateDoraRedDotJob", "updateDoraRedDotInMainThread", "updateMemoryRedDot", "onPause", "reportSearchStayTime", "preloadVoiceList", "onDestroyView", "performBack", "leaveMethod", "toggleMessagePushClickEvent", "isChecked", "startMoreMenu", "()Lkotlin/Unit;", "setupUserInfo", "", "setupViews", "setUpSoundsGroup", "useNewSoundsGroup", "setRealtimeCallSwitch", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/view/item/ItemTextToggle;", "setupGroupCells", "setupAppSettings", "hideEmptyItemGroup", "group", "filterInvalidItem", "shouldApplyOptionWhiteList", "reapplyHostAllowListIfNeeded", "setupAdvanced", "handleIndependentModel", "handleIndependentMode", "handleDefaultReplyModeMenu", "getValidDefaultReplyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getDefaultReplyAgentMode", "replyOption", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;)Ljava/lang/Integer;", "getDefaultReplyAnswerMode", DownloadHelper.IDENTITY, "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "handleDefaultReplyModeMenuV2", "menuDataV2", "Lcom/larus/bmhome/chat/model/api/DefaultReplyMenuDataV2;", "showDefaultReplyModeNestedMenu", "showDefaultReplyModeNestedMenuV2", "anchorView", "handleDefaultReplyModeNestedMenuClick", "result", "Lcom/larus/bmhome/chat/nestedmenu/NestedMenuClickResult;", "handleDefaultReplyModeNestedMenuClickV2", "showDefaultReplyModeMenu", "showDefaultReplyModeToast", "selectedText", "setupKeyboardReturnBehavior", "setupStartupOpenNewChatSetting", "bindStartupOpenNewChatToggle", "currentSetting", "Lcom/larus/platform/model/UserConfigItem;", "setupOfficeTaskSettings", "setupCreationOutputSettings", "showKeyboardReturnBehaviorMenu", "getKeyboardReturnBehaviorText", "behavior", "Lcom/larus/bmhome/input/api/EnterKeyAction;", "setupAppSettingModel", "setupUseOnComputer", "setupThird", "setupDiscord", "setupVersion", "setupDoubaoWebsite", "Lcom/larus/bmhome/view/item/ItemTextArrow;", "setupDriveCapacity", "buildDriveCapacitySubText", "storageData", "Lcom/larus/platform/api/DriveUserStorageData;", "formatDriveCapacity", HTTP.CONTENT_RANGE_BYTES, "formatDriveCapacityNumber", "value", "Ljava/math/BigDecimal;", "setupFeedback", "setupAboutApp", "setupLogout", "setupMultiAccountSwitch", "setupPrimacyPermission", "setupArchivedConversations", "findMainActivity", "Landroid/app/Activity;", "setupNotifySettings", "setupLLMDisclaimerPoweredHintInNewStyle", "setupShortCut", "setUpHealthAgreement", "setupLLMDisclaimer", "setupLLMDisclaimerPoweredHint", "setupDisclaimerForApp", "setupPersonalCollect", "setupSanfangShare", "setupDisclaimer", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)Lkotlin/Unit;", "isEnterPrise", "getOpenUrl", "isMainCvs", "setupFontAndTheme", "setupExpertMode", "onResult", "bundle", "appBackGroundListener", "com/larus/bmhome/bot/CommonSettingFragment$appBackGroundListener$1", "Lcom/larus/bmhome/bot/CommonSettingFragment$appBackGroundListener$1;", "setupBotEditSubTitleObserver", "shouldShowGetPro", "setupGetPro", "setupSubscriptionObserver", "setupMembershipEntry", "updateMembershipEntry", "config", "Lcom/larus/commercemembership/api/model/SubscriptionEntryConfig;", "(Lcom/larus/commercemembership/api/model/SubscriptionEntryConfig;)Lkotlin/Unit;", "resolveSubTitleColor", "colorCfg", "Lcom/larus/commercemembership/api/model/SettingsPageSubTitleColor;", "(Lcom/larus/commercemembership/api/model/SettingsPageSubTitleColor;)Ljava/lang/Integer;", "isMembershipEntryShowed", "isManagementEntryShowed", "mobMembershipShowGuidance", "clickUrl", "onShowSubsGuidanceEvent", "defaultEnterMethod", "itemId", "mapMembershipIconRes", "iconName", "isSectionRename", "setupSearch", "showTitleBarLeftImg", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "setupSupportedItems", "setupCommonConversation", "canModifyTts", "setupSubConversation", "canEditBgImage", "setupUpdateResult", "updateAvatar", "newBotInfo", "(Lcom/larus/im/bean/bot/BotModel;)Lkotlin/Unit;", "openBgImagePreviewPage", "setupSelectSpeakerResult", "updateSpeaker", "Lcom/larus/im/bean/bot/SpeakerVoice;", "setupSelectLanguageResult", "updateLanguage", "refreshBotTagView", "tagList", "", "Lcom/larus/im/bean/bot/ShowTagInfo;", "setupSelectModelResult", "updateModel", "setupSelectPrivateStatusResult", "tryInterceptMsgPushCheckListener", "changedCheckState", "originAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldChangeState", "setupRenewSection", "setupRenewSectionUI", "buildCreatorName", "", "setupChatInfo", "refreshBotNameView", "iconEditItemLoad", "onLowMemory", "openBotAvatarPreviewDialog", "url", "setupReSubmit", "setupSubjectBotObserver", "setupResetBotSubjectObserver", "setupConversationName", "setupIconEdit", "setupBotEdit", "setupBotLanguage", "setupLtmSettings", "setupSwitchConfig", "setupDoraEntrance", "isTraceShow", "source", "updateSwitchConfig", "setupPlugin", "setupTtsSpeaker", "observeSaasAudioReady", "runtimeProvider", "Lcom/larus/platform/api/IAudioSettingRuntimeProvider;", "setupVoiceSettingModel", "setupVoiceCreate", "setupDataModel", "setupNickName", "setAutoSendMessageInChatPageIfNeeded", "firstMessage", "setupAccessPermission", "updateAccessPermission", "privateStatus", "(Ljava/lang/Integer;)Lkotlin/Unit;", "setupBotShare", "shareClickAction", "isSharable", "getCaseRecommendFrom", "getCaseTraceId", "getCaseRequestTraceId", "shareClickActionWhenEnabled", "shareClickActionWhenDisabled", "setupAccessPermissionObserver", "setupClearHistory", "clearHistory", "setupDeleteConversation", "setupDelete", "confirmDelete", "resetDefaultSetting", "deleteConversation", "tipOff", "updateBotInfo", "findConversationInfo", "cvsId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBotInfo", "forceNew", "scene", "isAuto", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversationName", "newName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshConversationId", "newId", "isCreator", "getCurrentPageName", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "autoLogEnterPage", "logEnterPage", "isImmersiveStyle", "mergeAllReferrerParams", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonSettingFragment extends TraceFragment implements com.larus.bmhome.y {

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final BigDecimal f296452k1 = null;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final BigDecimal f296453p1 = null;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final BigDecimal f296454v1 = null;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public final Lazy G;
    public final Lazy H;
    public final hq9.m4 H0;
    public AppCompatTextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f296455J;
    public final Lazy K;
    public final Lazy L;
    public boolean L0;
    public final Lazy M;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public boolean P0;
    public final Lazy Q;
    public final Lazy R;
    public String S;
    public final Lazy T;
    public final Lazy U;
    public final Lazy V;
    public Job V0;
    public final CommonSettingFragment$listener$1 W;
    public Job X;
    public boolean Y;
    public final com.larus.bmhome.chat.manager.settings.p Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final b f296456b1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f296457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f296458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.larus.bmhome.setting.c f296459g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f296460g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.larus.platform.api.n4 f296461h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f296462h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Balloon f296463i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f296464j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f296465k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final Lazy f296466k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.larus.bmhome.bot.b f296467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f296468m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f296469n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f296470o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f296471p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f296472p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public wc9.e f296473q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f296474r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public BotModel f296475s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public EditPos f296476t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f296477u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FragmentExtKt$addOnBackPressed$callback$1 f296478v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f296479w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public SearchMobParam f296480x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f296481y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f296482z;

    public static final class a {
    }

    public static final class b implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonSettingFragment f296483a;

        @Override // f09.a.b
        public final void onAppForeground() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
            this.f296483a.N9("kill_app");
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            this.f296483a.N9("to_background");
        }

        public b(CommonSettingFragment r100) {
            this.f296483a = r100;
        }
    }

    public static final class c implements com.larus.common_ui.dialog.p0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonSettingFragment f296484a;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            String r100 = this.f296484a.f296469n;
            BotModel r101 = null;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("conversationId");
            r100 = null;
        L5:
            CommonSettingFragment r102 = this.f296484a;
            if (r100.length() != 0) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            r100 = r102.La0();
        L11:
            wc9.e r104 = this.f296484a.f296473q;
            if (r104 == null) goto L19;
            Integer r105 = r104.f559217t;
            if (r105 == null) goto L19;
            if (r105.intValue() != 8) goto L19;
            boolean r106 = true;
        L20:
            this.f296484a.Ja0().removeConversation(r100);
            Gson r107 = new Gson();
            CommonSettingFragment r108 = this.f296484a;
            Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L26
            BotModel r110 = r108.f296475s;     // Catch: Throwable -> L26
            if (r110 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("botInfo");     // Catch: Throwable -> L26
            r110 = null;
        L24:
            Object r111 = Result.m9449constructorimpl((EditPos) r107.fromJson(r110.getEditPos(), EditPos.class));     // Catch: Throwable -> L26
        L29:
            if (Result.m9455isFailureimpl(r111) == false) goto L31;
            r111 = null;
        L31:
            EditPos r112 = (EditPos) r111;
            if (r112 != null) goto L34;
            r112 = new EditPos(0);
        L34:
            int r113 = wi8.e.f559860a;
            BotModel r114 = this.f296484a.f296475s;
            if (r114 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        L38:
            String r115 = r101.getBotId();
            if (r115 != null) goto L41;
            r115 = "";
        L41:
            Integer r116 = this.f296484a.f296474r;
            Boolean r117 = Boolean.valueOf(r112.c());
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            Intrinsics.checkNotNullParameter(r115, "botId");
            Pair[] r118 = new Pair[5];
            r118[0] = TuplesKt.to("conversation_id", r100);
            r118[1] = TuplesKt.to("bot_id", r115);
            r118[2] = TuplesKt.to("click_from", "chat_setting");
            if (r106 == false) goto L44;
            String r119 = "archived";
        L45:
            r118[3] = TuplesKt.to("chat_status", r119);
            if (r116 != null) goto L49;
        L51:
            if (r116 == null) goto L57;
            if (r116.intValue() != 3) goto L57;
            String r120 = "default_new";
        L60:
            r118[4] = TuplesKt.to("chat_type", r120);
            com.larus.platform.service.o.f365780a.b("remove_chat", com.larus.utils.f.c(r118));
            return;
        L57:
            if (Intrinsics.areEqual(r117, Boolean.TRUE) == false) goto L59;
            r120 = "self_created";
            goto L60
        L59:
            r120 = "other_default";
            goto L60
        L49:
            if (r116.intValue() != 1) goto L51;
            r120 = "default";
            goto L60
        L44:
            r119 = "normal";
            goto L45
        L37:
            r101 = r114;
        L26:
            th = move-exception;
            Result.Companion r121 = Result.Companion;
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L19:
            r106 = false;
            goto L20
        L8:
            r103 = false;
            goto L9
        }

        public c(CommonSettingFragment r100) {
            this.f296484a = r100;
        }
    }

    public static final class d implements com.larus.common_ui.dialog.u {
        public d() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
        }
    }

    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f296486a;

        public e(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f296486a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f296486a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f296486a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.bot.CommonSettingFragment$onResume$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$onResume$1", f = "CommonSettingFragment.kt", i = {}, l = {753}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
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
            IAIChatConversationService.Companion r103 = IAIChatConversationService.f365892a;
            this.label = 1;
            if (r103.c(this) != r101) goto L12;
            return r101;
        }
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.c
    public final boolean et() {
        return true;
    }

    static {
        f296452k1 = BigDecimal.valueOf(1073741824);
        f296453p1 = BigDecimal.valueOf(DownloadConstants.TB);
        f296454v1 = new BigDecimal("0.01");
    }

    public final void Ba0() {
        IFlowSettingThemeConfigProvider r100 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        ItemTextArrow r101 = null;
        if (r100 == null) goto L9;
        com.larus.bmhome.setting.c r102 = this.f296459g;
        if (r102 == null) goto L7;
        ItemTextArrow r103 = r102.X();
    L8:
        r100.b(r103, AdaptThemeFeatureKey.SETTING_ITEM_DOUBAO_EDIT);
        goto L9
    L7:
        r103 = null;
    L9:
        IFlowSettingThemeConfigProvider r104 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r104 == null) goto L16;
        com.larus.bmhome.setting.c r105 = this.f296459g;
        if (r105 == null) goto L14;
        ItemTextArrow r106 = r105.I();
    L15:
        r104.b(r106, AdaptThemeFeatureKey.SETTING_ITEM_FEEDBACK);
        goto L16
    L14:
        r106 = null;
    L16:
        IFlowSettingThemeConfigProvider r107 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r107 == null) goto L23;
        com.larus.bmhome.setting.c r108 = this.f296459g;
        if (r108 == null) goto L21;
        ItemTextArrow r109 = r108.A0();
    L22:
        r107.b(r109, AdaptThemeFeatureKey.SETTING_ITEM_ORDER);
        goto L23
    L21:
        r109 = null;
    L23:
        IFlowSettingThemeConfigProvider r110 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r110 == null) goto L30;
        com.larus.bmhome.setting.c r111 = this.f296459g;
        if (r111 == null) goto L28;
        ItemTextArrow r112 = r111.g1();
    L29:
        r110.b(r112, AdaptThemeFeatureKey.SETTING_ITEM_WALLET);
        goto L30
    L28:
        r112 = null;
    L30:
        IFlowSettingThemeConfigProvider r113 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r113 == null) goto L37;
        com.larus.bmhome.setting.c r114 = this.f296459g;
        if (r114 == null) goto L35;
        ItemTextArrow r115 = r114.i0();
    L36:
        r113.b(r115, AdaptThemeFeatureKey.SETTING_ITEM_MINOR);
        goto L37
    L35:
        r115 = null;
    L37:
        IFlowSettingThemeConfigProvider r116 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r116 == null) goto L44;
        com.larus.bmhome.setting.c r117 = this.f296459g;
        if (r117 == null) goto L42;
        r101 = r117.C();
    L42:
        r116.b(r101, AdaptThemeFeatureKey.SETTING_ITEM_DORA);
        return;
    }

    public final boolean Ca0() {
        if (((Boolean) this.M.getValue()).booleanValue() == false) goto L52;
        EditPos r100 = null;
        if (this.f296476t != null) goto L21;
        Gson r101 = new Gson();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        BotModel r103 = this.f296475s;     // Catch: Throwable -> L12
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");     // Catch: Throwable -> L12
        r103 = null;
    L10:
        Object r104 = Result.m9449constructorimpl((EditPos) r101.fromJson(r103.getEditPos(), EditPos.class));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r104) == false) goto L17;
        r104 = null;
    L17:
        EditPos r105 = (EditPos) r104;
        if (r105 != null) goto L20;
        r105 = new EditPos(0);
    L20:
        this.f296476t = r105;
    L12:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L21:
        EditPos r107 = this.f296476t;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r107 = null;
    L25:
        if (r107.i() == true) goto L46;
        EditPos r108 = this.f296476t;
        if (r108 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r108 = null;
    L30:
        if (r108.g() == true) goto L46;
        EditPos r109 = this.f296476t;
        if (r109 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r109 = null;
    L35:
        if (r109.e() == true) goto L46;
        EditPos r110 = this.f296476t;
        if (r110 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
    L41:
        if (r100.h() == true) goto L46;
        if (AuthModelDelegate.f297134b.d() == true) goto L46;
        boolean r111 = false;
    L47:
        if (r111 == false) goto L53;
        return true;
    L53:
        return false;
    L39:
        r100 = r110;
    L46:
        r111 = true;
        goto L47
    L52:
        return false;
    }

    public final boolean Da0() {
        BotModel r100 = this.f296475s;
        EditPos r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r100 = null;
    L5:
        SpeakerVoice r102 = r100.getVoiceType();
        EditPos r103 = this.f296476t;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
    L10:
        return lq9.g0.a(r102, r101);
    L8:
        r101 = r103;
        goto L10
    }

    public final void Ea0() {
        BotModel r100 = this.f296475s;
        String r101 = null;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r100 = null;
    L6:
        if (ni8.a.b(r100) != (-10)) goto L13;
        BotSettingViewModel r102 = Ja0();
        String r103 = this.f296469n;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
    L11:
        r102.removeConversation(r101);
        return;
    L10:
        r101 = r103;
        goto L11
    L13:
        if (isAdded() == true) goto L15;
        return;
    L15:
        if (getChildFragmentManager().isStateSaved() == true) goto L20;
        CommonDialog.a r104 = new CommonDialog.a();
        r104.i(getString(R.string.larus_chat_list_delete_alert));
        r104.g(getString(R.string.larus_bot_delete_chat_double_confirmation_text));
        CommonDialog.a.f(r104, new c(this), getString(R.string.larus_bot_delete_chat_double_confirmation_delete), false, 12);
        CommonDialog.a.e(r104, new d(), getString(R.string.larus_bot_delete_chat_double_confirmation_cancel), 4);
        U90(r104.a(), getChildFragmentManager());
        return;
    }

    public final AppSettingModel Ia0() {
        return (AppSettingModel) this.f296465k.getValue();
    }

    public final BotSettingViewModel Ja0() {
        return (BotSettingViewModel) this.f296464j.getValue();
    }

    public final String La0() {
        return (String) this.R.getValue();
    }

    public final String Ma0() {
        Integer r100 = this.f296474r;
        if (r100 != null) goto L6;
    L8:
        return "bot_setting";
    L6:
        if (r100.intValue() != 3) goto L8;
        return "new_chat_setting";
    }

    public final RecommendFrom Na0() {
        return (RecommendFrom) this.V.getValue();
    }

    public final void Qa0() {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 == null) goto L63;
        final ItemTextMenu r101 = r100.Y();
        if (r101 == null) goto L64;
        UserConfigActiveModeMenu r102 = Ia0().getDefaultActiveModeMenu();
        String r103 = null;
        if (r102 == null) goto L10;
        List<UserConfigActiveMode> r104 = r102.getModeList();
    L11:
        if (r104 != null) goto L13;
        r104 = CollectionsKt.emptyList();
    L13:
        List r105 = CollectionsKt.filterNotNull(r104);
        final ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L15:
        if (r107.hasNext() == false) goto L35;
        Object r108 = r107.next();
        UserConfigActiveMode r109 = (UserConfigActiveMode) r108;
        String r110 = r109.getModeId();
        boolean r111 = false;
        if (r110 != null) goto L19;
    L22:
        boolean r112 = true;
    L23:
        if (r112 == true) goto L33;
        String r113 = r109.getModelName();
        if (r113 != null) goto L27;
    L30:
        boolean r114 = true;
    L31:
        if (r114 == true) goto L33;
        r111 = true;
        goto L33
    L27:
        if (r113.length() == 0) goto L30;
        r114 = false;
    L33:
        if (r111 == false) goto L15;
        r106.add(r108);
        goto L15
    L19:
        if (r110.length() == 0) goto L22;
        r112 = false;
        goto L23
    L35:
        DefaultActiveModeSettingValue r115 = Ia0().getDefaultActiveModeSettingValue();
        if (r115 == null) goto L38;
        final String r116 = r115.getCurrentSelectMode();
    L40:
        if (r106.isEmpty() == false) goto L43;
        com.larus.utils.e1.o(r101);
        return;
    L43:
        Iterator r117 = r106.iterator();
    L45:
        if (r117.hasNext() == false) goto L49;
        Object r118 = r117.next();
        if (Intrinsics.areEqual(((UserConfigActiveMode) r118).getModeId(), r116) == false) goto L45;
    L50:
        UserConfigActiveMode r119 = (UserConfigActiveMode) r118;
        if (r119 == null) goto L53;
        r103 = r119.getModelName();
    L53:
        r101.setSubText(r103);
        com.larus.utils.e1.x(r101);
        r101.setOnClickListener(new s0(r101, this, r106, r116));
        return;
    L49:
        r118 = null;
        goto L50
    L38:
        r116 = null;
        goto L40
    L10:
        r104 = null;
        goto L11
    L64:
        return;
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        if (this.f296455J == true) goto L5;
        return true;
    L5:
        return !Va0();
    }

    public final boolean Ta0() {
        if (this.f296475s != null) goto L7;
        return false;
    L7:
        return this.f296482z;
    }

    public final boolean Ua0() {
        Integer r100 = this.f296474r;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.equals(1);
    }

    public final boolean Va0() {
        return ((Boolean) this.L.getValue()).booleanValue();
    }

    public final void Xa0() {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 == null) goto L29;
        BotModel r101 = this.f296475s;
        BotModel r102 = null;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r101 = null;
    L7:
        BotIconImage r103 = r101.getIconImage();
        if (r103 == null) goto L10;
        String r104 = r103.getUri();
    L12:
        if (com.larus.utils.o0.d(r104) == false) goto L27;
        BotModel r105 = this.f296475s;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r105 = null;
    L16:
        BotIconImage r106 = r105.getIconImage();
        if (r106 == null) goto L19;
        String r107 = r106.getOriginUrl();
    L21:
        if (com.larus.utils.o0.d(r107) == false) goto L27;
        com.larus.platform.service.m3 r108 = com.larus.platform.service.m3.f365766a;
        Context r109 = r100.P0().getContext();
        BotModel r110 = this.f296475s;
        if (r110 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L26:
        r108.d(r109, r102, this);
        goto L27
    L25:
        r102 = r110;
        goto L26
    L19:
        r107 = null;
    L27:
        Unit r111 = Unit.INSTANCE;
        return;
    L10:
        r104 = null;
        goto L12
    }

    public final void Za0() {
        if (com.larus.platform.service.z2.f365865a.I2() == false) goto L13;
        p2a.i r100 = p2a.i.f527471b;
        BotModel r101 = this.f296475s;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r101 = null;
    L7:
        BotCreatorInfo r102 = r101.getBotCreatorInfo();
        if (r102 == null) goto L10;
        String r103 = r102.getId();
    L11:
        p2a.i.f527471b.R(r103, "");
        goto L13
    L10:
        r103 = null;
    L13:
        if (this.A == false) goto L15;
        return;
    L15:
        final ArrayList<p68.b> r104 = new ArrayList();
        if (isAdded() == false) goto L18;
        p2a.s.f527494b.F0().c(this).observe(getViewLifecycleOwner(), new e(new p1(r104)));
    L20:
        if (FeatureKitDelegate.f295792b.l0().b() == false) goto L35;
        List<SpeakerVoice> r105 = p2a.i.f527471b.D1();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L23:
        if (r107.hasNext() == false) goto L34;
        SpeakerVoice r108 = (SpeakerVoice) r107.next();
        String r109 = r108.getStyleId();
        if (r109 != null) goto L27;
        r109 = "";
    L27:
        AudioPreview r110 = r108.getPreview();
        if (r110 == null) goto L30;
        String r111 = r110.getPreviewAudio();
    L31:
        if (r111 != null) goto L33;
        r111 = "";
    L33:
        r106.add(new p68.b(r111, r109));
        goto L23
    L30:
        r111 = null;
        goto L31
    L34:
        r104.addAll(r106);
    L35:
        AudioServiceDelegate.f288288a.o0().j(r104);
        return;
    L18:
        FLogger.f375446a.e(this.f296457e, "preloadVoiceList failed!");
        goto L20
    }

    public final void ab0() {
        hq9.m4 r100 = this.H0;
        if (r100.f486682a == true) goto L5;
        return;
    L5:
        List<String> r101 = r100.f486683b;
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return;
    L14:
        tb0();
        return;
    L8:
        if (r101.isEmpty() == true) goto L11;
        r102 = false;
        goto L12
    }

    public final boolean an() {
        BotModel r100 = this.f296475s;
        String r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r100 = null;
    L5:
        BotCreatorInfo r102 = r100.getBotCreatorInfo();
        if (r102 == null) goto L8;
        r101 = r102.getId();
    L8:
        if (r101 != null) goto L10;
        r101 = "";
    L10:
        String r103 = AccountService.f365697a.getUserId();
        FLogger.f375446a.d(this.f296457e, "isCreator called: creatorId = " + r101 + ", userId = " + r103);
        return Intrinsics.areEqual(r101, r103);
    }

    public final void eb0() {
        final com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 == null) goto L318;
        ItemTextToggle r101 = r100.F0();
        if (r101 == null) goto L9;
        CustomSwitchCompat r102 = r101.getToggleView();
        if (r102 == null) goto L9;
        r102.setChecked(Ia0().isPromptEnabled());
    L9:
        ItemTextToggle r103 = r100.F0();
        if (r103 == null) goto L14;
        CustomSwitchCompat r104 = r103.getToggleView();
        if (r104 == null) goto L14;
        r104.setClickable(false);
    L14:
        ItemTextToggle r105 = r100.F0();
        if (r105 == null) goto L19;
        CustomSwitchCompat r106 = r105.getToggleView();
        if (r106 == null) goto L19;
        r106.setOnCheckedChangeListener(new p2(this));
    L19:
        FeatureKitDelegate r107 = FeatureKitDelegate.f295792b;
        if (r107.i0().b() == true) goto L24;
        ItemTextToggle r108 = r100.F0();
        if (r108 == null) goto L24;
        r108.setVisibility(8);
    L24:
        ItemTextToggle r109 = r100.G0();
        if (r109 == null) goto L29;
        CustomSwitchCompat r110 = r109.getToggleView();
        if (r110 == null) goto L29;
        r110.setChecked(Ia0().isPromptStyleVertical());
    L29:
        ItemTextToggle r111 = r100.G0();
        if (r111 == null) goto L34;
        CustomSwitchCompat r112 = r111.getToggleView();
        if (r112 == null) goto L34;
        r112.setClickable(false);
    L34:
        ItemTextToggle r113 = r100.G0();
        if (r113 == null) goto L39;
        CustomSwitchCompat r114 = r113.getToggleView();
        if (r114 == null) goto L39;
        r114.setOnCheckedChangeListener(new q2(this));
    L39:
        com.larus.platform.service.s r115 = com.larus.platform.service.s.f365799a;
        if (r115.c() == true) goto L44;
        ItemTextToggle r116 = r100.G0();
        if (r116 == null) goto L50;
        r116.setVisibility(8);
    L50:
        ItemTextToggle r117 = r100.I0();
        if (r117 == null) goto L55;
        CustomSwitchCompat r118 = r117.getToggleView();
        if (r118 == null) goto L55;
        r118.setChecked(Ia0().isStreamMode());
    L55:
        ItemTextToggle r119 = r100.I0();
        if (r119 == null) goto L60;
        CustomSwitchCompat r120 = r119.getToggleView();
        if (r120 == null) goto L60;
        r120.setClickable(false);
    L60:
        ItemTextToggle r121 = r100.I0();
        if (r121 == null) goto L66;
        CustomSwitchCompat r122 = r121.getToggleView();
        if (r122 == null) goto L66;
        r122.setOnCheckedChangeListener(new r2(this));
    L66:
        if (r115.c() == true) goto L70;
        ItemTextToggle r123 = r100.I0();
        if (r123 == null) goto L76;
        r123.setVisibility(8);
    L76:
        ItemTextToggle r124 = r100.J0();
        if (r124 == null) goto L79;
        r124.setVisibility(8);
    L79:
        ItemTextToggle r125 = r100.E0();
        if (r125 == null) goto L84;
        CustomSwitchCompat r126 = r125.getToggleView();
        if (r126 == null) goto L84;
        r126.setChecked(Ia0().isInterruptEnabled());
    L84:
        ItemTextToggle r127 = r100.E0();
        if (r127 == null) goto L89;
        CustomSwitchCompat r128 = r127.getToggleView();
        if (r128 == null) goto L89;
        r128.setClickable(false);
    L89:
        ItemTextToggle r129 = r100.E0();
        if (r129 == null) goto L95;
        CustomSwitchCompat r130 = r129.getToggleView();
        if (r130 == null) goto L95;
        r130.setOnCheckedChangeListener(new s2(this));
    L95:
        if (r115.c() == true) goto L99;
        ItemTextToggle r131 = r100.E0();
        if (r131 == null) goto L105;
        r131.setVisibility(8);
    L105:
        final boolean r132 = AppHost.f326268a.isOversea();
        FeatureDetail r133 = r107.S();
        int r134 = UserSettingDelegate.f308901b.S();
        ItemTextToggle r135 = r100.f1();
        if (r135 == null) goto L110;
        CustomSwitchCompat r136 = r135.getToggleView();
        if (r136 == null) goto L110;
        r136.setClickable(false);
    L110:
        ItemTextToggle r137 = r100.f1();
        boolean r138 = true;
        if (r137 == null) goto L127;
        CustomSwitchCompat r139 = r137.getToggleView();
        if (r139 == null) goto L127;
        if (r132 == true) goto L116;
        if (r134 != 1) goto L120;
    L119:
        boolean r140 = true;
    L121:
        if (r140 == true) goto L123;
    L125:
        boolean r141 = false;
    L126:
        r139.setChecked(r141);
        goto L127
    L123:
        if (r133.b() == false) goto L125;
        r141 = true;
    L120:
        r140 = false;
        goto L121
    L116:
        if (r134 != 2) goto L120;
    L127:
        ItemTextToggle r142 = r100.f1();
        if (r142 == null) goto L133;
        CustomSwitchCompat r143 = r142.getToggleView();
        if (r143 == null) goto L133;
        r143.setOnCheckedChangeListener(new t2(this, r132));
    L133:
        if (r107.S().b() == true) goto L137;
        ItemTextToggle r144 = r100.f1();
        if (r144 == null) goto L137;
        r144.setVisibility(8);
    L137:
        if (r132 == false) goto L139;
    L153:
        ItemTextToggle r145 = r100.M0();
        if (r145 == null) goto L156;
        r145.setVisibility(8);
    L156:
        DefaultReplyMenuItem r146 = null;
        if (r107.T().b() == false) goto L189;
        DefaultReplyMenuDataV2 r147 = Ia0().getDefaultActiveModelMenu();
        if (r147 == null) goto L165;
        DefaultReplyMenuConfigV2 r148 = r147.getMenuConfV2();
        if (r148 == null) goto L165;
        DefaultReplySwitchModeConfig r149 = r148.getModeList();
        if (r149 == null) goto L165;
        List<DefaultReplySwitchMenuMode> r150 = r149.getItemList();
    L166:
        List<DefaultReplySwitchMenuMode> r151 = r150;
        if (r151 != null) goto L169;
    L172:
        boolean r152 = true;
    L173:
        if (r152 == false) goto L179;
        com.larus.bmhome.setting.c r153 = this.f296459g;
        if (r153 == null) goto L195;
        ItemTextArrow r154 = r153.Z();
        if (r154 == null) goto L195;
        com.larus.utils.e1.o(r154);
    L195:
        if (r107.W().b() == false) goto L201;
        Qa0();
        com.larus.bmhome.setting.c r155 = this.f296459g;
        if (r155 == null) goto L257;
        ItemTextMenu r156 = r155.y();
        if (r156 == null) goto L257;
        com.larus.utils.e1.o(r156);
    L257:
        ItemTextToggle r157 = r100.H0();
        if (r157 == null) goto L262;
        CustomSwitchCompat r158 = r157.getToggleView();
        if (r158 == null) goto L262;
        r158.setChecked(Ia0().isHighlightEnabled());
    L262:
        ItemTextToggle r159 = r100.H0();
        if (r159 == null) goto L267;
        CustomSwitchCompat r160 = r159.getToggleView();
        if (r160 == null) goto L267;
        r160.setClickable(false);
    L267:
        ItemTextToggle r161 = r100.H0();
        if (r161 == null) goto L272;
        CustomSwitchCompat r162 = r161.getToggleView();
        if (r162 == null) goto L272;
        r162.setOnCheckedChangeListener(new w2(this));
    L272:
        FeatureKitDelegate r163 = FeatureKitDelegate.f295792b;
        if (r163.s0().b() == true) goto L277;
        ItemTextToggle r164 = r100.H0();
        if (r164 == null) goto L277;
        r164.setVisibility(8);
    L277:
        com.larus.utils.e1.d(r100.W0(), new x2(this));
        if (com.larus.platform.service.s.f365799a.c() == true) goto L282;
        ItemTextArrow r165 = r100.W0();
        if (r165 == null) goto L289;
        r165.setVisibility(8);
    L289:
        if (r163.A0().b() == false) goto L311;
        ViewGroup r166 = r100.e();
        if (r166 == null) goto L293;
        com.larus.utils.e1.x(r166);
    L293:
        ItemTextToggle r167 = r100.L0();
        if (r167 == null) goto L296;
        r167.setVisibility(0);
    L296:
        ItemTextToggle r168 = r100.L0();
        if (r168 == null) goto L301;
        CustomSwitchCompat r169 = r168.getToggleView();
        if (r169 == null) goto L301;
        r169.setChecked(Ia0().getRealtimeCallEnabled());
    L301:
        ItemTextToggle r170 = r100.L0();
        if (r170 == null) goto L306;
        CustomSwitchCompat r171 = r170.getToggleView();
        if (r171 == null) goto L306;
        r171.setClickable(false);
    L306:
        ItemTextToggle r172 = r100.L0();
        if (r172 == null) goto L319;
        CustomSwitchCompat r173 = r172.getToggleView();
        if (r173 == null) goto L320;
        r173.setOnCheckedChangeListener(new y2(this));
        Unit r174 = Unit.INSTANCE;
        return;
    L320:
        return;
    L319:
        return;
    L311:
        ItemTextToggle r175 = r100.L0();
        if (r175 == null) goto L322;
        r175.setVisibility(8);
        Unit r176 = Unit.INSTANCE;
        return;
    L322:
        return;
    L282:
        ViewGroup r177 = r100.e();
        if (r177 == null) goto L285;
        com.larus.utils.e1.x(r177);
    L285:
        ItemTextArrow r178 = r100.W0();
        if (r178 == null) goto L289;
        com.larus.utils.e1.x(r178);
        goto L289
    L201:
        com.larus.bmhome.setting.c r179 = this.f296459g;
        if (r179 == null) goto L252;
        ItemTextMenu r180 = r179.y();
        if (r180 == null) goto L252;
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L209;
        r180.getTextView().setText(getString(R.string.larus_modeSwitch_settings_header_newTaskDefault_cn));
    L209:
        gga.a r181 = ObricAccountSPIServiceDelegate.f392812b.e();
        if (r107.d0().b() == false) goto L251;
        final DefaultReplyMenuDataV2 r182 = Ia0().getDefaultReplyMenuDataV2();
        if (r182 == null) goto L214;
        boolean r183 = Intrinsics.areEqual(r182.getUseMenuConfV2(), Boolean.TRUE);
    L215:
        if (r183 == false) goto L217;
        Pa0(r182);
        goto L252
    L217:
        DefaultReplyMenuData r184 = Ia0().getDefaultModelItemMenu();
        if (r184 != null) goto L220;
        com.larus.utils.e1.o(r180);
        goto L252
    L220:
        ModelItemIdentity r185 = Ia0().getDefaultModelItemKey();
        List<DefaultReplyMenuItem> r186 = r184.getItemList();
        if (r186 == null) goto L235;
        Iterator<T> r187 = r186.iterator();
    L224:
        if (r187.hasNext() == false) goto L232;
        Object r188 = r187.next();
        DefaultReplyMenuItem r189 = (DefaultReplyMenuItem) r188;
        if (r189 == null) goto L228;
        ModelItemIdentity r190 = r189.getIdentity();
    L230:
        if (Intrinsics.areEqual(r190, ModelItemIdentity.copy$default(r185, null, Integer.valueOf(r181.b(r185.getDeprecatedItemId())), 1, null)) == false) goto L224;
    L233:
        DefaultReplyMenuItem r191 = (DefaultReplyMenuItem) r188;
        if (r191 == null) goto L235;
    L241:
        String r192 = r191.getSelectedName();
        if (r192 != null) goto L244;
    L247:
        if (r138 == false) goto L249;
        String r193 = r191.getName();
    L250:
        r180.setSubText(r193);
        r180.setOnMenuClickListener(new p0(r182, this));
        com.larus.utils.e1.x(r180);
        goto L252
    L249:
        r193 = r191.getSelectedName();
        goto L250
    L244:
        if (r192.length() == 0) goto L247;
        r138 = false;
        goto L247
    L228:
        r190 = null;
        goto L230
    L232:
        r188 = null;
    L235:
        List<DefaultReplyMenuItem> r194 = r184.getItemList();
        if (r194 == null) goto L238;
        r146 = (DefaultReplyMenuItem) CollectionsKt.firstOrNull(r194);
    L238:
        if (r146 != null) goto L240;
        com.larus.utils.e1.o(r180);
        goto L252
    L240:
        r191 = r146;
        goto L241
    L214:
        r183 = false;
        goto L215
    L251:
        com.larus.utils.e1.o(r180);
    L252:
        com.larus.bmhome.setting.c r195 = this.f296459g;
        if (r195 == null) goto L257;
        ItemTextArrow r196 = r195.Z();
        if (r196 == null) goto L257;
        com.larus.utils.e1.o(r196);
        goto L257
    L179:
        com.larus.bmhome.setting.c r197 = this.f296459g;
        if (r197 == null) goto L184;
        ItemTextArrow r198 = r197.Z();
        if (r198 == null) goto L184;
        com.larus.utils.e1.x(r198);
    L184:
        com.larus.bmhome.setting.c r199 = this.f296459g;
        if (r199 == null) goto L195;
        ItemTextArrow r200 = r199.Z();
        if (r200 == null) goto L195;
        com.larus.utils.e1.d(r200, new q0(this));
        goto L195
    L169:
        if (r151.isEmpty() == true) goto L172;
        r152 = false;
    L165:
        r150 = null;
        goto L166
    L189:
        com.larus.bmhome.setting.c r201 = this.f296459g;
        if (r201 == null) goto L195;
        ItemTextMenu r202 = r201.Y();
        if (r202 == null) goto L195;
        com.larus.utils.e1.o(r202);
        goto L195
    L139:
        if (r107.n0().b() == false) goto L153;
        if (com.larus.platform.service.z2.f365865a.q().f486696o == false) goto L153;
        ItemTextToggle r203 = r100.M0();
        if (r203 == null) goto L148;
        CustomSwitchCompat r204 = r203.getToggleView();
        if (r204 == null) goto L148;
        r204.setChecked(Ia0().isRelatedVideoEnabled());
    L148:
        ItemTextToggle r205 = r100.M0();
        if (r205 == null) goto L156;
        CustomSwitchCompat r206 = r205.getToggleView();
        if (r206 == null) goto L156;
        r206.setOnCheckedChangeListener(new u2(this, r100));
        goto L156
    L99:
        ViewGroup r207 = r100.e();
        if (r207 == null) goto L102;
        com.larus.utils.e1.x(r207);
    L102:
        ItemTextToggle r208 = r100.E0();
        if (r208 == null) goto L105;
        com.larus.utils.e1.x(r208);
        goto L105
    L70:
        ViewGroup r209 = r100.e();
        if (r209 == null) goto L73;
        com.larus.utils.e1.x(r209);
    L73:
        ItemTextToggle r210 = r100.I0();
        if (r210 == null) goto L76;
        com.larus.utils.e1.x(r210);
        goto L76
    L44:
        ViewGroup r211 = r100.e();
        if (r211 == null) goto L47;
        com.larus.utils.e1.x(r211);
    L47:
        ItemTextToggle r212 = r100.G0();
        if (r212 == null) goto L50;
        com.larus.utils.e1.x(r212);
        goto L50
    }

    public final void ib0() {
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L5;
    L20:
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 == null) goto L28;
        ItemTextArrow r101 = r100.E();
        if (r101 == null) goto L29;
        com.larus.utils.e1.o(r101);
        return;
    L29:
        return;
    L28:
        return;
    L5:
        if (((Boolean) this.P.getValue()).booleanValue() == false) goto L20;
        if (FlowDriveSdkService.f365704a.u() == false) goto L20;
        com.larus.bmhome.setting.c r102 = this.f296459g;
        if (r102 == null) goto L26;
        ItemTextArrow r103 = r102.E();
        if (r103 == null) goto L27;
        com.larus.utils.e1.o(r103.getArrowView());
        com.larus.utils.e1.x(r103);
        com.larus.bmhome.setting.c r104 = this.f296459g;
        if (r104 == null) goto L18;
        ItemGroup r105 = r104.r0();
        if (r105 == null) goto L18;
        com.larus.utils.e1.x(r105);
    L18:
        com.larus.utils.e1.d(r103, new w1(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CommonSettingFragment$setupDriveCapacity$1$2(this, r103, null), 2, null);
        return;
    L27:
        return;
    }

    public final Unit jb0() {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (this.f296468m == 1) goto L7;
    L15:
        boolean r101 = false;
    L16:
        if (r101 == false) goto L36;
        com.larus.utils.e1.x(r100.L());
        ItemGroup r102 = r100.t0();
        if (r102 == null) goto L20;
        com.larus.utils.e1.x(r102);
    L20:
        String r103 = "";
        if (com.larus.platform.service.c2.f365725a.a() == false) goto L29;
        r100.L().setText(getString(R.string.larus_cici_monetization_chat_settings_subscription_tab));
        ItemTextArrow r104 = r100.L();
        Context r105 = getContext();
        if (r105 == null) goto L28;
        String r106 = v19.j5.a(r105, R.string.app_string_name, R.string.larus_cici_monetization_cici_pro_text_global);
        if (r106 == null) goto L28;
        r103 = r106;
    L28:
        r104.Z5(r103, null);
        r100.L().setVisible(true);
    L35:
        com.larus.utils.e1.d(r100.t0(), new s1(this));
    L42:
        ab0();
        return Unit.INSTANCE;
    L29:
        ItemTextArrow r107 = r100.L();
        Context r108 = getContext();
        if (r108 == null) goto L34;
        String r109 = v19.j5.a(r108, R.string.app_string_name, R.string.larus_cici_monetization_get_cici_pro_btn_global);
        if (r109 == null) goto L34;
        r103 = r109;
    L34:
        r107.setText(r103);
        goto L35
    L36:
        com.larus.utils.e1.o(r100.L());
        ItemGroup r110 = r100.t0();
        if (r110 == null) goto L39;
        com.larus.utils.e1.o(r110);
    L39:
        ItemGroup r111 = r100.R();
        if (r111 == null) goto L42;
        com.larus.utils.e1.o(r111);
        goto L42
    L7:
        if (AppHost.f326268a.isOversea() == false) goto L15;
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L15;
        if (com.larus.platform.service.z2.f365865a.enableSubscription() == false) goto L13;
    L14:
        r101 = true;
        goto L16
    L13:
        if (com.larus.platform.service.c2.f365725a.a() == false) goto L15;
        goto L14
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        if (this.f296455J == false) goto L6;
        return "setting";
    L6:
        Integer r100 = this.f296474r;
        if (r100 != null) goto L10;
    L12:
        return "bot_setting";
    L10:
        if (r100.intValue() != 3) goto L12;
        return "new_chat_setting";
    }

    public final void kb0() {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (com.larus.platform.service.z2.f365865a.enableRenameRenewSection() == false) goto L7;
        r100.N0().setImageSrc(R.drawable.larus_ic_new_renew_section);
        r100.N0().setText(getString(R.string.larus_settings_clear_context_new));
        return;
    L7:
        r100.N0().setImageSrc(R.drawable.larus_ic_renew_section);
        r100.N0().setText(getString(R.string.larus_clear_context));
    }

    public final void lb0() {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 == null) goto L40;
        ItemTextToggle r101 = r100.V0();
        if (r101 != null) goto L7;
        return;
    L7:
        if (com.larus.platform.service.z2.f365865a.getBasicExperienceFeatureConfig().f486523a == true) goto L9;
    L11:
        final UserConfigItem r102 = UserSettingDelegate.f308901b.b(UserConfigKey.STARTUP_OPEN_NEW_CHAT);
        com.larus.bmhome.auth.e0 r103 = AuthModelDelegate.f297134b.D();
        if (r103 == null) goto L14;
        String r104 = r103.V();
    L16:
        if (Intrinsics.areEqual(r104, "1") == false) goto L38;
        if (r102 == null) goto L38;
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L38;
        if (com.larus.platform.service.x1.f365857a.a() == true) goto L38;
        boolean r105 = com.larus.platform.service.n0.f365775a.b();
        boolean r106 = AppHost.f326268a.isOversea();
        int r107 = R.string.larus_infra_settings_entry_NewTaskLaunch_global;
        if (r106 == false) goto L30;
        Context r108 = requireContext();
        if (r105 == true) goto L29;
        r107 = R.string.larus_infra_settings_entry_NewChatLaunch_global;
    L29:
        String r109 = v19.j5.a(r108, R.string.app_string_name, r107);
    L33:
        r101.setText(r109);
        com.larus.utils.e1.x(r101);
        com.larus.bmhome.setting.c r110 = this.f296459g;
        if (r110 == null) goto L43;
        final ItemTextToggle r111 = r110.V0();
        if (r111 == null) goto L44;
        r111.getToggleView().setChecked(Intrinsics.areEqual(r102.c(), "1"));
        r111.getToggleView().setOnCheckedChangeListener(new v4(r111, r102, this, r111));
        return;
    L44:
        return;
    L43:
        return;
    L30:
        if (r105 == false) goto L32;
        r109 = getString(R.string.larus_infra_settings_entry_NewTaskLaunch_global);
        Intrinsics.checkNotNull(r109);
        goto L33
    L32:
        r109 = getString(R.string.larus_infra_settings_entry_NewChatLaunch_global);
    L38:
        com.larus.utils.e1.o(r101);
        return;
    L14:
        r104 = null;
        goto L16
    L9:
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L11;
        com.larus.utils.e1.o(r101);
        return;
    }

    public final com.larus.bmhome.setting.c mb0() {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        String r101 = null;
        if (r100 == null) goto L50;
        if (this.Y == true) goto L9;
        ItemTextArrow r102 = r100.a1();
        if (r102 == null) goto L51;
        com.larus.utils.e1.o(r102);
        return r100;
    L51:
        return r100;
    L9:
        com.larus.platform.service.z2 r103 = com.larus.platform.service.z2.f365865a;
        boolean r104 = false;
        if (r103.disableCommonSettingsVoiceCreate() == false) goto L15;
        ItemTextArrow r105 = r100.a1();
        if (r105 == null) goto L53;
        r105.setVisible(false);
        return r100;
    L53:
        return r100;
    L15:
        if (AppHost.f326268a.isOversea() == false) goto L33;
        ItemTextArrow r106 = r100.a1();
        if (r106 == null) goto L46;
        EditPos r107 = this.f296476t;
        if (r107 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r107 = null;
    L22:
        if (r107.j() == false) goto L32;
        p2a.a r108 = p2a.r.f527492b.l2();
        BotModel r109 = this.f296475s;
        if (r109 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r109 = null;
    L26:
        SpeakerVoice r110 = r109.getVoiceType();
        if (r110 == null) goto L30;
        r101 = r110.getLanguageCode();
    L30:
        if (r108.b(r101) == false) goto L32;
        r104 = true;
    L32:
        r106.setVisible(r104);
    L46:
        ItemTextArrow r111 = r100.a1();
        if (r111 == null) goto L55;
        r111.setOnClickListener(new i1(this));
        return r100;
    L55:
        return r100;
    L33:
        ItemTextArrow r112 = r100.a1();
        if (r112 == null) goto L46;
        if (r103.D2() == true) goto L38;
    L45:
        r112.setVisible(r104);
        goto L46
    L38:
        if (Da0() == false) goto L45;
        if (r100.Z0().getVisibility() != 0) goto L42;
        boolean r113 = true;
    L43:
        if (r113 == false) goto L45;
        r104 = true;
        goto L45
    L42:
        r113 = false;
        goto L43
    L50:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Balloon r100 = this.f296463i;
        if (r100 == null) goto L5;
        r100.h();
    L5:
        this.f296463i = null;
        com.larus.platform.api.n4 r101 = this.f296461h;
        if (r101 == null) goto L8;
        r101.release();
    L8:
        this.f296461h = null;
        super.onDestroyView();
        AppHost.f326268a.a().c(this.f296456b1);
        if (this.f296475s == null) goto L17;
        BotServiceImpl r102 = com.larus.im.d.a();
        BotModel r103 = this.f296475s;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r103 = null;
    L13:
        String r104 = r103.getBotId();
        if (r104 != null) goto L16;
        r104 = "";
    L16:
        r102.unregisterBotChangeListener(r104, this.W);
    L17:
        t19.s.f544207a.a();
        FragmentExtKt$addOnBackPressed$callback$1 r105 = this.f296478v;
        if (r105 == null) goto L20;
        r105.remove();
    L20:
        s1a.a.g(this).m(com.larus.bmhome.setting.c.class);
        this.f296459g = null;
    }

    public final void sb0() {
        Job r100 = this.V0;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.V0 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CommonSettingFragment$updateDoraRedDotInMainThread$1(this, null), 3, null);
    }

    public final void tb0() {
        ItemGroup[] r100 = new ItemGroup[11];
        com.larus.bmhome.setting.c r101 = this.f296459g;
        ItemGroup r102 = null;
        if (r101 == null) goto L5;
        ItemGroup r103 = r101.m0();
    L6:
        boolean r104 = false;
        r100[0] = r103;
        com.larus.bmhome.setting.c r105 = this.f296459g;
        if (r105 == null) goto L9;
        ItemGroup r106 = r105.n0();
    L10:
        r100[1] = r106;
        com.larus.bmhome.setting.c r107 = this.f296459g;
        if (r107 == null) goto L13;
        ItemGroup r108 = r107.r0();
    L14:
        r100[2] = r108;
        com.larus.bmhome.setting.c r109 = this.f296459g;
        if (r109 == null) goto L17;
        ItemGroup r110 = r109.g();
    L18:
        r100[3] = r110;
        com.larus.bmhome.setting.c r111 = this.f296459g;
        if (r111 == null) goto L21;
        ItemGroup r112 = r111.o0();
    L22:
        r100[4] = r112;
        com.larus.bmhome.setting.c r113 = this.f296459g;
        if (r113 == null) goto L25;
        ItemGroup r114 = r113.p0();
    L26:
        r100[5] = r114;
        com.larus.bmhome.setting.c r115 = this.f296459g;
        if (r115 == null) goto L29;
        ItemGroup r116 = r115.t0();
    L30:
        r100[6] = r116;
        com.larus.bmhome.setting.c r117 = this.f296459g;
        if (r117 == null) goto L33;
        ItemGroup r118 = r117.U0();
    L34:
        r100[7] = r118;
        com.larus.bmhome.setting.c r119 = this.f296459g;
        if (r119 == null) goto L37;
        ItemGroup r120 = r119.h0();
    L38:
        r100[8] = r120;
        com.larus.bmhome.setting.c r121 = this.f296459g;
        if (r121 == null) goto L41;
        ItemGroup r122 = r121.i();
    L42:
        r100[9] = r122;
        com.larus.bmhome.setting.c r123 = this.f296459g;
        if (r123 == null) goto L45;
        ItemGroup r124 = r123.s0();
    L46:
        r100[10] = r124;
        List r125 = CollectionsKt.listOf(r100);
        hq9.m4 r126 = this.H0;
        List<String> r127 = r126.f486683b;
        if (r127 != null) goto L49;
    L56:
        r127 = null;
    L58:
        if (r127 == null) goto L86;
        ArrayDeque r128 = new ArrayDeque();
        com.larus.bmhome.setting.c r129 = this.f296459g;
        if (r129 == null) goto L64;
        View r130 = r129.P0();
        if (r130 == null) goto L64;
        r128.add(r130);
    L64:
        boolean r131 = false;
    L66:
        if ((!r128.isEmpty()) == false) goto L82;
        if (r131 == true) goto L82;
        View r132 = (View) r128.removeFirst();
        Object r133 = r132.getTag(R.id.larus_bot_settings_config_key);
        if (r133 != null) goto L71;
    L73:
        boolean r134 = false;
    L74:
        if (r134 == true) goto L81;
        if ((r132 instanceof ViewGroup) == false) goto L81;
        Iterator<View> r135 = ViewGroupKt.getChildren((ViewGroup) r132).iterator();
    L79:
        if (r135.hasNext() == false) goto L81;
        r128.add(r135.next());
    L81:
        r131 = r134;
        goto L66
    L71:
        if (CollectionsKt.contains(r127, r133) == false) goto L73;
        r134 = true;
    L82:
        if (r131 == true) goto L84;
        FLogger.f375446a.e(this.f296457e, "host option white list matched nothing, skip filter: " + r127);
    L84:
        if (r131 != true) goto L86;
        r104 = true;
    L86:
        Iterator r136 = r125.iterator();
    L88:
        if (r136.hasNext() == false) goto L112;
        ItemGroup r137 = (ItemGroup) r136.next();
        if (r104 == false) goto L88;
        List<String> r138 = this.H0.f486683b;
        if (r138 == null) goto L88;
        if (r137 == null) goto L88;
        Sequence<View> r139 = ViewGroupKt.getChildren(r137);
        if (r139 == null) goto L88;
        Iterator<View> r140 = r139.iterator();
    L100:
        if (r140.hasNext() == false) goto L88;
        View r141 = r140.next();
        if (this.f296455J == false) goto L106;
        if (r141.getId() == R.id.clear_cache) goto L100;
    L106:
        Object r142 = r141.getTag(R.id.larus_bot_settings_config_key);
        if (r142 == null) goto L111;
        if (CollectionsKt.contains(r138, r142) == false) goto L111;
        FLogger.f375446a.i(this.f296457e, r142 + " is in white list so can visible");
    L111:
        com.larus.utils.e1.o(r141);
        FLogger.f375446a.i(this.f296457e, r142 + " is not in white list so must gone");
        goto L100
    L112:
        if (r104 == false) goto L118;
        com.larus.bmhome.setting.c r143 = this.f296459g;
        if (r143 == null) goto L118;
        ViewGroup r144 = r143.e();
        if (r144 == null) goto L118;
        com.larus.utils.e1.o(r144);
    L118:
        com.larus.bmhome.setting.c r145 = this.f296459g;
        if (r145 == null) goto L123;
        ItemGroup r146 = r145.m0();
        if (r146 == null) goto L123;
        com.larus.utils.w0.e(r146, v19.i5.q());
    L123:
        com.larus.bmhome.setting.c r147 = this.f296459g;
        if (r147 == null) goto L126;
        ItemGroup r148 = r147.m0();
    L127:
        Ra0(r148);
        com.larus.bmhome.setting.c r149 = this.f296459g;
        if (r149 == null) goto L130;
        ItemGroup r150 = r149.n0();
    L131:
        Ra0(r150);
        com.larus.bmhome.setting.c r151 = this.f296459g;
        if (r151 == null) goto L134;
        ItemGroup r152 = r151.q0();
    L135:
        Ra0(r152);
        com.larus.bmhome.setting.c r153 = this.f296459g;
        if (r153 == null) goto L138;
        ItemGroup r154 = r153.r0();
    L139:
        Ra0(r154);
        com.larus.bmhome.setting.c r155 = this.f296459g;
        if (r155 == null) goto L142;
        ItemGroup r156 = r155.g();
    L143:
        Ra0(r156);
        com.larus.bmhome.setting.c r157 = this.f296459g;
        if (r157 == null) goto L146;
        ItemGroup r158 = r157.o0();
    L147:
        Ra0(r158);
        com.larus.bmhome.setting.c r159 = this.f296459g;
        if (r159 == null) goto L150;
        ItemGroup r160 = r159.p0();
    L151:
        Ra0(r160);
        com.larus.bmhome.setting.c r161 = this.f296459g;
        if (r161 == null) goto L154;
        ItemGroup r162 = r161.t0();
    L155:
        Ra0(r162);
        com.larus.bmhome.setting.c r163 = this.f296459g;
        if (r163 == null) goto L158;
        ItemGroup r164 = r163.h0();
    L159:
        Ra0(r164);
        com.larus.bmhome.setting.c r165 = this.f296459g;
        if (r165 == null) goto L162;
        ItemGroup r166 = r165.i();
    L163:
        Ra0(r166);
        if (r104 == false) goto L173;
        com.larus.bmhome.setting.c r167 = this.f296459g;
        if (r167 == null) goto L168;
        ItemGroup r168 = r167.U0();
    L169:
        Ra0(r168);
        com.larus.bmhome.setting.c r169 = this.f296459g;
        if (r169 == null) goto L172;
        r102 = r169.s0();
    L172:
        Ra0(r102);
        goto L173
    L168:
        r168 = null;
    L173:
        Ba0();
        return;
    L162:
        r166 = null;
        goto L163
    L158:
        r164 = null;
        goto L159
    L154:
        r162 = null;
        goto L155
    L150:
        r160 = null;
        goto L151
    L146:
        r158 = null;
        goto L147
    L142:
        r156 = null;
        goto L143
    L138:
        r154 = null;
        goto L139
    L134:
        r152 = null;
        goto L135
    L130:
        r150 = null;
        goto L131
    L126:
        r148 = null;
        goto L127
    L49:
        if (r126.f486682a == true) goto L51;
    L53:
        boolean r170 = false;
    L54:
        if (r170 == false) goto L56;
    L51:
        if ((!r127.isEmpty()) == false) goto L53;
        r170 = true;
        goto L54
    L45:
        r124 = null;
        goto L46
    L41:
        r122 = null;
        goto L42
    L37:
        r120 = null;
        goto L38
    L33:
        r118 = null;
        goto L34
    L29:
        r116 = null;
        goto L30
    L25:
        r114 = null;
        goto L26
    L21:
        r112 = null;
        goto L22
    L17:
        r110 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final void ub0() {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 == null) goto L51;
        p2a.i.f527471b.Z();
        BotModel r101 = this.f296475s;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r101 = null;
    L7:
        bb0(r101.getName());
        BotModel r102 = this.f296475s;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r102 = null;
    L10:
        cb0(r102.getTagList());
        ItemTextArrow r103 = r100.b0();
        BotModel r104 = this.f296475s;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r104 = null;
    L13:
        SpeakerVoice r105 = r104.getVoiceType();
        if (r105 == null) goto L16;
        String r106 = r105.getLanguage();
    L17:
        String r107 = "";
        if (r106 != null) goto L20;
        r106 = "";
    L20:
        int r108 = ItemTextArrow.f316958k;
        r103.Z5(r106, null);
        BotModel r109 = this.f296475s;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r109 = null;
    L23:
        boolean r110 = true;
        if (r109.getMuted() != true) goto L26;
        r100.Z0().Z5(getString(R.string.larus_muted_voice), null);
        return;
    L26:
        BotModel r111 = this.f296475s;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r111 = null;
    L29:
        SpeakerVoice r112 = r111.getVoiceType();
        if (r112 == null) goto L32;
        String r113 = r112.getName();
    L33:
        if (r113 != null) goto L35;
    L38:
        if (r110 == false) goto L40;
        r107 = getString(R.string.larus_muted_voice);
    L49:
        Intrinsics.checkNotNull(r107);
        r100.Z0().Z5(r107, null);
        return;
    L40:
        BotModel r114 = this.f296475s;
        if (r114 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r114 = null;
    L43:
        SpeakerVoice r115 = r114.getVoiceType();
        if (r115 == null) goto L49;
        String r116 = r115.getName();
        if (r116 == null) goto L49;
        r107 = r116;
        goto L49
    L35:
        if (r113.length() == 0) goto L38;
        r110 = false;
        goto L38
    L32:
        r113 = null;
        goto L33
    L16:
        r106 = null;
        goto L17
    }

    public final void wb0() {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 == null) goto L17;
        ItemTextArrow r101 = r100.j0();
        if (r101 == null) goto L18;
        BotModel r102 = this.f296475s;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r102 = null;
    L9:
        ModelItem r103 = r102.getModel();
        if (r103 == null) goto L12;
        String r104 = r103.getName();
    L13:
        if (r104 != null) goto L15;
        r104 = "";
    L15:
        int r105 = ItemTextArrow.f316958k;
        r101.Z5(r104, null);
        return;
    L12:
        r104 = null;
        goto L13
    L18:
        return;
    }

    public final void yb0() {
        final com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 == null) goto L16;
        LinearLayout r101 = r100.s();
        if (r101 == null) goto L14;
        FeatureKitDelegate r102 = FeatureKitDelegate.f295792b;
        if (r102.b0().b() == false) goto L9;
    L12:
        int r103 = 0;
    L13:
        r101.setVisibility(r103);
        goto L14
    L9:
        if (r102.a0().b() == true) goto L12;
        r103 = 8;
    L14:
        FeatureKitDelegate r104 = FeatureKitDelegate.f295792b;
        final boolean r105 = r104.b0().b();
        final boolean r106 = r104.a0().b();
        final Ref.ObjectRef r107 = new Ref.ObjectRef();
        Transformations.map(AuthModelDelegate.f297134b.c(), new l1()).observe(getViewLifecycleOwner(), new e(new m1(r107, this, r105, r106, r100)));
        return;
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [com.larus.bmhome.bot.CommonSettingFragment$listener$1] */
    public CommonSettingFragment() {
        this.f296457e = "ChatSettingFragment";
        this.f296458f = 100;
        final Function0<Fragment> r100 = new CommonSettingFragment$special$$inlined$viewModels$default$1(this);
        this.f296464j = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BotSettingViewModel.class), new CommonSettingFragment$special$$inlined$viewModels$default$2(r100), new CommonSettingFragment$special$$inlined$viewModels$default$3(r100, this));
        final Function0<Fragment> r101 = new CommonSettingFragment$special$$inlined$viewModels$default$4(this);
        this.f296465k = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(AppSettingModel.class), new CommonSettingFragment$special$$inlined$viewModels$default$5(r101), new CommonSettingFragment$special$$inlined$viewModels$default$6(r101, this));
        this.f296467l = new com.larus.bmhome.bot.b();
        this.f296468m = 2;
        this.f296477u = "";
        this.f296479w = "";
        this.G = LazyKt.lazy(new q());
        this.H = LazyKt.lazy(new g3(this));
        this.K = LazyKt.lazy(new r3());
        this.L = LazyKt.lazy(new c4(this));
        this.M = LazyKt.lazy(new n4());
        this.N = LazyKt.lazy(new y4());
        this.O = LazyKt.lazy(new b0());
        this.P = LazyKt.lazy(new m0());
        this.Q = LazyKt.lazy(new x0(this));
        this.R = LazyKt.lazy(new h1(this));
        this.S = "";
        this.T = LazyKt.lazy(new o1(this));
        this.U = LazyKt.lazy(new z1(this));
        this.V = LazyKt.lazy(new k2(this));
        this.W = new CommonSettingFragment$listener$1(this);
        this.Y = true;
        this.Z = new com.larus.bmhome.chat.manager.settings.p();
        this.f296466k0 = LazyKt.lazy(new v2(this));
        this.f296472p0 = true;
        this.H0 = com.larus.platform.service.z2.f365865a.q();
        this.f296456b1 = new b(this);
    }

    public final ReplyOption Oa0() {
        ReplyOption r100 = Ia0().getDefaultReplyOption();
        if (r100 == null) goto L5;
        Object r101 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        return com.larus.bmhome.view.actionbar.custom.cache.e.a(r100);
    L5:
        return null;
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final void T90() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommonSettingFragment$logEnterPage$1(this, null), 3, null);
    }

    public final void nb0() {
        if (isAdded() == true) goto L6;
        FLogger.f375446a.e(this.f296457e, "ChatSettingFragment is not added");
        return;
    L6:
        p2a.s r100 = p2a.s.f527494b;
        r100.F0().b(this).observe(getViewLifecycleOwner(), new e(new x1(this)));
        com.larus.audio.w0 r101 = r100.F0();
        BotModel r102 = this.f296475s;
        EditPos r103 = null;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r102 = null;
    L9:
        SpeakerVoice r104 = r102.getVoiceType();
        EditPos r105 = this.f296476t;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
    L13:
        r101.a(this, r104, r103);
        return;
    L12:
        r103 = r105;
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.f296480x != null) goto L5;
        return;
    L5:
        if (this.f296481y == 0) goto L14;
        long r100 = SystemClock.elapsedRealtime() - this.f296481y;
        BotModel r101 = this.f296475s;
        if (r101 == null) goto L10;
        String r102 = r101.getBotId();
    L11:
        Long r103 = Long.valueOf(r100);
        tx9.i3.h(r102, null, r103, null, null, null, null, null, null, this, 2042);
        this.f296481y = 0;
        return;
    L10:
        r102 = null;
        goto L11
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f296480x == null) goto L5;
        this.f296481y = SystemClock.elapsedRealtime();
    L5:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(null), 3, null);
        boolean r100 = false;
        gb0(false, "onResume");
        sb0();
        jb0();
        com.larus.bmhome.setting.c r101 = this.f296459g;
        if (r101 == null) goto L26;
        Context r102 = getContext();
        if ((r102 instanceof FragmentActivity) == false) goto L10;
        FragmentActivity r103 = (FragmentActivity) r102;
    L11:
        LifecycleOwner r104 = getViewLifecycleOwner();
        AppHost.Companion r105 = AppHost.f326268a;
        if (r105.isOversea() == false) goto L14;
    L16:
        if (r103 != null) goto L18;
    L23:
        RelativeLayout r106 = r101.d1();
        if (r106 == null) goto L26;
        com.larus.utils.e1.o(r106);
        Unit r107 = Unit.INSTANCE;
        goto L26
    L18:
        if (r105.isPlugin() == true) goto L23;
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L23;
        if (r100 == true) goto L23;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r104), null, null, new CommonSettingFragment$setupUserInfo$1$1(r101, this, r104, r103, null), 3, null);
        goto L26
    L14:
        if (com.larus.platform.service.x1.f365857a.a() == false) goto L16;
        r100 = true;
        goto L16
    L10:
        r103 = null;
    L26:
        ib0();
        com.larus.bmhome.setting.c r108 = this.f296459g;
        if (r108 == null) goto L44;
        ItemTextArrow r109 = r108.l0();
        if (r109 == null) goto L44;
        AccountService r110 = AccountService.f365697a;
        if (r110.isLogin().booleanValue() == true) goto L34;
    L43:
        com.larus.utils.e1.o(r109);
        goto L44
    L34:
        if (com.larus.platform.service.z2.f365865a.g1() == false) goto L43;
        if (com.larus.platform.service.x1.f365857a.a() == true) goto L43;
        com.larus.utils.e1.x(r109);
        int r111 = r110.v();
        if (r111 <= 1) goto L41;
        String r112 = String.valueOf(r111);
    L42:
        r109.Z5(r112, null);
        com.larus.utils.e1.d(r109, new n1(this));
        goto L44
    L41:
        r112 = "";
    L44:
        ab0();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onLowMemory() {
        super.onLowMemory();
    }

    public static String Ha0(long r100) {
        if (r100 > 0) goto L6;
        return "0 GB";
    L6:
        BigDecimal r101 = BigDecimal.valueOf(r100).divide(f296452k1, 10, RoundingMode.DOWN);
        BigDecimal r102 = f296454v1;
        if (r101.compareTo(r102) > 0) goto L11;
        return r102.stripTrailingZeros().toPlainString() + " GB";
    L11:
        if (r100 < DownloadConstants.TB) goto L13;
        Pair r103 = TuplesKt.to(BigDecimal.valueOf(r100).divide(f296453p1, 2, RoundingMode.DOWN), "TB");
    L14:
        BigDecimal r104 = (BigDecimal) r103.component1();
        String r105 = (String) r103.component2();
        StringBuilder r106 = new StringBuilder();
        Intrinsics.checkNotNull(r104);
        r106.append(r104.stripTrailingZeros().toPlainString());
        r106.append(' ');
        r106.append(r105);
        return r106.toString();
    L13:
        r103 = TuplesKt.to(r101.setScale(2, RoundingMode.DOWN), "GB");
        goto L14
    }

    public static void Ra0(ItemGroup r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L29;
        Iterator<View> r103 = ViewGroupKt.getChildren(r100).iterator();
    L14:
        if (r103.hasNext() == false) goto L22;
        if (r103.next().getVisibility() != 0) goto L18;
        boolean r104 = true;
    L20:
        if ((!r104) == true) goto L14;
    L23:
        if (r101 == false) goto L30;
        com.larus.utils.e1.o(r100);
        return;
    L30:
        return;
    L18:
        r104 = false;
        goto L20
    L22:
        r101 = true;
        goto L23
    L29:
        return;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 != true) goto L10;
        r102 = true;
        goto L11
    L7:
        r105 = false;
        goto L8
    }

    public static void V90(com.larus.common_ui.dialog.l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static final void X90(CommonSettingFragment r100) {
        r100.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L45
        hq9.p1 r102 = com.larus.platform.service.z2.f365865a.j2();     // Catch: Throwable -> L45
        Iterator<T> r103 = r102.f486741a.iterator();     // Catch: Throwable -> L45
    L5:
        if (r103.hasNext() == false) goto L38;
        if (Intrinsics.areEqual((String) r103.next(), r100.S) == false) goto L5;
        SpannableStringBuilder r104 = new SpannableStringBuilder(r102.f486742b);     // Catch: Throwable -> L45
        r104.setSpan(new d5(r102, r100), 0, r102.f486742b.length(), 33);     // Catch: Throwable -> L45
        com.larus.bmhome.setting.c r105 = r100.f296459g;     // Catch: Throwable -> L45
        if (r105 == null) goto L13;
        TextView r106 = r105.V();     // Catch: Throwable -> L45
        if (r106 == null) goto L13;
        r106.setText(r104);     // Catch: Throwable -> L45
    L13:
        com.larus.bmhome.setting.c r107 = r100.f296459g;     // Catch: Throwable -> L45
        if (r107 == null) goto L18;
        TextView r108 = r107.V();     // Catch: Throwable -> L45
        if (r108 == null) goto L18;
        r108.setMovementMethod(LinkMovementMethod.getInstance());     // Catch: Throwable -> L45
    L18:
        com.larus.bmhome.setting.c r109 = r100.f296459g;     // Catch: Throwable -> L45
        if (r109 == null) goto L23;
        TextView r110 = r109.V();     // Catch: Throwable -> L45
        if (r110 == null) goto L23;
        r110.setHighlightColor(0);     // Catch: Throwable -> L45
    L23:
        com.larus.bmhome.setting.c r111 = r100.f296459g;     // Catch: Throwable -> L45
        if (r111 == null) goto L28;
        TextView r112 = r111.V();     // Catch: Throwable -> L45
        if (r112 == null) goto L28;
        r112.setClickable(true);     // Catch: Throwable -> L45
    L28:
        com.larus.bmhome.setting.c r113 = r100.f296459g;     // Catch: Throwable -> L45
        if (r113 == null) goto L33;
        TextView r114 = r113.V();     // Catch: Throwable -> L45
        if (r114 == null) goto L33;
        r114.setLongClickable(false);     // Catch: Throwable -> L45
    L33:
        com.larus.bmhome.setting.c r115 = r100.f296459g;     // Catch: Throwable -> L45
        if (r115 == null) goto L52;
        TextView r116 = r115.V();     // Catch: Throwable -> L45
        if (r116 == null) goto L53;
        com.larus.utils.e1.x(r116);     // Catch: Throwable -> L45
        return;
    L53:
        return;
    L52:
        return;
    L38:
        com.larus.bmhome.setting.c r117 = r100.f296459g;     // Catch: Throwable -> L45
        if (r117 == null) goto L43;
        TextView r118 = r117.V();     // Catch: Throwable -> L45
        if (r118 == null) goto L43;
        com.larus.utils.e1.o(r118);     // Catch: Throwable -> L45
    L43:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L45
        return;
    L45:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final void Y90(CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L9;
        com.larus.utils.e1.x(r101.U0());
        ItemTextToggle r102 = r101.K0();
        if (com.larus.platform.service.z2.f365865a.m3() == true) goto L7;
        FLogger.f375446a.e(r100.f296457e, "audio not enable");
        return;
    L7:
        boolean r103 = VoiceCallServiceDelegate.f377087a.F();
        r102.getToggleView().setChecked(r103);
        r102.getToggleView().setOnCheckedChangeListener(new f4());
        return;
    }

    public static final void Z90(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L9;
        BotModel r102 = r100.f296475s;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r102 = null;
    L7:
        r100.qb0(r102.getPrivateStatus());
        com.larus.utils.e1.d(r101.b(), new t3(r100));
        Unit r103 = Unit.INSTANCE;
        return;
    }

    public static final void aa0(final CommonSettingFragment r100) {
        if (r100.A == true) goto L7;
        r100.Ja0().getUpdateBotAccessPermission().observe(r100.getViewLifecycleOwner(), new e(new i4(r100)));
        return;
    }

    public static final void ba0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100), Dispatchers.getIO(), null, new CommonSettingFragment$setupBotEdit$1$1(r100, null), 2, null);
        r101.G().setOnClickListener(new w(r100));
        Unit r102 = Unit.INSTANCE;
        return;
    }

    public static final void ca0(final CommonSettingFragment r100) {
        if (r100.A == true) goto L7;
        r100.Ja0().getUpdateBotEditItemFromDBResult().observe(r100.getViewLifecycleOwner(), new e(new l3(r100)));
        return;
    }

    public static final void da0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L53;
        ItemTextArrow r102 = r101.b0();
        boolean r103 = true;
        if (r100.f296455J == false) goto L7;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L19;
        int r105 = 0;
    L20:
        r102.setVisibility(r105);
        IFlowSdkDepend r106 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r106 == null) goto L23;
        r106.i();
        com.larus.home.impl.sdk.u2.f346250a.b();
    L23:
        r101.b0().setOnClickListener(new j2(r100));
        if (r101.b0().getText().length() > 0) goto L27;
        r103 = false;
    L27:
        String r107 = "";
        if (r103 == false) goto L41;
        CharSequence r108 = r101.b0().getText();
        BotModel r109 = r100.f296475s;
        if (r109 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r109 = null;
    L32:
        SpeakerVoice r110 = r109.getVoiceType();
        if (r110 == null) goto L35;
        String r111 = r110.getLanguage();
    L36:
        if (r111 != null) goto L39;
        r111 = "";
    L39:
        if (Intrinsics.areEqual(r108, r111) == true) goto L41;
        p2a.i.f527471b.Z();
        goto L41
    L35:
        r111 = null;
    L41:
        ItemTextArrow r112 = r101.b0();
        BotModel r113 = r100.f296475s;
        if (r113 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r113 = null;
    L44:
        SpeakerVoice r114 = r113.getVoiceType();
        if (r114 == null) goto L47;
        String r115 = r114.getLanguage();
    L48:
        if (r115 == null) goto L51;
        r107 = r115;
    L51:
        int r116 = ItemTextArrow.f316958k;
        r112.Z5(r107, null);
        Unit r117 = Unit.INSTANCE;
        return;
    L47:
        r115 = null;
        goto L48
    L19:
        r105 = 8;
        goto L20
    L7:
        if (com.larus.platform.service.z2.f365865a.q().f486687f == false) goto L16;
        com.larus.bmhome.chat.api.e0 r118 = AuthModelDelegate.f297134b.e().getValue();
        if (r118 == null) goto L13;
        LaunchInfo r119 = r118.f297186a;
        if (r119 == null) goto L13;
        boolean r120 = Intrinsics.areEqual(r119.N0(), Boolean.TRUE);
    L14:
        if (r120 == true) goto L16;
        r104 = true;
    L13:
        r120 = false;
        goto L14
    }

    public static final void ea0(final CommonSettingFragment r110) {
        com.larus.bmhome.setting.c r100 = r110.f296459g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r110.Ua0() == false) goto L7;
    L62:
        Unit r111 = Unit.INSTANCE;
        return;
    L7:
        if (r110.f296455J == true) goto L62;
        com.larus.platform.service.z2 r101 = com.larus.platform.service.z2.f365865a;
        if (r101.q().f486688g == false) goto L62;
        String r102 = null;
        if (r101.x3().getDisableBotShare() == false) goto L20;
        Integer r103 = r110.f296474r;
        BotModel r104 = r110.f296475s;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r104 = null;
    L18:
        if (nq9.h.a(r103, r104.getBotType()) == true) goto L62;
    L20:
        BotModel r105 = r110.f296475s;
        if (r105 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r105 = null;
    L23:
        ShareInfo r106 = r105.getShareInfo();
        boolean r107 = false;
        if (r106 == null) goto L26;
        boolean r108 = Intrinsics.areEqual(r106.isShowShareTab(), Boolean.TRUE);
    L27:
        if (r108 == false) goto L62;
        Integer r109 = r110.f296474r;
        if (r109 != null) goto L32;
    L34:
        BotModel r112 = r110.f296475s;
        if (r112 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r112 = null;
    L37:
        ShareInfo r113 = r112.getShareInfo();
        if (r113 == null) goto L40;
        String r114 = r113.getShareStatus();
    L41:
        final boolean r115 = Intrinsics.areEqual(r114, "shareable");
        if (r115 == false) goto L44;
        float r116 = 1.0f;
    L46:
        if (r110.Ja0().getShareBtnCenter() == false) goto L61;
        ((com.larus.common_ui.view.b0) r110.f296466k0.getValue()).b();
        LarusShareButtonCenterLayoutBinding r117 = (LarusShareButtonCenterLayoutBinding) ((com.larus.common_ui.view.b0) r110.f296466k0.getValue()).f328321c;
        if (r117 == null) goto L52;
        FrameLayout r118 = r117.f326798b;
        if (r118 == null) goto L52;
        com.larus.utils.e1.d(r118, new v3(r110, r115));
        r118.setAlpha(r116);
    L52:
        if (r107 == false) goto L61;
        LarusShareButtonCenterLayoutBinding r119 = (LarusShareButtonCenterLayoutBinding) ((com.larus.common_ui.view.b0) r110.f296466k0.getValue()).f328321c;
        if (r119 == null) goto L61;
        TextView r120 = r119.f326799c;
        if (r120 == null) goto L61;
        Context r121 = r110.getContext();
        if (r121 == null) goto L60;
        r102 = r121.getString(R.string.larus_bot_setting_sharechat);
    L60:
        r120.setText(r102);
    L61:
        NovaTitleBarEx.k6(r100.Y0(), v19.c.b(R.attr.larus_ic_bot_share_menu, r110.getContext(), R.drawable.larus_ic_bot_share_menu), r116, null, r110.getString(R.string.larus_accessibility_icon_share), new w3(r110, r115), 12);
        goto L62
    L44:
        r116 = 0.3f;
        goto L46
    L40:
        r114 = null;
        goto L41
    L32:
        if (r109.intValue() != 3) goto L34;
        r107 = true;
        goto L34
    L26:
        r108 = false;
        goto L27
    }

    public static final void fa0(final CommonSettingFragment r100) {
        if (r100.f296459g != null) goto L5;
        return;
    L5:
        if (r100.A == true) goto L7;
        r100.Ja0().getChatHistoryClearSuccess().observe(r100.getViewLifecycleOwner(), new e(new x(r100)));
    L7:
        Unit r101 = Unit.INSTANCE;
    }

    public static final void ga0(final CommonSettingFragment r100) {
        final com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L18;
        ItemTextArrow r102 = r101.F();
        if (r102 == null) goto L7;
        r102.setOnClickListener(new d2(r100));
    L7:
        ItemTextArrow r103 = r101.F();
        if (r103 == null) goto L14;
        String r104 = r100.f296470o;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("conversationName");
        r104 = null;
    L12:
        int r105 = ItemTextArrow.f316958k;
        r103.Z5(r104, null);
    L14:
        if (r100.A == true) goto L16;
        r100.Ja0().getUpdateCvsName().observe(r100.getViewLifecycleOwner(), new e(new e2(r100, r101)));
    L16:
        Unit r106 = Unit.INSTANCE;
        return;
    }

    public static final void ha0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L20;
        ItemTextArrow r102 = r101.j0();
        if (r102 == null) goto L7;
        r102.setOnClickListener(new s3(r100));
    L7:
        ItemTextArrow r103 = r101.j0();
        if (r103 == null) goto L21;
        BotModel r104 = r100.f296475s;
        if (r104 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r104 = null;
    L12:
        ModelItem r105 = r104.getModel();
        if (r105 == null) goto L15;
        String r106 = r105.getName();
    L16:
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        int r107 = ItemTextArrow.f316958k;
        r103.Z5(r106, null);
        Unit r108 = Unit.INSTANCE;
        return;
    L15:
        r106 = null;
        goto L16
    L21:
        return;
    }

    public static /* synthetic */ void hb0(CommonSettingFragment r100) {
        r100.gb0(true, "");
    }

    public static final void ia0(final CommonSettingFragment r100) {
        if (r100.f296459g != null) goto L5;
        return;
    L5:
        if (r100.A == true) goto L7;
        r100.Ja0().getDeleteBot().observe(r100.getViewLifecycleOwner(), new e(new k4(r100)));
    L7:
        Unit r101 = Unit.INSTANCE;
    }

    public static final void ja0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.A == true) goto L10;
        ItemTextView r102 = r101.z();
        if (r102 == null) goto L9;
        r102.setOnClickListener(new l2(r100));
    L9:
        r100.Ja0().getRemoveConversation().observe(r100.getViewLifecycleOwner(), new e(new m2(r100)));
    L10:
        Unit r103 = Unit.INSTANCE;
    }

    public static final void ka0(CommonSettingFragment r100) {
        if (r100.getView() == null) goto L6;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner()), null, null, new CommonSettingFragment$setupDoraRedDotObserver$1(r100, null), 3, null);
        return;
    }

    public static final void la0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.f296468m != 1) goto L17;
        CoroutineScope r102 = ExpertSwitchManager.f306663a;
        if (FeatureKitDelegate.f295792b.h0().b() == false) goto L11;
        ItemGroup r103 = r101.P();
        if (r103 == null) goto L14;
        r103.setVisibility(0);
    L14:
        final ItemTextToggle r104 = r101.H();
        if (r104 == null) goto L22;
        r104.getToggleView().setChecked(ExpertSwitchManager.f306664b.f0());
        r104.getToggleView().setClickable(false);
        r104.getToggleView().setOnCheckedChangeListener(new i2(r104, r100));
        Unit r105 = Unit.INSTANCE;
        return;
    L22:
        return;
    L11:
        ItemGroup r106 = r101.P();
        if (r106 == null) goto L14;
        r106.setVisibility(8);
        goto L14
    L17:
        ItemGroup r107 = r101.P();
        if (r107 == null) goto L24;
        r107.setVisibility(8);
        Unit r108 = Unit.INSTANCE;
        return;
    }

    public static final void ma0(CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L17;
        Iterator r102 = CollectionsKt.listOf(new ItemGroup[]{r101.M(), r101.N(), r101.O(), r101.P(), r101.Q(), r101.m0(), r101.U0(), r101.n0(), r101.r0(), r101.g(), r101.o0(), r101.p0(), r101.h0(), r101.i()}).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        ItemGroup r103 = (ItemGroup) r102.next();
        if (r103 == null) goto L6;
        r103.c();
        goto L6
    L10:
        Unit r104 = Unit.INSTANCE;
        return;
    }

    public static final void na0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.X().getVisibility() != 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
    L31:
        Unit r103 = Unit.INSTANCE;
        return;
    L11:
        if (r101.b1() == false) goto L30;
        AppHost.Companion r104 = AppHost.f326268a;
        String r105 = "";
        if (r104.isOversea() == true) goto L22;
        ItemTextArrow r106 = r101.X();
        Context r107 = r100.getContext();
        if (r107 == null) goto L21;
        String r108 = r107.getString(R.string.larus_settings_account_manage_avatar_cn);
        if (r108 == null) goto L21;
        String r109 = String.format(r108, Arrays.copyOf(new Object[]{r104.getAppStringName()}, 1));
        if (r109 == null) goto L21;
        r105 = r109;
    L21:
        r106.setText(r105);
        goto L30
    L22:
        ItemTextArrow r110 = r101.X();
        Context r111 = r100.getContext();
        if (r111 == null) goto L29;
        String r112 = r111.getString(R.string.larus_settings_account_manage_avatar_global);
        if (r112 == null) goto L29;
        String r113 = String.format(r112, Arrays.copyOf(new Object[]{r104.getAppStringName()}, 1));
        if (r113 == null) goto L29;
        r105 = r113;
    L29:
        r110.setText(r105);
    L30:
        com.larus.utils.e1.d(r101.X(), new n3(r100));
        goto L31
    L7:
        r102 = false;
        goto L8
    }

    public static final void oa0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L18;
        final com.larus.bmhome.setting.c r104 = r100.f296459g;
        if (r104 != null) goto L12;
        return;
    L12:
        if (((Boolean) r100.N.getValue()).booleanValue() == true) goto L14;
    L17:
        Unit r105 = Unit.INSTANCE;
        return;
    L14:
        if (r100.I != null) goto L17;
        AppCompatTextView r106 = new AppCompatTextView(r104.P0().getContext());
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(-1, v19.i5.f0());
        r107.bottomMargin = v19.i5.T();
        r107.topMargin = v19.i5.q();
        r106.setLayoutParams(r107);
        r106.setGravity(17);
        r106.setTextSize(14.0f);
        r106.setTextColor(ContextCompat.getColor(r106.getContext(), v19.c.b(R.attr.larus_primary_50, r106.getContext(), R.color.larus_primary_50)));
        r100.I = r106;
        r104.P0().post(new j3(r100, r104));
        goto L17
    L18:
        com.larus.bmhome.setting.c r108 = r100.f296459g;
        TextView r109 = null;
        if (r108 == null) goto L23;
        TextView r110 = r108.c0();
        if (r110 == null) goto L23;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
    L25:
        if ((r111 instanceof LinearLayout.LayoutParams) == false) goto L27;
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r111;
    L28:
        com.larus.bmhome.setting.c r113 = r100.f296459g;
        if (r113 == null) goto L38;
        TextView r114 = r113.V();
        if (r114 == null) goto L38;
        if (r114.getVisibility() != 0) goto L35;
        boolean r115 = true;
    L36:
        if (r115 != true) goto L38;
        r102 = true;
        goto L38
    L35:
        r115 = false;
    L38:
        if (r102 == false) goto L41;
        if (r112 == null) goto L43;
        r112.topMargin = c7.b(8);
    L43:
        com.larus.bmhome.setting.c r116 = r100.f296459g;
        if (r116 == null) goto L49;
        TextView r117 = r116.c0();
        if (r117 == null) goto L49;
        r117.setLayoutParams(r112);
    L49:
        if (((Boolean) r100.N.getValue()).booleanValue() == false) goto L55;
        com.larus.bmhome.setting.c r118 = r100.f296459g;
        if (r118 == null) goto L60;
        TextView r119 = r118.c0();
        if (r119 == null) goto L60;
        com.larus.utils.e1.x(r119);
    L60:
        com.larus.bmhome.setting.c r120 = r100.f296459g;
        if (r120 == null) goto L63;
        r109 = r120.c0();
    L63:
        r100.fb0(r109);
        return;
    L55:
        com.larus.bmhome.setting.c r121 = r100.f296459g;
        if (r121 == null) goto L60;
        TextView r122 = r121.c0();
        if (r122 == null) goto L60;
        com.larus.utils.e1.o(r122);
        goto L60
    L41:
        if (r112 == null) goto L43;
        r112.topMargin = c7.b(24);
        goto L43
    L27:
        r112 = null;
    L23:
        r111 = null;
        goto L25
    L5:
        if (r101.b1() != true) goto L7;
        r103 = true;
        goto L8
    }

    public static final void pa0(final CommonSettingFragment r100) {
        final com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L28;
        BotModel r102 = r100.f296475s;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r102 = null;
    L7:
        BotMemoryConfig r103 = r102.getBotMemoryConfig();
        if (r103 == null) goto L10;
        boolean r104 = Intrinsics.areEqual(r103.getEnableBotMemory(), Boolean.TRUE);
    L11:
        if (r104 == true) goto L13;
    L26:
        r101.e0().setVisibility(8);
        Unit r105 = Unit.INSTANCE;
        return;
    L13:
        if (r101.e0().getTag() != null) goto L26;
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L26;
        BotModel r106 = r100.f296475s;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r106 = null;
    L19:
        BotMemoryConfig r107 = r106.getBotMemoryConfig();
        if (r107 == null) goto L29;
        r101.e0().setVisible(true);
        com.larus.utils.e1.d(r101.e0(), new z(r100, r101));
        if (Intrinsics.areEqual(r107.getSwitchStatus(), Boolean.TRUE) == false) goto L24;
        r101.e0().Z5(r100.getString(R.string.larus_settings_memory_on), null);
    L25:
        Unit r108 = Unit.INSTANCE;
        return;
    L24:
        r101.e0().Z5(r100.getString(R.string.larus_settings_memory_off), null);
        goto L25
    L29:
        return;
    L10:
        r104 = false;
        goto L11
    }

    public static final void qa0(final CommonSettingFragment r100) {
        if (r100.isAdded() == true) goto L5;
    L24:
        FLogger.f375446a.i(r100.f296457e, "setupMembershipEntry skipped: fragment not ready");
        return;
    L5:
        if (r100.getView() == null) goto L24;
        ICommerceMembershipService.f325827a.getClass();     // Catch: Exception -> L22
        ICommerceMembershipService r101 = ICommerceMembershipService.a.a();     // Catch: Exception -> L22
        if (r101 == null) goto L10;
        uz8.f r102 = r101.y();     // Catch: Exception -> L22
    L11:
        r100.vb0(r102);     // Catch: Exception -> L22
        if (r101 == null) goto L15;
        r101.c(LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner()), new v(r100));     // Catch: Exception -> L22
    L15:
        if (r100.C == true) goto L28;
        r100.C = true;     // Catch: Exception -> L22
        if (r101 == null) goto L19;
        r101.a("onSetupMembershipSettingEntry");     // Catch: Exception -> L22
    L19:
        if (r101 == null) goto L29;
        r101.g("SETTINGS");     // Catch: Exception -> L22
        return;
    L29:
        return;
    L28:
        return;
    L10:
        r102 = null;
    L22:
        e = move-exception;
        FLogger.f375446a.e(r100.f296457e, "setupMembershipEntry failed", e);
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
    }

    public static final void ra0(final CommonSettingFragment r100) {
        final com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L46;
        FLogger r102 = FLogger.f375446a;
        String r103 = r100.f296457e;
        StringBuilder r104 = new StringBuilder("setupNickName callerName: ");
        BotModel r105 = r100.f296475s;
        BotModel r106 = null;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r105 = null;
    L7:
        r104.append(r105.getCallerName());
        r104.append(" , setting -> ");
        BotModel r107 = r100.f296475s;
        if (r107 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r107 = null;
    L10:
        r104.append(r107.getCallerNameSetting());
        r102.d(r103, r104.toString());
        BotModel r108 = r100.f296475s;
        if (r108 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r108 = null;
    L13:
        String r109 = r108.getCallerName();
        int r110 = 0;
        if (r109 != null) goto L16;
    L19:
        boolean r111 = true;
    L20:
        if (r111 == true) goto L27;
        ItemTextArrow r112 = r101.x0();
        if (r112 == null) goto L27;
        BotModel r113 = r100.f296475s;
        if (r113 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r113 = null;
    L26:
        String r114 = String.valueOf(r113.getCallerName());
        int r115 = ItemTextArrow.f316958k;
        r112.Z5(r114, null);
    L27:
        ItemTextArrow r116 = r101.x0();
        if (r116 == null) goto L30;
        r116.setImageSrc(R.drawable.larus_icon_nick_name);
    L30:
        ItemTextArrow r117 = r101.x0();
        if (r117 == null) goto L33;
        r117.setOnClickListener(new y3(r100, r101));
    L33:
        ItemTextArrow r118 = r101.x0();
        if (r118 == null) goto L44;
        BotModel r119 = r100.f296475s;
        if (r119 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L40:
        if (Intrinsics.areEqual(r106.getCallerNameSetting(), Boolean.TRUE) == true) goto L43;
        r110 = 8;
    L43:
        r118.setVisibility(r110);
        goto L44
    L38:
        r106 = r119;
    L44:
        Unit r120 = Unit.INSTANCE;
        return;
    L16:
        if (r109.length() == 0) goto L19;
        r111 = false;
        goto L20
    }

    public static final void sa0(final CommonSettingFragment r100) {
        BotModel r101 = r100.f296475s;
        if (r101 == null) goto L21;
        final String r102 = r101.getBotId();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        com.larus.bmhome.setting.c r103 = r100.f296459g;
        if (r103 == null) goto L22;
        final ItemTextArrow r104 = r103.D0();
        if (r104 == null) goto L23;
        PluginManagerDelegate r105 = PluginManagerDelegate.f297308a;
        Intrinsics.checkNotNullParameter(r102, "botId");
        ConcurrentHashMap<String, PluginManager> r106 = PluginManager.f297302d;
        CopyOnWriteArrayList<PluginItem> r107 = PluginManager.a.a(r102).f297305a.f297288d;
        if (r107 != null) goto L15;
    L18:
        boolean r108 = true;
    L19:
        r104.setVisible(!r108);
        com.larus.utils.e1.d(r104, new s4(r100, r102));
        PluginManagerDelegate.r(r102, true, null, new t4(r104));
        return;
    L15:
        if (r107.isEmpty() == true) goto L18;
        r108 = false;
        goto L19
    L23:
        return;
    L22:
        return;
    }

    public static final void ta0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L37;
        Context r102 = r100.getContext();
        if (r102 == null) goto L38;
        final ItemTextArrow r103 = r101.O0();
        if (r103 == null) goto L39;
        BotModel r104 = r100.f296475s;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r104 = null;
    L11:
        Integer r105 = r104.getBotStatus();
        if (r105 != null) goto L15;
    L16:
        BotModel r106 = r100.f296475s;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r106 = null;
    L19:
        Integer r107 = r106.getBotStatus();
        if (r107 != null) goto L23;
    L33:
        ItemGroup r108 = r101.S();
        if (r108 == null) goto L41;
        r108.setVisibility(8);
        return;
    L41:
        return;
    L23:
        if (r107.intValue() != (-30)) goto L33;
    L24:
        BotModel r109 = r100.f296475s;
        if (r109 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r109 = null;
    L28:
        if (r109.getBotMode() != 1) goto L33;
        ItemGroup r110 = r101.S();
        if (r110 == null) goto L32;
        r110.setVisibility(0);
    L32:
        r103.setVisible(true);
        r103.setTextColor(ContextCompat.getColor(r102, R.color.larus_danger_50));
        r103.getSubTextView().setVisibility(0);
        r103.Z5(r100.getString(R.string.larus_review_failed_modify), null);
        r103.getSubTextView().setTextColor(ContextCompat.getColor(r102, v19.c.b(R.attr.larus_primary_50, r102, R.color.larus_primary_50)));
        r103.getArrowView().setVisibility(8);
        com.larus.utils.e1.d(r103, new e4(r100, r103));
        return;
    L15:
        if (r105.intValue() == (-50)) goto L24;
    L39:
        return;
    L38:
        return;
    }

    public static final void ua0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r101 == null) goto L39;
        final String r102 = r100.f296469n;
        BotModel r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r102 = null;
    L8:
        if (r102.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L14;
        r102 = r100.La0();
    L14:
        if (r100.f296468m == 3) goto L34;
        Boolean r105 = Boolean.TRUE;
        BotModel r106 = r100.f296475s;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r106 = null;
    L19:
        if (Intrinsics.areEqual(r105, r106.getShowMessagePush()) == false) goto L34;
        if (ic8.n.r(r100.f296473q) == true) goto L34;
        ItemGroup r107 = r101.O();
        if (r107 == null) goto L25;
        com.larus.utils.e1.x(r107);
    L25:
        final ItemTextToggle r108 = r101.k0();
        if (r108 == null) goto L37;
        CustomSwitchCompat r109 = r108.getToggleView();
        BotModel r110 = r100.f296475s;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L31:
        r109.setChecked(Intrinsics.areEqual(r105, r103.getMessagePush()));
        r108.getToggleView().setOnCheckedChangeListener(new o4(r100, r102));
        final LifecycleOwner r111 = ViewTreeLifecycleOwner.get(r108.getToggleView());
        if (r111 == null) goto L37;
        r100.Ja0().getMessagePushLiveData().observe(r111, new e(new p4(r111, r108, r100)));
        goto L37
    L30:
        r103 = r110;
    L37:
        r100.kb0();
        com.larus.utils.e1.d(r101.N0(), new q4(r100, r102));
        Unit r112 = Unit.INSTANCE;
        return;
    L34:
        ItemGroup r113 = r101.O();
        if (r113 == null) goto L37;
        r113.setVisibility(8);
        goto L37
    L10:
        r104 = false;
        goto L11
    }

    public static final void va0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r100.getView() == null) goto L5;
        LifecycleOwner r102 = r100.getViewLifecycleOwner();
    L6:
        if (r102 == null) goto L10;
        r100.Ja0().getResetBotInfo().observe(r102, new e(new x3(r100)));
        return;
    L10:
        return;
    L5:
        r102 = r100.getActivity();
        goto L6
    }

    public static final void wa0(final CommonSettingFragment r110) {
        com.larus.bmhome.setting.c r100 = r110.f296459g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (com.larus.platform.service.z2.f365865a.q3() == false) goto L23;
        ChatControlTrace r101 = ChatControlTrace.f309996b;
        Integer r102 = Integer.valueOf(r110.f296468m);
        BotModel r103 = r110.f296475s;
        String r104 = null;
        if (r103 == null) goto L9;
        Integer r105 = r103.getBotType();
    L10:
        BotModel r106 = r110.f296475s;
        if (r106 == null) goto L16;
        BotCreatorInfo r107 = r106.getBotCreatorInfo();
        if (r107 == null) goto L15;
        r104 = r107.getId();
    L15:
        boolean r108 = Intrinsics.areEqual(r104, AccountService.f365697a.getUserId());
    L17:
        final String r109 = r101.g(r102, r105, r108);
        ItemGroup r111 = r100.T();
        if (r111 == null) goto L20;
        r111.setVisibility(0);
    L20:
        r100.S0().setVisibility(0);
        com.larus.utils.e1.d(r100.S0(), new n2(r110, r109));
        if (r110.B == true) goto L27;
        r110.B = true;
        tx9.i3.b(null, null, null, null, null, "chat", new JSONObject().put("bot_id", r110.S).put("function_type", "chat_search").put("show_method", "default").put("chat_type", r109), r110, 31);
    L27:
        Unit r112 = Unit.INSTANCE;
        return;
    L16:
        r108 = false;
        goto L17
    L9:
        r105 = null;
        goto L10
    L23:
        ItemGroup r113 = r100.T();
        if (r113 == null) goto L26;
        r113.setVisibility(8);
    L26:
        r100.S0().setVisibility(8);
        goto L27
    }

    public static final void xa0(final CommonSettingFragment r100) {
        String r101 = r100.f296469n;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r101 = null;
    L6:
        if (com.larus.utils.o0.d(r101) == true) goto L8;
    L21:
        com.larus.bmhome.setting.c r102 = r100.f296459g;
        if (r102 == null) goto L30;
        ItemGroup r103 = r102.U();
        if (r103 == null) goto L31;
        com.larus.utils.e1.o(r103);
        return;
    L31:
        return;
    L30:
        return;
    L8:
        if (r100.Ua0() == true) goto L21;
        if (Build.VERSION.SDK_INT < 26) goto L21;
        com.larus.bmhome.setting.c r104 = r100.f296459g;
        if (r104 == null) goto L16;
        ItemGroup r105 = r104.U();
        if (r105 == null) goto L16;
        com.larus.utils.e1.x(r105);
    L16:
        com.larus.bmhome.setting.c r106 = r100.f296459g;
        if (r106 == null) goto L27;
        ItemTextView r107 = r106.d();
        if (r107 == null) goto L28;
        com.larus.utils.e1.d(r107, new p3(r100));
        return;
    L28:
        return;
    }

    public static final void ya0(final CommonSettingFragment r100) {
        com.larus.bmhome.setting.c r101 = r100.f296459g;
        if (r100.getView() == null) goto L5;
        LifecycleOwner r102 = r100.getViewLifecycleOwner();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r100.A == true) goto L12;
        r100.Ja0().getSubjectBotInfo().observe(r102, new e(new x4(r100)));
        return;
    L12:
        return;
    L5:
        r102 = r100.getActivity();
        goto L6
    }

    public static final void za0(final CommonSettingFragment r100) {
        r100.getClass();
        if (com.larus.platform.service.z2.f365865a.enableSubscription() == false) goto L6;
        com.larus.platform.service.c2.f365725a.e().observe(r100.getViewLifecycleOwner(), new e(new f2(r100)));
        return;
    }

    public final String Ka0(EnterKeyAction r100) {
        if (r100 != EnterKeyAction.NEWLINE) goto L5;
        int r101 = R.string.larus_settingsPreference_return;
    L6:
        Context r102 = getContext();
        if (r102 == null) goto L9;
        String r103 = r102.getString(r101);
    L10:
        if (r103 != null) goto L13;
        return "";
    L13:
        return r103;
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = R.string.larus_settingsPreference_sendMessage;
        goto L6
    }

    public final void N9(String r110) {
        Intrinsics.checkNotNullParameter(r110, "leaveMethod");
        int r100 = 1;
        boolean r101 = false;
        if (this.f296455J == false) goto L13;
        if (Intrinsics.areEqual(r110, "system_back_button") == false) goto L7;
    L8:
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L97;
        r111.setResult(100, new Intent().putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("previous_page", k())})));
        return;
    L97:
        return;
    L7:
        if (Intrinsics.areEqual(r110, "click_back_button") == true) goto L8;
        return;
    L13:
        if (this.f296475s != null) goto L15;
        return;
    L15:
        FragmentActivity r102 = getActivity();
        String r103 = null;
        if (r102 == null) goto L34;
        Intent r104 = new Intent();
        Pair[] r105 = new Pair[9];
        r105[0] = TuplesKt.to("argPreviousPage", this.f296477u);
        r105[1] = TuplesKt.to("navigate_up_from", "bot_setting");
        r105[2] = TuplesKt.to("conversation_exit", Boolean.TRUE);
        r105[3] = TuplesKt.to("conversationId", this.f296479w);
        BotModel r106 = this.f296475s;
        if (r106 == null) goto L20;
        SpeakerVoice r107 = r106.getVoiceType();
    L21:
        r105[4] = TuplesKt.to("select_speaker_result", r107);
        BotModel r108 = this.f296475s;
        if (r108 == null) goto L24;
        String r109 = r108.getCallerName();
    L25:
        r105[5] = TuplesKt.to("nick_name_update", r109);
        BotModel r112 = this.f296475s;
        if (r112 == null) goto L28;
        ModelItem r113 = r112.getModel();
    L29:
        r105[6] = TuplesKt.to("select_model_result", r113);
        BotModel r114 = this.f296475s;
        if (r114 == null) goto L32;
        boolean r115 = r114.getMuted();
    L33:
        r105[7] = TuplesKt.to("bot_is_mute", Boolean.valueOf(r115));
        r105[8] = TuplesKt.to("leave_method", r110);
        r102.setResult(100, r104.putExtras(com.larus.utils.f.c(r105)));
        goto L34
    L32:
        r115 = false;
        goto L33
    L28:
        r113 = null;
        goto L29
    L24:
        r109 = null;
        goto L25
    L20:
        r107 = null;
    L34:
        JSONObject r116 = new JSONObject();
        com.larus.bmhome.setting.c r117 = this.f296459g;
        if (r117 == null) goto L43;
        ItemTextToggle r118 = r117.k0();
        if (r118 == null) goto L43;
        CustomSwitchCompat r119 = r118.getToggleView();
        if (r119 == null) goto L43;
        if (r119.isChecked() != true) goto L43;
    L44:
        r116.put("notify_push", r100);
        com.larus.bmhome.setting.c r120 = this.f296459g;
        if (r120 == null) goto L51;
        ItemTextArrow r121 = r120.Z0();
        if (r121 == null) goto L51;
        TextView r122 = r121.getSubTextView();
        if (r122 == null) goto L51;
        CharSequence r123 = r122.getText();
    L52:
        r116.put("voice", r123);
        com.larus.bmhome.setting.c r124 = this.f296459g;
        if (r124 == null) goto L59;
        ItemLongTextArrow r125 = r124.b();
        if (r125 == null) goto L59;
        TextView r126 = r125.getTextView();
        if (r126 == null) goto L59;
        CharSequence r127 = r126.getText();
    L60:
        r116.put("bot_status", r127);
        com.larus.bmhome.setting.c r128 = this.f296459g;
        if (r128 == null) goto L67;
        ItemTextArrow r129 = r128.b0();
        if (r129 == null) goto L67;
        TextView r130 = r129.getSubTextView();
        if (r130 == null) goto L67;
        CharSequence r131 = r130.getText();
    L68:
        r116.put("language", r131);
        RecommendFrom r132 = Na0();
        if (r132 == null) goto L71;
        String r133 = r132.f365483b;
    L72:
        r116.put("req_id", r133);
        r116.put("leave_method", r110);
        ChatControlTrace r134 = ChatControlTrace.f309996b;
        Integer r135 = Integer.valueOf(this.f296468m);
        BotModel r136 = this.f296475s;
        if (r136 == null) goto L75;
        Integer r137 = r136.getBotType();
    L76:
        BotModel r138 = this.f296475s;
        if (r138 == null) goto L83;
        BotCreatorInfo r139 = r138.getBotCreatorInfo();
        if (r139 == null) goto L81;
        String r140 = r139.getId();
    L82:
        r101 = Intrinsics.areEqual(r140, AccountService.f365697a.getUserId());
        goto L83
    L81:
        r140 = null;
    L83:
        r116.put("chat_type", r134.g(r135, r137, r101));
        BotModel r141 = this.f296475s;
        if (r141 == null) goto L86;
        r103 = r141.getBotId();
    L86:
        Intrinsics.checkNotNullParameter(r116, "params");
        if (r103 != null) goto L94;
    L92:
        TrackParams r142 = new TrackParams().merge(r116);
        by7.a r143 = new by7.a("leave_botsetting_page");
        r143.f21464b = this;
        r143.f21463a.merge(r142);
        r143.b();
        return;
    L94:
        r116.put("bot_id", r103);     // Catch: JSONException -> L90
    L90:
        e = move-exception;
        FLogger.f375446a.e("LeaveEventHelper", "error in LeaveEventHelper leaveBotsettingPage " + e.getLocalizedMessage());
        goto L92
    L75:
        r137 = null;
        goto L76
    L71:
        r133 = null;
    L67:
        r131 = null;
    L59:
        r127 = null;
    L51:
        r123 = null;
    L43:
        r100 = 0;
        goto L44
    }

    public final String Pa0(final DefaultReplyMenuDataV2 r110) {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        String r101 = null;
        if (r100 == null) goto L95;
        ItemTextMenu r102 = r100.y();
        if (r102 == null) goto L95;
        ReplyOption r103 = Oa0();
        com.larus.bmhome.setting.c r104 = this.f296459g;
        if (r104 == null) goto L95;
        ItemTextMenu r105 = r104.y();
        if (r105 == null) goto L95;
        final ImageView r106 = r105.getMenuArrowView();
        if (r106 == null) goto L95;
        if (r103 == null) goto L17;
        ModelItemIdentity r107 = r103.getModel();
        if (r107 == null) goto L17;
    L18:
        if (r103 == null) goto L21;
        String r108 = r103.getModeId();
        if (r108 == null) goto L21;
    L42:
        DefaultReplyMenuConfigV2 r109 = r110.getMenuConfV2();
        if (r109 == null) goto L47;
        DefaultReplySwitchModeConfig r111 = r109.getModeList();
        if (r111 == null) goto L47;
        List<DefaultReplySwitchMenuMode> r112 = r111.getItemList();
    L48:
        if (r112 != null) goto L50;
        r112 = CollectionsKt.emptyList();
    L50:
        boolean r113 = false;
        if (r108 == null) goto L65;
        Iterator<T> r114 = r112.iterator();
    L54:
        if (r114.hasNext() == false) goto L62;
        Object r115 = r114.next();
        DefaultReplySwitchMenuMode r116 = (DefaultReplySwitchMenuMode) r115;
        if (r116 == null) goto L58;
        String r117 = r116.getModeId();
    L60:
        if (Intrinsics.areEqual(r117, r108) == false) goto L54;
    L63:
        DefaultReplySwitchMenuMode r118 = (DefaultReplySwitchMenuMode) r115;
        if (r118 == null) goto L65;
    L83:
        if (r118 != null) goto L86;
        com.larus.utils.e1.o(r102);
        return null;
    L86:
        String r119 = r118.getSelectedName();
        if (r119 != null) goto L89;
    L90:
        r113 = true;
    L91:
        if (r113 == false) goto L93;
        r101 = r118.getName();
    L94:
        r102.setSubText(r101);
        r102.setOnMenuClickListener(new o0(this, r106, r110));
        com.larus.utils.e1.x(r102);
        goto L95
    L93:
        r101 = r118.getSelectedName();
        goto L94
    L89:
        if (r119.length() != 0) goto L91;
    L58:
        r117 = null;
        goto L60
    L62:
        r115 = null;
    L65:
        Iterator<T> r120 = r112.iterator();
    L67:
        if (r120.hasNext() == false) goto L81;
        Object r121 = r120.next();
        DefaultReplySwitchMenuMode r122 = (DefaultReplySwitchMenuMode) r121;
        if (r122 == null) goto L71;
        String r123 = r122.getModeId();
    L72:
        if (r123 != null) goto L74;
    L77:
        boolean r124 = true;
    L79:
        if ((!r124) == false) goto L67;
    L82:
        r118 = (DefaultReplySwitchMenuMode) r121;
        goto L83
    L74:
        if (r123.length() == 0) goto L77;
        r124 = false;
        goto L79
    L71:
        r123 = null;
        goto L72
    L81:
        r121 = null;
    L47:
        r112 = null;
    L21:
        DefaultReplyMenuConfigV2 r125 = r110.getMenuConfV2();
        if (r125 == null) goto L41;
        DefaultReplySwitchMenuConfig r126 = r125.getModelList();
        if (r126 == null) goto L41;
        List<DefaultReplySwitchMenuItem> r127 = r126.getItemList();
        if (r127 == null) goto L41;
        Iterator<T> r128 = r127.iterator();
    L29:
        if (r128.hasNext() == false) goto L37;
        Object r129 = r128.next();
        DefaultReplySwitchMenuItem r130 = (DefaultReplySwitchMenuItem) r129;
        if (r130 == null) goto L33;
        String r131 = r130.getModelItemKey();
    L35:
        if (Intrinsics.areEqual(r131, r107.getKey()) == false) goto L29;
    L38:
        DefaultReplySwitchMenuItem r132 = (DefaultReplySwitchMenuItem) r129;
        if (r132 == null) goto L41;
        r108 = r132.getDefaultMode();
        goto L42
    L33:
        r131 = null;
        goto L35
    L37:
        r129 = null;
    L41:
        r108 = null;
    L17:
        r107 = Ia0().getDefaultModelItemKey();
    L95:
        return r101;
    }

    public final Unit Sa0(BotModel r110) {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.X().getVisibility() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L36;
        if (r100.b1() == false) goto L30;
        LaunchInfo r102 = AuthModelDelegate.f297134b.x().getValue();
        if (r102 == null) goto L27;
        List<CocoSetting> r103 = r102.s();
        if (r103 == null) goto L27;
        Iterator<T> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L21;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(String.valueOf(((CocoSetting) r105).a()), r110.getBotIconMappedAppIcon()) == false) goto L17;
    L22:
        CocoSetting r106 = (CocoSetting) r105;
        if (r106 == null) goto L27;
        String r107 = r106.g();
        if (r107 == null) goto L27;
    L34:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CommonSettingFragment$iconEditItemLoad$1$1(r107, r100, null), 2, null);
        goto L36
    L21:
        r105 = null;
    L27:
        BotIconImage r111 = r110.getIconImage();
        if (r111 == null) goto L33;
        r107 = r111.getOriginUrl();
    L33:
        r107 = null;
        goto L34
    L30:
        BotIconImage r112 = r110.getIconImage();
        if (r112 == null) goto L33;
        r107 = r112.getOriginUrl();
    L36:
        return Unit.INSTANCE;
    L7:
        r101 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [T, android.app.Dialog, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bmhome.bot.y1] */
    public final void Ya0(String r110) {
        if (isAdded() == true) goto L5;
        return;
    L5:
        final FragmentActivity r100 = getActivity();
        if (r100 != null) goto L8;
        return;
    L8:
        boolean r101 = true;
        if (this.f296468m == 1) goto L11;
    L15:
        r101 = false;
    L16:
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        if (r101 == false) goto L19;
        ?? r103 = new BotAvatarViewerCanChangeIconDialog(r100, r110, new y1(r102, this, r100));
    L20:
        r102.element = r103;
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L27;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L27:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L26
    L24:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        return;
    L19:
        r103 = new BotAvatarViewerDialog(r100, r110, false, true, "bot_setting", null, null);
        goto L20
    L11:
        if (AuthModelDelegate.f297134b.z() == false) goto L15;
        if (com.larus.platform.service.i3.f365750a.i() == true) goto L15;
        goto L15
    }

    public final void bb0(String r100) {
        com.larus.bmhome.setting.c r101 = this.f296459g;
        if (r101 == null) goto L11;
        TextView r102 = r101.r();
        if (r102 == null) goto L12;
        if (r100 == null) goto L8;
        String r103 = StringsKt.replace$default(r100, "\n", "", false, 4, null);
    L9:
        r102.setText(r103);
        return;
    L8:
        r103 = null;
        goto L9
    L12:
        return;
    }

    public final void cb0(List<ShowTagInfo> r100) {
        if (r100 == null) goto L13;
        Iterator<T> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L13;
        ShowTagInfo r102 = (ShowTagInfo) r101.next();
        if (com.larus.utils.o0.d(r102.getNameToShow()) == false) goto L5;
        if (r102.getType() == 3) goto L14;
        if (r102.getType() != 2) goto L5;
    L14:
        if (r102 == null) goto L23;
        com.larus.bmhome.setting.c r103 = this.f296459g;
        if (r103 == null) goto L36;
        TagTextView r104 = r103.t();
        if (r104 == null) goto L37;
        com.larus.utils.e1.x(r104);
        String r105 = r102.getNameToShow();
        if (r105 != null) goto L22;
        r105 = "";
    L22:
        r104.x(r105, vb8.a.d(Integer.valueOf(r102.getType())));
        return;
    L37:
        return;
    L36:
        return;
    L23:
        com.larus.bmhome.setting.c r106 = this.f296459g;
        if (r106 == null) goto L39;
        TagTextView r107 = r106.t();
        if (r107 == null) goto L40;
        com.larus.utils.e1.o(r107);
        return;
    L40:
        return;
    L39:
        return;
    L13:
        r102 = null;
        goto L14
    }

    public final Integer db0(uz8.d r100) {
        Context r101 = getContext();
        if (r101 == null) goto L7;
        boolean r102 = v19.h.f552477a;
        boolean r103 = true;
        if (v19.h.b(r101) != true) goto L7;
    L8:
        Object r104 = null;
        if (r103 == false) goto L12;
        if (r100 == null) goto L14;
        String r105 = r100.darkColor;
    L15:
        if (r105 == null) goto L28;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L18
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor(r105)));     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r107) == true) goto L25;
        r104 = r107;
    L25:
        return (Integer) r104;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L28:
        return null;
    L14:
        r105 = null;
        goto L15
    L12:
        if (r100 == null) goto L14;
        r105 = r100.lightColor;
    L7:
        r103 = false;
        goto L8
    }

    public final void fb0(TextView r100) {
        if (this.f296459g == null) goto L36;
        BotModel r101 = this.f296475s;
        BotModel r102 = null;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r101 = null;
    L7:
        Integer r103 = r101.getBotType();
        boolean r104 = true;
        if (r103 != null) goto L11;
    L13:
        BotModel r105 = this.f296475s;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L17:
        List<ShowTagInfo> r106 = r102.getTagList();
        if (r106 == null) goto L25;
        Iterator<T> r107 = r106.iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        if (((ShowTagInfo) r107.next()).getType() != 2) goto L21;
    L26:
        if (r104 == false) goto L28;
        ((hq9.a2) this.O.getValue()).getClass();
    L29:
        if (r100 == null) goto L31;
        r100.setVisibility(8);
    L31:
        Unit r108 = Unit.INSTANCE;
        return;
    L28:
        ((hq9.a2) this.O.getValue()).getClass();
    L25:
        r104 = false;
        goto L26
    L16:
        r102 = r105;
        goto L17
    L11:
        if (r103.intValue() != 1) goto L13;
        ((hq9.a2) this.O.getValue()).getClass();
        goto L29
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.larus.trace.tracknode.a.C4500a.a(this, r100);
        if (this.f296455J == false) goto L6;
        r100.put("encrypted_status", com.larus.platform.service.z2.f365865a.u2());
        return;
    L6:
        SearchMobParam r101 = this.f296480x;
        String r102 = null;
        if (r101 == null) goto L9;
        String r103 = r101.f365487a;
    L10:
        r100.putIfNull("query", r103);
        SearchMobParam r104 = this.f296480x;
        if (r104 == null) goto L13;
        String r105 = r104.f365488b;
    L14:
        r100.putIfNull("query_id", r105);
        SearchMobParam r106 = this.f296480x;
        if (r106 == null) goto L17;
        String r107 = r106.f365489c;
    L18:
        r100.putIfNull("search_id", r107);
        SearchMobParam r108 = this.f296480x;
        if (r108 == null) goto L21;
        String r109 = r108.f365490d;
    L22:
        r100.putIfNull("search_request_id", r109);
        SearchMobParam r110 = this.f296480x;
        if (r110 == null) goto L25;
        String r111 = r110.f365491e;
    L26:
        r100.putIfNull("search_result_id", r111);
        SearchMobParam r112 = this.f296480x;
        if (r112 == null) goto L29;
        r102 = r112.f365492f;
    L29:
        r100.putIfNull("rank", r102);
        return;
    L25:
        r111 = null;
        goto L26
    L21:
        r109 = null;
        goto L22
    L17:
        r107 = null;
        goto L18
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [com.larus.bmhome.bot.share.ShareBotController$performShareBot$1] */
    public final void ob0(boolean r110) {
        BotModel r100 = null;
        String r101 = null;
        String r102 = null;
        if (r110 == false) goto L134;
        com.larus.platform.service.z2 r111 = com.larus.platform.service.z2.f365865a;
        if (r111.x3().getDisableBotShare() == false) goto L17;
        wc9.e r103 = this.f296473q;
        if (r103 == null) goto L9;
        Integer r104 = r103.f559219v;
    L10:
        BotModel r105 = this.f296475s;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r105 = null;
    L14:
        if (nq9.h.a(r104, r105.getBotType()) == false) goto L17;
        return;
    L9:
        r104 = null;
    L17:
        if (an() == false) goto L27;
        BotModel r106 = this.f296475s;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r106 = null;
    L21:
        Integer r107 = r106.getPrivateStatus();
        if (r107 == null) goto L27;
        if (r107.intValue() != 2) goto L27;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommonSettingFragment$shareClickActionWhenEnabled$1(this, null), 3, null);
    L27:
        final ShareBotController r108 = (ShareBotController) this.H.getValue();
        final wc9.e r109 = this.f296473q;
        BotModel r112 = this.f296475s;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        final BotModel r113 = null;
    L31:
        r108.getClass();
        Intrinsics.checkNotNullParameter(r113, "botModel");
        if (r109 != null) goto L34;
    L48:
        wc9.e r114 = this.f296473q;
        boolean r115 = false;
        if (r114 == null) goto L56;
        Integer r116 = r114.f559219v;
        if (r116 == null) goto L56;
        if (r116.intValue() != 3) goto L56;
        boolean r117 = true;
    L58:
        if (r117 == true) goto L107;
        com.larus.audio.p0 r118 = AudioServiceDelegate.f288288a.getAudioConfig();
        BotModel r119 = this.f296475s;
        if (r119 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r119 = null;
    L63:
        if (r118.n(r119) == false) goto L65;
        String r120 = "1";
    L66:
        ChatControlTrace r121 = ChatControlTrace.f309996b;
        JSONObject r122 = r121.Xb(Na0());
        if (Na0() != null) goto L79;
        Bundle r123 = getArguments();
        if (r123 == null) goto L71;
        String r124 = r123.getString("argBotCaseFrom");
    L73:
        if (com.larus.utils.o0.d(r124) == false) goto L79;
        Bundle r125 = getArguments();
        if (r125 == null) goto L77;
        String r126 = r125.getString("argBotCaseFrom");
    L78:
        r122.put("recommend_from", r126);
        goto L79
    L77:
        r126 = null;
        goto L78
    L71:
        r124 = null;
    L79:
        BotModel r127 = this.f296475s;
        if (r127 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r127 = null;
    L82:
        r122.put("bot_id", r127.getBotId());
        BotModel r128 = this.f296475s;
        if (r128 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r128 = null;
    L85:
        r122.put("item_id", r128.getBotId());
        String r129 = this.f296469n;
        if (r129 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r129 = null;
    L88:
        r122.put("conversation_id", r129);
        Integer r130 = Integer.valueOf(this.f296468m);
        BotModel r131 = this.f296475s;
        if (r131 == null) goto L91;
        Integer r132 = r131.getBotType();
    L92:
        BotModel r133 = this.f296475s;
        if (r133 == null) goto L99;
        BotCreatorInfo r134 = r133.getBotCreatorInfo();
        if (r134 == null) goto L97;
        String r135 = r134.getId();
    L98:
        r115 = Intrinsics.areEqual(r135, AccountService.f365697a.getUserId());
        goto L99
    L97:
        r135 = null;
    L99:
        r122.put("chat_type", r121.g(r130, r132, r115));
        r122.put("group_type", BridgePrivilege.PRIVATE);
        r122.put("is_immersive_background", ve8.c.b(Ta0()));
        Bundle r136 = getArguments();
        if (r136 == null) goto L102;
        String r137 = r136.getString("create_sub_conv_case_id");
    L103:
        r122.put("user_case_item_id", r137);
        Bundle r138 = getArguments();
        if (r138 == null) goto L106;
        r101 = r138.getString("create_sub_conv_case_request_id");
    L106:
        r122.put("user_case_reco_request_id", r101);
        tx9.c0.B(r122, this, r120, 819199);
        return;
    L102:
        r137 = null;
        goto L103
    L91:
        r132 = null;
        goto L92
    L65:
        r120 = "0";
        goto L66
    L107:
        BotModel r139 = this.f296475s;
        if (r139 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r139 = null;
    L110:
        String r140 = r139.getBotId();
        String r141 = this.f296469n;
        if (r141 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r141 = null;
    L113:
        ChatControlTrace r142 = ChatControlTrace.f309996b;
        Integer r143 = Integer.valueOf(this.f296468m);
        BotModel r144 = this.f296475s;
        if (r144 == null) goto L116;
        Integer r145 = r144.getBotType();
    L117:
        BotModel r146 = this.f296475s;
        if (r146 == null) goto L123;
        BotCreatorInfo r147 = r146.getBotCreatorInfo();
        if (r147 == null) goto L122;
        r102 = r147.getId();
    L122:
        r115 = Intrinsics.areEqual(r102, AccountService.f365697a.getUserId());
    L123:
        String r148 = r142.g(r143, r145, r115);
        String r149 = k();
        String r150 = Ma0();
        JSONObject r151 = new JSONObject();
        Intrinsics.checkNotNullParameter(r151, "params");
        if (r140 != null) goto L146;
    L128:
        if (r141 == null) goto L130;
        r151.put("conversation_id", r141);     // Catch: JSONException -> L126
    L130:
        r151.put("current_page", r149);     // Catch: JSONException -> L126
        r151.put("previous_page", r150);     // Catch: JSONException -> L126
        r151.put("chat_type", r148);     // Catch: JSONException -> L126
    L133:
        TrackParams r152 = new TrackParams().merge(r151);
        by7.a r153 = new by7.a("click_share_new_dialogue");
        r153.f21463a.merge(r152);
        r153.b();
        return;
    L126:
        e = move-exception;
        FLogger.f375446a.e("ClickEventHelper", "error in ClickEventHelper mobClickShareNewDialog " + e.getLocalizedMessage());
        goto L133
    L146:
        r151.put("bot_id", r140);     // Catch: JSONException -> L126
        goto L128
    L116:
        r145 = null;
    L56:
        r117 = false;
        goto L58
    L34:
        if (r108.f296737d == null) goto L48;
        Integer r154 = r109.f559219v;
        if (r154 == null) goto L44;
        if (r154.intValue() != 3) goto L44;
        ShareScene r155 = ShareScene.MESSAGES_LINK_SUB_CONV;
    L47:
        IShareService.a.b(ShareServiceDelegate.f313831b, r108.f296737d, r109, r113, r155, null, r108.f296735b, new ShareBotController$performShareBot$1(r108, r109, r113), 16);
    L44:
        if (r111.getShareConfig().m() == false) goto L46;
        r155 = ShareScene.COMMON_BOT_WITH_SAVE;
        goto L47
    L46:
        r155 = ShareScene.COMMON_BOT;
        goto L47
    L30:
        r113 = r112;
        goto L31
    L134:
        BotModel r156 = this.f296475s;
        if (r156 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L138:
        Integer r157 = r100.getBotStatus();
        if (r157 != null) goto L142;
    L144:
        t19.s r158 = t19.s.f544207a;
        Context r159 = getContext();
        String r160 = getString(R.string.larus_cannot_share_yet);
        r158.getClass();
        t19.s.t(r159, r160);
        return;
    L142:
        if (r157.intValue() != (-20)) goto L144;
        t19.s r161 = t19.s.f544207a;
        Context r162 = getContext();
        String r163 = getString(R.string.larus_bot_ban_under_review);
        r161.getClass();
        t19.s.t(r162, r163);
        return;
    L137:
        r100 = r156;
        goto L138
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        FLogger r101 = FLogger.f375446a;
        r101.d(this.f296457e, "Router arguments: " + this + ' ' + getArguments());
        boolean r102 = true;
        boolean r103 = false;
        if (this.f296455J == true) goto L15;
        Bundle r104 = getArguments();
        if (r104 == null) goto L7;
        boolean r105 = r104.getBoolean("setting_is_app_page", false);
    L8:
        if (r105 == true) goto L15;
        if (r100 == null) goto L11;
        boolean r106 = r100.getBoolean("is_app_setting");
    L12:
        if (r106 == true) goto L15;
        boolean r107 = false;
    L16:
        this.f296455J = r107;
        SearchMobParam r108 = null;
        String r109 = null;
        r109 = null;
        String r110 = null;
        r110 = null;
        String r111 = "";
        if (r107 == false) goto L75;
        AuthModelDelegate r112 = AuthModelDelegate.f297134b;
        wc9.e r113 = r112.y().getValue();
        if (r113 == null) goto L21;
        String r114 = r113.f559198a;
    L22:
        if (r114 != null) goto L24;
        r114 = "";
    L24:
        this.f296469n = r114;
        if (r114.length() != 0) goto L27;
        boolean r115 = true;
    L28:
        if (r115 == true) goto L30;
    L34:
        boolean r116 = false;
    L35:
        String r117 = this.f296469n;
        if (r117 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r117 = null;
    L39:
        if (r117.length() != 0) goto L41;
        boolean r118 = true;
    L42:
        if (r118 == false) goto L48;
        if (r116 == true) goto L48;
        FragmentActivity r119 = getActivity();
        if (r119 == null) goto L104;
        r119.finish();
        return;
    L104:
        return;
    L48:
        this.f296468m = 1;
        if (r116 == false) goto L66;
        com.larus.bmhome.auth.h0 r120 = r112.v();
        if (r120 != null) goto L53;
    L58:
        if (r109 == null) goto L61;
        r111 = r109;
    L61:
        String r121 = this.f296457e;
        StringBuilder r122 = new StringBuilder("open side bar app settings without main conversation, botIdEmpty=");
        if (r111.length() == 0) goto L65;
        r102 = false;
    L65:
        r122.append(r102);
        r101.i(r121, r122.toString());
    L74:
        this.S = r111;
    L96:
        p2a.i.f527471b.Z();
        FragmentAttachExtKt.b(this, ContainerFilter.CHAT_SETTING);     // Catch: Exception -> L99
        return;
    L99:
        e = move-exception;
        FLogger.f375446a.e(this.f296457e, "attachComponent chatCoreContainer error, " + e.getClass().getSimpleName() + ", " + e.getMessage());
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e, "attachComponent chatCoreContainer error");
        return;
    L53:
        if (Intrinsics.areEqual(r120.h(), AccountService.f365697a.getSecUserId()) == true) goto L56;
        r120 = null;
    L56:
        if (r120 == null) goto L58;
        r109 = r120.b();
        goto L58
    L66:
        com.larus.bmhome.chat.api.e0 r123 = r112.e().getValue();
        if (r123 == null) goto L71;
        LaunchInfo r124 = r123.f297186a;
        if (r124 == null) goto L71;
        r110 = r124.W();
    L71:
        if (r110 == null) goto L74;
        r111 = r110;
        goto L74
    L41:
        r118 = false;
        goto L42
    L30:
        if (Va0() == false) goto L34;
        if (com.larus.platform.exp.o.a() == false) goto L34;
        r116 = true;
        goto L35
    L27:
        r115 = false;
        goto L28
    L21:
        r114 = null;
        goto L22
    L75:
        Bundle r125 = getArguments();
        if (r125 == null) goto L79;
        String r126 = r125.getString("setting_conversation_id", "");
        if (r126 == null) goto L79;
    L80:
        this.f296469n = r126;
        Bundle r127 = getArguments();
        int r128 = 2;
        if (r127 == null) goto L83;
        r128 = r127.getInt("setting_bot_cvs_type", 2);
    L83:
        this.f296468m = r128;
        Bundle r129 = getArguments();
        if (r129 == null) goto L86;
        r108 = (SearchMobParam) r129.getParcelable("argSearchMobParam");
    L86:
        this.f296480x = r108;
        Bundle r130 = getArguments();
        if (r130 == null) goto L89;
        r103 = r130.getBoolean("setting_is_immersive_bot", false);
    L89:
        this.f296482z = r103;
        Bundle r131 = getArguments();
        if (r131 == null) goto L95;
        String r132 = r131.getString("setting_bot_id", "");
        if (r132 == null) goto L95;
        r111 = r132;
    L95:
        this.S = r111;
    L79:
        r126 = "";
        goto L80
    L11:
        r106 = false;
        goto L12
    L7:
        r105 = false;
    L15:
        r107 = true;
        goto L16
    }

    @Override // com.larus.bmhome.y
    public final void onResult(Bundle r710) {
        Intrinsics.checkNotNullParameter(r710, "bundle");
        if (this.f296475s == null) goto L28;
        Serializable r100 = r710.getSerializable("select_language_result");
        if ((r100 instanceof BotModel) == false) goto L8;
        BotModel r101 = (BotModel) r100;
    L9:
        if (r101 == null) goto L28;
        if (this.f296475s != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L14:
        BotModel r102 = this.f296475s;
        if (r102 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        BotModel r103 = null;
    L18:
        rb0(BotModel.copy$default(r103, null, r101.getName(), null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r101.getVoiceType(), null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -131075, Integer.MAX_VALUE, null));
        BotSettingViewModel r104 = Ja0();
        String r105 = this.f296469n;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("conversationId");
        r105 = null;
    L21:
        r104.requireUpdateConversationInfo(r105);
        BotSettingViewModel r106 = Ja0();
        BotModel r107 = this.f296475s;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r107 = null;
    L24:
        r106.updateAsrLanguage(r107, this.f296468m);
        ub0();
        if (AppHost.f326268a.isOversea() == false) goto L28;
        mb0();
        goto L28
    L17:
        r103 = r102;
        goto L18
    L8:
        r101 = null;
    L28:
        if (this.f296475s == null) goto L44;
        Serializable r108 = r710.getSerializable("select_model_result");
        if ((r108 instanceof ModelItem) == false) goto L33;
        ModelItem r109 = (ModelItem) r108;
    L34:
        if (r109 == null) goto L44;
        if (this.f296475s != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L39:
        BotModel r110 = this.f296475s;
        if (r110 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r110 = null;
    L42:
        rb0(BotModel.copy$default(r110, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, r109, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -65537, Integer.MAX_VALUE, null));
        wb0();
        yb0();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommonSettingFragment$setupSelectModelResult$1(this, r109, null), 3, null);
        goto L44
    L33:
        r109 = null;
    L44:
        if (this.f296475s == null) goto L115;
        Serializable r111 = r710.getSerializable("bot_update_result");
        if ((r111 instanceof BotModel) == false) goto L49;
        final BotModel r112 = (BotModel) r111;
    L50:
        if (r112 == null) goto L115;
        if (this.f296475s != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L55:
        rb0(r112);
        yb0();
        ub0();
        wb0();
        xb0(null);
        BotModel r113 = this.f296475s;
        if (r113 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r113 = null;
    L58:
        qb0(r113.getPrivateStatus());
        if (AppHost.f326268a.isOversea() == false) goto L61;
        mb0();
    L61:
        com.larus.bmhome.setting.c r114 = this.f296459g;
        if (r114 == null) goto L66;
        ItemGroup r115 = r114.S();
        if (r115 == null) goto L66;
        r115.setVisibility(8);
    L66:
        com.larus.bmhome.setting.c r116 = this.f296459g;
        if (r116 == null) goto L115;
        if (Ca0() == true) goto L71;
    L89:
        RoundAvatarImageView r117 = r116.k();
        if (r117 == null) goto L92;
        com.larus.utils.e1.x(r117);
    L92:
        View r118 = r116.l();
        if (r118 == null) goto L95;
        com.larus.utils.e1.o(r118);
    L95:
        RoundAvatarImageView r119 = r116.k();
        if (r119 == null) goto L104;
        BotIconImage r120 = r112.getIconImage();
        if (r120 == null) goto L100;
        String r121 = r120.getOriginUrl();
    L101:
        if (r121 != null) goto L103;
        r121 = "";
    L103:
        ImageLoaderKt.v(r119, r121, "bot_setting.avatar_upload", null, new u1());
        goto L104
    L100:
        r121 = null;
    L104:
        BotModel r122 = this.f296475s;
        if (r122 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r122 = null;
    L107:
        bb0(r122.getName());
        BotModel r123 = this.f296475s;
        if (r123 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r123 = null;
    L110:
        cb0(r123.getTagList());
        RoundAvatarImageView r124 = r116.k();
        if (r124 == null) goto L113;
        com.larus.utils.e1.d(r124, new v1(this, r112));
    L113:
        Sa0(r112);
        goto L115
    L71:
        if (r112.getBgImgOpen() == false) goto L89;
        if (com.larus.utils.o0.d(r112.getBgImgUrl()) == false) goto L89;
        RoundAvatarImageView r125 = r116.k();
        if (r125 == null) goto L77;
        com.larus.utils.e1.o(r125);
    L77:
        View r126 = r116.l();
        if (r126 == null) goto L80;
        com.larus.utils.e1.x(r126);
    L80:
        View r127 = r116.l();
        if ((r127 instanceof SimpleDraweeView) == false) goto L83;
        SimpleDraweeView r128 = (SimpleDraweeView) r127;
    L84:
        if (r128 == null) goto L86;
        ImageLoaderKt.u(r128, r112.getBgImgUrl(), "chat_setting_update_avatar");
    L86:
        View r129 = r116.l();
        if (r129 == null) goto L113;
        com.larus.utils.e1.d(r129, new t1(this, r112));
        goto L113
    L83:
        r128 = null;
        goto L84
    L49:
        r112 = null;
    L115:
        if (this.f296475s != null) goto L118;
        return;
    L118:
        if (com.larus.platform.service.z2.f365865a.o3().f510331a == false) goto L140;
        w2a.f r130 = w2a.h.a(r710);
        if (r130 == null) goto L165;
        BotModel r131 = this.f296475s;
        if (r131 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r131 = null;
    L124:
        if (r131 == null) goto L128;
        SpeakerVoice r132 = r131.getVoiceType();
        if (r132 == null) goto L128;
        String r133 = r132.getId();
    L129:
        com.larus.bmhome.setting.c r134 = this.f296459g;
        if (r134 == null) goto L134;
        ItemTextArrow r135 = r134.Z0();
        if (r135 == null) goto L134;
        r135.Y5();
    L134:
        com.larus.bmhome.setting.c r136 = this.f296459g;
        if (r136 == null) goto L139;
        ItemTextArrow r137 = r136.Z0();
        if (r137 == null) goto L139;
        r137.c6();
    L139:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new CommonSettingFragment$setupSelectSpeakerResult$1$1(r130, this, r133, null), 3, null);
        return;
    L128:
        r133 = null;
        goto L129
    L165:
        return;
    L140:
        Serializable r138 = r710.getSerializable("select_speaker_result");
        if ((r138 instanceof SpeakerVoice) == false) goto L143;
        SpeakerVoice r210 = (SpeakerVoice) r138;
    L144:
        if (r210 != null) goto L146;
        return;
    L146:
        if (Intrinsics.areEqual(r210.getId(), "none") == false) goto L156;
        if (this.f296475s != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L150:
        BotModel r139 = this.f296475s;
        if (r139 != null) goto L153;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        BotModel r140 = null;
    L154:
        rb0(BotModel.copy$default(r140, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r210, null, true, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null));
    L163:
        xb0(null);
        return;
    L153:
        r140 = r139;
        goto L154
    L156:
        if (this.f296475s != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L158:
        BotModel r141 = this.f296475s;
        if (r141 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        BotModel r142 = null;
    L162:
        rb0(BotModel.copy$default(r142, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r210, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null));
        goto L163
    L161:
        r142 = r141;
        goto L162
    L143:
        r210 = null;
        goto L144
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        r100.putBoolean("is_app_setting", this.f296455J);
    }

    public final void qb0(Integer r100) {
        com.larus.bmhome.setting.c r101 = this.f296459g;
        if (r101 == null) goto L38;
        if (r100 != null) goto L7;
    L14:
        if (r100 != null) goto L17;
    L24:
        if (r100 != null) goto L27;
    L34:
        ItemLongTextArrow r102 = r101.b();
        if (r102 == null) goto L45;
        r102.setVisibility(8);
        Unit r103 = Unit.INSTANCE;
        return;
    L45:
        return;
    L27:
        if (r100.intValue() != 2) goto L34;
        ItemLongTextArrow r104 = r101.b();
        if (r104 == null) goto L31;
        r104.setImageSrc(R.drawable.larus_ic_bot_access_permission_private);
    L31:
        ItemLongTextArrow r105 = r101.b();
        if (r105 == null) goto L43;
        r105.setText(getString(R.string.larus_option_private));
        Unit r106 = Unit.INSTANCE;
        return;
    L43:
        return;
    L17:
        if (r100.intValue() != 3) goto L24;
        ItemLongTextArrow r107 = r101.b();
        if (r107 == null) goto L21;
        r107.setImageSrc(R.drawable.larus_ic_bot_access_permission_unlisted);
    L21:
        ItemLongTextArrow r108 = r101.b();
        if (r108 == null) goto L41;
        r108.setText(getString(R.string.larus_unlisted));
        Unit r109 = Unit.INSTANCE;
        return;
    L41:
        return;
    L7:
        if (r100.intValue() != 1) goto L14;
        ItemLongTextArrow r110 = r101.b();
        if (r110 == null) goto L11;
        r110.setImageSrc(R.drawable.larus_ic_bot_access_permission_public);
    L11:
        ItemLongTextArrow r111 = r101.b();
        if (r111 == null) goto L39;
        r111.setText(getString(R.string.larus_option_public));
        Unit r112 = Unit.INSTANCE;
        return;
    L39:
        return;
    }

    public final void rb0(BotModel r100) {
        this.f296475s = r100;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CommonSettingFragment$updateBotInfo$1(r100, this, null), 3, null);
    }

    public final void vb0(uz8.f r110) {
        com.larus.bmhome.setting.c r100 = this.f296459g;
        if (r100 == null) goto L157;
        boolean r101 = false;
        if (r110 == null) goto L11;
        uz8.h r102 = r110.settingsUpgradePage;
        if (r102 == null) goto L11;
        if (r102.isEnabled != true) goto L11;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        if (r110 == null) goto L18;
        final uz8.h r104 = r110.settingsUpgradePage;
    L19:
        FLogger r105 = FLogger.f375446a;
        String r106 = this.f296457e;
        StringBuilder r107 = new StringBuilder("updateMembershipEntry membership isEnabled: ");
        if (r104 == null) goto L22;
        Boolean r108 = Boolean.valueOf(r104.isEnabled);
    L23:
        r107.append(r108);
        r105.i(r106, r107.toString());
        if (r104 != null) goto L26;
    L28:
        boolean r109 = false;
    L29:
        String r111 = "";
        if (r109 == false) goto L61;
        final ItemTextArrow r112 = r100.g0();
        if (r112 == null) goto L64;
        String r113 = r104.title;
        if (r113 != null) goto L36;
        r113 = "";
    L36:
        r112.setText(r113);
        String r114 = r104.subTitle;
        if (r114 != null) goto L39;
        r114 = "";
    L39:
        r112.Z5(r114, db0(r104.subTitleColor));
        String r115 = r104.iconName;
        if (r115 != null) goto L42;
    L57:
        int r116 = R.drawable.larus_ic_setting_membership_gray;
    L58:
        r112.setImageSrc(r116);
        com.larus.utils.e1.d(r112, new t0(r112, r104));
        ItemTextArrow r117 = r100.g0();
        if (r117 == null) goto L64;
        com.larus.utils.e1.x(r117);
        goto L64
    L42:
        switch(r115.hashCode()) {
            case -969653906: goto L54;
            case -969499785: goto L52;
            case 10281071: goto L49;
            case 579544016: goto L45;
            default: goto L57;
        };
    L52:
        r115.equals("icon_setting_membership_gray");
        goto L57
    L45:
        if (r115.equals("icon_setting_membership_purple") == false) goto L57;
        r116 = R.drawable.larus_ic_setting_membership_purple;
        goto L58
    L49:
        if (r115.equals("icon_setting_membership_green") == false) goto L57;
        r116 = R.drawable.larus_ic_setting_membership_green;
        goto L58
    L54:
        if (r115.equals("icon_setting_membership_blue") == false) goto L57;
        r116 = R.drawable.larus_ic_setting_membership_blue;
    L64:
        if (r110 == null) goto L66;
        final uz8.h r118 = r110.settingsManagementPage;
    L67:
        String r119 = this.f296457e;
        StringBuilder r120 = new StringBuilder("updateMembershipEntry management isEnabled: ");
        if (r118 == null) goto L70;
        Boolean r121 = Boolean.valueOf(r118.isEnabled);
    L71:
        r120.append(r121);
        r105.i(r119, r120.toString());
        if (r118 != null) goto L74;
    L76:
        boolean r122 = false;
    L77:
        if (r122 == false) goto L90;
        final ItemTextArrow r123 = r100.f0();
        if (r123 == null) goto L93;
        String r124 = r118.title;
        if (r124 != null) goto L83;
        r124 = "";
    L83:
        r123.setText(r124);
        String r125 = r118.subTitle;
        if (r125 == null) goto L87;
        r111 = r125;
    L87:
        r123.Z5(r111, db0(r118.subTitleColor));
        com.larus.utils.e1.d(r123, new u0(r123, r118));
        ItemTextArrow r126 = r100.f0();
        if (r126 == null) goto L93;
        com.larus.utils.e1.x(r126);
    L93:
        ItemTextArrow r127 = r100.g0();
        if (r127 != null) goto L96;
    L101:
        boolean r128 = false;
    L102:
        if (r128 == true) goto L117;
        ItemTextArrow r129 = r100.f0();
        if (r129 != null) goto L106;
    L111:
        boolean r130 = false;
    L112:
        if (r130 == true) goto L117;
        ItemGroup r131 = r100.s0();
        if (r131 == null) goto L120;
        com.larus.utils.e1.o(r131);
    L120:
        ab0();
        if (isVisible() == false) goto L139;
        ItemTextArrow r132 = r100.g0();
        if (r132 != null) goto L125;
    L130:
        boolean r133 = false;
    L131:
        if (r133 == false) goto L139;
        if (r104 == null) goto L134;
        String r134 = r104.clickUrl;
    L136:
        if (this.f296460g1 == true) goto L139;
        Wa0(r134, "setting", null);
        this.f296460g1 = true;
        goto L139
    L134:
        r134 = null;
        goto L136
    L125:
        if (r132.getVisibility() != 0) goto L127;
        boolean r135 = true;
    L128:
        if (r135 != true) goto L130;
        r133 = true;
        goto L131
    L127:
        r135 = false;
    L139:
        if (isVisible() == false) goto L155;
        ItemTextArrow r136 = r100.f0();
        if (r136 != null) goto L143;
    L148:
        if (r101 == false) goto L155;
        if (this.f296462h1 == true) goto L155;
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r137 = ICommerceMembershipService.a.a();
        if (r137 == null) goto L154;
        r137.r();
    L154:
        this.f296462h1 = true;
        goto L155
    L143:
        if (r136.getVisibility() != 0) goto L145;
        boolean r138 = true;
    L146:
        if (r138 != true) goto L148;
        r101 = true;
        goto L148
    L145:
        r138 = false;
    L155:
        Unit r139 = Unit.INSTANCE;
        return;
    L106:
        if (r129.getVisibility() != 0) goto L108;
        boolean r140 = true;
    L109:
        if (r140 != true) goto L111;
        r130 = true;
        goto L112
    L108:
        r140 = false;
    L117:
        ItemGroup r141 = r100.s0();
        if (r141 == null) goto L120;
        com.larus.utils.e1.x(r141);
        goto L120
    L96:
        if (r127.getVisibility() != 0) goto L98;
        boolean r142 = true;
    L99:
        if (r142 != true) goto L101;
        r128 = true;
        goto L102
    L98:
        r142 = false;
        goto L99
    L90:
        ItemTextArrow r143 = r100.f0();
        if (r143 == null) goto L93;
        com.larus.utils.e1.o(r143);
        goto L93
    L74:
        if (r118.isEnabled != true) goto L76;
        r122 = true;
        goto L77
    L70:
        r121 = null;
        goto L71
    L66:
        r118 = null;
        goto L67
    L61:
        ItemTextArrow r144 = r100.g0();
        if (r144 == null) goto L64;
        com.larus.utils.e1.o(r144);
        goto L64
    L26:
        if (r104.isEnabled != true) goto L28;
        r109 = true;
        goto L29
    L22:
        r108 = null;
    L18:
        r104 = null;
        goto L19
    L16:
        if (r110 == null) goto L18;
        r104 = r110.settingsPage;
    L11:
        r103 = false;
        goto L13
    }

    public final void xb0(SpeakerVoice r110) {
        if (this.Y == true) goto L5;
        return;
    L5:
        BotModel r100 = null;
        if (r110 != null) goto L11;
        BotModel r111 = this.f296475s;
        if (r111 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r111 = null;
    L10:
        r110 = r111.getVoiceType();
    L11:
        com.larus.audio.w0 r101 = p2a.s.f527494b.F0();
        EditPos r102 = this.f296476t;
        if (r102 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        r102 = null;
    L14:
        r101.a(this, r110, r102);
        com.larus.bmhome.setting.c r103 = this.f296459g;
        if (r103 == null) goto L54;
        int r104 = xb8.a.f563159a;
        Context r105 = getContext();
        ItemTextArrow r106 = r103.Z0();
        BotModel r107 = this.f296475s;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r107 = null;
    L19:
        boolean r108 = r107.getMuted();
        EditPos r109 = this.f296476t;
        if (r109 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("editPos");
        EditPos r112 = null;
    L23:
        xb8.a.b(r105, r106, r110, r108, r112, false);
        boolean r113 = false;
        if (r110 != null) goto L26;
    L28:
        boolean r114 = false;
    L29:
        if (r114 == true) goto L55;
        if (r110 != null) goto L32;
    L34:
        boolean r115 = false;
    L35:
        if (r115 == true) goto L56;
        if (r110 != null) goto L38;
    L40:
        if (r113 == true) goto L57;
        BotModel r116 = this.f296475s;
        if (r116 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
        r116 = null;
    L45:
        if (r116.getMuted() == false) goto L58;
        BotModel r117 = this.f296475s;
        if (r117 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L50:
        SpeakerVoice r118 = r100.getVoiceType();
        if (r118 == null) goto L59;
        r118.setId("0");
        return;
    L59:
        return;
    L49:
        r100 = r117;
        goto L50
    L58:
        return;
    L57:
        return;
    L38:
        if (r110.getStatus() != 3) goto L40;
        r113 = true;
        goto L40
    L56:
        return;
    L32:
        if (r110.getStatus() != 4) goto L34;
        r115 = true;
        goto L35
    L55:
        return;
    L26:
        if (r110.getConfStatus() != 2) goto L28;
        r114 = true;
        goto L29
    L22:
        r112 = r109;
        goto L23
    }

    public static final void Aa0(final CommonSettingFragment r100, ItemTextArrow r110) {
        Job r101 = r100.X;
        BotModel r102 = null;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        final IAudioSettingRuntimeProvider r103 = (IAudioSettingRuntimeProvider) ServiceManager.get().getService(IAudioSettingRuntimeProvider.class, false, false);
        if (r103 != null) goto L8;
        r100.Y = true;
        r100.nb0();
    L13:
        if (r100.f296459g != null) goto L15;
        return;
    L15:
        if (com.larus.platform.service.z2.f365865a.m3() == true) goto L17;
        com.larus.utils.e1.o(r110);
        return;
    L17:
        com.larus.utils.e1.x(r110);
        r100.xb0(null);
        if (r100.Y == false) goto L26;
        BotModel r104 = r100.f296475s;
        if (r104 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("botInfo");
    L24:
        if (r102.getMuted() == true) goto L26;
        r100.Za0();
        goto L26
    L22:
        r102 = r104;
    L26:
        r110.setImageSrc(R.drawable.larus_icon_tts_speaker);
        r110.setOnClickListener(new r4(r103, r100));
        return;
    L8:
        boolean r105 = r103.a().getValue().booleanValue();
        r100.Y = r105;
        if (r105 == false) goto L11;
        r100.nb0();
    L11:
        r100.X = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r100.getViewLifecycleOwner()), null, null, new CommonSettingFragment$observeSaasAudioReady$1(r103, r100, null), 3, null);
        goto L13
    }

    public static void U90(CommonDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, null);
    }

    public final void gb0(final boolean r100, final String r101) {
        IFlowSettingThemeConfigProvider r102 = (IFlowSettingThemeConfigProvider) ServiceManager.get().getService(IFlowSettingThemeConfigProvider.class);
        if (r102 == null) goto L6;
        r102.a(new j1(this, r101, r100), new k1(this), AdaptThemeFeatureKey.SETTING_ITEM_DORA_BUSINESS_LOGIC);
        return;
    }

    /* JADX WARN: Type inference failed for: r7v17, types: [com.larus.bmhome.bot.m4] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f296472p0 = true;
        AppHost.Companion r100 = AppHost.f326268a;
        r100.a().j(this.f296456b1);
        com.larus.bmhome.setting.c r101 = this.f296459g;
        if (r101 == null) goto L19;
        NovaTitleBarEx r112 = r101.Y0();
        if (Va0() == true) goto L7;
    L17:
        NovaTitleBarEx.b6(r112, v19.c.b(R.attr.larus_ic_left_back, r112.getContext(), R.drawable.larus_ic_left_back), false, null, getString(R.string.larus_accessibility_icon_back), new d4(this), 6);
    L18:
        Unit r102 = Unit.INSTANCE;
        goto L19
    L7:
        if (this.f296455J == false) goto L17;
        ViewGroup.LayoutParams r103 = r112.getLayoutParams();
        if (r103 == null) goto L16;
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        com.larus.utils.i0.f375410a.getClass();
        r104.topMargin = com.larus.utils.i0.g();
        r112.setLayoutParams(r104);
        NovaTitleBarEx.b6(r112, v19.c.b(R.attr.larus_ic_side_bar, r112.getContext(), R.drawable.larus_ic_side_bar), false, null, null, new b4(this), 14);
        View r105 = r101.P0();
        Context r106 = r112.getContext();
        if ((r106 instanceof FragmentActivity) == false) goto L13;
        FragmentActivity r107 = (FragmentActivity) r106;
    L14:
        int r108 = com.larus.utils.u.b(r107);
        int r109 = r105.getPaddingStart();
        int r113 = r105.getPaddingTop();
        int r114 = r105.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r105.getClass().getSimpleName() + ",source:,start:" + r109 + ",top:" + r113 + ",end:" + r114 + ",bottom:" + r108);
        r105.setPaddingRelative(r109, r113, r114, r108);
        goto L18
    L13:
        r107 = null;
        goto L14
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L19:
        Ia0().getUserConfigsUpdatedLiveData().observe(getViewLifecycleOwner(), new e(new z2(this)));
        Ia0().updateUserConfigs();
        Ia0().getAnswerWithSuggestLiveData().observe(getViewLifecycleOwner(), new e(new a3(this)));
        Ia0().getAnswerWithVideoLiveData().observe(getViewLifecycleOwner(), new e(new b3(this)));
        Ia0().getHighlightEngineEnableLiveData().observe(getViewLifecycleOwner(), new e(new c3(this)));
        Ia0().getRelatedVideoEnableLiveData().observe(getViewLifecycleOwner(), new e(new d3(this)));
        FeatureKitDelegate r115 = FeatureKitDelegate.f295792b;
        if (r115.T().b() == false) goto L23;
        Ia0().getDefaultActiveModeLiveData().observe(getViewLifecycleOwner(), new e(new e3(this)));
    L23:
        if (r115.W().b() == true) goto L25;
        Ia0().getDefaultReplyModeLiveData().observe(getViewLifecycleOwner(), new e(new f3(this)));
    L25:
        com.larus.bmhome.setting.c r116 = this.f296459g;
        if (r116 == null) goto L30;
        final ItemTextArrow r117 = r116.J();
        if (r117 == null) goto L30;
        com.larus.utils.e1.x(r117);
        com.larus.utils.e1.d(r117, new h2(this, r117));
    L30:
        AccountService r118 = AccountService.f365697a;
        if (r118.isLogin().booleanValue() == true) goto L33;
    L45:
        com.larus.bmhome.setting.c r119 = this.f296459g;
        if (r119 == null) goto L50;
        ItemTextArrow r120 = r119.I();
        if (r120 == null) goto L50;
        com.larus.utils.e1.o(r120);
    L50:
        ib0();
        boolean r121 = false;
        if (r118.isLogin().booleanValue() == true) goto L53;
    L65:
        com.larus.bmhome.setting.c r122 = this.f296459g;
        if (r122 == null) goto L70;
        ItemTextArrow r123 = r122.a();
        if (r123 == null) goto L70;
        com.larus.utils.e1.o(r123);
    L70:
        com.larus.bmhome.setting.c r124 = this.f296459g;
        if (r124 == null) goto L92;
        ItemTextArrow r125 = r124.D();
        if (r125 == null) goto L92;
        if (r100.isOversea() == false) goto L77;
    L91:
        r125.setVisibility(8);
        goto L92
    L77:
        if (com.larus.platform.service.z2.f365865a.enableOfficialWebsite() == false) goto L91;
        r125.setVisibility(0);
        String r126 = this.H0.f486698q.f486555e;
        if (r126 != null) goto L82;
    L89:
        String r127 = getString(R.string.larus_settings_item_doubaoWebsite_cn);
    L90:
        r125.setText(r127);
        com.larus.utils.e1.d(r125, new l4());
        goto L92
    L82:
        if (Boolean.valueOf(!StringsKt.isBlank(r126)).booleanValue() == true) goto L85;
        r126 = null;
    L85:
        if (r126 == null) goto L89;
        r127 = r126 + getString(R.string.larus_lark_doubao_settings_work);
        if (r127 == null) goto L89;
    L92:
        com.larus.bmhome.setting.c r128 = this.f296459g;
        if (r128 == null) goto L100;
        ItemTextArrow r129 = r128.v();
        if (r129 == null) goto L100;
        if (r118.isLogin().booleanValue() == true) goto L99;
        r129.setVisibility(8);
        goto L100
    L99:
        com.larus.utils.e1.d(r129, new o2(this));
    L100:
        com.larus.bmhome.setting.c r130 = this.f296459g;
        if (r130 == null) goto L115;
        ItemTextMenu r131 = r130.a0();
        if (r131 == null) goto L115;
        if (com.larus.platform.service.z2.f365865a.enableEnterKeyBehaviorSetting() == false) goto L107;
        int r132 = 0;
    L108:
        r131.setVisibility(r132);
        if (r131.getVisibility() != 0) goto L111;
        boolean r133 = true;
    L112:
        if (r133 == false) goto L115;
        r131.setSubText(Ka0(EnterKeyBehaviorHostDelegate.f311786b.a()));
        r131.setOnMenuClickListener(new k3(this));
        goto L115
    L111:
        r133 = false;
        goto L112
    L107:
        r132 = 8;
    L115:
        lb0();
        com.larus.bmhome.setting.c r134 = this.f296459g;
        if (r134 == null) goto L139;
        ItemTextArrow r135 = r134.z0();
        if (r135 == null) goto L139;
        if (com.larus.platform.service.p1.f365785a.n() == true) goto L122;
    L128:
        boolean r136 = false;
    L129:
        if (r136 == false) goto L131;
        int r137 = 0;
    L132:
        r135.setVisibility(r137);
        if (r135.getVisibility() != 0) goto L135;
        boolean r138 = true;
    L136:
        if (r138 == false) goto L139;
        r135.setOnClickListener(new z3(this));
        goto L139
    L135:
        r138 = false;
        goto L136
    L131:
        r137 = 8;
        goto L132
    L122:
        if (r118.isLogin().booleanValue() == false) goto L128;
        if (r100.isOversea() == true) goto L128;
        if (com.larus.platform.service.x1.f365857a.a() == true) goto L128;
        r136 = true;
    L139:
        com.larus.bmhome.setting.c r139 = this.f296459g;
        if (r139 == null) goto L153;
        final ItemTextArrow r140 = r139.x();
        if (r140 == null) goto L153;
        if (r100.isOversea() == false) goto L146;
    L152:
        com.larus.utils.e1.o(r140);
        goto L153
    L146:
        if (r118.isLogin().booleanValue() == false) goto L152;
        com.larus.platform.service.z2 r141 = com.larus.platform.service.z2.f365865a;
        if (r141.n2() == false) goto L150;
    L151:
        int r142 = com.larus.utils.j0.f375426a;
        r140.setText(com.larus.utils.j0.e("aiCreation_uploadPermission_settings_outputs"));
        com.larus.utils.e1.d(r140, new m3(this, r140));
        com.larus.utils.e1.x(r140);
        goto L153
    L150:
        if (Intrinsics.areEqual(r141.watermarkRemovalConfig().a(), Boolean.TRUE) == false) goto L152;
    L153:
        com.larus.bmhome.setting.c r143 = this.f296459g;
        if (r143 == null) goto L163;
        final ItemTextArrow r144 = r143.X0();
        if (r144 == null) goto L163;
        if (r118.isLogin().booleanValue() == true) goto L160;
    L162:
        com.larus.utils.e1.o(r144);
        goto L163
    L160:
        if (r115.c0().b() == false) goto L162;
        com.larus.utils.e1.x(r144);
        com.larus.utils.e1.d(r144, new a4(r144, this));
    L163:
        com.larus.bmhome.setting.c r145 = this.f296459g;
        if (r145 == null) goto L189;
        ItemTextView r146 = r145.B();
        if (r146 == null) goto L189;
        com.larus.bmhome.chat.api.e0 r147 = AuthModelDelegate.f297134b.e().getValue();
        if (r147 == null) goto L172;
        LaunchInfo r148 = r147.f297186a;
        if (r148 == null) goto L172;
        final String r149 = r148.c0();
    L174:
        if (r118.isLogin().booleanValue() == false) goto L188;
        if (r149 != null) goto L177;
    L180:
        boolean r150 = true;
    L181:
        if (r150 == true) goto L188;
        if (r100.isOversea() == false) goto L188;
        if (com.larus.platform.service.x1.f365857a.a() == true) goto L188;
        r146.setVisibility(0);
        r146.setOnClickListener(new y(r149, this));
        goto L189
    L177:
        if (StringsKt.isBlank(r149) == true) goto L180;
        r150 = false;
    L188:
        r146.setVisibility(8);
    L172:
        r149 = null;
    L189:
        com.larus.platform.service.z2 r151 = com.larus.platform.service.z2.f365865a;
        if (r151.q().f486693l == true) goto L196;
        com.larus.bmhome.setting.c r152 = this.f296459g;
        if (r152 == null) goto L206;
        ItemTextView r153 = r152.d0();
        if (r153 == null) goto L206;
        com.larus.utils.e1.o(r153);
    L206:
        com.larus.bmhome.setting.c r154 = this.f296459g;
        if (r154 == null) goto L211;
        View r155 = r154.P0();
        if (r155 == null) goto L211;
        View r156 = r155.findViewById(R.id.clear_cache);
    L213:
        if (this.f296455J == false) goto L215;
        com.larus.platform.service.u.f365809a.c(this, r156, k(), this);
    L218:
        if (r151.q().f486694m == true) goto L224;
        com.larus.bmhome.setting.c r157 = this.f296459g;
        if (r157 == null) goto L246;
        ItemTextArrow r158 = r157.B0();
        if (r158 == null) goto L246;
        com.larus.utils.e1.o(r158);
    L246:
        final com.larus.bmhome.a0 r159 = com.larus.bmhome.b0.a(this);
        final FragmentActivity r160 = getActivity();
        if (r159 != null) goto L279;
        String r161 = com.larus.platform.service.w0.b();
        gd9.i r162 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r162);
        Iterator r163 = CollectionsKt.asReversed(r162.a().d()).iterator();
    L250:
        if (r163.hasNext() == false) goto L261;
        Object r164 = r163.next();
        Activity r165 = (Activity) r164;
        if (r165.isFinishing() == false) goto L254;
    L258:
        boolean r166 = false;
    L259:
        if (r166 == false) goto L250;
    L262:
        Activity r167 = (Activity) r164;
        if ((r167 instanceof FragmentActivity) == false) goto L265;
        FragmentActivity r168 = (FragmentActivity) r167;
    L266:
        if (r168 == null) goto L278;
        FragmentManager r169 = r168.getSupportFragmentManager();
        if (r169 == null) goto L278;
        List<Fragment> r170 = r169.getFragments();
        if (r170 == null) goto L278;
        ArrayList r171 = new ArrayList();
        Iterator<T> r172 = r170.iterator();
    L273:
        if (r172.hasNext() == false) goto L277;
        Object r173 = r172.next();
        if ((r173 instanceof com.larus.bmhome.a0) == false) goto L273;
        r171.add(r173);
        goto L273
    L277:
        final com.larus.bmhome.a0 r174 = (com.larus.bmhome.a0) CollectionsKt.firstOrNull(r171);
    L280:
        if (r174 != null) goto L282;
    L284:
        boolean r175 = false;
    L285:
        if (r175 == false) goto L296;
        com.larus.bmhome.setting.c r176 = this.f296459g;
        if (r176 == null) goto L291;
        ItemTextArrow r177 = r176.h();
        if (r177 == null) goto L291;
        com.larus.utils.e1.d(r177, new j4(r174, this, r159, r160));
    L291:
        com.larus.bmhome.setting.c r178 = this.f296459g;
        if (r178 == null) goto L301;
        ItemGroup r179 = r178.g();
        if (r179 == null) goto L301;
        com.larus.utils.e1.x(r179);
    L301:
        com.larus.bmhome.a0.f294919z1.getClass();
        boolean r180 = com.larus.bmhome.a0.a.f294921b;
        com.larus.platform.service.z2 r181 = com.larus.platform.service.z2.f365865a;
        boolean r182 = r181.getECommerceSettingsConfig().getEnableOrderMessageNotificationSettings();
        LarkSocialExp.f365340a.getClass();
        int r183 = hq9.l2.f486657a;
        boolean r184 = LarkSocialExp.f();
        boolean r185 = r181.q().f486695n;
        if (r180 == true) goto L307;
        if (r184 == false) goto L306;
        if (r185 == true) goto L307;
    L306:
        boolean r186 = false;
    L308:
        if (r186 == true) goto L312;
        if (r182 == true) goto L312;
        boolean r187 = false;
    L313:
        if (r187 == true) goto L319;
        com.larus.bmhome.setting.c r188 = this.f296459g;
        if (r188 == null) goto L329;
        ItemTextArrow r189 = r188.y0();
        if (r189 == null) goto L329;
        com.larus.utils.e1.o(r189);
    L329:
        final com.larus.bmhome.setting.c r190 = this.f296459g;
        if (r190 != null) goto L332;
    L342:
        com.larus.bmhome.setting.c r191 = this.f296459g;
        if (r191 == null) goto L391;
        AppHost.Companion r192 = AppHost.f326268a;
        if (r192.isOversea() == false) goto L350;
        TextView r193 = r191.A();
        if (r193 == null) goto L391;
        r193.setVisibility(8);
        goto L391
    L350:
        if (r181.V() == false) goto L361;
        TextView r194 = r191.A();
        if (r194 == null) goto L354;
        r194.setVisibility(0);
    L354:
        TextView r195 = r191.A();
        if (r195 == null) goto L357;
        r195.setText("《豆包 AI 使用须知》");
    L357:
        TextView r196 = r191.A();
        if (r196 == null) goto L360;
        r196.setTextColor(getResources().getColor(v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
    L360:
        com.larus.utils.e1.d(r191.A(), new b2(this));
        goto L391
    L361:
        String r197 = getString(R.string.larus_skylark_text);
        if (r197 != null) goto L364;
    L367:
        boolean r198 = true;
    L368:
        if (r198 == false) goto L372;
        TextView r199 = r191.A();
        if (r199 == null) goto L391;
        r199.setVisibility(8);
        goto L391
    L372:
        TextView r200 = r191.A();
        if (r200 == null) goto L375;
        r200.setVisibility(0);
    L375:
        TextView r201 = r191.A();
        if (r201 == null) goto L379;
        StringCompanionObject r1100 = StringCompanionObject.INSTANCE;
        r201.setText(String.format(getString(R.string.larus_settings_disclaimer_powered_by), Arrays.copyOf(new Object[]{r197}, 1)));
    L379:
        if (r192.isOversea() == true) goto L384;
        TextView r202 = r191.A();
        if (r202 == null) goto L384;
        r202.setTextColor(getResources().getColor(v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
    L384:
        if (r181.Z1().length() != 0) goto L386;
        r121 = true;
    L386:
        if (r121 == false) goto L390;
        TextView r203 = r191.A();
        if (r203 == null) goto L390;
        r203.setVisibility(8);
    L390:
        com.larus.utils.e1.d(r191.A(), new c2(this));
        goto L391
    L364:
        if (r197.length() == 0) goto L367;
        r198 = false;
    L391:
        com.larus.bmhome.setting.c r204 = this.f296459g;
        if (r204 != null) goto L394;
    L428:
        com.larus.bmhome.setting.c r205 = this.f296459g;
        if (r205 != null) goto L431;
    L456:
        eb0();
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L463;
        com.larus.bmhome.setting.c r206 = this.f296459g;
        if (r206 == null) goto L463;
        ItemGroup r207 = r206.p0();
        if (r207 == null) goto L463;
        com.larus.utils.e1.o(r207);
    L463:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain().getImmediate(), null, new CommonSettingFragment$setupViews$1(this, null), 2, null);
        JSONObject r208 = new JSONObject();
        Intrinsics.checkNotNullParameter(r208, "params");
        TrackParams r209 = new TrackParams().merge(r208);
        by7.a r210 = new by7.a("bot_setting_pv");
        r210.f21464b = this;
        r210.f21463a.merge(r209);
        r210.b();
        this.f296478v = com.larus.utils.v.a(this, new q1(this));
        if (this.f296468m == 1) goto L466;
    L468:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CommonSettingFragment$requestAppletDebuggerEntrance$1(this, null), 3, null);
        r110.post(new r1(this));
        tb0();
        return;
    L466:
        if (AuthModelDelegate.f297134b.z() == false) goto L468;
        com.larus.platform.service.u.f365809a.d();
        goto L468
    L431:
        if (AppHost.f326268a.isOversea() == false) goto L433;
    L452:
        TextView r211 = r205.Q0();
        if (r211 == null) goto L455;
        r211.setVisibility(8);
    L455:
        Unit r212 = Unit.INSTANCE;
        goto L456
    L433:
        if (r181.V() == true) goto L452;
        TextView r213 = r205.Q0();
        if (r213 == null) goto L438;
        r213.setText("《" + getString(R.string.larus_settings_third_party_android) + 12299);
    L438:
        TextView r214 = r205.Q0();
        if (r214 == null) goto L441;
        r214.setTextColor(getResources().getColor(v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
    L441:
        String r215 = r181.w1();
        if (com.larus.utils.o0.d(r215) == true) goto L445;
        r215 = null;
    L445:
        if (r215 == null) goto L449;
        TextView r216 = r205.Q0();
        if (r216 == null) goto L455;
        com.larus.utils.e1.d(r216, new h4(this));
        goto L455
    L449:
        TextView r217 = r205.Q0();
        if (r217 == null) goto L455;
        com.larus.utils.e1.o(r217);
        goto L455
    L394:
        if (AppHost.f326268a.isOversea() == false) goto L396;
    L424:
        TextView r218 = r204.C0();
        if (r218 == null) goto L427;
        r218.setVisibility(8);
    L427:
        Unit r219 = Unit.INSTANCE;
        goto L428
    L396:
        if (r181.V() == true) goto L424;
        final String r220 = r181.F1();
        if (com.larus.utils.o0.d(r220) == false) goto L401;
        String r221 = r220;
    L402:
        if (r221 == null) goto L421;
        TextView r222 = r204.C0();
        if (r222 == null) goto L415;
        String r1101 = r181.h();
        if (r1101 != null) goto L408;
    L413:
        r1101 = "《" + getString(R.string.larus_personal_info_list) + 12299;
    L414:
        r222.setText(r1101);
        goto L415
    L408:
        if (Boolean.valueOf(com.larus.utils.o0.d(r1101)).booleanValue() == true) goto L411;
        r1101 = null;
    L411:
        if (r1101 == null) goto L413;
    L415:
        TextView r223 = r204.C0();
        if (r223 == null) goto L418;
        r223.setTextColor(getResources().getColor(v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
    L418:
        TextView r224 = r204.C0();
        if (r224 == null) goto L427;
        com.larus.utils.e1.d(r224, new o3(this, r220));
        goto L427
    L421:
        TextView r225 = r204.C0();
        if (r225 == null) goto L427;
        com.larus.utils.e1.o(r225);
        goto L427
    L401:
        r221 = null;
        goto L402
    L332:
        if (r181.q2() == false) goto L336;
        AppInfoLayout r226 = r190.f();
        if (r226 == null) goto L342;
        com.larus.utils.e1.o(r226);
        Unit r227 = Unit.INSTANCE;
        goto L342
    L336:
        AppInfoLayout r228 = r190.f();
        if (r228 == null) goto L339;
        com.larus.utils.e1.x(r228);
    L339:
        AppInfoLayout r229 = r190.f();
        if (r229 == null) goto L342;
        r229.setOnClickListener(new v19.b6(new m4(r190, this)));
        Unit r230 = Unit.INSTANCE;
        goto L342
    L319:
        com.larus.bmhome.setting.c r231 = this.f296459g;
        if (r231 == null) goto L324;
        ItemTextArrow r232 = r231.y0();
        if (r232 == null) goto L324;
        com.larus.utils.e1.d(r232, new a2(this));
    L324:
        com.larus.bmhome.setting.c r233 = this.f296459g;
        if (r233 == null) goto L329;
        ItemTextArrow r234 = r233.y0();
        if (r234 == null) goto L329;
        com.larus.utils.e1.x(r234);
    L312:
        r187 = true;
    L307:
        r186 = true;
        goto L308
    L296:
        com.larus.bmhome.setting.c r235 = this.f296459g;
        if (r235 == null) goto L301;
        ItemGroup r236 = r235.g();
        if (r236 == null) goto L301;
        com.larus.utils.e1.o(r236);
        goto L301
    L282:
        if (r174.DK() != true) goto L284;
        r175 = true;
    L278:
        r174 = null;
        goto L280
    L265:
        r168 = null;
        goto L266
    L254:
        if (r165.isDestroyed() == true) goto L258;
        if (Intrinsics.areEqual(r165.getClass().getName(), r161) == false) goto L258;
        r166 = true;
        goto L259
    L261:
        r164 = null;
        goto L262
    L279:
        r174 = r159;
        goto L280
    L224:
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.f() == true) goto L227;
    L236:
        com.larus.bmhome.setting.c r237 = this.f296459g;
        if (r237 == null) goto L241;
        ItemTextArrow r238 = r237.B0();
        if (r238 == null) goto L241;
        com.larus.utils.e1.d(r238, new g4(this));
    L241:
        com.larus.bmhome.setting.c r239 = this.f296459g;
        if (r239 == null) goto L246;
        ItemTextArrow r240 = r239.B0();
        if (r240 == null) goto L246;
        com.larus.utils.e1.x(r240);
        goto L246
    L227:
        if (com.larus.bmhome.utils.d3.f315000a.getInt("primacy_guide", 0) != 0) goto L229;
        boolean r241 = true;
    L230:
        if (r241 == false) goto L236;
        com.larus.bmhome.setting.c r242 = this.f296459g;
        if (r242 == null) goto L236;
        ItemTextArrow r243 = r242.B0();
        if (r243 == null) goto L236;
        r243.i6(getString(R.string.larus_settings_permission_contact_sectionTitle));
        goto L236
    L229:
        r241 = false;
        goto L230
    L215:
        if (r156 == null) goto L218;
        com.larus.utils.e1.o(r156);
    L211:
        r156 = null;
        goto L213
    L196:
        com.larus.bmhome.setting.c r244 = this.f296459g;
        if (r244 == null) goto L201;
        ItemTextView r245 = r244.d0();
        if (r245 == null) goto L201;
        r245.setOnClickListener(new d0(this));
    L201:
        com.larus.bmhome.setting.c r246 = this.f296459g;
        if (r246 == null) goto L206;
        ItemTextView r247 = r246.d0();
        if (r247 == null) goto L206;
        com.larus.utils.e1.x(r247);
        goto L206
    L53:
        if (com.larus.platform.service.z2.f365865a.q().f486691j == false) goto L65;
        com.larus.bmhome.setting.c r248 = this.f296459g;
        if (r248 == null) goto L60;
        final ItemTextArrow r249 = r248.a();
        if (r249 == null) goto L60;
        r249.setText(getString(R.string.larus_settings_about_app, new Object[]{getString(R.string.app_name_replace)}));
        com.larus.utils.e1.d(r249, new u4(r249, this));
    L60:
        com.larus.bmhome.setting.c r250 = this.f296459g;
        if (r250 == null) goto L70;
        ItemTextArrow r251 = r250.a();
        if (r251 == null) goto L70;
        com.larus.utils.e1.x(r251);
        goto L70
    L33:
        if (com.larus.platform.service.z2.f365865a.q().f486690i == false) goto L45;
        com.larus.bmhome.setting.c r252 = this.f296459g;
        if (r252 == null) goto L40;
        ItemTextArrow r253 = r252.I();
        if (r253 == null) goto L40;
        r253.setOnClickListener(new w4(this));
    L40:
        com.larus.bmhome.setting.c r254 = this.f296459g;
        if (r254 == null) goto L50;
        ItemTextArrow r255 = r254.I();
        if (r255 == null) goto L50;
        com.larus.utils.e1.x(r255);
        goto L50
    }

    public final void pb0(ModelItemIdentity r100, String r101) {
        if (this.L0 == true) goto L5;
        return;
    L5:
        this.L0 = false;
        if (Intrinsics.areEqual(r100, wa8.t0.f558885a) == true) goto L8;
    L9:
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        String r103 = getString(R.string.larus_model_switch_toast_switched);
        Object[] r104 = new Object[1];
        if (r101 != null) goto L12;
        r101 = "";
    L12:
        r104[0] = r101;
        String r105 = String.format(r103, Arrays.copyOf(r104, 1));
        t19.s r106 = t19.s.f544207a;
        Context r107 = requireContext();
        r106.getClass();
        t19.s.p(r107, r105);
        return;
    L8:
        if (ObricTaskSkillDelegate.f392916b.c(Oa0()) == true) goto L9;
    }

    public static final Object W90(CommonSettingFragment r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof CommonSettingFragment$findConversationInfo$1) == false) goto L7;
        CommonSettingFragment$findConversationInfo$1 r103 = (CommonSettingFragment$findConversationInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        CommonSettingFragment$findConversationInfo$1 r105 = r103;
        Object r106 = r105.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r105.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L17:
        wc9.e r109 = (wc9.e) r106;
        if (r109 == null) goto L20;
        FLogger.f375446a.d(r100.f296457e, "Found conversation info: " + r109);
        return r109;
    L20:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        RepoDispatcher.f307729a.getClass();
        ConversationRepo r110 = RepoDispatcher.f307734f;
        r105.label = 1;
        r106 = IConversationRepoService.a.c(r110, r101, false, null, r105, 6);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r103 = new CommonSettingFragment$findConversationInfo$1(r100, r102);
        goto L8
    }

    public static void Wa0(String r110, String r111, String r112) {
        ICommerceMembershipService.f325827a.getClass();
        ICommerceMembershipService r100 = ICommerceMembershipService.a.a();
        String r101 = null;
        if (r100 == null) goto L5;
        uz8.c r102 = r100.z(r110);
    L6:
        ICommerceMembershipService r103 = ICommerceMembershipService.a.a();
        if (r103 == null) goto L31;
        if (r102 == null) goto L10;
        String r104 = r102.f552209a;
    L12:
        if (com.larus.utils.o0.d(r104) == false) goto L16;
        if (r102 == null) goto L15;
        String r105 = r102.f552209a;
    L18:
        if (r102 == null) goto L20;
        String r106 = r102.f552210b;
    L21:
        if (r102 == null) goto L23;
        String r107 = r102.f552211c;
    L24:
        if (r102 == null) goto L26;
        String r108 = r102.f552212d;
    L27:
        if (r102 == null) goto L29;
        r101 = r102.f552214f;
    L29:
        ICommerceMembershipService.b.b(r103, r105, "settings", r106, r107, r108, r101, r112, null, null, null, null, null, 3968);
        return;
    L26:
        r108 = null;
        goto L27
    L23:
        r107 = null;
        goto L24
    L20:
        r106 = null;
        goto L21
    L15:
        r105 = null;
        goto L18
    L16:
        r105 = r111;
        goto L18
    L10:
        r104 = null;
        goto L12
    L31:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r910, ViewGroup r911, Bundle r912) {
        Intrinsics.checkNotNullParameter(r910, "inflater");
        boolean r100 = true;
        if (this.f296468m != 1) goto L7;
        if (com.larus.platform.service.z2.f365865a.enableMainBotNewSetting() == false) goto L7;
    L10:
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r910, "inflater");
        int r101 = R.id.chat_setting_header_container;
        if (r100 == false) goto L249;
        boolean r102 = com.larus.platform.service.z2.f365865a.configListReorder();
        if (r102 == false) goto L15;
        int r103 = R.layout.larus_page_chat_setting_main_bot_reorder;
    L16:
        View r104 = r910.inflate(r103, r911, false);
        ItemTextArrow r110 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.about_app);
        if (r110 == null) goto L246;
        ItemTextView r210 = (ItemTextView) ViewBindings.findChildViewById(r104, R.id.account_logout);
        if (r210 == null) goto L245;
        AppCompatTextView r211 = (AppCompatTextView) ViewBindings.findChildViewById(r104, R.id.account_settings);
        if (r211 == null) goto L244;
        CardView r212 = (CardView) ViewBindings.findChildViewById(r104, R.id.advanced_setting);
        if (r212 == null) goto L243;
        AppInfoLayout r213 = (AppInfoLayout) ViewBindings.findChildViewById(r104, R.id.app_info);
        if (r213 != null) goto L27;
        r101 = R.id.app_info;
    L248:
        throw new NullPointerException("Missing required view with ID: ".concat(r104.getResources().getResourceName(r101)));
    L27:
        if (((LinearLayout) ViewBindings.findChildViewById(r104, R.id.bottom_layout)) == null) goto L241;
        FrameLayout r214 = (FrameLayout) ViewBindings.findChildViewById(r104, R.id.chat_setting_header_container);
        if (r214 == null) goto L248;
        if (((ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.clear_cache)) == null) goto L240;
        ItemTextArrow r215 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.commerce_credit);
        if (r215 == null) goto L239;
        LinearLayout r216 = (LinearLayout) ViewBindings.findChildViewById(r104, R.id.container_layout);
        if (r216 == null) goto L238;
        ItemTextArrow r217 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.creation_output_settings);
        if (r217 == null) goto L237;
        ItemTextMenu r218 = (ItemTextMenu) ViewBindings.findChildViewById(r104, R.id.default_reply_mode_menu_item);
        if (r218 == null) goto L236;
        TextView r219 = (TextView) ViewBindings.findChildViewById(r104, R.id.disclaimer);
        if (r219 == null) goto L235;
        ItemTextArrow r310 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.dora_entrance);
        if (r310 == null) goto L234;
        ItemTextArrow r311 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.doubao_website);
        if (r311 == null) goto L233;
        ItemTextArrow r312 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.drive_capacity);
        if (r312 == null) goto L232;
        ItemTextArrow r313 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.edit_item);
        if (r313 == null) goto L231;
        ItemTextArrow r314 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.font_and_theme_setting);
        if (r314 == null) goto L230;
        ItemTextMenu r315 = (ItemTextMenu) ViewBindings.findChildViewById(r104, R.id.fork_conversation_menu_item);
        if (r315 == null) goto L229;
        ItemTextArrow r316 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.get_pro_item);
        if (r316 == null) goto L228;
        ItemTextArrow r317 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.icon_edit_item);
        if (r317 == null) goto L227;
        ItemTextMenu r318 = (ItemTextMenu) ViewBindings.findChildViewById(r104, R.id.independent_reply_mode_menu_item);
        if (r318 == null) goto L226;
        ItemTextArrow r319 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.independent_reply_model_menu_item);
        if (r319 == null) goto L225;
        ItemTextArrow r410 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.item_bind_account);
        if (r410 == null) goto L224;
        ItemTextArrow r411 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.item_minor);
        if (r411 == null) goto L223;
        ItemTextView r412 = (ItemTextView) ViewBindings.findChildViewById(r104, R.id.join_discord);
        if (r412 == null) goto L222;
        ItemTextMenu r413 = (ItemTextMenu) ViewBindings.findChildViewById(r104, R.id.keyboard_return_behavior);
        if (r413 == null) goto L221;
        ItemTextArrow r414 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.language_item);
        if (r414 == null) goto L220;
        ItemTextArrow r415 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.ltm_item);
        if (r415 == null) goto L219;
        ItemTextArrow r416 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.management_item);
        if (r416 == null) goto L218;
        ItemTextArrow r105 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.membership_item);
        if (r105 == null) goto L217;
        FrameLayout r417 = (FrameLayout) ViewBindings.findChildViewById(r104, R.id.multi_account_header_container);
        if (r417 == null) goto L216;
        ItemTextArrow r418 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.multi_account_switch);
        if (r418 == null) goto L215;
        ItemGroup r510 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.new_group1);
        if (r510 == null) goto L214;
        ItemGroup r511 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.new_group2);
        if (r511 == null) goto L213;
        ItemGroup r512 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.new_group3);
        if (r512 == null) goto L212;
        ItemGroup r513 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.new_group4);
        if (r513 == null) goto L211;
        ItemGroup r514 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.new_group_bind_account);
        if (r514 == null) goto L210;
        ItemGroup r515 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.new_group_chat);
        if (r515 == null) goto L209;
        ItemGroup r516 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.new_group_membership);
        if (r516 == null) goto L208;
        ItemGroup r517 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.new_group_minor);
        if (r517 == null) goto L207;
        ItemGroup r518 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.new_group_pro);
        if (r518 == null) goto L206;
        AppCompatTextView r519 = (AppCompatTextView) ViewBindings.findChildViewById(r104, R.id.nick_name);
        if (r519 == null) goto L205;
        AppCompatImageView r610 = (AppCompatImageView) ViewBindings.findChildViewById(r104, R.id.nick_name_chevron);
        if (r610 == null) goto L204;
        ConstraintLayout r611 = (ConstraintLayout) ViewBindings.findChildViewById(r104, R.id.nick_name_container);
        if (r611 == null) goto L203;
        ItemTextArrow r612 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.notify_settings);
        if (r612 == null) goto L202;
        ItemTextArrow r106 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.office_task_settings);
        if (r106 == null) goto L201;
        ItemTextArrow r613 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.orders);
        if (r613 == null) goto L200;
        TextView r614 = (TextView) ViewBindings.findChildViewById(r104, R.id.personal_info_collect);
        if (r614 == null) goto L199;
        ItemTextToggle r615 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.prefer_interrupt);
        if (r615 == null) goto L198;
        ItemTextToggle r616 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.prefer_prompt);
        if (r616 == null) goto L197;
        ItemTextToggle r617 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.prefer_prompt_style);
        if (r617 == null) goto L196;
        ItemTextToggle r618 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.prefer_show_highlight);
        if (r618 == null) goto L195;
        ItemTextToggle r710 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.prefer_stream);
        if (r710 == null) goto L194;
        ItemTextToggle r711 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.prefer_tts);
        if (r711 == null) goto L193;
        ItemTextArrow r107 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.privacy_data_permission);
        if (r107 == null) goto L192;
        ItemTextToggle r712 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.realtime_call_settings);
        if (r712 == null) goto L191;
        ItemTextToggle r713 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.realtime_call_style_item);
        if (r713 == null) goto L190;
        ItemTextToggle r108 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.related_video_settings);
        if (r108 == null) goto L189;
        ItemTextArrow r109 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.renew_section);
        if (r109 == null) goto L188;
        TextView r714 = (TextView) ViewBindings.findChildViewById(r104, R.id.sanfang_share);
        if (r714 == null) goto L187;
        NestedScrollView r715 = (NestedScrollView) ViewBindings.findChildViewById(r104, R.id.scroll_view);
        if (r715 == null) goto L186;
        ItemTextArrow r111 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.search_section);
        if (r111 == null) goto L185;
        ItemGroup r810 = (ItemGroup) ViewBindings.findChildViewById(r104, R.id.sounds_group);
        if (r810 == null) goto L184;
        ItemTextToggle r112 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.startup_open_new_chat);
        if (r112 == null) goto L183;
        ItemTextArrow r811 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.sug_settings);
        if (r811 == null) goto L182;
        ItemTextArrow r812 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.thirdPartyArrow);
        if (r812 == null) goto L181;
        NovaTitleBarEx r813 = (NovaTitleBarEx) ViewBindings.findChildViewById(r104, R.id.title);
        if (r813 == null) goto L180;
        ItemTextArrow r113 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.tts_speaker_item);
        if (r113 == null) goto L179;
        ItemTextArrow r114 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.tts_speaker_item_v2);
        if (r114 == null) goto L178;
        ItemTextArrow r814 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.use_on_computer);
        if (r814 == null) goto L177;
        RoundAvatarImageView r815 = (RoundAvatarImageView) ViewBindings.findChildViewById(r104, R.id.user_avatar);
        if (r815 == null) goto L176;
        RelativeLayout r816 = (RelativeLayout) ViewBindings.findChildViewById(r104, R.id.user_container);
        if (r816 == null) goto L175;
        ItemTextArrow r913 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.user_feedback);
        if (r913 == null) goto L174;
        AppCompatTextView r914 = (AppCompatTextView) ViewBindings.findChildViewById(r104, R.id.user_name);
        if (r914 == null) goto L173;
        ItemTextToggle r915 = (ItemTextToggle) ViewBindings.findChildViewById(r104, R.id.video_settings);
        if (r915 == null) goto L172;
        ItemTextArrow r916 = (ItemTextArrow) ViewBindings.findChildViewById(r104, R.id.walletEntry);
        if (r916 == null) goto L171;
        LarusPageChatSettingMainBotBinding r115 = new LarusPageChatSettingMainBotBinding((LinearLayout) r104, r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r105, r417, r418, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r106, r613, r614, r615, r616, r617, r618, r710, r711, r107, r712, r713, r108, r109, r714, r715, r111, r810, r112, r811, r812, r813, r113, r114, r814, r815, r816, r913, r914, r915, r916);
        r105.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.MEMBERSHIP);
        r113.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.TTS_SPEAKER_ITEM);
        r114.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.TTS_SPEAKER_ITEM);
        r109.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.RENEW_SECTION);
        r111.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.SEARCH_SECTION);
        r115.f311188c.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.SAAS_ACCOUNT_BIND);
        r115.f311204k.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.DEFAULT_REPLY_MODE);
        r115.f311224u.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.INDEPENDENT_REPLY_MODE);
        r115.f311226v.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.INDEPENDENT_REPLY_MODEL);
        r108.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.RELATED_VIDEO);
        r115.f311212o.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.DRIVE_STORAGE);
        r107.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.PRIVACY_PERMISSION);
        r115.f311210n.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.DOUBAO_WEBSITE);
        r115.f311186b.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.ABOUT_DOUBAO);
        r106.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.OFFICE_TASK_SETTINGS);
        r115.f311218r.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.FORK_CONVERSATION);
        r115.f311228w.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.SAAS_ACCOUNT_BIND);
        r112.setTag(R.id.larus_bot_settings_config_key, SettingsItemType.STARTUP_OPEN_NEW_CHAT);
        com.larus.bmhome.setting.c r116 = new o(r115, r102);
    L356:
        this.f296459g = r116;
        Ba0();
        com.larus.bmhome.setting.c r117 = this.f296459g;
        if (r117 == null) goto L359;
        s1a.a.g(this).n(r117, com.larus.bmhome.setting.c.class);
    L359:
        s1a.a.g(this).n(new com.larus.bmhome.setting.k(this.f296455J), com.larus.bmhome.setting.k.class);
        com.larus.bmhome.setting.c r118 = this.f296459g;
        if (r118 == null) goto L364;
        View r119 = r118.P0();
        if (r119 == null) goto L364;
        r119.setTag(R.id.lib_track_tag_parent_track_node, this);
        return r119;
    L364:
        return null;
    L171:
        r101 = R.id.walletEntry;
        goto L248
    L172:
        r101 = R.id.video_settings;
        goto L248
    L173:
        r101 = R.id.user_name;
        goto L248
    L174:
        r101 = R.id.user_feedback;
        goto L248
    L175:
        r101 = R.id.user_container;
        goto L248
    L176:
        r101 = R.id.user_avatar;
        goto L248
    L177:
        r101 = R.id.use_on_computer;
        goto L248
    L178:
        r101 = R.id.tts_speaker_item_v2;
        goto L248
    L179:
        r101 = R.id.tts_speaker_item;
        goto L248
    L180:
        r101 = R.id.title;
        goto L248
    L181:
        r101 = R.id.thirdPartyArrow;
        goto L248
    L182:
        r101 = R.id.sug_settings;
        goto L248
    L183:
        r101 = R.id.startup_open_new_chat;
        goto L248
    L184:
        r101 = R.id.sounds_group;
        goto L248
    L185:
        r101 = R.id.search_section;
        goto L248
    L186:
        r101 = R.id.scroll_view;
        goto L248
    L187:
        r101 = R.id.sanfang_share;
        goto L248
    L188:
        r101 = R.id.renew_section;
        goto L248
    L189:
        r101 = R.id.related_video_settings;
        goto L248
    L190:
        r101 = R.id.realtime_call_style_item;
        goto L248
    L191:
        r101 = R.id.realtime_call_settings;
        goto L248
    L192:
        r101 = R.id.privacy_data_permission;
        goto L248
    L193:
        r101 = R.id.prefer_tts;
        goto L248
    L194:
        r101 = R.id.prefer_stream;
        goto L248
    L195:
        r101 = R.id.prefer_show_highlight;
        goto L248
    L196:
        r101 = R.id.prefer_prompt_style;
        goto L248
    L197:
        r101 = R.id.prefer_prompt;
        goto L248
    L198:
        r101 = R.id.prefer_interrupt;
        goto L248
    L199:
        r101 = R.id.personal_info_collect;
        goto L248
    L200:
        r101 = R.id.orders;
        goto L248
    L201:
        r101 = R.id.office_task_settings;
        goto L248
    L202:
        r101 = R.id.notify_settings;
        goto L248
    L203:
        r101 = R.id.nick_name_container;
        goto L248
    L204:
        r101 = R.id.nick_name_chevron;
        goto L248
    L205:
        r101 = R.id.nick_name;
        goto L248
    L206:
        r101 = R.id.new_group_pro;
        goto L248
    L207:
        r101 = R.id.new_group_minor;
        goto L248
    L208:
        r101 = R.id.new_group_membership;
        goto L248
    L209:
        r101 = R.id.new_group_chat;
        goto L248
    L210:
        r101 = R.id.new_group_bind_account;
        goto L248
    L211:
        r101 = R.id.new_group4;
        goto L248
    L212:
        r101 = R.id.new_group3;
        goto L248
    L213:
        r101 = R.id.new_group2;
        goto L248
    L214:
        r101 = R.id.new_group1;
        goto L248
    L215:
        r101 = R.id.multi_account_switch;
        goto L248
    L216:
        r101 = R.id.multi_account_header_container;
        goto L248
    L217:
        r101 = R.id.membership_item;
        goto L248
    L218:
        r101 = R.id.management_item;
        goto L248
    L219:
        r101 = R.id.ltm_item;
        goto L248
    L220:
        r101 = R.id.language_item;
        goto L248
    L221:
        r101 = R.id.keyboard_return_behavior;
        goto L248
    L222:
        r101 = R.id.join_discord;
        goto L248
    L223:
        r101 = R.id.item_minor;
        goto L248
    L224:
        r101 = R.id.item_bind_account;
        goto L248
    L225:
        r101 = R.id.independent_reply_model_menu_item;
        goto L248
    L226:
        r101 = R.id.independent_reply_mode_menu_item;
        goto L248
    L227:
        r101 = R.id.icon_edit_item;
        goto L248
    L228:
        r101 = R.id.get_pro_item;
        goto L248
    L229:
        r101 = R.id.fork_conversation_menu_item;
        goto L248
    L230:
        r101 = R.id.font_and_theme_setting;
        goto L248
    L231:
        r101 = R.id.edit_item;
        goto L248
    L232:
        r101 = R.id.drive_capacity;
        goto L248
    L233:
        r101 = R.id.doubao_website;
        goto L248
    L234:
        r101 = R.id.dora_entrance;
        goto L248
    L235:
        r101 = R.id.disclaimer;
        goto L248
    L236:
        r101 = R.id.default_reply_mode_menu_item;
        goto L248
    L237:
        r101 = R.id.creation_output_settings;
        goto L248
    L238:
        r101 = R.id.container_layout;
        goto L248
    L239:
        r101 = R.id.commerce_credit;
        goto L248
    L240:
        r101 = R.id.clear_cache;
        goto L248
    L241:
        r101 = R.id.bottom_layout;
        goto L248
    L243:
        r101 = R.id.advanced_setting;
        goto L248
    L244:
        r101 = R.id.account_settings;
        goto L248
    L245:
        r101 = R.id.account_logout;
        goto L248
    L246:
        r101 = R.id.about_app;
        goto L248
    L15:
        r103 = R.layout.larus_page_chat_setting_main_bot;
        goto L16
    L249:
        View r120 = r910.inflate(R.layout.larus_page_chat_setting, r911, false);
        ItemLongTextArrow r121 = (ItemLongTextArrow) ViewBindings.findChildViewById(r120, R.id.access_permission_item);
        if (r121 == null) goto L413;
        ItemTextView r220 = (ItemTextView) ViewBindings.findChildViewById(r120, R.id.add_shortcart);
        if (r220 == null) goto L412;
        RoundAvatarImageView r221 = (RoundAvatarImageView) ViewBindings.findChildViewById(r120, R.id.bot_avatar);
        if (r221 == null) goto L411;
        SimpleDraweeView r222 = (SimpleDraweeView) ViewBindings.findChildViewById(r120, R.id.bot_bg);
        if (r222 == null) goto L410;
        TextView r223 = (TextView) ViewBindings.findChildViewById(r120, R.id.bot_bio);
        if (r223 == null) goto L409;
        TextView r224 = (TextView) ViewBindings.findChildViewById(r120, R.id.bot_creator_name);
        if (r224 == null) goto L408;
        LinearLayout r225 = (LinearLayout) ViewBindings.findChildViewById(r120, R.id.bot_enable_gen_pic);
        if (r225 != null) goto L264;
        r101 = R.id.bot_enable_gen_pic;
    L415:
        throw new NullPointerException("Missing required view with ID: ".concat(r120.getResources().getResourceName(r101)));
    L264:
        if (((TextView) ViewBindings.findChildViewById(r120, R.id.bot_enable_gen_pic_des)) == null) goto L406;
        LinearLayout r226 = (LinearLayout) ViewBindings.findChildViewById(r120, R.id.bot_enable_web_search);
        if (r226 != null) goto L268;
        r101 = R.id.bot_enable_web_search;
        goto L415
    L268:
        if (((TextView) ViewBindings.findChildViewById(r120, R.id.bot_enable_web_search_des)) == null) goto L404;
        LinearLayout r227 = (LinearLayout) ViewBindings.findChildViewById(r120, R.id.bot_info_area);
        if (r227 == null) goto L403;
        TextView r228 = (TextView) ViewBindings.findChildViewById(r120, R.id.bot_name);
        if (r228 == null) goto L402;
        LinearLayout r229 = (LinearLayout) ViewBindings.findChildViewById(r120, R.id.bot_switch_area);
        if (r229 == null) goto L401;
        TagTextView r320 = (TagTextView) ViewBindings.findChildViewById(r120, R.id.bot_tag_view);
        if (r320 == null) goto L400;
        FrameLayout r321 = (FrameLayout) ViewBindings.findChildViewById(r120, R.id.chat_setting_header_container);
        if (r321 == null) goto L415;
        if (((ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.clear_cache)) == null) goto L399;
        LinearLayout r322 = (LinearLayout) ViewBindings.findChildViewById(r120, R.id.container_layout);
        if (r322 == null) goto L398;
        ItemTextView r323 = (ItemTextView) ViewBindings.findChildViewById(r120, R.id.delete_conversation);
        if (r323 != null) goto L286;
        r101 = R.id.delete_conversation;
        goto L415
    L286:
        if (((ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.dora_entrance)) == null) goto L396;
        ItemTextArrow r324 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.edit_cvs_name);
        if (r324 == null) goto L395;
        ItemTextArrow r325 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.edit_item);
        if (r325 == null) goto L394;
        ItemTextToggle r326 = (ItemTextToggle) ViewBindings.findChildViewById(r120, R.id.expert_text);
        if (r326 == null) goto L393;
        ItemTextArrow r327 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.get_pro_item);
        if (r327 == null) goto L392;
        ItemGroup r328 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_1);
        if (r328 == null) goto L391;
        ItemGroup r329 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_2);
        if (r329 == null) goto L390;
        ItemGroup r419 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_3);
        if (r419 == null) goto L389;
        ItemGroup r420 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_4);
        if (r420 == null) goto L388;
        ItemGroup r421 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_5);
        if (r421 != null) goto L306;
        r101 = R.id.group_5;
        goto L415
    L306:
        if (((ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_dora)) == null) goto L386;
        ItemGroup r422 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_get_pro);
        if (r422 == null) goto L385;
        ItemGroup r423 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_review);
        if (r423 == null) goto L384;
        ItemGroup r424 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_search);
        if (r424 == null) goto L383;
        ItemGroup r425 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.group_shortcart);
        if (r425 == null) goto L382;
        TextView r426 = (TextView) ViewBindings.findChildViewById(r120, R.id.healthAgreement);
        if (r426 == null) goto L381;
        AppCompatImageView r427 = (AppCompatImageView) ViewBindings.findChildViewById(r120, R.id.hot_tag);
        if (r427 == null) goto L380;
        ItemTextArrow r428 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.icon_edit_item);
        if (r428 == null) goto L379;
        ItemTextArrow r520 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.language_item);
        if (r520 == null) goto L378;
        TextView r521 = (TextView) ViewBindings.findChildViewById(r120, R.id.llm_disclaimer_powered_by);
        if (r521 == null) goto L377;
        ItemTextArrow r522 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.ltm_item);
        if (r522 == null) goto L376;
        ItemTextArrow r523 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.model_item);
        if (r523 == null) goto L375;
        ItemTextToggle r524 = (ItemTextToggle) ViewBindings.findChildViewById(r120, R.id.msg_push_text);
        if (r524 == null) goto L374;
        ItemTextArrow r525 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.nick_name_item);
        if (r525 == null) goto L373;
        ItemTextArrow r526 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.plugin_item);
        if (r526 == null) goto L372;
        ItemTextToggle r527 = (ItemTextToggle) ViewBindings.findChildViewById(r120, R.id.realtime_call_style_item);
        if (r527 == null) goto L371;
        r101 = R.id.renew_section;
        ItemTextArrow r528 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.renew_section);
        if (r528 == null) goto L415;
        ItemTextArrow r529 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.resubmit_button);
        if (r529 == null) goto L370;
        ItemTextArrow r619 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.search_section);
        if (r619 == null) goto L369;
        ViewStub r620 = (ViewStub) ViewBindings.findChildViewById(r120, R.id.share_button_center);
        if (r620 == null) goto L368;
        ItemGroup r621 = (ItemGroup) ViewBindings.findChildViewById(r120, R.id.sounds_group);
        if (r621 == null) goto L367;
        r101 = R.id.title;
        NovaTitleBarEx r622 = (NovaTitleBarEx) ViewBindings.findChildViewById(r120, R.id.title);
        if (r622 == null) goto L415;
        ItemTextArrow r623 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.tts_speaker_item);
        if (r623 == null) goto L366;
        r101 = R.id.tts_speaker_item_v2;
        ItemTextArrow r624 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.tts_speaker_item_v2);
        if (r624 == null) goto L415;
        r101 = R.id.tts_voice_create;
        ItemTextArrow r625 = (ItemTextArrow) ViewBindings.findChildViewById(r120, R.id.tts_voice_create);
        if (r625 == null) goto L415;
        r116 = new p(new LarusPageChatSettingBinding((LinearLayout) r120, r121, r220, r221, r222, r223, r224, r225, r226, r227, r228, r229, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r419, r420, r421, r422, r423, r424, r425, r426, r427, r428, r520, r521, r522, r523, r524, r525, r526, r527, r528, r529, r619, r620, r621, r622, r623, r624, r625));
        goto L356
    L366:
        r101 = R.id.tts_speaker_item;
        goto L415
    L367:
        r101 = R.id.sounds_group;
        goto L415
    L368:
        r101 = R.id.share_button_center;
        goto L415
    L369:
        r101 = R.id.search_section;
        goto L415
    L370:
        r101 = R.id.resubmit_button;
        goto L415
    L371:
        r101 = R.id.realtime_call_style_item;
        goto L415
    L372:
        r101 = R.id.plugin_item;
        goto L415
    L373:
        r101 = R.id.nick_name_item;
        goto L415
    L374:
        r101 = R.id.msg_push_text;
        goto L415
    L375:
        r101 = R.id.model_item;
        goto L415
    L376:
        r101 = R.id.ltm_item;
        goto L415
    L377:
        r101 = R.id.llm_disclaimer_powered_by;
        goto L415
    L378:
        r101 = R.id.language_item;
        goto L415
    L379:
        r101 = R.id.icon_edit_item;
        goto L415
    L380:
        r101 = R.id.hot_tag;
        goto L415
    L381:
        r101 = R.id.healthAgreement;
        goto L415
    L382:
        r101 = R.id.group_shortcart;
        goto L415
    L383:
        r101 = R.id.group_search;
        goto L415
    L384:
        r101 = R.id.group_review;
        goto L415
    L385:
        r101 = R.id.group_get_pro;
        goto L415
    L386:
        r101 = R.id.group_dora;
        goto L415
    L388:
        r101 = R.id.group_4;
        goto L415
    L389:
        r101 = R.id.group_3;
        goto L415
    L390:
        r101 = R.id.group_2;
        goto L415
    L391:
        r101 = R.id.group_1;
        goto L415
    L392:
        r101 = R.id.get_pro_item;
        goto L415
    L393:
        r101 = R.id.expert_text;
        goto L415
    L394:
        r101 = R.id.edit_item;
        goto L415
    L395:
        r101 = R.id.edit_cvs_name;
        goto L415
    L396:
        r101 = R.id.dora_entrance;
        goto L415
    L398:
        r101 = R.id.container_layout;
        goto L415
    L399:
        r101 = R.id.clear_cache;
        goto L415
    L400:
        r101 = R.id.bot_tag_view;
        goto L415
    L401:
        r101 = R.id.bot_switch_area;
        goto L415
    L402:
        r101 = R.id.bot_name;
        goto L415
    L403:
        r101 = R.id.bot_info_area;
        goto L415
    L404:
        r101 = R.id.bot_enable_web_search_des;
        goto L415
    L406:
        r101 = R.id.bot_enable_gen_pic_des;
        goto L415
    L408:
        r101 = R.id.bot_creator_name;
        goto L415
    L409:
        r101 = R.id.bot_bio;
        goto L415
    L410:
        r101 = R.id.bot_bg;
        goto L415
    L411:
        r101 = R.id.bot_avatar;
        goto L415
    L412:
        r101 = R.id.add_shortcart;
        goto L415
    L413:
        r101 = R.id.access_permission_item;
    L7:
        if (com.larus.platform.service.z2.f365865a.q().f486684c == true) goto L10;
        r100 = false;
        goto L10
    }

    public final Object Fa0(String r100, boolean r110, String r111, Continuation r112) {
        if ((r112 instanceof CommonSettingFragment$findBotInfo$1) == false) goto L7;
        CommonSettingFragment$findBotInfo$1 r101 = (CommonSettingFragment$findBotInfo$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        CommonSettingFragment$findBotInfo$1 r103 = r101;
        Object r113 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r113);
    L26:
        return r113;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r114 = r103.Z$0;
        IBotRepoService r106 = (IBotRepoService) r103.L$1;
        String r115 = (String) r103.L$0;
        ResultKt.throwOnFailure(r113);
        IBotRepoService r107 = r106;
        boolean r108 = r114;
        String r109 = r115;
    L20:
        String r116 = (String) CollectionsKt.firstOrNull((List) r113);
        if (r116 != null) goto L23;
        r116 = "";
    L23:
        FLogger.f375446a.d(this.f296457e, "Found bot info: ".concat(r116));
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 2;
        r113 = IBotRepoService.b.a(r107, r116, r108, r109, false, r103, 8);
        if (r113 != r104) goto L26;
        return r104;
    L16:
        ResultKt.throwOnFailure(r113);
        RepoDispatcher.f307729a.getClass();
        BotRepo r117 = RepoDispatcher.f307735g;
        r103.L$0 = r111;
        r103.L$1 = r117;
        r103.Z$0 = r110;
        r103.label = 1;
        Object r118 = ic8.n.b(r100, r103);
        if (r118 != r104) goto L19;
        return r104;
    L19:
        r108 = r110;
        r109 = r111;
        r107 = r117;
        r113 = r118;
    L7:
        r101 = new CommonSettingFragment$findBotInfo$1(this, r112);
        goto L8
    }

    public static /* synthetic */ Object Ga0(CommonSettingFragment r100, String r101, boolean r102, Continuation r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r104 & 4) == 0) goto L8;
        String r105 = "default";
    L10:
        return r100.Fa0(r101, r102, r105, r103);
    L8:
        r105 = null;
        goto L10
    }
}
