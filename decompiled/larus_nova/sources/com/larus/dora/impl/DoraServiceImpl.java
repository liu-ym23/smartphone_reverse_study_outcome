package com.larus.dora.impl;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Base64;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.buds.BudsEvent;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dtf.face.config.IConstValues;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.controller.GlobalAudioController;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.avlink.impl.DoraAVLinkServiceImpl;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.DoraResourceState;
import com.larus.dora.api.DoraServerDeviceType;
import com.larus.dora.api.DoraServerResourceSource;
import com.larus.dora.api.DoraServerResourceType;
import com.larus.dora.api.IDoraGuideService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.api.h.HSKU;
import com.larus.dora.api.model.FlowDoraSubBizType;
import com.larus.dora.dorag.res.DoraByteCastManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.DoraBTOptimizationManager;
import com.larus.dora.impl.core.DoraMinorManager;
import com.larus.dora.impl.core.DoraSceneManager;
import com.larus.dora.impl.core.DoraSyncManager;
import com.larus.dora.impl.core.DoraUserManager;
import com.larus.dora.impl.core.DoraVoiceWakeupStateManager;
import com.larus.dora.impl.core.settingsconfig.DoraSettingsConfigManager;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.core.y0;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeywordsHandler;
import com.larus.dora.impl.device.battery.DoraChargingCaseNotificationManager$init$3;
import com.larus.dora.impl.device.ota.DoraOTAManagement;
import com.larus.dora.impl.device.ota.DoraOTAManagement$listenerDoraLink$4;
import com.larus.dora.impl.device.ota.OTAUpdateFrom;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.GestureSettingsRepository;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager$init$1;
import com.larus.dora.impl.device.settings.sound.DoraAmbientVolumeSettingsNotifier;
import com.larus.dora.impl.dynamic.DoraDynamicActivity;
import com.larus.dora.impl.dynamic.n1;
import com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo;
import com.larus.dora.impl.file.DoraLogFileTransferCoordinator;
import com.larus.dora.impl.file.upload.DoraFileUploaderImpl;
import com.larus.dora.impl.frameassembler.DoraAggregateFrameAssembler;
import com.larus.dora.impl.imu.DoraImuDataManager;
import com.larus.dora.impl.log.DoraLogManager;
import com.larus.dora.impl.log.g.DoraGLogManager;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.dora.impl.onboarding.dialog.DoraOnboardingAudioSettingDialog;
import com.larus.dora.impl.ota.DoraOTAManager;
import com.larus.dora.impl.ota.g2.G2OtaFacade;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.DoraResourceSource;
import com.larus.dora.impl.resource.DoraResourceSyncManager;
import com.larus.dora.impl.resource.DoraResourceSyncTrigger;
import com.larus.dora.impl.resource.DoraResourceType;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.HealthService;
import com.larus.dora.impl.serviceimpl.NetworkService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.dora.impl.serviceimpl.VisionService$init$1;
import com.larus.dora.impl.serviceimpl.r;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.home.impl.sdk.p1;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.service.BotChangeType;
import com.larus.minor.api.IMinorService;
import com.larus.network.util.ScreenStateManager;
import com.larus.nova.NovaApplication;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.p2;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.settings.value.c7;
import com.larus.settings.value.e10;
import com.larus.settings.value.kh;
import com.larus.settings.value.s2;
import com.larus.utils.logger.FLogger;
import com.mammon.audiosdk.SAMICore;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.obric.assistant.spi.dora.ObricDoraDelegate;
import com.obric.assistant.spi.window.IChatWindowService;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.open.SocialConstants;
import hq9.a1;
import hq9.b5;
import hq9.g4;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.b1;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import qt9.j4;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009f\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0007Qr}ð\u0002ó\u0002\b\u0007\u0018\u0000 \u009e\u00032\u00020\u00012\u00020\u0002:\u0006\u009e\u0003\u009f\u0003 \u0003B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J.\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020\b2\t\u0010\u0082\u0001\u001a\u0004\u0018\u00010G2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010GH\u0016¢\u0006\u0003\u0010\u0084\u0001J\u0013\u0010\u0085\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u0086\u0001\u001a\u00020YH\u0016J\u0013\u0010\u0087\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u0088\u0001\u001a\u00020YH\u0002J\u001b\u0010\u0089\u0001\u001a\u00020\b2\u0007\u0010\u0086\u0001\u001a\u00020Y2\u0007\u0010\u008a\u0001\u001a\u00020\bH\u0002J(\u0010\u008b\u0001\u001a\u00030\u008c\u00012\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u008f\u0001H\u0082@¢\u0006\u0003\u0010\u0090\u0001J\u001d\u0010\u0091\u0001\u001a\u0004\u0018\u00010\b2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0002¢\u0006\u0003\u0010\u0094\u0001J\u0019\u0010\u0095\u0001\u001a\u0004\u0018\u00010Y*\u00030\u008e\u00012\u0007\u0010\u0096\u0001\u001a\u00020YH\u0002J\u001b\u0010\u0097\u0001\u001a\u00020\b2\u0007\u0010\u000f\u001a\u00030\u008f\u00012\u0007\u0010\u0098\u0001\u001a\u00020\bH\u0002J\"\u0010\u0099\u0001\u001a\u00020\b2\u0007\u0010\u000f\u001a\u00030\u008f\u00012\u0007\u0010\u0098\u0001\u001a\u00020\bH\u0082@¢\u0006\u0003\u0010\u009a\u0001J\u0019\u0010\u009b\u0001\u001a\u00020\b2\u0007\u0010\u000f\u001a\u00030\u008f\u0001H\u0082@¢\u0006\u0003\u0010\u009c\u0001J\"\u0010\u009d\u0001\u001a\u00020\b2\u0007\u0010\u000f\u001a\u00030\u008f\u00012\u0007\u0010\u0098\u0001\u001a\u00020\bH\u0082@¢\u0006\u0003\u0010\u009a\u0001J\n\u0010\u009e\u0001\u001a\u00030\u0080\u0001H\u0002J\n\u0010\u009f\u0001\u001a\u00030\u0080\u0001H\u0002J\u0014\u0010 \u0001\u001a\u00030\u0080\u00012\b\u0010¡\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u0080\u0001H\u0016J\n\u0010¤\u0001\u001a\u00030\u0080\u0001H\u0002J\u0007\u0010¥\u0001\u001a\u00020GJ\t\u0010¦\u0001\u001a\u00020GH\u0002J\u0013\u0010§\u0001\u001a\u00030\u0080\u00012\u0007\u0010¨\u0001\u001a\u00020GH\u0002J\u0013\u0010©\u0001\u001a\u00030\u0080\u00012\u0007\u0010ª\u0001\u001a\u00020\bH\u0016J\u0015\u0010«\u0001\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0]H\u0016J\n\u0010¬\u0001\u001a\u00030\u00ad\u0001H\u0016J\u0010\u0010®\u0001\u001a\u00020\b*\u0005\u0018\u00010¯\u0001H\u0002J\f\u0010°\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0002J\t\u0010±\u0001\u001a\u00020\bH\u0016J\t\u0010²\u0001\u001a\u00020\bH\u0016J\u0010\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020Y0´\u0001H\u0016J\n\u0010µ\u0001\u001a\u00030\u0080\u0001H\u0002J\n\u0010¶\u0001\u001a\u00030\u0080\u0001H\u0016J\n\u0010·\u0001\u001a\u00030\u0080\u0001H\u0016J\n\u0010¸\u0001\u001a\u00030\u0080\u0001H\u0002J\n\u0010¹\u0001\u001a\u00030\u0080\u0001H\u0016J\u0014\u0010º\u0001\u001a\u00030\u0080\u00012\b\u0010»\u0001\u001a\u00030¼\u0001H\u0016J\u0014\u0010½\u0001\u001a\u00030\u0080\u00012\b\u0010»\u0001\u001a\u00030¼\u0001H\u0016J\t\u0010¾\u0001\u001a\u00020GH\u0016J\t\u0010¿\u0001\u001a\u00020GH\u0016J\t\u0010À\u0001\u001a\u00020GH\u0016J\t\u0010Á\u0001\u001a\u00020\bH\u0016J\u0013\u0010Â\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ã\u0001\u001a\u00020GH\u0016J\t\u0010Ä\u0001\u001a\u00020\bH\u0016J\u000b\u0010Å\u0001\u001a\u0004\u0018\u00010YH\u0016J\t\u0010Æ\u0001\u001a\u00020YH\u0016J\n\u0010Ç\u0001\u001a\u00030\u0080\u0001H\u0016J\n\u0010È\u0001\u001a\u00030\u0080\u0001H\u0016J\u0013\u0010É\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ê\u0001\u001a\u00020YH\u0016J\u0013\u0010Ë\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ê\u0001\u001a\u00020YH\u0016J\n\u0010Ì\u0001\u001a\u00030\u0080\u0001H\u0016J\u0013\u0010Í\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ê\u0001\u001a\u00020YH\u0016J\u001b\u0010Î\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0]0NH\u0016J\n\u0010Ï\u0001\u001a\u00030\u0080\u0001H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010Ð\u0001\u001a\u00020\bH\u0016J\u0012\u0010Ñ\u0001\u001a\u00020G2\u0007\u0010Ò\u0001\u001a\u00020\bH\u0016J\u0013\u0010Ó\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ô\u0001\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010\u0017\u001a\u00030Õ\u0001H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020$H\u0016J\u000b\u0010Ö\u0001\u001a\u0004\u0018\u00010YH\u0016J\u0012\u0010×\u0001\u001a\u00020\b2\u0007\u0010Ø\u0001\u001a\u000207H\u0016J\u0012\u0010Ù\u0001\u001a\u00020;2\u0007\u0010Ø\u0001\u001a\u000207H\u0016J\n\u0010Ú\u0001\u001a\u00030\u0080\u0001H\u0016J(\u0010Û\u0001\u001a\u0005\u0018\u00010Ü\u00012\u0007\u0010Ø\u0001\u001a\u0002072\b\u0010Ý\u0001\u001a\u00030Þ\u00012\u0007\u0010ß\u0001\u001a\u00020YH\u0016J\u0013\u0010à\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ø\u0001\u001a\u000207H\u0016J\u0012\u0010á\u0001\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u000204H\u0016J\u0012\u0010â\u0001\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u000204H\u0016J\u0012\u0010ã\u0001\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u000209H\u0016J\u0012\u0010ä\u0001\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u000209H\u0016J\u0012\u0010å\u0001\u001a\u00020;2\u0007\u0010Ø\u0001\u001a\u000207H\u0002J\u0013\u0010æ\u0001\u001a\u00020;2\b\u0010ç\u0001\u001a\u00030è\u0001H\u0002J\u001c\u0010é\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ø\u0001\u001a\u0002072\u0007\u0010Ò\u0001\u001a\u00020\bH\u0002J\u001c\u0010ê\u0001\u001a\u00030\u0080\u00012\u0007\u0010Ø\u0001\u001a\u0002072\u0007\u0010ë\u0001\u001a\u00020;H\u0002J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020/H\u0016J\u001f\u0010ì\u0001\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0]2\b\u0010í\u0001\u001a\u00030\u008e\u0001H\u0016J\b\u0010!\u001a\u00020\"H\u0016J\n\u0010î\u0001\u001a\u00030ï\u0001H\u0016J7\u0010ð\u0001\u001a\u00030\u0080\u00012\u0007\u0010ñ\u0001\u001a\u00020G2\u0007\u0010Z\u001a\u00030ò\u00012\u0007\u0010ó\u0001\u001a\u00020\b2\u0007\u0010ô\u0001\u001a\u00020\b2\u0007\u0010õ\u0001\u001a\u00020\bH\u0016J%\u0010ö\u0001\u001a\u00030\u0080\u00012\u0007\u0010÷\u0001\u001a\u00020Y2\u0007\u0010ñ\u0001\u001a\u00020G2\u0007\u0010Z\u001a\u00030ø\u0001H\u0016J\u0016\u0010ù\u0001\u001a\u00030\u0080\u00012\n\u0010»\u0001\u001a\u0005\u0018\u00010ò\u0001H\u0016J\t\u0010ú\u0001\u001a\u00020\bH\u0016J\t\u0010û\u0001\u001a\u00020\bH\u0016J\u0011\u0010ü\u0001\u001a\n\u0012\u0005\u0012\u00030\u0080\u00010ý\u0001H\u0016J\t\u0010þ\u0001\u001a\u00020\bH\u0016J\n\u0010ÿ\u0001\u001a\u00030\u0080\u0001H\u0016J\t\u0010\u0080\u0002\u001a\u00020\bH\u0016J\t\u0010\u0081\u0002\u001a\u00020GH\u0016J\t\u0010\u0082\u0002\u001a\u00020GH\u0016J\n\u0010\u0083\u0002\u001a\u00030\u0080\u0001H\u0016J\u001c\u0010\u0084\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0085\u0002\u001a\u00020G2\u0007\u0010\u0086\u0002\u001a\u00020\bH\u0016J\u0013\u0010\u0087\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0085\u0002\u001a\u00020GH\u0016J\u0013\u0010\u0088\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u0089\u0002\u001a\u00020YH\u0016J+\u0010\u008a\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u008b\u0002\u001a\u00020Y2\u0016\u0010\u0092\u0001\u001a\u0011\u0012\u0004\u0012\u00020Y\u0012\u0007\u0012\u0005\u0018\u00010\u0093\u00010]H\u0016J\t\u0010\u008c\u0002\u001a\u00020GH\u0016J\t\u0010\u008d\u0002\u001a\u00020GH\u0016J)\u0010\u008e\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u008b\u0002\u001a\u00020Y2\u0014\u0010\u0092\u0001\u001a\u000f\u0012\u0004\u0012\u00020Y\u0012\u0005\u0012\u00030\u0093\u00010]H\u0016J\u0016\u0010\u008f\u0002\u001a\u000f\u0012\u0004\u0012\u00020Y\u0012\u0005\u0012\u00030\u0093\u00010]H\u0016J\t\u0010\u0095\u0002\u001a\u00020\bH\u0016J\u0012\u0010\u0096\u0002\u001a\u00020\b2\u0007\u0010\u0097\u0002\u001a\u00020YH\u0016J\u0014\u0010\u0098\u0002\u001a\u00030\u0080\u00012\b\u0010\u0099\u0002\u001a\u00030\u009a\u0002H\u0016J\t\u0010\u009b\u0002\u001a\u00020\bH\u0016J\t\u0010\u009c\u0002\u001a\u00020\bH\u0016J\t\u0010\u009d\u0002\u001a\u00020\bH\u0016J\u001a\u0010\u009e\u0002\u001a\u00020\b2\t\u0010\u009f\u0002\u001a\u0004\u0018\u00010GH\u0016¢\u0006\u0003\u0010 \u0002J\u001a\u0010¡\u0002\u001a\u0004\u0018\u00010G2\u0007\u0010¢\u0002\u001a\u00020YH\u0016¢\u0006\u0003\u0010£\u0002J\u0012\u0010¤\u0002\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u00020aH\u0016J\u0012\u0010¥\u0002\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u00020aH\u0016J\u0012\u0010¦\u0002\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u00020aH\u0016J\u0012\u0010§\u0002\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u00020dH\u0016J\n\u0010¨\u0002\u001a\u00030\u0080\u0001H\u0016J\n\u0010©\u0002\u001a\u00030\u0080\u0001H\u0016J\u001e\u0010ª\u0002\u001a\u00020\b2\u0013\u0010¡\u0001\u001a\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0]H\u0016J\f\u0010«\u0002\u001a\u0005\u0018\u00010¬\u0002H\u0016J\u0012\u0010\u00ad\u0002\u001a\u00020G2\u0007\u0010®\u0002\u001a\u00020GH\u0016J\n\u0010¯\u0002\u001a\u00030°\u0002H\u0016J\t\u0010±\u0002\u001a\u00020\bH\u0016J\u0012\u0010²\u0002\u001a\u00020G2\u0007\u0010³\u0002\u001a\u00020\bH\u0016J\u0013\u0010´\u0002\u001a\u00020G2\b\u0010µ\u0002\u001a\u00030°\u0002H\u0016J\n\u0010¶\u0002\u001a\u00030°\u0002H\u0016J\u0013\u0010·\u0002\u001a\u00020G2\b\u0010µ\u0002\u001a\u00030°\u0002H\u0016J\u0013\u0010¸\u0002\u001a\u00030\u0080\u00012\u0007\u0010¹\u0002\u001a\u00020YH\u0016J\f\u0010º\u0002\u001a\u0005\u0018\u00010»\u0002H\u0016J\u0011\u0010¼\u0002\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0003\u0010½\u0002J\u0016\u0010¾\u0002\u001a\u0005\u0018\u00010»\u00022\b\u0010¿\u0002\u001a\u00030\u008f\u0001H\u0002J\t\u0010À\u0002\u001a\u00020\bH\u0016J\u0014\u0010Á\u0002\u001a\u00030\u0080\u00012\b\u0010»\u0001\u001a\u00030Â\u0002H\u0016J\u0014\u0010Ã\u0002\u001a\u00030\u0080\u00012\b\u0010»\u0001\u001a\u00030Â\u0002H\u0016J\t\u0010Ä\u0002\u001a\u00020GH\u0016J\u0013\u0010Å\u0002\u001a\u00030\u0080\u00012\u0007\u0010Æ\u0002\u001a\u00020YH\u0016J\n\u0010Ç\u0002\u001a\u00030\u0080\u0001H\u0002J\u001b\u0010È\u0002\u001a\u00030\u0080\u00012\u000f\u0010É\u0002\u001a\n\u0012\u0005\u0012\u00030Ë\u00020Ê\u0002H\u0002J\u0015\u0010Ì\u0002\u001a\u00030\u0080\u00012\t\u0010Í\u0002\u001a\u0004\u0018\u00010YH\u0002J\u001a\u0010Î\u0002\u001a\u00020\b2\u000f\u0010É\u0002\u001a\n\u0012\u0005\u0012\u00030Ë\u00020Ê\u0002H\u0002J\n\u0010Ï\u0002\u001a\u00030\u0080\u0001H\u0002J\u0013\u0010Ð\u0002\u001a\u00030\u0080\u00012\u0007\u0010Æ\u0002\u001a\u00020YH\u0016J\u0013\u0010Ñ\u0002\u001a\u00030\u0080\u00012\u0007\u0010Ò\u0002\u001a\u00020YH\u0002J\n\u0010Ó\u0002\u001a\u00030\u0080\u0001H\u0002J\u001b\u0010Ô\u0002\u001a\u0004\u0018\u00010Y2\u0007\u0010Õ\u0002\u001a\u00020YH\u0082@¢\u0006\u0003\u0010Ö\u0002J\n\u0010×\u0002\u001a\u00030Ø\u0002H\u0016J\u0013\u0010Ù\u0002\u001a\u00030\u0080\u00012\u0007\u0010Ú\u0002\u001a\u00020oH\u0016J\f\u0010Û\u0002\u001a\u0005\u0018\u00010»\u0002H\u0016J\f\u0010Ü\u0002\u001a\u0005\u0018\u00010»\u0002H\u0016J\u0016\u0010Ý\u0002\u001a\u0005\u0018\u00010»\u00022\b\u0010¿\u0002\u001a\u00030\u008f\u0001H\u0002J\n\u0010Þ\u0002\u001a\u00030\u0080\u0001H\u0002J\u0011\u0010ß\u0002\u001a\u00030\u0080\u0001H\u0082@¢\u0006\u0003\u0010à\u0002J\n\u0010á\u0002\u001a\u00030\u0080\u0001H\u0002JM\u0010â\u0002\u001a\u00030\u0080\u00012\u0007\u0010ë\u0001\u001a\u00020G2\u0007\u0010ã\u0002\u001a\u00020G2\u0007\u0010ä\u0002\u001a\u00020G2\u0007\u0010å\u0002\u001a\u00020G2\u0007\u0010æ\u0002\u001a\u00020G2\t\u0010ç\u0002\u001a\u0004\u0018\u00010Y2\t\u0010è\u0002\u001a\u0004\u0018\u00010YH\u0016J\t\u0010é\u0002\u001a\u00020\bH\u0002J\u0012\u0010ê\u0002\u001a\u00020\b2\u0007\u0010ã\u0002\u001a\u00020GH\u0002J\u001c\u0010ë\u0002\u001a\u00030\u0080\u00012\u0007\u0010ã\u0002\u001a\u00020G2\u0007\u0010ä\u0002\u001a\u00020GH\u0002J\u0012\u0010ì\u0002\u001a\u00020\b2\u0007\u0010ã\u0002\u001a\u00020GH\u0002J\u0012\u0010í\u0002\u001a\u00020Y2\u0007\u0010ë\u0001\u001a\u00020GH\u0002J\n\u0010î\u0002\u001a\u00030\u0093\u0001H\u0002J\u0013\u0010õ\u0002\u001a\u00030\u0080\u00012\u0007\u0010Æ\u0002\u001a\u00020YH\u0002J\u0013\u0010ö\u0002\u001a\u00030\u0080\u00012\u0007\u0010\u000f\u001a\u00030\u008f\u0001H\u0002J\u0013\u0010÷\u0002\u001a\u00030\u0080\u00012\u0007\u0010ë\u0001\u001a\u00020GH\u0016J\n\u0010ø\u0002\u001a\u00030\u0080\u0001H\u0002J\u001b\u0010ù\u0002\u001a\u00030\u0080\u00012\u000f\u0010ú\u0002\u001a\n\u0012\u0005\u0012\u00030\u0080\u00010û\u0002H\u0002J\u001b\u0010ü\u0002\u001a\u00030\u0080\u00012\u000f\u0010ú\u0002\u001a\n\u0012\u0005\u0012\u00030\u0080\u00010û\u0002H\u0002J\n\u0010ý\u0002\u001a\u00030\u0080\u0001H\u0002J\u001f\u0010þ\u0002\u001a\u00030\u0080\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u008f\u00012\b\u0010ë\u0001\u001a\u00030ÿ\u0002H\u0016J\u0015\u0010\u0080\u0003\u001a\u00030\u0080\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u008f\u0001H\u0016J!\u0010\u0081\u0003\u001a\u00030\u0080\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010ë\u0001\u001a\u0005\u0018\u00010\u0082\u0003H\u0016J!\u0010\u0083\u0003\u001a\u00030\u0080\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0084\u0003\u001a\u0005\u0018\u00010\u0082\u0003H\u0016J!\u0010\u0085\u0003\u001a\u00030\u0080\u00012\t\u0010\u000f\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0086\u0003\u001a\u0005\u0018\u00010\u0082\u0003H\u0016J\u0013\u0010\u0087\u0003\u001a\u00030\u0080\u00012\u0007\u0010ë\u0001\u001a\u00020GH\u0016J%\u0010\u0088\u0003\u001a\u00030\u0080\u00012\u0007\u0010\u0089\u0003\u001a\u00020G2\u0007\u0010\u008a\u0003\u001a\u00020G2\u0007\u0010\u008b\u0002\u001a\u00020GH\u0016J\u0012\u0010\u008b\u0003\u001a\u0004\u0018\u00010Y2\u0007\u0010å\u0002\u001a\u00020GJ\t\u0010\u008c\u0003\u001a\u00020GH\u0016J\u000b\u0010\u008d\u0003\u001a\u0004\u0018\u00010YH\u0016J\u000b\u0010\u008e\u0003\u001a\u0004\u0018\u00010YH\u0016J\t\u0010\u008f\u0003\u001a\u00020YH\u0016J\t\u0010\u0090\u0003\u001a\u00020\bH\u0016J\u0013\u0010\u0091\u0003\u001a\u00030\u0080\u00012\u0007\u0010\u0092\u0003\u001a\u00020GH\u0016J\t\u0010\u0093\u0003\u001a\u000201H\u0016J\t\u0010\u0094\u0003\u001a\u00020\bH\u0016J\u0012\u0010\u0095\u0003\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u00020OH\u0016J\u0012\u0010\u0096\u0003\u001a\u00030\u0080\u00012\u0006\u0010Z\u001a\u00020OH\u0016J\t\u0010\u0097\u0003\u001a\u00020\bH\u0016J\t\u0010\u0098\u0003\u001a\u00020\bH\u0016J\t\u0010\u0099\u0003\u001a\u00020\bH\u0016J\u0013\u0010\u009a\u0003\u001a\u00030\u009b\u00032\u0007\u0010\u009c\u0003\u001a\u00020YH\u0002J\n\u0010\u009d\u0003\u001a\u00030\u0080\u0001H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0016\u001a\u0004\b'\u0010(R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\b06X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020903X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020;06X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0018\u00010CR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010I\u001a\u0004\u0018\u00010J8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020O0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0004\n\u0002\u0010RR\"\u0010U\u001a\u0004\u0018\u00010T2\b\u0010S\u001a\u0004\u0018\u00010T@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020Y0]0NX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0014\u0010`\u001a\b\u0012\u0004\u0012\u00020a0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\b\u0012\u0004\u0012\u00020a0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020d0NX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010e\u001a\u00020\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u000e\u0010i\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u00020rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010sR\u000e\u0010t\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020vX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010w\u001a\u00020xX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010z\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010{\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u00020}X\u0082\u0004¢\u0006\u0004\n\u0002\u0010~R\u001f\u0010\u0090\u0002\u001a\u00020GX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0002\u0010\u0092\u0002\"\u0006\b\u0093\u0002\u0010\u0094\u0002R\u0013\u0010ï\u0002\u001a\u00030ð\u0002X\u0082\u0004¢\u0006\u0005\n\u0003\u0010ñ\u0002R\u0013\u0010ò\u0002\u001a\u00030ó\u0002X\u0082\u000e¢\u0006\u0005\n\u0003\u0010ô\u0002¨\u0006¡\u0003"}, d2 = {"Lcom/larus/dora/impl/DoraServiceImpl;", "Lcom/larus/dora/api/IDoraService;", "Lcom/bytedance/dora/buds/IDoraBudsCallback;", "<init>", "()V", "preWakeUpTask", "Lcom/larus/dora/impl/DoraPreWakeUpTask;", "isEnrollingStatus", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/larus/dora/api/IDoraService$Session;", "audio", "Lcom/larus/dora/api/IDoraService$Audio;", "vision", "Lcom/larus/dora/api/IDoraService$Vision;", "device", "Lcom/larus/dora/api/IDoraService$Device;", "wifi", "Lcom/larus/dora/api/IDoraService$Wifi;", "getWifi", "()Lcom/larus/dora/api/IDoraService$Wifi;", "wifi$delegate", "Lkotlin/Lazy;", "debug", "Lcom/larus/dora/impl/serviceimpl/DebugService;", "resourceSyncManager", "Lcom/larus/dora/impl/resource/DoraResourceSyncManager;", "ability", "Lcom/larus/dora/api/IDoraService$Ability;", "health", "Lcom/larus/dora/api/IDoraService$Health;", "network", "Lcom/larus/dora/api/IDoraService$Network;", "ota", "Lcom/larus/dora/api/IDoraService$OTA;", "envObserve", "Lcom/larus/dora/api/IDoraService$EnvObserve;", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "llmPlugin", "Lcom/larus/dora/api/IDoraService$LLMPlugin;", "asrPlugin", "Lcom/larus/dora/api/IDoraService$ASRPlugin;", "onboarding", "Lcom/larus/dora/api/IDoraService$Onboarding;", "deviceStateInfo", "Lcom/larus/dora/api/DeviceStatusInfo;", "enabledStateCallbacks", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/dora/api/IDoraService$EnabledStateCallback;", "enabledStateCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/larus/dora/api/DoraEnableScope;", "resourceStateCallbacks", "Lcom/larus/dora/api/IDoraService$ResourceStateCallback;", "resourceStateCache", "Lcom/larus/dora/api/DoraResourceState;", "mainHandler", "Landroid/os/Handler;", "gFeatureInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "audioManager", "Landroid/media/AudioManager;", "volumeChangeReceiver", "Lcom/larus/dora/impl/DoraServiceImpl$VolumeChangeReceiver;", "volumeSyncScope", "Lkotlinx/coroutines/CoroutineScope;", "lastVolume", "", "maxVolume", "avlinkService", "Lcom/larus/avlink/api/IDoraAVLinkService;", "getAvlinkService", "()Lcom/larus/avlink/api/IDoraAVLinkService;", "conversationGestureCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/dora/api/IConversationGestureCallback;", "deviceInfoProvider", "com/larus/dora/impl/DoraServiceImpl$deviceInfoProvider$1", "Lcom/larus/dora/impl/DoraServiceImpl$deviceInfoProvider$1;", "value", "Lcom/larus/im/bean/bot/BotModel;", "mainBotInfo", "getMainBotInfo", "()Lcom/larus/im/bean/bot/BotModel;", "mainConversationId", "", "callback", "Lcom/bytedance/dora/voice/IDoraVoiceCallback;", "cachedVadEvents", "", "getCachedVadEvents", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "mHighPriorityDoraLinkCallbacks", "Lcom/larus/dora/api/IDoraLinkCallback;", "mDoraLinkCallbacks", "mDoraBudsCallbacks", "Lcom/larus/dora/api/IDoraBudsCallback;", "isVoiceInWakeup", "()Z", "setVoiceInWakeup", "(Z)V", "mHasRegisterCallbacks", "coreLaunchObserverRegistered", "coreLaunchConversationInitEnabled", "applogIdCallbackRegistered", "lastCoreConversationInitIdentity", "mainConversationRevision", "", "registeredBotChangeListenerId", "mainBotChangeListener", "com/larus/dora/impl/DoraServiceImpl$mainBotChangeListener$1", "Lcom/larus/dora/impl/DoraServiceImpl$mainBotChangeListener$1;", "hasRegisteredAtomicFuncCallbackProcessor", "atomicFunctionEtpTracker", "Lcom/larus/dora/impl/DoraAtomicFunctionEtpTracker;", "atomicFuncCallbackProcessor", "Lcom/bytedance/dora/link/spp/IETPProcessor;", "cdmInitialized", "p2pRTCVideoCallRequestStarting", "isAppOnForeground", "appBackGroundListener", "com/larus/dora/impl/DoraServiceImpl$appBackGroundListener$1", "Lcom/larus/dora/impl/DoraServiceImpl$appBackGroundListener$1;", "reportState", "", "link", "idleState", "currentIdleState", "(ZLjava/lang/Integer;Ljava/lang/Integer;)V", "handleDoraAtomicFunction", "cmdValue", "forwardETPPayload", "bodyEtpBase64", "handleAppAtomicFunctions", "hasEtpPayload", "executeAppAtomicRequest", "Lcom/larus/dora/impl/DoraServiceImpl$AtomicJsonRpcResult;", "request", "Lorg/json/JSONObject;", "Lcom/bytedance/dora/device/DoraDevice;", "(Lorg/json/JSONObject;Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAtomicEnable", "params", "", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "optNonBlankString", "name", "updateWearDetectionSwitch", "enable", "updateAdaptiveVolumeSwitch", "(Lcom/bytedance/dora/device/DoraDevice;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEnvironmentObservationPrivacyAccepted", "(Lcom/bytedance/dora/device/DoraDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEnvironmentObservationSwitch", "ensureAtomicFuncCallbackProcessorRegistered", "unregisterAtomicFuncCallbackProcessor", "handleAtomicFuncCallbackPayload", WsConstants.KEY_PAYLOAD, "", "init", "initVolumeListener", "getCurrentSystemVolume", "getMaxSystemVolume", "onSystemVolumeChanged", ITTVideoEngineEventSource.KEY_VOLUME, "idleInit", "immediately", "appendDoraParam", "getDoraXLinkCommonConfig", "Lcom/larus/platform/model/DoraXLinkCommonConfig;", "hasDoraXLinkBusinessConfig", "Lcom/larus/settings/provider/dora/AndroidConfig;", "getSdkDoraXLinkCommonConfig", "canEnableLocationPoll", "isDoraGLocationPollEnabled", "getTranslucentPages", "", "doraInit", "registerAllFlowDoraCallback", "registerAllFlowDoraGCallback", "initializeDoraGFeature", "unregisterAllFlowDoraGCallback", "addDoraWakeStateChangeCallback", "listener", "Lcom/larus/dora/api/wrapper/IDoraWakeStateChangedCallback;", "removeDoraWakeStateChangeCallback", "getWakeState", "getWakeMode", "getQueryState", "isWakeUp", "notifyDoraQueryState", "queryState", "isOnboarding", "getModelPath", "getModelMd5", "requestPreWakeupModelDownload", "onStopListenByVoice", "onTtsStart", "audioType", "onTtsEnd", "onAsrEnd", "onAsrStart", "getCacheVadEvents", "onVoiceMonitorTtsStartEvent", "getVoiceWakeupEnable", "setVoiceWakeupEnable", "enabled", "setEnrollingStatus", "enrolling", "Lcom/larus/dora/api/IDoraService$Debug;", "getODiaryBetaUrl", "isEnabled", "scope", "getResourceState", "refreshResourceConfig", "resolveResource", "Lcom/larus/dora/api/DoraServerResource;", "resourceType", "Lcom/larus/dora/api/DoraServerResourceType;", "resourceName", "refreshEnabledState", "addEnabledStateCallback", "removeEnabledStateCallback", "addResourceStateCallback", "removeResourceStateCallback", "calculateResourceState", "calculateDeviceResourceState", IConstValues.DEVICE_TYPE, "Lcom/larus/dora/api/DoraServerDeviceType;", "publishEnabledStateIfChanged", "publishResourceStateIfChanged", "state", "getDoraHeader", "callBody", "getAiQuickNoteConfig", "Lcom/larus/dora/api/entity/QuickNoteConfig;", "getEarbudsLog", "logType", "Lcom/larus/dora/api/OnGetDoraLogCallback;", "fromFeedback", "pendingUpload", "isManual", "uploadEarbudsLog", "filePath", "Lcom/larus/dora/api/OnUploadDoraLogResult;", "listenAutoGetLog", "hasNewVersion", "shouldEnterObricDeviceManagement", "otaNewVersionChangedFlow", "Lkotlinx/coroutines/flow/Flow;", "isFirstEnterSimulInterpretPage", "enterSimulInterpretPage", "isFirstEnterLabSettings", "getKeepAliveDismissDuration", "getKeepAliveBubbleCounts", "syncVUIDataEndEvent", "sendVUIEndEvent", "code", "isSilent", "sendVUIEndSilentEvent", "traceDoraEntranceShow", "page", "reportDoraAndDoubaoTrace", "event", "getWearCount", "getWakeupCount", "reportDoraTrace", "getDoubaoBuryPointCustomParams", "linkState", "getLinkState", "()I", "setLinkState", "(I)V", "isDoraFeatureEnable", "isProactivePriorityEnabled", "userId", "showBluetoothSettingDialog", "manager", "Landroidx/fragment/app/FragmentManager;", "hasDoraDevice", "hasDoraEDevice", "hasDoraGDevice", "isDoraG", "productId", "(Ljava/lang/Integer;)Z", "getDoraBizTypeByAppKey", com.heytap.mcssdk.constant.b.f276376z, "(Ljava/lang/String;)Ljava/lang/Integer;", "registerDoraLinkCallback", "registerHighPriorityDoraLinkCallback", "unRegisterDoraLinkCallback", "registerDoraBudsCallback", "registerDeviceSwitchCallback", "initCompanionDeviceManager", "updateAppletPayload", "getQueryWorkThread", "Ljava/lang/Thread;", "setBudsVersionType", "versionType", "takeRoleSwitchTransmitImageEnable", "", "takeImageOnSpeechEnable", "syncImageOnSpeechEnable", "isChecked", "syncRoleSwitchTransmitImageEnable", "isEnable", "getVpuEnable", "syncVpuEnable", "sendCMD", "cmd", "firstBindDevice", "Lcom/larus/dora/api/DoraDeviceInfo;", "isMultiManageEnabled", "()Ljava/lang/Boolean;", "transformBindDevivce", "it", "isVoiceWakeupEnabled", "addVoiceWakeupStateChangedListener", "Lcom/larus/dora/api/OnVoiceWakeupStateChangedListener;", "removeVoiceWakeupStateChangedListener", "getAutoStopTimeConfig", "tryInitBotConversationInMainThread", "source", "registerCoreLaunchObserverIfNeeded", "handleCoreLaunchResult", "coreResult", "Lcom/larus/bmhome/auth/LaunchResult;", "Lcom/larus/bmhome/auth/CoreLaunchInfo;", "tryInitBotConversationWhenDeviceIdReady", "coreSecUserId", "isCoreReadyForConversationInit", "updateMainConversationFromLaunch", "tryInitBotConversation", "registerMainBotChangeListenerIfNeeded", "mainBotId", "registerAccountStatusCallback", "requestMainConversationInfo", "botId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDoraRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "syncAsrEndDeviceTime", "time", "firstBondedDevice", "managementEntryDevice", "transformBindDevice", "handleP2PRTCVideoCallRequest", "waitP2PRTCVideoCallStartGuard", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerDoraVoiceCallback", "realOnVoiceWakeUp", "mode", "query", "side", "vuiId", "kw", "wakeupExtra", "shouldSkipObricLogic", "shouldNotifyDoraGStateForObric", "notifyDoraGWakeupStateIfNeeded", "isDoraGVoiceWakeupMode", "parseLinkState", "adjustSystemVoice", "highPriorityDoraLinkCallback", "com/larus/dora/impl/DoraServiceImpl$highPriorityDoraLinkCallback$1", "Lcom/larus/dora/impl/DoraServiceImpl$highPriorityDoraLinkCallback$1;", "doraLinkCallback", "com/larus/dora/impl/DoraServiceImpl$doraLinkCallback$1", "Lcom/larus/dora/impl/DoraServiceImpl$doraLinkCallback$1;", "replayCurrentStateToAllCallbacks", "uploadDeviceInfo", "stopTask", "tryGetLinkState", "runOnMain", "block", "Lkotlin/Function0;", "runOnIO", "initLinkManager", "onIdleStateChanged", "Lcom/bytedance/dora/buds/DeviceIdleState;", "onDeviceInfoChange", "onBudsStateChanged", "", "onWearStateChanged", "wearState", "onChargeStateChanged", "charge", "onLowPowerState", "onKeyEvent", "type", "key", "getActionByRadio", "getDoraTitleResId", "getMainBotRealtimeStyleId", "getMainBotStyleId", "getMainBotAudioMetrics", "hasDoraGDeviceJudgedByTraversal", "jumpToManagePage", "routeFlags", "getDeviceStatusInfo", "isHeadGestureControlEnabled", "registerConversationGestureCallback", "unregisterConversationGestureCallback", "isVideoLiveAIEnabled", "isVideoLiveAIPreInitEnabled", "isVideoLiveAIPreInitP2PEnabled", "videoLiveAIPreInitMode", "Lcom/larus/dora/impl/core/settingsconfig/DoraXLinkTransportMode;", "scene", "incWakeupCount", "Companion", "AtomicJsonRpcResult", "VolumeChangeReceiver", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraServiceImpl implements IDoraService, mj4.h {
    public static final AtomicBoolean V0 = null;
    public final CoroutineScope A;
    public int B;
    public int C;
    public final CopyOnWriteArrayList<t39.h> D;
    public final f E;
    public BotModel F;
    public String G;
    public s0 H;
    public int H0;
    public final CopyOnWriteArrayList<Map<String, String>> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final CopyOnWriteArrayList<t39.n> f331916J;
    public final CopyOnWriteArrayList<t39.n> K;
    public final CopyOnWriteArrayList<t39.i> L;
    public final g L0;
    public boolean M;
    public final AtomicBoolean N;
    public final AtomicBoolean O;
    public final AtomicBoolean P;
    public final DoraServiceImpl$doraLinkCallback$1 P0;
    public final AtomicBoolean Q;
    public String R;
    public long S;
    public volatile String T;
    public final j U;
    public final AtomicBoolean V;
    public final com.larus.dora.impl.a W;
    public final g0 X;
    public final AtomicBoolean Y;
    public final AtomicBoolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DoraPreWakeUpTask f331917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f331918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SessionService f331919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.dora.impl.serviceimpl.f f331920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VisionService f331921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DeviceService f331922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f331923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.dora.impl.serviceimpl.h f331924h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DoraResourceSyncManager f331925i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AbilityService f331926j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HealthService f331927k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f331928k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final NetworkService f331929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final r f331930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f331931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.larus.dora.impl.serviceimpl.s f331932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.larus.dora.impl.serviceimpl.a f331933p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final e f331934p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.larus.dora.impl.serviceimpl.t f331935q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final t39.c f331936r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArraySet<IDoraService.e> f331937s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ConcurrentHashMap<DoraEnableScope, Boolean> f331938t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArraySet<IDoraService.g> f331939u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ConcurrentHashMap<DoraEnableScope, DoraResourceState> f331940v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Handler f331941w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final AtomicBoolean f331942x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public AudioManager f331943y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public c f331944z;

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f331945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f331946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f331947c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f331945a, r101.f331945a) == true) goto L12;
            return false;
        L12:
            if (this.f331946b == r101.f331946b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f331947c, r101.f331947c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f331945a.hashCode() * 31) + this.f331946b) * 31) + this.f331947c.hashCode();
        }

        public final String toString() {
            return "AtomicJsonRpcResult(id=" + this.f331945a + ", code=" + this.f331946b + ", result=" + this.f331947c + ')';
        }

        public a(String r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r102, "result");
            this.f331945a = r100;
            this.f331946b = r101;
            this.f331947c = r102;
        }
    }

    public static final class b {
    }

    public final class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraServiceImpl f331948a;

        public c(DoraServiceImpl r100) {
            this.f331948a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 == null) goto L5;
            String r102 = r101.getAction();
        L7:
            if (Intrinsics.areEqual(r102, "android.media.VOLUME_CHANGED_ACTION") == false) goto L27;
            DoraDevice r103 = DoraAdapterExtKt.h(kj4.a.g());     // Catch: Throwable -> L23
            if (r103 != null) goto L13;
            g49.d.d("DoraServiceImpl", "Dora current device is null. Ignore volume changed, ignoring");     // Catch: Throwable -> L23
            return;
        L13:
            if (o59.a.l(r103) == true) goto L16;
            g49.d.d("DoraServiceImpl", "Dora current device is not DoraG. Ignore volume changed, ignoring");     // Catch: Throwable -> L23
            return;
        L16:
            int r104 = r101.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);     // Catch: Throwable -> L23
            if (r104 != 3) goto L21;
            int r105 = this.f331948a.w1();     // Catch: Throwable -> L23
            if (r105 == this.f331948a.B) goto L28;
            g49.d.d("DoraServiceImpl", "system volume changed from " + this.f331948a.B + " to " + r105 + " (stream: " + r104 + ')');     // Catch: Throwable -> L23
            DoraServiceImpl r106 = this.f331948a;     // Catch: Throwable -> L23
            r106.B = r105;     // Catch: Throwable -> L23
            r106.C1(r105);     // Catch: Throwable -> L23
            return;
        L28:
            return;
        L21:
            g49.d.d("DoraServiceImpl", "volume changed for other stream type: " + r104 + ", ignoring");     // Catch: Throwable -> L23
            return;
        L23:
            th = move-exception;
            g49.d.c("DoraServiceImpl", "handle volume change broadcast failed: " + th.getMessage(), th);
            return;
        L27:
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f331949a = null;

        static {
            int[] r100 = new int[DoraEnableScope.values().length];
            r100[DoraEnableScope.G1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DoraEnableScope.G2.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DoraEnableScope.G_SERIES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f331949a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.DoraServiceImpl$debug$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<DoraEnableScope, Unit> {
        public AnonymousClass1(Object r100) {
            super(1, r100, DoraServiceImpl.class, "refreshEnabledState", "refreshEnabledState(Lcom/larus/dora/api/DoraEnableScope;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DoraEnableScope r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            ((DoraServiceImpl) this.receiver).E1(r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DoraEnableScope r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public static final class e implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraServiceImpl f331951a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            FLogger.f375446a.i("DoraServiceImpl", "onAppBackground");
            this.f331951a.f331928k0 = false;
            if (AppHost.f326268a.a().h(DoraDynamicActivity.class) == false) goto L25;
            IObricDoraService r100 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
            boolean r101 = true;
            if (r100 != null) goto L7;
        L9:
            boolean r102 = false;
        L10:
            if (r102 == true) goto L12;
            return;
        L12:
            if (AudioServiceDelegate.f288288a.e0() == false) goto L27;
            IDoraWakeupService r103 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
            if (r103 != null) goto L16;
        L18:
            r101 = false;
        L19:
            if (r101 == false) goto L28;
            IDoraWakeupService r104 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
            if (r104 == null) goto L23;
            r104.l(false);
        L23:
            this.f331951a.H0(162);
            return;
        L28:
            return;
        L16:
            if (r103.f() != true) goto L18;
        L27:
            return;
        L7:
            if (r100.t() != true) goto L9;
            r102 = true;
            goto L10
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            FLogger.f375446a.i("DoraServiceImpl", "onAppForeground");
            this.f331951a.f331928k0 = true;
        }

        public e(DoraServiceImpl r100) {
            this.f331951a = r100;
        }
    }

    public static final class f implements oy8.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraServiceImpl f331952a;

        @Override // oy8.a
        public final int getProductId() {
            return this.f331952a.f331922f.y();
        }

        public f(DoraServiceImpl r100) {
            this.f331952a = r100;
        }
    }

    public static final class g implements IDoraLinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraServiceImpl f331953a;

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onBtStateChanged(int r100, int r101) {
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onDeviceFound(DoraDevice r100) {
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onScanFailed(int r100) {
        }

        public g(DoraServiceImpl r100) {
            this.f331953a = r100;
        }

        @Override // com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r110, int r111) {
            if (r100 != null) goto L4;
            return;
        L4:
            int r112 = r100.productId;
            ProductNameType r101 = ProductNameType.getProduct(r112);
            if (r101 == null) goto L8;
            String r102 = r101.name;
            if (r102 == null) goto L8;
        L9:
            Iterator<T> r103 = this.f331953a.f331916J.iterator();
        L11:
            if (r103.hasNext() == false) goto L15;
            t39.n r104 = (t39.n) r103.next();
            long r105 = SystemClock.elapsedRealtime();
            r104.e(r111, r112, r102, r100.softVersion);
            long r106 = SystemClock.elapsedRealtime() - r105;
            if (r106 <= 50) goto L11;
            g49.d.e("DoraServiceImpl", "high priority DoraLinkCallback cost=" + r106 + "ms, callback=" + r104);
            goto L11
        L15:
            return;
        L8:
            r102 = DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class h implements oy8.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f331954a;

        @Override // oy8.d
        public final boolean a() {
            return !this.f331954a;
        }

        public h(boolean r100) {
            this.f331954a = r100;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class i implements oy8.b {
        public i() {
        }

        @Override // oy8.b
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "macAddress");
        }

        @Override // oy8.b
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "macAddress");
            g49.d.b("DoraServiceImpl", "onDeviceAppeared");
        L10:
            th = move-exception;
            th.printStackTrace();
            return;
        L4:
            if ((!DoraAdapterExtKt.j(kj4.a.g()).isEmpty()) == true) goto L6;
        L13:
            return;
        L6:
            if (AccountService.f365697a.isLogin().booleanValue() == false) goto L8;
            com.larus.dora.impl.core.i0.a.f332211a.i(0, r100);     // Catch: Throwable -> L10
            goto L13
        L8:
            g49.d.d("DoraServiceImpl", "initLinkManager user not login");     // Catch: Throwable -> L10
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.DoraServiceImpl$init$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.DoraServiceImpl$init$1", f = "DoraServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C110691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraServiceImpl this$0;

        public C110691(DoraServiceImpl r100, Continuation<? super C110691> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C110691(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C110691) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            e10 r101 = e10.f368561a;
            int r102 = com.larus.utils.l0.f375430a;
            if (((Boolean) com.larus.utils.l0.a(Boolean.TRUE, new kh())).booleanValue() == true) goto L7;
            this.this$0.P.set(true);
        L7:
            DoraServiceImpl.p1(this.this$0);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class j implements com.larus.im.service.y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraServiceImpl f331955a;

        public j(DoraServiceImpl r100) {
            this.f331955a = r100;
        }

        @Override // com.larus.im.service.y
        public final void a(List<BotModel> r100, BotChangeType r101) {
            Intrinsics.checkNotNullParameter(r100, "changedBots");
            Intrinsics.checkNotNullParameter(r101, "changeType");
            BotModel r102 = (BotModel) CollectionsKt.firstOrNull(r100);
            if (r102 != null) goto L5;
            return;
        L5:
            DoraServiceImpl r103 = this.f331955a;
            AtomicBoolean r104 = DoraServiceImpl.V0;
            r103.getClass();
            IDoraAVLinkService r105 = DoraServiceImpl.v1();
            if (r105 == null) goto L8;
            r105.r(r102);
        L8:
            this.f331955a.F = r102;
            IDoraAVLinkService r106 = DoraServiceImpl.v1();
            if (r106 == null) goto L16;
            SpeakerVoice r107 = r102.getVoiceType();
            if (r107 == null) goto L13;
            String r108 = com.larus.dora.impl.util.r.a(r107);
        L14:
            r106.F(r108);
            return;
        L13:
            r108 = null;
            goto L14
        }
    }

    @Override // com.larus.dora.api.IDoraService
    public final void F0() {
    }

    @Override // mj4.h
    public final /* synthetic */ void J(byte[] r100) {
    }

    @Override // mj4.h
    public final /* synthetic */ void N(int r100, int r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void N0(DoraDevice r100, int[] r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void P0(DoraDevice r100, int[] r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void a0(DoraDevice r100, int[] r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void b0(DoraDevice r100, int[] r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void d1(DoraDevice r100, int r101) {
    }

    @Override // com.larus.dora.api.IDoraService
    public final void e() {
    }

    @Override // mj4.h
    public final /* synthetic */ void f1(int r100, byte r101) {
    }

    @Override // mj4.h
    public final /* synthetic */ void u(DoraDevice r100, int r101) {
    }

    public final int w1() {
        AudioManager r100 = this.f331943y;     // Catch: Throwable -> L7
        if (r100 == null) goto L12;
        return r100.getStreamVolume(3);
    L12:
        return 0;
    L7:
        th = move-exception;
        g49.d.c("DoraServiceImpl", "get current volume failed: " + th.getMessage(), th);
        return 0;
    }

    @Override // mj4.h
    public final /* synthetic */ void y(DoraDevice r100, int r101, byte[] r102) {
    }

    static {
        V0 = new AtomicBoolean(false);
        g49.d.d("DoraServiceImpl", "Companion object Init == ");
        if (pk4.n.f529659c != null) goto L5;
        pk4.n.f529659c = AppHost.f326268a.getApplication();
    L5:
        Application r100 = AppHost.f326268a.getApplication();
        if (r100 != null) goto L8;
        return;
    L8:
        if (com.larus.dora.impl.util.y.b(r100) == false) goto L10;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraServiceImpl$Companion$1$1(null), 3, null);
        return;
    L10:
        g49.d.d("DoraServiceImpl", "Companion object_In_Not_Main_Process = " + com.larus.dora.impl.util.y.a(r100));
    }

    public static void s1() {
        int r100 = com.larus.dora.impl.util.j0.f338143a;
        AppHost.Companion r101 = AppHost.f326268a;
        Object r102 = r101.getApplication().getSystemService("audio");
        AudioManager r103 = null;
        if ((r102 instanceof AudioManager) == false) goto L5;
        AudioManager r104 = (AudioManager) r102;
    L6:
        int r105 = 0;
        if (r104 == null) goto L9;
        int r106 = r104.getStreamVolume(3);
    L10:
        DoraSetting.f338023a.getClass();
        int r107 = com.larus.utils.l0.f375430a;
        j4 r108 = (j4) com.larus.utils.l0.a(new j4(0), new com.larus.dora.impl.settings.u());
        double r109 = r108.b();
        Object r110 = r101.getApplication().getSystemService("audio");
        if ((r110 instanceof AudioManager) == false) goto L13;
        AudioManager r111 = (AudioManager) r110;
    L14:
        int r112 = Build.VERSION.SDK_INT;
        if (r112 < 28) goto L18;
        if (r111 == null) goto L18;
        int r113 = r111.getStreamMinVolume(3);
    L19:
        int r114 = 15;
        if (r111 == null) goto L22;
        int r115 = r111.getStreamMaxVolume(3);
    L23:
        int r116 = (int) ((((double) (r115 - r113)) * r109) + ((double) r113));
        g49.d.b("DoraServiceImpl", "current systemVolumeRatio enable: " + r108.a() + ",config.volume: " + r108.b() + ",currentSystemVolume: " + r106 + ",expectVoice:" + r116);
        if (r108.a() == false) goto L49;
        if (r106 >= r116) goto L49;
        g49.d.b("DoraServiceImpl", "current systemVolumeRatio: " + r106);
        Object r117 = r101.getApplication().getSystemService("audio");     // Catch: Exception -> L47
        if ((r117 instanceof AudioManager) == false) goto L30;
        AudioManager r118 = (AudioManager) r117;     // Catch: Exception -> L47
    L31:
        if (r118 == null) goto L53;
        r118.setStreamVolume(3, r116, 1);     // Catch: Exception -> L47
        g49.d.d("GlobalAudioManager", "setSystemVolume " + r116);     // Catch: Exception -> L47
        Object r119 = r101.getApplication().getSystemService("audio");     // Catch: Exception -> L47
        if ((r119 instanceof AudioManager) == false) goto L36;
        r103 = (AudioManager) r119;     // Catch: Exception -> L47
    L36:
        if (r112 < 28) goto L39;
        if (r103 == null) goto L39;
        r105 = r103.getStreamMinVolume(3);     // Catch: Exception -> L47
    L39:
        if (r103 == null) goto L41;
        r114 = r103.getStreamMaxVolume(3);     // Catch: Exception -> L47
    L41:
        int r120 = r114 - r105;     // Catch: Exception -> L47
        if (r120 != 0) goto L44;
        final double r121 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L45:
        com.larus.utils.l0.b(new com.larus.dora.impl.util.i0(r121));     // Catch: Exception -> L47
        return;
    L44:
        r121 = ((double) (r116 - r105)) / ((double) r120);     // Catch: Exception -> L47
        goto L45
    L53:
        return;
    L30:
        r118 = null;
    L47:
        e = move-exception;
        g49.d.c("GlobalAudioManager", "setSystemVolume " + r116 + " error", e);
        return;
    L49:
        Unit r122 = Unit.INSTANCE;
        return;
    L22:
        r115 = 15;
    L18:
        r113 = 0;
        goto L19
    L13:
        r111 = null;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    public static IDoraAVLinkService v1() {
        return (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void A() {
        Intrinsics.checkNotNullParameter("InitDoraTask", "source");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DoraServiceImpl$tryInitBotConversationInMainThread$1(this, null), 3, null);
    }

    public final boolean A1() {
        if (this.M == true) goto L9;
        IDoraAVLinkService r100 = v1();
        if (r100 == null) goto L7;
        boolean r101 = r100.B();
    L8:
        if (r101 == true) goto L9;
        return false;
    L7:
        r101 = false;
    L9:
        return true;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void C() {
        DoraVoiceCallMonitor.f331961a.onEvent(DoraVoiceCallMonitor.EVENT.CLIENT_TTS_START);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void D0() {
        if (t69.p.f544694b.compareAndSet(true, false) == false) goto L13;
        t69.n r100 = t69.p.f544695c;
        if (r100 == null) goto L8;
        kj4.a.g().E(r100);
    L8:
        t69.o r101 = t69.p.f544696d;
        if (r101 == null) goto L11;
        kj4.a.g().unregisterDoraLinkCallback(r101);
    L11:
        t69.p.f544695c = null;
        t69.p.f544696d = null;
        FLogger.f375446a.i("FlowDoraWidgetManager", "deinit done");
    L13:
        if (t69.k.f544690b.compareAndSet(true, false) == false) goto L20;
        t69.j r102 = t69.k.f544691c;
        if (r102 == null) goto L18;
        kj4.a.g().f503709d.getClass();
        ((CopyOnWriteArraySet) uj4.b.f550325h.f533516c).remove(r102);
    L18:
        t69.k.f544691c = null;
        FLogger.f375446a.i("FlowDoraCameraManager", "deinit done");
    L20:
        if (t69.s.f544698b.compareAndSet(true, false) == false) goto L30;
        t69.r r103 = t69.s.f544699c;
        if (r103 == null) goto L25;
        int r104 = yj4.g.f568093a;
        yj4.f.a.f568092a.getClass();
        ((CopyOnWriteArraySet) yj4.h.D2).remove(r103);
    L25:
        t69.q r105 = t69.s.f544700d;
        if (r105 == null) goto L28;
        vk4.e.d.f555490a.j(r105);
    L28:
        t69.s.f544699c = null;
        t69.s.f544700d = null;
        FLogger.f375446a.i("FlowDoraWifiStateManager", "deinit done");
        return;
    }

    @Override // com.larus.dora.api.IDoraService
    public final DoraRouterInterceptor E0() {
        return new DoraRouterInterceptor();
    }

    @Override // com.larus.dora.api.IDoraService
    public final int F() {
        e10 r100 = e10.f368561a;
        int r101 = com.larus.utils.l0.f375430a;
        return ((Number) com.larus.utils.l0.a(3, new s2())).intValue();
    }

    public final boolean F1() {
        IChatWindowService r100 = (IChatWindowService) ServiceManager.get().getService(IChatWindowService.class);
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        gd9.i r103 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r103);
        boolean r104 = r103.a().c(DoraDynamicActivity.class);
        if (this.f331928k0 == false) goto L13;
        if (r104 == false) goto L13;
        if (r102 == true) goto L13;
        boolean r105 = true;
    L14:
        boolean r106 = J0();
        IDoraAVLinkService r107 = v1();
        if (r107 != null) goto L17;
    L19:
        boolean r108 = false;
    L20:
        IDoraWakeupService r109 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r109 != null) goto L23;
    L25:
        boolean r110 = false;
    L26:
        if (r110 == true) goto L31;
        if (r105 == true) goto L30;
        if (r106 == true) goto L30;
        if (r108 == false) goto L31;
    L30:
        r101 = true;
    L31:
        g49.d.d("DoraServiceImpl", "shouldSkipObricLogic, skipObricLogic: " + r101 + ", isInRadioPressing: " + r110 + ", isAppOnForeground: " + this.f331928k0 + ", isInDoraSettingsPage: " + r105 + ", isDoraSettingsPageInStack: " + r104 + ", isAssistantChatWindowShowing: " + r102 + ", isOnboarding: " + r106 + ", isDeviceRecording: " + r108);
        return r101;
    L23:
        if (r109.o() != true) goto L25;
        r110 = true;
        goto L26
    L17:
        if (r107.Y0() != true) goto L19;
        r108 = true;
    L13:
        r105 = false;
        goto L14
    L5:
        if (r100.e() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean J0() {
        StringBuilder r100 = new StringBuilder("isOnboarding = ");
        boolean r101 = com.larus.dora.impl.onboarding.d.f336616a;
        r100.append(com.larus.dora.impl.onboarding.d.f336617b);
        g49.d.d("DoraServiceImpl", r100.toString());
        return com.larus.dora.impl.onboarding.d.f336617b;
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean K0() {
        if (L1("isVideoLiveAIPreInitEnabled") == DoraXLinkTransportMode.OFF) goto L5;
        return true;
    L5:
        return false;
    }

    public final void K1() {
        if (this.P.get() == true) goto L5;
        return;
    L5:
        if (com.larus.platform.service.o.f365780a.getDeviceId().length() != 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L48;
        AuthModelDelegate r101 = AuthModelDelegate.f297134b;
        c1<com.larus.bmhome.auth.h0> r102 = r101.a().getValue();
        if (r102 == null) goto L44;
        com.larus.bmhome.auth.h0 r103 = r102.f295753d;
        if (r103 == null) goto L49;
        String r104 = DoraConfig.g();
        if (Intrinsics.areEqual(r104, r103.b()) == true) goto L18;
        return;
    L18:
        AccountService r105 = AccountService.f365697a;
        if (r105.isLogin().booleanValue() == false) goto L24;
        if (Intrinsics.areEqual(r103.h(), r105.getSecUserId()) == true) goto L24;
        return;
    L24:
        if (com.larus.platform.exp.o.b("dora_init_main_conversation") == false) goto L26;
        return;
    L26:
        wc9.e r106 = r101.y().getValue();
        if (r106 == null) goto L45;
        String r107 = r106.f559198a;
        if (r107 != null) goto L31;
        return;
    L31:
        if ((true ^ StringsKt.isBlank(r107)) == true) goto L34;
        r107 = null;
    L34:
        if (r107 != null) goto L36;
        return;
    L36:
        if (Intrinsics.areEqual(this.G, r107) == false) goto L38;
        return;
    L38:
        this.G = r107;
        IDoraAVLinkService r108 = v1();
        if (r108 == null) goto L41;
        r108.z(r107);
    L41:
        DoraAVLinkDelegate.f291640b.k(r104, r107);
        return;
    L45:
        return;
    L49:
        return;
    L44:
        return;
    L48:
        return;
    L7:
        r100 = false;
        goto L8
    }

    @Override // com.larus.dora.api.IDoraService
    public final int O() {
        com.larus.dora.impl.util.b0.f338123a.getClass();
        return com.larus.dora.impl.util.b0.c();
    }

    @Override // com.larus.dora.api.IDoraService
    public final String P() {
        BotModel r100 = this.F;
        if (r100 == null) goto L7;
        SpeakerVoice r101 = r100.getVoiceType();
        if (r101 == null) goto L7;
        return r101.getStyleId();
    L7:
        return null;
    }

    @Override // com.larus.dora.api.IDoraService
    public final String Q0() {
        int r100 = DoraPreWakeUpTask.f331888d;
        return DoraPreWakeUpTask.Companion.j();
    }

    @Override // com.larus.dora.api.IDoraService
    public final IDoraService.j S() {
        return (IDoraService.j) this.f331923g.getValue();
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean T() {
        String r100 = AccountService.f365697a.getUserId();
        com.larus.dora.impl.util.b0.f338123a.getClass();
        boolean r101 = com.larus.dora.impl.util.b0.p(r100);
        boolean r102 = com.larus.dora.impl.util.b0.u(r100);
        DoraWifiLinkWrapper.f332292a.getClass();
        DoraWifiLinkWrapper.a r103 = DoraWifiLinkWrapper.n();
        com.larus.dora.impl.core.settingsconfig.c r104 = com.larus.dora.impl.core.settingsconfig.c.f332267a;
        boolean r105 = r103.a();
        r104.getClass();
        DoraXLinkTransportMode r106 = com.larus.dora.impl.core.settingsconfig.c.d(r101, r102, r105);
        String r107 = com.larus.dora.impl.core.settingsconfig.c.a();
        IDoraService r108 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r108 == null) goto L9;
        DeviceService r109 = r108.device();
        if (r109 == null) goto L9;
        if (r109.n0("rtc") != true) goto L9;
        boolean r110 = true;
    L10:
        g49.d.d("DoraServiceImpl", "isVideoLiveAIEnabled: isBluetoothRTCEnabled=" + r101 + ", isP2PRTCEnabled=" + r102 + ", hasPermissions=" + r103.f332301a + ", hasP2PRTCAbility=" + r103.f332302b + ", p2pRuntimeSupported=" + r103.a() + ", xLinkMode=" + r106 + ", isAbilitySupported=" + r110 + ", xLinkConfig=[" + r107 + ']');
        if (r106 == DoraXLinkTransportMode.OFF) goto L15;
        if (r110 == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L9:
        r110 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.dora.impl.DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1] */
    @Override // com.larus.dora.api.IDoraService
    public final DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1 U0() {
        final b1 r100 = com.larus.dora.impl.ota.b.f337425c;
        return new DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1(r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final int W0() {
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L8;
        q38.a r101 = r100.getAccountInfo();
        if (r101 == null) goto L8;
        String r102 = r101.f531530c;
        if (r102 == null) goto L8;
    L10:
        if (r102.length() <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        return com.larus.dora.impl.util.b0.o(r102);
    L16:
        return 0;
    L12:
        r103 = false;
    L8:
        r102 = "";
        goto L10
    }

    @Override // com.larus.dora.api.IDoraService
    public final List<String> a() {
        return new ArrayList();
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean b() {
        DoraVoiceWakeupStateManager r100 = DoraVoiceWakeupStateManager.f332171a;
        return DoraVoiceWakeupStateManager.f332175e;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void b1() {
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L8;
        q38.a r101 = r100.getAccountInfo();
        if (r101 == null) goto L8;
        String r102 = r101.f531530c;
        if (r102 == null) goto L8;
    L10:
        if (r102.length() <= 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        Intrinsics.checkNotNullParameter(r102, "uid");
        int r104 = com.larus.dora.impl.util.b0.o(r102);
        com.larus.dora.impl.util.b0.j().storeInt(r102.concat("_dora_newcomer_wakeup_count"), r104 + 1);
        return;
    L16:
        return;
    L12:
        r103 = false;
    L8:
        r102 = "";
        goto L10
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean c() {
        CopyOnWriteArrayList<h49.k> r100 = h49.a.f483780a;
        g49.d.d("DoraAudioManager", "lastConnectState:" + h49.a.f483781b + ", lastWakeState:" + h49.a.f483782c + ", lastWakeMode: " + h49.a.f483783d + ", lastQueryState: " + h49.a.f483784e);
        if (h49.a.f483783d != 11) goto L10;
        if (h49.a.f483782c == 2) goto L7;
    L12:
        return false;
    L7:
        if (h49.a.f483784e != 8) goto L12;
    L11:
        return true;
    L10:
        if (h49.a.f483782c != 2) goto L12;
        goto L11
    }

    @Override // com.larus.dora.api.IDoraService
    public final void c0() {
        DoraBuryPointManager r100 = DoraBuryPointManager.f331862a;
        r100.getClass();
        DoraBuryPointManager.J(r100, "stop_listen", MapsKt.mapOf(TuplesKt.to(com.alipay.sdk.m.p.e.f25671s, "voice")), false, 12);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void c1() {
        CopyOnWriteArraySet<h49.m> r100 = t69.g.f544683a;
        AppHost.Companion r101 = AppHost.f326268a;
        r101.a().j(new t69.d());
        kj4.a.g().registerDoraLinkCallback(new t69.c());
        kj4.a.g().k(new t69.e());
        kj4.a.g().l(new t69.f());
        t69.b r102 = t69.b.f544679a;
        monitor-enter(r102);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (t69.b.f544680b == false) goto L8;
        monitor-exit(r102);
    L10:
        CopyOnWriteArraySet<h49.e> r103 = t69.m.f544692a;
        kj4.a.g().registerDoraLinkCallback(new t69.l());
        CopyOnWriteArraySet<h49.c> r104 = t69.i.f544688a;
        kj4.a.g().k(new t69.h());
        final com.larus.dora.impl.device.battery.e r105 = com.larus.dora.impl.device.battery.e.f333599m.a();
        com.larus.dora.impl.device.battery.e.f333600n = r101.getApplication().getString(R.string.larus_dora_g_case_notification_channel);
        g49.d.d("DoraChargingCaseNotificationManager", "init ==");
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.device.battery.a(r105));
        kj4.a.g().k(new com.larus.dora.impl.device.battery.f(r105));
        LocalBroadcastManager.getInstance(r101.getApplication()).registerReceiver(new DoraChargingCaseNotificationManager$init$3(r105), new IntentFilter("action.DEVICE_UNBIND"));
        AccountService.f365697a.E(new com.larus.dora.impl.device.battery.g(r105));
        return;
    L8:
        kj4.a.g().k(new t69.a());     // Catch: Throwable -> L12
        t69.b.f544680b = true;     // Catch: Throwable -> L12
        monitor-exit(r102);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    @Override // com.larus.dora.api.IDoraService
    public final int d0() {
        CopyOnWriteArraySet<h49.m> r100 = t69.g.f544683a;
        ?? r101 = t69.g.f544684b;
        int r102 = r101;
        if (t69.g.f544685c == false) goto L5;
        r102 = r101 + 1;
    L5:
        FLogger.f375446a.i("DoraWearStatusManager", "getWearCount: " + r102);
        return r102;
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean e0() {
        com.larus.dora.impl.util.b0.f338123a.getClass();
        return com.larus.dora.impl.util.b0.s();
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean f() {
        DoraSetting.f338023a.getClass();
        return DoraSetting.f();
    }

    @Override // com.larus.dora.api.IDoraService
    public final a1 getDoraXLinkCommonConfig() {
        e10 r100 = e10.f368561a;
        nu9.o r101 = e10.Q();
        nu9.a r102 = r101.a();
        hq9.g r103 = null;
        b5 r104 = null;
        hq9.b1 r105 = null;
        if (r102 == null) goto L42;
        nu9.b r106 = r102.a();
        if (r106 == null) goto L8;
        nu9.a0 r107 = r106.a();
    L9:
        nu9.q r108 = r102.b();
        if (r108 == null) goto L12;
        nu9.b0 r109 = r108.b();
    L13:
        if (r107 == null) goto L15;
        Boolean r110 = r107.a();
    L16:
        if (r110 != null) goto L43;
        if (r107 == null) goto L19;
        List<String> r111 = r107.b();
    L20:
        if (r111 != null) goto L43;
        if (r109 == null) goto L23;
        Boolean r112 = r109.c();
    L24:
        if (r112 != null) goto L43;
        if (r109 == null) goto L27;
        Boolean r113 = r109.d();
    L28:
        if (r113 != null) goto L43;
        if (r109 == null) goto L31;
        String r114 = r109.e();
    L32:
        if (r114 != null) goto L43;
        if (r109 == null) goto L35;
        String r115 = r109.b();
    L36:
        if (r115 != null) goto L43;
        if (r109 == null) goto L39;
        String r116 = r109.a();
    L40:
        if (r116 == null) goto L42;
    L39:
        r116 = null;
        goto L40
    L35:
        r115 = null;
        goto L36
    L31:
        r114 = null;
        goto L32
    L27:
        r113 = null;
        goto L28
    L23:
        r112 = null;
        goto L24
    L19:
        r111 = null;
    L43:
        boolean r117 = true;
    L44:
        if (r117 == false) goto L114;
    L91:
        nu9.a r118 = r101.a();
        if (r118 == null) goto L113;
        nu9.b r119 = r118.a();
        if (r119 == null) goto L104;
        nu9.a0 r120 = r119.a();
        if (r120 == null) goto L102;
        Boolean r121 = r120.a();
        List<String> r122 = r120.b();
        if (r122 == null) goto L100;
        List r123 = CollectionsKt.filterNotNull(r122);
    L101:
        g4 r124 = new g4(r121, r123);
    L103:
        hq9.d0 r125 = new hq9.d0(r124);
    L105:
        nu9.q r126 = r118.b();
        if (r126 == null) goto L111;
        nu9.b0 r127 = r126.b();
        if (r127 == null) goto L110;
        r104 = new b5(r127.c(), r127.d(), r127.e(), r127.b(), r127.a());
    L110:
        r105 = new hq9.b1(r104);
    L111:
        r103 = new hq9.g(r125, r105);
        goto L113
    L100:
        r123 = null;
        goto L101
    L102:
        r124 = null;
        goto L103
    L104:
        r125 = null;
    L113:
        return new a1(r103);
    L114:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L83
        kj4.a.g().getClass();     // Catch: Throwable -> L83
        kk4.b.a r129 = kj4.a.f().f503781a;     // Catch: Throwable -> L83
        if (r129 == null) goto L48;
        kk4.b.a r130 = new kk4.b.a(r129.f503782a, r129.f503783b);     // Catch: Throwable -> L83
    L49:
        if (r130 != null) goto L51;
        a1 r131 = new a1(null);     // Catch: Throwable -> L83
    L81:
        Object r132 = Result.m9449constructorimpl(r131);     // Catch: Throwable -> L83
    L86:
        if (Result.m9455isFailureimpl(r132) == false) goto L88;
        r132 = null;
    L88:
        a1 r133 = (a1) r132;
        if (r133 == null) goto L91;
        return r133;
    L51:
        kk4.b.C6566b r134 = r130.f503782a;     // Catch: Throwable -> L83
        if (r134 == null) goto L54;
        kk4.b.C6566b r135 = new kk4.b.C6566b(r134.f503784a);     // Catch: Throwable -> L83
    L55:
        kk4.b.c r136 = r130.f503783b;     // Catch: Throwable -> L83
        if (r136 == null) goto L58;
        kk4.b.c r137 = new kk4.b.c(r136.f503785a);     // Catch: Throwable -> L83
    L59:
        if (r135 == null) goto L70;
        kk4.b.d r138 = r135.f503784a;     // Catch: Throwable -> L83
        if (r138 == null) goto L63;
        kk4.b.d r139 = new kk4.b.d(r138.f503786a, r138.f503787b);     // Catch: Throwable -> L83
    L64:
        if (r139 == null) goto L70;
        Boolean r140 = r139.f503786a;     // Catch: Throwable -> L83
        if (r139.f503787b == null) goto L68;
        ArrayList r141 = new ArrayList(r139.f503787b);     // Catch: Throwable -> L83
    L69:
        g4 r142 = new g4(r140, r141);     // Catch: Throwable -> L83
    L71:
        hq9.d0 r143 = new hq9.d0(r142);     // Catch: Throwable -> L83
        if (r137 == null) goto L79;
        kk4.b.e r144 = r137.f503785a;     // Catch: Throwable -> L83
        if (r144 == null) goto L76;
        kk4.b.e r145 = new kk4.b.e(r144.f503788a, r144.f503789b, r144.f503790c, r144.f503791d, r144.f503792e);     // Catch: Throwable -> L83
    L77:
        if (r145 == null) goto L79;
        b5 r146 = new b5(r145.f503788a, r145.f503789b, r145.f503790c, r145.f503791d, r145.f503792e);     // Catch: Throwable -> L83
    L80:
        r131 = new a1(new hq9.g(r143, new hq9.b1(r146)));     // Catch: Throwable -> L83
        goto L81
    L76:
        r145 = null;
    L79:
        r146 = null;
        goto L80
    L68:
        r141 = null;
        goto L69
    L63:
        r139 = null;
    L70:
        r142 = null;
        goto L71
    L58:
        r137 = null;
        goto L59
    L54:
        r135 = null;
        goto L55
    L48:
        r130 = null;
    L83:
        th = move-exception;
        Result.Companion r147 = Result.Companion;
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L86
    L15:
        r110 = null;
        goto L16
    L12:
        r109 = null;
        goto L13
    L8:
        r107 = null;
    L42:
        r117 = false;
        goto L44
    }

    @Override // com.larus.dora.api.IDoraService
    public final int h() {
        CopyOnWriteArrayList<h49.k> r100 = h49.a.f483780a;
        return h49.a.f483782c;
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean i0() {
        if (L1("isVideoLiveAIPreInitP2PEnabled") != DoraXLinkTransportMode.WIFI) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void i1() {
        this.f331925i.c(DoraResourceSyncTrigger.PAGE_ENTRY);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void init() {
        if (V0.getAndSet(true) == false) goto L6;
        g49.d.d("DoraServiceImpl", "already Init == ");
        return;
    L6:
        AudioManager r110 = null;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C110691(this, null), 3, null);
        AppHost.Companion r100 = AppHost.f326268a;
        r100.a().j(this.f331934p0);
        g49.d.d("DoraServiceImpl", "doraInit");
        ObricDoraDelegate.f392872b.d(r100.getApplication());
        int r101 = n59.b.f518049a;
        g49.d.d("CloudReportRuleStrategy", "registerCloudGetLog");
        n59.a r102 = new n59.a();
        if (x8a.c.f562940k == false) goto L9;
        x8a.c.b().e(r102);
    L10:
        DoraMinorManager r103 = DoraMinorManager.f332157a;
        g49.d.d("DoraMinorManager", "init: registerMinorStatusCallback");
        IMinorService r104 = (IMinorService) ServiceManager.get().getService(IMinorService.class);
        if (r104 == null) goto L13;
        r104.k(r103, Boolean.FALSE);
    L13:
        DoraSetting.f338023a.getClass();
        DoraSetting.f338024b = true;
        com.larus.dora.impl.util.u0.f338159a.execute(new q0());
        AccountService r105 = AccountService.f365697a;
        r105.E(new r0(this));
        DoraResourceSyncManager r106 = this.f331925i;
        if (r106.f337826c.compareAndSet(false, true) == false) goto L17;
        r100.a().j(r106);
        r106.c(DoraResourceSyncTrigger.COLD_START);
    L17:
        DoraVoiceCallMonitor r107 = DoraVoiceCallMonitor.f331961a;
        g49.d.a("DoraVoiceCallMonitor", "start");
        kj4.a r108 = kj4.a.g();
        ((CopyOnWriteArraySet) r108.f503708c.f514227b).add(r107);
        r108.registerDoraLinkCallback(new v0());
        r108.registerDoraVoiceCallback(new w0());
        pk4.j.f529629a = new com.larus.dora.impl.util.k0();
        pk4.l.f529633a = DoraBuryPointManager.f331862a;
        n0 r109 = new n0();
        pk4.c r111 = pk4.c.a.f529617a;
        pk4.c.f529616a = r109;
        y1.b.f565609a = new com.larus.dora.impl.util.b();
        DoraSystemInfoManager r112 = DoraSystemInfoManager.f338056a;
        DoraSystemInfoManager.d();
        CoroutineScope r113 = com.larus.dora.impl.core.i.f332199a;
        if (com.larus.dora.impl.core.i.f332200b == false) goto L20;
        g49.d.d("DoraBatterySyncManager", "init: already initialized");
    L21:
        DoraOTAManagement r114 = DoraOTAManagement.f334138a;
        DoraOTAManagement.Q = new com.larus.dora.impl.device.ota.e0();
        DoraDevice r115 = DoraAdapterExtKt.h(kj4.a.g());
        if (r115 != null) goto L24;
    L34:
        kj4.a.g().registerDoraLinkCallback(new DoraOTAManagement$listenerDoraLink$4());
        kj4.a.g().k(DoraOTAManagement.Q);
        Map<String, String> r116 = com.larus.dora.impl.core.l0.f332216a;
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.core.k0());
        CoroutineScope r117 = DoraSyncManager.f332165a;
        int r118 = com.larus.utils.l0.f375430a;
        boolean r119 = ((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new com.larus.dora.impl.settings.w())).booleanValue();
        g49.d.d("DoraSyncManager", "init: isSyncStatusFeatureEnabled=" + r119);
        if (r119 == false) goto L51;
        r105.E(new com.larus.dora.impl.core.u0());
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.core.v0());
        DoraSyncManager.c("2");
        if (DoraSyncManager.f332167c == null) goto L162;
        g49.d.d("DoraSyncManager", "registerNetworkCallback: networkCallback already registered");
        goto L51
    L162:
        ConnectivityManager r120 = (ConnectivityManager) ContextCompat.getSystemService(r100.getApplication(), ConnectivityManager.class);     // Catch: Exception -> L49
        com.larus.dora.impl.core.w0 r121 = DoraSyncManager.f332167c;     // Catch: Exception -> L156
        if (r121 == null) goto L44;
        if (r120 == null) goto L44;
        r120.unregisterNetworkCallback(r121);     // Catch: Exception -> L156
    L44:
        com.larus.dora.impl.core.w0 r122 = new com.larus.dora.impl.core.w0();     // Catch: Exception -> L49
        NetworkRequest r123 = new NetworkRequest.Builder().addCapability(12).build();     // Catch: Exception -> L49
        g49.d.d("DoraSyncManager", "registerNetworkCallback");     // Catch: Exception -> L49
        if (r120 == null) goto L47;
        r120.registerNetworkCallback(r123, r122);     // Catch: Exception -> L49
    L47:
        DoraSyncManager.f332167c = r122;     // Catch: Exception -> L49
    L49:
        e = move-exception;
        g49.d.d("DoraSyncManager", "registerNetworkCallback failed. msg : " + e.getMessage());
    L51:
        com.larus.dora.impl.core.v r124 = com.larus.dora.impl.core.v.f332284a;
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.core.u());
        DoraSettingsConfigManager.f332259a.getClass();
        DoraSettingsConfigManager.b();
        sk4.e r125 = com.larus.dora.impl.core.o0.f332223a;
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.core.n0());
        DoraUserSettingsManager.f336185a.e();
        DoraWakeupKeywordsHandler.b();
        DoraBuryPointManager r126 = DoraBuryPointManager.f331862a;
        r126.getClass();
        ((CopyOnWriteArraySet) kj4.a.g().f503708c.f514227b).add(r126);
        kj4.a.g().k(new com.larus.dora.impl.i());
        kj4.a.g().registerDoraLinkCallback(new DoraBuryPointManager$init$doraLinkCallback$1());
        if (com.larus.dora.impl.util.s.a() == false) goto L54;
        r126.z();
    L54:
        IApplog.f287053a.p();
        Iterator r127 = DoraBuryPointManager.x().entrySet().iterator();
    L56:
        if (r127.hasNext() == false) goto L58;
        Map.Entry r128 = (Map.Entry) r127.next();
        IApplog.f287053a.a((String) r128.getKey(), r128.getValue());
        goto L56
    L58:
        ScreenStateManager r129 = ScreenStateManager.f360254a;
        ScreenStateManager.a(r126);
        DoraLogManager r130 = DoraLogManager.f336045a;
        g49.d.a("DoraLogManager", "init");
        DoraLogManager.x();
        kj4.a r131 = kj4.a.g();
        ((CopyOnWriteArraySet) r131.f503708c.f514227b).add(r130);
        r131.registerDoraLinkCallback(new com.larus.dora.impl.log.i());
        r131.registerDoraVoiceCallback(new com.larus.dora.impl.log.j());
        r131.k(new com.larus.dora.impl.log.l());
        DoraResourceUtil r132 = DoraResourceUtil.f338111a;
        DoraResourceUtil.j();
        DoraUserManager r133 = DoraUserManager.f332169a;
        DoraUserManager.a();
        IDoraGuideService r134 = (IDoraGuideService) ServiceManager.get().getService(IDoraGuideService.class);
        if (r134 == null) goto L61;
        r134.init();
    L61:
        com.larus.dora.impl.network.l.f336164a.getClass();
        IFlowSdkDepend r135 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r135 != null) goto L64;
        p1 r136 = null;
    L69:
        com.larus.dora.impl.network.l.f336165b = r136;
        if (r136 == null) goto L72;
        r136.b(com.larus.dora.impl.network.l.f336169f);
    L72:
        p2 r137 = com.larus.dora.impl.network.l.f336165b;
        if (r137 == null) goto L75;
        r137.i(com.larus.dora.impl.network.l.f336170g);
    L75:
        int r138 = DoraPreWakeUpTask.f331888d;
        g49.d.a("DoraPreWakeUpTask", "onAppStart");
        kj4.a.g().k(DoraPreWakeUpTask.f331889e);
        DoraDevice r139 = DoraAdapterExtKt.h(kj4.a.g());
        if (r139 == null) goto L82;
        int[] r140 = r139.idleState;
        if (r140 == null) goto L82;
        Integer r141 = ArraysKt.getOrNull(r140, 0);
        if (r141 == null) goto L82;
        int r142 = r141.intValue();
    L83:
        DoraPreWakeUpTask.f331888d = r142;
        if (kj4.a.g().getDoraBondCount() <= 0) goto L86;
        DoraPreWakeUpTask.Companion.l();
    L86:
        BuildersKt.launch$default(DoraPreWakeUpTask.f331895k, null, null, new DoraPreWakeUpTask$Companion$setModelPathPropertyAsync$1(null), 3, null);
        DoraPreWakeUpTask.Companion.NetworkChangeReceiver r143 = new DoraPreWakeUpTask.Companion.NetworkChangeReceiver();
        IntentFilter r144 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        Application r145 = AppHost.f326268a.getApplication();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L158;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L158:
    L111:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L155;
        ReceiverRegisterCrashOptimizer.registerReceiver(r143, r144);
    L115:
        AppHost.Companion r146 = AppHost.f326268a;
        r146.a().j(new w());
        com.larus.dora.impl.network.l r147 = com.larus.dora.impl.network.l.f336164a;
        com.larus.dora.impl.network.l.a r148 = new DoraPreWakeUpTask$Companion$listenMultiUserModeUpdate$1();
        r147.getClass();
        Intrinsics.checkNotNullParameter(r148, "listener");
        com.larus.dora.impl.network.l.f336166c.add(r148);
        v r149 = new v();
        Intrinsics.checkNotNullParameter(r149, "listener");
        com.larus.dora.impl.network.l.f336167d.add(r149);
        SAMICore.RegisterWakeupParamRequestCallback(new DoraPreWakeUpTask.Companion.a());
        DoraVoiceWakeupStateManager r150 = DoraVoiceWakeupStateManager.f332171a;
        kj4.a.g().registerDoraLinkCallback(new y0());
        DoraOTAManager.f337359a.getClass();
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.ota.f());
        ((gk4.g) DoraOTAManager.f337365g.getValue()).a(new com.larus.dora.impl.ota.i());
        G2OtaFacade.INSTANCE.getClass();
        G2OtaFacade.B();
        DoraSceneManager r151 = DoraSceneManager.f332159a;
        DoraSceneManager.c();
        ck4.a r152 = ck4.a.C0455a.f24033a;
        n59.c r153 = new n59.c();
        if (((ArrayList) r152.f24032a).contains(r153) == true) goto L118;
        ((ArrayList) r152.f24032a).add(r153);
    L118:
        QuickNoteRepo.f335241a.d();
        GestureSettingsRepository.f334402a.e();
        GestureWakeupRepository.f334505a.h();
        CoroutineScope r154 = com.larus.dora.impl.core.f0.f332195a;
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.core.e0());
        final AbilityService r155 = this.f331926j;
        r155.getClass();
        kj4.a.g().registerProtocolInfoCallback(new com.larus.dora.impl.serviceimpl.b(r155), true);
        DoraFileUploaderImpl r156 = DoraLogFileTransferCoordinator.f335728j;
        r156.getClass();
        r146.a().j(new com.larus.dora.impl.file.upload.b(r156));
        IDoraService r157 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r157 == null) goto L121;
        r157.L0(new com.larus.dora.impl.file.upload.c(r156));
    L121:
        kj4.a.g().k(new com.larus.dora.impl.file.p());
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.file.q());
        com.larus.dora.impl.file.r r158 = new com.larus.dora.impl.file.r();
        int r159 = com.larus.dora.impl.frameassembler.e.f335807m;
        com.larus.dora.impl.frameassembler.e.a r160 = new com.larus.dora.impl.frameassembler.e.a();
        r160.f335820a = 10000;
        final DoraAggregateFrameAssembler r161 = new DoraAggregateFrameAssembler(new com.larus.dora.impl.frameassembler.e(r160), r158);
        ((CopyOnWriteArraySet) vj4.b.a.f555417a.f555414a).add(new com.larus.dora.impl.file.o(r161));
        DoraBTOptimizationManager r162 = DoraBTOptimizationManager.f332126a;
        if (DoraBTOptimizationManager.f332127b.compareAndSet(false, true) == false) goto L125;
        g49.d.d("DoraBTOptimizationManager", "init: registerHeartbeatCallback");
        DoraBTOptimizationManager.a().registerDoraLinkCallback(new com.larus.dora.impl.core.g());
    L125:
        if (com.larus.dora.impl.core.o.f332222c.compareAndSet(false, true) == true) goto L127;
        g49.d.e("DoraBtStatusManager", "init already called, ignore repeated call");
    L128:
        com.larus.dora.impl.bridge.g.f332074a.d();
        if (com.larus.dora.impl.util.s.a() == false) goto L131;
        y1();
    L131:
        DoraSetting.f338023a.getClass();
        int r163 = com.larus.utils.l0.f375430a;
        boolean r164 = ((Boolean) com.larus.utils.l0.a(Boolean.FALSE, new com.larus.dora.impl.settings.a1())).booleanValue();
        g49.d.d("DoraServiceImpl", "doraInit dumpAllLog enabled=" + r164);
        pk4.e.f529620a = r164;
        Object r165 = r146.getApplication().getSystemService("audio");     // Catch: Throwable -> L152
        if ((r165 instanceof AudioManager) == false) goto L135;
        r110 = (AudioManager) r165;     // Catch: Throwable -> L152
    L135:
        this.f331943y = r110;     // Catch: Throwable -> L152
        if (r110 != null) goto L138;
        g49.d.b("DoraServiceImpl", "failed to get AudioManager");     // Catch: Throwable -> L152
        return;
    L138:
        this.B = w1();     // Catch: Throwable -> L152
        AudioManager r166 = this.f331943y;     // Catch: Throwable -> L144
        if (r166 == null) goto L146;
        int r167 = r166.getStreamMaxVolume(3);     // Catch: Throwable -> L144
    L147:
        this.C = r167;     // Catch: Throwable -> L152
        if (r167 > 0) goto L150;
        this.C = 15;     // Catch: Throwable -> L152
    L150:
        g49.d.d("DoraServiceImpl", "initial system volume: " + this.B);     // Catch: Throwable -> L152
        C1(this.B);     // Catch: Throwable -> L152
        this.f331944z = new c(this);     // Catch: Throwable -> L152
        IntentFilter r168 = new IntentFilter();     // Catch: Throwable -> L152
        r168.addAction("android.media.VOLUME_CHANGED_ACTION");     // Catch: Throwable -> L152
        ContextCompat.registerReceiver(AppHost.f326268a.getApplication(), this.f331944z, r168, 2);     // Catch: Throwable -> L152
        g49.d.d("DoraServiceImpl", "volume broadcast receiver registered successfully");     // Catch: Throwable -> L152
        return;
    L146:
        r167 = 15;
    L144:
        th = move-exception;
        g49.d.c("DoraServiceImpl", "get max volume failed: " + th.getMessage(), th);     // Catch: Throwable -> L152
    L152:
        th = move-exception;
        g49.d.c("DoraServiceImpl", "init volume listener failed: " + th.getMessage(), th);
        return;
    L127:
        g49.d.d("DoraBtStatusManager", "init: register dora buds and link callback");
        kj4.a.g().k(new com.larus.dora.impl.core.m());
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.core.n());
        goto L128
    L155:
        throw e;
    L91:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L102;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r144) == false) goto L102;
        int r169 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r143, r144, 0, null, null, 2, r145).result;     // Catch: Exception -> L111
        if (r169 == 1) goto L100;
        if (r169 == 2) goto L99;
        if (r169 == 3) goto L157;
        r145.registerReceiver(r143, r144);     // Catch: Exception -> L111
    L157:
        goto L115
    L99:
        new Intent();     // Catch: Exception -> L111
        goto L157
    L100:
        r145.registerReceiver(r143, r144);     // Catch: Exception -> L111
    L102:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L105;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L111
        r145.registerReceiver(r143, r144, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L111
        goto L157
    L105:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L107;
    L109:
        r145.registerReceiver(r143, r144);     // Catch: Exception -> L111
        goto L157
    L107:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r144) == false) goto L109;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L111
        ContextCompat.registerReceiver(r145, r143, r144, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L111
    L82:
        r142 = 0;
        goto L83
    L64:
        if (AppHost.f326268a.isOversea() == false) goto L66;
        int r170 = 134217794;
    L67:
        r136 = r135.B(r170);
        goto L69
    L66:
        r170 = 33554789;
        goto L67
    L24:
        if (o59.a.p(r115) == false) goto L27;
        g49.d.d("DoraOTAManagement", "listenerDoraLink, ignore doraG device");
    L27:
        if ((!o59.a.p(r115)) == true) goto L30;
        r115 = null;
    L30:
        if (r115 == null) goto L34;
        g49.d.d("DoraOTAManagement", "listenerDoraLink, get device");
        DoraOTAManagement.A = true;
        DoraOTAManagement.m(OTAUpdateFrom.DoraLinkStateChanged.getScene());
        com.larus.dora.impl.device.ota.e0 r171 = DoraOTAManagement.Q;
        if (r171 == null) goto L34;
        r171.a1(null, new mj4.b(0, -1));
        goto L34
    L20:
        g49.d.d("DoraBatterySyncManager", "init: register battery sync callback");
        kj4.a.g().k(new com.larus.dora.impl.core.h());
        com.larus.dora.impl.core.i.f332200b = true;
        goto L21
    L9:
        x8a.c.f562939j = r102;
        goto L10
    }

    @Override // com.larus.dora.api.IDoraService
    public final void m() {
        x0 r100 = x0.f338309a;
        monitor-enter(r100);
        monitor-exit(r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void onAsrEnd() {
        DoraBuryPointManager.f331862a.getClass();
        DoraBuryPointManager.f331869h = System.currentTimeMillis();
    }

    @Override // com.larus.dora.api.IDoraService
    public final a49.k p0() {
        QuickNoteRepo.f335241a.getClass();
        com.larus.dora.impl.network.z r100 = QuickNoteRepo.f335244d;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.c();
    L6:
        if (r100 == null) goto L8;
        String r103 = r100.e();
    L9:
        if (r100 == null) goto L11;
        String r104 = r100.b();
    L12:
        if (r100 == null) goto L15;
        r101 = r100.d();
    L15:
        return new a49.k(r102, r103, r104, r101);
    L11:
        r104 = null;
        goto L12
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.dora.api.IDoraService
    public final int q() {
        CopyOnWriteArrayList<h49.k> r100 = h49.a.f483780a;
        return h49.a.f483783d;
    }

    @Override // com.larus.dora.api.IDoraService
    public final int r() {
        CopyOnWriteArrayList<h49.k> r100 = h49.a.f483780a;
        return h49.a.f483784e;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void r0() {
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L7;
        g49.d.d("DoraServiceImpl", "initCompanionDeviceManager: skip in enterprise mode");
        return;
    L7:
        if (this.Y.compareAndSet(false, true) == true) goto L9;
        return;
    L9:
        z2 r100 = z2.f365865a;
        boolean r101 = r100.getDoraCdmFeatureSwitchConfig();
        g49.d.d("DoraServiceImpl", "cdm switch is: " + r101);
        IFlowCompanionDeviceManager r102 = (IFlowCompanionDeviceManager) ServiceManager.get().getService(IFlowCompanionDeviceManager.class);
        if (r102 == null) goto L12;
        r102.h(new h(r101));
    L12:
        boolean r103 = r100.getDoraCdmDisableConfig();
        g49.d.d("DoraServiceImpl", "cdm is disabled: " + r103);
        if (r103 == false) goto L29;
        if (r102 == null) goto L26;
        List<String> r104 = r102.l();
        if (r104 == null) goto L26;
        Iterator<T> r105 = r104.iterator();
    L19:
        if (r105.hasNext() == false) goto L26;
        String r106 = (String) r105.next();
        if (r102.b(r106) == false) goto L24;
        r102.a(r106);
    L24:
        if (r102.m(r106) == false) goto L19;
        r102.d(r106);
    L26:
        if (r102 == null) goto L39;
        r102.f();
        return;
    L39:
        return;
    L29:
        if (r102 == null) goto L31;
        r102.i(this.E);
    L31:
        if (r102 == null) goto L40;
        r102.e(new i());
        return;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void s0() {
        g49.d.d("DoraServiceImpl", "requestPreWakeupModelDownload");
        int r100 = DoraPreWakeUpTask.f331888d;
        DoraPreWakeUpTask.Companion.l();
    }

    @Override // com.larus.dora.api.IDoraService
    public final int t() {
        e10 r100 = e10.f368561a;
        int r101 = com.larus.utils.l0.f375430a;
        return ((Number) com.larus.utils.l0.a(10000, new c7())).intValue();
    }

    @Override // com.larus.dora.api.IDoraService
    public final void t0() {
        String r100 = ILoginService.f286097a.getAccountInfo().f531530c;
        if (com.larus.utils.o0.d(r100) == false) goto L8;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (com.larus.dora.impl.util.b0.j().getBoolean("dora_settings_first_use_simul_interpret" + r100, true) == false) goto L9;
        Intrinsics.checkNotNullParameter(r100, "uid");
        com.larus.dora.impl.util.b0.j().storeBoolean("dora_settings_first_use_simul_interpret".concat(r100), false);
        LocalBroadcastManager.getInstance(AppHost.f326268a.getApplication()).sendBroadcast(new Intent("action.DEVICE_ENTER_SIMUL_INTERPRET"));
        return;
    L9:
        return;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void u0() {
        g49.e.a r100 = g49.e.f480009a;
        com.larus.dora.impl.util.e r101 = new com.larus.dora.impl.util.e();
        Intrinsics.checkNotNullParameter(r101, "callback");
        g49.e.f480009a = r101;
    }

    @Override // com.larus.dora.api.IDoraService
    public final String v0() {
        BotModel r100 = this.F;
        if (r100 == null) goto L7;
        SpeakerVoice r101 = r100.getVoiceType();
        if (r101 == null) goto L7;
        return com.larus.dora.impl.util.r.a(r101);
    L7:
        return null;
    }

    public final void y1() {
        if (this.f331942x.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.larus.dora.impl.network.e r100 = com.larus.dora.impl.network.e.f336163a;
        monitor-enter(r100);
        monitor-exit(r100);
        DoraBuryPointManager.f331862a.z();
        final VisionService r101 = this.f331921e;
        if (r101.f337991c.compareAndSet(false, true) == true) goto L11;
        FLogger.f375446a.i("VisionService", "init: already initialized, skip");
    L12:
        DoraResourceUtil r102 = DoraResourceUtil.f338111a;
        DoraResourceUtil.k();
        String r103 = o69.b.f522208a;
        g49.d.d("DoraGTimeSyncManager", "init");
        int r104 = yj4.g.f568093a;
        yj4.f r105 = yj4.f.a.f568092a;
        o69.a r106 = new o69.a();
        r105.getClass();
        ((CopyOnWriteArraySet) yj4.h.D2).add(r106);
        DoraGLogManager r107 = DoraGLogManager.f336103a;
        g49.d.d("DoraGLogManager", "DoraGLogManager init");
        kj4.a r108 = kj4.a.g();
        ((CopyOnWriteArraySet) r108.f503708c.f514227b).add(r107);
        r108.registerDoraLinkCallback(new com.larus.dora.impl.log.g.f());
        r108.registerDoraVoiceCallback(new com.larus.dora.impl.log.g.g());
        r108.k(new com.larus.dora.impl.log.g.h());
        DoraGGestureSettingsRepository r109 = DoraGGestureSettingsRepository.f334370a;
        kj4.a.g().registerDoraLinkCallback(new com.larus.dora.impl.device.settings.gesture.q());
        DoraEnvObserveManager.f334593a.getClass();
        if (DoraEnvObserveManager.f334597e.compareAndSet(false, true) == false) goto L19;
        kj4.a.g().registerDoraLinkCallback(new DoraEnvObserveManager$init$1());
        kj4.a.g().l(new com.larus.dora.impl.device.settings.lab.env.n());
        new Handler(Looper.getMainLooper()).post(new com.larus.dora.impl.device.settings.lab.env.d());
        Iterator<Function0<p49.a>> r110 = DoraEnvObserveManager.f334595c.iterator();
    L17:
        if (r110.hasNext() == false) goto L19;
        r110.next().invoke().a();
    L19:
        DoraImuDataManager.f336015a.getClass();
        g49.d.d("DoraImuDataManager", "DoraImuDataManager init, report enabled: " + DoraImuDataManager.i());
        if (DoraImuDataManager.i() == true) goto L22;
        g49.d.d("DoraImuDataManager", "IMU report is disabled, skip registering callbacks");
    L34:
        IDoraAVLinkService r111 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r111 != null) goto L37;
    L39:
        boolean r112 = false;
    L40:
        if (r112 == true) goto L43;
        return;
    L43:
        if (this.V.compareAndSet(false, true) == false) goto L61;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L47
        kj4.a.g().registerETPProcessor(this.X);     // Catch: Throwable -> L47
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
    L50:
        if (Result.m9456isSuccessimpl(r114) == false) goto L52;
        Unit r115 = (Unit) r114;
        FLogger.f375446a.i("DoraServiceImpl", "atomicFuncCallback ETP processor registered");
    L52:
        Throwable r116 = Result.m9452exceptionOrNullimpl(r114);
        if (r116 == null) goto L59;
        this.V.set(false);
        FLogger.f375446a.e("DoraServiceImpl", "atomicFuncCallback ETP processor register failed", r116);
        return;
    L59:
        return;
    L47:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    L61:
        return;
    L37:
        if (r111.P0() != true) goto L39;
        r112 = true;
        goto L40
    L22:
        if (DoraImuDataManager.f336024j.compareAndSet(false, true) == true) goto L24;
        g49.d.d("DoraImuDataManager", "DoraImuDataManager callbacks already registered");
        goto L34
    L24:
        zj4.a r118 = zj4.a.C8468a.f572461a;
        if (r118 == null) goto L27;
        ((CopyOnWriteArraySet) r118.f572454a).add(DoraImuDataManager.f336027m);
    L27:
        kj4.a r119 = kj4.a.g();
        if (r119 == null) goto L30;
        r119.registerDoraLinkCallback(DoraImuDataManager.f336028n);
    L30:
        kj4.a r120 = kj4.a.g();
        if (r120 == null) goto L34;
        r120.k(DoraImuDataManager.f336029o);
        goto L34
    L11:
        kj4.a.g().registerDoraLinkCallback(new VisionService$init$1(r101));
        kj4.a r121 = kj4.a.g();
        com.larus.dora.impl.serviceimpl.y r122 = new com.larus.dora.impl.serviceimpl.y(r101);
        Intrinsics.checkNotNullParameter(r121, "<this>");
        Intrinsics.checkNotNullParameter(r122, SocialConstants.PARAM_RECEIVER);
        ArrayMap<Integer, hk4.b> r123 = qk4.g.f533513j;
        ((CopyOnWriteArraySet) qk4.g.a.f533523a.f533518e).add(r122);
        goto L12
    }

    @Override // com.larus.dora.api.IDoraService
    public final String z() {
        BotModel r100 = this.F;
        if (r100 == null) goto L7;
        SpeakerVoice r101 = r100.getVoiceType();
        if (r101 == null) goto L7;
        String r102 = r101.getAudioMetrics();
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.larus.dora.api.IDoraService
    public final String z0() {
        int r100 = DoraPreWakeUpTask.f331888d;
        return DoraPreWakeUpTask.Companion.h();
    }

    /* JADX WARN: Type inference failed for: r0v43, types: [com.larus.dora.impl.g0] */
    /* JADX WARN: Type inference failed for: r0v48, types: [com.larus.dora.impl.DoraServiceImpl$doraLinkCallback$1] */
    public DoraServiceImpl() {
        this.f331919c = new SessionService();
        this.f331920d = new com.larus.dora.impl.serviceimpl.f();
        this.f331921e = new VisionService();
        this.f331922f = new DeviceService();
        this.f331923g = LazyKt.lazy(new e0());
        this.f331924h = new com.larus.dora.impl.serviceimpl.h(new AnonymousClass1(this));
        this.f331925i = new DoraResourceSyncManager(new DoraServiceImpl$resourceSyncManager$1(this));
        this.f331926j = new AbilityService();
        this.f331927k = new HealthService();
        this.f331929l = new NetworkService();
        this.f331930m = new r();
        this.f331931n = LazyKt.lazy(new f0());
        this.f331932o = new com.larus.dora.impl.serviceimpl.s();
        this.f331933p = new com.larus.dora.impl.serviceimpl.a();
        this.f331935q = new com.larus.dora.impl.serviceimpl.t();
        this.f331936r = new t39.c();
        this.f331937s = new CopyOnWriteArraySet();
        this.f331938t = new ConcurrentHashMap();
        this.f331939u = new CopyOnWriteArraySet();
        this.f331940v = new ConcurrentHashMap();
        this.f331941w = new Handler(Looper.getMainLooper());
        this.f331942x = new AtomicBoolean(false);
        this.A = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.B = 6;
        this.C = 15;
        this.D = new CopyOnWriteArrayList();
        this.E = new f(this);
        this.I = new CopyOnWriteArrayList();
        this.f331916J = new CopyOnWriteArrayList();
        this.K = new CopyOnWriteArrayList();
        this.L = new CopyOnWriteArrayList();
        this.N = new AtomicBoolean(false);
        this.O = new AtomicBoolean(false);
        this.P = new AtomicBoolean(false);
        this.Q = new AtomicBoolean(false);
        this.U = new j(this);
        this.V = new AtomicBoolean(false);
        this.W = new com.larus.dora.impl.a();
        this.X = new g0(this);
        this.Y = new AtomicBoolean(false);
        this.Z = new AtomicBoolean(false);
        this.f331934p0 = new e(this);
        this.L0 = new g(this);
        this.P0 = new DoraServiceImpl$doraLinkCallback$1(this);
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean B0() {
        kj4.a r100 = kj4.a.g();
        Intrinsics.checkNotNull(r100);
        boolean r101 = false;
        DoraDevice r102 = DoraAdapterExtKt.i(r100, false);
        if (r100.getDoraLinkState(r102) != 2) goto L5;
        boolean r103 = true;
    L6:
        String r104 = null;
        if (r102 == null) goto L9;
        int[] r105 = r102.wearState;
    L10:
        if (r105 == null) goto L17;
        Integer r106 = ArraysKt.getOrNull(r105, 0);
        if (r106 == null) goto L17;
        if (r106.intValue() != 1) goto L17;
        boolean r107 = true;
    L18:
        if (r105 == null) goto L25;
        Integer r108 = ArraysKt.getOrNull(r105, 1);
        if (r108 == null) goto L25;
        if (r108.intValue() != 1) goto L25;
        boolean r109 = true;
    L26:
        com.larus.dora.impl.util.b0.f338123a.getClass();
        if (com.larus.dora.impl.util.b0.s() == false) goto L32;
        if (r107 == true) goto L30;
        if (r109 == false) goto L32;
    L30:
        if (r103 == false) goto L32;
        r101 = true;
    L32:
        FLogger r110 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("canEnableLocationPoll current(false): result=");
        r111.append(r101);
        r111.append(", locationPoll=");
        r111.append(com.larus.dora.impl.util.b0.s());
        r111.append(", connected=");
        r111.append(r103);
        r111.append(", leftOn=");
        r111.append(r107);
        r111.append(", rightOn=");
        r111.append(r109);
        r111.append(", wearState=");
        if (r105 == null) goto L35;
        String r112 = Arrays.toString(r105);
    L36:
        r111.append(r112);
        r111.append(", productId=");
        if (r102 == null) goto L39;
        Integer r113 = Integer.valueOf(r102.productId);
    L40:
        r111.append(r113);
        r111.append(", sn=");
        if (r102 == null) goto L43;
        String r114 = r102.f204390sn;
    L44:
        r111.append(r114);
        r111.append(", version=");
        if (r102 == null) goto L47;
        String r115 = r102.softVersion;
    L48:
        r111.append(r115);
        r111.append(", modelVersion=");
        if (r102 == null) goto L51;
        r104 = r102.modelVersion;
    L51:
        r111.append(r104);
        r110.i("DoraServiceImpl", r111.toString());
        return r101;
    L47:
        r115 = null;
        goto L48
    L43:
        r114 = null;
        goto L44
    L39:
        r113 = null;
        goto L40
    L35:
        r112 = null;
    L25:
        r109 = false;
    L17:
        r107 = false;
        goto L18
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object, t69.q] */
    @Override // com.larus.dora.api.IDoraService
    public final void I() {
        y1();
        if (t69.p.f544694b.compareAndSet(false, true) == true) goto L5;
        FLogger.f375446a.i("FlowDoraWidgetManager", "init: already initialized, skip");
    L7:
        if (t69.k.f544690b.compareAndSet(false, true) == true) goto L9;
        FLogger.f375446a.i("FlowDoraCameraManager", "init: already initialized, skip");
    L11:
        if (t69.s.f544698b.compareAndSet(false, true) == true) goto L13;
        FLogger.f375446a.i("FlowDoraWifiStateManager", "init: already initialized, skip");
        return;
    L13:
        t69.r r100 = new t69.r();
        t69.s.f544699c = r100;
        int r101 = yj4.g.f568093a;
        yj4.f.a.f568092a.getClass();
        ((CopyOnWriteArraySet) yj4.h.D2).add(r100);
        ?? r102 = new t69.q();
        t69.s.f544700d = r102;
        ((CopyOnWriteArraySet) vk4.e.d.f555490a.f555484c).add(r102);
        FLogger.f375446a.i("FlowDoraWifiStateManager", "init done");
        return;
    L9:
        t69.j r103 = new t69.j();
        t69.k.f544691c = r103;
        kj4.a.g().f503709d.getClass();
        ((CopyOnWriteArraySet) uj4.b.f550325h.f533516c).add(r103);
        FLogger.f375446a.i("FlowDoraCameraManager", "init done");
        goto L11
    L5:
        t69.n r104 = new t69.n();
        t69.o r105 = new t69.o();
        t69.p.f544695c = r104;
        t69.p.f544696d = r105;
        kj4.a.g().k(r104);
        kj4.a.g().registerDoraLinkCallback(r105);
        FLogger.f375446a.i("FlowDoraWidgetManager", "init done");
        goto L7
    }

    @Override // com.larus.dora.api.IDoraService
    public final byte K() {
        return kj4.a.g().f503709d.d();
    }

    @Override // com.larus.dora.api.IDoraService
    public final t39.d L() {
        List<DoraDevice> r100 = DoraAdapterExtKt.k(kj4.a.g());
        Object r101 = null;
        if (r100.isEmpty() == false) goto L5;
        return null;
    L5:
        DoraDevice r102 = DoraAdapterExtKt.h(kj4.a.g());
        if (r102 != null) goto L8;
    L20:
        List<DoraDevice> r103 = r100;
        Iterator<T> r104 = r103.iterator();
    L22:
        if (r104.hasNext() == false) goto L29;
        Object r105 = r104.next();
        if (kj4.a.g().getDoraLinkState((DoraDevice) r105) != 2) goto L26;
        boolean r106 = true;
    L27:
        if (r106 == false) goto L22;
    L30:
        DoraDevice r107 = (DoraDevice) r105;
        if (r107 != null) goto L33;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        Iterator r108 = com.larus.dora.impl.util.b0.e().iterator();
    L36:
        if (r108.hasNext() == false) goto L48;
        String r109 = (String) r108.next();
        Iterator<T> r110 = r103.iterator();
    L39:
        if (r110.hasNext() == false) goto L43;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((DoraDevice) r111).f204389mac, r109) == false) goto L39;
    L44:
        DoraDevice r112 = (DoraDevice) r111;
        if (r112 == null) goto L36;
        return G1(r112);
    L43:
        r111 = null;
        goto L44
    L48:
        Iterator<T> r113 = r103.iterator();
    L50:
        if (r113.hasNext() == false) goto L54;
        Object r114 = r113.next();
        if (o59.a.o(Integer.valueOf(n1.c((DoraDevice) r114))) == false) goto L50;
        r101 = r114;
    L54:
        DoraDevice r115 = (DoraDevice) r101;
        if (r115 == null) goto L59;
        return G1(r115);
    L59:
        return G1((DoraDevice) CollectionsKt.first(r100));
    L33:
        return G1(r107);
    L26:
        r106 = false;
        goto L27
    L29:
        r105 = null;
        goto L30
    L8:
        if (kj4.a.g().getDoraLinkState(r102) != 2) goto L20;
        Iterator<T> r116 = r100.iterator();
    L11:
        if (r116.hasNext() == false) goto L15;
        Object r117 = r116.next();
        if (Intrinsics.areEqual(((DoraDevice) r117).f204389mac, r102.f204389mac) == false) goto L11;
    L16:
        DoraDevice r118 = (DoraDevice) r117;
        if (r118 == null) goto L20;
        return G1(r118);
    L15:
        r117 = null;
        goto L16
    }

    @Override // com.larus.dora.api.IDoraService
    public final Map<String, String> f0() {
        DoraDevice r100 = ak4.a.d().f4000a.A;
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 != null) goto L5;
    L20:
        FLogger.f375446a.i("DoraServiceImpl", "doraparam0: " + MapsKt.toMap(r101));
        return MapsKt.toMap(r101);
    L5:
        if (r100.vendorId != 4096) goto L20;
        String r102 = String.valueOf(r100.productId);
        String r103 = "none";
        if (r102 != null) goto L9;
        r102 = "none";
    L9:
        r101.put("dora_hw_product_id", r102);
        String r104 = r100.getProductName();
        if (r104 != null) goto L12;
        r104 = "none";
    L12:
        r101.put("dora_hw_product_name", r104);
        String r105 = String.valueOf(r100.sku);
        if (r105 != null) goto L15;
        r105 = "none";
    L15:
        r101.put("dora_hw_sku_id", r105);
        HSKU.a r106 = HSKU.Companion;
        Integer r107 = Integer.valueOf(r100.sku);
        r106.getClass();
        String r108 = HSKU.a.a(r107).getSkuName();
        if (r108 == null) goto L19;
        r103 = r108;
    L19:
        r101.put("dora_hw_sku_name", r103);
        goto L20
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean h0() {
        if (kj4.a.g().hasAppBound(ProductNameType.DORA_G.f204375id) == false) goto L5;
    L12:
        return true;
    L5:
        if (kj4.a.g().hasAppBound(ProductNameType.DORA_G2.f204375id) == true) goto L12;
        if (kj4.a.g().hasAppBound(ProductNameType.DORA_G_AIR.f204375id) == true) goto L12;
        if (kj4.a.g().hasAppBound(ProductNameType.DORA_G_PIN.f204375id) == true) goto L12;
        return false;
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean hasDoraDevice() {
        return kj4.a.g().hasDoraDevice();
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean j() {
        DoraDevice r100 = DoraAdapterExtKt.h(kj4.a.g());
        if (r100 == null) goto L25;
        com.larus.dora.impl.ota.b r101 = com.larus.dora.impl.ota.b.f337423a;
        String r102 = com.larus.dora.impl.ota.b.a(r100);
        if (r102.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L22;
        String r104 = r100.softVersion;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(r102, r100.softVersion) == true) goto L24;
        return true;
    L24:
        return false;
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
        goto L17
    L22:
        return false;
    L8:
        r103 = false;
        goto L9
    L25:
        return false;
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean j1() {
        List<DoraDevice> r100 = DoraAdapterExtKt.k(kj4.a.g());
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (o59.a.o(Integer.valueOf(((DoraDevice) r101.next()).productId)) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean l() {
        return com.larus.dora.impl.device.w0.a();
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean s() {
        DoraDevice r100 = kj4.a.g().c();
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (o59.a.l(r100) == false) goto L11;
        String r101 = ILoginService.f286097a.getAccountInfo().f531530c;
        if (com.larus.utils.o0.d(r101) == false) goto L11;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        if (com.larus.dora.impl.util.b0.q(r101) == false) goto L11;
        return true;
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean v() {
        if (o59.a.l(kj4.a.g().c()) == false) goto L5;
        return true;
    L5:
        kj4.a.g().f503709d.getClass();
        Long r100 = 1L;
        if (pk4.i.a.f529628a.f529627a.getLong("tag_speak_then_take_photo", r100.longValue()) == 1) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.larus.dora.api.IDoraService
    public final t39.d x0() {
        DoraDevice r100 = DoraAdapterExtKt.h(kj4.a.g());
        if (r100 == null) goto L15;
        Iterator<T> r101 = DoraAdapterExtKt.k(kj4.a.g()).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((DoraDevice) r102).f204389mac, r100.f204389mac) == false) goto L6;
    L11:
        DoraDevice r103 = (DoraDevice) r102;
        if (r103 == null) goto L15;
        return G1(r103);
    L10:
        r102 = null;
    L15:
        List<DoraDevice> r104 = DoraAdapterExtKt.k(kj4.a.g());
        if (r104 == null) goto L21;
        DoraDevice r105 = (DoraDevice) CollectionsKt.firstOrNull(r104);
        if (r105 == null) goto L21;
        return G1(r105);
    L21:
        return null;
    }

    @Override // com.larus.dora.api.IDoraService
    public final CopyOnWriteArrayList<Map<String, String>> G0() {
        return this.I;
    }

    @Override // com.larus.dora.api.IDoraService
    public final com.larus.dora.impl.serviceimpl.f M0() {
        return this.f331920d;
    }

    @Override // com.larus.dora.api.IDoraService
    public final com.larus.dora.impl.serviceimpl.s R() {
        return this.f331932o;
    }

    @Override // com.larus.dora.api.IDoraService
    public final com.larus.dora.impl.serviceimpl.t U() {
        return this.f331935q;
    }

    @Override // com.larus.dora.api.IDoraService
    public final VisionService V() {
        return this.f331921e;
    }

    @Override // com.larus.dora.api.IDoraService
    public final com.larus.dora.impl.serviceimpl.a X0() {
        return this.f331933p;
    }

    @Override // com.larus.dora.api.IDoraService
    public final SessionService d() {
        return this.f331919c;
    }

    @Override // com.larus.dora.api.IDoraService
    public final com.larus.dora.impl.serviceimpl.h debug() {
        return this.f331924h;
    }

    @Override // com.larus.dora.api.IDoraService
    public final DeviceService device() {
        return this.f331922f;
    }

    @Override // com.larus.dora.api.IDoraService
    public final r g1() {
        return this.f331930m;
    }

    @Override // com.larus.dora.api.IDoraService
    public final int getLinkState() {
        return this.H0;
    }

    @Override // com.larus.dora.api.IDoraService
    public final t39.c l0() {
        return this.f331936r;
    }

    @Override // com.larus.dora.api.IDoraService
    public final NetworkService network() {
        return this.f331929l;
    }

    @Override // com.larus.dora.api.IDoraService
    public final AbilityService o0() {
        return this.f331926j;
    }

    @Override // com.larus.dora.api.IDoraService
    public final HealthService w() {
        return this.f331927k;
    }

    public static t39.d G1(DoraDevice r100) {
        return new t39.d(r100.name, r100.f204389mac, Integer.valueOf(n1.c(r100)), Integer.valueOf(r100.vendorId), r100.model, r100.f204390sn);
    }

    public static DoraXLinkTransportMode L1(String r100) {
        String r101 = AccountService.f365697a.getUserId();
        com.larus.dora.impl.util.b0.f338123a.getClass();
        boolean r102 = com.larus.dora.impl.util.b0.p(r101);
        boolean r103 = com.larus.dora.impl.util.b0.u(r101);
        DoraWifiLinkWrapper.f332292a.getClass();
        boolean r104 = DoraWifiLinkWrapper.g();
        com.larus.dora.impl.core.settingsconfig.c r105 = com.larus.dora.impl.core.settingsconfig.c.f332267a;
        boolean r106 = DoraWifiLinkWrapper.k();
        r105.getClass();
        DoraXLinkTransportMode r107 = com.larus.dora.impl.core.settingsconfig.c.e(r102, r103, r104, r106);
        g49.d.d("DoraServiceImpl", r100 + ": isBluetoothRTCEnabled=" + r102 + ", isP2PRTCEnabled=" + r103 + ", hasPermissions=" + r104 + ", xLinkMode=" + r107 + ", xLinkConfig=[" + com.larus.dora.impl.core.settingsconfig.c.a() + ']');
        return r107;
    }

    public static final void p1(final DoraServiceImpl r100) {
        if (r100.O.compareAndSet(false, true) == true) goto L7;
        c1<com.larus.bmhome.auth.h0> r101 = AuthModelDelegate.f297134b.a().getValue();
        if (r101 == null) goto L9;
        r100.x1(r101);
        return;
    L9:
        return;
    L7:
        AuthModelDelegate r102 = AuthModelDelegate.f297134b;
        r102.a().observeForever(new u0(new DoraServiceImpl$registerCoreLaunchObserverIfNeeded$2(r100)));
        r102.y().observeForever(new u0(new h0(r100)));
    }

    public final void C1(int r100) {
        float r101 = r100 / this.C;
        g49.d.d("DoraServiceImpl", "setVolume, gain: " + r101);
        BuildersKt.launch$default(this.A, null, null, new DoraServiceImpl$onSystemVolumeChanged$1(this, r101, null), 3, null);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void E(String r100) {
        Intrinsics.checkNotNullParameter(r100, "audioType");
        DoraBuryPointManager r101 = DoraBuryPointManager.f331862a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "audioType");
        DoraBuryPointManager.J(r101, "query_thru_earphones_status", MapsKt.mapOf(new Pair[]{TuplesKt.to("status", 1), TuplesKt.to("failure_reason", "none")}), false, 12);
    }

    public final void E1(DoraEnableScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        int r101 = t0.f338079b[r100.ordinal()];
        if (r101 == 1) goto L11;
        if (r101 != 2) goto L6;
        List r102 = CollectionsKt.listOf(new DoraEnableScope[]{DoraEnableScope.G2, DoraEnableScope.G_SERIES});
    L12:
        Iterator r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L36;
        final DoraEnableScope r104 = (DoraEnableScope) r103.next();
        final DoraResourceState r105 = u1(r104);
        DoraResourceState r106 = this.f331940v.put(r104, r105);
        if (r106 == null) goto L24;
        if (r106 == r105) goto L24;
        Runnable r107 = new j0(this, r104, r105);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L22;
        r107.run();
        goto L24
    L22:
        this.f331941w.post(r107);
    L24:
        if (r105 != DoraResourceState.READY) goto L26;
        final boolean r108 = true;
    L27:
        Boolean r109 = this.f331938t.put(r104, Boolean.valueOf(r108));
        if (r109 == null) goto L14;
        if (Intrinsics.areEqual(r109, Boolean.valueOf(r108)) == true) goto L14;
        Runnable r110 = new i0(this, r104, r108);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L34;
        this.f331941w.post(r110);
        goto L14
    L34:
        r110.run();
        goto L14
    L26:
        r108 = false;
        goto L27
    L36:
        return;
    L6:
        if (r101 != 3) goto L9;
        r102 = CollectionsKt.listOf(DoraEnableScope.G_SERIES);
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    L11:
        r102 = CollectionsKt.listOf(new DoraEnableScope[]{DoraEnableScope.G1, DoraEnableScope.G_SERIES});
        goto L12
    }

    @Override // com.larus.dora.api.IDoraService
    public final void G(t39.n r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f331916J.remove(r100);
        this.K.addIfAbsent(r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void H(long r100) {
        kj4.a r101 = kj4.a.g();
        BudsEvent r102 = BudsEvent.LOCAL_SPEECH_END_TIME;
        mj4.f r103 = r101.f503708c;
        r103.getClass();
        ByteBuffer r104 = ByteBuffer.allocate(8);
        r104.order(ByteOrder.BIG_ENDIAN);
        r104.putLong(r100);
        r103.f514229d.i(r102.SID, r102.CID, pk4.n.u(new byte[]{(byte) r102.EVENT, (byte) r102.LEN}, r104.array()));
    }

    @Override // com.larus.dora.api.IDoraService
    public final void H0(int r100) {
        IDoraAVLinkService r101 = v1();
        if (r101 == null) goto L8;
        w88.t r102 = r101.A();
        if (r102 == null) goto L9;
        r102.d(true, 11, r100);
        return;
    L9:
        return;
    }

    public final void H1(String r100) {
        com.larus.platform.service.o r101 = com.larus.platform.service.o.f365780a;
        String r102 = r101.getDeviceId();
        if (r102.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L16;
        StringBuilder r104 = new StringBuilder();
        r104.append(AccountService.f365697a.isLogin().booleanValue());
        r104.append('|');
        if (r100 != null) goto L10;
        r100 = "";
    L10:
        r104.append(r100);
        r104.append('|');
        r104.append(DoraConfig.g());
        r104.append('|');
        r104.append(r102);
        String r105 = r104.toString();
        if (Intrinsics.areEqual(this.R, r105) == false) goto L13;
        return;
    L13:
        this.R = r105;
        m0("coreLaunchForConsumerLiveData ready");
        return;
    L16:
        if (this.Q.compareAndSet(false, true) == true) goto L18;
        return;
    L18:
        r101.e(new DoraServiceImpl$tryInitBotConversationWhenDeviceIdReady$1(this));
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // com.larus.dora.api.IDoraService
    public final void I0(int r100) {
        IDoraAVLinkService r101 = v1();
        if (r101 == null) goto L6;
        r101.n(Integer.valueOf(r100));
        return;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void L0(h49.k r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<h49.k> r101 = h49.a.f483780a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        CopyOnWriteArrayList<h49.k> r102 = h49.a.f483780a;
        if (r102.contains(r100) == true) goto L7;
        r102.add(r100);
        return;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void M(DoraAVLinkServiceImpl.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.D.contains(r100) == true) goto L6;
        this.D.add(r100);
        g49.d.d("DoraServiceImpl", "registerConversationGestureCallback: ".concat(DoraAVLinkServiceImpl.c.class.getSimpleName()));
        return;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void O0(com.larus.avlink.impl.l r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        DoraEnableScope[] r101 = DoraEnableScope.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        DoraEnableScope r104 = r101[r103];
        ConcurrentHashMap<DoraEnableScope, Boolean> r105 = this.f331938t;
        if (S0(r104) != DoraResourceState.READY) goto L7;
        boolean r106 = true;
    L8:
        r105.putIfAbsent(r104, Boolean.valueOf(r106));
        r103 = r103 + 1;
        goto L3
    L7:
        r106 = false;
        goto L8
    L9:
        this.f331937s.add(r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean Q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        com.larus.dora.impl.util.b0.f338123a.getClass();
        return com.larus.dora.impl.util.b0.v(r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void R0(t39.i r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.L.addIfAbsent(r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final DoraResourceState S0(DoraEnableScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        DoraResourceState r101 = u1(r100);
        this.f331940v.putIfAbsent(r100, r101);
        return r101;
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean T0(DoraEnableScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        if (S0(r100) != DoraResourceState.READY) goto L5;
        boolean r101 = true;
    L6:
        this.f331938t.putIfAbsent(r100, Boolean.valueOf(r101));
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.dora.api.IDoraService
    public final void V0(DoraByteCastManager.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.K.remove(r100);
        this.f331916J.remove(r100);
        this.f331916J.add(0, r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void W(t39.x r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        DoraVoiceWakeupStateManager r101 = DoraVoiceWakeupStateManager.f332171a;
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArraySet<t39.x> r102 = DoraVoiceWakeupStateManager.f332172b;
        r102.add(r100);
        g49.d.d("DoraVoiceWakeupStateManager", "addVoiceWakeupStateChangedListener, size=" + r102.size());
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean X(Integer r100) {
        return o59.a.o(r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void Y0(int r100) {
        h49.a.b(r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void Z(String r100) {
        Intrinsics.checkNotNullParameter(r100, "audioType");
        DoraBuryPointManager.f331862a.getClass();
        Intrinsics.checkNotNullParameter(r100, "audioType");
        DoraBuryPointManager.f331869h = System.currentTimeMillis();
    }

    @Override // com.larus.dora.api.IDoraService
    public final void Z0(boolean r100) {
        DoraSetting.f338023a.getClass();
        boolean r101 = DoraSetting.f();
        g49.d.d("DoraServiceImpl", "idleInit: " + r101 + ", immediately: " + r100);
        if (r101 == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        if (r100 == true) goto L9;
        g49.d.d("DoraServiceImpl", "addIdleHandler");
        pk4.n.f529660d.getLooper().getQueue().addIdleHandler(new l0());
        return;
    L9:
        pk4.n.f529660d.post(new m0());
    }

    @Override // com.larus.dora.api.IDoraService
    public final boolean g(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        IDoraAVLinkService r101 = v1();
        if (r101 == null) goto L7;
        w88.t r102 = r101.A();
        if (r102 == null) goto L7;
        r102.g(r100);
        return true;
    L7:
        return false;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void i(boolean r100) {
        this.f331918b = r100;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraServiceImpl$setEnrollingStatus$1(r100, null), 3, null);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void j0(m59.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f331939u.remove(r100);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        DoraBuryPointManager.f331862a.L("dora_device_management_entrance_show", MapsKt.mapOf(TuplesKt.to("page", r100)));
    }

    @Override // com.larus.dora.api.IDoraService
    public final void k1(m59.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        DoraEnableScope[] r101 = DoraEnableScope.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        DoraEnableScope r104 = r101[r103];
        this.f331940v.putIfAbsent(r104, u1(r104));
        r103 = r103 + 1;
        goto L3
    L5:
        this.f331939u.add(r100);
    }

    @Override // mj4.h
    public final void l1(DoraDevice r100) {
        if (o59.a.m(Integer.valueOf(r100.productId)) == false) goto L29;
        String r101 = r100.f204390sn;
        boolean r102 = true;
        if (r101 != null) goto L8;
    L11:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L27;
        String r104 = r100.f204389mac;
        if (r104 != null) goto L17;
    L20:
        if (r102 == true) goto L27;
        if (kj4.a.g().getDoraLinkState(r100) == 2) goto L25;
        return;
    L25:
        g49.d.d("DoraServiceImpl", "onDeviceInfoChange: upload G2 basic_info, productId=" + r100.productId);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraServiceImpl$onDeviceInfoChange$1(r100, null), 3, null);
        return;
    L17:
        if (r104.length() == 0) goto L20;
        r102 = false;
    L27:
        g49.d.b("DoraServiceImpl", "onDeviceInfoChange: skip G2 basic_info because device info is incomplete");
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r103 = false;
        goto L13
    }

    @Override // com.larus.dora.api.IDoraService
    public final void m0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DoraServiceImpl$tryInitBotConversation$1(this, r100, null), 3, null);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void n(FragmentManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        DoraOnboardingAudioSettingDialog r101 = new DoraOnboardingAudioSettingDialog();
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r101, "OnboardingAudioSetting", r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, r101, r102) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r101.show(r100, "OnboardingAudioSetting");
        return;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void n0(String r110) {
        Intrinsics.checkNotNullParameter(r110, "cmdValue");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(ouc.k.n(ouc.a.f526798d.e(r110)));     // Catch: Throwable -> L5
    L7:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 != null) goto L76;
        ouc.i r103 = (ouc.i) ((ouc.d0) r101).get("body_etp_base64");
        Long r104 = null;
        if (r103 == null) goto L12;
        String r105 = ouc.k.g(ouc.k.o(r103));
    L14:
        if (r105 != null) goto L16;
    L19:
        boolean r106 = true;
    L20:
        boolean r107 = !r106;
        Object r111 = Result.m9449constructorimpl(new JSONObject(r110));     // Catch: Throwable -> L23
    L25:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r111);
        if (r108 != null) goto L39;
        JSONObject r112 = (JSONObject) r111;
        JSONArray r109 = r112.optJSONArray("json_rpc_reqs");
        if (r109 == null) goto L40;
        String r113 = D1(r112, "req_id");
        if (r113 != null) goto L33;
        FLogger.f375446a.e("DoraServiceImpl", "handleAppAtomicFunctions: req_id is missing");
    L38:
        boolean r114 = true;
    L41:
        if (r105 != null) goto L43;
    L46:
        boolean r115 = true;
    L47:
        if (r115 == false) goto L84;
        if (r114 == true) goto L86;
        FLogger.f375446a.w("DoraServiceImpl", "handleDoraAtomicFunction: no supported payload");
        return;
    L86:
        return;
    L84:
        Object r116 = Result.m9449constructorimpl(Base64.decode(r105, 0));     // Catch: Throwable -> L53
    L56:
        if (Result.m9456isSuccessimpl(r116) == false) goto L72;
        byte[] r117 = (byte[]) r116;
        Intrinsics.checkNotNull(r117);
        String r118 = ArraysKt.joinToString$default(r117, " ", null, null, 0, null, new k0(), 30, null);
        com.larus.dora.impl.a r119 = this.W;
        r119.getClass();
        Intrinsics.checkNotNullParameter(r117, WsConstants.KEY_PAYLOAD);
        int r120 = com.larus.dora.impl.a.b.f331973c;
        com.larus.dora.impl.a.b r121 = com.larus.dora.impl.a.b.C4209a.a(r117);
        if (r121 != null) goto L61;
    L62:
        Long r122 = r104;
        FLogger.f375446a.i("DoraServiceImpl", "handleDoraAtomicFunction: decoded payload length=" + r117.length + ", adaptiveVolumeRequestId=" + r122 + ", hex=" + r118 + ", utf8=" + new String(r117, Charsets.UTF_8));
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraServiceImpl$forwardETPPayload$2$1(r118, r122, this, r117, null), 3, null);
        goto L72
    L61:
        if (r121.f331975b != 101) goto L62;
        Map<Long, Integer> r123 = r119.f331972a;
        monitor-enter(r123);
        r119.f331972a.put(Long.valueOf(r121.f331974a), Integer.valueOf(((Number) ((LinkedHashMap) r119.f331972a).getOrDefault(Long.valueOf(r121.f331974a), 0)).intValue() + 1));     // Catch: Throwable -> L69
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L69
        monitor-exit(r123);
        r104 = Long.valueOf(r121.f331974a);
    L69:
        th = move-exception;
        throw th;
    L72:
        Throwable r125 = Result.m9452exceptionOrNullimpl(r116);
        if (r125 == null) goto L87;
        FLogger.f375446a.e("DoraServiceImpl", "handleDoraAtomicFunction: failed to decode body_etp_base64", r125);
        return;
    L87:
        return;
    L53:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L43:
        if (r105.length() == 0) goto L46;
        r115 = false;
        goto L47
    L33:
        if (r107 == true) goto L35;
    L37:
        IDoraService.B1.getClass();
        BuildersKt.launch$default(IDoraService.b.f331727b, null, null, new DoraServiceImpl$handleAppAtomicFunctions$1(r113, r109, this, null), 3, null);
        goto L38
    L35:
        if (r109.length() != 0) goto L37;
        FLogger.f375446a.i("DoraServiceImpl", "handleAppAtomicFunctions: skip empty JSON-RPC callback because ETP payload is present, reqId=".concat(r113));
    L40:
        r114 = false;
        goto L41
    L39:
        FLogger.f375446a.e("DoraServiceImpl", "handleAppAtomicFunctions: invalid value JSON", r108);
    L23:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L25
    L16:
        if (r105.length() == 0) goto L19;
        r106 = false;
        goto L20
    L12:
        r105 = null;
        goto L14
    L76:
        FLogger.f375446a.e("DoraServiceImpl", "handleDoraAtomicFunction: invalid value JSON", r102);
        return;
    L5:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.dora.api.IDoraService
    public final Integer o(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276376z);
        switch(r100.hashCode()) {
            case -1615297669: goto L30;
            case -1172408017: goto L26;
            case 110036354: goto L22;
            case 1130641490: goto L18;
            case 1255550169: goto L15;
            case 1284848785: goto L12;
            case 1819149060: goto L9;
            case 2097915162: goto L6;
            default: goto L33;
        };
    L33:
        return null;
    L6:
        if (r100.equals("HmRdheYWOw") == false) goto L33;
    L36:
        return Integer.valueOf(FlowDoraSubBizType.OLA_FRIEND.getValue());
    L9:
        if (r100.equals("phiDZKCcuhc6srv1") == false) goto L33;
    L35:
        return Integer.valueOf(FlowDoraSubBizType.G1_G2.getValue());
    L12:
        if (r100.equals("qoZHsKsRzH") == false) goto L33;
    L37:
        return Integer.valueOf(FlowDoraSubBizType.E.getValue());
    L15:
        if (r100.equals("HgZBnrFyOUeW9eWN") == false) goto L33;
    L38:
        return Integer.valueOf(FlowDoraSubBizType.G1_G2.getValue());
    L18:
        if (r100.equals("8WXv2rMtrmQ6QeJd") == true) goto L35;
    L22:
        if (r100.equals("VWkAjHuAlm") == true) goto L36;
    L26:
        if (r100.equals("HqxgWPsgLv") == true) goto L37;
    L30:
        if (r100.equals("Wd4coUDTJ8zmVZ0T") == true) goto L38;
        goto L33
    }

    @Override // com.larus.dora.api.IDoraService
    public final void onAsrStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "audioType");
        DoraBuryPointManager.f331862a.getClass();
        Intrinsics.checkNotNullParameter(r100, "audioType");
        DoraBuryPointManager.f331868g = true;
        DoraBuryPointManager.f331869h = System.currentTimeMillis();
    }

    @Override // mj4.h
    public final void p(int r100) {
        g49.d.d("DoraServiceImpl", "onLowPowerState isBothConnected is " + this.f331922f.G());
        CopyOnWriteArrayList<t39.i> r101 = this.L;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<t39.i> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().p(r100);
        r102.add(Unit.INSTANCE);
        goto L4
    }

    @Override // com.larus.dora.api.IDoraService
    public final void q0(t39.n r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f331916J.remove(r100);
        this.K.remove(r100);
    }

    public final DoraResourceState t1(DoraServerDeviceType r100) {
        this.f331924h.getClass();
        Intrinsics.checkNotNullParameter(r100, IConstValues.DEVICE_TYPE);
        Intrinsics.checkNotNullParameter(r100, IConstValues.DEVICE_TYPE);
        Set<String> r101 = com.larus.dora.impl.resource.l.f337892a;
        String r102 = AppHost.f326268a.getBuildChannel();
        Intrinsics.checkNotNullParameter(r102, "buildChannel");
        boolean r103 = false;
        if (com.larus.dora.impl.resource.l.f337892a.contains(r102) == true) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L20;
        com.larus.dora.impl.resource.j0 r105 = com.larus.dora.impl.resource.j0.f337886a;
        int r106 = com.larus.dora.impl.serviceimpl.n.f338013a[r100.ordinal()];
        if (r106 == 1) goto L16;
        if (r106 != 2) goto L15;
        DoraResourceDeviceType r107 = DoraResourceDeviceType.G2;
    L17:
        r105.getClass();
        if (com.larus.dora.impl.resource.j0.b(r107) == false) goto L20;
        DoraResourceState r108 = DoraResourceState.PENDING;
    L21:
        DoraResourceState r109 = DoraResourceState.DISABLED;
        if (r108 == r109) goto L24;
        boolean r110 = true;
    L25:
        if (r110 == false) goto L27;
        DoraResourceState r111 = r108;
    L28:
        if (r111 != null) goto L37;
        List<DoraEnableScope> r112 = com.larus.dora.impl.resource.r.f337907a;
        int r113 = t0.f338078a[r100.ordinal()];
        if (r113 == 1) goto L35;
        if (r113 != 2) goto L34;
        DoraEnableScope r114 = DoraEnableScope.G2;
    L36:
        r111 = com.larus.dora.impl.resource.r.c(r114);
        goto L37
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        r114 = DoraEnableScope.G1;
    L37:
        int r115 = t0.f338078a[r100.ordinal()];
        if (r115 == 1) goto L43;
        if (r115 != 2) goto L42;
        DoraResourceDeviceType r116 = DoraResourceDeviceType.G2;
    L44:
        int r117 = b0.f332051a;
        if (r111 == r109) goto L47;
        r103 = true;
    L47:
        if (r108 == r109) goto L49;
        com.larus.dora.impl.resource.j0.f337886a.getClass();
        boolean r118 = com.larus.dora.impl.resource.j0.b(r116);
    L50:
        Intrinsics.checkNotNullParameter(r111, "syncState");
        if (r103 == false) goto L62;
        if (r118 == true) goto L61;
        DoraResourceState r119 = DoraResourceState.FAILED;
        if (r111 == r119) goto L60;
        r119 = DoraResourceState.PENDING;
    L60:
        return r119;
    L61:
        return DoraResourceState.READY;
    L62:
        return r109;
    L49:
        com.larus.dora.impl.resource.j0.f337886a.getClass();
        Intrinsics.checkNotNullParameter(r116, IConstValues.DEVICE_TYPE);
        com.larus.dora.impl.resource.x r120 = (com.larus.dora.impl.resource.x) com.larus.dora.impl.resource.j0.f337887b.getValue();
        r120.getClass();
        Intrinsics.checkNotNullParameter(r116, IConstValues.DEVICE_TYPE);
        r118 = com.larus.dora.impl.resource.x.d(r120.f337925c, r116);
        goto L50
    L42:
        throw new NoWhenBranchMatchedException();
    L43:
        r116 = DoraResourceDeviceType.G1;
        goto L44
    L27:
        r111 = null;
        goto L28
    L24:
        r110 = false;
        goto L25
    L15:
        throw new NoWhenBranchMatchedException();
    L16:
        r107 = DoraResourceDeviceType.G1;
    L20:
        r108 = DoraResourceState.DISABLED;
        goto L21
    L5:
        if (com.larus.dora.impl.resource.y.a(r100) == false) goto L7;
        r104 = true;
        goto L9
    }

    public final DoraResourceState u1(DoraEnableScope r100) {
        int r101 = d.f331949a[r100.ordinal()];
        if (r101 == 1) goto L22;
        if (r101 == 2) goto L24;
        if (r101 != 3) goto L19;
        int r102 = b0.f332051a;
        DoraResourceState r103 = t1(DoraServerDeviceType.G1);
        DoraResourceState r104 = t1(DoraServerDeviceType.G2);
        Intrinsics.checkNotNullParameter(r103, SoloKtvContext.SOLO_PAGE_FIRST);
        Intrinsics.checkNotNullParameter(r104, "second");
        List r105 = CollectionsKt.listOf(new DoraResourceState[]{r103, r104});
        DoraResourceState r106 = DoraResourceState.PENDING;
        if (r105.contains(r106) == true) goto L25;
        DoraResourceState r107 = DoraResourceState.FAILED;
        if (r105.contains(r107) == true) goto L26;
        DoraResourceState r108 = DoraResourceState.READY;
        if (r105.contains(r108) == false) goto L23;
        return r108;
    L23:
        return DoraResourceState.DISABLED;
    L26:
        return r107;
    L25:
        return r106;
    L19:
        throw new NoWhenBranchMatchedException();
    L24:
        return t1(DoraServerDeviceType.G2);
    L22:
        return t1(DoraServerDeviceType.G1);
    }

    @Override // com.larus.dora.api.IDoraService
    public final Map<String, String> w0(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "callBody");
        int r100 = com.larus.dora.impl.network.n.f336172a;
        Intrinsics.checkNotNullParameter(r110, "callBody");
        Pair[] r101 = new Pair[2];
        String r111 = r110.toString();
        String[] r102 = (String[]) StringsKt.split$default("", new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
        ArraysKt.sort(r102);
        String r103 = "POST\n" + ArraysKt.joinToString$default(r102, "&", null, null, 0, null, null, 62, null) + '\n';
        if (TextUtils.isEmpty(r111) == true) goto L5;
        r103 = r103 + DigestUtils.md5Hex(r111) + '\n';
    L5:
        HmacAlgorithms r104 = HmacAlgorithms.HMAC_SHA_256;
        Charset r105 = Charsets.UTF_8;
        r101[0] = TuplesKt.to("X-Signature", "Dora:" + Base64.encodeToString(new HmacUtils(r104, "5522550fcfe91334eb58c258a3b65c46".getBytes(r105)).hmac(r103.getBytes(r105)), 2));
        r101[1] = TuplesKt.to("x-ttnet-req-biz-id", DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME);
        return MapsKt.mapOf(r101);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void x(h49.k r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<h49.k> r101 = h49.a.f483780a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        h49.a.f483780a.remove(r100);
    }

    public final void x1(c1<com.larus.bmhome.auth.h0> r110) {
        if (this.P.get() == false) goto L21;
        com.larus.bmhome.auth.h0 r100 = r110.f295753d;
        if (r100 == null) goto L7;
        String r101 = r100.b();
    L8:
        if (r101 != null) goto L10;
    L13:
        boolean r102 = true;
    L15:
        if ((!r102) == false) goto L21;
        com.larus.bmhome.auth.h0 r111 = r110.f295753d;
        if (r111 == null) goto L19;
        String r112 = r111.h();
    L20:
        H1(r112);
        K1();
        goto L21
    L19:
        r112 = null;
        goto L20
    L10:
        if (StringsKt.isBlank(r101) == true) goto L13;
        r102 = false;
        goto L15
    L7:
        r101 = null;
    L21:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraServiceImpl$handleCoreLaunchResult$1(this, null), 3, null);
        if (this.N.getAndSet(true) == true) goto L25;
        kj4.a r113 = kj4.a.g();
        r113.registerHighPriorityDoraLinkCallback(this.L0);
        r113.registerDoraLinkCallback(this.P0);
        r113.k(this);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraServiceImpl$replayCurrentStateToAllCallbacks$1("firstRegisterGate:handleCoreLaunch", this, null), 3, null);
        return;
    }

    public static String D1(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L20;
        String r104 = r102.toString();
        if (r104 != null) goto L17;
        return null;
    L17:
        if ((true ^ StringsKt.isBlank(r104)) == true) goto L19;
        return null;
    L19:
        return r104;
    L20:
        return null;
    L5:
        if (Intrinsics.areEqual(r102, JSONObject.NULL) == true) goto L8;
        r103 = false;
        goto L10
    }

    public static final String o1(DoraServiceImpl r100, int r101) {
        r100.getClass();
        if (r101 == (-1)) goto L16;
        if (r101 != 0) goto L6;
        return "LinkState.DISCONNECTED";
    L6:
        if (r101 != 1) goto L8;
        return "LinkState.CONNECTING";
    L8:
        if (r101 != 2) goto L10;
        return "LinkState.CONNECTED";
    L10:
        if (r101 != 3) goto L18;
        return "LinkState.DISCONNECTING";
    L18:
        return "LinkState Undefined: " + r101;
    L16:
        return "LinkState.UN_BONDED";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006d -> B:27:0x0070). Please report as a decompilation issue!!! */
    public static final Object r1(DoraServiceImpl r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof DoraServiceImpl$waitP2PRTCVideoCallStartGuard$1) == false) goto L7;
        DoraServiceImpl$waitP2PRTCVideoCallStartGuard$1 r100 = (DoraServiceImpl$waitP2PRTCVideoCallStartGuard$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r113 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r100.label;
        boolean r103 = true;
        if (r102 == 0) goto L14;
        if (r102 != 1) goto L13;
        long r104 = r100.J$0;
        ResultKt.throwOnFailure(r112);
    L27:
        r104 = r104 + 200;
    L15:
        boolean r114 = false;
        if (r104 >= KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL) goto L28;
        IDoraAVLinkService r105 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r105 != null) goto L20;
    L22:
        if (r114 == false) goto L24;
        g49.d.d("DoraServiceImpl", "handleP2PRTCVideoCallRequest guard released: LiveAI entered");
        return Unit.INSTANCE;
    L24:
        r100.J$0 = r104;
        r100.label = 1;
        if (DelayKt.delay(200, r100) != r113) goto L27;
        return r113;
    L20:
        if (r105.c1(1) != true) goto L22;
        r114 = true;
        goto L22
    L28:
        IDoraAVLinkService r115 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r115 != null) goto L31;
    L33:
        r103 = false;
    L34:
        if (r103 == false) goto L36;
        g49.d.d("DoraServiceImpl", "handleP2PRTCVideoCallRequest guard released: LiveAI entered after timeout");
        return Unit.INSTANCE;
    L36:
        g49.d.b("DoraServiceImpl", "handleP2PRTCVideoCallRequest guard timeout before LiveAI entered");
        jk4.d r116 = jk4.d.b.f499499a;
        r116.getClass();
        r116.q(new jk4.d.c((byte) 0, 0));
        IDoraService r117 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r117 == null) goto L42;
        AbilityService r118 = r117.o0();
        if (r118 == null) goto L42;
        r118.a();
    L42:
        return Unit.INSTANCE;
    L31:
        if (r115.c1(1) != true) goto L33;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r104 = 0;
    L7:
        r100 = new DoraServiceImpl$waitP2PRTCVideoCallStartGuard$1(r110, r111);
        goto L8
    }

    @Override // com.larus.dora.api.IDoraService
    public final void A0(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        DoraBuryPointManager.f331862a.L(r100, r101);
    }

    public final void B1(int r100, int r101) {
        boolean r102 = false;
        if (this.f331922f.M() == true) goto L5;
    L19:
        boolean r103 = false;
    L20:
        if (r103 == true) goto L22;
        return;
    L22:
        if (r101 != 1) goto L24;
    L32:
        g49.d.d("DoraServiceImpl", "notifyDoraGWakeupStateIfNeeded, mode:" + v88.a.h(r100) + ", query:" + v88.b.a(r101) + ", isInWakeup:" + r102);
        IDoraWakeupService r104 = (IDoraWakeupService) ServiceManager.get().getService(IDoraWakeupService.class);
        if (r104 == null) goto L36;
        r104.d(r102);
        return;
    L36:
        return;
    L24:
        if (r101 != 2) goto L26;
    L31:
        r102 = true;
        goto L32
    L26:
        if (r101 == 3) goto L32;
        if (r101 == 7) goto L31;
        if (r101 == 8) goto L32;
        return;
    L5:
        if (this.f331922f.S() == false) goto L19;
        if (r100 != 1) goto L8;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        r103 = true;
        goto L20
    L8:
        if (r100 == 6) goto L16;
        if (r100 == 32) goto L16;
        if (r100 == 7) goto L16;
        if (r100 == 11) goto L16;
        r105 = false;
        goto L17
    }

    @Override // mj4.h
    public final void D(DoraDevice r100, int[] r101) {
        boolean r102 = o59.a.j(r100);
        g49.d.d("DoraServiceImpl", "onChargeStateChanged isBothConnected is " + r102);
        CopyOnWriteArrayList<t39.i> r103 = this.L;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<t39.i> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r105.next().c(r102);
        r104.add(Unit.INSTANCE);
        goto L4
    }

    @Override // mj4.h
    public final void a1(DoraDevice r100, mj4.b r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        CopyOnWriteArrayList<t39.i> r102 = this.L;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<t39.i> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().a(r101.f514221a, r101.f514222b);
        r103.add(Unit.INSTANCE);
        goto L4
    }

    @Override // mj4.h
    public final void e1(DoraDevice r100, int[] r101) {
        boolean r102 = o59.a.j(r100);
        g49.d.d("DoraServiceImpl", "onBudsStateChanged isBothConnected is " + r102);
        CopyOnWriteArrayList<t39.i> r103 = this.L;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<t39.i> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r105.next().b(r102);
        r104.add(Unit.INSTANCE);
        goto L4
    }

    @Override // com.larus.dora.api.IDoraService
    public final void h1(int r100, boolean r101) {
        IDoraAVLinkService r102 = v1();
        if (r102 == null) goto L8;
        w88.t r103 = r102.A();
        if (r103 == null) goto L9;
        r103.d(r101, 11, r100);
        return;
    L9:
        return;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void m1(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, r100, r101, false, 12);
    }

    @Override // mj4.h
    public final void y0(DoraDevice r100, int[] r101) {
        boolean r102 = true;
        if (r101 == null) goto L10;
        Integer r103 = ArraysKt.getOrNull(r101, 0);
        if (r103 == null) goto L10;
        if (r103.intValue() != 1) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L22;
        if (r101 == null) goto L19;
        Integer r105 = ArraysKt.getOrNull(r101, 1);
        if (r105 == null) goto L19;
        if (r105.intValue() != 1) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L22;
    L23:
        g49.d.d("DoraServiceImpl", "onWearStateChanged isBothConnected is " + r102);
        CopyOnWriteArrayList<t39.i> r107 = this.L;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator<T> r109 = r107.iterator();
    L25:
        if (r109.hasNext() == false) goto L27;
        ((t39.i) r109.next()).b(r102);
        r108.add(Unit.INSTANCE);
        goto L25
    L27:
        return;
    L19:
        r106 = false;
    L22:
        r102 = false;
    L10:
        r104 = false;
        goto L11
    }

    public final Object z1(DoraDevice r100, Continuation<? super Boolean> r101) {
        if ((r101 instanceof DoraServiceImpl$isEnvironmentObservationPrivacyAccepted$1) == false) goto L7;
        DoraServiceImpl$isEnvironmentObservationPrivacyAccepted$1 r102 = (DoraServiceImpl$isEnvironmentObservationPrivacyAccepted$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L17:
        String r108 = null;
        if (Result.m9455isFailureimpl(r107) == false) goto L20;
        r107 = null;
    L20:
        com.larus.dora.impl.network.h r109 = (com.larus.dora.impl.network.h) r107;
        if (r109 == null) goto L26;
        com.larus.dora.impl.network.g r110 = r109.a();
        if (r110 == null) goto L26;
        r108 = r110.a();
    L26:
        return Boxing.boxBoolean(Intrinsics.areEqual(r108, "1"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        DoraNetworkApi r111 = DoraNetworkApi.f336157a;
        List<String> r112 = CollectionsKt.listOf("environmental_observation_agreement_status");
        r102.label = 1;
        r107 = r111.x(r100, r112, r102);
        if (r107 != r105) goto L17;
        return r105;
    L7:
        r102 = new DoraServiceImpl$isEnvironmentObservationPrivacyAccepted$1(this, r101);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object q1(DoraServiceImpl r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof DoraServiceImpl$requestMainConversationInfo$1) == false) goto L7;
        DoraServiceImpl$requestMainConversationInfo$1 r103 = (DoraServiceImpl$requestMainConversationInfo$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        com.larus.network.http.a r108 = (com.larus.network.http.a) r105;
        if ((r108 instanceof com.larus.network.http.y) == false) goto L23;
        wc9.e r109 = (wc9.e) ((com.larus.network.http.y) r108).f360135b;
        if (r109 == null) goto L26;
        return r109.f559198a;
    L26:
        return null;
    L23:
        if ((r108 instanceof com.larus.network.http.f) == false) goto L26;
        g49.d.c("DoraServiceImpl", "request conversation info failed.", ((com.larus.network.http.f) r108).f360157d);
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        IConversationRepoService r110 = zh8.a.f572197b;
        r103.label = 1;
        r105 = IConversationRepoService.a.e(r110, null, r101, r103, 5);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new DoraServiceImpl$requestMainConversationInfo$1(r100, r102);
        goto L8
    }

    @Override // com.larus.dora.api.IDoraService
    public final t39.f B(DoraEnableScope r100, DoraServerResourceType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "resourceType");
        Intrinsics.checkNotNullParameter(r102, "resourceName");
        if (T0(r100) == true) goto L5;
        return null;
    L5:
        com.larus.dora.impl.resource.j0 r103 = com.larus.dora.impl.resource.j0.f337886a;
        int r104 = t0.f338079b[r100.ordinal()];
        if (r104 == 1) goto L13;
        if (r104 == 2) goto L12;
        if (r104 != 3) goto L11;
        DoraResourceDeviceType r105 = DoraResourceDeviceType.G_SERIES;
    L15:
        switch(t0.f338080c[r101.ordinal()]) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            default: goto L17;
        };
    L18:
        DoraResourceType r106 = DoraResourceType.DIMEN;
    L25:
        gd9.i r107 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r107);
        NovaApplication r108 = r107.getApplication();
        r103.getClass();
        com.larus.dora.impl.resource.k r109 = com.larus.dora.impl.resource.j0.e(r105, r106, r102, com.larus.dora.impl.resource.j0.h(r108));
        if ((r109 instanceof com.larus.dora.impl.resource.k.a) == false) goto L29;
        return new t39.f.a(((com.larus.dora.impl.resource.k.a) r109).f337889a);
    L29:
        if ((r109 instanceof com.larus.dora.impl.resource.k.b) == false) goto L40;
        com.larus.dora.impl.resource.k.b r110 = (com.larus.dora.impl.resource.k.b) r109;
        File r111 = r110.f337890a;
        DoraResourceSource r112 = r110.f337891b;
        int r113 = t0.f338081d[r112.ordinal()];
        if (r113 == 1) goto L38;
        if (r113 == 2) goto L37;
        if (r113 != 3) goto L36;
        DoraServerResourceSource r114 = DoraServerResourceSource.CLOUD;
    L44:
        return new t39.f.b(r111, r114);
    L36:
        throw new NoWhenBranchMatchedException();
    L37:
        r114 = DoraServerResourceSource.LOCAL;
        goto L44
    L38:
        r114 = DoraServerResourceSource.APK;
        goto L44
    L40:
        if (r109 != null) goto L43;
        return null;
    L43:
        throw new NoWhenBranchMatchedException();
    L19:
        r106 = DoraResourceType.XML;
        goto L25
    L20:
        r106 = DoraResourceType.COLOR;
        goto L25
    L21:
        r106 = DoraResourceType.RAW;
        goto L25
    L22:
        r106 = DoraResourceType.LAYOUT;
        goto L25
    L23:
        r106 = DoraResourceType.DRAWABLE;
        goto L25
    L24:
        r106 = DoraResourceType.STRING;
        goto L25
    L17:
        throw new NoWhenBranchMatchedException();
    L11:
        throw new NoWhenBranchMatchedException();
    L12:
        r105 = DoraResourceDeviceType.G2;
        goto L15
    L13:
        r105 = DoraResourceDeviceType.G1;
        goto L15
    }

    public final Object I1(DoraDevice r100, boolean r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof DoraServiceImpl$updateAdaptiveVolumeSwitch$1) == false) goto L7;
        DoraServiceImpl$updateAdaptiveVolumeSwitch$1 r103 = (DoraServiceImpl$updateAdaptiveVolumeSwitch$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.Z$0;
        r100 = (DoraDevice) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        int r108 = ((Number) r105).intValue();
        boolean r109 = false;
        if (r108 == 0) goto L21;
        FLogger.f375446a.e("DoraServiceImpl", "updateAdaptiveVolumeSwitch: failed, enable=" + r101 + ", result=" + r108);
        return Boxing.boxBoolean(false);
    L21:
        String r110 = r100.f204389mac;
        if (r110 != null) goto L24;
    L40:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L33
        DoraAmbientVolumeSettingsNotifier r112 = DoraAmbientVolumeSettingsNotifier.f334888a;     // Catch: Throwable -> L33
        DoraAmbientVolumeSettingsNotifier.b(r100, r101);     // Catch: Throwable -> L33
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L33
    L35:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L39;
        FLogger.f375446a.e("DoraServiceImpl", "updateAdaptiveVolumeSwitch: failed to notify settings page", r114);
    L39:
        return Boxing.boxBoolean(true);
    L33:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L24:
        if (r110.length() <= 0) goto L26;
        r109 = true;
    L26:
        if (r109 == true) goto L29;
        r110 = null;
    L29:
        if (r110 == null) goto L40;
        com.larus.dora.impl.util.b0.f338123a.getClass();
        com.larus.dora.impl.util.b0.z(r110);
        goto L40
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        kj4.a r116 = kj4.a.g();
        r103.L$0 = r100;
        r103.Z$0 = r101;
        r103.label = 1;
        r105 = DoraAdapterExtKt.H(r116, r101 ? 1 : 0);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new DoraServiceImpl$updateAdaptiveVolumeSwitch$1(this, r102);
        goto L8
    }

    public final Object J1(DoraDevice r100, boolean r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof DoraServiceImpl$updateEnvironmentObservationSwitch$1) == false) goto L7;
        DoraServiceImpl$updateEnvironmentObservationSwitch$1 r101 = (DoraServiceImpl$updateEnvironmentObservationSwitch$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        r110 = r101.Z$0;
        IDoraPageConfig r105 = (IDoraPageConfig) r101.L$0;
        ResultKt.throwOnFailure(r112);
        Object r113 = ((Result) r112).m9458unboximpl();
    L27:
        if (Result.m9456isSuccessimpl(r113) == false) goto L29;
        r105.a("dora_g_config_key_env_observe_enable", r110);
        o49.b.f522007b.a();
        EnvObserveChangeReason r106 = EnvObserveChangeReason.SWITCH_CHANGE;
        Intrinsics.checkNotNullParameter(r106, "reason");
        DoraEnvObserveManager.f334593a.getClass();
        DoraEnvObserveManager.h(r106, 181);
        return Boxing.boxBoolean(true);
    L29:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        IDoraPageConfig r114 = (IDoraPageConfig) this.f331931n.getValue();
        if (r114 == null) goto L17;
        DoraNetworkApi r107 = DoraNetworkApi.f336157a;
        if (r110 == false) goto L21;
        String r108 = "1";
    L22:
        List<? extends Pair<String, ? extends Object>> r109 = CollectionsKt.listOf(TuplesKt.to("environmental_observation_switch", r108));
        r101.L$0 = r114;
        r101.Z$0 = r110;
        r101.label = 1;
        Object r115 = r107.y(r100, r109, r101);
        if (r115 != r103) goto L25;
        return r103;
    L25:
        r113 = r115;
        r105 = r114;
        goto L27
    L21:
        r108 = "0";
        goto L22
    L17:
        return Boxing.boxBoolean(false);
    L7:
        r101 = new DoraServiceImpl$updateEnvironmentObservationSwitch$1(this, r111);
        goto L8
    }

    @Override // mj4.h
    public final void Y(int r100, int r101, int r102) {
        GlobalAudioController.f289658a.l(r100, r101, r102);
    }

    @Override // com.larus.dora.api.IDoraService
    public final void g0(boolean r100, Integer r101, Integer r102) {
        IDoraAVLinkService r103 = v1();
        if (r103 == null) goto L6;
        r103.t(r100, r101, r102);
        return;
    }

    @Override // com.larus.dora.api.IDoraService
    public final void k0(String r100, int r101, t39.w r102) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r102, "callback");
        DoraLogManager r103 = DoraLogManager.f336045a;
        String r104 = DoraLogManager.q(r101);
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r104, "logType");
        Intrinsics.checkNotNullParameter(r102, "callback");
        DoraLogManager.f336051g = r102;
        DoraLogManager.z(new com.larus.dora.impl.log.b(r100, r104));
    }

    public static final Object n1(DoraServiceImpl r210, JSONObject r211, DoraDevice r212, Continuation r213) {
        DoraDevice r100 = r212;
        r210.getClass();
        if ((r213 instanceof DoraServiceImpl$executeAppAtomicRequest$1) == false) goto L7;
        DoraServiceImpl$executeAppAtomicRequest$1 r101 = (DoraServiceImpl$executeAppAtomicRequest$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        Boolean r106 = (Boolean) r101.L$2;
        String r107 = (String) r101.L$1;
        String r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L97:
        if (((Boolean) r103).booleanValue() == true) goto L120;
        FLogger.f375446a.e("DoraServiceImpl", "executeAppAtomicRequest: adaptive volume update failed, requestId=" + r108);
        return new a(r108, -1, "settings_sync_failed");
    L120:
        Boolean r109 = r106;
        String r110 = r107;
        String r111 = r108;
    L154:
        FLogger.f375446a.i("DoraServiceImpl", "executeAppAtomicRequest: success, requestId=" + r111 + ", method=" + r110 + ", enable=" + r109);
        return new a(r111, 0, "success");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r106 = (Boolean) r101.L$2;
        r107 = (String) r101.L$1;
        r108 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L118:
        if (((Boolean) r103).booleanValue() == true) goto L120;
        FLogger.f375446a.e("DoraServiceImpl", "executeAppAtomicRequest: settings sync failed, requestId=" + r108);
        return new a(r108, -1, "settings_sync_failed");
    L17:
        r106 = (Boolean) r101.L$3;
        String r112 = (String) r101.L$2;
        String r113 = (String) r101.L$1;
        DoraDevice r114 = (DoraDevice) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r110 = r112;
        r100 = r114;
        String r115 = r113;
    L109:
        if (((Boolean) r103).booleanValue() == true) goto L111;
        FLogger.f375446a.w("DoraServiceImpl", "executeAppAtomicRequest: privacy consent is required, requestId=" + r115 + ", code=5200");
        return new a(r115, 5200, "privacy_consent_required");
    L111:
        r111 = r115;
    L113:
        boolean r116 = r106.booleanValue();
        r101.L$0 = r111;
        r101.L$1 = r110;
        r101.L$2 = r106;
        r101.L$3 = null;
        r101.label = 2;
        Object r117 = r210.J1(r100, r116, r101);
        if (r117 == r104) goto L173;
        r108 = r111;
        r103 = r117;
        r107 = r110;
        goto L118
    L173:
        return r104;
    L18:
        ResultKt.throwOnFailure(r103);
        if (r211 == null) goto L21;
        r111 = D1(r211, "id");
    L22:
        if (r111 != null) goto L24;
        r111 = "";
    L24:
        if (r211 == null) goto L26;
        Object r118 = r211.opt(com.alipay.sdk.m.p.e.f25671s);
    L28:
        if ((r118 instanceof String) == false) goto L30;
        r110 = (String) r118;
    L32:
        if (r211 != null) goto L34;
    L155:
        FLogger.f375446a.w("DoraServiceImpl", "executeAppAtomicRequest: invalid request, requestId=".concat(r111));
        return new a(r111, -1, "invalid_request");
    L34:
        if (StringsKt.isBlank(r111) == true) goto L155;
        if (Intrinsics.areEqual(r211.opt("jsonrpc"), EventConstant.Value.AUTH_VERSION_2) == false) goto L155;
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"environment_observation", "wear_detection", "adaptive_volume"}), r110) == false) goto L155;
        Object r119 = r211.opt("params");
        if ((r119 instanceof JSONObject) == false) goto L44;
        Object r120 = ((JSONObject) r119).opt("enable");
    L53:
        if ((r120 instanceof Boolean) == false) goto L56;
        Boolean r121 = (Boolean) r120;
    L71:
        r109 = r121;
    L73:
        if (r109 != null) goto L76;
        FLogger.f375446a.w("DoraServiceImpl", "executeAppAtomicRequest: invalid params, requestId=".concat(r111));
        return new a(r111, -1, "invalid_request");
    L76:
        if (r100 != null) goto L78;
        FLogger.f375446a.w("DoraServiceImpl", "executeAppAtomicRequest: ByteLink unavailable, requestId=" + r111 + ", hasCurrentDevice=false");
        return new a(r111, TTVideoEngineInterface.PLAYER_OPTION_INT_ENABLE_FIX_SET_DISPLAY_MODE_SAR, "byte_link_unconnected");
    L78:
        int r122 = kj4.a.g().getDoraLinkState(r100);
        if (r122 == 2) goto L81;
        FLogger.f375446a.w("DoraServiceImpl", "executeAppAtomicRequest: ByteLink unavailable, requestId=" + r111 + ", hasCurrentDevice=true, linkState=" + r122);
        return new a(r111, TTVideoEngineInterface.PLAYER_OPTION_INT_ENABLE_FIX_SET_DISPLAY_MODE_SAR, "byte_link_unconnected");
    L81:
        if (r110 == null) goto L154;
        int r123 = r110.hashCode();
        if (r123 == (-2011541051)) goto L122;
        if (r123 == (-560536576)) goto L100;
        if (r123 != 1918958851) goto L154;
        if (r110.equals("adaptive_volume") == false) goto L154;
        boolean r124 = r109.booleanValue();
        r101.L$0 = r111;
        r101.L$1 = r110;
        r101.L$2 = r109;
        r101.label = 3;
        Object r125 = r210.I1(r100, r124, r101);
        if (r125 == r104) goto L171;
        r108 = r111;
        r107 = r110;
        r103 = r125;
        r106 = r109;
        goto L97
    L171:
        return r104;
    L100:
        if (r110.equals("environment_observation") == false) goto L154;
        if (r109.booleanValue() == false) goto L112;
        r101.L$0 = r100;
        r101.L$1 = r111;
        r101.L$2 = r110;
        r101.L$3 = r109;
        r101.label = 1;
        Object r126 = r210.z1(r100, r101);
        if (r126 == r104) goto L172;
        r115 = r111;
        r103 = r126;
        r106 = r109;
        goto L109
    L172:
        return r104;
    L112:
        r106 = r109;
        goto L113
    L122:
        if (r110.equals("wear_detection") == false) goto L154;
        boolean r127 = r109.booleanValue();
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L143
        kj4.a r129 = kj4.a.g();     // Catch: Throwable -> L143
        if (r127 == false) goto L128;
        byte r130 = 1;
    L129:
        int r131 = r129.x(r130);     // Catch: Throwable -> L143
        if (r131 == 0) goto L161;
        FLogger.f375446a.e("DoraServiceImpl", "updateWearDetectionSwitch: failed, enable=" + r127 + ", result=" + r131);     // Catch: Throwable -> L143
        boolean r132 = false;
    L141:
        Object r133 = Result.m9449constructorimpl(Boolean.valueOf(r132));     // Catch: Throwable -> L143
    L145:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L148;
        FLogger.f375446a.e("DoraServiceImpl", "updateWearDetectionSwitch: exception, enable=" + r127, r134);
    L148:
        Boolean r135 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r133) == false) goto L152;
        r133 = r135;
    L152:
        if (((Boolean) r133).booleanValue() == true) goto L154;
        FLogger.f375446a.e("DoraServiceImpl", "executeAppAtomicRequest: wear detection update failed, requestId=".concat(r111));
        return new a(r111, -1, "settings_sync_failed");
    L161:
        com.larus.dora.impl.device.settings.general.a.a(r100, r127);     // Catch: Throwable -> L135
        Object r136 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L135
    L137:
        Throwable r137 = Result.m9452exceptionOrNullimpl(r136);     // Catch: Throwable -> L143
        if (r137 == null) goto L140;
        FLogger.f375446a.e("DoraServiceImpl", "updateWearDetectionSwitch: failed to notify settings page", r137);     // Catch: Throwable -> L143
    L140:
        r132 = true;
        goto L141
    L135:
        th = move-exception;
        Result.Companion r138 = Result.Companion;     // Catch: Throwable -> L143
        r136 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L143
        goto L137
    L128:
        r130 = 0;
    L143:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L145
    L56:
        if ((r120 instanceof Integer) == false) goto L64;
        int r140 = ((Number) r120).intValue();
        if (r140 == 0) goto L62;
        if (r140 != 1) goto L72;
        r121 = Boolean.TRUE;
    L72:
        r109 = null;
        goto L73
    L62:
        r121 = Boolean.FALSE;
        goto L71
    L64:
        if ((r120 instanceof Long) == false) goto L72;
        long r141 = ((Number) r120).longValue();
        if (r141 != 0) goto L69;
        r121 = Boolean.FALSE;
        goto L71
    L69:
        if (r141 != 1) goto L72;
        r121 = Boolean.TRUE;
        goto L71
    L44:
        if ((r119 instanceof String) == true) goto L157;
    L51:
        r120 = null;
        goto L53
    L157:
        Result.Companion r142 = Result.Companion;     // Catch: Throwable -> L47
        r120 = Result.m9449constructorimpl(new JSONObject((String) r119).opt("enable"));     // Catch: Throwable -> L47
    L50:
        if (Result.m9455isFailureimpl(r120) == false) goto L53;
    L47:
        th = move-exception;
        Result.Companion r143 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L50
    L30:
        r110 = null;
        goto L32
    L26:
        r118 = null;
        goto L28
    L21:
        r111 = null;
    L7:
        r101 = new DoraServiceImpl$executeAppAtomicRequest$1(r210, r213);
        goto L8
    }

    @Override // com.larus.dora.api.IDoraService
    public final void C0(int r110, t39.u r111, boolean r112, boolean r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        DoraLogManager.C(r110, r111, false, false, r113, r112, r114, 12);
    }
}
