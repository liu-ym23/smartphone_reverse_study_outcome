package w1a;

import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f557950a;

    public h() {
        this(0);
    }

    public /* synthetic */ h(int r100) {
        this(String.valueOf(UUID.randomUUID()));
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subscriptionId");
        this.f557950a = r100;
    }
}
