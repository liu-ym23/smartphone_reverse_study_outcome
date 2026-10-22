package nta;

import android.text.TextUtils;
import com.bytedance.common.utility.StringUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f520541a;

    public c() {
    }

    public abstract void a(String r100);

    public abstract String c(String r100);

    public void b(String r100) {
        c r101 = this.f520541a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final String d(String r100, String r101) {
        c r102 = this.f520541a;
        String r103 = c("device_id");
        boolean r104 = !TextUtils.isEmpty(r100);
        boolean r105 = !TextUtils.isEmpty(r103);
        if (r104 == true) goto L6;
        if (r105 == false) goto L6;
        r100 = r103;
    L6:
        if (r102 == null) goto L10;
        r100 = r102.d(r100, r101);
        if (StringUtils.equal(r100, r103) == true) goto L21;
        a(r100);
    L21:
        return r100;
    L10:
        if (r104 == true) goto L13;
        if (r105 == true) goto L13;
        r100 = r101;
        boolean r106 = true;
    L14:
        if (r106 == true) goto L16;
    L17:
        if (r104 == false) goto L21;
        if (StringUtils.equal(r100, r103) == true) goto L21;
    L20:
        a(r100);
        goto L21
    L16:
        if ((!TextUtils.isEmpty(r100)) == true) goto L20;
    L13:
        r106 = false;
        goto L14
    }
}
