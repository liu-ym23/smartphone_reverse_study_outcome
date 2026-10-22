package gg0;

import android.os.Bundle;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkSpecialViewBinder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k extends b<MultiLinkSpecialViewBinder.a> {

    public static final class a {
    }

    static {
    }

    public k() {
    }

    @Override // gg0.b
    public final boolean a(tf0.e r100, tf0.e r101) {
        MultiLinkSpecialViewBinder.a r102 = (MultiLinkSpecialViewBinder.a) r100;
        MultiLinkSpecialViewBinder.a r103 = (MultiLinkSpecialViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.f75986l != r103.f75986l) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L10:
        return false;
    L8:
        if (r102.f75988n != r103.f75988n) goto L10;
        return true;
    L5:
        r104 = false;
        goto L6
    }

    @Override // gg0.b
    public final boolean b(tf0.e r100, tf0.e r101) {
        MultiLinkSpecialViewBinder.a r102 = (MultiLinkSpecialViewBinder.a) r100;
        MultiLinkSpecialViewBinder.a r103 = (MultiLinkSpecialViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.f75985k != r103.f75985k) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // gg0.b
    public final Bundle d(tf0.e r100, tf0.e r101, int r102, int r103) {
        MultiLinkSpecialViewBinder.a r104 = (MultiLinkSpecialViewBinder.a) r100;
        MultiLinkSpecialViewBinder.a r105 = (MultiLinkSpecialViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r104, "oldItem");
        Intrinsics.checkNotNullParameter(r105, "newItem");
        Bundle r106 = new Bundle();
        if (r104.f75986l != r105.f75986l) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == true) goto L8;
        r106.putBoolean("payload_key_lock_status_update", true);
    L8:
        boolean r108 = r104.f75988n;
        boolean r109 = r105.f75988n;
        if (r108 == r109) goto L11;
        r106.putBoolean("payload_key_interact_state_update", r109);
    L11:
        return r106;
    L5:
        r107 = false;
        goto L6
    }
}
