package com.bytedance.bdp.appbase.network.mime;

import com.bytedance.bdp.appbase.network.BdpRequestHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends a {
    public c(JSONObject r100) {
        super(BdpRequestHelper.INSTANCE.convertToBytes(r100.toString()));
    }
}
