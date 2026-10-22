package com.bytedance.android.shopping.buynow.data.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/buynow/data/model/TTPayCode;", "", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface TTPayCode {
    public static final int CANCEL_PAY = 4;
    public static final a Companion = null;
    public static final int INSUFFICIENT_BALANCE = 113;
    public static final int IS_PAY_PROGRESS = 9;
    public static final int SHARE_CARD_FAIL = 118;
    public static final int SUCCESS = 0;
    public static final int TT_CJ_PAY_ANTI_FRAUD_CANCELED = 116;
    public static final int WECHAT_NOT_INSTALLED = 119;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }
}
