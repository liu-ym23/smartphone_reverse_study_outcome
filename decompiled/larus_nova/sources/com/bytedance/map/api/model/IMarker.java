package com.bytedance.map.api.model;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface IMarker {

    /* JADX INFO: renamed from: com.bytedance.map.api.model.IMarker$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isCollideWithPoi(IMarker r100) {
            return false;
        }

        public static void $default$setCollideWithPoi(IMarker r100, boolean r101) {
        }

        public static void $default$updateMarker(IMarker r100, Map r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            Object r102 = r101.get("rotateAngle");
            if ((r102 instanceof Number) == false) goto L7;
            r100.setRotateAngle(((Number) r102).floatValue());
        L7:
            Object r103 = r101.get("alpha");
            if ((r103 instanceof Number) == false) goto L10;
            r100.setAlpha(((Number) r103).floatValue());
        L10:
            Object r104 = r101.get("zIndex");
            if ((r104 instanceof Number) == false) goto L13;
            r100.setZIndex(((Number) r104).floatValue());
        L13:
            Object r105 = r101.get("position");
            if ((r105 instanceof List) == false) goto L22;
            List r106 = (List) r105;
            if (r106.size() != 2) goto L22;
            Object r107 = ListProtector.get(r106, 0);
            Object r108 = ListProtector.get(r106, 1);
            if ((r107 instanceof Number) == false) goto L22;
            if ((r108 instanceof Number) == false) goto L22;
            double r109 = ((Number) r107).doubleValue();
            r100.updatePosition(new BDLatLng(((Number) r108).doubleValue(), r109));
        L22:
            Object r110 = r101.get("containerPosition");
            if ((r110 instanceof List) == false) goto L34;
            List r111 = (List) r110;
            if (r111.size() != 2) goto L34;
            Object r112 = ListProtector.get(r111, 0);
            Object r113 = ListProtector.get(r111, 1);
            if ((r112 instanceof Number) == false) goto L34;
            if ((r113 instanceof Number) == false) goto L34;
            int r114 = ((Number) r112).intValue();
            int r115 = ((Number) r113).intValue();
            if (r114 == (-1)) goto L34;
            if (r115 == (-1)) goto L34;
            r100.setScreenPoint(new Point(r114, r115));
        L34:
            Object r116 = r101.get("anchor");
            if ((r116 instanceof List) == false) goto L43;
            List r117 = (List) r116;
            if (r117.size() < 2) goto L43;
            Object r118 = ListProtector.get(r117, 0);
            Object r119 = ListProtector.get(r117, 1);
            if ((r118 instanceof Number) == false) goto L43;
            if ((r119 instanceof Number) == false) goto L43;
            r100.setAnchor(((Number) r118).floatValue(), ((Number) r119).floatValue());
        L43:
            Object r120 = r101.get("clickable");
            if ((r120 instanceof Boolean) == false) goto L46;
            r100.setClickable(((Boolean) r120).booleanValue());
        L46:
            Object r121 = r101.get("draggable");
            if ((r121 instanceof Boolean) == false) goto L49;
            r100.setDraggable(((Boolean) r121).booleanValue());
        L49:
            Object r122 = r101.get("isCollideWithPoi");
            if ((r122 instanceof Boolean) == false) goto L53;
            r100.setCollideWithPoi(((Boolean) r122).booleanValue());
            return;
        }
    }

    void destroy();

    Object getData();

    String getId();

    BDLatLng getPosition();

    Point getScreenPoint();

    String getSnippet();

    String getTitle();

    Rect getVisibleRect(Point r100);

    float getZIndex();

    void hideInfoWindow();

    boolean isCollideWithPoi();

    boolean isDraggable();

    boolean isInfoWindowShown();

    boolean isSelected();

    boolean isVisible();

    void remove();

    void setAlpha(float r100);

    void setAnchor(float r100, float r101);

    void setClickable(boolean r100);

    void setCollideWithPoi(boolean r100);

    void setData(Object r100);

    void setDraggable(boolean r100);

    void setIcons(List<Bitmap> r100);

    void setRotateAngle(float r100);

    void setScreenPoint(Point r100);

    void setSelected(boolean r100);

    void setToTop();

    void setVisible(boolean r100);

    void setVisible(boolean r100, boolean r101);

    void setZIndex(float r100);

    void showInfoWindow();

    void startAnimation(Object r100);

    void updateMarker(Map<String, Object> r100);

    void updateMarkerIcon(Bitmap r100);

    void updateMarkerIcon(View r100);

    void updatePosition(BDLatLng r100);
}
