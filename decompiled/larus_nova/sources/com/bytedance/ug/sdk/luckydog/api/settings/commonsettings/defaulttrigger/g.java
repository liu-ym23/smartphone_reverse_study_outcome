package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.defaulttrigger;

import gk7.j;

/* JADX INFO: loaded from: classes22.dex */
public final class g extends xk7.c {

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f271625a;

        public a(g r100) {
            this.f271625a = r100;
        }

        @Override // gk7.j
        public final void a(boolean r100, long r101) {
            if (r100 == false) goto L4;
            this.f271625a.c("time_jump");
        L4:
            hl7.b.b().f485693e.remove(this);
        }
    }

    public g() {
        hl7.b r100 = hl7.b.b();
        a r101 = new a(this);
        r100.f485693e.add(r101);
    }
}
