package com.ss.android.lark.widget.photopickernew.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.entity.VideoImage;
import com.ss.android.lark.imagewidget.ImageWidgetFG;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.mark.MarkView;
import com.ss.android.lark.widget.photopicker.s;
import com.ss.android.lark.widget.photopickerimpl.bean.Photo;
import com.ss.android.lark.widget.photopickernew.utils.AlbumUtils;
import com.ss.android.lark.widget.thumb.AlbumSettingUtils;
import java.io.File;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import rdc.o;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class GridImageShowPlugin extends pdc.a<t, GridImageViewHolder> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Executor f447881h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f447882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f447883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rdc.d f447884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rdc.b f447885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f447886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f447887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f447888g;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/widget/photopickernew/grid/GridImageShowPlugin$GridImageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivPhoto", "Landroid/widget/ImageView;", "getIvPhoto", "()Landroid/widget/ImageView;", "vSelected", "Landroid/widget/CheckBox;", "getVSelected", "()Landroid/widget/CheckBox;", "vMask", "getVMask", "()Landroid/view/View;", "tvDuration", "Lcom/ss/android/lark/widget/mark/MarkView;", "getTvDuration", "()Lcom/ss/android/lark/widget/mark/MarkView;", "gifMark", "getGifMark", "setupCheckboxStyle", "", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GridImageViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f447889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CheckBox f447890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f447891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MarkView f447892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final MarkView f447893e;

        public GridImageViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f447889a = (ImageView) r100.findViewById(R.id.iv_photo);
            CheckBox r101 = (CheckBox) r100.findViewById(R.id.v_selected);
            this.f447890b = r101;
            this.f447891c = r100.findViewById(R.id.v_mask);
            this.f447892d = (MarkView) r100.findViewById(R.id.tv_duration);
            this.f447893e = (MarkView) r100.findViewById(R.id.tv_image_tag);
            ViewGroup.LayoutParams r102 = r101.getLayoutParams();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams r103 = (RelativeLayout.LayoutParams) r102;
            Context r104 = this.itemView.getContext();
            int r105 = ycc.a.f567293a;
            float r106 = 7;
            r103.topMargin = UIUtils.dp2px(r104, r106);
            r103.rightMargin = UIUtils.dp2px(this.itemView.getContext(), r106);
            float r107 = 30;
            r103.width = UIUtils.dp2px(this.itemView.getContext(), r107);
            r103.height = UIUtils.dp2px(this.itemView.getContext(), r107);
            r101.setTextSize(16);
            r101.setBackgroundResource(R.drawable.checkbox_bg_selector);
        }
    }

    public static final class a {
    }

    public interface b {
    }

    static {
        f447881h = CoreThreadPool.getDefault().getSingleScheduledThreadPool("lk-album-load");
    }

    @Override // pdc.a
    public final void c() {
        Log.i("GridImageShowPlugin", LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @Override // pdc.a
    public final RecyclerView.ViewHolder b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (this.f447888g != 0) goto L8;
        Lazy r101 = AlbumSettingUtils.f448944a;
        int r102 = ((AlbumSettingUtils.LevelItem) AlbumSettingUtils.f448948e.getValue()).getResolutionRatio();
        int r103 = r100.getMeasuredWidth();
        if (r103 <= 0) goto L7;
        this.f447888g = r103 / r102;
        Log.i("GridImageShowPlugin", "imageSizeCompat: " + this.f447888g + ", ratio: " + r102);
        goto L8
    L7:
        this.f447888g = DeviceUtils.getScreenWidth(this.f447882a) / r102;
        Log.w("GridImageShowPlugin", "imageSizeCompat: " + this.f447888g + ", ratio: " + r102 + ", useScreenWidth");
    L8:
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.__picker_item_photo, r100, false);
        Intrinsics.checkNotNull(r104);
        return new GridImageViewHolder(r104);
    }

    @Override // pdc.a
    public final void a(RecyclerView.ViewHolder r110, Photo r111) {
        GridImageViewHolder r100 = (GridImageViewHolder) r110;
        t r101 = (t) r111;
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "photo");
        if (r101.a() == false) goto L5;
        r100.f447892d.setVisibility(0);
        r100.f447892d.setText(r101.f447744i);
    L6:
        Context r102 = this.f447882a;
        boolean r103 = com.ss.android.lark.utils.a.a(r100.f447889a.getContext());
        int r104 = com.ss.android.lark.widget.utils.d.f449079a;
        Intrinsics.checkNotNullParameter(r101, "photo");
        com.ss.android.lark.widget.thumb.b.a r105 = new com.ss.android.lark.widget.thumb.b.a();
        r105.f448950a = r101.f447736a;
        r105.f448951b = r101.f447737b;
        r105.f448952c = r101.f447742g;
        r105.f448953d = r101.a();
        r105.f448954e = ((Boolean) r101.f447746k.getValue()).booleanValue();
        r105.f448955f = r101.f447745j;
        if (ImageWidgetFG.a() == false) goto L9;
        int r106 = this.f447888g;
        r105.f448956g = r106;
        r105.f448957h = r106;
    L11:
        if (r103 == true) goto L13;
    L55:
        MarkView r107 = r100.f447893e;
        if (r101.f447745j == false) goto L58;
        int r108 = 0;
    L59:
        r107.setVisibility(r108);
        boolean r109 = r101.f537388m;
        r100.f447889a.setSelected(r109);
        if (r101.f537389n == false) goto L62;
    L65:
        boolean r112 = true;
    L66:
        View r113 = r100.f447891c;
        if (r112 == false) goto L69;
        int r114 = 0;
    L70:
        r113.setVisibility(r114);
        s r115 = this.f447883b;
        if (r115.f447558c == 1) goto L73;
    L75:
        r100.f447890b.setVisibility(0);
        r100.f447890b.setChecked(r109);
        r100.f447890b.setText(r101.f537387l);
        r100.f447890b.setOnClickListener(new d(r101, r100, this, r109));
        return;
    L73:
        if (r115.f447562g == true) goto L75;
        r100.f447890b.setVisibility(8);
        r100.f447889a.setOnClickListener(new c(this, r101));
        return;
    L69:
        r114 = 8;
        goto L70
    L62:
        if (r101.f537390o == true) goto L65;
        r112 = false;
        goto L66
    L58:
        r108 = 8;
        goto L59
    L13:
        if (AlbumSettingUtils.a().getTotal() != 1) goto L15;
        com.ss.android.lark.widget.thumb.b.a(r102, r105, r100.f447889a);
        goto L55
    L15:
        String r116 = r101.f447737b;
        Log.i("GridImageShowPlugin", "showImage, photo: " + r101);
        if (r116 != null) goto L18;
    L21:
        boolean r117 = true;
    L22:
        if (r117 == true) goto L55;
        DiskCacheStrategy r118 = DiskCacheStrategy.RESULT;
        if (r101.f447745j == false) goto L28;
        r118 = DiskCacheStrategy.NONE;
    L28:
        if (r101.a() == false) goto L30;
        Object r119 = new VideoImage(r116);
        DiskCacheStrategy r120 = DiskCacheStrategy.NONE;
    L32:
        if (ImageWidgetFG.a() == false) goto L34;
        int r121 = this.f447888g;
    L36:
        if (AlbumUtils.a(r105) == false) goto L54;
        StringBuilder r122 = new StringBuilder();
        r122.append(r121);
        r122.append('*');
        r122.append(r121);
        String r123 = r122.toString();
        Intrinsics.checkNotNullParameter(r116, "originPath");
        Intrinsics.checkNotNullParameter(r123, "suffix");
        if (FileUtils.r(r116) == true) goto L40;
        String r124 = null;
    L42:
        if (FileUtils.r(r124) == false) goto L44;
        r119 = r124;
        goto L54
    L44:
        if (r124 != null) goto L46;
    L49:
        boolean r125 = true;
    L50:
        if (r125 == true) goto L54;
        r100.f447889a.setImageDrawable(null);
        Executor r126 = f447881h;
        if (r126 == null) goto L55;
        r126.execute(new e(r116, r121, r124, this, r100));
        goto L55
    L46:
        if (r124.length() == 0) goto L49;
        r125 = false;
        goto L50
    L40:
        PolarisFileWrapper r127 = new PolarisFileWrapper(r116);
        String r128 = wkb.b.a().getRealPath();
        FileUtils.t(r128);
        String r129 = r128 + File.separator + r116.hashCode() + '_' + r127.lastModified() + '_' + r123 + ".jpg";
        Log.i("AlbumUtils", "getAlbumThumbPath: " + r129);
        r124 = r129;
    L54:
        ImageLoader.with(r102).placeholder(R.drawable.__picker_ic_photo_black_48dp).error(R.drawable.__picker_ic_broken_image_black_48dp).load(r119).centerCrop().thumbnail(0.5f).dontAnimate(true).diskCacheStrategy(r120).override(r121, r121).listener(new f()).into(r100.f447889a);
        goto L55
    L34:
        r121 = ((Number) this.f447887f.getValue()).intValue();
        goto L36
    L30:
        r120 = r118;
        r119 = r116;
        goto L32
    L18:
        if (r116.length() == 0) goto L21;
        r117 = false;
        goto L22
    L9:
        Lazy r130 = AlbumUtils.f447970b;
        r105.f448956g = ((Number) ((Pair) r130.getValue()).getFirst()).intValue();
        r105.f448957h = ((Number) ((Pair) r130.getValue()).getSecond()).intValue();
        goto L11
    L5:
        r100.f447892d.setVisibility(8);
        goto L6
    }

    public GridImageShowPlugin(Context r100, s r101, rdc.d r102, rdc.b r103, o r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "pickParams");
        Intrinsics.checkNotNullParameter(r102, "selectedChangedListener");
        Intrinsics.checkNotNullParameter(r103, "photoClickListener");
        Intrinsics.checkNotNullParameter(r104, "support");
        this.f447882a = r100;
        this.f447883b = r101;
        this.f447884c = r102;
        this.f447885d = r103;
        this.f447886e = r104;
        this.f447887f = LazyKt.lazy(new GridImageShowPlugin$imageSize$2(this));
    }
}
