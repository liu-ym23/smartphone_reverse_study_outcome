package wo5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final boolean a(b r4, String r5) {
        if (r4 != null) goto L10;
        return false;
    L10:
        boolean r6 = r4.b.isEnable(r5);     // Catch: Exception -> L7
        tt5.a.h("DocUserComponentAbilityExtensions", "isEnable: " + r5 + " = " + r6);     // Catch: Exception -> L7
        return r6;
    L7:
        e = move-exception;
        tt5.a.d("DocUserComponentAbilityExtensions", "isEnable fail: " + e);
        return false;
    }
}
