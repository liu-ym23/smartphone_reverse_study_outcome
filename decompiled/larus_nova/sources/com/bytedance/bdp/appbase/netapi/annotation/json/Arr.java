package com.bytedance.bdp.appbase.netapi.annotation.json;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.tencent.open.SocialConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B(\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003R\u000f\u0010\u0006\u001a\u00020\u0000¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u000f\u0010\u0007\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\nR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/annotation/json/Arr;", "", "type", "", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "Lcom/bytedance/bdp/appbase/netapi/annotation/json/Obj;", "arr", SocialConstants.PARAM_APP_DESC, "()Lcom/bytedance/bdp/appbase/netapi/annotation/json/Arr;", "()Ljava/lang/String;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/json/Obj;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface Arr {
    Arr arr() default @Arr;

    String desc() default "";

    Obj obj() default @Obj;

    String type() default "str";
}
