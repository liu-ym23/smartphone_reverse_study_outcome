package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.bytedance.ee.bear.drive.config.fg.DriveVideoPlayConfig;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.push.ba;
import com.xiaomi.push.bk;
import com.xiaomi.push.h;
import com.xiaomi.push.v;
import com.xiaomi.push.x;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class a implements IEventProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f463024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> f142a;

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        bk.a(this.f463024a, "event", "eventUploading");
        File[] r100 = bk.m8854a(this.f463024a, "eventUploading");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length <= 0) goto L103;
        int r101 = r100.length;
        FileLock r102 = null;
        RandomAccessFile r103 = null;
        PolarisFileWrapper r104 = null;
        int r105 = 0;
    L8:
        if (r105 >= r101) goto L104;
        File r106 = r100[r105];
        if (r106 != null) goto L80;
        if (r102 != null) goto L13;
    L18:
        v.a(r103);
        if (r104 == null) goto L67;
    L20:
        r104.delete();
    L67:
        r105 = r105 + 1;
        goto L8
    L13:
        if (r102.isValid() == false) goto L18;
        r102.release();     // Catch: IOException -> L16
    L16:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L18
    L80:
        if (r106.length() <= DriveVideoPlayConfig.DEFAULT_BITRATE) goto L34;
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because " + r106.getName() + " is too big, length " + r106.length());     // Catch: Throwable -> L53 Exception -> L55
        a(r106.getName(), Formatter.formatFileSize(this.f463024a, r106.length()));     // Catch: Throwable -> L53 Exception -> L55
        r106.delete();     // Catch: Throwable -> L53 Exception -> L55
        if (r102 != null) goto L26;
    L31:
        v.a(r103);
        if (r104 == null) goto L67;
    L26:
        if (r102.isValid() == false) goto L31;
        r102.release();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L31
    L34:
        String r107 = r106.getAbsolutePath();     // Catch: Throwable -> L53 Exception -> L55
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107 + ".lock");     // Catch: Throwable -> L53 Exception -> L55
        v.m9433a(r108);     // Catch: Throwable -> L49 Exception -> L51
        RandomAccessFile r109 = new RandomAccessFile(r108, "rw");     // Catch: Throwable -> L49 Exception -> L51
    L94:
        r102 = r109.getChannel().lock();     // Catch: Throwable -> L45 Exception -> L47
        a(a(r107));     // Catch: Throwable -> L45 Exception -> L47
        r106.delete();     // Catch: Throwable -> L45 Exception -> L47
        if (r102 != null) goto L39;
    L44:
        v.a(r109);
        r108.delete();
        r103 = r109;
        r104 = r108;
        goto L67
    L39:
        if (r102.isValid() == false) goto L44;
        r102.release();     // Catch: IOException -> L42
    L42:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L44
    L47:
        e = e;
        r103 = r109;
    L52:
        r104 = r108;
    L56:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L53
        if (r102 != null) goto L59;
    L64:
        v.a(r103);
        if (r104 == null) goto L67;
    L59:
        if (r102.isValid() == false) goto L64;
        r102.release();     // Catch: IOException -> L62
    L62:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L45:
        th = th;
        r103 = r109;
    L50:
        r104 = r108;
    L68:
        if (r102 != null) goto L70;
    L75:
        v.a(r103);
        if (r104 == null) goto L102;
        r104.delete();
        throw th;
    L102:
        throw th;
    L70:
        if (r102.isValid() == false) goto L75;
        r102.release();     // Catch: IOException -> L73
    L73:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L51:
        e = e;
    L49:
        th = th;
        goto L50
    L53:
        th = th;
    L55:
        e = e;
        goto L56
    L104:
        return;
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> r100 = this.f142a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.size() <= 0) goto L15;
        Iterator<String> r101 = this.f142a.keySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L15;
        String r102 = r101.next();
        ArrayList<com.xiaomi.clientreport.data.a> r103 = this.f142a.get(r102);
        if (r103 == null) goto L9;
        if (r103.size() <= 0) goto L9;
        com.xiaomi.clientreport.data.a[] r104 = new com.xiaomi.clientreport.data.a[r103.size()];
        r103.toArray(r104);
        m8731a(r104);
    L15:
        this.f142a.clear();
    }

    public a(Context r100) {
        a(r100);
    }

    private com.xiaomi.clientreport.data.a[] a(com.xiaomi.clientreport.data.a[] r110) {
        String r100 = b(r110[0]);
        BufferedOutputStream r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L53;
        return null;
    L53:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100 + ".lock");     // Catch: Throwable -> L39 Exception -> L41
        v.m9433a(r102);     // Catch: Throwable -> L39 Exception -> L41
        RandomAccessFile r103 = new RandomAccessFile(r102, "rw");     // Catch: Throwable -> L39 Exception -> L41
    L55:
        FileLock r104 = r103.getChannel().lock();     // Catch: Throwable -> L35 Exception -> L37
    L57:
        BufferedOutputStream r105 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r100), true));     // Catch: Throwable -> L31 Exception -> L33
        int r106 = r110.length;     // Catch: Exception -> L29 Throwable -> L46
        int r107 = 0;
        int r108 = 0;
    L9:
        if (r107 >= r106) goto L44;
        com.xiaomi.clientreport.data.a r111 = r110[r107];     // Catch: Exception -> L29 Throwable -> L46
        if (r111 == null) goto L28;
        byte[] r112 = stringToBytes(r111.toJsonString());     // Catch: Exception -> L29 Throwable -> L46
        if (r112 != null) goto L16;
    L27:
        com.xiaomi.channel.commonutils.logger.b.d("event data throw a invalid item ");     // Catch: Exception -> L29 Throwable -> L46
        goto L28
    L16:
        if (r112.length < 1) goto L27;
        if (r112.length > 4096) goto L27;
        if (bk.m8853a(this.f463024a, r100) == false) goto L22;
        r105.write(x.a(-573785174));     // Catch: Exception -> L29 Throwable -> L46
        r105.write(x.a(r112.length));     // Catch: Exception -> L29 Throwable -> L46
        r105.write(r112);     // Catch: Exception -> L29 Throwable -> L46
        r105.flush();     // Catch: Exception -> L29 Throwable -> L46
        r108 = r108 + 1;     // Catch: Exception -> L29 Throwable -> L46
        goto L28
    L22:
        int r109 = r110.length - r108;     // Catch: Exception -> L29 Throwable -> L46
        com.xiaomi.clientreport.data.a[] r113 = new com.xiaomi.clientreport.data.a[r109];     // Catch: Exception -> L29 Throwable -> L46
        System.arraycopy(r110, r108, r113, 0, r109);     // Catch: Exception -> L29 Throwable -> L46
        v.a(r105);
        a(r103, r104);
        return r113;
    L28:
        r107 = r107 + 1;
    L44:
        v.a(r105);
        a(r103, r104);
        return null;
    L29:
        e = e;
    L43:
        com.xiaomi.channel.commonutils.logger.b.a("event data write to cache file failed cause exception", e);     // Catch: Throwable -> L46
    L46:
        th = th;
        r101 = r105;
    L48:
        v.a(r101);
        a(r103, r104);
        throw th;
    L33:
        e = e;
        r105 = null;
    L31:
        th = th;
    L37:
        e = e;
        r104 = null;
        r105 = null;
    L35:
        th = th;
        r104 = null;
    L41:
        e = e;
        r104 = null;
        r103 = null;
        r105 = null;
    L39:
        th = th;
        r104 = null;
        r103 = null;
        goto L48
    }

    private String b(com.xiaomi.clientreport.data.a r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.f463024a.getFilesDir(), "event");
        String r102 = r101.getAbsolutePath() + File.separator + a(r100);
        int r103 = 0;
    L4:
        if (r103 >= 100) goto L9;
        String r104 = r102 + r103;
        if (bk.m8853a(this.f463024a, r104) == true) goto L13;
        r103 = r103 + 1;
        goto L4
    L13:
        return r104;
    L9:
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] r100) {
        if (r100 != null) goto L5;
    L32:
        return null;
    L5:
        if (r100.length < 1) goto L32;
        if (com.xiaomi.clientreport.manager.a.a(this.f463024a).m8727a().isEventEncrypted() == false) goto L10;
        String r101 = bk.a(this.f463024a);
        if (TextUtils.isEmpty(r101) == false) goto L14;
        return null;
    L14:
        byte[] r102 = bk.a(r101);
        if (r102 == null) goto L32;
        if (r102.length <= 0) goto L32;
        return ba.b(Base64.decode(h.a(r102, r100), 2));
    L30:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L26:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L28:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L22:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L20:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
    L24:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L32
    L10:
        return ba.b(r100);
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<com.xiaomi.clientreport.data.a>> r100) {
        this.f142a = r100;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (com.xiaomi.clientreport.manager.a.a(this.f463024a).m8727a().isEventEncrypted() == false) goto L8;
        String r101 = bk.a(this.f463024a);
        byte[] r102 = ba.m8846a(r100);
        if (TextUtils.isEmpty(r101) == true) goto L23;
        if (r102 == null) goto L23;
        if (r102.length <= 1) goto L23;
        byte[] r103 = bk.a(r101);
        if (r103 == null) goto L23;
    L21:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L23
    L18:
        if (r103.length <= 1) goto L23;
        return h.b(r103, Base64.encode(r102, 2));
    L23:
        return null;
    L8:
        return ba.m8846a(r100);
    }

    private List<String> a(String r100) {
        ArrayList r101 = new ArrayList();
        byte[] r102 = new byte[4];
        byte[] r103 = new byte[4];
        PolarisFileInputStreamWrapper r104 = null;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r100));     // Catch: Throwable -> L36 Exception -> L38
    L47:
        int r106 = r105.read(r102);     // Catch: Throwable -> L32 Exception -> L34
        if (r106 == (-1)) goto L31;
        if (r106 != 4) goto L10;
        if (x.a(r102) != (-573785174)) goto L13;
        int r107 = r105.read(r103);     // Catch: Throwable -> L32 Exception -> L34
        if (r107 == (-1)) goto L31;
        if (r107 != 4) goto L18;
        int r108 = x.a(r103);     // Catch: Throwable -> L32 Exception -> L34
        if (r108 < 1) goto L30;
        if (r108 > 4096) goto L30;
        byte[] r109 = new byte[r108];     // Catch: Throwable -> L32 Exception -> L34
        if (r105.read(r109) != r108) goto L26;
        String r110 = bytesToString(r109);     // Catch: Throwable -> L32 Exception -> L34
        if (TextUtils.isEmpty(r110) == true) goto L47;
        r101.add(r110);     // Catch: Throwable -> L32 Exception -> L34
        goto L47
    L26:
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause buffer size not equal length");     // Catch: Throwable -> L32 Exception -> L34
    L30:
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");     // Catch: Throwable -> L32 Exception -> L34
        goto L31
    L18:
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed cause lengthBuffer error");     // Catch: Throwable -> L32 Exception -> L34
        goto L31
    L13:
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");     // Catch: Throwable -> L32 Exception -> L34
        goto L31
    L10:
        com.xiaomi.channel.commonutils.logger.b.d("eventData read from cache file failed because magicNumber error");     // Catch: Throwable -> L32 Exception -> L34
    L31:
        v.a(r105);
    L41:
        return r101;
    L34:
        e = e;
        r104 = r105;
    L39:
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L36
        v.a(r104);
    L32:
        th = th;
        r104 = r105;
    L42:
        v.a(r104);
        throw th;
    L38:
        e = e;
    L36:
        th = th;
        goto L42
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo8730a(com.xiaomi.clientreport.data.a r100) {
        if ((r100 instanceof EventClientReport) == true) goto L6;
        return;
    L6:
        if (this.f142a != null) goto L8;
        return;
    L8:
        EventClientReport r101 = (EventClientReport) r100;
        String r102 = a(r101);
        ArrayList<com.xiaomi.clientreport.data.a> r103 = this.f142a.get(r102);
        if (r103 != null) goto L11;
        r103 = new ArrayList();
    L11:
        r103.add(r101);
        this.f142a.put(r102, r103);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m8731a(com.xiaomi.clientreport.data.a[] r100) {
        if (r100 != null) goto L4;
    L15:
        com.xiaomi.channel.commonutils.logger.b.m8718a("event data write to cache file failed because data null");
        return;
    L4:
        if (r100.length == 0) goto L15;
        if (r100[0] == null) goto L15;
    L8:
        r100 = a(r100);
        if (r100 == null) goto L14;
        if (r100.length <= 0) goto L21;
        if (r100[0] != null) goto L8;
        return;
    L21:
        return;
    }

    public static String a(com.xiaomi.clientreport.data.a r100) {
        return String.valueOf(r100.production);
    }

    public void a(List<String> r100) {
        bk.a(this.f463024a, r100);
    }

    public void a(Context r100) {
        this.f463024a = r100;
    }

    private void a(String r100, String r101) {
        EventClientReport r102 = com.xiaomi.clientreport.manager.a.a(this.f463024a).a(5001, "24:" + r100 + "," + r101);
        ArrayList r103 = new ArrayList();
        r103.add(r102.toJsonString());
        a(r103);
    }

    private void a(RandomAccessFile r100, FileLock r101) {
        if (r101 != null) goto L4;
    L9:
        v.a(r100);
        return;
    L4:
        if (r101.isValid() == false) goto L9;
        r101.release();     // Catch: IOException -> L7
    L7:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L9
    }
}
