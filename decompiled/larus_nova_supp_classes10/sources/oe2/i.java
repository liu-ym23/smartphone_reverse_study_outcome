package oe2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.AvatarType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class i implements sb0.e {
    public final IRoom a;
    public final long b;
    public final o c;
    public final com.bytedance.android.live.pushstream.d d;

    public boolean b() {
        return !(this instanceof c.b);
    }

    public final String a() {
        IRoom r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.getOwnerUserIdString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final Map<String, String> getAnchorAbMap() {
        IRoom r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAnchorABMap();
    }

    public final IBaseUser getOwner() {
        IRoom r0 = this.a;
        if (r0 == null) goto L5;
        IBaseUser r1 = r0.getOwner();
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");
    L5:
        r1 = null;
        goto L6
    }

    public final boolean isAnchor() {
        Boolean r0 = this.c.isAnchor();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public final com.bytedance.android.live.pushstream.d getLiveStream() {
        return this.d;
    }

    public final long getRoomId() {
        return this.b;
    }

    public final py.k c(Integer r2) {
        IRoom r0 = this.a;
        if (r0 == null) goto L10;
        IBaseUser r1 = r0.getOwner();
        if (r1 == null) goto L10;
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L12:
        return com.bytedance.android.live.liveinteract.linkpanel.util.o.h(r1, r3);
    L8:
        r3 = AvatarType.AVATAR_THUMB.getValue();
    L10:
        return null;
    }

    public i(KtvContext r2, o r3, com.bytedance.android.live.pushstream.d r4) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.c = r3;
        this.d = r4;
        m r5 = r3.getRoom();
        if (r5 == null) goto L5;
        IRoom r6 = (IRoom) r5.getValue();
    L6:
        this.a = r6;
        if (r6 == null) goto L9;
        long r7 = r6.getRoomId();
    L10:
        this.b = r7;
        return;
    L9:
        r7 = 0;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
