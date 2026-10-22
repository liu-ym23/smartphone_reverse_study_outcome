package th5;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.external.EntityType;
import com.bytedance.ee.bear.middleground.permission.external.SceneType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int l = 0;
    public final Context a;
    public final String b;
    public final int c;
    public final boolean d;
    public final SceneType e;
    public final EntityType f;
    public final int g;
    public final int h;
    public final HashMap<String, Serializable> i;
    public final Integer j;
    public final String k;

    public static final class a {
        @JvmStatic
        public static boolean a(int r1) {
            if (r1 != SceneType.INVITE_EXTERNAL_MEMBER.getValue()) goto L5;
        L24:
            return true;
        L5:
            if (r1 == SceneType.INVITE_EXTERNAL_PARTNER_TENANT_MEMBER.getValue()) goto L24;
            if (r1 == SceneType.IM_SHARE_EXTERNAL_MEMBER.getValue()) goto L24;
            if (r1 == SceneType.IM_SHARE_EXTERNAL_PARTNER_TENANT_MEMBER.getValue()) goto L24;
            if (r1 == SceneType.PASSWORD_SHARE.getValue()) goto L24;
            if (r1 == SceneType.WECHAT_SHARE.getValue()) goto L24;
            if (r1 == SceneType.WECHAT_MOMENTS_SHARE.getValue()) goto L24;
            if (r1 == SceneType.QQ_SHARE.getValue()) goto L24;
            if (r1 == SceneType.WEIBO_SHARE.getValue()) goto L24;
            if (r1 == SceneType.MORE_SHARE.getValue()) goto L24;
            return false;
        }
    }

    static {
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((r0 + r1) * 31) + this.e.hashCode()) * 31;
        EntityType r3 = this.f;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((((r2 + r5) * 31) + this.g) * 31) + this.h) * 31;
        HashMap<String, Serializable> r7 = this.i;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.j;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.k;
        if (r13 == null) goto L23;
        r4 = r13.hashCode();
    L23:
        return r12 + r4;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AdjustExternalParams(context=" + this.a + ", token=" + this.b + ", type=" + this.c + ", isWiki=" + this.d + ", sceneType=" + this.e + ", entityType=" + this.f + ", shareExternal=" + this.g + ", sharePartnerTenant=" + this.h + ", statisticParams=" + this.i + ", updatePermissionType=" + this.j + ", updatePermissionInfo=" + this.k + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public final int getType() {
        return this.c;
    }

    public /* synthetic */ b(Context r13, String r14, int r15, boolean r16, SceneType r17, EntityType r18, int r19, int r20, HashMap r21) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, r21, null, null);
    }

    public b(Context r2, String r3, int r4, boolean r5, SceneType r6, EntityType r7, int r8, int r9, HashMap<String, Serializable> r10, Integer r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "sceneType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }
}
