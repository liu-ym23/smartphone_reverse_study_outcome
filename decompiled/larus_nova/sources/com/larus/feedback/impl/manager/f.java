package com.larus.feedback.impl.manager;

import android.os.Handler;
import com.larus.utils.t0;
import java.util.Map;

/* JADX INFO: loaded from: classes27.dex */
public final class f implements o99.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q99.e f343105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DefaultIMFeedbackManager f343106b;

    @Override // o99.c
    public final void e(q99.d r100) {
        if (r100 == null) goto L12;
        q99.e r101 = this.f343105a;
        String r102 = r101.f532145b;
        Map<String, String> r103 = r101.f532150g;
        if (r103 == null) goto L6;
        String r104 = r103.get("section_id");
    L7:
        final q99.d r105 = r100.j(r102, r104, this.f343105a.f532150g);
        String r106 = this.f343105a.f532145b;
        if (r106 != null) goto L10;
        r106 = r105.e();
    L10:
        final q99.e r107 = q99.e.a(this.f343105a, null, r106, r105, 93);
        Handler r108 = t0.f375468a;
        final DefaultIMFeedbackManager r109 = this.f343106b;
        r108.post(new e(r109, r107, r105));
        return;
    L6:
        r104 = null;
        goto L7
    }

    public f(q99.e r100, DefaultIMFeedbackManager r101) {
        this.f343105a = r100;
        this.f343106b = r101;
    }
}
