package com.obric.livecard.api.utils;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\r¨\u0006\u0011"}, d2 = {"Lcom/obric/livecard/api/utils/ResourceUtils;", "", "()V", "getApplicationIcon", "", "packageName", "getAssetsFile", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "fileName", "type", "getDrawable", "drawableId", "", "getString", "stringId", "ResourceType", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ResourceUtils {
    public static final ResourceUtils INSTANCE = null;

    /* JADX INFO: loaded from: classes33.dex */
    @Target({ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/livecard/api/utils/ResourceUtils$ResourceType;", "", "Companion", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ResourceType {
        public static final String ALPHA_VIDEO = "alpha-video";
        public static final String APP_DRAWABLE = "drawable";
        public static final String APP_ICON = "app_icon";
        public static final Companion Companion = null;
        public static final String LOTTIE = "lottie";
        public static final String STRING = "stringId";
        public static final String SVG = "svg";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/livecard/api/utils/ResourceUtils$ResourceType$Companion;", "", "()V", "ALPHA_VIDEO", "", "APP_DRAWABLE", "APP_ICON", "LOTTIE", "STRING", "SVG", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final String ALPHA_VIDEO = "alpha-video";
            public static final String APP_DRAWABLE = "drawable";
            public static final String APP_ICON = "app_icon";
            public static final String LOTTIE = "lottie";
            public static final String STRING = "stringId";
            public static final String SVG = "svg";

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    static {
        INSTANCE = new ResourceUtils();
    }

    private ResourceUtils() {
    }

    public final String getApplicationIcon(String r100) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        return new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter("pkg", r100).appendQueryParameter("type", "app_icon").build().toString();
    }

    public final String getString(int r100) {
        return "stringId://" + r100;
    }

    public final String getDrawable(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter("id", String.valueOf(r101)).appendQueryParameter("pkg", r100.getPackageName()).appendQueryParameter("type", "drawable").build().toString();
    }

    public final String getAssetsFile(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r102, "type");
        return new Uri.Builder().scheme("content").authority("com.island.local.file").appendQueryParameter("fileName", r101).appendQueryParameter("pkg", r100.getPackageName()).appendQueryParameter("type", r102).build().toString();
    }
}
