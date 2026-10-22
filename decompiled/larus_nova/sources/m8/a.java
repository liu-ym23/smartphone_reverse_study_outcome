package m8;

import com.bytedance.android.annie.ng.h;
import com.bytedance.android.live.browser.i;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.annie.monitor.lynx.b f512433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.annie.ng.a.C0738a f512434b;

    @Override // com.bytedance.android.annie.ng.h
    public final void onCallback() {
        com.bytedance.android.annie.monitor.lynx.b r100 = this.f512433a;
        if (r100 == null) goto L6;
        com.bytedance.android.annie.ng.a.C0738a r101 = this.f512434b;
        c.f512438a.put(r101.f39647a, r100);
        return;
    }

    public a(i r100, com.bytedance.android.annie.ng.a.C0738a r101) {
        this.f512433a = r100;
        this.f512434b = r101;
    }
}
