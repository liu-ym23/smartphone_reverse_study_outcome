package ura;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements ora.a {
    public a() {
    }

    @Override // ora.a
    public final String a(Object r100) {
        StackTraceElement[] r101 = (StackTraceElement[]) r100;
        StringBuilder r102 = new StringBuilder(256);
        if (r101 != null) goto L5;
    L21:
        return null;
    L5:
        if (r101.length == 0) goto L21;
        int r103 = 0;
        if (r101.length == 1) goto L26;
        int r104 = r101.length;
    L11:
        if (r103 >= r104) goto L27;
        if (r103 != 0) goto L16;
        r102.append("\n");
    L16:
        if (r103 == (r104 - 1)) goto L18;
        r102.append("\t├ ");
        r102.append(r101[r103].toString());
        r102.append("\n");
    L19:
        r103 = r103 + 1;
        goto L11
    L18:
        r102.append("\t└ ");
        r102.append(r101[r103].toString());
        goto L19
    L27:
        return r102.toString();
    L26:
        return "\t─ " + r101[0].toString();
    }
}
