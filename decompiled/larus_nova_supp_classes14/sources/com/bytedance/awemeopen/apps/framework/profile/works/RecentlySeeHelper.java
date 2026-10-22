package com.bytedance.awemeopen.apps.framework.profile.works;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.apps.framework.utils.p0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class RecentlySeeHelper {
    public boolean A;
    public final Lazy a;
    public final Lazy b;
    public ViewGroup c;
    public TextView d;
    public ImageView e;
    public RecyclerView f;
    public GridLayoutManager g;
    public User h;
    public String i;
    public int j;
    public boolean k;
    public boolean l;
    public RefreshStatus m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public final int[] r;
    public final Lazy s;
    public final RotateAnimation t;
    public Function0<String> u;
    public Function0<Integer> v;
    public Function2<? super Integer, ? super a, Unit> w;
    public Function0<Unit> x;
    public final b y;
    public final RecentlySeeHelper$scrollListener$1 z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper$RefreshStatus;", "", "NONE", "SUCCESS", "FAILED", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum RefreshStatus extends Enum<RefreshStatus> {
        public static final RefreshStatus FAILED = null;
        public static final RefreshStatus NONE = null;
        public static final RefreshStatus SUCCESS = null;
        public static final /* synthetic */ RefreshStatus[] a = null;

        public static RefreshStatus valueOf(String r1) {
            return (RefreshStatus) r27.a.a(RefreshStatus.class, r1);
        }

        public static RefreshStatus[] values() {
            return (RefreshStatus[]) a.clone();
        }

        static {
            RefreshStatus r0 = new RefreshStatus("NONE", 0);
            NONE = r0;
            RefreshStatus r1 = new RefreshStatus("SUCCESS", 1);
            SUCCESS = r1;
            RefreshStatus r3 = new RefreshStatus("FAILED", 2);
            FAILED = r3;
            a = new RefreshStatus[]{r0, r1, r3};
        }

        public RefreshStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a();

        void onFail();

        void onSuccess(List<jz3.a> r1, boolean r2);
    }

    public static final class b implements DampScrollableLayout.d {
        public final /* synthetic */ RecentlySeeHelper a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            this.a.a();
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
            this.a.a();
        }

        public b(RecentlySeeHelper r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r1) {
            this.a.a();
        }
    }

    public final void a() {
        if (this.k == true) goto L5;
        return;
    L5:
        if (this.m == RefreshStatus.SUCCESS) goto L8;
        return;
    L8:
        if (this.A == true) goto L10;
    L136:
        ViewGroup r1 = this.c;
        if (r1 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        ViewGroup r2 = null;
    L140:
        x54.b.b(r2);
        return;
    L139:
        r2 = r1;
        goto L140
    L10:
        if (this.l == true) goto L136;
        if (this.j >= 0) goto L20;
        e();
        ImageView r3 = this.e;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r4 = null;
    L18:
        r4.setRotation(0.0f);
        return;
    L17:
        r4 = r3;
        goto L18
    L20:
        RecyclerView r5 = this.f;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r5 = null;
    L23:
        RecyclerView.ViewHolder r6 = r5.findViewHolderForAdapterPosition(this.j);
        if (r6 != null) goto L40;
        int r7 = this.j;
        LinearLayoutManager r8 = this.g;
        if (r8 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r8 = null;
    L29:
        if (r7 >= r8.findFirstCompletelyVisibleItemPosition()) goto L35;
        e();
        ImageView r9 = this.e;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r10 = null;
    L34:
        r10.setRotation(180.0f);
        return;
    L33:
        r10 = r9;
        goto L34
    L35:
        e();
        ImageView r11 = this.e;
        if (r11 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r12 = null;
    L39:
        r12.setRotation(0.0f);
        return;
    L38:
        r12 = r11;
        goto L39
    L40:
        r6.itemView.getLocationOnScreen(this.r);
        int r13 = this.r[1];
        if (r13 > ((Number) this.s.getValue()).intValue()) goto L47;
        e();
        ImageView r14 = this.e;
        if (r14 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r15 = null;
    L46:
        r15.setRotation(180.0f);
        return;
    L45:
        r15 = r14;
        goto L46
    L47:
        Function0<Integer> r16 = this.v;
        if (r16 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("getBottomY");
        r16 = null;
    L51:
        int r17 = ((Number) r16.invoke()).intValue();
        if (r17 > 0) goto L58;
        ViewGroup r18 = this.f;
        if (r18 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r18 = null;
    L56:
        r17 = d0.c(r18.getContext());
    L58:
        if ((r13 + r6.itemView.getHeight()) <= r17) goto L65;
        e();
        ImageView r19 = this.e;
        if (r19 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r20 = null;
    L63:
        r20.setRotation(0.0f);
        return;
    L62:
        r20 = r19;
        goto L63
    L65:
        if (this.q == false) goto L91;
        this.q = false;
        d14.a r21 = b14.a.a;
        t24.a r110 = b14.a.a(t24.a.class);
        Function0<String> r22 = this.u;
        if (r22 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("enterMethod");
        r22 = null;
    L70:
        String r111 = (String) r22.invoke();
        User r23 = this.h;
        if (r23 == null) goto L73;
        String r24 = r23.u();
    L75:
        if (r24 != null) goto L77;
        String r112 = "";
    L78:
        String r25 = this.i;
        if (r25 != null) goto L81;
        String r113 = "";
    L82:
        User r26 = this.h;
        if (r26 == null) goto L85;
        String r27 = r26.u();
    L86:
        if (r27 != null) goto L88;
        String r114 = "";
    L89:
        r110.f3(r111, r112, r113, r114, null);
        goto L91
    L88:
        r114 = r27;
        goto L89
    L85:
        r27 = null;
        goto L86
    L81:
        r113 = r25;
        goto L82
    L77:
        r112 = r24;
        goto L78
    L73:
        r24 = null;
    L91:
        if (this.o == false) goto L130;
        this.o = false;
        this.k = false;
        if (this.n == false) goto L130;
        this.n = false;
        UserProfileWorkViewHolder r28 = (UserProfileWorkViewHolder) r6;
        RecyclerView r29 = this.f;
        if (r29 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r29 = null;
    L98:
        if (r29.computeVerticalScrollOffset() != 0) goto L100;
        boolean r30 = true;
    L101:
        g r31 = r28.k;
        final View r32 = ((RecyclerView.ViewHolder) r28).itemView;
        int r33 = r28.j;
        r31.getClass();
        Intrinsics.checkNotNullParameter(r32, "itemView");
        ViewCompat.setElevation(r32, 1.0f);
        if (r33 >= 3) goto L105;
        if (r30 == false) goto L105;
        boolean r34 = true;
    L107:
        if (r31.a.isEmpty() == true) goto L109;
        r31.a.clear();
    L109:
        ViewParent r115 = r32.getParent();
    L111:
        if ((r115 instanceof ViewGroup) == false) goto L121;
        Pair<ViewGroup, boolean[]> r116 = new Pair(r115, new boolean[2]);
        ViewGroup r35 = (ViewGroup) r115;
        ((boolean[]) r116.second)[0] = r35.getClipChildren();
        ((boolean[]) r116.second)[1] = r35.getClipToPadding();
        r31.a.push(r116);
        r35.setClipChildren(false);
        r35.setClipToPadding(false);
        if (r34 == false) goto L118;
        if ((r115 instanceof DampScrollableLayout) == true) goto L121;
    L120:
        r115 = r35.getParent();
        goto L111
    L118:
        if ((r115 instanceof ViewPager) == false) goto L120;
    L121:
        int r36 = r33 % 3;
        if (r36 == 0) goto L128;
        if (r36 == 1) goto L127;
        if (r36 != 2) goto L129;
        r32.setPivotX(r32.getWidth());
        r32.setPivotY(r32.getHeight() / 2.0f);
    L129:
        Resources r37 = Resources.getSystem();
        ValueAnimator r38 = ValueAnimator.ofObject(new g.a(), new Object[]{new g.b(1.0f, 0.0f), new g.b(1.2f, TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r37, r37.getDisplayMetrics()))), new g.b(1.0f, 0.0f)});
        r38.setDuration(500);
        r38.setInterpolator(new c());
        r38.addUpdateListener(new f(r32));
        r38.addListener(new h(r32, r31));
        r38.start();
        goto L130
    L127:
        r32.setPivotX(r32.getWidth() / 2.0f);
        r32.setPivotY(r32.getHeight() / 2.0f);
        goto L129
    L128:
        r32.setPivotX(0.0f);
        r32.setPivotY(r32.getHeight() / 2.0f);
    L105:
        r34 = false;
        goto L107
    L100:
        r30 = false;
    L130:
        ViewGroup r39 = this.c;
        if (r39 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        ViewGroup r40 = null;
    L134:
        x54.b.b(r40);
        return;
    L133:
        r40 = r39;
        goto L134
    }

    public final void d() {
        this.i = "";
        this.j = -1;
        this.k = false;
        ImageView r1 = this.e;
        TextView r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        r1 = null;
    L5:
        r1.setRotation(180.0f);
        ViewGroup r3 = this.c;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        r3 = null;
    L8:
        x54.b.b(r3);
        f();
        this.p = true;
        this.q = true;
        this.n = true;
        this.o = false;
        this.m = RefreshStatus.NONE;
        TextView r0 = this.d;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L12:
        r2.setText(2131894269);
        return;
    L11:
        r2 = r0;
        goto L12
    }

    public final void e() {
        ViewGroup r0 = this.c;
        String r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        r0 = null;
    L5:
        x54.b.d(r0);
        if (this.p == false) goto L29;
        this.p = false;
        d14.a r2 = b14.a.a;
        t24.a r3 = b14.a.a(t24.a.class);
        Function0<String> r4 = this.u;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("enterMethod");
        r4 = null;
    L11:
        String r5 = (String) r4.invoke();
        User r6 = this.h;
        if (r6 == null) goto L14;
        String r7 = r6.u();
    L16:
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        String r8 = this.i;
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        User r9 = this.h;
        if (r9 == null) goto L24;
        r1 = r9.u();
    L24:
        if (r1 != null) goto L26;
        String r10 = "";
    L27:
        r3.O(r5, r7, r8, r10, null);
        return;
    L26:
        r10 = r1;
        goto L27
    L14:
        r7 = null;
        goto L16
    }

    public final void f() {
        ImageView r0 = this.e;
        ImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        r0 = null;
    L5:
        r0.setImageResource(2131247413);
        ImageView r2 = this.e;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
    L9:
        r1.clearAnimation();
        a();
        return;
    L8:
        r1 = r2;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper$scrollListener$1] */
    public RecentlySeeHelper() {
        this.a = LazyKt.lazy(RecentlySeeHelper$locateCount$2.INSTANCE);
        this.b = LazyKt.lazy(RecentlySeeHelper$showRecentlySee$2.INSTANCE);
        this.i = "";
        this.j = -1;
        this.m = RefreshStatus.NONE;
        this.n = true;
        this.p = true;
        this.q = true;
        this.r = new int[2];
        this.s = LazyKt.lazy(new RecentlySeeHelper$topY$2(this));
        RotateAnimation r2 = new RotateAnimation(0.0f, 43200.0f, 1, 0.5f, 1, 0.5f);
        r2.setDuration(120000);
        r2.setInterpolator(new LinearInterpolator());
        r2.setRepeatCount(-1);
        r2.setRepeatMode(1);
        this.t = r2;
        this.y = new b(this);
        this.z = new RecentlySeeHelper$scrollListener$1(this);
        this.A = true;
    }

    public final void c(int r8) {
        LinearLayoutManager r0 = this.g;
        GridLayoutManager r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r0 = null;
    L5:
        int r4 = 0;
        if (Math.abs(r8 - r0.findFirstCompletelyVisibleItemPosition()) <= 300) goto L68;
        RecyclerView r2 = this.f;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r2 = null;
    L10:
        r2.stopScroll();
        RecyclerView r3 = this.f;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r3 = null;
    L13:
        LinearLayoutManager r5 = this.g;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r5 = null;
    L16:
        RecyclerView.ViewHolder r6 = r3.findViewHolderForAdapterPosition(r5.findFirstCompletelyVisibleItemPosition());
        if (r6 == null) goto L100;
        Function0<Unit> r7 = this.x;
        if (r7 == null) goto L22;
        r7.invoke();
    L22:
        LinearLayoutManager r9 = this.g;
        if (r9 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r9 = null;
    L25:
        int r10 = r9.findFirstCompletelyVisibleItemPosition();
        ViewGroup r11 = this.f;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r11 = null;
    L28:
        int r12 = RangesKt.coerceAtLeast((d0.c(r11.getContext()) / 2) / r6.itemView.getHeight(), 0);
        if (r8 <= r10) goto L54;
        RecyclerView r13 = this.f;
        if (r13 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r13 = null;
    L33:
        RecyclerView.Adapter r14 = r13.getAdapter();
        if (r14 == null) goto L36;
        Integer r15 = Integer.valueOf(r14.getItemCount());
    L37:
        RecyclerView r16 = this.f;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r16 = null;
    L40:
        if (r15 == null) goto L53;
        GridLayoutManager r17 = this.g;
        if (r17 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r17 = null;
    L46:
        if (((r17.getSpanCount() * r12) + r8) >= (r15.intValue() - 1)) goto L52;
        GridLayoutManager r18 = this.g;
        if (r18 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
    L51:
        r8 = r8 + (r1.getSpanCount() * r12);
        goto L53
    L50:
        r1 = r18;
        goto L51
    L52:
        r8 = r15.intValue() - 1;
    L53:
        r16.scrollToPosition(r8);
        return;
    L36:
        r15 = null;
        goto L37
    L54:
        RecyclerView r19 = this.f;
        if (r19 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r19 = null;
    L57:
        GridLayoutManager r20 = this.g;
        if (r20 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r20 = null;
    L61:
        if ((r8 - (r20.getSpanCount() * r12)) < 0) goto L67;
        GridLayoutManager r21 = this.g;
        if (r21 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
    L66:
        r4 = r8 - (r1.getSpanCount() * r12);
        goto L67
    L65:
        r1 = r21;
    L67:
        r19.scrollToPosition(r4);
        return;
    L100:
        return;
    L68:
        RecyclerView r22 = this.f;
        if (r22 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r22 = null;
    L71:
        r22.stopScroll();
        RecyclerView r23 = this.f;
        if (r23 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r23 = null;
    L74:
        int r24 = r23.computeVerticalScrollOffset();
        GridLayoutManager r25 = this.g;
        if (r25 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r25 = null;
    L77:
        int r26 = r8 / r25.getSpanCount();
        RecyclerView r27 = this.f;
        if (r27 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r27 = null;
    L80:
        LinearLayoutManager r28 = this.g;
        if (r28 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r28 = null;
    L83:
        RecyclerView.ViewHolder r29 = r27.findViewHolderForAdapterPosition(r28.findFirstCompletelyVisibleItemPosition());
        if (r29 == null) goto L101;
        int r30 = r29.itemView.getHeight() * (r26 + 1);
        ViewGroup r31 = this.f;
        if (r31 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r31 = null;
    L89:
        int r32 = (r30 - (d0.c(r31.getContext()) / 2)) - r24;
        Function0<Unit> r33 = this.x;
        if (r33 == null) goto L92;
        r33.invoke();
    L92:
        GridLayoutManager r34 = this.f;
        if (r34 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L96:
        r1.smoothScrollBy(0, r32);
        return;
    L95:
        r1 = r34;
        goto L96
    }

    public static int b(List r2, String r3) {
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        jz3.a r0 = (jz3.a) r4.next();
        if (Intrinsics.areEqual(r0.a.c(), r3) == false) goto L4;
        return r0.d;
    L9:
        return -1;
    }

    public final void update(User r3, String r4, boolean r5) {
        d();
        this.h = r3;
        this.i = r4;
        boolean r1 = false;
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L19;
        if (r5 == true) goto L19;
        if (r3 == null) goto L19;
        if (r3.M() == true) goto L19;
        if (p0.d(r3) == true) goto L19;
        if (r4 != null) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L19;
        r1 = true;
        goto L19
    L13:
        if (r4.length() == 0) goto L16;
        r6 = false;
    L19:
        this.k = r1;
    }
}
