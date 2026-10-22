package com.bytedance.ies.xelement.audiott.transform;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.xelement.audiott.bean.PlayModel;
import com.bytedance.ies.xelement.audiott.bean.XAudioSrc;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.util.UriUtil;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public class b extends com.bytedance.ies.xelement.audiott.transform.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f249770a;

    public static final class a {
    }

    static {
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f249770a = r100;
    }

    @Override // com.bytedance.ies.xelement.audiott.transform.a
    public final void a(XAudioSrc r110, Function1<? super g76.a, Unit> r111) {
        Context r100 = this.f249770a;     // Catch: Throwable -> L62
        if (r110 == null) goto L6;
        String r101 = r110.getPlayUrl();     // Catch: Throwable -> L62
        if (r101 == null) goto L6;
    L7:
        boolean r102 = false;
        String r103 = d7a.a.b(r100, r101, false);     // Catch: Throwable -> L62
        if (r103 != null) goto L11;
        super.a(r110, r111);     // Catch: Throwable -> L62
        return;
    L11:
        Uri r104 = UriProtector.parse(r103);     // Catch: Throwable -> L62
        String r105 = r104.getScheme();     // Catch: Throwable -> L62
        if (r105 == null) goto L60;
        PlayModel r106 = null;
        switch(r105.hashCode()) {
            case -1408207997: goto L42;
            case 3143036: goto L30;
            case 3213448: goto L23;
            case 93121264: goto L20;
            case 99617003: goto L17;
            default: goto L60;
        };     // Catch: Throwable -> L62
    L17:
        if (r105.equals("https") == false) goto L60;
    L25:
        if (r110 == null) goto L27;
        PlayModel r107 = r110.getPlayModel();     // Catch: Throwable -> L62
    L28:
        r111.invoke(new g76.a(r103, null, r103, null, r107, 10));     // Catch: Throwable -> L62
        return;
    L27:
        r107 = null;
        goto L28
    L20:
        if (r105.equals(UriUtil.LOCAL_ASSET_SCHEME) == false) goto L60;
    L44:
        String r108 = r104.getPath();     // Catch: Throwable -> L62
        if (r108 != null) goto L47;
    L49:
        if (r102 == false) goto L51;
        r108 = r108.substring(1);     // Catch: Throwable -> L62
    L51:
        if (r108 != null) goto L53;
        super.a(r110, r111);     // Catch: Throwable -> L62
        return;
    L53:
        AssetFileDescriptor r109 = this.f249770a.getAssets().openFd(r108);     // Catch: Throwable -> L62
        if (r110 == null) goto L56;
        String r112 = r110.getPlayUrl();     // Catch: Throwable -> L62
    L57:
        if (r110 == null) goto L59;
        r106 = r110.getPlayModel();     // Catch: Throwable -> L62
    L59:
        r111.invoke(new g76.a(r112, null, null, r109, r106, 6));     // Catch: Throwable -> L62
        return;
    L56:
        r112 = null;
        goto L57
    L47:
        if (StringsKt.startsWith$default(r108, HTTP.URL_DEFAULT, false, 2, null) != true) goto L49;
        r102 = true;
        goto L49
    L23:
        if (r105.equals("http") == true) goto L25;
    L30:
        if (r105.equals("file") == false) goto L60;
        String r113 = r104.getPath();     // Catch: Throwable -> L62
        if (new PolarisFileWrapper(r113).exists() == false) goto L40;
        if (r110 == null) goto L36;
        String r114 = r110.getPlayUrl();     // Catch: Throwable -> L62
    L37:
        if (r110 == null) goto L39;
        r106 = r110.getPlayModel();     // Catch: Throwable -> L62
    L39:
        r111.invoke(new g76.a(r114, r113, null, null, r106, 12));     // Catch: Throwable -> L62
        return;
    L36:
        r114 = null;
        goto L37
    L40:
        super.a(r110, r111);     // Catch: Throwable -> L62
        return;
    L42:
        if (r105.equals(ChameleonAssertResManager.ASSET_FOLDER) == true) goto L44;
    L60:
        super.a(r110, r111);     // Catch: Throwable -> L62
        return;
    L6:
        r101 = "";
    L62:
        th = move-exception;
        th.getMessage();
        super.a(r110, r111);
    }
}
