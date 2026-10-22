package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/jedi/arch/JediPairEvent;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Lcom/bytedance/jedi/arch/Event;", "Lkotlin/Pair;", "value", "(Lkotlin/Pair;)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class JediPairEvent<A, B> extends Event<Pair<? extends A, ? extends B>> {
    public JediPairEvent(Pair<? extends A, ? extends B> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        super(r100);
    }
}
