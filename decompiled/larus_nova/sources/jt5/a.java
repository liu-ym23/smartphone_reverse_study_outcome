package jt5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f500300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f500301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer[] f500302c;

    /* JADX INFO: renamed from: jt5.a$a, reason: collision with other inner class name */
    public static final class C6485a extends FrameLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f500303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f500304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f500305c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f500306d;

        public C6485a(int r100, int r101, int r102, int r103, int r104, boolean r105) {
            super(r100, r101);
            this.f500303a = r102;
            this.f500304b = r103;
            this.f500305c = r104;
            this.f500306d = r105;
        }
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f500302c = new Integer[0];
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        Integer[] r102 = this.f500302c;
        if (r102.length != r100) goto L7;
        return r102[r101].intValue();
    L7:
        return super.getChildDrawingOrder(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        Pair[] r106 = new Pair[r105];
        int r107 = 0;
        int r108 = 0;
    L4:
        if (r108 >= r105) goto L7;
        Integer r109 = Integer.valueOf(r108);
        ViewGroup.LayoutParams r110 = getChildAt(r108).getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ee.larkwebview.platform.overlay.OverlayNativeViewLayout.LayoutParams");
        r106[r108] = TuplesKt.to(r109, Integer.valueOf(((C6485a) r110).f500305c));
        r108 = r108 + 1;
        goto L4
    L7:
        if (r105 <= 1) goto L9;
        ArraysKt.sortWith(r106, new b());
    L9:
        Integer[] r111 = new Integer[r105];
        int r112 = 0;
    L10:
        if (r112 >= r105) goto L12;
        r111[r112] = r106[r112].getFirst();
        r112 = r112 + 1;
        goto L10
    L12:
        this.f500302c = r111;
        int r113 = getChildCount();
    L13:
        if (r107 >= r113) goto L18;
        View r114 = getChildAt(r107);
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.bytedance.ee.larkwebview.platform.overlay.OverlayNativeViewLayout.LayoutParams");
        C6485a r116 = (C6485a) r115;
        int r117 = r116.f500303a;
        int r118 = r116.f500304b;
        if (r116.f500306d == true) goto L17;
        r117 = r117 - this.f500300a;
        r118 = r118 - this.f500301b;
    L17:
        r114.layout(r117, r118, r114.getMeasuredWidth() + r117, r114.getMeasuredHeight() + r118);
        r107 = r107 + 1;
        goto L13
    }
}
