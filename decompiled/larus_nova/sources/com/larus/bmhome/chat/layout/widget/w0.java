package com.larus.bmhome.chat.layout.widget;

import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public class w0 extends ClickableSpan implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.OnClickListener f305296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.OnLongClickListener f305297b;

    @Override // android.text.style.ClickableSpan
    public void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        View.OnClickListener r101 = this.f305296a;
        if (r101 == null) goto L6;
        r101.onClick(r100);
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        View.OnLongClickListener r101 = this.f305297b;
        if (r101 == null) goto L7;
        r101.onLongClick(r100);
        return true;
    L7:
        return true;
    }

    public w0(View.OnClickListener r100, View.OnLongClickListener r101) {
        this.f305296a = r100;
        this.f305297b = r101;
    }
}
