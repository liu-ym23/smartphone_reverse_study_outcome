package xz0;

import com.bytedance.android.live.revenue.platform.network.dynamic.g;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements OnWRDSDataUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ylc.c f565483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ylc.c f565484b;

    @Override // com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener
    public final void onWRDSDataUpdate(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "syncKey");
    }

    @Override // com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener
    public final ylc.c getDataSyncListener() {
        return this.f565483a;
    }

    public a(g r100) {
        this.f565484b = r100;
        this.f565483a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener
    public final void setDataSyncListener(ylc.c r100) {
        this.f565483a = r100;
    }
}
