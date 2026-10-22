package com.ss.android.lark.compose.foundation.toast;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larus.nova.R;
import com.ss.android.lark.flow.ud.databinding.FlowUdToastLayoutBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f417658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowUdToastLayoutBinding f417659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewPropertyAnimator f417660c;

    public static final class a {
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animatable f417661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f417662b;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f417661a.start();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f417661a.stop();
            this.f417662b.f417659b.f424293a.removeOnAttachStateChangeListener(this);
        }

        public b(Animatable r100, i r101) {
            this.f417661a = r100;
            this.f417662b = r101;
        }
    }

    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f417663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f417664b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (this.f417663a != this.f417664b.f417659b.f424293a.getWidth()) goto L5;
            return;
        L5:
            this.f417663a = this.f417664b.f417659b.f424293a.getWidth();
            ViewGroup.LayoutParams r100 = this.f417664b.f417659b.f424296d.getLayoutParams();
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams r101 = (LinearLayout.LayoutParams) r100;
            if (this.f417664b.f417659b.f424297e.getLineCount() != 1) goto L8;
            r101.gravity = 16;
        L9:
            this.f417664b.f417659b.f424296d.setLayoutParams(r101);
            return;
        L8:
            r101.gravity = 48;
            goto L9
        }

        public c(i r100) {
            this.f417664b = r100;
        }
    }

    static {
    }

    public final void b() {
        this.f417659b.f424294b.getText().length();
        ImageView r100 = this.f417659b.f424296d;
        r100.getDrawable();
        Object r101 = r100.getDrawable();
        if ((r101 instanceof Animatable) == false) goto L5;
        Animatable r102 = (Animatable) r101;
    L6:
        if (r102 == null) goto L8;
        this.f417659b.f424293a.addOnAttachStateChangeListener(new b(r102, this));
    L8:
        TextView r103 = this.f417659b.f424297e;
        r103.setGravity(GravityCompat.START);
        int r104 = h18.d.d(this.f417658a, R.dimen.flow_ud_toast_max_wight) - (h18.d.d(this.f417658a, R.dimen.flow_ud_toast_padding_horizontal) * 2);
        if (this.f417659b.f424296d.getVisibility() != 0) goto L12;
        r104 = (r104 - h18.d.d(this.f417658a, R.dimen.flow_ud_toast_icon_size)) - h18.d.d(this.f417658a, R.dimen.flow_ud_toast_padding_icon_text);
    L12:
        if (this.f417659b.f424294b.getVisibility() != 0) goto L14;
        int r105 = (r104 - (h18.d.d(this.f417658a, R.dimen.flow_ud_toast_padding_action_divider) * 2)) - h18.d.d(this.f417658a, R.dimen.flow_ud_toast_divider_size);
        int r106 = h18.d.d(this.f417658a, R.dimen.flow_ud_toast_action_max_wight);
        r104 = r105 - Math.min((int) this.f417659b.f424294b.getPaint().measureText(this.f417659b.f424294b.getText().toString()), r106);
    L14:
        r103.setMaxWidth(r104);
        r103.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f417658a = r100;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.flow_ud_toast_layout, null, false);
        int r102 = R.id.flow_ud_toast_action;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r101, R.id.flow_ud_toast_action);
        if (r103 == null) goto L15;
        r102 = R.id.flow_ud_toast_action_divider;
        View r104 = ViewBindings.findChildViewById(r101, R.id.flow_ud_toast_action_divider);
        if (r104 == null) goto L15;
        r102 = R.id.flow_ud_toast_icon;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(r101, R.id.flow_ud_toast_icon);
        if (r105 == null) goto L15;
        r102 = R.id.flow_ud_toast_root;
        if (((LinearLayout) ViewBindings.findChildViewById(r101, R.id.flow_ud_toast_root)) == null) goto L15;
        UDShadowLayout r106 = (UDShadowLayout) r101;
        r102 = R.id.flow_ud_toast_text;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r101, R.id.flow_ud_toast_text);
        if (r107 == null) goto L15;
        this.f417659b = new FlowUdToastLayoutBinding(r106, r103, r104, r105, r107);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    public final void a(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f417659b.f424296d.setImageDrawable(r100);
        this.f417659b.f424296d.setVisibility(0);
    }
}
