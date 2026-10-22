package com.bytedance.awemeopen.apps.framework.card.view;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class AosPureVideoCardView$play$2$1$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $aid;
    final /* synthetic */ List<r14.c> $data;
    final /* synthetic */ d this$0;

    public AosPureVideoCardView$play$2$1$onSuccess$1(List<r14.c> r1, d r2, String r3) {
        this.$data = r1;
        this.this$0 = r2;
        this.$aid = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1244invoke() {
        r14.c r0 = (r14.c) CollectionsKt.firstOrNull(this.$data);
        d r1 = this.this$0;
        int r2 = d.a;
        r1.getClass();
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1244invoke();
        return Unit.INSTANCE;
    }
}
