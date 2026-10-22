package com.bytedance.awemeopen.apps.framework.comment.api.root;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/api/root/CommentServiceId;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public @interface CommentServiceId {
    public static final String AWEME_COMMENT = "0";
    public static final String BOOK_COMMENT = "1026";
    public static final a Companion = null;
    public static final String HOT_SPOT = "101";
    public static final String PRODUCT_COMMENT = "1201";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f194119a = null;

        static {
            f194119a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f194119a;
    }
}
