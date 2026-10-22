package mm5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514467a = 0;

    static {
    }

    public static void a(BaseTitleBar r110, View.OnClickListener r111) {
        Intrinsics.checkNotNullParameter(r110, "titleBar");
        Intrinsics.checkNotNullParameter(r111, "onCloseListener");
        Context r100 = r110.getContext();
        r110.setDividerVisible(false);
        r110.setBackground(ContextCompat.getDrawable(r100, R.drawable.facade_round_top_xxl));
        r110.setBackgroundTintList(ColorStateList.valueOf(r100.getResources().getColor(R.color.bg_float_base)));
        Intrinsics.checkNotNull(r100);
        int r101 = n.d(40);
        int r102 = n.d(8);
        r110.setLeftVisible(false);
        int r103 = n.d(30);
        int r104 = n.d(14);
        FrameLayout r105 = new FrameLayout(r100);
        r105.setOnClickListener(r111);
        AppCompatImageView r112 = new AppCompatImageView(r100);
        StateListDrawable r106 = new StateListDrawable();
        r106.addState(new int[]{android.R.attr.state_pressed}, b(r100, R.color.fill_pressed));
        r106.addState(new int[]{android.R.attr.state_selected}, b(r100, R.color.fill_pressed));
        r106.addState(new int[0], b(r100, R.color.fill_hover));
        r112.setBackground(r106);
        r112.setDuplicateParentStateEnabled(true);
        r105.addView(r112, new FrameLayout.LayoutParams(r103, r103, 17));
        AppCompatImageView r113 = new AppCompatImageView(r100);
        r113.setImageResource(R.drawable.ud_icon_close_bold_outlined);
        r113.setImageTintList(ColorStateList.valueOf(r113.getResources().getColor(R.color.icon_n2)));
        r113.setClickable(false);
        r113.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r105.addView(r113, new FrameLayout.LayoutParams(r104, r104, 17));
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(r101, -1);
        r114.setMarginEnd(r102);
        Unit r107 = Unit.INSTANCE;
        r110.f240031f.addView(r105, -1, r114);
        int r115 = n.d(64);
        ViewGroup.LayoutParams r108 = r110.getLayoutParams();
        if (r108 != null) goto L5;
        r110.setLayoutParams(new FrameLayout.LayoutParams(-1, r115));
        return;
    L5:
        r108.height = r115;
        r110.setLayoutParams(r108);
    }

    public static GradientDrawable b(Context r100, int r101) {
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(1);
        r102.setColor(r100.getResources().getColor(r101));
        return r102;
    }
}
