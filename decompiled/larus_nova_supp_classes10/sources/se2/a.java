package se2;

import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import kotlin.jvm.internal.Intrinsics;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends gg0.b<MultiLinkNormalEmptyViewBinder.a> {

    /* JADX INFO: renamed from: se2.a$a, reason: collision with other inner class name */
    public static final class C0171a {
    }

    static {
    }

    public a() {
    }

    public final boolean a(e r6, e r7) {
        MultiLinkNormalEmptyViewBinder.a r8 = (MultiLinkNormalEmptyViewBinder.a) r6;
        MultiLinkNormalEmptyViewBinder.a r9 = (MultiLinkNormalEmptyViewBinder.a) r7;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        LinkmicPositionItem r0 = r8.c();
        LinkmicPositionItem r1 = r9.c();
        if (Intrinsics.areEqual(r0, r1) == false) goto L5;
        boolean r2 = true;
    L10:
        if (super.a(r8, r9) == false) goto L22;
        if (r2 == true) goto L13;
        return false;
    L13:
        if (r8.h() == r9.h()) goto L15;
        return false;
    L15:
        if (r8.f() == r9.f()) goto L17;
        return false;
    L17:
        if (e(r8.a(), r9.a()) == true) goto L19;
        return false;
    L19:
        if (r8.i() != r9.i()) goto L27;
        return true;
    L27:
        return false;
    L22:
        return false;
    L5:
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        r2 = r0.equals(r1);
    L8:
        r2 = false;
        goto L10
    }

    public final boolean b(e r2, e r3) {
        MultiLinkNormalEmptyViewBinder.a r4 = (MultiLinkNormalEmptyViewBinder.a) r2;
        MultiLinkNormalEmptyViewBinder.a r5 = (MultiLinkNormalEmptyViewBinder.a) r3;
        Intrinsics.checkNotNullParameter(r4, "oldItem");
        Intrinsics.checkNotNullParameter(r5, "newItem");
        if (r4.b() != r5.b()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean e(ch0.b r5, ch0.b r6) {
        if (Intrinsics.areEqual(r5, r6) == false) goto L5;
        return true;
    L5:
        IBaseUser r0 = null;
        if (r5 == null) goto L8;
        Boolean r2 = Boolean.valueOf(r5.b);
    L9:
        if (r6 == null) goto L11;
        Boolean r3 = Boolean.valueOf(r6.b);
    L13:
        if (Intrinsics.areEqual(r2, r3) == false) goto L22;
        if (r5 == null) goto L22;
        IBaseUser r7 = r5.a;
        if (r7 == null) goto L22;
        if (r6 == null) goto L20;
        r0 = r6.a;
    L20:
        if (r7.equals(r0) != true) goto L22;
        return true;
    L22:
        return false;
    L11:
        r3 = null;
        goto L13
    L8:
        r2 = null;
        goto L9
    }

    public final Bundle d(e r4, e r5, int r6, int r7) {
        MultiLinkNormalEmptyViewBinder.a r8 = (MultiLinkNormalEmptyViewBinder.a) r4;
        MultiLinkNormalEmptyViewBinder.a r9 = (MultiLinkNormalEmptyViewBinder.a) r5;
        Intrinsics.checkNotNullParameter(r8, "oldItem");
        Intrinsics.checkNotNullParameter(r9, "newItem");
        Bundle r10 = super.d(r8, r9, r6, r7);
        LinkmicPositionItem r11 = r8.c();
        LinkmicPositionItem r0 = r9.c();
        if (Intrinsics.areEqual(r11, r0) == false) goto L5;
        boolean r12 = true;
    L9:
        if (r12 == true) goto L12;
        r10.putBoolean("payload_key_position_item_update", true);
    L12:
        if (r8.f() == r9.f()) goto L15;
        r10.putBoolean("payload_key_position_invite_guide_update", r9.f());
    L15:
        if (r8.h() == r9.h()) goto L18;
        r10.putBoolean("payload_key_interact_state_update", r9.h());
    L18:
        if (e(r8.a(), r9.a()) == true) goto L20;
        r10.putBoolean("payload_key_friend_online_update", true);
    L20:
        return r10;
    L5:
        if (r11 == null) goto L8;
        if (r0 == null) goto L8;
        r12 = r11.equals(r0);
    L8:
        r12 = false;
        goto L9
    }
}
