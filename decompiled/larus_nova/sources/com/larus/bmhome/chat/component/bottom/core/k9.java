package com.larus.bmhome.chat.component.bottom.core;

import androidx.fragment.app.Fragment;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final op8.k f299275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ICoreInputAbility f299276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f299277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ICoreInputAbility f299278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f299279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j9 f299280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i9 f299281g;

    public final void a(String r110) {
        if (Intrinsics.areEqual(this.f299277c.invoke(), r110) == false) goto L5;
        return;
    L5:
        this.f299279e = true;
        ICoreInputAbility.b.d(this.f299276b, r110, false, false, null, null, false, 56);     // Catch: Throwable -> L9
        this.f299279e = false;
        return;
    L9:
        th = move-exception;
        this.f299279e = false;
        throw th;
    }

    public k9(op8.k r100, ICoreInputAbility r101, com.larus.bmhome.chat.component.bottom.attachment.v r102) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_CONNECTION);
        Intrinsics.checkNotNullParameter(r101, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r102, "childText");
        this.f299275a = r100;
        this.f299276b = r101;
        this.f299277c = r102;
        Fragment r103 = r100.a();
        if (r103 == null) goto L5;
        ICoreInputAbility r104 = (ICoreInputAbility) s1a.a.g(r103).getAbility(ICoreInputAbility.class);
    L6:
        this.f299278d = r104;
        this.f299280f = new j9(this);
        this.f299281g = new i9(this);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
