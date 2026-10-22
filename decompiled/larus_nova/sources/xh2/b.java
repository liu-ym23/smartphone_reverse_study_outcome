package xh2;

import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveClearScreenHelper;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements fi2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f563866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomContextController f563867b;

    @Override // fi2.a
    public final boolean isLinkmic() {
        com.bytedance.android.livesdk.livecommerce.room.api.c r100 = ControllerExtensionsKt.c(this.f563867b, this.f563866a).J();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isLinkmic();
    }

    @Override // fi2.a
    public final void b(int r100) {
        String r101 = this.f563866a;
        RoomContextController r102 = this.f563867b;
        if (r102 == null) goto L5;
        String r103 = r102.D();
    L6:
        ECLiveClearScreenHelper.a(r100, r101, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public b(String r100, RoomContextController r101) {
        this.f563866a = r100;
        this.f563867b = r101;
    }

    @Override // fi2.a
    public final void a(FragmentActivity r100, String r101, Window r102) {
        com.bytedance.android.livesdk.livecommerce.room.api.c r103 = ControllerExtensionsKt.c(this.f563867b, this.f563866a).J();
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }

    @Override // fi2.a
    public final void d(FragmentActivity r100, String r101, Window r102, Function2 r103) {
        com.bytedance.android.livesdk.livecommerce.room.api.c r104 = ControllerExtensionsKt.c(this.f563867b, this.f563866a).J();
        if (r104 == null) goto L6;
        r104.d(r100, r101, r102, r103);
        return;
    }

    @Override // fi2.a
    public final void notifyPanelEventByLiveList(boolean r110, int r111, long r112, long r113, boolean r114) {
        int r100 = ECSdk.f48106a;
        IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r101 == null) goto L6;
        r101.notifyPanelEventByLiveList(r110, r111, r112, r113, r114);
        return;
    }
}
