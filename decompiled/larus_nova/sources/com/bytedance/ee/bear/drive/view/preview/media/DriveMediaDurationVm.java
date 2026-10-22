package com.bytedance.ee.bear.drive.view.preview.media;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000fR'\u0010\u0004\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/media/DriveMediaDurationVm;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", ControlRule.KEY_EXTRA_DATA, "Landroidx/lifecycle/MutableLiveData;", "", "", "", "getExtraData", "()Landroidx/lifecycle/MutableLiveData;", "setExtraData", "", "key", "value", "(Ljava/lang/String;Ljava/lang/Long;)V", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMediaDurationVm extends ViewModel {
    private final MutableLiveData<Map<String, Long>> extraData;

    public DriveMediaDurationVm() {
        this.extraData = new MutableLiveData();
    }

    public final MutableLiveData<Map<String, Long>> getExtraData() {
        return this.extraData;
    }

    public final void setExtraData(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        MutableLiveData<Map<String, Long>> r102 = this.extraData;
        Intrinsics.checkNotNull(r102);
        Map<String, Long> r103 = r102.getValue();
        if (r103 != null) goto L5;
        r103 = new HashMap();
    L5:
        if (r101 == null) goto L7;
        long r104 = r101.longValue();
    L8:
        r103.put(r100, Long.valueOf(r104));
        this.extraData.setValue(r103);
        return;
    L7:
        r104 = 0;
        goto L8
    }
}
