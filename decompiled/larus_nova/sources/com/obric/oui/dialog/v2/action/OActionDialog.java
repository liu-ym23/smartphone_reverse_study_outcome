package com.obric.oui.dialog.v2.action;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.miniapp.lynx.m;
import com.obric.oui.dialog.base.q;
import com.obric.oui.text.OTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pla.d;
import xla.c;

/* JADX INFO: loaded from: classes34.dex */
public final class OActionDialog extends q {
    public final Lazy I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Lazy f400733J;
    public final Lazy K;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f400734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CharSequence f400735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function1<ViewGroup, View> f400736c;

        public b(CharSequence r100, CharSequence r101, m r102) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "subtitle");
            this.f400734a = r100;
            this.f400735b = r101;
            this.f400736c = r102;
        }
    }

    static {
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final int f() {
        return R.layout.o_action_dialog;
    }

    public OActionDialog(Context r100, b r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "modifier");
        super(r100);
        Lazy r101 = LazyKt.lazy(new OActionDialog$titleTextView$2(this));
        this.I = r101;
        Lazy r102 = LazyKt.lazy(new OActionDialog$subtitleTextView$2(this));
        this.f400733J = r102;
        Lazy r103 = LazyKt.lazy(new OActionDialog$bodyContainerView$2(this));
        this.K = r103;
        ((OTextView) r101.getValue()).setIncludeFontPadding(true);
        ((OTextView) r102.getValue()).setIncludeFontPadding(true);
        CharSequence r104 = r110.f400734a;
        Intrinsics.checkNotNullParameter(r104, "title");
        if (r104.length() != 0) goto L5;
        boolean r105 = true;
    L7:
        if (r105 == false) goto L13;
        ((OTextView) r101.getValue()).setVisibility(8);
        ViewGroup.LayoutParams r106 = ((OTextView) r102.getValue()).getLayoutParams();
        if (r106 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r106).topMargin = 0;
    L16:
        CharSequence r107 = r110.f400735b;
        Intrinsics.checkNotNullParameter(r107, "message");
        if (r107.length() != 0) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L22;
        ((OTextView) r102.getValue()).setVisibility(8);
    L23:
        Function1<ViewGroup, View> r109 = r110.f400736c;
        if (r109 == null) goto L26;
        View r111 = r109.invoke((ViewGroup) r103.getValue());
        ((ViewGroup) r103.getValue()).removeAllViews();
        ((ViewGroup) r103.getValue()).addView(r111);
    L26:
        this.f400659m = true;
        return;
    L22:
        OTextView r112 = (OTextView) r102.getValue();
        r112.setVisibility(0);
        r112.setText(r107);
        c.a(r112, r107);
        goto L23
    L19:
        r108 = false;
        goto L20
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L13:
        OTextView r113 = (OTextView) r101.getValue();
        r113.setVisibility(0);
        r113.setText(r104);
        OTextView r114 = (OTextView) r102.getValue();
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if (r115 == null) goto L29;
        int r116 = d.n(r114, 8);
        ((ViewGroup.MarginLayoutParams) r115).topMargin = r116;
        goto L16
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L5:
        r105 = false;
        goto L7
    }
}
