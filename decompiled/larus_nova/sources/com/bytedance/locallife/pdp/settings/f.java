package com.bytedance.locallife.pdp.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f261727a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/pdp/settings/f$a;", "", "", "enabledBeforeDetail", "Z", "getEnabledBeforeDetail", "()Z", "enabledAfterDetail", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "enabledCacheData", "b", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("enabled_after_detail")
        private final boolean enabledAfterDetail;

        @SerializedName("enabled_before_detail")
        private final boolean enabledBeforeDetail;

        @SerializedName("enabled_cache_data")
        private final boolean enabledCacheData;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.enabledBeforeDetail == r101.enabledBeforeDetail) goto L12;
            return false;
        L12:
            if (this.enabledAfterDetail == r101.enabledAfterDetail) goto L15;
            return false;
        L15:
            if (this.enabledCacheData == r101.enabledCacheData) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.enabledBeforeDetail == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.enabledAfterDetail == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.enabledCacheData == true) goto L15;
            r100 = 1237;
        L15:
            return r104 + r100;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "DeliverGoodsDetailPreloadConfig(enabledBeforeDetail=" + this.enabledBeforeDetail + ", enabledAfterDetail=" + this.enabledAfterDetail + ", enabledCacheData=" + this.enabledCacheData + ')';
        }

        public final boolean a() {
            return this.enabledAfterDetail;
        }

        public final boolean b() {
            return this.enabledCacheData;
        }

        public a(int r100) {
            this.enabledBeforeDetail = false;
            this.enabledAfterDetail = false;
            this.enabledCacheData = false;
        }
    }

    static {
        f261727a = new a(0);
    }
}
