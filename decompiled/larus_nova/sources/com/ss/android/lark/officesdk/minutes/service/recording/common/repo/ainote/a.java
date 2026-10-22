package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote;

import android.view.ViewGroup;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<c> {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.a$a, reason: collision with other inner class name */
    public static final class C5184a {
        public static /* synthetic */ void a(a r100, Boolean r101, Boolean r102, Boolean r103, String r104, int r105) {
            if ((r105 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r105 & 4) == 0) goto L11;
            r103 = null;
        L11:
            r100.d0(r101, r102, r103, r104);
        }
    }

    void G0(long r100, long r101);

    boolean H0();

    void I0();

    Long J();

    void M(String r100);

    void N0();

    void O0(ViewGroup r100, f r101);

    boolean R(String r100);

    e T(d r100);

    void V(boolean r100);

    void d();

    void d0(Boolean r100, Boolean r101, Boolean r102, String r103);

    List<e> m0();

    boolean o(k r100);

    boolean o0();

    boolean q(String r100);

    void q0();

    int t();

    boolean t0();

    void v(Function1<? super List<e>, Unit> r100);

    void v0(boolean r100);

    void w0(boolean r100, String r101);

    boolean y(String r100);

    boolean y0();
}
