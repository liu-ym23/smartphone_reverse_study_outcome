package com.bytedance.locallife.poi.media.impl;

import android.app.Activity;
import com.bytedance.locallife.poi.media.api.IPlayerLayerFactoryService;
import com.bytedance.locallife.poi.media.entity.PoiVideoStyle;
import com.bytedance.locallife.poi.media.ui.e;
import hy6.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/poi/media/impl/PlayerLayerFactoryServiceImpl;", "Lcom/bytedance/locallife/poi/media/api/IPlayerLayerFactoryService;", "Landroid/app/Activity;", "activity", "", "scene", "videoStyle", "Lhy6/a;", "getPlayerLayerCreator", "<init>", "()V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PlayerLayerFactoryServiceImpl implements IPlayerLayerFactoryService {
    public PlayerLayerFactoryServiceImpl() {
    }

    @Override // com.bytedance.locallife.poi.media.api.IPlayerLayerFactoryService
    public a getPlayerLayerCreator(Activity r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        if (r102 == PoiVideoStyle.VIDEO_STYLE_LYNX.getStyle()) goto L5;
        return null;
    L5:
        return new e(r100);
    }
}
