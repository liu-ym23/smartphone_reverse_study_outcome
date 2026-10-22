package qcb;

import android.app.Activity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f532532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f532533b;

    /* JADX INFO: renamed from: qcb.a$a, reason: collision with other inner class name */
    public static final class C7311a {
    }

    static {
    }

    public final Activity getActivity() {
        return this.f532532a;
    }

    public a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f532532a = r100;
        this.f532533b = 300;
    }
}
