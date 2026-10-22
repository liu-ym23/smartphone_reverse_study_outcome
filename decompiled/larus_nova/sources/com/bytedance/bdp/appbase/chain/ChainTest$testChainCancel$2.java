package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Void;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testChainCancel$2 extends Lambda implements Function2<f, ?, String> {
    public static final ChainTest$testChainCancel$2 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testChainCancel$2();
    }

    public ChainTest$testChainCancel$2() {
        super(2);
    }

    public final String invoke(f r100, Void r101) {
        return "2";
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(f r100, Object r101) {
        return invoke(r100, (Void) r101);
    }
}
