package com.larus.bmhome.chat.component.bottom.core.inputtext.project;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelListView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.x0;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputPanelListView f299134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f299135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f299136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f299137d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f299138e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f299139f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f299140g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f299141h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FrameLayout f299142i;

    public static final class a {
    }

    static {
    }

    public final void a() {
        int r100 = this.f299137d;
        if (r100 > 0) goto L5;
        return;
    L5:
        int r101 = RangesKt.coerceAtMost(r100, this.f299136c);
        ViewGroup.LayoutParams r102 = this.f299141h.getLayoutParams();
        if ((r102 instanceof FrameLayout.LayoutParams) == false) goto L8;
        FrameLayout.LayoutParams r103 = (FrameLayout.LayoutParams) r102;
    L9:
        if (r103 != null) goto L12;
        this.f299141h.setLayoutParams(new FrameLayout.LayoutParams(-1, r101));
        return;
    L12:
        if (r103.height == r101) goto L16;
        r103.height = r101;
        this.f299141h.setLayoutParams(r103);
        return;
    L16:
        return;
    L8:
        r103 = null;
        goto L9
    }

    public h(ViewGroup r110, final x0 r111) {
        Intrinsics.checkNotNullParameter(r110, "panelContainer");
        Intrinsics.checkNotNullParameter(r111, "onCloseClick");
        Context r100 = r110.getContext();
        this.f299134a = new InputPanelListView(r100);
        this.f299136c = c7.b(360);
        LinearLayout r101 = new LinearLayout(r100);
        r101.setOrientation(1);
        this.f299138e = r101;
        final ScrollView r102 = new ScrollView(r100);
        r102.setOnScrollChangeListener(new f(r102, this));
        r102.addView(r101, new ViewGroup.LayoutParams(-1, -2));
        LinearLayout r103 = new LinearLayout(r100);
        r103.setOrientation(1);
        r103.setPadding(0, c7.b(4), 0, 0);
        this.f299139f = r103;
        LinearLayout r104 = new LinearLayout(r100);
        r104.setOrientation(1);
        this.f299140g = r104;
        LinearLayout r112 = new LinearLayout(r100);
        r112.setOrientation(1);
        FrameLayout r113 = new FrameLayout(r112.getContext());
        View r114 = new View(r113.getContext());
        r114.setBackgroundColor(ContextCompat.getColor(r114.getContext(), v19.c.b(R.attr.larus_neutral_transparent_1, r114.getContext(), R.color.larus_neutral_transparent_1)));
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-1, 1);
        r105.gravity = 16;
        r105.setMarginStart(c7.b(18));
        r105.setMarginEnd(c7.b(18));
        Unit r115 = Unit.INSTANCE;
        r113.addView(r114, r105);
        r112.addView(r113, new LinearLayout.LayoutParams(-1, c7.b(6)));
        r112.addView(r104, new LinearLayout.LayoutParams(-1, -2));
        r112.setPadding(0, 0, 0, c7.b(6));
        LinearLayout r106 = new LinearLayout(r100);
        r106.setOrientation(1);
        r106.addView(r103, new LinearLayout.LayoutParams(-1, -2));
        r106.addView(r102, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        r106.addView(r112, new LinearLayout.LayoutParams(-1, -2));
        this.f299141h = r106;
        FrameLayout r107 = new FrameLayout(r100);
        r107.setVisibility(8);
        r107.addView(r106, new FrameLayout.LayoutParams(-1, -2));
        ImageView r108 = new ImageView(r107.getContext());
        r108.setImageResource(R.drawable.larus_ic_icon_reply_close);
        r108.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        FrameLayout.LayoutParams r109 = new FrameLayout.LayoutParams(c7.b(24), c7.b(24));
        r109.gravity = 8388661;
        r109.topMargin = c7.b(12);
        r109.setMarginEnd(c7.b(12));
        r108.setLayoutParams(r109);
        r108.setOnClickListener(new g(r111));
        r107.addView(r108);
        this.f299142i = r107;
        r110.addView(r107, new FrameLayout.LayoutParams(-1, -2));
    }
}
