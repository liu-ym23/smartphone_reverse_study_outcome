package r06;

import android.app.Application;
import com.bytedance.ies.bullet.secure.f;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.cn.auth.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f535462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f535463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C7412a f535464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Application f535465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f535466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f535467f;

    /* JADX INFO: renamed from: r06.a$a, reason: collision with other inner class name */
    public static final class C7412a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f535468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f535469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f535470c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f535471d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f535472e;

        public C7412a() {
            this(null, null, null, null, false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7412a) == true) goto L8;
            return false;
        L8:
            C7412a r101 = (C7412a) r100;
            if (Intrinsics.areEqual(this.f535468a, r101.f535468a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f535469b, r101.f535469b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f535470c, r101.f535470c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f535471d, r101.f535471d) == true) goto L21;
            return false;
        L21:
            if (this.f535472e == r101.f535472e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f535468a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f535469b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f535470c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f535471d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            int r111 = (r109 + r101) * 31;
            if (this.f535472e == false) goto L21;
            int r112 = 1231;
        L23:
            return r111 + r112;
        L21:
            r112 = 1237;
            goto L23
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "AppEnv(appId=" + this.f535468a + ", appVersion=" + this.f535469b + ", did=" + this.f535470c + ", channel=" + this.f535471d + ", debuggable=" + this.f535472e + ')';
        }

        public C7412a(String r110, String r111, String r112, String r113, boolean r114) {
            this.f535468a = r110;
            this.f535469b = r111;
            this.f535470c = r112;
            this.f535471d = r113;
            this.f535472e = r114;
            if (r111 == null) goto L17;
            List r115 = StringsKt.split$default(r111, new String[]{"."}, false, 0, 6, null);
            ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r115, 10));
            Iterator r116 = r115.iterator();
        L7:
            if (r116.hasNext() == false) goto L12;
            String r117 = (String) r116.next();
            if (r117.length() != 1) goto L11;
            r117 = "0".concat(r117);
        L11:
            r100.add(r117);
            goto L7
        L12:
            CastLongProtector.parseLong(CollectionsKt.joinToString$default(r100, "", null, null, 0, null, null, 62, null));
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r06.b f535473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f535474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f535475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f535476d;

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f535473a, r101.f535473a) == true) goto L12;
            return false;
        L12:
            if (this.f535474b == r101.f535474b) goto L15;
            return false;
        L15:
            if (this.f535475c == r101.f535475c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f535476d, r101.f535476d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            r06.b r100 = this.f535473a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            int r104 = 1231;
            if (this.f535474b == false) goto L9;
            int r105 = 1231;
        L10:
            int r106 = (r103 + r105) * 31;
            if (this.f535475c == true) goto L14;
            r104 = 1237;
        L14:
            int r107 = (r106 + r104) * 31;
            List<String> r108 = this.f535476d;
            if (r108 == null) goto L19;
            r101 = r108.hashCode();
        L19:
            return r107 + r101;
        L9:
            r105 = 1237;
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "HostInitConfig(settings=" + this.f535473a + ", closeLynxVerify=" + this.f535474b + ", enableTTM=" + this.f535475c + ", enableSubprocessList=" + this.f535476d + ')';
        }

        public b(Object r100) {
            this.f535473a = null;
            this.f535474b = false;
            this.f535475c = false;
            this.f535476d = null;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f535462a, r101.f535462a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f535463b, r101.f535463b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f535464c, r101.f535464c) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f535465d, r101.f535465d) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f535466e, r101.f535466e) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f535467f, r101.f535467f) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f535462a.hashCode() * 31;
        g r101 = this.f535463b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + 0) * 31) + this.f535464c.hashCode()) * 31;
        Application r105 = this.f535465d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        d r108 = this.f535466e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        c r111 = this.f535467f;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ArgusInitConfig(hostConfig=" + this.f535462a + ", permissionConfigProvider=" + this.f535463b + ", passportDepend=null, env=" + this.f535464c + ", application=" + this.f535465d + ", uploadSignFailedLynxDepend=" + this.f535466e + ", lifeCycleDepend=" + this.f535467f + ')';
    }

    public a(b r100, C7412a r101, Application r102, f r103, com.bytedance.ies.bullet.secure.g r104) {
        Intrinsics.checkNotNullParameter(r100, "hostConfig");
        Intrinsics.checkNotNullParameter(r101, "env");
        this.f535462a = r100;
        this.f535463b = null;
        this.f535464c = r101;
        this.f535465d = r102;
        this.f535466e = r103;
        this.f535467f = r104;
    }
}
