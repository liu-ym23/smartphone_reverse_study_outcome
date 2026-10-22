package com.ss.android.lark.statistics.video_site;

import com.ss.android.lark.chat.entity.message.PreviewVideo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import o5c.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoSiteHitPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f440779a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440780a = null;

        static {
            int[] r100 = new int[PreviewVideo.Site.values().length];
            r100[PreviewVideo.Site.XIGUA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[PreviewVideo.Site.DOUYIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[PreviewVideo.Site.YOUTUBE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f440780a = r100;
        }
    }

    static {
        f440779a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, VideoSiteHitPoint$statistics$2.INSTANCE);
    }

    public static String a(PreviewVideo.Site r100) {
        int r101 = a.f440780a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "xigua";
    L5:
        if (r101 != 2) goto L7;
        return "douyin";
    L7:
        if (r101 == 3) goto L10;
        return "";
    L10:
        return "youtube";
    }

    @JvmStatic
    public static final void b(PreviewVideo.Site r100) {
        Intrinsics.checkNotNullParameter(r100, "site");
        ((b) f440779a.getValue()).sendEvent("video_url_click", new JSONObject().put("video_source", a(r100)));
    }
}
