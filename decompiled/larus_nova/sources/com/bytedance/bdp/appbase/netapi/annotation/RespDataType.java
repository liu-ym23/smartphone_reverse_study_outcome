package com.bytedance.bdp.appbase.netapi.annotation;

import com.bytedance.bdp.appbase.netapi.annotation.json.KV;
import com.bytedance.bdp.appbase.netapi.annotation.json.Obj;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B(\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\tR\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000bR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\fR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/annotation/RespDataType;", "", "struct", "Lcom/bytedance/bdp/appbase/netapi/annotation/json/Obj;", "sucCode", "", "jsonKeys", "Lcom/bytedance/bdp/appbase/netapi/annotation/ResultJsonKey;", "checkServerCode", "", "()Z", "()Lcom/bytedance/bdp/appbase/netapi/annotation/ResultJsonKey;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/json/Obj;", "()I", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface RespDataType {
    boolean checkServerCode() default true;

    ResultJsonKey jsonKeys() default @ResultJsonKey;

    Obj struct() default @Obj(kv = {@KV(key = "data", obj = @Obj, required = true)});

    int sucCode() default 0;
}
