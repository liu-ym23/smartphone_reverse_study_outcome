package m50;

import java.nio.ShortBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f512068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f512069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f512070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ShortBuffer f512071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public short[] f512072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f512073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f512074g;

    public c(short[] r100) {
        Intrinsics.checkNotNullParameter(r100, "array");
        this.f512068a = 34963;
        this.f512069b = 35044;
        this.f512070c = 2;
        this.f512073f = -1;
        this.f512074g = 0;
        this.f512074g = r100.length;
        this.f512072e = r100;
    }
}
