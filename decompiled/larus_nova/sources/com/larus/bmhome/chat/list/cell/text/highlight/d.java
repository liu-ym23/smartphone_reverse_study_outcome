package com.larus.bmhome.chat.list.cell.text.highlight;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import va8.p;
import va8.q0;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f306400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q0 f306401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f306402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f306403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f306404e;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f306400a.getViewTreeObserver().removeOnPreDrawListener(this);
        return !SearchLandingHighlightHelper.f306375a.a(this.f306400a, this.f306401b, this.f306402c, this.f306403d, false, this.f306404e);
    }

    public d(TextView r100, q0 r101, p r102, boolean r103, long r104) {
        this.f306400a = r100;
        this.f306401b = r101;
        this.f306402c = r102;
        this.f306403d = r103;
        this.f306404e = r104;
    }
}
