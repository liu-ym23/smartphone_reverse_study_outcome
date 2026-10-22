package com.bytedance.bdp.appbase.netapi.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001e\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007R\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\tR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/annotation/ReqBody;", "", "multiPart", "Lcom/bytedance/bdp/appbase/netapi/annotation/ReqMultiPart;", "map", "Lcom/bytedance/bdp/appbase/netapi/annotation/ReqMap;", "json", "Lcom/bytedance/bdp/appbase/netapi/annotation/ReqJson;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/ReqJson;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/ReqMap;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/ReqMultiPart;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ReqBody {
    ReqJson json() default @ReqJson;

    ReqMap map() default @ReqMap;

    ReqMultiPart multiPart() default @ReqMultiPart;
}
