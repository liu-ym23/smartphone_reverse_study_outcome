package ji9;

import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.larus.bmhome.view.ChatConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f499240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<Set<h>> f499241b = null;

    public e() {
    }

    static {
        f499240a = new e();
        f499241b = new SparseArray();
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [ji9.c] */
    public static void a(final View r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        if (r100 != null) goto L5;
        return;
    L5:
        int r102 = System.identityHashCode(r100.getContext());     // Catch: Throwable -> L17
        Set<h> r103 = f499241b.get(r102);     // Catch: Throwable -> L17
        if (Build.VERSION.SDK_INT < 24) goto L8;
        final ?? r104 = new c(r100);     // Catch: Throwable -> L17
        Object r105 = Boolean.valueOf(r103.removeIf(new d(r104)));     // Catch: Throwable -> L17
    L15:
        Result.m9449constructorimpl(r105);     // Catch: Throwable -> L17
        return;
    L8:
        Iterator<h> r106 = r103.iterator();     // Catch: Throwable -> L17
    L10:
        if (r106.hasNext() == false) goto L14;
        if (Intrinsics.areEqual(r106.next().f499244c.get(), r100) == false) goto L10;
        r106.remove();     // Catch: Throwable -> L17
        goto L10
    L14:
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [ji9.a] */
    public static void b(Set r100, final ChatConstraintLayout r101) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        final ?? r102 = new a(r101);
        r100.removeIf(new b(r102));
        return;
    L5:
        Iterator r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L35;
        View r104 = ((h) r103.next()).f499244c.get();
        boolean r105 = true;
        if (r104 == null) goto L20;
    L11:
        if (r104 == null) goto L19;
        if (Intrinsics.areEqual(r104, r101) == true) goto L20;
        Object r106 = r104.getParent();
        if ((r106 instanceof View) == true) goto L17;
        r104 = null;
        goto L11
    L17:
        r104 = (View) r106;
        goto L11
    L19:
        r105 = false;
    L20:
        if (r105 == false) goto L7;
        r103.remove();
        goto L7
    }

    public static void c(int r110, int r111) {
        Set<h> r100 = f499241b.get(r110);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() == 0) goto L133;
        Iterator r101 = r100.iterator();
        HashSet r102 = null;
    L9:
        if (r101.hasNext() == false) goto L108;
        h r103 = (h) r101.next();
        if (r103.f499246e.contains(Integer.valueOf(r111)) == false) goto L9;
        View r104 = r103.f499244c.get();
        if (r104 == null) goto L15;
        e r105 = f499240a;
        boolean r106 = r103.f499247f;
        r105.getClass();
        int r107 = 0;
        if (r104.isAttachedToWindow() == true) goto L19;
    L25:
        boolean r108 = true;
    L27:
        if (r108 == false) goto L30;
    L42:
        int r112 = 0;
    L44:
        boolean r109 = r103.f499247f;
        if (r104.isAttachedToWindow() == true) goto L47;
    L53:
        boolean r113 = true;
    L54:
        if (r113 == false) goto L57;
    L66:
        int r114 = 0;
    L68:
        float[] r115 = r103.f499245d;
        ArrayList r116 = new ArrayList();
        int r117 = r115.length;
        int r118 = 0;
    L69:
        if (r118 >= r117) goto L91;
        float r119 = r115[r118];
        f499240a.getClass();
        if (r112 <= 0) goto L86;
        if (r114 <= 0) goto L86;
        float r120 = r112;
        float r121 = r114;
        Float r122 = Float.valueOf(r119);
        if (r122.floatValue() < 0.0f) goto L76;
        boolean r123 = true;
    L77:
        if (r123 == true) goto L80;
        r122 = null;
    L80:
        if (r122 == null) goto L82;
        float r124 = r122.floatValue();
    L84:
        if (r120 < (r121 * r124)) goto L86;
        boolean r125 = true;
    L87:
        if (r125 == false) goto L89;
        r116.add(Float.valueOf(r119));
    L89:
        r118 = r118 + 1;
        goto L69
    L82:
        r124 = 1.0f;
        goto L84
    L76:
        r123 = false;
    L86:
        r125 = false;
        goto L87
    L91:
        if ((!r116.isEmpty()) == true) goto L94;
        r116 = null;
    L94:
        if (r116 == null) goto L9;
        String r126 = r103.f499242a.a().invoke();
        float[] r127 = CollectionsKt.toFloatArray(r116);
        Intrinsics.checkNotNullParameter(r127, "exposedPercentages");
        if (r126 == null) goto L9;
        if (TextUtils.isEmpty(r126) == true) goto L9;
        int r128 = r127.length;
    L101:
        if (r107 >= r128) goto L9;
        float r129 = r127[r107];
        if (r103.a(r126, r129) == true) goto L107;
        if (r103.a(r126, r129) == true) goto L107;
        ((Map) r103.f499243b.getValue()).put(r126, Float.valueOf(r129));
        r103.f499242a.b().invoke(Float.valueOf(r129));
    L107:
        r107 = r107 + 1;
        goto L101
    L57:
        if (r104.getWidth() > 0) goto L59;
    L64:
        boolean r130 = true;
    L65:
        if (r130 == true) goto L66;
        r114 = r104.getMeasuredWidth() * r104.getMeasuredHeight();
        goto L68
    L59:
        if (r104.getHeight() <= 0) goto L64;
        if (r104.getAlpha() <= 0.0f) goto L64;
        r130 = false;
        goto L65
    L47:
        if (r104.hasWindowFocus() == true) goto L50;
        if (r109 == false) goto L53;
    L50:
        if (r104.isShown() == false) goto L53;
        r113 = false;
        goto L54
    L30:
        if (r104.getWidth() > 0) goto L32;
    L37:
        boolean r131 = true;
    L38:
        if (r131 == true) goto L42;
        Rect r132 = new Rect();
        if (r104.getGlobalVisibleRect(r132) == false) goto L42;
        r112 = r132.height() * r132.width();
        goto L44
    L32:
        if (r104.getHeight() <= 0) goto L37;
        if (r104.getAlpha() <= 0.0f) goto L37;
        r131 = false;
        goto L38
    L19:
        if (r104.hasWindowFocus() == true) goto L22;
        if (r106 == false) goto L25;
    L22:
        if (r104.isShown() == false) goto L25;
        r108 = false;
        goto L27
    L15:
        r102 = new HashSet();
        r102.add(r103);
        goto L9
    L108:
        if (r102 == null) goto L132;
        r100.removeAll(r102);
        return;
    L132:
        return;
    }
}
