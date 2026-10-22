package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.diff;

import android.os.Bundle;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkNormalEmptyViewBinder;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import gg0.a;
import java.util.List;
import se2.b;
import tf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class KtvRoomDiffCallback extends DiffUtil.Callback {
    public final a a;
    public final List<e> b;
    public final List<e> c;

    public final int getNewListSize() {
        return this.c.size();
    }

    public final int getOldListSize() {
        return this.b.size();
    }

    public KtvRoomDiffCallback(List<e> r4, List<e> r5) {
        a r0 = new a();
        this.a = r0;
        r0.b(MultiLinkNormalEmptyViewBinder.a.class, new se2.a());
        r0.b(MultiLinkGuestViewBinder.a.class, new b());
        this.b = r4;
        this.c = r5;
    }

    public final Boolean a(e r1, e r2) {
        VoiceLiveTheme r3 = r1.c;
        VoiceLiveTheme r4 = r2.c;
        if (r3 == null) goto L7;
        if (r4 == null) goto L7;
        return Boolean.valueOf(r3.equals(r4));
    L7:
        if (r3 != null) goto L10;
        if (r4 != null) goto L10;
        boolean r5 = true;
    L12:
        return Boolean.valueOf(r5);
    L10:
        r5 = false;
        goto L12
    }

    public final boolean areContentsTheSame(int r5, int r6) {
        e r7 = (e) ListProtector.get(this.b, r5);
        e r8 = (e) ListProtector.get(this.c, r6);
        if (r7.getClass() != r8.getClass()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        return false;
    L9:
        if (this.a.a(r7).a(r7, r8) == true) goto L11;
    L13:
        return false;
    L11:
        if (a(r7, r8).booleanValue() == false) goto L13;
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean areItemsTheSame(int r6, int r7) {
        e r0 = (e) ListProtector.get(this.b, r6);
        e r1 = (e) ListProtector.get(this.c, r7);
        if (r0.getClass() != r1.getClass()) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L11;
        if (r6 != r7) goto L11;
        return this.a.a(r0).b(r0, r1);
    L11:
        return false;
    L5:
        r2 = false;
        goto L6
    }

    public final Object getChangePayload(int r6, int r7) {
        e r0 = (e) ListProtector.get(this.b, r6);
        e r1 = (e) ListProtector.get(this.c, r7);
        if (r0.getClass() != r1.getClass()) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        Bundle r8 = new Bundle();
        r8.putBoolean("payload_key_is_not_same_class", true);
        return r8;
    L9:
        Bundle r9 = this.a.a(r0).d(r0, r1, r6, r7);
        if (a(r0, r1).booleanValue() == true) goto L12;
        r9.putBoolean("payload_key_theme_update", true);
    L12:
        return r9;
    L5:
        r2 = false;
        goto L6
    }
}
