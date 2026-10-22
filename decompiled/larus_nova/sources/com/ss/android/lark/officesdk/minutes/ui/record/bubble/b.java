package com.ss.android.lark.officesdk.minutes.ui.record.bubble;

import android.view.View;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes37.dex */
public final class b implements qub.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f435820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f435821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<qub.a> f435822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f435823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<View.OnAttachStateChangeListener> f435824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ View f435825f;

    @Override // qub.a
    public final void hide() {
        c.a(this.f435820a, this.f435821b, this.f435822c, this.f435823d, this.f435824e, this.f435825f, "hide");
    }

    @Override // qub.a
    public final boolean isShowing() {
        qub.a r100 = this.f435822c.element;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public b(Ref.BooleanRef r100, Ref.BooleanRef r101, Ref.ObjectRef<qub.a> r102, Ref.BooleanRef r103, Ref.ObjectRef<View.OnAttachStateChangeListener> r104, View r105) {
        this.f435820a = r100;
        this.f435821b = r101;
        this.f435822c = r102;
        this.f435823d = r103;
        this.f435824e = r104;
        this.f435825f = r105;
    }
}
