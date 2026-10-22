package i2;

import android.graphics.Rect;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.model.RenderType;
import com.bytedance.ai.model.k;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.objects.PageType;
import k2.n;
import k2.s;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j f488034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<i> f488035b = null;

    public static final class a {
        public static i a() {
            return i.f488035b.getValue();
        }
    }

    static {
        f488035b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new h());
    }

    @Override // i2.g, i2.j
    public final Rect b() {
        j r100 = f488034a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.b();
    }

    @Override // i2.j
    public final boolean e() {
        j r100 = f488034a;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        Lazy<f> r102 = f.f488023i;
        if (f.a.a().e() == true) goto L11;
        return false;
    L11:
        return true;
    L5:
        if (r100.e() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // i2.j
    public final boolean h() {
        j r100 = f488034a;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        Lazy<f> r102 = f.f488023i;
        if (f.a.a().h() == true) goto L11;
        return false;
    L11:
        return true;
    L5:
        if (r100.h() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // i2.j
    public final s j() {
        j r100 = f488034a;
        if (r100 == null) goto L6;
        s r101 = r100.j();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Lazy<f> r102 = f.f488023i;
        return f.a.a().f488029f;
    }

    public i() {
    }

    @Override // i2.j
    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        com.bytedance.ai.utils.g.f37637a.i("FloatingViewManagerDelegate", "remove floating window");
        j r101 = f488034a;
        if (r101 == null) goto L5;
        r101.g(r100);
    L5:
        Lazy<f> r102 = f.f488023i;
        if (f.a.a().h() == true) goto L8;
        return true;
    L8:
        return f.a.a().g(r100);
    }

    @Override // i2.j
    public final boolean a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        j r102 = f488034a;
        if (r102 == null) goto L5;
        r102.a(r100, r101);
    L5:
        Lazy<f> r103 = f.f488023i;
        f.a.a().a(r100, r101);
        return true;
    }

    @Override // i2.j
    public final boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        j r102 = f488034a;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.c(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i2.j
    public final int d(s r100, PageInfo r101, FragmentActivity r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r101, "pageInfo");
        String r103 = null;
        if ((r100 instanceof com.bytedance.ai.model.widgets.c) == false) goto L5;
        com.bytedance.ai.model.widgets.c r104 = (com.bytedance.ai.model.widgets.c) r100;
    L6:
        if (r104 == null) goto L9;
        r103 = r104.getRenderType();
    L9:
        if (Intrinsics.areEqual(r103, RenderType.LYNX.getTypeName()) == false) goto L14;
        j r105 = f488034a;
        if (r105 != null) goto L16;
        return 0;
    L16:
        return r105.d(r100, r101, r102);
    L14:
        Lazy<f> r106 = f.f488023i;
        return f.a.a().d(r100, r101, r102);
    L5:
        r104 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i2.j
    public final void f(s r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "page");
        String r103 = null;
        if ((r100 instanceof com.bytedance.ai.model.widgets.c) == false) goto L5;
        com.bytedance.ai.model.widgets.c r104 = (com.bytedance.ai.model.widgets.c) r100;
    L6:
        if (r104 == null) goto L9;
        r103 = r104.getRenderType();
    L9:
        if (Intrinsics.areEqual(r103, RenderType.LYNX.getTypeName()) == false) goto L13;
        j r105 = f488034a;
        if (r105 == null) goto L15;
        r105.f(r100, r101, r102);
        return;
    L15:
        return;
    L13:
        Lazy<f> r106 = f.f488023i;
        f.a.a().f(r100, r101, r102);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final boolean k(Applet r100, PageInfo r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, "applet");
        Intrinsics.checkNotNullParameter(r101, "pageInfo");
        PageType r103 = r101.getPageType();
        PageType r104 = PageType.FLOATING_VIEW;
        if (r103 == r104) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(n.b(r100, r101), RenderType.LYNX.getTypeName()) == true) goto L30;
        Intrinsics.checkNotNullParameter(r100, "applet");
        Intrinsics.checkNotNullParameter(r101, "pageInfo");
        if (r101.getPageType() == r104) goto L11;
        return true;
    L11:
        if (h() == false) goto L37;
        String r105 = r101.getPageName();
        s r106 = j();
        if (r106 == null) goto L17;
        PageInfo r107 = r106.getPageInfo();
        if (r107 == null) goto L17;
        String r108 = r107.getPageName();
    L19:
        if (Intrinsics.areEqual(r105, r108) == false) goto L22;
        r102.invoke("already hasFloatingView " + r101.getPageName());
    L21:
        return false;
    L22:
        s r109 = j();
        if (r109 == null) goto L27;
        String r110 = r109.getPageID();
        if (r110 == null) goto L27;
        boolean r111 = g(r110);
    L28:
        if (r111 == true) goto L39;
        r102.invoke("hasFloatingView and close current floating failed");
        goto L21
    L39:
        return true;
    L27:
        r111 = false;
    L17:
        r108 = null;
        goto L19
    L37:
        return true;
    L30:
        String r112 = r101.getPageName();
        if (r112 == null) goto L40;
        boolean r113 = c(r112, r101.getPackageName());
        if (r113 == false) goto L36;
        r102.invoke("already hasFloatingView " + r101.getPageName());
    L36:
        return true ^ r113;
    L40:
        return true;
    }
}
