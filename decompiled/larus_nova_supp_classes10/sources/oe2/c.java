package oe2;

import android.content.Context;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements sb0.b {
    public Context b;
    public final b c;
    public final g d;
    public final a e;
    public final KtvContext f;
    public final o g;
    public final DataCenter h;

    public static final class a implements sb0.d {
        public a() {
        }

        public final MusicPanel a() {
            ChorusContext.a r0 = ChorusContext.Companion;
            if (r0.c() == false) goto L9;
            ChorusContext r1 = r0.getContext();
            if (r1 == null) goto L13;
            List<MusicPanel> r2 = r1.getChorusNotSelfSeeingMusicList();
            if (r2 != null) goto L15;
            return null;
        L15:
            return (MusicPanel) CollectionsKt.firstOrNull(r2);
        L13:
            return null;
        L9:
            KtvComponentOrderedSongDataContext r3 = KtvComponentOrderedSongDataContext.Companion.getContext();
            if (r3 != null) goto L12;
            return null;
        L12:
            return r3.getKtvPublicFirstOrderedSong();
        }

        public final List<SongUniqueInfo> c() {
            KtvComponentOrderedSongDataContext r0 = KtvComponentOrderedSongDataContext.Companion.getContext();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.m201getKtvSongUniqueInfoList();
        }
    }

    public static final class b extends i {
        public b(KtvContext r2, o r3) {
            super(r2, r3, null);
        }
    }

    public final boolean a() {
        return this.f.isCurrentUserIsSinger();
    }

    public final String f() {
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L9;
        String r2 = r1.n();
        if (r2 == null) goto L9;
        return r2;
    L9:
        return "";
    }

    public final String e() {
        return ((i) b()).a();
    }

    public final boolean isAnchor() {
        return ((i) b()).isAnchor();
    }

    public final sb0.e b() {
        return this.c;
    }

    public final sb0.c c() {
        return this.d;
    }

    public final sb0.d d() {
        return this.e;
    }

    public final Context getContext() {
        return this.b;
    }

    public final DataCenter getDataCenter() {
        return this.h;
    }

    public c(KtvContext r2, o r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        Intrinsics.checkNotNullParameter(r4, "roomDataCenter");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.c = new b(r2, r3);
        m r5 = r3.getRoom();
        if (r5 == null) goto L5;
        IRoom r6 = (IRoom) r5.getValue();
    L6:
        this.d = new g(r6);
        this.e = new a();
        return;
    L5:
        r6 = null;
        goto L6
    }
}
