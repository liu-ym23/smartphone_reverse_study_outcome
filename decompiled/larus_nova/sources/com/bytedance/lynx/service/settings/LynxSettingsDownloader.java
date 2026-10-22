package com.bytedance.lynx.service.settings;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.lynx.service.model.LynxServiceConfig;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
public final class LynxSettingsDownloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxSettingsDownloader f264959a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f264960b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f264961c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static e f264962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static LynxServiceConfig f264963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f264964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f264965g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f264966h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/lynx/service/settings/LynxSettingsDownloader$LynxSettingsSource;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "CUSTOM", "TIMER", "EXPERIMENT", "LynxService_noasanRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum LynxSettingsSource extends Enum<LynxSettingsSource> {
        public static final LynxSettingsSource CUSTOM = null;
        public static final LynxSettingsSource EXPERIMENT = null;
        public static final LynxSettingsSource TIMER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LynxSettingsSource[] f264967a = null;
        private final String description;

        public static LynxSettingsSource valueOf(String r100) {
            return (LynxSettingsSource) r27.a.a(LynxSettingsSource.class, r100);
        }

        public static LynxSettingsSource[] values() {
            return (LynxSettingsSource[]) f264967a.clone();
        }

        static {
            LynxSettingsSource r100 = new LynxSettingsSource("CUSTOM", 0, "custom");
            CUSTOM = r100;
            LynxSettingsSource r101 = new LynxSettingsSource("TIMER", 1, UploadTypeInf.TIMER);
            TIMER = r101;
            LynxSettingsSource r102 = new LynxSettingsSource("EXPERIMENT", 2, "experiment");
            EXPERIMENT = r102;
            f264967a = new LynxSettingsSource[]{r100, r101, r102};
        }

        public final String getDescription() {
            return this.description;
        }

        public LynxSettingsSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.description = r102;
        }
    }

    public LynxSettingsDownloader() {
    }

    static {
        f264959a = new LynxSettingsDownloader();
        f264960b = new AtomicBoolean(false);
        f264961c = new Handler(Looper.getMainLooper());
        f264965g = LazyKt.lazy(LynxSettingsDownloader$mSharedPreferences$2.INSTANCE);
        f264966h = 3;
    }

    public static SharedPreferences a() {
        return (SharedPreferences) f264965g.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.lynx.service.settings.e, java.lang.Runnable] */
    public static void c(long r100) {
        e r101 = f264962d;
        if (r101 == null) goto L5;
        f264961c.removeCallbacks(r101);
    L5:
        ?? r102 = new e();
        f264962d = r102;
        f264961c.postDelayed(r102, r100);
    }

    public static void b(final boolean r110, final String r111, final LynxSettingsSource r112, final int r113, final String r114, final String r115) {
        String r100 = "";
        final String r101 = String.valueOf(a().getLong("lynx_settings_last_sync_time", 0));     // Catch: ClassCastException -> L5
    L10:
        r100 = String.valueOf(a().getLong("lynx_settings_experiment_update_timestamp", 0));     // Catch: ClassCastException -> L9
    L7:
        final String r102 = r100;
        LynxEventReporter.onEvent("lynxsdk_settings_fetch_event", -1, new b(r112, r101, r102, r111, r110, r113, r114, r115));
        return;
    L5:
        r101 = "";
        goto L10
    }
}
