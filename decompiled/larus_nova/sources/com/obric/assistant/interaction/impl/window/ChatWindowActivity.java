package com.obric.assistant.interaction.impl.window;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.apm.ApmAgent;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.ChatBubbleParams;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.h4;
import com.larus.bmhome.chat.l4;
import com.larus.bmhome.setting.IFragmentProvider;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.setting.api.SettingService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.ActivityProxyListener;
import com.obric.assistant.interaction.api.service.IActivityResultHelperApi;
import com.obric.assistant.interaction.api.service.IActivityResultHelperApiKt;
import com.obric.assistant.interaction.api.window.IChatWindowActivity;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.interact.ObricInteractDelegate;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ¿\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002¿\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0002J$\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u000f2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\b\u00104\u001a\u00020+H\u0002J\b\u00105\u001a\u00020+H\u0002J\b\u00106\u001a\u00020+H\u0002J\b\u00107\u001a\u00020#H\u0002J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u00020\u00112\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010;\u001a\u00020\u00152\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010<\u001a\u00020=2\u0006\u00109\u001a\u00020\tH\u0002J\u0015\u0010>\u001a\u00020+2\u0006\u0010?\u001a\u00020@H\u0000¢\u0006\u0002\bAJ\u0017\u0010B\u001a\u00020+2\b\u0010C\u001a\u0004\u0018\u00010DH\u0000¢\u0006\u0002\bEJ\u0015\u0010F\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bIJ\r\u0010J\u001a\u00020+H\u0000¢\u0006\u0002\bKJ\b\u0010L\u001a\u00020DH\u0003J\n\u0010M\u001a\u0004\u0018\u00010NH\u0016J\n\u0010O\u001a\u0004\u0018\u00010NH\u0002J)\u0010P\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\u0012\u0010S\u001a\n\u0012\u0006\b\u0001\u0012\u00020U0T\"\u00020UH\u0002¢\u0006\u0002\u0010VJ \u0010W\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020#H\u0002J\u0017\u0010[\u001a\u00020+2\b\u0010\\\u001a\u0004\u0018\u00010DH\u0000¢\u0006\u0002\b]J\r\u0010^\u001a\u00020+H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020+H\u0000¢\u0006\u0002\baJ\r\u0010b\u001a\u00020+H\u0000¢\u0006\u0002\bcJ\r\u0010d\u001a\u00020+H\u0000¢\u0006\u0002\beJ\r\u0010f\u001a\u00020+H\u0000¢\u0006\u0002\bgJ\u001f\u0010h\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020+0jH\u0082\bJ\u0018\u0010k\u001a\u00020+2\u0006\u0010Q\u001a\u00020R2\u0006\u0010-\u001a\u00020.H\u0002J'\u0010l\u001a\u00020#2\u0006\u0010m\u001a\u00020=2\u0006\u0010n\u001a\u00020=2\b\u0010o\u001a\u0004\u0018\u00010\u0015H\u0000¢\u0006\u0002\bpJ\u0010\u0010q\u001a\u00020#2\u0006\u0010r\u001a\u00020sH\u0002J\b\u0010t\u001a\u00020\tH\u0016J\b\u0010u\u001a\u00020\u0011H\u0016J\b\u0010v\u001a\u00020\u0015H\u0016J\u0010\u0010w\u001a\u00020+2\u0006\u0010x\u001a\u00020\u0015H\u0016J\u0012\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u00020RH\u0016J\b\u0010|\u001a\u000203H\u0016J\b\u0010}\u001a\u00020\u000bH\u0016J\b\u0010~\u001a\u00020\u007fH\u0016J\u000e\u0010\u0080\u0001\u001a\u00070\u0081\u0001R\u00020\u007fH\u0016J\t\u0010\u0082\u0001\u001a\u00020RH\u0016J\n\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\u0007\u0010\u0087\u0001\u001a\u00020@J\u0013\u0010\u0088\u0001\u001a\u00020+2\b\u0010\\\u001a\u0004\u0018\u00010DH\u0014J\t\u0010\u0089\u0001\u001a\u00020+H\u0014J\t\u0010\u008a\u0001\u001a\u00020+H\u0014J\t\u0010\u008b\u0001\u001a\u00020+H\u0014J\t\u0010\u008c\u0001\u001a\u00020+H\u0014J\t\u0010\u008d\u0001\u001a\u00020+H\u0014J\t\u0010\u008e\u0001\u001a\u00020+H\u0014J\t\u0010\u008f\u0001\u001a\u00020+H\u0014J\u0013\u0010\u0090\u0001\u001a\u00020+2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0016J\u0019\u0010\u0093\u0001\u001a\u00020+2\b\u0010\u0091\u0001\u001a\u00030\u0092\u0001H\u0000¢\u0006\u0003\b\u0094\u0001J#\u0010\u0095\u0001\u001a\u00020+2\u0006\u0010m\u001a\u00020=2\u0006\u0010n\u001a\u00020=2\b\u0010o\u001a\u0004\u0018\u00010\u0015H\u0014J2\u0010\u0096\u0001\u001a\u00020+2\u0006\u0010m\u001a\u00020=2\u000f\u0010\u0097\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020R0T2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0016¢\u0006\u0003\u0010\u009a\u0001J9\u0010\u0096\u0001\u001a\u00020+2\u0006\u0010m\u001a\u00020=2\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020R0T2\b\u0010\u0098\u0001\u001a\u00030\u0099\u00012\u0007\u0010\u009b\u0001\u001a\u00020=H\u0016¢\u0006\u0003\u0010\u009c\u0001J\u000f\u0010\u009d\u0001\u001a\u00020#H\u0000¢\u0006\u0003\b\u009e\u0001J\u0012\u0010\u009f\u0001\u001a\u00020+2\u0007\u0010 \u0001\u001a\u00020RH\u0002J\t\u0010¡\u0001\u001a\u00020+H\u0016J\t\u0010¢\u0001\u001a\u00020+H\u0016J\t\u0010£\u0001\u001a\u00020+H\u0016J\t\u0010¤\u0001\u001a\u00020+H\u0016J\u0015\u0010¥\u0001\u001a\u00020+2\n\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001H\u0016J%\u0010¨\u0001\u001a\u00020+2\u0007\u0010©\u0001\u001a\u00020\u00152\u0006\u0010m\u001a\u00020=2\t\u0010ª\u0001\u001a\u0004\u0018\u00010DH\u0016JL\u0010«\u0001\u001a\u00020+2\b\u0010©\u0001\u001a\u00030¬\u00012\u0006\u0010m\u001a\u00020=2\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00152\u0007\u0010®\u0001\u001a\u00020=2\u0007\u0010¯\u0001\u001a\u00020=2\u0007\u0010°\u0001\u001a\u00020=2\t\u0010ª\u0001\u001a\u0004\u0018\u00010DH\u0017J\u0014\u0010±\u0001\u001a\u00020+2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u0015H\u0016J\u001f\u0010±\u0001\u001a\u00020+2\t\u0010©\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010ª\u0001\u001a\u0004\u0018\u00010DH\u0016J\"\u0010²\u0001\u001a\u00020+2\u0011\u0010³\u0001\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010TH\u0016¢\u0006\u0003\u0010´\u0001J-\u0010²\u0001\u001a\u00020+2\u0011\u0010³\u0001\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010T2\t\u0010ª\u0001\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0003\u0010µ\u0001J\u0012\u0010¶\u0001\u001a\u00020#2\u0007\u0010·\u0001\u001a\u00020RH\u0016J\f\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001H\u0016J\t\u0010º\u0001\u001a\u00020RH\u0016J\t\u0010»\u0001\u001a\u00020=H\u0016J\f\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001H\u0016J\t\u0010¾\u0001\u001a\u00020#H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006À\u0001"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/larus/bmhome/chat/IChatActivity;", "Lcom/larus/bmhome/chat/IDefaultChatActivity;", "Lcom/larus/bmhome/chat/ITraceActivity;", "Lcom/obric/assistant/interaction/api/window/IChatWindowActivity;", "app", "Landroid/app/Application;", "baseCtx", "Landroid/content/Context;", "win", "Landroid/view/Window;", "<init>", "(Landroid/app/Application;Landroid/content/Context;Landroid/view/Window;)V", "token", "Landroid/os/IBinder;", "fakeComponentName", "Landroid/content/ComponentName;", "activityInfo", "Landroid/content/pm/ActivityInfo;", "currentIntent", "Landroid/content/Intent;", "lifecycleDispatcher", "Lcom/obric/assistant/interaction/impl/window/FakeActivityLifecycleDispatcher;", "fakeActivityResultRegistry", "Lcom/obric/assistant/interaction/impl/window/ChatWindowActivityResultRegistry;", "androidXFragmentsController", "Landroidx/fragment/app/FragmentController;", "getAndroidXFragmentsController", "()Landroidx/fragment/app/FragmentController;", "androidXFragmentsController$delegate", "Lkotlin/Lazy;", "stage", "Lcom/obric/assistant/interaction/impl/window/FakeActivityStage;", "platformHostAttached", "", "destroyedDispatched", "finishRequested", "contentRoot", "Landroid/view/ViewGroup;", "mainHandler", "Landroid/os/Handler;", "configureAppCompatForFakeWindow", "", "shouldIgnoreDecorToolbarCrash", "error", "", "bindCoreFields", LiveEndPageData.TAG_WINDOW, "activityToken", "windowManager", "Landroid/view/WindowManager;", "bindAndroidXFields", "ensurePlatformHostAttached", "attachContextCompat", "attachContextImpl", "buildActivityInfo", "ctx", "buildFakeComponentName", "buildFakeIntent", "resolveDefaultTheme", "", "bindContentRoot", RootDescription.ROOT_ELEMENT, "Landroid/view/View;", "bindContentRoot$impl_mainlandRelease", "updateIntentExtras", "extras", "Landroid/os/Bundle;", "updateIntentExtras$impl_mainlandRelease", "mountChatFragment", "rootView", "Lcom/obric/assistant/interaction/impl/window/AssistantChatView;", "mountChatFragment$impl_mainlandRelease", "updateData", "updateData$impl_mainlandRelease", "buildChatBundleForWindow", "getChatFragment", "Landroidx/fragment/app/Fragment;", "findMountedChatFragment", "checkLifecycleState", "actionName", "", "expectedStates", "", "Landroidx/lifecycle/Lifecycle$State;", "(Ljava/lang/String;[Landroidx/lifecycle/Lifecycle$State;)V", "requireLifecycleDispatch", "event", "Landroidx/lifecycle/Lifecycle$Event;", "dispatched", "performCreate", "savedInstanceState", "performCreate$impl_mainlandRelease", "performStart", "performStart$impl_mainlandRelease", "performResume", "performResume$impl_mainlandRelease", "performPause", "performPause$impl_mainlandRelease", "performStop", "performStop$impl_mainlandRelease", "performDestroy", "performDestroy$impl_mainlandRelease", "performLifecycleAction", "action", "Lkotlin/Function0;", "reportLifecycleError", "dispatchActivityResultCompat", "requestCode", "resultCode", "data", "dispatchActivityResultCompat$impl_mainlandRelease", "startProxyActivity", "listener", "Lcom/obric/assistant/interaction/api/service/ActivityProxyListener;", "getApplicationContext", "getComponentName", "getIntent", "setIntent", "newIntent", "getSystemService", "", "name", "getWindowManager", "getWindow", "getResources", "Landroid/content/res/Resources;", "getTheme", "Landroid/content/res/Resources$Theme;", "getPackageName", "getLayoutInflater", "Landroid/view/LayoutInflater;", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "ensureDecorView", WidgetCostModule.TYPE_ON_CREATE, "onRestart", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "onPostResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "dispatchWindowConfigurationChanged", "dispatchWindowConfigurationChanged$impl_mainlandRelease", "onActivityResult", "onRequestPermissionsResult", ComplianceResult.JsonKey.PERMISSIONS, "grantResults", "", "(I[Ljava/lang/String;[I)V", "deviceId", "(I[Ljava/lang/String;[II)V", "canBeReusedByWindowHost", "canBeReusedByWindowHost$impl_mainlandRelease", "requestFinish", "reason", VideoEventOneOutSync.END_TYPE_FINISH, "finishAndRemoveTask", "finishAfterTransition", "finishAffinity", "finishFromChild", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/app/Activity;", "startActivityForResult", "intent", "options", "startIntentSenderForResult", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "startActivity", "startActivities", "intents", "([Landroid/content/Intent;)V", "([Landroid/content/Intent;Landroid/os/Bundle;)V", "shouldShowRequestPermissionRationale", "permission", "getVContext", "Lcom/larus/ui/arch/context/external/VContext;", "scene", "getTaskId", "getDisplay", "Landroid/view/Display;", "isTaskRoot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatWindowActivity extends AppCompatActivity implements d4, h4, l4, IChatWindowActivity {
    private static final String CATEGORY_CHAT_WINDOW_LIFECYCLE_ERROR = "chat_window_lifecycle_error";
    public static final Companion Companion = null;
    private static final String DECOR_TOOLBAR_CRASH_PREFIX = "Can't make a decor toolbar out of";
    private static final String EVENT_OBRIC_APP_ERROR = "obric_app_error";
    public static final String TAG = "ChatWindowActivity";
    private final ActivityInfo activityInfo;
    private final Lazy androidXFragmentsController$delegate;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private final Application f389733app;
    private final Context baseCtx;
    private ViewGroup contentRoot;
    private Intent currentIntent;
    private boolean destroyedDispatched;
    private final ChatWindowActivityResultRegistry fakeActivityResultRegistry;
    private final ComponentName fakeComponentName;
    private boolean finishRequested;
    private final FakeActivityLifecycleDispatcher lifecycleDispatcher;
    private final Handler mainHandler;
    private boolean platformHostAttached;
    private FakeActivityStage stage;
    private final IBinder token;
    private Window win;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/ChatWindowActivity$Companion;", "", "<init>", "()V", "TAG", "", "DECOR_TOOLBAR_CRASH_PREFIX", "EVENT_OBRIC_APP_ERROR", "CATEGORY_CHAT_WINDOW_LIFECYCLE_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ FragmentController A1(ChatWindowActivity r100) {
        return androidXFragmentsController_delegate$lambda$2(r100);
    }

    public static /* synthetic */ de8.a B1(Bundle r100, de8.a r101) {
        return updateData$lambda$32(r100, r101);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static /* synthetic */ void access$001(AppCompatActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    private static final Activity fakeActivityResultRegistry$lambda$0(ChatWindowActivity r100) {
        return r100;
    }

    private final int resolveDefaultTheme(Context r100) {
        return R.style.Theme_OApp_Home_Transparent;
    }

    public static /* synthetic */ Activity y1(ChatWindowActivity r100) {
        return fakeActivityResultRegistry$lambda$0(r100);
    }

    public static /* synthetic */ void z1(ChatWindowActivity r100, String r101) {
        requestFinish$lambda$51(r100, r101);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // android.app.Activity
    public int getTaskId() {
        return 0;
    }

    @Override // android.app.Activity
    public boolean isTaskRoot() {
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r100) {
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(this, r100);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    @Override // com.larus.bmhome.chat.l4
    public String scene() {
        return "O";
    }

    private final void attachContextCompat() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(attachContextImpl()));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        if (((Boolean) r101).booleanValue() == true) goto L15;
        attachBaseContext(this.baseCtx);
        return;
    L15:
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final boolean attachContextImpl() {
        Object r100 = ChatWindowReflectionCompat.ActivityThreadRef.INSTANCE.current();
        ChatWindowReflectionCompat.LoadedApkRef r101 = ChatWindowReflectionCompat.LoadedApkRef.INSTANCE;
        Application r102 = this.f389733app;
        Object r103 = r101.obtain(r102, r102.getApplicationContext());
        ChatWindowReflectionCompat.ContextImplRef r104 = ChatWindowReflectionCompat.ContextImplRef.INSTANCE;
        Context r105 = r104.createActivityContext(r100, r103, this.activityInfo, this.token, 0, null);
        if (r105 != null) goto L15;
        return false;
    L15:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L8
        r104.setOuterContext(r105, this);     // Catch: Throwable -> L8
        attachBaseContext(r105);     // Catch: Throwable -> L8
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L17;
        FLogger.f375446a.e("ChatWindowActivity", "attachContextImpl failed", r108);
        return true;
    L17:
        return true;
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void bindAndroidXFields() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setDeclaredFieldIfExists(this, ComponentActivity.class, "mActivityResultRegistry", this.fakeActivityResultRegistry);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setDeclaredFieldIfExists(this, ComponentActivity.class, "activityResultRegistry", this.fakeActivityResultRegistry);     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L12;
        FLogger.f375446a.e("ChatWindowActivity", "bindAndroidXFields failed", r102);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void configureAppCompatForFakeWindow() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(supportRequestWindowFeature(1)));     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L19;
        FLogger.f375446a.w("ChatWindowActivity", "supportRequestWindowFeature(NO_TITLE) failed", r102);
    L19:
        AppCompatDelegate r103 = getDelegate();     // Catch: Throwable -> L11
        Boolean r104 = Boolean.FALSE;     // Catch: Throwable -> L11
        ChatWindowActivityKt.access$setPrivateFieldOrLog(r103, "mHasActionBar", r104, "ChatWindowActivity");     // Catch: Throwable -> L11
        ChatWindowActivityKt.access$setPrivateFieldOrLog(r103, "mOverlayActionBar", r104, "ChatWindowActivity");     // Catch: Throwable -> L11
        ChatWindowActivityKt.access$setPrivateFieldOrLog(r103, "mWindowNoTitle", Boolean.TRUE, "ChatWindowActivity");     // Catch: Throwable -> L11
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L21;
        FLogger.f375446a.w("ChatWindowActivity", "configure AppCompat delegate failed", r106);
        return;
    L21:
        return;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void ensurePlatformHostAttached() {
        if (this.platformHostAttached == false) goto L25;
        return;
    L25:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L19
        Field r101 = ChatWindowActivityKt.access$findDeclaredField(Activity.class, "mFragments");     // Catch: Throwable -> L19
        if (r101 == null) goto L18;
        Object r102 = r101.get(this);     // Catch: Throwable -> L19
        if (r102 == null) goto L18;
        Method r103 = r102.getClass().getDeclaredMethod("getFragmentManager", new Class[0]);     // Catch: Throwable -> L19
        r103.setAccessible(true);     // Catch: Throwable -> L19
        Object r104 = r103.invoke(r102, new Object[0]);     // Catch: Throwable -> L19
        Field r105 = ChatWindowActivityKt.access$findDeclaredField(r104.getClass(), "mHost");     // Catch: Throwable -> L19
        if (r105 == null) goto L12;
        Object r106 = r105.get(r104);     // Catch: Throwable -> L19
    L13:
        if (r106 == null) goto L16;
        this.platformHostAttached = true;     // Catch: Throwable -> L19
        return;
    L16:
        Method r107 = r102.getClass().getDeclaredMethod("attachHost", new Class[]{INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.Fragment")});     // Catch: Throwable -> L19
        r107.setAccessible(true);     // Catch: Throwable -> L19
        r107.invoke(r102, new Object[]{null});     // Catch: Throwable -> L19
        this.platformHostAttached = true;     // Catch: Throwable -> L19
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L26;
        FLogger.f375446a.e("ChatWindowActivity", "ensurePlatformHostAttached failed", r109);
        return;
    L26:
        return;
    L12:
        r106 = null;
    L18:
        throw new IllegalStateException("Activity#mFragments not found".toString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    private final FragmentController getAndroidXFragmentsController() {
        return (FragmentController) this.androidXFragmentsController$delegate.getValue();
    }

    public final boolean canBeReusedByWindowHost$impl_mainlandRelease() {
        if (this.finishRequested == false) goto L5;
    L9:
        return false;
    L5:
        if (isFinishing() == true) goto L9;
        if (isDestroyed() == true) goto L9;
        return true;
    }

    public void com_obric_assistant_interaction_impl_window_ChatWindowActivity__finish$___twin___() {
        requestFinish(VideoEventOneOutSync.END_TYPE_FINISH);
    }

    public void com_obric_assistant_interaction_impl_window_ChatWindowActivity__onDestroy$___twin___() {
        FLogger.f375446a.i("ChatWindowActivity", "onDestroy: " + this);
        super.onDestroy();
    }

    public void com_obric_assistant_interaction_impl_window_ChatWindowActivity__onStop$___twin___() {
        FLogger.f375446a.i("ChatWindowActivity", "onStop: " + this);
        super.onStop();
    }

    public final View ensureDecorView() {
        return INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(this.win);
    }

    @Override // android.app.Activity
    public void finishAffinity() {
        requestFinish("finishAffinity");
    }

    @Override // android.app.Activity
    public void finishAfterTransition() {
        requestFinish("finishAfterTransition");
    }

    @Override // android.app.Activity
    public void finishAndRemoveTask() {
        requestFinish("finishAndRemoveTask");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        Context r100 = this.f389733app.getApplicationContext();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.f389733app;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Display getDisplay() {
        Object r100 = getSystemService("display");
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        return ((DisplayManager) r100).getDisplay(0);
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        Object r100 = super.getSystemService("layout_inflater");
        if ((r100 instanceof LayoutInflater) == false) goto L5;
        LayoutInflater r101 = (LayoutInflater) r100;
    L6:
        if (r101 != null) goto L9;
        r101 = LayoutInflater.from(getBaseContext());
    L9:
        return r101.cloneInContext(this);
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.baseCtx.getPackageName();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.baseCtx.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(super.getTheme());     // Catch: Throwable -> L4
    L7:
        if (Result.m9452exceptionOrNullimpl(r101) == null) goto L11;
        r101 = this.baseCtx.getTheme();
    L11:
        return (Resources.Theme) r101;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // android.app.Activity
    public WindowManager getWindowManager() {
        return this.win.getWindowManager();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        FLogger.f375446a.i("ChatWindowActivity", "onPause: " + this);
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        FLogger.f375446a.i("ChatWindowActivity", "onPostResume: " + this);
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        super.onPostResume();     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 != null) goto L10;
        return;
    L10:
        if (shouldIgnoreDecorToolbarCrash(r102) == false) goto L13;
        FLogger.f375446a.w("ChatWindowActivity", "ignore decor toolbar init for fake window", r102);
        configureAppCompatForFakeWindow();
        return;
    L13:
        throw r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // android.app.Activity
    public void onRestart() {
        FLogger.f375446a.i("ChatWindowActivity", "onRestart: " + this);
        super.onRestart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        FLogger.f375446a.i("ChatWindowActivity", "onResume: " + this);
        super.onResume();
        SettingService.f367887a.k();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        FLogger.f375446a.i("ChatWindowActivity", "onStart: " + this);
        super.onStart();
    }

    public final void performDestroy$impl_mainlandRelease() {
    L18:
        th = move-exception;
        FLogger.f375446a.e("ChatWindowActivity", "performLifecycleAction performDestroy failed with error: " + th.getMessage(), th);
        reportLifecycleError("performDestroy", th);
        throw th;
    L4:
        if (this.destroyedDispatched == true) goto L23;
        FakeActivityStage r100 = this.stage;     // Catch: Throwable -> L18
        FakeActivityStage r101 = FakeActivityStage.DESTROYED;     // Catch: Throwable -> L18
        if (r100 != r101) goto L9;
        return;
    L9:
        if (r100 != FakeActivityStage.RESUMED) goto L11;
    L12:
        performStop$impl_mainlandRelease();     // Catch: Throwable -> L18
    L14:
        if (this.stage != FakeActivityStage.INITIALIZED) goto L16;
        this.stage = FakeActivityStage.CREATED;     // Catch: Throwable -> L18
    L16:
        checkLifecycleState("performDestroy", new Lifecycle.State[]{Lifecycle.State.INITIALIZED, Lifecycle.State.CREATED});     // Catch: Throwable -> L18
        this.lifecycleDispatcher.dispatchPreDestroy(this);     // Catch: Throwable -> L18
        Boolean r102 = Boolean.TRUE;     // Catch: Throwable -> L18
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mFinished", r102);     // Catch: Throwable -> L18
        onDestroy();     // Catch: Throwable -> L18
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mDestroyed", r102);     // Catch: Throwable -> L18
        requireLifecycleDispatch("performDestroy", Lifecycle.Event.ON_DESTROY, this.lifecycleDispatcher.dispatchDestroy(this));     // Catch: Throwable -> L18
        this.destroyedDispatched = true;     // Catch: Throwable -> L18
        this.stage = r101;     // Catch: Throwable -> L18
        return;
    L11:
        if (r100 != FakeActivityStage.STARTED) goto L14;
    }

    public final void performPause$impl_mainlandRelease() {
    L8:
        th = move-exception;
        FLogger.f375446a.e("ChatWindowActivity", "performLifecycleAction performPause failed with error: " + th.getMessage(), th);
        reportLifecycleError("performPause", th);
        throw th;
    L4:
        if (this.stage == FakeActivityStage.RESUMED) goto L6;
        return;
    L6:
        checkLifecycleState("performPause", new Lifecycle.State[]{Lifecycle.State.RESUMED});     // Catch: Throwable -> L8
        onPause();     // Catch: Throwable -> L8
        requireLifecycleDispatch("performPause", Lifecycle.Event.ON_PAUSE, this.lifecycleDispatcher.dispatchPause(this));     // Catch: Throwable -> L8
        this.stage = FakeActivityStage.STARTED;     // Catch: Throwable -> L8
    }

    public final void performResume$impl_mainlandRelease() {
        FakeActivityStage r100 = this.stage;     // Catch: Throwable -> L17
        if (r100 == FakeActivityStage.DESTROYED) goto L22;
        FakeActivityStage r101 = FakeActivityStage.RESUMED;     // Catch: Throwable -> L17
        if (r100 != r101) goto L9;
        return;
    L9:
        if (r100 != FakeActivityStage.INITIALIZED) goto L11;
    L14:
        performStart$impl_mainlandRelease();     // Catch: Throwable -> L17
    L15:
        checkLifecycleState("performResume", new Lifecycle.State[]{Lifecycle.State.STARTED});     // Catch: Throwable -> L17
        onResume();     // Catch: Throwable -> L17
        onPostResume();     // Catch: Throwable -> L17
        requireLifecycleDispatch("performResume", Lifecycle.Event.ON_RESUME, this.lifecycleDispatcher.dispatchResume(this));     // Catch: Throwable -> L17
        this.stage = r101;     // Catch: Throwable -> L17
        return;
    L11:
        if (r100 == FakeActivityStage.CREATED) goto L14;
        if (r100 != FakeActivityStage.STOPPED) goto L15;
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("ChatWindowActivity", "performLifecycleAction performResume failed with error: " + th.getMessage(), th);
        reportLifecycleError("performResume", th);
        throw th;
    }

    public final void performStart$impl_mainlandRelease() {
        FakeActivityStage r100 = this.stage;     // Catch: Throwable -> L18
        if (r100 == FakeActivityStage.DESTROYED) goto L23;
        FakeActivityStage r101 = FakeActivityStage.STARTED;     // Catch: Throwable -> L18
        if (r100 != r101) goto L8;
        return;
    L8:
        if (r100 != FakeActivityStage.RESUMED) goto L11;
        return;
    L11:
        if (r100 != FakeActivityStage.INITIALIZED) goto L14;
        performCreate$impl_mainlandRelease(null);     // Catch: Throwable -> L18
    L14:
        if (this.stage != FakeActivityStage.STOPPED) goto L16;
        onRestart();     // Catch: Throwable -> L18
    L16:
        checkLifecycleState("performStart", new Lifecycle.State[]{Lifecycle.State.CREATED});     // Catch: Throwable -> L18
        onStart();     // Catch: Throwable -> L18
        requireLifecycleDispatch("performStart", Lifecycle.Event.ON_START, this.lifecycleDispatcher.dispatchStart(this));     // Catch: Throwable -> L18
        this.stage = r101;     // Catch: Throwable -> L18
        return;
    L23:
        return;
    L18:
        th = move-exception;
        FLogger.f375446a.e("ChatWindowActivity", "performLifecycleAction performStart failed with error: " + th.getMessage(), th);
        reportLifecycleError("performStart", th);
        throw th;
    }

    public final void performStop$impl_mainlandRelease() {
        FakeActivityStage r100 = this.stage;     // Catch: Throwable -> L17
        if (r100 != FakeActivityStage.DESTROYED) goto L6;
        return;
    L6:
        if (r100 != FakeActivityStage.INITIALIZED) goto L8;
        return;
    L8:
        if (r100 == FakeActivityStage.CREATED) goto L24;
        FakeActivityStage r101 = FakeActivityStage.STOPPED;     // Catch: Throwable -> L17
        if (r100 != r101) goto L13;
        return;
    L13:
        if (r100 != FakeActivityStage.RESUMED) goto L15;
        performPause$impl_mainlandRelease();     // Catch: Throwable -> L17
    L15:
        checkLifecycleState("performStop", new Lifecycle.State[]{Lifecycle.State.STARTED});     // Catch: Throwable -> L17
        onStop();     // Catch: Throwable -> L17
        requireLifecycleDispatch("performStop", Lifecycle.Event.ON_STOP, this.lifecycleDispatcher.dispatchStop(this));     // Catch: Throwable -> L17
        this.stage = r101;     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("ChatWindowActivity", "performLifecycleAction performStop failed with error: " + th.getMessage(), th);
        reportLifecycleError("performStop", th);
        throw th;
    }

    private final Bundle buildChatBundleForWindow() {
        Bundle r100 = getIntent().getExtras();
        if (r100 == null) goto L6;
        Bundle r101 = r100.deepCopy();
        if (r101 == null) goto L6;
    L7:
        r101.putBoolean("O_WINDOW_CHAT", true);
        r101.putBoolean("disable_onboarding_tts", true);
        r101.putBoolean("isMultiWindowMode", true);
        r101.putParcelable("argChatBubbleParamsFromHost", new ChatBubbleParams(true, 6));
        return r101;
    L6:
        r101 = new Bundle();
        goto L7
    }

    private final Fragment findMountedChatFragment() {
        return (Fragment) CollectionsKt.firstOrNull(getSupportFragmentManager().getFragments());
    }

    @Override // com.obric.assistant.interaction.api.window.IChatWindowActivity
    public Fragment getChatFragment() {
        return findMountedChatFragment();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public FragmentManager getSupportFragmentManager() {
        return super.getSupportFragmentManager();
    }

    @Override // com.larus.bmhome.chat.d4
    public t1a.b getVContext() {
        Fragment r100 = (Fragment) CollectionsKt.firstOrNull(getSupportFragmentManager().getFragments());
        if (r100 != null) goto L7;
        return null;
    L7:
        return s1a.a.g(r100);
    }

    public final void updateData$impl_mainlandRelease() {
        Fragment r100 = findMountedChatFragment();
        if (r100 != null) goto L6;
        FLogger.f375446a.w("ChatWindowActivity", "updateData skipped because chat fragment is not mounted");
        return;
    L6:
        final Bundle r101 = buildChatBundleForWindow();
        t1a.b r102 = s1a.a.g(r100);
        de8.c r103 = (de8.c) r102.a(de8.c.class);
        if (r103 == null) goto L14;
        Bundle r104 = r103.f468085a;
        if (r104 == null) goto L11;
        r104.clear();
        r104.putAll(r101);
    L11:
        Bundle r105 = r103.f468086b;
        if (r105 == null) goto L14;
        r105.clear();
        r105.putAll(r101);
    L14:
        t1a.e r106 = r102.e(de8.a.class);
        if (r106 == null) goto L18;
        r106.a(new c(r101));
        return;
    }

    @Override // android.app.Activity
    public ComponentName getComponentName() {
        return this.fakeComponentName;
    }

    @Override // android.app.Activity
    public Intent getIntent() {
        return this.currentIntent;
    }

    @Override // android.app.Activity
    public Window getWindow() {
        return this.win;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static View INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ Handler access$getMainHandler$p(ChatWindowActivity r100) {
        return r100.mainHandler;
    }

    private static final FragmentController androidXFragmentsController_delegate$lambda$2(ChatWindowActivity r100) {
        Field r101 = ChatWindowActivityKt.access$findDeclaredField(FragmentActivity.class, "mFragments");
        FragmentController r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get(r100);
    L7:
        if ((r103 instanceof FragmentController) == false) goto L9;
        r102 = (FragmentController) r103;
    L9:
        if (r102 != null) goto L11;
        FLogger.f375446a.w("ChatWindowActivity", "FragmentActivity#mFragments not found, noteStateNotSaved will be skipped");
    L11:
        return r102;
    L5:
        r103 = null;
        goto L7
    }

    private final ActivityInfo buildActivityInfo(Context r100) {
        ActivityInfo r101 = new ActivityInfo();
        r101.packageName = r100.getPackageName();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 0));     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        Object r105 = r103;
        if (r104 == null) goto L11;
        ApplicationInfo r106 = new ApplicationInfo();
        r106.packageName = r100.getPackageName();
        r105 = r106;
    L11:
        r101.applicationInfo = (ApplicationInfo) r105;
        r101.theme = resolveDefaultTheme(r100);
        r101.name = this.fakeComponentName.getClassName();
        return r101;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final ComponentName buildFakeComponentName(Context r100) {
        return new ComponentName(r100.getPackageName(), ChatWindowActivity.class.getName());
    }

    private final Intent buildFakeIntent(Context r100) {
        Intent r101 = new Intent();
        r101.setComponent(this.fakeComponentName);
        r101.setPackage(r100.getPackageName());
        return r101;
    }

    public static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ChatWindowActivity r100) {
        r100.com_obric_assistant_interaction_impl_window_ChatWindowActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(ChatWindowActivity r100) {
        r100.com_obric_assistant_interaction_impl_window_ChatWindowActivity__finish$___twin___();
    }

    public static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(ChatWindowActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.com_obric_assistant_interaction_impl_window_ChatWindowActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    private final void requestFinish(final String r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("ChatWindowActivity", "requestFinish reason=" + r100);
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mFinished", Boolean.TRUE);
        if (this.finishRequested == false) goto L6;
        r101.i("ChatWindowActivity", "requestFinish ignored, already requested");
        return;
    L6:
        this.finishRequested = true;
        this.mainHandler.post(new b(this, r100));
    }

    private final boolean shouldIgnoreDecorToolbarCrash(Throwable r100) {
        if ((r100 instanceof IllegalStateException) == false) goto L13;
        String r101 = r100.getMessage();
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (StringsKt.startsWith$default(r101, DECOR_TOOLBAR_CRASH_PREFIX, false, 2, null) != true) goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }

    private final boolean startProxyActivity(ActivityProxyListener r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        IActivityResultHelperApi r102 = IActivityResultHelperApiKt.getActivityResultHelper();     // Catch: Throwable -> L8
        if (r102 != null) goto L5;
        boolean r103 = false;
    L6:
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(r103));     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L15;
        FLogger.f375446a.e("ChatWindowActivity", "startProxyActivity failed", r105);
        r104 = Boolean.FALSE;
    L15:
        return ((Boolean) r104).booleanValue();
    L5:
        r102.startActivityForResult(r100);     // Catch: Throwable -> L8
        r103 = true;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void bindContentRoot$impl_mainlandRelease(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        this.contentRoot = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public void com_obric_assistant_interaction_impl_window_ChatWindowActivity__onCreate$___twin___(Bundle r100) {
        FLogger r101 = FLogger.f375446a;
        r101.i("ChatWindowActivity", "onCreate: " + this);
        configureAppCompatForFakeWindow();
        boolean r102 = getIntent().getBooleanExtra("wakeup_assistant", false);
        r101.d("ChatWindowActivity", "handleWakeup: " + r102 + ", " + getIntent());
        ObricInteractDelegate.f392884b.notifyWakeupEvent(r102);
        ensurePlatformHostAttached();
        super.onCreate(r100);
    }

    public final void dispatchWindowConfigurationChanged$impl_mainlandRelease(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, new Configuration(r100));
    }

    @Override // android.app.Activity
    public void finishFromChild(Activity r100) {
        FLogger.f375446a.i("ChatWindowActivity", "finishFromChild child=" + r100);
        requestFinish("finishFromChild");
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (Intrinsics.areEqual(LiveEndPageData.TAG_WINDOW, r100) == false) goto L7;
        return this.win.getWindowManager();
    L7:
        if (Intrinsics.areEqual("layout_inflater", r100) == false) goto L17;
        Object r101 = super.getSystemService(r100);
        if ((r101 instanceof LayoutInflater) == false) goto L11;
        LayoutInflater r102 = (LayoutInflater) r101;
    L12:
        if (r102 != null) goto L15;
        r102 = LayoutInflater.from(getBaseContext());
    L15:
        return r102.cloneInContext(this);
    L11:
        r102 = null;
        goto L12
    L17:
        return super.getSystemService(r100);
    }

    public final void mountChatFragment$impl_mainlandRelease(AssistantChatView r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        if (findMountedChatFragment() == null) goto L5;
        return;
    L5:
        IFragmentProvider r101 = (IFragmentProvider) ServiceManager.get().getService(IFragmentProvider.class);
        if (r101 == null) goto L10;
        Fragment r102 = r101.e(buildChatBundleForWindow());
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(getSupportFragmentManager().beginTransaction(), r100.getFragmentContainerId$impl_mainlandRelease(), r102).commitNowAllowingStateLoss();
        sga.e.a(r100);
        return;
    L10:
        throw new IllegalStateException("IFragmentProvider.getService returned null".toString());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        FragmentController r101 = getAndroidXFragmentsController();
        if (r101 == null) goto L5;
        r101.noteStateNotSaved();
    L5:
        INVOKESPECIAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
    }

    public final void performCreate$impl_mainlandRelease(Bundle r100) {
    L8:
        th = move-exception;
        FLogger.f375446a.e("ChatWindowActivity", "performLifecycleAction performCreate failed with error: " + th.getMessage(), th);
        reportLifecycleError("performCreate", th);
        throw th;
    L4:
        if (this.stage == FakeActivityStage.INITIALIZED) goto L6;
        return;
    L6:
        checkLifecycleState("performCreate", new Lifecycle.State[]{Lifecycle.State.INITIALIZED});     // Catch: Throwable -> L8
        onCreate(r100);     // Catch: Throwable -> L8
        requireLifecycleDispatch("performCreate", Lifecycle.Event.ON_CREATE, this.lifecycleDispatcher.dispatchCreate(this, r100));     // Catch: Throwable -> L8
        this.stage = FakeActivityStage.CREATED;     // Catch: Throwable -> L8
    }

    @Override // android.app.Activity
    public void setIntent(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "newIntent");
        this.currentIntent = r100;
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mIntent", r100);
        super.setIntent(r100);
    }

    @Override // android.app.Activity
    public boolean shouldShowRequestPermissionRationale(String r100) {
        Intrinsics.checkNotNullParameter(r100, "permission");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_shouldShowRequestPermissionRationale_super(this, r100)));     // Catch: Throwable -> L5
    L7:
        Boolean r103 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = r103;
    L11:
        return ((Boolean) r102).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r100) {
        if (r100 != null) goto L15;
        return;
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        int r102 = r100.length;     // Catch: Throwable -> L9
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        r100[r103].addFlags(268435456);     // Catch: Throwable -> L9
        r103 = r103 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        getBaseContext().startActivities(r100);     // Catch: Throwable -> L9
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L18;
        FLogger.f375446a.e("ChatWindowActivity", "startActivities failed", r105);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r100) {
        startActivity(r100, null);
    }

    public final void updateIntentExtras$impl_mainlandRelease(Bundle r100) {
        Intent r101 = new Intent(this.currentIntent);
        if (r100 == null) goto L5;
        Bundle r102 = new Bundle(r100);
    L6:
        r101.replaceExtras(r102);
        setIntent(r101);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static void INVOKESPECIAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(AppCompatActivity r100, Configuration r101) {
        access$001(r100, r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r102 = r100.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L24;
        r100.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r100.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != r102) goto L14;
        return;
    L8:
        r103 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(ChatWindowActivity r100, Configuration r101) {
        r100.onConfigurationChanged(r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L22;
        int r102 = r100.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L24;
        r100.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:ChatWindowActivity portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != r102) goto L14;
        return;
    L8:
        r103 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    public static final /* synthetic */ boolean access$startProxyActivity(ChatWindowActivity r100, ActivityProxyListener r101) {
        return r100.startProxyActivity(r101);
    }

    private final void checkLifecycleState(String r110, Lifecycle.State... r111) {
        Lifecycle.State r100 = getLifecycle().getCurrentState();
        if (ArraysKt.contains(r111, r100) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("ChatWindowActivity " + r110 + " invalid lifecycle state, expected=" + ArraysKt.joinToString$default(r111, null, null, null, 0, null, null, 63, null) + ", actual=" + r100 + ", activity=" + this);
    }

    private static boolean com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_shouldShowRequestPermissionRationale_super(AppCompatActivity r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_shouldShowRequestPermissionRationale_super");
        g06.a r102 = ApiHookConfig.f245611b.get(102609);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102609, "androidx/appcompat/app/AppCompatActivity", "shouldShowRequestPermissionRationale", r110, r101, "boolean", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Boolean) r107.f474983b).booleanValue();
    L21:
        return super.shouldShowRequestPermissionRationale(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_larus_home_impl_utils_ActivityThemeLancet_onCreate(ChatWindowActivity r100, Bundle r101) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(r100.getTheme());     // Catch: Throwable -> L10
    L6:
        if (v19.f.f(r100) == false) goto L8;
        v19.f.c(r100.getTheme());     // Catch: Throwable -> L10
    L8:
        r100.com_obric_assistant_interaction_impl_window_ChatWindowActivity__onCreate$___twin___(r101);
    }

    private final void performLifecycleAction(String r100, Function0<Unit> r101) {
        r101.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        FLogger.f375446a.e("ChatWindowActivity", "performLifecycleAction " + r100 + " failed with error: " + th.getMessage(), th);
        reportLifecycleError(r100, th);
        throw th;
    }

    private final void reportLifecycleError(String r100, Throwable r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L7
        r103.put("action", r100);     // Catch: Throwable -> L7
        r103.put("activity", toString());     // Catch: Throwable -> L7
        r103.put("error", r101.getClass().getName());     // Catch: Throwable -> L7
        String r104 = r101.getMessage();     // Catch: Throwable -> L7
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103.put("message", r104);     // Catch: Throwable -> L7
        r103.put("stacktrace", ExceptionsKt.stackTraceToString(r101));     // Catch: Throwable -> L7
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L7
        r105.put("category", CATEGORY_CHAT_WINDOW_LIFECYCLE_ERROR);     // Catch: Throwable -> L7
        ApmAgent.monitorEvent(EVENT_OBRIC_APP_ERROR, r105, null, r103);     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L15;
        FLogger.f375446a.e("ChatWindowActivity", "reportLifecycleError failed", r107);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    private static final void requestFinish$lambda$51(ChatWindowActivity r100, String r101) {
        WindowHost.INSTANCE.dismissWithReasonIfCurrent(r100, r101);
    }

    private static final de8.a updateData$lambda$32(Bundle r100, de8.a r101) {
        Intrinsics.checkNotNullParameter(r101, "resultFirstData");
        Bundle r102 = new Bundle(r100);
        r101.getClass();
        return new de8.a(r102);
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r100, Bundle r101) {
        if (r100 != null) goto L15;
        return;
    L15:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        int r103 = r100.length;     // Catch: Throwable -> L9
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        r100[r104].addFlags(268435456);     // Catch: Throwable -> L9
        r104 = r104 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        getBaseContext().startActivities(r100, r101);     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L18;
        FLogger.f375446a.e("ChatWindowActivity", "startActivities(options) failed", r106);
        return;
    L18:
        return;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r100, Bundle r101) {
        if (r100 != null) goto L12;
        return;
    L12:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        r100.addFlags(268435456);     // Catch: Throwable -> L6
        getBaseContext().startActivity(r100, r101);     // Catch: Throwable -> L6
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L14;
        FLogger.f375446a.e("ChatWindowActivity", "startActivity failed", r104);
        return;
    L14:
        return;
    L6:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public ChatWindowActivity(Application r100, Context r101, Window r102) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "baseCtx");
        Intrinsics.checkNotNullParameter(r102, "win");
        this.f389733app = r100;
        this.baseCtx = r101;
        this.win = r102;
        this.token = new Binder();
        this.fakeComponentName = buildFakeComponentName(r101);
        this.activityInfo = buildActivityInfo(r101);
        this.currentIntent = buildFakeIntent(r101);
        this.lifecycleDispatcher = new FakeActivityLifecycleDispatcher();
        this.fakeActivityResultRegistry = new ChatWindowActivityResultRegistry(new d(this), new ChatWindowActivity$fakeActivityResultRegistry$2(this));
        this.androidXFragmentsController$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new e(this));
        this.stage = FakeActivityStage.INITIALIZED;
        this.mainHandler = new Handler(Looper.getMainLooper());
        FLogger.f375446a.i("ChatWindowActivity", "ChatWindowActivity init win=" + this.win + " token=" + this.win.getAttributes().token);
        attachContextCompat();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        setTheme(R.style.Theme_OApp_Home_Transparent);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L13:
        v19.f.a(getTheme());     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Window r104 = this.win;
        bindCoreFields(r104, this.token, r104.getWindowManager());
        configureAppCompatForFakeWindow();
        bindAndroidXFields();
        ensurePlatformHostAttached();
        Boolean r105 = Boolean.FALSE;
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mFinished", r105);
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mDestroyed", r105);
        return;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, int r101, Fragment r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r102, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, r101) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    private final void bindCoreFields(Window r100, IBinder r101, WindowManager r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldSafely(this, "mApplication", this.f389733app);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldSafely(this, "mWindow", r100);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mWindowManager", r102);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mToken", r101);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mActivityInfo", this.activityInfo);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mComponent", this.fakeComponentName);     // Catch: Throwable -> L4
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mIntent", this.currentIntent);     // Catch: Throwable -> L4
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L25;
        FLogger.f375446a.e("ChatWindowActivity", "bindCoreFields failed", r105);
    L25:
        ChatWindowReflectionCompat.ActivityThreadRef r106 = ChatWindowReflectionCompat.ActivityThreadRef.INSTANCE;     // Catch: Throwable -> L17
        Object r107 = r106.current();     // Catch: Throwable -> L17
        if (r107 == null) goto L12;
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mMainThread", r107);     // Catch: Throwable -> L17
    L12:
        Instrumentation r108 = r106.instrumentation(r107);     // Catch: Throwable -> L17
        if (r108 == null) goto L15;
        ChatWindowActivityKt.access$setPrivateFieldIfExists(this, "mInstrumentation", r108);     // Catch: Throwable -> L17
    L15:
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L27;
        FLogger.f375446a.e("ChatWindowActivity", "bindCoreFields instrumentation failed", r110);
        return;
    L27:
        return;
    L17:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    private final void requireLifecycleDispatch(String r100, Lifecycle.Event r101, boolean r102) {
        if (r102 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException("ChatWindowActivity " + r100 + " failed to dispatch " + r101 + ", stage=" + this.stage + ", lifecycle=" + getLifecycle().getCurrentState() + ", activity=" + this);
    }

    public final boolean dispatchActivityResultCompat$impl_mainlandRelease(int r100, int r101, Intent r102) {
        return this.fakeActivityResultRegistry.dispatchRawResult(r100, r101, r102);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r100, int r101, Intent r102) {
        FragmentController r103 = getAndroidXFragmentsController();
        if (r103 == null) goto L6;
        r103.noteStateNotSaved();
    L6:
        if (this.fakeActivityResultRegistry.dispatchRawResult(r100, r101, r102) == false) goto L8;
        return;
    L8:
        super.onActivityResult(r100, r101, r102);
        if (r102 == null) goto L19;
        Bundle r104 = r102.getExtras();
        if (r104 == null) goto L20;
        ActivityResultCaller r105 = getChatFragment();
        if ((r105 instanceof xe8.a) == false) goto L15;
        xe8.a r106 = (xe8.a) r105;
    L16:
        if (r106 == null) goto L21;
        r106.Lc(r104, r100, r101);
        return;
    L21:
        return;
    L15:
        r106 = null;
        goto L16
    L20:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r100, String[] r101, int[] r102) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "grantResults");
        FragmentController r103 = getAndroidXFragmentsController();
        if (r103 == null) goto L5;
        r103.noteStateNotSaved();
    L5:
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_onRequestPermissionsResult_super(this, r100, r101, r102);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        ChatWindowActivity$startActivityForResult$listener$1 r103 = new ChatWindowActivity$startActivityForResult$listener$1(r101, this, r100, r102);
        if (startProxyActivity(r103) == false) goto L5;
        return;
    L5:
        if (r103.getProxyTerminalGate().tryComplete() == true) goto L7;
        return;
    L7:
        FLogger.f375446a.w("ChatWindowActivity", "startActivityForResult fallback to Context.startActivity, requestCode=" + r101);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L10
        r100.addFlags(268435456);     // Catch: Throwable -> L10
        getBaseContext().startActivity(r100, r102);     // Catch: Throwable -> L10
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L19;
        FLogger.f375446a.e("ChatWindowActivity", "startActivityForResult fallback failed", r106);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_androidx_appcompat_app_AppCompatActivity_onRequestPermissionsResult_super(AppCompatActivity r110, int r111, String[] r210, int[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111), r210, r211};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102611);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102611, "androidx/appcompat/app/AppCompatActivity", "onRequestPermissionsResult", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        super.onRequestPermissionsResult(r111, r210, r211);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private static void com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_ChatWindowActivity_onRequestPermissionsResult(ChatWindowActivity r110, int r111, String[] r210, int[] r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111), r210, r211};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(102611);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102611, "com/obric/assistant/interaction/impl/window/ChatWindowActivity", "onRequestPermissionsResult", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.onRequestPermissionsResult(r111, r210, r211);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public void onRequestPermissionsResult(int r100, String[] r101, int[] r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Intrinsics.checkNotNullParameter(r102, "grantResults");
        com_obric_assistant_interaction_impl_window_ChatWindowActivity_com_obric_assistant_interaction_impl_window_ChatWindowActivity_onRequestPermissionsResult(this, r100, r101, r102);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Window fake activity still requires a proxy activity to deliver IntentSender results reliably")
    public void startIntentSenderForResult(IntentSender r110, int r111, Intent r112, int r113, int r114, int r115, Bundle r116) {
        Intrinsics.checkNotNullParameter(r110, "intent");
        ChatWindowActivity$startIntentSenderForResult$listener$1 r100 = new ChatWindowActivity$startIntentSenderForResult$listener$1(r111, this, r110, r112, r113, r114, r115, r116);
        if (startProxyActivity(r100) == true) goto L6;
        r100.completeCancelOnce("startIntentSenderForResult ignored because proxy unavailable, requestCode=" + r111, null);
        return;
    }
}
