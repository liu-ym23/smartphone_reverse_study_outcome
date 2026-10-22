package com.larus.larkfeed.impl.voice.view;

import com.ss.android.lark.voiceinput.api.data.model.record.VoiceRecordState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes30.dex */
public final class e<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowVoiceView f355701a;

    public e(FlowVoiceView r100) {
        this.f355701a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        FlowVoiceView r102 = this.f355701a;
        VoiceRecordState r103 = ((abc.c) r100).f2527b;
        int r104 = FlowVoiceView.f355694k0;
        r102.getClass();
        switch(FlowVoiceView.b.f355695a[r103.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L11;
        this.f355701a.setVisibility(8);
    L11:
        return Unit.INSTANCE;
    L7:
        r105 = true;
        goto L8
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
