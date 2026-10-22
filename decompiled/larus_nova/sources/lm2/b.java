package lm2;

import am3.g;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.message.model.o0;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.jvm.internal.Intrinsics;
import py.m;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends o0 implements h {

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f509861a;

        @Override // py.m
        public final int getIntTypeExt() {
            return -1;
        }

        @Override // py.m
        public final String getWsMethod() {
            return this.f509861a.baseMessage.method;
        }

        public a(b r100) {
            this.f509861a = r100;
        }
    }

    public b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        byte[] r101 = am3.h.b(r100);
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        g r102 = new g();
        r102.k(new am3.b(r101));
        long r103 = r102.c();
    L3:
        int r104 = r102.f();
        if (r104 == (-1)) goto L10;
        if (r104 == 1) goto L9;
        am3.h.e(r102);
        goto L3
    L9:
        setBaseMessage((m0) f.a(r102, m0.class));
    L10:
        r102.d(r103);
        setType(new a(this));
    }
}
