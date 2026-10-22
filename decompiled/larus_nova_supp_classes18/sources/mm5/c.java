package mm5;

import android.R;
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
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(BaseTitleBar r12, View.OnClickListener r13) {
        Intrinsics.checkNotNullParameter(r12, "titleBar");
        Intrinsics.checkNotNullParameter(r13, "onCloseListener");
        Context r0 = r12.getContext();
        r12.setDividerVisible(false);
        r12.setBackground(ContextCompat.getDrawable(r0, 2131235325));
        r12.setBackgroundTintList(ColorStateList.valueOf(r0.getResources().getColor(2131100558)));
        Intrinsics.checkNotNull(r0);
        int r2 = n.d(40);
        int r3 = n.d(8);
        r12.setLeftVisible(false);
        int r4 = n.d(30);
        int r5 = n.d(14);
        FrameLayout r6 = new FrameLayout(r0);
        r6.setOnClickListener(r13);
        AppCompatImageView r14 = new AppCompatImageView(r0);
        StateListDrawable r7 = new StateListDrawable();
        r7.addState(new int[]{R.attr.state_pressed}, b(r0, 2131101953));
        r7.addState(new int[]{R.attr.state_selected}, b(r0, 2131101953));
        r7.addState(new int[0], b(r0, 2131101950));
        r14.setBackground(r7);
        r14.setDuplicateParentStateEnabled(true);
        r6.addView(r14, new FrameLayout.LayoutParams(r4, r4, 17));
        AppCompatImageView r15 = new AppCompatImageView(r0);
        r15.setImageResource(2131254119);
        r15.setImageTintList(ColorStateList.valueOf(r15.getResources().getColor(2131102419)));
        r15.setClickable(false);
        r15.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r6.addView(r15, new FrameLayout.LayoutParams(r5, r5, 17));
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(r2, -1);
        r16.setMarginEnd(r3);
        Unit r1 = Unit.INSTANCE;
        r12.f.addView(r6, -1, r16);
        int r17 = n.d(64);
        ViewGroup.LayoutParams r8 = r12.getLayoutParams();
        if (r8 != null) goto L5;
        r12.setLayoutParams(new FrameLayout.LayoutParams(-1, r17));
        return;
    L5:
        r8.height = r17;
        r12.setLayoutParams(r8);
    }

    public static GradientDrawable b(Context r2, int r3) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(1);
        r0.setColor(r2.getResources().getColor(r3));
        return r0;
    }
}
