package com.bytedance.bdp.appbase.netapi.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001B6\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003R\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\fR\u000f\u0010\n\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\rR\u000f\u0010\u000b\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u000eR\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/annotation/NetApiInfo;", "", "name", "", "request", "Lcom/bytedance/bdp/appbase/netapi/annotation/NetRequest;", "response", "Lcom/bytedance/bdp/appbase/netapi/annotation/NetResponse;", "enableChain", "", "enableProtected", "paramsForSpecial", "()Z", "()Ljava/lang/String;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/NetRequest;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/NetResponse;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface NetApiInfo {
    boolean enableChain() default false;

    boolean enableProtected() default false;

    String name();

    String paramsForSpecial() default "";

    NetRequest request();

    NetResponse response();
}
