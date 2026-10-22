package qs3;

import android.text.TextUtils;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.apm.util.m;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
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

/* JADX INFO: loaded from: classes14.dex */
public final class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpURLConnection f534656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f534657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f534658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f534659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DataOutputStream f534660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GZIPOutputStream f534661g;

    @Override // ff7.g
    public final b finish() throws IOException {
        ArrayList r100 = new ArrayList();
        byte[] r101 = ("\r\n--" + this.f534655a + "--\r\n").getBytes();
        if (this.f534658d == false) goto L5;
        this.f534661g.write(r101);
        this.f534661g.finish();
        this.f534661g.close();
    L6:
        int r102 = this.f534656b.getResponseCode();
        if (r102 != 200) goto L19;
        BufferedReader r103 = new BufferedReader(new InputStreamReader(this.f534656b.getInputStream()));
    L9:
        String r104 = r103.readLine();
        if (r104 == null) goto L12;
        r100.add(r104);
        goto L9
    L12:
        r103.close();
        this.f534656b.disconnect();
        StringBuilder r105 = new StringBuilder();
        Iterator r106 = r100.iterator();
    L14:
        if (r106.hasNext() == false) goto L17;
        r105.append((String) r106.next());
        goto L14
    L17:
        return new b(r102, r105.toString().getBytes());
    L19:
        throw new IOException("Server returned non-OK status: " + r102);
    L5:
        this.f534660f.write(r101);
        this.f534660f.flush();
        this.f534660f.close();
        goto L6
    }

    @Override // ff7.g
    public final void a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder(100);
        r102.append(HttpClient.ENDFLAG);
        r102.append(this.f534655a);
        r102.append("\r\nContent-Disposition: form-data; name=\"");
        r102.append(r100);
        r102.append("\"\r\nContent-Type: text/plain; charset=");
        r102.append(this.f534657c);
        r102.append("\r\n\r\n");
        r102.append(r101);
        r102.append("\r\n");
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f534658d == false) goto L6;
        this.f534661g.write(r102.toString().getBytes());     // Catch: IOException -> L8
    L11:
        return;
    L6:
        this.f534660f.write(r102.toString().getBytes());     // Catch: IOException -> L8
        goto L11
    }

    @Override // ff7.g
    public final void c(String r100, Map r101) throws IOException {
        StringBuilder r102 = new StringBuilder(100);
        r102.append(HttpClient.ENDFLAG);
        r102.append(this.f534655a);
        r102.append("\r\nContent-Disposition: form-data; name=\"params.txt\"; filename=\"params.txt\"");
        Iterator r103 = ((HashMap) r101).entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.append("; ");
        r102.append((String) r104.getKey());
        r102.append("=\"");
        r102.append((String) r104.getValue());
        r102.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty("text/plain") == true) goto L9;
        r102.append("\r\nContent-Type: text/plain\r\n");
    L9:
        r102.append("\r\n");
        if (this.f534658d == false) goto L12;
        this.f534661g.write(r102.toString().getBytes());
    L13:
        if (r100 != null) goto L16;
        r100 = "";
    L16:
        if (this.f534658d == false) goto L18;
        this.f534661g.write(r100.getBytes());
    L20:
        if (this.f534658d == false) goto L22;
        this.f534661g.write("\r\n".getBytes());
        return;
    L22:
        this.f534660f.write("\r\n".getBytes());
        this.f534660f.flush();
        return;
    L18:
        this.f534660f.write(r100.getBytes());
        goto L20
    L12:
        this.f534660f.write(r102.toString().getBytes());
        goto L13
    }

    public a(String r100, String r101, boolean r102, Map<String, String> r103) throws IOException {
        this.f534657c = r101;
        this.f534658d = r102;
        this.f534659e = r103;
        String r104 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f534655a = r104;
        HttpURLConnection r105 = m.a(r100);
        this.f534656b = r105;
        r105.setUseCaches(false);
        r105.setDoOutput(true);
        r105.setDoInput(true);
        r105.setRequestMethod("POST");
        r105.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + r104);
        if (r103 == null) goto L8;
        Iterator<Map.Entry<String, String>> r106 = r103.entrySet().iterator();
    L6:
        if (r106.hasNext() == false) goto L8;
        Map.Entry<String, String> r107 = r106.next();
        this.f534656b.setRequestProperty(r107.getKey(), r107.getValue());
    L8:
        this.f534656b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f534655a);
        if (r102 == false) goto L11;
        this.f534656b.setRequestProperty("Content-Encoding", DownloadHelper.GZIP);
        this.f534661g = new GZIPOutputStream(this.f534656b.getOutputStream());
        return;
    L11:
        this.f534660f = new DataOutputStream(this.f534656b.getOutputStream());
    }

    @Override // ff7.g
    public final void b(String r100, File r101, String r102, Map<String, String> r103) throws IOException {
        String r104 = r101.getName();
        StringBuilder r105 = new StringBuilder(100);
        r105.append(HttpClient.ENDFLAG);
        r105.append(this.f534655a);
        r105.append("\r\nContent-Disposition: form-data; name=\"");
        r105.append(r100);
        r105.append("\"; filename=\"");
        r105.append(r104);
        r105.append("\"");
        Iterator<Map.Entry<String, String>> r106 = r103.entrySet().iterator();
    L4:
        if (r106.hasNext() == false) goto L7;
        Map.Entry<String, String> r107 = r106.next();
        r105.append("; ");
        r105.append(r107.getKey());
        r105.append("=\"");
        r105.append(r107.getValue());
        r105.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r105.append("\r\nContent-Type: ");
        r105.append(r102);
        r105.append("\r\n");
    L9:
        r105.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        if (this.f534658d == false) goto L12;
        this.f534661g.write(r105.toString().getBytes());
    L13:
        PolarisFileInputStreamWrapper r108 = new PolarisFileInputStreamWrapper(r101);
        byte[] r109 = new byte[8192];
    L14:
        int r110 = r108.read(r109);
        if (r110 == (-1)) goto L20;
        if (this.f534658d == true) goto L18;
        this.f534660f.write(r109, 0, r110);
        goto L14
    L18:
        this.f534661g.write(r109, 0, r110);
        goto L14
    L20:
        r108.close();
        if (this.f534658d == false) goto L23;
        this.f534661g.write("\r\n".getBytes());
        return;
    L23:
        this.f534660f.write("\r\n".getBytes());
        this.f534660f.flush();
        return;
    L12:
        this.f534660f.write(r105.toString().getBytes());
        goto L13
    }
}
