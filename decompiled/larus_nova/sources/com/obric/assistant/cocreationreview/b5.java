package com.obric.assistant.cocreationreview;

import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f387198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f387199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FeedbackMediaType f387200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f387201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f387202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f387203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f387204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FeedbackMediaUploadState f387205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f387206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f387207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f387208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f387209l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b5) == true) goto L8;
        return false;
    L8:
        b5 r101 = (b5) r100;
        if (Intrinsics.areEqual(this.f387198a, r101.f387198a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f387199b, r101.f387199b) == true) goto L15;
        return false;
    L15:
        if (this.f387200c == r101.f387200c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f387201d, r101.f387201d) == true) goto L21;
        return false;
    L21:
        if (this.f387202e == r101.f387202e) goto L24;
        return false;
    L24:
        if (this.f387203f == r101.f387203f) goto L27;
        return false;
    L27:
        if (this.f387204g == r101.f387204g) goto L30;
        return false;
    L30:
        if (this.f387205h == r101.f387205h) goto L33;
        return false;
    L33:
        if (this.f387206i == r101.f387206i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f387207j, r101.f387207j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f387208k, r101.f387208k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f387209l, r101.f387209l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f387198a.hashCode() * 31) + this.f387199b.hashCode()) * 31) + this.f387200c.hashCode()) * 31) + this.f387201d.hashCode()) * 31;
        long r101 = this.f387202e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        int r103 = 1231;
        if (this.f387203f == false) goto L5;
        int r104 = 1231;
    L6:
        int r105 = (r102 + r104) * 31;
        if (this.f387204g == true) goto L10;
        r103 = 1237;
    L10:
        int r106 = (((((r105 + r103) * 31) + this.f387205h.hashCode()) * 31) + this.f387206i) * 31;
        String r107 = this.f387207j;
        int r108 = 0;
        if (r107 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r106 + r109) * 31;
        String r111 = this.f387208k;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f387209l;
        if (r114 == null) goto L23;
        r108 = r114.hashCode();
    L23:
        return r113 + r108;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r107.hashCode();
        goto L14
    L5:
        r104 = 1237;
        goto L6
    }

    public final String toString() {
        return "FeedbackMediaDraft(id=" + this.f387198a + ", uri=" + this.f387199b + ", type=" + this.f387200c + ", displayName=" + this.f387201d + ", durationMillis=" + this.f387202e + ", isMarked=" + this.f387203f + ", isCropped=" + this.f387204g + ", uploadState=" + this.f387205h + ", uploadProgress=" + this.f387206i + ", uploadIdentifier=" + this.f387207j + ", remoteUri=" + this.f387208k + ", uploadError=" + this.f387209l + ')';
    }

    public final FeedbackMediaType getType() {
        return this.f387200c;
    }

    public /* synthetic */ b5(String r110, String r111, FeedbackMediaType r112, String r210, long r211, FeedbackMediaUploadState r212, int r213, String r214, int r215) {
        if ((r215 & 1) == 0) goto L5;
        String r100 = UUID.randomUUID().toString();
    L7:
        if ((r215 & 16) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r215 & 128) == 0) goto L13;
        FeedbackMediaUploadState r113 = FeedbackMediaUploadState.READY;
    L15:
        if ((r215 & 256) == 0) goto L17;
        int r114 = 0;
    L19:
        if ((r215 & 1024) == 0) goto L21;
        String r115 = null;
    L22:
        this(r100, r111, r112, r210, r101, false, false, r113, r114, null, r115, null);
        return;
    L21:
        r115 = r214;
        goto L22
    L17:
        r114 = r213;
        goto L19
    L13:
        r113 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static b5 a(b5 r110, String r111, String r210, boolean r211, boolean r212, FeedbackMediaUploadState r213, int r214, String r215, String r216, String r217, int r218) {
        FeedbackMediaType r100 = null;
        if ((r218 & 1) == 0) goto L5;
        String r101 = r110.f387198a;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r102 = r110.f387199b;
    L11:
        if ((r218 & 4) == 0) goto L13;
        r100 = r110.f387200c;
    L13:
        FeedbackMediaType r103 = r100;
        if ((r218 & 8) == 0) goto L16;
        String r104 = r110.f387201d;
    L18:
        if ((r218 & 16) == 0) goto L20;
        long r105 = r110.f387202e;
    L21:
        long r106 = r105;
        if ((r218 & 32) == 0) goto L24;
        boolean r112 = r110.f387203f;
    L26:
        if ((r218 & 64) == 0) goto L28;
        boolean r113 = r110.f387204g;
    L30:
        if ((r218 & 128) == 0) goto L32;
        FeedbackMediaUploadState r114 = r110.f387205h;
    L34:
        if ((r218 & 256) == 0) goto L36;
        int r115 = r110.f387206i;
    L38:
        if ((r218 & 512) == 0) goto L40;
        String r116 = r110.f387207j;
    L42:
        if ((r218 & 1024) == 0) goto L44;
        String r117 = r110.f387208k;
    L46:
        if ((r218 & 2048) == 0) goto L48;
        String r118 = r110.f387209l;
    L49:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "uri");
        Intrinsics.checkNotNullParameter(r103, "type");
        Intrinsics.checkNotNullParameter(r104, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r114, "uploadState");
        return new b5(r101, r102, r103, r104, r106, r112, r113, r114, r115, r116, r117, r118);
    L48:
        r118 = r217;
        goto L49
    L44:
        r117 = r216;
        goto L46
    L40:
        r116 = r215;
        goto L42
    L36:
        r115 = r214;
        goto L38
    L32:
        r114 = r213;
        goto L34
    L28:
        r113 = r212;
        goto L30
    L24:
        r112 = r211;
        goto L26
    L20:
        r105 = 0;
        goto L21
    L16:
        r104 = r210;
        goto L18
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public b5(String r100, String r101, FeedbackMediaType r102, String r103, long r104, boolean r105, boolean r106, FeedbackMediaUploadState r110, int r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "uri");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, CommonConstant.KEY_DISPLAY_NAME);
        Intrinsics.checkNotNullParameter(r110, "uploadState");
        this.f387198a = r100;
        this.f387199b = r101;
        this.f387200c = r102;
        this.f387201d = r103;
        this.f387202e = r104;
        this.f387203f = r105;
        this.f387204g = r106;
        this.f387205h = r110;
        this.f387206i = r111;
        this.f387207j = r112;
        this.f387208k = r113;
        this.f387209l = r114;
    }
}
