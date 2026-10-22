package um9;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.map.api.BDMapClient;
import com.bytedance.map.api.MapInitConfig;
import com.bytedance.map.api.listener.CancelableCallback;
import com.bytedance.map.api.listener.MapActionListener;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.BDMapStyleType;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.IMarker;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.location.dto.LarkLocation;
import com.ss.android.lark.location.dto.POIInfo;

/* JADX INFO: loaded from: classes29.dex */
public final class b implements com.ss.android.lark.location.service.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BDMapClient f550700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f550701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IMarker f550702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IMarker f550703d;

    public static final class a {
    }

    /* JADX INFO: renamed from: um9.b$b, reason: collision with other inner class name */
    public static final class C7899b implements MapActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f550704a;

        @Override // com.bytedance.map.api.listener.MapActionListener
        public final void onMapClick(BDLatLng r100) {
        }

        @Override // com.bytedance.map.api.listener.MapActionListener
        public final void onMapLoad() {
        }

        @Override // com.bytedance.map.api.listener.MapActionListener
        public final void onMapMove(BDLatLng r100) {
        }

        @Override // com.bytedance.map.api.listener.MapActionListener
        public final void onMapMoveEnd(BDLatLng r100) {
        }

        @Override // com.bytedance.map.api.listener.MapActionListener
        public final void onMapZoom(float r100) {
        }

        @Override // com.bytedance.map.api.listener.MapActionListener
        public final void onMapZoomEnd(float r100) {
        }

        public C7899b(b r100) {
            this.f550704a = r100;
        }

        @Override // com.bytedance.map.api.listener.MapActionListener
        public final void onMapTouch(MotionEvent r100) {
            FrameLayout r101 = this.f550704a.f550701b;
            if (r101 == null) goto L13;
            ViewParent r102 = r101.getParent();
            if (r102 == null) goto L14;
            boolean r103 = false;
            if (r100 != null) goto L9;
        L11:
            r102.requestDisallowInterceptTouchEvent(!r103);
            return;
        L9:
            if (r100.getAction() != 1) goto L11;
            r103 = true;
            goto L11
        L14:
            return;
        }
    }

    public static final class c implements CancelableCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f550705a;

        @Override // com.bytedance.map.api.listener.CancelableCallback
        public final void onCancel() {
        }

        @Override // com.bytedance.map.api.listener.CancelableCallback
        public final void onFinish() {
            BDMapClient r100 = this.f550705a.f550700a;
            if (r100 == null) goto L6;
            r100.setZoom(15.0f, true, 250);
            return;
        }

        public c(b r100) {
            this.f550705a = r100;
        }
    }

    static {
    }

    public b() {
    }

    @Override // com.ss.android.lark.location.service.d
    public final void b() {
        BDMapClient r100 = this.f550700a;
        if (r100 == null) goto L6;
        r100.addMapActionListener(new C7899b(this));
        return;
    }

    @Override // com.ss.android.lark.location.service.i
    public final void onDestroy() {
        IMarker r100 = this.f550702c;
        if (r100 == null) goto L5;
        r100.remove();
    L5:
        IMarker r101 = this.f550703d;
        if (r101 == null) goto L8;
        r101.remove();
    L8:
        this.f550702c = null;
        this.f550703d = null;
        BDMapClient r102 = this.f550700a;
        if (r102 == null) goto L11;
        r102.onDestroy();
    L11:
        this.f550700a = null;
        this.f550701b = null;
    }

    @Override // com.ss.android.lark.location.service.i
    public final void onPause() {
        BDMapClient r100 = this.f550700a;
        if (r100 == null) goto L6;
        r100.onPause();
        return;
    }

    @Override // com.ss.android.lark.location.service.i
    public final void onResume() {
        BDMapClient r100 = this.f550700a;
        if (r100 == null) goto L6;
        r100.onResume();
        return;
    }

    @Override // com.ss.android.lark.location.service.i
    public final void onSaveInstanceState(Bundle r100) {
        BDMapClient r101 = this.f550700a;
        if (r101 == null) goto L6;
        r101.onSaveInstanceState(r100);
        return;
    }

    public static boolean s(double r100, double r101) {
        if ((-90.0d) <= r100) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if ((-180.0d) <= r101) goto L12;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L17;
        return false;
    L17:
        if (Double.isNaN(r100) == false) goto L19;
        return false;
    L19:
        if (Double.isNaN(r101) == false) goto L21;
        return false;
    L21:
        if (Double.isInfinite(r100) == false) goto L23;
        return false;
    L23:
        if (Double.isInfinite(r101) == true) goto L31;
        return true;
    L31:
        return false;
    L12:
        if (r101 > 180.0d) goto L14;
        r103 = true;
        goto L15
    L5:
        if (r100 > 90.0d) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.ss.android.lark.location.service.d
    public final void a(double r100, double r101) {
        if (s(r100, r101) == true) goto L5;
        return;
    L5:
        FrameLayout r102 = this.f550701b;
        if (r102 == null) goto L21;
        Context r103 = r102.getContext();
        if (r103 == null) goto L22;
        BDMapClient r104 = this.f550700a;
        if (r104 != null) goto L13;
        return;
    L13:
        Bitmap r105 = r(r103, R.drawable.location_my_location_icon, null, null);
        if (r105 != null) goto L16;
        return;
    L16:
        BDMarkerOptions r106 = new BDMarkerOptions();
        r106.setLatLng(new BDLatLng(r100, r101));
        r106.setDraggable(false);
        r106.setAnchorX(0.45f);
        r106.setAnchorY(0.45f);
        r106.setIcon(r105);
        IMarker r107 = this.f550702c;
        if (r107 == null) goto L19;
        r107.remove();
    L19:
        this.f550702c = r104.addMarker(r106);
        return;
    L22:
        return;
    }

    @Override // com.ss.android.lark.location.service.d
    public final void l(double r100, double r101) {
        BDMapClient r102 = this.f550700a;
        if (r102 == null) goto L6;
        r102.setCenter(new BDLatLng(r100, r101), true, 250, new c(this));
        return;
    }

    @Override // com.ss.android.lark.location.service.d
    public final View q(Context r100, Bundle r101, POIInfo r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        this.f550700a = new BDMapClient(new MapInitConfig.Builder(r100).setMapType(4).setMapStyle(0).setRotateGesturesEnabled(false).setTiltGesturesEnabled(false).setScaleControlsEnabled(false).setZoomControlsEnabled(false).build());
        if ((r100.getResources().getConfiguration().uiMode & 48) != 32) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L13;
        BDMapClient r104 = this.f550700a;
        if (r104 == null) goto L13;
        r104.setCustomMapStyle(BDMapStyleType.NORMAL_DARK);
    L13:
        BDMapClient r105 = this.f550700a;
        if (r105 == null) goto L16;
        r105.onCreate(r101);
    L16:
        BDMapClient r106 = this.f550700a;
        if (r106 == null) goto L19;
        r106.onResume();
    L19:
        FrameLayout r107 = new FrameLayout(r100);
        this.f550701b = r107;
        BDMapClient r108 = this.f550700a;
        if (r108 == null) goto L22;
        r108.attachToParentView(r107);
    L22:
        double r109 = r102.getLatitude();
        double r110 = r102.getLongitude();
        if (s(r109, r110) == true) goto L26;
        BDLatLng r111 = new BDLatLng(39.908823d, 116.39747d);
    L33:
        BDMapClient r112 = this.f550700a;
        if (r112 == null) goto L36;
        r112.setCenter(r111, false);
    L36:
        BDMapClient r113 = this.f550700a;
        if (r113 == null) goto L43;
        int r114 = r102.getZoomLevel();
        if (r114 > 0) goto L42;
        r114 = 15;
    L42:
        r113.setZoom(r114, false);
    L43:
        FrameLayout r115 = this.f550701b;
        if (r115 == null) goto L59;
        Context r116 = r115.getContext();
        if (r116 == null) goto L59;
        BDMapClient r117 = this.f550700a;
        if (r117 == null) goto L59;
        Bitmap r118 = r(r116, R.drawable.location_icon_event_location, 22, 35);
        if (r118 == null) goto L59;
        BDMarkerOptions r119 = new BDMarkerOptions();
        r119.setLatLng(r111);
        r119.setDraggable(false);
        r119.setAnchorX(0.4f);
        r119.setAnchorY(0.85f);
        r119.setIcon(r118);
        IMarker r120 = this.f550703d;
        if (r120 == null) goto L57;
        r120.remove();
    L57:
        this.f550703d = r117.addMarker(r119);
    L59:
        return this.f550701b;
    L26:
        if (r102.getCoordinateSystem() == LarkLocation.CoordinateSystem.WGS) goto L29;
        BDLatLng r121 = new BDLatLng(r109, r110);
    L28:
        r111 = r121;
        goto L33
    L29:
        wq9.a r122 = wq9.d.e(r109, r110);
        if (r122 != null) goto L32;
        r121 = new BDLatLng(r109, r110);
        goto L28
    L32:
        r111 = new BDLatLng(r122.f560759a, r122.f560760b);
        goto L33
    L8:
        r103 = false;
        goto L9
    }

    public static Bitmap r(Context r100, int r101, Integer r102, Integer r110) {
        Bitmap r103 = BitmapFactory.decodeResource(r100.getResources(), r101);
        if (r103 == null) goto L5;
        return r103;
    L5:
        Drawable r104 = AppCompatResources.getDrawable(r100, r101);
        Integer r105 = null;
        if (r104 != null) goto L8;
        return null;
    L8:
        boolean r106 = true;
        int r107 = 48;
        if (r102 == null) goto L11;
        float r108 = r102.intValue();
        Resources r109 = r100.getResources();
        int r111 = (int) ((r108 * WindowDisplayMetricsOverride.apply(r109, r109.getDisplayMetrics()).density) + 0.5f);
    L21:
        if (r110 == null) goto L23;
        float r112 = r110.intValue();
        Resources r113 = r100.getResources();
        r107 = (int) ((r112 * WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics()).density) + 0.5f);
    L31:
        Bitmap r114 = Bitmap.createBitmap(r111, r107, Bitmap.Config.ARGB_8888);
        Canvas r115 = new Canvas(r114);
        r104.setBounds(0, 0, r111, r107);
        r104.draw(r115);
        return r114;
    L23:
        Integer r116 = Integer.valueOf(r104.getIntrinsicHeight());
        if (r116.intValue() > 0) goto L27;
        r106 = false;
    L27:
        if (r106 == false) goto L29;
        r105 = r116;
    L29:
        if (r105 == null) goto L31;
        r107 = r105.intValue();
        goto L31
    L11:
        Integer r117 = Integer.valueOf(r104.getIntrinsicWidth());
        if (r117.intValue() <= 0) goto L14;
        boolean r118 = true;
    L15:
        if (r118 == true) goto L18;
        r117 = null;
    L18:
        if (r117 == null) goto L20;
        r111 = r117.intValue();
        goto L21
    L20:
        r111 = 48;
        goto L21
    L14:
        r118 = false;
        goto L15
    }
}
