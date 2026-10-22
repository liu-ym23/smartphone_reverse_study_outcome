package com.ss.android.tecommonenvinitializer.diagnosis;

import android.content.Context;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.tecommonenvinitializer.MultiMediaEnv;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f449597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f449598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f449599c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f449600d;

    public static final class a {
        @JvmStatic
        public static boolean c() {
            if (c.f449600d == true) goto L5;
            return true;
        L5:
            Context r100 = MultiMediaEnv.f449589a.getContext();
            if (r100 != null) goto L111;
            return false;
        L111:
            PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), "temp_ve_libs");     // Catch: Throwable -> L110
            if (r101.exists() == true) goto L112;
            if (r101.mkdirs() == true) goto L112;
            Intrinsics.stringPlus("Failed to create internal directory: ", r101.getAbsolutePath());     // Catch: Throwable -> L110
            return false;
        L112:
            File[] r102 = r101.listFiles();     // Catch: Exception -> L31 Throwable -> L110
            if (r102 == null) goto L33;
            ArrayList r103 = new ArrayList();     // Catch: Exception -> L31 Throwable -> L110
            int r104 = r102.length;     // Catch: Exception -> L31 Throwable -> L110
            int r110 = 0;
        L19:
            if (r110 >= r104) goto L34;
            File r111 = r102[r110];     // Catch: Exception -> L31 Throwable -> L110
            r110 = r110 + 1;     // Catch: Exception -> L31 Throwable -> L110
            if (r111.isFile() == true) goto L23;
        L27:
            boolean r112 = false;
        L28:
            if (r112 == false) goto L19;
            r103.add(r111);     // Catch: Exception -> L31 Throwable -> L110
            goto L19
        L23:
            if (StringsKt.startsWith$default(r111.getName(), "lib", false, 2, null) == false) goto L27;
            if (StringsKt.endsWith$default(r111.getName(), ".so", false, 2, null) == false) goto L27;
            r112 = true;
            goto L28
        L34:
            PolarisFileWrapper r105 = new PolarisFileWrapper("/data/local/tmp/ve");     // Catch: Throwable -> L110
        L55:
            e = move-exception;
            Intrinsics.stringPlus("Failed to list external libs, ", e.getMessage());     // Catch: Throwable -> L110
        L57:
            ArrayList r106 = null;
        L58:
            if (r103 == null) goto L83;
            Iterator r107 = r103.iterator();     // Catch: Throwable -> L110
        L62:
            if (r107.hasNext() == false) goto L83;
            File r108 = (File) r107.next();     // Catch: Throwable -> L110
            if (r106 == null) goto L75;
        L67:
            if (r106.isEmpty() == true) goto L75;
            Iterator r109 = r106.iterator();     // Catch: Exception -> L81 Throwable -> L110
        L71:
            if (r109.hasNext() == false) goto L75;
            if (Intrinsics.areEqual(((File) r109.next()).getName(), r108.getName()) == false) goto L71;
            boolean r113 = true;
        L76:
            if (r113 == true) goto L62;
            Intrinsics.stringPlus("Deleting internal lib no longer present externally: ", r108.getName());     // Catch: Exception -> L81 Throwable -> L110
            if (r108.delete() == true) goto L62;
            Intrinsics.stringPlus("Failed to delete internal lib: ", r108.getAbsolutePath());     // Catch: Exception -> L81 Throwable -> L110
        L81:
            e = move-exception;
            r108.getName();     // Catch: Throwable -> L110
            e.getMessage();     // Catch: Throwable -> L110
        L75:
            r113 = false;
        L83:
            if (r106 == null) goto L108;
            Iterator r114 = r106.iterator();     // Catch: Throwable -> L110
        L87:
            if (r114.hasNext() == false) goto L108;
            File r115 = (File) r114.next();     // Catch: Throwable -> L110
            if (r103 != null) goto L91;
            File r116 = null;
        L99:
            if (r116 == null) goto L103;
            int r117 = fgc.a.f476908a;     // Catch: Exception -> L105 Throwable -> L110
            if (fgc.a.C5902a.b(r116.getAbsolutePath(), r115.getAbsolutePath()) == false) goto L103;
            r116.getName();     // Catch: Exception -> L105 Throwable -> L110
            goto L87
        L105:
            e = move-exception;
            r115.getName();     // Catch: Throwable -> L110
            e.getMessage();     // Catch: Throwable -> L110
            return false;
        L103:
            PolarisFileWrapper r118 = new PolarisFileWrapper(r101.getAbsolutePath(), r115.getName());     // Catch: Exception -> L105 Throwable -> L110
            r115.getName();     // Catch: Exception -> L105 Throwable -> L110
            r118.getAbsolutePath();     // Catch: Exception -> L105 Throwable -> L110
            FilesKt.copyTo$default(r115, r118, true, 0, 4, null);     // Catch: Exception -> L105 Throwable -> L110
            goto L87
        L91:
            Iterator r119 = r103.iterator();     // Catch: Exception -> L105 Throwable -> L110
        L93:
            if (r119.hasNext() == false) goto L97;
            Object r120 = r119.next();     // Catch: Exception -> L105 Throwable -> L110
            if (Intrinsics.areEqual(((File) r120).getName(), r115.getName()) == false) goto L93;
        L98:
            r116 = (File) r120;     // Catch: Exception -> L105 Throwable -> L110
            goto L99
        L97:
            r120 = null;
        L108:
            c.f449600d = false;     // Catch: Throwable -> L110
            return true;
        L36:
            if (r105.exists() == false) goto L57;
            if (r105.isDirectory() == false) goto L57;
            File[] r121 = r105.listFiles();     // Catch: Exception -> L55 Throwable -> L110
            if (r121 == null) goto L57;
            r106 = new ArrayList();     // Catch: Exception -> L55 Throwable -> L110
            int r122 = r121.length;     // Catch: Exception -> L55 Throwable -> L110
            int r123 = 0;
        L43:
            if (r123 >= r122) goto L58;
            File r124 = r121[r123];     // Catch: Exception -> L55 Throwable -> L110
            r123 = r123 + 1;     // Catch: Exception -> L55 Throwable -> L110
            if (r124.isFile() == true) goto L47;
        L51:
            boolean r125 = false;
        L52:
            if (r125 == false) goto L43;
            r106.add(r124);     // Catch: Exception -> L55 Throwable -> L110
            goto L43
        L47:
            if (StringsKt.startsWith$default(r124.getName(), "lib", false, 2, null) == false) goto L51;
            if (StringsKt.endsWith$default(r124.getName(), ".so", false, 2, null) == false) goto L51;
            r125 = true;
            goto L52
        L33:
            r103 = null;
        L31:
            e = move-exception;
            Intrinsics.stringPlus("Failed to list internal libs, ", e.getMessage());     // Catch: Throwable -> L110
        L110:
            return false;
        }

        public a() {
        }

        @JvmStatic
        public static String a(Context r100, String r101) {
            if (StringsKt.isBlank(r101) == true) goto L10;
            if (r100 == null) goto L10;
            String r102 = new PolarisFileWrapper(new PolarisFileWrapper(r100.getFilesDir(), "temp_ve_libs"), "lib" + r101 + ".so").getAbsolutePath();
            if (new PolarisFileWrapper(r102).exists() == true) goto L9;
            return null;
        L9:
            return r102;
        L10:
            return null;
        }

        @JvmStatic
        public final synchronized boolean b(List<String> r100, Function1<? super List<String>, Boolean> r101) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r100, "libs");     // Catch: Throwable -> L51
            Intrinsics.checkNotNullParameter(r101, "fallbackLoader");     // Catch: Throwable -> L51
            MultiMediaEnv.a r102 = MultiMediaEnv.f449589a;     // Catch: Throwable -> L51
            if (MultiMediaEnv.f449591c != 1) goto L6;
            boolean r103 = MultiMediaEnv.f449592d.getValue().f449601a;     // Catch: Throwable -> L51
        L12:
            if (r103 == true) goto L17;
            boolean r104 = r101.invoke(r100).booleanValue();     // Catch: Throwable -> L51
            monitor-exit(this);
            return r104;
        L17:
            if (c() == true) goto L21;
            boolean r105 = r101.invoke(r100).booleanValue();     // Catch: Throwable -> L51
            monitor-exit(this);
            return r105;
        L21:
            Iterator<T> r106 = r100.iterator();     // Catch: Throwable -> L51
        L23:
            if (r106.hasNext() == false) goto L49;
            String r107 = (String) r106.next();     // Catch: Throwable -> L51
            if (((ArrayList) c.f449599c).contains(r107) == true) goto L23;
            a r108 = c.f449597a;     // Catch: Throwable -> L51
            String r109 = a(MultiMediaEnv.f449589a.getContext(), r107);     // Catch: Throwable -> L51
            if (r109 != null) goto L30;
        L33:
            boolean r110 = true;
        L34:
            if (r110 == false) goto L54;
            boolean r111 = r101.invoke(CollectionsKt.listOf(r107)).booleanValue();     // Catch: Throwable -> L51
        L43:
            if (r111 == false) goto L44;
            ((ArrayList) c.f449599c).add(r107);     // Catch: Throwable -> L51
            goto L23
        L44:
            Intrinsics.stringPlus("Failed to load ", r107);     // Catch: Throwable -> L51
            monitor-exit(this);
            return false;
        L54:
            System.load(r109);     // Catch: Throwable -> L39 Exception -> L41
            r111 = true;
            goto L43
        L41:
            e = move-exception;
            e.getMessage();     // Catch: Throwable -> L39
            r111 = r101.invoke(CollectionsKt.listOf(r107)).booleanValue();     // Catch: Throwable -> L39
        L39:
            th = move-exception;
            throw th;     // Catch: Throwable -> L51
        L30:
            if (StringsKt.isBlank(r109) == true) goto L33;
            r110 = false;
            goto L34
        L49:
            monitor-exit(this);
            return true;
        L6:
            Boolean r112 = c.f449598b;     // Catch: Throwable -> L51
            if (r112 != null) goto L9;
        L11:
            r103 = false;
            goto L12
        L9:
            if (Intrinsics.areEqual(r112, Boolean.TRUE) == false) goto L11;
            r103 = true;
        L51:
            th = move-exception;
            throw th;
        }
    }

    static {
        f449597a = new a();
        PolarisFileWrapper r100 = new PolarisFileWrapper("/data/local/tmp/ve/loadso_hook.json");
        if (r100.exists() == true) goto L11;
    L9:
        f449599c = new ArrayList();
        f449600d = true;
        return;
    L11:
        Boolean r101 = Boolean.valueOf(JSONObjectProtectorUtils.getBoolean(new JSONObject(FilesKt.readText$default(r100, null, 1, null)), "enable"));     // Catch: Exception -> L7
    L8:
        f449598b = r101;
    L7:
        r101 = Boolean.FALSE;
        goto L8
    }
}
