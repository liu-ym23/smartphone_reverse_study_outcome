package cq5;

import com.bytedance.ee.bear.contract.route.parcelable.g;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceFilter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements g.a {
    public b a;

    /* JADX INFO: renamed from: cq5.a$a, reason: collision with other inner class name */
    public static final class C0224a {
    }

    public interface b {
        void a(WikiSpaceFilter r1);
    }

    static {
    }

    public a() {
    }

    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r3, "spaceClassId");
        WikiSpaceFilter r0 = new WikiSpaceFilter(r2, r3);
        b r4 = this.a;
        if (r4 == null) goto L6;
        r4.a(r0);
        return;
    }
}
