package com.bytedance.timon.ruler.adapter.impl;

import com.bytedance.ruler.utils.c;
import com.bytedance.timonbase.report.TMDataCollector;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/timon/ruler/adapter/impl/RulerAppLogImpl;", "Lcom/bytedance/ruler/utils/c;", "", "eventName", "Lorg/json/JSONObject;", "eventParams", "", "log", "<init>", "()V", "ruler-adapter_release"}, k = 1, mv = {1, 4, 0})
public final class RulerAppLogImpl implements c {
    public RulerAppLogImpl() {
    }

    @Override // com.bytedance.ruler.utils.c
    public void log(String r100, JSONObject r101) {
        TMDataCollector.e(r100, r101, false, 8);
    }
}
