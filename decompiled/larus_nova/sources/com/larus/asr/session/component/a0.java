package com.larus.asr.session.component;

import com.larus.im.bean.message.Message;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f287680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Message, Unit> f287681b;

    public final f0 getContext() {
        return this.f287680a;
    }

    public a0(f0 r100, com.larus.asr.session.j r101) {
        Intrinsics.checkNotNullParameter(r101, "beforeSendAudioMessage");
        this.f287680a = r100;
        this.f287681b = r101;
    }
}
