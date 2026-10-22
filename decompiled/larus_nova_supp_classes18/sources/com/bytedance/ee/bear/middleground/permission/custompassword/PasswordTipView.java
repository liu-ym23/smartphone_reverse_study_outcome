package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.middleground.permission.custompassword.state.PasswordItemState;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.larksuite.framework.utils.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0018\u001a\u00020\rH\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/PasswordTipView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "init", "", "getLayoutParam", "Landroid/view/ViewGroup$LayoutParams;", "initPasswordTipView", "Landroid/widget/TextView;", "itemStateMsg", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/PassWordItemMsg;", "getImageView", "Landroid/widget/ImageView;", "imageBg", "", ExportShareModel.EXPORT_SHARE_TYPE_IMAGE, "getImageLp", "Landroid/widget/LinearLayout$LayoutParams;", "initWarningView", "getBaseTextView", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PasswordTipView extends LinearLayout {

    public static final class a {
    }

    static {
    }

    private final TextView getBaseTextView() {
        TextView r0 = new TextView(getContext());
        r0.setTextColor(y9c.d.c(getContext(), 2131106622));
        r0.setTextSize(2, 14.0f);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.leftMargin = UIUtils.dp2px(getContext(), 4.0f);
        r0.setLayoutParams(r1);
        return r0;
    }

    private final LinearLayout.LayoutParams getImageLp() {
        int r0 = y9c.d.a(16);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(r0, r0);
        r1.topMargin = y9c.d.a(2);
        return r1;
    }

    public final ViewGroup.LayoutParams getLayoutParam() {
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        r0.bottomMargin = UIUtils.dp2px(getContext(), 4.0f);
        return r0;
    }

    public PasswordTipView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void a(jh5.c r4) {
        Intrinsics.checkNotNullParameter(r4, "itemStateMsg");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(48);
        PasswordItemState r0 = r4.b;
        TextView r1 = getBaseTextView();
        r1.setText(r4.a);
        if (r0 != PasswordItemState.STATE_PASS) goto L6;
        ImageView r5 = new ImageView(getContext());
        r5.setLayoutParams(getImageLp());
        r5.setImageResource(2131255861);
        com.bytedance.ee.util.ui.l.c(r5, 2131102143);
        addView(r5);
    L9:
        addView(r1);
        return;
    L6:
        if (r0 != PasswordItemState.STATE_TIPS) goto L8;
        ImageView r6 = new ImageView(getContext());
        r6.setLayoutParams(getImageLp());
        r6.setImageResource(2131255861);
        com.bytedance.ee.util.ui.l.c(r6, 2131102417);
        addView(r6);
        goto L9
    L8:
        r1.setTextColor(y9c.d.c(getContext(), 2131102089));
        ImageView r7 = new ImageView(getContext());
        r7.setLayoutParams(getImageLp());
        r7.setImageResource(2131254319);
        addView(r7);
        goto L9
    }

    public final void b(jh5.c r4) {
        Intrinsics.checkNotNullParameter(r4, "itemStateMsg");
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(0);
        setGravity(48);
        TextView r0 = getBaseTextView();
        r0.setText(r4.a);
        r0.setTextColor(y9c.d.c(getContext(), 2131102089));
        ImageView r5 = new ImageView(getContext());
        r5.setLayoutParams(getImageLp());
        r5.setImageResource(2131254319);
        addView(r5);
        addView(r0);
    }

    public PasswordTipView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
