package vu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ju1.c<Object> f557320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DynamicFactor<Object> f557321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final iu1.a<Object> f557322c;

    public c(ju1.c<Object> r100, DynamicFactor<Object> r101, iu1.a<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "factor");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "wrapper");
        this.f557320a = r100;
        this.f557321b = r101;
        this.f557322c = r102;
    }
}
