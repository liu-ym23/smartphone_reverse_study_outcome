package ou6;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes21.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Pair<String, String>> f526774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f526775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f526776c;

    public final String a() {
        if (this.f526774a.isEmpty() == true) goto L5;
        ArrayList<Pair<String, String>> r100 = this.f526774a;
        String r101 = this.f526776c;
        StringBuilder r102 = new StringBuilder();
        boolean r103 = false;
        if (r100 == null) goto L18;
        Iterator<Pair<String, String>> r104 = r100.iterator();
    L10:
        if (r104.hasNext() == false) goto L18;
        Pair<String, String> r105 = r104.next();
        String r106 = b(r105.getFirst(), r101);
        String r107 = b(r105.getSecond(), r101);
        if (r102.length() <= 0) goto L14;
        boolean r108 = true;
    L15:
        if (r108 == false) goto L17;
        r102.append("&");
    L17:
        r102.append(r106);
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(r107);
        goto L10
    L14:
        r108 = false;
    L18:
        String r109 = r102.toString();
        String r110 = this.f526775b;
        if (r110 == null) goto L33;
        Intrinsics.checkNotNull(r110);
        if (r110.length() != 0) goto L23;
        r103 = true;
    L23:
        if (r103 == true) goto L35;
        String r111 = this.f526775b;
        Intrinsics.checkNotNull(r111);
        if (StringsKt.indexOf$default(r111, '?', 0, false, 6, null) < 0) goto L29;
        return this.f526775b + Typography.amp + r109;
    L29:
        return this.f526775b + '?' + r109;
    L35:
        return r109;
    L33:
        return r109;
    L5:
        return this.f526775b;
    }

    public final String toString() {
        String r100 = a();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public k(String r100) {
        this.f526774a = new ArrayList();
        this.f526776c = "UTF-8";
        this.f526775b = r100;
    }

    public static String b(String r100, String r101) {
        if (r101 != null) goto L5;
        r100 = URLEncoder.encode(r100, "ISO-8859-1");     // Catch: UnsupportedEncodingException -> L9
    L12:
        return r100;
    L5:
        if (Intrinsics.areEqual(r101, "null_encoding") == true) goto L12;
        r100 = URLEncoder.encode(r100, r101);     // Catch: UnsupportedEncodingException -> L9
    L9:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
