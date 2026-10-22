package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class RunnableGroup$run$1 extends Lambda implements Function0<String> {
    final /* synthetic */ v this$0;

    public RunnableGroup$run$1(v r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1053invoke() {
        return "================ " + this.this$0 + " start run ===============";
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1053invoke();
    }
}
