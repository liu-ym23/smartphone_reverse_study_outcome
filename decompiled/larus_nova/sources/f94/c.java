package f94;

import com.bytedance.bdp.bdpbase.ipc.IpcException;
import com.bytedance.bdp.bdpbase.ipc.annotation.Event;
import com.bytedance.bdp.bdpbase.ipc.annotation.RemoteInterface;
import com.bytedance.bdp.bdpbase.ipc.annotation.SyncIpc;
import com.bytedance.bdp.bdpbase.ipc.r;

/* JADX INFO: loaded from: classes11.dex */
@RemoteInterface(implementClass = b.class)
public interface c extends r {
    @Event
    @SyncIpc
    String getDeviceId() throws IpcException;
}
