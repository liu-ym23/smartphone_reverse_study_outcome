package com.bytedance.android.shopping.card_list.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/card_list/dto/MarketingResourceSchemaResponse;", "Ljava/io/Serializable;", "", "isShow", "Z", "()Z", "", "couponSchema", "Ljava/lang/String;", "getCouponSchema", "()Ljava/lang/String;", "<init>", "(ZLjava/lang/String;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MarketingResourceSchemaResponse implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("coupon_schema")
    private final String couponSchema;

    @SerializedName("is_show")
    private final boolean isShow;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MarketingResourceSchemaResponse() {
        String r0 = null;
        boolean r2 = false;
        this(r2, r0, 3, r0);
    }

    public final String getCouponSchema() {
        return this.couponSchema;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public MarketingResourceSchemaResponse(boolean r1, String r2) {
        this.isShow = r1;
        this.couponSchema = r2;
    }

    public /* synthetic */ MarketingResourceSchemaResponse(boolean r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
