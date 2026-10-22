package com.bytedance.bdp.appbase.netapi.annotation;

import com.bytedance.bdp.appbase.netapi.annotation.json.Obj;
import com.tencent.open.SocialConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001BB\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003R\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0006\u001a\u0004\b\u0007\u0010\rR\u000f\u0010\f\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u000f\u0010\u0006\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000fR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u000eR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u000fR\u000f\u0010\n\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\n\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/annotation/ReqJson;", "", "mediaType", "", "required", "", "local", "addComParamsFun", "", "Lcom/bytedance/bdp/appbase/netapi/annotation/ComParam;", "struct", "Lcom/bytedance/bdp/appbase/netapi/annotation/json/Obj;", SocialConstants.PARAM_APP_DESC, "()[Lcom/bytedance/bdp/appbase/netapi/annotation/ComParam;", "()Ljava/lang/String;", "()Z", "()Lcom/bytedance/bdp/appbase/netapi/annotation/json/Obj;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ReqJson {
    ComParam[] addComParamsFun() default {};

    String desc() default "";

    boolean local() default false;

    String mediaType() default "application/json";

    boolean required() default true;

    Obj struct() default @Obj;
}
