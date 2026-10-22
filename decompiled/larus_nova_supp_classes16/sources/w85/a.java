package w85;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final boolean a;
    public final DownloadRequestInfo.DownloadType b;
    public final boolean c;
    public final String d;
    public String e;
    public String f;
    public String g;
    public final b h;
    public final String i;
    public final int j;
    public DownloadRequestInfo.b k;
    public final int l;
    public final String m;

    /* JADX INFO: renamed from: w85.a$a, reason: collision with other inner class name */
    public static final class C0319a {
        public boolean a;
        public DownloadRequestInfo.DownloadType b;
        public boolean c;
        public String d;
        public String e;
        public final String f;
        public String g;
        public String h;
        public int i;
        public b j;
        public DownloadRequestInfo.b k;
        public int l;
        public String m;

        public final a a() {
            return new a(this);
        }

        public C0319a() {
            this.a = false;
            this.b = DownloadRequestInfo.DownloadType.DRIVE;
            this.c = true;
            this.d = "";
            this.e = "";
            this.f = "";
            this.g = "";
            this.h = "";
            this.i = 2;
            this.j = null;
            this.l = DrivePriority.DownloadPriority.USER_INTERACTION.getPriority();
        }
    }

    public interface b {
        void a(String r1, String r2, int r3);

        void c(String r1, w85.b r2);

        void e(String r1);
    }

    public final String toString() {
        return "DriveImageRequest{isAsync=" + this.a + ", downloadType=" + this.b + ", connect=" + this.c + ", url='" + du5.b.f(this.d) + "', fileToken='" + du5.b.g(this.e) + "', mountNodeToken='" + du5.b.g(this.f) + "', mountPoint='" + this.g + "', callback=" + this.h + ", docToken='" + du5.b.g(this.i) + "', docType=" + this.j + ", coverInfo=" + this.k + ", priority=" + this.l + ", disableCdn=false, extra='" + du5.b.f(this.m) + "'}";
    }

    public a(C0319a r5) {
        this.a = r5.a;
        DownloadRequestInfo.DownloadType r0 = r5.b;
        this.b = r0;
        this.c = r5.c;
        String r1 = r5.d;
        this.d = r1;
        this.e = r5.e;
        this.f = r5.f;
        this.g = r5.g;
        this.h = r5.j;
        this.i = r5.h;
        this.j = r5.i;
        this.k = r5.k;
        this.l = r5.l;
        this.m = r5.m;
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.e) == false) goto L28;
        Uri r6 = UriProtector.parse(r1);     // Catch: Throwable -> L22
        this.e = r6.getLastPathSegment();     // Catch: Throwable -> L22
        String r2 = UriProtector.getQueryParameter(r6, DrivePreviewOpenItem.EXTRA_MOUNT_NODE_TOKEN);     // Catch: Throwable -> L22
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        this.f = r2;     // Catch: Throwable -> L22
        this.g = a(r6);     // Catch: Throwable -> L22
        if (r0 == DownloadRequestInfo.DownloadType.COVER) goto L12;
        return;
    L12:
        if (this.k != null) goto L30;
        String r3 = UriProtector.getQueryParameter(r6, "width");     // Catch: Throwable -> L22
        String r4 = UriProtector.getQueryParameter(r6, "height");     // Catch: Throwable -> L22
        String r7 = UriProtector.getQueryParameter(r6, "policy");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r3) == false) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(r4) == false) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r7) == false) goto L20;
        r7 = "equal";
    L20:
        this.k = new DownloadRequestInfo.b(CastIntegerProtector.parseInt(r3), CastIntegerProtector.parseInt(r4), r7, true);     // Catch: Throwable -> L22
        return;
    L30:
        return;
    L22:
        th = move-exception;
        tt5.a.e("DriveImageRequest", "parse url error! " + this.d, th, false);
        return;
    }

    public final String a(Uri r16) {
        String r17 = UriProtector.getQueryParameter(r16, DrivePreviewOpenItem.EXTRA_MOUNT_POINT);
        String r2 = "doc_image";
        if ("doc".equals(r17) == false) goto L6;
        r17 = "doc_image";
    L6:
        if (TextUtils.isEmpty(r17) == false) goto L51;
        String r18 = this.f;
        if (TextUtils.isEmpty(r18) == true) goto L10;
    L12:
        byte r1 = 0;
        String r19 = r18.substring(0, 3);
        r19.getClass();
        switch(r19.hashCode()) {
            case 97667: goto L36;
            case 97739: goto L32;
            case 99640: goto L28;
            case 113855: goto L24;
            case 113963: goto L20;
            case 117721: goto L16;
            default: goto L37;
        };
    L37:
        r1 = -1;
    L38:
        if (r1 == 0) goto L49;
        if (r1 == 1) goto L48;
        if (r1 == 2) goto L47;
        if (r1 == 3) goto L46;
        if (r1 == 4) goto L45;
        if (r1 == 5) goto L47;
    L44:
        r17 = "";
        goto L51
    L45:
        r17 = "slides_image";
        goto L51
    L46:
        r17 = "sheet_image";
    L47:
        r17 = "doc_image";
        goto L51
    L48:
        r17 = FileInfoPuller.CALLER_EXPLORER;
        goto L51
    L49:
        r17 = "mindnote_image";
        goto L51
    L16:
        if (r19.equals("wik") == false) goto L37;
        r1 = 5;
        goto L38
    L20:
        if (r19.equals("sld") == false) goto L37;
        r1 = 4;
        goto L38
    L24:
        if (r19.equals("sht") == false) goto L37;
        r1 = 3;
        goto L38
    L28:
        if (r19.equals("doc") == false) goto L37;
        r1 = 2;
        goto L38
    L32:
        if (r19.equals("box") == false) goto L37;
        r1 = 1;
        goto L38
    L36:
        if (r19.equals("bmn") == true) goto L38;
    L10:
        if (r18.length() >= 4) goto L12;
    L51:
        if (TextUtils.isEmpty(r17) == false) goto L73;
        int r110 = this.j;
        if (r110 == 2) goto L71;
        if (r110 != 3) goto L56;
        r2 = "sheet_image";
        goto L71
    L56:
        if (r110 != 8) goto L58;
        r2 = "bitable_image";
        goto L71
    L58:
        if (r110 == 16) goto L71;
        if (r110 != 30) goto L62;
        r2 = "slides_image";
        goto L71
    L62:
        if (r110 != 11) goto L64;
        r2 = "mindnote_image";
        goto L71
    L64:
        if (r110 == 12) goto L66;
        r2 = "";
        goto L71
    L66:
        r2 = FileInfoPuller.CALLER_EXPLORER;
    L71:
        r17 = r2;
    L73:
        if (TextUtils.isEmpty(this.g) == false) goto L76;
        r17 = this.g;
    L76:
        if (TextUtils.isEmpty(r17) == false) goto L79;
        return "unknown";
    L79:
        return r17;
    }
}
