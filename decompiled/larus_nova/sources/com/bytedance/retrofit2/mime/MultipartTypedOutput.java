package com.bytedance.retrofit2.mime;

import com.baidu.mapapi.http.HttpClient;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class MultipartTypedOutput implements TypedOutput {
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    private final String boundary;
    private final byte[] footer;
    private long length;
    private final List<MimePart> mimeParts;

    /* JADX INFO: loaded from: classes21.dex */
    public static final class MimePart {
        private final TypedOutput body;
        private final String boundary;
        private boolean isBuilt;
        private final boolean isFirst;
        private final String name;
        private byte[] partBoundary;
        private byte[] partHeader;
        private final String transferEncoding;

        private void build() {
            if (this.isBuilt == false) goto L5;
            return;
        L5:
            this.partBoundary = MultipartTypedOutput.access$000(this.boundary, this.isFirst, false);
            this.partHeader = MultipartTypedOutput.access$100(this.name, this.transferEncoding, this.body);
            this.isBuilt = true;
        }

        public long size() {
            build();
            if (this.body.length() > (-1)) goto L5;
            return -1;
        L5:
            return (this.body.length() + ((long) this.partBoundary.length)) + ((long) this.partHeader.length);
        }

        public void writeTo(OutputStream r100) throws IOException {
            build();
            r100.write(this.partBoundary);
            r100.write(this.partHeader);
            this.body.writeTo(r100);
        }

        public MimePart(String r100, String r101, TypedOutput r102, String r103, boolean r104) {
            this.name = r100;
            this.transferEncoding = r101;
            this.body = r102;
            this.isFirst = r104;
            this.boundary = r103;
        }
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    public int getPartCount() {
        return this.mimeParts.size();
    }

    public List<byte[]> getParts() throws IOException {
        ArrayList r100 = new ArrayList(this.mimeParts.size());
        Iterator<MimePart> r101 = this.mimeParts.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        MimePart r102 = r101.next();
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        r102.writeTo(r103);
        r100.add(r103.toByteArray());
        goto L4
    L6:
        return r100;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        if (this.length != (-1)) goto L36;
        return null;
    L36:
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();     // Catch: Throwable -> L13
        writeTo(r100);     // Catch: Throwable -> L12
        ByteArrayInputStream r101 = new ByteArrayInputStream(r100.toByteArray());     // Catch: Throwable -> L12
        String r102 = DigestUtil.md5Hex(r101);     // Catch: Throwable -> L11
        r100.close();     // Catch: Throwable -> L21
    L28:
        r101.close();     // Catch: Throwable -> L22
    L10:
        return r102;
    L14:
        if (r100 != null) goto L26;
    L18:
        if (r101 != null) goto L34;
    L20:
        return null;
    L34:
        r101.close();     // Catch: Throwable -> L23
        goto L20
    L26:
        r100.close();     // Catch: Throwable -> L17
    L12:
        r101 = null;
    L13:
        r100 = null;
        r101 = null;
        goto L14
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "multipart/form-data; boundary=" + this.boundary;
    }

    public MultipartTypedOutput() {
        this(UUID.randomUUID().toString());
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.length;
    }

    public MultipartTypedOutput(String r100) {
        this.mimeParts = new LinkedList();
        this.boundary = r100;
        byte[] r101 = buildBoundary(r100, false, true);
        this.footer = r101;
        this.length = r101.length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r100) throws IOException {
        Iterator<MimePart> r101 = this.mimeParts.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().writeTo(r100);
        goto L4
    L6:
        r100.write(this.footer);
    }

    public void addPart(String r100, TypedOutput r101) {
        addPart(r100, DEFAULT_TRANSFER_ENCODING, r101);
    }

    public static /* synthetic */ byte[] access$000(String r100, boolean r101, boolean r102) {
        return buildBoundary(r100, r101, r102);
    }

    public static /* synthetic */ byte[] access$100(String r100, String r101, TypedOutput r102) {
        return buildHeader(r100, r101, r102);
    }

    private static byte[] buildBoundary(String r100, boolean r101, boolean r102) {
        StringBuilder r103 = new StringBuilder(r100.length() + 8);     // Catch: IOException -> L12
        if (r101 == true) goto L7;
        r103.append("\r\n");     // Catch: IOException -> L12
    L7:
        r103.append(HttpClient.ENDFLAG);     // Catch: IOException -> L12
        r103.append(r100);     // Catch: IOException -> L12
        if (r102 == false) goto L10;
        r103.append(HttpClient.ENDFLAG);     // Catch: IOException -> L12
    L10:
        r103.append("\r\n");     // Catch: IOException -> L12
        return r103.toString().getBytes("UTF-8");
    L12:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart boundary", e);
    }

    private static byte[] buildHeader(String r100, String r101, TypedOutput r102) {
        StringBuilder r103 = new StringBuilder(128);     // Catch: IOException -> L10
        r103.append("Content-Disposition: form-data; name=\"");     // Catch: IOException -> L10
        r103.append(r100);     // Catch: IOException -> L10
        String r104 = r102.fileName();     // Catch: IOException -> L10
        if (r104 == null) goto L5;
        r103.append("\"; filename=\"");     // Catch: IOException -> L10
        r103.append(r104);     // Catch: IOException -> L10
    L5:
        r103.append("\"\r\nContent-Type: ");     // Catch: IOException -> L10
        r103.append(r102.mimeType());     // Catch: IOException -> L10
        long r105 = r102.length();     // Catch: IOException -> L10
        if (r105 == (-1)) goto L8;
        r103.append("\r\nContent-Length: ");     // Catch: IOException -> L10
        r103.append(r105);     // Catch: IOException -> L10
    L8:
        r103.append("\r\nContent-Transfer-Encoding: ");     // Catch: IOException -> L10
        r103.append(r101);     // Catch: IOException -> L10
        r103.append("\r\n\r\n");     // Catch: IOException -> L10
        return r103.toString().getBytes("UTF-8");
    L10:
        e = move-exception;
        throw new RuntimeException("Unable to write multipart header", e);
    }

    public void addPart(String r100, String r101, TypedOutput r110) {
        if (r100 == null) goto L17;
        if (r101 == null) goto L15;
        if (r110 == null) goto L13;
        MimePart r102 = new MimePart(r100, r101, r110, this.boundary, this.mimeParts.isEmpty());
        this.mimeParts.add(r102);
        long r103 = r102.size();
        if (r103 != (-1)) goto L8;
        this.length = -1;
        return;
    L8:
        long r104 = this.length;
        if (r104 == (-1)) goto L19;
        this.length = r104 + r103;
        return;
    L19:
        return;
    L13:
        throw new NullPointerException("Part body must not be null.");
    L15:
        throw new NullPointerException("Transfer encoding must not be null.");
    L17:
        throw new NullPointerException("Part name must not be null.");
    }
}
