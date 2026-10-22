package com.larus.dora.impl.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.ivykit.forest.IFlowForestService;
import com.larus.nova.R;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraResourceUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DoraResourceUtil f338111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f338112b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f338113c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<DoraVideoType> f338114d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final DoraResourceUtil$doraLinkCallback$1 f338115e = null;

    public DoraResourceUtil() {
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.dora.impl.util.DoraResourceUtil$doraLinkCallback$1] */
    static {
        f338111a = new DoraResourceUtil();
        f338112b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f338113c = new AtomicBoolean(false);
        f338114d = CollectionsKt.listOf(new DoraVideoType[]{DoraVideoType.DORA_G_GESTURE_L_2_M, DoraVideoType.DORA_G_GESTURE_L, DoraVideoType.DORA_G_GESTURE_M_2_L, DoraVideoType.DORA_G_GESTURE_M_2_R, DoraVideoType.DORA_G_GESTURE_R_2_M, DoraVideoType.DORA_G_GESTURE_R});
        f338115e = new DoraResourceUtil$doraLinkCallback$1();
    }

    public static final void b() {
        IFlowForestService r100 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Exception -> L11
        if (r100 == null) goto L6;
        String r101 = r100.b("https://lf-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/dora/client/resource/com_flow_dora_lynx/volume-setting/template.js", "com_flow_dora_lynx", true);     // Catch: Exception -> L11
    L7:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        g49.d.d("DoraResourceUtil", "preloadVolumeSettingTemplate path=".concat(r101));     // Catch: Exception -> L11
        return;
    L6:
        r101 = null;
    L11:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        g49.d.b("DoraResourceUtil", "preloadVolumeSettingTemplate error: " + e.getMessage());
    }

    public static String g() {
        IFlowForestService r100 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Exception -> L7
        if (r100 == null) goto L9;
        String r101 = r100.b("audio_kws_silence_5s_use.wav", "com_flow_dora", true);     // Catch: Exception -> L7
    L10:
        g49.d.d("DoraResourceUtil", "getSilentAudioPath: " + r101);
        return r101;
    L9:
        r101 = "";
    L7:
        e = move-exception;
        g49.d.b("DoraResourceUtil", "getSilentAudioPath error: " + e.getMessage());
        goto L9
    }

    public static void k() {
        if (f338113c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(f338112b, null, null, new DoraResourceUtil$initializeGGestureResources$1(null), 3, null);
    }

    public static Unit l() {
        DoraSetting.f338023a.getClass();
        if (DoraSetting.f() == false) goto L5;
        g49.d.d("DoraResourceUtil", "initialize Dora Video Resources");
        IFlowForestService r100 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);
        if (r100 == null) goto L10;
        g49.d.d("DoraResourceUtil", "initialize Dora Video Resources start");
        DoraVideoType r101 = DoraVideoType.ONBOARDING_UNBOXING;
        DoraSKU r102 = DoraSKU.SILVER;
        String r103 = r100.b(r101.fileName(r102, false), "com_flow_dora_onboarding", true);
        String r104 = r100.b(DoraImageType.IMAGE_ONBOARDING_POPUP_HEADPHONE_WELCOME.fileName(r102), "com_flow_dora", true);
        r100.b("audio_kws_silence_5s_use.wav", "com_flow_dora", true);
        g49.d.d("DoraResourceUtil", "initialize Dora Video Resources down， video path is " + r103 + ", image path is " + r104 + ", dora e image path is " + r100.b(DoraImageType.IMAGE_DORA_E_HEADPHONE_BOX.fileName(r102, false), "com_flow_dora_e_image", true));
        String r105 = r100.b("index", "com_flow_dora_netural_wakeup", true);
        StringBuilder r106 = new StringBuilder("initialize Dora Wakeup Response Resources, wakeup path is ");
        r106.append(r105);
        g49.d.d("DoraResourceUtil", r106.toString());
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static void j() {
        kj4.a.g().registerDoraLinkCallback(f338115e);
        if (kj4.a.g().hasDoraDevice() == false) goto L5;
        BuildersKt.launch$default(f338112b, null, null, new DoraResourceUtil$init$1(null), 3, null);
    L5:
        BuildersKt.launch$default(f338112b, null, null, new DoraResourceUtil$init$2(null), 3, null);
    }

    public static Bitmap c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter("com_flow_dora", "channel");
        if (Intrinsics.areEqual("com_flow_dora", "com_flow_dora_gesture_channel") == true) goto L5;
    L7:
        long r101 = SystemClock.uptimeMillis();
        IFlowForestService r102 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Exception -> L12
        if (r102 == null) goto L14;
        String r103 = r102.b(r100, "com_flow_dora", true);     // Catch: Exception -> L12
    L15:
        Bitmap r104 = BitmapFactory.decodeFile(r103);
        g49.d.d("DoraResourceUtil", "duration total:" + (SystemClock.uptimeMillis() - r101));
        if (r104 != null) goto L33;
        Resources r105 = AppHost.f326268a.getApplication().getResources();
        Locale r106 = Locale.US;
        if (StringsKt.contains$default(r100, "IMAGE_ONBOARDING_POPUP_HEADPHONE_GESTURE".toLowerCase(r106), false, 2, null) == false) goto L21;
        return BitmapFactory.decodeResource(r105, R.drawable.larus_image_onboarding_popup_headphone_gesture_silver);
    L21:
        if (StringsKt.contains$default(r100, "IMAGE_ONBOARDING_POPUP_HEADPHONE_BOX".toLowerCase(r106), false, 2, null) == false) goto L24;
        return BitmapFactory.decodeResource(r105, R.drawable.larus_image_onboarding_popup_headphone_box_silver_light);
    L24:
        if (StringsKt.contains$default(r100, "IMAGE_ONBOARDING_POPUP_HEADPHONE_LEFT".toLowerCase(r106), false, 2, null) == false) goto L27;
        return BitmapFactory.decodeResource(r105, R.drawable.larus_image_onboarding_popup_headphone_left_silver_light);
    L27:
        if (StringsKt.contains$default(r100, "IMAGE_ONBOARDING_POPUP_HEADPHONE_RIGHT".toLowerCase(r106), false, 2, null) == false) goto L30;
        return BitmapFactory.decodeResource(r105, R.drawable.larus_image_onboarding_popup_headphone_right_silver_light);
    L30:
        if (StringsKt.contains$default(r100, "IMAGE_ONBOARDING_POPUP_HEADPHONE_WELCOME".toLowerCase(r106), false, 2, null) == true) goto L42;
        return null;
    L42:
        return BitmapFactory.decodeResource(r105, R.drawable.larus_image_onboarding_popup_headphone_welcome_silver);
    L33:
        return r104;
    L14:
        r103 = "";
    L12:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        g49.d.b("DoraResourceUtil", "getImage" + e.getMessage());
        goto L14
    L5:
        if (s.a() == true) goto L7;
        g49.d.d("DoraResourceUtil", "Dora G is disabled, skip G gesture image resource: " + r100);
        return null;
    }

    public static String d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        long r101 = SystemClock.uptimeMillis();
        String r102 = "";
        IFlowForestService r103 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Exception -> L11
        if ("".length() != 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L13;
        if (r103 == null) goto L13;
        r102 = r103.b(r100, "com_flow_dora", true);     // Catch: Exception -> L11
    L13:
        g49.d.d("DoraResourceUtil", "duration total:" + (SystemClock.uptimeMillis() - r101));
        return r102;
    L6:
        r104 = false;
    L11:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        g49.d.b("DoraResourceUtil", "getImage" + e.getMessage());
        goto L13
    }

    public static Bitmap e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        long r101 = SystemClock.uptimeMillis();
        String r102 = "";
        IFlowForestService r103 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Exception -> L11
        if ("".length() != 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L13;
        if (r103 == null) goto L13;
        r102 = r103.b(r100, "com_flow_dora", true);     // Catch: Exception -> L11
    L13:
        Bitmap r105 = BitmapFactory.decodeFile(r102);
        g49.d.d("DoraResourceUtil", "duration total:" + (SystemClock.uptimeMillis() - r101));
        if (r105 != null) goto L19;
        AppHost.Companion r106 = AppHost.f326268a;
        Resources r107 = r106.getApplication().getResources();
        return BitmapFactory.decodeResource(r107, r107.getIdentifier(r100, "drawable", r106.getApplication().getPackageName()));
    L19:
        return r105;
    L6:
        r104 = false;
    L11:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        g49.d.b("DoraResourceUtil", "getImage" + e.getMessage());
        goto L13
    }

    public static String f(String r110) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter("com_flow_dora", "channel");
        String r100 = "";
        if (Intrinsics.areEqual("com_flow_dora", "com_flow_dora_gesture_channel") == true) goto L5;
    L7:
        long r101 = SystemClock.uptimeMillis();
        if (StringsKt.contains$default(StringsKt.substringAfterLast$default(r110, '/', null, 2, null), '.', false, 2, null) == false) goto L10;
        String r102 = r110;
    L19:
        IFlowForestService r103 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Exception -> L15
        if (r103 == null) goto L17;
        r100 = r103.b(r102, "com_flow_dora", false);     // Catch: Exception -> L15
    L17:
        g49.d.d("DoraResourceUtil", "getLottiePath key=" + r110 + ", normalizedKey=" + r102 + ", duration total:" + (SystemClock.uptimeMillis() - r101) + ", path=" + r100);
    L18:
        return r100;
    L15:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        g49.d.b("DoraResourceUtil", "getLottiePath error: " + e.getMessage());
        goto L17
    L10:
        r102 = r110 + InvRouter.FLOW_SUFFIX;
        goto L19
    L5:
        if (s.a() == true) goto L7;
        g49.d.d("DoraResourceUtil", "Dora G is disabled, skip G gesture lottie resource: " + r110);
        goto L18
    }

    public static /* synthetic */ String i(String r100) {
        return h(r100, "com_flow_dora_onboarding");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0075 -> B:26:0x0086). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0083 -> B:26:0x0086). Please report as a decompilation issue!!! */
    public static final Object a(DoraResourceUtil r100, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof DoraResourceUtil$preloadObricExploreLottieResource$1) == false) goto L7;
        DoraResourceUtil$preloadObricExploreLottieResource$1 r101 = (DoraResourceUtil$preloadObricExploreLottieResource$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r101.I$1;
        int r106 = r101.I$0;
        ResultKt.throwOnFailure(r103);
    L26:
        r105 = r105 + 1;
    L15:
        if (r105 >= r106) goto L28;
        int r107 = r105 + 1;
        String r108 = f("basic_media_play_pause");
        g49.d.d("DoraResourceUtil", "preloadObricExploreLottieResource attempt=" + r107 + " key=basic_media_play_pause path=" + r108);
        if (r108.length() <= 0) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == true) goto L29;
        if (r107 >= 10) goto L26;
        r101.I$0 = r106;
        r101.I$1 = r105;
        r101.label = 1;
        if (DelayKt.delay(2000, r101) != r111) goto L26;
        return r111;
    L29:
        return Unit.INSTANCE;
    L19:
        r109 = false;
        goto L20
    L28:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r105 = 0;
        r106 = 10;
    L7:
        r101 = new DoraResourceUtil$preloadObricExploreLottieResource$1(r100, r110);
        goto L8
    }

    public static String h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "channel");
        if (Intrinsics.areEqual(r101, "com_flow_dora_gesture_channel") == true) goto L5;
    L15:
        IFlowForestService r102 = (IFlowForestService) ServiceManager.get().getService(IFlowForestService.class);     // Catch: Exception -> L12
        if (r102 == null) goto L17;
        return r102.b(r100, r101, true);
    L17:
        return "";
    L12:
        e = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
        g49.d.b("DoraResourceUtil", "getImage" + e.getMessage());
        return "";
    L5:
        if (s.a() == true) goto L15;
        g49.d.d("DoraResourceUtil", "Dora G is disabled, skip G gesture resource: " + r100);
        return "";
    }
}
