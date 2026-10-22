package l33;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import w33.g;

/* JADX INFO: loaded from: classes12.dex */
public final class b<STATE extends g, PROPS extends u33.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final STATE f507247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w33.b f507248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PROPS f507249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i33.a f507250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p33.a f507251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f507252f;

    /* JADX WARN: Multi-variable type inference failed */
    public b(g r100, w33.b r101, u33.a r102, i33.b r103, p33.a r104, c r105) {
        Intrinsics.checkNotNullParameter(r100, "bizState");
        Intrinsics.checkNotNullParameter(r101, "archState");
        Intrinsics.checkNotNullParameter(r102, SlcElement.KEY_PROPS);
        Intrinsics.checkNotNullParameter(r103, "abilities");
        Intrinsics.checkNotNullParameter(r104, "layoutStruct");
        Intrinsics.checkNotNullParameter(r105, "platformContainerDelegate");
        this.f507247a = r100;
        this.f507248b = r101;
        this.f507249c = r102;
        this.f507250d = r103;
        this.f507251e = r104;
        this.f507252f = r105;
    }
}
