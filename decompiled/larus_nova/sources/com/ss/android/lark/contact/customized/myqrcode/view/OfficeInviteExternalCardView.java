package com.ss.android.lark.contact.customized.myqrcode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalCardLayoutBinding;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007JB\u0010\u0015\u001a\u00020\u00122:\u0010\u0016\u001a6\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bJ\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\n\u001a6\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/contact/customized/myqrcode/view/OfficeInviteExternalCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbInviteExternalCardLayoutBinding;", "avatarLoadListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "success", "Lcom/ss/android/lark/image/api/DataSource;", "dataSource", "", "mainBotAvatarCallback", "Landroid/graphics/drawable/Drawable$Callback;", "setOnAvatarLoadListener", "listener", "initCard", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/ss/android/lark/contact/customized/myqrcode/model/OfficeInviteExternalCardRenderModel;", "getCardLayout", "Landroid/view/View;", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalCardView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ContactDbInviteExternalCardLayoutBinding f419320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Boolean, ? super DataSource, Unit> f419321b;

    public static final class a {
    }

    static {
    }

    public final View getCardLayout() {
        return this.f419320a.f419034b;
    }

    public OfficeInviteExternalCardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setOnAvatarLoadListener(Function2<? super Boolean, ? super DataSource, Unit> r100) {
        this.f419321b = r100;
    }

    public OfficeInviteExternalCardView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(getContext()).inflate(R.layout.contact_db_invite_external_card_layout, this, true);
        int r112 = R.id.llCardLayout;
        LKUIRoundLinearLayout r100 = (LKUIRoundLinearLayout) ViewBindings.findChildViewById(this, R.id.llCardLayout);
        if (r100 == null) goto L23;
        r112 = R.id.scvShowInfoInviteLinkQrIv;
        LKUIRoundedImageView2 r101 = (LKUIRoundedImageView2) ViewBindings.findChildViewById(this, R.id.scvShowInfoInviteLinkQrIv);
        if (r101 == null) goto L23;
        r112 = R.id.scvShowInfoInviteLinkQrIvParent;
        if (((LKUIRoundableLayout) ViewBindings.findChildViewById(this, R.id.scvShowInfoInviteLinkQrIvParent)) == null) goto L23;
        r112 = R.id.scvShowInfoInviteLinkQrLogo;
        LKUIRoundedImageView2 r102 = (LKUIRoundedImageView2) ViewBindings.findChildViewById(this, R.id.scvShowInfoInviteLinkQrLogo);
        if (r102 == null) goto L23;
        r112 = R.id.scvShowInfoNameTv;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.scvShowInfoNameTv);
        if (r103 == null) goto L23;
        r112 = R.id.scvShowInfoTenantTv;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.scvShowInfoTenantTv);
        if (r104 == null) goto L23;
        r112 = R.id.scvTopAvatarCiv;
        LKUIRoundedImageView2 r105 = (LKUIRoundedImageView2) ViewBindings.findChildViewById(this, R.id.scvTopAvatarCiv);
        if (r105 == null) goto L23;
        r112 = R.id.scvTopSubTitleTv;
        if (((TextView) ViewBindings.findChildViewById(this, R.id.scvTopSubTitleTv)) == null) goto L23;
        r112 = R.id.scvTopTitleTv;
        TextView r106 = (TextView) ViewBindings.findChildViewById(this, R.id.scvTopTitleTv);
        if (r106 == null) goto L23;
        this.f419320a = new ContactDbInviteExternalCardLayoutBinding(this, r100, r101, r102, r103, r104, r105, r106);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
    }
}
