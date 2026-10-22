package com.bytedance.map.api.edit;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.map.api.BDMapClient;
import com.bytedance.map.api.listener.PolygonEditListener;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.IMarker;
import com.bytedance.map.api.model.IPolygon;
import com.bytedance.map.api.utils.CommonUtil;
import com.bytedance.map.api.utils.DensityUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class EditHandler {
    private static int MIN_DISTANCE_TO_NEAREST_POINT;
    private Context mContext;
    private Map<Integer, Integer> mDistanceMap;
    private int mDownX;
    private int mDownY;
    private boolean mHasMovedPoint;
    private boolean mHasTouchedPoint;
    private boolean mIsMainPoint;
    private boolean mIsRotateGesturesEnabled;
    private boolean mIsScrollGesturesEnabled;
    private boolean mIsTiltGesturesEnabled;
    private boolean mIsZoomGesturesEnabled;
    private List<BDLatLng> mLatLngPoints;
    private BDMapClient mMapClient;
    private int mMovePosition;
    private int mMoveX;
    private int mMoveY;
    private List<IMarker> mPointMarkers;
    private IPolygon mPolygon;
    private PolygonEditListener mPolygonEditListener;

    private View getMainPointView() {
        return LayoutInflater.from(this.mContext).inflate(R.layout.map_big_point_marker_layout, null);
    }

    private View getNotMainPointView() {
        return LayoutInflater.from(this.mContext).inflate(R.layout.map_small_point_marker_layout, null);
    }

    private void handleUpEvent() {
        if (this.mHasTouchedPoint == true) goto L5;
    L9:
        this.mHasTouchedPoint = false;
        this.mHasMovedPoint = false;
        this.mIsMainPoint = false;
        this.mMovePosition = -1;
        this.mMapClient.setRotateGesturesEnabled(this.mIsRotateGesturesEnabled);
        this.mMapClient.setScrollGesturesEnabled(this.mIsScrollGesturesEnabled);
        this.mMapClient.setZoomGesturesEnabled(this.mIsZoomGesturesEnabled);
        this.mMapClient.setTiltGesturesEnabled(this.mIsTiltGesturesEnabled);
        return;
    L5:
        if (this.mHasMovedPoint == false) goto L9;
        PolygonEditListener r100 = this.mPolygonEditListener;
        if (r100 == null) goto L9;
        r100.onEditEnd(this.mPolygon);
        goto L9
    }

    private void updatePolygon() {
        if (this.mPolygon != null) goto L5;
        return;
    L5:
        ArrayList r100 = new ArrayList();
        int r101 = 0;
    L7:
        if (r101 >= this.mLatLngPoints.size()) goto L9;
        r100.add(ListProtector.get(this.mLatLngPoints, r101));
        r101 = r101 + 2;
        goto L7
    L9:
        this.mPolygon.updatePoints(r100);
    }

    private void handleClickEvent(int r100) {
        if (this.mLatLngPoints.size() > 6) goto L6;
        return;
    L6:
        if (r100 != 0) goto L8;
        List<BDLatLng> r101 = this.mLatLngPoints;
        BDLatLng r102 = getCenterLatLng((BDLatLng) ListProtector.get(r101, r101.size() - 2), (BDLatLng) ListProtector.get(this.mLatLngPoints, 2));
        List<IMarker> r103 = this.mPointMarkers;
        ((IMarker) ListProtector.get(r103, r103.size() - 1)).destroy();
        ((IMarker) ListProtector.get(this.mPointMarkers, 1)).destroy();
        ((IMarker) ListProtector.get(this.mPointMarkers, 0)).destroy();
        List<IMarker> r104 = this.mPointMarkers;
        ListProtector.remove(r104, r104.size() - 1);
        ListProtector.remove(this.mPointMarkers, 1);
        ListProtector.remove(this.mPointMarkers, 0);
        List<BDLatLng> r105 = this.mLatLngPoints;
        ListProtector.remove(r105, r105.size() - 1);
        ListProtector.remove(this.mLatLngPoints, 1);
        ListProtector.remove(this.mLatLngPoints, 0);
        this.mPointMarkers.add(drawPointMarker(r102, getNotMainPointView()));
        this.mLatLngPoints.add(new BDLatLng(r102, false));
    L9:
        updatePolygon();
        return;
    L8:
        BDLatLng r106 = (BDLatLng) ListProtector.get(this.mLatLngPoints, r100 - 2);
        List<BDLatLng> r107 = this.mLatLngPoints;
        BDLatLng r108 = getCenterLatLng(r106, (BDLatLng) ListProtector.get(r107, (r100 + 2) % r107.size()));
        int r109 = r100 + 1;
        ((IMarker) ListProtector.get(this.mPointMarkers, r109)).destroy();
        ((IMarker) ListProtector.get(this.mPointMarkers, r100)).destroy();
        int r110 = r100 - 1;
        ((IMarker) ListProtector.get(this.mPointMarkers, r110)).destroy();
        ListProtector.remove(this.mPointMarkers, r109);
        ListProtector.remove(this.mPointMarkers, r100);
        ListProtector.remove(this.mPointMarkers, r110);
        ListProtector.remove(this.mLatLngPoints, r109);
        ListProtector.remove(this.mLatLngPoints, r100);
        ListProtector.remove(this.mLatLngPoints, r110);
        ListProtector.add(this.mPointMarkers, r110, drawPointMarker(r108, getNotMainPointView()));
        ListProtector.add(this.mLatLngPoints, r110, new BDLatLng(r108, false));
        goto L9
    }

    private void handleMainPointEdit(BDLatLng r100) {
        int r101 = this.mLatLngPoints.size();
        int r102 = this.mMovePosition;
        int r103 = ((r102 - 2) + r101) % r101;
        int r104 = ((r102 - 1) + r101) % r101;
        BDLatLng r105 = getCenterLatLng((BDLatLng) ListProtector.get(this.mLatLngPoints, r103), r100);
        ((IMarker) ListProtector.get(this.mPointMarkers, r104)).updatePosition(r105);
        ListProtector.remove(this.mLatLngPoints, r104);
        ListProtector.add(this.mLatLngPoints, r104, new BDLatLng(r105, false));
        int r106 = this.mMovePosition;
        ((IMarker) ListProtector.get(this.mPointMarkers, r106)).updatePosition(r100);
        ListProtector.remove(this.mLatLngPoints, r106);
        ListProtector.add(this.mLatLngPoints, r106, new BDLatLng(r100, true));
        int r107 = this.mMovePosition;
        int r108 = ((r107 + 2) + r101) % r101;
        int r109 = ((r107 + 1) + r101) % r101;
        BDLatLng r110 = getCenterLatLng((BDLatLng) ListProtector.get(this.mLatLngPoints, r108), r100);
        ((IMarker) ListProtector.get(this.mPointMarkers, r109)).updatePosition(r110);
        ListProtector.remove(this.mLatLngPoints, r109);
        ListProtector.add(this.mLatLngPoints, r109, new BDLatLng(r110, false));
        updatePolygon();
    }

    private void handleNotMainPointEdit(BDLatLng r100) {
        BDLatLng r101 = getCenterLatLng((BDLatLng) ListProtector.get(this.mLatLngPoints, this.mMovePosition - 1), r100);
        ListProtector.add(this.mPointMarkers, this.mMovePosition, drawPointMarker(r101, getNotMainPointView()));
        ListProtector.add(this.mLatLngPoints, this.mMovePosition, new BDLatLng(r101, false));
        ((IMarker) ListProtector.get(this.mPointMarkers, this.mMovePosition + 1)).destroy();
        ListProtector.remove(this.mPointMarkers, this.mMovePosition + 1);
        ListProtector.remove(this.mLatLngPoints, this.mMovePosition + 1);
        ListProtector.add(this.mPointMarkers, this.mMovePosition + 1, drawPointMarker(r100, getMainPointView()));
        ListProtector.add(this.mLatLngPoints, this.mMovePosition + 1, new BDLatLng(r100, true));
        BDLatLng r102 = getCenterLatLng((BDLatLng) ListProtector.get(this.mLatLngPoints, (this.mMovePosition + 2) % this.mLatLngPoints.size()), r100);
        ListProtector.add(this.mPointMarkers, this.mMovePosition + 2, drawPointMarker(r102, getNotMainPointView()));
        ListProtector.add(this.mLatLngPoints, this.mMovePosition + 2, new BDLatLng(r102, false));
        this.mIsMainPoint = true;
        this.mMovePosition++;
        handleMainPointEdit(r100);
    }

    public void initEditState(IPolygon r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.equals(this.mPolygon) == true) goto L13;
        resetEditState(this.mPolygon);
        this.mPolygon = r100;
        List<BDLatLng> r101 = r100.getPoints();
        int r102 = r101.size();
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        BDLatLng r104 = (BDLatLng) ListProtector.get(r101, r103);
        r103 = r103 + 1;
        BDLatLng r105 = getCenterLatLng(r104, (BDLatLng) ListProtector.get(r101, r103 % r102));
        this.mPointMarkers.add(drawPointMarker(r104, getMainPointView()));
        this.mPointMarkers.add(drawPointMarker(r105, getNotMainPointView()));
        this.mLatLngPoints.add(new BDLatLng(r104, true));
        this.mLatLngPoints.add(new BDLatLng(r105, false));
        goto L7
    L9:
        this.mIsRotateGesturesEnabled = this.mMapClient.isRotateGesturesEnabled();
        this.mIsZoomGesturesEnabled = this.mMapClient.isZoomGesturesEnabled();
        this.mIsScrollGesturesEnabled = this.mMapClient.isScrollGesturesEnabled();
        this.mIsTiltGesturesEnabled = this.mMapClient.isTiltGesturesEnabled();
        return;
    }

    public synchronized void onPointClick(IMarker r100) {
        monitor-enter(this);
        MapLogger.i("EditHandler ", "onPointClick");     // Catch: Throwable -> L25
        if (r100 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r101 = 0;
    L9:
        if (r101 >= this.mPointMarkers.size()) goto L14;
        if (r100.equals(ListProtector.get(this.mPointMarkers, r101)) == true) goto L15;
        r101 = r101 + 1;
    L15:
        if (r101 != (-1)) goto L19;
        monitor-exit(this);
        return;
    L19:
        if (((BDLatLng) ListProtector.get(this.mLatLngPoints, r101)).isMainPoint() == true) goto L22;
        monitor-exit(this);
        return;
    L22:
        handleClickEvent(r101);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L14:
        r101 = -1;
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized void onTouchEvent(MotionEvent r100) {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.mPolygon != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        MapLogger.i("EditHandler ", "action is " + r100.getAction() + " and hasmoved is " + this.mHasTouchedPoint);     // Catch: Throwable -> L29
        int r101 = r100.getAction();     // Catch: Throwable -> L29
        if (r101 != 0) goto L11;
        this.mDownX = (int) r100.getX();     // Catch: Throwable -> L29
        int r102 = (int) r100.getY();     // Catch: Throwable -> L29
        this.mDownY = r102;     // Catch: Throwable -> L29
        handleDownEvent(this.mDownX, r102);     // Catch: Throwable -> L29
    L27:
        monitor-exit(this);
        return;
    L11:
        if (r101 != 1) goto L13;
        handleUpEvent();     // Catch: Throwable -> L29
        goto L27
    L13:
        if (r101 != 2) goto L27;
        this.mMoveX = (int) r100.getX();     // Catch: Throwable -> L29
        int r103 = (int) r100.getY();     // Catch: Throwable -> L29
        this.mMoveY = r103;     // Catch: Throwable -> L29
        handleMoveEvent(this.mDownX, this.mDownY, this.mMoveX, r103);     // Catch: Throwable -> L29
        if (this.mHasTouchedPoint == false) goto L27;
        if (this.mHasMovedPoint == false) goto L27;
        MapLogger.i("EditHandler ", "has moved and position is " + this.mMovePosition);     // Catch: Throwable -> L29
        if (this.mMovePosition != (-1)) goto L24;
        monitor-exit(this);
        return;
    L24:
        handleEditEvent(this.mMoveX, this.mMoveY);     // Catch: Throwable -> L29
        goto L27
    }

    public void resetEditState(IPolygon r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.equals(this.mPolygon) == false) goto L20;
        this.mPolygon = null;
        Iterator<IMarker> r101 = this.mPointMarkers.iterator();
    L8:
        if (r101.hasNext() == false) goto L12;
        IMarker r102 = r101.next();
        if (r102 == null) goto L8;
        r102.destroy();
        goto L8
    L12:
        this.mPointMarkers.clear();
        this.mLatLngPoints.clear();
        this.mIsRotateGesturesEnabled = false;
        this.mIsZoomGesturesEnabled = true;
        this.mIsScrollGesturesEnabled = true;
        this.mIsTiltGesturesEnabled = false;
        return;
    }

    public void setPolygonEditListener(PolygonEditListener r100) {
        this.mPolygonEditListener = r100;
    }

    public EditHandler(Context r100, BDMapClient r101) {
        this.mIsRotateGesturesEnabled = false;
        this.mIsZoomGesturesEnabled = true;
        this.mIsScrollGesturesEnabled = true;
        this.mIsTiltGesturesEnabled = false;
        this.mDownX = 0;
        this.mDownY = 0;
        this.mMoveX = 0;
        this.mMoveY = 0;
        this.mMovePosition = -1;
        this.mLatLngPoints = new ArrayList();
        this.mDistanceMap = new HashMap();
        this.mPointMarkers = new ArrayList();
        this.mContext = r100;
        this.mMapClient = r101;
        MIN_DISTANCE_TO_NEAREST_POINT = DensityUtil.dp2px(r100, 30.0f);
    }

    private IMarker drawPointMarker(BDLatLng r100, View r101) {
        BDMarkerOptions r102 = new BDMarkerOptions();
        r102.setLatLng(r100);
        r102.setView(r101);
        return this.mMapClient.addMarker(r102);
    }

    private BDLatLng getCenterLatLng(BDLatLng r100, BDLatLng r101) {
        Point r102 = this.mMapClient.transLatLngToPoint(r100);
        Point r103 = this.mMapClient.transLatLngToPoint(r101);
        if (r102 != null) goto L5;
        r102 = new Point(0, 0);
    L5:
        if (r103 != null) goto L7;
        r103 = new Point(0, 0);
    L7:
        Point r104 = new Point(CommonUtil.avg(r102.x, r103.x), CommonUtil.avg(r102.y, r103.y));
        return this.mMapClient.transPointToLatLng(r104);
    }

    private void handleDownEvent(int r100, int r101) {
        this.mDistanceMap.clear();
        int r102 = 0;
    L4:
        if (r102 >= this.mLatLngPoints.size()) goto L10;
        Point r103 = this.mMapClient.transLatLngToPoint((BDLatLng) ListProtector.get(this.mLatLngPoints, r102));
        if (r103 == null) goto L9;
        this.mDistanceMap.put(Integer.valueOf(r102), Integer.valueOf(CommonUtil.distance(r100, r101, r103.x, r103.y)));
    L9:
        r102 = r102 + 1;
        goto L4
    L10:
        int[] r104 = CommonUtil.getPairOfMinValue(this.mDistanceMap);
        MapLogger.i("EditHandler", String.valueOf(r104[1]));
        if (r104[1] >= MIN_DISTANCE_TO_NEAREST_POINT) goto L17;
        this.mHasTouchedPoint = true;
        this.mMapClient.setAllGesturesEnabled(false);
        int r105 = r104[0];
        this.mMovePosition = r105;
        this.mIsMainPoint = ((BDLatLng) ListProtector.get(this.mLatLngPoints, r105)).isMainPoint();
        return;
    }

    private void handleEditEvent(int r100, int r101) {
        MapLogger.i("EditHandler ", "handleMoveEvent");
        BDLatLng r102 = this.mMapClient.transPointToLatLng(new Point(r100, r101));
        if (this.mIsMainPoint == false) goto L5;
        handleMainPointEdit(r102);
    L6:
        PolygonEditListener r103 = this.mPolygonEditListener;
        if (r103 == null) goto L10;
        r103.onEdit(this.mPolygon);
        return;
    L10:
        return;
    L5:
        handleNotMainPointEdit(r102);
        goto L6
    }

    private void handleMoveEvent(int r100, int r101, int r102, int r103) {
        if (this.mHasMovedPoint == false) goto L6;
        return;
    L6:
        if (CommonUtil.distance(r100, r101, r102, r103) <= DensityUtil.dp2px(this.mContext, 5.0f)) goto L13;
        this.mHasMovedPoint = true;
        if (this.mHasTouchedPoint == false) goto L14;
        PolygonEditListener r104 = this.mPolygonEditListener;
        if (r104 == null) goto L15;
        r104.onEditStart(this.mPolygon);
        return;
    L15:
        return;
    L14:
        return;
    }
}
