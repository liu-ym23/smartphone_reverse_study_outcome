package gi6;

import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventCategory f481419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f481420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Object> f481421c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f481419a, r101.f481419a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f481420b, r101.f481420b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f481421c, r101.f481421c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        EventCategory r100 = this.f481419a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        c r104 = this.f481420b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, Object> r107 = this.f481421c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Event(eventCategory=" + this.f481419a + ", eventType=" + this.f481420b + ", eventInfo=" + this.f481421c + ")";
    }

    public /* synthetic */ b(EventCategory r100, c r101) {
        this(r100, r101, new HashMap());
    }

    public b(EventCategory r100, c r101, HashMap<String, Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventCategory");
        Intrinsics.checkNotNullParameter(r101, "eventType");
        Intrinsics.checkNotNullParameter(r102, "eventInfo");
        this.f481419a = r100;
        this.f481420b = r101;
        this.f481421c = r102;
    }
}
