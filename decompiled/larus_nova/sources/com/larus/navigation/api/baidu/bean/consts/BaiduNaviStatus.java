package com.larus.navigation.api.baidu.bean.consts;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes30.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/navigation/api/baidu/bean/consts/BaiduNaviStatus;", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface BaiduNaviStatus {
    public static final a Companion = null;
    public static final int INNER_ERROR = 1;
    public static final int INVALID_PARAM = 2;
    public static final int INVALID_ROUTE_ID = 5;
    public static final int NO_AK_PARAM = 101;
    public static final int NO_PERMISSION = 240;
    public static final int OFF_THE_ROUTE = 3;
    public static final int OFF_THE_ROUTE_NEW_ROUTING = 4;
    public static final int OK = 0;
    public static final int REACH_END = 9;
    public static final int UNKNOWN = -1;
    public static final int WRONG_AK_PARAM = 200;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f359654a = null;

        static {
            f359654a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f359654a;
    }
}
