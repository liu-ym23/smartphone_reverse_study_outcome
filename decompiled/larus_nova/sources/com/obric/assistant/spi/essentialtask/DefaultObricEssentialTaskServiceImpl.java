package com.obric.assistant.spi.essentialtask;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import ec9.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/spi/essentialtask/DefaultObricEssentialTaskServiceImpl;", "Lcom/obric/assistant/spi/essentialtask/IObricEssentialTaskService;", "<init>", "()V", "isEnabled", "", "preInit", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "init", "Landroid/app/Application;", "startExecute", "isExecuteSucceed", "doAfterExecuteSucceed", "action", "Ljava/lang/Runnable;", "showLoadingUI", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onLoadSucceed", "Lkotlin/Function0;", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultObricEssentialTaskServiceImpl implements IObricEssentialTaskService {
    public DefaultObricEssentialTaskServiceImpl() {
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public final void init(Application r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public final boolean isEnabled() {
        return false;
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public final boolean isExecuteSucceed() {
        return true;
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public final void preInit(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public final void showLoadingUI(FragmentManager r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "onLoadSucceed");
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public final void startExecute() {
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public final void doAfterExecuteSucceed(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ((c) r100).run();
    }
}
