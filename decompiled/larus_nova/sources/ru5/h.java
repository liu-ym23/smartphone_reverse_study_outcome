package ru5;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.drive.biz.preview.orientation.DriveOrientationPlugin;
import com.bytedance.ee.util.orientation.OrientationViewModel;
import java.util.Objects;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a.InterfaceC7535a f539260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OrientationViewModel f539261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f539262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<d> f539263d;

    @Override // ru5.a
    public final void a() {
        j r100 = this.f539262c;
        if (r100 == null) goto L5;
        r100.disable();
        this.f539262c = null;
    L5:
        OrientationViewModel r101 = this.f539261b;
        if (r101 == null) goto L9;
        r101.onCleared();
        this.f539261b = null;
        return;
    }

    public h(DriveOrientationPlugin.c r100) {
        this.f539263d = new MutableLiveData();
        this.f539260a = r100;
    }

    public final void b(final com.bytedance.ee.bear.drive.biz.preview.orientation.b r100) {
        this.f539261b = (OrientationViewModel) this.f539260a.b(OrientationViewModel.class);
        Context r101 = this.f539260a.provideContext();
        final MutableLiveData<d> r102 = this.f539263d;
        Objects.requireNonNull(r102);
        this.f539262c = new j(r101, new e(r102));
        this.f539263d.observe(this.f539260a.a(), new f(this, r100));
        this.f539262c.enable();
        this.f539261b.getLocked().observe(this.f539260a.a(), new g(this, r100));
        this.f539261b.registerLockObserver(this.f539260a.provideContext());
    }
}
