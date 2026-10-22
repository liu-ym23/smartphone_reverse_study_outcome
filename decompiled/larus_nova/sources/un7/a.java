package un7;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.larus.nova.R;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import oo7.j;
import oo7.k;
import oo7.n;
import oo7.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends lo7.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IWXAPI f550831d;

    /* JADX INFO: renamed from: un7.a$a, reason: collision with other inner class name */
    public class C7904a implements wn7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f550832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WXMediaMessage f550833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WXMiniProgramObject f550834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f550835d;

        @Override // wn7.a
        public final void a(byte[] r100) {
            if (r100 != null) goto L5;
            kn7.b.a(10082, this.f550832a);
            return;
        L5:
            WXMediaMessage r101 = this.f550833b;
            r101.thumbData = r100;
            ShareContent r102 = this.f550832a;
            WXMiniProgramObject r103 = this.f550834c;
            a r104 = this.f550835d;
            r104.getClass();
            un7.c r105 = new un7.c(r104, r101, 0, r102);
            if (xn7.e.a(r102, r105) == false) goto L29;
            JSONObject r106 = new JSONObject();     // Catch: Throwable -> L24
            r106.put("title", r101.title);     // Catch: Throwable -> L24
            if (TextUtils.isEmpty(r101.description) == true) goto L11;
            r106.put("description", r101.description);     // Catch: Throwable -> L24
        L11:
            byte[] r107 = r101.thumbData;     // Catch: Throwable -> L24
            if (r107 == null) goto L17;
            if (r107.length <= 0) goto L17;
            String r108 = oo7.e.a(r107);     // Catch: Throwable -> L24
            r101.thumbDataHash = r108;     // Catch: Throwable -> L24
            r106.put("thumbDataHash", r108);     // Catch: Throwable -> L24
        L17:
            if (TextUtils.isEmpty(r103.userName) == true) goto L20;
            r106.put("userName", r103.userName);     // Catch: Throwable -> L24
        L20:
            if (TextUtils.isEmpty(r103.path) == true) goto L22;
            r106.put("path", r103.path);     // Catch: Throwable -> L24
        L22:
            eo7.a r109 = eo7.a.b.f473353a;     // Catch: Throwable -> L24
            jo7.c.a(new io7.c(r102, ShareContentType.MINI_APP, r106, r105));     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            k.d("WXShareSignHelper", "signMiniApp()...error", th);
            return;
        }

        public C7904a(a r100, ShareContent r101, WXMediaMessage r102, WXMiniProgramObject r103) {
            this.f550835d = r100;
            this.f550832a = r101;
            this.f550833b = r102;
            this.f550834c = r103;
        }
    }

    public class b implements wn7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WXMediaMessage f550836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShareContent f550837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WXWebpageObject f550838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f550839d;

        @Override // wn7.a
        public final void a(byte[] r100) {
            WXMediaMessage r101 = this.f550836a;
            r101.thumbData = r100;
            ShareContent r102 = this.f550837b;
            WXWebpageObject r103 = this.f550838c;
            a r104 = this.f550839d;
            r104.getClass();
            xn7.e.b(r102, r103, r101, new un7.c(r104, r101, a.p(r102), r102));
        }

        public b(a r100, WXMediaMessage r101, ShareContent r102, WXWebpageObject r103) {
            this.f550839d = r100;
            this.f550836a = r101;
            this.f550837b = r102;
            this.f550838c = r103;
        }
    }

    public class c implements wn7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f550840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f550841b;

        @Override // wn7.a
        public final void a(byte[] r100) {
            this.f550841b.r(this.f550840a, r100);
        }

        public c(a r100, ShareContent r101) {
            this.f550841b = r100;
            this.f550840a = r101;
        }
    }

    public class d implements co7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f550842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f550843b;

        @Override // co7.b
        public final void a() {
            kn7.b.a(10055, this.f550842a);
        }

        @Override // co7.b
        public final void b(String r100) {
            this.f550843b.s(this.f550842a, r100);
        }

        public d(a r100, ShareContent r101) {
            this.f550843b = r100;
            this.f550842a = r101;
        }
    }

    public class e implements co7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f550844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f550845b;

        @Override // co7.a
        public final void a() {
            kn7.b.a(10073, this.f550844a);
        }

        @Override // co7.a
        public final void b(String r100) {
            a r101 = this.f550845b;
            ShareContent r102 = this.f550844a;
            IWXAPI r103 = r101.f550831d;
            if (r103 != null) goto L5;
        L7:
            boolean r104 = false;
        L8:
            if (r104 == true) goto L10;
        L22:
            WXFileObject r105 = new WXFileObject(r100);
        L23:
            WXMediaMessage r106 = new WXMediaMessage(r105);
            r106.title = r102.getFileName();
            r101.q(r106, 0, r102);
            return;
        L10:
            if (Build.VERSION.SDK_INT < 24) goto L12;
            boolean r107 = true;
        L13:
            if (r107 == false) goto L22;
            Context r108 = r101.f510132a;
            Uri r109 = n.b(r100);     // Catch: Throwable -> L19
            if (r109 == null) goto L21;
            r108.grantUriPermission("com.tencent.mm", r109, 1);     // Catch: Throwable -> L19
            r100 = r109.toString();     // Catch: Throwable -> L19
        L21:
            r105 = new WXFileObject(r100);
        L19:
            th = move-exception;
            k.b(th.toString());
            goto L21
        L12:
            r107 = false;
            goto L13
        L5:
            if (r103.getWXAppSupportAPI() < 654314752) goto L7;
            r104 = true;
            goto L8
        }

        public e(a r100, ShareContent r101) {
            this.f550845b = r100;
            this.f550844a = r101;
        }
    }

    @Override // lo7.a
    public final String c() {
        return "com.tencent.mm";
    }

    @Override // lo7.b
    public final String d() {
        return "com.tencent.mm.ui.tools.ShareImgUI";
    }

    @Override // lo7.b
    public final void j() {
        this.f510134c = 10030;
    }

    public a(Context r100) {
        super(r100);
        eo7.a r101 = eo7.a.b.f473353a;
        if (TextUtils.isEmpty(r101.f473341o) == true) goto L5;
        String r102 = r101.f473341o;
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L12;
        IWXAPI r103 = WXAPIFactory.createWXAPI(r100, r102, true);
        this.f550831d = r103;
        if (r103.registerApp(r102) == true) goto L13;
        this.f550831d = null;
        return;
    L13:
        return;
    L12:
        return;
    L5:
        String r104 = r101.f("wechat");
        r101.f473341o = r104;
        r102 = r104;
        goto L7
    }

    public static int p(ShareContent r100) {
        if (r100.getShareChanelType() != ShareChannelType.WX) goto L6;
        return 0;
    L6:
        return 1;
    }

    @Override // lo7.a
    public final boolean b(ShareContent r100) {
        IWXAPI r101 = this.f550831d;
        if (r101 != null) goto L7;
        kn7.b.a(10016, r100);
        return false;
    L7:
        if (r101.isWXAppInstalled() == true) goto L10;
        kn7.b.a(10011, r100);
        o.b(this.f510132a, r100, 104, R.string.share_sdk_toast_weixin_not_install);
        return false;
    L10:
        return true;
    }

    @Override // lo7.b
    public final boolean e(ShareContent r100) {
        if (TextUtils.isEmpty(r100.getTargetUrl()) == false) goto L7;
        this.f510134c = 10102;
        return false;
    L7:
        if (TextUtils.isEmpty(r100.getAudioUrl()) == false) goto L11;
        this.f510134c = 10103;
        return false;
    L11:
        if (TextUtils.isEmpty(r100.getTitle()) == false) goto L15;
        this.f510134c = 10101;
        return false;
    L15:
        if (r100.getImage() == null) goto L17;
    L20:
        wn7.b.b(r100, new c(this, r100));
        return true;
    L17:
        if (TextUtils.isEmpty(r100.getImageUrl()) == false) goto L20;
        r(r100, null);
        return true;
    }

    @Override // lo7.b
    public final boolean g(ShareContent r100) {
        if (TextUtils.isEmpty(r100.getFileUrl()) == false) goto L7;
        this.f510134c = 10071;
        return false;
    L7:
        if (TextUtils.isEmpty(r100.getFileName()) == false) goto L10;
        this.f510134c = 10072;
        return false;
    L10:
        ho7.b.C6179b.f486235a.b(r100, new e(this, r100));
        return true;
    }

    @Override // lo7.b
    public final boolean h(ShareContent r100) {
        if (TextUtils.isEmpty(r100.getTargetUrl()) == false) goto L7;
        this.f510134c = 10022;
        return false;
    L7:
        if (TextUtils.isEmpty(r100.getTitle()) == false) goto L10;
        this.f510134c = 10021;
        return false;
    L10:
        WXWebpageObject r101 = new WXWebpageObject();
        r101.webpageUrl = r100.getTargetUrl();
        WXMediaMessage r102 = new WXMediaMessage(r101);
        r102.title = n.c(r100.getTitle(), 500);
        String r103 = n.c(r100.getText(), 1000);
        if (TextUtils.isEmpty(r103) == true) goto L14;
        r102.description = r103;
    L14:
        if (r100.getImage() == null) goto L16;
    L19:
        wn7.b.b(r100, new b(this, r102, r100, r101));
        return true;
    L16:
        if (TextUtils.isEmpty(r100.getImageUrl()) == false) goto L19;
        xn7.e.b(r100, r101, r102, new un7.c(this, r102, p(r100), r100));
        return true;
    }

    @Override // lo7.b
    public final boolean i(ShareContent r100) {
        String r101 = r100.getImageUrl();
        if (r100.getImage() != null) goto L9;
        if (TextUtils.isEmpty(r101) == false) goto L9;
        this.f510134c = 10051;
        return false;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        String r102 = ho7.d.a(r100.getImage());
        if (TextUtils.isEmpty(r102) == true) goto L30;
        s(r100, r102);
        return true;
    L30:
        return true;
    L11:
        if (ho7.d.b(r101) == false) goto L13;
        s(r100, r101);
        return true;
    L13:
        d r103 = new d(this, r100);
        if (TextUtils.isEmpty(r100.getImageUrl()) == true) goto L31;
        eo7.a r104 = eo7.a.b.f473353a;
        if (r104.h() == null) goto L32;
        String r105 = r100.getImageUrl();
        if (TextUtils.isEmpty(r105) == true) goto L33;
        j.b(r100);
        r104.d(r105, new ho7.c(r103, false));
        return true;
    L33:
        return true;
    L32:
        return true;
    L31:
        return true;
    }

    @Override // lo7.b
    public final boolean k(ShareContent r100) {
        kn7.a r101 = r100.getExtraParams();
        if (r101 == null) goto L47;
        Object r102 = r101.f504249c;
        if (r102 == null) goto L47;
        if ((r102 instanceof vn7.a) == false) goto L47;
        vn7.a r103 = (vn7.a) r102;
        String r104 = r103.f556458a;
        if (TextUtils.isEmpty(r104) == false) goto L14;
        this.f510134c = 10084;
        return false;
    L14:
        if (TextUtils.isEmpty(r100.getTargetUrl()) == false) goto L18;
        this.f510134c = 10083;
        return false;
    L18:
        if (TextUtils.isEmpty(r100.getTitle()) == false) goto L22;
        this.f510134c = 10081;
        return false;
    L22:
        if (TextUtils.isEmpty(r100.getImageUrl()) == true) goto L24;
    L27:
        WXMiniProgramObject r105 = new WXMiniProgramObject();
        r105.webpageUrl = r100.getTargetUrl();
        int r106 = r103.f556460c;
        if (r106 >= 0) goto L30;
    L32:
        r105.miniprogramType = 0;
    L33:
        r105.userName = r104;
        String r107 = r103.f556459b;
        if (TextUtils.isEmpty(r107) == true) goto L36;
        r105.path = r107;
    L36:
        WXMediaMessage r108 = new WXMediaMessage(r105);
        r108.title = r100.getTitle();
        if (TextUtils.isEmpty(r100.getText()) == true) goto L40;
        r108.description = r100.getText();
    L40:
        if (r100.getImage() == null) goto L42;
    L45:
        wn7.b.c(r100, new C7904a(this, r100, r108, r105), true, true);
        return true;
    L42:
        if (TextUtils.isEmpty(r100.getImageUrl()) == false) goto L45;
        return false;
    L30:
        if (r106 > 2) goto L32;
        r105.miniprogramType = r106;
        goto L33
    L24:
        if (r100.getImage() != null) goto L27;
        this.f510134c = 10082;
        return false;
    L47:
        this.f510134c = 10080;
        return false;
    }

    @Override // lo7.b
    public final boolean l(ShareContent r100) {
        if (TextUtils.isEmpty(r100.getTitle()) == false) goto L6;
        this.f510134c = 10041;
        return false;
    L6:
        WXTextObject r101 = new WXTextObject();
        r101.text = r100.getTitle();
        WXMediaMessage r102 = new WXMediaMessage();
        r102.mediaObject = r101;
        r102.description = r100.getTitle();
        un7.c r103 = new un7.c(this, r102, p(r100), r100);
        if (xn7.e.a(r100, r103) == false) goto L17;
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L11
        r104.put("text", r101.text);     // Catch: Throwable -> L11
        eo7.a r105 = eo7.a.b.f473353a;     // Catch: Throwable -> L11
        jo7.c.a(new io7.c(r100, ShareContentType.TEXT, r104, r103));     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        k.d("WXShareSignHelper", "signText()...error", th);
        return true;
    L17:
        return true;
    }

    @Override // lo7.b
    public final boolean n(ShareContent r100) {
        if (r100.getShareChanelType() != ShareChannelType.WX) goto L7;
        return super.n(r100);
    L7:
        if (TextUtils.isEmpty(r100.getTargetUrl()) == false) goto L10;
        this.f510134c = 10065;
    L12:
        return false;
    L10:
        if (TextUtils.isEmpty(r100.getTitle()) == false) goto L13;
        this.f510134c = 10064;
        goto L12
    L13:
        WXVideoObject r101 = new WXVideoObject();
        r101.videoUrl = r100.getTargetUrl();
        WXMediaMessage r102 = new WXMediaMessage(r101);
        r102.title = n.c(r100.getTitle(), 500);
        String r103 = n.c(r100.getText(), 1000);
        if (TextUtils.isEmpty(r103) == true) goto L17;
        r102.description = r103;
    L17:
        if (r100.getImage() == null) goto L19;
    L22:
        wn7.b.b(r100, new un7.b(this, r102, r100, r101));
    L23:
        return true;
    L19:
        if (TextUtils.isEmpty(r100.getImageUrl()) == false) goto L22;
        xn7.e.c(r100, r101, r102, new un7.c(this, r102, p(r100), r100));
        goto L23
    }

    public final void r(ShareContent r100, byte[] r101) {
        WXMusicObject r102 = new WXMusicObject();
        r102.musicUrl = r100.getTargetUrl() + "#wechat_music_url=" + r100.getAudioUrl();
        WXMediaMessage r103 = new WXMediaMessage();
        r103.mediaObject = r102;
        r103.title = n.c(r100.getTitle(), 500);
        if (TextUtils.isEmpty(r100.getText()) == true) goto L5;
        r103.description = n.c(r100.getText(), 1000);
    L5:
        if (r101 == null) goto L7;
        r103.thumbData = r101;
    L7:
        un7.c r104 = new un7.c(this, r103, p(r100), r100);
        if (xn7.e.a(r100, r104) == false) goto L25;
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L20
        r105.put("musicUrl", r102.musicUrl);     // Catch: Throwable -> L20
        r105.put("title", r103.title);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r103.description) == true) goto L13;
        r105.put("description", r103.description);     // Catch: Throwable -> L20
    L13:
        byte[] r106 = r103.thumbData;     // Catch: Throwable -> L20
        if (r106 != null) goto L16;
    L18:
        eo7.a r107 = eo7.a.b.f473353a;     // Catch: Throwable -> L20
        jo7.c.a(new io7.c(r100, ShareContentType.AUDIO, r105, r104));     // Catch: Throwable -> L20
        return;
    L16:
        if (r106.length <= 0) goto L18;
        String r108 = oo7.e.a(r106);     // Catch: Throwable -> L20
        r103.thumbDataHash = r108;     // Catch: Throwable -> L20
        r105.put("thumbDataHash", r108);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        k.d("WXShareSignHelper", "signAudio()...error", th);
        return;
    }

    public final void s(ShareContent r100, String r101) {
        WXImageObject r102 = new WXImageObject();
        WXMediaMessage r103 = new WXMediaMessage(r102);
        IWXAPI r104 = this.f550831d;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == true) goto L10;
    L21:
        r102.imagePath = r101;
    L22:
        q(r103, p(r100), r100);
        return;
    L10:
        if (Build.VERSION.SDK_INT < 24) goto L12;
        r105 = true;
    L12:
        if (r105 == false) goto L21;
        Context r107 = this.f510132a;
        Uri r108 = n.b(r101);     // Catch: Throwable -> L18
        if (r108 == null) goto L20;
        r107.grantUriPermission("com.tencent.mm", r108, 1);     // Catch: Throwable -> L18
        r101 = r108.toString();     // Catch: Throwable -> L18
    L20:
        r102.imagePath = r101;
    L18:
        th = move-exception;
        k.b(th.toString());
        goto L20
    L5:
        if (r104.getWXAppSupportAPI() < 654314752) goto L7;
        r106 = true;
        goto L8
    }

    public final void q(WXMediaMessage r100, int r101, ShareContent r102) {
        SendMessageToWX.Req r103 = new SendMessageToWX.Req();
        r103.transaction = String.valueOf(System.currentTimeMillis());
        r103.message = r100;
        r103.scene = r101;
        ShareStrategy r104 = r102.getShareStrategy();
        if (r104 != null) goto L5;
        r104 = ShareStrategy.NORMAL;
    L5:
        int r105 = xn7.d.f564641a[r104.ordinal()];
        if (r105 != 1) goto L8;
    L10:
        xn7.c r106 = new xn7.a();
    L12:
        if (r106.a(this.f510132a, this.f550831d, r102, r103) == false) goto L15;
        o();
        return;
    L15:
        return;
    L8:
        if (r105 == 2) goto L10;
        r106 = new xn7.b();
        goto L12
    }
}
