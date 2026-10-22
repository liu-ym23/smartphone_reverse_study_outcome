package hn1;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.detail.p;
import com.bytedance.android.livesdkapi.model.BackendGeneratedData;

/* JADX INFO: loaded from: classes7.dex */
public interface b {
    MutableLiveData<BackendGeneratedData> a();

    com.bytedance.android.livesdk.chatroom.detail.a b(long r100);

    void c(long r100);

    p d(long r100);

    void e(long r100);

    <T> void f(long r100, T r101, Class<T> r102);

    MutableLiveData<BackendGeneratedData> getPreEnterRoomBackendData(long r100);

    boolean preEnterRoom(long r100, Bundle r101);
}
