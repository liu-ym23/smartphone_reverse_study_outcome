package k7c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.applink.AppLink;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends ova.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e7c.b f502073a;

    public static final class a {
    }

    static {
    }

    public d(e7c.c r100) {
        this.f502073a = r100;
    }

    @Override // ova.p
    public final boolean a(Context r100, AppLink r110) {
        Log.i("OpenTodoDetailAppHandler", "handle");
        if (r100 != null) goto L5;
    L22:
        Log.e("OpenTodoDetailAppHandler", "handle invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r110.f408912a) == true) goto L22;
        Uri r111 = UriProtector.parse(r110.f408912a);
        String r101 = UriProtector.getQueryParameter(r111, "guid");
        String r102 = "";
        if (r101 != null) goto L10;
        String r103 = "";
    L11:
        String r104 = UriProtector.getQueryParameter(r111, "navigateStyle");
        if (r104 == null) goto L15;
        r102 = r104;
    L15:
        String r105 = UriProtector.getQueryParameter(r111, "authscene");
        String r106 = UriProtector.getQueryParameter(r111, "authid");
        if (TextUtils.isEmpty(r103) == true) goto L24;
        e7c.b r107 = this.f502073a;
        if (r107 == null) goto L25;
        r107.e(r100, r103, r105, r106, Intrinsics.areEqual(r102, "push"));
        return true;
    L25:
        return true;
    L24:
        return true;
    L10:
        r103 = r101;
        goto L11
    }

    @Override // ova.p
    public final boolean b(Context r100, AppLink r101) {
        Log.i("OpenTodoDetailAppHandler", "canOpen");
        if (r100 != null) goto L5;
    L9:
        Log.e("OpenTodoDetailAppHandler", "canOpen invalid parameter");
        return false;
    L5:
        if (TextUtils.isEmpty(r101.f408912a) == true) goto L9;
        return true;
    }
}
