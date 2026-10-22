package com.bytedance.ies.ezpermission.core.task;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.ezpermission.core.e;
import com.bytedance.ies.ezpermission.core.result.ResultWrapper;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    void a(c r100);

    e b();

    ResultWrapper c();

    Object d(Continuation<? super Unit> r100);

    void e(ResultWrapper r100);

    boolean f();

    c g();

    Activity getActivity();

    Context getContext();
}
