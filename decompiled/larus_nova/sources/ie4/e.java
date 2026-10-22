package ie4;

import com.bytedance.caijing.sdk.infra.base.api.plugin.container.xelement.keyboard.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f489471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f489472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f489473c;

    public final Type getType() {
        return this.f489472b;
    }

    public e(boolean r100, Type r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "content");
        this.f489471a = r100;
        this.f489472b = r101;
        this.f489473c = r102;
    }
}
