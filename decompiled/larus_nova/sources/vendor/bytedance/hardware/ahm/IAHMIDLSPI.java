package vendor.bytedance.hardware.ahm;

import android.os.IBinder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0005"}, d2 = {"Lvendor/bytedance/hardware/ahm/IAHMIDLSPI;", "Lvendor/bytedance/hardware/ahm/IAHMIDL;", "asBinder", "Landroid/os/IBinder;", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAHMIDLSPI extends IAHMIDL {
    public static final a Companion = null;
    public static final String TAG = "IAHMIDLSPI";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f554563a = null;

        static {
            f554563a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f554563a;
    }

    @Override // android.os.IInterface
    IBinder asBinder();
}
