package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import android.R;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.MmEndWindowAvatar;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowFragment$createWebHelperListener$1;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.pb.entities.Cipher;
import com.ss.android.lark.pb.entities.Crypto;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okio.ByteString;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class MmEndWindowWebHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f435875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup f435876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final w f435877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f435878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OfficeWebView f435879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f435880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f435881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f435882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f435883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f435884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f435885m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e f435886n;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f435887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f435888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ByteString f435889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f435890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f435891e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f435887a, r101.f435887a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f435888b, r101.f435888b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f435889c, r101.f435889c) == true) goto L18;
            return false;
        L18:
            if (this.f435890d == r101.f435890d) goto L21;
            return false;
        L21:
            if (this.f435891e == r101.f435891e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f435887a.hashCode() * 31;
            String r101 = this.f435888b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((((((r100 + r102) * 31) + this.f435889c.hashCode()) * 31) + this.f435890d) * 31) + this.f435891e;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ImageViewerConfig(imageKey=" + this.f435887a + ", fsUnit=" + this.f435888b + ", crypto=" + this.f435889c + ", width=" + this.f435890d + ", height=" + this.f435891e + ')';
        }

        public a(String r100, String r101, ByteString r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "imageKey");
            Intrinsics.checkNotNullParameter(r102, "crypto");
            this.f435887a = r100;
            this.f435888b = r101;
            this.f435889c = r102;
            this.f435890d = r103;
            this.f435891e = r104;
        }
    }

    public final void e() {
        int r100 = bwb.b.f21271a;
        bwb.b.g(MmUiLogScene.WEB, "destroyWebViewOnly", null, f(), 4);
        OfficeWebView r101 = this.f435879g;
        if (r101 == null) goto L5;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        ((ConcurrentHashMap) r101.getBridge().f565288b.f565311a).clear();
        r101.stopLoading();
        r101.getSettings().setJavaScriptEnabled(false);
        r101.clearHistory();
        r101.clearView();
        r101.removeAllViews();
        r101.destroy();
    L5:
        this.f435876d.removeAllViews();
        this.f435879g = null;
    }

    public final String f() {
        return (String) this.f435878f.getValue();
    }

    public final void g() {
        int r100 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.WEB, "initWebView", "create new webView", f());
        OfficeWebView r101 = new OfficeWebView(this.f435876d.getContext(), null, 6);
        r101.setHorizontalScrollBarEnabled(false);
        r101.setVerticalScrollBarEnabled(false);
        r101.getSettings().setJavaScriptEnabled(true);
        r101.getSettings().setSupportZoom(false);
        r101.setBackgroundColor(ContextCompat.getColor(r101.getContext(), R.color.transparent));
        r101.setOverScrollMode(2);
        r101.setLayerType(2, null);
        if (DevEnvUtil.isDebugMode(r101.getContext()) == false) goto L5;
        WebView.setWebContentsDebuggingEnabled(true);
    L5:
        r101.setWebViewClient(new com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.a(this, this.f435886n));
        xwb.a r102 = r101.getBridge();
        r102.b("common.close", new l(this));
        r102.b("common.showToast", new o(this));
        r102.b("common.sendTrackEvent", new p(this));
        r102.b("common.openWeb", new q(this));
        r102.b("minutes.updateTitle", new r(this));
        r102.b("common.notifyLoadComplete", new s(this));
        r102.b("common.log", new t(this));
        if (this.f435885m == false) goto L8;
        r102.b("minutes.getPictures", new u(this));
        r102.b("minutes.loadLocationChooser", new v(this));
    L8:
        r102.b("minutes.getAvatarInfo", new b(this));
        r102.b("common.getAvatarBase64", new c(this));
        r102.b("common.openProfile", new d(this));
        r102.b("minutes.getMinutesInfo", new e(this));
        r102.b("minutes.getDoubaoUserInfo", new f(this));
        r102.b("common.getDomain", new g(this));
        r102.b("common.getFG", new h(this));
        r102.b("common.getSettings", new i(this));
        r102.b("common.ready", new j(this));
        r102.b("common.networkProxy", new k(this));
        r102.b("minutes.changeSpeaker", new m(this));
        r102.b("minutes.showImageViewer", new n(this));
        this.f435876d.removeAllViews();
        this.f435876d.addView(r101, new ViewGroup.LayoutParams(-1, -1));
        this.f435879g = r101;
    }

    public static Cipher b(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Cipher.Builder r101 = new Cipher.Builder();
        ByteString r102 = d(r100.optString("secret"));
        if (r102 == null) goto L8;
        r101.secret(r102);
    L8:
        ByteString r103 = d(r100.optString("nonce"));
        if (r103 == null) goto L11;
        r101.nonce(r103);
    L11:
        ByteString r104 = d(r100.optString("additionalData"));
        if (r104 == null) goto L15;
        r101.additional_data(r104);
    L15:
        return r101.build();
    }

    public static ByteString d(String r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L23;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        ByteString.a r103 = ByteString.Companion;     // Catch: Throwable -> L12
        byte[] r104 = Base64.decode(r100, 0);     // Catch: Throwable -> L12
        byte[] r105 = Arrays.copyOf(r104, r104.length);     // Catch: Throwable -> L12
        r103.getClass();     // Catch: Throwable -> L12
        Object r106 = Result.m9449constructorimpl(ByteString.a.c(r105));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r106) == true) goto L19;
        r101 = r106;
    L19:
        return (ByteString) r101;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    L23:
        return null;
    }

    public static Crypto.Type j(Object r100) {
        if ((r100 instanceof Number) == true) goto L24;
        Object r101 = null;
        if ((r100 instanceof String) == false) goto L21;
        Integer r102 = StringsKt.toIntOrNull((String) r100);
        if (r102 != null) goto L10;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Object r104 = Result.m9449constructorimpl(Crypto.Type.valueOf((String) r100));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r104) == true) goto L25;
        r101 = r104;
    L25:
        return (Crypto.Type) r101;
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L10:
        return Crypto.Type.fromValue(r102.intValue());
    L21:
        return null;
    L24:
        return Crypto.Type.fromValue(((Number) r100).intValue());
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        int r101 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.WEB, "loadUrl", "url is empty or webView is null, url=" + r100, f());
        return;
    L6:
        this.f435883k = r100;
        if (this.f435877e.isDarkMode() == false) goto L9;
        String r102 = "dark";
    L10:
        String r103 = "theme=".concat(r102);
        if (StringsKt.contains$default(r100, "?", false, 2, null) == false) goto L13;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        char r105 = Typography.amp;
    L14:
        r104.append(r105);
        r104.append(r103);
        String r106 = r104.toString();
        int r107 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.WEB, "loadUrl", "url=" + r106, f());
        OfficeWebView r108 = this.f435879g;
        if (r108 == null) goto L18;
        r108.loadUrl(r106);
        return;
    L18:
        return;
    L13:
        r104 = new StringBuilder();
        r104.append(r100);
        r105 = '?';
        goto L14
    L9:
        r102 = "light";
        goto L10
    }

    public final List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g> k(JSONArray r110) {
        if (r110 == null) goto L85;
        if (r110.length() == 0) goto L85;
        ArrayList r100 = new ArrayList();
        int r101 = r110.length();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L83;
        JSONObject r103 = r110.optJSONObject(r102);
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g r104 = null;
        if (r103 == null) goto L82;
        String r105 = r103.optString("imageKey");
        if (StringsKt.isBlank(r105) == false) goto L15;
        r105 = r103.optString("image_key");
    L15:
        if (StringsKt.isBlank(r105) == false) goto L17;
        r105 = r103.optString("key");
    L17:
        Intrinsics.checkNotNull(r105);
        if ((!StringsKt.isBlank(r105)) == false) goto L20;
        String r106 = r105;
    L22:
        if (r106 != null) goto L24;
        a r107 = null;
    L57:
        String r108 = r103.optString("url");
        if (StringsKt.isBlank(r108) == false) goto L61;
        r108 = r103.optString("uri");
    L61:
        if (StringsKt.isBlank(r108) == false) goto L64;
        r108 = r103.optString("localUri");
    L64:
        if (StringsKt.isBlank(r108) == false) goto L66;
        r108 = r103.optString("local_uri");
    L66:
        String r109 = r103.optString("thumbUrl");
        if (StringsKt.isBlank(r109) == false) goto L70;
        r109 = r103.optString("thumb_url");
    L70:
        if (StringsKt.isBlank(r109) == false) goto L73;
        r109 = r103.optString("thumbUri");
    L73:
        if (StringsKt.isBlank(r109) == false) goto L75;
        r109 = r103.optString("thumb_uri");
    L75:
        Intrinsics.checkNotNull(r108);
        if (StringsKt.isBlank(r108) == false) goto L81;
        Intrinsics.checkNotNull(r109);
        if (StringsKt.isBlank(r109) == false) goto L81;
        if (r107 != null) goto L81;
        int r111 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.WEB, "showImageViewer", "image uri is empty", f());
    L81:
        r104 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.g(c(r108, r107), c(r109, r107));
        goto L82
    L24:
        String r112 = r103.optString("fsUnit");
        if (StringsKt.isBlank(r112) == false) goto L27;
        r112 = r103.optString("fs_unit");
    L27:
        Intrinsics.checkNotNull(r112);
        if ((!StringsKt.isBlank(r112)) == false) goto L30;
        String r113 = r112;
    L31:
        JSONObject r114 = r103.optJSONObject("crypto");
        if (r114 != null) goto L86;
        ByteString r115 = ByteString.EMPTY;
    L56:
        r107 = new a(r106, r113, r115, r103.optInt("width", 0), r103.optInt("height", 0));
        goto L57
    L86:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L47
        Crypto.Builder r117 = new Crypto.Builder();     // Catch: Throwable -> L47
        Crypto.Type r118 = j(r114.opt("type"));     // Catch: Throwable -> L47
        if (r118 == null) goto L38;
        r117.type(r118);     // Catch: Throwable -> L47
    L38:
        Cipher r119 = b(r114.optJSONObject("cipher"));     // Catch: Throwable -> L47
        if (r119 == null) goto L41;
        r117.cipher(r119);     // Catch: Throwable -> L47
    L41:
        byte[] r120 = r117.build().encode();     // Catch: Throwable -> L47
        if (r120 == null) goto L44;
        ByteString r121 = ByteString.a.e(ByteString.Companion, r120);     // Catch: Throwable -> L47
    L45:
        Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L47
    L49:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L52;
        int r124 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.WEB, "showImageViewer", "parse crypto failed, error=" + r123.getMessage(), f());
    L52:
        ByteString r125 = ByteString.EMPTY;
        if (Result.m9455isFailureimpl(r122) == false) goto L55;
        r122 = r125;
    L55:
        r115 = (ByteString) r122;
        goto L56
    L44:
        r121 = ByteString.EMPTY;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    L30:
        r113 = null;
        goto L31
    L20:
        r106 = null;
    L82:
        r100.add(r104);
        r102 = r102 + 1;
        goto L7
    L83:
        return r100;
    L85:
        return CollectionsKt.emptyList();
    }

    public final void l(boolean r100) {
        BuildersKt.launch$default(this.f435875c, null, null, new MmEndWindowWebHelper$updateTheme$1(this, r100, null), 3, null);
    }

    public static com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h c(String r110, a r111) {
        String r100 = null;
        if (r110 == null) goto L15;
        boolean r101 = true;
        if ((!StringsKt.isBlank(r110)) == false) goto L12;
        if (r111 == null) goto L8;
        String r102 = r111.f435887a;
    L10:
        if (Intrinsics.areEqual(r110, r102) == true) goto L12;
    L13:
        if (r101 == false) goto L15;
        String r103 = r110;
    L17:
        if (r111 == null) goto L19;
        String r104 = r111.f435887a;
    L20:
        if (r111 == null) goto L22;
        r100 = r111.f435888b;
    L22:
        String r105 = r100;
        if (r111 == null) goto L26;
        ByteString r106 = r111.f435889c;
        if (r106 == null) goto L26;
    L27:
        ByteString r107 = r106;
        if (r111 == null) goto L30;
        int r108 = r111.f435890d;
    L31:
        if (r111 == null) goto L33;
        int r112 = r111.f435891e;
    L34:
        if (r103 == null) goto L36;
        String r113 = "localOrUrl";
    L38:
        return new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.ainote.h(r103, r104, r105, r107, r108, r112, r113);
    L36:
        r113 = "remoteConfig";
        goto L38
    L33:
        r112 = 0;
        goto L34
    L30:
        r108 = 0;
    L26:
        r106 = ByteString.EMPTY;
        goto L27
    L19:
        r104 = null;
        goto L20
    L8:
        r102 = null;
    L12:
        r101 = false;
    L15:
        r103 = null;
        goto L17
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0081 -> B:20:0x0085). Please report as a decompilation issue!!! */
    public static final Object a(MmEndWindowWebHelper r110, int r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof MmEndWindowWebHelper$buildAvatarInfoArray$1) == false) goto L7;
        MmEndWindowWebHelper$buildAvatarInfoArray$1 r100 = (MmEndWindowWebHelper$buildAvatarInfoArray$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r104 = r100.J$0;
        r111 = r100.I$0;
        MmEndWindowAvatar r105 = (MmEndWindowAvatar) r100.L$3;
        Iterator r106 = (Iterator) r100.L$2;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r107 = (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c) r100.L$1;
        JSONArray r108 = (JSONArray) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L20:
        Bitmap r114 = (Bitmap) r113;
        if (r114 == null) goto L16;
        JSONObject r109 = new JSONObject();
        r109.put("type", r105.getType());
        r109.put("userId", r105.getUserId());
        r109.put("fakeNameId", r105.getFakeNameId());
        ByteArrayOutputStream r115 = new ByteArrayOutputStream();
        r114.compress(Bitmap.CompressFormat.PNG, 100, r115);     // Catch: Throwable -> L26
        String r116 = Base64.encodeToString(r115.toByteArray(), 2);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r115, null);
        r109.put("avatarBase64", r116);
        r108.put(r109);
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r115, th);
        throw th;
    L16:
        if (r106.hasNext() == false) goto L31;
        r105 = (MmEndWindowAvatar) r106.next();
        r100.L$0 = r108;
        r100.L$1 = r107;
        r100.L$2 = r106;
        r100.L$3 = r105;
        r100.I$0 = r111;
        r100.J$0 = r104;
        r100.label = 1;
        r113 = r110.h(r105, r111, r100);
        if (r113 != r102) goto L20;
        return r102;
    L31:
        int r117 = bwb.b.f21271a;
        bwb.b.f(MmUiLogScene.WEB, "getAvatarInfo", "cost=" + (System.currentTimeMillis() - r104) + "ms, avatarCount=" + r108.length() + ", sourceCount=" + r107.f434948f.size(), r110.f());
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        r104 = System.currentTimeMillis();
        JSONArray r118 = new JSONArray();
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c r119 = r110.f435877e.i();
        r106 = r119.f434948f.iterator();
        r108 = r118;
        r107 = r119;
    L7:
        r100 = new MmEndWindowWebHelper$buildAvatarInfoArray$1(r110, r112);
        goto L8
    }

    public final Object h(MmEndWindowAvatar r100, int r101, Continuation<? super Bitmap> r102) {
        if ((r102 instanceof MmEndWindowWebHelper$loadEndWindowAvatar$1) == false) goto L7;
        MmEndWindowWebHelper$loadEndWindowAvatar$1 r103 = (MmEndWindowWebHelper$loadEndWindowAvatar$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L20;
        if (r107 == 1) goto L17;
        if (r107 != 2) goto L16;
        r100 = (MmEndWindowAvatar) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L42
    L38:
        Bitmap r109 = (Bitmap) r105;     // Catch: Throwable -> L42
    L40:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L42
    L44:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L48;
        int r112 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.WEB, "getAvatarInfo", "load avatar failed, type=" + r100.getType() + ", userId=" + r100.getUserId() + ", error=" + r111, f());
    L48:
        if (Result.m9455isFailureimpl(r110) == false) goto L51;
        return null;
    L51:
        return r110;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r100 = (MmEndWindowAvatar) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L42
    L29:
        r109 = (Bitmap) r105;     // Catch: Throwable -> L42
        goto L40
    L20:
        ResultKt.throwOnFailure(r105);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L42
        if (r100.getAvatarKey().length() <= 0) goto L24;
        boolean r114 = true;
    L25:
        if (r114 == false) goto L31;
        w r115 = this.f435877e;     // Catch: Throwable -> L42
        String r116 = r100.getAvatarKey();     // Catch: Throwable -> L42
        String r117 = r100.getUserId();     // Catch: Throwable -> L42
        r103.L$0 = r100;     // Catch: Throwable -> L42
        r103.label = 1;     // Catch: Throwable -> L42
        r105 = r115.c(r116, r117, r101, r103);     // Catch: Throwable -> L42
        if (r105 != r106) goto L29;
        return r106;
    L31:
        if (r100.getAvatarUrl().length() > 0) goto L34;
        r108 = false;
    L34:
        if (r108 == false) goto L39;
        w r118 = this.f435877e;     // Catch: Throwable -> L42
        String r119 = r100.getAvatarUrl();     // Catch: Throwable -> L42
        r103.L$0 = r100;     // Catch: Throwable -> L42
        r103.label = 2;     // Catch: Throwable -> L42
        r105 = r118.m(r119, r101, r103);     // Catch: Throwable -> L42
        if (r105 != r106) goto L38;
        return r106;
    L39:
        r109 = null;
        goto L40
    L24:
        r114 = false;
    L42:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = new MmEndWindowWebHelper$loadEndWindowAvatar$1(this, r102);
        goto L8
    }

    public MmEndWindowWebHelper(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, String r110, LifecycleCoroutineScope r111, ViewGroup r112, MmEndWindowFragment$createWebHelperListener$1 r113) {
        Intrinsics.checkNotNullParameter(r100, "uccApi");
        Intrinsics.checkNotNullParameter(r110, "meetingId");
        Intrinsics.checkNotNullParameter(r111, "mainScope");
        Intrinsics.checkNotNullParameter(r112, "webViewContainer");
        Intrinsics.checkNotNullParameter(r113, "listener");
        this.f435873a = r100;
        this.f435874b = r110;
        this.f435875c = r111;
        this.f435876d = r112;
        this.f435877e = r113;
        this.f435878f = LazyKt.lazy(new MmEndWindowWebHelper$logDetail$2(this));
        this.f435880h = "";
        this.f435882j = 96;
        this.f435883k = "";
        this.f435884l = LazyKt.lazy(MmEndWindowWebHelper$mapReadHelper$2.INSTANCE);
        this.f435885m = true;
        this.f435886n = new com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e(new com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web.e.b("end_window", 3, new MmEndWindowWebHelper$renderGoneHandler$1(this), new MmEndWindowWebHelper$renderGoneHandler$2(this), new MmEndWindowWebHelper$renderGoneHandler$3(this), new MmEndWindowWebHelper$renderGoneHandler$4(this), new MmEndWindowWebHelper$renderGoneHandler$5(this)));
        g();
    }
}
