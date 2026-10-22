package my7;

import android.app.Activity;
import android.os.Build;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<a> f516390a = null;

    public interface a {
        void a(Activity r100, Throwable r101);

        boolean b(Throwable r100);
    }

    public static final class b implements a {
        public b() {
        }

        @Override // my7.d.a
        public final boolean b(Throwable r110) {
            Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
            if (Build.VERSION.SDK_INT == 34) goto L5;
            return false;
        L5:
            String r100 = Build.BRAND;
            String r101 = "";
            if (r100 != null) goto L8;
            r100 = "";
        L8:
            Locale r102 = Locale.ROOT;
            String r103 = r100.toLowerCase(r102);
            String r104 = Build.MANUFACTURER;
            if (r104 == null) goto L12;
            r101 = r104;
        L12:
            String r105 = r101.toLowerCase(r102);
            if (StringsKt.contains$default(r103, DimLocationCheckUtil.VIVO, false, 2, null) == false) goto L15;
        L17:
            String r106 = r110.getMessage();
            if (r106 != null) goto L20;
        L23:
            boolean r107 = true;
        L24:
            if (r107 == false) goto L26;
            return false;
        L26:
            if (StringsKt.contains$default(r106, "DecorCaptionView.getCaption()", false, 2, null) == false) goto L52;
            StackTraceElement[] r111 = r110.getStackTrace();
            int r108 = r111.length;
            int r109 = 0;
            boolean r112 = false;
            boolean r113 = false;
        L29:
            if (r109 >= r108) goto L41;
            StackTraceElement r114 = r111[r109];
            if (Intrinsics.areEqual(r114.getClassName(), "com.android.internal.policy.DecorView") == false) goto L36;
            if (Intrinsics.areEqual(r114.getMethodName(), "updateColorViews") == false) goto L36;
            r112 = true;
        L36:
            if (Intrinsics.areEqual(r114.getClassName(), "com.android.internal.policy.PhoneWindow") == false) goto L40;
            if (Intrinsics.areEqual(r114.getMethodName(), "getDecorView") == false) goto L40;
            r113 = true;
        L40:
            r109 = r109 + 1;
            goto L29
        L41:
            if (r112 == false) goto L50;
            if (r113 == false) goto L51;
            return true;
        L51:
            return false;
        L50:
            return false;
        L52:
            return false;
        L20:
            if (r106.length() == 0) goto L23;
            r107 = false;
            goto L24
        L15:
            if (StringsKt.contains$default(r105, DimLocationCheckUtil.VIVO, false, 2, null) == true) goto L17;
            return false;
        }

        @Override // my7.d.a
        public final void a(Activity r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter("InsetsCompatAirActivity", "tag");
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            Log.e("InsetsCompatAirActivity", "skip setupWindowInsets for vivo DecorCaptionView crash, activity=".concat(r100.getClass().getSimpleName()), r101);
        }
    }

    public static final class c implements a {
        public c() {
        }

        @Override // my7.d.a
        public final boolean b(Throwable r110) {
            Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
            if ((r110 instanceof SecurityException) == true) goto L5;
            return false;
        L5:
            String r100 = r110.getMessage();
            if (r100 != null) goto L8;
        L11:
            boolean r101 = true;
        L12:
            if (r101 == false) goto L14;
            return false;
        L14:
            if (StringsKt.contains$default(r100, "Binder invocation to an incorrect interface", false, 2, null) == false) goto L51;
            StackTraceElement[] r111 = ((SecurityException) r110).getStackTrace();
            int r102 = r111.length;
            int r103 = 0;
            boolean r104 = false;
            boolean r105 = false;
            boolean r106 = false;
        L17:
            if (r103 >= r102) goto L38;
            StackTraceElement r107 = r111[r103];
            if (Intrinsics.areEqual(r107.getClassName(), "android.view.IWindowManager$Stub$Proxy") == false) goto L26;
            if (Intrinsics.areEqual(r107.getMethodName(), "hasNavigationBar") == false) goto L23;
        L24:
            r104 = true;
            goto L26
        L23:
            if (Intrinsics.areEqual(r107.getMethodName(), "getWindowInsets") == true) goto L24;
        L26:
            if (Intrinsics.areEqual(r107.getClassName(), "com.android.internal.policy.DecorView") == false) goto L31;
            if (Intrinsics.areEqual(r107.getMethodName(), "<init>") == false) goto L31;
            r105 = true;
        L31:
            if (Intrinsics.areEqual(r107.getClassName(), "com.android.internal.policy.PhoneWindow") == false) goto L37;
            if (Intrinsics.areEqual(r107.getMethodName(), "getDecorView") == false) goto L35;
        L36:
            r106 = true;
            goto L37
        L35:
            if (Intrinsics.areEqual(r107.getMethodName(), "installDecor") == true) goto L36;
        L37:
            r103 = r103 + 1;
            goto L17
        L38:
            if (r104 == false) goto L48;
            if (r105 == false) goto L49;
            if (r106 == false) goto L50;
            return true;
        L50:
            return false;
        L49:
            return false;
        L48:
            return false;
        L51:
            return false;
        L8:
            if (r100.length() == 0) goto L11;
            r101 = false;
            goto L12
        }

        @Override // my7.d.a
        public final void a(Activity r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter("InsetsCompatAirActivity", "tag");
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            Log.e("InsetsCompatAirActivity", "skip setupWindowInsets for decorView IWindowManager binder crash, activity=" + r100.getClass().getSimpleName() + ", brand=" + Build.BRAND + ", manufacturer=" + Build.MANUFACTURER + ", model=" + Build.MODEL + ", sdk=" + Build.VERSION.SDK_INT, r101);
        }
    }

    static {
        f516390a = CollectionsKt.listOf(new a[]{new b(), new c()});
    }
}
