package com.larus.bmhome.chat.layout.item;

import com.larus.flow.video.bean.CommonVideoModel;
import com.larus.network.http.AsyncThrowable;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.platform.uimodel.MediaEntityContainer;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes25.dex */
public final class n4 implements CommonVideoModel.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l4 f304543a;

    public n4(l4 r100) {
        this.f304543a = r100;
    }

    @Override // com.larus.flow.video.bean.CommonVideoModel.b
    public final void a(MediaEntityContainer r100) {
        if (r100 == null) goto L4;
        ArrayList<MediaEntity> r101 = r100.getVideo_list();
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        FLogger.f375446a.d(l4.class.getSimpleName(), "[preloadMediaDetailData] error!!!  media list is empty ");
        return;
    L13:
        ArrayList<MediaEntity> r103 = this.f304543a.f304496w;
        if (r103 == null) goto L16;
        r103.clear();
    L16:
        if (r100 == null) goto L22;
        ArrayList<MediaEntity> r104 = r100.getVideo_list();
        if (r104 == null) goto L22;
        ArrayList<MediaEntity> r105 = this.f304543a.f304496w;
        if (r105 == null) goto L22;
        r105.addAll(r104);
    L22:
        this.f304543a.n();
        return;
    L7:
        if (r101.isEmpty() == true) goto L10;
        r102 = false;
        goto L11
    L4:
        r101 = null;
        goto L5
    }

    @Override // com.larus.flow.video.bean.CommonVideoModel.b
    public final void b(AsyncThrowable r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        l4 r102 = this.f304543a;
        r102.f304499z = r100.getMessage();
        return;
    L10:
        return;
    L5:
        if (r100.getCode() != 710012017) goto L7;
        r101 = true;
        goto L7
    }
}
