package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import rqc.h;
import rqc.i;
import rqc.j;
import rqc.k;
import rqc.l;

/* JADX INFO: loaded from: classes41.dex */
public class UCropFragment extends Fragment {
    public static final Bitmap.CompressFormat C = null;
    public final a A;
    public final b B;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.yalantis.ucrop.b f464395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f464396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f464397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f464398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f464399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AutoTransition f464400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UCropView f464401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f464402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public GestureCropImageView f464403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OverlayView f464404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f464405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f464406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f464407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ViewGroup f464408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewGroup f464409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ViewGroup f464410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<ViewGroup> f464411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f464412u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f464413v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f464414w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Bitmap.CompressFormat f464415x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f464416y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int[] f464417z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureTypes {
    }

    public class a implements TransformImageView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UCropFragment f464418a;

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public final void a() {
            this.f464418a.f464401j.animate().alpha(1.0f).setDuration(300).setInterpolator(new AccelerateInterpolator());
            this.f464418a.f464414w.setClickable(false);
            this.f464418a.f464395d.vg(false);
        }

        public a(UCropFragment r100) {
            this.f464418a = r100;
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public final void b(Exception r100) {
            this.f464418a.f464395d.H20(UCropFragment.S90(r100));
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public final void c(float r100) {
            TextView r101 = this.f464418a.f464413v;
            if (r101 == null) goto L6;
            r101.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (r100 * 100.0f))}));
            return;
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.b
        public final void d(float r100) {
            TextView r101 = this.f464418a.f464412u;
            if (r101 == null) goto L6;
            r101.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(r100)}));
            return;
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UCropFragment f464419a;

        public b(UCropFragment r100) {
            this.f464419a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (r100.isSelected() == true) goto L6;
            UCropFragment r101 = this.f464419a;
            int r102 = r100.getId();
            Bitmap.CompressFormat r103 = UCropFragment.C;
            r101.U90(r102);
            return;
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Intent f464420a;

        public c(Intent r100) {
            this.f464420a = r100;
        }
    }

    static {
        C = Bitmap.CompressFormat.JPEG;
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public UCropFragment() {
        this.f464411t = new ArrayList();
        this.f464415x = C;
        this.f464416y = 90;
        this.f464417z = new int[]{1, 2, 3};
        this.A = new a(this);
        this.B = new b(this);
    }

    public static c S90(Throwable r100) {
        return new c(new Intent().putExtra("com.yalantis.ucrop.Error", r100));
    }

    public final void T90(int r100) {
        GestureCropImageView r101 = this.f464403l;
        int r102 = this.f464417z[r100];
        boolean r103 = false;
        if (r102 == 3) goto L7;
        if (r102 == 1) goto L7;
        boolean r104 = false;
    L8:
        r101.setScaleEnabled(r104);
        GestureCropImageView r105 = this.f464403l;
        int r106 = this.f464417z[r100];
        if (r106 != 3) goto L11;
    L12:
        r103 = true;
    L13:
        r105.setRotateEnabled(r103);
        return;
    L11:
        if (r106 != 2) goto L13;
    L7:
        r104 = true;
        goto L8
    }

    public final void U90(int r100) {
        if (this.f464399h == true) goto L5;
        return;
    L5:
        ViewGroup r101 = this.f464405n;
        if (r100 != R.id.state_aspect_ratio) goto L8;
        boolean r102 = true;
    L9:
        r101.setSelected(r102);
        ViewGroup r103 = this.f464406o;
        if (r100 != R.id.state_rotate) goto L12;
        boolean r104 = true;
    L13:
        r103.setSelected(r104);
        ViewGroup r105 = this.f464407p;
        if (r100 != R.id.state_scale) goto L16;
        boolean r106 = true;
    L17:
        r105.setSelected(r106);
        ViewGroup r107 = this.f464408q;
        int r108 = 8;
        if (r100 != R.id.state_aspect_ratio) goto L20;
        int r109 = 0;
    L21:
        r107.setVisibility(r109);
        ViewGroup r110 = this.f464409r;
        if (r100 != R.id.state_rotate) goto L24;
        int r111 = 0;
    L25:
        r110.setVisibility(r111);
        ViewGroup r112 = this.f464410s;
        if (r100 != R.id.state_scale) goto L28;
        int r113 = 0;
    L29:
        r112.setVisibility(r113);
        if (getView() == null) goto L32;
        TransitionManager.beginDelayedTransition((ViewGroup) getView().findViewById(R.id.ucrop_photobox), this.f464400i);
    L32:
        View r114 = this.f464407p.findViewById(R.id.text_view_scale);
        if (r100 != R.id.state_scale) goto L35;
        int r115 = 0;
    L36:
        r114.setVisibility(r115);
        View r116 = this.f464405n.findViewById(R.id.text_view_crop);
        if (r100 != R.id.state_aspect_ratio) goto L39;
        int r117 = 0;
    L40:
        r116.setVisibility(r117);
        View r118 = this.f464406o.findViewById(R.id.text_view_rotate);
        if (r100 != R.id.state_rotate) goto L43;
        r108 = 0;
    L43:
        r118.setVisibility(r108);
        if (r100 != R.id.state_scale) goto L46;
        T90(0);
        return;
    L46:
        if (r100 != R.id.state_rotate) goto L48;
        T90(1);
        return;
    L48:
        T90(2);
        return;
    L39:
        r117 = 8;
        goto L40
    L35:
        r115 = 8;
        goto L36
    L28:
        r113 = 8;
        goto L29
    L24:
        r111 = 8;
        goto L25
    L20:
        r109 = 8;
        goto L21
    L16:
        r106 = false;
        goto L17
    L12:
        r104 = false;
        goto L13
    L8:
        r102 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        if ((getParentFragment() instanceof com.yalantis.ucrop.b) == false) goto L6;
        this.f464395d = (com.yalantis.ucrop.b) getParentFragment();
        return;
    L6:
        if ((r100 instanceof com.yalantis.ucrop.b) == false) goto L10;
        this.f464395d = (com.yalantis.ucrop.b) r100;
        return;
    L10:
        throw new IllegalArgumentException(r100.toString() + " must implement UCropFragmentCallback");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r210) {
        View r100 = r110.inflate(R.layout.ucrop_fragment_photobox, r111, false);
        Bundle r101 = getArguments();
        this.f464396e = r101.getInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_active));
        this.f464398g = r101.getInt("com.yalantis.ucrop.UcropLogoColor", ContextCompat.getColor(getContext(), R.color.ucrop_color_default_logo));
        this.f464399h = !r101.getBoolean("com.yalantis.ucrop.HideBottomControls", false);
        this.f464397f = r101.getInt("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_neutral_100, getContext(), R.color.larus_neutral_100)));
        this.f464401j = (UCropView) r100.findViewById(R.id.ucrop);
        this.f464402k = (ImageView) r100.findViewById(R.id.image_view_logo);
        this.f464403l = this.f464401j.getCropImageView();
        this.f464404m = this.f464401j.getOverlayView();
        this.f464403l.setTransformImageListener(this.A);
        ((ImageView) r100.findViewById(R.id.image_view_logo)).setColorFilter(this.f464398g, PorterDuff.Mode.SRC_ATOP);
        r100.findViewById(R.id.ucrop_frame).setBackgroundColor(this.f464397f);
        this.f464395d.vg(true);
        float r102 = 0.0f;
        ViewGroup r112 = null;
        if (this.f464399h == false) goto L24;
        ViewGroup r103 = (ViewGroup) r100.findViewById(R.id.controls_wrapper);
        r103.setVisibility(0);
        LayoutInflater.from(getContext()).inflate(R.layout.ucrop_controls, r103, true);
        AutoTransition r104 = new AutoTransition();
        this.f464400i = r104;
        r104.setDuration(50);
        ViewGroup r105 = (ViewGroup) r100.findViewById(R.id.state_aspect_ratio);
        this.f464405n = r105;
        r105.setOnClickListener(this.B);
        ViewGroup r106 = (ViewGroup) r100.findViewById(R.id.state_rotate);
        this.f464406o = r106;
        r106.setOnClickListener(this.B);
        ViewGroup r107 = (ViewGroup) r100.findViewById(R.id.state_scale);
        this.f464407p = r107;
        r107.setOnClickListener(this.B);
        this.f464408q = (ViewGroup) r100.findViewById(R.id.layout_aspect_ratio);
        this.f464409r = (ViewGroup) r100.findViewById(R.id.layout_rotate_wheel);
        this.f464410s = (ViewGroup) r100.findViewById(R.id.layout_scale_wheel);
        int r108 = r101.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList r109 = r101.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        if (r109 != null) goto L7;
    L8:
        r109 = new ArrayList();
        r109.add(new AspectRatio(null, 1.0f, 1.0f));
        r109.add(new AspectRatio(null, 3.0f, 4.0f));
        r109.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
        r109.add(new AspectRatio(null, 3.0f, 2.0f));
        r109.add(new AspectRatio(null, 16.0f, 9.0f));
        r108 = 2;
    L9:
        LinearLayout r113 = (LinearLayout) r100.findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(0, -1);
        r114.weight = 1.0f;
        Iterator r115 = r109.iterator();
    L11:
        if (r115.hasNext() == false) goto L13;
        AspectRatio r116 = (AspectRatio) r115.next();
        FrameLayout r117 = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, r112);
        r117.setLayoutParams(r114);
        AspectRatioTextView r118 = (AspectRatioTextView) r117.getChildAt(0);
        r118.setActiveColor(this.f464396e);
        r118.setAspectRatio(r116);
        r113.addView(r117);
        ((ArrayList) this.f464411t).add(r117);
        r112 = null;
        goto L11
    L13:
        ((ViewGroup) ListProtector.get(this.f464411t, r108)).setSelected(true);
        Iterator r119 = ((ArrayList) this.f464411t).iterator();
    L15:
        if (r119.hasNext() == false) goto L17;
        ((ViewGroup) r119.next()).setOnClickListener(new h(this));
        goto L15
    L17:
        this.f464412u = (TextView) r100.findViewById(R.id.text_view_rotate);
        ((HorizontalProgressWheelView) r100.findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new i(this));
        ((HorizontalProgressWheelView) r100.findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.f464396e);
        r100.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new j(this));
        r100.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new k(this));
        int r120 = this.f464396e;
        TextView r121 = this.f464412u;
        if (r121 == null) goto L20;
        r121.setTextColor(r120);
    L20:
        this.f464413v = (TextView) r100.findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView) r100.findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new l(this));
        ((HorizontalProgressWheelView) r100.findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.f464396e);
        int r122 = this.f464396e;
        TextView r123 = this.f464413v;
        if (r123 == null) goto L23;
        r123.setTextColor(r122);
    L23:
        ImageView r124 = (ImageView) r100.findViewById(R.id.image_view_state_scale);
        ImageView r125 = (ImageView) r100.findViewById(R.id.image_view_state_rotate);
        ImageView r126 = (ImageView) r100.findViewById(R.id.image_view_state_aspect_ratio);
        r124.setImageDrawable(new vqc.h(r124.getDrawable(), this.f464396e));
        r125.setImageDrawable(new vqc.h(r125.getDrawable(), this.f464396e));
        r126.setImageDrawable(new vqc.h(r126.getDrawable(), this.f464396e));
    L25:
        Uri r127 = (Uri) r101.getParcelable("com.yalantis.ucrop.InputUri");
        Uri r128 = (Uri) r101.getParcelable("com.yalantis.ucrop.OutputUri");
        String r129 = r101.getString("com.yalantis.ucrop.CompressionFormatName");
        if (TextUtils.isEmpty(r129) == true) goto L28;
        Bitmap.CompressFormat r130 = Bitmap.CompressFormat.valueOf(r129);
    L29:
        if (r130 != null) goto L31;
        r130 = C;
    L31:
        this.f464415x = r130;
        this.f464416y = r101.getInt("com.yalantis.ucrop.CompressionQuality", 90);
        int[] r131 = r101.getIntArray("com.yalantis.ucrop.AllowedGestures");
        if (r131 != null) goto L34;
    L36:
        this.f464403l.setMaxBitmapSize(r101.getInt("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.f464403l.setMaxScaleMultiplier(r101.getFloat("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.f464403l.setImageToWrapCropBoundsAnimDuration(r101.getInt("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.f464404m.setFreestyleCropEnabled(r101.getBoolean("com.yalantis.ucrop.FreeStyleCrop", false));
        this.f464404m.setDimmedColor(r101.getInt("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.f464404m.setCircleDimmedLayer(r101.getBoolean("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.f464404m.setShowCropFrame(r101.getBoolean("com.yalantis.ucrop.ShowCropFrame", true));
        this.f464404m.setCropFrameColor(r101.getInt("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.f464404m.setCropFrameStrokeWidth(r101.getInt("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f464404m.setShowCropGrid(r101.getBoolean("com.yalantis.ucrop.ShowCropGrid", true));
        this.f464404m.setCropGridRowCount(r101.getInt("com.yalantis.ucrop.CropGridRowCount", 2));
        this.f464404m.setCropGridColumnCount(r101.getInt("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.f464404m.setCropGridColor(r101.getInt("com.yalantis.ucrop.CropGridColor", getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.f464404m.setCropGridStrokeWidth(r101.getInt("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        if (r101.getBoolean("com.yalantis.ucrop.DisablePadding", false) == false) goto L40;
        this.f464403l.setPadding(0, 0, 0, 0);
        this.f464404m.setPadding(0, 0, 0, 0);
    L40:
        if (this.f464402k != null) goto L42;
    L44:
        float r132 = r101.getFloat("com.yalantis.ucrop.AspectRatioX", -1.0f);
        float r133 = r101.getFloat("com.yalantis.ucrop.AspectRatioY", -1.0f);
        int r134 = r101.getInt("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList r135 = r101.getParcelableArrayList("com.yalantis.ucrop.AspectRatioOptions");
        if (r132 >= 0.0f) goto L47;
    L56:
        if (r135 != null) goto L58;
    L64:
        this.f464403l.setTargetAspectRatio(0.0f);
    L65:
        int r136 = r101.getInt("com.yalantis.ucrop.MaxSizeX", 0);
        int r137 = r101.getInt("com.yalantis.ucrop.MaxSizeY", 0);
        if (r136 <= 0) goto L69;
        if (r137 <= 0) goto L69;
        this.f464403l.setMaxResultImageSizeX(r136);
        this.f464403l.setMaxResultImageSizeY(r137);
    L69:
        if (r127 == null) goto L75;
        if (r128 == null) goto L75;
        this.f464403l.q(r127, r128);     // Catch: Exception -> L73
    L77:
        if (this.f464399h == true) goto L79;
        T90(0);
    L84:
        if (this.f464414w != null) goto L86;
        this.f464414w = new View(getContext());
        this.f464414w.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f464414w.setClickable(true);
    L86:
        ((RelativeLayout) r100.findViewById(R.id.ucrop_photobox)).addView(this.f464414w);
        return r100;
    L79:
        if (this.f464405n.getVisibility() != 0) goto L81;
        U90(R.id.state_aspect_ratio);
        goto L84
    L81:
        U90(R.id.state_scale);
    L73:
        e = move-exception;
        this.f464395d.H20(S90(e));
    L75:
        this.f464395d.H20(S90(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent))));
        goto L77
    L58:
        if (r134 >= r135.size()) goto L64;
        float r138 = ((AspectRatio) ListProtector.get(r135, r134)).f464423b / ((AspectRatio) ListProtector.get(r135, r134)).f464424c;
        GestureCropImageView r139 = this.f464403l;
        if (Float.isNaN(r138) == true) goto L63;
        r102 = r138;
    L63:
        r139.setTargetAspectRatio(r102);
        goto L65
    L47:
        if (r133 < 0.0f) goto L56;
        ViewGroup r140 = this.f464405n;
        if (r140 == null) goto L51;
        r140.setVisibility(8);
    L51:
        float r141 = r132 / r133;
        GestureCropImageView r142 = this.f464403l;
        if (Float.isNaN(r141) == true) goto L55;
        r102 = r141;
    L55:
        r142.setTargetAspectRatio(r102);
        goto L65
    L42:
        if (r101.getBoolean("com.yalantis.ucrop.HideLogo", false) == false) goto L44;
        this.f464402k.setVisibility(8);
        goto L44
    L34:
        if (r131.length != 3) goto L36;
        this.f464417z = r131;
        goto L36
    L28:
        r130 = null;
        goto L29
    L7:
        if (r109.isEmpty() == false) goto L9;
    L24:
        ((RelativeLayout.LayoutParams) r100.findViewById(R.id.ucrop_frame).getLayoutParams()).bottomMargin = 0;
        r100.findViewById(R.id.ucrop_frame).requestLayout();
        goto L25
    }
}
