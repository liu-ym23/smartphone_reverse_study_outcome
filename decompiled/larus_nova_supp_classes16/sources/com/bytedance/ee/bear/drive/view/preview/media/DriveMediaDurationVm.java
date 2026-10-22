package com.bytedance.ee.bear.drive.view.preview.media;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000fR'\u0010\u0004\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/media/DriveMediaDurationVm;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "extraData", "Landroidx/lifecycle/MutableLiveData;", "", "", "", "getExtraData", "()Landroidx/lifecycle/MutableLiveData;", "setExtraData", "", "key", "value", "(Ljava/lang/String;Ljava/lang/Long;)V", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMediaDurationVm extends ViewModel {
    private final MutableLiveData<Map<String, Long>> extraData;

    public DriveMediaDurationVm() {
        this.extraData = new MutableLiveData();
    }

    public final MutableLiveData<Map<String, Long>> getExtraData() {
        return this.extraData;
    }

    public final void setExtraData(String r4, Long r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        MutableLiveData<Map<String, Long>> r0 = this.extraData;
        Intrinsics.checkNotNull(r0);
        Map r1 = (Map) r0.getValue();
        if (r1 != null) goto L5;
        r1 = new HashMap();
    L5:
        if (r5 == null) goto L7;
        long r2 = r5.longValue();
    L8:
        r1.put(r4, Long.valueOf(r2));
        this.extraData.setValue(r1);
        return;
    L7:
        r2 = 0;
        goto L8
    }
}
