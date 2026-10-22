package com.ss.android.lark.chat.preview.components.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import com.bumptech.glide.load.model.GlideUrl;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.n0;
import com.larus.nova.R;
import com.ss.android.lark.chat.preview.entity.component.property.VideoProperty;
import com.ss.android.lark.export.entity.preview.Border;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Style;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.mark.MarkView;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j extends LKUIRoundableLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ImageView f416216r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ImageView f416217s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final MarkView f416218t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ImageView f416219u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f416220v;

    public static final class a {
    }

    static {
    }

    private final GradientDrawable getDefaultGradientDrawable() {
        GradientDrawable r100 = new GradientDrawable();
        r100.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r100.setColors(new int[]{j08.b.b(getContext().getResources().getColor(R.color.black), 0.2f), j08.b.b(getContext().getResources().getColor(R.color.black), 0.01f), j08.b.b(getContext().getResources().getColor(R.color.black), 0.2f)});
        return r100;
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 6, 0);
        g6b.a.InterfaceC5990a r101 = g6b.a.f480178a;
        if (r101 == null) goto L5;
        r101.c();
    L5:
        this.f416220v = false;
        LayoutInflater.from(r100).inflate(R.layout.video_cover, this, true);
        ImageView r102 = (ImageView) findViewById(R.id.iv_video_bg);
        this.f416216r = r102;
        ImageView r103 = (ImageView) findViewById(R.id.iv_video_cover);
        this.f416217s = r103;
        this.f416218t = (MarkView) findViewById(R.id.tv_video_duration);
        ImageView r104 = (ImageView) findViewById(R.id.iv_shadow);
        this.f416219u = r104;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
        r102 = null;
    L8:
        r102.setLayerType(2, null);
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r103 = null;
    L11:
        r103.setLayerType(2, null);
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("shadowImg");
        r104 = null;
    L14:
        r104.setLayerType(2, null);
    }

    private final void setViewCornerRadius(Style r100) {
        if (r100 == null) goto L21;
        Border r101 = r100.getBorder();
        if (r101 == null) goto L8;
        ThemeColor r102 = r101.getThemeColor();
        if (r102 == null) goto L8;
        setBorderColor(com.ss.android.lark.export.entity.preview.a.a(r102, getContext(), null));
    L8:
        Border r103 = r100.getBorder();
        float r104 = 0.0f;
        if (r103 == null) goto L13;
        Float r105 = r103.getWidth();
        if (r105 == null) goto L13;
        float r106 = r105.floatValue();
    L14:
        setBorderWidth(UIHelper.dp2px(r106));
        Border r107 = r100.getBorder();
        if (r107 == null) goto L19;
        Float r108 = r107.getCornerRadius();
        if (r108 == null) goto L19;
        r104 = r108.floatValue();
    L19:
        setRadius(r104);
        return;
    L13:
        r106 = 0.0f;
        goto L14
    }

    public final void f(String r100) {
        IRequestCreator r101 = ImageLoader.with(getContext()).load(r100);
        DiskCacheStrategy r102 = DiskCacheStrategy.RESULT;
        IRequestCreator r103 = r101.diskCacheStrategy(r102).isAsync(this.f416220v).override(getLayoutParams().width, getLayoutParams().height);
        ImageView r104 = this.f416217s;
        ImageView r105 = null;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r104 = null;
    L5:
        r103.into(r104);
        IRequestCreator r106 = ImageLoader.with(getContext()).load(r100).diskCacheStrategy(r102).isAsync(this.f416220v).centerCrop().override(getLayoutParams().width, getLayoutParams().height).transform(new xkb.b());
        ImageView r107 = this.f416216r;
        if (r107 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
    L9:
        r106.into(r105);
        return;
    L8:
        r105 = r107;
        goto L9
    }

    public final void g(VideoProperty r110, Style r111) {
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        GradientDrawable r100 = getDefaultGradientDrawable();
        ImageSet r101 = r110.getCoverImage();
        boolean r102 = true;
        if (r101 == null) goto L14;
        Image r103 = r101.getOrigin();
        if (r103 == null) goto L14;
        String r104 = r103.getKey();
        if (r104 == null) goto L14;
        if (r104.length() != 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
        boolean r106 = true;
    L15:
        MarkView r107 = null;
        if (r106 == false) goto L37;
        ImageSet r108 = r110.getCoverImage();
        if (r108 == null) goto L96;
        Image r109 = r108.getOrigin();
        if (r109 == null) goto L96;
        if (getLayoutParams().width <= 0) goto L25;
        int r112 = getLayoutParams().width;
    L27:
        if (getLayoutParams().height <= 0) goto L29;
        int r113 = getLayoutParams().height;
    L30:
        IRequestCreator r114 = ImageLoader.with(getContext()).load(new EncryptImage(r109)).isAsync(this.f416220v).override(r112, r113);
        ImageView r115 = this.f416217s;
        if (r115 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r115 = null;
    L33:
        r114.into(r115);
        IRequestCreator r116 = ImageLoader.with(getContext()).load(new EncryptImage(r109)).isAsync(this.f416220v).override(r112, r113).centerCrop().transform(new xkb.b());
        ImageView r117 = this.f416216r;
        if (r117 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
        r117 = null;
    L36:
        r116.into(r117);
        goto L96
    L29:
        r113 = r109.getHeight();
        goto L30
    L25:
        r112 = r109.getWidth();
    L96:
        ImageView r118 = this.f416219u;
        if (r118 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("shadowImg");
        r118 = null;
    L99:
        r118.setImageDrawable(r100);
        if (r110.getDuration() != 0) goto L106;
        MarkView r119 = this.f416218t;
        if (r119 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("durationTv");
    L105:
        r107.setVisibility(8);
    L114:
        setViewCornerRadius(r111);
        return;
    L104:
        r107 = r119;
        goto L105
    L106:
        MarkView r120 = this.f416218t;
        if (r120 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("durationTv");
        r120 = null;
    L109:
        r120.setVisibility(0);
        MarkView r121 = this.f416218t;
        if (r121 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("durationTv");
    L113:
        r107.setText(com.larksuite.framework.utils.e.f((int) r110.getDuration()));
        goto L114
    L112:
        r107 = r121;
        goto L113
    L37:
        String r122 = r110.getCoverImageUrl();
        if (r122 != null) goto L40;
    L45:
        boolean r123 = false;
    L46:
        if (r123 == false) goto L89;
        String r124 = r110.getCoverImageUrl();
        String r125 = "";
        if (r124 != null) goto L50;
        r124 = "";
    L50:
        Pattern r126 = n0.f286044a;
        if (TextUtils.isEmpty(r124) == false) goto L116;
    L52:
        String r127 = "";
    L58:
        if (r127.equals("https") == false) goto L88;
        g6b.a.InterfaceC5990a r128 = g6b.a.f480178a;
        if (r128 == null) goto L66;
        com.ss.android.lark.officesdk.integrator.im.h r129 = r128.getFeatureGatingDependency();
        if (r129 == null) goto L66;
        if (r129.a("im.chat.session_governance") != true) goto L66;
    L67:
        if (r102 == false) goto L84;
        g6b.a.InterfaceC5990a r130 = g6b.a.f480178a;
        if (r130 == null) goto L73;
        com.ss.android.lark.officesdk.integrator.im.d r131 = r130.getLoginDependency();
        if (r131 == null) goto L73;
        String r132 = r131.a();
    L74:
        if (r132 == null) goto L77;
        r125 = r132;
    L77:
        GlideUrl r133 = new GlideUrl(r124, new k(com.ss.android.lark.passport.auth.f.a.a((com.ss.android.lark.passport.auth.f) e0c.k.a(LarkContext.getApplication(), com.ss.android.lark.passport.auth.f.class), r125, r124)));
        IRequestCreator r134 = ImageLoader.with(getContext()).load(r133).isAsync(this.f416220v).override(getLayoutParams().width, getLayoutParams().height);
        ImageView r135 = this.f416217s;
        if (r135 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r135 = null;
    L80:
        r134.into(r135);
        IRequestCreator r136 = ImageLoader.with(getContext()).load(r133).isAsync(this.f416220v).centerCrop().override(getLayoutParams().width, getLayoutParams().height).transform(new xkb.b());
        ImageView r137 = this.f416216r;
        if (r137 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
        r137 = null;
    L83:
        r136.into(r137);
    L73:
        r132 = null;
        goto L74
    L84:
        g6b.a.InterfaceC5990a r138 = g6b.a.f480178a;
        if (r138 == null) goto L87;
        r138.i();
    L87:
        f(r124);
    L66:
        r102 = false;
        goto L67
    L88:
        f(r124);
        goto L96
    L116:
        r127 = UriProtector.parse(r124).getScheme();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.printStackTrace();
        goto L52
    L89:
        ImageView r139 = this.f416216r;
        if (r139 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("bg");
        r139 = null;
    L92:
        r139.setImageDrawable(r100);
        ImageView r140 = this.f416217s;
        if (r140 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
        r140 = null;
    L95:
        r140.setImageDrawable(r100);
        goto L96
    L40:
        if (r122.length() <= 0) goto L42;
        boolean r141 = true;
    L43:
        if (r141 != true) goto L45;
        r123 = true;
        goto L46
    L42:
        r141 = false;
        goto L43
    L11:
        r105 = false;
    L14:
        r106 = false;
        goto L15
    }
}
