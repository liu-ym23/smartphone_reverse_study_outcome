package com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LigoEventProcessPluginV3$appendParamsWithPattern$3 extends Lambda implements Function0<String> {
    final /* synthetic */ String $key;
    final /* synthetic */ d93.a $paramsPattern;
    final /* synthetic */ Object $value;

    public LigoEventProcessPluginV3$appendParamsWithPattern$3(String r1, Object r2, d93.a r3) {
        this.$key = r1;
        this.$value = r2;
        this.$paramsPattern = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m956invoke() {
        return "..append single params with pattern: put json(" + this.$key + ", " + this.$value + "), pattern=" + this.$paramsPattern;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m956invoke();
    }
}
