package com.larus.live.api;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH&J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0001H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&¨\u0006\u001c"}, d2 = {"Lcom/larus/live/api/ILiveService;", "", "isLiveInit", "", "init", "Lkotlin/Result;", "", "init-d1pmJ48", "()Ljava/lang/Object;", "canHandleLiveSchema", "uri", "Landroid/net/Uri;", "handleLiveSchema", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createLiveRoomFragment", "Landroidx/fragment/app/Fragment;", "roomId", "", "bundle", "Landroid/os/Bundle;", "createLiveEntranceView", "Landroid/view/View;", "getAdditionalMethodFinder", "", "contextProviderFactory", "enableLiveSmartRouterOptimize", "enableLiveSaaSDeepLinkConfig", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ILiveService {
    boolean a();

    boolean b();

    boolean c(Context r100, Uri r101);

    List<Object> d(Object r100);

    boolean e();

    Object f();

    boolean g(Uri r100);
}
