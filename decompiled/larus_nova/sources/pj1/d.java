package pj1;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements Observer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.room.b f529442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f529443b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        e r101 = this.f529443b;
        com.bytedance.android.livesdk.room.b r102 = this.f529442a;
        r101.getClass();
        e.z(r102, (String) r100);
    }

    public d(e r100, com.bytedance.android.livesdk.room.b r101) {
        this.f529443b = r100;
        this.f529442a = r101;
    }
}
