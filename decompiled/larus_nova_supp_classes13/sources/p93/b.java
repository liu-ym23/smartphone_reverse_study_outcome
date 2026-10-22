package p93;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.tools.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final ConcurrentHashMap<String, a> a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;
    public static final b d = null;

    public static final class a {
        public final Typeface a;

        public a(Typeface r1) {
            this.a = r1;
        }
    }

    public b() {
    }

    static {
        d = new b();
        a = new ConcurrentHashMap();
        b = SetsKt.setOf(new String[]{"douyin_number_abc_medium.otf", "douyin_number_abc_bold.otf", "douyin_number_abc_condensed_medium.otf", "douyin_number_abc_extra_bold.otf", "douyin_number_abc_extra_condensed_medium.otf", "DouyinSansBold.otf"});
        c = SetsKt.setOf("DouyinSansBold.otf");
    }

    public static int b(String r10) {
        List r11 = new Regex(",").split(r10.substring(5, r10.length() - 1), 0);
        if (r11.isEmpty() == true) goto L13;
        ListIterator r0 = r11.listIterator(r11.size());
    L6:
        if (r0.hasPrevious() == false) goto L13;
        if (((String) r0.previous()).length() != 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L6;
        List r12 = CollectionsKt.take(r11, r0.nextIndex() + 1);
    L14:
        Object[] r13 = r12.toArray(new String[0]);
        if (r13 == null) goto L101;
        String[] r14 = (String[]) r13;
        String r1 = r14[0];     // Catch: NumberFormatException -> L102
        int r4 = r1.length() - 1;     // Catch: NumberFormatException -> L102
        int r5 = 0;
        boolean r6 = false;
    L19:
        if (r5 > r4) goto L34;
        if (r6 == true) goto L22;
        int r7 = r5;
    L24:
        if (Intrinsics.compare(r1.charAt(r7), 32) > 0) goto L26;
        boolean r8 = true;
    L27:
        if (r6 == false) goto L28;
        if (r8 == false) goto L34;
        r4 = r4 - 1;     // Catch: NumberFormatException -> L102
        goto L19
    L28:
        if (r8 == false) goto L29;
        r5 = r5 + 1;     // Catch: NumberFormatException -> L102
        goto L19
    L29:
        r6 = true;
        goto L19
    L26:
        r8 = false;
        goto L27
    L22:
        r7 = r4;
    L34:
        int r2 = CastIntegerProtector.parseInt(r1.subSequence(r5, r4 + 1).toString());     // Catch: NumberFormatException -> L102
        String r9 = r14[1];     // Catch: NumberFormatException -> L102
        int r15 = r9.length() - 1;     // Catch: NumberFormatException -> L102
        int r16 = 0;
        boolean r17 = false;
    L35:
        if (r16 > r15) goto L50;
        if (r17 == true) goto L38;
        int r18 = r16;
    L40:
        if (Intrinsics.compare(r9.charAt(r18), 32) > 0) goto L42;
        boolean r19 = true;
    L43:
        if (r17 == false) goto L44;
        if (r19 == false) goto L50;
        r15 = r15 - 1;     // Catch: NumberFormatException -> L102
        goto L35
    L44:
        if (r19 == false) goto L45;
        r16 = r16 + 1;     // Catch: NumberFormatException -> L102
        goto L35
    L45:
        r17 = true;
        goto L35
    L42:
        r19 = false;
        goto L43
    L38:
        r18 = r15;
    L50:
        int r20 = CastIntegerProtector.parseInt(r9.subSequence(r16, r15 + 1).toString());     // Catch: NumberFormatException -> L102
        String r21 = r14[2];     // Catch: NumberFormatException -> L102
        int r22 = r21.length() - 1;     // Catch: NumberFormatException -> L102
        int r23 = 0;
        boolean r24 = false;
    L51:
        if (r23 > r22) goto L66;
        if (r24 == true) goto L54;
        int r25 = r23;
    L56:
        if (Intrinsics.compare(r21.charAt(r25), 32) > 0) goto L58;
        boolean r26 = true;
    L59:
        if (r24 == false) goto L60;
        if (r26 == false) goto L66;
        r22 = r22 - 1;     // Catch: NumberFormatException -> L102
        goto L51
    L60:
        if (r26 == false) goto L61;
        r23 = r23 + 1;     // Catch: NumberFormatException -> L102
        goto L51
    L61:
        r24 = true;
        goto L51
    L58:
        r26 = false;
        goto L59
    L54:
        r25 = r22;
    L66:
        int r27 = CastIntegerProtector.parseInt(r21.subSequence(r23, r22 + 1).toString());     // Catch: NumberFormatException -> L102
        String r110 = r14[3];     // Catch: NumberFormatException -> L102
        int r28 = r110.length() - 1;     // Catch: NumberFormatException -> L102
        int r29 = 0;
        boolean r30 = false;
    L67:
        if (r29 > r28) goto L82;
        if (r30 == true) goto L70;
        int r31 = r29;
    L72:
        if (Intrinsics.compare(r110.charAt(r31), 32) > 0) goto L74;
        boolean r32 = true;
    L75:
        if (r30 == false) goto L76;
        if (r32 == false) goto L82;
        r28 = r28 - 1;     // Catch: NumberFormatException -> L102
        goto L67
    L76:
        if (r32 == false) goto L77;
        r29 = r29 + 1;     // Catch: NumberFormatException -> L102
        goto L67
    L77:
        r30 = true;
        goto L67
    L74:
        r32 = false;
        goto L75
    L70:
        r31 = r28;
    L82:
        float r111 = CastFloatProtector.parseFloat(r110.subSequence(r29, r28 + 1).toString());     // Catch: NumberFormatException -> L102
        if (r2 < 0) goto L99;
        if (255 < r2) goto L99;
        if (r20 < 0) goto L99;
        if (255 < r20) goto L99;
        if (r27 < 0) goto L99;
        if (255 < r27) goto L99;
        if (0.0f > r111) goto L99;
        if (r111 > 1.0f) goto L99;
        return Color.argb((int) (r111 * 255), r2, r20, r27);
    L99:
        return 0;
    L101:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L10:
        r3 = false;
    L13:
        r12 = CollectionsKt.emptyList();
        goto L14
    }

    public static Integer e(String r4) {
        if (r4 != null) goto L18;
        return null;
    L18:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        if (StringsKt.startsWith$default(r4, "#", false, 2, null) == false) goto L10;
        return Integer.valueOf(Color.parseColor(r4));
    L10:
        if (StringsKt.startsWith$default(r4, "rgba", false, 2, null) == true) goto L12;
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        return null;
    L12:
        return Integer.valueOf(b(r4));
    L15:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public static float c(List r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$getOr0");
        if (r2 < r1.size()) goto L7;
        return 0.0f;
    L7:
        return ((Number) ListProtector.get(r1, r2)).floatValue();
    }

    public static int f(Number r1, Context r2) {
        int r0 = c.a;
        return c.c(r1, r2, true);
    }

    public static Typeface d(String r3, Context r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "font");
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = r3.hashCode();
        if (r0 == (-981614931)) goto L11;
        if (r0 == 1866312093) goto L8;
    L13:
        String r1 = r3;
    L14:
        Typeface r2 = null;
        if (b.contains(r1) == true) goto L17;
        return null;
    L17:
        String r6 = "fonts/".concat(r1);
        a r7 = a.get(r6);
        if (r7 == null) goto L20;
        Typeface r8 = r7.a;
    L21:
        if (r8 == null) goto L23;
    L29:
        if (r8 == null) goto L39;
        a.put(r6, new a(r8));
        if (r5 != null) goto L34;
        return r8;
    L34:
        if (Build.VERSION.SDK_INT < 28) goto L39;
        if (r8.getWeight() == r5.intValue()) goto L39;
        return Typeface.create(r8, r5.intValue(), r8.isItalic());
    L39:
        return r8;
    L23:
        if (c.contains(r3) == false) goto L40;
        r8 = i.b.a(r4, r3);
        goto L29
    L40:
        r2 = Typeface.createFromAsset(r4.getAssets(), r6);     // Catch: Throwable -> L27
    L28:
        r8 = r2;
        goto L29
    L20:
        r8 = null;
        goto L21
    L8:
        if (r3.equals("DouyinNumberABC-Medium") == false) goto L13;
        r1 = "douyin_number_abc_medium.otf";
        goto L14
    L11:
        if (r3.equals("DouyinNumberABC-Bold") == false) goto L13;
        r1 = "douyin_number_abc_bold.otf";
        goto L14
    }

    public static GradientDrawable a(int r3, int r4, int r5, float[] r6) {
        GradientDrawable r0 = new GradientDrawable();     // Catch: Exception -> L6
        r0.setShape(0);     // Catch: Exception -> L6
        r0.setColor(r3);     // Catch: Exception -> L6
        r0.setStroke(r5, r4);     // Catch: Exception -> L6
        if (r6.length != 4) goto L10;
        float r7 = r6[1];     // Catch: Exception -> L6
        float r8 = r6[2];     // Catch: Exception -> L6
        float r9 = r6[3];     // Catch: Exception -> L6
        r0.setCornerRadii(new float[]{r6[0], r6[0], r7, r7, r8, r8, r9, r9});     // Catch: Exception -> L6
        return r0;
    L10:
        return r0;
    L6:
        return null;
    }
}
