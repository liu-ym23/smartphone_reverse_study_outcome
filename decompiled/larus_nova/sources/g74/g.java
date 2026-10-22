package g74;

import android.graphics.Bitmap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Polyline;
import com.baidu.mapapi.model.LatLng;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IPolyline;
import com.bytedance.map.api.monitor.MapMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements IPolyline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Polyline f480235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480236b;

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setAlpha(float r100) {
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final boolean isCollideWithPoi() {
        Polyline r100 = this.f480235a;
        if (r100 != null) goto L10;
        return false;
    L10:
        return r100.getIsPoiCollided();
    L7:
        e = move-exception;
        a("isCollideWithPoi", e);
        return false;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void remove() {
        Polyline r100 = this.f480235a;
        if (r100 != null) goto L10;
        return;
    L10:
        r100.remove();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a("remove", e);
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final String getId() {
        return this.f480236b;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setCollideWithPoi(boolean r100) {
        Polyline r101 = this.f480235a;
        if (r101 != null) goto L10;
        return;
    L10:
        r101.setPoiCollided(r100);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a("setCollideWithPoi", e);
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setColor(int r100) {
        Polyline r101 = this.f480235a;
        if (r101 != null) goto L10;
        return;
    L10:
        r101.setColor(r100);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a("setColor", e);
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setColorList(List<Integer> r100) {
        if (this.f480235a == null) goto L31;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L33;
    L24:
        e = move-exception;
        a("setColorList", e);
        return;
    L9:
        if (r100.size() == 1) goto L11;
    L14:
        int[] r101 = new int[r100.size()];     // Catch: Exception -> L24
        int r102 = 0;
    L16:
        if (r102 >= r100.size()) goto L22;
        Integer r103 = (Integer) ListProtector.get(r100, r102);     // Catch: Exception -> L24
        if (r103 == null) goto L20;
        int r104 = r103.intValue();     // Catch: Exception -> L24
    L21:
        r101[r102] = r104;     // Catch: Exception -> L24
        r102 = r102 + 1;     // Catch: Exception -> L24
        goto L16
    L20:
        r104 = 0;
        goto L21
    L22:
        this.f480235a.setColorList(r101);     // Catch: Exception -> L24
        Polyline r105 = this.f480235a;     // Catch: Exception -> L24
        r105.setPoints(r105.getPoints());     // Catch: Exception -> L24
        return;
    L11:
        if (ListProtector.get(r100, 0) == null) goto L14;
        setColor(((Integer) ListProtector.get(r100, 0)).intValue());     // Catch: Exception -> L24
        return;
    L33:
        return;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setCustomTexture(Bitmap r100) {
        Polyline r101 = this.f480235a;
        if (r101 == null) goto L13;
        if (r100 == null) goto L14;
        r101.setTexture(BitmapDescriptorFactory.fromBitmap(r100));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a("setCustomTexture", e);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setCustomTextureList(List<Bitmap> r100) {
        if (this.f480235a == null) goto L44;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L46;
        List<LatLng> r101 = this.f480235a.getPoints();     // Catch: Exception -> L29
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.size() < 2) goto L43;
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L29
        Iterator<Bitmap> r103 = r100.iterator();     // Catch: Exception -> L29
    L15:
        if (r103.hasNext() == false) goto L24;
        Bitmap r104 = r103.next();     // Catch: Exception -> L29
        if (r104 == null) goto L15;
        BitmapDescriptor r105 = BitmapDescriptorFactory.fromBitmap(r104);     // Catch: Exception -> L29
        if (r105 == null) goto L15;
        r102.add(r105);     // Catch: Exception -> L29
        goto L15
    L24:
        if (r102.isEmpty() == false) goto L26;
        return;
    L26:
        this.f480235a.setTextureList(r102);     // Catch: Exception -> L29
        Polyline r106 = this.f480235a;     // Catch: Exception -> L29
        r106.setPoints(r106.getPoints());     // Catch: Exception -> L29
        return;
    L43:
        return;
    L29:
        e = move-exception;
        a("setCustomTextureList", e);
        return;
    L46:
        return;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setDottedLine(boolean r100) {
        Polyline r101 = this.f480235a;
        if (r101 != null) goto L10;
        return;
    L10:
        r101.setDottedLine(r100);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        a("setDottedLine", e);
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setPoints(List<BDLatLng> r100) {
        if (this.f480235a == null) goto L26;
        if (r100 == null) goto L27;
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L15
        Iterator<BDLatLng> r102 = r100.iterator();     // Catch: Exception -> L15
    L8:
        if (r102.hasNext() == false) goto L13;
        BDLatLng r103 = r102.next();     // Catch: Exception -> L15
        if (r103 == null) goto L8;
        r101.add(new LatLng(r103.getLatitude(), r103.getLongitude()));     // Catch: Exception -> L15
        goto L8
    L13:
        this.f480235a.setPoints(r101);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        a("setPoints", e);
        return;
    L27:
        return;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setTextureIndexList(List<Integer> r100) {
        if (this.f480235a == null) goto L33;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L35;
        List<LatLng> r101 = this.f480235a.getPoints();     // Catch: Exception -> L24
        if (r101 != null) goto L11;
        return;
    L11:
        if (r101.size() < 2) goto L32;
        int[] r102 = new int[r100.size()];     // Catch: Exception -> L24
        int r103 = 0;
    L15:
        if (r103 >= r100.size()) goto L21;
        Integer r104 = (Integer) ListProtector.get(r100, r103);     // Catch: Exception -> L24
        if (r104 == null) goto L19;
        int r105 = r104.intValue();     // Catch: Exception -> L24
    L20:
        r102[r103] = r105;     // Catch: Exception -> L24
        r103 = r103 + 1;     // Catch: Exception -> L24
        goto L15
    L19:
        r105 = 0;
        goto L20
    L21:
        this.f480235a.setIndexs(r102);     // Catch: Exception -> L24
        Polyline r106 = this.f480235a;     // Catch: Exception -> L24
        r106.setPoints(r106.getPoints());     // Catch: Exception -> L24
        return;
    L32:
        return;
    L24:
        e = move-exception;
        a("setTextureIndexList", e);
        return;
    L35:
        return;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setWidth(float r100) {
        Polyline r101 = this.f480235a;
        if (r101 != null) goto L11;
        return;
    L11:
        r101.setWidth(e74.a.a((int) r100));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a("setWidth", e);
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public final void setZIndex(float r100) {
        Polyline r101 = this.f480235a;
        if (r101 != null) goto L11;
        return;
    L11:
        r101.setZIndex((int) r100);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        a("setZIndex", e);
    }

    public g(Polyline r100, String r101) {
        this.f480235a = r100;
        this.f480236b = r101;
    }

    public static void a(String r100, Exception r101) {
        MapMonitor.mapExceptionMonitor(4, r101);
        MapLogger.e("BaiduPolyline", r100.concat(" failed"), r101);
    }
}
