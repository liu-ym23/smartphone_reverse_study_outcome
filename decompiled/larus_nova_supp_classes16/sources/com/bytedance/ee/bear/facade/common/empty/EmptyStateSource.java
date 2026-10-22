package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.net.CloudReqFun;
import go2.g;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class EmptyStateSource extends LiveData<b> {
    public final a a;

    public static class a {
        public final Context a;
        public b b;

        public a(Context r3) {
            this.b = new b(0);
            this.a = r3;
        }
    }

    public static class b {
        public final int a;

        public b(int r1) {
            this.a = r1;
        }
    }

    public final void loading() {
        a r0 = this.a;
        r0.getClass();
        tt5.a.b("EmptyStateSource", "next: loading ");
        tt5.a.b("EmptyStateSource", "next: loading ，isForce=false");
        int r1 = r0.b.a;
        if (r1 != 2) goto L5;
    L8:
        postValue(r0.b);
        return;
    L5:
        if (r1 == 8) goto L7;
        r0.b = new b(0);
        goto L8
    L7:
        r0.b = new b(8);
        goto L8
    }

    public final void onActive() {
        setValue(this.a.b);
        super.onActive();
    }

    public final void onInactive() {
        super.onInactive();
    }

    public EmptyStateSource(Context r2) {
        this.a = new a(r2);
    }

    public final void data(int r5) {
        a r0 = this.a;
        r0.getClass();
        tt5.a.b("EmptyStateSource", "next: load data : " + r5);
        tt5.a.b("EmptyStateSource", "next: load data : " + r5 + " isForce=false");
        b r1 = r0.b;
        if (r1.a == 8) goto L9;
        if (r5 > 0) goto L7;
        r0.b = new b(1);
    L8:
        r1 = r0.b;
        goto L9
    L7:
        r0.b = new b(2);
    L9:
        postValue(r1);
    }

    public final void fail(Throwable r5) {
        a r0 = this.a;
        r0.getClass();
        tt5.a.e("EmptyStateSource", "next: error", r5, false);
        if (r5 != null) goto L5;
    L23:
        postValue(r0.b);
        return;
    L5:
        if (r0.b.a != 2) goto L7;
    L16:
        rb5.b.a r1 = (rb5.b.a) com.bytedance.ee.bear.bizwidget.a.a;
        if (r1.a != null) goto L19;
        r1.a = new g();
    L19:
        r1.a.getClass();
        if (ax4.d.b(r5, 3) == false) goto L22;
        r0.b = new b(5);
    L22:
        r0.b.getClass();
        goto L23
    L7:
        if (fw4.d.b(r0.a) != NetworkType.NETWORK_NO) goto L10;
        r0.b = new b(4);
        goto L16
    L10:
        if ((r5 instanceof CloudReqFun.OkHttpReqException) == false) goto L12;
        boolean r2 = ((CloudReqFun.OkHttpReqException) r5).exception.equals(SocketTimeoutException.class.getName());
    L13:
        if (r2 == false) goto L15;
        r0.b = new b(7);
        goto L16
    L15:
        r0.b = new b(3);
        goto L16
    L12:
        r2 = r5 instanceof SocketTimeoutException;
        goto L13
    }
}
