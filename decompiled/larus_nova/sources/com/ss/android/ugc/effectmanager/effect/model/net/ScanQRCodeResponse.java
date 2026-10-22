package com.ss.android.ugc.effectmanager.effect.model.net;

import com.ss.android.ugc.effectmanager.common.model.BaseNetResponse;
import com.ss.android.ugc.effectmanager.effect.model.PlatformEffect;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class ScanQRCodeResponse extends BaseNetResponse {
    public DataNode data;

    public static class DataNode {
        public PlatformEffect effect;
        public List<String> url_prefix;

        public DataNode() {
        }
    }

    @Override // com.ss.android.ugc.effectmanager.common.model.BaseNetResponse
    public boolean checkValue() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    public ScanQRCodeResponse() {
    }
}
