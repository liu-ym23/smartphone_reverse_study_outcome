package wbc;

import android.graphics.Paint;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f559057a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f559058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static float f559059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static float f559060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f559061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f559062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f559063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Paint f559064h;

    public b() {
    }

    static {
        f559057a = new b();
        f559061e = -1;
        f559062f = -1;
    }

    public static void a(List r110) {
        f559060d = 0.0f;
        f559061e = -1;
        f559062f = -1;
    L3:
        String r100 = null;
        if (f559060d > f559059c) goto L20;
        f559061e = f559062f;
        String r101 = f559058b;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("textRemain");
        String r102 = null;
    L9:
        int r103 = StringsKt.indexOf$default(r102, ' ', f559061e + 1, false, 4, null);
        f559062f = r103;
        if (r103 == (-1)) goto L20;
        Paint r104 = f559064h;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("paint");
        r104 = null;
    L14:
        String r105 = f559058b;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("textRemain");
    L18:
        f559060d = r104.measureText(r100, 0, f559062f);
        goto L3
    L17:
        r100 = r105;
        goto L18
    L8:
        r102 = r101;
    L20:
        if (f559061e != (-1)) goto L50;
        int r106 = f559063g;
        String r107 = f559058b;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("textRemain");
        r107 = null;
    L24:
        int r108 = r107.length();
        if (r106 > r108) goto L37;
    L26:
        Paint r109 = f559064h;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("paint");
        r109 = null;
    L29:
        String r111 = f559058b;
        if (r111 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("textRemain");
        r111 = null;
    L32:
        float r112 = r109.measureText(r111, 0, r106);
        f559060d = r112;
        if (r112 > f559059c) goto L34;
        if (r106 == r108) goto L37;
        r106 = r106 + 1;
        goto L26
    L34:
        int r113 = Math.max(r106 - 1, 0);
    L38:
        String r114 = f559058b;
        if (r114 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("textRemain");
        r114 = null;
    L41:
        String r115 = r114.substring(0, r113);
        if (r115 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("textBeforeIndex");
        r115 = null;
    L44:
        ((ArrayList) r110).add(r115);
        String r116 = f559058b;
        if (r116 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("textRemain");
    L48:
        f559058b = r100.substring(r113);
        return;
    L47:
        r100 = r116;
    L37:
        r113 = 0;
        goto L38
    L50:
        String r117 = f559058b;
        if (r117 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("textRemain");
        r117 = null;
    L53:
        String r118 = r117.substring(0, f559061e);
        if (r118 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("textBeforeIndex");
        r118 = null;
    L56:
        ((ArrayList) r110).add(r118);
        String r119 = f559058b;
        if (r119 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("textRemain");
    L60:
        f559058b = r100.substring(f559061e + 1);
        return;
    L59:
        r100 = r119;
        goto L60
    }
}
