package com.bytedance.kmp.livesdk.gift.platform.core.extra;

import com.bytedance.android.livesdk.gift.model.g0;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f252254a;

    public d(f r100) {
        this.f252254a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BehaviorSubject<List<g0>> r101 = this.f252254a.f252256a;
        r101.onNext((List) r100);
    }
}
