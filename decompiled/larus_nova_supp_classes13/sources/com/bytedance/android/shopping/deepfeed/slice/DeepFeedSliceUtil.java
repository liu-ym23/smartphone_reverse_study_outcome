package com.bytedance.android.shopping.deepfeed.slice;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DeepFeedSliceUtil {
    public static final AtomicBoolean a = null;
    public static final AtomicBoolean b = null;

    static {
        a = new AtomicBoolean(false);
        b = new AtomicBoolean(false);
    }

    public static void a() {
        if (a.compareAndSet(false, true) == false) goto L6;
        SliceRender r0 = SliceRender.o;
        DeepFeedSliceUtil$injectElement$1 r1 = DeepFeedSliceUtil$injectElement$1.INSTANCE;
        r0.getClass();
        ElementTypes.b("ECDeepFeedVideo", r1);
        ElementTypes.b("ECDeepFeedList", DeepFeedSliceUtil$injectElement$2.INSTANCE);
        ElementTypes.b("ECDeepFeedImage", DeepFeedSliceUtil$injectElement$3.INSTANCE);
        ElementTypes.b("ECDeepFeedIndicator", DeepFeedSliceUtil$injectElement$4.INSTANCE);
        ElementTypes.b("ECDeepFeedAdaptiveLayout", DeepFeedSliceUtil$injectElement$5.INSTANCE);
        ElementTypes.b("DeepFeedLottieView", DeepFeedSliceUtil$injectElement$6.INSTANCE);
        ElementTypes.b("ECDeepFeedCarousel", DeepFeedSliceUtil$injectElement$7.INSTANCE);
        ElementTypes.b("ECDeepFeedScrolling", DeepFeedSliceUtil$injectElement$8.INSTANCE);
        ElementTypes.b("ECDeepFeedCommentItem", DeepFeedSliceUtil$injectElement$9.INSTANCE);
        ElementTypes.b("ECDeepFeedCommentTitle", DeepFeedSliceUtil$injectElement$10.INSTANCE);
        ElementTypes.b("ECDeepFeedImpressionWords", DeepFeedSliceUtil$injectElement$11.INSTANCE);
        ElementTypes.b("ECDeepFeedGradientText", DeepFeedSliceUtil$injectElement$12.INSTANCE);
        ElementTypes.b("ECDeepFeedLongPress", DeepFeedSliceUtil$injectElement$13.INSTANCE);
        ElementTypes.b("ECDeepFeedGestureArea", DeepFeedSliceUtil$injectElement$14.INSTANCE);
        ElementTypes.b("ECMallScrollNumber", DeepFeedSliceUtil$injectElement$15.INSTANCE);
        ElementTypes.b("ECDeepFeedLive", DeepFeedSliceUtil$injectElement$16.INSTANCE);
        return;
    }
}
