package jj7;

import android.text.TextUtils;
import com.bytedance.ug.sdk.luckycat.api.depend.d;
import com.bytedance.ug.sdk.luckycat.impl.manager.i;
import com.bytedance.ug.sdk.luckycat.impl.manager.m;
import com.bytedance.ug.sdk.luckycat.impl.utils.u;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f499340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f499341b;

    /* JADX INFO: renamed from: jj7.a$a, reason: collision with other inner class name */
    public static class C6446a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f499342a = null;

        static {
            f499342a = new a();
        }
    }

    public a() {
        this.f499340a = false;
        i.a.f271322a.getClass();
        this.f499340a = u.a().d("key_had_upload_invite_code", Boolean.FALSE);
        if (this.f499340a == true) goto L20;
        m r100 = m.a.f271349a;
        d r101 = r100.f271337e;
        if (r101 != null) goto L8;
    L10:
        String r102 = "";
    L12:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        r102 = u.a().c("key_invite_code_cache", "");
    L15:
        this.f499341b = r102;
        if (u.a().c("self_invite_code", "").equals(this.f499341b) == false) goto L18;
        this.f499341b = null;
        u.a().g("key_invite_code_cache", "");
    L18:
        r100.n();
        return;
    L8:
        if (((cn7.a) r101).a() == null) goto L10;
        r102 = null;
        goto L12
    }
}
