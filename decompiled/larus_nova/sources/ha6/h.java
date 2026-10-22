package ha6;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f484393a = 0;

    static {
    }

    public h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Lifecycle c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof LifecycleOwner) == false) goto L7;
        return ((LifecycleOwner) r100).getLifecycle();
    L7:
        if ((r100 instanceof ContextWrapper) == true) goto L9;
        return null;
    L9:
        return c(((ContextWrapper) r100).getBaseContext());
    }

    public static boolean a(View r100, boolean r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        boolean r102 = r100.isAttachedToWindow();
        if (r100.getParent() == null) goto L30;
        if (r102 == true) goto L10;
        return false;
    L10:
        if (r100.getVisibility() != 8) goto L12;
        return false;
    L12:
        if (r100.isShown() == true) goto L15;
        return false;
    L15:
        if (r100.getWidth() != 0) goto L17;
    L21:
        if (r101 == true) goto L38;
        int[] r103 = new int[2];
        r100.getLocationOnScreen(r103);
        int r104 = r103[0];
        int r105 = r103[1];
        int r106 = r100.getWidth() + r104;
        int r107 = r100.getHeight() + r105;
        c r108 = d.a(r100.getContext());
        int r109 = r108.f484382a;
        int r110 = r108.f484383b;
        if (r106 <= 0) goto L32;
        if (r104 >= r109) goto L33;
        if (r107 <= 0) goto L34;
        if (r105 >= r110) goto L35;
        return true;
    L35:
        return false;
    L34:
        return false;
    L33:
        return false;
    L32:
        return false;
    L38:
        return false;
    L17:
        if (r100.getHeight() == 0) goto L21;
        return r100.getGlobalVisibleRect(new Rect());
    L30:
        return false;
    }

    public static void d(final View r100, final com.bytedance.kmp.ec.yata.view.c r101, final Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "instance");
        Intrinsics.checkNotNullParameter(r102, "action");
        if (r101.f251835r == false) goto L5;
        return;
    L5:
        r100.post(new g(r101, r100, r102));
    }

    public static void b(final View r100, final com.bytedance.kmp.ec.yata.common.utils.b r101, final int r102, final int r110, final Function0 r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "life");
        Intrinsics.checkNotNullParameter(r111, "action");
        if (r101.a() == false) goto L5;
        return;
    L5:
        if (r102 <= r110) goto L9;
        r111.invoke();
        return;
    L9:
        if (r100.isLayoutRequested() == false) goto L11;
        r100.post(new f(r100, r101, r102, r110, r111));
        return;
    L11:
        r111.invoke();
    }
}
