package com.ss.android.lark.officesdk.utils.di;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f437230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f437231b = null;

    static {
        f437230a = CollectionsKt.listOf(new String[]{EffectConstants.GIF_FILE_SUFFIX, Global.SUFFIX_TXT_FILE, ".pdf", ".ppt", ".pptx", ".jpg", ".jpeg", RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT, ".doc", ".docx", ".xls", ".xlsx", ".mp4", FaceShowElderlyFragment.AUDIO_FORM, ".js", ".css", ".svg"});
        f437231b = PatternProtector.compile("((sht|doc|dox|bas|app|sld|bmn|fld|nod|box|jsn|img|isv|wik|wia|wib|wic|wid|wie|whb)(cn|us|lg|jp)[A-Za-z0-9]{22})|[A-Z][a-zA-Z0-9]{3}([sdbafnjiw])[a-zA-Z0-9]{4}([oaplmsih])[a-zA-Z0-9]{4}([txspdngvkabce])[a-zA-Z0-9]{4}([culj])[a-zA-Z0-9]{4}([nsgp])[a-zA-Z0-9]{2}");
    }

    public static String a(Uri r100) {
        String r101 = "";
        if (r100 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r100.getAuthority()) == true) goto L8;
        String r102 = r100.getScheme();
    L10:
        if (TextUtils.isEmpty(r100.getAuthority()) == true) goto L13;
        r101 = r100.getAuthority();
    L13:
        return r102 + "://" + r101;
    L8:
        r102 = "";
        goto L10
    }

    public static String b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L20;
        j.b("ReportUrlUtils", "originUrl isNullOrBlank");
        return "";
    L20:
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r102.getEncodedPath()) == true) goto L16;
        return d(r102.getEncodedPath());
    L16:
        return "";
    L17:
        e = move-exception;
        j.d("ReportUrlUtils", e);
        return r100;
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L9
    }

    public static String c(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        j.b("ReportUrlUtils", "originUrl isNullOrBlank");
        return "";
    L13:
        if (r100 != null) goto L38;
    L20:
        if (r101 == false) goto L22;
        String r103 = "";
    L23:
        int r104 = g.f437223a;     // Catch: Throwable -> L18
        if (g.a.a("openplatform.webview.report.safe.url") == false) goto L27;
        j.e("ReportUrlUtils", "openplatform.webview.report.safe.url is open");     // Catch: Throwable -> L18
        String r105 = b(r100);     // Catch: Throwable -> L18
    L34:
        return r103 + r105;
    L18:
        th = move-exception;
        j.d("ReportUrlUtils", th);
        return "";
    L27:
        if (TextUtils.isEmpty(r100) == true) goto L33;
        Uri r106 = UriProtector.parse(r100);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r106.getEncodedPath()) == true) goto L33;
        r105 = r106.getEncodedPath();     // Catch: Throwable -> L18
        if (r105 != null) goto L34;
    L33:
        r105 = "";
        goto L34
    L22:
        r103 = a(UriProtector.parse(r100));     // Catch: Throwable -> L18
        goto L23
    L38:
        if (StringsKt.isBlank(r100) == true) goto L20;
        r101 = false;
        goto L20
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L10
    }

    public static String d(String r110) {
        boolean r100 = true;
        boolean r101 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        j.b("ReportUrlUtils", "originPath isNullOrBlank");
        return "";
    L13:
        Iterator<T> r103 = f437230a.iterator();
    L15:
        if (r103.hasNext() == false) goto L20;
        String r104 = (String) r103.next();
        if (StringsKt.endsWith$default(r110, r104, false, 2, null) == false) goto L15;
        j.e("ReportUrlUtils", "find need filter info: file type is " + r104);
        return StringsKt.replace$default(r110, r104, ".***", false, 4, null);
    L20:
        if (r110 != null) goto L35;
    L27:
        if (r100 == true) goto L30;
        r101 = f437231b.matcher(r110).find();     // Catch: Throwable -> L25
    L30:
        if (r101 == false) goto L34;
        return StringsKt.replace$default(r110, r110.substring(r110.length() - 4), "****", false, 4, null);
    L25:
        th = move-exception;
        j.d("ReportUrlUtils", th);
    L34:
        return r110;
    L35:
        if (StringsKt.isBlank(r110) == true) goto L27;
        r100 = false;
        goto L27
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r102 = false;
        goto L10
    }
}
