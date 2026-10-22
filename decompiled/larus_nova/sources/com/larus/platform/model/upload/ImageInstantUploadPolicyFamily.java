package com.larus.platform.model.upload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes31.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/platform/model/upload/ImageInstantUploadPolicyFamily;", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ImageInstantUploadPolicyFamily {
    public static final a Companion = null;
    public static final String FILE_IDENTITY = "file_identity";
    public static final String IMAGE_AVATAR = "image_avatar";
    public static final String IMAGE_CHAT = "image_chat";
    public static final String IMAGE_CREATION = "image_creation";
    public static final String IMAGE_IDENTITY = "image_identity";
    public static final String VIDEO_IDENTITY = "video_identity";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f365662a = null;

        static {
            f365662a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f365662a;
    }
}
