package js2;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.android.livesdkapi.shopping.ICommerceFlashData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a extends b {

    /* JADX INFO: renamed from: js2.a$a, reason: collision with other inner class name */
    public static final class C6482a implements ICommerceFlashData {
        public C6482a() {
        }

        @Override // com.bytedance.android.livesdkapi.shopping.ICommerceFlashData
        public final boolean hasAuth() {
            return true;
        }

        @Override // com.bytedance.android.livesdkapi.shopping.ICommerceFlashData
        public final boolean isOpen() {
            return true;
        }
    }

    public a(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        super(r100);
    }

    @Override // js2.b
    public final void a(int r100) {
        super.a(r100);
        p2 r101 = (p2) this.f500198a.get("data_live_mini_app_commerce_status", new p2());
        p2 r102 = null;
        if (r100 != 0) goto L5;
        if (r101 != null) goto L31;
        return;
    L31:
        if ((!r101.f116662k) == false) goto L33;
        r102 = r101;
    L33:
        if (r102 == null) goto L48;
        r102.f116662k = true;
        this.f500198a.put("data_live_mini_app_commerce_status", r101);
        return;
    L48:
        return;
    L5:
        if (r100 != 1) goto L7;
        if (r101 != null) goto L25;
        return;
    L25:
        if (r101.f116662k == false) goto L27;
        r102 = r101;
    L27:
        if (r102 == null) goto L45;
        r102.f116662k = false;
        this.f500198a.put("data_live_mini_app_commerce_status", r101);
        return;
    L45:
        return;
    L7:
        switch(r100) {
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L15;
            case 11: goto L9;
            default: goto L49;
        };
    L9:
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.f116662k == false) goto L13;
        r102 = r101;
    L13:
        if (r102 == null) goto L37;
        r102.f116662k = false;
        this.f500198a.put("data_live_mini_app_commerce_status", r101);
        return;
    L37:
        return;
    L15:
        if (r101 != null) goto L17;
        return;
    L17:
        if ((!r101.f116662k) == false) goto L19;
        r102 = r101;
    L19:
        if (r102 == null) goto L40;
        r102.f116662k = true;
        this.f500198a.put("data_live_mini_app_commerce_status", r101);
        return;
    L40:
        return;
    L21:
        this.f500198a.put("data_commerce_flash_info", null);
        return;
    L22:
        this.f500198a.put("data_commerce_flash_info", new C6482a());
        return;
    }
}
