package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.network.NetConnectionTypeProvider;
import com.larus.network.NetworkQualityType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class p implements com.larus.network.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f294427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetworkAwareRetrier f294428b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f294429a = null;

        static {
            int[] r100 = new int[NetworkQualityType.values().length];
            r100[NetworkQualityType.NO_NET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[NetworkQualityType.WEAK_NETWORK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[NetworkQualityType.NORMAL_NETWORK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f294429a = r100;
        }
    }

    public p(NetworkAwareRetrier r100) {
        this.f294428b = r100;
        if (NetConnectionTypeProvider.a(NetConnectionTypeProvider.f360084a) != NetworkQualityType.NO_NET) goto L5;
        boolean r101 = true;
    L6:
        this.f294427a = r101;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.network.k
    public final void a(NetworkQualityType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = a.f294429a[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f294427a = true;
        return;
    L5:
        if (r101 == 2) goto L12;
        if (r101 == 3) goto L12;
        throw new NoWhenBranchMatchedException();
    L12:
        if (this.f294427a == false) goto L16;
        this.f294427a = false;
        n1.d(this.f294428b.f294378b, "wake up on network recovered");
        this.f294428b.f294388l.mo10962trySendJP2dKIU(Unit.INSTANCE);
        return;
    }
}
