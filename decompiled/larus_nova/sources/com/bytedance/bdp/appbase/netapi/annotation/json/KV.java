package com.bytedance.bdp.appbase.netapi.annotation.json;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.tencent.open.SocialConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003R\u000f\u0010\t\u001a\u00020\n¢\u0006\u0006\u001a\u0004\b\t\u0010\fR\u000f\u0010\u000b\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\rR\u000f\u0010\u0007\u001a\u00020\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u000eR\u000f\u0010\u0005\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000fR\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0004\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/annotation/json/KV;", "", "key", "", "type", "required", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lcom/bytedance/bdp/appbase/netapi/annotation/json/Obj;", "arr", "Lcom/bytedance/bdp/appbase/netapi/annotation/json/Arr;", SocialConstants.PARAM_APP_DESC, "()Lcom/bytedance/bdp/appbase/netapi/annotation/json/Arr;", "()Ljava/lang/String;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/json/Obj;", "()Z", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface KV {
    Arr arr() default @Arr;

    String desc() default "";

    String key();

    Obj obj() default @Obj;

    boolean required() default false;

    String type() default "str";
}
