package se6;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f541587a;

    public /* synthetic */ n(byte[] r100) {
        AtomicLong r101 = ue6.a.f549807a;
        this(r100, ue6.a.C7870a.a());
    }

    public n(byte[] r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        this.f541587a = r100;
    }
}
