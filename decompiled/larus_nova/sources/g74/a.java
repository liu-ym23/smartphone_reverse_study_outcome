package g74;

import com.baidu.mapapi.map.Arc;
import com.bytedance.map.api.model.IArc;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements IArc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Arc f480221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480222b;

    @Override // com.bytedance.map.api.model.IArc
    public final int getColor() {
        Arc r100 = this.f480221a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getColor();
    }

    @Override // com.bytedance.map.api.model.IArc
    public final int getWidth() {
        Arc r100 = this.f480221a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        int r101 = r100.getWidth();
        int r102 = e74.a.b();
        if (r102 != 0) goto L10;
        return r101;
    L10:
        return Math.round((r101 * r102) / 310.0f);
    }

    @Override // com.bytedance.map.api.model.IArc
    public final float getZIndex() {
        Arc r100 = this.f480221a;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getZIndex();
    }

    @Override // com.bytedance.map.api.model.IArc
    public final boolean isVisible() {
        Arc r100 = this.f480221a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isVisible();
    }

    @Override // com.bytedance.map.api.model.IArc
    public final void remove() {
        Arc r100 = this.f480221a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.remove();
    }

    @Override // com.bytedance.map.api.model.IArc
    public final String getId() {
        return this.f480222b;
    }

    @Override // com.bytedance.map.api.model.IArc
    public final void setColor(int r100) {
        Arc r101 = this.f480221a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setColor(r100);
    }

    @Override // com.bytedance.map.api.model.IArc
    public final void setVisible(boolean r100) {
        Arc r101 = this.f480221a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisible(r100);
    }

    @Override // com.bytedance.map.api.model.IArc
    public final void setWidth(int r100) {
        Arc r101 = this.f480221a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setWidth(e74.a.a(r100));
    }

    @Override // com.bytedance.map.api.model.IArc
    public final void setZIndex(float r100) {
        Arc r101 = this.f480221a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setZIndex((int) r100);
    }

    public a(Arc r100, String r101) {
        this.f480221a = r100;
        this.f480222b = r101;
    }
}
