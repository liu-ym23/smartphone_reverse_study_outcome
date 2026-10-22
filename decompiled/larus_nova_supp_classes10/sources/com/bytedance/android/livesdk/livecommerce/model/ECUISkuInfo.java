package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.ec.model.promotion.ECUIActivity;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECUISkuInfo {
    public String a;
    public String b;
    public boolean c;
    public String d;
    public ECUICampaign e;
    public String f;
    public String g;
    public String h;
    public int i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public Map<String, String> q;
    public int r;
    public a s;
    public String t;
    public ECUIActivity u;
    public ECUIAskExplainInfo v;
    public boolean w;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/ECUISkuInfo$PreSellInfo;", "Ljava/io/Serializable;", "preSellType", "", "deliveryDelayDec", "", "preDelayDesc", "(ILjava/lang/String;Ljava/lang/String;)V", "getDeliveryDelayDec", "()Ljava/lang/String;", "getPreDelayDesc", "getPreSellType", "()I", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreSellInfo implements Serializable {
        private final String deliveryDelayDec;
        private final String preDelayDesc;
        private final int preSellType;

        public final String getDeliveryDelayDec() {
            return this.deliveryDelayDec;
        }

        public final String getPreDelayDesc() {
            return this.preDelayDesc;
        }

        public final int getPreSellType() {
            return this.preSellType;
        }

        public PreSellInfo(int r1, String r2, String r3) {
            this.preSellType = r1;
            this.deliveryDelayDec = r2;
            this.preDelayDesc = r3;
        }
    }

    public static final class a {
        public final String[] a;
        public final long b;

        public a(String[] r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ECUISkuInfo() {
        this.d = "";
        this.i = -1;
        this.t = "";
    }

    public final ECUIActivity getActivity() {
        return this.u;
    }
}
