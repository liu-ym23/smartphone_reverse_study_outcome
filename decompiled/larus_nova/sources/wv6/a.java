package wv6;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f561596a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f561597b = null;

    static {
        f561596a = CollectionsKt.listOf(new String[]{"18", "08"});
        f561597b = CollectionsKt.listOf(new String[]{HiAnalyticsConstant.KeyAndValue.NUMBER_01, "03", "1901", "1905", "0501", "0502", "0503", "0505", "0520", "0521", "0701", "0201", "0402", "0403", "1701"});
    }

    @JvmStatic
    public static final String a(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        Iterator<T> r101 = f561596a.iterator();
    L7:
        if (r101.hasNext() == false) goto L12;
        if (StringsKt.startsWith$default(r100, (String) r101.next(), false, 2, null) == false) goto L7;
        return "1";
    L12:
        Iterator<T> r102 = f561597b.iterator();
    L14:
        if (r102.hasNext() == false) goto L19;
        if (StringsKt.startsWith$default(r100, (String) r102.next(), false, 2, null) == false) goto L14;
        return "2";
    L19:
        return "0";
    }
}
