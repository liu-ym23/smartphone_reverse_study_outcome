package com.bytedance.kmp.livesdk.gift.platform.core.extra;

import com.byted.cast.common.TeaEventTrack;
import io.reactivex.functions.BiFunction;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes19.dex */
public final class b<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f252248a = null;

    static {
        f252248a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        List r102 = (List) r100;
        Sequence r103 = (Sequence) r101;
        Intrinsics.checkNotNullParameter(r102, "list");
        Intrinsics.checkNotNullParameter(r103, TeaEventTrack.ACTION_DRAMA_NEXT);
        CollectionsKt.addAll(r102, r103);
        return r102;
    }
}
