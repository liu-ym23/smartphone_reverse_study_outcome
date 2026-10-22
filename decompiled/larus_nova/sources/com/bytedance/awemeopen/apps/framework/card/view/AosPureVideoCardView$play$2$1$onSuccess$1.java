package com.bytedance.awemeopen.apps.framework.card.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosPureVideoCardView$play$2$1$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $aid;
    final /* synthetic */ List<r14.c> $data;
    final /* synthetic */ d this$0;

    public AosPureVideoCardView$play$2$1$onSuccess$1(List<r14.c> r100, d r101, String r102) {
        this.$data = r100;
        this.this$0 = r101;
        this.$aid = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        r14.c r100 = (r14.c) CollectionsKt.firstOrNull(this.$data);
        d r101 = this.this$0;
        int r102 = d.f193908a;
        r101.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
