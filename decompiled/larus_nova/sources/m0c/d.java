package m0c;

import com.ss.android.lark.passportc.api.Scene;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.log.trace.b f511552a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f511553b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f511554c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f511555d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f511556e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f511557f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f511558g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f511559h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f511560i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f511561j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f511562k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f511563l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f511564m = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f511565a = null;

        static {
            int[] r100 = new int[Scene.values().length];
            r100[Scene.FAST_ONLINE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Scene.SWITCH_ONLINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f511565a = r100;
        }
    }

    static {
        f511552a = new com.ss.android.lark.log.trace.b();
        f511553b = "OfflineForeground";
        f511554c = "OfflineTransfer";
        f511555d = "BringNewOnline";
        f511556e = "SwapTransfer";
        f511557f = "OnlineTransfer";
        f511558g = "ComponentTask";
        f511559h = "NotifyChange";
        f511560i = "NotifyGlobalUserOffline";
        f511561j = "NotifyGlobalUserChange";
        f511562k = "NotifyGlobalUserOnline";
        f511563l = "NotifyUserOffline";
        f511564m = "NotifyUserOnline";
    }

    public static com.ss.android.lark.log.trace.b a(Scene r100) {
        if (r100 != null) goto L4;
        int r101 = -1;
    L6:
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L11;
        return f511552a;
    L11:
        return f511552a;
    L4:
        r101 = a.f511565a[r100.ordinal()];
        goto L6
    }
}
