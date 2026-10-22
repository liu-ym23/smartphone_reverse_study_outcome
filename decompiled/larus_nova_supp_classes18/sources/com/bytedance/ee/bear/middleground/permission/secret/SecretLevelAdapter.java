package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.secret.SearchBoxStatus;
import com.bytedance.ee.bear.secret.SearchableStatus;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0014J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u0018\u0010\u001b\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001c\u001a\u00020\u001aJ\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0003J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\"\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/SecretLevelAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/secret/SecretLevel;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "meta", "Lcom/bytedance/ee/bear/DocMetaInfo;", "itemClick", "Lkotlin/Function1;", "", "<init>", "(Lcom/bytedance/ee/bear/DocMetaInfo;Lkotlin/jvm/functions/Function1;)V", "canShowSearchTips", "", "getCanShowSearchTips", "()Z", "setCanShowSearchTips", "(Z)V", "defaultSecretLabelId", "", "convert", "helper", "item", "setSearchTipsStatus", "instanceModel", "Lcom/bytedance/ee/bear/secret/SecretApprovalInstanceModel;", "appCall", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretLevelAdapter$IApproveCall;", "setApproveModel", "call", "setupApprovalTips", "setupSecretTips", "setupTag", "itemId", "getSelectedItem", "setDefaultId", "IApproveCall", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretLevelAdapter extends BaseQuickAdapter<SecretLevel, BaseViewHolder> {
    public final DocMetaInfo a;
    public final Function1<SecretLevel, Unit> b;
    public boolean c;
    public String d;
    public SecretApprovalInstanceModel e;
    public a f;

    public interface a {
        void a(SecretLevel r1);
    }

    public static final /* synthetic */ String y2() {
        return BaseQuickAdapter.TAG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SecretLevelAdapter(DocMetaInfo r3, Function1<? super SecretLevel, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "meta");
        Intrinsics.checkNotNullParameter(r4, "itemClick");
        super(2131564175, new ArrayList());
        this.a = r3;
        this.b = r4;
        this.d = "";
        this.e = new SecretApprovalInstanceModel();
    }

    public final void convert(BaseViewHolder r12, Object r13) {
        SecretLevel r14 = (SecretLevel) r13;
        Intrinsics.checkNotNullParameter(r12, "helper");
        Intrinsics.checkNotNullParameter(r14, "item");
        int r0 = r12.getLayoutPosition();
        if (r0 != 0) goto L5;
        boolean r3 = true;
    L7:
        if (r0 != (getData().size() - 1)) goto L9;
        boolean r1 = true;
    L10:
        if (r3 == false) goto L13;
        if (r1 == false) goto L13;
        boolean r4 = true;
    L14:
        BaseViewHolder r5 = r12.setText(2131385709, r14.getName()).setText(2131385706, r14.getDescription()).setChecked(2131365627, r14.isSelected());
        if (r4 == true) goto L18;
        if (r1 == true) goto L18;
        boolean r6 = true;
    L19:
        BaseViewHolder r7 = r5.setVisible(2131369197, r6);
        if (this.c == true) goto L22;
    L32:
        boolean r8 = false;
    L33:
        BaseViewHolder r9 = r7.setGone(2131378847, r8);
        if (this.c == true) goto L36;
    L46:
        boolean r10 = false;
    L47:
        r9.setGone(2131390073, r10).setText(2131390073, r14.getTips());
        String r11 = BaseQuickAdapter.TAG;
        Log.i(r11, "setSearchTipsStatus: item.searchBoxStatus = " + r14.getSearchBoxStatus());
        Integer r15 = r14.getSearchBoxStatus();
        int r16 = SearchBoxStatus.SHOW.getValue();
        if (r15 != null) goto L51;
    L53:
        boolean r17 = false;
    L55:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.middleground.permission.b.h(), Boolean.FALSE) == true) goto L65;
        DocMetaInfo r18 = this.a;
        if (r18 == null) goto L63;
        SecretLevel r19 = r18.getSecretLevel();
        if (r19 == null) goto L63;
        if (r19.getLevel() != r14.getLevel()) goto L63;
        boolean r20 = true;
    L64:
        if (r20 == true) goto L65;
    L66:
        r12.setGone(2131378846, r17);
        if (r17 == false) goto L83;
        Log.i(r11, "setSearchTipsStatus: isVisible = visible");
        String r21 = r14.getTips();
        if (r21 == null) goto L72;
        r12.setText(2131390073, r21);
    L72:
        TextView r22 = (TextView) r12.getView(2131391357);
        String r23 = r14.getSearchCheckboxDesc();
        if (r23 == null) goto L75;
        r22.setText(r23);
    L75:
        UDCheckBox r24 = r12.getView(2131365306);
        Integer r25 = r14.getSearchable();
        int r26 = SearchableStatus.SEARCHABLE.getValue();
        if (r25 != null) goto L79;
    L81:
        boolean r27 = false;
    L82:
        r24.setChecked(r27);
        r14.setSelectedSearch(r14.getSearchable());
        ((ViewGroup) r12.getView(2131378846)).setOnClickListener(new r(r24));
        r24.setOnCheckedChangeListener(new s(r14, this));
        goto L83
    L79:
        if (r25.intValue() != r26) goto L81;
        r27 = true;
    L83:
        String r28 = r14.getId();
        AppCompatTextView r29 = r12.getView(2131385710);
        if (TextUtils.isEmpty(this.d) == false) goto L86;
    L88:
        r29.setVisibility(8);
    L90:
        if (r14.getCanModify() == false) goto L92;
    L94:
        ((RecyclerView.ViewHolder) r12).itemView.setOnClickListener(new q(r14, this));
        Context r30 = ((RecyclerView.ViewHolder) r12).itemView.getContext();
        int r31 = UIUtils.getColor(r30, 2131100557);
        Intrinsics.checkNotNull(r30);
        float r32 = h18.d.b(r30, 10);
        ArrayList<SecretApprovalInstanceModel.Instance> r33 = null;
        if (r4 == false) goto L97;
        GradientDrawable r2 = lp5.a.b(r31, r32, null);
    L102:
        ((RecyclerView.ViewHolder) r12).itemView.setBackground(r2);
        TextView r110 = (TextView) r12.getView(2131363219);
        if (this.e.isSuccess() == false) goto L130;
        SecretApprovalInstanceModel r34 = this.e;
        String r35 = r14.getId();
        int r36 = b0.a;
        Intrinsics.checkNotNullParameter(r35, ResourceData.KEY_ID);
        if (r34 == null) goto L107;
        r33 = r34.getInstances();
    L107:
        if (r33 != null) goto L109;
    L116:
        int r37 = 0;
    L117:
        if (r37 <= 0) goto L119;
        String r38 = eu5.b.a.getResources().getQuantityString(2131755043, r37, new Object[]{Integer.valueOf(r37)});
    L121:
        if (TextUtils.isEmpty(r38) == true) goto L123;
        r110.setVisibility(0);
        r110.setText(r38);
        r110.setOnClickListener(new t(this, r14));
        return;
    L123:
        r110.setVisibility(8);
        return;
    L119:
        r38 = "";
        goto L121
    L109:
        if (r34.getInstances().isEmpty() == true) goto L116;
        Iterator<SecretApprovalInstanceModel.Instance> r39 = r34.getInstances().iterator();
        r37 = 0;
    L112:
        if (r39.hasNext() == false) goto L117;
        if (r35.equals(r39.next().getApply_sec_label_id()) == false) goto L112;
        r37 = r37 + 1;
        goto L112
    L130:
        return;
    L97:
        if (r3 == false) goto L99;
        r2 = lp5.a.g(r31, r32, null);
        goto L102
    L99:
        if (r1 == false) goto L101;
        r2 = lp5.a.a(r31, r32, null);
        goto L102
    L101:
        r2 = lp5.a.e(r31, null);
        goto L102
    L92:
        if (r14.isSelected() == true) goto L94;
        r12.getView(2131365627).setEnabled(false);
        goto L94
    L86:
        if (TextUtils.equals(r28, this.d) == false) goto L88;
        r29.setVisibility(0);
    L63:
        r20 = false;
    L65:
        Log.i(r11, "setSearchTipsStatus: hide search tips");
        r17 = false;
        goto L66
    L51:
        if (r15.intValue() != r16) goto L53;
        r17 = true;
        goto L55
    L36:
        if (r14.isSelected() == false) goto L46;
        String r40 = r14.getTips();
        if (r40 != null) goto L40;
    L43:
        boolean r41 = true;
    L44:
        if (r41 == true) goto L46;
        r10 = true;
        goto L47
    L40:
        if (r40.length() == 0) goto L43;
        r41 = false;
        goto L44
    L22:
        if (r14.isSelected() == false) goto L32;
        String r42 = r14.getTips();
        if (r42 != null) goto L26;
    L29:
        boolean r43 = true;
    L30:
        if (r43 == true) goto L32;
        r8 = true;
        goto L33
    L26:
        if (r42.length() == 0) goto L29;
        r43 = false;
    L18:
        r6 = false;
    L13:
        r4 = false;
        goto L14
    L9:
        r1 = false;
        goto L10
    L5:
        r3 = false;
        goto L7
    }
}
