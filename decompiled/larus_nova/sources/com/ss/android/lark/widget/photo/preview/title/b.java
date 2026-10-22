package com.ss.android.lark.widget.photo.preview.title;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.larksuite.framework.palette.widget.ConstraintLayoutPalette;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.StatusBarUtil;
import com.ss.android.lark.widget.photo.preview.PhotoPagerInitData;
import com.ss.android.lark.widget.photo.preview.PhotoPagerViewModel;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f447120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PhotoPagerInitData f447121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f447122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f447123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PhotoPagerViewModel f447124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f447125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f447126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f447127h;

    public static final class a extends CharacterStyle {
        public a() {
        }

        @Override // android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "tp");
            r100.setFakeBoldText(true);
        }
    }

    public final void a() {
        if (this.f447121b.getShowPhotoTitleBar() == false) goto L5;
    L7:
        PhotoPagerViewModel r100 = this.f447124e;
        PhotoPagerViewModel r101 = null;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r100 = null;
    L10:
        int r102 = r100.getCurrentIndex() + 1;
        PhotoPagerViewModel r103 = this.f447124e;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L14:
        ArrayList<PhotoItem> r104 = r101.getPhotoItemsLiveData().getValue();
        if (r104 == null) goto L17;
        int r105 = r104.size();
    L18:
        if (r105 > 0) goto L21;
        ((TextView) this.f447126g.getValue()).setText("");
        return;
    L21:
        SpannableString r106 = new SpannableString(r102 + " / " + r105);
        r106.setSpan(new a(), 0, r106.length(), 33);
        ((TextView) this.f447126g.getValue()).setText(r106);
        return;
    L17:
        r105 = 0;
        goto L18
    L13:
        r101 = r103;
        goto L14
    L5:
        if (this.f447121b.getShowPhotoIndex() == true) goto L7;
    }

    public final void b() {
        if (this.f447121b.getShowPhotoTitleBar() == false) goto L5;
    L7:
        PhotoPagerViewModel r100 = this.f447124e;
        PhotoPagerViewModel r101 = null;
        if (r100 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        r100 = null;
    L10:
        int r102 = r100.getCurrentIndex();
        PhotoPagerViewModel r103 = this.f447124e;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L14:
        ArrayList<PhotoItem> r104 = r101.getPhotoItemsLiveData().getValue();
        if (r104 == null) goto L17;
        int r105 = r104.size();
    L19:
        if (r102 == this.f447122c) goto L21;
    L22:
        a();
        this.f447122c = r102;
        this.f447123d = r105;
    L23:
        a();
        return;
    L21:
        if (r105 == this.f447123d) goto L23;
    L17:
        r105 = 0;
        goto L19
    L13:
        r101 = r103;
        goto L14
    L5:
        if (this.f447121b.getShowPhotoIndex() == true) goto L7;
    }

    public b(Fragment r110, ConstraintLayoutPalette r111, PhotoPagerInitData r112) {
        Intrinsics.checkNotNullParameter(r110, "hostFragment");
        Intrinsics.checkNotNullParameter(r111, "rootView");
        Intrinsics.checkNotNullParameter(r112, "initData");
        this.f447120a = r111;
        this.f447121b = r112;
        Context r113 = r111.getContext();
        this.f447123d = r112.getPhotoItem().size();
        Lazy r100 = LazyKt.lazy(new TitleAreaBlock$titleContainer$2(this));
        this.f447125f = r100;
        Lazy r101 = LazyKt.lazy(new TitleAreaBlock$titleTvIndex$2(this));
        this.f447126g = r101;
        Lazy r102 = LazyKt.lazy(new TitleAreaBlock$titleBtDelete$2(this));
        this.f447127h = r102;
        this.f447124e = (PhotoPagerViewModel) ViewModelProviders.of(r110).get(PhotoPagerViewModel.class);
        FrameLayout.LayoutParams r103 = null;
        if (r112.getShowPhotoTitleBar() == true) goto L5;
    L16:
        ((ImageView) r102.getValue()).setOnClickListener(new com.ss.android.lark.widget.photo.preview.title.a(this));
        if (r112.getShowPhotoIndex() == true) goto L19;
        return;
    L19:
        if (((FrameLayout) r100.getValue()).getVisibility() != 8) goto L21;
        boolean r114 = true;
    L22:
        if (r114 == false) goto L39;
        int r115 = StatusBarUtil.getStatusBarHeight(r113);
        FrameLayout r116 = (FrameLayout) r100.getValue();
        Intrinsics.checkNotNull(r116);
        r116.setVisibility(0);
        ViewGroup.LayoutParams r104 = r116.getLayoutParams();
        if ((r104 instanceof FrameLayout.LayoutParams) == false) goto L26;
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r104;
    L27:
        if (r105 == null) goto L29;
        r105.height = UIUtils.dp2px(r116.getContext(), 44.0f) + r115;
    L29:
        r116.setBackgroundColor(UIUtils.getColor(r113, R.color.lkui_transparent));
        TextView r117 = (TextView) r101.getValue();
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if ((r118 instanceof FrameLayout.LayoutParams) == false) goto L32;
        r103 = (FrameLayout.LayoutParams) r118;
    L32:
        if (r103 == null) goto L34;
        r103.gravity = 1;
    L34:
        if (r103 == null) goto L36;
        r103.topMargin = UIUtils.dp2px(r117.getContext(), 16.0f) + r115;
    L36:
        int r119 = UIUtils.dp2px(r117.getContext(), 2.0f);
        int r120 = UIUtils.dp2px(r117.getContext(), 6.0f);
        r117.setPadding(r120, r119, r120, r119);
        r117.setBackgroundResource(R.drawable.bg_photo_header_index_label);
        return;
    L26:
        r105 = null;
        goto L27
    L39:
        return;
    L21:
        r114 = false;
        goto L22
    L5:
        if (((FrameLayout) r100.getValue()).getVisibility() != 8) goto L7;
        boolean r121 = true;
    L8:
        if (r121 == false) goto L16;
        FrameLayout r122 = (FrameLayout) r100.getValue();
        Intrinsics.checkNotNull(r122);
        r122.setVisibility(0);
        int r106 = StatusBarUtil.getStatusBarHeight(r122.getContext());
        ViewGroup.LayoutParams r107 = r122.getLayoutParams();
        if ((r107 instanceof FrameLayout.LayoutParams) == false) goto L12;
        FrameLayout.LayoutParams r108 = (FrameLayout.LayoutParams) r107;
    L13:
        if (r108 == null) goto L15;
        r108.height = UIUtils.dp2px(r122.getContext(), 44.0f) + r106;
    L15:
        r122.setPadding(r122.getPaddingLeft(), r106, r122.getPaddingRight(), r122.getPaddingBottom());
        r122.setBackgroundColor(j08.b.c(r122.getContext(), R.color.lkui_N1000, 0.3f));
        ((ImageView) r102.getValue()).setVisibility(0);
        goto L16
    L12:
        r108 = null;
        goto L13
    L7:
        r121 = false;
        goto L8
    }
}
