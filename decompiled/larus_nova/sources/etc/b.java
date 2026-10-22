package etc;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gtc.g f473960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f473961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f473962c;

    @Override // etc.e
    public final CharSequence a(String r100, String r101) {
        if (r101.isEmpty() == false) goto L5;
        return r101;
    L5:
        if (r100 == null) goto L16;
        gtc.g.a r102 = this.f473960a.b(r100);
        if (r102 == null) goto L10;
    L12:
        if (r102 == null) goto L15;
        SpannableStringBuilder r103 = new SpannableStringBuilder();
        c r104 = new c(r100, this.f473961b, r103);
        this.f473960a.getClass();
        r104.a(gtc.g.j(r101, r102));
        return r103;
    L15:
        return r101;
    L10:
        if (TextUtils.isEmpty(this.f473962c) == true) goto L12;
        r100 = this.f473962c;
        r102 = this.f473960a.b(r100);
        goto L12
    L16:
        return r101;
    }

    public b(gtc.g r100, d r101, String r102) {
        this.f473960a = r100;
        this.f473961b = r101;
        this.f473962c = r102;
    }
}
