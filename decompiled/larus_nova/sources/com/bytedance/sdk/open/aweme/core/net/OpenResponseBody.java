package com.bytedance.sdk.open.aweme.core.net;

import com.bytedance.sdk.open.aweme.utils.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class OpenResponseBody extends InputStream {
    private byte[] bytesBody;
    private boolean closed;
    private long contentLength;
    private String contentType;
    private boolean finished;
    private long readLength;
    private InputStream real;
    private String stringBody;

    public OpenResponseBody(String r100, long r101, InputStream r102) {
        this.finished = false;
        this.closed = false;
        this.readLength = 0;
        this.bytesBody = null;
        this.stringBody = null;
        this.contentLength = r101;
        this.contentType = r100;
        this.real = r102;
    }

    public synchronized byte[] bytes() {
        monitor-enter(this);
        byte[] r100 = this.bytesBody;     // Catch: Throwable -> L19
        if (r100 == null) goto L8;
        monitor-exit(this);
        return r100;
    L8:
        if (isClosed() == false) goto L24;
        byte[] r101 = new byte[0];     // Catch: Throwable -> L19
        monitor-exit(this);
        return r101;
    L24:
        this.bytesBody = IOUtils.toByteArray(this);     // Catch: Throwable -> L22
    L13:
        safeClose();     // Catch: Throwable -> L19
        if (this.bytesBody != null) goto L16;
        this.bytesBody = new byte[0];     // Catch: Throwable -> L19
    L16:
        byte[] r102 = this.bytesBody;     // Catch: Throwable -> L19
        monitor-exit(this);
        return r102;
    L19:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        this.real.close();
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public long getReadLength() {
        return this.readLength;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isReadFinished() {
        return this.finished;
    }

    public JSONObject jsonBody() {
        return new JSONObject(stringBody());
    L4:
        return null;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int r100 = this.real.read();
        if (r100 == (-1)) goto L5;
        this.readLength++;
    L6:
        return r100;
    L5:
        this.finished = true;
        goto L6
    }

    public boolean safeClose() {
        close();     // Catch: Throwable -> L5
        return true;
    L5:
        return false;
    }

    public String stringBody() {
        String r100 = this.stringBody;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = new String(bytes());
        this.stringBody = r101;
        return r101;
    }

    public String toString() {
        return "OpenResponseBody{contentType='" + this.contentType + "', contentLength=" + this.contentLength + ", finished=" + this.finished + ", closed=" + this.closed + ", readLength=" + this.readLength + '}';
    }
}
