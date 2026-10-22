package com.bytedance.ee.bear.contract.route.parcelable;

import android.content.Context;
import androidx.fragment.app.Fragment;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface e {
    Disposable a(Fragment r1, Context r2, String r3, String r4, Function0<Unit> r5, Function0<Unit> r6);

    Disposable b(String r1, String r2, Function1<? super Boolean, Unit> r3);
}
