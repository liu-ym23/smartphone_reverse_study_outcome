package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.shopping.anchorv4.experiment.h;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderMediaModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.e;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.i;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.j;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.k;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.r;
import com.bytedance.android.shopping.utils.d0;
import com.bytedance.android.shopping.utils.x;
import com.bytedance.android.shopping.utils.y;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static Integer n;
    public final boolean a;
    public com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.c b;
    public Integer c;
    public int d;
    public float e;
    public View f;
    public ValueAnimator g;
    public Integer h;
    public final Context i;
    public final s j;

    public static final class a {
        public a() {
        }

        public static int c(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Integer r0 = b.n;
            if (r0 != null) goto L5;
            int r2 = th.a.f(r1).getDimensionPixelOffset(2131165695);
            b.n = Integer.valueOf(r2);
            return r2;
        L5:
            return r0.intValue();
        }

        public static final int a(Context r1, boolean r2) {
            int r0 = b.k;
            int r3 = y.a;
            return (((int) ((y.d(r1, Boolean.valueOf(r2)) - com.bytedance.android.shopping.extensions.b.a(44)) / 3.0f)) * 2) + com.bytedance.android.shopping.extensions.b.a(6);
        }

        public static int b(Context r2, float r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Float r5 = Float.valueOf(r3);
            if (r5.floatValue() == 0.0f) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L9;
            r5 = null;
        L9:
            if (r5 == null) goto L11;
            float r6 = r5.floatValue();
        L12:
            int r1 = y.a;
            return (int) (y.d(r2, Boolean.valueOf(r4)) * r6);
        L11:
            r6 = 0.6666667f;
            goto L12
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b$b, reason: collision with other inner class name */
    public static final class RunnableC0012b implements Runnable {
        public final /* synthetic */ RecyclerView a;

        public RunnableC0012b(RecyclerView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ b a;

        public c(b r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r4) {
            b r0 = this.a;
            Object r5 = r4.getAnimatedValue();
            Integer r2 = null;
            if ((r5 instanceof Number) == true) goto L5;
            r5 = null;
        L5:
            Number r6 = (Number) r5;
            if (r6 == null) goto L8;
            r2 = Integer.valueOf(r6.intValue());
        L8:
            r0.c = r2;
            this.a.p();
        }
    }

    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ b a;

        public d(b r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.p();
        }
    }

    static {
        new a();
        k = com.bytedance.android.shopping.extensions.b.a(16);
        l = com.bytedance.android.shopping.extensions.b.a(6);
        m = com.bytedance.android.shopping.extensions.b.a(4);
    }

    public final int c() {
        return this.j.W4();
    }

    public final int m() {
        RecyclerView r0 = this.j.getRecyclerView();
        if (r0 == null) goto L14;
        Integer r1 = Integer.valueOf(r0.getWidth());
        if (r1.intValue() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L14;
        return r1.intValue();
    L7:
        r2 = false;
    L14:
        return n();
    }

    public final int n() {
        int r0 = y.a;
        return y.d(this.i, Boolean.valueOf(this.j.rR().d()));
    }

    public final boolean o() {
        if (this.a == true) goto L5;
        return false;
    L5:
        if (this.j.n0() == true) goto L19;
        Integer r0 = this.j.Lz();
        if (r0 != null) goto L10;
        return false;
    L10:
        if (r0.intValue() == 0) goto L12;
        return false;
    L12:
        if (this.j.W4() <= 0) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == true) goto L21;
        return true;
    L21:
        return false;
    L14:
        r1 = false;
        goto L15
    L19:
        return false;
    }

    public final void p() {
        RecyclerView r0 = this.j.getRecyclerView();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isInLayout() == false) goto L7;
        r0.post(new RunnableC0012b(r0));
        return;
    L7:
        r0.requestLayout();
    }

    public final Context getContext() {
        return this.i;
    }

    public final float b(int r2) {
        AnchorV4HeadV2VO r0 = this.j.K10();
        if (r0 == null) goto L9;
        i r3 = r0.getCellStyle(r2);
        if (r3 == null) goto L9;
        Float r4 = r3.a();
        if (r4 == null) goto L9;
        return r4.floatValue();
    L9:
        return 1.0f;
    }

    public b(Context r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        this.i = r2;
        this.j = r3;
        this.a = com.bytedance.android.shopping.anchorv3.detail.utils.a.a();
        this.d = r3.getCurrentPosition();
    }

    public final int e(boolean r4, int r5) {
        if (s.a.b(this.j, Integer.valueOf(r5), 2) == false) goto L7;
        return (int) (b(r5) * n());
    L7:
        if (h.a() == false) goto L10;
    L14:
        return -1;
    L10:
        if (this.a == false) goto L14;
        if (r4 == false) goto L17;
        return a.a(this.i, this.j.rR().d());
    L17:
        return n();
    }

    public final int g(boolean r5, int r6) {
        AnchorV4HeadV2VO r0 = this.j.K10();
        if (r0 == null) goto L9;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L9;
        HeaderContentModel r2 = (HeaderContentModel) CollectionsKt.lastOrNull(r1);
        if (r2 == null) goto L9;
        HeaderMediaModel r3 = r2.getMedia();
    L10:
        boolean r4 = true;
        if (r3 != null) goto L13;
        boolean r7 = true;
    L14:
        AnchorV4HeadV2VO r8 = this.j.K10();
        if (r8 == null) goto L21;
        List<HeaderContentModel> r9 = r8.getCells();
        if (r9 == null) goto L21;
        if (r6 != (r9.size() - 1)) goto L21;
    L23:
        if (this.j.Mm() == false) goto L33;
        if (this.j.Gv() == false) goto L33;
        if (r5 == false) goto L33;
        if (r6 == 0) goto L48;
        if (r7 == false) goto L49;
        if (r4 == false) goto L49;
        return 0;
    L49:
        return m;
    L48:
        return 0;
    L33:
        if (this.j.wZ() == false) goto L37;
        if (r6 == 0) goto L37;
        int r10 = com.bytedance.android.ec.hybrid.list.util.c.a;
        return com.bytedance.android.ec.hybrid.list.util.c.d(Integer.valueOf(ECSettingKeys.A0().f()));
    L37:
        if (s.a.b(this.j, Integer.valueOf(r6), 2) == false) goto L41;
        if (r6 != 0) goto L52;
        return com.bytedance.android.shopping.extensions.b.a(12);
    L52:
        return com.bytedance.android.shopping.extensions.b.a(6);
    L41:
        if (r5 == true) goto L43;
        return 0;
    L43:
        if (o() == false) goto L54;
        if (r6 != 0) goto L47;
        return k;
    L47:
        return l;
    L54:
        return 0;
    L21:
        r4 = false;
        goto L23
    L13:
        r7 = false;
    L9:
        r3 = null;
        goto L10
    }

    public final int h(boolean r6, int r7) {
        AnchorV4HeadV2VO r0 = this.j.K10();
        if (r0 == null) goto L9;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r7 != (r1.size() - 1)) goto L9;
    L11:
        if (s.a.b(this.j, Integer.valueOf(r7), 2) == false) goto L17;
        AnchorV4HeadV2VO r8 = this.j.K10();
        if (r8 != null) goto L15;
        return 0;
    L15:
        if (r8.getLastScaleIndex() == r7) goto L25;
        return 0;
    L25:
        return com.bytedance.android.shopping.extensions.b.a(12);
    L17:
        if (r6 == true) goto L19;
        return 0;
    L19:
        if (o() == false) goto L27;
        if (r2 == true) goto L22;
        return 0;
    L22:
        return k;
    L27:
        return 0;
    L9:
        r2 = false;
        goto L11
    }

    public final int i(boolean r3, int r4) {
        if (s.a.b(this.j, Integer.valueOf(r4), 2) == true) goto L11;
        if (r3 == true) goto L7;
    L9:
        return 0;
    L7:
        if (o() == false) goto L9;
        return com.bytedance.android.shopping.extensions.b.a(8);
    L11:
        return com.bytedance.android.shopping.extensions.b.a(12);
    }

    public final int l(boolean r4, int r5) {
        if (this.j.W4() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L23;
        if (r4 == false) goto L35;
        Integer r6 = Integer.valueOf(r5);
        if (r6 == null) goto L14;
        if (r6.intValue() < this.j.W4()) goto L14;
        return n();
    L14:
        if (this.j.W4() != 1) goto L34;
        if (r6 == null) goto L34;
        if (r6.intValue() != 0) goto L34;
        return n();
    L34:
        return a.b(this.i, this.j.s00(), this.j.rR().d());
    L35:
        return n();
    L23:
        if (s.a.b(this.j, Integer.valueOf(r5), 2) == false) goto L26;
        return (int) (b(r5) * n());
    L26:
        if (o() == false) goto L30;
        if (r4 == false) goto L38;
        return a.a(this.i, this.j.rR().d());
    L38:
        return n();
    L30:
        return -1;
    L5:
        r0 = false;
        goto L6
    }

    public final int a(int r12, float r13, Integer r14) {
        RecyclerView r1 = null;
        boolean r2 = false;
        if (this.j.isExpanded() == false) goto L5;
    L33:
        float r0 = k(this, r12, r14, null, null, 12);
    L34:
        r12 = r12 - 1;
        if (r12 <= 0) goto L39;
        if (this.j.aN(r12) == true) goto L34;
    L39:
        float r15 = k(this, RangesKt.coerceAtLeast(r12, 0), r14, null, null, 12);
        RecyclerView r4 = this.j.getRecyclerView();
        if ((r4 instanceof HeadRecyclerView) == false) goto L43;
        r1 = r4;
    L43:
        HeadRecyclerView r3 = (HeadRecyclerView) r1;
        if (r3 != null) goto L46;
    L48:
        if (r2 == true) goto L59;
        if (r14 == null) goto L52;
        int r16 = r14.intValue();
    L54:
        return (int) (r0 + ((r13 / r16) * (r15 - r0)));
    L52:
        r16 = m();
        goto L54
    L59:
        return (int) r15;
    L46:
        if (r3.t(false) != true) goto L48;
        r2 = true;
        goto L48
    L5:
        if (c() == 1) goto L33;
        if (r12 != (c() - 1)) goto L9;
    L10:
        RecyclerView r5 = this.j.getRecyclerView();
        if ((r5 instanceof HeadRecyclerView) == false) goto L14;
        r1 = r5;
    L14:
        HeadRecyclerView r6 = (HeadRecyclerView) r1;
        if (r6 != null) goto L17;
    L19:
        if (r2 == false) goto L21;
        float r17 = k(this, r12 - 1, r14, null, null, 12);
    L58:
        return (int) r17;
    L21:
        float r7 = k(this, r12, r14, null, null, 12);
        int r8 = a.b(this.i, this.j.s00(), this.j.rR().d());
        if (r12 != (c() - 1)) goto L28;
        float r9 = (r8 + h(this.j.isExpanded(), r12)) / 2.0f;
        if (r13 >= (-r9)) goto L32;
        float r18 = (Math.abs(r13) - r9) / r9;
        float r19 = k(this, r12 + 1, r14, null, null, 12);
        int r110 = x.a;
        r7 = r7 + ((r19 - r7) * r18);
    L32:
        return (int) r7;
    L28:
        if (r12 != c()) goto L32;
        float r10 = r8;
        float r111 = k(this, r12 - 1, r14, null, null, 12);
        int r112 = x.a;
        r17 = r111 + ((r7 - r111) * ((r10 - r13) / r10));
        goto L58
    L17:
        if (r6.t(false) != true) goto L19;
        r2 = true;
        goto L19
    L9:
        if (r12 != c()) goto L33;
        goto L10
    }

    public final int d(boolean r2, int r3, Boolean r4) {
        if (this.j.qV(Integer.valueOf(r3), r4) == false) goto L7;
        if (r2 == false) goto L14;
        return com.bytedance.android.shopping.extensions.b.a(12);
    L14:
        return com.bytedance.android.shopping.extensions.b.a(48);
    L7:
        if (r2 == true) goto L9;
    L11:
        return 0;
    L9:
        if (o() == false) goto L11;
        return k;
    }

    public final float f(int r4, Integer r5, boolean r6) {
        AnchorV4HeadV2VO r0 = this.j.K10();
        Float r1 = null;
        if (r0 == null) goto L7;
        List<HeaderContentModel> r2 = r0.getCells();
        if (r2 == null) goto L7;
        HeaderContentModel r7 = (HeaderContentModel) CollectionsKt.getOrNull(r2, r4);
    L8:
        if (r7 == null) goto L16;
        r r3 = r7.getMultiPreview();
        if (r3 == null) goto L16;
        List<k> r8 = r3.a();
        if (r8 == null) goto L16;
        k r9 = (k) CollectionsKt.getOrNull(r8, 0);
        if (r9 == null) goto L16;
        HeaderContentModel r10 = r9.a();
    L17:
        if (r10 == null) goto L22;
        Float r11 = r10.getWHScale(r6);
        if (r11 == null) goto L22;
        r1 = r11;
    L24:
        if (r1 == null) goto L26;
        float r12 = r1.floatValue();
    L27:
        if (r5 == null) goto L29;
        int r13 = r5.intValue();
    L31:
        return r13 / r12;
    L29:
        r13 = m();
        goto L31
    L26:
        r12 = 1.0f;
    L22:
        if (r7 == null) goto L24;
        r1 = r7.getWHScale(r6);
    L16:
        r10 = null;
    L7:
        r7 = null;
        goto L8
    }

    public final int j(boolean r6, int r7, Boolean r8) {
        AnchorV4HeadV2VO r0 = this.j.K10();
        int r2 = 0;
        if (r0 == null) goto L21;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L21;
        HeaderContentModel r3 = (HeaderContentModel) CollectionsKt.getOrNull(r1, r7);
        if (r3 == null) goto L21;
        if (r3.getLynx() == null) goto L11;
        boolean r4 = this.j.Pg().b(r3.getLynx());
    L13:
        if (r3.getNeedStatusBarPlace() == true) goto L19;
        if (r4 == false) goto L21;
        j r5 = r3.getLynx();
        if (r5 == null) goto L21;
        if (r5.d() != true) goto L21;
    L19:
        return 0;
    L11:
        r4 = false;
    L21:
        if (this.j.qV(Integer.valueOf(r7), r8) == false) goto L25;
        if (r6 == false) goto L63;
        return com.bytedance.android.shopping.extensions.b.a(12);
    L63:
        return com.bytedance.android.shopping.extensions.b.a(44);
    L25:
        if (r6 == false) goto L30;
        if (o() == false) goto L30;
        return k;
    L30:
        if (h.a() == false) goto L65;
        AnchorV4HeadV2VO r9 = this.j.K10();
        if (r9 == null) goto L36;
        List<HeaderContentModel> r10 = r9.getCells();
        if (r10 == null) goto L36;
        HeaderContentModel r11 = (HeaderContentModel) CollectionsKt.getOrNull(r10, r7);
    L37:
        if (r6 == true) goto L57;
        if (r11 == null) goto L42;
        Float r12 = r11.getTopPadding();
        if (r12 == null) goto L42;
        int r13 = com.bytedance.android.shopping.extensions.b.a(r12);
    L43:
        if (r11 == null) goto L66;
        if (r11.getNeedShowBar() != true) goto L66;
        if (this.j.Pg().b(r11.getLynx()) == false) goto L53;
        j r14 = r11.getLynx();
        if (r14 == null) goto L53;
        if (r14.d() == true) goto L66;
    L53:
        if (e.c == false) goto L55;
        r2 = a.c(this.i) - d0.a();
        goto L66
    L55:
        r2 = a.c(this.i);
    L66:
        return r2 + r13;
    L42:
        r13 = 0;
        goto L43
    L57:
        if (r11 == null) goto L67;
        Float r15 = r11.getTopPaddingHalf();
        if (r15 != null) goto L61;
        return 0;
    L61:
        return com.bytedance.android.shopping.extensions.b.a(r15);
    L67:
        return 0;
    L36:
        r11 = null;
        goto L37
    L65:
        return 0;
    }

    public final void q(int r11, View r12, Integer r13) {
        Intrinsics.checkNotNullParameter(r12, "child");
        if (h.a() == true) goto L5;
        return;
    L5:
        if (r11 >= 0) goto L7;
        return;
    L7:
        if (r12.getX() < 0) goto L36;
        ValueAnimator r0 = this.g;
        if (r0 == null) goto L12;
        r0.cancel();
    L12:
        this.g = null;
        if (this.c != null) goto L15;
    L27:
        int r14 = a(r11, r12.getX(), null);
        Integer r1 = this.c;
        if (r1 != null) goto L31;
    L32:
        this.c = Integer.valueOf(r14);
        p();
    L33:
        this.d = r11;
        this.e = r12.getX();
        this.f = r12;
        return;
    L31:
        if (r1.intValue() == r14) goto L33;
    L15:
        if (this.d == r11) goto L27;
        if (this.e == 0.0f) goto L19;
    L20:
        if (r13 == null) goto L27;
        if (r13.intValue() != 0) goto L27;
    L24:
        float r2 = k(this, this.d, null, null, null, 14);
        float r15 = k(this, r11, null, null, null, 14);
        if (r2 == r15) goto L33;
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{r2, r15});
        r16.setDuration(350);
        r16.addUpdateListener(new c(this));
        r16.addListener(new d(this));
        r16.start();
        Unit r3 = Unit.INSTANCE;
        this.g = r16;
        goto L33
    L19:
        if (r12.getX() == 0.0f) goto L24;
    }

    public static float k(b r4, int r5, Integer r6, Boolean r7, Boolean r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r6 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r7 = null;
    L9:
        if ((r9 & 8) == 0) goto L11;
        r8 = null;
    L11:
        if (r7 == null) goto L13;
        r4.getClass();
        boolean r10 = r7.booleanValue();
    L14:
        boolean r11 = true;
        boolean r12 = !r10;
        AnchorV4HeadV2VO r0 = r4.j.K10();
        if (r0 == null) goto L31;
        List<HeaderContentModel> r1 = r0.getCells();
        if (r1 == null) goto L31;
        HeaderContentModel r2 = (HeaderContentModel) CollectionsKt.getOrNull(r1, r5);
        if (r2 == null) goto L31;
        if (r2.getFixedHeight() == null) goto L31;
        if (r2.getLynx() == null) goto L25;
        boolean r3 = r4.j.Pg().b(r2.getLynx());
    L26:
        if (r3 == false) goto L28;
    L29:
        int r13 = com.bytedance.android.ec.hybrid.list.util.c.a;
        float r14 = com.bytedance.android.ec.hybrid.list.util.c.d(Float.valueOf(r2.getFixedHeight().intValue() * (r4.n() / q.a(375)))) - com.bytedance.android.ec.hybrid.list.util.c.d(20);
    L56:
        return (r14 + r4.j(r12, r5, r8)) + r4.d(r12, r5, r8);
    L28:
        if (r2.getLynx() != null) goto L31;
    L25:
        r3 = false;
    L31:
        if (r4.j.qV(Integer.valueOf(r5), r8) == false) goto L34;
        r14 = r4.b(r5) * r4.n();
        goto L56
    L34:
        if (r12 == false) goto L51;
        if (s.a.a(r4.j, Integer.valueOf(r5), 2) == false) goto L39;
        int r15 = k83.a.a;
        int r16 = k83.a.b(false, k83.a.a(r4.j.XU(), 0), r4.n());
    L53:
        r14 = r16;
        goto L56
    L39:
        if (r4.j.W4() > 0) goto L42;
        r11 = false;
    L42:
        if (r11 == false) goto L48;
        if (r5 >= r4.j.W4()) goto L46;
        r16 = a.b(r4.i, r4.j.s00(), r4.j.rR().d());
        goto L53
    L46:
        r14 = r4.f(r5, r6, r12);
        goto L56
    L48:
        if (r4.o() == false) goto L54;
        r16 = a.a(r4.i, r4.j.rR().d());
    L54:
        r14 = r4.f(r5, r6, r12);
        goto L56
    L51:
        if (s.a.a(r4.j, Integer.valueOf(r5), 2) == false) goto L54;
        int r17 = k83.a.a;
        r16 = k83.a.b(true, k83.a.a(r4.j.XU(), 0), r4.n());
        goto L53
    L13:
        r10 = r4.j.isExpanded();
        goto L14
    }
}
