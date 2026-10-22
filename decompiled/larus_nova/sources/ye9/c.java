package ye9;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.larus.im.internal.protocol.bean.DownlinkMessage;
import com.larus.im.internal.protocol.bean.UplinkMessage;
import juc.d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public interface c {

    public static final class a implements c {
        public a() {
        }

        @Override // ye9.c
        public final DownlinkMessage a(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            wt7.c r102 = wt7.a.f561230a;     // Catch: Throwable -> L5
            Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Throwable -> L5
            String r103 = StringsKt.decodeToString(r100);     // Catch: Throwable -> L5
            d<DownlinkMessage> r104 = DownlinkMessage.Companion.serializer();     // Catch: Throwable -> L5
            r102.getClass();     // Catch: Throwable -> L5
            Object r105 = Result.m9449constructorimpl((DownlinkMessage) wt7.c.a(r103, r104));     // Catch: Throwable -> L5
        L8:
            if (Result.m9455isFailureimpl(r105) == false) goto L11;
            r105 = null;
        L11:
            return (DownlinkMessage) r105;
        L5:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L8
        }

        @Override // ye9.c
        public final byte[] b(UplinkMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "struct");
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
            wt7.c r103 = wt7.a.f561230a;     // Catch: Throwable -> L9
            d<UplinkMessage> r104 = UplinkMessage.Companion.serializer();     // Catch: Throwable -> L9
            r103.getClass();     // Catch: Throwable -> L9
            String r105 = wt7.c.b(r100, r104);     // Catch: Throwable -> L9
            if (r105 == null) goto L6;
            Intrinsics.checkNotNullParameter(r105, "<this>");     // Catch: Throwable -> L9
            byte[] r106 = StringsKt.encodeToByteArray(r105);     // Catch: Throwable -> L9
        L7:
            Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L9
        L12:
            if (Result.m9455isFailureimpl(r107) == true) goto L16;
            r101 = r107;
        L16:
            return (byte[]) r101;
        L6:
            r106 = null;
        L9:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        }
    }

    DownlinkMessage a(byte[] r100);

    byte[] b(UplinkMessage r100);
}
