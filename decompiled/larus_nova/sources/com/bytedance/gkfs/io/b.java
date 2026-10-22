package com.bytedance.gkfs.io;

import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import java.io.InputStream;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f245186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f245187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f245188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f245189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GkFSChunkStorageInfo f245190e;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "ChunkBuffer@" + hashCode() + '#' + this.f245189d.f245200a + "(totalSize=" + this.f245187b + ", totalReadCount=" + this.f245188c + ", available=" + this.f245186a.available() + ')';
    }

    public b(f r100, GkFSChunkStorageInfo r101) {
        this.f245189d = r100;
        this.f245190e = r101;
        InputStream r102 = r101.f245288c.invoke();
        this.f245186a = r102;
        this.f245187b = r102.available();
    }
}
