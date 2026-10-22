package com.larus.bmhome.upload.sdk;

import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f314833a = null;

        static {
            int[] r100 = new int[UploadScene.values().length];
            r100[UploadScene.CHAT_FILE_UPLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r100[UploadScene.CHAT_IMAGE_VLM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r100[UploadScene.CHAT_IMAGE_OCR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[UploadScene.CHAT_IMAGE_EDU.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r100[UploadScene.CHAT_DIRECT_IMAGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r100[UploadScene.CHAT_ATTACHMENT_IMAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r100[UploadScene.CHAT_ATTACHMENT_VIDEO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r100[UploadScene.CREATION_USER_VIDEO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[UploadScene.SPRING_MAIN_VENUE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r100[UploadScene.O_SERVER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r100[UploadScene.O_MOBILE_TMP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r100[UploadScene.O_ASSISTANT_FEEDBACK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            f314833a = r100;
        }
    }

    public static final FlowResourceScene a(is8.g r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (r101 != null) goto L5;
    L15:
        FlowResourceScene r102 = FlowResourceScene.Unknown;
    L16:
        FlowResourceScene r103 = FlowResourceScene.Unknown;
        if (r102 == r103) goto L19;
        return r102;
    L19:
        UploadScene r104 = r100.f495672c.f495646b;
        switch(a.f314833a[r104.ordinal()]) {
            case 1: goto L34;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L43;
            case 5: goto L42;
            case 6: goto L41;
            case 7: goto L40;
            case 8: goto L39;
            case 9: goto L38;
            case 10: goto L37;
            case 11: goto L36;
            case 12: goto L35;
            default: goto L46;
        };
    L46:
        return r103;
    L35:
        return FlowResourceScene.O_ASSISTANT_FEEDBACK;
    L36:
        return FlowResourceScene.O_Mobile_Tmp;
    L37:
        return FlowResourceScene.O_Server;
    L38:
        return FlowResourceScene.SpringMainVenue;
    L39:
        return FlowResourceScene.CreationUserVideo;
    L40:
        return FlowResourceScene.VideoUpload;
    L41:
        return FlowResourceScene.ImageVLM;
    L42:
        return FlowResourceScene.ImageVLM;
    L43:
        return FlowResourceScene.ImageEDU;
    L44:
        return FlowResourceScene.ImageOCR;
    L45:
        return FlowResourceScene.ImageVLM;
    L34:
        return FlowResourceScene.FileUpload;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L15;
        ResourceCenter.f313541a.getClass();
        r102 = ResourceCenter.g(r101);
        if (r102 == null) goto L15;
    L7:
        r105 = false;
        goto L8
    }
}
