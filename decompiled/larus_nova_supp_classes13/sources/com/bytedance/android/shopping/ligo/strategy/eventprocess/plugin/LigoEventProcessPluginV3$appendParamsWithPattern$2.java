package com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LigoEventProcessPluginV3$appendParamsWithPattern$2 extends Lambda implements Function0<String> {
    final /* synthetic */ List $paramsPattern;
    final /* synthetic */ JSONObject $result;
    final /* synthetic */ c this$0;

    public LigoEventProcessPluginV3$appendParamsWithPattern$2(c r1, JSONObject r2, List r3) {
        this.$result = r2;
        this.$paramsPattern = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m955invoke() {
        StringBuilder r0 = new StringBuilder("..append params with pattern: params result=");
        r0.append(this.$result);
        r0.append(", ruleName=");
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m955invoke();
    }
}
