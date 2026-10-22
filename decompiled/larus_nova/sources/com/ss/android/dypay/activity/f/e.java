package com.ss.android.dypay.activity.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.ss.android.dypay.activity.DyPayEntranceActivity;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements qta.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f408383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f408384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.dypay.utils.e.a f408385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public vta.b f408386d;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f408387b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f408388c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f408389d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f408390e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ a[] f408391f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408392a;

        static {
            a r100 = new a("CACHE", 0, "cache");
            f408387b = r100;
            a r101 = new a("SYNC_NET", 1, "sync_net");
            f408388c = r101;
            a r102 = new a("REVEAL", 2, "reveal");
            f408389d = r102;
            a r103 = new a("UNKNOWN", 3, "unknown");
            f408390e = r103;
            f408391f = new a[]{r100, r101, r102, r103};
        }

        public a(String r100, int r101, String r102) {
            super(r100, r101);
            this.f408392a = r102;
        }

        public static a valueOf(String r100) {
            return (a) r27.a.a(a.class, r100);
        }

        public static a[] values() {
            return (a[]) f408391f.clone();
        }
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f408393a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f408394b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f408395c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ b[] f408396d = null;

        static {
            b r100 = new b("AWEME_LOGIN_OPT", 0);
            f408393a = r100;
            b r101 = new b("AWEME_LITE_LOGIN_OPT", 1);
            f408394b = r101;
            b r102 = new b("AWEME_HOTSOON_LOGIN_OPT", 2);
            f408395c = r102;
            f408396d = new b[]{r100, r101, r102};
        }

        public b(String r100, int r101) {
            super(r100, r101);
        }

        public static b valueOf(String r100) {
            return (b) r27.a.a(b.class, r100);
        }

        public static b[] values() {
            return (b[]) f408396d.clone();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f408398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.dypay.bean.c f408399c;

        public c(String r100, JSONObject r101, com.ss.android.dypay.bean.c r102) {
            this.f408397a = r100;
            this.f408398b = r101;
            this.f408399c = r102;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L12;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f408397a, r101.f408397a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f408398b, r101.f408398b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f408399c, r101.f408399c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f408397a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            JSONObject r104 = this.f408398b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            com.ss.android.dypay.bean.c r107 = this.f408399c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "PayInfoData(payInfoStr=" + this.f408397a + ", payInfoObj=" + this.f408398b + ", payInfoBean=" + this.f408399c + ")";
        }
    }

    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f408400b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f408401c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f408402d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f408403e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ d[] f408404f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408405a;

        static {
            d r100 = new d(EffectConstants.NORMAL, 0, "");
            f408400b = r100;
            d r101 = new d("LOGIN_OPT", 1, "login_opt");
            f408401c = r101;
            d r102 = new d("H5", 2, "h5");
            f408402d = r102;
            d r103 = new d("NO_RESULT_RETRY", 3, "no_result_retry");
            f408403e = r103;
            f408404f = new d[]{r100, r101, r102, r103};
        }

        public d(String r100, int r101, String r102) {
            super(r100, r101);
            this.f408405a = r102;
        }

        public static d valueOf(String r100) {
            return (d) r27.a.a(d.class, r100);
        }

        public static d[] values() {
            return (d[]) f408404f.clone();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.dypay.activity.f.e$e, reason: collision with other inner class name */
    public final class C4734e extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f408406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f408407b;

        public C4734e(e r100, Function1 r101) {
            this.f408406a = r100;
            this.f408407b = r101;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean r100) {
            boolean r101 = r100.booleanValue();
            if (r101 == false) goto L5;
            this.f408406a.e();
        L5:
            Function1 r102 = this.f408407b;
            if (r102 == null) goto L9;
            Unit r103 = (Unit) r102.invoke(Boolean.valueOf(r101));
        L9:
            return Unit.INSTANCE;
        }
    }

    public e() {
    }

    @Override // qta.b
    public final com.ss.android.dypay.utils.e.a a() {
        com.ss.android.dypay.utils.e.a r100 = this.f408385c;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appStatus");
    L5:
        return r100;
    }

    @Override // qta.b
    public final void b(DyPayEntranceActivity r100, vta.e r101, i.c r102) {
        SharedPreferences r103 = vta.d.f557260a;
        vta.d.c(r100, r101, false, new C4734e(this, r102));
    }

    @Override // qta.b
    public final vta.b c() {
        if (this.f408386d != null) goto L6;
        e();
    L6:
        return this.f408386d;
    }

    @Override // qta.b
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final String mo8600a() {
        c r100 = this.f408384b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("payInfoData");
    L6:
        return r100.f408398b.optString(DyPayConstant.K_PAY_INFO_PARAM_EVOKE_URL);
    }

    @Override // qta.b
    public final String b() {
        c r100 = this.f408384b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("payInfoData");
    L6:
        return r100.f408397a;
    }

    @Override // qta.b
    public final com.ss.android.dypay.bean.c d() {
        c r100 = this.f408384b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("payInfoData");
    L6:
        return r100.f408399c;
    }

    public final void e() {
        SharedPreferences r100 = vta.d.f557260a;
        c r101 = this.f408384b;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("payInfoData");
    L5:
        String r102 = r101.f408399c.f408458b;
        c r103 = this.f408384b;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("payInfoData");
    L8:
        this.f408386d = vta.d.b(r102, r103.f408399c.f408457a);
        String r104 = com.ss.android.dypay.utils.e.f408484a;
        Context r105 = this.f408383a;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L11:
        vta.b r106 = this.f408386d;
        if (r106 == null) goto L16;
        vta.h r107 = r106.f557248a;
        if (r107 == null) goto L16;
        String r108 = r107.f557285m;
    L17:
        this.f408385c = com.ss.android.dypay.utils.e.e(r105, r108);
        return;
    L16:
        r108 = null;
        goto L17
    }

    @Override // qta.b
    public final void a(DyPayEntranceActivity r100, c r101) {
        this.f408383a = r100;
        this.f408384b = r101;
        e();
    }
}
