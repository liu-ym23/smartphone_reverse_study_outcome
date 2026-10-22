package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    @Deprecated(message = "后续不要在使用这个方法", replaceWith = @ReplaceWith(expression = "直接拿具体业务context", imports = {}))
    public static final MusicPanel a(KtvContext r1) {
        Intrinsics.checkNotNullParameter(r1, "ktvContext");
        OrderedSongDataContext r2 = d(r1.isKtvMode());
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getKtvPublicFirstOrderedSong();
    }

    @Deprecated(message = "后续不要在使用这个方法", replaceWith = @ReplaceWith(expression = "直接拿具体业务context", imports = {}))
    public static final List<MusicPanel> b(KtvContext r1) {
        Intrinsics.checkNotNullParameter(r1, "ktvContext");
        OrderedSongDataContext r2 = d(r1.isKtvMode());
        if (r2 == null) goto L7;
        List<MusicPanel> r3 = r2.getKtvPublicOrderedSongList();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return new ArrayList();
    }

    @Deprecated(message = "后续不要在使用这个方法", replaceWith = @ReplaceWith(expression = "直接拿具体业务context", imports = {}))
    public static final List<MusicPanel> c(KtvContext r1) {
        Intrinsics.checkNotNullParameter(r1, "ktvContext");
        OrderedSongDataContext r2 = d(r1.isKtvMode());
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.m200getKtvSingSongList();
    }

    @Deprecated(message = "后续不要在使用这个方法", replaceWith = @ReplaceWith(expression = "直接拿具体业务context", imports = {}))
    public static final OrderedSongDataContext d(boolean r0) {
        if (r0 == false) goto L5;
        return KtvModeOrderedSongDataContext.Companion.getContext();
    L5:
        return KtvComponentOrderedSongDataContext.Companion.getContext();
    }

    @Deprecated(message = "后续不要在使用这个方法", replaceWith = @ReplaceWith(expression = "直接拿具体业务context", imports = {}))
    public static final int e(KtvContext r1) {
        Intrinsics.checkNotNullParameter(r1, "ktvContext");
        OrderedSongDataContext r2 = d(r1.isKtvMode());
        if (r2 == null) goto L7;
        List<SongUniqueInfo> r3 = r2.getKtvPublicSongUniqueInfoList();
        if (r3 == null) goto L7;
        return r3.size();
    L7:
        return 0;
    }
}
