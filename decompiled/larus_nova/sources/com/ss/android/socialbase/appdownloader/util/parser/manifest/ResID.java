package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import com.ss.ttvideoengine.TTVideoEngineInterface;

/* JADX INFO: loaded from: classes38.dex */
public class ResID {
    public final int entry;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final int f449572id;
    public final int pkgId;
    public final int type;

    public String toString() {
        return String.format("0x%08x", new Object[]{Integer.valueOf(this.f449572id)});
    }

    public int hashCode() {
        return TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.f449572id;
    }

    public ResID(int r100) {
        this((r100 >> 24) & 255, (r100 >> 16) & 255, 65535 & r100, r100);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (getClass() == r100.getClass()) goto L9;
        return false;
    L9:
        if (this.f449572id != ((ResID) r100).f449572id) goto L12;
        return true;
    L12:
        return false;
    }

    public ResID(int r100, int r101, int r102) {
        this(r100, r101, r102, ((r100 << 24) + (r101 << 16)) + r102);
    }

    public ResID(int r100, int r101, int r102, int r103) {
        if (r100 != 0) goto L5;
        r100 = 2;
    L5:
        this.pkgId = r100;
        this.type = r101;
        this.entry = r102;
        this.f449572id = r103;
    }
}
