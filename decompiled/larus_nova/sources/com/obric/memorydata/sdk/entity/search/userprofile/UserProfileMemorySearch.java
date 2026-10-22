package com.obric.memorydata.sdk.entity.search.userprofile;

import android.content.Context;
import android.os.Bundle;
import com.obric.memorydata.sdk.MemoryResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pka.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/userprofile/UserProfileMemorySearch;", "", "<init>", "()V", "queryUserProfileMemory", "Lcom/obric/memorydata/sdk/entity/search/userprofile/UserProfileMemoryResult;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "profileKey", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UserProfileMemorySearch {
    public static final UserProfileMemorySearch INSTANCE = null;

    static {
        INSTANCE = new UserProfileMemorySearch();
    }

    private UserProfileMemorySearch() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UserProfileMemoryResult queryUserProfileMemory(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "profileKey");
        a.f529681a.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "profileKey");
        Bundle r102 = new Bundle();
        r102.putString("profileKey", r101);
        MemoryResponse r103 = a.c(r100, "queryUserProfileMemory", r102);
        UserProfileMemoryResult r104 = (UserProfileMemoryResult) r103.f397053c;
        if (r103.f397051a != 0) goto L7;
        if (r104 == null) goto L7;
        return r104;
    L7:
        return new UserProfileMemoryResult(r103.f397051a, r103.f397052b, null);
    }
}
