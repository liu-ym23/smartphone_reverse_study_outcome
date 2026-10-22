package xib;

import com.larksuite.component.universe_design.image.UDAvatar;
import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import com.ss.android.lark.forwardv3.recentforward.viewholder.RecentForwardViewHolder;
import com.ss.android.lark.forwardv3.utils.n;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends e<SearchShieldP2PChatInfo> {
    public g(RecentForwardAdapterV3.b r100, RecentForwardAdapterV3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r101, "onItemBusinessConsumeClickListener");
        super(r100, r101);
    }

    @Override // xib.e
    public final void b(SearchBaseInfo r100, RecentForwardViewHolder r101) {
        SearchShieldP2PChatInfo r102 = (SearchShieldP2PChatInfo) r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        Intrinsics.checkNotNullParameter(r101, "holder");
        UDAvatar r103 = r101.f425516b;
        if (r103 == null) goto L6;
        int r104 = n.f425590a;
        n.b(r103.getContext(), r103, r102.getAvatarKey(), r102.getChatterId(), y9c.d.b(r103.getContext(), 48.0f), y9c.d.b(r103.getContext(), 48.0f));
        return;
    }
}
