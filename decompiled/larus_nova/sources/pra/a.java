package pra;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements ora.a {
    public a() {
    }

    @Override // ora.a
    public final String a(Object r110) {
        String[] r111 = (String[]) r110;
        if (r111 != null) goto L5;
        return "";
    L5:
        if (r111.length == 0) goto L39;
        String[] r100 = new String[r111.length];
        int r101 = r111.length;
        int r102 = 0;
        int r103 = 0;
    L8:
        if (r102 >= r101) goto L13;
        String r104 = r111[r102];
        if (r104 == null) goto L12;
        r100[r103] = r104;
        r103 = r103 + 1;
    L12:
        r102 = r102 + 1;
        goto L8
    L13:
        if (r103 == 0) goto L40;
        StringBuilder r112 = new StringBuilder("╔═══════════════════════════════════════════════════════════════════════════════════════════════════\n");
        int r105 = 0;
    L16:
        if (r105 >= r103) goto L28;
        String r106 = r100[r105];
        StringBuilder r107 = new StringBuilder(r106.length() + 10);
        String[] r108 = r106.split("\n");
        int r109 = r108.length;
        int r113 = 0;
    L18:
        if (r113 >= r109) goto L22;
        if (r113 == 0) goto L21;
        r107.append("\n");
    L21:
        String r114 = r108[r113];
        r107.append(9553);
        r107.append(r114);
        r113 = r113 + 1;
        goto L18
    L22:
        r112.append(r107.toString());
        if (r105 == (r103 - 1)) goto L25;
        r112.append("\n╟───────────────────────────────────────────────────────────────────────────────────────────────────\n");
    L26:
        r105 = r105 + 1;
        goto L16
    L25:
        r112.append("\n╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
        goto L26
    L28:
        return r112.toString();
    L40:
        return "";
    L39:
        return "";
    }
}
