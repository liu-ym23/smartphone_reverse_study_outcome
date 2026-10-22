package oe2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.c6;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostUser;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.AvatarType;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.ktv.KTVRoomFeedModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements sb0.b {
    public final String b;
    public final c c;
    public final b d;
    public final C0158a e;
    public final KTVRoomFeedModel f;
    public final com.bytedance.android.livesdk.ktvimpl.feed.a g;

    /* JADX INFO: renamed from: oe2.a$a, reason: collision with other inner class name */
    public static final class C0158a implements sb0.c {
        public final /* synthetic */ a a;

        public final boolean isAudienceLinkEngineOn() {
            return false;
        }

        public final List<LinkPlayerInfo> getOnlineUserList() {
            return this.a.g.getFeedGuestList();
        }

        public C0158a(a r1) {
            this.a = r1;
        }

        public final void a(List<? extends LinkPlayerInfo> r2) {
            this.a.g.setFeedGuestList(r2);
        }
    }

    public static final class b implements sb0.d {
        public List<MusicPanel> a;
        public MusicPanel b;
        public List<SongUniqueInfo> c;

        public b() {
            new ArrayList();
        }

        public final MusicPanel a() {
            return this.b;
        }

        public final List<SongUniqueInfo> c() {
            return this.c;
        }
    }

    public static final class c implements sb0.e {
        public final long a;
        public final /* synthetic */ a b;

        public final boolean b() {
            return true;
        }

        public final com.bytedance.android.live.pushstream.d getLiveStream() {
            return null;
        }

        public final IBaseUser getOwner() {
            return null;
        }

        public final boolean isAnchor() {
            return false;
        }

        public final String a() {
            String r0 = this.b.f.ownerUserIdString;
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        public final Map<String, String> getAnchorAbMap() {
            com.bytedance.android.livesdk.ktvimpl.feed.a r0 = this.b.g;
            if (r0 == null) goto L7;
            IRoom r1 = r0.getFeedRoom();
            if (r1 == null) goto L7;
            return r1.getAnchorABMap();
        L7:
            return null;
        }

        public final long getRoomId() {
            return this.a;
        }

        public c(a r3) {
            this.b = r3;
            this.a = r3.f.roomId;
        }

        public final py.k c(Integer r6) {
            if (r6 == null) goto L4;
            int r7 = r6.intValue();
        L5:
            IRoom r0 = this.b.f.room;
            if (r0 == null) goto L9;
            IBaseUser r1 = r0.getOwner();
            if (r1 == null) goto L9;
        L26:
            if (r1 != null) goto L28;
            return null;
        L28:
            return je0.d.n(r1, r7);
        L9:
            List<LinkPlayerInfo> r2 = this.b.e.getOnlineUserList();
            if (r2 == null) goto L25;
            Iterator<T> r3 = r2.iterator();
        L13:
            if (r3.hasNext() == false) goto L21;
            Object r4 = r3.next();
            IBaseUser r5 = ((LinkPlayerInfo) r4).getUser();
            if (r5 == null) goto L17;
            String r8 = r5.getIdString();
        L19:
            if (Intrinsics.areEqual(r8, this.b.e()) == false) goto L13;
        L22:
            LinkPlayerInfo r9 = (LinkPlayerInfo) r4;
            if (r9 == null) goto L25;
            r1 = r9.getUser();
            goto L26
        L17:
            r8 = null;
            goto L19
        L21:
            r4 = null;
        L25:
            r1 = null;
            goto L26
        L4:
            r7 = AvatarType.AVATAR_THUMB.getValue();
            goto L5
        }
    }

    public final boolean a() {
        return false;
    }

    public final /* bridge */ /* synthetic */ DataCenter getDataCenter() {
        return null;
    }

    public final String f() {
        String r0 = this.b;
        String r1 = null;
        if (r0 != null) goto L13;
        IMiddleHostService r2 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r2 == null) goto L11;
        IMiddlewareHostUser r3 = r2.user();
        if (r3 == null) goto L11;
        r0 = r3.getCurUserId();
        if (r0 != null) goto L13;
    L11:
        r0 = null;
    L13:
        if (r0 == null) goto L15;
    L24:
        r1 = r0;
    L25:
        if (r1 != null) goto L28;
        return "";
    L28:
        return r1;
    L15:
        if (c6.a == false) goto L23;
        IMiddlewareUserService r4 = jc1.k.f(IMiddlewareUserService.class);
        if (r4 == null) goto L25;
        com.bytedance.android.livesdk.user.e r5 = r4.user();
        if (r5 == null) goto L25;
        r0 = r5.n();
        if (r0 == null) goto L25;
    L23:
        r1 = "";
        goto L25
    }

    public final String e() {
        return ((c) b()).a();
    }

    public final boolean isAnchor() {
        return ((c) b()).isAnchor();
    }

    public final sb0.e b() {
        return this.c;
    }

    public final sb0.c c() {
        return this.e;
    }

    public final sb0.d d() {
        return this.d;
    }

    public a(KTVRoomFeedModel r2, com.bytedance.android.livesdk.ktvimpl.feed.a r3) {
        Intrinsics.checkNotNullParameter(r2, "feedModelKTV");
        Intrinsics.checkNotNullParameter(r3, "feedViewData");
        this.f = r2;
        this.g = r3;
        IMiddleHostService r4 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r4 == null) goto L9;
        IMiddlewareHostUser r5 = r4.user();
        if (r5 == null) goto L9;
        String r6 = r5.getCurUserId();
        if (r6 == null) goto L9;
    L10:
        this.b = r6;
        this.c = new c(this);
        this.d = new b();
        this.e = new C0158a(this);
        return;
    L9:
        r6 = null;
        goto L10
    }
}
