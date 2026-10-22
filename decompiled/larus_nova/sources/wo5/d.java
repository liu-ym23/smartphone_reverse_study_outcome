package wo5;

/* JADX INFO: loaded from: classes18.dex */
public final class d {
    public static final boolean a(b r100, String r101) {
        if (r100 != null) goto L10;
        return false;
    L10:
        boolean r102 = r100.f560523b.isEnable(r101);     // Catch: Exception -> L7
        tt5.a.h("DocUserComponentAbilityExtensions", "isEnable: " + r101 + " = " + r102);     // Catch: Exception -> L7
        return r102;
    L7:
        e = move-exception;
        tt5.a.d("DocUserComponentAbilityExtensions", "isEnable fail: " + e);
        return false;
    }
}
