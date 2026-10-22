package cu5;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static String a(String r100) {
        String r101 = r100.toLowerCase();
        String[] r102 = r101.split("_");
        int r103 = 1;
        if (r102.length != 1) goto L5;
        return r101;
    L5:
        StringBuilder r104 = new StringBuilder();
        r104.append(r102[0]);
    L7:
        if (r103 >= r102.length) goto L10;
        char[] r105 = r102[r103].toCharArray();
        r105[0] = (char) (r105[0] - ' ');
        r104.append(String.valueOf(r105));
        r103 = r103 + 1;
        goto L7
    L10:
        return r104.toString();
    }
}
