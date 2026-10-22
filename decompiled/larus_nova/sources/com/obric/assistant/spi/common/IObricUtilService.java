package com.obric.assistant.spi.common;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J \u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u000eH&J\b\u0010\u0015\u001a\u00020\u0007H&¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/spi/common/IObricUtilService;", "", "getLaunchMethod", "", "checkAsync", "", "isCheckPassed", "", "onUserActionBlocked", "showToastIfAppIsBackground", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "toast", "duration", "", "isImeLaunchedByApp", "viewGroup", "Landroid/view/ViewGroup;", "physicalScreenWidthPixels", "(Landroid/content/Context;)Ljava/lang/Integer;", "getPassportSdkVersion", "isDarkModeDefaultFollowSys", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricUtilService {
    String a();

    void b();

    boolean c();

    boolean d(Context r100, String r101);

    boolean e();

    int f();

    void g();

    Integer h(Context r100);
}
