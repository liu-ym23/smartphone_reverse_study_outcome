package com.franmontiel.persistentcookiejar.persistence;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.UByte;
import okhttp3.g;

/* JADX INFO: loaded from: classes23.dex */
public class SerializableCookie implements Serializable {
    private static final long serialVersionUID = -8594045714036645534L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g f274230a;

    public SerializableCookie() {
    }

    static {
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        g.a r101 = new g.a();
        r101.c((String) r100.readObject());
        r101.e((String) r100.readObject());
        long r102 = r100.readLong();
        if (r102 == (-1)) goto L5;
        r101.b(r102);
    L5:
        String r103 = (String) r100.readObject();
        r101.a(r103, false);
        r101.d((String) r100.readObject());
        if (r100.readBoolean() == false) goto L9;
        r101.f523869f = true;
    L9:
        if (r100.readBoolean() == false) goto L12;
        r101.f523870g = true;
    L12:
        if (r100.readBoolean() == false) goto L14;
        r101.a(r103, true);
    L14:
        this.f274230a = new g(r101);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeObject(this.f274230a.f523855a);
        r100.writeObject(this.f274230a.f523856b);
        g r101 = this.f274230a;
        if (r101.f523862h == false) goto L5;
        long r102 = r101.f523857c;
    L6:
        r100.writeLong(r102);
        r100.writeObject(this.f274230a.f523858d);
        r100.writeObject(this.f274230a.f523859e);
        r100.writeBoolean(this.f274230a.f523860f);
        r100.writeBoolean(this.f274230a.f523861g);
        r100.writeBoolean(this.f274230a.f523863i);
        return;
    L5:
        r102 = -1;
        goto L6
    }

    public g decode(String r100) {
        int r101 = r100.length();
        byte[] r102 = new byte[r101 / 2];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103 / 2] = (byte) ((Character.digit(r100.charAt(r103), 16) << 4) + Character.digit(r100.charAt(r103 + 1), 16));
        r103 = r103 + 2;
        goto L3
    L5:
        ObjectInputStream r104 = null;
        g r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        ObjectInputStream r106 = new ObjectInputStream(new ByteArrayInputStream(r102));     // Catch: Throwable -> L12 ClassNotFoundException -> L16 IOException -> L19
    L33:
        r105 = ((SerializableCookie) r106.readObject()).f274230a;     // Catch: Throwable -> L10 ClassNotFoundException -> L25 IOException -> L26
    L29:
        r106.close();     // Catch: IOException -> L23
    L22:
        return r105;
    L10:
        th = th;
        r104 = r106;
    L13:
        if (r104 != null) goto L27;
    L15:
        throw th;
    L27:
        r104.close();     // Catch: IOException -> L24
    L20:
        if (r106 == null) goto L22;
    L17:
        if (r106 == null) goto L22;
    L19:
        r106 = null;
    L16:
        r106 = null;
    L12:
        th = th;
        goto L13
    }

    public String encode(g r100) {
        this.f274230a = r100;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        ObjectOutputStream r102 = null;
        ObjectOutputStream r103 = new ObjectOutputStream(r101);     // Catch: Throwable -> L16 IOException -> L20
    L36:
        r103.writeObject(this);     // Catch: Throwable -> L14 IOException -> L26
        r103.close();     // Catch: IOException -> L24
    L6:
        byte[] r104 = r101.toByteArray();
        StringBuilder r105 = new StringBuilder(r104.length * 2);
        int r106 = r104.length;
        int r107 = 0;
    L7:
        if (r107 >= r106) goto L13;
        int r108 = r104[r107] & UByte.MAX_VALUE;
        if (r108 >= 16) goto L11;
        r105.append('0');
    L11:
        r105.append(Integer.toHexString(r108));
        r107 = r107 + 1;
        goto L7
    L13:
        return r105.toString();
    L14:
        th = th;
        r102 = r103;
    L17:
        if (r102 != null) goto L28;
    L19:
        throw th;
    L28:
        r102.close();     // Catch: IOException -> L25
    L21:
        if (r103 != null) goto L32;
    L23:
        return null;
    L32:
        r103.close();     // Catch: IOException -> L27
    L20:
        r103 = null;
    L16:
        th = th;
        goto L17
    }
}
