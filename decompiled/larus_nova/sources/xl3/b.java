package xl3;

import android.content.Context;
import com.bytedance.android.tetrisinspectorsdk.Protocol;
import com.bytedance.android.tetrisinspectorsdk.TetrisDumpContentProvider;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.bytedance.android.androidadbbindings.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TetrisDumpContentProvider f564438a;

    public b(TetrisDumpContentProvider r100) {
        this.f564438a = r100;
    }

    @Override // com.bytedance.android.androidadbbindings.b
    public final void a(com.bytedance.android.androidadbbindings.a r100) {
        Context r101 = this.f564438a.getContext();
        if (r101 == null) goto L36;
        c r102 = new c(r100, r101);
        byte[] r103 = Protocol.PROTOCOL_VERSION.encode();
        byte[] r104 = a.a("2");
        ByteBuffer r105 = ByteBuffer.allocate(r103.length + r104.length);
        r105.put(r103);
        r105.put(r104);
        r100.write(r105.array());
        byte[] r106 = new byte[4];
        r100.read(r106);
        if (r106[0] == 79) goto L7;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == false) goto L28;
    L15:
        byte[] r108 = new byte[4];
        r102.f564439a.read(r108);
        Charset r109 = Charsets.UTF_8;
        byte[] r110 = new byte[CastIntegerProtector.parseInt(new String(r108, r109))];     // Catch: NumberFormatException -> L25
        r102.f564439a.read(r110);     // Catch: NumberFormatException -> L25
        String r111 = new String(r110, r109);     // Catch: NumberFormatException -> L25
        if (Intrinsics.areEqual(r111, Protocol.PROTOCOL_VERSION.getProtocol()) == true) goto L26;
        if (Intrinsics.areEqual(r111, Protocol.PROTOCOL_DUMP_VIEW.getProtocol()) == false) goto L23;
        r102.a();     // Catch: NumberFormatException -> L25
        goto L26
    L23:
        if (Intrinsics.areEqual(r111, Protocol.PROTOCOL_END.getProtocol()) == false) goto L26;
        boolean r112 = true;
    L27:
        if (r112 == false) goto L15;
    L26:
        r112 = false;
    L28:
        r102.f564439a.close();
        return;
    L7:
        if (r106[1] != 75) goto L13;
        if (r106[2] != 65) goto L13;
        if (r106[3] != 89) goto L13;
        r107 = true;
        goto L14
    }
}
