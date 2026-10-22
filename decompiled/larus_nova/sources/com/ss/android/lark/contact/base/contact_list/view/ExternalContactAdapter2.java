package com.ss.android.lark.contact.base.contact_list.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.lark.pb.basic.v1.CertificateStatus;
import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chatter.ChatterDescription;
import com.ss.android.lark.contact.base.viewholder.ContactsHomeItemViewHolder;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import com.suite.lark.platform.component.widget_biz_tenantname.data.TenantCertificationData;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusLinearLayout;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class ExternalContactAdapter2 extends IndexRecyclerViewAdapter<ContactsHomeItemViewHolder, w8b.a> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f418615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f418616e;

    public interface a {
    }

    public ExternalContactAdapter2() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        super.onAttachedToRecyclerView(r100);
        this.f418615d = r100.getContext();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter
    public final Map<Integer, String> z2(List<? extends w8b.a> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100.size() == 0) goto L5;
        r101.put(0, ((w8b.a) ListProtector.get(r100, 0)).b());
        int r102 = 1;
    L8:
        if (r102 >= r100.size()) goto L13;
        w8b.a r103 = (w8b.a) ListProtector.get(r100, r102 - 1);
        w8b.a r104 = (w8b.a) ListProtector.get(r100, r102);
        if (r103.b().equalsIgnoreCase(r104.b()) == true) goto L12;
        r101.put(Integer.valueOf(r102), r104.b());
    L12:
        r102 = r102 + 1;
        goto L8
    L13:
        return r101;
    L5:
        return new HashMap();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ContactsHomeItemViewHolder r102 = (ContactsHomeItemViewHolder) r100;
        final w8b.a r103 = getItem(r101);
        if (TextUtils.isEmpty(r103.f558715m) == false) goto L5;
        String r104 = r103.f558703a;
    L6:
        String r105 = r103.f558711i;
        if (TextUtils.isEmpty(r105) == true) goto L9;
        r102.contactNameTV.setText(r105);
    L10:
        String r106 = r103.f558705c;
        r102.contactNameTV.setMaxLines(1);
        r102.contactNameTV.setEllipsize(TextUtils.TruncateAt.END);
        r102.contactTenantTV.setTenantNameData(new gpc.a(r106, r103.f558709g, true, r103.f558707e));
        CertificationInfo r107 = r103.f558716n;
        if (r107 == null) goto L15;
        CertificateStatus r108 = r107.certificate_status;
        if (r108 == null) goto L15;
        r102.contactTenantTV.setTenantCertificationData(new TenantCertificationData(r107.is_show_cert_sign, TenantCertificationData.CertificateStatus.fromValue(Integer.valueOf(r108.getValue())), null));
    L16:
        int r109 = UIHelper.dp2px(48.0f);
        Context r110 = this.f418615d;
        LKUIRoundedImageView2 r111 = r102.contactAvatar;
        String r112 = r103.f558706d;
        String r113 = r103.f558707e;
        LoadParams r114 = new LoadParams();
        r114.f426328a = r109;
        r114.f426329b = r109;
        ImageModule.a(r110, r111, r112, r113, r114);
        r102.checkBox.setVisibility(8);
        ChatterDescription r115 = r103.f558710h;
        if (r115 != null) goto L19;
    L22:
        r102.contactUserStatus.setVisibility(8);
    L23:
        r102.contactLayout.setOnClickListener(new b(this, r103));
        r102.contactLayout.setOnLongClickListener(new com.ss.android.lark.contact.base.contact_list.view.a(this, r103));
        r102.deleteBtn.setOnClickListener(new c(this, r103));
        UIUtils.display(r102.specialFocusView, r103.f558714l);
        return;
    L19:
        if (TextUtils.isEmpty(r115.description) == true) goto L22;
        r102.contactUserStatus.setVisibility(0);
        r102.contactUserStatus.setTextColor(this.f418615d.getResources().getColor(R.color.text_placeholder));
        UserStatusLinearLayout r116 = r102.contactUserStatus;
        String r117 = r103.f558710h.description;
        Context r118 = this.f418615d;
        hpc.b r119 = hpc.b.b();
        r103.f558710h.type.getNumber();
        r119.getClass();
        Drawable r120 = UIUtils.getDrawable(r118, R.drawable.icon_status_divider);
        r116.f461150a.setImageDrawable(r120);
        r116.f461151b.G(r117, null);
        r116.f461152c = r117;
    L15:
        r102.contactTenantTV.setTenantCertificationData(null);
        goto L16
    L9:
        r102.contactNameTV.setText(r104);
        goto L10
    L5:
        r104 = r103.f558715m;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        View r102 = LayoutInflater.from(this.f418615d).inflate(R.layout.activity_contacts_home_item, r100, false);
        if ((r102.findViewById(R.id.contact_item_layout).getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L6;
        ((ViewGroup.MarginLayoutParams) r102.findViewById(R.id.contact_item_layout).getLayoutParams()).setMarginEnd(UIUtils.dp2px(this.f418615d, 27.0f));
    L6:
        return new ContactsHomeItemViewHolder(r102);
    }
}
