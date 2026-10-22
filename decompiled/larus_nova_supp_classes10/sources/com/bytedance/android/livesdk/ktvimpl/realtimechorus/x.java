package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x implements sb0.b {
    public final k1 b;
    public final String c;
    public final a d;
    public final d e;
    public final KtvContext f;
    public final com.bytedance.android.livesdk.chatroom.o g;
    public final DataCenter h;
    public final com.bytedance.android.live.pushstream.d i;

    public static final class a implements sb0.d {
        public a() {
        }

        public final MusicPanel a() {
            KtvModeOrderedSongDataContext r0 = KtvModeOrderedSongDataContext.Companion.getContext();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getKtvPublicFirstOrderedSong();
        }

        public final List<SongUniqueInfo> c() {
            KtvModeOrderedSongDataContext r0 = KtvModeOrderedSongDataContext.Companion.getContext();
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.m201getKtvSongUniqueInfoList();
        }
    }

    public final Context getContext() {
        return null;
    }

    public final boolean a() {
        return this.f.isCurrentUserIsSinger();
    }

    public final String f() {
        String r0 = this.c;
        if (r0 != null) goto L10;
        IMiddlewareUserService r1 = jc1.k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.user.e r2 = r1.user();
        if (r2 == null) goto L9;
        r0 = r2.n();
    L9:
        r0 = null;
    L10:
        if (r0 != null) goto L13;
        return "";
    L13:
        return r0;
    }

    public final String e() {
        return ((k1) b()).a();
    }

    public final boolean isAnchor() {
        return ((k1) b()).isAnchor();
    }

    public final sb0.e b() {
        return this.b;
    }

    public final sb0.c c() {
        return this.e;
    }

    public final sb0.d d() {
        return this.d;
    }

    public final DataCenter getDataCenter() {
        return this.h;
    }

    public x(KtvContext r2, com.bytedance.android.livesdk.chatroom.o r3, DataCenter r4, com.bytedance.android.live.pushstream.d r5) {
        Intrinsics.checkNotNullParameter(r2, "ktvContext");
        Intrinsics.checkNotNullParameter(r3, "roomContext");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.b = new k1(r2, r3, r5);
        IMiddlewareUserService r6 = jc1.k.f(IMiddlewareUserService.class);
        IRoom r7 = null;
        if (r6 == null) goto L7;
        com.bytedance.android.livesdk.user.e r8 = r6.user();
        if (r8 == null) goto L7;
        String r9 = r8.n();
    L8:
        this.c = r9;
        this.d = new a();
        com.bytedance.live.datacontext.m r10 = r3.getRoom();
        if (r10 == null) goto L11;
        r7 = (IRoom) r10.getValue();
    L11:
        this.e = new d(r7);
        return;
    L7:
        r9 = null;
        goto L8
    }
}
