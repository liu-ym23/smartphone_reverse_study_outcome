package com.larus.bmhome.share.api;

import android.content.Context;
import android.content.Intent;
import com.larus.bmhome.share.panel.b;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J_\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000fH&J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J\u001c\u0010\u0019\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/share/api/IShareRuntimeService;", "", "initShareRuntime", "", "share", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "shareChannel", "", "shareType", "shareContent", "Lcom/larus/bmhome/share/panel/FlowShareContent;", DyPayConstant.KEY_SHOW_LOADING, "", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "resultCode", "isInstalledChannel", "handleActivityResult", "requestCode", "intent", "Landroid/content/Intent;", "isChannelSupported", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IShareRuntimeService {
    boolean a(String r100);

    void b(int r100, int r101, Intent r102);

    void c();

    void d(Context r100, String r101, String r102, b r103, boolean r104, com.larus.share.impl.sdk.b r105);

    boolean e(String r100, String r101);
}
