package n4a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f517363b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f517364c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f517365d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f517366e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f517367f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f517368g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f517369a;

    static {
        f517363b = f5.o("SRFZHZUVZT3BOa0ZiemZRQQ");
        f517364c = f5.o("FbGJzX3Nkaw");
        f517365d = f5.o("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
        f517366e = f5.o("FQU5EU0RLMTA");
        f517367f = f5.o("FMTAw");
        f517368g = false;
    }

    public i() {
        this.f517369a = "";
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f517369a) == false) goto L5;
        String r100 = f5.d(y4.e("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA"));
        StringBuffer r101 = new StringBuffer();
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r103 >= r100.length()) goto L10;
        r101.append((char) (r100.charAt(r103) - (r103 % 48)));
        r103 = r103 + 1;
        goto L8
    L10:
        String r104 = r101.toString();
        StringBuffer r105 = new StringBuffer();
    L12:
        if (r102 >= (r104.length() / 2)) goto L14;
        r105.append((char) ((r104.charAt(r102) + r104.charAt((r104.length() - 1) - r102)) / 2));
        r102 = r102 + 1;
        goto L12
    L14:
        String r106 = r105.toString();
        this.f517369a = r106;
        return r106;
    L5:
        return this.f517369a;
    }
}
