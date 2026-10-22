package com.bytedance.ee.bear.bitable.preload.net;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class MobileViewCacheParser implements NetService.c<Result<MobileViewResult>> {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/preload/net/MobileViewCacheParser$MobileViewResult;", "Lcom/bytedance/ee/util/io/NonProguard;", "clientVarsData", "Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableResourceData;", "mobileViewCode", "", "mobileViewMessage", "", "mobileViewData", "<init>", "(Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableResourceData;ILjava/lang/String;Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableResourceData;)V", "getClientVarsData", "()Lcom/bytedance/ee/bear/bitable/dao/resourcedata/BitableResourceData;", "getMobileViewCode", "()I", "getMobileViewMessage", "()Ljava/lang/String;", "getMobileViewData", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MobileViewResult implements NonProguard {
        private final BitableResourceData clientVarsData;
        private final int mobileViewCode;
        private final BitableResourceData mobileViewData;
        private final String mobileViewMessage;

        public final BitableResourceData getClientVarsData() {
            return this.clientVarsData;
        }

        public final int getMobileViewCode() {
            return this.mobileViewCode;
        }

        public final BitableResourceData getMobileViewData() {
            return this.mobileViewData;
        }

        public final String getMobileViewMessage() {
            return this.mobileViewMessage;
        }

        public MobileViewResult(BitableResourceData r100, int r101, String r102, BitableResourceData r103) {
            Intrinsics.checkNotNullParameter(r100, "clientVarsData");
            Intrinsics.checkNotNullParameter(r102, "mobileViewMessage");
            Intrinsics.checkNotNullParameter(r103, "mobileViewData");
            this.clientVarsData = r100;
            this.mobileViewCode = r101;
            this.mobileViewMessage = r102;
            this.mobileViewData = r103;
        }
    }

    public static final class a {
    }

    static {
    }

    public MobileViewCacheParser() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<MobileViewResult> parse(String r100) {
        Result<MobileViewResult> r101 = new Result();
    L31:
        th = move-exception;
        tt5.a.e("MobileViewCacheParser", "parse", th, false);
    L33:
        return r101;
    L4:
        String r102 = "";
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        JSONObject r103 = new JSONObject(r100);     // Catch: Throwable -> L31
        r101.code = r103.optInt("code");     // Catch: Throwable -> L31
        r101.msg = r103.optString("msg");     // Catch: Throwable -> L31
        JSONObject r104 = r103.optJSONObject("data");     // Catch: Throwable -> L31
        BitableResourceData r105 = new BitableResourceData();     // Catch: Throwable -> L31
        r105.setResKey("BITABLE_CLIENT_VARS");     // Catch: Throwable -> L31
        if (r104 == null) goto L11;
        String r106 = r104.optString("clientVar");     // Catch: Throwable -> L31
        if (r106 == null) goto L11;
    L12:
        r105.setResValue(r106);     // Catch: Throwable -> L31
        if (r104 == null) goto L15;
        JSONObject r107 = r104.optJSONObject("mobileViewCacheData");     // Catch: Throwable -> L31
    L16:
        if (r107 == null) goto L18;
        int r108 = r107.optInt("mobileViewCode");     // Catch: Throwable -> L31
    L19:
        if (r107 == null) goto L22;
        String r109 = r107.optString("mobileViewMessage");     // Catch: Throwable -> L31
        if (r109 == null) goto L22;
    L23:
        BitableResourceData r110 = new BitableResourceData();     // Catch: Throwable -> L31
        r110.setResKey("BITABLE_MAIN_PAGE");     // Catch: Throwable -> L31
        if (r107 == null) goto L29;
        String r111 = r107.optString("mobileViewCache");     // Catch: Throwable -> L31
        if (r111 == null) goto L29;
        r102 = r111;
    L29:
        r110.setResValue(r102);     // Catch: Throwable -> L31
        r101.data = new MobileViewResult(r105, r108, r109, r110);     // Catch: Throwable -> L31
    L22:
        r109 = "not found";
        goto L23
    L18:
        r108 = -1;
        goto L19
    L15:
        r107 = null;
    L11:
        r106 = "";
        goto L12
    }
}
