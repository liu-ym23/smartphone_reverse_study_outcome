package n0a;

import com.larus.ugc.feed.api.model.UserCreationModelKmp;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<UserCreationModelKmp> f516613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f516614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f516615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f516616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f516617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f516618f;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f516613a, r101.f516613a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f516614b, r101.f516614b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f516615c, r101.f516615c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f516616d, r101.f516616d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f516617e, r101.f516617e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f516618f, r101.f516618f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f516613a.hashCode() * 31) + this.f516614b.hashCode()) * 31;
        e r101 = this.f516615c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        b r105 = this.f516616d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Long r108 = this.f516617e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        c r111 = this.f516618f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationFeedUiState(creationModelList=" + this.f516613a + ", pageState=" + this.f516614b + ", refreshState=" + this.f516615c + ", moreState=" + this.f516616d + ", invokeLoadMoreEvent=" + this.f516617e + ", invokeNotifyDataList=" + this.f516618f + ')';
    }

    public /* synthetic */ a(int r100) {
        this(CollectionsKt.emptyList(), d.e.f516629a, null, null, null, null);
    }

    public a(List<UserCreationModelKmp> r100, d r101, e r102, b r103, Long r104, c r105) {
        Intrinsics.checkNotNullParameter(r100, "creationModelList");
        Intrinsics.checkNotNullParameter(r101, "pageState");
        this.f516613a = r100;
        this.f516614b = r101;
        this.f516615c = r102;
        this.f516616d = r103;
        this.f516617e = r104;
        this.f516618f = r105;
    }

    public static a a(a r100, List r101, d r102, e r110, b r111, Long r112, c r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        r101 = r100.f516613a;
    L5:
        List r103 = r101;
        if ((r114 & 2) == 0) goto L8;
        r102 = r100.f516614b;
    L8:
        d r104 = r102;
        if ((r114 & 4) == 0) goto L11;
        r110 = r100.f516615c;
    L11:
        e r105 = r110;
        if ((r114 & 8) == 0) goto L14;
        r111 = r100.f516616d;
    L14:
        b r106 = r111;
        if ((r114 & 16) == 0) goto L17;
        r112 = r100.f516617e;
    L17:
        Long r107 = r112;
        if ((r114 & 32) == 0) goto L20;
        r113 = r100.f516618f;
    L20:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "creationModelList");
        Intrinsics.checkNotNullParameter(r104, "pageState");
        return new a(r103, r104, r105, r106, r107, r113);
    }
}
