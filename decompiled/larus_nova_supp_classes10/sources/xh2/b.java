package xh2;

import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveClearScreenHelper;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements fi2.a {
    public final String a;
    public final RoomContextController b;

    @Override // fi2.a
    public final boolean isLinkmic() {
        com.bytedance.android.livesdk.livecommerce.room.api.c r0 = ControllerExtensionsKt.c(this.b, this.a).J();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isLinkmic();
    }

    @Override // fi2.a
    public final void b(int r3) {
        String r0 = this.a;
        RoomContextController r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.D();
    L6:
        ECLiveClearScreenHelper.a(r3, r0, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public b(String r1, RoomContextController r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // fi2.a
    public final void a(FragmentActivity r3, String r4, Window r5) {
        com.bytedance.android.livesdk.livecommerce.room.api.c r0 = ControllerExtensionsKt.c(this.b, this.a).J();
        if (r0 == null) goto L6;
        r0.a(r3, r4, r5);
        return;
    }

    @Override // fi2.a
    public final void d(FragmentActivity r3, String r4, Window r5, Function2 r6) {
        com.bytedance.android.livesdk.livecommerce.room.api.c r0 = ControllerExtensionsKt.c(this.b, this.a).J();
        if (r0 == null) goto L6;
        r0.d(r3, r4, r5, r6);
        return;
    }

    @Override // fi2.a
    public final void notifyPanelEventByLiveList(boolean r10, int r11, long r12, long r14, boolean r16) {
        int r0 = ECSdk.a;
        IAdapterService r1 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r1 == null) goto L6;
        r1.notifyPanelEventByLiveList(r10, r11, r12, r14, r16);
        return;
    }
}
