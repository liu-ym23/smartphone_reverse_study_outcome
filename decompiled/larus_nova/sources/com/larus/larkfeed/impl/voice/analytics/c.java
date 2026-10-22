package com.larus.larkfeed.impl.voice.analytics;

import com.ss.android.lark.voiceinput.api.data.model.asr.VoiceAsrState;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes30.dex */
public final class c<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f355589a;

    public c(a r100) {
        this.f355589a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        zac.b r102 = (zac.b) r100;
        a r103 = this.f355589a;
        VoiceAsrState r104 = r102.f571115b;
        r103.getClass();
        int r105 = a.C4400a.f355587a[r104.ordinal()];
        boolean r106 = true;
        if (r105 != 1) goto L5;
    L9:
        if (r106 == false) goto L13;
        a.c(this.f355589a, r102.f571114a, false);
        return Unit.INSTANCE;
    L13:
        return Unit.INSTANCE;
    L5:
        if (r105 == 2) goto L9;
        if (r105 == 3) goto L9;
        r106 = false;
        goto L9
    }
}
