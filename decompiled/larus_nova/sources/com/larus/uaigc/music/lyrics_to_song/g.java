package com.larus.uaigc.music.lyrics_to_song;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Message f373692e;

    @Override // xc8.b
    public final int d() {
        if (this.f373692e.getContentType() != 70) goto L7;
        return 0;
    L7:
        if (this.f373692e.getContentType() != 72) goto L10;
        return 3;
    L10:
        return -1;
    }

    public g(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "songMessage");
        super(r100);
        this.f373692e = r100;
    }
}
