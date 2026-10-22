package com.bytedance.ee.bear.widget;

import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderResultList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q implements com.bytedance.ee.bear.atfinder.d {
    public final com.bytedance.ee.bear.atfinder.c a;
    public final kn4.g.a b;
    public final Runnable c;

    public final void b() {
        this.c.run();
    }

    public final void c(String r1) {
        this.b.c();
    }

    public final void d(String r1) {
        this.b.b();
    }

    public final void a(AtFinderResultList r30, boolean r31) {
        tt5.a.b("AtFinderDataCallbackImpl", "onSelectData: ");
        this.a.a();
        List r1 = r30.getData().getResult_list();
        if (r1.size() > 0) goto L5;
        return;
    L5:
        AtObject r2 = (AtObject) ListProtector.get(r1, 0);
        String r3 = r2.getContent();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        String r10 = r3;
        int r5 = r10.length();
        int r6 = r2.getType();
        int r7 = r2.getSub_type();
        String r8 = r2.getToken();
        String r9 = r2.getUrl();
        String r11 = r2.getName();
        String r12 = r2.getEn_name();
        String r13 = r2.getCn_name();
        r2.getDisplay_name();
        HashMap r14 = r2.getI18n_user_name();
        r2.getSequenceNum();
        int r18 = r2.getIcon_type();
        String r17 = r2.getIcon_key();
        bo4.a r4 = new bo4.a(0, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2.getIconInfo(), r2.getIcon_fsunit(), r17, r18, false, null, r2.isNot_notify(), r2.isExternal(), r2.getUnion_id(), r2.getDepartment(), null, null, r2.getAvatar_url(), r2.getUserType());
        kn4.g.a r15 = this.b;
        boolean r16 = this.a.l;
        r15.a(r4);
    }

    public q(com.bytedance.ee.bear.atfinder.c r1, kn4.g.a r2, Runnable r3) {
        this.b = r2;
        this.a = r1;
        this.c = r3;
    }
}
