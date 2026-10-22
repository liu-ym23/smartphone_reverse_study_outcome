package com.larus.office.base.component.permission;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes29.dex */
public interface c {
    int C3();

    int J7();

    Object V3(Context r100, Continuation<? super Fragment> r101);

    b X2();

    Fragment d5();

    void d7(Function0<Unit> r100);

    Context getHostContext();

    String getToken();

    void x5(Fragment r100);

    FragmentManager y1();
}
