package com.bytedance.bdturing.ttnet;

import android.content.Context;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedInput;
import ec4.b;
import ec4.d;
import ec4.h;
import ec4.i;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TTNetHttpClient implements b {
    private Context context;

    public TTNetHttpClient(Context r100) {
        this.context = r100;
    }

    @Override // ec4.b
    public byte[] get(String r100, Map<String, String> r101) {
        i.a(this.context, r100, r101);
        List<Header> r102 = h.c(r101);
        SsResponse<TypedInput> r103 = h.b(r100).doGet(true, r100, null, r102).execute();     // Catch: Exception -> L13
        if (r103.code() != 200) goto L12;
        InputStream r104 = r103.body().in();     // Catch: Exception -> L13
        ByteArrayOutputStream r105 = new ByteArrayOutputStream();     // Catch: Exception -> L13
        byte[] r106 = new byte[1024];     // Catch: Exception -> L13
    L6:
        int r107 = r104.read(r106);     // Catch: Exception -> L13
        if (r107 == (-1)) goto L9;
        r105.write(r106, 0, r107);     // Catch: Exception -> L13
        goto L6
    L9:
        return r105.toByteArray();
    L12:
        return new byte[0];
    }

    @Override // ec4.b
    public byte[] post(String r100, Map<String, String> r101, byte[] r102) {
        i.a(this.context, r100, r101);
        List<Header> r103 = h.c(r101);
        SsResponse<TypedInput> r104 = h.b(r100).doPost(r100, null, new d(r102), r103).execute();     // Catch: Exception -> L13
        if (r104.code() != 200) goto L12;
        InputStream r105 = r104.body().in();     // Catch: Exception -> L13
        ByteArrayOutputStream r106 = new ByteArrayOutputStream();     // Catch: Exception -> L13
        byte[] r107 = new byte[1024];     // Catch: Exception -> L13
    L6:
        int r108 = r105.read(r107);     // Catch: Exception -> L13
        if (r108 == (-1)) goto L9;
        r106.write(r107, 0, r108);     // Catch: Exception -> L13
        goto L6
    L9:
        return r106.toByteArray();
    L12:
        return new byte[0];
    }
}
