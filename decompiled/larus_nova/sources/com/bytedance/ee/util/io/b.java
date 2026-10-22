package com.bytedance.ee.util.io;

import android.graphics.BitmapFactory;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f243144a = null;

    static {
        HashMap r100 = new HashMap();
        f243144a = r100;
        r100.put("ffd8ffe000104a464946", "jpg");
        r100.put("89504e470d0a1a0a0000", LoadParams.ImageFormat.PNG);
        r100.put("47494638396126026f01", "gif");
        r100.put("49492a00227105008037", "tif");
        r100.put("424d", "bmp");
        r100.put("41433130313500000000", "dwg");
        r100.put("3c21444f435459504520", "html");
        r100.put("3c21646f637479706520", "htm");
        r100.put("48544d4c207b0d0a0942", GXTemplateKey.GAIAX_CSS);
        r100.put("696b2e71623d696b2e71", GXTemplateKey.GAIAX_JS);
        r100.put("7b5c727466315c616e73", "rtf");
        r100.put("38425053000100000000", "psd");
        r100.put("46726f6d3a203d3f6762", "eml");
        r100.put("d0cf11e0a1b11ae10000", "doc");
        r100.put("d0cf11e0a1b11ae10000", "vsd");
        r100.put("5374616E64617264204A", "mdb");
        r100.put("252150532D41646F6265", "ps");
        r100.put("255044462d312e360d25", ExportFileExtension.PDF);
        r100.put("2e524d46000000120001", "rmvb");
        r100.put("464c5601050000000900", "flv");
        r100.put("00000020667479706973", "mp4");
        r100.put("49443303000000000f76", TTVideoEngineInterface.FORMAT_TYPE_MP3);
        r100.put("000001ba210001000180", "mpg");
        r100.put("3026b2758e66cf11a6d9", "wmv");
        r100.put("4d546864000000060001", "mid");
        r100.put("504b0304140000000800", "zip");
        r100.put("526172211a0700cf9073", "rar");
        r100.put("235468697320636f6e66", "ini");
        r100.put("504b03040a0000000000", "jar");
        r100.put("4d5a9000030000000400", "exe");
        r100.put("3c25402070616765206c", "jsp");
        r100.put("4d616e69666573742d56", "mf");
        r100.put("3c3f786d6c2076657273", "xml");
        r100.put("efbbbf2f2a0d0a53514c", "sql");
        r100.put("7061636b616765207765", "java");
        r100.put("406563686f206f66660d", "bat");
        r100.put("1f8b0800000000000000", "gz");
        r100.put("6c6f67346a2e726f6f74", "properties");
        r100.put("cafebabe0000002e0041", "class");
        r100.put("49545346030000006000", "chm");
        r100.put("04000000010000001300", "mxp");
        r100.put("504b0304140006000800", DocumentType.DOCX_NAME);
        r100.put("d0cf11e0a1b11ae10000", "wps");
        r100.put("6431303a637265617465", "torrent");
        r100.put("494d4b48010100000200", "264");
        r100.put("6D6F6F76", "mov");
        r100.put("FF575043", "wpd");
        r100.put("CFAD12FEC5FD746F", "dbx");
        r100.put("2142444E", "pst");
        r100.put("AC9EBD8F", "qdf");
        r100.put("E3828596", "pwl");
        r100.put("2E7261FD", "ram");
    }

    public static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100.length > 0) goto L6;
        return null;
    L6:
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        String r103 = Integer.toHexString(r100[r102] & UByte.MAX_VALUE);
        if (r103.length() >= 2) goto L12;
        r101.append(0);
    L12:
        r101.append(r103);
        r102 = r102 + 1;
        goto L8
    L14:
        return r101.toString();
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x00b1: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:16777393), block:B:37:0x00b1 */
    public static String b(VFSPath r100) {
        Closeable r101 = null;
        String r102 = null;
        r102 = null;
        r102 = null;
        InputStream r103 = r100.toFile().newInputStream();     // Catch: Throwable -> L38 IOException -> L40 FileNotFoundException -> L43
    L52:
        byte[] r104 = new byte[12];     // Catch: IOException -> L31 FileNotFoundException -> L33 Throwable -> L36
        r103.read(r104, 0, 12);     // Catch: IOException -> L31 FileNotFoundException -> L33 Throwable -> L36
        String r105 = new String(r104, StandardCharsets.UTF_8);     // Catch: IOException -> L31 FileNotFoundException -> L33 Throwable -> L36
        if (r105.contains("RIFF") == true) goto L8;
    L22:
        String r106 = a(r104).substring(0, 6);     // Catch: IOException -> L31 FileNotFoundException -> L33 Throwable -> L36
        Iterator r107 = ((HashMap) f243144a).keySet().iterator();     // Catch: IOException -> L31 FileNotFoundException -> L33 Throwable -> L36
        tt5.a.h("FileTypeUtils", "getFileType: fileCode=" + r106);     // Catch: IOException -> L31 FileNotFoundException -> L33 Throwable -> L36
    L24:
        if (r107.hasNext() == false) goto L35;
        String r108 = (String) r107.next();     // Catch: IOException -> L31 FileNotFoundException -> L33 Throwable -> L36
        if (r108.toLowerCase().startsWith(r106.toLowerCase()) == true) goto L29;
        if (r106.toLowerCase().startsWith(r108.toLowerCase()) == false) goto L24;
    L29:
        r102 = (String) ((HashMap) f243144a).get(r108);     // Catch: IOException -> L31 FileNotFoundException -> L33 Throwable -> L36
        goto L35
    L35:
        FileUtils.d(r103);
        tt5.a.h("FileTypeUtils", "getFileType:  res=" + r102);
        return r102;
    L8:
        if (r105.contains("WEBP") == false) goto L13;
        FileUtils.d(r103);
        return "webp";
    L13:
        if (r105.contains("AVI") == false) goto L18;
        FileUtils.d(r103);
        return "avi";
    L18:
        if (r105.contains("WAV") == false) goto L22;
        FileUtils.d(r103);
        return "wav";
    L33:
        e = e;
    L45:
        tt5.a.e("FileTypeUtils", "getFileType: FileNotFoundException, path=" + r100, e, false);     // Catch: Throwable -> L36
    L31:
        e = e;
    L42:
        tt5.a.e("FileTypeUtils", "getFileType: IOException, path=" + r100, e, false);     // Catch: Throwable -> L36
    L36:
        th = th;
        r101 = r4;
    L49:
        FileUtils.d(r101);
        throw th;
    L43:
        e = e;
        r103 = null;
    L40:
        e = e;
        r103 = null;
    L38:
        th = th;
        goto L49
    }

    public static boolean c(VFSPath r100) {
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (r100.toFile().exists() == false) goto L13;
        BitmapFactory.Options r101 = new BitmapFactory.Options();     // Catch: Exception -> L11
        r101.inJustDecodeBounds = true;     // Catch: Exception -> L11
        BitmapFactory.decodeStream(ay4.d.a().l(r100), null, r101);     // Catch: Exception -> L11
        if (r101.outHeight <= 0) goto L16;
        return true;
    L16:
        return false;
    L11:
        e = move-exception;
        tt5.a.f("FileTypeUtils", e, false);
        goto L13
    }
}
