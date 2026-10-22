package com.bytedance.ee.bear.bitable.card.view.stage;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Float;"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class StageStepView$borderWidth$2 extends Lambda implements Function0<Float> {
    public static final StageStepView$borderWidth$2 INSTANCE = null;

    static {
        INSTANCE = new StageStepView$borderWidth$2();
    }

    public StageStepView$borderWidth$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Float invoke() {
        return Float.valueOf(UIHelper.dp2px(2.0f));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Float invoke() {
        return invoke();
    }
}
