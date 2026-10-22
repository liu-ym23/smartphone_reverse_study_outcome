package com.bytedance.jedi.arch;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B\u001f\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/jedi/arch/JediTripeEvent;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "Lcom/bytedance/jedi/arch/Event;", "Lkotlin/Triple;", "value", "(Lkotlin/Triple;)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class JediTripeEvent<A, B, C> extends Event<Triple<? extends A, ? extends B, ? extends C>> {
    public JediTripeEvent(Triple<? extends A, ? extends B, ? extends C> r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        super(r100);
    }
}
