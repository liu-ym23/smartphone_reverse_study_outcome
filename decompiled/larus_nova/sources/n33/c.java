package n33;

import com.bytedance.android.shopping.abscontainer.arch.core.data.ResponseType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f516914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResponseType f516915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Throwable f516916c;

    public final ResponseType getType() {
        return this.f516915b;
    }

    public c(a r100, ResponseType r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f516914a = r100;
        this.f516915b = r101;
        this.f516916c = r102;
    }
}
