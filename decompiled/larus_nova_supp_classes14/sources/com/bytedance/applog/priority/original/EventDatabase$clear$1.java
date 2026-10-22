package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class EventDatabase$clear$1 extends Lambda implements Function0<String> {
    final /* synthetic */ EventDatabase this$0;

    public EventDatabase$clear$1(EventDatabase r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m1031invoke() {
        return "clear data in table " + this.this$0.c + " failed!";
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m1031invoke();
    }
}
