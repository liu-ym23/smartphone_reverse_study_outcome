package j8;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f497665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f497666b;

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "bcl");
        this.f497665a = r100;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        this.f497665a.a(r100, this.f497666b);
    }

    @Override // b7.a, b7.b
    public final void onAttachView(View r100, IHybridComponent.HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        super.onAttachView(r100, r101, r102);
        this.f497665a.onAttachView(r100, this.f497666b);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        this.f497665a.b(r100, r101);
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataStart(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
        if (r102 == false) goto L5;
        r100 = r101;
    L5:
        this.f497666b = r100;
    }
}
