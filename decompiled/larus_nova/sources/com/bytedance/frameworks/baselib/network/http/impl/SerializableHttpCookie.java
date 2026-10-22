package com.bytedance.frameworks.baselib.network.http.impl;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.cookie.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class SerializableHttpCookie implements Serializable {
    private static final long serialVersionUID = 6374381323722046734L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient f f244749a;

    public byte[] encode() {
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();
        new ObjectOutputStream(r100).writeObject(this);     // Catch: IOException -> L6
        return r100.toByteArray();
    L6:
        e = move-exception;
        Logger.e("SerializableHttpCookie", "encodeCookie failed", e);
        return null;
    }

    public int hashCode() {
        return this.f244749a.hashCode();
    }

    static {
    }

    public f getHttpCookie() {
        return this.f244749a;
    }

    public SerializableHttpCookie(f r100) {
        this.f244749a = r100;
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        f r101 = new f();
        this.f244749a = r101;
        r101.f244709h = (String) r100.readObject();
        f r102 = this.f244749a;
        r102.f244704c = r100.readLong();
        f r103 = this.f244749a;
        r103.f244708g = r100.readBoolean();
        this.f244749a.e((String) r100.readObject(), false);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeObject(this.f244749a.f244709h);
        r100.writeLong(this.f244749a.f244704c);
        r100.writeBoolean(this.f244749a.f244708g);
        r100.writeObject(this.f244749a.f244705d);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof f) == false) goto L7;
        return this.f244749a.equals(r100);
    L7:
        if ((r100 instanceof SerializableHttpCookie) == true) goto L9;
        return false;
    L9:
        return this.f244749a.equals(((SerializableHttpCookie) r100).f244749a);
    }

    public static SerializableHttpCookie decode(String r100, String r101, String r102, boolean r103, byte[] r104) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L13:
        return null;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L13;
        if (r104 == null) goto L13;
        SerializableHttpCookie r105 = (SerializableHttpCookie) new nx5.a(new ByteArrayInputStream(r104), new Class[]{SerializableHttpCookie.class}).readObject();     // Catch: Throwable -> L11
        r105.f244749a.f(r100, r103);     // Catch: Throwable -> L11
        f r106 = r105.f244749a;     // Catch: Throwable -> L11
        r106.f244707f = r101;     // Catch: Throwable -> L11
        r106.f244706e = r102;     // Catch: Throwable -> L11
        return r105;
    L11:
        th = move-exception;
        Logger.e("SerializableHttpCookie", "decodeCookie failed", th);
        goto L13
    }
}
