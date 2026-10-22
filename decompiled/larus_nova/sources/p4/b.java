package p4;

import com.bytedance.ai.bridge.remote.model.AppMeta;
import com.bytedance.ai.bridge.remote.model.FailedKey;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<AppMeta> f527617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<FailedKey> f527618b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f527617a, r101.f527617a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f527618b, r101.f527618b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<AppMeta> r100 = this.f527617a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<FailedKey> r104 = this.f527618b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BatchAppletMetaInfoResult(items=" + this.f527617a + ", failedKeys=" + this.f527618b + ')';
    }

    public b() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public final List<AppMeta> a() {
        return this.f527617a;
    }

    public b(List<AppMeta> r100, List<FailedKey> r101) {
        this.f527617a = r100;
        this.f527618b = r101;
    }
}
