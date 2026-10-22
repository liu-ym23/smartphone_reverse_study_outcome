package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.fail.DocException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiException extends DocException {
    public WikiException(int r2) {
        super(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isNotFound(Throwable r1) {
        if ((r1 instanceof WikiException) == true) goto L5;
    L7:
        return false;
    L5:
        if (((WikiException) r1).getCode() != 920004002) goto L7;
        return true;
    }

    public WikiException(int r1, String r2) {
        super(r1, r2);
    }

    public static WikiInfo validate(Context r1, WikiInfo r2) throws WikiException {
        a(r1, r2, false);
        return r2;
    }

    public static WikiInfo validateObjInfo(Context r1, WikiInfo r2) throws WikiException {
        a(r1, r2, true);
        return r2;
    }

    public static void a(Context r3, WikiInfo r4, boolean r5) throws WikiException {
        if (r4 == null) goto L51;
        int r0 = r4.getCode();
        if (r0 != 3) goto L6;
        tt5.a.h("WikiException", "setwikiinfo code is 3, wiki token is wrong");
    L49:
        throw new WikiException(920004002, r3.getString(2131888338));
    L6:
        if (r0 == 4) goto L46;
        switch(r0) {
            case 920004002: goto L49;
            case 920004007: goto L46;
            case 920004012: goto L46;
            case 920004123: goto L11;
            default: goto L8;
        };
    L8:
        if (r5 == false) goto L12;
        boolean r6 = r4.isValidObjInfo();
    L13:
        if (r6 == false) goto L44;
        if (r4.getObjType() == (-1)) goto L42;
        int r7 = r4.getObjType();
        if (sbb.e.g.b != r7) goto L19;
    L37:
        boolean r8 = true;
    L38:
        if (r8 == true) goto L52;
        tt5.a.d("WikiException", "unsupported wiki type:" + r4);
        throw new WikiException(-100001, "Unsupported wiki type:" + r4);
    L52:
        return;
    L19:
        if (sbb.e.h.b == r7) goto L37;
        if (sbb.e.k.b != r7) goto L25;
        r8 = yp5.c.f();
        goto L38
    L25:
        if (sbb.e.i.b != r7) goto L28;
        r8 = yp5.c.d();
        goto L38
    L28:
        if (sbb.e.l.b == r7) goto L37;
        if (sbb.e.o.b == r7) goto L37;
        if (sbb.e.m.b != r7) goto L36;
        r8 = yp5.c.g();
        goto L38
    L36:
        r8 = false;
        goto L38
    L42:
        return;
    L44:
        throw new WikiException(r4.getCode());
    L12:
        r6 = r4.isValid();
        goto L13
    L11:
        throw new WikiException(-55);
    L46:
        throw new WikiException(-8010, "No wiki permission");
    L51:
        throw new WikiException(-8011, "Pull wiki token fail");
    }
}
