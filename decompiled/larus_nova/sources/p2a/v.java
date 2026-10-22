package p2a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.k0;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class v implements q97.a {

    public static final class a {
    }

    static {
    }

    public v() {
    }

    public static String c(com.bytedance.router.c r100) {
        int r101 = k0.f375428a;
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L9:
        if (Intrinsics.areEqual(k0.a(r103), "//flow/single_tts_speaker_setting") == false) goto L12;
        return "com.larus.kmp.voice_setting.voice.SingleTtsSpeakerSettingActivity";
    L12:
        return null;
    L7:
        r103 = null;
        goto L9
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        if (y.a() == true) goto L6;
        return false;
    L6:
        if (c(r100) == null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // q97.a
    public final boolean a(Context r100, com.bytedance.router.c r101) {
        String r102 = c(r101);
        int r103 = 0;
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        Intent r104 = new Intent().setClassName(r100.getPackageName(), r102);
        if (r101 == null) goto L12;
        Intent r105 = r101.f267528b;
        if (r105 == null) goto L12;
        r104.addFlags(r105.getFlags());
        r104.putExtras(r105);
    L12:
        if (r101 == null) goto L19;
        Uri r106 = r101.f267530d;
        if (r106 == null) goto L19;
        Iterator<T> r107 = UriProtector.getQueryParameterNames(r106).iterator();
    L17:
        if (r107.hasNext() == false) goto L19;
        String r108 = (String) r107.next();
        r104.putExtra(r108, UriProtector.getQueryParameter(r106, r108));
    L19:
        boolean r109 = r100 instanceof Activity;
        if (r109 == true) goto L23;
        r104.addFlags(268435456);
    L23:
        if (r101 != null) goto L25;
    L30:
        boolean r110 = false;
    L31:
        if (r110 == false) goto L34;
        if (r109 == false) goto L34;
        ((Activity) r100).startActivityForResult(r104, r101.f267536j);
    L35:
        if (r109 == false) goto L61;
        if (r101 == null) goto L61;
        int r111 = r101.f267534h;
        if (r111 < 0) goto L40;
    L41:
        Activity r112 = (Activity) r100;
        Integer r113 = Integer.valueOf(r111);
        if (r113.intValue() < 0) goto L44;
        boolean r114 = true;
    L45:
        Integer r115 = null;
        if (r114 == true) goto L49;
        r113 = null;
    L49:
        if (r113 == null) goto L51;
        int r116 = r113.intValue();
    L52:
        Integer r117 = Integer.valueOf(r101.f267535i);
        if (r117.intValue() < 0) goto L55;
        boolean r118 = true;
    L56:
        if (r118 == false) goto L58;
        r115 = r117;
    L58:
        if (r115 == null) goto L60;
        r103 = r115.intValue();
    L60:
        r112.overridePendingTransition(r116, r103);
        goto L61
    L55:
        r118 = false;
        goto L56
    L51:
        r116 = 0;
        goto L52
    L44:
        r114 = false;
        goto L45
    L40:
        if (r101.f267535i >= 0) goto L41;
    L61:
        return true;
    L34:
        r100.startActivity(r104);
        goto L35
    L25:
        if (r101.f267536j == Integer.MIN_VALUE) goto L27;
        boolean r119 = true;
    L28:
        if (r119 != true) goto L30;
        r110 = true;
        goto L31
    L27:
        r119 = false;
        goto L28
    }
}
