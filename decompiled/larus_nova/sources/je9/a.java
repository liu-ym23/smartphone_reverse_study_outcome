package je9;

import com.google.protobuf.Message;
import com.google.protobuf.Message.Builder;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.internal.network.proto2.AvUplink;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a<Builder extends Message.Builder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Class<?>, c<?, Builder>> f498834a;

    /* JADX INFO: renamed from: je9.a$a, reason: collision with other inner class name */
    public static final class C6426a {
    }

    static {
    }

    public abstract AvUplink.UplinkMessage.Builder a();

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f498834a = new HashMap();
    }

    public final void b(Class r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "converter");
        this.f498834a.put(r100, r101);
    }
}
