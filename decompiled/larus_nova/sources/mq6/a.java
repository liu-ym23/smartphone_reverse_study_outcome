package mq6;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class a implements c.a {
    public /* synthetic */ a() {
    }

    public final String a(String r100) {
        int r101 = b.f514892a;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L6:
        return "";
    L5:
        if ("null".equals(r100) == true) goto L6;
        return r100;
    }
}
