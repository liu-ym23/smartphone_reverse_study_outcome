package com.bytedance.android.shopping.new_cart.container;

import android.content.Context;
import android.os.Handler;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.facebook.common.executors.HandlerExecutorServiceImpl;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CreateSliceRenderInfo {
    public com.bytedance.kmp.ec.yata.view.render.delegate.v2.a a;
    public final boolean b;
    public final boolean c;
    public final a d;
    public final Lazy e;
    public final CartParams f;

    public static final class a extends HandlerExecutorServiceImpl {
        public a(Handler r1) {
            super(r1);
        }

        public final void execute(Runnable r2) {
            if (r2 == null) goto L8;
            Lazy r0 = UIUtils.a;
            if (UIUtils.d() == false) goto L6;
            r2.run();
            return;
        L6:
            UIUtils.c().postAtFrontOfQueue(r2);
            return;
        }
    }

    public CreateSliceRenderInfo(CartParams r2) {
        this.f = r2;
        ECSettingKeys.j.getClass();
        this.b = ECSettingKeys.h().b();
        this.c = ECSettingKeys.h().e();
        Lazy r0 = UIUtils.a;
        this.d = new a(UIUtils.c());
        this.e = LazyKt.lazy(CreateSliceRenderInfo$fieldUIExecutor$2.INSTANCE);
    }

    public final void a(Context r7) {
        if (r7 == null) goto L39;
        int r0 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.e;
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r8 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.a.a(r7, "yata_cart");
        SlcRenderContext r1 = r8.b;
        int r2 = com.bytedance.android.shopping.new_cart.utils.c.a;
        CartParams r3 = this.f;
        String r4 = null;
        if (r3 == null) goto L6;
        String r5 = r3.getSplitActivityScene();
    L7:
        boolean r6 = com.bytedance.android.shopping.new_cart.utils.c.a(r5);
        if (r1 == null) goto L10;
        int r9 = s.a;
        r1.f = s.a(Boolean.valueOf(r6));
    L10:
        if (r1 == null) goto L12;
        r1.c0 = new zf3.a();
    L12:
        if (r1 == null) goto L14;
        int r10 = s.a;
        r1.g = ECSettingKeys.p().k();
    L14:
        if (r1 == null) goto L16;
        int r11 = s.a;
        r1.y = ECSettingKeys.p().j();
    L16:
        if (r1 == null) goto L18;
        int r12 = s.a;
        r1.j = ECSettingKeys.p().f();
    L18:
        if (r1 == null) goto L21;
        int r13 = s.a;
        r1.k = ECSettingKeys.p().e();
    L21:
        if (this.b == true) goto L25;
        if (r1 == null) goto L25;
        r1.v = 0;
    L25:
        if (this.c == false) goto L29;
        if (r1 == null) goto L29;
        r1.o = new u(this);
    L29:
        if (CartSettingUtils.b() == false) goto L31;
        Float r14 = ECAppInfoService.e.getCurrentFontScale();
    L32:
        if (r1 == null) goto L37;
        Pair[] r15 = new Pair[2];
        r15[0] = TuplesKt.to("large_font_scale", r14);
        CartParams r16 = this.f;
        if (r16 == null) goto L36;
        r4 = r16.getSplitActivityScene();
    L36:
        r15[1] = TuplesKt.to("split_mode_scene", r4);
        r1.p(MapsKt.mapOf(r15));
    L37:
        Unit r17 = Unit.INSTANCE;
        this.a = r8;
        return;
    L31:
        r14 = Float.valueOf(1.0f);
        goto L32
    L6:
        r5 = null;
        goto L7
    }
}
