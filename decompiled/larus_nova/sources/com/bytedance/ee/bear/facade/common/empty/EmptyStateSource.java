package com.bytedance.ee.bear.facade.common.empty;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.net.CloudReqFun;
import go2.g;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes16.dex */
public class EmptyStateSource extends LiveData<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f226412a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f226413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f226414b;

        public a(Context r100) {
            this.f226414b = new b(0);
            this.f226413a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f226415a;

        public b(int r100) {
            this.f226415a = r100;
        }
    }

    public final void loading() {
        a r100 = this.f226412a;
        r100.getClass();
        tt5.a.b("EmptyStateSource", "next: loading ");
        tt5.a.b("EmptyStateSource", "next: loading ，isForce=false");
        int r101 = r100.f226414b.f226415a;
        if (r101 != 2) goto L5;
    L8:
        postValue(r100.f226414b);
        return;
    L5:
        if (r101 == 8) goto L7;
        r100.f226414b = new b(0);
        goto L8
    L7:
        r100.f226414b = new b(8);
        goto L8
    }

    @Override // androidx.lifecycle.LiveData
    public final void onActive() {
        setValue(this.f226412a.f226414b);
        super.onActive();
    }

    @Override // androidx.lifecycle.LiveData
    public final void onInactive() {
        super.onInactive();
    }

    public EmptyStateSource(Context r100) {
        this.f226412a = new a(r100);
    }

    public final void data(int r100) {
        a r101 = this.f226412a;
        r101.getClass();
        tt5.a.b("EmptyStateSource", "next: load data : " + r100);
        tt5.a.b("EmptyStateSource", "next: load data : " + r100 + " isForce=false");
        b r102 = r101.f226414b;
        if (r102.f226415a == 8) goto L9;
        if (r100 > 0) goto L7;
        r101.f226414b = new b(1);
    L8:
        r102 = r101.f226414b;
        goto L9
    L7:
        r101.f226414b = new b(2);
    L9:
        postValue(r102);
    }

    public final void fail(Throwable r100) {
        a r101 = this.f226412a;
        r101.getClass();
        tt5.a.e("EmptyStateSource", "next: error", r100, false);
        if (r100 != null) goto L5;
    L23:
        postValue(r101.f226414b);
        return;
    L5:
        if (r101.f226414b.f226415a != 2) goto L7;
    L16:
        rb5.b.a r102 = (rb5.b.a) com.bytedance.ee.bear.bizwidget.a.f216306a;
        if (r102.f536937a != null) goto L19;
        r102.f536937a = new g();
    L19:
        r102.f536937a.getClass();
        if (ax4.d.b(r100, 3) == false) goto L22;
        r101.f226414b = new b(5);
    L22:
        r101.f226414b.getClass();
        goto L23
    L7:
        if (fw4.d.b(r101.f226413a) != NetworkType.NETWORK_NO) goto L10;
        r101.f226414b = new b(4);
        goto L16
    L10:
        if ((r100 instanceof CloudReqFun.OkHttpReqException) == false) goto L12;
        boolean r103 = ((CloudReqFun.OkHttpReqException) r100).exception.equals(SocketTimeoutException.class.getName());
    L13:
        if (r103 == false) goto L15;
        r101.f226414b = new b(7);
        goto L16
    L15:
        r101.f226414b = new b(3);
        goto L16
    L12:
        r103 = r100 instanceof SocketTimeoutException;
        goto L13
    }
}
