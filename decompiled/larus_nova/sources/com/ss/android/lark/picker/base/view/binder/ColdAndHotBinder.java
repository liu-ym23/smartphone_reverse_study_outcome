package com.ss.android.lark.picker.base.view.binder;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.view.ColdAndHotViewHolder;
import com.ss.android.lark.picker.base.view.CommonIconFrontTextView;
import com.ss.android.lark.search.dto.info.SearchColdAndHotInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import v3c.g;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ColdAndHotBinder;", "Lcom/ss/android/lark/picker/base/view/binder/IViewBinder;", "mContext", "Landroid/content/Context;", "mOnItemClickHandler", "Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/search/dto/SearchItemInterface$IOnItemClickHandler;)V", "bind", "", "position", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchColdAndHotInfo;", "holder", "Lcom/ss/android/lark/picker/base/view/ColdAndHotViewHolder;", "resetView", "Companion", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColdAndHotBinder implements IViewBinder {
    public static final Companion Companion = null;
    private static final String TAG = "LarkSearch.Common.ColdAndHotBinder";
    private final Context mContext;
    private final g mOnItemClickHandler;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/base/view/binder/ColdAndHotBinder$Companion;", "", "<init>", "()V", "TAG", "", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static final /* synthetic */ g access$getMOnItemClickHandler$p(ColdAndHotBinder r100) {
        return r100.mOnItemClickHandler;
    }

    public final void resetView(ColdAndHotViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        ProgressBar r101 = r100.getProgressBar();
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        CommonIconFrontTextView r102 = r100.getIconFrontTextView();
        if (r102 == null) goto L9;
        r102.setVisibility(0);
        return;
    }

    public ColdAndHotBinder(Context r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mOnItemClickHandler");
        this.mContext = r100;
        this.mOnItemClickHandler = r101;
    }

    public final void bind(final int r100, final SearchColdAndHotInfo r101, ColdAndHotViewHolder r102) {
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "holder");
        resetView(r102);
        if (r101.getLoading() == false) goto L12;
        ProgressBar r103 = r102.getProgressBar();
        if (r103 == null) goto L7;
        r103.setVisibility(0);
    L7:
        CommonIconFrontTextView r104 = r102.getIconFrontTextView();
        if (r104 == null) goto L10;
        r104.setVisibility(8);
    L10:
        r102.getView().setOnClickListener(null);
        return;
    L12:
        int r105 = r101.getColdAndHotType();
        if (r105 != 2) goto L15;
        CommonIconFrontTextView r106 = r102.getIconFrontTextView();
        if (r106 == null) goto L26;
        Context r107 = this.mContext;
        r106.setCompoundDrawables(UDIconUtils.getIconDrawable(r107, R.drawable.ud_icon_down_expand_outlined, UDColorUtils.getColor(r107, R.color.primary_fill_default)), null, null, null);
        r106.setText(r106.getResources().getString(R.string.Lark_ASLSearch_SearchInChat_MsgTab_ViewMoreMsgFromOverAYearAgo));
        r106.setTextColor(UDColorUtils.getColor(this.mContext, R.color.primary_fill_default));
    L26:
        View.OnClickListener r108 = new ColdAndHotBinder$bind$clickListener$1(this, r101, r100);
        r102.getView().setOnClickListener(r108);
        return;
    L15:
        if (r105 == 3) goto L20;
        CommonIconFrontTextView r109 = r102.getIconFrontTextView();
        if (r109 == null) goto L28;
        r109.setVisibility(8);
        return;
    L28:
        return;
    L20:
        CommonIconFrontTextView r110 = r102.getIconFrontTextView();
        if (r110 == null) goto L26;
        r110.setCompoundDrawables(null, null, null, null);
        r110.setText(r110.getResources().getString(R.string.Lark_ASLSearch_ComprehensiveSearch_MsgTab_AllSearchResultsAreShown));
        r110.setTextColor(UDColorUtils.getColor(this.mContext, R.color.text_caption));
        goto L26
    }
}
