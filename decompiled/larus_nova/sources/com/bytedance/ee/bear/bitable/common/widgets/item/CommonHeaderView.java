package com.bytedance.ee.bear.bitable.common.widgets.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$J\u0010\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'J\u000e\u0010(\u001a\u00020\"2\u0006\u0010&\u001a\u00020'J\u000e\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00018FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/widgets/item/CommonHeaderView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "titleFromXml", "Landroid/widget/TextView;", "getTitleFromXml", "()Landroid/widget/TextView;", "setTitleFromXml", "(Landroid/widget/TextView;)V", "avatarIconFromXml", "Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "getAvatarIconFromXml", "()Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;", "setAvatarIconFromXml", "(Lcom/larksuite/component/ui/imageview/LKUIRoundedImageView;)V", "rightIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getRightIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setRightIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "rightActionFromXml", "getRightActionFromXml", "()Landroid/widget/FrameLayout;", "setRightActionFromXml", "(Landroid/widget/FrameLayout;)V", com.alipay.sdk.m.x.d.f25925o, "", "text", "", "setAvatar", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "setRightIcon", "setRightAction", "listener", "Landroid/view/View$OnClickListener;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonHeaderView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f209990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LKUIRoundedImageView f209991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f209992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f209993d;

    public CommonHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final LKUIRoundedImageView getAvatarIconFromXml() {
        KeyEvent.Callback r100 = this.f209991b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.avatar_icon);
        this.f209991b = (LKUIRoundedImageView) r100;
    L6:
        return (LKUIRoundedImageView) r100;
    }

    public final FrameLayout getRightActionFromXml() {
        KeyEvent.Callback r100 = this.f209993d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.right_action);
        this.f209993d = (FrameLayout) r100;
    L6:
        return (FrameLayout) r100;
    }

    public final AppCompatImageView getRightIconFromXml() {
        KeyEvent.Callback r100 = this.f209992c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.right_icon);
        this.f209992c = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final TextView getTitleFromXml() {
        KeyEvent.Callback r100 = this.f209990a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.title);
        this.f209990a = (TextView) r100;
    L6:
        return (TextView) r100;
    }

    public final void setAvatar(Icon r100) {
        LKUIRoundedImageView r101 = getAvatarIconFromXml();
        Intrinsics.checkNotNullParameter(r101, "view");
        if (r100 == null) goto L5;
        com.bytedance.ee.bear.bitable.panel.e.i(r101, r100);
    L5:
        if (r100 != null) goto L7;
        int r102 = 8;
    L8:
        r101.setVisibility(r102);
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public final void setAvatarIconFromXml(LKUIRoundedImageView r100) {
        this.f209991b = r100;
    }

    public final void setRightAction(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        getRightActionFromXml().setOnClickListener(r100);
    }

    public final void setRightActionFromXml(FrameLayout r100) {
        this.f209993d = r100;
    }

    public final void setRightIcon(Icon r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        com.bytedance.ee.bear.bitable.panel.e.i(getRightIconFromXml(), r100);
    }

    public final void setRightIconFromXml(AppCompatImageView r100) {
        this.f209992c = r100;
    }

    public final void setTitle(String r100) {
        TextView r101 = getTitleFromXml();
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setText(r100);
        if (r100 != null) goto L5;
        int r102 = 8;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public final void setTitleFromXml(TextView r100) {
        this.f209990a = r100;
    }

    public CommonHeaderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.common_header, this, true);
    }

    public /* synthetic */ CommonHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
