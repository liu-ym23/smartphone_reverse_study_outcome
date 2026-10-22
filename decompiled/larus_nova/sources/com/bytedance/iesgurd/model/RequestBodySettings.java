package com.bytedance.iesgurd.model;

import com.amap.api.services.cloud.CloudSearch;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.core.n;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\tB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodySettings;", "Lcom/bytedance/iesgurd/model/RequestBodyBase;", "reqType", "Lcom/bytedance/iesgurd/core/ReqType;", "version", "", "(Lcom/bytedance/iesgurd/core/ReqType;Ljava/lang/String;)V", "local", "Lcom/bytedance/iesgurd/model/RequestBodySettings$Local;", CloudSearch.SearchBound.LOCAL_SHAPE, "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class RequestBodySettings extends RequestBodyBase {

    @SerializedName("local")
    private Local local;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/iesgurd/model/RequestBodySettings$Local;", "", "version", "", "(Ljava/lang/String;)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    public static final class Local {

        @SerializedName("version")
        private String version;

        public Local(String r100) {
            this.version = "0";
            if (r100 == null) goto L6;
            this.version = r100;
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RequestBodySettings(ReqType r100, String r101) {
        super(r100);
        this.local = new Local(r101);
        Set<String> r102 = n.f250675a;
        Iterator r103 = ((ConcurrentHashMap) n.f250676b).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Map.Entry r104 = (Map.Entry) r103.next();
        String r105 = (String) ((ConcurrentHashMap) r104.getValue()).get("business_version");
        if (r105 == null) goto L4;
        getCustom().put(r104.getKey(), MapsKt.mapOf(TuplesKt.to("business_version", r105)));
        goto L4
    }
}
