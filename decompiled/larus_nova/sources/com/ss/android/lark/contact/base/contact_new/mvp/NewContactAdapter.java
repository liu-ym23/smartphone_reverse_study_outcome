package com.ss.android.lark.contact.base.contact_new.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.bmf_mods.common.ErrorCode;
import com.bytedance.lark.pb.basic.v1.CertificateStatus;
import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.callback.CallbackManager;
import com.larus.nova.R;
import com.ss.android.lark.base.adapter.LarkRecyclerViewBaseAdapter;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.suite.lark.platform.component.widget_biz_tenantname.TenantNameTextView;
import com.suite.lark.platform.component.widget_biz_tenantname.data.TenantCertificationData;

/* JADX INFO: loaded from: classes35.dex */
public class NewContactAdapter extends LarkRecyclerViewBaseAdapter<NewContactViewHolder, NewContactView.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f418708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f418709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CallbackManager f418710c;

    public class NewContactViewHolder extends RecyclerView.ViewHolder {

        @BindView(8699)
        TextView confirmBtn;

        @BindView(8702)
        LKUIRoundedImageView2 newContactAvatar;

        @BindView(8703)
        TextView newContactExtraMessageTV;

        @BindView(ErrorCode.MODULE_NOT_INIT)
        LinearLayout newContactLayout;

        @BindView(ErrorCode.NOT_FLUSH)
        TextView newContactNameTV;

        @BindView(ErrorCode.INVALID_DATA)
        TenantNameTextView newContactTenantTV;

        public NewContactViewHolder(View r100) {
            super(r100);
            ButterKnife.bind(this, r100);
        }
    }

    public class NewContactViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NewContactViewHolder f418711a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            NewContactViewHolder r100 = this.f418711a;
            if (r100 == null) goto L7;
            this.f418711a = null;
            r100.newContactLayout = null;
            r100.newContactAvatar = null;
            r100.newContactNameTV = null;
            r100.newContactTenantTV = null;
            r100.newContactExtraMessageTV = null;
            r100.confirmBtn = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public NewContactViewHolder_ViewBinding(NewContactViewHolder r100, View r101) {
            this.f418711a = r100;
            r100.newContactLayout = (LinearLayout) Utils.findRequiredViewAsType(r101, R.id.contact_item_layout, "field 'newContactLayout'", LinearLayout.class);
            r100.newContactAvatar = (LKUIRoundedImageView2) Utils.findRequiredViewAsType(r101, R.id.contact_avatar, "field 'newContactAvatar'", LKUIRoundedImageView2.class);
            r100.newContactNameTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.contact_name, "field 'newContactNameTV'", TextView.class);
            r100.newContactTenantTV = (TenantNameTextView) Utils.findRequiredViewAsType(r101, R.id.contact_tenant, "field 'newContactTenantTV'", TenantNameTextView.class);
            r100.newContactExtraMessageTV = (TextView) Utils.findRequiredViewAsType(r101, R.id.contact_extra_message, "field 'newContactExtraMessageTV'", TextView.class);
            r100.confirmBtn = (TextView) Utils.findRequiredViewAsType(r101, R.id.confirm_btn, "field 'confirmBtn'", TextView.class);
        }
    }

    public interface a {
    }

    public NewContactAdapter() {
        this.f418710c = new CallbackManager();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        NewContactViewHolder r112 = (NewContactViewHolder) r110;
        final NewContactView.a r100 = getItem(r111);
        String r101 = r100.f418724d;
        String r102 = r100.f418725e;
        r112.newContactNameTV.setText(r101);
        TenantNameTextView r103 = r112.newContactTenantTV;
        TenantNameStatus r104 = r100.f418726f;
        ChatApplication.Status r105 = r100.f418728h;
        ChatApplication.Status r106 = ChatApplication.Status.AGREED;
        if (r105 != r106) goto L5;
        boolean r107 = true;
    L6:
        r103.setTenantNameData(new gpc.a(r102, r104, r107, r100.f418722b));
        CertificationInfo r108 = r100.f418729i;
        if (r108 == null) goto L11;
        CertificateStatus r109 = r108.certificate_status;
        if (r109 == null) goto L11;
        r112.newContactTenantTV.setTenantCertificationData(new TenantCertificationData(r108.is_show_cert_sign, TenantCertificationData.CertificateStatus.fromValue(Integer.valueOf(r109.getValue())), null));
    L12:
        int r113 = UIHelper.dp2px(40.0f);
        Context r114 = this.f418708a;
        LKUIRoundedImageView2 r115 = r112.newContactAvatar;
        String r116 = r100.f418723c;
        String r117 = r100.f418722b;
        LoadParams r118 = new LoadParams();
        r118.f426328a = r113;
        r118.f426329b = r113;
        ImageModule.a(r114, r115, r116, r117, r118);
        ChatApplication.Status r119 = r100.f418728h;
        if (r119 != ChatApplication.Status.PEDING) goto L15;
        r112.confirmBtn.setVisibility(0);
        r112.confirmBtn.setTextColor(UIHelper.getColor(R.color.primary_fill_default));
        r112.confirmBtn.setBackground(UIHelper.getDrawable(R.drawable.contact_external_or_new_item_bg));
        r112.confirmBtn.setText(UIHelper.getString(R.string.Lark_Legacy_Agree));
    L25:
        if (r119 != ChatApplication.Status.DELETED) goto L27;
        r112.newContactLayout.setVisibility(8);
    L27:
        r112.newContactExtraMessageTV.setText(r100.f418727g);
        r112.confirmBtn.setOnClickListener(new d(this, r119, r100, r111));
        r112.newContactLayout.setOnClickListener(new e(this, r100));
        r112.newContactLayout.setOnLongClickListener(new c(this, r100));
        return;
    L15:
        if (r119 != r106) goto L17;
    L20:
        r112.confirmBtn.setVisibility(0);
        r112.confirmBtn.setBackground(null);
        r112.confirmBtn.setTextColor(UIHelper.getColor(R.color.text_placeholder));
        if (r119 != r106) goto L23;
        r112.confirmBtn.setText(UIHelper.getString(R.string.Lark_NewContacts_ContactRequestAccepted));
        goto L25
    L23:
        r112.confirmBtn.setText(UIHelper.getString(R.string.Lark_Legacy_FriendRequestExpired));
        goto L25
    L17:
        if (r119 == ChatApplication.Status.EXPIRED) goto L20;
        r112.confirmBtn.setVisibility(8);
    L11:
        r112.newContactTenantTV.setTenantCertificationData(null);
        goto L12
    L5:
        r107 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Context r102 = r100.getContext();
        this.f418708a = r102;
        return new NewContactViewHolder(LayoutInflater.from(r102).inflate(R.layout.item_new_contact, r100, false));
    }
}
