package j42;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f497342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f497343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f497344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f497345d;

    public b(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "commenterNickName");
        Intrinsics.checkNotNullParameter(r102, "commenterUserId");
        Intrinsics.checkNotNullParameter(r103, "commentContent");
        this.f497342a = r100;
        this.f497343b = r101;
        this.f497344c = r102;
        this.f497345d = r103;
    }
}
