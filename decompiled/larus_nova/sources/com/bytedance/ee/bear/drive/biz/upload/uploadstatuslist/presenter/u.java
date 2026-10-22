package com.bytedance.ee.bear.drive.biz.upload.uploadstatuslist.presenter;

import android.os.Message;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class u implements Consumer<List<z65.b>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f223910a;

    public u(w r100) {
        this.f223910a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(List<z65.b> r100) throws Exception {
        List<z65.b> r101 = r100;
        w r102 = this.f223910a;
        ((ArrayList) r102.f223916e).clear();
        ((ArrayList) r102.f223916e).addAll(r101);
        w r103 = this.f223910a;
        r103.getClass();
        r103.sendMessage(Message.obtain(r103, 10005));
        r101.clear();
        this.f223910a.f223913b.sP();
        this.f223910a.f223913b.eH(false);
        this.f223910a.f223913b.e50(r101);
        tt5.a.h("UpdateListTAG", "cancel all upload");
    }
}
