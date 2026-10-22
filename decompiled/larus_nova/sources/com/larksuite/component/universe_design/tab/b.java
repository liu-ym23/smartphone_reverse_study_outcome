package com.larksuite.component.universe_design.tab;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f285292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public UDTabLayout f285293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CharSequence f285294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Drawable f285295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f285296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f285297f;

    public static final class a {
    }

    static {
    }

    public final TextView a() {
        return (TextView) this.f285296e.findViewById(R.id.ud_tab_title);
    }

    public final void c() {
        ImageView r100 = (ImageView) this.f285296e.findViewById(R.id.ud_tab_icon);
        if (r100 != null) goto L5;
        return;
    L5:
        Drawable r101 = this.f285295d;
        if (r101 != null) goto L8;
        r100.setVisibility(8);
    L9:
        UDTabLayout r102 = this.f285293b;
        if (r102 == null) goto L13;
        r102.invaliIndicator$universe_ui_tab_release();
        return;
    L13:
        return;
    L8:
        r100.setImageDrawable(r101);
        r100.setVisibility(0);
        goto L9
    }

    public final void d() {
        TextView r100 = a();
        if (r100 != null) goto L5;
        return;
    L5:
        TextView r101 = (TextView) this.f285296e.findViewById(R.id.ud_tab_title_bold);
        CharSequence r102 = this.f285294c;
        if (r102 != null) goto L10;
        r100.setVisibility(8);
        if (r101 == null) goto L15;
        r101.setVisibility(8);
    L15:
        UDTabLayout r103 = this.f285293b;
        if (r103 == null) goto L19;
        r103.invaliIndicator$universe_ui_tab_release();
        return;
    L19:
        return;
    L10:
        r100.setText(r102);
        r100.setVisibility(0);
        if (r101 == null) goto L13;
        r101.setText(this.f285294c);
    L13:
        if (r101 == null) goto L15;
        r101.setVisibility(4);
        goto L15
    }

    public final Context getContext() {
        return this.f285292a;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f285292a = r100;
        f r101 = new f(r100);
        r101.setTab$universe_ui_tab_release(this);
        this.f285296e = r101;
        this.f285297f = -1;
    }

    public final void b(CharSequence r100) {
        this.f285294c = r100;
        d();
    }
}
