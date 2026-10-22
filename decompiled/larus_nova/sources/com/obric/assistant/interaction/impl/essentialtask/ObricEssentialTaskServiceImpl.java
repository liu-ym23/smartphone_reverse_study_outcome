package com.obric.assistant.interaction.impl.essentialtask;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.obric.assistant.interaction.api.essentialtask.IEssentialTaskServiceKt;
import com.obric.assistant.spi.essentialtask.IObricEssentialTaskService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/interaction/impl/essentialtask/ObricEssentialTaskServiceImpl;", "Lcom/obric/assistant/spi/essentialtask/IObricEssentialTaskService;", "<init>", "()V", "isEnabled", "", "preInit", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "init", "Landroid/app/Application;", "startExecute", "isExecuteSucceed", "doAfterExecuteSucceed", "action", "Ljava/lang/Runnable;", "showLoadingUI", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onLoadSucceed", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricEssentialTaskServiceImpl implements IObricEssentialTaskService {
    public ObricEssentialTaskServiceImpl() {
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public boolean isEnabled() {
        return true;
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public boolean isExecuteSucceed() {
        return IEssentialTaskServiceKt.getEssentialTaskServiceDelegate().isExecuteSucceed();
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public void startExecute() {
        IEssentialTaskServiceKt.getEssentialTaskServiceDelegate().startExecute();
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public void doAfterExecuteSucceed(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        IEssentialTaskServiceKt.getEssentialTaskServiceDelegate().doAfterExecuteSucceed(r100);
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public void init(Application r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IEssentialTaskServiceKt.getEssentialTaskServiceDelegate().init(r100);
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public void preInit(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        IEssentialTaskServiceKt.getEssentialTaskServiceDelegate().preInit(r100);
    }

    @Override // com.obric.assistant.spi.essentialtask.IObricEssentialTaskService
    public void showLoadingUI(FragmentManager r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "onLoadSucceed");
        IEssentialTaskServiceKt.getEssentialTaskServiceDelegate().showLoadingUI(r100, r101);
    }
}
