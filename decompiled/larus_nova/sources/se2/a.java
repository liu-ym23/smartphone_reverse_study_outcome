package se2;

import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends gg0.b<MultiLinkNormalEmptyViewBinder.a> {

    /* JADX INFO: renamed from: se2.a$a, reason: collision with other inner class name */
    public static final class C7599a {
    }

    static {
    }

    public a() {
    }

    @Override // gg0.b
    public final boolean a(e r100, e r101) {
        MultiLinkNormalEmptyViewBinder.a r102 = (MultiLinkNormalEmptyViewBinder.a) r100;
        MultiLinkNormalEmptyViewBinder.a r103 = (MultiLinkNormalEmptyViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        LinkmicPositionItem r104 = r102.c();
        LinkmicPositionItem r105 = r103.c();
        if (Intrinsics.areEqual(r104, r105) == false) goto L5;
        boolean r106 = true;
    L10:
        if (super.a(r102, r103) == false) goto L22;
        if (r106 == true) goto L13;
        return false;
    L13:
        if (r102.h() == r103.h()) goto L15;
        return false;
    L15:
        if (r102.f() == r103.f()) goto L17;
        return false;
    L17:
        if (e(r102.a(), r103.a()) == true) goto L19;
        return false;
    L19:
        if (r102.i() != r103.i()) goto L27;
        return true;
    L27:
        return false;
    L22:
        return false;
    L5:
        if (r104 == null) goto L8;
        if (r105 == null) goto L8;
        r106 = r104.equals(r105);
    L8:
        r106 = false;
        goto L10
    }

    @Override // gg0.b
    public final boolean b(e r100, e r101) {
        MultiLinkNormalEmptyViewBinder.a r102 = (MultiLinkNormalEmptyViewBinder.a) r100;
        MultiLinkNormalEmptyViewBinder.a r103 = (MultiLinkNormalEmptyViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r102, "oldItem");
        Intrinsics.checkNotNullParameter(r103, "newItem");
        if (r102.b() != r103.b()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e(ch0.b r100, ch0.b r101) {
        if (Intrinsics.areEqual(r100, r101) == false) goto L5;
        return true;
    L5:
        IBaseUser r102 = null;
        if (r100 == null) goto L8;
        Boolean r103 = Boolean.valueOf(r100.f23717b);
    L9:
        if (r101 == null) goto L11;
        Boolean r104 = Boolean.valueOf(r101.f23717b);
    L13:
        if (Intrinsics.areEqual(r103, r104) == false) goto L22;
        if (r100 == null) goto L22;
        IBaseUser r105 = r100.f23716a;
        if (r105 == null) goto L22;
        if (r101 == null) goto L20;
        r102 = r101.f23716a;
    L20:
        if (r105.equals(r102) != true) goto L22;
        return true;
    L22:
        return false;
    L11:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L9
    }

    @Override // gg0.b
    public final Bundle d(e r100, e r101, int r102, int r103) {
        MultiLinkNormalEmptyViewBinder.a r104 = (MultiLinkNormalEmptyViewBinder.a) r100;
        MultiLinkNormalEmptyViewBinder.a r105 = (MultiLinkNormalEmptyViewBinder.a) r101;
        Intrinsics.checkNotNullParameter(r104, "oldItem");
        Intrinsics.checkNotNullParameter(r105, "newItem");
        Bundle r106 = super.d(r104, r105, r102, r103);
        LinkmicPositionItem r107 = r104.c();
        LinkmicPositionItem r108 = r105.c();
        if (Intrinsics.areEqual(r107, r108) == false) goto L5;
        boolean r109 = true;
    L9:
        if (r109 == true) goto L12;
        r106.putBoolean("payload_key_position_item_update", true);
    L12:
        if (r104.f() == r105.f()) goto L15;
        r106.putBoolean("payload_key_position_invite_guide_update", r105.f());
    L15:
        if (r104.h() == r105.h()) goto L18;
        r106.putBoolean("payload_key_interact_state_update", r105.h());
    L18:
        if (e(r104.a(), r105.a()) == true) goto L20;
        r106.putBoolean("payload_key_friend_online_update", true);
    L20:
        return r106;
    L5:
        if (r107 == null) goto L8;
        if (r108 == null) goto L8;
        r109 = r107.equals(r108);
    L8:
        r109 = false;
        goto L9
    }
}
