package com.bytedance.dux.panel.header;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.dux.divider.DuxDivider;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f205383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f205384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f205385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f205386i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f205387j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f205388k;

    @Override // com.bytedance.dux.panel.header.d
    public final View c() {
        return this.f205388k;
    }

    public b(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, false, false);
        View r111 = View.inflate(d.a(this, r110), R.layout.dux_basic_panel_normal_header, null);
        this.f205388k = r111;
        int r100 = com.bytedance.dux.utils.a.f205857a;
        com.bytedance.dux.utils.a.a(b());
        r111.setBackgroundColor(0);
        AppCompatImageView r101 = (AppCompatImageView) r111.findViewById(R.id.iv_close);
        this.f205383f = r101;
        this.f205384g = (TextView) r111.findViewById(R.id.tv_title);
        ImageView r102 = (ImageView) r111.findViewById(R.id.iv_back);
        this.f205385h = r102;
        DuxDivider r103 = (DuxDivider) r111.findViewById(R.id.divider);
        this.f205386i = r111.findViewById(R.id.grabber);
        View r104 = r111.findViewById(R.id.main_view);
        this.f205387j = r104;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L13;
        r105.height = -2;
        r104.setLayoutParams(r105);
        float r106 = 12;
        Resources r107 = Resources.getSystem();
        int r108 = MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics())));
        Resources r109 = Resources.getSystem();
        r104.setPadding(0, r108, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r106, WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()))));
        if (TextUtils.isEmpty(null) == true) goto L8;
        Intrinsics.checkNotNull(null);
        e(this, null);
    L8:
        if (ViewCompat.isAttachedToWindow(r111) == false) goto L10;
        Resources r112 = Resources.getSystem();
        int r113 = MathKt.roundToInt(TypedValue.applyDimension(1, 44, WindowDisplayMetricsOverride.apply(r112, r112.getDisplayMetrics())));
        n.c(r111, r113, r113, new View[]{r102, r101});
        return;
    L10:
        r111.addOnAttachStateChangeListener(new a(r111, this));
        return;
    L13:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void d(View.OnClickListener r100) {
        AppCompatImageView r101 = this.f205383f;
        Resources r102 = Resources.getSystem();
        n.a(r101, MathKt.roundToInt(TypedValue.applyDimension(1, 44, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()))));
        this.f205383f.setOnClickListener(r100);
    }

    public static void e(b r100, CharSequence r101) {
        Boolean r102 = Boolean.FALSE;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "charSequence");
        r100.f205384g.setText(r101);
        r100.f205384g.setCompoundDrawables(null, null, null, null);
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L6;
        r100.f205384g.setTypeface(Typeface.defaultFromStyle(1));
        return;
    }
}
