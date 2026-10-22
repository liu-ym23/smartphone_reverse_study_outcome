package ow4;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import sbb.e;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f527057a;

    public static boolean b(int r100) {
        if (r100 != e.f541296g.f541317b) goto L5;
        return true;
    L5:
        if (r100 != e.f541304o.f541317b) goto L7;
        return true;
    L7:
        if (r100 != e.f541297h.f541317b) goto L9;
        return true;
    L9:
        if (r100 != e.f541300k.f541317b) goto L11;
        return true;
    L11:
        if (r100 != e.f541298i.f541317b) goto L13;
        return true;
    L13:
        if (r100 != e.f541302m.f541317b) goto L15;
        return true;
    L15:
        if (r100 != e.f541303n.f541317b) goto L17;
        return true;
    L17:
        if (r100 == e.f541299j.f541317b) goto L29;
        return false;
    L29:
        return true;
    }

    public static String a(String r100, String r101) {
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r102.build(), "from")) == false) goto L6;
        r102.appendQueryParameter("from", r101);
        return r102.build().toString();
    L6:
        return r100;
    }
}
