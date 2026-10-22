package com.bytedance.ee.bear.middleground.comment.audio;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f230330a;

    @Override // io.reactivex.functions.Action
    public final void run() throws Exception {
        b r100 = this.f230330a;
        r100.f230331a = false;
        r100.f230332b = true;
        r100.a();
    }

    public a(b r100) {
        this.f230330a = r100;
    }
}
