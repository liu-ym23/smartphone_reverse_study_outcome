package g74;

import androidx.camera.video.AudioStats;
import com.baidu.mapapi.map.Circle;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.SpatialRelationUtil;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.ICircle;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements ICircle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Circle f480223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480224b;

    @Override // com.bytedance.map.api.model.ICircle
    public final double getRadius() {
        Circle r100 = this.f480223a;
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.getRadius();
    }

    @Override // com.bytedance.map.api.model.ICircle
    public final void remove() {
        Circle r100 = this.f480223a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.remove();
    }

    @Override // com.bytedance.map.api.model.ICircle
    public final String getId() {
        return this.f480224b;
    }

    @Override // com.bytedance.map.api.model.ICircle
    public final boolean contains(BDLatLng r100) {
        if (this.f480223a == null) goto L8;
        if (r100 == null) goto L10;
        LatLng r101 = new LatLng(r100.getLatitude(), r100.getLongitude());
        return SpatialRelationUtil.isCircleContainsPoint(this.f480223a.getCenter(), this.f480223a.getRadius(), r101);
    L10:
        return false;
    L8:
        return false;
    }

    @Override // com.bytedance.map.api.model.ICircle
    public final void setFillColor(int r100) {
        Circle r101 = this.f480223a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setFillColor(r100);
    }

    @Override // com.bytedance.map.api.model.ICircle
    public final void setLineWidth(float r100) {
        Circle r101 = this.f480223a;
        if (r101 != null) goto L5;
        return;
    L5:
        float r102 = e74.a.a((int) r100);
        if (this.f480223a.getStroke() == null) goto L8;
        int r103 = this.f480223a.getStroke().color;
    L9:
        r101.setStroke(new Stroke(r102, r103));
        return;
    L8:
        r103 = 0;
        goto L9
    }

    @Override // com.bytedance.map.api.model.ICircle
    public final void setStrokeColor(int r100) {
        Circle r101 = this.f480223a;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getStroke() == null) goto L8;
        float r102 = this.f480223a.getStroke().strokeWidth;
    L9:
        r101.setStroke(new Stroke(r102, r100));
        return;
    L8:
        r102 = 0.0f;
        goto L9
    }

    @Override // com.bytedance.map.api.model.ICircle
    public final void updateCenter(BDLatLng r100) {
        Circle r101 = this.f480223a;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.setCenter(new LatLng(r100.getLatitude(), r100.getLongitude()));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.map.api.model.ICircle
    public final void updateRadius(double r100) {
        Circle r101 = this.f480223a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setRadius((int) r100);
    }

    public b(Circle r100, String r101) {
        this.f480223a = r100;
        this.f480224b = r101;
    }
}
