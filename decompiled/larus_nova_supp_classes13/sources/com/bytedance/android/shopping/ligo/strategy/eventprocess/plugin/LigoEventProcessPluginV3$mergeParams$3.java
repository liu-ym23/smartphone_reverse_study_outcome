package com.bytedance.android.shopping.ligo.strategy.eventprocess.plugin;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LigoEventProcessPluginV3$mergeParams$3 extends Lambda implements Function0<String> {
    final /* synthetic */ JSONObject $result;

    public LigoEventProcessPluginV3$mergeParams$3(JSONObject r1) {
        this.$result = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final String m958invoke() {
        return "merge params with pattern success, result=" + this.$result;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m958invoke();
    }
}
