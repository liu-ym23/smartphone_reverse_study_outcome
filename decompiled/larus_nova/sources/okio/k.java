package okio;

import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f524077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f524078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f524079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f524080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f524081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f524082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f524083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<KClass<?>, Object> f524084h;

    public final String toString() {
        ArrayList r100 = new ArrayList();
        if (this.f524077a == false) goto L6;
        r100.add("isRegularFile");
    L6:
        if (this.f524078b == false) goto L9;
        r100.add("isDirectory");
    L9:
        if (this.f524080d == null) goto L12;
        r100.add("byteCount=" + this.f524080d);
    L12:
        if (this.f524081e == null) goto L15;
        r100.add("createdAt=" + this.f524081e);
    L15:
        if (this.f524082f == null) goto L18;
        r100.add("lastModifiedAt=" + this.f524082f);
    L18:
        if (this.f524083g == null) goto L21;
        r100.add("lastAccessedAt=" + this.f524083g);
    L21:
        if ((!this.f524084h.isEmpty()) == false) goto L24;
        r100.add("extras=" + this.f524084h);
    L24:
        return CollectionsKt.joinToString$default(r100, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }

    public /* synthetic */ k(boolean r110, boolean r111, b0 r112, Long r113, Long r114, Long r115, Long r116) {
        this(r110, r111, r112, r113, r114, r115, r116, MapsKt.emptyMap());
    }

    public k(boolean r100, boolean r101, b0 r102, Long r103, Long r104, Long r105, Long r106, Map<KClass<?>, ? extends Object> r107) {
        Intrinsics.checkNotNullParameter(r107, "extras");
        this.f524077a = r100;
        this.f524078b = r101;
        this.f524079c = r102;
        this.f524080d = r103;
        this.f524081e = r104;
        this.f524082f = r105;
        this.f524083g = r106;
        this.f524084h = MapsKt.toMap(r107);
    }
}
