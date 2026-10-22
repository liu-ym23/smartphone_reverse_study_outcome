package se2;

import android.os.Bundle;
import ch0.f;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.g0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends gg0.b<MultiLinkGuestViewBinder.a> {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final boolean a(e r7, e r8) {
        MultiLinkGuestViewBinder.a r9 = (MultiLinkGuestViewBinder.a) r7;
        MultiLinkGuestViewBinder.a r10 = (MultiLinkGuestViewBinder.a) r8;
        Intrinsics.checkNotNullParameter(r9, "oldItem");
        Intrinsics.checkNotNullParameter(r10, "newItem");
        if (r9.k.a.getUserPosition() != r10.k.a.getUserPosition()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L53;
        ILinkPlayerInfoBridge r1 = r9.k.a;
        ILinkPlayerInfoBridge r2 = r10.k.a;
        IBaseUser r3 = r1.getUser();
        String r4 = null;
        if (r3 == null) goto L10;
        String r5 = r3.getIdString();
    L11:
        IBaseUser r6 = r2.getUser();
        if (r6 == null) goto L15;
        r4 = r6.getIdString();
    L15:
        if (Intrinsics.areEqual(r5, r4) == false) goto L53;
        if (e(r9.k.a, r10.k.a) == false) goto L53;
        if (r9.k.a.getSilenceStatus() != r10.k.a.getSilenceStatus()) goto L21;
        boolean r11 = true;
    L22:
        if (r11 == false) goto L53;
        ILinkPlayerInfoBridge r12 = r9.k.a;
        ILinkPlayerInfoBridge r13 = r10.k.a;
        if (r12.isBackground() == r13.isBackground()) goto L26;
    L28:
        boolean r14 = false;
    L29:
        if (r14 == false) goto L53;
        g0 r15 = r9.k.a.getMicPosTagInfo();
        g0 r16 = r10.k.a.getMicPosTagInfo();
        if (r15 != null) goto L34;
        if (r16 != null) goto L34;
        boolean r17 = true;
    L37:
        if (r17 == false) goto L53;
        if (r10.k.d.get("EXT_KEY_SEAT_ANIM_ACTION") == null) goto L41;
        boolean r18 = true;
    L42:
        if (r18 == true) goto L53;
        if (f(r9, r10) == false) goto L53;
        if (Intrinsics.areEqual(r9.k.a.getMicDress(), r10.k.a.getMicDress()) == false) goto L53;
        if (r10.k.d.get("EXT_KEY_TAG_LABEL_ACTION") == null) goto L50;
        boolean r19 = true;
    L51:
        if (r19 == true) goto L53;
        return true;
    L50:
        r19 = false;
        goto L51
    L41:
        r18 = false;
    L34:
        if (r15 == null) goto L36;
        r17 = r15.equals(r16);
        goto L37
    L36:
        r17 = false;
        goto L37
    L26:
        if (r12.isSelfBackground() != r13.isSelfBackground()) goto L28;
        r14 = true;
        goto L29
    L21:
        r11 = false;
        goto L22
    L10:
        r5 = null;
    L53:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean b(e r3, e r4) {
        MultiLinkGuestViewBinder.a r5 = (MultiLinkGuestViewBinder.a) r3;
        MultiLinkGuestViewBinder.a r6 = (MultiLinkGuestViewBinder.a) r4;
        Intrinsics.checkNotNullParameter(r5, "oldItem");
        Intrinsics.checkNotNullParameter(r6, "newItem");
        if (((e) r5).a != ((e) r6).a) goto L14;
        IBaseUser r7 = r5.k.a.getUser();
        String r0 = null;
        if (r7 == null) goto L7;
        String r8 = r7.getIdString();
    L8:
        IBaseUser r9 = r6.k.a.getUser();
        if (r9 == null) goto L12;
        r0 = r9.getIdString();
    L12:
        if (Intrinsics.areEqual(r8, r0) == false) goto L14;
        return true;
    L7:
        r8 = null;
    L14:
        return false;
    }

    public final boolean e(ILinkPlayerInfoBridge r1, ILinkPlayerInfoBridge r2) {
        IBaseUser r3 = r1.getUser();
        if (r3 == null) goto L11;
        k r4 = r3.getAvatarMedium();
        if (r4 == null) goto L11;
        IBaseUser r5 = r2.getUser();
        if (r5 == null) goto L9;
        k r6 = r5.getAvatarMedium();
    L13:
        return r4.equalsOnlyUri(r6);
    L9:
        r6 = null;
    L11:
        return false;
    }

    public final boolean f(MultiLinkGuestViewBinder.a r5, MultiLinkGuestViewBinder.a r6) {
        Map r0 = r5.k.d;
        Object r2 = null;
        if (r0 == null) goto L5;
        Object r1 = r0.get("EXT_KEY_KTV_UPDATE_TALK_STATUS");
    L6:
        Map r3 = r6.k.d;
        if (r3 == null) goto L10;
        r2 = r3.get("EXT_KEY_KTV_UPDATE_TALK_STATUS");
    L10:
        if ((!Intrinsics.areEqual(r1, r2)) == false) goto L13;
        return false;
    L13:
        if (f.a(r5.k) == f.a(r6.k)) goto L17;
        return false;
    L17:
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final Bundle d(e r6, e r7, int r8, int r9) {
        MultiLinkGuestViewBinder.a r10 = (MultiLinkGuestViewBinder.a) r6;
        MultiLinkGuestViewBinder.a r11 = (MultiLinkGuestViewBinder.a) r7;
        Intrinsics.checkNotNullParameter(r10, "oldItem");
        Intrinsics.checkNotNullParameter(r11, "newItem");
        Bundle r0 = super.d(r10, r11, r8, r9);
        boolean r3 = false;
        if (r10.k.a.getUserPosition() != r11.k.a.getUserPosition()) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        if (r8 != r9) goto L8;
    L10:
        if (e(r10.k.a, r11.k.a) == false) goto L20;
        ILinkPlayerInfoBridge r12 = r10.k.a;
        ILinkPlayerInfoBridge r13 = r11.k.a;
        IBaseUser r14 = r12.getUser();
        String r2 = null;
        if (r14 == null) goto L14;
        String r15 = r14.getIdString();
    L15:
        IBaseUser r16 = r13.getUser();
        if (r16 == null) goto L19;
        r2 = r16.getIdString();
    L19:
        if (Intrinsics.areEqual(r15, r2) == false) goto L20;
    L22:
        if (r10.k.a.getSilenceStatus() != r11.k.a.getSilenceStatus()) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == true) goto L27;
        r0.putBoolean("payload_key_silence_status_update", true);
    L27:
        ILinkPlayerInfoBridge r18 = r10.k.a;
        ILinkPlayerInfoBridge r19 = r11.k.a;
        if (r18.isBackground() == r19.isBackground()) goto L30;
    L32:
        boolean r20 = false;
    L33:
        if (r20 == true) goto L35;
        r0.putBoolean("payload_key_background_status_update", true);
    L35:
        g0 r21 = r10.k.a.getMicPosTagInfo();
        g0 r22 = r11.k.a.getMicPosTagInfo();
        if (r21 != null) goto L39;
        if (r22 != null) goto L39;
        boolean r23 = true;
    L42:
        if (r23 == true) goto L45;
        r0.putBoolean("payload_key_link_mic_tag_info_update", true);
    L45:
        if (r11.k.d.get("EXT_KEY_SEAT_ANIM_ACTION") == null) goto L47;
        r3 = true;
    L47:
        if (r3 == false) goto L50;
        r0.putBoolean("payload_key_is_seat_anim_action_update", true);
    L50:
        if (f(r10, r11) == true) goto L53;
        r0.putBoolean("payload_key_mic_talk_state", true);
    L53:
        if (Intrinsics.areEqual(r10.k.a.getMicDress(), r11.k.a.getMicDress()) == true) goto L55;
        r0.putBoolean("payload_key_mic_dress", true);
    L55:
        return r0;
    L39:
        if (r21 == null) goto L41;
        r23 = r21.equals(r22);
        goto L42
    L41:
        r23 = false;
        goto L42
    L30:
        if (r18.isSelfBackground() != r19.isSelfBackground()) goto L32;
        r20 = true;
        goto L33
    L24:
        r17 = false;
        goto L25
    L14:
        r15 = null;
    L20:
        r0.putBoolean("payload_key_avatar_update", true);
    L8:
        r0.putBoolean("payload_key_user_position", true);
        goto L10
    L5:
        r1 = false;
        goto L6
    }
}
