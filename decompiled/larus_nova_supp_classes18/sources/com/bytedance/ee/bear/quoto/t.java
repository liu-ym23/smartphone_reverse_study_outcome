package com.bytedance.ee.bear.quoto;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface t {
    boolean a(Throwable r1, Context r2);

    Flowable b();

    void c(Context r1, String r2, String r3, boolean r4, boolean r5, String r6);

    void d(Context r1, int r2);

    boolean e();

    void f(Context r1, SingleFileQuotaConfig r2, Long r3);

    boolean g(int r1);

    boolean h(int r1, Context r2, boolean r3);

    void i(FragmentActivity r1, String r2, String r3, boolean r4, String r5, View.OnClickListener r6);

    void j(FragmentActivity r1, FullQuotoConfig r2);

    boolean k(int r1);

    boolean l(int r1, Context r2);

    void m(FragmentActivity r1, DialogInterface.OnDismissListener r2);

    void n(Context r1, int r2, i55.a r3);

    boolean o(int r1);

    boolean p(Throwable r1, Context r2, boolean r3);

    boolean q(int r1);

    void r(FragmentActivity r1, DialogInterface.OnDismissListener r2);

    boolean s(int r1);
}
