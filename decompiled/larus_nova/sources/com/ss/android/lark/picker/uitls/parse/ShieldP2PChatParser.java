package com.ss.android.lark.picker.uitls.parse;

import com.bytedance.lark.pb.feed.v1.ForwardCommonData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchShieldP2PChatInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/picker/uitls/parse/ShieldP2PChatParser;", "Lcom/ss/android/lark/picker/uitls/parse/IParse;", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData$ShieldP2PChatInfo;", "<init>", "()V", "parse", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "commonData", "Lcom/bytedance/lark/pb/feed/v1/ForwardCommonData;", "info", "Companion", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShieldP2PChatParser implements IParse<ForwardCommonData.ShieldP2PChatInfo> {
    private static final Companion Companion = null;
    private static final String TAG = "ShieldP2PChatParser";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/picker/uitls/parse/ShieldP2PChatParser$Companion;", "", "<init>", "()V", "TAG", "", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public ShieldP2PChatParser() {
    }

    /* JADX INFO: renamed from: parse, reason: avoid collision after fix types in other method */
    public SearchBaseInfo parse2(ForwardCommonData r100, ForwardCommonData.ShieldP2PChatInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "commonData");
        if (r101 != null) goto L5;
        Log.e(TAG, "ForwardCommonData id is: " + r100.f253625id + ", ForwardCommonData type is: " + r100.item_type);
        Unit r102 = Unit.INSTANCE;
    L5:
        if (r101 == null) goto L18;
        SearchShieldP2PChatInfo r103 = (SearchShieldP2PChatInfo) IParseKt.addCommonParams(new SearchShieldP2PChatInfo(), r100);
        Long r104 = r100.chat_id;
        String r105 = "";
        if (r104 == null) goto L10;
        String r106 = r104.toString();
        if (r106 == null) goto L10;
    L11:
        r103.setId(r106);
        r103.setType(SearchCommonConstants.SearchResultType.SHIELD_P2P_CHAT);
        Long r107 = r101.chatter_id;
        if (r107 == null) goto L17;
        String r108 = r107.toString();
        if (r108 == null) goto L17;
        r105 = r108;
    L17:
        r103.setChatterId(r105);
        return r103;
    L10:
        r106 = "";
        goto L11
    L18:
        return null;
    }

    @Override // com.ss.android.lark.picker.uitls.parse.IParse
    public /* bridge */ /* synthetic */ SearchBaseInfo parse(ForwardCommonData r100, ForwardCommonData.ShieldP2PChatInfo r101) {
        return parse2(r100, r101);
    }
}
