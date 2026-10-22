package my;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f516354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f516355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f516356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f516357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f516358e;

    public final String toString() {
        return "BackupSeiInfo[isFromBackup = " + this.f516354a + ", backupSource = " + this.f516355b + ", streamId = " + this.f516356c + ", backupPts = " + this.f516357d + ", timeDiff = " + this.f516358e + ']';
    }

    public e(boolean r100, String r101, String r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "backupSource");
        Intrinsics.checkNotNullParameter(r102, "streamId");
        this.f516354a = r100;
        this.f516355b = r101;
        this.f516356c = r102;
        this.f516357d = r103;
        this.f516358e = r104;
    }
}
