package gq4;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.view.form.FormView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cp4.a f482165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jq4.l f482166b;

    public p(FormView r100) {
        this.f482166b = r100;
    }

    public final void a(cp4.a r100) {
        tt5.a.b("RecordPresenter_record", "setRecord: " + r100);
        this.f482165a = r100;
        List<dp4.a> r101 = r100.f464646m;
        String r102 = r100.f464634a.f464667k;
        int r103 = 0;
        int r104 = -1;
        int r105 = -1;
    L4:
        if (r103 >= r101.size()) goto L14;
        dp4.a r106 = (dp4.a) ListProtector.get(r101, r103);
        if (TextUtils.isEmpty(r106.f469587a.f478263j) == true) goto L10;
        if (r104 >= 0) goto L10;
        r104 = r103;
    L10:
        if (TextUtils.equals(r102, r106.f469587a.f478255b) == false) goto L13;
        if (r105 >= 0) goto L13;
        this.f482165a.f464634a.f464667k = null;
        r105 = r103;
    L13:
        r103 = r103 + 1;
        goto L4
    L14:
        if (r104 > (-1)) goto L17;
        r104 = r105;
    L17:
        if (r104 <= (-1)) goto L19;
        this.f482166b.g(r104);
    L19:
        this.f482166b.j(r100);
    }
}
