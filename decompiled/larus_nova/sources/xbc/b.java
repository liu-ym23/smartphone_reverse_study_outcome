package xbc;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.UIHelper;

/* JADX INFO: loaded from: classes38.dex */
public final class b {
    public static int e(float r100) {
        if (r100 <= 0.0f) goto L7;
        r100 = UIHelper.dp2px(r100);
    L7:
        return (int) r100;
    }

    public static ConstraintLayout.LayoutParams a(float r100, float r101) {
        return b(r100, r101, 0, 0, 0, 0);
    }

    public static RelativeLayout.LayoutParams d(float r100, float r101) {
        RelativeLayout.LayoutParams r102 = new RelativeLayout.LayoutParams(e(r100), e(r101));
        r102.addRule(13);
        r102.setMargins(UIHelper.dp2px(0.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(0.0f), UIHelper.dp2px(0.0f));
        return r102;
    }

    public static LinearLayout.LayoutParams c(int r100, int r101, int r102, int r103) {
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(e(r100), e(-2));
        int r105 = UIHelper.dp2px(r102);
        float r106 = 0;
        r104.setMargins(r105, UIHelper.dp2px(r106), UIHelper.dp2px(r103), UIHelper.dp2px(r106));
        r104.gravity = r101;
        return r104;
    }

    public static ConstraintLayout.LayoutParams b(float r100, float r101, int r102, int r103, int r104, int r105) {
        ConstraintLayout.LayoutParams r106 = new ConstraintLayout.LayoutParams(e(r100), e(r101));
        r106.setMargins(e(r102), e(r103), e(r104), e(r105));
        return r106;
    }
}
