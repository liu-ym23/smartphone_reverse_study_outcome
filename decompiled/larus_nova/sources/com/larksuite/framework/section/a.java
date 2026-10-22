package com.larksuite.framework.section;

import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.base.fragment.BaseFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes24.dex */
public interface a {
    BaseFragment f();

    void g(Function3<? super Integer, ? super Integer, ? super Intent, Unit> r100);

    Context provideContext();
}
