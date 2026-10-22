package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/ECStoreJsbErrorCode;", "", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ECStoreJsbErrorCode {
    public static final a Companion = null;
    public static final int EMPTY_JSB_NAME = -200;
    public static final int EMPTY_NO_POLICY = -240;
    public static final int JSON_ERROR = -101;
    public static final int NO_RULE_ERROR = -102;
    public static final int PATTERN_EXCEPTION = -270;

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
