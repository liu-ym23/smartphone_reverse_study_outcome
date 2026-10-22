package io.ktor.client.engine;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import io.ktor.http.r;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "key", "", "values", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
final class UtilsKt$mergeHeaders$2 extends Lambda implements Function2<String, List<? extends String>, Unit> {
    final /* synthetic */ Function2<String, String, Unit> $block;

    /* JADX WARN: Multi-variable type inference failed */
    public UtilsKt$mergeHeaders$2(Function2<? super String, ? super String, Unit> r100) {
        this.$block = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r110, List<String> r111) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "values");
        List<String> r100 = r.f491904a;
        if (Intrinsics.areEqual("Content-Length", r110) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual("Content-Type", r110) == false) goto L9;
        return;
    L9:
        if (h.f491648a.contains(r110) == false) goto L15;
        Function2<String, String, Unit> r101 = this.$block;
        Iterator<T> r112 = r111.iterator();
    L12:
        if (r112.hasNext() == false) goto L21;
        r101.invoke(r110, (String) r112.next());
        goto L12
    L21:
        return;
    L15:
        if (Intrinsics.areEqual("Cookie", r110) == false) goto L17;
        String r102 = "; ";
    L18:
        String r103 = r102;
        this.$block.invoke(r110, CollectionsKt.joinToString$default(r111, r103, null, null, 0, null, null, 62, null));
        return;
    L17:
        r102 = ",";
        goto L18
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String r100, List<? extends String> r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
