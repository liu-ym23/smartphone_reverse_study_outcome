package com.ss.android.lark.chat.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
public final class MessageImageMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f416612a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/utils/MessageImageMonitor$Scene;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "IMAGE_MESSAGE", "POST_MESSAGE", "MEDIA_COVER", "MOMENTS_IMAGE", "LOOK_LARGE_IMAGE", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Scene extends Enum<Scene> {
        public static final Scene IMAGE_MESSAGE = null;
        public static final Scene LOOK_LARGE_IMAGE = null;
        public static final Scene MEDIA_COVER = null;
        public static final Scene MOMENTS_IMAGE = null;
        public static final Scene POST_MESSAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Scene[] f416613a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416614b = null;
        private final String value;

        public static EnumEntries<Scene> getEntries() {
            return f416614b;
        }

        static {
            Scene r100 = new Scene("IMAGE_MESSAGE", 0, "image_message");
            IMAGE_MESSAGE = r100;
            Scene r101 = new Scene("POST_MESSAGE", 1, "post_message");
            POST_MESSAGE = r101;
            Scene r102 = new Scene("MEDIA_COVER", 2, "media_cover");
            MEDIA_COVER = r102;
            Scene r103 = new Scene("MOMENTS_IMAGE", 3, "moments_image");
            MOMENTS_IMAGE = r103;
            Scene r104 = new Scene("LOOK_LARGE_IMAGE", 4, "look_large_image");
            LOOK_LARGE_IMAGE = r104;
            Scene[] r105 = {r100, r101, r102, r103, r104};
            f416613a = r105;
            f416614b = EnumEntriesKt.enumEntries(r105);
        }

        public static Scene[] values() {
            return (Scene[]) f416613a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Scene valueOf(String r100) {
            return (Scene) r27.a.a(Scene.class, r100);
        }

        public Scene(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        f416612a = LazyKt.lazy(MessageImageMonitor$statistics$2.INSTANCE);
    }
}
