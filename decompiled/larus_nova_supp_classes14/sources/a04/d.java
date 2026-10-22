package a04;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.digg.DiggType;
import com.bytedance.awemeopen.apps.framework.utils.AccountUsageHintHelper;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends BaseElement<n, o, a04.a, jz3.a> implements q24.b {
    public final Activity g;
    public final com.bytedance.awemeopen.apps.framework.framework.viewpager.o h;
    public final q24.c i;
    public jz3.a j;
    public boolean k;
    public boolean l;

    public static final class a implements q24.a {
        public final /* synthetic */ d a;
        public final /* synthetic */ DiggType b;

        public final void b() {
        }

        public final void a() {
            zx3.a.b(this.a.getContext(), 2131894241).d();
            this.a.k = false;
        }

        public final void onFail() {
            if (AoEnv.j() == true) goto L5;
            zx3.a.b(this.a.getContext(), 2131894185).d();
        L5:
            this.a.k = false;
        }

        public final void onSuccess(String r6) {
            Intrinsics.checkNotNullParameter(r6, "aid");
            Intrinsics.checkNotNullParameter(r6, "aid");
            Lazy r0 = AccountUsageHintHelper.a;
            AccountUsageHintHelper.b(this.a.getContext());
            jz3.a r1 = this.a.j;
            jz3.a r2 = null;
            if (r1 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r1 = null;
        L6:
            if (Intrinsics.areEqual(r6, r1.a.c()) == false) goto L16;
            this.a.h().a.b(Boolean.TRUE);
            AosEventReporter r7 = AosEventReporter.a;
            d r3 = this.a;
            com.bytedance.awemeopen.apps.framework.framework.viewpager.o r4 = r3.h;
            jz3.a r5 = r3.j;
            if (r5 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r5 = null;
        L10:
            r14.c r8 = r5.a;
            DiggType r9 = this.b;
            r7.getClass();
            AosEventReporter.E(r4, r8, r9, false);
            d r10 = this.a;
            com.bytedance.awemeopen.apps.framework.framework.viewpager.o r11 = r10.h;
            jz3.a r12 = r10.j;
            if (r12 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L14:
            AosEventReporter.E(r11, r2.a, this.b, true);
            this.a.k = false;
            return;
        L13:
            r2 = r12;
            goto L14
        }

        public a(d r1, DiggType r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        this.k = false;
        this.l = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new n();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new o();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        this.i.s3(this);
    }

    public final void r() {
        if (Intrinsics.areEqual(this.f.c, Boolean.TRUE) == false) goto L13;
        o r0 = h();
        q24.c r1 = this.i;
        Activity r2 = this.g;
        jz3.a r3 = this.j;
        jz3.a r4 = null;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r3 = null;
    L7:
        r0.b.b(Long.valueOf(r1.f0(r2, r3.a)));
        o r5 = h();
        q24.c r6 = this.i;
        Activity r7 = this.g;
        jz3.a r8 = this.j;
        if (r8 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L11:
        r5.c.b(Boolean.valueOf(r6.m3(r7, r4.a)));
        return;
    L10:
        r4 = r8;
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<n, o> d() {
        if (f().b() == null) goto L9;
        if (f().c() == null) goto L9;
        Context r2 = getContext();
        n r3 = g();
        o r4 = h();
        Integer r1 = f().b();
        Intrinsics.checkNotNull(r1);
        int r5 = r1.intValue();
        Integer r6 = f().c();
        Intrinsics.checkNotNull(r6);
        return new i(r2, r3, r4, r5, r6.intValue());
    L9:
        return new m(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        n r0 = g();
        Observer<Unit> r1 = new b(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.a.b;
    }

    public final Activity getActivity() {
        return this.g;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "aid");
        jz3.a r0 = this.j;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r0 = null;
    L6:
        if (Intrinsics.areEqual(r2, r0.a.c()) == false) goto L9;
        r();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r3) {
        final jz3.a r4 = r3;
        Intrinsics.checkNotNullParameter(r4, "data");
        p();
        this.j = r4;
        this.k = false;
        this.l = false;
        this.i.Y(this);
        r();
        o r0 = h();
        Observer<Long> r1 = new c(r4, this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.b.a(r1);
    }

    public final void q(DiggType r9) {
        Intrinsics.checkNotNullParameter(r9, "diggType");
        jz3.a r0 = this.j;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.i.m3(this.g, r0.a) == false) goto L9;
        return;
    L9:
        if (this.k == false) goto L11;
        return;
    L11:
        AosEventReporter r1 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r2 = this.h;
        jz3.a r3 = this.j;
        jz3.a r4 = null;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r3 = null;
    L14:
        r14.c r5 = r3.a;
        r1.getClass();
        AosEventReporter.q(r2, r5, r9, "click_like");
        this.k = true;
        q24.c r6 = this.i;
        Context r7 = getContext();
        jz3.a r8 = this.j;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L18:
        r14.c r10 = r4.a;
        Activity r11 = this.g;
        int r12 = com.bytedance.awemeopen.bizmodels.user.a.a;
        if (this.h.getPageConfig().isCardMode() == false) goto L21;
        Map r13 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_card_mode", CommentScene.COMMENTSCENE_NO_AWEME)});
    L22:
        r6.j3(r7, r10, new com.bytedance.awemeopen.bizmodels.user.f(r11, "like", r13), new a(this, r9));
        return;
    L21:
        r13 = new LinkedHashMap();
        goto L22
    L17:
        r4 = r8;
        goto L18
    }

    public d(Activity r2, com.bytedance.awemeopen.apps.framework.framework.viewpager.o r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
        if (r3.getPageConfig().isTeenagerModel() == false) goto L5;
        d14.a r4 = b14.a.a;
        q24.c r5 = (q24.c) b14.a.a(m34.a.class);
    L6:
        this.i = r5;
        return;
    L5:
        d14.a r6 = b14.a.a;
        r5 = b14.a.a(q24.c.class);
        goto L6
    }
}
