package com.bytedance.ee.bear.contract.route.parcelable;

import android.content.Context;
import androidx.fragment.app.Fragment;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes16.dex */
public interface e {
    Disposable a(Fragment r100, Context r101, String r102, String r103, Function0<Unit> r104, Function0<Unit> r105);

    Disposable b(String r100, String r101, Function1<? super Boolean, Unit> r102);
}
