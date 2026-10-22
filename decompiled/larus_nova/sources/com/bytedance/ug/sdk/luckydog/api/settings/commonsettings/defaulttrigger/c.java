package com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.defaulttrigger;

import android.app.Activity;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends xk7.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f271621c;

    public static final class a extends uo7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f271622a;

        public a(c r100) {
            this.f271622a = r100;
        }

        @Override // uo7.c, uo7.b
        public final void onEnterForeground(Activity r100) {
            this.f271622a.c("hot_start");
        }
    }

    public c() {
        this.f271621c = new a(this);
        to7.c.d(this.f271621c);
    }
}
