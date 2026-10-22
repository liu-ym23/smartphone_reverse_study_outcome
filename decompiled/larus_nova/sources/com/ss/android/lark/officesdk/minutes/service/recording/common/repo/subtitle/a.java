package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.event.SubtitleSource;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.c<d> {

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.a$a, reason: collision with other inner class name */
    public static final class C5189a {
        public static /* synthetic */ void a(a r100, String r101, String r110, SubtitleSource r111) {
            r100.n0(r101, r110, null, true, 30, r111);
        }
    }

    void D(boolean r100);

    void L0();

    void Q(String r100, String r101, Long r102, boolean r103, long r104, SubtitleSource r105, boolean r106);

    void b0(String r100, String r101, long r102, long r103);

    void c(String r100, long r101);

    void n0(String r100, String r101, Long r102, boolean r103, long r104, SubtitleSource r105);

    void s();
}
