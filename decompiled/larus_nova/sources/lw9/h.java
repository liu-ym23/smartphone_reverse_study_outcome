package lw9;

import android.app.Activity;
import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements jn7.h {
    public h() {
    }

    @Override // jn7.h
    public final Activity getTopActivity() {
        return AppHost.f326268a.a().getCurrentActivity();
    }
}
