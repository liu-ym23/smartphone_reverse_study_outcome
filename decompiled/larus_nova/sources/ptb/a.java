package ptb;

import com.ss.android.lark.officesdk.experiment.LaunchExperiment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LaunchExperiment f530687a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f530687a == ((a) r100).f530687a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f530687a.hashCode();
    }

    public final String toString() {
        return "OfficeSDKLaunchExperiment(launchExperiment=" + this.f530687a + ')';
    }

    public a() {
        this(LaunchExperiment.LAUNCH_ALL_AFTER);
    }

    public a(LaunchExperiment r100) {
        Intrinsics.checkNotNullParameter(r100, "launchExperiment");
        this.f530687a = r100;
    }
}
