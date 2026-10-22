package com.ss.android.lark.keyboard.plugin.tool.face;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB-\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/face/FaceEmptyView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "init", "", "createView", "Landroid/view/View;", "keyboard-biz-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FaceEmptyView extends LinearLayout {
    public FaceEmptyView(Context r100) {
        this(r100, null);
    }

    public FaceEmptyView(Context r100, AttributeSet r101) {
        this(r100, r101, -1);
    }

    public FaceEmptyView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102, -1);
        Context r103 = getContext();
        LinearLayout r104 = new LinearLayout(r103);
        LinearLayout.LayoutParams r105 = new LinearLayout.LayoutParams(-2, -2);
        r105.gravity = 17;
        r104.setGravity(17);
        r104.setOrientation(1);
        addView(r104, r105);
        ImageView r106 = new ImageView(r103);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(UIUtils.dp2px(r103, 74.0f), UIUtils.dp2px(r103, 74.0f));
        r106.setImageDrawable(y9c.d.e(r103, R.drawable.ic_icon_empty_sticker_add));
        r104.addView(r106, r107);
        TextView r108 = new TextView(r103);
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(-2, -2);
        r109.topMargin = UIUtils.dp2px(r103, 10.0f);
        r108.setText(UIUtils.getString(r103, R.string.Lark_Legacy_ClickToAddStickers));
        r108.setTextColor(UIUtils.getColor(r103, R.color.lkui_N500));
        r108.setTextSize(2, 12.0f);
        r104.addView(r108, r109);
    }
}
