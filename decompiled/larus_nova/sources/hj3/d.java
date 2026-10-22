package hj3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.android.shopping.store.mall.follows.ThemeStatus;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AttributeSet f485410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThemeStatus f485411b;

    public final AttributeSet getAttrs() {
        return this.f485410a;
    }

    public final ThemeStatus getStatus() {
        return this.f485411b;
    }

    public d(Context r100, ThemeStatus r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "status");
        ViewGroup.LayoutParams r103 = null;
        super(r100, null, 0);
        this.f485410a = null;
        this.f485411b = r101;
        LayoutInflater.from(getContext()).inflate(R.layout.ec_shop_layout_follow_store_loading, this);
        View r104 = findViewById(R.id.content_loading);
        ImageView r105 = (ImageView) findViewById(R.id.skylight_loading_img);
        View r106 = findViewById(R.id.skylight_loading_wrapper);
        GenericDraweeHierarchy r107 = ((SimpleDraweeView) findViewById(R.id.content_loading_img)).getHierarchy();
        if (r102 == false) goto L5;
        int r108 = R.drawable.ec_store_follow_content_loading_double;
    L6:
        r107.setPlaceholderImage(r108);
        int r109 = c.f485409a[r101.ordinal()];
        if (r109 != 1) goto L9;
    L41:
        ViewGroup.LayoutParams r110 = r105.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == true) goto L44;
        r110 = null;
    L44:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r110;
        if (r111 == null) goto L47;
        r111.topMargin = 0;
    L47:
        ViewGroup.LayoutParams r112 = r104.getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L51;
        r103 = r112;
    L51:
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r103;
        if (r113 == null) goto L59;
        r113.topMargin = com.bytedance.android.shopping.extensions.b.b(72);
        return;
    L59:
        return;
    L9:
        if (r109 == 2) goto L41;
        if (r109 != 3) goto L13;
        r105.setImageResource(R.drawable.ec_store_follow_skylight_loading_dark);
        ViewGroup.LayoutParams r114 = r105.getLayoutParams();
        if ((r114 instanceof ViewGroup.MarginLayoutParams) == true) goto L31;
        r114 = null;
    L31:
        ViewGroup.MarginLayoutParams r115 = (ViewGroup.MarginLayoutParams) r114;
        if (r115 == null) goto L34;
        r115.topMargin = 0;
    L34:
        ViewGroup.LayoutParams r116 = r104.getLayoutParams();
        if ((r116 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        r103 = r116;
    L38:
        ViewGroup.MarginLayoutParams r117 = (ViewGroup.MarginLayoutParams) r103;
        if (r117 == null) goto L57;
        r117.topMargin = com.bytedance.android.shopping.extensions.b.b(72);
        return;
    L57:
        return;
    L13:
        if (r109 != 4) goto L60;
        ViewGroup.LayoutParams r118 = r105.getLayoutParams();
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == true) goto L18;
        r118 = null;
    L18:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
        if (r119 == null) goto L21;
        r119.topMargin = com.bytedance.android.shopping.extensions.b.b(12);
    L21:
        r106.setBackgroundResource(R.drawable.shape_follow_store_skylight_loading);
        ViewGroup.LayoutParams r120 = r104.getLayoutParams();
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L25;
        r103 = r120;
    L25:
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r103;
        if (r121 == null) goto L55;
        r121.topMargin = com.bytedance.android.shopping.extensions.b.b(84);
        return;
    L55:
        return;
    L60:
        return;
    L5:
        r108 = R.drawable.ec_store_follow_content_loading;
        goto L6
    }
}
