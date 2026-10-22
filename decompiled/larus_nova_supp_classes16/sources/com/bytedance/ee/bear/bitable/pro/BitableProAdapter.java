package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.image.UDAvatarList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/BitableProAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/bitable/pro/Role;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "pageTrigger", "Lcom/bytedance/ee/bear/bitable/pro/IBitableProPageTrigger;", "<init>", "(Lcom/bytedance/ee/bear/bitable/pro/IBitableProPageTrigger;)V", "convert", "", "helper", "role", "AvatarListAdapter", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableProAdapter extends BaseQuickAdapter<Role, BaseViewHolder> {
    public static final /* synthetic */ int b = 0;
    public final i0 a;

    public static final class a extends UDAvatarList.AvatarAdapter<UserInfo> {
        public a() {
            super(-3, null, 2, null);
        }

        public final void onItemCreated(UDAvatar r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "avatar");
            UserInfo r4 = (UserInfo) getItem(r3);
            if (r4 == null) goto L6;
            pg5.a.b(r2, r4);
            return;
        }
    }

    public static final class b {
        public static String a(Context r10, Role r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "role");
            int r0 = r11.getCanEditTableCount();
            int r1 = r11.getCanReadTableCount();
            String r2 = r10.getString(2131887551);
            int r12 = r11.getCanReadDashboardCount();
            if (r12 <= 0) goto L5;
            String r13 = r10.getResources().getQuantityString(2131755010, r12, new Object[]{Integer.valueOf(r12)}) + r2;
        L7:
            if (r0 <= 0) goto L10;
            if (r1 <= 0) goto L10;
            String r14 = r10.getResources().getQuantityString(2131755008, r0, new Object[]{Integer.valueOf(r0)}) + r2 + r10.getResources().getQuantityString(2131755009, r1, new Object[]{Integer.valueOf(r1)});
        L16:
            return r13 + r14;
        L10:
            if (r0 <= 0) goto L12;
            r14 = r10.getResources().getQuantityString(2131755008, r0, new Object[]{Integer.valueOf(r0)});
            Intrinsics.checkNotNull(r14);
            goto L16
        L12:
            if (r1 <= 0) goto L14;
            r14 = r10.getResources().getQuantityString(2131755009, r1, new Object[]{Integer.valueOf(r1)});
            Intrinsics.checkNotNull(r14);
            goto L16
        L14:
            r14 = r10.getString(2131886167);
            Intrinsics.checkNotNull(r14);
            goto L16
        L5:
            r13 = "";
            goto L7
        }
    }

    static {
    }

    public BitableProAdapter(i0 r2) {
        super(2131559119);
        this.a = r2;
    }

    public static final /* synthetic */ Context y2(BitableProAdapter r0) {
        return ((BaseQuickAdapter) r0).mContext;
    }

    public final void convert(BaseViewHolder r17, Object r18) {
        Role r2 = (Role) r18;
        Intrinsics.checkNotNullParameter(r17, "helper");
        Intrinsics.checkNotNullParameter(r2, "role");
        int r5 = 2131102416;
        int r8 = 2131102418;
        int r10 = 2131106622;
        if (r2.isFaType() == false) goto L5;
        r17.setGone(2131379524, true);
        r17.setGone(2131384737, false).setGone(2131375591, false).setGone(2131379519, true).setGone(2131388335, false);
        r17.setText(2131384735, 2131886210);
    L30:
        if (r2.isFaType() == false) goto L32;
    L35:
        boolean r3 = true;
    L36:
        ImageView r11 = (ImageView) r17.getView(2131379518);
        if (r3 == false) goto L39;
        r8 = 2131102416;
    L39:
        com.bytedance.ee.util.ui.l.c(r11, r8);
        ImageView r12 = (ImageView) r17.getView(2131379517);
        if (r3 == true) goto L43;
        r5 = 2131102420;
    L43:
        com.bytedance.ee.util.ui.l.c(r12, r5);
        Resources r6 = ((RecyclerView.ViewHolder) r17).itemView.getResources();
        if (r3 == false) goto L46;
        r10 = 2131106610;
    L46:
        r17.setTextColor(2131379520, r6.getColor(r10));
        if (r2.getMembers().isEmpty() == false) goto L49;
        r17.setVisible(2131379517, true).setGone(2131379837, false);
    L54:
        ((RecyclerView.ViewHolder) r17).itemView.setOnClickListener(new com.bytedance.ee.bear.bitable.pro.b(r2, this));
        r17.getView(2131375591).setOnClickListener(new c(r2, this));
        return;
    L49:
        r17.setGone(2131379517, false).setVisible(2131379837, true);
        a r7 = new a();
        r7.setData(r2.getMembers());
        r17.getView(2131379837).setAdapter(r7);
        UDAvatarList r9 = r17.getView(2131379837);
        if (r3 == false) goto L52;
        float r4 = 0.3f;
    L53:
        r9.setAlpha(r4);
        goto L54
    L52:
        r4 = 1.0f;
        goto L53
    L32:
        if (r2.disableEditMembers() == true) goto L35;
        r3 = false;
        goto L36
    L5:
        r17.setGone(2131379524, false);
        if (r2.isTemplate() == false) goto L8;
        r17.setGone(2131375591, false).setGone(2131379519, false).setVisible(2131388335, true);
    L9:
        String r13 = b.a(((BaseQuickAdapter) this).mContext, r2);
        DefaultTagTitleView r14 = (DefaultTagTitleView) r17.getView(2131384737);
        r14.setTitle(r2.getName());
        boolean r16 = r2.isDefault();
        TextView r19 = r14.b;
        if (r16 == false) goto L12;
        int r110 = 0;
    L13:
        r19.setVisibility(r110);
        r14.b.setText(2131886142);
        if (r2.hasCostPerm() == false) goto L16;
        r14.b.setVisibility(0);
        r14.b.setText(2131886191);
        r14.setBackground(2131232355);
        r14.setTagTextColor(2131109130);
    L16:
        r17.setText(2131384735, r13);
        r17.getView(2131379519).setOnClickListener(new com.bytedance.ee.bear.bitable.pro.a(r2, this));
        ImageView r20 = (ImageView) r17.getView(2131375590);
        if (r2.disableAddMembers() == false) goto L19;
        int r111 = 2131102416;
    L20:
        com.bytedance.ee.util.ui.l.c(r20, r111);
        ImageView r21 = (ImageView) r17.getView(2131375589);
        if (r2.disableAddMembers() == false) goto L23;
        int r112 = 2131102416;
    L24:
        com.bytedance.ee.util.ui.l.c(r21, r112);
        Resources r22 = ((RecyclerView.ViewHolder) r17).itemView.getResources();
        if (r2.disableAddMembers() == false) goto L27;
        int r113 = 2131106610;
    L28:
        r17.setTextColor(2131375592, r22.getColor(r113));
        goto L30
    L27:
        r113 = 2131106622;
        goto L28
    L23:
        r112 = 2131102420;
        goto L24
    L19:
        r111 = 2131102418;
        goto L20
    L12:
        r110 = 8;
        goto L13
    L8:
        r17.setVisible(2131375591, true).setVisible(2131379519, true).setGone(2131388335, false);
        goto L9
    }
}
