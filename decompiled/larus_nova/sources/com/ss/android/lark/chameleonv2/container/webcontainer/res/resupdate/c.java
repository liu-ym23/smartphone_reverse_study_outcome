package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import android.text.TextUtils;
import com.bytedance.ee.bear.libarchive.Archive;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonAssertResManager;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import swb.m;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f411278a = 0;

    static {
    }

    public static VFSPath k() {
        return LarkFileStorage.b().b(f.f440957d, new com.ss.android.lark.storage.d(new String[]{"chameleon"}));
    }

    public static void a(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        j.d(ChameleonResUtils.TAG, e);
        return;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0064: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:16777316), block:B:29:0x0064 */
    public static String b(InputStream r100) {
        StringBuffer r101 = new StringBuffer();
        Closeable r102 = null;
        if (r100 != null) goto L35;
    L18:
        j.b(ChameleonResUtils.TAG, "convertString()... steam is invalid");     // Catch: Throwable -> L21 IOException -> L23
        String r103 = r101.toString();     // Catch: Throwable -> L21 IOException -> L23
        a(r100);
        return r103;
    L35:
    L23:
        e = move-exception;
        BufferedReader r104 = null;
        IOException e100 = e;
    L25:
        j.d(ChameleonResUtils.TAG, e100);     // Catch: Throwable -> L28
    L26:
        a(r100);
        a(r104);
        return r101.toString();
    L21:
        th = th;
    L30:
        a(r100);
        a(r102);
        throw th;
    L5:
        if (r100.available() <= 0) goto L18;
        r104 = new BufferedReader(new InputStreamReader(r100));     // Catch: Throwable -> L21 IOException -> L23
        String r105 = null;
    L33:
        String r106 = r104.readLine();     // Catch: IOException -> L16 Throwable -> L28
        if (r106 == null) goto L12;
        r105 = r106;
    L13:
        if (r106 == null) goto L26;
        r101.append(r105 + System.getProperty("line.separator"));     // Catch: IOException -> L16 Throwable -> L28
        goto L33
    L12:
        r106 = null;
    L16:
        e100 = e;
    L28:
        th = th;
        r102 = r3;
        goto L30
    }

    public static VFSFile c(ChameleonConfig r100) {
        VFSPath r101 = k();
        if (r100 == null) goto L7;
        String r102 = r100.getBizName();
        if (r102 == null) goto L7;
        r101 = r101.subPath(r102);
    L7:
        VFSPath r103 = r101.subPath(ChameleonAssertResManager.ASSET_FOLDER);
        if (com.suite.lark.component.storage.ext.b.b(r103) == false) goto L13;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        VFSFiles.f444819b.getClass();
        if (VFSFiles.a(r103).isFile(r103) == false) goto L12;
        com.suite.lark.component.storage.ext.b.delete(r103);
    L12:
        com.suite.lark.component.storage.ext.b.d(r103);
    L15:
        return r103.toFile();
    L13:
        com.suite.lark.component.storage.ext.b.d(r103);
        goto L15
    }

    public static String d(VFSFile r110) {
        VFSFile r100 = null;
        if (r110 != null) goto L39;
        VFSFile[] r111 = null;
    L9:
        if (r111 != null) goto L11;
    L17:
        boolean r101 = true;
    L18:
        if (r101 == false) goto L21;
        j.e(ChameleonResUtils.TAG, "getLatestResourceVersion(): resourceRootDir is empty");     // Catch: IOException -> L5
        return "";
    L21:
        ArrayList r102 = new ArrayList();     // Catch: IOException -> L5
        int r103 = r111.length;     // Catch: IOException -> L5
        int r104 = 0;
    L22:
        if (r104 >= r103) goto L30;
        VFSFile r105 = r111[r104];     // Catch: IOException -> L5
        String r106 = r105.getName();     // Catch: IOException -> L5
        if (TextUtils.isEmpty(r106) == false) goto L26;
        boolean r107 = false;
    L27:
        if (r107 == false) goto L29;
        r102.add(r105);     // Catch: IOException -> L5
    L29:
        r104 = r104 + 1;     // Catch: IOException -> L5
        goto L22
    L26:
        r107 = Pattern.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$", r106);     // Catch: IOException -> L5
        goto L27
    L30:
        Collections.sort(r102, new swb.f());     // Catch: IOException -> L5
        if ((!r102.isEmpty()) == false) goto L33;
        r100 = (VFSFile) ListProtector.remove(r102, 0);     // Catch: IOException -> L5
    L33:
        if (r100 != null) goto L36;
        return "";
    L36:
        return r100.getName();
    L11:
        if (r111.length != 0) goto L13;
        boolean r108 = true;
    L14:
        if (r108 == true) goto L17;
        r101 = false;
        goto L18
    L13:
        r108 = false;
        goto L14
    L39:
        r111 = r110.listFiles();     // Catch: IOException -> L5
    L5:
        e = move-exception;
        j.c(ChameleonResUtils.TAG, "getLatestResourceVersion(): failed ", e);
        return "";
    }

    public static String e(VFSPath r100) {
        if (r100 == null) goto L15;
        VFSPath r101 = r100.subPath(ChameleonResConstants.TEMPLATE_VERSION);
        if (r101.toFile().isFile() == true) goto L6;
        return "";
    L6:
        if (r101.toFile().exists() == false) goto L17;
        return f(new BufferedReader(new PolarisFileReaderWrapper(r101.toFile())));
    L9:
        e = move-exception;
        j.d(ChameleonResUtils.TAG, e);
        return "";
    L17:
        return "";
    L15:
        return "";
    }

    public static String f(BufferedReader r100) {
    L43:
        String r101 = r100.readLine();     // Catch: Throwable -> L35 Exception -> L37
        if (r101 == null) goto L39;
        boolean r102 = false;
        if (StringsKt.startsWith$default(r101, "version", false, 2, null) != true) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L43;
        List<String> r104 = new Regex(":").split(r101, 0);     // Catch: Throwable -> L35 Exception -> L37
        if (r104 != null) goto L13;
    L26:
        String[] r105 = null;
    L27:
        if (r105 != null) goto L29;
    L31:
        if (r102 == false) goto L43;
        String r106 = r105[1];     // Catch: Throwable -> L35 Exception -> L37
        a(r100);
        return r106;
    L29:
        if (r105.length != 2) goto L31;
        r102 = true;
        goto L31
    L13:
        if (r104.isEmpty() == true) goto L23;
        ListIterator<String> r107 = r104.listIterator(r104.size());     // Catch: Throwable -> L35 Exception -> L37
    L16:
        if (r107.hasPrevious() == false) goto L23;
        if (r107.previous().length() != 0) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == true) goto L16;
        List r109 = CollectionsKt.take(r104, r107.nextIndex() + 1);     // Catch: Throwable -> L35 Exception -> L37
    L24:
        if (r109 == null) goto L26;
        r105 = (String[]) r109.toArray(new String[0]);     // Catch: Throwable -> L35 Exception -> L37
        goto L27
    L20:
        r108 = false;
    L23:
        r109 = CollectionsKt.emptyList();     // Catch: Throwable -> L35 Exception -> L37
        goto L24
    L8:
        r103 = false;
    L39:
        a(r100);
        return null;
    L35:
        th = move-exception;
        a(r100);
        throw th;
    L37:
        e = move-exception;
        j.d(ChameleonResUtils.TAG, e);     // Catch: Throwable -> L35
        goto L39
    }

    public static b g(BufferedReader r100) {
        b r101 = new b(0);
    L42:
        String r102 = r100.readLine();     // Catch: Throwable -> L34 IOException -> L36
        if (r102 == null) goto L38;
        String[] r103 = null;
        if (StringsKt.startsWith$default(r102, "version", false, 2, null) != true) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L42;
        List<String> r105 = new Regex(":").split(r102, 0);     // Catch: Throwable -> L34 IOException -> L36
        if (r105 != null) goto L13;
    L26:
        if (r103 != null) goto L28;
    L30:
        boolean r106 = false;
    L31:
        if (r106 == false) goto L42;
        r101.f411277b = r103[1];     // Catch: Throwable -> L34 IOException -> L36
        goto L42
    L28:
        if (r103.length != 2) goto L30;
        r106 = true;
        goto L31
    L13:
        if (r105.isEmpty() == true) goto L23;
        ListIterator<String> r107 = r105.listIterator(r105.size());     // Catch: Throwable -> L34 IOException -> L36
    L16:
        if (r107.hasPrevious() == false) goto L23;
        if (r107.previous().length() != 0) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == true) goto L16;
        List r109 = CollectionsKt.take(r105, r107.nextIndex() + 1);     // Catch: Throwable -> L34 IOException -> L36
    L24:
        if (r109 == null) goto L26;
        r103 = (String[]) r109.toArray(new String[0]);     // Catch: Throwable -> L34 IOException -> L36
        goto L26
    L20:
        r108 = false;
    L23:
        r109 = CollectionsKt.emptyList();     // Catch: Throwable -> L34 IOException -> L36
        goto L24
    L8:
        r104 = false;
    L38:
        a(r100);
        return r101;
    L34:
        th = move-exception;
        a(r100);
        throw th;
    L36:
        e = move-exception;
        j.d(ChameleonResUtils.TAG, e);     // Catch: Throwable -> L34
        goto L38
    }

    public static b h(ChameleonConfig r100, String r110) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L12;
        ResConfig r102 = r100.getResConfig();
        if (r102 == null) goto L12;
        String r103 = r102.getOfflineZipName();
        if (r103 == null) goto L12;
        List r104 = StringsKt.split$default(r103, new String[]{"."}, false, 0, 6, null);
        if (r104 == null) goto L12;
        String r105 = (String) ListProtector.get(r104, 0);
        if (r105 == null) goto L12;
    L13:
        r101.append(r105);
        r101.append(File.separator);
        r101.append(ChameleonResConstants.TEMPLATE_VERSION);
        String r106 = r101.toString();
        String r107 = m.f543778a;
        String r108 = null;
        if (TextUtils.isEmpty(r110) == false) goto L16;
    L35:
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r108) == false) goto L25;
        int r111 = -1;
    L26:
        r109.put("result", r111);     // Catch: Exception -> L32
        if (TextUtils.isEmpty(r108) == false) goto L30;
        j.b(ChameleonResUtils.TAG, "get versioninfo is null");     // Catch: Exception -> L32
        return new b(0);
    L30:
        Intrinsics.checkNotNull(r108);     // Catch: Exception -> L32
        return g(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(r108.getBytes(Charsets.UTF_8)))));
    L25:
        r111 = 0;
    L32:
        e = move-exception;
        j.b(ChameleonResUtils.TAG, "getResInfoOf7z: report event fails:" + e);
        return new b(0);
    L16:
        if (TextUtils.isEmpty(r106) == true) goto L35;
        r108 = Archive.extractEntryToString(r110, r106, null);     // Catch: IOException -> L20
    L20:
        e = move-exception;
        j.b(m.f543778a, "extractEntry :" + r106 + " fails : " + e + " message:" + e.getMessage());
    L12:
        r105 = "";
        goto L13
    }

    public static VFSFile i(ChameleonConfig r100, String r101) throws IOException {
        VFSPath r102 = k();
        if (r100 == null) goto L7;
        String r103 = r100.getBizName();
        if (r103 == null) goto L7;
        r102 = r102.subPath(r103);
    L7:
        if (r101 == null) goto L10;
        r102 = r102.subPath(r101);
    L10:
        if (com.suite.lark.component.storage.ext.b.b(r102) == false) goto L15;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        VFSFiles.f444819b.getClass();
        if (VFSFiles.a(r102).isFile(r102) == false) goto L14;
        com.suite.lark.component.storage.ext.b.delete(r102);
    L14:
        com.suite.lark.component.storage.ext.b.d(r102);
    L17:
        return r102.toFile();
    L15:
        com.suite.lark.component.storage.ext.b.d(r102);
        goto L17
    }

    public static VFSFile j(ChameleonConfig r100, UpdatePackage r101) {
        Intrinsics.checkNotNullParameter(r100, "chameleonConfig");
        String r102 = r101.getChannel();
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L13;
        return null;
    L13:
        return i(r100, r102);
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
