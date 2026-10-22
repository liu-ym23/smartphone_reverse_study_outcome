package com.larus.avlink.gallery.silent;

import com.larus.utils.logger.FLogger;
import java.util.Timer;
import kotlin.Pair;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements com.larus.avlink.gallery.thumbnail.a {
    public a() {
    }

    @Override // com.larus.avlink.gallery.thumbnail.a
    public final void a(int r100, int r101) {
        if (SilentSyncManager.f292711g.getFirst().intValue() == r100) goto L5;
    L8:
        Job r102 = SilentSyncManager.f292705a;
        SilentSyncManager.f292711g = new Pair(Integer.valueOf(r100), Integer.valueOf(r101));
        FLogger r103 = FLogger.f375446a;
        r103.i("SilentSyncManager", "Album state changed: images=" + r100 + ", videos=" + r101);
        if (r100 > 0) goto L15;
        if (r101 > 0) goto L15;
        r103.d("SilentSyncManager", "Album is empty, cancelling auto sync timer");
        Timer r104 = SilentSyncManager.f292706b;
        if (r104 == null) goto L19;
        r104.cancel();
        return;
    L19:
        return;
    L15:
        Job r105 = SilentSyncManager.f292705a;
        if (SilentSyncManager.b() == false) goto L20;
        r103.i("SilentSyncManager", "Album has media content - scheduling auto sync (images=" + r100 + ", videos=" + r101 + ')');
        SilentSyncManager.a("album_state_change");
        return;
    L20:
        return;
    L5:
        if (SilentSyncManager.f292711g.getSecond().intValue() != r101) goto L8;
        FLogger.f375446a.d("SilentSyncManager", "Album state unchanged " + r100 + ", " + r101 + ", skipping");
    }
}
