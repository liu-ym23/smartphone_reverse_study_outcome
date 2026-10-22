package com.ss.android.lark.feed.shared.page.utils;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class CanvasUtil$drawOvalClippedAvatarChild$orderedChildIndices$2 extends Lambda implements Function1<Integer, Comparable<?>> {
    public static final CanvasUtil$drawOvalClippedAvatarChild$orderedChildIndices$2 INSTANCE = null;

    static {
        INSTANCE = new CanvasUtil$drawOvalClippedAvatarChild$orderedChildIndices$2();
    }

    public CanvasUtil$drawOvalClippedAvatarChild$orderedChildIndices$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(Integer r100) {
        return invoke(r100.intValue());
    }

    public final Comparable<?> invoke(int r100) {
        return Integer.valueOf(r100);
    }
}
