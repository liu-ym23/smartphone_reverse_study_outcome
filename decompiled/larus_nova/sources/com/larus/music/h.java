package com.larus.music;

import com.larus.music.qq.data.QQMusicSong;
import com.larus.music.qq.data.QQPlayStatus;
import com.larus.platform.api.i1;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h implements com.larus.music.qq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i1 f359474a;

    public h(ml9.a.C6828a r100) {
        this.f359474a = r100;
    }

    @Override // com.larus.music.qq.a
    public final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "songId");
        this.f359474a.a(r100, r101);
    }

    @Override // com.larus.music.qq.a
    public final void b(QQMusicSong r100, QQPlayStatus r101) {
        Intrinsics.checkNotNullParameter(r101, "status");
        i1 r102 = this.f359474a;
        if (r100 == null) goto L5;
        com.larus.platform.api.QQMusicSong r103 = j.c(r100);
    L6:
        int r104 = j.a.f359477b[r101.ordinal()];
        if (r104 != 1) goto L9;
        com.larus.platform.api.QQPlayStatus r105 = com.larus.platform.api.QQPlayStatus.PLAYING;
    L17:
        r102.b(r103, r105);
        return;
    L9:
        if (r104 != 2) goto L11;
        r105 = com.larus.platform.api.QQPlayStatus.PAUSED;
        goto L17
    L11:
        if (r104 != 3) goto L14;
        r105 = com.larus.platform.api.QQPlayStatus.STOPPED;
        goto L17
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        r103 = null;
        goto L6
    }
}
