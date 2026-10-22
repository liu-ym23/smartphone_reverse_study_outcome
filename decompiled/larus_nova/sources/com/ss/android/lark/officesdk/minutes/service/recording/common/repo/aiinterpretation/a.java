package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<d> {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a$a, reason: collision with other inner class name */
    public static final class C5183a {
        public static /* synthetic */ Object a(a r100, String r101, boolean r102, g r110, Continuation r111) {
            return r100.z(r101, "", r102, r110, true, r111);
        }
    }

    void F0(HeadsetPromptSource r100);

    Object I(g r100, Continuation<? super Unit> r101);

    void M0(HeadsetPromptSource r100);

    void S0();

    void U();

    void W(MmAudioSaveType r100);

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c
    i1<d> b();

    void g(String r100);

    void g0();

    void i(byte[] r100);

    @Override // fvb.a
    void onDestroy();

    Object r0(String r100, String r101, Continuation<? super Unit> r102);

    Object w(String r100, String r101, g r102, g r103, Continuation<? super Unit> r104);

    Object z(String r100, String r101, boolean r102, g r103, boolean r104, Continuation<? super p> r105);
}
