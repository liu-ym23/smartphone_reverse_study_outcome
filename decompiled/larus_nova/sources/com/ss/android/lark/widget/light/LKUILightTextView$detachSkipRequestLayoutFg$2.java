package com.ss.android.lark.widget.light;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class LKUILightTextView$detachSkipRequestLayoutFg$2 extends Lambda implements Function0<Boolean> {
    public static final LKUILightTextView$detachSkipRequestLayoutFg$2 INSTANCE = null;

    static {
        INSTANCE = new LKUILightTextView$detachSkipRequestLayoutFg$2();
    }

    public LKUILightTextView$detachSkipRequestLayoutFg$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable("messenger.rich_text.detach_skip_request_layout"));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
