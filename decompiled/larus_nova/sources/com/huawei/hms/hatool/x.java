package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;

/* JADX INFO: loaded from: classes23.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277470a;

    public x() {
        this.f277470a = q0.i().getFilesDir().getPath();
    }

    private String a(String r100) {
        return this.f277470a + "/hms/component/".replace("component", r100);
    }

    private void a(String r100, String r101) {
        File r102 = new File(a(r100));
        File r103 = new File(a(r100), "hianalytics_" + r100);
        if (r102.exists() == true) goto L8;
        if (r102.mkdirs() == false) goto L8;
        v.c("hmsSdk", "file directory is mkdirs");
    L8:
        if (a(r103) == false) goto L10;
        k1.a(r103, r101);
        return;
    L10:
        v.f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
    }

    private boolean a(File r100) {
        if (r100.exists() == false) goto L10;
        return true;
    L10:
        return r100.createNewFile();
    L8:
        v.f("hmsSdk", "create new file error!");
        return false;
    }

    private char[] a(String r100, String r101, String r102, String r103) {
        byte[] r104 = HexUtil.hexStr2ByteArray(r100);
        byte[] r105 = HexUtil.hexStr2ByteArray(r101);
        byte[] r106 = HexUtil.hexStr2ByteArray(r102);
        byte[] r107 = HexUtil.hexStr2ByteArray(r103);
        int r108 = r104.length;
        if (r108 <= r105.length) goto L6;
        r108 = r105.length;
    L6:
        if (r108 <= r106.length) goto L9;
        r108 = r106.length;
    L9:
        if (r108 <= r107.length) goto L11;
        r108 = r107.length;
    L11:
        char[] r109 = new char[r108];
        int r110 = 0;
    L12:
        if (r110 >= r108) goto L14;
        r109[r110] = (char) (((r104[r110] ^ r105[r110]) ^ r106[r110]) ^ r107[r110]);
        r110 = r110 + 1;
        goto L12
    L14:
        return r109;
    }

    private String b(String r100) {
        File r101 = new File(a(r100), "hianalytics_" + r100);
        if (a(r101) == true) goto L5;
        String r102 = EncryptUtil.generateSecureRandomStr(128);
        k1.a(r101, r102);
        return r102;
    L5:
        return k1.a(r101);
    }

    private boolean b() {
        long r100 = d.a(q0.i(), "Privacy_MY", "assemblyFlash", -1);
        if ((-1) != r100) goto L7;
        v.c("hmsSdk", "First init components");
        return true;
    L7:
        if ((System.currentTimeMillis() - r100) > 31536000000L) goto L11;
        return false;
    L11:
        return true;
    }

    private static boolean b(File r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L27:
        return false;
    L5:
        if (r100.exists() == false) goto L27;
        if (r100.isDirectory() == false) goto L27;
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L27;
        if (r102.length == 0) goto L27;
        int r103 = r102.length;
    L15:
        if (r101 >= r103) goto L26;
        File r104 = r102[r101];
        if (r104.isFile() == false) goto L22;
        if (r104.delete() == true) goto L24;
        v.c("hmsSdk", "delete file failed : " + r104.getName());
    L24:
        r101 = r101 + 1;
        goto L15
    L22:
        if (r104.isDirectory() == false) goto L24;
        b(r104);
        goto L24
    L26:
        return r100.delete();
    }

    public static boolean c() {
        return b(new File(q0.i().getFilesDir().getPath() + "/hms"));
    }

    private String d() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    public String a() {
        String r100 = d();
        if (b() == false) goto L5;
        v.c("hmsSdk", "refresh components");
        String r101 = EncryptUtil.generateSecureRandomStr(128);
        a("aprpap", r101);
        String r102 = EncryptUtil.generateSecureRandomStr(128);
        a("febdoc", r102);
        String r103 = EncryptUtil.generateSecureRandomStr(128);
        a("marfil", r103);
        String r104 = EncryptUtil.generateSecureRandomStr(128);
        a("maywnj", r104);
        d.b(q0.i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
    L7:
        return HexUtil.byteArray2HexStr(PBKDF2.pbkdf2(a(r101, r102, r103, r100), HexUtil.hexStr2ByteArray(r104), 10000, 16));
    L5:
        r101 = b("aprpap");
        r102 = b("febdoc");
        r103 = b("marfil");
        r104 = b("maywnj");
        goto L7
    }
}
