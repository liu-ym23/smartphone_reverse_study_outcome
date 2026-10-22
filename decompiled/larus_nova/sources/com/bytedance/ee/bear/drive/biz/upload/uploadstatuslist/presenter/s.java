package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Message;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes16.dex */
public final class s implements Consumer<z65.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z65.a f223907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f223908b;

    @Override // io.reactivex.functions.Consumer
    public final void accept(z65.a r100) throws Exception {
        z65.a r101 = r100;
        tt5.a.h("UpdateListTAG", "update status key = " + r101.f570483b);
        w r102 = this.f223908b;
        w.a(r102, r102.f223915d);
        z65.d r103 = this.f223908b.f223914c;
        int r104 = 0;
    L4:
        if (r104 >= ((ArrayList) r103.f570505a).size()) goto L12;
        z65.b r105 = (z65.b) ListProtector.get(r103.f570505a, r104);
        if (r105.f570500g.equals(r101.f570483b) == true) goto L7;
        r104 = r104 + 1;
        goto L4
    L7:
        String r106 = r101.f570487f;
        if (TextUtils.isEmpty(r106) == true) goto L10;
        r105.f570504k = r106;
        goto L12
    L10:
        r105.f570498e = r101.f570482a;
        r105.f570501h = r101.f570486e;
        r105.f570496c = r101.f570484c;
        r105.f570497d = r101.f570485d;
    L12:
        z65.d r107 = this.f223908b.f223914c;
        Collections.sort(r107.f570505a, r107.f570506b);
        this.f223908b.f223913b.sP();
        this.f223908b.f223913b.aw(r101.f570487f);
        if (this.f223907a.f570482a != 4) goto L18;
        tt5.a.h("UpdateListTAG", "dispatch delete message " + r101.f570483b);
        w r108 = this.f223908b;
        r108.sendMessageDelayed(Message.obtain(r108, 10002, r101), r108.f223918g);
        return;
    }

    public s(w r100, z65.a r101) {
        this.f223908b = r100;
        this.f223907a = r101;
    }
}
