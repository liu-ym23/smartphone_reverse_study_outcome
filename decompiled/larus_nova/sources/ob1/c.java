package ob1;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.bytedance.android.live.soloktv.util.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nb1.l;
import nb1.m;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f522593a = 0;

    static {
    }

    public static LinearGradient a(List r110, float r111) {
        int r100 = 0;
        if (r110 != null) goto L24;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return null;
    L11:
        if (r110.size() <= 1) goto L29;
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L23
        ArrayList r103 = new ArrayList();     // Catch: Exception -> L23
        float r104 = r111 / (r110.size() - 1);     // Catch: Exception -> L23
        Iterator r112 = r110.iterator();     // Catch: Exception -> L23
    L14:
        if (r112.hasNext() == false) goto L19;
        Object r105 = r112.next();     // Catch: Exception -> L23
        int r106 = r100 + 1;     // Catch: Exception -> L23
        if (r100 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L23
    L18:
        r103.add(Float.valueOf(r100 * r104));     // Catch: Exception -> L23
        r102.add(Integer.valueOf(Color.parseColor(((m) r105).b())));     // Catch: Exception -> L23
        r100 = r106;
        goto L14
    L19:
        return new LinearGradient(0.0f, 0.0f, r111, 0.0f, CollectionsKt.toIntArray(r102), CollectionsKt.toFloatArray(r103), Shader.TileMode.CLAMP);
    L30:
        return null;
    L29:
        return null;
    L24:
        if (r110.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public static void b(String r100, Integer r101, Paint... r102) {
        Intrinsics.checkNotNullParameter(r102, "paints");
        int r103 = 0;
        if (r101 == null) goto L8;
        int r104 = 1;
        if (r101.intValue() != 1) goto L8;
    L19:
        if (r100 == null) goto L38;
        String r105 = d.e(r100);
        if (r105 == null) goto L41;
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105);
        if (r106.exists() == true) goto L25;
        return;
    L25:
        if (TypeFaceOptimizer.getSwitch() == false) goto L34;
        String r107 = r106.getPath();
        if (r107 == null) goto L34;
        if (TypeFaceLancet.cache.contains(r107) == false) goto L31;
        Typeface r108 = (Typeface) TypeFaceLancet.cache.get(r107);
    L35:
        Typeface r109 = Typeface.create(r108, r104);
        int r110 = r102.length;
    L36:
        if (r103 >= r110) goto L45;
        r102[r103].setTypeface(r109);
        r103 = r103 + 1;
        goto L36
    L45:
        return;
    L31:
        Typeface r111 = Typeface.createFromFile(r106);
        if (r111 == null) goto L34;
        TypeFaceLancet.cache.put(r107, r111);
        r108 = r111;
    L34:
        r108 = Typeface.createFromFile(r106);
        goto L35
    L41:
        return;
    L38:
        int r112 = r102.length;
    L39:
        if (r103 >= r112) goto L46;
        r102[r103].setTypeface(Typeface.defaultFromStyle(r104));
        r103 = r103 + 1;
        goto L39
    L46:
        return;
    L8:
        if (r101 == null) goto L13;
        r104 = 2;
        if (r101.intValue() == 2) goto L19;
    L13:
        if (r101 == null) goto L18;
        r104 = 3;
        if (r101.intValue() == 3) goto L19;
    L18:
        r104 = 0;
        goto L19
    }

    public static void c(nb1.d r100, TextPaint r101, TextPaint r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, "attributeStruct");
        Intrinsics.checkNotNullParameter(r101, "paint");
        Intrinsics.checkNotNullParameter(r102, "borderPaint");
        r101.setTextSize(r100.d() * r103);     // Catch: Exception -> L27
        r101.setStyle(Paint.Style.FILL);     // Catch: Exception -> L27
        r101.setTextAlign(Paint.Align.CENTER);     // Catch: Exception -> L27
        r101.setAntiAlias(true);     // Catch: Exception -> L27
        l r104 = r100.a();     // Catch: Exception -> L27
        if (r104 == null) goto L14;
        r102.setStrokeWidth(r104.b() * r103);     // Catch: Exception -> L27
        r102.setTextSize(r100.d() * r103);     // Catch: Exception -> L27
        r102.setTextAlign(Paint.Align.CENTER);     // Catch: Exception -> L27
        r102.setStyle(Paint.Style.STROKE);     // Catch: Exception -> L27
        m r105 = r104.a();     // Catch: Exception -> L27
        if (r105 == null) goto L8;
        String r106 = r105.b();     // Catch: Exception -> L27
    L9:
        r102.setColor(Color.parseColor(r106));     // Catch: Exception -> L27
        m r107 = r104.a();     // Catch: Exception -> L27
        if (r107 == null) goto L12;
        float r108 = r107.a();     // Catch: Exception -> L27
    L13:
        r102.setAlpha((int) (r108 * 255));     // Catch: Exception -> L27
        r102.setAntiAlias(true);     // Catch: Exception -> L27
        goto L14
    L12:
        r108 = 1.0f;
        goto L13
    L8:
        r106 = null;
    L14:
        ArrayList<m> r109 = r100.b();     // Catch: Exception -> L27
        if (r109 != null) goto L17;
    L20:
        boolean r110 = true;
    L21:
        if (r110 == false) goto L23;
    L25:
        b(r100.c(), r100.e(), new Paint[]{r101, r102});     // Catch: Exception -> L27
        return;
    L23:
        if (r109.size() != 1) goto L25;
        m r111 = (m) ListProtector.get(r109, 0);     // Catch: Exception -> L27
        r101.setColor(Color.parseColor(r111.b()));     // Catch: Exception -> L27
        r101.setAlpha((int) (r111.a() * 255));     // Catch: Exception -> L27
        goto L25
    L17:
        if (r109.isEmpty() == true) goto L20;
        r110 = false;
    }
}
