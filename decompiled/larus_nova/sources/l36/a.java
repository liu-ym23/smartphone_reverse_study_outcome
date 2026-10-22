package l36;

import android.app.Activity;
import com.bytedance.ies.bullet.service.base.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends Activity> f507261a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f507261a, ((a) r100).f507261a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Class<? extends Activity> r100 = this.f507261a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "PageConfig(activityCls=" + this.f507261a + ')';
    }

    @Override // com.bytedance.ies.bullet.service.base.s
    public final Class<? extends Activity> b() {
        return this.f507261a;
    }

    public a(Class<? extends Activity> r100) {
        this.f507261a = r100;
    }
}
