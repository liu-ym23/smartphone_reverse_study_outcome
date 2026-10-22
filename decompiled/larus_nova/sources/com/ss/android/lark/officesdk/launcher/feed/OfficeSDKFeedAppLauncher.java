package com.ss.android.lark.officesdk.launcher.feed;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class OfficeSDKFeedAppLauncher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f433441a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/feed/OfficeSDKFeedAppLauncher$OfficeSdkFeedInitorEntryPoint;", "", "getOfficeSdkFeedInitor", "Lcom/ss/android/lark/officesdk/launcher/feed/IProcessFeedInitor;", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        b n();
    }

    public OfficeSDKFeedAppLauncher(final Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f433441a = LazyKt.lazy(new OfficeSDKFeedAppLauncher$initor$2(r100));
    }
}
