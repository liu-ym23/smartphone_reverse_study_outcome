package com.bytedance.ee.bear.utils;

import com.bytedance.ee.bear.at.AtObject;
import java.util.Map;
import kn4.k;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements k {
    @Override // kn4.k
    public final void b() {
        tt5.a.b("DefaultAtAnalytic", "reportOpenMention");
    }

    @Override // kn4.k
    public final void clearParams() {
        tt5.a.b("DefaultAtAnalytic", "clearParams");
    }

    public g() {
    }

    @Override // kn4.k
    public final void a(Map<String, Object> r100) {
        tt5.a.b("DefaultAtAnalytic", "addSpecialAnalyticParams");
    }

    @Override // kn4.k
    public final void d(boolean r100) {
        tt5.a.b("DefaultAtAnalytic", "reportOpenMention");
    }

    @Override // kn4.k
    public final void f(bo4.d r100) {
        tt5.a.b("DefaultAtAnalytic", "setMentionInfo");
    }

    @Override // kn4.k
    public final void e(AtObject r100, boolean r101) {
        tt5.a.b("DefaultAtAnalytic", "reportConfirmMention");
    }

    @Override // kn4.k
    public final void c(AtObject r100, boolean r101, int r102, boolean r103) {
        tt5.a.b("DefaultAtAnalytic", "reportOpenMention");
    }
}
