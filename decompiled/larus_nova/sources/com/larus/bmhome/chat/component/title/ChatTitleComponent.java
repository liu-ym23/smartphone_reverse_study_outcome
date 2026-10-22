package com.larus.bmhome.chat.component.title;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.services.apm.api.EnsureManager;
import com.ixigua.lib.track.TrackParams;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.ChatActivity;
import com.larus.bmhome.chat.ChatDoubleTabFragment;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.component.showcase.ShowCaseTitleBar;
import com.larus.bmhome.chat.g4;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.bmhome.chat.model.TitleQuotaModel;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.databinding.LarusPageChatImmersiveBinding;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.bmhome.view.ChatTitleAlignLeftStyle;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.chat.ChatTitleBarIcon;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.im.bean.IMConnectState;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ModelItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.api.IAppLaunchReporter;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.TitleBarInflateService;
import com.larus.platform.service.c2;
import com.larus.platform.service.i3;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.SafeExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000×\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b%*\u0001\u0010\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010Ó\u0001\u001a\u00030È\u0001H\u0016J\n\u0010Ô\u0001\u001a\u00030È\u0001H\u0016J\n\u0010Õ\u0001\u001a\u00030È\u0001H\u0002J\u0014\u0010Ö\u0001\u001a\u00030È\u00012\b\u0010×\u0001\u001a\u00030Ø\u0001H\u0002J\u0013\u0010Ù\u0001\u001a\u00030È\u00012\u0007\u0010Ú\u0001\u001a\u00020\u0019H\u0016J\n\u0010Û\u0001\u001a\u00030È\u0001H\u0002J\u0015\u0010Ü\u0001\u001a\u00030È\u00012\t\b\u0002\u0010Ý\u0001\u001a\u00020\u0016H\u0002J\n\u0010Þ\u0001\u001a\u00030È\u0001H\u0016J\n\u0010â\u0001\u001a\u00030È\u0001H\u0002J\n\u0010ã\u0001\u001a\u00030È\u0001H\u0016J\n\u0010ä\u0001\u001a\u00030È\u0001H\u0002J\n\u0010æ\u0001\u001a\u00030È\u0001H\u0002J\n\u0010ç\u0001\u001a\u00030È\u0001H\u0016J\n\u0010è\u0001\u001a\u00030È\u0001H\u0016J\n\u0010é\u0001\u001a\u00030È\u0001H\u0016J\n\u0010î\u0001\u001a\u00030È\u0001H\u0002J\n\u0010ï\u0001\u001a\u00030È\u0001H\u0016J\n\u0010ð\u0001\u001a\u00030È\u0001H\u0016J\n\u0010ñ\u0001\u001a\u00030È\u0001H\u0016J\n\u0010ò\u0001\u001a\u00030È\u0001H\u0016J\u000b\u0010ó\u0001\u001a\u0004\u0018\u00010\u000eH\u0016J\f\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0016J\f\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001H\u0016J\n\u0010ø\u0001\u001a\u00030È\u0001H\u0002J\n\u0010ù\u0001\u001a\u00030È\u0001H\u0002J\n\u0010ú\u0001\u001a\u00030È\u0001H\u0002J\n\u0010û\u0001\u001a\u00030È\u0001H\u0002J\n\u0010ü\u0001\u001a\u00030È\u0001H\u0002J\u0014\u0010ý\u0001\u001a\u00020\u00162\t\b\u0002\u0010þ\u0001\u001a\u00020\u0016H\u0002J\u000b\u0010ÿ\u0001\u001a\u0004\u0018\u00010\u001eH\u0002J\u001b\u0010\u0080\u0002\u001a\u00030\u0081\u00022\b\u0010\u0082\u0002\u001a\u00030\u0083\u0002H\u0082@¢\u0006\u0003\u0010\u0084\u0002J\u0014\u0010\u0085\u0002\u001a\u00030È\u00012\b\u0010\u0086\u0002\u001a\u00030\u0083\u0002H\u0002J\u0014\u0010\u0087\u0002\u001a\u00030È\u00012\b\u0010\u0088\u0002\u001a\u00030\u0083\u0002H\u0002J\n\u0010\u0089\u0002\u001a\u00030È\u0001H\u0002J\u0016\u0010\u008a\u0002\u001a\u00030È\u00012\n\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u008c\u0002H\u0002J\t\u0010\u008d\u0002\u001a\u00020\u0016H\u0002J\n\u0010\u008e\u0002\u001a\u00030È\u0001H\u0002J\n\u0010\u008f\u0002\u001a\u00030È\u0001H\u0002J3\u0010\u0090\u0002\u001a\u00030È\u00012\t\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u001e2\u0007\u0010\u0092\u0002\u001a\u00020\u00162\u0007\u0010\u0093\u0002\u001a\u00020\b2\n\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0095\u0002H\u0016J(\u0010\u0096\u0002\u001a\u00030È\u00012\t\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u001e2\u0007\u0010\u0098\u0002\u001a\u00020\u00162\b\u0010\u0099\u0002\u001a\u00030\u0095\u0002H\u0016J\t\u0010\u009a\u0002\u001a\u00020\u0016H\u0002J\t\u0010\u009b\u0002\u001a\u00020\u0016H\u0002J\n\u0010\u009c\u0002\u001a\u00030È\u0001H\u0002J\u0013\u0010\u009d\u0002\u001a\u00030È\u00012\u0007\u0010\u009e\u0002\u001a\u00020\u0016H\u0016J\u0011\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0003\u0010 \u0002J\u001d\u0010¡\u0002\u001a\u00030È\u00012\u0007\u0010\u009e\u0002\u001a\u00020\u00162\b\u0010¢\u0002\u001a\u00030\u0081\u0002H\u0016J\u001b\u0010£\u0002\u001a\u00030¤\u00022\t\u0010¥\u0002\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0003\u0010¦\u0002J7\u0010§\u0002\u001a\u00030È\u00012\n\u0010¨\u0002\u001a\u0005\u0018\u00010\u0083\u00022\n\u0010©\u0002\u001a\u0005\u0018\u00010ª\u00022\n\u0010«\u0002\u001a\u0005\u0018\u00010¬\u00022\u0007\u0010\u00ad\u0002\u001a\u00020\u001eH\u0016J\t\u0010®\u0002\u001a\u00020\u001eH\u0016J%\u0010¯\u0002\u001a\u00030È\u00012\b\u0010°\u0002\u001a\u00030ª\u00022\t\u0010±\u0002\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0003\u0010²\u0002J\u0016\u0010³\u0002\u001a\u00030È\u00012\n\u0010\u0099\u0002\u001a\u0005\u0018\u00010½\u0001H\u0016J&\u0010´\u0002\u001a\u00030È\u00012\b\u0010µ\u0002\u001a\u00030¶\u00022\u0007\u0010·\u0002\u001a\u00020\b2\u0007\u0010¸\u0002\u001a\u00020\bH\u0016J\u0013\u0010¹\u0002\u001a\u00030È\u00012\u0007\u0010º\u0002\u001a\u00020\u0016H\u0016J\n\u0010»\u0002\u001a\u00030È\u0001H\u0016J\u0014\u0010¼\u0002\u001a\u00030È\u00012\b\u0010½\u0002\u001a\u00030÷\u0001H\u0002J\u000b\u0010¾\u0002\u001a\u0004\u0018\u00010\u001eH\u0002J\n\u0010¿\u0002\u001a\u00030È\u0001H\u0002J\n\u0010À\u0002\u001a\u00030È\u0001H\u0002J\n\u0010Á\u0002\u001a\u00030È\u0001H\u0002J\u001b\u0010Â\u0002\u001a\u00030È\u00012\t\u0010Ã\u0002\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0003\u0010Ä\u0002J\u0014\u0010Å\u0002\u001a\u00030È\u00012\b\u0010Æ\u0002\u001a\u00030÷\u0001H\u0002J\u001c\u0010Ç\u0002\u001a\u0005\u0018\u00010È\u00012\b\u0010\u008b\u0002\u001a\u00030\u008c\u0002H\u0002¢\u0006\u0003\u0010È\u0002J\n\u0010É\u0002\u001a\u00030È\u0001H\u0002J\n\u0010Ê\u0002\u001a\u00030È\u0001H\u0002J\n\u0010Ë\u0002\u001a\u00030È\u0001H\u0002J\u0013\u0010Ì\u0002\u001a\u00030È\u00012\u0007\u0010¾\u0001\u001a\u00020\u0016H\u0002J\u0014\u0010Í\u0002\u001a\u00030È\u00012\b\u0010\u008b\u0002\u001a\u00030\u008c\u0002H\u0002J\f\u0010Î\u0002\u001a\u0005\u0018\u00010Ï\u0002H\u0002J\n\u0010Ð\u0002\u001a\u00030È\u0001H\u0002J\t\u0010Ñ\u0002\u001a\u00020\u0016H\u0002J&\u0010Ò\u0002\u001a\u00030È\u00012\b\u0010\u008b\u0002\u001a\u00030\u008c\u00022\u0007\u0010Ó\u0002\u001a\u00020\u001e2\u0007\u0010Ô\u0002\u001a\u00020\u000eH\u0002J\t\u0010Õ\u0002\u001a\u00020\u0016H\u0002J\u0014\u0010Ö\u0002\u001a\u00030È\u00012\b\u0010\u008b\u0002\u001a\u00030\u008c\u0002H\u0002J\u0012\u0010×\u0002\u001a\u0005\u0018\u00010È\u0001H\u0016¢\u0006\u0003\u0010Ø\u0002J\n\u0010Ù\u0002\u001a\u00030È\u0001H\u0002J\t\u0010Ú\u0002\u001a\u00020\u0016H\u0002J\t\u0010Û\u0002\u001a\u00020\u0016H\u0002J\t\u0010Ü\u0002\u001a\u00020\u0016H\u0002J\u0015\u0010Ý\u0002\u001a\u00020\u00162\n\u0010\u0088\u0002\u001a\u0005\u0018\u00010\u0083\u0002H\u0002J\t\u0010Þ\u0002\u001a\u00020\u0016H\u0002J \u0010ß\u0002\u001a\u00030È\u00012\t\u0010à\u0002\u001a\u0004\u0018\u00010\u001e2\t\u0010á\u0002\u001a\u0004\u0018\u00010\u001eH\u0002J*\u0010â\u0002\u001a\u00020\u00162\t\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u001e2\t\u0010ã\u0002\u001a\u0004\u0018\u00010\u001e2\t\u0010ä\u0002\u001a\u0004\u0018\u00010\u001eH\u0002J\u0011\u0010å\u0002\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0003\u0010æ\u0002J\t\u0010ç\u0002\u001a\u00020\u0016H\u0002J\n\u0010è\u0002\u001a\u00030È\u0001H\u0002J\u000b\u0010é\u0002\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010ê\u0002\u001a\u00030È\u0001H\u0002J!\u0010ë\u0002\u001a\u00030È\u00012\n\u0010\u008b\u0002\u001a\u0005\u0018\u00010\u008c\u00022\t\b\u0002\u0010ì\u0002\u001a\u00020\u0016H\u0002J\n\u0010í\u0002\u001a\u00030È\u0001H\u0002J\u0011\u0010î\u0002\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0003\u0010 \u0002J\u0011\u0010ï\u0002\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0003\u0010 \u0002J\f\u0010ð\u0002\u001a\u0005\u0018\u00010\u008c\u0002H\u0002J\t\u0010ñ\u0002\u001a\u00020\u001eH\u0002J\f\u0010ò\u0002\u001a\u0005\u0018\u00010\u0083\u0002H\u0002J\u000b\u0010ó\u0002\u001a\u0004\u0018\u00010\u001eH\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001d\u0010#\u001a\u0004\u0018\u00010$8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b*\u0010+R\u001d\u0010-\u001a\u0004\u0018\u00010.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\"\u001a\u0004\b/\u00100R\u001d\u00102\u001a\u0004\u0018\u0001038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\"\u001a\u0004\b4\u00105R\u001d\u00107\u001a\u0004\u0018\u0001088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\"\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010\"\u001a\u0004\b>\u0010?R\u001d\u0010A\u001a\u0004\u0018\u00010B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010\"\u001a\u0004\bC\u0010DR\u001d\u0010F\u001a\u0004\u0018\u00010G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\"\u001a\u0004\bH\u0010IR\u0016\u0010K\u001a\u0004\u0018\u00010L8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u001d\u0010O\u001a\u0004\u0018\u00010P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\"\u001a\u0004\bQ\u0010RR\u001d\u0010T\u001a\u0004\u0018\u00010U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\"\u001a\u0004\bV\u0010WR\u001d\u0010Y\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\"\u001a\u0004\b[\u0010\\R\u001d\u0010^\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\"\u001a\u0004\b`\u0010aR\u001d\u0010c\u001a\u0004\u0018\u00010d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010\"\u001a\u0004\be\u0010fR\u001d\u0010h\u001a\u0004\u0018\u00010i8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\"\u001a\u0004\bj\u0010kR\u001d\u0010m\u001a\u0004\u0018\u00010n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\"\u001a\u0004\bo\u0010pR\u0014\u0010r\u001a\u00020s8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR\u001d\u0010v\u001a\u0004\u0018\u00010w8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bz\u0010\"\u001a\u0004\bx\u0010yR\u001d\u0010{\u001a\u0004\u0018\u00010|8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u007f\u0010\"\u001a\u0004\b}\u0010~R\"\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0084\u0001\u0010\"\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\"\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0089\u0001\u0010\"\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R!\u0010\u008a\u0001\u001a\u00030\u008b\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R \u0010\u0090\u0001\u001a\u00030\u0091\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u0094\u0001\u0010\"\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u000f\u0010\u0095\u0001\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u009c\u0001\u0010\"\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R)\u0010\u009d\u0001\u001a\f\u0012\u0005\u0012\u00030\u009f\u0001\u0018\u00010\u009e\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b¢\u0001\u0010\"\u001a\u0006\b \u0001\u0010¡\u0001R \u0010£\u0001\u001a\u00030¤\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b§\u0001\u0010\"\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0012\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u00ad\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010®\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010¯\u0001\u001a\f\u0012\u0005\u0012\u00030\u009f\u0001\u0018\u00010°\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010±\u0001\u001a\u0015\u0012\u000e\u0012\f\u0012\u0005\u0012\u00030³\u0001\u0018\u00010²\u0001\u0018\u00010°\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¶\u0001\u001a\u0005\u0018\u00010·\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¸\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010¹\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010º\u0001\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010»\u0001\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010¿\u0001\u001a\u00020\u00162\u0007\u0010¾\u0001\u001a\u00020\u0016@BX\u0082\u000e¢\u0006\n\n\u0000\"\u0006\bÀ\u0001\u0010Á\u0001R\u001f\u0010Â\u0001\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÄ\u0001\u0010\"\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u000f\u0010Å\u0001\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010Æ\u0001\u001a\n\u0012\u0005\u0012\u00030È\u00010Ç\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010É\u0001\u001a\u0005\u0018\u00010Ê\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÍ\u0001\u0010\"\u001a\u0006\bË\u0001\u0010Ì\u0001R \u0010Î\u0001\u001a\u00030Ï\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\bÒ\u0001\u0010\"\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u001e\u0010ß\u0001\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\bá\u0001\u0010\"\u001a\u0005\bà\u0001\u0010 R\u0012\u0010å\u0001\u001a\u0005\u0018\u00010©\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010ê\u0001\u001a\u0005\u0018\u00010ë\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\bì\u0001\u0010í\u0001¨\u0006ô\u0002"}, d2 = {"Lcom/larus/bmhome/chat/component/title/ChatTitleComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/chat/api/IChatTitleAbility;", "Lcom/larus/component/ability/IChatTitleOutAbility;", "<init>", "()V", "contentViewId", "", "getContentViewId", "()I", "setContentViewId", "(I)V", "titleBar", "Lcom/larus/platform/api/IChatTitle;", "uiBlockChangeListener", "com/larus/bmhome/chat/component/title/ChatTitleComponent$uiBlockChangeListener$1", "Lcom/larus/bmhome/chat/component/title/ChatTitleComponent$uiBlockChangeListener$1;", "collectModeTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "collectionTitleRefreshRetryCount", "hasLoggedCollectionTitleReady", "", "hasLoggedCollectionTitleFailure", "caseModeTitle", "Landroid/view/View;", "shareModeTitle", "serviceBotTitle", "needFinishWhenStop", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "parentFragment", "Landroidx/fragment/app/Fragment;", "getParentFragment", "()Landroidx/fragment/app/Fragment;", "parentFragment$delegate", "chatPageStateAbility", "Lcom/larus/bmhome/chat/component/halfscreen/IChatPageStateAbility;", "getChatPageStateAbility", "()Lcom/larus/bmhome/chat/component/halfscreen/IChatPageStateAbility;", "chatPageStateAbility$delegate", "floatChatCoreAbility", "Lcom/larus/bmhome/ability/IFloatChatCoreAbility;", "getFloatChatCoreAbility", "()Lcom/larus/bmhome/ability/IFloatChatCoreAbility;", "floatChatCoreAbility$delegate", "aiFloatChatFoldCoreAbility", "Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "getAiFloatChatFoldCoreAbility", "()Lcom/larus/bmhome/ability/IAIFloatChatFoldCoreAbility;", "aiFloatChatFoldCoreAbility$delegate", "chatHostConfigAbility", "Lcom/larus/bmhome/chat/component/host/IChatHostConfigAbility;", "getChatHostConfigAbility", "()Lcom/larus/bmhome/chat/component/host/IChatHostConfigAbility;", "chatHostConfigAbility$delegate", "fragmentAbility", "Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "getFragmentAbility", "()Lcom/larus/bmhome/chat/component/IChatFragmentAbility;", "fragmentAbility$delegate", "listAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listAbility$delegate", "ttsOutAbility", "Lcom/larus/tts/IChatTtsAbility;", "getTtsOutAbility", "()Lcom/larus/tts/IChatTtsAbility;", "ttsOutAbility$delegate", "collectionAbility", "Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "getCollectionAbility", "()Lcom/larus/bmhome/chat/component/collection/IChatCollectMessageAbility;", "caseAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "getCaseAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatCaseMessageAbility;", "caseAbility$delegate", "serviceBotAbility", "Lcom/larus/bmhome/chat/component/servicebot/IServiceBotAbility;", "getServiceBotAbility", "()Lcom/larus/bmhome/chat/component/servicebot/IServiceBotAbility;", "serviceBotAbility$delegate", "shareAbility", "Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "getShareAbility", "()Lcom/larus/bmhome/chat/component/share/IChatMessageShareAbility;", "shareAbility$delegate", "bottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "bottomAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "skillAbility", "Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "getSkillAbility", "()Lcom/larus/bmhome/chat/component/skill/ISkillAbility;", "skillAbility$delegate", "chatInputUICoreAbility", "Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "getChatInputUICoreAbility", "()Lcom/larus/bmhome/ability/IChatInputUICoreAbility;", "chatInputUICoreAbility$delegate", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "chatImmerseAbility", "Lcom/larus/bmhome/chat/component/immerse/IImmerseComponentAbility;", "getChatImmerseAbility", "()Lcom/larus/bmhome/chat/component/immerse/IImmerseComponentAbility;", "chatImmerseAbility$delegate", "chatClickTalkAbility", "Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "getChatClickTalkAbility", "()Lcom/obric/assistant/ability/audio/IChatClickTalkAbility;", "chatClickTalkAbility$delegate", "binding", "Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "getBinding", "()Lcom/larus/bmhome/databinding/LarusPageChatBinding;", "binding$delegate", "titleViewModel", "Lcom/larus/bmhome/chat/component/title/ChatTitleComponentViewModel;", "getTitleViewModel", "()Lcom/larus/bmhome/chat/component/title/ChatTitleComponentViewModel;", "titleViewModel$delegate", "Lcom/larus/ui/arch/vm/internal/ComponentVMLazy;", "titleQuotaModel", "Lcom/larus/bmhome/chat/model/TitleQuotaModel;", "getTitleQuotaModel", "()Lcom/larus/bmhome/chat/model/TitleQuotaModel;", "titleQuotaModel$delegate", "isMainBotDoubleTabCreateSub", "navSettings", "Lcom/larus/platform/model/ChatNavNewStyleSettings;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "getChatParam", "()Lcom/larus/bmhome/chat/ChatParam;", "chatParam$delegate", "connectStateLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/larus/im/bean/IMConnectState;", "getConnectStateLiveData", "()Landroidx/lifecycle/LiveData;", "connectStateLiveData$delegate", "delayHandler", "Landroid/os/Handler;", "getDelayHandler", "()Landroid/os/Handler;", "delayHandler$delegate", "connectStatusJob", "Lkotlinx/coroutines/Job;", "enterpriseSubtitleRestoreRunnable", "Ljava/lang/Runnable;", "pendingEnterpriseSubtitle", "isEnterpriseSubtitleDisclaimerShowing", "hasShownEnterpriseColdStartDisclaimer", "connectStateObserver", "Landroidx/lifecycle/Observer;", "launchAsyncObserver", "Lcom/larus/bmhome/auth/LaunchResult;", "Lcom/larus/bmhome/auth/IMLaunchInfo;", "outsidePointNumSDKListener", "Lcom/larus/im/observer/OnUnReadBadgeCountObserver;", "outsidePointNumListener", "Lcom/larus/bmhome/chat/reddot/ConversationRedDotListenerWrapper;", "firstConnecting", "pageVisible", "botFollowEnterMethodString", "currentTabName", "onAddBotChangedListener", "Lcom/larus/bmhome/chat/event/OnAddBotChangedListener;", "value", "isLocalCoCoSub", "setLocalCoCoSub", "(Z)V", "isSideBar", "()Z", "isSideBar$delegate", "markReadWhenCreateSub", "multiTaskEntranceConfigListener", "Lkotlin/Function0;", "", "disclaimerConfig", "Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "getDisclaimerConfig", "()Lcom/larus/platform/model/chat/DoubaoDisclaimerConfig;", "disclaimerConfig$delegate", "continuousConfig", "Lcom/larus/platform/model/audio/ContinueTalkV2Config;", "getContinuousConfig", "()Lcom/larus/platform/model/audio/ContinueTalkV2Config;", "continuousConfig$delegate", "onAttach", WidgetCostModule.TYPE_ON_CREATE, "createTitleBar", "setTitleCustom", "it", "Lcom/larus/bmhome/view/ChatTitleAlignLeftStyle;", "onViewCreated", "view", "observeUIBlock", "setBackIcon", "forceBack", "onStop", "tvNoLoginUseDirectlyStr", "getTvNoLoginUseDirectlyStr", "tvNoLoginUseDirectlyStr$delegate", "initLoginGuideBannerInChat", "onParentViewCreated", "observeContinuousSpeech", "stateFlowJob", "collectAudioDowngrade", "updateTtsStatus", "forbidBack", "forbidRedDot", "titleBarConfig", "Lcom/larus/bmhome/chat/IChatTitleBarConfig;", "getTitleBarConfig", "()Lcom/larus/bmhome/chat/IChatTitleBarConfig;", "setUpDora", "onResume", "onPause", "onFragmentViewDestroyed", LiveCommonConstants.REASON_ON_DEDTROY, "getChatTitle", "getTvLoginGuideBanner", "Landroid/widget/TextView;", "getTitleContainer", "Landroid/view/ViewGroup;", "addOnConversationIdOrTypeListener", "applyTitleBarConfig", "addOnConversationTitleOrAvatarListener", "addOnConversationBadgeCountListener", "addOnBotListener", "enableRealtimeCall", "state", "templateText", "getEditPosFromBotModel", "Lcom/larus/platform/model/EditPos;", "new", "Lcom/larus/im/bean/bot/BotModel;", "(Lcom/larus/im/bean/bot/BotModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAsrAndTts", "newBot", "initTitleByBot", "bot", "setSubTitleAndMainContainerClickAction", "updateChatSubtitle", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "shouldShowEnterpriseColdStartDisclaimer", "showEnterpriseSubtitleDisclaimer", "clearEnterpriseSubtitleDisclaimer", "setCreatorName", "creatorName", "isAllow", "type", "subTitleClickListener", "Landroid/view/View$OnClickListener;", "updateTitleForGpt4", "hint", "hasBenefitsWhenEnter", "listener", "shouldShowGetPro", "enableTitleGetProFeature", "updateTitleForCiciPro", "setAudioBtnEnabled", "enabled", "checkTtsStatus", "()Ljava/lang/Boolean;", "updateRealtimeCallBtnInTitle", "editPos", "getStartCallBean", "Lcom/larus/voicecall/api/bean/StartCallPayLoadBean;", "isRedDotVisible", "(Ljava/lang/Boolean;)Lcom/larus/voicecall/api/bean/StartCallPayLoadBean;", "updateChatSettings", "currentBot", "newSpeakerVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "modelItem", "Lcom/larus/im/bean/bot/ModelItem;", "nickName", "getBotFollowEnterMethod", "updateAsrLanguage", "voice", "cvsType", "(Lcom/larus/im/bean/bot/SpeakerVoice;Ljava/lang/Integer;)V", "setAddBotListener", "handleChatSettingResult", "bundle", "Landroid/os/Bundle;", "requestCode", "resultCode", "handleDoraTTSUI", "grey", "refreshTitleStatus", "attachCollectionTitleIfNeeded", "titleContainer", "getPreviewCollectionId", "refreshCollectionTitleIfNeeded", "retryRefreshCollectionTitleIfNeeded", "refreshTitleState", "handleChatBotUpdate", "botConversationType", "(Ljava/lang/Integer;)V", "attachTitleBar", KtvSubElement.CONTAINER, "setupTitle", "(Lcom/larus/im/bean/conversation/Conversation;)Lkotlin/Unit;", "tryCloseContinuousTalk", "tryCloseClickTalk", "initConnectStateObserver", "setIsMainBot", "initTitleAndAvatar", "createReviewFailedTitleTagConfig", "Lcom/larus/platform/api/ChatTitleTagConfig;", "tryShowMemoryGuideTip", "pass26SpringTipCheck", "handleTitleRedDotCount", "owner", "title", "needHideRedDot", "checkMarkConversationRead", "tryStartSettings", "()Lkotlin/Unit;", "startSettings", "isShowTitleRedDot", "isLastConversationPage", "isTopRealtimeCallActivity", "ifShowCreatorName", "setTitleClickJumpToBotSetting", "setCreatorInfoForOfficialBot", "officialWebsiteName", "officialWebsiteUrl", "setTitleClickJumpToProfile", "creatorId", "botId", "getBotType", "()Ljava/lang/Integer;", "getBotIsOwner", "handleRedDotStyle", "getParentFragmentTitle", "setUpChatWithTab", "markConversationRead", "ignoreImmerseValid", "checkAudioDowngradeWhenResume", "isTtsBanned", "isTtsChecked", "getConversion", "getConversationId", "getBot", "getBotId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTitleComponent extends BaseContentWidget implements ry8.b, u29.a {
    public static final /* synthetic */ int P1 = 0;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy G1;
    public final Lazy H;
    public k0 H0;
    public final Lazy H1;
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f301679J;
    public final Lazy K;
    public final Lazy L;
    public l0 L0;
    public final Lazy L1;
    public final Lazy M;
    public Job M1;
    public final Lazy N;
    public final Lazy O;
    public final Lazy P;
    public com.larus.bmhome.chat.reddot.a P0;
    public final Lazy Q;
    public final com.larus.ui.arch.vm.internal.l R;
    public final Lazy S;
    public final hq9.g0 T;
    public final Lazy U;
    public final Lazy V;
    public boolean V0;
    public final Lazy W;
    public Job X;
    public x0 Y;
    public String Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f301680b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public String f301681g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public String f301682h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f301683k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public te8.b f301684k1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f301685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.larus.platform.api.g0 f301686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final j f301687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public NovaTitleBarEx f301688p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f301689p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public boolean f301690p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f301691q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f301692r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f301693s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f301694t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public NovaTitleBarEx f301695u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public NovaTitleBarEx f301696v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final Lazy f301697v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f301698w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f301699x;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public boolean f301700x1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f301701y;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final com.larus.bmhome.chat.component.title.d f301702y1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f301703z;

    /* JADX INFO: loaded from: classes25.dex */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f301704a = null;

        static {
            int[] r100 = new int[IMConnectState.values().length];
            r100[IMConnectState.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[IMConnectState.DISCONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[IMConnectState.CONNECTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f301704a = r100;
        }
    }

    public static final class b implements Function0<com.larus.bmhome.chat.component.halfscreen.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f301705a;

        public b(AttachReceiver r100) {
            this.f301705a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.halfscreen.c, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.chat.component.halfscreen.c invoke() {
            AttachReceiver r100 = this.f301705a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.halfscreen.c.class));
        }
    }

    public static final class c implements Function0<va8.f0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f301706a;

        public c(AttachReceiver r100) {
            this.f301706a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.f0] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.f0 invoke() {
            AttachReceiver r100 = this.f301706a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.f0.class));
        }
    }

    public static final class d implements Function0<va8.k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f301707a;

        public d(AttachReceiver r100) {
            this.f301707a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.k] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.k invoke() {
            AttachReceiver r100 = this.f301707a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.k.class));
        }
    }

    public static final class e implements Function0<sd8.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f301708a;

        public e(AttachReceiver r100) {
            this.f301708a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [sd8.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final sd8.a invoke() {
            AttachReceiver r100 = this.f301708a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(sd8.a.class));
        }
    }

    public static final class f implements Function0<by9.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f301709a;

        public f(AttachReceiver r100) {
            this.f301709a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [by9.a, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final by9.a invoke() {
            AttachReceiver r100 = this.f301709a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(by9.a.class));
        }
    }

    public static final class g implements Function0<LifecycleOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f301710a;

        public g(ComponentFeature r100) {
            this.f301710a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final LifecycleOwner invoke() {
            return this.f301710a;
        }
    }

    public static final class h implements Function0<ViewModelStoreOwner> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComponentFeature f301711a;

        public h(ComponentFeature r100) {
            this.f301711a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStoreOwner invoke() {
            return this.f301711a;
        }
    }

    public static final class i implements Function0<ViewModelProvider.Factory> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f301712a = null;

        static {
            f301712a = new i();
        }

        public i() {
        }

        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            return new ViewModelProvider.NewInstanceFactory();
        }
    }

    public static final class j implements ss8.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatTitleComponent f301713a;

        @Override // ss8.g.b
        public final void b() {
        }

        public j(ChatTitleComponent r100) {
            this.f301713a = r100;
        }

        @Override // ss8.g.b
        public final void a(ChatUIBlockConfig r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "config");
            if (r100 != ChatUIBlockConfig.HIDE_TITLE_BAR_BUTTONS) goto L8;
            FLogger r102 = FLogger.f375446a;
            ChatTitleComponent r103 = this.f301713a;
            int r104 = ChatTitleComponent.P1;
            r102.i(r103.d4(), "UIBlock HIDE_TITLE_BAR_BUTTONS changed: blocked=" + r101);
            com.larus.platform.api.g0 r105 = this.f301713a.f301686n;
            if (r105 == null) goto L8;
            r105.setRealTimeCallVisible(!r101);
        L8:
            if (r100 != ChatUIBlockConfig.DISABLE_MESSAGE_INTERACTION) goto L16;
            com.larus.platform.api.g0 r106 = this.f301713a.f301686n;
            if ((r106 instanceof ChatTitleAlignLeftStyle) == false) goto L12;
            ChatTitleAlignLeftStyle r107 = (ChatTitleAlignLeftStyle) r106;
        L13:
            if (r107 == null) goto L17;
            r107.setCreateNewCvsForceHidden(r101);
            return;
        L17:
            return;
        L12:
            r107 = null;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.title.ChatTitleComponent$onCreate$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes25.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.title.ChatTitleComponent$onCreate$1", f = "ChatTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            AudioServiceDelegate.f288288a.i0().i();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
        boolean r100 = false;
        this.f301680b1 = false;
        if (z2.f365865a.enableChatWithTab() == false) goto L7;
        RepoDispatcher.f307729a.getClass();
        com.larus.bmhome.chat.model.repo.n0 r101 = RepoDispatcher.f307732d.f307632d;
        if (Intrinsics.areEqual(Q3(), r101.f307841e) == false) goto L7;
        r101.f307841e = null;
    L7:
        Bundle r102 = f1().f468085a;
        if (r102 != null) goto L10;
    L12:
        if (r100 == true) goto L14;
        return;
    L14:
        if (this.f301700x1 == true) goto L24;
        RepoDispatcher.f307729a.getClass();
        ConversationRepo r103 = RepoDispatcher.f307734f;
        com.larus.bmhome.chat.component.cvs.y r104 = u0();
        if (r104 == null) goto L20;
        wc9.e r105 = r104.h();
        if (r105 == null) goto L20;
        String r106 = r105.f559198a;
    L21:
        r103.h(r106, null);
        this.f301700x1 = true;
        return;
    L20:
        r106 = null;
        goto L21
    L24:
        return;
    L10:
        if (r102.getBoolean("is_create_sub_conversation") != true) goto L12;
        r100 = true;
        goto L12
    }

    public static boolean z3() {
        if (AppHost.f326268a.isOversea() == false) goto L9;
        z2 r100 = z2.f365865a;
        if (r100.enableSubscription() == false) goto L9;
        if (r100.enableSubscribeTitleEntrance() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        com.larus.bmhome.chat.reddot.a r100 = this.P0;
        if (r100 == null) goto L5;
        com.larus.bmhome.chat.reddot.f r101 = com.larus.bmhome.chat.reddot.f.f308497a;
        com.larus.bmhome.chat.reddot.f.e(r100);
    L5:
        Intrinsics.checkNotNullParameter(this, "<this>");
        t1a.b r102 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r102 == null) goto L10;
        ss8.g r103 = (ss8.g) r102.getAbility(ss8.g.class);
        if (r103 == null) goto L10;
        r103.aZ(this.f301687o);
    L10:
        com.larus.platform.api.g0 r104 = this.f301686n;
        if (r104 == null) goto L13;
        r104.Qa();
    L13:
        Job r105 = this.M1;
        if (r105 == null) goto L16;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L16:
        TtsGuideDelegate.f289898b.c();
    }

    public final LarusPageChatBinding B3() {
        return (LarusPageChatBinding) this.Q.getValue();
    }

    public final void B4() {
        boolean r100 = false;
        String r101 = null;
        if (this.f301690p1 == false) goto L24;
        com.larus.platform.api.g0 r102 = this.f301686n;
        if (r102 == null) goto L9;
        View r103 = r102.getTitle();
        if (r103 == null) goto L9;
        r103.setOnClickListener(null);
        r103.setClickable(false);
    L9:
        wc9.e r104 = V3();
        if (AppHost.f326268a.isOversea() == false) goto L12;
    L22:
        f5(r104);
        return;
    L12:
        if (com.larus.platform.exp.o.a() == false) goto L179;
        LocalSubConvHelper r105 = LocalSubConvHelper.f314106a;
        if (r104 == null) goto L16;
        String r106 = r104.f559198a;
    L17:
        com.larus.bmhome.auth.h0 r107 = AuthModelDelegate.f297134b.v();
        if (r107 == null) goto L21;
        r101 = r107.b();
    L21:
        if (LocalSubConvHelper.e(r106, r101) == true) goto L22;
        return;
    L16:
        r106 = null;
        goto L17
    L179:
        return;
    L24:
        FLogger r108 = FLogger.f375446a;
        String r109 = d4();
        StringBuilder r110 = new StringBuilder("setSubTitleAndMainContainerClickAction, officialWebsiteName: ");
        hq9.g0 r111 = this.T;
        if (r111 == null) goto L27;
        String r112 = r111.f486608a;
    L28:
        r110.append(r112);
        r110.append(", officialWebsiteUrl: ");
        hq9.g0 r113 = this.T;
        if (r113 == null) goto L31;
        String r114 = r113.f486609b;
    L32:
        r110.append(r114);
        r110.append(", overseaOfficialWebsiteName: ");
        hq9.g0 r115 = this.T;
        if (r115 == null) goto L35;
        String r116 = r115.f486610c;
    L36:
        r110.append(r116);
        r110.append(", overOfficialWebsiteUrl: ");
        hq9.g0 r117 = this.T;
        if (r117 == null) goto L39;
        String r118 = r117.f486611d;
    L40:
        r110.append(r118);
        r110.append("officialWebsiteDisplayBotTypes: ");
        hq9.g0 r119 = this.T;
        if (r119 == null) goto L45;
        ArrayList<Integer> r120 = r119.f486612e;
        if (r120 == null) goto L45;
        String r121 = CollectionsKt.joinToString$default(r120, ", ", null, null, 0, null, null, 62, null);
    L46:
        r110.append(r121);
        r108.d(r109, r110.toString());
        com.larus.bmhome.chat.component.cvs.y r122 = u0();
        if (r122 == null) goto L49;
        BotModel r123 = r122.j0();
    L50:
        if (r123 == null) goto L54;
        BotCreatorInfo r124 = r123.getBotCreatorInfo();
        if (r124 == null) goto L54;
        final String r125 = r124.getId();
    L55:
        if (r123 == null) goto L57;
        Integer r126 = r123.getBotStatus();
    L59:
        if (r126 != null) goto L62;
    L63:
        if (r126 != null) goto L66;
    L68:
        boolean r127 = true;
    L71:
        if (r127 == false) goto L156;
        if (r123 == null) goto L76;
        BotCreatorInfo r128 = r123.getBotCreatorInfo();
        if (r128 == null) goto L76;
        String r129 = r128.getName();
    L77:
        if (r123 == null) goto L79;
        String r130 = r123.getBotFeatureLabel();
    L80:
        if (r123 == null) goto L82;
        Integer r131 = r123.getBotType();
    L83:
        if (r123 == null) goto L85;
        final String r132 = r123.getBotId();
    L86:
        if (r123 == null) goto L88;
        Integer r133 = r123.getBotStatus();
    L90:
        if ((this.f301686n instanceof ChatTitleAlignLeftStyle) == true) goto L92;
        if (r133 != null) goto L114;
    L115:
        if (r133 != null) goto L118;
    L125:
        if (r133 != null) goto L128;
    L130:
        com.larus.platform.api.g0 r134 = this.f301686n;
        if (r134 == null) goto L134;
        getContext();
        com.larus.platform.api.g0.a.a(r134, com.larus.bmhome.utils.i.b(r130, r129), 0, 14);
    L134:
        if (com.larus.utils.o0.d(r129) == true) goto L136;
    L143:
        boolean r135 = false;
    L145:
        if (z2.f365865a.I2() == false) goto L160;
        p2a.i r136 = p2a.i.f527471b;
        if (r123 == null) goto L151;
        BotCreatorInfo r137 = r123.getBotCreatorInfo();
        if (r137 == null) goto L151;
        r101 = r137.getId();
    L151:
        p2a.i.f527471b.R(r101, "");
    L160:
        g4 r138 = e4();
        if (r138 != null) goto L163;
    L165:
        if (r100 == false) goto L169;
        com.larus.platform.api.g0 r139 = this.f301686n;
        if (r139 == null) goto L174;
        r139.setOnMainClickListener(new g0());
    L174:
        if (Intrinsics.areEqual(r125, AccountService.f365697a.getUserId()) == false) goto L181;
        com.larus.platform.api.g0 r140 = this.f301686n;
        if (r140 == null) goto L182;
        r140.setHasMore(true);
        return;
    L182:
        return;
    L181:
        return;
    L169:
        if (r135 == true) goto L174;
        com.larus.platform.api.g0 r141 = this.f301686n;
        if (r141 == null) goto L174;
        r141.setOnMainClickListener(new i0(this));
        goto L174
    L163:
        if (r138.h() == true) goto L165;
        r100 = true;
        goto L165
    L136:
        if (com.larus.utils.o0.d(r125) == false) goto L143;
        if (FeatureKitDelegate.f295792b.z0().b() == false) goto L143;
        com.larus.platform.api.g0 r142 = this.f301686n;
        if (r142 == null) goto L142;
        r142.setOnMainClickListener(new y0(this, r125, r132));
    L142:
        r135 = true;
        goto L145
    L128:
        if (r133.intValue() != (-30)) goto L130;
    L152:
        com.larus.platform.api.g0 r143 = this.f301686n;
        if (r143 == null) goto L155;
        r143.setOnMainClickListener(new z0(this));
    L155:
        r135 = true;
        goto L160
    L118:
        if (r133.intValue() != (-50)) goto L125;
        BotCreatorInfo r144 = r123.getBotCreatorInfo();
        if (r144 == null) goto L122;
        String r145 = r144.getId();
    L124:
        if (Intrinsics.areEqual(r145, AccountService.f365697a.getUserId()) == true) goto L152;
    L122:
        r145 = null;
        goto L124
    L114:
        if (r133.intValue() == (-20)) goto L152;
    L92:
        if (G4() == false) goto L96;
        i5();
        return;
    L96:
        if (z3() == true) goto L103;
        if (((TitleQuotaModel) this.S.getValue()).showGPT4QuotaOnTitle(r131, r132) == false) goto L103;
        com.larus.platform.api.g0 r146 = this.f301686n;
        if (r146 == null) goto L155;
        r146.setOnMainClickListener(new z0(this));
    L103:
        if (com.larus.platform.service.n0.f365775a.b() == true) goto L107;
        com.larus.platform.api.g0 r147 = this.f301686n;
        if (r147 == null) goto L107;
        getContext();
        com.larus.platform.api.g0.a.a(r147, com.larus.bmhome.utils.i.b(r130, r129), 0, 14);
    L107:
        com.larus.platform.api.g0 r148 = this.f301686n;
        if (r148 == null) goto L110;
        r148.setOnMainClickListener(new z0(this));
    L110:
        f5(V3());
        goto L155
    L88:
        r133 = null;
        goto L90
    L85:
        r132 = null;
        goto L86
    L82:
        r131 = null;
        goto L83
    L79:
        r130 = null;
    L76:
        r129 = null;
        goto L77
    L156:
        com.larus.platform.api.g0 r149 = this.f301686n;
        if (r149 == null) goto L159;
        com.larus.platform.api.g0.a.a(r149, "", 0, 14);
    L159:
        r135 = false;
        goto L160
    L66:
        if (r126.intValue() != (-40)) goto L68;
    L69:
        r127 = false;
        goto L71
    L62:
        if (r126.intValue() == (-10)) goto L69;
    L57:
        r126 = null;
    L54:
        r125 = null;
        goto L55
    L49:
        r123 = null;
    L45:
        r121 = null;
        goto L46
    L39:
        r118 = null;
        goto L40
    L35:
        r116 = null;
        goto L36
    L31:
        r114 = null;
        goto L32
    L27:
        r112 = null;
        goto L28
    }

    public final sd8.a E3() {
        return (sd8.a) this.C.getValue();
    }

    @Override // ry8.b
    public final void E6() {
        com.larus.platform.api.g0 r100 = this.f301686n;
        if (r100 == null) goto L6;
        r100.E6();
        return;
    }

    public final com.larus.bmhome.chat.component.immerse.a G3() {
        return (com.larus.bmhome.chat.component.immerse.a) this.O.getValue();
    }

    public final void T4() {
        maa.e r100 = (maa.e) this.P.getValue();
        if (r100 == null) goto L6;
        maa.e.a.a(r100, null, null, false, 7);
        return;
    }

    public final ICoreInputAbility W3() {
        return (ICoreInputAbility) this.K.getValue();
    }

    public final u7 X3() {
        return (u7) this.E.getValue();
    }

    public final Fragment Z3() {
        return (Fragment) this.f301701y.getValue();
    }

    public final com.larus.bmhome.chat.component.servicebot.a c4() {
        return (com.larus.bmhome.chat.component.servicebot.a) this.H.getValue();
    }

    public final String d4() {
        return (String) this.f301699x.getValue();
    }

    public final g4 e4() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r100 instanceof ChatFragment) == false) goto L5;
        ChatFragment r101 = (ChatFragment) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f296868i;
    L5:
        r101 = null;
        goto L6
    }

    public final de8.c f1() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isAdded() == false) goto L13;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).isDetached() == true) goto L13;
        de8.c r100 = (de8.c) s1a.d.a(this).a(de8.c.class);     // Catch: Exception -> L9
    L10:
        if (r100 != null) goto L17;
        com.larus.platform.service.g.f365738a.ensureNotReachHere("ChatTitleComponent get data == null");
        de8.c r101 = de8.c.f468084s;
        return de8.c.a.a(null);
    L17:
        return r100;
    L9:
        r100 = null;
    L13:
        de8.c r102 = de8.c.f468084s;
        return de8.c.a.a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ChatTitleComponentViewModel h4() {
        return (ChatTitleComponentViewModel) this.R.getValue();
    }

    public final by9.a i4() {
        return (by9.a) this.F.getValue();
    }

    public final void j4() {
        if (AppHost.f326268a.isPlugin() == false) goto L5;
        FLogger.f375446a.i(d4(), "now is in SaaS App");
        return;
    L5:
        LarusPageChatBinding r100 = B3();
        if (r100 == null) goto L8;
        TextView r101 = r100.f311107w;
    L9:
        com.larus.utils.e1.d(r101, new b0(this));
        LarusPageChatBinding r102 = B3();
        if (r102 == null) goto L36;
        TextView r103 = r102.f311107w;
        if (r103 == null) goto L37;
        LarusPageChatBinding r104 = B3();
        if (r104 == null) goto L19;
        TextView r105 = r104.f311107w;
        if (r105 == null) goto L19;
        r105.setText((String) this.L1.getValue());
    L19:
        if (i3.f365750a.f() == true) goto L21;
    L33:
        com.larus.utils.e1.o(r103);
        return;
    L21:
        if (com.larus.bmhome.utils.i.g(Q3()) == false) goto L33;
        if (z2.f365865a.chatListLoginGuideBannerEnabled() == false) goto L33;
        if (r103.getVisibility() != 0) goto L27;
        boolean r106 = true;
    L28:
        if (r106 == true) goto L38;
        JSONObject r107 = new JSONObject();
        Intrinsics.checkNotNullParameter(r107, "params");
        if (com.larus.utils.o0.d("chat") == false) goto L32;
        r107.put("current_page", "chat");
    L32:
        TrackParams r108 = new TrackParams().merge(r107);
        by7.a r109 = new by7.a("login_guide_banner_show");
        r109.f21463a.merge(r108);
        r109.b();
        com.larus.utils.e1.x(r103);
        return;
    L38:
        return;
    L27:
        r106 = false;
        goto L28
    L37:
        return;
    L36:
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final boolean k4() {
        return ((Boolean) this.f301697v1.getValue()).booleanValue();
    }

    public final void m3() {
        com.larus.bmhome.chat.component.servicebot.a r100 = c4();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.E8() != true) goto L7;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        com.larus.platform.api.g0 r102 = TitleBarInflateService.f365713a.a(getContext(), f1().k());
        if (r102 != null) goto L28;
        final Context r103 = getContext();
    L25:
        th = move-exception;
        EnsureManager.ensureNotReachHere("createTitle# e=" + th.getMessage());
        FLogger.f375446a.e(d4(), "createTitle# e=" + th.getMessage());
        ChatTitleAlignLeftStyle r104 = new ChatTitleAlignLeftStyle(getContext());
    L27:
        r102 = r104;
        goto L28
    L14:
        if (z2.f365865a.enablePreloadChatPageView().b() == false) goto L23;
        o37.c.f521918e.getClass();     // Catch: Throwable -> L25
        if (o37.c.f("chat_title_nita") == false) goto L23;
        if ((r103 instanceof Activity) == false) goto L23;
        final gd8.e r105 = (gd8.e) o37.c.e("chat_title_nita");     // Catch: Throwable -> L25
        int r106 = gd8.c.f480948b;     // Catch: Throwable -> L25
        View r107 = (View) gd8.c.a.a("ChatTitle", new u(r105, r103));     // Catch: Throwable -> L25
        if ((r107 instanceof ChatTitleAlignLeftStyle) == false) goto L22;
        r104 = (ChatTitleAlignLeftStyle) r107;     // Catch: Throwable -> L25
    L35:
        goto L27
    L22:
        r104 = new ChatTitleAlignLeftStyle(getContext());     // Catch: Throwable -> L25
    L23:
        r104 = new ChatTitleAlignLeftStyle(getContext());     // Catch: Throwable -> L25
    L28:
        this.f301686n = r102;
        if ((r102 instanceof ChatTitleAlignLeftStyle) == false) goto L31;
        ChatTitleAlignLeftStyle r108 = (ChatTitleAlignLeftStyle) r102;
    L32:
        if (r108 == null) goto L38;
        F4(r108);
        return;
    L38:
        return;
    L31:
        r108 = null;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        z2.f365865a.p3(this.f301702y1);
        ((Handler) this.W.getValue()).removeCallbacksAndMessages(null);
        u7 r100 = X3();
        if (r100 == null) goto L41;
        List<Message> r101 = r100.zj();
        if (r101 == null) goto L42;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L23;
        Object r103 = r102.next();
        Message r104 = (Message) r103;
        Integer r105 = com.larus.bmhome.social.userchat.model.b0.c(r104);
        if (r105 != null) goto L13;
    L14:
        Integer r106 = com.larus.bmhome.social.userchat.model.b0.c(r104);
        if (r106 != null) goto L18;
    L19:
        boolean r107 = true;
    L21:
        if (r107 == false) goto L8;
    L24:
        Message r108 = (Message) r103;
        if (r108 != null) goto L27;
        return;
    L27:
        if (r108.getRegenStatus() <= 0) goto L44;
        RepoDispatcher.f307729a.getClass();
        ConversationRepo r109 = RepoDispatcher.f307734f;
        com.larus.bmhome.chat.component.cvs.y r110 = u0();
        if (r110 == null) goto L33;
        wc9.e r111 = r110.h();
        if (r111 == null) goto L33;
        String r112 = r111.f559198a;
    L34:
        r109.h(r112, null);
        return;
    L33:
        r112 = null;
        goto L34
    L44:
        return;
    L18:
        if (r106.intValue() != 14) goto L19;
    L20:
        r107 = false;
        goto L21
    L13:
        if (r105.intValue() == 13) goto L20;
    L23:
        r103 = null;
        goto L24
    L42:
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        IAppLaunchReporter r100 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        wc9.e r101 = null;
        if (r100 == null) goto L5;
        r100.b("chat_title_show", null);
    L5:
        this.f301680b1 = true;
        z2 r102 = z2.f365865a;
        if (r102.enableChatWithTab() == false) goto L11;
        RepoDispatcher.f307729a.getClass();
        com.larus.bmhome.chat.model.repo.n0 r103 = RepoDispatcher.f307732d.f307632d;
        r103.f307841e = Q3();
        by9.a r104 = i4();
        if (r104 == null) goto L11;
        r104.Ic();
    L11:
        com.larus.platform.api.g0 r105 = this.f301686n;
        if (r105 == null) goto L14;
        r105.refresh();
    L14:
        com.larus.bmhome.chat.component.cvs.y r106 = u0();
        if (r106 == null) goto L17;
        r101 = r106.h();
    L17:
        l4(r101, true);
        if (r102.enableRealtimeCallDowngrade() == false) goto L25;
        VoiceCallServiceDelegate.f377087a.w("chat_resume");
        com.larus.platform.api.g0 r107 = this.f301686n;
        if (r107 == null) goto L24;
        r107.setRealtimeCallVisibleHookShow(AudioServiceDelegate.f288288a.getAudioConfig().B(r107.Da()));
        return;
    L24:
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        if (this.f301698w == false) goto L11;
        Intrinsics.checkNotNullParameter(this, "<this>");
        FragmentActivity r100 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getActivity();
        if ((r100 instanceof ChatActivity) == false) goto L7;
        ChatActivity r101 = (ChatActivity) r100;
    L8:
        if (r101 == null) goto L12;
        r101.finish();
        return;
    L12:
        return;
    L7:
        r101 = null;
        goto L8
    }

    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.N.getValue();
    }

    @Override // ry8.b
    public final void va() {
        com.larus.platform.api.g0 r100 = this.f301686n;
        if (r100 == null) goto L6;
        r100.va();
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, ry8.b.class);
    }

    /* JADX WARN: Type inference failed for: r0v59, types: [com.larus.bmhome.chat.component.title.d] */
    public ChatTitleComponent() {
        this.f301685m = R.id.title_container;
        this.f301687o = new j(this);
        this.f301699x = LazyKt.lazy(new com.larus.bmhome.chat.component.title.a(this));
        this.f301701y = LazyKt.lazy(new com.larus.bmhome.chat.component.title.c(this));
        this.f301703z = LazyKt.lazy(new b(this));
        this.A = LazyKt.lazy(new c(this));
        this.B = LazyKt.lazy(new d(this));
        this.C = LazyKt.lazy(new e(this));
        this.D = LazyKt.lazy(new com.larus.bmhome.chat.component.title.h(this));
        this.E = LazyKt.lazy(new com.larus.bmhome.chat.component.title.i(this));
        this.F = LazyKt.lazy(new f(this));
        this.G = LazyKt.lazy(new com.larus.bmhome.chat.component.title.j(this));
        this.H = LazyKt.lazy(new k(this));
        this.I = LazyKt.lazy(new m(this));
        this.f301679J = LazyKt.lazy(new n(this));
        this.K = LazyKt.lazy(new o(this));
        this.L = LazyKt.lazy(new p(this));
        this.M = LazyKt.lazy(new l(this));
        this.N = LazyKt.lazy(new w(this));
        this.O = LazyKt.lazy(new h0(this));
        this.P = LazyKt.lazy(new s0(this));
        this.Q = LazyKt.lazy(new d1(this));
        this.R = new com.larus.ui.arch.vm.internal.l(Reflection.getOrCreateKotlinClass(ChatTitleComponentViewModel.class), Reflection.getOrCreateKotlinClass(ChatTitleComponentState.class), new g(this), new h(this), i.f301712a);
        this.S = LazyKt.lazy(new f1(this));
        this.T = z2.f365865a.K1();
        this.U = LazyKt.lazy(new g1(this));
        this.V = LazyKt.lazy(new h1());
        this.W = LazyKt.lazy(new i1());
        this.V0 = true;
        this.f301681g1 = "chatted";
        this.f301697v1 = LazyKt.lazy(new com.larus.bmhome.chat.component.title.b(this));
        this.f301702y1 = new com.larus.bmhome.chat.component.title.d(this);
        this.G1 = LazyKt.lazy(new com.larus.bmhome.chat.component.title.e());
        this.H1 = LazyKt.lazy(new com.larus.bmhome.chat.component.title.f());
        this.L1 = LazyKt.lazy(new com.larus.bmhome.chat.component.title.g(this));
    }

    public final boolean C3() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 == null) goto L9;
        BotModel r101 = r100.j0();
        if (r101 == null) goto L9;
        BotCreatorInfo r102 = r101.getBotCreatorInfo();
        if (r102 == null) goto L9;
        String r103 = r102.getId();
    L11:
        return Intrinsics.areEqual(r103, AccountService.f365697a.getUserId());
    L9:
        r103 = null;
        goto L11
    }

    public final Integer D3() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 == null) goto L7;
        BotModel r101 = r100.j0();
        if (r101 == null) goto L7;
        return r101.getBotType();
    L7:
        return null;
    }

    public final boolean G4() {
        if (z3() == true) goto L5;
    L15:
        return false;
    L5:
        if (c2.f365725a.a() == true) goto L15;
        if (z2.f365865a.getChatNavigatorConfig().f486625b == true) goto L15;
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 == null) goto L11;
        wc9.e r101 = r100.h();
    L13:
        if (ic8.n.v(r101) == false) goto L15;
        return true;
    L11:
        r101 = null;
        goto L13
    }

    public final com.larus.bmhome.chat.component.collection.o H3() {
        return (com.larus.bmhome.chat.component.collection.o) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.collection.o.class);
    }

    @Override // ry8.b
    public final Boolean L9() {
        by9.a r100 = i4();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.L9();
    }

    @Override // ry8.b
    public final void M9() {
        by9.a r100 = i4();
        if (r100 == null) goto L6;
        r100.M9();
        return;
    }

    public final String Q3() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 == null) goto L5;
        String r101 = r100.Y1();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final void R4() {
        h4().checkBotExist(Q3(), new c1(this));
    }

    public final wc9.e V3() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    public final void V4() {
        if (ce8.c.a() == false) goto L8;
        xa8.b r100 = (xa8.b) s1a.d.a(this).getAbility(xa8.b.class);
        if (r100 == null) goto L9;
        r100.closeContinuousTalk();
        return;
    L9:
        return;
    }

    public final void W4() {
        if (B3() == null) goto L18;
        V4();
        T4();
        va8.o r100 = (va8.o) this.M.getValue();
        if (r100 == null) goto L9;
        boolean r101 = true;
        if (r100.w() != true) goto L9;
    L10:
        if (r101 == false) goto L15;
        ICoreInputAbility r102 = W3();
        if (r102 == null) goto L14;
        r102.qp(false);
    L14:
        SafeExtKt.b(F2(), new e1(this), 300);
    L16:
        Unit r103 = Unit.INSTANCE;
        return;
    L15:
        R4();
    L9:
        r101 = false;
        goto L10
    }

    public final String a4() {
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
        if (r103 != null) goto L17;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Bundle r104 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getArguments();
        if (r104 == null) goto L15;
        return r104.getString("preview_collection_id");
    L15:
        return null;
    L17:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    @Override // ry8.b
    public final ViewGroup getTitleContainer() {
        LarusPageChatBinding r100 = B3();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f311102r;
    }

    public final com.larus.platform.api.j h3() {
        BotModel r100 = j0();
        if (r100 == null) goto L5;
        Integer r101 = r100.getBotStatus();
    L6:
        if (r101 != null) goto L9;
    L10:
        if (r101 != null) goto L13;
    L14:
        return null;
    L13:
        if (r101.intValue() != (-50)) goto L14;
    L16:
        return new com.larus.platform.api.j(getContext().getString(R.string.larus_tag_review_failed), Integer.valueOf(R.color.larus_neutral_50), Integer.valueOf(R.drawable.larus_bg_gray_rectangle), Float.valueOf(i5.g()), Integer.valueOf(i5.Y()), Integer.valueOf(i5.M()), 1, 17);
    L9:
        if (r101.intValue() == (-30)) goto L16;
    L5:
        r101 = null;
        goto L6
    }

    @Override // ry8.b
    public final void hz() {
        LarusPageChatBinding r100 = B3();
        if (r100 == null) goto L187;
        IChatMessageShareAbility r101 = (IChatMessageShareAbility) this.I.getValue();
        boolean r102 = true;
        if (r101 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        NovaTitleBarEx r104 = null;
        NovaTitleBarEx r105 = null;
        ViewGroup r106 = null;
        ShowCaseTitleBar r107 = null;
        if (r103 == true) goto L13;
        com.larus.bmhome.chat.component.collection.o r108 = H3();
        if (r108 != null) goto L21;
    L23:
        boolean r109 = false;
    L25:
        if (r109 == false) goto L45;
        FrameLayout r110 = r100.f311102r;
        NovaTitleBarEx r111 = this.f301688p;
        if (r111 != null) goto L37;
        com.larus.bmhome.chat.component.collection.o r112 = H3();
        if (r112 == null) goto L33;
        r111 = r112.gU();
        if (r111 == null) goto L33;
        this.f301688p = r111;
    L34:
        if (r111 != null) goto L37;
    L71:
        IChatMessageShareAbility r113 = (IChatMessageShareAbility) this.I.getValue();
        if (r113 != null) goto L74;
    L76:
        boolean r114 = false;
    L78:
        if (r114 == false) goto L96;
        NovaTitleBarEx r115 = this.f301695u;
        if (r115 == null) goto L82;
        r115.setVisibility(0);
    L82:
        NovaTitleBarEx r116 = this.f301688p;
        if (r116 == null) goto L85;
        r116.setVisibility(8);
    L85:
        View r117 = this.f301694t;
        if (r117 == null) goto L88;
        r117.setVisibility(8);
    L88:
        NovaTitleBarEx r118 = this.f301696v;
        if (r118 == null) goto L91;
        r118.setVisibility(8);
    L91:
        com.larus.platform.api.g0 r119 = this.f301686n;
        if (r119 == null) goto L188;
        View r120 = r119.getTitleView();
        if (r120 == null) goto L189;
        r120.setVisibility(8);
        return;
    L189:
        return;
    L188:
        return;
    L96:
        com.larus.bmhome.chat.component.collection.o r121 = H3();
        if (r121 != null) goto L99;
    L101:
        boolean r122 = false;
    L102:
        if (r122 == false) goto L120;
        View r123 = this.f301694t;
        if (r123 == null) goto L106;
        r123.setVisibility(8);
    L106:
        NovaTitleBarEx r124 = this.f301695u;
        if (r124 == null) goto L109;
        r124.setVisibility(8);
    L109:
        NovaTitleBarEx r125 = this.f301688p;
        if (r125 == null) goto L112;
        r125.setVisibility(0);
    L112:
        NovaTitleBarEx r126 = this.f301696v;
        if (r126 == null) goto L115;
        r126.setVisibility(8);
    L115:
        com.larus.platform.api.g0 r127 = this.f301686n;
        if (r127 == null) goto L191;
        View r128 = r127.getTitleView();
        if (r128 == null) goto L192;
        r128.setVisibility(8);
        return;
    L192:
        return;
    L191:
        return;
    L120:
        com.larus.bmhome.chat.component.showcase.x r129 = (com.larus.bmhome.chat.component.showcase.x) this.G.getValue();
        if (r129 != null) goto L123;
    L125:
        boolean r130 = false;
    L126:
        if (r130 == false) goto L144;
        View r131 = this.f301694t;
        if (r131 == null) goto L130;
        r131.setVisibility(0);
    L130:
        NovaTitleBarEx r132 = this.f301695u;
        if (r132 == null) goto L133;
        r132.setVisibility(8);
    L133:
        NovaTitleBarEx r133 = this.f301688p;
        if (r133 == null) goto L136;
        r133.setVisibility(8);
    L136:
        NovaTitleBarEx r134 = this.f301696v;
        if (r134 == null) goto L139;
        r134.setVisibility(8);
    L139:
        com.larus.platform.api.g0 r135 = this.f301686n;
        if (r135 == null) goto L194;
        View r136 = r135.getTitleView();
        if (r136 == null) goto L195;
        r136.setVisibility(8);
        return;
    L195:
        return;
    L194:
        return;
    L144:
        com.larus.bmhome.chat.component.servicebot.a r137 = c4();
        if (r137 != null) goto L147;
    L149:
        r102 = false;
    L150:
        if (r102 == false) goto L169;
        View r138 = this.f301694t;
        if (r138 == null) goto L154;
        r138.setVisibility(8);
    L154:
        NovaTitleBarEx r139 = this.f301695u;
        if (r139 == null) goto L157;
        r139.setVisibility(8);
    L157:
        NovaTitleBarEx r140 = this.f301688p;
        if (r140 == null) goto L160;
        r140.setVisibility(8);
    L160:
        NovaTitleBarEx r141 = this.f301696v;
        if (r141 == null) goto L163;
        r141.setVisibility(0);
    L163:
        com.larus.platform.api.g0 r142 = this.f301686n;
        if (r142 == null) goto L168;
        View r143 = r142.getTitleView();
        if (r143 == null) goto L168;
        r143.setVisibility(8);
    L168:
        FLogger.f375446a.i(d4(), "refreshTitleState " + this.f301696v);
        return;
    L169:
        View r144 = this.f301694t;
        if (r144 == null) goto L172;
        r144.setVisibility(8);
    L172:
        NovaTitleBarEx r145 = this.f301695u;
        if (r145 == null) goto L175;
        r145.setVisibility(8);
    L175:
        NovaTitleBarEx r146 = this.f301688p;
        if (r146 == null) goto L178;
        r146.setVisibility(8);
    L178:
        NovaTitleBarEx r147 = this.f301696v;
        if (r147 == null) goto L181;
        r147.setVisibility(8);
    L181:
        com.larus.platform.api.g0 r148 = this.f301686n;
        if (r148 == null) goto L198;
        View r149 = r148.getTitleView();
        if (r149 == null) goto L199;
        r149.setVisibility(0);
        return;
    L199:
        return;
    L198:
        return;
    L147:
        if (r137.E8() != true) goto L149;
    L123:
        if (r129.e6() != true) goto L125;
        r130 = true;
        goto L126
    L99:
        if (r121.i0() != true) goto L101;
        r122 = true;
        goto L102
    L74:
        if (r113.H1() != true) goto L76;
        r114 = true;
    L33:
        r111 = null;
    L37:
        if (r111.getParent() == r110) goto L71;
        ViewParent r150 = r111.getParent();
        if ((r150 instanceof ViewGroup) == false) goto L42;
        r106 = (ViewGroup) r150;
    L42:
        if (r106 == null) goto L44;
        r106.removeView(r111);
    L44:
        r110.addView(r111, new ViewGroup.LayoutParams(-1, -2));
        FLogger.f375446a.i(d4(), "attach collection title, previewCollectionId=" + a4() + ", childCount=" + r110.getChildCount());
        goto L71
    L45:
        com.larus.bmhome.chat.component.showcase.x r151 = (com.larus.bmhome.chat.component.showcase.x) this.G.getValue();
        if (r151 != null) goto L48;
    L50:
        boolean r152 = false;
    L51:
        if (r152 == true) goto L53;
        com.larus.bmhome.chat.component.servicebot.a r153 = c4();
        if (r153 != null) goto L61;
    L63:
        boolean r154 = false;
    L64:
        if (r154 == false) goto L71;
        if (this.f301696v != null) goto L71;
        com.larus.bmhome.chat.component.servicebot.a r155 = c4();
        if (r155 == null) goto L70;
        r104 = r155.O10();
    L70:
        this.f301696v = r104;
        r100.f311102r.addView(r104, new ViewGroup.LayoutParams(-1, -2));
        FLogger.f375446a.i(d4(), "titleContainer = " + r100.f311102r.getChildCount());
        goto L71
    L61:
        if (r153.E8() != true) goto L63;
        r154 = true;
        goto L64
    L53:
        if (this.f301694t != null) goto L71;
        com.larus.bmhome.chat.component.showcase.x r156 = (com.larus.bmhome.chat.component.showcase.x) this.G.getValue();
        if (r156 == null) goto L57;
        r107 = r156.pt();
    L57:
        this.f301694t = r107;
        r100.f311102r.addView(r107, new ViewGroup.LayoutParams(-1, -2));
        goto L71
    L48:
        if (r151.e6() != true) goto L50;
        r152 = true;
        goto L51
    L21:
        if (r108.i0() != true) goto L23;
        r109 = true;
        goto L25
    L13:
        if (this.f301695u != null) goto L71;
        IChatMessageShareAbility r157 = (IChatMessageShareAbility) this.I.getValue();
        if (r157 == null) goto L17;
        r105 = r157.VU();
    L17:
        this.f301695u = r105;
        r100.f311102r.addView(r105, new ViewGroup.LayoutParams(-1, r100.f311102r.getHeight() - r100.f311102r.getPaddingTop()));
        goto L71
    L7:
        if (r101.H1() != true) goto L9;
        r103 = true;
        goto L10
    }

    public final void i5() {
        if (G4() == false) goto L6;
        getContext().getString(R.string.larus_cici_monetization_get_pro_btn);
        Intrinsics.checkNotNullParameter(new q(this), "listener");
        v4("", true, 2, null);
        return;
    }

    public final BotModel j0() {
        com.larus.bmhome.chat.component.cvs.y r100 = u0();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.j0();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget, com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        super.onCreate();
        z2.f365865a.i2(this.f301702y1);
        g4 r100 = e4();
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        IAppLaunchReporter r102 = (IAppLaunchReporter) ServiceManager.get().getService(IAppLaunchReporter.class);
        if (r102 == null) goto L13;
        r102.c("chat_title_show", null);
    L13:
        m3();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
        return;
    L5:
        if (r100.i() == true) goto L7;
        r101 = true;
        goto L8
    }

    public final void p4() {
        String r100 = a4();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        com.larus.bmhome.chat.component.collection.o r103 = H3();
        if (r103 != null) goto L14;
    L31:
        com.larus.platform.api.g0 r104 = this.f301686n;
        if (r104 == null) goto L36;
        View r105 = r104.getTitleView();
        if (r105 == null) goto L36;
        r105.setVisibility(8);
    L36:
        int r106 = this.f301691q;
        if (r106 >= 3) goto L39;
        this.f301691q = r106 + 1;
        LarusPageChatBinding r107 = B3();
        if (r107 == null) goto L57;
        FrameLayout r108 = r107.f311102r;
        if (r108 == null) goto L58;
        r108.postDelayed(new r(this), 50);
        return;
    L58:
        return;
    L57:
        return;
    L39:
        if (this.f301693s == true) goto L59;
        this.f301693s = true;
        com.larus.bmhome.chat.component.collection.o r109 = H3();
        FLogger r110 = FLogger.f375446a;
        String r111 = d4();
        StringBuilder r112 = new StringBuilder("refresh collection title failed, previewCollectionId=");
        r112.append(a4());
        r112.append(", hasCollectionAbility=");
        if (r109 != null) goto L45;
        r101 = false;
    L45:
        r112.append(r101);
        r112.append(", isCollectionMode=");
        if (r109 == null) goto L48;
        Boolean r113 = Boolean.valueOf(r109.i0());
    L49:
        r112.append(r113);
        r110.w(r111, r112.toString());
        return;
    L48:
        r113 = null;
        goto L49
    L59:
        return;
    L14:
        if (r103.i0() == false) goto L31;
        if (this.f301692r == true) goto L19;
        this.f301692r = true;
        FLogger.f375446a.i(d4(), "refresh collection title, previewCollectionId=" + a4() + ", retryCount=" + this.f301691q);
    L19:
        this.f301691q = 0;
        LarusPageChatBinding r114 = B3();
        if (r114 == null) goto L24;
        FrameLayout r115 = r114.f311102r;
        if (r115 == null) goto L24;
        r115.setVisibility(0);
    L24:
        com.larus.platform.api.g0 r116 = this.f301686n;
        if (r116 == null) goto L29;
        View r117 = r116.getTitleView();
        if (r117 == null) goto L29;
        r117.setVisibility(8);
    L29:
        hz();
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        p4();
    }

    @Override // ry8.b, u29.a
    public final com.larus.platform.api.g0 C5() {
        return this.f301686n;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final int U2() {
        return this.f301685m;
    }

    @Override // ry8.b
    public final String nM() {
        return this.f301681g1;
    }

    public static final void Y2(ChatTitleComponent r100) {
        g4 r101 = r100.e4();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.i() == false) goto L38;
        com.larus.platform.api.g0 r102 = r100.f301686n;
        if (r102 == null) goto L11;
        r101.a();
        r102.setBackIconVisible(true);
    L11:
        CharSequence r103 = r101.g();
        if (r103 == null) goto L16;
        com.larus.platform.api.g0 r104 = r100.f301686n;
        if (r104 == null) goto L16;
        com.larus.platform.api.g0.a.b(r104, r103.toString(), false, 6);
    L16:
        CharSequence r105 = r101.f();
        if (r105 == null) goto L21;
        com.larus.platform.api.g0 r106 = r100.f301686n;
        if (r106 == null) goto L21;
        com.larus.platform.api.g0.a.a(r106, r105.toString(), 0, 14);
    L21:
        com.larus.platform.api.g0 r107 = r100.f301686n;
        if ((r107 instanceof ChatTitleAlignLeftStyle) == false) goto L24;
        ChatTitleAlignLeftStyle r108 = (ChatTitleAlignLeftStyle) r107;
    L25:
        if (r108 != null) goto L27;
        return;
    L27:
        if (r101.d() == true) goto L32;
        View r109 = r108.getSearchIcon();
        if (r109 == null) goto L32;
        com.larus.utils.e1.o(r109);
    L32:
        if (r101.c() == true) goto L36;
        r108.setArrowVisible(false);
        return;
    L36:
        return;
    L24:
        r108 = null;
        goto L25
    }

    public final void F4(ChatTitleAlignLeftStyle r100) {
        sd8.a r101 = E3();
        if (r101 == null) goto L5;
        qy8.a r102 = r101.yu();
    L6:
        r100.setNowHalfStyle(f1().n());
        if (r102 == null) goto L9;
        Set<ChatTitleBarIcon> r103 = r102.f535209f;
    L10:
        r100.setTitleBarVisibleIcons(r103);
        if (r102 == null) goto L15;
        qy8.c r104 = r102.f535204a;
        if (r104 == null) goto L15;
        r104.b();
    L15:
        r100.setForceHideBack(false);
        r100.setForceHideSearch(false);
        r100.setSideNavIconVisible(false);
        r100.setTitleBarIconAnimationProgressProvider(null);
        Intrinsics.checkNotNullParameter(this, "<this>");
        r100.H6(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        return;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseContentWidget
    public final void X2(int r100) {
        this.f301685m = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.larus.bmhome.chat.component.title.x0, java.lang.Runnable] */
    public final void f5(wc9.e r100) {
        com.larus.platform.api.g0 r101 = this.f301686n;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L19;
        if (r100 == null) goto L16;
        Integer r104 = r100.f559219v;
        if (r104 == null) goto L16;
        if (r104.intValue() != 1) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        boolean r106 = true;
    L20:
        be8.a r107 = (be8.a) this.L.getValue();
        if (r107 == null) goto L23;
        String r108 = r107.lo();
    L24:
        if (r108 != null) goto L53;
        com.larus.platform.service.n0 r109 = com.larus.platform.service.n0.f365775a;
        if (r109.b() == false) goto L31;
        if (r106 == false) goto L31;
        r108 = getContext().getString(R.string.larus_enterprise_mainBot_desc_genByAI_cn);
        Intrinsics.checkNotNull(r108);
    L31:
        if (r109.b() == false) goto L34;
        r108 = getContext().getString(R.string.larus_enterprise_otherBot_desc_genByDBAI_cn);
        Intrinsics.checkNotNull(r108);
        goto L53
    L34:
        if (r106 == false) goto L41;
        if (getContext().getResources().getConfiguration().screenWidthDp > 350) goto L38;
        String r110 = getContext().getString(R.string.larus_Bot_desc_genByAI);
    L39:
        r108 = r110;
        Intrinsics.checkNotNull(r108);
        goto L53
    L38:
        r110 = getContext().getString(R.string.larus_mainBot_desc_genByAI);
        goto L39
    L41:
        if (AppHost.f326268a.isOversea() == false) goto L48;
        if (getContext().getResources().getConfiguration().screenWidthDp > 350) goto L45;
        String r111 = getContext().getString(R.string.larus_Bot_desc_genByAI);
    L46:
        r108 = r111;
        Intrinsics.checkNotNull(r108);
        goto L53
    L45:
        r111 = getContext().getString(R.string.larus_otherBot_desc_genByDolaAI);
        goto L46
    L48:
        if (getContext().getResources().getConfiguration().screenWidthDp > 350) goto L50;
        String r112 = getContext().getString(R.string.larus_Bot_desc_genByAI);
    L51:
        r108 = r112;
        Intrinsics.checkNotNull(r108);
        goto L53
    L50:
        r112 = getContext().getString(R.string.larus_otherBot_desc_genByDBAI_cn);
    L53:
        if (com.larus.platform.service.n0.f365775a.b() == true) goto L61;
        x0 r113 = this.Y;
        if (r113 == null) goto L57;
        ((Handler) this.W.getValue()).removeCallbacks(r113);
    L57:
        this.Y = null;
        this.f301683k0 = false;
        this.Z = null;
        com.larus.platform.api.g0 r114 = this.f301686n;
        if (r114 == null) goto L84;
        com.larus.platform.api.g0.a.a(r114, r108, 1, 10);
        return;
    L84:
        return;
    L61:
        this.Z = r108;
        if (f1().w() == false) goto L69;
        if (this.f301689p0 == true) goto L69;
        if (this.Y != null) goto L69;
        r102 = true;
    L69:
        if (r102 == false) goto L76;
        this.f301689p0 = true;
        this.f301683k0 = true;
        com.larus.platform.api.g0 r115 = this.f301686n;
        if (r115 == null) goto L73;
        com.larus.platform.api.g0.a.a(r115, getContext().getString(R.string.larus_enterprise_bot_desc_disclaimer_cn), 1, 10);
    L73:
        ?? r116 = new x0(this);
        ((Handler) this.W.getValue()).postDelayed(r116, 3000);
        this.Y = r116;
        return;
    L76:
        if (this.f301683k0 == false) goto L80;
        com.larus.platform.api.g0 r117 = this.f301686n;
        if (r117 == null) goto L85;
        com.larus.platform.api.g0.a.a(r117, getContext().getString(R.string.larus_enterprise_bot_desc_disclaimer_cn), 1, 10);
        return;
    L85:
        return;
    L80:
        com.larus.platform.api.g0 r118 = this.f301686n;
        if (r118 == null) goto L87;
        com.larus.platform.api.g0.a.a(r118, r108, 1, 10);
        return;
    L87:
        return;
    L23:
        r108 = null;
    L16:
        r105 = false;
    L19:
        r106 = false;
        goto L20
    L5:
        if (r101.Da() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // ry8.b
    public final void lL(boolean r100) {
        com.larus.platform.api.g0 r101 = this.f301686n;
        if (r101 == null) goto L6;
        r101.setTtsGrey(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v78, types: [com.larus.bmhome.chat.component.title.f0] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.bmhome.chat.component.title.t] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r110) {
        Intrinsics.checkNotNullParameter(r110, "view");
        g4 r100 = e4();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        int r103 = 8;
        if (r102 == false) goto L16;
        LarusPageChatBinding r111 = B3();
        if (r111 == null) goto L267;
        FrameLayout r112 = r111.f311102r;
        if (r112 == null) goto L268;
        r112.setVisibility(8);
        return;
    L268:
        return;
    L267:
        return;
    L16:
        Fragment r104 = Z3();
        if ((r104 instanceof ChatDoubleTabFragment) == false) goto L22;
        Fragment r105 = Z3();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.larus.bmhome.chat.ChatDoubleTabFragment");
        com.larus.platform.api.g0 r106 = ((ChatDoubleTabFragment) r105).f296850j;
        if (r106 != null) goto L25;
    L24:
        r106 = null;
    L25:
        if (r106 == null) goto L34;
        this.f301686n = r106;
        if ((r106 instanceof ChatTitleAlignLeftStyle) == false) goto L29;
        ChatTitleAlignLeftStyle r107 = (ChatTitleAlignLeftStyle) r106;
    L30:
        if (r107 == null) goto L32;
        F4(r107);
    L32:
        r110.setMinimumHeight((i5.c0() + i5.r0()) + i5.r0());
    L72:
        if (((va8.k) this.B.getValue()) == null) goto L85;
        LarusPageChatBinding r113 = B3();
        if (r113 == null) goto L111;
        FrameLayout r114 = r113.f311102r;
        if (r114 == null) goto L111;
        va8.k r108 = (va8.k) this.B.getValue();
        if (r108 == null) goto L80;
        FloatChatWindowState r109 = r108.getWindowState();
    L82:
        if (r109 != FloatChatWindowState.Expanded) goto L84;
        r103 = 0;
    L84:
        r114.setVisibility(r103);
        goto L111
    L80:
        r109 = null;
    L111:
        com.larus.bmhome.chat.component.halfscreen.c r115 = (com.larus.bmhome.chat.component.halfscreen.c) this.f301703z.getValue();
        if (r115 == null) goto L114;
        r115.UX(new s(this));
    L114:
        com.larus.platform.api.g0 r116 = this.f301686n;
        if ((r116 instanceof ChatTitleAlignLeftStyle) == false) goto L117;
        ChatTitleAlignLeftStyle r117 = (ChatTitleAlignLeftStyle) r116;
    L118:
        if (r117 == null) goto L146;
        String r118 = Q3();
        AuthModelDelegate r119 = AuthModelDelegate.f297134b;
        wc9.e r120 = r119.y().getValue();
        if (r120 == null) goto L122;
        String r121 = r120.f559198a;
    L123:
        boolean r122 = Intrinsics.areEqual(r118, r121);
        if (r122 == false) goto L130;
        wc9.e r123 = r119.y().getValue();
        if (r123 == null) goto L128;
        String r124 = r123.f559200c;
    L129:
        if (r124 == null) goto L130;
    L131:
        String r125 = r124;
        wc9.e r126 = V3();
        if (r126 != null) goto L134;
    L136:
        boolean r127 = false;
    L137:
        r117.setTopLeftCreateNewCvsAvailable(!r127);
        boolean r128 = Intrinsics.areEqual(L9(), Boolean.TRUE);
        boolean r129 = k4();
        if (f1().w() == true) goto L140;
    L144:
        boolean r130 = false;
    L145:
        r117.i6(r122, r125, r128, r129, r130);
        goto L146
    L140:
        if (this.f301689p0 == true) goto L144;
        if (this.Y != null) goto L144;
        r130 = true;
        goto L145
    L134:
        if (ic8.n.r(r126) != true) goto L136;
        r127 = true;
        goto L137
    L128:
        r124 = null;
    L130:
        r124 = "";
        goto L131
    L122:
        r121 = null;
    L146:
        q4(false);
        sd8.a r131 = E3();
        if (r131 == null) goto L155;
        qy8.a r132 = r131.yu();
        if (r132 == null) goto L155;
        Set<ChatTitleBarIcon> r133 = r132.f535209f;
        if (r133 == null) goto L155;
        if (r133.contains(ChatTitleBarIcon.COLLAPSE) != true) goto L155;
        boolean r134 = true;
    L156:
        if (r134 == false) goto L160;
        com.larus.platform.api.g0 r135 = this.f301686n;
        if (r135 == null) goto L160;
        r135.setBackIconRes(R.drawable.larus_ic_page_close);
    L160:
        com.larus.platform.api.g0 r136 = this.f301686n;
        if (r136 == null) goto L163;
        r136.setDotEnable(f1().f468096l);
    L163:
        j4();
        RepoDispatcher.f307729a.getClass();
        ChatRepo r137 = RepoDispatcher.f307732d;
        Pair<String, String> r138 = r137.f307631c.getValue();
        if (r138 == null) goto L166;
        String r139 = r138.getSecond();
    L167:
        this.f301682h1 = r139;
        if (z2.f365865a.enableChatWithTab() == false) goto L186;
        com.larus.platform.api.g0 r140 = this.f301686n;
        if (r140 == null) goto L172;
        r140.setRedDotBGType(2);
    L172:
        com.larus.bmhome.chat.component.immerse.a r141 = G3();
        if (r141 == null) goto L175;
        ChatImmersFragment r142 = r141.Z5();
    L177:
        if ((r142 instanceof ChatImmersFragment) == true) goto L180;
        r142 = null;
    L180:
        if (r142 == null) goto L203;
        LarusPageChatImmersiveBinding r143 = r142.f303184j;
        if (r143 == null) goto L203;
        RedDotTextView r144 = r143.f311151d;
        if (r144 == null) goto L203;
        r144.setRedDotBG(2);
    L203:
        Pair<String, String> r145 = r137.f307631c.getValue();
        if (r145 == null) goto L206;
        String r146 = r145.getSecond();
    L207:
        this.f301682h1 = r146;
        if (f1().f468096l == true) goto L215;
        com.larus.platform.api.g0 r147 = this.f301686n;
        if (r147 == null) goto L212;
        r147.setDotEnable(false);
    L212:
        com.larus.platform.api.g0 r148 = this.f301686n;
        if (r148 == null) goto L215;
        r148.setRedDotViewVisible(false);
    L215:
        m1 r149 = new m1(this);
        com.larus.platform.api.g0 r150 = this.f301686n;
        if (r150 != null) goto L218;
    L221:
        com.larus.bmhome.chat.component.cvs.y r151 = u0();
        if (r151 == null) goto L224;
        r151.rh(new z(), r149);
    L224:
        n1 r152 = new n1(this);
        com.larus.bmhome.chat.component.cvs.y r153 = u0();
        if (r153 == null) goto L227;
        r153.rh(new c0(), r152);
    L227:
        l1 r154 = new l1(this);
        com.larus.bmhome.chat.component.cvs.y r155 = u0();
        if (r155 == null) goto L230;
        r155.rh(new j0(), r154);
    L230:
        k1 r156 = new k1(this);
        com.larus.bmhome.chat.component.cvs.y r157 = u0();
        if (r157 == null) goto L233;
        r157.ll(new d0(), r156);
    L233:
        com.larus.bmhome.chat.component.cvs.y r158 = u0();
        if (r158 == null) goto L236;
        r158.ll(new e0(), new j1(this));
    L236:
        ICoreInputAbility r159 = W3();
        if (r159 == 0) goto L239;
        r159.sQ(new f0(this));
    L239:
        Intrinsics.checkNotNullParameter(this, "<this>");
        t1a.b r160 = s1a.a.g(com.larus.ui.arch.component.internal.attach.a.b(this, this));
        if (r160 == null) goto L242;
        ss8.g r161 = (ss8.g) r160.getAbility(ss8.g.class);
    L243:
        FLogger r162 = FLogger.f375446a;
        r162.i(d4(), "observeUIBlock: ability=" + r161);
        if (r161 == null) goto L258;
        r161.ds(this.f301687o);
        boolean r163 = r161.bc(ChatUIBlockConfig.HIDE_TITLE_BAR_BUTTONS);
        r162.i(d4(), "observeUIBlock: HIDE_TITLE_BAR_BUTTONS blocked=" + r163);
        if (r163 == false) goto L251;
        com.larus.platform.api.g0 r164 = this.f301686n;
        if (r164 == null) goto L251;
        r164.setRealTimeCallVisible(false);
    L251:
        if (r161.bc(ChatUIBlockConfig.DISABLE_MESSAGE_INTERACTION) == false) goto L258;
        com.larus.platform.api.g0 r165 = this.f301686n;
        if ((r165 instanceof ChatTitleAlignLeftStyle) == false) goto L255;
        ChatTitleAlignLeftStyle r166 = (ChatTitleAlignLeftStyle) r165;
    L256:
        if (r166 == null) goto L258;
        r166.setCreateNewCvsForceHidden(true);
        goto L258
    L255:
        r166 = null;
    L258:
        p4();
        com.larus.bmhome.chat.component.servicebot.a r167 = c4();
        if (r167 != null) goto L261;
    L263:
        r101 = false;
    L264:
        if (r101 == true) goto L269;
        c2.f365725a.e().observe(this, new u1(new t(this)));
        Intrinsics.checkNotNullParameter(this, "<this>");
        this.M1 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new ChatTitleComponent$collectAudioDowngrade$1(this, null), 3, null);
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(ce8.c.f23471a, new ChatTitleComponent$observeContinuousSpeech$1(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
        return;
    L269:
        return;
    L261:
        if (r167.E8() != true) goto L263;
    L242:
        r161 = null;
        goto L243
    L218:
        if (k4() == false) goto L220;
        r150.setOnBackClickListener(new x(this));
        goto L221
    L220:
        r150.setOnBackClickListener(new y(this));
        goto L221
    L206:
        r146 = null;
        goto L207
    L175:
        r142 = null;
        goto L177
    L186:
        com.larus.platform.api.g0 r168 = this.f301686n;
        if (r168 == null) goto L189;
        r168.setRedDotBGType(1);
    L189:
        com.larus.bmhome.chat.component.immerse.a r169 = G3();
        if (r169 == null) goto L192;
        ChatImmersFragment r170 = r169.Z5();
    L194:
        if ((r170 instanceof ChatImmersFragment) == true) goto L197;
        r170 = null;
    L197:
        if (r170 == null) goto L203;
        LarusPageChatImmersiveBinding r171 = r170.f303184j;
        if (r171 == null) goto L203;
        RedDotTextView r172 = r171.f311151d;
        if (r172 == null) goto L203;
        r172.setRedDotBG(1);
        goto L203
    L192:
        r170 = null;
        goto L194
    L166:
        r139 = null;
    L155:
        r134 = false;
        goto L156
    L117:
        r117 = null;
        goto L118
    L85:
        va8.f0 r173 = (va8.f0) this.A.getValue();
        if (r173 != null) goto L88;
    L90:
        boolean r174 = false;
    L91:
        if (r174 == false) goto L111;
        Bundle r175 = f1().f468086b;
        if (r175 != null) goto L95;
        r175 = f1().f468085a;
    L95:
        if (r175 != null) goto L97;
    L99:
        boolean r176 = false;
    L100:
        if (r176 == false) goto L106;
        r110.setMinimumHeight(0);
        LarusPageChatBinding r177 = B3();
        if (r177 == null) goto L111;
        FrameLayout r178 = r177.f311102r;
        if (r178 == null) goto L111;
        r178.setVisibility(8);
        goto L111
    L106:
        LarusPageChatBinding r179 = B3();
        if (r179 == null) goto L111;
        FrameLayout r180 = r179.f311102r;
        if (r180 == null) goto L111;
        r180.setVisibility(4);
        goto L111
    L97:
        if (r175.getBoolean("argHideTitleContainerPlaceholder", false) != true) goto L99;
        r176 = true;
        goto L100
    L88:
        if (r173.R() != true) goto L90;
        r174 = true;
        goto L91
    L29:
        r107 = null;
        goto L30
    L34:
        if ((r110 instanceof ViewGroup) == false) goto L36;
        ViewGroup r181 = (ViewGroup) r110;
    L37:
        if (r181 == null) goto L72;
        if (com.larus.utils.o0.d(a4()) == false) goto L47;
        com.larus.platform.api.g0 r182 = this.f301686n;
        if (r182 == null) goto L45;
        View r183 = r182.getTitleView();
        if (r183 == null) goto L45;
        r183.setVisibility(8);
    L45:
        p4();
        FLogger.f375446a.i(d4(), "skip normal title attach in preview collection, previewCollectionId=" + a4());
        goto L72
    L47:
        if (r181.getChildCount() == 0) goto L49;
        boolean r184 = true;
    L50:
        if (r184 == true) goto L52;
    L54:
        com.larus.bmhome.chat.component.servicebot.a r185 = c4();
        if (r185 != null) goto L57;
    L59:
        boolean r186 = false;
    L60:
        if (r186 == false) goto L62;
        FLogger.f375446a.i(d4(), "intercept attach titleBar in serviceBot");
        goto L72
    L62:
        r181.removeAllViews();
        if (this.f301686n != null) goto L65;
        FLogger.f375446a.e(d4(), "create title again on generateTitleBar");
        m3();
    L65:
        com.larus.platform.api.g0 r187 = this.f301686n;
        if (r187 == null) goto L72;
        View r188 = r187.getTitleView();
        if (r188.getParent() == null) goto L70;
        ViewParent r189 = r188.getParent();
        Intrinsics.checkNotNull(r189, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r189).removeView(r188);
    L70:
        r181.addView(r188);
        ViewGroup.LayoutParams r190 = r188.getLayoutParams();
        r190.width = -1;
        r190.height = -1;
        goto L72
    L57:
        if (r185.E8() != true) goto L59;
        r186 = true;
        goto L60
    L52:
        if ((ViewGroupKt.get(r181, 0) instanceof com.larus.platform.api.g0) == false) goto L54;
    L49:
        r184 = false;
        goto L50
    L36:
        r181 = null;
        goto L37
    L22:
        if ((r104 instanceof ci8.d) == false) goto L24;
        ActivityResultCaller r191 = Z3();
        Intrinsics.checkNotNull(r191, "null cannot be cast to non-null type com.larus.bmhome.chat.multi_tab.IChatMultiTabFragment");
        r106 = ((ci8.d) r191).getTitle();
        goto L25
    L5:
        if (r100.i() == true) goto L7;
        r102 = true;
        goto L8
    }

    public final boolean p3(boolean r100) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r101 = com.larus.ui.arch.component.internal.attach.a.b(this, this).getParentFragment();
        if (r101 == null) goto L7;
        Bundle r102 = r101.getArguments();
        if (r102 == null) goto L7;
        String r103 = r102.getString("template_show_text");
    L9:
        if (Intrinsics.areEqual(r103, "") == false) goto L12;
        return true;
    L12:
        return r100;
    L7:
        r103 = null;
        goto L9
    }

    public final void q4(boolean r100) {
        String r101 = Q3();
        wc9.e r102 = AuthModelDelegate.f297134b.y().getValue();
        if (r102 == null) goto L5;
        String r103 = r102.f559198a;
    L6:
        boolean r104 = Intrinsics.areEqual(r101, r103);
        if (k4() == true) goto L11;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (xq8.b.a(com.larus.ui.arch.component.internal.attach.a.b(this, this)) == true) goto L11;
        boolean r105 = true;
    L12:
        FLogger.f375446a.i(d4(), "setBackIcon, forceBack=" + r100 + " isSideBar=" + k4() + " isMainCvs=" + r104 + " isSecondLevelPage=" + r105);
        if (r100 == false) goto L19;
        com.larus.platform.api.g0 r106 = this.f301686n;
        if (r106 == null) goto L37;
        r106.setBackIconRes(v19.c.b(R.attr.larus_ic_left_back, getContext(), R.drawable.larus_ic_left_back));
        return;
    L37:
        return;
    L19:
        if (k4() == false) goto L23;
        com.larus.platform.api.g0 r107 = this.f301686n;
        if (r107 == null) goto L38;
        r107.setBackIconRes(v19.c.b(R.attr.larus_ic_side_bar, getContext(), R.drawable.larus_ic_side_bar));
        return;
    L38:
        return;
    L23:
        if (r105 == false) goto L27;
        com.larus.platform.api.g0 r108 = this.f301686n;
        if (r108 == null) goto L40;
        r108.setBackIconRes(v19.c.b(R.attr.larus_ic_left_back, getContext(), R.drawable.larus_ic_left_back));
        return;
    L40:
        return;
    L27:
        if (r104 == true) goto L29;
    L33:
        com.larus.platform.api.g0 r109 = this.f301686n;
        if (r109 == null) goto L44;
        r109.setBackIconRes(v19.c.b(R.attr.larus_ic_left_back, getContext(), R.drawable.larus_ic_left_back));
        return;
    L44:
        return;
    L29:
        if (z2.f365865a.getChatNavigatorConfig().f486626c == false) goto L33;
        com.larus.platform.api.g0 r110 = this.f301686n;
        if (r110 == null) goto L42;
        r110.setBackIconRes(v19.c.b(R.attr.larus_ic_drawer_back, getContext(), R.drawable.larus_ic_drawer_back));
        return;
    L42:
        return;
    L11:
        r105 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // ry8.b
    public final void setAudioBtnEnabled(boolean r100) {
        com.larus.platform.api.g0 r101 = this.f301686n;
        if (r101 == null) goto L6;
        r101.setAudioBtnEnabled(r100);
        return;
    }

    @Override // ry8.b
    public final b3a.c wP(Boolean r410) {
        LocalSubConvHelper r100 = LocalSubConvHelper.f314106a;
        Map r101 = LocalSubConvHelper.d(Q3());
        Intrinsics.checkNotNullParameter(this, "<this>");
        Fragment r102 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        String r103 = Q3();
        wc9.e r104 = V3();
        if (r104 == null) goto L5;
        String r310 = r104.I;
    L6:
        wc9.e r105 = V3();
        if (r105 == null) goto L9;
        String r106 = r105.B;
    L10:
        wc9.e r107 = V3();
        if (r107 == null) goto L13;
        Long r108 = r107.f559214q;
    L14:
        BotModel r109 = j0();
        RecommendFrom r110 = f1().f468088d;
        ChatControlTrace r111 = ChatControlTrace.f309996b;
        wc9.e r112 = V3();
        if (r112 == null) goto L17;
        Integer r113 = r112.f559219v;
    L18:
        String r114 = r111.g(r113, D3(), C3());
        if (r410 == null) goto L21;
        boolean r115 = r410.booleanValue();
    L27:
        boolean r116 = r115;
    L29:
        SearchMobParam r117 = f1().f468089e;
        Intrinsics.checkNotNullParameter(this, "<this>");
        ActivityResultCaller r118 = com.larus.ui.arch.component.internal.attach.a.b(this, this);
        if ((r118 instanceof by7.e) == false) goto L32;
        by7.e r119 = (by7.e) r118;
    L33:
        String r120 = f1().e();
        String r121 = f1().d();
        String r122 = (String) r101.get("sub_conv_firstmet_type");
        if (r122 != null) goto L36;
        String r210 = "";
    L37:
        String r123 = (String) r101.get("sub_conv_source_message");
        if (r123 != null) goto L40;
        String r211 = "";
    L42:
        return new b3a.c(r102, r103, r106, r108, r109, r110, r114, "chat", "click_chat_icon", null, r116, r117, null, r119, r120, r121, 0, null, r210, r211, null, null, null, null, null, null, null, ChatControlTrace.L, ChatControlTrace.M, ChatControlTrace.P, null, null, null, null, null, r310, -940371456, 63);
    L40:
        r211 = r123;
        goto L42
    L36:
        r210 = r122;
        goto L37
    L32:
        r119 = null;
        goto L33
    L21:
        com.larus.platform.api.g0 r124 = this.f301686n;
        if (r124 == null) goto L24;
        Boolean r125 = Boolean.valueOf(r124.i());
    L25:
        if (r125 == null) goto L28;
        r115 = r125.booleanValue();
        goto L27
    L28:
        r116 = false;
        goto L29
    L24:
        r125 = null;
        goto L25
    L17:
        r113 = null;
        goto L18
    L13:
        r108 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r310 = null;
        goto L6
    }

    @Override // ry8.b
    public final void xC(te8.b r100) {
        this.f301684k1 = r100;
    }

    public final void h5(boolean r110, EditPos r111) {
        Intrinsics.checkNotNullParameter(r111, "editPos");
        com.larus.platform.api.g0 r100 = this.f301686n;
        if (r100 == null) goto L8;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).getView() == null) goto L9;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ChatTitleComponent$updateRealtimeCallBtnInTitle$1$1(r111, this, r110, r100, null), 2, null);
        return;
    L9:
        return;
    }

    public final void l4(wc9.e r100, boolean r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (z2.f365865a.enableChatWithTab() == true) goto L16;
        com.larus.bmhome.chat.component.immerse.a r102 = G3();
        if (r102 == null) goto L9;
        ChatImmersFragment r103 = r102.Z5();
    L11:
        if ((r103 instanceof ChatImmersFragment) == true) goto L14;
        r103 = null;
    L14:
        if (r103 != null) goto L16;
    L19:
        if (r101 == false) goto L21;
    L27:
        RepoDispatcher.f307729a.getClass();
        RepoDispatcher.f307734f.h(r100.f559198a, null);
        return;
    L21:
        if (f1().C() == false) goto L27;
        com.larus.bmhome.chat.component.immerse.a r104 = (com.larus.bmhome.chat.component.immerse.a) s1a.d.a(this).getAbility(com.larus.bmhome.chat.component.immerse.a.class);
        if (r104 == null) goto L27;
        if (r104.b50() == true) goto L27;
        return;
    L9:
        r103 = null;
    L16:
        if (this.f301680b1 == true) goto L19;
        FLogger.f375446a.d(d4(), "RED_DOT markConversationRead : DO NOT markConversationRead");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ry8.b
    public final void Y9(Bundle r110, int r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, "bundle");
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        BotModel r101 = j0();
        Integer r102 = null;
        if (r111 == 100) goto L5;
    L25:
        Serializable r103 = r110.getSerializable("select_speaker_result");
        if ((r103 instanceof SpeakerVoice) == false) goto L28;
        T r104 = (SpeakerVoice) r103;
    L29:
        r100.element = r104;
        Serializable r105 = r110.getSerializable("select_model_result");
        if ((r105 instanceof ModelItem) == false) goto L32;
        ModelItem r106 = (ModelItem) r105;
    L33:
        String r107 = r110.getString("nick_name_update", "");
        SpeakerVoice r108 = (SpeakerVoice) r100.element;
        Intrinsics.checkNotNull(r107);
        d5(r101, r108, r106, r107);
    L35:
        if (r110.getBoolean("conversation_exit", false) == false) goto L46;
        wc9.e r109 = V3();
        if (r109 == null) goto L39;
        r102 = r109.f559219v;
    L39:
        BotModel r113 = j0();
        if (r113 == null) goto L44;
        SpeakerVoice r114 = r113.getVoiceType();
        if (r114 == null) goto L44;
        h4().updateAsrLanguage(r114, r102);
    L44:
        AudioServiceDelegate.f288288a.i0().l(r113);
        return;
    L46:
        return;
    L32:
        r106 = null;
        goto L33
    L28:
        r104 = 0;
        goto L29
    L5:
        if (r112 != 11) goto L25;
        if (z2.f365865a.o3().f510331a == false) goto L25;
        p2a.a r115 = p2a.r.f527492b.l2();
        if (r101 == null) goto L13;
        SpeakerVoice r116 = r101.getVoiceType();
        if (r116 == null) goto L13;
        String r117 = r116.getLanguageCode();
    L15:
        if (r115.d(r117) == false) goto L25;
        if (r101 == null) goto L20;
        SpeakerVoice r118 = r101.getVoiceType();
        if (r118 == null) goto L20;
        String r119 = r118.getStyleId();
    L21:
        w2a.f r120 = w2a.h.a(r110);
        if (r120 == null) goto L35;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ChatTitleComponent$handleChatSettingResult$1$1(r120, r101, r100, this, r110, r119, null), 3, null);
    L20:
        r119 = null;
    L13:
        r117 = null;
        goto L15
    }

    public final void d5(BotModel r110, SpeakerVoice r111, ModelItem r112, String r113) {
        Intrinsics.checkNotNullParameter(r113, "nickName");
        if (r110 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatTitleComponent$updateChatSettings$1(r111, r110, r112, r113, this, null), 2, null);
    }

    public final void v4(String r100, boolean r101, int r102, View.OnClickListener r103) {
        com.larus.platform.api.g0 r104 = this.f301686n;
        if (r104 == null) goto L6;
        r104.Fa("", r101, r102, r103);
        return;
    }
}
