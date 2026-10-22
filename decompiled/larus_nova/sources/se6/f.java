package se6;

import com.bytedance.lark.pb.basic.v1.Command;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f541567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f541568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Command f541569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f541570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f541571e;

    public f(int r100, byte[] r101, Command r102, String r103, long r104) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "originCommand");
        Intrinsics.checkNotNullParameter(r103, "contextId");
        this.f541567a = r100;
        this.f541568b = r101;
        this.f541569c = r102;
        this.f541570d = r103;
        this.f541571e = r104;
    }
}
