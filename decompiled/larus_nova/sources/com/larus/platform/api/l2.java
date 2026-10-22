package com.larus.platform.api;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.larus.platform.model.ecommerce.ECNotifyBinderDialogType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes31.dex */
public interface l2 {
    void a(String r100, String r101, String r102);

    void b(String r100, String r101);

    boolean c(Context r100, Uri r101);

    void d(FragmentActivity r100, Integer r101, String r102, String r103);

    void e(uq9.d r100, Function3<? super String, ? super String, ? super ECNotifyBinderDialogType, Unit> r101, Function1<? super uq9.e, Unit> r102);

    void f(String r100, uq9.l r101);

    int getVersion();

    boolean h(Context r100, String r101);

    boolean i();
}
