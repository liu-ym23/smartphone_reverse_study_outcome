package com.bytedance.bdp.appbase.chain;

import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0001\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "Lcom/bytedance/bdp/appbase/chain/b0;", "", "", PriorityModule.SCENE_MULTI, AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Lcom/bytedance/bdp/appbase/chain/b0;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testMultiThrowable$3 extends Lambda implements Function2<f, b0, String> {
    public static final ChainTest$testMultiThrowable$3 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testMultiThrowable$3();
    }

    public ChainTest$testMultiThrowable$3() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(f r100, b0 r101) {
        StringBuilder r102 = new StringBuilder();
        r101.getClass();
        String r103 = (String) null;
        r102.append(null);
        r102.append(",");
        r101.getClass();
        Void r104 = (Void) null;
        r102.append(null);
        return r102.toString();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(f r100, b0 r101) {
        return invoke2(r100, r101);
    }
}
