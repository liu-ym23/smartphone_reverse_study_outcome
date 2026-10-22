package com.ss.android.lark.forwardv3.configuration;

import com.ss.android.lark.forwardv3.RemoteOnForwardTargetCustomDisableListener;
import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/ss/android/lark/forwardv3/configuration/ForwardTargetConfig$setOnForwardTargetCustomDisableListener$1", "Lcom/ss/android/lark/forwardv3/RemoteOnForwardTargetCustomDisableListener$Stub;", "customDisable", "", PickerReporterConstants.KEY.TARGET, "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "customDisableToastText", "", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardTargetConfig$setOnForwardTargetCustomDisableListener$1 extends RemoteOnForwardTargetCustomDisableListener.Stub {
    final /* synthetic */ oib.e $listener;

    @Override // com.ss.android.lark.forwardv3.RemoteOnForwardTargetCustomDisableListener
    public String customDisableToastText() {
        return this.$listener.customDisableToastText();
    }

    public ForwardTargetConfig$setOnForwardTargetCustomDisableListener$1(oib.e r100) {
        this.$listener = r100;
    }

    @Override // com.ss.android.lark.forwardv3.RemoteOnForwardTargetCustomDisableListener
    public boolean customDisable(ForwardTargetBaseInfoNew r100) {
        return this.$listener.customDisable(r100);
    }
}
