package sm9;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f542587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f542588b;

    public static final class a {
    }

    static {
    }

    public final boolean a(String r210) {
        Intrinsics.checkNotNullParameter(r210, "url");
        Uri r100 = UriProtector.parse(r210);
        String r101 = r100.getHost();
        boolean r102 = false;
        if (r101 != null) goto L6;
        FLogger.f375446a.d("FeishuDocLinkClassifier", "isFeishuDocLink: host is null for url=" + r210);
        return false;
    L6:
        FLogger.f375446a.d("FeishuDocLinkClassifier", "isFeishuDomain: host=" + r101 + ", domains=" + this.f542587a);
        List<String> r103 = this.f542587a;
        if ((r103 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L23;
        String r105 = (String) r104.next();
        if (Intrinsics.areEqual(r101, r105) == false) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == false) goto L13;
        boolean r107 = true;
    L24:
        if (r107 == true) goto L27;
        FLogger.f375446a.d("FeishuDocLinkClassifier", "isFeishuDocLink: host=" + r101 + " is not a feishu domain");
        return false;
    L27:
        String r108 = r100.getPath();
        if (r108 != null) goto L30;
        FLogger.f375446a.d("FeishuDocLinkClassifier", "matchDocType: path is null");
    L46:
        FLogger.f375446a.i("FeishuDocLinkClassifier", "isFeishuDocLink: url=" + r210 + ", host=" + r101 + ", path=" + r100.getPath() + ", matched=" + r102);
        return r102;
    L30:
        List r109 = StringsKt.split$default(r108, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        ArrayList r110 = new ArrayList();
        Iterator r111 = r109.iterator();
    L32:
        if (r111.hasNext() == false) goto L40;
        Object r112 = r111.next();
        if (((String) r112).length() <= 0) goto L36;
        boolean r113 = true;
    L37:
        if (r113 == false) goto L32;
        r110.add(r112);
        goto L32
    L36:
        r113 = false;
        goto L37
    L40:
        if (r110.size() >= 2) goto L42;
        FLogger.f375446a.d("FeishuDocLinkClassifier", "matchDocType: less than 2 segments in path=".concat(r108));
        goto L46
    L42:
        String r114 = CollectionsKt.joinToString$default(CollectionsKt.dropLast(r110, 1), HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null);
        FLogger r115 = FLogger.f375446a;
        r115.d("FeishuDocLinkClassifier", "matchDocType: pathPrefix=" + r114 + ", normalizedDocTypes=" + this.f542588b);
        if (((ArrayList) this.f542588b).contains(r114) == false) goto L45;
        r115.d("FeishuDocLinkClassifier", "matchDocType: pathPrefix '" + r114 + "' matches docType");
        r102 = true;
        goto L46
    L45:
        r115.d("FeishuDocLinkClassifier", "matchDocType: no match for pathPrefix=" + r114);
        goto L46
    L17:
        if (StringsKt.endsWith$default(r101, "." + r105, false, 2, null) == true) goto L20;
        r106 = false;
    L23:
        r107 = false;
        goto L24
    L9:
        if (r103.isEmpty() == false) goto L11;
        goto L11
    }

    public b(List<String> r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "domains");
        Intrinsics.checkNotNullParameter(r101, "docTypes");
        this.f542587a = r100;
        List<String> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(StringsKt.trim((String) r104.next(), new char[]{'/'}));
        goto L4
    L6:
        this.f542588b = r103;
    }
}
