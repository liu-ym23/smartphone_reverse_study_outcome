package yr7;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.expression.And;
import com.cronutils.model.field.expression.Between;
import com.cronutils.model.field.expression.Every;
import com.cronutils.model.field.expression.FieldExpression;
import com.cronutils.model.field.expression.On;
import com.cronutils.model.field.value.FieldValue;
import com.cronutils.model.field.value.IntegerFieldValue;
import com.cronutils.model.field.value.SpecialChar;
import com.cronutils.model.field.value.SpecialCharFieldValue;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f568925b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f568926c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f568927d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FieldConstraints f568928a;

    static {
        f568925b = new char[]{'/', '-', ','};
        f568926c = PatternProtector.compile("[0-9]L", 2);
        f568927d = PatternProtector.compile("[0-9]W", 2);
    }

    public h(FieldConstraints r100) {
        zr7.a.b(r100, "FieldConstraints must not be null");
        this.f568928a = r100;
    }

    public final FieldValue<?> a(String r100) {
        SpecialChar[] r101 = SpecialChar.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        SpecialChar r104 = r101[r103];
        if (r104.toString().equals(r100) == true) goto L7;
        r103 = r103 + 1;
        goto L3
    L7:
        return new SpecialCharFieldValue(r104);
    L10:
        return new IntegerFieldValue(f(r100));
    }

    public final IntegerFieldValue b(String r100) {
        Integer r101 = Integer.valueOf(f(r100));     // Catch: NumberFormatException -> L8
        Integer r102 = this.f568928a.getIntMappingValue(r101);     // Catch: NumberFormatException -> L8
        if (r102 == null) goto L5;
        int r103 = r102.intValue();     // Catch: NumberFormatException -> L8
    L6:
        return new IntegerFieldValue(r103);
    L5:
        r103 = r101.intValue();     // Catch: NumberFormatException -> L8
    L9:
        throw new IllegalArgumentException(String.format("Invalid value. Expected some integer, found %s", new Object[]{r100}));
    }

    public final FieldExpression c(String r100) {
        if ("*".equals(r100) == false) goto L7;
        return FieldExpression.always();
    L7:
        if ("?".equals(r100) == false) goto L11;
        return FieldExpression.questionMark();
    L11:
        if ("?".equals(r100) == false) goto L18;
        SpecialCharFieldValue r101 = new SpecialCharFieldValue(SpecialChar.QUESTION_MARK);
        String r102 = r100.replace("?", "");
        if ("".equals(r102) == false) goto L16;
        return new On(new IntegerFieldValue(-1), r101, new IntegerFieldValue(-1));
    L16:
        throw new IllegalArgumentException(String.format("Expected: '?', found: %s", new Object[]{r102}));
    L18:
        if (r100.contains("#") == false) goto L33;
        Set<SpecialChar> r103 = this.f568928a.getSpecialChars();
        SpecialChar r104 = SpecialChar.HASH;
        if (r103.contains(r104) == false) goto L31;
        SpecialCharFieldValue r105 = new SpecialCharFieldValue(r104);
        String[] r106 = r100.split("#");
        if (r106.length == 0) goto L29;
        IntegerFieldValue r107 = b(r106[1]);
        if (r106[0].isEmpty() == true) goto L27;
        return new On(b(r106[0]), r105, r107);
    L27:
        throw new IllegalArgumentException("Time should be specified!");
    L29:
        throw new IllegalArgumentException("Invalid Position of # Character!");
    L31:
        throw new IllegalArgumentException("Invalid expression: ".concat(r100));
    L33:
        if (r100.contains("LW") == false) goto L40;
        SpecialCharFieldValue r108 = new SpecialCharFieldValue(SpecialChar.LW);
        String r109 = r100.replace("LW", "");
        if ("".equals(r109) == false) goto L38;
        return new On(new IntegerFieldValue(-1), r108, new IntegerFieldValue(-1));
    L38:
        throw new IllegalArgumentException(String.format("Expected: LW, found: %s", new Object[]{r109}));
    L40:
        if (f568926c.matcher(r100).find() == true) goto L50;
        if (r100.equalsIgnoreCase("L") == true) goto L50;
        if (f568927d.matcher(r100).find() == false) goto L47;
        On r110 = new On(b(r100.replace(ExifInterface.LONGITUDE_WEST, "")), new SpecialCharFieldValue(SpecialChar.W), new IntegerFieldValue(-1));
    L54:
        return r110;
    L47:
        r110 = new On(b(r100), new SpecialCharFieldValue(SpecialChar.NONE), new IntegerFieldValue(-1));
    L50:
        return e(r100, new IntegerFieldValue(-1));
    }

    public final FieldExpression d(String r110) {
        char[] r100 = f568925b;
        int r101 = 0;
        if (r110 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L28;
        int r103 = r110.length();
        int r104 = r103 - 1;
        int r105 = 0;
    L12:
        if (r105 >= r103) goto L28;
        char r106 = r110.charAt(r105);
        int r107 = 0;
    L15:
        if (r107 >= 3) goto L27;
        if (r100[r107] != r106) goto L26;
        if (Character.isHighSurrogate(r106) == false) goto L25;
        if (r107 == 2) goto L25;
        if (r105 >= r104) goto L26;
        if (r100[r107 + 1] != r110.charAt(r105 + 1)) goto L26;
    L25:
        boolean r108 = true;
    L30:
        if (r108 == false) goto L32;
        String[] r109 = r110.split(",");
        if (r109.length <= 1) goto L46;
        And r111 = new And();
        int r112 = r109.length;
    L43:
        if (r101 >= r112) goto L45;
        r111.and(d(r109[r101]));
        r101 = r101 + 1;
        goto L43
    L45:
        return r111;
    L46:
        String[] r113 = r110.split("-");
        if (r110.contains("-") == false) goto L54;
        if (r113.length == 2) goto L54;
        throw new IllegalArgumentException("Missing values for range: ".concat(r110));
    L54:
        if (r113[0].equalsIgnoreCase("L") == false) goto L57;
        return e(r113[0], b(r113[1]));
    L57:
        if (r113.length > 1) goto L59;
        String[] r114 = r110.split(HTTP.URL_DEFAULT);
        if (r114.length != 2) goto L84;
        String r115 = r114[0];
        String r116 = r114[1];
        String r117 = r115.trim();
        if ("*".equals(r117) == false) goto L76;
        if (r116.equals("1") == false) goto L76;
        return c(r115);
    L76:
        if ("*".equals(r117) == true) goto L82;
        if ("".equals(r115.trim()) == true) goto L82;
        return new Every(new On(b(r115)), new IntegerFieldValue(CastIntegerProtector.parseInt(r116)));
    L82:
        return new Every(new IntegerFieldValue(CastIntegerProtector.parseInt(r116)));
    L84:
        if (r114.length != 1) goto L88;
        throw new IllegalArgumentException("Missing steps for expression: ".concat(r110));
    L88:
        throw new IllegalArgumentException("Invalid expression: ".concat(r110));
    L59:
        if (r113[0].isEmpty() == true) goto L67;
        if (r113[1].isEmpty() == true) goto L67;
        if (r113[1].contains(HTTP.URL_DEFAULT) == false) goto L100;
        String[] r118 = r113[1].split(HTTP.URL_DEFAULT);
        return new Every(new Between(a(r113[0]), a(r118[0])), b(r118[1]));
    L100:
        return new Between(a(r113[0]), a(r113[1]));
    L67:
        throw new IllegalArgumentException(String.format("Invalid expression! Expression: %s-%s does not describe a range. Negative numbers are not allowed.", new Object[]{r113[0], r113[1]}));
    L32:
        if (r110.contains("?") == false) goto L39;
        if (this.f568928a.getSpecialChars().contains(SpecialChar.QUESTION_MARK) == true) goto L39;
        throw new IllegalArgumentException("Invalid expression: ".concat(r110));
    L39:
        return c(r110);
    L26:
        r107 = r107 + 1;
        goto L15
    L27:
        r105 = r105 + 1;
    L28:
        r108 = false;
        goto L30
    L5:
        if (r110.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    public final int f(String r100) {
        Integer r101 = this.f568928a.getStringMappingValue(r100);
        if (r101 != null) goto L5;
        return CastIntegerProtector.parseInt(r100);
    L9:
        throw new IllegalArgumentException(String.format("Invalid chars in expression! Expression: %s Invalid chars: %s", new Object[]{r100, new or7.a(this.f568928a).b(r100)}));
    L5:
        return r101.intValue();
    }

    public final On e(String r100, IntegerFieldValue r101) {
        SpecialCharFieldValue r102 = new SpecialCharFieldValue(SpecialChar.L);
        String r103 = r100.replace("L", "");
        IntegerFieldValue r104 = new IntegerFieldValue(-1);
        if ("".equals(r103) == true) goto L6;
        r104 = b(r103);
    L6:
        return new On(r104, r102, r101);
    }
}
