package sz9;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import zo8.e;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    public static final String a(b r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        zo8.b r102 = r100.f544079c;
    L6:
        if (r102 == null) goto L8;
        String r103 = qz9.a.a(r100.f544079c);
    L20:
        StringBuilder r104 = new StringBuilder();
        if (r100 == null) goto L25;
        Message r105 = r100.f544077a;
        if (r105 == null) goto L25;
        r101 = r105.getMessageId();
    L25:
        r104.append(r101);
        r104.append('_');
        r104.append(r103);
        String r106 = r104.toString();
        FLogger.f375446a.i("CreationGalleryData", "generateCreationKey: " + r106);
        return r106;
    L8:
        boolean r107 = false;
        if (r100 != null) goto L11;
    L13:
        if (r107 == false) goto L19;
        e r108 = r100.f544080d;
        if (r108 == null) goto L17;
        String r109 = r108.f573154k;
    L18:
        r103 = String.valueOf(r109);
        goto L20
    L17:
        r109 = null;
        goto L18
    L19:
        r103 = "0";
        goto L20
    L11:
        if (r100.f544084h != true) goto L13;
        r107 = true;
        goto L13
    L5:
        r102 = null;
        goto L6
    }
}
