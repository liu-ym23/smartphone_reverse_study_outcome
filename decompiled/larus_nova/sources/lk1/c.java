package lk1;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public interface c {

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    public static final a f509546i2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f509547a = null;

        public a() {
        }

        static {
            f509547a = new a();
        }

        @JvmStatic
        public static c a(DataCenter r100) {
            Intrinsics.checkNotNullParameter(r100, "dataCenter");
            IRoomContextService r101 = (IRoomContextService) k.f(IRoomContextService.class);
            Object r102 = null;
            if (r101 == null) goto L7;
            t r103 = IRoomContextService.a.c(r101, r100, 2);
            if (r103 == null) goto L7;
            ViewModel r104 = r103.d();
        L9:
            if ((r104 instanceof c) == false) goto L12;
            r102 = r104;
        L12:
            c r105 = (c) r102;
            if (r105 == null) goto L15;
            return r105;
        L15:
            return new d();
        L7:
            r104 = null;
            goto L9
        }
    }

    static {
        f509546i2 = a.f509547a;
    }

    lk1.a addComponentRule(String r100, mk1.b r101);

    mk1.a getComponentStatus(String r100);

    mk1.a getComponentStatusByConfig(String r100, mk1.c r101);

    com.bytedance.android.live.core.arch.mvvm.d<mk1.a> observeStatusChanged(String r100);

    void updateComponentRule(String r100, mk1.b r101);
}
