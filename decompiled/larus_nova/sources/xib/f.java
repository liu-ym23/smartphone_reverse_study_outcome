package xib;

import com.larksuite.component.universe_design.image.UDAvatar;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.recentforward.viewholder.RecentForwardViewHolder;
import com.ss.android.lark.forwardv3.utils.n;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends e<SearchChatInfo> {
    public f(RecentForwardAdapterV3.b r100, RecentForwardAdapterV3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r101, "onItemBusinessConsumeClickListener");
        super(r100, r101);
    }

    @Override // xib.e
    public final void b(SearchBaseInfo r100, RecentForwardViewHolder r101) {
        SearchChatInfo r102 = (SearchChatInfo) r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "holder");
        UDAvatar r103 = r101.f425516b;
        if (r103 == null) goto L7;
        int r104 = n.f425590a;
        if (n.d(r102, r103) == false) goto L7;
        return;
    L7:
        if (r103 == null) goto L10;
        int r105 = n.f425590a;
        n.b(r103.getContext(), r103, r102.getAvatarKey(), r102.getId(), UIUtils.dp2px(r103.getContext(), 48.0f), UIUtils.dp2px(r103.getContext(), 48.0f));
        return;
    }
}
