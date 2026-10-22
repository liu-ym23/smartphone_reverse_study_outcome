package com.bytedance.ee.bear.quoto;

import com.ss.android.lark.search.dto.UserGroupScene;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class p implements ov4.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f236424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f236425b;

    public /* synthetic */ p(s r100, boolean r101) {
        this.f236424a = r100;
        this.f236425b = r101;
    }

    @Override // ov4.b.a
    public final void a(String r110) {
        s r100 = this.f236424a;
        boolean r101 = this.f236425b;
        r100.getClass();
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.a(com.bytedance.ee.bear.docshost.k.class)).e(r110, "");
        boolean r102 = r100.f236439m;
        com.bytedance.ee.bear.contract.d r103 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        boolean r104 = r100.f236432f;
        boolean r105 = r100.f236433g;
        boolean r106 = r100.f236431e;
        if (r101 == false) goto L5;
        String r111 = UserGroupScene.DEFAULT_NAME_SPACE;
    L6:
        c.a(r102, r103, r104, r105, r106, r111, "im_chat_main_view");
        return;
    L5:
        r111 = "owner";
        goto L6
    }
}
