package com.xiaomi.push.service;

import com.xiaomi.push.fk;
import com.xiaomi.push.ft;
import com.xiaomi.push.fu;
import com.xiaomi.push.fw;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes41.dex */
public class i implements ft {
    public i() {
    }

    public void a() {
        fu.a().a("all", "xm:chat", this);
    }

    public static fk a(XmlPullParser r110) {
        if (r110.getEventType() == 2) goto L5;
        return null;
    L5:
        String r100 = r110.getName();
        String r101 = r110.getNamespace();
        if (r110.getAttributeCount() <= 0) goto L12;
        String[] r102 = new String[r110.getAttributeCount()];
        String[] r103 = new String[r110.getAttributeCount()];
        int r104 = 0;
    L9:
        if (r104 >= r110.getAttributeCount()) goto L11;
        r102[r104] = r110.getAttributeName(r104);
        r103[r104] = fw.b(r110.getAttributeValue(r104));
        r104 = r104 + 1;
        goto L9
    L11:
        String[] r105 = r102;
        String r106 = null;
        ArrayList r107 = null;
        String[] r108 = r103;
    L13:
        int r109 = r110.next();
        if (r109 == 3) goto L25;
        if (r109 == 4) goto L17;
        if (r109 != 2) goto L13;
        if (r107 != null) goto L21;
        r107 = new ArrayList();
    L21:
        fk r111 = a(r110);
        if (r111 == null) goto L13;
        r107.add(r111);
        goto L13
    L17:
        r106 = r110.getText().trim();
        goto L13
    L25:
        return new fk(r100, r101, r105, r108, r106, r107);
    L12:
        r105 = null;
        r108 = null;
        r106 = null;
        r107 = null;
        goto L13
    }

    public fk b(XmlPullParser r100) {
        int r101 = r100.getEventType();
    L4:
        if (r101 == 1) goto L7;
        if (r101 == 2) goto L7;
        r101 = r100.next();
    L7:
        if (r101 == 2) goto L9;
        return null;
    L9:
        return a(r100);
    }
}
