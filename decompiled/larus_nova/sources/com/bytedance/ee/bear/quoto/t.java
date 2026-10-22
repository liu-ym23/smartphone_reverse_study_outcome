package com.bytedance.ee.bear.quoto;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes18.dex */
public interface t {
    boolean a(Throwable r100, Context r101);

    Flowable b();

    void c(Context r100, String r101, String r102, boolean r103, boolean r104, String r105);

    void d(Context r100, int r101);

    boolean e();

    void f(Context r100, SingleFileQuotaConfig r101, Long r102);

    boolean g(int r100);

    boolean h(int r100, Context r101, boolean r102);

    void i(FragmentActivity r100, String r101, String r102, boolean r103, String r104, View.OnClickListener r105);

    void j(FragmentActivity r100, FullQuotoConfig r101);

    boolean k(int r100);

    boolean l(int r100, Context r101);

    void m(FragmentActivity r100, DialogInterface.OnDismissListener r101);

    void n(Context r100, int r101, i55.a r102);

    boolean o(int r100);

    boolean p(Throwable r100, Context r101, boolean r102);

    boolean q(int r100);

    void r(FragmentActivity r100, DialogInterface.OnDismissListener r101);

    boolean s(int r100);
}
