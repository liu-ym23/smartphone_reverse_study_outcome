package com.bytedance.jedi.model.sync;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.bytedance.jedi.model.traceable.ITraceable;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\b0\u0007H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "K", "V", "K1", OuterPayLoginWrapper.LOGIN_STYLE_V1, "traceable", "Lcom/bytedance/jedi/model/traceable/ITraceable;", "Lkotlin/Pair;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/jedi/model/traceable/ITraceable;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SynckerImpl$sync$2 extends Lambda implements Function1<ITraceable<Pair<Object, Object>>, Boolean> {
    final /* synthetic */ SynckerImpl<Object, Object, Object, Object> this$0;

    public SynckerImpl$sync$2(SynckerImpl<Object, Object, Object, Object> r100) {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(ITraceable<Pair<Object, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "traceable");
        int r101 = SynckerImpl.f251190a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ITraceable<Pair<Object, Object>> r100) {
        return invoke2(r100);
    }
}
