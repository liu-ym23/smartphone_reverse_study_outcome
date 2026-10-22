package com.obric.oui.panel.header;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;
import com.obric.oui.divider.ODivider;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
public final class b extends d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AppCompatImageView f402119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f402120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f402121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f402122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f402123j;

    @Override // com.obric.oui.panel.header.d
    public final View b() {
        return this.f402123j;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        View r101 = View.inflate(d.a(this, r100), R.layout.o_basic_panel_normal_header, null);
        this.f402123j = r101;
        int r102 = pla.a.f529794a;
        ContextThemeWrapper r103 = this.f402127d;
        if (r103 != null) goto L5;
        r103 = d.a(this, r100);
    L5:
        int r104 = pla.a.a(r103);
        r101.setBackgroundColor(0);
        AppCompatImageView r105 = (AppCompatImageView) r101.findViewById(R.id.iv_close);
        this.f402119f = r105;
        TextView r106 = (TextView) r101.findViewById(R.id.tv_title);
        ImageView r107 = (ImageView) r101.findViewById(R.id.iv_back);
        this.f402120g = r107;
        ODivider r108 = (ODivider) r101.findViewById(R.id.divider);
        this.f402121h = r101.findViewById(R.id.grabber);
        View r109 = r101.findViewById(R.id.main_view);
        this.f402122i = r109;
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if (r110 == null) goto L18;
        r110.height = r104;
        r109.setLayoutParams(r110);
        if (TextUtils.isEmpty(null) == true) goto L13;
        Intrinsics.checkNotNull(null);
        Boolean r111 = Boolean.FALSE;
        Intrinsics.checkNotNullParameter(null, "charSequence");
        r106.setText(null);
        r106.setCompoundDrawables(null, null, null, null);
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == false) goto L13;
        r106.setTypeface(Typeface.defaultFromStyle(1));
    L13:
        if (ViewCompat.isAttachedToWindow(r101) == false) goto L15;
        int r112 = pla.d.n(r101, 44);
        j.c(r101, r112, r112, new View[]{r107, r105});
        return;
    L15:
        r101.addOnAttachStateChangeListener(new a(r101, this));
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
