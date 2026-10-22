package com.larus.bmhome.chat.list.cell.video;

import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.platform.uimodel.MediaEntity;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class m implements l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList<MediaEntity> f306584a;

    public m(ArrayList<MediaEntity> r100) {
        this.f306584a = r100;
    }

    @Override // com.larus.platform.api.l4
    public final void a(String r100, com.larus.video.impl.sdk.a r101) {
        if (this.f306584a.isEmpty() == false) goto L5;
        return;
    L5:
        MediaEntity r102 = (MediaEntity) CollectionsKt.firstOrNull(this.f306584a);
        if (r102 == null) goto L8;
        String r103 = r102.getVideo_model();
    L10:
        if (Intrinsics.areEqual(r103, r100) == false) goto L15;
        Lazy r104 = q3.f365794a;
        z3 r105 = q3.a();
        if (r105 == null) goto L16;
        z3.a.a(r105, r101, null, 0, null, 30);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r103 = null;
        goto L10
    }
}
