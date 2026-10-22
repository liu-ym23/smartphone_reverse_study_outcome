package com.bytedance.sdk.open.aweme.commonbase.net.mime;

import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.core.net.OpenRequestBody;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class FormUrlEncodedRequestBody extends OpenRequestBody {
    private ByteArrayOutputStream content;

    public FormUrlEncodedRequestBody() {
        this.content = new ByteArrayOutputStream();
    }

    public void addField(String r100, Boolean r101, String r102, Boolean r103) {
        if (TextUtils.isEmpty(r100) == true) goto L21;
        if (r102 != null) goto L7;
        return;
    L7:
        if (this.content.size() <= 0) goto L22;
        this.content.write(38);
    L22:
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L11:
        if (r101.booleanValue() == false) goto L14;
        r100 = URLEncoder.encode(r100, "UTF-8");     // Catch: IOException -> L18
    L14:
        if (r103.booleanValue() == false) goto L16;
        r102 = URLEncoder.encode(r102, "UTF-8");     // Catch: IOException -> L18
    L16:
        this.content.write(r100.getBytes("UTF-8"));     // Catch: IOException -> L18
        this.content.write(61);     // Catch: IOException -> L18
        this.content.write(r102.getBytes("UTF-8"));     // Catch: IOException -> L18
        return;
    }

    public void addField(String r100, String r101) {
        Boolean r102 = Boolean.TRUE;
        addField(r100, r102, r101, r102);
    }

    public void addFields(Map<String, String> r100) {
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, String> r102 = r101.next();
        addField(r102.getKey(), r102.getValue());
        goto L4
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public String contentType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public String fileName() {
        return null;
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public long length() {
        return this.content.size();
    }

    @Override // com.bytedance.sdk.open.aweme.core.net.OpenRequestBody
    public void writeTo(OutputStream r100) throws IOException {
        r100.write(this.content.toByteArray());
    }
}
