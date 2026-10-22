package com.bytedance.sdk.account.impl;

/* JADX INFO: loaded from: classes22.dex */
public final class o extends ua7.a<ua7.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ua7.a f269105a;

    public class a extends va7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ua7.b f269106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f269107b;

        @Override // sa7.h
        public final void onSuccess(ua7.b r100) {
            xa7.d r101 = (xa7.d) r100;
            ua7.a r102 = this.f269107b.f269105a;
            if (r102 == null) goto L6;
            r102.onResponse(r101);
            return;
        }

        public a(o r100, ua7.b r101) {
            this.f269107b = r100;
            this.f269106a = r101;
        }

        @Override // sa7.h
        public final void onError(ua7.b r100, int r101) {
            xa7.d r102 = (xa7.d) r100;
            ua7.a r103 = this.f269107b.f269105a;
            if (r103 == null) goto L6;
            r103.onResponse(this.f269106a);
            return;
        }
    }

    public o(ua7.a r100) {
        this.f269105a = r100;
    }

    @Override // ua7.a
    public final void onResponse(ua7.b r100) {
        if (r100.f549249c == true) goto L8;
        ua7.a r101 = this.f269105a;
        if (r101 == null) goto L10;
        r101.onResponse(r100);
        return;
    L10:
        return;
    L8:
        g.a().b("normal", new a(this, r100));
    }
}
