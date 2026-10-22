package com.bytedance.bdp.appbase.netapi.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B\u001a\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006R\u000f\u0010\u0005\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0015\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/annotation/NetResponse;", "", "errInfo", "", "Lcom/bytedance/bdp/appbase/netapi/annotation/ErrInfo;", "dataType", "Lcom/bytedance/bdp/appbase/netapi/annotation/RespDataType;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/RespDataType;", "()[Lcom/bytedance/bdp/appbase/netapi/annotation/ErrInfo;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface NetResponse {
    RespDataType dataType() default @RespDataType;

    ErrInfo[] errInfo() default {};
}
