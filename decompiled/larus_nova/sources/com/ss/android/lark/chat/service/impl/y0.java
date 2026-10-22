package com.ss.android.lark.chat.service.impl;

import com.ss.android.lark.log.Log;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class y0 {
    public static final Disposable a(String r100, String r101, Function0<? extends Disposable> r102) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        Intrinsics.checkNotNullParameter(r101, "currentUserId");
        Intrinsics.checkNotNullParameter(r102, "observePushBlock");
        if (Intrinsics.areEqual(r101, "absent_user") == false) goto L6;
        Log.i(r100, "currentUserId is ABSENT_USER_ID, do not really call observePush");
        Disposable r103 = Disposables.empty();
        Intrinsics.checkNotNull(r103);
        return r103;
    L6:
        return r102.invoke();
    }
}
