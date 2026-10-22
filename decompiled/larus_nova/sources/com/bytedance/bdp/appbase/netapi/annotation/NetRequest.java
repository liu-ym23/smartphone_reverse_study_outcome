package com.bytedance.bdp.appbase.netapi.annotation;

import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes11.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001B¨\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018R\u000f\u0010\u000e\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0019R\u000f\u0010\t\u001a\u00020\n¢\u0006\u0006\u001a\u0004\b\t\u0010\u001aR\u000f\u0010\u0016\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001bR\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u001cR\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u001bR\u000f\u0010\u0014\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0019R\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0019R\u000f\u0010\u0015\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0019R\u000f\u0010\r\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\r\u0010\u0019R\u000f\u0010\b\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\b\u0010\u001bR\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u001bR\u000f\u0010\u0005\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u001bR\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u001dR\u000f\u0010\f\u001a\u00020\n¢\u0006\u0006\u001a\u0004\b\f\u0010\u001aR\u000f\u0010\u0017\u001a\u00020\u0018¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001eR\u000f\u0010\u000b\u001a\u00020\n¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/bdp/appbase/netapi/annotation/NetRequest;", "", e.f25671s, "", "hostUrl", "path", "inputHostAndPathParam", "", NewBroadcastMonitor.STAGE.LIFECYCLE, "connectTimeOutMs", "", "writeTimeOutMs", "readTimeOutMs", "inputTimeOutParams", "addBdpComParams", "headers", "", "Lcom/bytedance/bdp/appbase/netapi/annotation/Header;", "queries", "Lcom/bytedance/bdp/appbase/netapi/annotation/Query;", "inputHeaderParams", "inputQueryParams", "dyeTagType", "reqBody", "Lcom/bytedance/bdp/appbase/netapi/annotation/ReqBody;", "()Z", "()J", "()Ljava/lang/String;", "()[Lcom/bytedance/bdp/appbase/netapi/annotation/Header;", "()[Lcom/bytedance/bdp/appbase/netapi/annotation/Query;", "()Lcom/bytedance/bdp/appbase/netapi/annotation/ReqBody;", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface NetRequest {
    boolean addBdpComParams() default false;

    long connectTimeOutMs() default 10000;

    String dyeTagType() default "NULL";

    Header[] headers() default {};

    String hostUrl();

    boolean inputHeaderParams() default false;

    boolean inputHostAndPathParam() default false;

    boolean inputQueryParams() default false;

    boolean inputTimeOutParams() default false;

    String lifecycle() default "DESTROY";

    String method() default "GET";

    String path();

    Query[] queries() default {};

    long readTimeOutMs() default 10000;

    ReqBody reqBody() default @ReqBody;

    long writeTimeOutMs() default 10000;
}
