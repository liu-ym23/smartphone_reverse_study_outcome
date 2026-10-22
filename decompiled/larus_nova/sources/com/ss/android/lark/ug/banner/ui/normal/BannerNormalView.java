package com.ss.android.lark.ug.banner.ui.normal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.ug.banner.ui.view.BaseBannerView;
import com.ss.android.lark.ug.banner.ui.view.CloseIcon;
import com.ss.android.lark.utils.statistics.PerfLog;
import h9c.d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class BannerNormalView extends BaseBannerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f444374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintLayout f444375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f444376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageView f444377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f444378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f444379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f444380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CloseIcon f444381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f9c.a f444382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f444383j;

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/ug/banner/ui/normal/BannerNormalView$LayoutStyle;", "", "ug-banner-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface LayoutStyle {
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IRequestCreator f444384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BannerNormalView f444385b;

        public b(IRequestCreator r100, BannerNormalView r101) {
            this.f444384a = r100;
            this.f444385b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f444384a.into(this.f444385b.f444376c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IRequestCreator f444386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BannerNormalView f444387b;

        public c(IRequestCreator r100, BannerNormalView r101) {
            this.f444386a = r100;
            this.f444387b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f444386a.into(this.f444387b.f444377d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final int getStyle() {
        return this.f444374a;
    }

    public final void setBtnLink(String r100) {
        this.f444383j = r100;
    }

    public final void setButtonBg(int r100) {
        TextView r101 = this.f444380g;
        if (r101 == null) goto L6;
        float r102 = UIUtils.dp2px(getContext(), 6.0f);
        int r103 = g9c.a.f480537a;
        Intrinsics.checkNotNullParameter(getContext(), PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.setBackground(g9c.a.C5997a.a(r102, r100, 0, 0));
        return;
    }

    public final void setButtonText(int r100) {
        TextView r101 = this.f444380g;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setButtonTextColor(int r100) {
        TextView r101 = this.f444380g;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public final void setCloseIconColor(int r100) {
        CloseIcon r101 = this.f444381h;
        if (r101 == null) goto L6;
        r101.setIconColor(r100);
        return;
    }

    public final void setCloseIconVisible(boolean r100) {
        CloseIcon r101 = this.f444381h;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    public final void setContainerBgImage(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        UICallbackExecutor.execute(new b(ImageLoader.with(getContext()).load(r100).asDrawable(), this));
    }

    public final void setContent(int r100) {
        TextView r101 = this.f444379f;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setContentColor(int r100) {
        TextView r101 = this.f444379f;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public final void setIcon(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.f444377d == null) goto L9;
        UICallbackExecutor.execute(new c(ImageLoader.with(getContext()).load(r100).asDrawable(), this));
        return;
    }

    public final void setListener(f9c.a r100) {
        this.f444382i = r100;
    }

    public final void setTitle(int r100) {
        TextView r101 = this.f444378e;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setTitleColor(int r100) {
        TextView r101 = this.f444378e;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public final void setButtonText(String r100) {
        TextView r101 = this.f444380g;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setContent(String r100) {
        TextView r101 = this.f444379f;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setIcon(int r100) {
        ImageView r101 = this.f444377d;
        if (r101 == null) goto L6;
        r101.setImageResource(r100);
        return;
    }

    public final void setTitle(String r100) {
        TextView r101 = this.f444378e;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setIcon(Bitmap r100) {
        ImageView r101 = this.f444377d;
        if (r101 == null) goto L6;
        r101.setImageBitmap(r100);
        return;
    }

    public final void setIcon(Drawable r100) {
        ImageView r101 = this.f444377d;
        if (r101 == null) goto L6;
        r101.setImageDrawable(r100);
        return;
    }

    public BannerNormalView(Context r100, @LayoutStyle int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null);
        this.f444374a = r101;
        Context r102 = getContext();
        if (r101 != 1) goto L5;
        LayoutInflater.from(r102).inflate(R.layout.ug_normal_banner, this);
    L9:
        this.f444375b = (ConstraintLayout) findViewById(R.id.container);
        this.f444376c = (ImageView) findViewById(R.id.container_bg_img);
        this.f444377d = (ImageView) findViewById(R.id.icon);
        this.f444378e = (TextView) findViewById(R.id.title);
        this.f444379f = (TextView) findViewById(R.id.content);
        this.f444380g = (TextView) findViewById(R.id.button);
        this.f444381h = (CloseIcon) findViewById(R.id.close);
        setButtonBg(getResources().getColor(R.color.lkui_B500));
        a(getResources().getColor(R.color.lkui_B100), 0);
        ConstraintLayout r103 = this.f444375b;
        if (r103 == null) goto L12;
        r103.addOnAttachStateChangeListener(new h9c.a(this));
    L12:
        if (r101 <= 0) goto L14;
        getViewTreeObserver().addOnGlobalLayoutListener(new h9c.b(this));
    L14:
        ConstraintLayout r104 = this.f444375b;
        if (r104 == null) goto L17;
        r104.setOnClickListener(new h9c.c(this));
    L17:
        CloseIcon r105 = this.f444381h;
        if (r105 == null) goto L21;
        r105.setOnClickListener(new d(this));
        return;
    L21:
        return;
    L5:
        if (r101 == 2) goto L7;
        LayoutInflater.from(r102).inflate(R.layout.ug_normal_banner_0, this);
        goto L9
    L7:
        LayoutInflater.from(r102).inflate(R.layout.ug_normal_banner_2, this);
        goto L9
    }

    public final void a(int r100, int r101) {
        Context r102 = getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = ColorUtils.compositeColors(ContextCompat.getColor(r102, R.color.fill_img_mask), r100);
        float r104 = UIUtils.dp2px(getContext(), 8.0f);
        int r105 = UIUtils.dp2px(getContext(), 0.5f);
        int r106 = g9c.a.f480537a;
        Intrinsics.checkNotNullParameter(getContext(), PerfLog.PARAM_KEY_CONTEXT_ID);
        Drawable r107 = g9c.a.C5997a.a(r104, r103, r105, r101);
        ConstraintLayout r108 = this.f444375b;
        if (r108 == null) goto L6;
        r108.setBackground(r107);
        return;
    }
}
