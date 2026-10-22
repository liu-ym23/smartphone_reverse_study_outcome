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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.apps.framework.utils.p0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes14.dex */
public final class RecentlySeeHelper {
    public boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f197522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f197523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f197524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f197525d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f197526e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RecyclerView f197527f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GridLayoutManager f197528g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public User f197529h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f197530i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f197531j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f197532k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f197533l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RefreshStatus f197534m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f197535n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f197536o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f197537p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f197538q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int[] f197539r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f197540s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RotateAnimation f197541t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function0<String> f197542u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function0<Integer> f197543v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Function2<? super Integer, ? super a, Unit> f197544w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Function0<Unit> f197545x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f197546y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RecentlySeeHelper$scrollListener$1 f197547z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper$RefreshStatus;", "", UserProfileEvent.POSITION_NONE, "SUCCESS", "FAILED", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum RefreshStatus extends Enum<RefreshStatus> {
        public static final RefreshStatus FAILED = null;
        public static final RefreshStatus NONE = null;
        public static final RefreshStatus SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RefreshStatus[] f197548a = null;

        public static RefreshStatus valueOf(String r100) {
            return (RefreshStatus) r27.a.a(RefreshStatus.class, r100);
        }

        public static RefreshStatus[] values() {
            return (RefreshStatus[]) f197548a.clone();
        }

        static {
            RefreshStatus r100 = new RefreshStatus(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            RefreshStatus r101 = new RefreshStatus("SUCCESS", 1);
            SUCCESS = r101;
            RefreshStatus r102 = new RefreshStatus("FAILED", 2);
            FAILED = r102;
            f197548a = new RefreshStatus[]{r100, r101, r102};
        }

        public RefreshStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void a();

        void onFail();

        void onSuccess(List<jz3.a> r100, boolean r101);
    }

    public static final class b implements DampScrollableLayout.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecentlySeeHelper f197549a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            this.f197549a.a();
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
            this.f197549a.a();
        }

        public b(RecentlySeeHelper r100) {
            this.f197549a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r100) {
            this.f197549a.a();
        }
    }

    public final void a() {
        if (this.f197532k == true) goto L5;
        return;
    L5:
        if (this.f197534m == RefreshStatus.SUCCESS) goto L8;
        return;
    L8:
        if (this.A == true) goto L10;
    L136:
        ViewGroup r100 = this.f197524c;
        if (r100 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        ViewGroup r101 = null;
    L140:
        x54.b.b(r101);
        return;
    L139:
        r101 = r100;
        goto L140
    L10:
        if (this.f197533l == true) goto L136;
        if (this.f197531j >= 0) goto L20;
        e();
        ImageView r102 = this.f197526e;
        if (r102 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r103 = null;
    L18:
        r103.setRotation(0.0f);
        return;
    L17:
        r103 = r102;
        goto L18
    L20:
        RecyclerView r104 = this.f197527f;
        if (r104 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r104 = null;
    L23:
        RecyclerView.ViewHolder r105 = r104.findViewHolderForAdapterPosition(this.f197531j);
        if (r105 != null) goto L40;
        int r106 = this.f197531j;
        GridLayoutManager r107 = this.f197528g;
        if (r107 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r107 = null;
    L29:
        if (r106 >= r107.findFirstCompletelyVisibleItemPosition()) goto L35;
        e();
        ImageView r108 = this.f197526e;
        if (r108 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r109 = null;
    L34:
        r109.setRotation(180.0f);
        return;
    L33:
        r109 = r108;
        goto L34
    L35:
        e();
        ImageView r110 = this.f197526e;
        if (r110 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r111 = null;
    L39:
        r111.setRotation(0.0f);
        return;
    L38:
        r111 = r110;
        goto L39
    L40:
        r105.itemView.getLocationOnScreen(this.f197539r);
        int r112 = this.f197539r[1];
        if (r112 > ((Number) this.f197540s.getValue()).intValue()) goto L47;
        e();
        ImageView r113 = this.f197526e;
        if (r113 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r114 = null;
    L46:
        r114.setRotation(180.0f);
        return;
    L45:
        r114 = r113;
        goto L46
    L47:
        Function0<Integer> r115 = this.f197543v;
        if (r115 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("getBottomY");
        r115 = null;
    L51:
        int r116 = r115.invoke().intValue();
        if (r116 > 0) goto L58;
        RecyclerView r117 = this.f197527f;
        if (r117 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r117 = null;
    L56:
        r116 = d0.c(r117.getContext());
    L58:
        if ((r112 + r105.itemView.getHeight()) <= r116) goto L65;
        e();
        ImageView r118 = this.f197526e;
        if (r118 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        ImageView r119 = null;
    L63:
        r119.setRotation(0.0f);
        return;
    L62:
        r119 = r118;
        goto L63
    L65:
        if (this.f197538q == false) goto L91;
        this.f197538q = false;
        d14.a r120 = b14.a.f16924a;
        t24.a r121 = (t24.a) b14.a.a(t24.a.class);
        Function0<String> r122 = this.f197542u;
        if (r122 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("enterMethod");
        r122 = null;
    L70:
        String r123 = r122.invoke();
        User r124 = this.f197529h;
        if (r124 == null) goto L73;
        String r125 = r124.u();
    L75:
        if (r125 != null) goto L77;
        String r126 = "";
    L78:
        String r127 = this.f197530i;
        if (r127 != null) goto L81;
        String r128 = "";
    L82:
        User r129 = this.f197529h;
        if (r129 == null) goto L85;
        String r130 = r129.u();
    L86:
        if (r130 != null) goto L88;
        String r131 = "";
    L89:
        r121.f3(r123, r126, r128, r131, null);
        goto L91
    L88:
        r131 = r130;
        goto L89
    L85:
        r130 = null;
        goto L86
    L81:
        r128 = r127;
        goto L82
    L77:
        r126 = r125;
        goto L78
    L73:
        r125 = null;
    L91:
        if (this.f197536o == false) goto L130;
        this.f197536o = false;
        this.f197532k = false;
        if (this.f197535n == false) goto L130;
        this.f197535n = false;
        UserProfileWorkViewHolder r132 = (UserProfileWorkViewHolder) r105;
        RecyclerView r133 = this.f197527f;
        if (r133 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r133 = null;
    L98:
        if (r133.computeVerticalScrollOffset() != 0) goto L100;
        boolean r134 = true;
    L101:
        g r135 = r132.f197559k;
        final View r136 = r132.itemView;
        int r137 = r132.f197558j;
        r135.getClass();
        Intrinsics.checkNotNullParameter(r136, "itemView");
        ViewCompat.setElevation(r136, 1.0f);
        if (r137 >= 3) goto L105;
        if (r134 == false) goto L105;
        boolean r138 = true;
    L107:
        if (r135.f197586a.isEmpty() == true) goto L109;
        r135.f197586a.clear();
    L109:
        ViewParent r139 = r136.getParent();
    L111:
        if ((r139 instanceof ViewGroup) == false) goto L121;
        Pair<ViewGroup, boolean[]> r140 = new Pair(r139, new boolean[2]);
        ViewGroup r141 = (ViewGroup) r139;
        ((boolean[]) r140.second)[0] = r141.getClipChildren();
        ((boolean[]) r140.second)[1] = r141.getClipToPadding();
        r135.f197586a.push(r140);
        r141.setClipChildren(false);
        r141.setClipToPadding(false);
        if (r138 == false) goto L118;
        if ((r139 instanceof DampScrollableLayout) == true) goto L121;
    L120:
        r139 = r141.getParent();
        goto L111
    L118:
        if ((r139 instanceof ViewPager) == false) goto L120;
    L121:
        int r142 = r137 % 3;
        if (r142 == 0) goto L128;
        if (r142 == 1) goto L127;
        if (r142 != 2) goto L129;
        r136.setPivotX(r136.getWidth());
        r136.setPivotY(r136.getHeight() / 2.0f);
    L129:
        Resources r143 = Resources.getSystem();
        ValueAnimator r144 = ValueAnimator.ofObject(new g.a(), new Object[]{new g.b(1.0f, 0.0f), new g.b(1.2f, TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r143, r143.getDisplayMetrics()))), new g.b(1.0f, 0.0f)});
        r144.setDuration(500);
        r144.setInterpolator(new c());
        r144.addUpdateListener(new f(r136));
        r144.addListener(new h(r136, r135));
        r144.start();
        goto L130
    L127:
        r136.setPivotX(r136.getWidth() / 2.0f);
        r136.setPivotY(r136.getHeight() / 2.0f);
        goto L129
    L128:
        r136.setPivotX(0.0f);
        r136.setPivotY(r136.getHeight() / 2.0f);
    L105:
        r138 = false;
        goto L107
    L100:
        r134 = false;
    L130:
        ViewGroup r145 = this.f197524c;
        if (r145 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        ViewGroup r146 = null;
    L134:
        x54.b.b(r146);
        return;
    L133:
        r146 = r145;
        goto L134
    }

    public final void d() {
        this.f197530i = "";
        this.f197531j = -1;
        this.f197532k = false;
        ImageView r100 = this.f197526e;
        TextView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        r100 = null;
    L5:
        r100.setRotation(180.0f);
        ViewGroup r102 = this.f197524c;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        r102 = null;
    L8:
        x54.b.b(r102);
        f();
        this.f197537p = true;
        this.f197538q = true;
        this.f197535n = true;
        this.f197536o = false;
        this.f197534m = RefreshStatus.NONE;
        TextView r103 = this.f197525d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L12:
        r101.setText(R.string.aos_recently_see);
        return;
    L11:
        r101 = r103;
        goto L12
    }

    public final void e() {
        ViewGroup r100 = this.f197524c;
        String r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("buttonLayout");
        r100 = null;
    L5:
        x54.b.d(r100);
        if (this.f197537p == false) goto L29;
        this.f197537p = false;
        d14.a r102 = b14.a.f16924a;
        t24.a r103 = (t24.a) b14.a.a(t24.a.class);
        Function0<String> r104 = this.f197542u;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("enterMethod");
        r104 = null;
    L11:
        String r105 = r104.invoke();
        User r106 = this.f197529h;
        if (r106 == null) goto L14;
        String r107 = r106.u();
    L16:
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        String r108 = this.f197530i;
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        User r109 = this.f197529h;
        if (r109 == null) goto L24;
        r101 = r109.u();
    L24:
        if (r101 != null) goto L26;
        String r110 = "";
    L27:
        r103.O(r105, r107, r108, r110, null);
        return;
    L26:
        r110 = r101;
        goto L27
    L14:
        r107 = null;
        goto L16
    }

    public final void f() {
        ImageView r100 = this.f197526e;
        ImageView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        r100 = null;
    L5:
        r100.setImageResource(R.drawable.profile_ic_double_arrow_up);
        ImageView r102 = this.f197526e;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
    L9:
        r101.clearAnimation();
        a();
        return;
    L8:
        r101 = r102;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper$scrollListener$1] */
    public RecentlySeeHelper() {
        this.f197522a = LazyKt.lazy(RecentlySeeHelper$locateCount$2.INSTANCE);
        this.f197523b = LazyKt.lazy(RecentlySeeHelper$showRecentlySee$2.INSTANCE);
        this.f197530i = "";
        this.f197531j = -1;
        this.f197534m = RefreshStatus.NONE;
        this.f197535n = true;
        this.f197537p = true;
        this.f197538q = true;
        this.f197539r = new int[2];
        this.f197540s = LazyKt.lazy(new RecentlySeeHelper$topY$2(this));
        RotateAnimation r100 = new RotateAnimation(0.0f, 43200.0f, 1, 0.5f, 1, 0.5f);
        r100.setDuration(120000);
        r100.setInterpolator(new LinearInterpolator());
        r100.setRepeatCount(-1);
        r100.setRepeatMode(1);
        this.f197541t = r100;
        this.f197546y = new b(this);
        this.f197547z = new RecentlySeeHelper$scrollListener$1(this);
        this.A = true;
    }

    public final void c(int r100) {
        GridLayoutManager r101 = this.f197528g;
        RecyclerView r102 = null;
        GridLayoutManager r103 = null;
        GridLayoutManager r104 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r101 = null;
    L5:
        int r105 = 0;
        if (Math.abs(r100 - r101.findFirstCompletelyVisibleItemPosition()) <= 300) goto L68;
        RecyclerView r106 = this.f197527f;
        if (r106 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r106 = null;
    L10:
        r106.stopScroll();
        RecyclerView r107 = this.f197527f;
        if (r107 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r107 = null;
    L13:
        GridLayoutManager r108 = this.f197528g;
        if (r108 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r108 = null;
    L16:
        RecyclerView.ViewHolder r109 = r107.findViewHolderForAdapterPosition(r108.findFirstCompletelyVisibleItemPosition());
        if (r109 == null) goto L100;
        Function0<Unit> r110 = this.f197545x;
        if (r110 == null) goto L22;
        r110.invoke();
    L22:
        GridLayoutManager r111 = this.f197528g;
        if (r111 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r111 = null;
    L25:
        int r112 = r111.findFirstCompletelyVisibleItemPosition();
        RecyclerView r113 = this.f197527f;
        if (r113 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r113 = null;
    L28:
        int r114 = RangesKt.coerceAtLeast((d0.c(r113.getContext()) / 2) / r109.itemView.getHeight(), 0);
        if (r100 <= r112) goto L54;
        RecyclerView r115 = this.f197527f;
        if (r115 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r115 = null;
    L33:
        RecyclerView.Adapter r116 = r115.getAdapter();
        if (r116 == null) goto L36;
        Integer r117 = Integer.valueOf(r116.getItemCount());
    L37:
        RecyclerView r118 = this.f197527f;
        if (r118 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r118 = null;
    L40:
        if (r117 == null) goto L53;
        GridLayoutManager r119 = this.f197528g;
        if (r119 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r119 = null;
    L46:
        if (((r119.getSpanCount() * r114) + r100) >= (r117.intValue() - 1)) goto L52;
        GridLayoutManager r120 = this.f197528g;
        if (r120 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
    L51:
        r100 = r100 + (r103.getSpanCount() * r114);
        goto L53
    L50:
        r103 = r120;
        goto L51
    L52:
        r100 = r117.intValue() - 1;
    L53:
        r118.scrollToPosition(r100);
        return;
    L36:
        r117 = null;
        goto L37
    L54:
        RecyclerView r121 = this.f197527f;
        if (r121 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r121 = null;
    L57:
        GridLayoutManager r122 = this.f197528g;
        if (r122 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r122 = null;
    L61:
        if ((r100 - (r122.getSpanCount() * r114)) < 0) goto L67;
        GridLayoutManager r123 = this.f197528g;
        if (r123 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
    L66:
        r105 = r100 - (r104.getSpanCount() * r114);
        goto L67
    L65:
        r104 = r123;
    L67:
        r121.scrollToPosition(r105);
        return;
    L100:
        return;
    L68:
        RecyclerView r124 = this.f197527f;
        if (r124 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r124 = null;
    L71:
        r124.stopScroll();
        RecyclerView r125 = this.f197527f;
        if (r125 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r125 = null;
    L74:
        int r126 = r125.computeVerticalScrollOffset();
        GridLayoutManager r127 = this.f197528g;
        if (r127 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r127 = null;
    L77:
        int r128 = r100 / r127.getSpanCount();
        RecyclerView r129 = this.f197527f;
        if (r129 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r129 = null;
    L80:
        GridLayoutManager r130 = this.f197528g;
        if (r130 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
        r130 = null;
    L83:
        RecyclerView.ViewHolder r131 = r129.findViewHolderForAdapterPosition(r130.findFirstCompletelyVisibleItemPosition());
        if (r131 == null) goto L101;
        int r132 = r131.itemView.getHeight() * (r128 + 1);
        RecyclerView r133 = this.f197527f;
        if (r133 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r133 = null;
    L89:
        int r134 = (r132 - (d0.c(r133.getContext()) / 2)) - r126;
        Function0<Unit> r135 = this.f197545x;
        if (r135 == null) goto L92;
        r135.invoke();
    L92:
        RecyclerView r136 = this.f197527f;
        if (r136 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
    L96:
        r102.smoothScrollBy(0, r134);
        return;
    L95:
        r102 = r136;
        goto L96
    }

    public static int b(List r100, String r101) {
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        jz3.a r103 = (jz3.a) r102.next();
        if (Intrinsics.areEqual(r103.f501173a.c(), r101) == false) goto L4;
        return r103.f501176d;
    L9:
        return -1;
    }

    public final void update(User r100, String r101, boolean r102) {
        d();
        this.f197529h = r100;
        this.f197530i = r101;
        boolean r103 = false;
        if (((Boolean) this.f197523b.getValue()).booleanValue() == false) goto L19;
        if (r102 == true) goto L19;
        if (r100 == null) goto L19;
        if (r100.M() == true) goto L19;
        if (p0.d(r100) == true) goto L19;
        if (r101 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L19;
        r103 = true;
        goto L19
    L13:
        if (r101.length() == 0) goto L16;
        r104 = false;
    L19:
        this.f197532k = r103;
    }
}
