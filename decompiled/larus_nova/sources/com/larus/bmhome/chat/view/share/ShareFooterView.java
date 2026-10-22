package com.larus.bmhome.chat.view.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.alipay.sdk.m.x.d;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.common_res.common_ui.databinding.LarusLayoutShareFooterBinding;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.common_ui.widget.roundlayout.CustomRoundImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/view/share/ShareFooterView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusLayoutShareFooterBinding;", d.f25925o, "", "title", "", "setSubTitle", "subTitle", "setQRCode", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFooterView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutShareFooterBinding f310394a;

    public ShareFooterView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ShareFooterView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setQRCode(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        this.f310394a.f326767c.setImageBitmap(r100);
    }

    public final void setSubTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "subTitle");
        this.f310394a.f326768d.setText(r100);
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "title");
        this.f310394a.f326769e.setText(r100);
    }

    public ShareFooterView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_share_footer, this);
        int r103 = R.id.footer_avatar;
        if (((ImageView) ViewBindings.findChildViewById(this, R.id.footer_avatar)) == null) goto L19;
        r103 = R.id.footer_avatar_wrapper;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.footer_avatar_wrapper);
        if (r104 == null) goto L19;
        r103 = R.id.footer_enterprise_avatar;
        if (((CustomRoundImageView) ViewBindings.findChildViewById(this, R.id.footer_enterprise_avatar)) == null) goto L19;
        r103 = R.id.footer_enterprise_avatar_container;
        if (((ShadowLayout) ViewBindings.findChildViewById(this, R.id.footer_enterprise_avatar_container)) == null) goto L19;
        r103 = R.id.footer_qrcode;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(this, R.id.footer_qrcode);
        if (r105 == null) goto L19;
        r103 = R.id.footer_subtitle;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.footer_subtitle);
        if (r106 == null) goto L19;
        r103 = R.id.footer_title;
        TextView r107 = (TextView) ViewBindings.findChildViewById(this, R.id.footer_title);
        if (r107 == null) goto L19;
        this.f310394a = new LarusLayoutShareFooterBinding(this, r104, r105, r106, r107);
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ ShareFooterView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
