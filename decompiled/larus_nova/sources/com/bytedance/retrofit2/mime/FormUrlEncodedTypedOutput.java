package com.bytedance.retrofit2.mime;

import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.retrofit2.client.Request;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class FormUrlEncodedTypedOutput extends AbsTypedOutput {
    private static AtomicReference<IFormBodyModifyHook> sFormModifyHook;
    ByteArrayOutputStream content;
    private final boolean enableRecordFields;
    private Map<String, List<String>> fields;
    private IFormBodyModifyHook mFormModifyHook;

    public interface IFormBodyModifyHook {
        IFormBodyModifyHook copy();

        Map<String, List<String>> getAllNewFormFields(Request r100);
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    static {
        sFormModifyHook = new AtomicReference();
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public byte[] getOriginBody() {
        return TTRequestCompressManager.decompressDataByType(this.content.toByteArray(), this.mType, this.mOriginBodySize);
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public boolean interceptRequestBody() {
        byte[] r100 = this.content.toByteArray();
        if (r100 != null) goto L5;
    L12:
        return false;
    L5:
        if (r100.length > 102400) goto L12;
        byte[] r101 = EncryptorUtil.b(r100, r100.length);
        if (r101 != null) goto L10;
        return false;
    L10:
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(r101.length);
        this.content = r102;
        r102.write(r101, 0, r101.length);
        this.mIsBodyEncrypted = true;
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.content.size();
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        this.mBodyMd5Stub = DigestUtil.md5Hex(this.content.toByteArray());
        return this.mBodyMd5Stub;
    }

    public FormUrlEncodedTypedOutput() {
        this.content = new ByteArrayOutputStream();
        this.fields = new HashMap();
        this.enableRecordFields = false;
        IFormBodyModifyHook r100 = sFormModifyHook.get();
        if (r100 == null) goto L5;
        IFormBodyModifyHook r101 = r100.copy();
    L6:
        this.mFormModifyHook = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public Map<String, List<String>> fields() {
        return this.fields;
    }

    public FormUrlEncodedTypedOutput(boolean r100) {
        this.content = new ByteArrayOutputStream();
        this.fields = new HashMap();
        this.enableRecordFields = r100;
        IFormBodyModifyHook r101 = sFormModifyHook.get();
        if (r101 == null) goto L5;
        IFormBodyModifyHook r102 = r101.copy();
    L6:
        this.mFormModifyHook = r102;
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static void setFormBodyModifyHook(IFormBodyModifyHook r100) {
        if (r100 != null) goto L5;
        sFormModifyHook.set(null);
        return;
    L5:
        sFormModifyHook.set(r100.copy());
    }

    public void useFormBodyModifyHookAndConstructStream(Request r100) {
        IFormBodyModifyHook r101 = this.mFormModifyHook;
        if (r101 != null) goto L5;
        return;
    L5:
        Map<String, List<String>> r102 = r101.getAllNewFormFields(r100);
        this.fields = r102;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, List<String>>> r103 = this.fields.entrySet().iterator();
    L12:
        if (r103.hasNext() == false) goto L30;
        Map.Entry<String, List<String>> r104 = r103.next();
        Iterator<String> r105 = r104.getValue().iterator();
    L15:
        if (r105.hasNext() == false) goto L12;
        String r106 = r105.next();
        writeFieldToContentStream(r104.getKey(), true, r106, true);     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L30:
        return;
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput, com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r100) throws IOException {
        r100.write(this.content.toByteArray());
    }

    public void addField(String r100, String r101) {
        addField(r100, true, r101, true);
    }

    @Override // com.bytedance.retrofit2.mime.AbsTypedOutput
    public TTRequestCompressManager.CompressData compressRequestBody(String r100, String r101, boolean r102) {
        byte[] r103 = this.content.toByteArray();
        if (r103 != null) goto L6;
        return null;
    L6:
        TTRequestCompressManager.CompressData r104 = TTRequestCompressManager.compressBody(r103, r103.length, r100, r101, r102);
        if (r104 != null) goto L9;
    L12:
        return r104;
    L9:
        if (r104.data == null) goto L12;
        this.mOriginBodySize = r103.length;
        ByteArrayOutputStream r105 = new ByteArrayOutputStream(r104.data.length);
        this.content = r105;
        byte[] r106 = r104.data;
        r105.write(r106, 0, r106.length);
        this.mType = r104.contentEncoding;
        goto L12
    }

    private void writeFieldToContentStream(String r100, boolean r101, String r102, boolean r103) throws IOException {
        if (this.content.size() <= 0) goto L6;
        this.content.write(38);
    L6:
        if (r101 == false) goto L8;
        r100 = URLEncoder.encode(r100, "UTF-8");
    L8:
        if (r103 == false) goto L10;
        r102 = URLEncoder.encode(r102, "UTF-8");
    L10:
        this.content.write(r100.getBytes("UTF-8"));
        this.content.write(61);
        this.content.write(r102.getBytes("UTF-8"));
    }

    public void addField(String r100, boolean r101, String r102, boolean r103) {
        if (r100 == null) goto L23;
        if (r102 == null) goto L21;
        if (this.enableRecordFields == true) goto L9;
        if (this.mFormModifyHook != null) goto L9;
    L13:
        if (this.mFormModifyHook == null) goto L24;
        return;
    L24:
        writeFieldToContentStream(r100, r101, r102, r103);     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        if (this.fields.containsKey(r100) == false) goto L11;
        this.fields.get(r100).add(r102);
        goto L13
    L11:
        ArrayList r104 = new ArrayList();
        r104.add(r102);
        this.fields.put(r100, r104);
        goto L13
    L21:
        throw new NullPointerException("value");
    L23:
        throw new NullPointerException("name");
    }
}
