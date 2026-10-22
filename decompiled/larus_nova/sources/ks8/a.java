package ks8;

import com.larus.bmhome.upload.sdk.api.model.AuthMode;
import com.larus.bmhome.upload.sdk.api.model.RegisterPolicy;
import com.larus.bmhome.upload.sdk.api.model.RoutePolicy;
import com.larus.bmhome.upload.sdk.api.model.UploadEngineType;
import com.larus.bmhome.upload.sdk.api.model.UploadMediaType;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import is8.g;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements b {

    /* JADX INFO: renamed from: ks8.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6604a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f505936a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f505937b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f505938c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f505939d = null;

        static {
            int[] r100 = new int[RoutePolicy.values().length];
            r100[RoutePolicy.ForceResourceCenter.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L78:
            r100[RoutePolicy.ForceUploadAuthToken.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L94:
            r100[RoutePolicy.Auto.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L8:
            f505936a = r100;
            int[] r101 = new int[UploadMediaType.values().length];
            r101[UploadMediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L82:
            r101[UploadMediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L96:
            r101[UploadMediaType.FILE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L12:
            f505937b = r101;
            int[] r102 = new int[RegisterPolicy.values().length];
            r102[RegisterPolicy.ForceEnable.ordinal()] = 1;     // Catch: NoSuchFieldError -> L38
        L72:
            r102[RegisterPolicy.Disabled.ordinal()] = 2;     // Catch: NoSuchFieldError -> L39
        L84:
            r102[RegisterPolicy.Auto.ordinal()] = 3;     // Catch: NoSuchFieldError -> L40
        L16:
            f505938c = r102;
            int[] r103 = new int[UploadScene.values().length];
            r103[UploadScene.CHAT_DIRECT_IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L41
        L76:
            r103[UploadScene.CHAT_ATTACHMENT_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L42
        L88:
            r103[UploadScene.CHAT_ATTACHMENT_VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L43
        L54:
            r103[UploadScene.CHAT_IMAGE_VLM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L44
        L62:
            r103[UploadScene.CHAT_IMAGE_OCR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L45
        L92:
            r103[UploadScene.CHAT_IMAGE_EDU.ordinal()] = 6;     // Catch: NoSuchFieldError -> L46
        L56:
            r103[UploadScene.CHAT_FILE_UPLOAD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L47
        L68:
            r103[UploadScene.CREATION_USER_VIDEO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L48
        L74:
            r103[UploadScene.SPRING_MAIN_VENUE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L49
        L90:
            r103[UploadScene.O_SERVER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L50
        L66:
            r103[UploadScene.O_MOBILE_TMP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L51
        L80:
            r103[UploadScene.O_ASSISTANT_FEEDBACK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L52
        L86:
            r103[UploadScene.UNKNOWN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L53
        L30:
            f505939d = r103;
        }
    }

    public a() {
    }

    @Override // ks8.b
    public final is8.a a(g r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        UploadScene r100 = r110.f495672c.f495646b;
        RoutePolicy r101 = r110.f495673d.f495665b;
        int r102 = C6604a.f505936a[r101.ordinal()];
        if (r102 == 1) goto L22;
        if (r102 == 2) goto L21;
        if (r102 != 3) goto L20;
        UploadMediaType r103 = r110.f495671b;
        switch(C6604a.f505939d[r100.ordinal()]) {
            case 1: goto L17;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L16;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L16;
            case 9: goto L16;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L12;
            default: goto L9;
        };
    L15:
        AuthMode r104 = AuthMode.ResourceCenterPrepareUpload;
    L23:
        UploadMediaType r105 = r110.f495671b;
        int r106 = C6604a.f505937b[r105.ordinal()];
        if (r106 == 1) goto L31;
        if (r106 == 2) goto L30;
        if (r106 != 3) goto L29;
        UploadEngineType r107 = UploadEngineType.FILE;
    L32:
        boolean r108 = false;
        if (r104 != AuthMode.ResourceCenterPrepareUpload) goto L35;
        boolean r109 = true;
    L36:
        RegisterPolicy r111 = r110.f495673d.f495666c;
        int r112 = C6604a.f505938c[r111.ordinal()];
        if (r112 == 1) goto L44;
        if (r112 == 2) goto L43;
        if (r112 != 3) goto L42;
        boolean r113 = r109;
    L46:
        if (r110.f495671b == UploadMediaType.IMAGE) goto L49;
        r108 = true;
    L49:
        return new is8.a(r104, r107, r113, r108, r109, r100);
    L42:
        throw new NoWhenBranchMatchedException();
    L43:
        r113 = false;
        goto L46
    L44:
        r113 = true;
        goto L46
    L35:
        r109 = false;
        goto L36
    L29:
        throw new NoWhenBranchMatchedException();
    L30:
        r107 = UploadEngineType.VIDEO;
        goto L32
    L31:
        r107 = UploadEngineType.IMAGE;
        goto L32
    L16:
        r104 = AuthMode.ResourceCenterPrepareUpload;
        goto L23
    L17:
        r104 = AuthMode.UploadAuthToken;
        goto L23
    L9:
        if (r103 != UploadMediaType.VIDEO) goto L18;
        r104 = AuthMode.ResourceCenterPrepareUpload;
        goto L23
    L18:
        r104 = AuthMode.UploadAuthToken;
        goto L23
    L12:
        if (r103 != UploadMediaType.VIDEO) goto L14;
        r104 = AuthMode.ResourceCenterPrepareUpload;
        goto L23
    L14:
        r104 = AuthMode.UploadAuthToken;
        goto L23
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        r104 = AuthMode.UploadAuthToken;
        goto L23
    L22:
        r104 = AuthMode.ResourceCenterPrepareUpload;
        goto L23
    }
}
