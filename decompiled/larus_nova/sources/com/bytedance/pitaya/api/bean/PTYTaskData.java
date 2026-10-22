package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYTaskData;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "Lorg/json/JSONObject;", "component1", "params", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lorg/json/JSONObject;", "getParams", "()Lorg/json/JSONObject;", "Lcom/bytedance/pitaya/api/bean/a;", "dataFetcher", "Lcom/bytedance/pitaya/api/bean/a;", "getDataFetcher", "()Lcom/bytedance/pitaya/api/bean/a;", "setDataFetcher", "(Lcom/bytedance/pitaya/api/bean/a;)V", "<init>", "(Lorg/json/JSONObject;)V", "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public final class PTYTaskData implements ReflectionCall {
    private a dataFetcher;
    private final JSONObject params;

    public static /* synthetic */ PTYTaskData copy$default(PTYTaskData r100, JSONObject r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.params;
    L6:
        return r100.copy(r101);
    }

    public final JSONObject component1() {
        return this.params;
    }

    public final PTYTaskData copy(JSONObject r100) {
        return new PTYTaskData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PTYTaskData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.params, ((PTYTaskData) r100).params) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final a getDataFetcher() {
        return null;
    }

    public int hashCode() {
        JSONObject r100 = this.params;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final void setDataFetcher(a r100) {
    }

    public String toString() {
        return "PTYTaskData(params=" + this.params + ')';
    }

    public final JSONObject getParams() {
        return this.params;
    }

    public PTYTaskData(JSONObject r100) {
        this.params = r100;
    }
}
