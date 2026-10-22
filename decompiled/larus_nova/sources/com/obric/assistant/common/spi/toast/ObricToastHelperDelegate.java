package com.obric.assistant.common.spi.toast;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001J\u0015\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¨\u0006\t"}, d2 = {"Lcom/obric/assistant/common/spi/toast/ObricToastHelperDelegate;", "Lcom/obric/assistant/common/spi/toast/IToastHelper;", "<init>", "()V", "createToastHolder", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "resolveContext", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricToastHelperDelegate implements IToastHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricToastHelperDelegate f387851b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IToastHelper f387852a;

    static {
        f387851b = new ObricToastHelperDelegate();
    }

    @Override // com.obric.assistant.common.spi.toast.IToastHelper
    public final Object createToastHolder(Context r100) {
        return this.f387852a.createToastHolder(r100);
    }

    @Override // com.obric.assistant.common.spi.toast.IToastHelper
    public final Context resolveContext(Context r100) {
        return this.f387852a.resolveContext(r100);
    }

    private ObricToastHelperDelegate() {
        IToastHelper r100 = (IToastHelper) ServiceManager.get().getService(IToastHelper.class);
        if (r100 != null) goto L5;
        r100 = new DefaultToastHelper();
    L5:
        this.f387852a = r100;
    }
}
