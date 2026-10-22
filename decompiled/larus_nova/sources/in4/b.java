package in4;

import android.app.Application;
import android.os.Bundle;
import com.bytedance.ee.bear.docshost.k;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements k {
    public b() {
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final void b(String r100, boolean r101, Bundle r102) {
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final boolean c() {
        return false;
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final void d(String r100) {
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final Disposable e(String r100, CharSequence r101) {
        return a(r100, r101, false);
    }

    @Override // com.bytedance.ee.bear.docshost.k
    public final Disposable a(String r110, CharSequence r111, boolean r112) {
        if (r110 != null) goto L4;
    L7:
        boolean r100 = true;
    L8:
        if (r100 == true) goto L10;
        ContactSource.a r101 = new ContactSource.a();
        if (r112 == false) goto L14;
        int r113 = 20;
    L15:
        r101.f419443b = r113;
        if (r111 == null) goto L18;
        String r114 = r111.toString();
    L19:
        r101.f419444c = r114;
        ContactSource r102 = new ContactSource(r101);
        IProfileLauncherV2.f438837a.getClass();
        IProfileLauncherV2 r103 = IProfileLauncherV2.Companion.a();
        Application r104 = LarkContext.getApplication();
        Intrinsics.checkNotNull(r102);
        r103.openUserProfileV2(r104, null, r110, null, null, null, r102, null);
        return Disposables.empty();
    L18:
        r114 = null;
        goto L19
    L14:
        r113 = 4;
        goto L15
    L10:
        return Disposables.empty();
    L4:
        if (r110.length() == 0) goto L7;
        r100 = false;
        goto L8
    }
}
