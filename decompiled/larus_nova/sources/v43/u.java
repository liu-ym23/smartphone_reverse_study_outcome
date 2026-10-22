package v43;

import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553084b;

    public u(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r101, "trigger");
        this.f553083a = r100;
        this.f553084b = r101;
    }
}
