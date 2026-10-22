package jk6;

import android.graphics.drawable.Drawable;
import com.bytedance.live.richcontent.ResourceInfo;
import com.bytedance.live.richcontent.engine.SpanRendClient;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements ik6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.live.richcontent.utils.c f499504a;

    public e(com.bytedance.live.richcontent.utils.c r100) {
        Intrinsics.checkNotNullParameter(r100, "monitor");
        this.f499504a = r100;
    }

    @Override // ik6.c
    public final void a(SpanRendClient r110, ik6.d r111) {
        Intrinsics.checkNotNullParameter(r110, "client");
        Intrinsics.checkNotNullParameter(r111, "rendItem");
        List<ResourceInfo> r100 = r111.d();
        hk6.e r101 = r110.f255749f;
        if (r100 == null) goto L30;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L43;
        ResourceInfo r103 = (ResourceInfo) r102.next();
        ek6.b r104 = r103.f255740a;
        ek6.d r105 = r103.f255741b;
        ak6.f r106 = r111.f490270b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r104, "resource");
        Intrinsics.checkNotNullParameter(r105, "content");
        Intrinsics.checkNotNullParameter(r106, "config");
        Drawable r107 = null;
        r101.f485575b.c(r104);     // Catch: Exception -> L18
        hk6.b r108 = r101.a(r104);     // Catch: Exception -> L18
        if ((r108 instanceof hk6.c) == true) goto L11;
        r108 = null;
    L11:
        hk6.c r109 = (hk6.c) r108;     // Catch: Exception -> L18
        if (r109 == null) goto L14;
        Drawable r112 = r109.b(r104, r106, r105);     // Catch: Exception -> L18
    L15:
        if (r112 == null) goto L20;
        r101.f485575b.d(r104);     // Catch: Exception -> L18
        r107 = r112;
    L20:
        if (r107 == null) goto L6;
        Intrinsics.checkNotNullParameter(r103, "resourceInfo");
        if (r103.f255742c != ResourceInfo.State.READY) goto L24;
        ResourceInfo.State r113 = ResourceInfo.State.SUCCESS;
        Intrinsics.checkNotNullParameter(r113, "<set-?>");
        r103.f255742c = r113;
        boolean r114 = true;
    L25:
        if (r114 == false) goto L26;
        ik6.a r115 = r110.a(r103.f255741b);
        if (r115 == null) goto L6;
        r115.a(r111, r103.f255741b, r103.f255740a, r107);
        goto L6
    L26:
        this.f499504a.f(r103, true);
        goto L6
    L24:
        r114 = false;
        goto L25
    L14:
        r112 = null;
    L18:
        e = move-exception;
        r101.f485575b.b(r104, e.getMessage(), e);
        goto L20
    L43:
        return;
    }
}
