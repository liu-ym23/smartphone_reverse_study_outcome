package kk6;

import android.text.TextUtils;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import ek6.d;
import fk6.a;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class a<T extends fk6.a> implements ik6.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ImageStyle f503812a = null;

    /* JADX INFO: renamed from: kk6.a$a, reason: collision with other inner class name */
    public static final class C6567a {
    }

    public a() {
    }

    static {
        f503812a = new ImageStyle(null, 0, 0, 0.0f, 0, 0, null, null, null, 0, 0, null, 0, 0, 0, 2097151);
    }

    public static String h(fk6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        ImageStyle r101 = r100.e();
        if (r101 == null) goto L5;
        String r102 = r101.f255760i;
    L6:
        if (r102 != null) goto L8;
    L9:
        return "$";
    L8:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    @Override // ik6.a
    public final List b(d r100) {
        fk6.a r101 = (fk6.a) r100;
        Intrinsics.checkNotNullParameter(r101, "content");
        return CollectionsKt.listOf(r101.d());
    }

    @Override // ik6.a
    public final void f(ik6.b r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter((fk6.a) r101, "content");
    }

    @Override // ik6.a
    public final void g(ik6.b r100, d r101) {
        fk6.a r102 = (fk6.a) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r102, "content");
        ek6.c r103 = r102.c();
        if (r103 == null) goto L6;
        int r104 = com.bytedance.live.richcontent.utils.b.f255804a;
        Intrinsics.checkNotNullParameter(r103, "action");
        r100.a(r102, new lk6.d(r103));
        return;
    }

    @Override // ik6.a
    public final void c(ik6.d r100, d r101, ek6.b r102) {
        fk6.a r103 = (fk6.a) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r102, "resourceInfo");
        ImageStyle r104 = r103.e();
        if (r104 != null) goto L6;
        r104 = f503812a;
    L6:
        ImageStyle.PlaceHolderType r105 = r104.f255758g;
        ImageStyle r106 = r103.e();
        if (r106 != null) goto L11;
        r106 = f503812a;
    L11:
        if (r105 == r106.f255759h) goto L30;
        ImageStyle r107 = r103.e();
        if (r107 != null) goto L17;
        r107 = f503812a;
    L17:
        ImageStyle.PlaceHolderType r108 = r107.f255759h;
        int r109 = b.f503814b[r108.ordinal()];
        if (r109 != 1) goto L20;
        lk6.b r110 = null;
    L28:
        r100.b(r103, r110);
        return;
    L20:
        if (r109 != 2) goto L22;
        int r111 = com.bytedance.live.richcontent.utils.b.f255804a;
        r110 = new lk6.b();
        goto L28
    L22:
        if (r109 != 3) goto L25;
        int r112 = com.bytedance.live.richcontent.utils.b.f255804a;
        r110 = new lk6.b();
        com.bytedance.live.richcontent.utils.b.a(r110, r107);
        goto L28
    L25:
        throw new NoWhenBranchMatchedException();
    }

    @Override // ik6.a
    public final void d(ik6.b r100, d r101, ek6.b r102) {
        fk6.a r103 = (fk6.a) r101;
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r102, "resourceInfo");
        ImageStyle r104 = r103.e();
        if (r104 != null) goto L6;
        r104 = f503812a;
    L6:
        ImageStyle.PlaceHolderType r105 = r104.f255758g;
        int r106 = b.f503813a[r105.ordinal()];
        if (r106 != 1) goto L9;
        lk6.b r107 = null;
    L17:
        r100.b(r103, r107);
        return;
    L9:
        if (r106 != 2) goto L11;
        int r108 = com.bytedance.live.richcontent.utils.b.f255804a;
        r107 = new lk6.b();
        goto L17
    L11:
        if (r106 != 3) goto L14;
        int r109 = com.bytedance.live.richcontent.utils.b.f255804a;
        r107 = new lk6.b();
        com.bytedance.live.richcontent.utils.b.a(r107, r104);
        goto L17
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
