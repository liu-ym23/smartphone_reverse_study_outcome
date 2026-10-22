package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class s<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s<T> f426108a = null;

    static {
        f426108a = new s();
    }

    public s() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Map<String, MessageInfo>> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        r100.onNext(MapsKt.emptyMap());
        r100.onComplete();
    }
}
