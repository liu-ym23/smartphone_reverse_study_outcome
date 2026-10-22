package com.bytedance.pns.wrapper.metadata;

import android.media.MediaMetadataRetriever;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/pns/wrapper/metadata/MediaMetadataRetrieverWrapper;", "", "()V", "Companion", "metadata-wrapper_release"}, k = 1, mv = {1, 1, 13})
public final class MediaMetadataRetrieverWrapper {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007J\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007J\u000e\u0010\b\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007J\u000e\u0010\t\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007J\u000e\u0010\n\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007J\u000e\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007J\u000e\u0010\f\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007J\u000e\u0010\r\u001a\u0004\u0018\u00010\u0004*\u00020\u0005H\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/pns/wrapper/metadata/MediaMetadataRetrieverWrapper$Companion;", "", "()V", "getBitRate", "", "Landroid/media/MediaMetadataRetriever;", "getCaptureFrameRate", "getDate", "getDuration", "getMimeType", "getVideoHeight", "getVideoRotation", "getVideoWidth", "hasAudio", "metadata-wrapper_release"}, k = 1, mv = {1, 1, 13})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final String getBitRate(MediaMetadataRetriever r100) {
            return com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(r100, 20);
        }

        @JvmStatic
        public final String getCaptureFrameRate(MediaMetadataRetriever r100) {
            return com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(r100, 25);
        }

        @JvmStatic
        public final String getDate(MediaMetadataRetriever r100) {
            return com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(r100, 5);
        }

        @JvmStatic
        public final String getDuration(MediaMetadataRetriever r100) {
            return com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(r100, 9);
        }

        @JvmStatic
        public final String getMimeType(MediaMetadataRetriever r100) {
            return com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(r100, 12);
        }

        @JvmStatic
        public final String getVideoHeight(MediaMetadataRetriever r100) {
            return com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(r100, 19);
        }

        @JvmStatic
        public final String getVideoRotation(MediaMetadataRetriever r100) {
            return com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(r100, 24);
        }

        @JvmStatic
        public final String getVideoWidth(MediaMetadataRetriever r100) {
            return com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(r100, 18);
        }

        @JvmStatic
        public final String hasAudio(MediaMetadataRetriever r100) {
            return com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(r100, 16);
        }

        private static String com_bytedance_pns_wrapper_metadata_MediaMetadataRetrieverWrapper$Companion_android_media_MediaMetadataRetriever_extractMetadata(MediaMetadataRetriever r110, int r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {Integer.valueOf(r111)};
            b r112 = new b();
            a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return (String) r107.f474983b;
        L21:
            return r110.extractMetadata(r111);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MediaMetadataRetrieverWrapper() {
    }

    @JvmStatic
    public static final String getBitRate(MediaMetadataRetriever r100) {
        return Companion.getBitRate(r100);
    }

    @JvmStatic
    public static final String getCaptureFrameRate(MediaMetadataRetriever r100) {
        return Companion.getCaptureFrameRate(r100);
    }

    @JvmStatic
    public static final String getDate(MediaMetadataRetriever r100) {
        return Companion.getDate(r100);
    }

    @JvmStatic
    public static final String getDuration(MediaMetadataRetriever r100) {
        return Companion.getDuration(r100);
    }

    @JvmStatic
    public static final String getMimeType(MediaMetadataRetriever r100) {
        return Companion.getMimeType(r100);
    }

    @JvmStatic
    public static final String getVideoHeight(MediaMetadataRetriever r100) {
        return Companion.getVideoHeight(r100);
    }

    @JvmStatic
    public static final String getVideoRotation(MediaMetadataRetriever r100) {
        return Companion.getVideoRotation(r100);
    }

    @JvmStatic
    public static final String getVideoWidth(MediaMetadataRetriever r100) {
        return Companion.getVideoWidth(r100);
    }

    @JvmStatic
    public static final String hasAudio(MediaMetadataRetriever r100) {
        return Companion.hasAudio(r100);
    }
}
