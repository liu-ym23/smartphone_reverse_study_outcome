package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.ActionMode;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.share.export.ShareMemberGroupType;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.image.UDTextAvatar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u000bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/BitableDefaultMemberAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "data", "", "<init>", "(Ljava/util/List;)V", "mCustomActionMode", "Landroid/view/ActionMode;", "convert", "", "helper", "item", "updateLinkItem", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultMemberLinkInfo;", "updateUserItem", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "updateExtraItem", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultMemberExtraInfo;", "createCustomMenu", "view", "Landroid/view/View;", "destroyCustomMenu", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDefaultMemberAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final /* synthetic */ int b = 0;
    public ActionMode a;

    public static final class a {
    }

    static {
    }

    public BitableDefaultMemberAdapter(List<? extends MultiItemEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super(r2);
        addItemType(0, 2131559121);
        addItemType(ShareMemberGroupType.GROUP_MEMBER.getType(), 2131559122);
        addItemType(2, 2131559120);
    }

    public final void convert(BaseViewHolder r5, Object r6) {
        UserInfo r7 = (MultiItemEntity) r6;
        Intrinsics.checkNotNullParameter(r5, "helper");
        int r0 = r5.getItemViewType();
        UserInfo r1 = null;
        if (r0 != 0) goto L10;
        if ((r7 instanceof DefaultMemberLinkInfo) == false) goto L7;
        r1 = (DefaultMemberLinkInfo) r7;
    L7:
        if (r1 == null) goto L28;
        AppCompatImageView r8 = r5.getView(2131377990);
        ((RecyclerView.ViewHolder) r5).itemView.setOnLongClickListener(new b(this));
        r8.setImageDrawable(UDIconUtils.getIconDrawable(((BaseQuickAdapter) this).mContext, r1.getLinkResId(), ((BaseQuickAdapter) this).mContext.getResources().getColor(2131106521), new UDDimension.Dp(14)));
        return;
    L28:
        return;
    L10:
        if (r0 != ShareMemberGroupType.GROUP_MEMBER.getType()) goto L17;
        if ((r7 instanceof UserInfo) == false) goto L14;
        r1 = r7;
    L14:
        if (r1 == null) goto L30;
        UDAvatar r9 = r5.getView(2131392028);
        r9.setOnClickListener(new c(r1, r1));
        pg5.a.b(r9, r1);
        return;
    L30:
        return;
    L17:
        if (r0 == 2) goto L19;
        return;
    L19:
        if ((r7 instanceof DefaultMemberExtraInfo) == false) goto L21;
        r1 = (DefaultMemberExtraInfo) r7;
    L21:
        if (r1 == null) goto L33;
        UDTextAvatar r10 = r5.getView(2131372015);
        int r2 = 999;
        if (r1.getExtraMemberNumber() > 999) goto L26;
        r2 = r1.getExtraMemberNumber();
    L26:
        r10.setAvatarText("+" + r2);
        return;
    }
}
