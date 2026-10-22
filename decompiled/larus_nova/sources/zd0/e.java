package zd0;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements yd0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f571287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f571288b;

    public e(DataCenter r100) {
        this.f571288b = r100;
    }

    @Override // yd0.a
    public final boolean a(wd0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "renderContext");
        return !this.f571287a;
    }
}
