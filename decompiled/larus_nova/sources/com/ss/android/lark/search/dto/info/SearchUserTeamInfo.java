package com.ss.android.lark.search.dto.info;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchUserTeamInfo;", "Lcom/ss/android/lark/search/dto/info/SearchChatterInfo;", "<init>", "()V", "originChatterId", "", "getOriginChatterId", "()Ljava/lang/String;", "setOriginChatterId", "(Ljava/lang/String;)V", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchUserTeamInfo extends SearchChatterInfo {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private String originChatterId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public SearchUserTeamInfo() {
        this.originChatterId = "";
    }

    public final String getOriginChatterId() {
        return this.originChatterId;
    }

    public final void setOriginChatterId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originChatterId = r100;
    }
}
