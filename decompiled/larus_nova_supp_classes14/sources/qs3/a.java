package qs3;

import android.text.TextUtils;
import com.bytedance.apm.util.m;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import ff7.b;
import ff7.g;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements g {
    public final String a;
    public final HttpURLConnection b;
    public final String c;
    public final boolean d;
    public final Map<String, String> e;
    public final DataOutputStream f;
    public final GZIPOutputStream g;

    public final b finish() throws IOException {
        ArrayList r0 = new ArrayList();
        byte[] r1 = ("\r\n--" + this.a + "--\r\n").getBytes();
        if (this.d == false) goto L5;
        this.g.write(r1);
        this.g.finish();
        this.g.close();
    L6:
        int r2 = this.b.getResponseCode();
        if (r2 != 200) goto L19;
        BufferedReader r3 = new BufferedReader(new InputStreamReader(this.b.getInputStream()));
    L9:
        String r4 = r3.readLine();
        if (r4 == null) goto L12;
        r0.add(r4);
        goto L9
    L12:
        r3.close();
        this.b.disconnect();
        StringBuilder r5 = new StringBuilder();
        Iterator r6 = r0.iterator();
    L14:
        if (r6.hasNext() == false) goto L17;
        r5.append((String) r6.next());
        goto L14
    L17:
        return new b(r2, r5.toString().getBytes());
    L19:
        throw new IOException("Server returned non-OK status: " + r2);
    L5:
        this.f.write(r1);
        this.f.flush();
        this.f.close();
        goto L6
    }

    public final void a(String r3, String r4) {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--");
        r0.append(this.a);
        r0.append("\r\nContent-Disposition: form-data; name=\"");
        r0.append(r3);
        r0.append("\"\r\nContent-Type: text/plain; charset=");
        r0.append(this.c);
        r0.append("\r\n\r\n");
        r0.append(r4);
        r0.append("\r\n");
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.d == false) goto L6;
        this.g.write(r0.toString().getBytes());     // Catch: IOException -> L8
    L11:
        return;
    L6:
        this.f.write(r0.toString().getBytes());     // Catch: IOException -> L8
        goto L11
    }

    public final void c(String r4, Map r5) throws IOException {
        StringBuilder r0 = new StringBuilder(100);
        r0.append("--");
        r0.append(this.a);
        r0.append("\r\nContent-Disposition: form-data; name=\"params.txt\"; filename=\"params.txt\"");
        Iterator r6 = ((HashMap) r5).entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        Map.Entry r1 = (Map.Entry) r6.next();
        r0.append("; ");
        r0.append((String) r1.getKey());
        r0.append("=\"");
        r0.append((String) r1.getValue());
        r0.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty("text/plain") == true) goto L9;
        r0.append("\r\nContent-Type: text/plain\r\n");
    L9:
        r0.append("\r\n");
        if (this.d == false) goto L12;
        this.g.write(r0.toString().getBytes());
    L13:
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        if (this.d == false) goto L18;
        this.g.write(r4.getBytes());
    L20:
        if (this.d == false) goto L22;
        this.g.write("\r\n".getBytes());
        return;
    L22:
        this.f.write("\r\n".getBytes());
        this.f.flush();
        return;
    L18:
        this.f.write(r4.getBytes());
        goto L20
    L12:
        this.f.write(r0.toString().getBytes());
        goto L13
    }

    public a(String r4, String r5, boolean r6, Map<String, String> r7) throws IOException {
        this.c = r5;
        this.d = r6;
        this.e = r7;
        String r8 = "AAA" + System.currentTimeMillis() + "AAA";
        this.a = r8;
        HttpURLConnection r9 = m.a(r4);
        this.b = r9;
        r9.setUseCaches(false);
        r9.setDoOutput(true);
        r9.setDoInput(true);
        r9.setRequestMethod("POST");
        r9.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + r8);
        if (r7 == null) goto L8;
        Iterator<Map.Entry<String, String>> r10 = r7.entrySet().iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        Map.Entry<String, String> r11 = r10.next();
        this.b.setRequestProperty(r11.getKey(), r11.getValue());
    L8:
        this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.a);
        if (r6 == false) goto L11;
        this.b.setRequestProperty("Content-Encoding", "gzip");
        this.g = new GZIPOutputStream(this.b.getOutputStream());
        return;
    L11:
        this.f = new DataOutputStream(this.b.getOutputStream());
    }

    public final void b(String r4, File r5, String r6, Map<String, String> r7) throws IOException {
        String r0 = r5.getName();
        StringBuilder r1 = new StringBuilder(100);
        r1.append("--");
        r1.append(this.a);
        r1.append("\r\nContent-Disposition: form-data; name=\"");
        r1.append(r4);
        r1.append("\"; filename=\"");
        r1.append(r0);
        r1.append("\"");
        Iterator<Map.Entry<String, String>> r8 = r7.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L7;
        Map.Entry<String, String> r2 = r8.next();
        r1.append("; ");
        r1.append(r2.getKey());
        r1.append("=\"");
        r1.append(r2.getValue());
        r1.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r6) == true) goto L9;
        r1.append("\r\nContent-Type: ");
        r1.append(r6);
        r1.append("\r\n");
    L9:
        r1.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.d == false) goto L12;
        this.g.write(r1.toString().getBytes());
    L13:
        PolarisFileInputStreamWrapper r9 = new PolarisFileInputStreamWrapper(r5);
        byte[] r10 = new byte[8192];
    L14:
        int r11 = r9.read(r10);
        if (r11 == (-1)) goto L20;
        if (this.d == true) goto L18;
        this.f.write(r10, 0, r11);
        goto L14
    L18:
        this.g.write(r10, 0, r11);
        goto L14
    L20:
        r9.close();
        if (this.d == false) goto L23;
        this.g.write("\r\n".getBytes());
        return;
    L23:
        this.f.write("\r\n".getBytes());
        this.f.flush();
        return;
    L12:
        this.f.write(r1.toString().getBytes());
        goto L13
    }
}
