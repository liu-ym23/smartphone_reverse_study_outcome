package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "_ele", "", "_elementId", "index", "operationID", "enableReuseNotification", "", AbsMethodDelegate.TAG_INVOKE, "(JJIJZ)Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RenderFnRenderer$createList$componentAtIndexCallback$1 extends Lambda implements Function5<Long, Long, Integer, Long, Boolean, Integer> {
    final /* synthetic */ Function3<Integer, Long, Boolean, Integer> $componentAtIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public RenderFnRenderer$createList$componentAtIndexCallback$1(Function3<? super Integer, ? super Long, ? super Boolean, Integer> r100) {
        this.$componentAtIndex = r100;
        super(5);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Integer invoke(Long r110, Long r111, Integer r112, Long r113, Boolean r114) {
        return invoke(r110.longValue(), r111.longValue(), r112.intValue(), r113.longValue(), r114.booleanValue());
    }

    public final Integer invoke(long r100, long r101, int r102, long r103, boolean r104) {
        return this.$componentAtIndex.invoke(Integer.valueOf(r102), Long.valueOf(r103), Boolean.valueOf(r104));
    }
}
