package k82;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f502090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f502091b;

    public void a() {
    }

    public c(View r100, h82.b r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "bridges");
        this.f502090a = r100;
        this.f502091b = r101;
    }
}
