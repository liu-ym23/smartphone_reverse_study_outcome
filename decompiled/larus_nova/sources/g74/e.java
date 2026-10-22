package g74;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.baidu.mapapi.animation.AlphaAnimation;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.AnimationSet;
import com.baidu.mapapi.animation.ScaleAnimation;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IMarker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements IMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Marker f480228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f480230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f480231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f480232e;

    public static float a(float r100) {
        if (r100 >= 0.0f) goto L6;
        return 0.0f;
    L6:
        if (r100 <= 1.0f) goto L8;
        return 1.0f;
    L8:
        return r100;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final String getSnippet() {
        return null;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final /* synthetic */ void updateMarker(Map r100) {
        IMarker.CC.$default$updateMarker(this, r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final Object getData() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getExtraInfo();
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final BDLatLng getPosition() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L5;
        return null;
    L5:
        LatLng r101 = r100.getPosition();
        if (r101 != null) goto L9;
        return null;
    L9:
        return new BDLatLng(r101.latitude, r101.longitude);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final Point getScreenPoint() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getFixedScreenPosition();
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final String getTitle() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getTitle();
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final float getZIndex() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getZIndex();
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void hideInfoWindow() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.hideInfoWindow();
        this.f480232e = false;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final boolean isCollideWithPoi() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isPoiCollided() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final boolean isDraggable() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isDraggable() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final boolean isVisible() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isVisible() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void remove() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.remove();
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setToTop() {
        Marker r100 = this.f480228a;
        if (r100 == null) goto L6;
        r100.setToTop();
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void showInfoWindow() {
        Marker r100 = this.f480228a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.showInfoWindow();
        this.f480232e = true;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void destroy() {
        remove();
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final String getId() {
        return this.f480229b;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final boolean isInfoWindowShown() {
        return this.f480232e;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final boolean isSelected() {
        return this.f480230c;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final Rect getVisibleRect(Point r100) {
        Rect r101 = new Rect();
        Marker r102 = this.f480228a;
        if (r102 == null) goto L12;
        if (r100 == null) goto L12;
        if (r102.getIcon() == null) goto L12;
        Bitmap r103 = this.f480228a.getIcon().getBitmap();
        if (r103 != null) goto L11;
        return r101;
    L11:
        int r104 = this.f480228a.getXOffset();
        int r105 = this.f480228a.getYOffset();
        float r106 = this.f480228a.getAnchorX();
        float r107 = this.f480228a.getAnchorY();
        int r108 = (r100.x - Math.round(r106 * r103.getWidth())) + r104;
        r101.left = r108;
        r101.right = r108 + r103.getWidth();
        int r109 = (r100.y - Math.round(r107 * r103.getHeight())) + r105;
        r101.top = r109;
        r101.bottom = r109 + r103.getHeight();
    L12:
        return r101;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setAlpha(float r100) {
        Marker r101 = this.f480228a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setAlpha(r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setClickable(boolean r100) {
        Marker r101 = this.f480228a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setClickable(r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setCollideWithPoi(boolean r100) {
        Marker r101 = this.f480228a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.poiCollided(r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setData(Object r100) {
        Marker r101 = this.f480228a;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof Bundle) == false) goto L9;
        r101.setExtraInfo((Bundle) r100);
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setDraggable(boolean r100) {
        Marker r101 = this.f480228a;
        if (r101 == null) goto L6;
        r101.setDraggable(r100);
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setIcons(List<Bitmap> r100) {
        if (this.f480228a == null) goto L29;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L31;
        ArrayList<BitmapDescriptor> r101 = new ArrayList();
        Iterator<Bitmap> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        Bitmap r103 = r102.next();
        if (r103 == null) goto L9;
        BitmapDescriptor r104 = BitmapDescriptorFactory.fromBitmap(r103);
        if (r104 == null) goto L9;
        r101.add(r104);
        goto L9
    L18:
        if (r101.isEmpty() == false) goto L20;
        return;
    L20:
        this.f480228a.setIcons(r101);
        return;
    L31:
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setRotateAngle(float r100) {
        Marker r101 = this.f480228a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setRotate(r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setScreenPoint(Point r100) {
        Marker r101 = this.f480228a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.setFixedScreenPosition(r100);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setSelected(boolean r100) {
        this.f480230c = r100;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setVisible(boolean r100) {
        Marker r101 = this.f480228a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisible(r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setZIndex(float r100) {
        Marker r101 = this.f480228a;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setZIndex((int) r100);
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void startAnimation(Object r100) {
        Marker r101 = this.f480228a;
        if (r101 == null) goto L10;
        if (r100 != null) goto L7;
        return;
    L7:
        if ((r100 instanceof Animation) == false) goto L11;
        r101.setAnimation((Animation) r100);
        this.f480228a.startAnimation();
        return;
    L11:
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void updateMarkerIcon(Bitmap r100) {
        Marker r101 = this.f480228a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.setIcon(BitmapDescriptorFactory.fromBitmap(r100));
        return;
    L8:
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void updatePosition(BDLatLng r100) {
        Marker r101 = this.f480228a;
        if (r101 == null) goto L8;
        if (r100 == null) goto L9;
        r101.setPosition(new LatLng(r100.getLatitude(), r100.getLongitude()));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void updateMarkerIcon(View r100) {
        Marker r101 = this.f480228a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L8;
        r101.setIcon(BitmapDescriptorFactory.fromView(r100));
        return;
    L8:
        return;
    }

    public e(Marker r100, String r101) {
        this.f480230c = false;
        this.f480231d = true;
        this.f480232e = false;
        this.f480228a = r100;
        this.f480229b = r101;
        if (r100 == null) goto L6;
        this.f480231d = r100.isVisible();
        return;
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setAnchor(float r100, float r101) {
        if (this.f480228a != null) goto L5;
        return;
    L5:
        float r102 = a(r100);
        float r103 = a(r101);
        this.f480228a.setAnchor(r102, r103);
        BitmapDescriptor r104 = this.f480228a.getIcon();
        if (r104 != null) goto L8;
        return;
    L8:
        Bitmap r105 = r104.getBitmap();
        if (r105 != null) goto L11;
        return;
    L11:
        this.f480228a.setXOffset(-Math.round((r100 - r102) * r105.getWidth()));
        this.f480228a.setYOffset(-Math.round((r101 - r103) * r105.getHeight()));
    }

    @Override // com.bytedance.map.api.model.IMarker
    public final void setVisible(boolean r100, boolean r101) {
        if (r100 == this.f480231d) goto L15;
        Marker r102 = this.f480228a;
        if (r102 == null) goto L18;
        this.f480231d = r100;
        if (r101 == true) goto L11;
        r102.setVisible(r100);
        return;
    L11:
        if (r100 == false) goto L13;
        setVisible(true);
        AnimationSet r103 = new AnimationSet();
        r103.setDuration(300);
        AlphaAnimation r104 = new AlphaAnimation(new float[]{0.5f, 1.0f});
        ScaleAnimation r105 = new ScaleAnimation(new float[]{0.0f, 1.0f, 0.0f, 1.0f});
        r103.addAnimation(r104);
        r103.addAnimation(r105);
        this.f480228a.setAnimation(r103);
        this.f480228a.startAnimation();
        return;
    L13:
        AnimationSet r106 = new AnimationSet();
        r106.setDuration(300);
        AlphaAnimation r107 = new AlphaAnimation(new float[]{1.0f, 0.5f});
        ScaleAnimation r108 = new ScaleAnimation(new float[]{1.0f, 0.0f, 1.0f, 0.0f});
        r106.addAnimation(r107);
        r106.addAnimation(r108);
        r106.setAnimationListener(new d(this));
        this.f480228a.setAnimation(r106);
        this.f480228a.startAnimation();
        return;
    L18:
        return;
    }
}
