package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.secret.SearchBoxStatus;
import com.bytedance.ee.bear.secret.SearchableStatus;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0014J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u0018\u0010\u001b\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u001aJ\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0003J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/SecretLevelAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/secret/SecretLevel;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "meta", "Lcom/bytedance/ee/bear/DocMetaInfo;", "itemClick", "Lkotlin/Function1;", "", "<init>", "(Lcom/bytedance/ee/bear/DocMetaInfo;Lkotlin/jvm/functions/Function1;)V", "canShowSearchTips", "", "getCanShowSearchTips", "()Z", "setCanShowSearchTips", "(Z)V", "defaultSecretLabelId", "", "convert", "helper", MapController.ITEM_LAYER_TAG, "setSearchTipsStatus", "instanceModel", "Lcom/bytedance/ee/bear/secret/SecretApprovalInstanceModel;", "appCall", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretLevelAdapter$IApproveCall;", "setApproveModel", NotificationCompat.CATEGORY_CALL, "setupApprovalTips", "setupSecretTips", "setupTag", "itemId", "getSelectedItem", "setDefaultId", "IApproveCall", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretLevelAdapter extends BaseQuickAdapter<SecretLevel, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DocMetaInfo f233948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<SecretLevel, Unit> f233949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f233950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f233951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecretApprovalInstanceModel f233952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f233953f;

    public interface a {
        void a(SecretLevel r100);
    }

    public static final /* synthetic */ String y2() {
        return BaseQuickAdapter.TAG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SecretLevelAdapter(DocMetaInfo r100, Function1<? super SecretLevel, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        Intrinsics.checkNotNullParameter(r101, "itemClick");
        super(R.layout.perm_secret_item, new ArrayList());
        this.f233948a = r100;
        this.f233949b = r101;
        this.f233951d = "";
        this.f233952e = new SecretApprovalInstanceModel();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r110, SecretLevel r111) {
        SecretLevel r112 = r111;
        Intrinsics.checkNotNullParameter(r110, "helper");
        Intrinsics.checkNotNullParameter(r112, MapController.ITEM_LAYER_TAG);
        int r100 = r110.getLayoutPosition();
        if (r100 != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r100 != (getData().size() - 1)) goto L9;
        boolean r102 = true;
    L10:
        if (r101 == false) goto L13;
        if (r102 == false) goto L13;
        boolean r103 = true;
    L14:
        BaseViewHolder r104 = r110.setText(R.id.secretName, r112.getName()).setText(R.id.secretDesc, r112.getDescription()).setChecked(R.id.checkBox, r112.isSelected());
        if (r103 == true) goto L18;
        if (r102 == true) goto L18;
        boolean r105 = true;
    L19:
        BaseViewHolder r106 = r104.setVisible(R.id.divider, r105);
        if (this.f233950c == true) goto L22;
    L32:
        boolean r107 = false;
    L33:
        BaseViewHolder r108 = r106.setGone(R.id.ll_search_tips, r107);
        if (this.f233950c == true) goto L36;
    L46:
        boolean r109 = false;
    L47:
        r108.setGone(R.id.tvSearchTips, r109).setText(R.id.tvSearchTips, r112.getTips());
        String r113 = BaseQuickAdapter.TAG;
        Log.i(r113, "setSearchTipsStatus: item.searchBoxStatus = " + r112.getSearchBoxStatus());
        Integer r114 = r112.getSearchBoxStatus();
        int r115 = SearchBoxStatus.SHOW.getValue();
        if (r114 != null) goto L51;
    L53:
        boolean r116 = false;
    L55:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.h(), Boolean.FALSE) == true) goto L65;
        DocMetaInfo r117 = this.f233948a;
        if (r117 == null) goto L63;
        SecretLevel r118 = r117.getSecretLevel();
        if (r118 == null) goto L63;
        if (r118.getLevel() != r112.getLevel()) goto L63;
        boolean r119 = true;
    L64:
        if (r119 == true) goto L65;
    L66:
        r110.setGone(R.id.ll_search_box_status, r116);
        if (r116 == false) goto L83;
        Log.i(r113, "setSearchTipsStatus: isVisible = visible");
        String r120 = r112.getTips();
        if (r120 == null) goto L72;
        r110.setText(R.id.tvSearchTips, r120);
    L72:
        TextView r121 = (TextView) r110.getView(R.id.tv_search_box_status);
        String r122 = r112.getSearchCheckboxDesc();
        if (r122 == null) goto L75;
        r121.setText(r122);
    L75:
        UDCheckBox r123 = (UDCheckBox) r110.getView(R.id.cb_search_box_status);
        Integer r124 = r112.getSearchable();
        int r125 = SearchableStatus.SEARCHABLE.getValue();
        if (r124 != null) goto L79;
    L81:
        boolean r126 = false;
    L82:
        r123.setChecked(r126);
        r112.setSelectedSearch(r112.getSearchable());
        ((ViewGroup) r110.getView(R.id.ll_search_box_status)).setOnClickListener(new r(r123));
        r123.setOnCheckedChangeListener(new s(r112, this));
        goto L83
    L79:
        if (r124.intValue() != r125) goto L81;
        r126 = true;
    L83:
        String r127 = r112.getId();
        AppCompatTextView r128 = (AppCompatTextView) r110.getView(R.id.secretTag);
        if (TextUtils.isEmpty(this.f233951d) == false) goto L86;
    L88:
        r128.setVisibility(8);
    L90:
        if (r112.getCanModify() == false) goto L92;
    L94:
        r110.itemView.setOnClickListener(new q(r112, this));
        Context r129 = r110.itemView.getContext();
        int r130 = UIUtils.getColor(r129, R.color.bg_float);
        Intrinsics.checkNotNull(r129);
        float r131 = h18.d.b(r129, 10);
        ArrayList<SecretApprovalInstanceModel.Instance> r132 = null;
        if (r103 == false) goto L97;
        GradientDrawable r133 = lp5.a.b(r130, r131, null);
    L102:
        r110.itemView.setBackground(r133);
        TextView r134 = (TextView) r110.getView(R.id.approveMsg);
        if (this.f233952e.isSuccess() == false) goto L130;
        SecretApprovalInstanceModel r135 = this.f233952e;
        String r136 = r112.getId();
        int r137 = b0.f234026a;
        Intrinsics.checkNotNullParameter(r136, "id");
        if (r135 == null) goto L107;
        r132 = r135.getInstances();
    L107:
        if (r132 != null) goto L109;
    L116:
        int r138 = 0;
    L117:
        if (r138 <= 0) goto L119;
        String r139 = eu5.b.f474075a.getResources().getQuantityString(R.plurals.LarkCCM_Workspace_SecLeviI_AdjustRequest_xpplRequested_Tag, r138, new Object[]{Integer.valueOf(r138)});
    L121:
        if (TextUtils.isEmpty(r139) == true) goto L123;
        r134.setVisibility(0);
        r134.setText(r139);
        r134.setOnClickListener(new t(this, r112));
        return;
    L123:
        r134.setVisibility(8);
        return;
    L119:
        r139 = "";
        goto L121
    L109:
        if (r135.getInstances().isEmpty() == true) goto L116;
        Iterator<SecretApprovalInstanceModel.Instance> r140 = r135.getInstances().iterator();
        r138 = 0;
    L112:
        if (r140.hasNext() == false) goto L117;
        if (r136.equals(r140.next().getApply_sec_label_id()) == false) goto L112;
        r138 = r138 + 1;
        goto L112
    L130:
        return;
    L97:
        if (r101 == false) goto L99;
        r133 = lp5.a.g(r130, r131, null);
        goto L102
    L99:
        if (r102 == false) goto L101;
        r133 = lp5.a.a(r130, r131, null);
        goto L102
    L101:
        r133 = lp5.a.e(r130, null);
        goto L102
    L92:
        if (r112.isSelected() == true) goto L94;
        ((UDCheckBox) r110.getView(R.id.checkBox)).setEnabled(false);
        goto L94
    L86:
        if (TextUtils.equals(r127, this.f233951d) == false) goto L88;
        r128.setVisibility(0);
    L63:
        r119 = false;
    L65:
        Log.i(r113, "setSearchTipsStatus: hide search tips");
        r116 = false;
        goto L66
    L51:
        if (r114.intValue() != r115) goto L53;
        r116 = true;
        goto L55
    L36:
        if (r112.isSelected() == false) goto L46;
        String r141 = r112.getTips();
        if (r141 != null) goto L40;
    L43:
        boolean r142 = true;
    L44:
        if (r142 == true) goto L46;
        r109 = true;
        goto L47
    L40:
        if (r141.length() == 0) goto L43;
        r142 = false;
        goto L44
    L22:
        if (r112.isSelected() == false) goto L32;
        String r143 = r112.getTips();
        if (r143 != null) goto L26;
    L29:
        boolean r144 = true;
    L30:
        if (r144 == true) goto L32;
        r107 = true;
        goto L33
    L26:
        if (r143.length() == 0) goto L29;
        r144 = false;
    L18:
        r105 = false;
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L7
    }
}
