package com.bytedance.locallife.poi.poidetail.screenshot;

import bytedance.io.BdMediaItem;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lbytedance/io/BdMediaItem;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "(Lbytedance/io/BdMediaItem;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 3}, xi = 48)
final class PoiScreenshotShareManager$tryGetScreenshotPath$1 extends Lambda implements Function1<BdMediaItem, Boolean> {
    final /* synthetic */ long $time;

    public PoiScreenshotShareManager$tryGetScreenshotPath$1(long r100) {
        this.$time = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(BdMediaItem r100) {
        if (r100.getDateToken() >= this.$time) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(BdMediaItem r100) {
        return invoke2(r100);
    }
}
