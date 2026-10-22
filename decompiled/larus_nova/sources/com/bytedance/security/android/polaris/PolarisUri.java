package com.bytedance.security.android.polaris;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0007J\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0007J\u001e\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/security/android/polaris/PolarisUri;", "", "()V", "NOT_FOUND", "", "findPortSeparator", "authority", "", "getActualHost", "uri", "Landroid/net/Uri;", "isHostInAllowedList", "", "host", "allowList", "", "isUriInAllowList", "parseHost", "polaris_release"}, k = 1, mv = {1, 1, 15})
public final class PolarisUri {
    public static final PolarisUri INSTANCE = null;
    private static final int NOT_FOUND = -1;

    private PolarisUri() {
    }

    static {
        INSTANCE = new PolarisUri();
    }

    private final int findPortSeparator(String r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        int r101 = r100.length() - 1;
    L6:
        if (r101 < 0) goto L16;
        char r102 = r100.charAt(r101);
        if (':' == r102) goto L9;
        if (r102 < '0') goto L16;
        if (r102 > '9') goto L16;
        r101 = r101 - 1;
        goto L6
    L9:
        return r101;
    L16:
        return -1;
    }

    @JvmStatic
    public static final String getActualHost(Uri r100) {
        if (r100.isHierarchical() == false) goto L5;
        Uri r101 = UriProtector.parse(r100.toString());
    L6:
        String r102 = r101.getHost();
        if (r102 == null) goto L29;
        String r103 = r101.getEncodedAuthority();
        if (r103 == null) goto L29;
        int r104 = 0;
        int r105 = 0;
    L11:
        boolean r106 = true;
        if (r104 >= r103.length()) goto L20;
        if (r103.charAt(r104) == '@') goto L17;
        r106 = false;
    L17:
        if (r106 == false) goto L19;
        r105 = r105 + 1;
    L19:
        r104 = r104 + 1;
        goto L11
    L20:
        if (r105 <= 1) goto L26;
        r102 = INSTANCE.parseHost(r100);
        if (r102 != null) goto L26;
        return null;
    L26:
        if (StringsKt.contains$default(r102, '\\', false, 2, null) == true) goto L28;
        return r102;
    L28:
        return StringsKt.substringBefore$default(r102, '\\', null, 2, null);
    L29:
        return null;
    L5:
        r101 = r100;
        goto L6
    }

    private final String parseHost(Uri r100) {
        String r101 = r100.getEncodedAuthority();
        if (r101 == null) goto L10;
        int r102 = StringsKt.lastIndexOf$default(r101, '@', 0, false, 6, null);
        int r103 = findPortSeparator(r101);
        if (r103 != (-1)) goto L7;
        String r104 = r101.substring(r102 + 1);
    L9:
        return Uri.decode(r104);
    L7:
        r104 = r101.substring(r102 + 1, r103);
        goto L9
    L10:
        return null;
    }

    @JvmStatic
    public static final String getActualHost(String r100) {
        return getActualHost(UriProtector.parse(r100));
    }

    @JvmStatic
    public static final boolean isHostInAllowedList(String r100, List<String> r101) {
        Iterator<String> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L28;
        String r103 = r102.next();
        if (r103.length() != 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L4;
        if (Intrinsics.areEqual(r103, r100) == true) goto L13;
        if (StringsKt.startsWith$default(r103, ".", false, 2, null) == true) goto L16;
        if (StringsKt.endsWith$default(r100, "." + r103, false, 2, null) == false) goto L4;
        return true;
    L16:
        if (r103 == null) goto L24;
        if (Intrinsics.areEqual(r103.substring(1), r100) == true) goto L19;
        if (StringsKt.endsWith$default(r100, r103, false, 2, null) == false) goto L4;
        return true;
    L19:
        return true;
    L24:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L13:
        return true;
    L8:
        r104 = false;
        goto L9
    L28:
        return false;
    }

    @JvmStatic
    public static final boolean isUriInAllowList(Uri r100, List<String> r101) {
        boolean r102 = true;
        if ((!Intrinsics.areEqual(r100.getScheme(), "http")) == true) goto L5;
    L7:
        String r103 = getActualHost(r100);
        if (r103 != null) goto L10;
    L13:
        if (r102 == false) goto L16;
        return false;
    L16:
        return isHostInAllowedList(r103, r101);
    L10:
        if (r103.length() == 0) goto L13;
        r102 = false;
        goto L13
    L5:
        if ((!Intrinsics.areEqual(r100.getScheme(), "https")) == false) goto L7;
        return false;
    }

    @JvmStatic
    public static final boolean isUriInAllowList(String r100, List<String> r101) {
        return isUriInAllowList(UriProtector.parse(r100), r101);
    }
}
