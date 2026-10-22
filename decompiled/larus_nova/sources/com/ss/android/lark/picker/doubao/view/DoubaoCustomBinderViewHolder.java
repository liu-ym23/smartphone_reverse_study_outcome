package com.ss.android.lark.picker.doubao.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.nova.R;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.PickerRecentSpaceInfo;
import com.ss.android.lark.picker.base.utils.SearchCommonUtils;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obb.b;
import sbb.c;
import tz7.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0010\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010(H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010$\u001a\u00020%H\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010 \u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00060"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/DoubaoCustomBinderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "ivAvatar", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "getIvAvatar", "()Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "tvSubtitle", "getTvSubtitle", "ivDoubaoCheckbox", "Landroid/widget/ImageView;", "getIvDoubaoCheckbox", "()Landroid/widget/ImageView;", "checkboxContainer", "getCheckboxContainer", "()Landroid/view/View;", "docCoverPaddingPx", "", "getDocCoverPaddingPx", "()I", "docCoverPaddingPx$delegate", "Lkotlin/Lazy;", "coverSizePx", "getCoverSizePx", "coverSizePx$delegate", "highlightColor", "getHighlightColor", "bindTitle", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "bindSummary", "getSpaceInfo", "Lcom/ss/android/lark/search/dto/info/SearchSpaceInfo;", "bindAvatar", "bindDocAvatar", "bindCoverAvatar", "spaceInfo", "isPic", "", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoCustomBinderViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = null;
    public static final String TAG = "DoubaoCustomBinderViewHolder";
    private final View checkboxContainer;
    private final Lazy coverSizePx$delegate;
    private final Lazy docCoverPaddingPx$delegate;
    private final int highlightColor;
    private final LarkAvatarView ivAvatar;
    private final ImageView ivDoubaoCheckbox;
    private final TextView tvSubtitle;
    private final TextView tvTitle;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/doubao/view/DoubaoCustomBinderViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final int getCoverSizePx() {
        return ((Number) this.coverSizePx$delegate.getValue()).intValue();
    }

    private final int getDocCoverPaddingPx() {
        return ((Number) this.docCoverPaddingPx$delegate.getValue()).intValue();
    }

    public final View getCheckboxContainer() {
        return this.checkboxContainer;
    }

    public final int getHighlightColor() {
        return this.highlightColor;
    }

    public final LarkAvatarView getIvAvatar() {
        return this.ivAvatar;
    }

    public final ImageView getIvDoubaoCheckbox() {
        return this.ivDoubaoCheckbox;
    }

    public final TextView getTvSubtitle() {
        return this.tvSubtitle;
    }

    public final TextView getTvTitle() {
        return this.tvTitle;
    }

    public DoubaoCustomBinderViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.ivAvatar = (LarkAvatarView) r100.findViewById(R.id.iv_avatar);
        this.tvTitle = (TextView) r100.findViewById(R.id.tv_title);
        this.tvSubtitle = (TextView) r100.findViewById(R.id.tv_subtitle);
        this.ivDoubaoCheckbox = (ImageView) r100.findViewById(R.id.iv_doubao_checkbox);
        this.checkboxContainer = r100.findViewById(R.id.checkbox_container);
        this.docCoverPaddingPx$delegate = LazyKt.lazy(DoubaoCustomBinderViewHolder$docCoverPaddingPx$2.INSTANCE);
        this.coverSizePx$delegate = LazyKt.lazy(DoubaoCustomBinderViewHolder$coverSizePx$2.INSTANCE);
        this.highlightColor = ContextCompat.getColor(this.itemView.getContext(), R.color.primary_fill_default);
    }

    private final void bindCoverAvatar(SearchSpaceInfo r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        this.ivAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ivAvatar.setPadding(getDocCoverPaddingPx(), getDocCoverPaddingPx(), getDocCoverPaddingPx(), getDocCoverPaddingPx());
        boolean r100 = false;
        this.ivAvatar.setOval(false);
        c r101 = c.f541290a;
        String r102 = r110.getDocUrl();
        r101.getClass();
        b r103 = c.c(c.e(r102), r110.getIconInfo());
        if (r103 == null) goto L7;
        String r104 = r103.f522638b;
    L8:
        String r105 = r104;
        if (r105 != null) goto L11;
    L12:
        r100 = true;
    L13:
        if (r100 == false) goto L16;
        bindDocAvatar(r110);
        return;
    L16:
        PickerBaseModuleDependency.getDependency().loadDocCover(this.ivAvatar.getContext(), this.ivAvatar, r105, getCoverSizePx(), getCoverSizePx(), "near", 4);
        return;
    L11:
        if (r105.length() != 0) goto L13;
    L7:
        r104 = null;
        goto L8
    }

    private final void bindDocAvatar(SearchBaseInfo r100) {
        SearchSpaceInfo r101 = getSpaceInfo(r100);
        a.C7809a r102 = new a.C7809a();
        if (r101 == null) goto L5;
        String r103 = r101.getDocUrl();
    L6:
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        Intrinsics.checkNotNullParameter(r103, "url");
        r102.f548073k = r103;
        IconShape r105 = IconShape.SQUARE;
        Intrinsics.checkNotNullParameter(r105, "shape");
        r102.f548075m = r105;
        if (r101 != null) goto L12;
    L24:
        a r106 = new a(r102);
        this.ivAvatar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.ivAvatar.setOval(false);
        this.ivAvatar.j(r106);
        return;
    L12:
        if (r101.getDocType() != Doc.Type.SHORTCUT) goto L14;
        boolean r107 = true;
    L15:
        Boolean r108 = Boolean.valueOf(r107);
        if (r108.booleanValue() == true) goto L19;
        r108 = null;
    L19:
        obb.a r109 = new obb.a(r108, r101.getIsShareFolder(), null);
        Intrinsics.checkNotNullParameter(r109, KtvSubElement.CONTAINER);
        r102.f548076n = r109;
        String r110 = r101.getIconInfo();
        if (r110 == null) goto L23;
        r104 = r110;
    L23:
        Intrinsics.checkNotNullParameter(r104, "meta");
        r102.f548074l = r104;
        goto L24
    L14:
        r107 = false;
        goto L15
    L5:
        r103 = null;
        goto L6
    }

    private final SearchSpaceInfo getSpaceInfo(SearchBaseInfo r100) {
        if ((r100 instanceof SearchWikiInfo) == false) goto L6;
        return ((SearchWikiInfo) r100).getSpaceInfo();
    L6:
        if ((r100 instanceof SearchSpaceInfo) == true) goto L11;
        return null;
    L11:
        return (SearchSpaceInfo) r100;
    }

    private final boolean isPic(SearchBaseInfo r100) {
        String r101 = null;
        if ((r100 instanceof SearchWikiInfo) == false) goto L8;
        SearchSpaceInfo r102 = ((SearchWikiInfo) r100).getSpaceInfo();
        if (r102 == null) goto L10;
        String r103 = r102.getIconInfo();
    L11:
        c.f541290a.getClass();
        b r104 = c.c(null, r103);
        PickerBaseModuleDependency.IPickerCommonModuleDependency r105 = PickerBaseModuleDependency.getDependency();
        if (r104 == null) goto L15;
        r101 = r104.f522639c;
    L15:
        return r105.isSupportDocCover(r101);
    L10:
        r103 = null;
        goto L11
    L8:
        if ((r100 instanceof SearchSpaceInfo) == false) goto L10;
        r103 = ((SearchSpaceInfo) r100).getIconInfo();
        goto L11
    }

    public final void bindAvatar(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (isPic(r100) == false) goto L6;
        bindCoverAvatar(getSpaceInfo(r100));
        return;
    L6:
        bindDocAvatar(r100);
    }

    public final void bindSummary(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        SearchSpaceInfo r101 = getSpaceInfo(r100);
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof PickerRecentSpaceInfo) == false) goto L8;
        int r102 = R.string.LarkCCM_NewCM_LastVisitedTime_Description;
    L9:
        String r103 = UIHelper.mustacheFormat(r102, "time", SearchCommonUtils.getSearchResultTimeForLong(this.itemView.getContext(), r101.getUpdateTime(), true));
        TextUtils.TruncateAt r104 = TextUtils.TruncateAt.END;
        int r105 = this.itemView.getContext().getResources().getColor(R.color.text_placeholder);
        this.tvSubtitle.setTextColor(r105);
        PickerBaseModuleDependency.getDependency().bindHighLightTitle(this.tvSubtitle, r103, null, this.highlightColor);
        return;
    L8:
        r102 = R.string.LarkCCM_NewCM_LastModifiedTime_Description;
        goto L9
    }

    public final void bindTitle(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if ((r100 instanceof SearchWikiInfo) == false) goto L9;
        SearchWikiInfo r101 = (SearchWikiInfo) r100;
        SearchSpaceInfo r102 = r101.getSpaceInfo();
        if (r102 == null) goto L8;
        String r103 = r102.getTitle();
        if (r103 == null) goto L8;
    L10:
        PickerBaseModuleDependency.getDependency().bindHighLightTitle(this.tvTitle, r103, r100.getTitleTagList(), this.highlightColor);
        return;
    L8:
        r103 = r101.getTitle();
        goto L10
    L9:
        r103 = r100.getTitle();
        goto L10
    }
}
