package pu;

import am3.g;
import am3.h;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import java.io.IOException;

/* JADX INFO: loaded from: classes44.dex */
public class b {

    @SerializedName(ContainerPosition.BODY)
    public byte[] body;

    @SerializedName("header")
    public a header;

    public b() {
    }

    public static b a(g r100) throws IOException {
        b r101 = new b();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L31;
        if (r103 != 1) goto L8;
        a r104 = new a();
        long r105 = r100.c();
    L12:
        int r106 = r100.f();
        if (r106 == (-1)) goto L22;
        switch(r106) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            default: goto L15;
        };
    L16:
        r104.f530697f = h.c(r100);
        goto L12
    L17:
        r104.f530696e = r100.j();
        goto L12
    L18:
        r104.f530695d = h.c(r100);
        goto L12
    L19:
        r104.f530694c = h.c(r100);
        goto L12
    L20:
        r104.f530693b = h.c(r100);
        goto L12
    L21:
        r104.f530692a = (int) r100.j();
        goto L12
    L15:
        h.e(r100);
        goto L12
    L22:
        r100.d(r105);
        if (r104.f530692a == (-1)) goto L30;
        if (r104.f530696e == (-1)) goto L28;
        r101.header = r104;
        goto L3
    L28:
        throw new IOException("Invalid protobuf data: missing header.now!");
    L30:
        throw new IOException("Invalid protobuf data: missing header.statusCode!");
    L8:
        if (r103 != 2) goto L9;
        r101.body = h.b(r100);
        goto L3
    L9:
        h.e(r100);
        goto L3
    L31:
        r100.d(r102);
        if (r101.header != null) goto L34;
        a r107 = new a();
        r101.header = r107;
        r107.f530696e = System.currentTimeMillis();
        r101.header.f530692a = 0;
    L34:
        return r101;
    }
}
