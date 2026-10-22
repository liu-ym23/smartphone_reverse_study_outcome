package nfb;

import com.ss.android.lark.chat.entity.message.content.FilePreviewStage;
import com.ss.android.lark.filedetail.impl.folder.manage.entity.FileType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f518975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileType f518976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f518977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f518978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f518979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f518980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f518981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f518982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f518983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FilePreviewStage f518984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f518985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f518986l;

    /* JADX INFO: renamed from: nfb.a$a, reason: collision with other inner class name */
    public static final class C6924a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f518987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FileType f518988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f518989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f518990d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f518991e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f518992f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f518993g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f518994h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f518995i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public FilePreviewStage f518996j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f518997k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f518998l;

        public final a a() {
            return new a(this.f518987a, this.f518988b, this.f518989c, this.f518990d, this.f518991e, this.f518992f, this.f518993g, this.f518994h, this.f518995i, this.f518996j, this.f518997k, this.f518998l);
        }

        public C6924a() {
            this.f518987a = "";
            this.f518988b = FileType.FOLDER;
            this.f518989c = "";
            this.f518993g = "";
            this.f518994h = "";
            this.f518996j = FilePreviewStage.UnknownStage;
        }
    }

    public final int hashCode() {
        int r100 = ((((this.f518975a.hashCode() * 31) + this.f518976b.hashCode()) * 31) + this.f518977c.hashCode()) * 31;
        long r101 = this.f518978d;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f518979e;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f518980f;
        int r106 = (((((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f518981g.hashCode()) * 31) + this.f518982h.hashCode()) * 31;
        String r107 = this.f518983i;
        int r108 = 0;
        if (r107 != null) goto L5;
        int r109 = 0;
    L6:
        int r110 = (r106 + r109) * 31;
        FilePreviewStage r111 = this.f518984j;
        if (r111 != null) goto L9;
        int r112 = 0;
    L10:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f518985k;
        if (r114 != null) goto L13;
        int r115 = 0;
    L14:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f518986l;
        if (r117 == null) goto L19;
        r108 = r117.hashCode();
    L19:
        return r116 + r108;
    L13:
        r115 = r114.hashCode();
        goto L14
    L9:
        r112 = r111.hashCode();
        goto L10
    L5:
        r109 = r107.hashCode();
        goto L6
    }

    public final String toString() {
        return "FilePreviewInfo(key=" + this.f518975a + ", type=" + this.f518976b + ", name=" + this.f518977c + ", size=" + this.f518978d + ", createTime=" + this.f518979e + ", ownerId=" + this.f518980f + ", ownerName=" + this.f518981g + ", path=" + this.f518982h + ", previewImageKey=" + this.f518983i + ", filePreviewStage=" + this.f518984j + ", previewId=" + this.f518985k + ", msgLinkToken=" + this.f518986l + ')';
    }

    public final FileType getType() {
        return this.f518976b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.filedetail.impl.folder.manage.entity.FilePreviewInfo");
        if (Intrinsics.areEqual(this.f518975a, ((a) r100).f518975a) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public a(String r100, FileType r101, String r110, long r111, long r112, long r113, String r114, String r115, String r116, FilePreviewStage r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r110, "name");
        Intrinsics.checkNotNullParameter(r114, "ownerName");
        Intrinsics.checkNotNullParameter(r115, "path");
        this.f518975a = r100;
        this.f518976b = r101;
        this.f518977c = r110;
        this.f518978d = r111;
        this.f518979e = r112;
        this.f518980f = r113;
        this.f518981g = r114;
        this.f518982h = r115;
        this.f518983i = r116;
        this.f518984j = r210;
        this.f518985k = r211;
        this.f518986l = r212;
    }
}
