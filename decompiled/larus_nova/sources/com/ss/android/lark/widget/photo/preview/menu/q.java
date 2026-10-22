package com.ss.android.lark.widget.photo.preview.menu;

import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.widget.photo.preview.PhotoPagerFragment;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class q {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f447005i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f447006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f447007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f447008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f447009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f447010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f447011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final r f447012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final w f447013h;

    public static final class a {
    }

    public interface b {
        View a();

        com.ss.android.lark.widget.photo.preview.ocr.menu.b b();

        List<PhotoItem> c();

        PhotoItem d();

        PhotoPagerFragment getLifecycleOwner();
    }

    static {
    }

    public final MutableLiveData<Integer> a() {
        return this.f447006a.d().getPhotoState().getDownloadOriginProgress();
    }

    public final TextView b() {
        return (TextView) this.f447011f.getValue();
    }

    public final void c() {
        ((View) this.f447008c.getValue()).clearAnimation();
        ((View) this.f447008c.getValue()).setVisibility(0);
        this.f447010e.removeCallbacks(this.f447012g);
        this.f447010e.postDelayed(this.f447012g, 5000);
    }

    public final void d() {
        if (this.f447009d == false) goto L6;
        b().setVisibility(0);
        return;
    }

    public q(com.ss.android.lark.widget.photo.preview.menu.b r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f447006a = r100;
        this.f447007b = LazyKt.lazy(new LookOriginController$owner$2(this));
        this.f447008c = LazyKt.lazy(new LookOriginController$actionMenu$2(this));
        this.f447010e = new Handler();
        this.f447011f = LazyKt.lazy(new LookOriginController$lookOriginView$2(this));
        this.f447012g = new r(this);
        this.f447013h = new w(this);
        b().setOnClickListener(new s(this));
        com.ss.android.lark.widget.photopicker.f.a().G();
    }
}
