package wib;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardConfirmDialogConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTargetConfig;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.forwardv3.configuration.targetconfig.AIConfig;
import com.ss.android.lark.forwardv3.configuration.targetconfig.EntityItem;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.forward.textforward.TextForwardContent;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import ova.d;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends d {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // ova.p
    public final boolean a(Context r100, AppLink r101) {
        Log.i("ForwardTextAppLinkHandler", "handle forward appLink");
        if (r100 != null) goto L5;
    L18:
        Log.e("ForwardTextAppLinkHandler", "invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L18;
        Uri r102 = UriProtector.parse(r101.f408912a);
        if (r102 == null) goto L11;
        String r103 = UriProtector.getQueryParameter(r102, "text_content");
        if (r103 == null) goto L11;
    L13:
        if (TextUtils.isEmpty(r103) == false) goto L16;
        Log.e("ForwardTextAppLinkHandler", "invalid parameter by text_content");
        return false;
    L16:
        IncludeConfig.CREATOR.getClass();
        IncludeConfig r104 = IncludeConfig.b.a();
        EntityItem.a r105 = new EntityItem.a();
        r105.a(new AIConfig());
        r104.a(r105.c());
        ForwardTemplateNew.a r106 = new ForwardTemplateNew.a();
        TextForwardContent.a r107 = new TextForwardContent.a();
        Intrinsics.checkNotNullParameter(r103, "content");
        r107.f425380a = r103;
        r106.f425211f = r107.a();
        ForwardTargetConfig.a r108 = new ForwardTargetConfig.a();
        Intrinsics.checkNotNullParameter(r104, "includeConfig");
        r108.f425204d = r104;
        ForwardTargetConfig r109 = r108.a();
        Intrinsics.checkNotNullParameter(r109, "forwardTargetConfig");
        r106.f425206a = r109;
        ForwardConfirmDialogConfig.a r110 = new ForwardConfirmDialogConfig.a();
        BasicDialogContentConfig.a r111 = new BasicDialogContentConfig.a();
        Intrinsics.checkNotNullParameter(r103, "content");
        r111.f425141c = r103;
        r110.f425184d = r111.a();
        ForwardConfirmDialogConfig r112 = r110.a();
        Intrinsics.checkNotNullParameter(r112, "forwardConfirmDialogConfig");
        r106.f425210e = r112;
        com.ss.android.lark.forwardv3.forward.textforward.a.a(r100, 11, -1, r106.a());
        return true;
    L11:
        r103 = "";
        goto L13
    }

    @Override // ova.p
    public final boolean b(Context r100, AppLink r101) {
        Log.i("ForwardTextAppLinkHandler", "canOpen");
        if (r100 != null) goto L5;
    L9:
        Log.e("ForwardTextAppLinkHandler", "canOpen invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L9;
        return true;
    }
}
