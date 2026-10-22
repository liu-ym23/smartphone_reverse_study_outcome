package vy0;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a<PARAMS> {

    /* JADX INFO: renamed from: vy0.a$a, reason: collision with other inner class name */
    public static final class C8050a extends a<Object> {
        public C8050a() {
            Intrinsics.checkNotNullParameter("revenue_gift_lynx", WsConstants.KEY_PAYLOAD);
            super(0);
        }
    }

    public static final class b extends a<Object> {
        public b() {
            Intrinsics.checkNotNullParameter("revenue_link_lynx", WsConstants.KEY_PAYLOAD);
            super(0);
        }
    }

    public static final class c extends a<Object> {
        public c() {
            Intrinsics.checkNotNullParameter("revenue_service_center", WsConstants.KEY_PAYLOAD);
            super(0);
        }
    }

    public a() {
        throw null;
    }

    public a(int r100) {
    }
}
