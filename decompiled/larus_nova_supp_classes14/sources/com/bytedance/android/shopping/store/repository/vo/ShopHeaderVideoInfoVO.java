package com.bytedance.android.shopping.store.repository.vo;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/store/repository/vo/ShopHeaderVideoInfoVO;", "Ljava/io/Serializable;", "", "awemedata", "Ljava/lang/String;", "getAwemedata", "()Ljava/lang/String;", "setAwemedata", "(Ljava/lang/String;)V", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopHeaderVideoInfoVO implements Serializable {
    public static final a Companion = null;
    private String awemedata;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ShopHeaderVideoInfoVO() {
    }

    public final String getAwemedata() {
        return this.awemedata;
    }

    public final void setAwemedata(String r1) {
        this.awemedata = r1;
    }
}
