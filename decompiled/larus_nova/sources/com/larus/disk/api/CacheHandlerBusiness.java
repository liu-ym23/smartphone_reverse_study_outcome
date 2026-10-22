package com.larus.disk.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes27.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/disk/api/CacheHandlerBusiness;", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface CacheHandlerBusiness {
    public static final String APP_TECH = "app_tech";
    public static final String COMMON_CACHE_TEMP = "common_cache_temp";
    public static final a Companion = null;
    public static final String DATABASE = "data_base";
    public static final String DISK_LRU_CACHE = "disk_lru_cache";
    public static final String FILE_CACHE = "file_cache";
    public static final String FRESCO_CACHE = "fresco_cache";
    public static final String MESSAGE_CACHE = "message_cache";
    public static final String OFFLINE_RESOURCE = "offline_cache";
    public static final String SHARED_PREFERENCES = "shared_preferences";
    public static final String UGC_VOICE = "ugc_voice";
    public static final String UNKNOWN = "unknown";
    public static final String VIDEO_CACHE = "video_cache";
    public static final String VOICE_CACHE = "voice_cache";
    public static final String WEBVIEW = "webview";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f330509a = null;

        static {
            f330509a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f330509a;
    }
}
