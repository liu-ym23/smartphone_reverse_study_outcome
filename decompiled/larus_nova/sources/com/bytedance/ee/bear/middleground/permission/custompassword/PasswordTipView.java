package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.middleground.permission.custompassword.state.PasswordItemState;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0018\u001a\u00020\rH\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/PasswordTipView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "init", "", "getLayoutParam", "Landroid/view/ViewGroup$LayoutParams;", "initPasswordTipView", "Landroid/widget/TextView;", "itemStateMsg", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/PassWordItemMsg;", "getImageView", "Landroid/widget/ImageView;", "imageBg", "", "image", "getImageLp", "Landroid/widget/LinearLayout$LayoutParams;", "initWarningView", "getBaseTextView", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PasswordTipView extends LinearLayout {

    public static final class a {
    }

    static {
    }

    private final TextView getBaseTextView() {
        TextView r100 = new TextView(getContext());
        r100.setTextColor(y9c.d.c(getContext(), R.color.text_title));
        r100.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(-1, -2);
        r101.leftMargin = UIUtils.dp2px(getContext(), 4.0f);
        r100.setLayoutParams(r101);
        return r100;
    }

    private final LinearLayout.LayoutParams getImageLp() {
        int r100 = y9c.d.a(16);
        LinearLayout.LayoutParams r101 = new LinearLayout.LayoutParams(r100, r100);
        r101.topMargin = y9c.d.a(2);
        return r101;
    }

    public final ViewGroup.LayoutParams getLayoutParam() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-1, -2);
        r100.bottomMargin = UIUtils.dp2px(getContext(), 4.0f);
        return r100;
    }

    public PasswordTipView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(jh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "itemStateMsg");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(48);
        PasswordItemState r101 = r100.f499089b;
        TextView r102 = getBaseTextView();
        r102.setText(r100.f499088a);
        if (r101 != PasswordItemState.STATE_PASS) goto L6;
        ImageView r103 = new ImageView(getContext());
        r103.setLayoutParams(getImageLp());
        r103.setImageResource(R.drawable.ud_icon_succeed_hollow_filled);
        com.bytedance.ee.util.ui.l.c(r103, R.color.function_success_400);
        addView(r103);
    L9:
        addView(r102);
        return;
    L6:
        if (r101 != PasswordItemState.STATE_TIPS) goto L8;
        ImageView r104 = new ImageView(getContext());
        r104.setLayoutParams(getImageLp());
        r104.setImageResource(R.drawable.ud_icon_succeed_hollow_filled);
        com.bytedance.ee.util.ui.l.c(r104, R.color.icon_disabled);
        addView(r104);
        goto L9
    L8:
        r102.setTextColor(y9c.d.c(getContext(), R.color.function_danger_content_default));
        ImageView r105 = new ImageView(getContext());
        r105.setLayoutParams(getImageLp());
        r105.setImageResource(R.drawable.ud_icon_error_colorful);
        addView(r105);
        goto L9
    }

    public final void b(jh5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "itemStateMsg");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(48);
        TextView r101 = getBaseTextView();
        r101.setText(r100.f499088a);
        r101.setTextColor(y9c.d.c(getContext(), R.color.function_danger_content_default));
        ImageView r102 = new ImageView(getContext());
        r102.setLayoutParams(getImageLp());
        r102.setImageResource(R.drawable.ud_icon_error_colorful);
        addView(r102);
        addView(r101);
    }

    public PasswordTipView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
