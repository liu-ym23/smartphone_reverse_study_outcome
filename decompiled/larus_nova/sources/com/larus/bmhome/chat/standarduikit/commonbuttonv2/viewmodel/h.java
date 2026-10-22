package com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel;

import android.content.Context;

/* JADX INFO: loaded from: classes26.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a f309026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f309027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f309028c;

    public static final class a implements zj8.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f309029a;

        @Override // zj8.f
        public final void a() {
            h r100 = this.f309029a;
            com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r101 = r100.f309026a;
            if (r101 != null) goto L5;
            return;
        L5:
            b r102 = r100.f309027b;
            if (r102 == null) goto L9;
            r102.a(r101);
            return;
        }

        public a(h r100) {
            this.f309029a = r100;
        }

        @Override // zj8.f
        public final void b(Context r100) {
            h r101 = this.f309029a;
            com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a r102 = r101.f309026a;
            if (r102 != null) goto L5;
            return;
        L5:
            b r103 = r101.f309027b;
            if (r103 == null) goto L9;
            r103.b(r102, r100);
            return;
        }
    }

    public h() {
        this.f309028c = new a(this);
    }
}
