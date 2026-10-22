package com.ss.android.lark.search.dto.info;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchErrorInfoFooterInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lcom/ss/android/lark/search/dto/info/IFakeSearchUIInfo;", SocialConstants.PARAM_APP_DESC, "", WikiFolderPushPlugin.OPT, "opType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getDesc", "()Ljava/lang/String;", "getOperation", "getOpType", "()I", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchErrorInfoFooterInfo extends SearchBaseInfo implements a {
    private final String desc;
    private final int opType;
    private final String operation;

    public final String getDesc() {
        return this.desc;
    }

    public final int getOpType() {
        return this.opType;
    }

    public final String getOperation() {
        return this.operation;
    }

    public SearchErrorInfoFooterInfo(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        this.desc = r100;
        this.operation = r101;
        this.opType = r102;
    }
}
