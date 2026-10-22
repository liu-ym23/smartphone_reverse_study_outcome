package lo7;

import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f510145a = null;

    static {
        int[] r100 = new int[ShareChannelType.values().length];
        f510145a = r100;
        r100[ShareChannelType.COPY_LINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
    L26:
        f510145a[ShareChannelType.SYSTEM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
    L32:
        f510145a[ShareChannelType.SMS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
    L42:
        f510145a[ShareChannelType.EMAIL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
    L28:
        f510145a[ShareChannelType.FACEBOOK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
    L34:
        f510145a[ShareChannelType.QQ.ordinal()] = 6;     // Catch: NoSuchFieldError -> L19
    L36:
        f510145a[ShareChannelType.WEIBO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L20
    L38:
        f510145a[ShareChannelType.WEIBO_SG.ordinal()] = 8;     // Catch: NoSuchFieldError -> L21
    L24:
        f510145a[ShareChannelType.QZONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L22
    L30:
        f510145a[ShareChannelType.MESSENGER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L23
        return;
    }
}
