package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<f> {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a$a, reason: collision with other inner class name */
    public static final class C5191a {
        public static /* synthetic */ Object a(a r100, h r101, Continuation r102) {
            return r100.X(r101, new IMmRecordingLanguageOperator$setSpokenLanguageAndAwait$2(null), r102);
        }
    }

    void F(h r100);

    void K(String r100);

    Object X(h r100, Function1<? super Continuation<? super Boolean>, ? extends Object> r101, Continuation<? super Boolean> r102);

    void Y(boolean r100);

    Object a0(h r100, long r101, Continuation<? super MmAutoLanguageSettingResult> r102);

    void e0(h r100, boolean r101);

    long i0();

    Object k0(long r100, Continuation<? super MmAutoLanguageSettingResult> r101);

    void l0();

    void u(String r100, String r101, String r102);
}
