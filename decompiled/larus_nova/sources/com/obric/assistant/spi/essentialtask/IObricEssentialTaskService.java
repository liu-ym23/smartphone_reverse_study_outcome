package com.obric.assistant.spi.essentialtask;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/spi/essentialtask/IObricEssentialTaskService;", "", "isEnabled", "", "preInit", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "init", "Landroid/app/Application;", "startExecute", "isExecuteSucceed", "doAfterExecuteSucceed", "action", "Ljava/lang/Runnable;", "showLoadingUI", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onLoadSucceed", "Lkotlin/Function0;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricEssentialTaskService {
    void doAfterExecuteSucceed(Runnable r100);

    void init(Application r100);

    boolean isEnabled();

    boolean isExecuteSucceed();

    void preInit(Context r100);

    void showLoadingUI(FragmentManager r100, Function0<Unit> r101);

    void startExecute();
}
