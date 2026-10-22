package g74;

import com.baidu.mapapi.map.HeatMap;
import com.bytedance.map.api.model.IHeatMap;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements IHeatMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HeatMap f480225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480226b;

    @Override // com.bytedance.map.api.model.IHeatMap
    public final void clearTileCache() {
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public final float getZIndex() {
        return 0.0f;
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public final boolean isVisible() {
        return true;
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public final void setVisible(boolean r100) {
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public final void setZIndex(float r100) {
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public final void remove() {
        HeatMap r100 = this.f480225a;
        if (r100 == null) goto L6;
        r100.removeHeatMap();
        return;
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public final String getId() {
        return this.f480226b;
    }

    public c(HeatMap r100, String r101) {
        this.f480225a = r100;
        this.f480226b = r101;
    }
}
