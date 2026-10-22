package com.bytedance.applog.map.api;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class EventMap$init$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Application $app;
    final /* synthetic */ MapConfig $config;

    public EventMap$init$1(Application r1, MapConfig r2) {
        this.$app = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m989invoke() {
        return "init app: " + this.$app + ", null, service: " + b.a;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m989invoke();
    }
}
