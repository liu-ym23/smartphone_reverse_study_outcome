package com.bytedance.awemeopen.apps.framework.base.view.seekbar;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/a;", "kotlin.jvm.PlatformType", "o1", "o2", "", "invoke", "(Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/a;Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/a;)Ljava/lang/Integer;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class NoAnchorSeekBar$drawers$1 extends Lambda implements Function2<a, a, Integer> {
    public static final NoAnchorSeekBar$drawers$1 INSTANCE = null;

    static {
        INSTANCE = new NoAnchorSeekBar$drawers$1();
    }

    public NoAnchorSeekBar$drawers$1() {
        super(2);
    }

    public final Integer invoke(a r1, a r2) {
        return Integer.valueOf(r2.c() - r1.c());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((a) r1, (a) r2);
    }
}
