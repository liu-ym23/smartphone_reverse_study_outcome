package com.bytedance.applog.log;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class GlobalLogger$tags$2 extends Lambda implements Function0<List<? extends String>> {
    final /* synthetic */ String $tag;

    public GlobalLogger$tags$2(String r1) {
        this.$tag = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final List<String> m986invoke() {
        return CollectionsKt.listOf(this.$tag);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m986invoke();
    }
}
