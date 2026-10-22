package feb;

import com.ss.android.lark.feed.app.entity.UIFeedCard;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f476631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, UIFeedCard> f476632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f476633c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f476631a, r101.f476631a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f476632b, r101.f476632b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f476633c, r101.f476633c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f476631a.hashCode() * 31) + this.f476632b.hashCode()) * 31) + this.f476633c.hashCode();
    }

    public final String toString() {
        return "PersistPlan(finalOrderIds=" + this.f476631a + ", upsertItems=" + this.f476632b + ", removeItemIds=" + this.f476633c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<String> r100, Map<String, ? extends UIFeedCard> r101, Set<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "finalOrderIds");
        Intrinsics.checkNotNullParameter(r101, "upsertItems");
        Intrinsics.checkNotNullParameter(r102, "removeItemIds");
        this.f476631a = r100;
        this.f476632b = r101;
        this.f476633c = r102;
    }
}
