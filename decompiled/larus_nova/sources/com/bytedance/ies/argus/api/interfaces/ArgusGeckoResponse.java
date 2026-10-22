package com.bytedance.ies.argus.api.interfaces;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final class ArgusGeckoResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f245636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f245637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f245638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f245639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f245640e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f245641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f245642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f245643h;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/api/interfaces/ArgusGeckoResponse$GeckoVersionId;", "", "", "string", "Ljava/lang/String;", "getString", "()Ljava/lang/String;", "UNSET", "PKG_NOT_FOUND", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum GeckoVersionId extends Enum<GeckoVersionId> {
        public static final GeckoVersionId PKG_NOT_FOUND = null;
        public static final GeckoVersionId UNSET = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GeckoVersionId[] f245644a = null;
        private final String string;

        public static GeckoVersionId valueOf(String r100) {
            return (GeckoVersionId) a.a(GeckoVersionId.class, r100);
        }

        public static GeckoVersionId[] values() {
            return (GeckoVersionId[]) f245644a.clone();
        }

        static {
            GeckoVersionId r100 = new GeckoVersionId("UNSET", 0, "-2");
            UNSET = r100;
            GeckoVersionId r101 = new GeckoVersionId("PKG_NOT_FOUND", 1, "-1");
            PKG_NOT_FOUND = r101;
            f245644a = new GeckoVersionId[]{r100, r101};
        }

        public final String getString() {
            return this.string;
        }

        public GeckoVersionId(String r100, int r101, String r102) {
            super(r100, r101);
            this.string = r102;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ArgusGeckoResponse) == true) goto L8;
        return false;
    L8:
        ArgusGeckoResponse r101 = (ArgusGeckoResponse) r100;
        if (this.f245636a == r101.f245636a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f245637b, r101.f245637b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f245638c, r101.f245638c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f245639d, r101.f245639d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f245640e, r101.f245640e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f245641f, r101.f245641f) == true) goto L27;
        return false;
    L27:
        if (this.f245642g == r101.f245642g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f245643h, r101.f245643h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f245636a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        JSONObject r103 = this.f245637b;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f245638c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f245639d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f245640e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f245641f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f245642g == true) goto L30;
        r100 = 1237;
    L30:
        int r119 = (r118 + r100) * 31;
        String r120 = this.f245643h;
        if (r120 == null) goto L35;
        r104 = r120.hashCode();
    L35:
        return r119 + r104;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "ArgusGeckoResponse(isSucceed=" + this.f245636a + ", jsonResponse=" + this.f245637b + ", msg=" + this.f245638c + ", geckoVersion=" + this.f245639d + ", fetchUrl=" + this.f245640e + ", requestLogId=" + this.f245641f + ", fromRetry=" + this.f245642g + ", networkLogicVersion=" + this.f245643h + ')';
    }

    public ArgusGeckoResponse(boolean r100, int r101) {
        if ((r101 & 8) == 0) goto L5;
        String r102 = GeckoVersionId.UNSET.getString();
    L6:
        this.f245636a = r100;
        this.f245637b = null;
        this.f245638c = null;
        this.f245639d = r102;
        this.f245640e = null;
        this.f245641f = null;
        this.f245642g = false;
        this.f245643h = null;
        return;
    L5:
        r102 = null;
        goto L6
    }
}
