package com.bytedance.ee.bear.widget;

import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderResultList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class q implements com.bytedance.ee.bear.atfinder.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.atfinder.c f239950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kn4.g.a f239951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f239952c;

    @Override // com.bytedance.ee.bear.atfinder.d
    public final void b() {
        this.f239952c.run();
    }

    @Override // com.bytedance.ee.bear.atfinder.d
    public final void c(String r100) {
        this.f239951b.c();
    }

    @Override // com.bytedance.ee.bear.atfinder.d
    public final void d(String r100) {
        this.f239951b.b();
    }

    @Override // com.bytedance.ee.bear.atfinder.d
    public final void a(AtFinderResultList r310, boolean r311) {
        tt5.a.b("AtFinderDataCallbackImpl", "onSelectData: ");
        this.f239950a.a();
        List<AtObject> r100 = r310.getData().getResult_list();
        if (r100.size() > 0) goto L5;
        return;
    L5:
        AtObject r101 = (AtObject) ListProtector.get(r100, 0);
        String r102 = r101.getContent();
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        String r110 = r102;
        int r103 = r110.length();
        int r104 = r101.getType();
        int r105 = r101.getSub_type();
        String r106 = r101.getToken();
        String r107 = r101.getUrl();
        String r111 = r101.getName();
        String r112 = r101.getEn_name();
        String r113 = r101.getCn_name();
        r101.getDisplay_name();
        HashMap<String, String> r114 = r101.getI18n_user_name();
        r101.getSequenceNum();
        int r115 = r101.getIcon_type();
        String r116 = r101.getIcon_key();
        bo4.a r108 = new bo4.a(0, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r101.getIconInfo(), r101.getIcon_fsunit(), r116, r115, false, null, r101.isNot_notify(), r101.isExternal(), r101.getUnion_id(), r101.getDepartment(), null, null, r101.getAvatar_url(), r101.getUserType());
        kn4.g.a r109 = this.f239951b;
        boolean r117 = this.f239950a.f206359l;
        r109.a(r108);
    }

    public q(com.bytedance.ee.bear.atfinder.c r100, kn4.g.a r101, Runnable r102) {
        this.f239951b = r101;
        this.f239950a = r100;
        this.f239952c = r102;
    }
}
