package com.bytedance.ee.bear.bitable.pro.member;

import android.widget.TextView;
import com.bytedance.ee.bear.bitable.pro.Role;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagType;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B7\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0002H\u0014J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/member/BitableRoleMemberAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "role", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "avatarClickListener", "Lkotlin/Function1;", "", "removeCickListener", "<init>", "(Lcom/bytedance/ee/bear/bitable/pro/Role;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getRole", "()Lcom/bytedance/ee/bear/bitable/pro/Role;", "getAvatarClickListener", "()Lkotlin/jvm/functions/Function1;", "getRemoveCickListener", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "locale$delegate", "Lkotlin/Lazy;", "account", "Lcom/bytedance/ee/bear/contract/AccountService$Account;", "getAccount", "()Lcom/bytedance/ee/bear/contract/AccountService$Account;", "account$delegate", "convert", "helper", "item", "getRemoveTextColor", "", "isDefault", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRoleMemberAdapter extends BaseQuickAdapter<UserInfo, BaseViewHolder> {
    public final Role a;
    public final Function1<UserInfo, Unit> b;
    public final Function1<UserInfo, Unit> c;
    public final Lazy d;
    public final Lazy e;

    public final void convert(BaseViewHolder r8, Object r9) {
        UserInfo r10 = (UserInfo) r9;
        Intrinsics.checkNotNullParameter(r8, "helper");
        Intrinsics.checkNotNullParameter(r10, "item");
        UDAvatar r0 = r8.getView(2131363623);
        SpaceTagTitleView r1 = r8.getView(2131379841);
        TextView r2 = (TextView) r8.getView(2131379838);
        TextView r11 = (TextView) r8.getView(2131384258);
        Intrinsics.checkNotNull(r0);
        pg5.a.b(r0, r10);
        r0.setOnClickListener(new a(r10, this));
        r1.setTitle(r10.getDisplayName((Locale) this.d.getValue()));
        boolean r3 = true;
        int r4 = SpaceTagType.e;
        String r5 = r10.getOrganizationTagValue();
        boolean r6 = r10.isExternal();
        int r7 = ui5.c.a;
        SpaceTagType r12 = SpaceTagType.Companion.f(r5, r6, ui5.c.a((AccountService$Account) this.e.getValue()));
        int r13 = 0;
        r1.setLabels(new SpaceTagType[]{r12});
        String r14 = r10.getDisplayLabel();
        if (r14 != null) goto L6;
        r14 = "";
    L6:
        if (r14.length() == 0) goto L9;
        r3 = false;
    L9:
        if (r3 == false) goto L11;
        r13 = 8;
    L11:
        r2.setVisibility(r13);
        r2.setText(r14);
        if (this.a.isDefault() == false) goto L14;
        int r16 = ((BaseQuickAdapter) this).mContext.getResources().getColor(2131106610);
    L15:
        r11.setTextColor(r16);
        r11.setOnClickListener(new b(this, r10));
        return;
    L14:
        r16 = ((BaseQuickAdapter) this).mContext.getResources().getColor(2131106622);
        goto L15
    }

    public BitableRoleMemberAdapter(Role r3, Function1<? super UserInfo, Unit> r4, Function1<? super UserInfo, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "role");
        Intrinsics.checkNotNullParameter(r4, "avatarClickListener");
        Intrinsics.checkNotNullParameter(r5, "removeCickListener");
        super(2131559126, r3.getMembers());
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = LazyKt.lazy(BitableRoleMemberAdapter$locale$2.INSTANCE);
        this.e = LazyKt.lazy(BitableRoleMemberAdapter$account$2.INSTANCE);
    }
}
