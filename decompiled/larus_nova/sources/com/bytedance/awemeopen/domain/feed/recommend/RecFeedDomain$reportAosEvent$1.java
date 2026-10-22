package com.bytedance.awemeopen.domain.feed.recommend;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class RecFeedDomain$reportAosEvent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $event;
    final /* synthetic */ Map<String, String> $param;
    final /* synthetic */ RecFeedDomain this$0;

    public RecFeedDomain$reportAosEvent$1(RecFeedDomain r100, String r101, Map<String, String> r102) {
        this.this$0 = r100;
        this.$event = r101;
        this.$param = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        HashSet<Function2<String, Map<String, String>, Unit>> r100 = this.this$0.f198363h;
        String r101 = this.$event;
        Map<String, String> r102 = this.$param;
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((Function2) r103.next()).invoke(r101, r102);
        goto L4
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
