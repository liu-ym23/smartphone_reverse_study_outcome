package com.larus.dora.impl.ota.tracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes27.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/dora/impl/ota/tracker/DoraOTACheckReason;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface DoraOTACheckReason {
    public static final String CHECK_REQUEST_FAIL = "check_request_fail";
    public static final a Companion = null;
    public static final String ERROR_CODE_PREFIX = "error_code_";
    public static final String LOW_BATTERY = "low_battery";
    public static final String NOT_CONFIGURED_NETWORK = "not_configured_network";
    public static final String NOT_ENOUGH_SPACE_ON_PERIPHERAL = "not_enough_space_on_peripheral";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f337792a = null;

        static {
            f337792a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f337792a;
    }
}
