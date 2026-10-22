package com.larus.asr.session;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class m implements com.larus.asr.session.component.n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentAsrSession f287940a;

    public m(ComponentAsrSession r100) {
        this.f287940a = r100;
    }

    @Override // com.larus.asr.session.component.n0
    public final void c(Integer r100) {
        com.larus.asr.session.component.f0 r101 = this.f287940a.f287446h;
        if (r101 == null) goto L5;
        this.f287940a.h(r101);
    L5:
        Iterator r102 = ComponentAsrSession.a(this.f287940a).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((com.larus.asr.session.component.n0) r102.next()).c(r100);
        goto L7
    }

    @Override // com.larus.asr.session.component.n0
    public final void a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Iterator r102 = ((ArrayList) ComponentAsrSession.a(this.f287940a)).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.n0) r102.next()).a(r100, r101);
        goto L4
    }

    @Override // com.larus.asr.session.component.p0
    public final void b(com.larus.asr.session.component.b0 r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, BitableAnalytic.SelectSceneClickType.COMPLETE);
        r101.invoke(com.larus.asr.session.component.c0.b.f287688a);
    }
}
