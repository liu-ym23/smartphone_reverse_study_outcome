package io.noties.markwon.html.tag;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lwsc/a;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lwsc/a;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ImageGridHandler$handle$drawable$1 extends Lambda implements Function1<wsc.a, Boolean> {
    final /* synthetic */ int $imageIndex;
    final /* synthetic */ boolean $justPlaceHolder;
    final /* synthetic */ Integer $spanCount;
    final /* synthetic */ String $thumbnail;

    public ImageGridHandler$handle$drawable$1(String r100, Integer r101, int r102, boolean r103) {
        this.$thumbnail = r100;
        this.$spanCount = r101;
        this.$imageIndex = r102;
        this.$justPlaceHolder = r103;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(wsc.a r100) {
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, this.$thumbnail) == false) goto L16;
        r101.getClass();
        Integer r102 = this.$spanCount;
        if (r102 == null) goto L16;
        if (r102.intValue() != 0) goto L16;
        r101.getClass();
        if (this.$imageIndex != 0) goto L16;
        if (r100.f561127l != this.$justPlaceHolder) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(wsc.a r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
