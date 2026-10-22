package com.bytedance.bdp.appbase.netapi.annotation.json;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003R\u0015\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/annotation/json/Obj;", "", "kv", "", "Lcom/bytedance/bdp/appbase/netapi/annotation/json/KV;", "()[Lcom/bytedance/bdp/appbase/netapi/annotation/json/KV;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface Obj {
    KV[] kv() default {};
}
