package com.larus.larkfeed.impl.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.DownloadWatermarkService;
import com.larus.platform.service.i2;
import com.larus.platform.service.watermark.DownloadWatermarkScene;
import com.larus.platform.service.watermark.LocalImageWatermarkRequest;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: classes30.dex */
public final class LarkOfficeSocialHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LarkOfficeSocialHelper f355542a = null;

    static {
        f355542a = new LarkOfficeSocialHelper();
    }

    public LarkOfficeSocialHelper() {
    }

    public static void d(final Context r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        s r103 = s.f544207a;
        String r104 = r100.getString(R.string.larus_save_failed);
        r103.getClass();
        s.t(r100, r104);
        return;
    L12:
        b(r100, 28, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}), "saveVideoToAlbum", new c(r100, r101));
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final Object a(String r100, Continuation<? super String> r101) {
        if ((r101 instanceof LarkOfficeSocialHelper$applyDownloadWatermarkIfNeeded$1) == false) goto L7;
        LarkOfficeSocialHelper$applyDownloadWatermarkIfNeeded$1 r102 = (LarkOfficeSocialHelper$applyDownloadWatermarkIfNeeded$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L20:
        com.larus.platform.service.watermark.g r108 = (com.larus.platform.service.watermark.g) r104;
        if ((r108 instanceof com.larus.platform.service.watermark.g.d) == false) goto L23;
        com.larus.platform.service.watermark.g.d r109 = (com.larus.platform.service.watermark.g.d) r108;
    L24:
        if (r109 == null) goto L26;
        com.larus.platform.service.watermark.c r110 = r109.f365856a;
    L28:
        if ((r110 instanceof com.larus.platform.service.watermark.c.b) == false) goto L30;
        com.larus.platform.service.watermark.c.b r111 = (com.larus.platform.service.watermark.c.b) r110;
    L31:
        if (r111 == null) goto L41;
        String r112 = r111.f365849a;
        if (r112 != null) goto L35;
        return null;
    L35:
        if (r112.length() > 0) goto L38;
        r107 = false;
    L38:
        if (r107 == true) goto L40;
        return null;
    L40:
        return r112;
    L41:
        return null;
    L30:
        r111 = null;
        goto L31
    L26:
        r110 = null;
        goto L28
    L23:
        r109 = null;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        DownloadWatermarkService r113 = DownloadWatermarkService.f365700a;
        r113.getClass();
        if (DownloadWatermarkService.d() == true) goto L17;
        return r100;
    L17:
        LocalImageWatermarkRequest r114 = new LocalImageWatermarkRequest(new com.larus.platform.service.watermark.b.C4473b(r100), LocalImageWatermarkRequest.OutputPreference.AS_PATH, DownloadWatermarkScene.IM_GALLERY_IMAGE_DOWNLOAD);
        r102.label = 1;
        r104 = r113.b(r114, r102);
        if (r104 != r105) goto L20;
        return r105;
    L7:
        r102 = new LarkOfficeSocialHelper$applyDownloadWatermarkIfNeeded$1(this, r101);
        goto L8
    }

    public final Object c(final Context r100, String r101, Continuation<? super Unit> r110) {
        if ((r110 instanceof LarkOfficeSocialHelper$saveImageToAlbum$1) == false) goto L7;
        LarkOfficeSocialHelper$saveImageToAlbum$1 r102 = (LarkOfficeSocialHelper$saveImageToAlbum$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (Context) r102.L$0;
        ResultKt.throwOnFailure(r111);
    L37:
        final String r112 = (String) r111;
        if (r112 != null) goto L41;
        FLogger.f375446a.w("LarkOfficeSocialHelper", "saveImageToAlbum blocked because watermark generation failed");
        s r106 = s.f544207a;
        String r113 = r100.getString(R.string.larus_save_failed);
        r106.getClass();
        s.t(r100, r113);
        return Unit.INSTANCE;
    L41:
        b(r100, 29, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"), "saveImageToAlbum", new d(r100, r112));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        boolean r114 = false;
        if (r101 != null) goto L17;
    L20:
        boolean r107 = true;
    L21:
        if (r107 == false) goto L25;
        s r108 = s.f544207a;
        String r115 = r100.getString(R.string.larus_save_failed);
        r108.getClass();
        s.t(r100, r115);
        return Unit.INSTANCE;
    L25:
        if (StringsKt.startsWith$default(r101, MSkiaImageRegionDecoder.FILE_PREFIX, false, 2, null) == false) goto L27;
        r101 = UriProtector.parse(r101).getPath();
    L27:
        if (r101 != null) goto L29;
    L30:
        r114 = true;
    L31:
        if (r114 == false) goto L34;
        s r109 = s.f544207a;
        String r116 = r100.getString(R.string.larus_save_failed);
        r109.getClass();
        s.t(r100, r116);
        return Unit.INSTANCE;
    L34:
        r102.L$0 = r100;
        r102.label = 1;
        r111 = a(r101, r102);
        if (r111 != r104) goto L37;
        return r104;
    L29:
        if (r101.length() != 0) goto L31;
    L17:
        if (r101.length() == 0) goto L20;
        r107 = false;
    L7:
        r102 = new LarkOfficeSocialHelper$saveImageToAlbum$1(this, r110);
        goto L8
    }

    public static void b(final Context r100, int r101, List r102, final String r103, final Function0 r104) {
        if (Build.VERSION.SDK_INT > r101) goto L34;
        List r105 = r102;
        boolean r106 = true;
        if ((r105 instanceof Collection) == true) goto L7;
    L9:
        Iterator r107 = r105.iterator();
    L11:
        if (r107.hasNext() == false) goto L18;
        if (ContextCompat.checkSelfPermission(r100, (String) r107.next()) != 0) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L11;
        r106 = false;
        goto L18
    L15:
        r108 = false;
    L18:
        if (r106 == true) goto L34;
        FragmentActivity r109 = null;
        if ((r100 instanceof FragmentActivity) == false) goto L23;
        FragmentActivity r110 = (FragmentActivity) r100;
    L24:
        if (r110 != null) goto L28;
        Activity r111 = AppHost.f326268a.a().getCurrentActivity();
        if ((r111 instanceof FragmentActivity) == false) goto L29;
        r109 = (FragmentActivity) r111;
    L29:
        if (r109 != null) goto L32;
        FLogger.f375446a.e("LarkOfficeSocialHelper", r103.concat(" request storage permission failed, no FragmentActivity"));
        s r112 = s.f544207a;
        String r113 = r100.getString(R.string.larus_save_failed);
        r112.getClass();
        s.t(r100, r113);
        return;
    L32:
        i2.f365748b.a(r109, r102, new e(r104, r103, r100));
        return;
    L28:
        r109 = r110;
        goto L29
    L23:
        r110 = null;
        goto L24
    L7:
        if (r105.isEmpty() == false) goto L9;
    L34:
        r104.invoke();
    }
}
