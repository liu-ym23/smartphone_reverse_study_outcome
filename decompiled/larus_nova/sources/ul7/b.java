package ul7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckydog.base.window.ILuckyDogWindowConfig;
import gn7.f;
import gn7.g;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements f {
    public b() {
    }

    @Override // gn7.f
    public final void a() {
    }

    @Override // gn7.f
    public final boolean b() {
        return true;
    }

    @Override // gn7.f
    public final int d() {
        return 0;
    }

    @Override // gn7.f
    public final boolean c(g r100) {
        String r101 = r100.f481827j;
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return false;
    L5:
        Uri r102 = UriProtector.parse(r101);
        if ("polaris".equals(r102.getHost()) == true) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L16;
        ILuckyDogWindowConfig r104 = sl7.a.c();
        if (r104 != null) goto L15;
        return false;
    L15:
        return r104.showLowUpdateDialog();
    L16:
        return false;
    L8:
        if ("1".equals(UriProtector.getQueryParameter(r102, "need_check_version")) == false) goto L10;
        r103 = true;
        goto L11
    }
}
