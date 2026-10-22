package ld7;

import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthErrorCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthMode;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthConfigSource;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthSource;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f508711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f508712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f508713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AuthErrorCode f508714d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AuthSuccessCode f508715e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f508716f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f508717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AuthBridgeAccess f508718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FeAuthConfigSource f508719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AuthBridgeAccess f508720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f508721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f508722l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AuthMode f508723m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JSONObject f508724n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f508725o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f508711a == r101.f508711a) goto L12;
        return false;
    L12:
        if (this.f508712b == r101.f508712b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f508713c, r101.f508713c) == true) goto L18;
        return false;
    L18:
        if (this.f508714d == r101.f508714d) goto L21;
        return false;
    L21:
        if (this.f508715e == r101.f508715e) goto L24;
        return false;
    L24:
        if (this.f508716f == r101.f508716f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f508711a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f508712b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        String r105 = this.f508713c;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        AuthErrorCode r109 = this.f508714d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        AuthSuccessCode r112 = this.f508715e;
        if (r112 == null) goto L22;
        r106 = r112.hashCode();
    L22:
        int r113 = (r111 + r106) * 31;
        if (this.f508716f == true) goto L27;
        r100 = 1237;
    L27:
        return r113 + r100;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AuthResult(passed=" + this.f508711a + ", interrupt=" + this.f508712b + ", status=" + this.f508713c + ", errorCode=" + this.f508714d + ", successCode=" + this.f508715e + ", needReport=" + this.f508716f + ')';
    }

    public final String a() {
        String r100 = this.f508713c;
        AuthErrorCode r101 = this.f508714d;
        AuthSuccessCode r102 = this.f508715e;
        if (r100 != null) goto L15;
        String r103 = null;
        if (r101 == null) goto L7;
        String r104 = r101.getMsg();
    L8:
        if (r104 != null) goto L14;
        if (r102 == null) goto L11;
        r103 = r102.getMsg();
    L11:
        if (r103 != null) goto L16;
        return "";
    L16:
        return r103;
    L14:
        return r104;
    L7:
        r104 = null;
        goto L8
    L15:
        return r100;
    }

    public c(boolean r100, boolean r101, String r102, AuthErrorCode r103, AuthSuccessCode r104, int r105) {
        boolean r106 = false;
        if ((r105 & 2) == 0) goto L6;
        r101 = false;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L15;
        r104 = null;
    L15:
        if ((r105 & 32) == 0) goto L17;
        r106 = true;
    L17:
        this.f508711a = r100;
        this.f508712b = r101;
        this.f508713c = r102;
        this.f508714d = r103;
        this.f508715e = r104;
        this.f508716f = r106;
        this.f508717g = -1;
        this.f508719i = FeAuthConfigSource.UN_KNOWN;
        this.f508725o = FeAuthSource.NULL.getDesc();
    }
}
