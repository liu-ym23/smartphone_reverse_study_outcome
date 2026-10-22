package com.bytedance.ee.bear.watermark;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.watermark.interfaces.CCMWatermarkInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.utils.z;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.watermark.Watermark;
import com.ss.android.lark.watermark.core.IAttachToBitmapCallback;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import com.ss.android.lark.watermark.core.WatermarkPointContext;
import com.ss.android.lark.watermark.core.WatermarkType;
import com.ss.android.lark.watermark.dto.WatermarkData;
import com.ss.android.lark.watermark.dto.WatermarkInfo;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Single;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements zo5.b {
    public e() {
    }

    @Override // zo5.b
    public final CCMWatermarkInfo a() {
        String r0 = l.a;
        tt5.a.h("WatermarkManager", "getWatermarkInfo");
        Watermark.Companion.getClass();
        WatermarkInfo r1 = Watermark.a.a().get();
        if (r1 != null) goto L6;
        r1 = l.d;
    L6:
        return CCMWatermarkInfo.build(r1);
    }

    @Override // zo5.b
    public final zo5.a m() {
        String r0 = l.a;
        zo5.a r1 = new zo5.a();
        r1.a = l.a;
        r1.b = l.b;
        ConcurrentHashMap<String, Boolean> r2 = l.c;
        String r3 = l.a;
        Boolean r4 = r2.get(l.f(l.a, Integer.valueOf(l.b)));
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        r1.d = r5;
        r1.c = l.i();
        Watermark.Companion.getClass();
        WatermarkData r6 = Watermark.a.a().getWatermarkData(WatermarkType.PREVIEW);
        r1.e = r6.getObviousEnabled();
        r1.f = r6.getMysteriousEnabled();
        return r1;
    L5:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L7;
        r5 = true;
        goto L8
    }

    public static View t(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    @Override // zo5.b
    public final void b(WatermarkInfo r3) {
        String r0 = l.a;
        Intrinsics.checkNotNullParameter(r3, "info");
        tt5.a.h("WatermarkManager", "updateWatermark");
        l.d = r3;
        Watermark.Companion.getClass();
        Watermark.a.a().update(r3);
    }

    @Override // zo5.b
    public final void d(Dialog r3) {
        if (r3 != null) goto L4;
        Window r0 = null;
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        if (t(r0) != null) goto L9;
        return;
    L9:
        if ((t(r0) instanceof FrameLayout) == false) goto L14;
        p((FrameLayout) t(r3.getWindow()));
        return;
    L14:
        return;
    L4:
        r0 = r3.getWindow();
        goto L5
    }

    @Override // zo5.b
    public final void detachWatermark(FrameLayout r1) {
        l.e(r1);
    }

    @Override // zo5.b
    public final Single<VFSPath> e(final String r2) {
        return Single.create(new a(this, r2));
    }

    @Override // zo5.b
    public final WatermarkData getWatermarkData(WatermarkType r3) {
        String r0 = l.a;
        Intrinsics.checkNotNullParameter(r3, "watermarkType");
        tt5.a.h("WatermarkManager", "getWatermarkData, watermarkType= " + r3);
        Watermark.Companion.getClass();
        return Watermark.a.a().getWatermarkData(r3);
    }

    @Override // zo5.b
    public final void init(Context r3) {
        String r0 = l.a;
        Intrinsics.checkNotNullParameter(r3, "context");
        tt5.a.h("WatermarkManager", "init");
        if (z.e(eu5.b.a) == true) goto L6;
        Watermark.Companion.getClass();
        Watermark.a.a().init(r3);
        return;
    }

    @Override // zo5.b
    public final Single<ByteString> k(final ByteString r2) {
        return Single.create(new b(this, r2));
    }

    @Override // zo5.b
    public final void n(FragmentActivity r1) {
        l.c(r1);
    }

    @Override // zo5.b
    public final void p(final FrameLayout r6) {
        String r0 = l.a;
        if (l.i() == false) goto L5;
        l.h(true, new WatermarkManager$updateWatermarkForDialog$1(r6), new WatermarkManager$updateWatermarkForDialog$2(r6));
        return;
    L5:
        Function0<Unit> r1 = new WatermarkManager$updateWatermarkForDialog$3(r6);
        Function0<Unit> r2 = new WatermarkManager$updateWatermarkForDialog$4(r6);
        Boolean r7 = l.c.get(l.f(l.a, Integer.valueOf(l.b)));
        if (r7 == null) goto L8;
        l.h(r7.booleanValue(), r1, r2);
        return;
    L8:
        l.g(l.a, l.b, r1, r2, true);
    }

    @Override // zo5.b
    public final void q(FragmentActivity r4) {
        String r0 = l.a;
        StringBuilder r1 = new StringBuilder("addGlobalWatermark for activity, isnull: ");
        if (r4 != null) goto L5;
        boolean r2 = true;
    L6:
        r1.append(r2);
        tt5.a.h("WatermarkManager", r1.toString());
        if (r4 == null) goto L10;
        Watermark.Companion.getClass();
        Watermark.a.a().attachWatermark(r4, true, null);
        return;
    L10:
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // zo5.b
    public final void r(FragmentActivity r1) {
        l.d(r1);
    }

    @Override // zo5.b
    public final void s(Dialog r3) {
        if (r3 != null) goto L4;
        Window r0 = null;
    L5:
        if (r0 != null) goto L7;
        return;
    L7:
        if (t(r0) != null) goto L9;
        return;
    L9:
        if ((t(r0) instanceof FrameLayout) == false) goto L16;
        final FrameLayout r4 = (FrameLayout) t(r3.getWindow());
        String r1 = l.a;
        if (l.i() == false) goto L17;
        l.h(true, new WatermarkManager$addGlobalWatermarkForDialog$1(r4), new WatermarkManager$addGlobalWatermarkForDialog$2(r4));
        return;
    L17:
        return;
    L16:
        return;
    L4:
        r0 = r3.getWindow();
        goto L5
    }

    @Override // zo5.b
    public final void c(Bitmap r4, IAttachToBitmapCallback r5) {
        String r0 = l.a;
        Intrinsics.checkNotNullParameter(r4, "bitmap");
        Intrinsics.checkNotNullParameter(r5, "callback");
        if (eu5.c.e() == false) goto L5;
        r5.onAttachSuccess(r4);
        return;
    L5:
        String r1 = l.a;
        if (l.i() == false) goto L8;
        r5.onAttachSuccess(r4);
        return;
    L8:
        Boolean r2 = l.c.get(l.f(l.a, Integer.valueOf(l.b)));
        if (r2 == null) goto L11;
    L14:
        r5.onAttachSuccess(r4);
        return;
    L11:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == true) goto L14;
        Watermark.Companion.getClass();
        Watermark.a.a().addWatermarkToBitmap(r4, r5);
    }

    @Override // zo5.b
    public final void g(String r3, int r4) {
        String r0 = l.a;
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        String r1 = l.a;
        l.g(r3, r4, null, null, false);
    }

    @Override // zo5.b
    public final void h(String r1, int r2) {
        l.a = r1;
        l.b = r2;
    }

    @Override // zo5.b
    public final void i(String r4, IGetWaterMarkResourceCallback r5) {
        ((com.ss.android.lark.watermark.userscope.c) LarkContext.spiByDwarf(com.ss.android.lark.watermark.userscope.c.class)).w0("ccm_doc_save_image", r4, null, r5);
    }

    @Override // zo5.b
    public final void j(String r1, int r2, Dialog r3) {
        l.a = r1;
        l.b = r2;
        if (r3 != null) goto L5;
        Window r4 = null;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        if (t(r4) != null) goto L10;
        return;
    L10:
        if ((t(r4) instanceof FrameLayout) == false) goto L15;
        p((FrameLayout) t(r3.getWindow()));
        return;
    L15:
        return;
    L5:
        r4 = r3.getWindow();
        goto L6
    }

    @Override // zo5.b
    public final void l(String r3, int r4, final FrameLayout r5) {
        String r0 = l.a;
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "frameLayout");
        if (TextUtils.isEmpty(r3) == true) goto L12;
        if (r4 < 0) goto L12;
        String r1 = l.a;
        if (l.i() == true) goto L14;
        Boolean r2 = l.c.get(l.f(r3, Integer.valueOf(r4)));
        if (r2 == null) goto L11;
        l.h(r2.booleanValue(), new WatermarkManager$updateWatermarkForFrameLayout$1(r5), new WatermarkManager$updateWatermarkForFrameLayout$2(r5));
        return;
    L11:
        l.g(r3, r4, new WatermarkManager$updateWatermarkForFrameLayout$3(r5), new WatermarkManager$updateWatermarkForFrameLayout$4(r5), true);
        return;
    L14:
        return;
    L12:
        tt5.a.d("WatermarkManager", "updateWatermark token= " + du5.b.g(r3) + " type = " + r4);
    }

    @Override // zo5.b
    public final void o(String r3, int r4, final FragmentActivity r5) {
        String r0 = l.a;
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "activity");
        if (TextUtils.isEmpty(r3) == true) goto L12;
        if (r4 < 0) goto L12;
        l.a = r3;
        l.b = r4;
        String r1 = l.a;
        if (l.i() == true) goto L14;
        Boolean r2 = l.c.get(l.f(r3, Integer.valueOf(r4)));
        if (r2 == null) goto L11;
        l.h(r2.booleanValue(), new WatermarkManager$updateWatermarkForActivity$1(r5), new WatermarkManager$updateWatermarkForActivity$2(r5));
        return;
    L11:
        l.g(r3, r4, new WatermarkManager$updateWatermarkForActivity$3(r5), new WatermarkManager$updateWatermarkForActivity$4(r5), true);
        return;
    L14:
        return;
    L12:
        tt5.a.d("WatermarkManager", "updateWatermark token= " + du5.b.g(r3) + " type = " + r4);
    }

    @Override // zo5.b
    public final void f(Bitmap r2, IAttachToBitmapCallback r3, WatermarkType r4, WatermarkPointContext r5) {
        String r0 = l.a;
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, "watermarkType");
        Intrinsics.checkNotNullParameter(r5, "watermarkPointContext");
        Watermark.Companion.getClass();
        Watermark.a.a().tryAddFileWatermarkToBitmap(r2, r3, r4, r5);
    }
}
