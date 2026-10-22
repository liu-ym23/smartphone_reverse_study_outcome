package com.bytedance.timon.foundation.interfaces;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/timon/foundation/interfaces/IAppLog;", "", "log", "", "eventName", "", "eventParams", "Lorg/json/JSONObject;", "timonfoundation_release"}, k = 1, mv = {1, 1, 16})
public interface IAppLog {
    void log(String r100, JSONObject r101);
}
