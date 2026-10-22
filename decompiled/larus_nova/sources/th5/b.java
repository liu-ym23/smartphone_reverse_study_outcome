package th5;

import android.content.Context;
import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.ee.bear.middleground.permission.external.EntityType;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f545938l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f545939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f545941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f545942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SceneType f545943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final EntityType f545944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f545945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f545946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<String, Serializable> f545947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f545948j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f545949k;

    public static final class a {
        @JvmStatic
        public static boolean a(int r100) {
            if (r100 != SceneType.INVITE_EXTERNAL_MEMBER.getValue()) goto L5;
        L24:
            return true;
        L5:
            if (r100 == SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER.getValue()) goto L24;
            if (r100 == SceneType.IM_SHARE_EXTERNAL_MEMBER.getValue()) goto L24;
            if (r100 == SceneType.IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER.getValue()) goto L24;
            if (r100 == SceneType.PASSWORD_SHARE.getValue()) goto L24;
            if (r100 == SceneType.WECHAT_SHARE.getValue()) goto L24;
            if (r100 == SceneType.WECHAT_MOMENTS_SHARE.getValue()) goto L24;
            if (r100 == SceneType.QQ_SHARE.getValue()) goto L24;
            if (r100 == SceneType.WEIBO_SHARE.getValue()) goto L24;
            if (r100 == SceneType.MORE_SHARE.getValue()) goto L24;
            return false;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f545939a, r101.f545939a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f545940b, r101.f545940b) == true) goto L15;
        return false;
    L15:
        if (this.f545941c == r101.f545941c) goto L18;
        return false;
    L18:
        if (this.f545942d == r101.f545942d) goto L21;
        return false;
    L21:
        if (this.f545943e == r101.f545943e) goto L24;
        return false;
    L24:
        if (this.f545944f == r101.f545944f) goto L27;
        return false;
    L27:
        if (this.f545945g == r101.f545945g) goto L30;
        return false;
    L30:
        if (this.f545946h == r101.f545946h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f545947i, r101.f545947i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f545948j, r101.f545948j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f545949k, r101.f545949k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f545939a.hashCode() * 31) + this.f545940b.hashCode()) * 31) + this.f545941c) * 31;
        if (this.f545942d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (((r100 + r101) * 31) + this.f545943e.hashCode()) * 31;
        EntityType r103 = this.f545944f;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((((r102 + r105) * 31) + this.f545945g) * 31) + this.f545946h) * 31;
        HashMap<String, Serializable> r107 = this.f545947i;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f545948j;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f545949k;
        if (r113 == null) goto L23;
        r104 = r113.hashCode();
    L23:
        return r112 + r104;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AdjustExternalParams(context=" + this.f545939a + ", token=" + this.f545940b + ", type=" + this.f545941c + ", isWiki=" + this.f545942d + ", sceneType=" + this.f545943e + ", entityType=" + this.f545944f + ", shareExternal=" + this.f545945g + ", sharePartnerTenant=" + this.f545946h + ", statisticParams=" + this.f545947i + ", updatePermissionType=" + this.f545948j + ", updatePermissionInfo=" + this.f545949k + ')';
    }

    public final Context getContext() {
        return this.f545939a;
    }

    public final int getType() {
        return this.f545941c;
    }

    public /* synthetic */ b(Context r110, String r111, int r112, boolean r113, SceneType r114, EntityType r115, int r116, int r210, HashMap r211) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, null, null);
    }

    public b(Context r100, String r101, int r102, boolean r103, SceneType r104, EntityType r105, int r106, int r107, HashMap<String, Serializable> r110, Integer r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "token");
        Intrinsics.checkNotNullParameter(r104, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        this.f545939a = r100;
        this.f545940b = r101;
        this.f545941c = r102;
        this.f545942d = r103;
        this.f545943e = r104;
        this.f545944f = r105;
        this.f545945g = r106;
        this.f545946h = r107;
        this.f545947i = r110;
        this.f545948j = r111;
        this.f545949k = r112;
    }
}
