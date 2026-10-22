package com.ss.android.ad.applinksdk.model;

import com.ss.android.ad.applinksdk.utils.MonitorUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class AppLinkEventConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f406380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f406381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f406382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f406383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f406384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f406385f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f406386g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient Object f406387h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ad/applinksdk/model/AppLinkEventConfig$Scene;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "applinksdk_release"}, k = 1, mv = {1, 4, 0})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Scene {
        public static final a Companion = null;
        public static final int FEED = 0;
        public static final int LANDING_PAGE = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f406388a = null;

            public a() {
            }

            static {
                f406388a = new a();
            }
        }

        static {
            Companion = a.f406388a;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("deeplink_success_label", this.f406380a);     // Catch: Exception -> L5
        r100.putOpt("deeplink_failed_label", this.f406381b);     // Catch: Exception -> L5
        r100.putOpt("open_url_app_label", this.f406382c);     // Catch: Exception -> L5
        r100.putOpt("tag", this.f406383d);     // Catch: Exception -> L5
        r100.putOpt("refer", this.f406384e);     // Catch: Exception -> L5
        r100.putOpt("open_scene", 0);     // Catch: Exception -> L5
        r100.putOpt(AdDownloadEventConfig.JsonKey.ENABLE_V3_EVENT, Boolean.valueOf(this.f406385f));     // Catch: Exception -> L5
        r100.putOpt("extra", this.f406386g);     // Catch: Exception -> L5
        r100.putOpt("extra_value", 0);     // Catch: Exception -> L5
        r100.putOpt(AdDownloadEventConfig.JsonKey.PARAMS_JSON, null);     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        MonitorUtils.b(e, "AppLinkEventConfig toJson");
        goto L7
    }

    public final String toString() {
        return a().toString();
    }

    public AppLinkEventConfig() {
    }
}
