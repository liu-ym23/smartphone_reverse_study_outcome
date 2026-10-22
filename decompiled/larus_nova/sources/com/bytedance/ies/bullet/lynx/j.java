package com.bytedance.ies.bullet.lynx;

import android.net.Uri;
import com.bytedance.ies.bullet.core.BulletContext;

/* JADX INFO: loaded from: classes19.dex */
public final class j extends h16.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BulletContext f247373a;

    @Override // h16.e.a, h16.e
    public final Uri getCurrentUri() {
        return this.f247373a.f246443k;
    }

    @Override // h16.e.a, h16.e
    public final Uri getProcessingUri() {
        return this.f247373a.f246443k;
    }

    @Override // h16.e.a, h16.e
    public final BulletContext getBulletContext() {
        return this.f247373a;
    }

    public j(BulletContext r100) {
        this.f247373a = r100;
    }
}
