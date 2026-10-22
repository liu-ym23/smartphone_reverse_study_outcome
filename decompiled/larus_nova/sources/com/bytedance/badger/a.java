package com.bytedance.badger;

import android.content.Context;
import com.bytedance.badger.network.z;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public interface a {
    Function0<z> a();

    Function0<Boolean> b();

    Function0<String> c();

    Function0<Boolean> d();

    int getAppId();

    Context getContext();

    z64.a getExtraParams();

    com.ss.android.badger.a getLogger();

    com.ss.android.badger.b getNetRequestInterface();

    Pair<String, String> getRequestTagHeader();
}
