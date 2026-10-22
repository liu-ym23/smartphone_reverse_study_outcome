package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Message;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements Consumer<z65.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f223911a;

    public v(w r100) {
        this.f223911a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(z65.a r210) throws Exception {
        int r100 = this.f223911a.f223914c.b(r210.f570483b);
        z65.d r101 = this.f223911a.f223914c;
        z65.b r102 = (z65.b) ListProtector.get(r101.f570505a, r100);
        boolean r103 = false;
        int r104 = -1;
        if (r100 > (-1)) goto L5;
    L7:
        String r110 = null;
        long r111 = 0;
        long r112 = 0;
        int r113 = 0;
    L8:
        z65.a r105 = new z65.a(r104, r110, r113, r111, r112);
        if (r104 == 4) goto L11;
        w r106 = this.f223911a;
        r106.getClass();
        r106.sendMessage(Message.obtain(r106, 10006, r105));
    L11:
        this.f223911a.f223913b.sP();
        w r107 = this.f223911a;
        a75.g r108 = r107.f223913b;
        if (((ArrayList) r107.f223915d).size() == 0) goto L14;
        r103 = true;
    L14:
        r108.eH(r103);
        w r109 = this.f223911a;
        r109.f223913b.e50(r109.f223915d);
        tt5.a.h("UpdateListTAG", "delete item " + r100);
        return;
    L5:
        if (r100 >= ((ArrayList) r101.f570505a).size()) goto L7;
        String r114 = r102.f570500g;
        int r115 = r102.f570498e;
        int r116 = r102.f570501h;
        long r117 = r102.f570496c;
        long r118 = r102.f570497d;
        ListProtector.remove(r101.f570505a, r100);
        tt5.a.h("UpdateListTAG", "remove key = " + r114 + " position " + r100);
        r110 = r114;
        r104 = r115;
        r113 = r116;
        r111 = r117;
        r112 = r118;
        goto L8
    }
}
