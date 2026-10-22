package cq5;

import com.bytedance.ee.bear.contract.route.parcelable.g;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceFilter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f464789a;

    /* JADX INFO: renamed from: cq5.a$a, reason: collision with other inner class name */
    public static final class C5573a {
    }

    public interface b {
        void a(WikiSpaceFilter r100);
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.route.parcelable.g.a
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r101, "spaceClassId");
        WikiSpaceFilter r102 = new WikiSpaceFilter(r100, r101);
        b r103 = this.f464789a;
        if (r103 == null) goto L6;
        r103.a(r102);
        return;
    }
}
