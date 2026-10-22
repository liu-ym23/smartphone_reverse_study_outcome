package com.bytedance.ee.bear.tts.media;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f239726a;

    public g(b r100) {
        this.f239726a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        long r101 = ((Number) r100).longValue();
        b r102 = this.f239726a;
        if (r102.f239709l == false) goto L9;
        r102.f239709l = false;
        TtsMediaService.f r103 = r102.f239708k;
        if (r103 == null) goto L11;
        TtsMediaService r104 = r103.f239681b;
        a r105 = r104.f239660g;
        if (r105 == null) goto L12;
        r105.f239696h = r101;
        r104.e();
        return;
    L12:
        return;
    L11:
        return;
    L9:
        r102.f239709l = true;
    }
}
