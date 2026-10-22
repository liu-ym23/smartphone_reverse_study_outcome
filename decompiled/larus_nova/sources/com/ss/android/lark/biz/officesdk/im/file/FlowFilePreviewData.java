package com.ss.android.lark.biz.officesdk.im.file;

import com.obric.miniapp.alarm.AccountType;
import jza.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class FlowFilePreviewData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f410580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Source f410581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f410582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f410583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f410584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f410585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f410586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f410587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f410588i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/file/FlowFilePreviewData$Source;", "", "<init>", "(Ljava/lang/String;I)V", AccountType.LOCAL, "DRIVE", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source DRIVE = null;
        public static final Source LOCAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f410589a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410590b = null;

        public static EnumEntries<Source> getEntries() {
            return f410590b;
        }

        static {
            Source r100 = new Source(AccountType.LOCAL, 0);
            LOCAL = r100;
            Source r101 = new Source("DRIVE", 1);
            DRIVE = r101;
            Source[] r102 = {r100, r101};
            f410589a = r102;
            f410590b = EnumEntriesKt.enumEntries(r102);
        }

        public static Source[] values() {
            return (Source[]) f410589a.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowFilePreviewData) == true) goto L8;
        return false;
    L8:
        FlowFilePreviewData r101 = (FlowFilePreviewData) r100;
        if (Intrinsics.areEqual(this.f410580a, r101.f410580a) == true) goto L12;
        return false;
    L12:
        if (this.f410581b == r101.f410581b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410582c, r101.f410582c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410583d, r101.f410583d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f410584e, r101.f410584e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f410585f, r101.f410585f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f410586g, r101.f410586g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f410587h, r101.f410587h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f410588i, r101.f410588i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f410580a.hashCode() * 31) + this.f410581b.hashCode()) * 31;
        String r101 = this.f410582c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f410583d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f410584e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f410585f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f410586g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.f410587h;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return ((r116 + r102) * 31) + this.f410588i.hashCode();
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
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
        return "FlowFilePreviewData(messageId=" + this.f410580a + ", source=" + this.f410581b + ", previewUrl=" + this.f410582c + ", fileName=" + this.f410583d + ", localFilePath=" + this.f410584e + ", fileToken=" + this.f410585f + ", fileType=" + this.f410586g + ", driveFileType=" + this.f410587h + ", securityContext=" + this.f410588i + ')';
    }

    public static FlowFilePreviewData a(FlowFilePreviewData r110, Source r111, String r112, String r113, Long r114, int r115) {
        a r100 = null;
        if ((r115 & 1) == 0) goto L5;
        String r101 = r110.f410580a;
    L7:
        if ((r115 & 2) == 0) goto L9;
        Source r102 = r110.f410581b;
    L11:
        if ((r115 & 4) == 0) goto L13;
        String r103 = r110.f410582c;
    L15:
        if ((r115 & 8) == 0) goto L17;
        String r104 = r110.f410583d;
    L19:
        if ((r115 & 16) == 0) goto L21;
        String r105 = r110.f410584e;
    L23:
        if ((r115 & 32) == 0) goto L25;
        String r116 = r110.f410585f;
    L27:
        if ((r115 & 64) == 0) goto L29;
        String r117 = r110.f410586g;
    L31:
        if ((r115 & 128) == 0) goto L33;
        Long r118 = r110.f410587h;
    L35:
        if ((r115 & 256) == 0) goto L37;
        r100 = r110.f410588i;
    L37:
        a r119 = r100;
        r110.getClass();
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r119, "securityContext");
        return new FlowFilePreviewData(r101, r102, r103, r104, r105, r116, r117, r118, r119);
    L33:
        r118 = r114;
        goto L35
    L29:
        r117 = r113;
        goto L31
    L25:
        r116 = r112;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public FlowFilePreviewData(String r100, Source r101, String r102, String r103, String r104, String r105, String r106, Long r107, a r110) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r110, "securityContext");
        this.f410580a = r100;
        this.f410581b = r101;
        this.f410582c = r102;
        this.f410583d = r103;
        this.f410584e = r104;
        this.f410585f = r105;
        this.f410586g = r106;
        this.f410587h = r107;
        this.f410588i = r110;
    }
}
