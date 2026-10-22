package qs;

import com.bytedance.android.gamecp.base.network.response.i;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f534638a = null;

    static {
        f534638a = new d();
    }

    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        i r101 = (i) r100;
        bw.i r102 = com.bytedance.android.gamecp.host_api.a.b().getLiveService();
        Integer r103 = ((com.bytedance.android.gamecp.business.api.response.a) r101.data).todayDownloadCount;
        if (r103 == null) goto L5;
        int r104 = r103.intValue();
    L6:
        Boolean r105 = ((com.bytedance.android.gamecp.business.api.response.a) r101.data).hasDownloadPermission;
        if (r105 == null) goto L9;
        boolean r106 = r105.booleanValue();
    L10:
        Integer r107 = ((com.bytedance.android.gamecp.business.api.response.a) r101.data).notInstallCount;
        if (r107 == null) goto L13;
        int r108 = r107.intValue();
    L14:
        Boolean r109 = ((com.bytedance.android.gamecp.business.api.response.a) r101.data).hasInstallPermission;
        if (r109 == null) goto L17;
        boolean r110 = r109.booleanValue();
    L18:
        Boolean r111 = ((com.bytedance.android.gamecp.business.api.response.a) r101.data).showInstallTips;
        if (r111 == null) goto L21;
        boolean r112 = r111.booleanValue();
    L22:
        r102.updateAnchorFloatBallDownloadData(r104, r106, r108, r110, r112);
        return;
    L21:
        r112 = false;
        goto L22
    L17:
        r110 = false;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r106 = false;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }
}
