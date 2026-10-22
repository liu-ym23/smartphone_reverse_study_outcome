package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;

/* JADX INFO: loaded from: classes37.dex */
public interface a<Data, Error extends MmRecordingError> {
    void a(Error r100);

    void onSuccess(Data r100);
}
