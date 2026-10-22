package com.bytedance.ee.bear.list.office.longpress;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f229092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.more.office.c f229093b;

    public y(Context r100, com.bytedance.ee.bear.more.office.c r101) {
        this.f229092a = r100;
        this.f229093b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Context r102 = this.f229092a;
        Toast.showText(r102, r102.getString(R.string.Doc_List_MoveFailedRetry));
        b0 r103 = b0.f228938a;
        String r104 = this.f229093b.f234687a;
        r103.getClass();
        b0.h(r104);
    }
}
