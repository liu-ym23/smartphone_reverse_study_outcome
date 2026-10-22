package com.bytedance.android.shopping.feed.event;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class FeedProductEventTrackerKt$addTagNameInLabelName$1$1 extends Lambda implements Function1<String, CharSequence> {
    public static final FeedProductEventTrackerKt$addTagNameInLabelName$1$1 INSTANCE = null;

    static {
        INSTANCE = new FeedProductEventTrackerKt$addTagNameInLabelName$1$1();
    }

    public FeedProductEventTrackerKt$addTagNameInLabelName$1$1() {
        super(1);
    }

    public final CharSequence invoke(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return ",";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((String) r1);
    }
}
