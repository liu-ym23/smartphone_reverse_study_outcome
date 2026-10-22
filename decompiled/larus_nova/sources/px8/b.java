package px8;

import com.larus.camera.impl.entity.EduResultMode;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f530942e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<EduResultMode> f530943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EduResultMode f530944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f530945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EduResultMode f530946d;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f530943a, r101.f530943a) == true) goto L12;
        return false;
    L12:
        if (this.f530944b == r101.f530944b) goto L15;
        return false;
    L15:
        if (this.f530945c == r101.f530945c) goto L18;
        return false;
    L18:
        if (this.f530946d == r101.f530946d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f530943a.hashCode() * 31) + this.f530944b.hashCode()) * 31;
        if (this.f530945c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f530946d.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "EduResultTabState(availableModes=" + this.f530943a + ", selectedMode=" + this.f530944b + ", showTab=" + this.f530945c + ", defaultMode=" + this.f530946d + ')';
    }

    static {
        List r100 = CollectionsKt.emptyList();
        EduResultMode r101 = EduResultMode.SINGLE_QUESTION;
        f530942e = new b(r100, r101, false, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends EduResultMode> r100, EduResultMode r101, boolean r102, EduResultMode r103) {
        Intrinsics.checkNotNullParameter(r100, "availableModes");
        Intrinsics.checkNotNullParameter(r101, "selectedMode");
        Intrinsics.checkNotNullParameter(r103, "defaultMode");
        this.f530943a = r100;
        this.f530944b = r101;
        this.f530945c = r102;
        this.f530946d = r103;
    }
}
