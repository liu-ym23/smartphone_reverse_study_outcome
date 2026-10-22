package com.larus.uaigc.helper;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
public final class o0 {
    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static final Long b(Uri r100, String r101) {
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L34
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L34
        boolean r105 = true;
        if ((!StringsKt.isBlank(r101)) == true) goto L6;
    L8:
        boolean r106 = false;
    L9:
        if (r106 == true) goto L12;
        r104 = null;
    L12:
        if (r104 == null) goto L14;
        Long r107 = Long.valueOf(r104.length());     // Catch: Throwable -> L34
    L32:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L34
    L37:
        if (Result.m9455isFailureimpl(r108) == true) goto L41;
        r102 = r108;
    L41:
        return (Long) r102;
    L14:
        ParcelFileDescriptor r109 = a(AppHost.f326268a.getApplication().getContentResolver(), r100);     // Catch: Throwable -> L34
        if (r109 != null) goto L43;
        r107 = null;
        goto L32
    L43:
        Long r110 = Long.valueOf(r109.getStatSize());     // Catch: Throwable -> L26
    L18:
        if (r110.longValue() >= 0) goto L21;
        r105 = false;
    L21:
        if (r105 == true) goto L24;
        r110 = null;
    L24:
        CloseableKt.closeFinally(r109, null);     // Catch: Throwable -> L34
        r107 = r110;
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r109, th);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L6:
        if (r104.isFile() == false) goto L8;
        r106 = true;
    L34:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    }

    public static final ResourceItemBean c(Uri r310, String r311) {
        if (r310 != null) goto L5;
        return null;
    L5:
        if (r311 == null) goto L40;
        String r100 = r311;
    L10:
        ImFileUtil.f314899a.getClass();     // Catch: Throwable -> L7
        boolean r101 = ImFileUtil.w(r310);     // Catch: Throwable -> L7
        boolean r102 = ImFileUtil.y(r310);     // Catch: Throwable -> L7
        String r103 = vqc.d.d(AppHost.f326268a.getApplication(), r310);     // Catch: Throwable -> L7
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        Long r210 = b(r310, r103);     // Catch: Throwable -> L7
        String r211 = StringsKt.substringAfterLast$default(r103, '.', null, 2, null);     // Catch: Throwable -> L7
        String r104 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(StringsKt.substringAfterLast$default(r103, '.', null, 2, null));     // Catch: Throwable -> L7
        if (r104 != null) goto L17;
        String r212 = "";
    L19:
        if (r101 == false) goto L28;
        ItemStatus r105 = ItemStatus.UPLINKING;     // Catch: Throwable -> L7
        ResourceType r106 = ResourceType.IMAGE;     // Catch: Throwable -> L7
        String r110 = r103;
        Image r213 = new Image(UUID.randomUUID().toString(), "", null, null, null, r110, null, null, null, null, null, null, null, null, 16348, null);     // Catch: Throwable -> L7
        int r111 = i5.w0();     // Catch: Throwable -> L7
        HashMap r112 = new HashMap();     // Catch: Throwable -> L7
        r112.put("ext_img_show_path", r103);     // Catch: Throwable -> L7
        if (r210 == null) goto L23;
        r112.put("ext_creation_reference_file_size", Long.valueOf(r210.longValue()));     // Catch: Throwable -> L7
    L23:
        f.f373014a.getClass();     // Catch: Throwable -> L7
        Boolean r107 = f.c().d();     // Catch: Throwable -> L7
        Boolean r108 = Boolean.TRUE;     // Catch: Throwable -> L7
        if (Intrinsics.areEqual(r107, r108) == false) goto L41;
        r112.put("ext_silent_upload", r108);     // Catch: Throwable -> L7
    L41:
        return new ResourceItemBean(r100, null, r211, r212, r213, null, 0, r105, false, r106, r111, 0, 0, 0, false, false, false, false, 0, r112, 522530, null);
    L28:
        if (r102 == false) goto L42;
        ItemStatus r214 = ItemStatus.UPLINKING;     // Catch: Throwable -> L7
        ResourceType r215 = ResourceType.VIDEO;     // Catch: Throwable -> L7
        String r113 = r103;
        mt8.b r216 = new mt8.b(null, 0.0f, 0, 0, r113, null, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_USE_FALLBACK_API);     // Catch: Throwable -> L7
        int r114 = i5.w0();     // Catch: Throwable -> L7
        HashMap r115 = new HashMap();     // Catch: Throwable -> L7
        r115.put("ext_video_local_uri", r310.toString());     // Catch: Throwable -> L7
        if (r210 == null) goto L32;
        r115.put("ext_creation_reference_file_size", Long.valueOf(r210.longValue()));     // Catch: Throwable -> L7
    L32:
        f.f373014a.getClass();     // Catch: Throwable -> L7
        Boolean r109 = f.c().d();     // Catch: Throwable -> L7
        Boolean r116 = Boolean.TRUE;     // Catch: Throwable -> L7
        if (Intrinsics.areEqual(r109, r116) == false) goto L37;
        r115.put("ext_silent_upload", r116);     // Catch: Throwable -> L7
    L37:
        return new ResourceItemBean(r100, null, r211, r212, null, r216, 0, r214, false, r215, r114, 0, 0, 0, false, false, false, false, 0, r115, 522514, null);
    L42:
        return null;
    L17:
        r212 = r104;
        goto L19
    L40:
        r100 = UUID.randomUUID().toString();     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        com.larus.platform.service.g.f365738a.ensureNotReachHere(th);
        return null;
    }
}
