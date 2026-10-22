package com.bytedance.ug.sdk.share.api.entity;

import androidx.core.app.NotificationCompat;
import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes22.dex */
public final enum ShareStrategy extends Enum<ShareStrategy> {
    public static final ShareStrategy NORMAL = null;
    public static final ShareStrategy SHARE_WITH_COMPONENT = null;
    public static final ShareStrategy SHARE_WITH_COMPONET_OPTIMIZE = null;
    public static final ShareStrategy SHARE_WITH_IMAGE_TOKEN = null;
    public static final ShareStrategy SHARE_WITH_TOKEN = null;
    public static final ShareStrategy SHARE_WITH_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareStrategy[] f272309a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272310a = null;

        static {
            int[] r100 = new int[ShareStrategy.values().length];
            f272310a = r100;
            r100[ShareStrategy.SHARE_WITH_COMPONENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f272310a[ShareStrategy.SHARE_WITH_TOKEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f272310a[ShareStrategy.SHARE_WITH_COMPONET_OPTIMIZE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f272310a[ShareStrategy.SHARE_WITH_IMAGE_TOKEN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f272310a[ShareStrategy.SHARE_WITH_VIDEO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f272310a[ShareStrategy.NORMAL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        ShareStrategy r100 = new ShareStrategy(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ShareStrategy r101 = new ShareStrategy("SHARE_WITH_COMPONENT", 1);
        SHARE_WITH_COMPONENT = r101;
        ShareStrategy r102 = new ShareStrategy("SHARE_WITH_TOKEN", 2);
        SHARE_WITH_TOKEN = r102;
        ShareStrategy r103 = new ShareStrategy("SHARE_WITH_COMPONET_OPTIMIZE", 3);
        SHARE_WITH_COMPONET_OPTIMIZE = r103;
        ShareStrategy r104 = new ShareStrategy("SHARE_WITH_IMAGE_TOKEN", 4);
        SHARE_WITH_IMAGE_TOKEN = r104;
        ShareStrategy r105 = new ShareStrategy("SHARE_WITH_VIDEO", 5);
        SHARE_WITH_VIDEO = r105;
        f272309a = new ShareStrategy[]{r100, r101, r102, r103, r104, r105};
    }

    public static ShareStrategy[] values() {
        return (ShareStrategy[]) f272309a.clone();
    }

    public static ShareStrategy getStrategyByType(String r100) {
        switch(r100.hashCode()) {
            case -1737986495: goto L21;
            case 113722: goto L18;
            case 114381: goto L15;
            case 100313435: goto L12;
            case 110541305: goto L9;
            case 112202875: goto L6;
            default: goto L23;
        };
    L23:
        byte r101 = -1;
    L24:
        if (r101 == 0) goto L40;
        if (r101 == 1) goto L38;
        if (r101 == 2) goto L36;
        if (r101 == 3) goto L34;
        if (r101 == 4) goto L32;
        return NORMAL;
    L32:
        return SHARE_WITH_VIDEO;
    L34:
        return SHARE_WITH_IMAGE_TOKEN;
    L36:
        return SHARE_WITH_COMPONET_OPTIMIZE;
    L38:
        return SHARE_WITH_TOKEN;
    L40:
        return SHARE_WITH_COMPONENT;
    L6:
        if (r100.equals("video") == false) goto L23;
        r101 = 4;
        goto L24
    L9:
        if (r100.equals("token") == false) goto L23;
        r101 = 1;
        goto L24
    L12:
        if (r100.equals("image") == false) goto L23;
        r101 = 3;
        goto L24
    L15:
        if (r100.equals(NotificationCompat.CATEGORY_SYSTEM) == false) goto L23;
        r101 = 0;
        goto L24
    L18:
        if (r100.equals("sdk") == false) goto L23;
        r101 = 5;
        goto L24
    L21:
        if (r100.equals("sys_opt") == false) goto L23;
        r101 = 2;
        goto L24
    }

    public static String getStrategyStr(ShareStrategy r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        int r101 = a.f272310a[r100.ordinal()];
        if (r101 != 1) goto L8;
        return NotificationCompat.CATEGORY_SYSTEM;
    L8:
        if (r101 != 2) goto L10;
        return "token";
    L10:
        if (r101 != 3) goto L12;
        return "sys_opt";
    L12:
        if (r101 != 4) goto L14;
        return "image";
    L14:
        if (r101 == 5) goto L17;
        return "sdk";
    L17:
        return "video";
    }

    public static ShareStrategy valueOf(String r100) {
        return (ShareStrategy) r27.a.a(ShareStrategy.class, r100);
    }

    public ShareStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
