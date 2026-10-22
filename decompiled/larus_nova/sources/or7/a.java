package or7;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.cronutils.model.field.constraint.FieldConstraints;
import com.cronutils.model.field.value.SpecialChar;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SpecialChar[] f524953c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f524954d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Pattern f524955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f524956b;

    static {
        f524953c = new SpecialChar[]{SpecialChar.L, SpecialChar.LW, SpecialChar.W};
        f524954d = PatternProtector.compile("[#\\?/\\*0-9]");
    }

    public a(FieldConstraints r100) {
        Set<SpecialChar> r101 = r100.getSpecialChars();
        HashSet r102 = new HashSet();
        SpecialChar[] r103 = f524953c;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        SpecialChar r106 = r103[r105];
        if (r101.contains(r106) == false) goto L7;
        r102.add(r106.name());
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        this.f524956b = a(r102);
        this.f524955a = a(r100.getStringMappingKeySet());
    }

    public static Pattern a(Set r100) {
        StringBuilder r101 = new StringBuilder("\\b(");
        Iterator r102 = r100.iterator();
        if (r102.hasNext() == true) goto L6;
        r101.append(")\\b");
        return PatternProtector.compile(r101.toString());
    L6:
        r101.append((String) r102.next());
    L8:
        if (r102.hasNext() == false) goto L10;
        r101.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r101.append((String) r102.next());
        goto L8
    L10:
        r101.append(")\\b");
        return PatternProtector.compile(r101.toString());
    }

    public final String b(String r100) {
        Matcher r101 = f524954d.matcher(r100.toUpperCase());
        Matcher r102 = this.f524955a.matcher(r101.replaceAll(""));
        return this.f524956b.matcher(r102.replaceAll("")).replaceAll("").replaceAll("\\s+", "").replaceAll(",", "").replaceAll("-", "");
    }
}
