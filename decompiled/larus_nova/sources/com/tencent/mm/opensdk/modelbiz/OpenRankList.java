package com.tencent.mm.opensdk.modelbiz;

import com.tencent.mm.opensdk.modelbase.BaseReq;

/* JADX INFO: loaded from: classes40.dex */
public class OpenRankList {

    public static class Req extends BaseReq {
        public Req() {
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 11;
        }
    }

    public OpenRankList() {
    }
}
