package com.larus.doc.impl.viewmodel;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/doc/impl/viewmodel/DocDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "hasReportLoadEvent", "", "getHasReportLoadEvent", "()Z", "setHasReportLoadEvent", "(Z)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocDetailViewModel extends ViewModel {
    private boolean hasReportLoadEvent;

    public DocDetailViewModel() {
    }

    public final boolean getHasReportLoadEvent() {
        return this.hasReportLoadEvent;
    }

    public final void setHasReportLoadEvent(boolean r100) {
        this.hasReportLoadEvent = r100;
    }
}
