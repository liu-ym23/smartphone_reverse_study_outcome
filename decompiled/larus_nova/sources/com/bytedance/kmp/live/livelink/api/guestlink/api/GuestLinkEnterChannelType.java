package com.bytedance.kmp.live.livelink.api.guestlink.api;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/kmp/live/livelink/api/guestlink/api/GuestLinkEnterChannelType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public @interface GuestLinkEnterChannelType {
    public static final a Companion = null;
    public static final long GuestLinkEnterChannelType_ChannelDown = 2;
    public static final long GuestLinkEnterChannelType_ChannelIn = 3;
    public static final long GuestLinkEnterChannelType_ChannelUp = 1;
    public static final long GuestLinkEnterChannelType_Unknown = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f252198a = null;

        public a() {
        }

        static {
            f252198a = new a();
        }
    }

    static {
        Companion = a.f252198a;
    }
}
