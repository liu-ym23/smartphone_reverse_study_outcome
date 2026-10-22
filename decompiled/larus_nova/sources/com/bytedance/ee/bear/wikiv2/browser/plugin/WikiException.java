package com.bytedance.ee.bear.wikiv2.browser.plugin;

import android.content.Context;
import com.bytedance.ee.bear.contract.route.parcelable.WikiInfo;
import com.bytedance.ee.bear.document.fail.DocException;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class WikiException extends DocException {
    public WikiException(int r100) {
        super(r100, null);
    }

    public static boolean isNotFound(Throwable r100) {
        if ((r100 instanceof WikiException) == true) goto L5;
    L7:
        return false;
    L5:
        if (((WikiException) r100).getCode() != 920004002) goto L7;
        return true;
    }

    public WikiException(int r100, String r101) {
        super(r100, r101);
    }

    public static WikiInfo validate(Context r100, WikiInfo r101) throws WikiException {
        a(r100, r101, false);
        return r101;
    }

    public static WikiInfo validateObjInfo(Context r100, WikiInfo r101) throws WikiException {
        a(r100, r101, true);
        return r101;
    }

    public static void a(Context r100, WikiInfo r101, boolean r102) throws WikiException {
        if (r101 == null) goto L51;
        int r103 = r101.getCode();
        if (r103 != 3) goto L6;
        tt5.a.h("WikiException", "setwikiinfo code is 3, wiki token is wrong");
    L49:
        throw new WikiException(920004002, r100.getString(R.string.Doc_Wiki_PageRemovedText));
    L6:
        if (r103 == 4) goto L46;
        switch(r103) {
            case 920004002: goto L49;
            case 920004007: goto L46;
            case 920004012: goto L46;
            case 920004123: goto L11;
            default: goto L8;
        };
    L8:
        if (r102 == false) goto L12;
        boolean r104 = r101.isValidObjInfo();
    L13:
        if (r104 == false) goto L44;
        if (r101.getObjType() == (-1)) goto L42;
        int r105 = r101.getObjType();
        if (sbb.e.f541296g.f541317b != r105) goto L19;
    L37:
        boolean r106 = true;
    L38:
        if (r106 == true) goto L52;
        tt5.a.d("WikiException", "unsupported wiki type:" + r101);
        throw new WikiException(-100001, "Unsupported wiki type:" + r101);
    L52:
        return;
    L19:
        if (sbb.e.f541297h.f541317b == r105) goto L37;
        if (sbb.e.f541300k.f541317b != r105) goto L25;
        r106 = yp5.c.f();
        goto L38
    L25:
        if (sbb.e.f541298i.f541317b != r105) goto L28;
        r106 = yp5.c.d();
        goto L38
    L28:
        if (sbb.e.f541301l.f541317b == r105) goto L37;
        if (sbb.e.f541304o.f541317b == r105) goto L37;
        if (sbb.e.f541302m.f541317b != r105) goto L36;
        r106 = yp5.c.g();
        goto L38
    L36:
        r106 = false;
        goto L38
    L42:
        return;
    L44:
        throw new WikiException(r101.getCode());
    L12:
        r104 = r101.isValid();
        goto L13
    L11:
        throw new WikiException(-55);
    L46:
        throw new WikiException(-8010, "No wiki permission");
    L51:
        throw new WikiException(-8011, "Pull wiki token fail");
    }
}
