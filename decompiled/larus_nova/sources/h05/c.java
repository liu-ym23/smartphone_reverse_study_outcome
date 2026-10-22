package h05;

import android.text.TextUtils;
import com.bytedance.ee.bear.more.protocol3.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f483439a;

    @Override // com.bytedance.ee.bear.more.protocol3.m
    public final boolean isVisible() {
        if (TextUtils.isEmpty(this.f483439a.f483436c.a().getAssociateAppUrl()) == false) goto L6;
        return false;
    L6:
        return true;
    }

    public c(a r100) {
        this.f483439a = r100;
    }
}
