package dv0;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f470107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f470108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f470109c;

    public b(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "miniAppId");
        Intrinsics.checkNotNullParameter(r102, EventConstant.Key.RETAIN_PROMPT);
        this.f470107a = r100;
        this.f470108b = r101;
        this.f470109c = r102;
    }
}
