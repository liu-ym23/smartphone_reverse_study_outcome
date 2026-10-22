package com.bytedance.ee.bear.bitable.pro.member;

import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0002H\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/member/BitableRoleMemberAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "role", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "avatarClickListener", "Lkotlin/Function1;", "", "removeCickListener", "<init>", "(Lcom/bytedance/ee/bear/bitable/pro/Role;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getRole", "()Lcom/bytedance/ee/bear/bitable/pro/Role;", "getAvatarClickListener", "()Lkotlin/jvm/functions/Function1;", "getRemoveCickListener", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "locale$delegate", "Lkotlin/Lazy;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "getAccount", "()Lcom/bytedance/ee/bear/contract/AccountService$Account;", "account$delegate", "convert", "helper", MapController.ITEM_LAYER_TAG, "getRemoveTextColor", "", "isDefault", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRoleMemberAdapter extends BaseQuickAdapter<UserInfo, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Role f215187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<UserInfo, Unit> f215188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<UserInfo, Unit> f215189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f215190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f215191e;

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, UserInfo r101) {
        UserInfo r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "helper");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        UDAvatar r103 = (UDAvatar) r100.getView(R.id.avatar);
        SpaceTagTitleView r104 = (SpaceTagTitleView) r100.getView(R.id.memberName);
        TextView r105 = (TextView) r100.getView(R.id.memberLabel);
        TextView r106 = (TextView) r100.getView(R.id.removeTv);
        Intrinsics.checkNotNull(r103);
        pg5.a.b(r103, r102);
        r103.setOnClickListener(new a(r102, this));
        r104.setTitle(r102.getDisplayName((Locale) this.f215190d.getValue()));
        boolean r107 = true;
        int r108 = SpaceTagType.f240339e;
        String r109 = r102.getOrganizationTagValue();
        boolean r110 = r102.isExternal();
        int r111 = ui5.c.f550208a;
        SpaceTagType r112 = SpaceTagType.Companion.f(r109, r110, ui5.c.a((AccountService$Account) this.f215191e.getValue()));
        int r113 = 0;
        r104.setLabels(new SpaceTagType[]{r112});
        String r114 = r102.getDisplayLabel();
        if (r114 != null) goto L6;
        r114 = "";
    L6:
        if (r114.length() == 0) goto L9;
        r107 = false;
    L9:
        if (r107 == false) goto L11;
        r113 = 8;
    L11:
        r105.setVisibility(r113);
        r105.setText(r114);
        if (this.f215187a.isDefault() == false) goto L14;
        int r115 = this.mContext.getResources().getColor(R.color.text_disable);
    L15:
        r106.setTextColor(r115);
        r106.setOnClickListener(new b(this, r102));
        return;
    L14:
        r115 = this.mContext.getResources().getColor(R.color.text_title);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BitableRoleMemberAdapter(Role r100, Function1<? super UserInfo, Unit> r101, Function1<? super UserInfo, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "role");
        Intrinsics.checkNotNullParameter(r101, "avatarClickListener");
        Intrinsics.checkNotNullParameter(r102, "removeCickListener");
        super(R.layout.bitable_pro_role_member_manage_item, r100.getMembers());
        this.f215187a = r100;
        this.f215188b = r101;
        this.f215189c = r102;
        this.f215190d = LazyKt.lazy(BitableRoleMemberAdapter$locale$2.INSTANCE);
        this.f215191e = LazyKt.lazy(BitableRoleMemberAdapter$account$2.INSTANCE);
    }
}
