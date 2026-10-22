package z34;

import com.bytedance.awemeopen.domain.feed.preload.framework.AosAwemePreloadModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v34.b;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T extends v34.b<T>> implements y34.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Boolean> f569874a;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function1<? super String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "isPrivacy");
        this.f569874a = r100;
    }

    @Override // y34.a
    public final y34.b a(AosAwemePreloadModel r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Function1<String, Boolean> r101 = this.f569874a;
        String r102 = r100.id();
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        if (r101.invoke(r102).booleanValue() == false) goto L9;
        return new y34.b(true, "the video is Privacy!!");
    L9:
        return new y34.b(false, "");
    }
}
