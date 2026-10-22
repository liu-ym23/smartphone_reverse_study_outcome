package com.bytedance.live.bizlink.api.platform.datamerge.callback;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes19.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/bizlink/api/platform/datamerge/callback/VideoCaptureStatus;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multi-biz-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface VideoCaptureStatus {
    public static final a Companion = null;
    public static final int STATUS_ERROR = 5;
    public static final int STATUS_FIRST_FRAME = 3;
    public static final int STATUS_STARTED = 2;
    public static final int STATUS_STARTING = 1;
    public static final int STATUS_STOPPED = 4;
    public static final int STATUS_UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f254862a = null;

        public a() {
        }

        static {
            f254862a = new a();
        }
    }

    static {
        Companion = a.f254862a;
    }
}
