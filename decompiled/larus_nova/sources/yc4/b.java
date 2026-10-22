package yc4;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f567134a;

    public final Activity getActivity() {
        return this.f567134a;
    }

    public b(Activity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "creatorId");
        this.f567134a = r100;
    }
}
