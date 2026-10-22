package iu2;

import java.util.Map;
import ju2.f;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends com.bytedance.android.livesdk.log.filter.a<f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f495771c;

    public b() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        f r101 = (f) r100;
        this.f495771c = r101;
        if (r101 == null) goto L6;
        putAll(r101.b());
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        f r102 = (f) r101;
        super.u(r100, r102);
        r100.putAll(r102.b());
    }
}
