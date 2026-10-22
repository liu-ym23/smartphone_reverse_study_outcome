package w85;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority$DownloadPriority;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.lark.pb.space.drive.v1.CoverDownloadInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f558626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DownloadRequestInfo.DownloadType f558627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f558628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f558629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f558630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f558631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f558632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f558633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f558634i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f558635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DownloadRequestInfo.b f558636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f558637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f558638m;

    /* JADX INFO: renamed from: w85.a$a, reason: collision with other inner class name */
    public static final class C8081a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f558639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public DownloadRequestInfo.DownloadType f558640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f558641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f558642d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f558643e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f558644f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f558645g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f558646h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f558647i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public b f558648j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DownloadRequestInfo.b f558649k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f558650l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f558651m;

        public final a a() {
            return new a(this);
        }

        public C8081a() {
            this.f558639a = false;
            this.f558640b = DownloadRequestInfo.DownloadType.DRIVE;
            this.f558641c = true;
            this.f558642d = "";
            this.f558643e = "";
            this.f558644f = "";
            this.f558645g = "";
            this.f558646h = "";
            this.f558647i = 2;
            this.f558648j = null;
            this.f558650l = DrivePriority$DownloadPriority.USER_INTERACTION.getPriority();
        }
    }

    public interface b {
        void a(String r100, String r101, int r102);

        void c(String r100, w85.b r101);

        void e(String r100);
    }

    public final String toString() {
        return "DriveImageRequest{isAsync=" + this.f558626a + ", downloadType=" + this.f558627b + ", connect=" + this.f558628c + ", url='" + du5.b.f(this.f558629d) + "', fileToken='" + du5.b.g(this.f558630e) + "', mountNodeToken='" + du5.b.g(this.f558631f) + "', mountPoint='" + this.f558632g + "', callback=" + this.f558633h + ", docToken='" + du5.b.g(this.f558634i) + "', docType=" + this.f558635j + ", coverInfo=" + this.f558636k + ", priority=" + this.f558637l + ", disableCdn=false, extra='" + du5.b.f(this.f558638m) + "'}";
    }

    public a(C8081a r100) {
        this.f558626a = r100.f558639a;
        DownloadRequestInfo.DownloadType r101 = r100.f558640b;
        this.f558627b = r101;
        this.f558628c = r100.f558641c;
        String r102 = r100.f558642d;
        this.f558629d = r102;
        this.f558630e = r100.f558643e;
        this.f558631f = r100.f558644f;
        this.f558632g = r100.f558645g;
        this.f558633h = r100.f558648j;
        this.f558634i = r100.f558646h;
        this.f558635j = r100.f558647i;
        this.f558636k = r100.f558649k;
        this.f558637l = r100.f558650l;
        this.f558638m = r100.f558651m;
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f558630e) == false) goto L28;
        Uri r103 = UriProtector.parse(r102);     // Catch: Throwable -> L22
        this.f558630e = r103.getLastPathSegment();     // Catch: Throwable -> L22
        String r104 = UriProtector.getQueryParameter(r103, DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN);     // Catch: Throwable -> L22
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        this.f558631f = r104;     // Catch: Throwable -> L22
        this.f558632g = a(r103);     // Catch: Throwable -> L22
        if (r101 == DownloadRequestInfo.DownloadType.COVER) goto L12;
        return;
    L12:
        if (this.f558636k != null) goto L30;
        String r105 = UriProtector.getQueryParameter(r103, "width");     // Catch: Throwable -> L22
        String r106 = UriProtector.getQueryParameter(r103, "height");     // Catch: Throwable -> L22
        String r107 = UriProtector.getQueryParameter(r103, "policy");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r105) == false) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r106) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r107) == false) goto L20;
        r107 = CoverDownloadInfo.DEFAULT_POLICY;
    L20:
        this.f558636k = new DownloadRequestInfo.b(CastIntegerProtector.parseInt(r105), CastIntegerProtector.parseInt(r106), r107, true);     // Catch: Throwable -> L22
        return;
    L30:
        return;
    L22:
        th = move-exception;
        tt5.a.e("DriveImageRequest", "parse url error! " + this.f558629d, th, false);
        return;
    }

    public final String a(Uri r110) {
        String r111 = UriProtector.getQueryParameter(r110, DrivePreviewOpenItem.EXTRA_MOUNT_POINT);
        String r100 = "doc_image";
        if ("doc".equals(r111) == false) goto L6;
        r111 = "doc_image";
    L6:
        if (TextUtils.isEmpty(r111) == false) goto L51;
        String r112 = this.f558631f;
        if (TextUtils.isEmpty(r112) == true) goto L10;
    L12:
        byte r101 = 0;
        String r113 = r112.substring(0, 3);
        r113.getClass();
        switch(r113.hashCode()) {
            case 97667: goto L36;
            case 97739: goto L32;
            case 99640: goto L28;
            case 113855: goto L24;
            case 113963: goto L20;
            case 117721: goto L16;
            default: goto L37;
        };
    L37:
        r101 = -1;
    L38:
        if (r101 == 0) goto L49;
        if (r101 == 1) goto L48;
        if (r101 == 2) goto L47;
        if (r101 == 3) goto L46;
        if (r101 == 4) goto L45;
        if (r101 == 5) goto L47;
    L44:
        r111 = "";
        goto L51
    L45:
        r111 = "slides_image";
        goto L51
    L46:
        r111 = "sheet_image";
    L47:
        r111 = "doc_image";
        goto L51
    L48:
        r111 = FileInfoPuller.CALLER_EXPLORER;
        goto L51
    L49:
        r111 = "mindnote_image";
        goto L51
    L16:
        if (r113.equals("wik") == false) goto L37;
        r101 = 5;
        goto L38
    L20:
        if (r113.equals("sld") == false) goto L37;
        r101 = 4;
        goto L38
    L24:
        if (r113.equals("sht") == false) goto L37;
        r101 = 3;
        goto L38
    L28:
        if (r113.equals("doc") == false) goto L37;
        r101 = 2;
        goto L38
    L32:
        if (r113.equals("box") == false) goto L37;
        r101 = 1;
        goto L38
    L36:
        if (r113.equals("bmn") == true) goto L38;
    L10:
        if (r112.length() >= 4) goto L12;
    L51:
        if (TextUtils.isEmpty(r111) == false) goto L73;
        int r114 = this.f558635j;
        if (r114 == 2) goto L71;
        if (r114 != 3) goto L56;
        r100 = "sheet_image";
        goto L71
    L56:
        if (r114 != 8) goto L58;
        r100 = "bitable_image";
        goto L71
    L58:
        if (r114 == 16) goto L71;
        if (r114 != 30) goto L62;
        r100 = "slides_image";
        goto L71
    L62:
        if (r114 != 11) goto L64;
        r100 = "mindnote_image";
        goto L71
    L64:
        if (r114 == 12) goto L66;
        r100 = "";
        goto L71
    L66:
        r100 = FileInfoPuller.CALLER_EXPLORER;
    L71:
        r111 = r100;
    L73:
        if (TextUtils.isEmpty(this.f558632g) == false) goto L76;
        r111 = this.f558632g;
    L76:
        if (TextUtils.isEmpty(r111) == false) goto L79;
        return "unknown";
    L79:
        return r111;
    }
}
