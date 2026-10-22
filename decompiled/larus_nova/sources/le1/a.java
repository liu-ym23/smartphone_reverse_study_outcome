package le1;

import com.bytedance.android.livesdk.arch.plugin.Identity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Identity f508906a;

    @Override // le1.c
    public final Identity getId() {
        return this.f508906a;
    }

    public a(Identity r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f508906a = r100;
        r100.name();
    }
}
