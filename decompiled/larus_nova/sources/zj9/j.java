package zj9;

import com.larus.account.base.model.LoginPlatform;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f572536a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f572537a = null;

        static {
            int[] r100 = new int[LoginPlatform.values().length];
            r100[LoginPlatform.GOOGLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[LoginPlatform.DOUYIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[LoginPlatform.LINE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[LoginPlatform.FACEBOOK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[LoginPlatform.PHONE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[LoginPlatform.WEIXIN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f572537a = r100;
        }
    }

    static {
    }

    public static LoginPlatform a(String r100) {
        switch(r100.hashCode()) {
            case -1325936172: goto L26;
            case -1240244679: goto L22;
            case -791770330: goto L18;
            case 3321844: goto L14;
            case 497130182: goto L10;
            case 1903765666: goto L6;
            default: goto L30;
        };
    L6:
        if (r100.equals("phone_verify_code") == false) goto L30;
        return LoginPlatform.PHONE;
    L10:
        if (r100.equals("facebook") == false) goto L30;
        return LoginPlatform.FACEBOOK;
    L14:
        if (r100.equals("line") == false) goto L30;
        return LoginPlatform.LINE;
    L18:
        if (r100.equals("wechat") == false) goto L30;
        return LoginPlatform.WEIXIN;
    L22:
        if (r100.equals("google") == false) goto L30;
        return LoginPlatform.GOOGLE;
    L26:
        if (r100.equals("douyin") == false) goto L30;
        return LoginPlatform.DOUYIN;
    L30:
        return LoginPlatform.UNKNOWN;
    }
}
