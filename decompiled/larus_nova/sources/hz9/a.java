package hz9;

import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f487718a = 0;

    static {
    }

    public a() {
    }

    public static String a(Message r100, String r101, boolean r102, String r103) {
        StringBuilder r104 = new StringBuilder();
        if (r100 == null) goto L5;
        String r105 = r100.getMessageId();
    L6:
        r104.append(r105);
        r104.append('_');
        r104.append(r101);
        r104.append('_');
        r104.append(r102);
        r104.append('_');
        r104.append(r103);
        return r104.toString();
    L5:
        r105 = null;
        goto L6
    }

    public static /* synthetic */ String b(Message r100, String r101, boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L6;
        r102 = false;
    L6:
        return a(r100, r101, r102, null);
    }
}
