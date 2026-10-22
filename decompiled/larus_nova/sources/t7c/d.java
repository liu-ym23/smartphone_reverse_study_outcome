package t7c;

import com.larksuite.arch.jack.j;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.utils.i;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.ss.android.lark.todo.impl.features.center.v3.data.a> f545008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f545010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f545011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f545012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f545013f;

    public d() {
        this(null, null, false, false, false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f545008a, r101.f545008a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f545009b, r101.f545009b) == true) goto L15;
        return false;
    L15:
        if (this.f545010c == r101.f545010c) goto L18;
        return false;
    L18:
        if (this.f545011d == r101.f545011d) goto L21;
        return false;
    L21:
        if (this.f545012e == r101.f545012e) goto L24;
        return false;
    L24:
        if (this.f545013f == r101.f545013f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f545008a.hashCode() * 31) + this.f545009b.hashCode()) * 31;
        int r101 = 1231;
        if (this.f545010c == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f545011d == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f545012e == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f545013f == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ListViewState(itemList=" + this.f545008a + ", emptyString=" + this.f545009b + ", refresh=" + this.f545010c + ", needScrollTop=" + this.f545011d + ", showArchiveHeader=" + this.f545012e + ", showUnArchiveButton=" + this.f545013f + ')';
    }

    public d(List r100, String r101, boolean r102, boolean r103, boolean r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r105 & 2) == 0) goto L9;
        r101 = i.f444291a.g(R.string.Todo_NoTasks_EmptyStateText);
    L9:
        if ((r105 & 4) == 0) goto L11;
        boolean r106 = true;
    L13:
        if ((r105 & 8) == 0) goto L16;
        r102 = false;
    L16:
        if ((r105 & 16) == 0) goto L19;
        r103 = false;
    L19:
        if ((r105 & 32) == 0) goto L21;
        r104 = false;
    L21:
        Intrinsics.checkNotNullParameter(r100, "itemList");
        Intrinsics.checkNotNullParameter(r101, "emptyString");
        this.f545008a = r100;
        this.f545009b = r101;
        this.f545010c = r106;
        this.f545011d = r102;
        this.f545012e = r103;
        this.f545013f = r104;
        return;
    L11:
        r106 = false;
        goto L13
    }
}
