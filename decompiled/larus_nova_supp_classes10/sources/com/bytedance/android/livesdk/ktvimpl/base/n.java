package com.bytedance.android.livesdk.ktvimpl.base;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.model.KtvMode;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements bb0.a {
    public static final n a = null;

    public n() {
    }

    public final boolean f() {
        return true;
    }

    public final String k() {
        return "ttlive_ktv";
    }

    public final boolean l() {
        return true;
    }

    static {
        a = new n();
    }

    public final String a() {
        KtvContext.Companion.getClass();
        oe2.b r0 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a();
    }

    public final boolean b() {
        Lazy r0 = KtvSettingHelper.a;
        return KtvUtilsKt.g();
    }

    public final String c() {
        KtvContext.Companion.getClass();
        oe2.b r0 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public final List<Long> g() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L11;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L11;
        MutableLiveData<List<Long>> r3 = r2.getSelfWantListenSongList();
        if (r3 == null) goto L11;
        return (List) r3.getValue();
    L11:
        return null;
    }

    public final List<String> j() {
        KtvContext.Companion.getClass();
        return KtvContext.a.g().getRecentMusicInfo();
    }

    public final KtvMode d() {
        return KtvMode.LIVE_KTV;
    }

    public final void e(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "newList");
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L12;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L13;
        KtvComponentUIContext r3 = (KtvComponentUIContext) r1.getValue();
        if (r3 == null) goto L14;
        MutableLiveData<List<Long>> r4 = r3.getSelfWantListenSongList();
        if (r4 == null) goto L15;
        r4.setValue(r2);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public final boolean i(long r9) {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        Object r3 = null;
        if (r0 == null) goto L22;
        com.bytedance.live.datacontext.n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L22;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L22;
        MutableLiveData<List<Long>> r4 = r2.getSelfWantListenSongList();
        if (r4 == null) goto L22;
        List r5 = (List) r4.getValue();
        if (r5 == null) goto L22;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L21;
        Object r7 = r6.next();
        if (r9 != ((Number) r7).longValue()) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == false) goto L14;
        r3 = r7;
        goto L21
    L18:
        r8 = false;
    L21:
        r3 = (Long) r3;
    L22:
        if (r3 != null) goto L31;
        return false;
    L31:
        return true;
    }

    public final void h(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "musicTitle");
        KtvContext.Companion.getClass();
        KtvContext.a.b(r2, r4);
    }
}
