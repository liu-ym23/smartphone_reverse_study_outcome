package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes25.dex */
public final class s implements lsc.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f305210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f305211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f305212c;

    public s(Ref.LongRef r100, Ref.LongRef r101, Ref.LongRef r102) {
        this.f305210a = r100;
        this.f305211b = r101;
        this.f305212c = r102;
    }

    @Override // lsc.v
    public final void a(long r100, long r101, long r102) {
        this.f305210a.element = r100;
        this.f305211b.element = r101;
        this.f305212c.element = r102;
    }
}
