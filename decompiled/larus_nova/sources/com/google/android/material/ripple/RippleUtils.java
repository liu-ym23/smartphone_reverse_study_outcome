package com.google.android.material.ripple;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes23.dex */
public class RippleUtils {
    private static final int[] FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] HOVERED_STATE_SET = null;
    private static final int[] PRESSED_STATE_SET = null;
    private static final int[] SELECTED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET = null;
    private static final int[] SELECTED_HOVERED_STATE_SET = null;
    private static final int[] SELECTED_PRESSED_STATE_SET = null;
    private static final int[] SELECTED_STATE_SET = null;
    public static final boolean USE_FRAMEWORK_RIPPLE = false;

    static {
        USE_FRAMEWORK_RIPPLE = true;
        PRESSED_STATE_SET = new int[]{R.attr.state_pressed};
        HOVERED_FOCUSED_STATE_SET = new int[]{R.attr.state_hovered, R.attr.state_focused};
        FOCUSED_STATE_SET = new int[]{R.attr.state_focused};
        HOVERED_STATE_SET = new int[]{R.attr.state_hovered};
        SELECTED_PRESSED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_pressed};
        SELECTED_HOVERED_FOCUSED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        SELECTED_FOCUSED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_focused};
        SELECTED_HOVERED_STATE_SET = new int[]{R.attr.state_selected, R.attr.state_hovered};
        SELECTED_STATE_SET = new int[]{R.attr.state_selected};
    }

    private RippleUtils() {
    }

    public static ColorStateList convertToRippleDrawableColor(ColorStateList r100) {
        if (USE_FRAMEWORK_RIPPLE == true) goto L5;
        int[] r101 = SELECTED_PRESSED_STATE_SET;
        int[] r102 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        int[] r103 = SELECTED_FOCUSED_STATE_SET;
        int[] r104 = SELECTED_HOVERED_STATE_SET;
        int[] r105 = PRESSED_STATE_SET;
        int[] r106 = HOVERED_FOCUSED_STATE_SET;
        int[] r107 = FOCUSED_STATE_SET;
        int[] r108 = HOVERED_STATE_SET;
        return new ColorStateList(new int[][]{r101, r102, r103, r104, SELECTED_STATE_SET, r105, r106, r107, r108, StateSet.NOTHING}, new int[]{getColorForState(r100, r101), getColorForState(r100, r102), getColorForState(r100, r103), getColorForState(r100, r104), 0, getColorForState(r100, r105), getColorForState(r100, r106), getColorForState(r100, r107), getColorForState(r100, r108), 0});
    L5:
        return new ColorStateList(new int[][]{SELECTED_STATE_SET, StateSet.NOTHING}, new int[]{getColorForState(r100, SELECTED_PRESSED_STATE_SET), getColorForState(r100, PRESSED_STATE_SET)});
    }

    private static int doubleAlpha(int r100) {
        return ColorUtils.setAlphaComponent(r100, Math.min(Color.alpha(r100) * 2, 255));
    }

    private static int getColorForState(ColorStateList r100, int[] r101) {
        if (r100 == null) goto L4;
        int r102 = r100.getColorForState(r101, r100.getDefaultColor());
    L6:
        if (USE_FRAMEWORK_RIPPLE == true) goto L8;
        return r102;
    L8:
        return doubleAlpha(r102);
    L4:
        r102 = 0;
        goto L6
    }
}
