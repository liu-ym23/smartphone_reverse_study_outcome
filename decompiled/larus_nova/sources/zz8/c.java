package zz8;

import com.larus.common.account.platform.larkauth.model.LarkAuthAccountKind;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zz8.a f574102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zz8.b f574103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f574104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f574105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f574106e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f574107f;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f574108a = null;

        static {
            int[] r100 = new int[LarkAuthAccountKind.values().length];
            r100[LarkAuthAccountKind.LOGIN_B.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[LarkAuthAccountKind.LOGIN_C.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[LarkAuthAccountKind.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f574108a = r100;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f574102a, r101.f574102a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f574103b, r101.f574103b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f574104c, r101.f574104c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f574105d, r101.f574105d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f574106e, r101.f574106e) == true) goto L24;
        return false;
    L24:
        if (this.f574107f == r101.f574107f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        zz8.a r100 = this.f574102a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        zz8.b r104 = this.f574103b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((((((r103 + r101) * 31) + this.f574104c.hashCode()) * 31) + this.f574105d.hashCode()) * 31) + this.f574106e.hashCode()) * 31;
        if (this.f574107f == false) goto L13;
        int r106 = 1231;
    L15:
        return r105 + r106;
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkAuthOptions(loginAuth=" + this.f574102a + ", enterpriseAuth=" + this.f574103b + ", authorizationCacheKey=" + this.f574104c + ", dPopKeyAlias=" + this.f574105d + ", dPopHeartbeatUrl=" + this.f574106e + ", separateCacheByAccountKind=" + this.f574107f + ')';
    }

    public final String a(LarkAuthAccountKind r100) {
        Intrinsics.checkNotNullParameter(r100, "accountKind");
        if (this.f574107f == false) goto L10;
        if (r100 == LarkAuthAccountKind.UNKNOWN) goto L10;
        return this.f574104c + '_' + r100.name().toLowerCase(Locale.ROOT);
    L10:
        return this.f574104c;
    }

    public c(zz8.a r100, zz8.b r101) {
        Intrinsics.checkNotNullParameter("key_authorization_data", "authorizationCacheKey");
        Intrinsics.checkNotNullParameter("dpop_key", "dPopKeyAlias");
        Intrinsics.checkNotNullParameter("https://accounts.feishu.cn/accounts/status/heartbeat", "dPopHeartbeatUrl");
        this.f574102a = r100;
        this.f574103b = r101;
        this.f574104c = "key_authorization_data";
        this.f574105d = "dpop_key";
        this.f574106e = "https://accounts.feishu.cn/accounts/status/heartbeat";
        this.f574107f = false;
    }
}
