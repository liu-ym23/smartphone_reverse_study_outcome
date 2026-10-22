package mv6;

import com.bytedance.android.livesdkapi.message._CommonMessageData_ProtoDecoder;
import com.bytedance.locallife.live.message.LiveLocalLifeMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements am3.c<LiveLocalLifeMessage> {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // am3.c
    public final LiveLocalLifeMessage decode(am3.g r100) {
        Intrinsics.checkNotNullParameter(r100, "reader");
        Intrinsics.checkNotNullParameter(r100, "reader");
        LiveLocalLifeMessage r101 = new LiveLocalLifeMessage();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L8;
        r101.baseMessage = _CommonMessageData_ProtoDecoder.decodeStatic(r100);
        goto L3
    L8:
        if (r103 != 2) goto L10;
        r101.setType(r100.i());
        goto L3
    L10:
        if (r103 != 3) goto L11;
        r101.setBody(am3.h.c(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r102);
        return r101;
    }
}
