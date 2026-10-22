package qab;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f532280a = 0;

    static {
    }

    public static String a(String r100, String r101, String... r102) {
        StringBuilder r103 = new StringBuilder("{\"module\":\"todo\", \"context_id\":\"");
        r103.append(r100);
        r103.append("\", \"api_name\":\"GetParsedRruleTextRequest\", \"api_opt\":\"");
        r103.append(r101);
        r103.append("\"");
        if (r102 == null) goto L8;
        int r104 = 0;
    L6:
        if (r104 >= (r102.length - 1)) goto L8;
        r103.append(", \"");
        int r105 = r104 + 1;
        r103.append(r102[r104]);
        r103.append("\":\"");
        r104 = r105 + 1;
        r103.append(r102[r105]);
        r103.append("\"");
    L8:
        r103.append(i.f25855d);
        return r103.toString();
    }
}
