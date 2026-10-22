package com.bytedance.ee.bear.list.recent;

import android.content.DialogInterface;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: classes18.dex */
public final class b1 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1.a f229264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Document f229265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f229266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f229267d;

    public b1(a1.a r100, Document r101, String r102) {
        this.f229264a = r100;
        this.f229265b = r101;
        this.f229266c = r102;
        this.f229267d = "recent";
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r110) {
        this.f229264a.c2(this.f229265b);
        lc5.f.a r101 = lc5.f.f508440a;
        String r102 = this.f229266c;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r103 = r102;
        String r104 = this.f229267d;
        Document r105 = this.f229265b;
        r101.S(new lc5.v(r103, r104, r105.f227873d, r105.getType(), this.f229265b.F, "remove", "ccm_space_home_page_view"));
    }
}
