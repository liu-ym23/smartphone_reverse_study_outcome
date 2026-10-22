package com.obric.assistant.omnidetailpage.localmedia;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.flowsdk.security.api.FlowFileProtectionService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class LocalMediaShareHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalMediaShareHelper f390800a = null;

    static {
        f390800a = new LocalMediaShareHelper();
    }

    public LocalMediaShareHelper() {
    }

    public static void e(Context r100) {
        Toast.makeText(r100.getApplicationContext(), "分享失败", 0).show();
    }

    public final void c(final Context r210, ifa.c r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, MapController.ITEM_LAYER_TAG);
        boolean r100 = r211 instanceof ifa.c.a;
        if (r100 == false) goto L6;
        String r101 = "image";
    L8:
        FlowFileProtectionService r102 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        boolean r103 = false;
        if (r102 != null) goto L11;
    L13:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L25;
        com.larus.platform.service.o r105 = com.larus.platform.service.o.f365780a;
        JSONObject r106 = new JSONObject();
        r106.put("action", "share");
        r106.put("entry", "omni_detail_local_media");
        r106.put("channel", "system_share");
        r106.put("content_type", r101);
        Unit r107 = Unit.INSTANCE;
        r105.reportEvent("flow_enterprise_file_egress_block", r106);
        String r108 = r102.A0();
        if (r108 != null) goto L19;
        return;
    L19:
        if ((!StringsKt.isBlank(r108)) == false) goto L21;
        String r109 = r108;
    L22:
        if (r109 == null) goto L51;
        t19.s.j(t19.s.f544207a, r210, r109, null, false, 28);
        return;
    L51:
        return;
    L21:
        r109 = null;
        goto L22
    L25:
        if (r100 == false) goto L29;
        String r110 = ((ifa.c.a) r211).f489657c;
    L27:
        String r111 = r110;
        final String r112 = r101.concat("/*");
        String r113 = a(r210, r111, false);
        if (r113 != null) goto L44;
        if (r100 == true) goto L35;
    L42:
        e(r210);
        return;
    L35:
        if (StringsKt.startsWith$default(r111, "http://", false, 2, null) == false) goto L37;
    L38:
        r103 = true;
    L39:
        if (r103 == false) goto L42;
        ImageSave.z(ImageSave.f295932a, r111, null, null, null, false, false, null, new e(this, r210, r112), 126);
        return;
    L37:
        if (StringsKt.startsWith$default(r111, "https://", false, 2, null) == false) goto L39;
    L44:
        d(r210, r113, r112);
        return;
    L29:
        if ((r211 instanceof ifa.c.b) == false) goto L47;
        r110 = ((ifa.c.b) r211).f489663c;
        goto L27
    L47:
        throw new NoWhenBranchMatchedException();
    L11:
        if (r102.I0() != true) goto L13;
        r104 = true;
        goto L15
    L6:
        if ((r211 instanceof ifa.c.b) == false) goto L49;
        r101 = "video";
        goto L8
    L49:
        throw new NoWhenBranchMatchedException();
    }

    public static String a(Context r100, String r101, boolean r110) {
        l.f390838a.getClass();
        String r102 = l.b(r101);
        if (r102 != null) goto L56;
        return null;
    L56:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        Object r104 = Result.m9449constructorimpl(new PolarisFileWrapper(r102).getCanonicalFile());     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r104) == false) goto L12;
        r104 = null;
    L12:
        File r105 = (File) r104;
        if (r105 != null) goto L15;
        return null;
    L15:
        String r106 = r105.getPath();
        f390800a.getClass();
        Context r107 = r100.getApplicationContext();
        boolean r108 = false;
        List r109 = CollectionsKt.listOfNotNull(new File[]{r107.getFilesDir(), r107.getCacheDir(), r107.getExternalFilesDir(null), r107.getExternalFilesDir(Environment.DIRECTORY_DCIM), r107.getExternalCacheDir()});
        if (r110 == false) goto L22;
        List r111 = r109;
        String r112 = com.larus.utils.r.h();
        if (r112 == null) goto L20;
        PolarisFileWrapper r113 = new PolarisFileWrapper(r112);
    L21:
        r109 = CollectionsKt.plus(r111, CollectionsKt.listOfNotNull(r113));
        goto L22
    L20:
        r113 = null;
    L22:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r109.iterator();
    L24:
        if (r115.hasNext() == false) goto L37;
        File r116 = (File) r115.next();
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L28
        Object r118 = Result.m9449constructorimpl(r116.getCanonicalFile());     // Catch: Throwable -> L28
    L31:
        if (Result.m9455isFailureimpl(r118) == false) goto L33;
        r118 = null;
    L33:
        File r119 = (File) r118;
        if (r119 == null) goto L24;
        r114.add(r119);
    L28:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L37:
        if (r114.isEmpty() == true) goto L51;
        Iterator r121 = r114.iterator();
    L41:
        if (r121.hasNext() == false) goto L51;
        File r122 = (File) r121.next();
        f390800a.getClass();
        if (Intrinsics.areEqual(r105.getPath(), r122.getPath()) == false) goto L45;
    L48:
        boolean r123 = true;
    L49:
        if (r123 == false) goto L41;
        r108 = true;
        goto L51
    L45:
        if (StringsKt.startsWith$default(r105.getPath(), r122.getPath() + File.separator, false, 2, null) == true) goto L48;
        r123 = false;
    L51:
        if (r108 == true) goto L53;
        return null;
    L53:
        return r106;
    L7:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static void d(Context r100, String r101, String r102) {
        OmniDetailLocalFileOpenHelper r103 = OmniDetailLocalFileOpenHelper.f390806a;
        String r104 = StringsKt.substringAfterLast$default(r101, '/', null, 2, null);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r104, "fileName");
        OmniDetailLocalFileOpenHelper.a r105 = OmniDetailLocalFileOpenHelper.d(r100, r101, r104);
        if (r105 == null) goto L5;
        Uri r106 = r105.f390811a;
    L6:
        if (r106 != null) goto L9;
        e(r100);
        return;
    L9:
        Intent r107 = new Intent("android.intent.action.SEND");
        r107.setType(r102);
        r107.putExtra("android.intent.extra.STREAM", r106);
        r107.addFlags(1);
        Iterator<T> r108 = r100.getPackageManager().queryIntentActivities(r107, 0).iterator();
    L11:
        if (r108.hasNext() == false) goto L21;
        r100.grantUriPermission(((ResolveInfo) r108.next()).activityInfo.packageName, r106, 1);
        goto L11
    L21:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L15
        Intent r110 = Intent.createChooser(r107, null);     // Catch: Throwable -> L15
        r110.addFlags(268435456);     // Catch: Throwable -> L15
        r110.addFlags(1);     // Catch: Throwable -> L15
        r100.startActivity(r110);     // Catch: Throwable -> L15
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L18:
        if (Result.m9452exceptionOrNullimpl(r111) == null) goto L23;
        f390800a.getClass();
        e(r100);
        return;
    L23:
        return;
    L15:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        r106 = null;
        goto L6
    }

    public final Object b(Context r210, ifa.c r211, Continuation<? super Boolean> r212) {
        if ((r212 instanceof LocalMediaShareHelper$save$1) == false) goto L7;
        LocalMediaShareHelper$save$1 r100 = (LocalMediaShareHelper$save$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = false;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        Context r106 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L57:
        String r110 = (String) r102;
    L59:
        if (r110 == null) goto L61;
        String r107 = r110;
    L65:
        if (com.larus.utils.r.u(r106, r107, true) == null) goto L83;
        r105 = true;
    L83:
        return Boxing.boxBoolean(r105);
    L61:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        boolean r108 = r211 instanceof ifa.c.a;
        if (r108 == false) goto L18;
        String r109 = "image";
    L20:
        FlowFileProtectionService r111 = (FlowFileProtectionService) ServiceManager.get().getService(FlowFileProtectionService.class);
        if (r111 != null) goto L23;
    L25:
        boolean r112 = false;
    L26:
        r110 = null;
        if (r112 == false) goto L37;
        com.larus.platform.service.o r113 = com.larus.platform.service.o.f365780a;
        JSONObject r114 = new JSONObject();
        r114.put("action", "save_album");
        r114.put("entry", "omni_detail_local_media");
        r114.put("channel", "album");
        r114.put("content_type", r109);
        Unit r115 = Unit.INSTANCE;
        r113.reportEvent("flow_enterprise_file_egress_block", r114);
        String r116 = r111.H0();
        if (r116 != null) goto L31;
    L36:
        return null;
    L31:
        if ((!StringsKt.isBlank(r116)) == false) goto L33;
        String r117 = r116;
    L34:
        if (r117 == null) goto L36;
        t19.s.j(t19.s.f544207a, r210, r117, null, false, 28);
        goto L36
    L33:
        r117 = null;
        goto L34
    L37:
        if (r108 == false) goto L69;
        ifa.c.a r118 = (ifa.c.a) r211;
        r107 = a(r210, r118.f489657c, false);
        if (r107 != null) goto L63;
        String r119 = r118.f489657c;
        f390800a.getClass();
        if (StringsKt.startsWith$default(r119, "http://", false, 2, null) == false) goto L43;
    L46:
        boolean r120 = true;
    L47:
        if (r120 == false) goto L49;
        String r121 = r119;
    L50:
        if (r121 == null) goto L58;
        r100.L$0 = r210;
        r100.label = 1;
        kotlinx.coroutines.j r122 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r122.C();
        ImageSave.z(ImageSave.f295932a, r121, null, null, null, false, false, null, new f(r122, r210), 126);
        r102 = r122.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L54;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L54:
        if (r102 != r103) goto L56;
        return r103;
    L56:
        r106 = r210;
        goto L57
    L58:
        r106 = r210;
        goto L59
    L49:
        r121 = null;
        goto L50
    L43:
        if (StringsKt.startsWith$default(r119, "https://", false, 2, null) == true) goto L46;
        r120 = false;
        goto L47
    L63:
        r106 = r210;
        goto L65
    L69:
        if ((r211 instanceof ifa.c.b) == false) goto L80;
        String r123 = a(r210, ((ifa.c.b) r211).f489663c, false);
        if (r123 != null) goto L75;
        return Boxing.boxBoolean(false);
    L75:
        if (com.larus.utils.r.u(r210, r123, false) == null) goto L78;
        r105 = true;
    L78:
        return Boxing.boxBoolean(r105);
    L80:
        throw new NoWhenBranchMatchedException();
    L23:
        if (r111.I0() != true) goto L25;
        r112 = true;
        goto L26
    L18:
        if ((r211 instanceof ifa.c.b) == false) goto L82;
        r109 = "video";
        goto L20
    L82:
        throw new NoWhenBranchMatchedException();
    L7:
        r100 = new LocalMediaShareHelper$save$1(this, r212);
        goto L8
    }
}
