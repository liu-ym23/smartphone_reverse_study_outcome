package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.ActionMode;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.share.export.ShareMemberGroupType;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.component.universe_design.image.UDTextAvatar;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u000bR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/accessconfig/BitableDefaultMemberAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "data", "", "<init>", "(Ljava/util/List;)V", "mCustomActionMode", "Landroid/view/ActionMode;", "convert", "", "helper", MapController.ITEM_LAYER_TAG, "updateLinkItem", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultMemberLinkInfo;", "updateUserItem", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "updateExtraItem", "Lcom/bytedance/ee/bear/bitable/pro/accessconfig/DefaultMemberExtraInfo;", "createCustomMenu", "view", "Landroid/view/View;", "destroyCustomMenu", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableDefaultMemberAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f215110b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActionMode f215111a;

    public static final class a {
    }

    static {
    }

    public BitableDefaultMemberAdapter(List<? extends MultiItemEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        super(r100);
        addItemType(0, R.layout.bitable_pro_default_member_link_item);
        addItemType(ShareMemberGroupType.GROUP_MEMBER.getType(), R.layout.bitable_pro_default_member_user_item);
        addItemType(2, R.layout.bitable_pro_default_member_extra_item);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, Object r101) {
        MultiItemEntity r102 = (MultiItemEntity) r101;
        Intrinsics.checkNotNullParameter(r100, "helper");
        int r103 = r100.getItemViewType();
        DefaultMemberExtraInfo r104 = null;
        DefaultMemberLinkInfo r105 = null;
        UserInfo r106 = null;
        if (r103 != 0) goto L10;
        if ((r102 instanceof DefaultMemberLinkInfo) == false) goto L7;
        r105 = (DefaultMemberLinkInfo) r102;
    L7:
        if (r105 == null) goto L28;
        AppCompatImageView r107 = (AppCompatImageView) r100.getView(R.id.link_icon);
        r100.itemView.setOnLongClickListener(new b(this));
        r107.setImageDrawable(UDIconUtils.getIconDrawable(this.mContext, r105.getLinkResId(), this.mContext.getResources().getColor(R.color.static_white), new UDDimension.Dp(14)));
        return;
    L28:
        return;
    L10:
        if (r103 != ShareMemberGroupType.GROUP_MEMBER.getType()) goto L17;
        if ((r102 instanceof UserInfo) == false) goto L14;
        r106 = (UserInfo) r102;
    L14:
        if (r106 == null) goto L30;
        UDAvatar r108 = (UDAvatar) r100.getView(R.id.user_icon);
        r108.setOnClickListener(new c(r106, r106));
        pg5.a.b(r108, r106);
        return;
    L30:
        return;
    L17:
        if (r103 == 2) goto L19;
        return;
    L19:
        if ((r102 instanceof DefaultMemberExtraInfo) == false) goto L21;
        r104 = (DefaultMemberExtraInfo) r102;
    L21:
        if (r104 == null) goto L33;
        UDTextAvatar r109 = (UDTextAvatar) r100.getView(R.id.extra_icon);
        int r110 = 999;
        if (r104.getExtraMemberNumber() > 999) goto L26;
        r110 = r104.getExtraMemberNumber();
    L26:
        r109.setAvatarText(Marker.ANY_NON_NULL_MARKER + r110);
        return;
    }
}
