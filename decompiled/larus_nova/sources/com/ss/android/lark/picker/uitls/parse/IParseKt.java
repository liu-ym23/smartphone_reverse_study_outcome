package com.ss.android.lark.picker.uitls.parse;

import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.larus.nova.R;
import com.ss.android.lark.parser.internal.a0;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"addCommonParams", "B", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "commonData", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData;", "(Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData;)Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "picker_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class IParseKt {
    public static final <B extends SearchBaseInfo> B addCommonParams(B r100, ForwardCommonData r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "commonData");
        r100.setId(r101.f253625id.toString());
        r100.setTitle(r101.title);
        r100.setTagData(a0.a(r101.tag_data));
        r100.setCrossTenant(r101.is_cross_tenant.booleanValue());
        r100.setCrossWithKa(r101.is_cross_with_ka.booleanValue());
        r100.setSubTitle(r101.subTitle);
        r100.setAvatarKey(r101.avatar_key);
        r100.setHeaderId(0);
        r100.setHeaderLabel(UIHelper.getString(R.string.Lark_IM_RecentVisit_Title));
        r100.setScene(Scene.Type.TRANSMIT_MESSAGES);
        return r100;
    }
}
