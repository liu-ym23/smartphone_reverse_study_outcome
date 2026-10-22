package wk7;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.luckydog.api.settings.ILuckyDogCommonSettingsService;
import com.bytedance.ug.sdk.luckydog.api.settings.commonsettings.api.ILuckyDogSettingsService;
import rk7.m;
import zl7.n;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.bytedance.ug.sdk.luckydog.api.settings.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f560118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f560119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ fk7.d f560120c;

    public e(n r100, fk7.d r101) {
        this.f560118a = false;
        this.f560119b = r100;
        this.f560120c = r101;
    }

    @Override // com.bytedance.ug.sdk.luckydog.api.settings.d
    public final void a(ILuckyDogCommonSettingsService.Channel r100, boolean r101) {
        Application r102 = m.f538347a;
        if (r101 == false) goto L8;
        final Object r103 = ((ILuckyDogSettingsService) this.f560120c).getSettingsByKey(ILuckyDogCommonSettingsService.Channel.STATIC, "data");
        if (this.f560118a == false) goto L7;
        Handler r104 = new Handler(Looper.getMainLooper());
        final n r105 = this.f560119b;
        r104.post(new d(r105, r103));
        return;
    L7:
        this.f560119b.update(r103);
        return;
    L8:
        this.f560119b.a();
    }
}
