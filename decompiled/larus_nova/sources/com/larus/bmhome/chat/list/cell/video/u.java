package com.larus.bmhome.chat.list.cell.video;

import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class u extends xc8.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f306590e;

    @Override // xc8.b
    public final int d() {
        return com.larus.bmhome.chat.bean.d.G0(this.f563233a) ? 1 : 0;
    }

    public final boolean i() {
        CommonVideoModel.a r100 = CommonVideoModel.Companion;
        String r101 = this.f563233a.getContent();
        r100.getClass();
        MediaEntityContainer r102 = CommonVideoModel.a.a(r101);
        if (r102 != null) goto L5;
        return false;
    L5:
        ArrayList<MediaEntity> r103 = r102.getVideo_list();
        if (r103 == null) goto L13;
        MediaEntity r104 = (MediaEntity) CollectionsKt.firstOrNull(r103);
        if (r104 != null) goto L10;
        return false;
    L10:
        if (r104.getMedia_status() != 0) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    }

    public u(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        super(r100);
    }
}
