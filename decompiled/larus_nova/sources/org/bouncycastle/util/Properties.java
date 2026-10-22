package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.AccessControlException;
import java.security.AccessController;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes42.dex */
public class Properties {
    private static final ThreadLocal threadProperties = null;

    static {
        threadProperties = new ThreadLocal();
    }

    private Properties() {
    }

    public static BigInteger asBigInteger(String r100) {
        String r101 = getPropertyValue(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        return new BigInteger(r101);
    }

    public static Set<String> asKeySet(String r100) {
        HashSet r101 = new HashSet();
        String r102 = getPropertyValue(r100);
        if (r102 == null) goto L9;
        StringTokenizer r103 = new StringTokenizer(r102, ",");
    L6:
        if (r103.hasMoreElements() == false) goto L9;
        r101.add(Strings.toLowerCase(r103.nextToken()).trim());
    L9:
        return Collections.unmodifiableSet(r101);
    }

    public static String getPropertyValue(final String r100) {
        String r101 = (String) AccessController.doPrivileged(new AnonymousClass1(r100));
        if (r101 == null) goto L5;
        return r101;
    L5:
        Map r102 = (Map) threadProperties.get();
        if (r102 == null) goto L11;
        String r103 = (String) r102.get(r100);
        if (r103 == null) goto L11;
        return r103;
    L11:
        return (String) AccessController.doPrivileged(new AnonymousClass2(r100));
    }

    public static boolean isOverrideSet(String r100) {
        return isSetTrue(getPropertyValue(r100));
    L4:
        return false;
    }

    public static boolean isOverrideSetTo(String r100, boolean r101) {
        String r102 = getPropertyValue(r100);     // Catch: AccessControlException -> L8
        if (r101 == false) goto L7;
        return isSetTrue(r102);
    L7:
        return isSetFalse(r102);
    L8:
        return false;
    }

    private static boolean isSetFalse(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() == 5) goto L8;
        return false;
    L8:
        if (r100.charAt(0) == 'f') goto L12;
        if (r100.charAt(0) == 'F') goto L12;
        return false;
    L12:
        if (r100.charAt(1) == 'a') goto L16;
        if (r100.charAt(1) == 'A') goto L16;
        return false;
    L16:
        if (r100.charAt(2) == 'l') goto L20;
        if (r100.charAt(2) == 'L') goto L20;
        return false;
    L20:
        if (r100.charAt(3) == 's') goto L24;
        if (r100.charAt(3) == 'S') goto L24;
        return false;
    L24:
        if (r100.charAt(4) != 'e') goto L26;
    L27:
        return true;
    L26:
        if (r100.charAt(4) == 'E') goto L27;
        return false;
    }

    private static boolean isSetTrue(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() == 4) goto L8;
        return false;
    L8:
        if (r100.charAt(0) == 't') goto L12;
        if (r100.charAt(0) == 'T') goto L12;
        return false;
    L12:
        if (r100.charAt(1) == 'r') goto L16;
        if (r100.charAt(1) == 'R') goto L16;
        return false;
    L16:
        if (r100.charAt(2) == 'u') goto L20;
        if (r100.charAt(2) == 'U') goto L20;
        return false;
    L20:
        if (r100.charAt(3) != 'e') goto L22;
    L23:
        return true;
    L22:
        if (r100.charAt(3) == 'E') goto L23;
        return false;
    }

    public static boolean removeThreadOverride(String r100) {
        ThreadLocal r101 = threadProperties;
        Map r102 = (Map) r101.get();
        if (r102 == null) goto L11;
        String r103 = (String) r102.remove(r100);
        if (r103 != null) goto L7;
        return false;
    L7:
        if (r102.isEmpty() == false) goto L10;
        r101.remove();
    L10:
        return "true".equals(Strings.toLowerCase(r103));
    L11:
        return false;
    }

    public static boolean setThreadOverride(String r100, boolean r101) {
        boolean r102 = isOverrideSet(r100);
        ThreadLocal r103 = threadProperties;
        Map r104 = (Map) r103.get();
        if (r104 != null) goto L5;
        r104 = new HashMap();
        r103.set(r104);
    L5:
        if (r101 == false) goto L7;
        String r105 = "true";
    L8:
        r104.put(r100, r105);
        return r102;
    L7:
        r105 = "false";
        goto L8
    }
}
