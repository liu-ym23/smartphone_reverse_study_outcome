package g74;

import com.baidu.mapapi.map.Polygon;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IPolygon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements IPolygon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Polygon f480233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480234b;

    @Override // com.bytedance.map.api.model.IPolygon
    public final List<BDLatLng> getPoints() {
        Polygon r100 = this.f480233a;
        if (r100 != null) goto L5;
        return null;
    L5:
        List<LatLng> r101 = r100.getPoints();
        if (r101 != null) goto L8;
        return null;
    L8:
        if (r101.isEmpty() == true) goto L28;
        ArrayList r102 = new ArrayList();
        Iterator<LatLng> r103 = r101.iterator();
    L12:
        if (r103.hasNext() == false) goto L18;
        LatLng r104 = r103.next();
        if (r104 == null) goto L12;
        r102.add(new BDLatLng(r104.latitude, r104.longitude));
        goto L12
    L18:
        if (r102.isEmpty() == false) goto L21;
        return null;
    L21:
        return r102;
    L28:
        return null;
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public final boolean isClickable() {
        Polygon r100 = this.f480233a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isClickable();
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public final void remove() {
        Polygon r100 = this.f480233a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.remove();
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public final String getId() {
        return this.f480234b;
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public final void setClickable(boolean r100) {
        Polygon r101 = this.f480233a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setClickable(r100);
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public final void setFillColor(int r100) {
        Polygon r101 = this.f480233a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setFillColor(r100);
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public final void setLineWidth(float r100) {
        Polygon r101 = this.f480233a;
        if (r101 != null) goto L5;
        return;
    L5:
        float r102 = e74.a.a((int) r100);
        if (this.f480233a.getStroke() == null) goto L8;
        int r103 = this.f480233a.getStroke().color;
    L9:
        r101.setStroke(new Stroke(r102, r103));
        return;
    L8:
        r103 = 0;
        goto L9
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public final void setStrokeColor(int r100) {
        Polygon r101 = this.f480233a;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.getStroke() == null) goto L8;
        float r102 = this.f480233a.getStroke().strokeWidth;
    L9:
        r101.setStroke(new Stroke(r102, r100));
        return;
    L8:
        r102 = 0.0f;
        goto L9
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public final void updatePoints(List<BDLatLng> r100) {
        if (this.f480233a == null) goto L25;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L27;
        ArrayList r101 = new ArrayList();
        Iterator<BDLatLng> r102 = r100.iterator();
    L10:
        if (r102.hasNext() == false) goto L16;
        BDLatLng r103 = r102.next();
        if (r103 == null) goto L10;
        r101.add(new LatLng(r103.getLatitude(), r103.getLongitude()));
        goto L10
    L16:
        if (r101.isEmpty() == false) goto L18;
        return;
    L18:
        this.f480233a.setPoints(r101);
        return;
    L27:
        return;
    }

    public f(Polygon r100, String r101) {
        this.f480233a = r100;
        this.f480234b = r101;
    }
}
