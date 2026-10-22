package vr1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public interface t {
    String a(Context r100, String r101);

    com.bytedance.android.livesdk.chatroom.ui.record.e c(Activity r100, String r101);

    void d(ILiveRecordService.RecordStatus r100, DataCenter r101);

    boolean f(DataCenter r100);

    Intent getRecordPermissionIntent();

    boolean isRecording(DataCenter r100);

    void saveRecordPermissionIntent(Intent r100);

    void setClearScreen(boolean r100);
}
