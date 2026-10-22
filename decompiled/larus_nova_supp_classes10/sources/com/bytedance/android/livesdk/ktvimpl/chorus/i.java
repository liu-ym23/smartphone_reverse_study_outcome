package com.bytedance.android.livesdk.ktvimpl.chorus;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.de;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i {
    public static final List<MusicPanel> a(List<? extends de.a> r12) {
        Intrinsics.checkNotNullParameter(r12, "$this$toMusicPanelList");
        ArrayList r0 = new ArrayList();
        Iterator<? extends de.a> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        de.a r1 = r13.next();
        Intrinsics.checkNotNullParameter(r1, "$this$toMusicPanel");
        r0.add(new MusicPanel(r1.a(), 0, null, r1.b(), MusicPanel.MusicPanelSource.KSONG, null, null, 1073741774));
        goto L4
    L6:
        return r0;
    }
}
