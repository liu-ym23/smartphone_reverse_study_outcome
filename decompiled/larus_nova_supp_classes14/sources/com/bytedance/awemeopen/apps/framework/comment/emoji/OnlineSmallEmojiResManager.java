package com.bytedance.awemeopen.apps.framework.comment.emoji;

import android.app.Application;
import com.bytedance.awemeopen.apps.framework.comment.emoji.model.OnlineSmallEmojiRes;
import com.bytedance.awemeopen.apps.framework.comment.emoji.model.OnlineSmallEmojiResInfo;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.net.AoFromSource;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoRequestType;
import com.bytedance.awemeopen.infra.base.net.download.AoDownloadCallback;
import com.bytedance.awemeopen.infra.base.net.download.AoDownloadRequest;
import com.bytedance.awemeopen.infra.base.net.download.BdpDownloadModule;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisZipFileWrapper;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class OnlineSmallEmojiResManager {
    public static final OnlineSmallEmojiResManager i = null;
    public OnlineSmallEmojiResInfo a;
    public final Lazy b;
    public final Map<String, String> c;
    public final Lazy d;
    public OnlineSmallEmojiCache e;
    public volatile String f;
    public volatile int g;
    public volatile boolean h;

    public static final class a {
    }

    static {
        i = new OnlineSmallEmojiResManager();
    }

    public final boolean c() {
        if (this.g != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        AoLogger.b("OnlineEmojiResManager", new Object[]{" not enabled: " + this.g});
    L8:
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    public final void d() {
        monitor-enter(com.bytedance.awemeopen.apps.framework.comment.emoji.a.class);
        com.bytedance.awemeopen.apps.framework.comment.emoji.a r1 = com.bytedance.awemeopen.apps.framework.comment.emoji.a.C0069a.a;     // Catch: Throwable -> L15
        monitor-exit(com.bytedance.awemeopen.apps.framework.comment.emoji.a.class);
        final String r0 = r1.a.getString("key_small_emoji_md5", "");
        if (r0.length() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        AoLogger.b("OnlineEmojiResManager", new Object[]{"preloadResourceInfo lastCacheMd5 empty"});
        return;
    L13:
        this.f = r0;
        this.g = 1;
        AoPool.a(new OnlineSmallEmojiResManager$loadResourceInfo$1(r0, this));
        return;
    L9:
        r2 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public final void f() {
        boolean r3 = true;
        if (com.bytedance.awemeopen.apps.framework.launchconfig.a.a == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r1 = "emoticon_new_android";
    L9:
        JSONObject r4 = AoSettings.a("ao_resource_config");
        String r5 = null;
        if (r4 == null) goto L12;
        JSONObject r2 = r4.optJSONObject(r1);
    L13:
        if (r2 == null) goto L15;
        final String r6 = r2.optString("package_md5");
    L16:
        if (r2 == null) goto L18;
        r5 = r2.optString("package_url");
    L18:
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L64;
        if (r5 != null) goto L28;
    L31:
        boolean r8 = true;
    L32:
        if (r8 == true) goto L64;
        if (this.h == false) goto L37;
        return;
    L37:
        this.h = true;
        AoLogger.b("OnlineEmojiResManager", new Object[]{"refreshEmoji start"});
        monitor-enter(com.bytedance.awemeopen.apps.framework.comment.emoji.a.class);
        com.bytedance.awemeopen.apps.framework.comment.emoji.a r9 = com.bytedance.awemeopen.apps.framework.comment.emoji.a.C0069a.a;     // Catch: Throwable -> L60
        monitor-exit(com.bytedance.awemeopen.apps.framework.comment.emoji.a.class);
        String r10 = r9.a.getString("key_small_emoji_md5", "");
        final OnlineSmallEmojiRes r11 = new OnlineSmallEmojiRes(r5, r6);
        if (Intrinsics.areEqual(r6, r10) == false) goto L58;
        d r12 = d.a;
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNullParameter(r6, "md5");
        PolarisFileWrapper r13 = new PolarisFileWrapper(d.b(r6));
        if (r13.exists() == true) goto L46;
    L49:
        boolean r14 = true;
    L50:
        if (r14 == true) goto L58;
        JSONObject r15 = AoSettings.a("ao_feature_bugfix");
        if (r15 == null) goto L54;
        r3 = r15.optBoolean("ao_async_clear", true);
    L54:
        if (r3 == false) goto L56;
        AoPool.a(new OnlineSmallEmojiResManager$refreshEmoji$1(this, r6));
        return;
    L56:
        b(r6);
        this.h = false;
        return;
    L46:
        if (r13.isDirectory() == false) goto L49;
        r14 = false;
    L58:
        StringBuilder r16 = new StringBuilder();
        d r17 = d.a;
        r16.append(d.b + "tmp/");
        String r18 = r11.getMd5();
        Intrinsics.checkNotNull(r18);
        Intrinsics.checkNotNullParameter(r18, "md5");
        r16.append(r18 + ".zip");
        final PolarisFileWrapper r19 = new PolarisFileWrapper(r16.toString());
        Function0 r20 = AoNet.a;
        AoFromSource r21 = AoFromSource.download;
        Intrinsics.checkNotNullParameter(r21, "from");
        AoRequestType r110 = AoRequestType.HOST;
        ArrayList r22 = new ArrayList();
        String r23 = r11.getResourceUrl();
        Intrinsics.checkNotNull(r23);
        Intrinsics.checkNotNullParameter(r23, "url");
        Intrinsics.checkNotNullParameter(r19, "targetFile");
        AoDownloadRequest r24 = new AoDownloadRequest(r23, r19, r21, null, new q64.c(r22), false, false, false, r110, 60000, 0, r11.getMd5(), true, true, 0, null);
        AoDownloadCallback r25 = new OnlineSmallEmojiResManager$downloadResource$1(this, r11, r19);
        Intrinsics.checkNotNullParameter(r24, "request");
        ConcurrentHashMap r26 = BdpDownloadModule.a;
        BdpDownloadModule.a((Application) AoNet.c.getValue(), r24, r25);
        return;
    L60:
        th = move-exception;
        throw th;
    L28:
        if (r5.length() == 0) goto L31;
        r8 = false;
    L64:
        AoLogger.b("OnlineEmojiResManager", new Object[]{"refreshEmoji, md5=" + r6 + ", url=" + r5 + ", md5 or url is null"});
        return;
    L20:
        if (r6.length() == 0) goto L23;
        r7 = false;
        goto L25
    L15:
        r6 = null;
        goto L16
    L12:
        r2 = null;
        goto L13
    L8:
        r1 = "emoticon_android";
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    public OnlineSmallEmojiResManager() {
        this.b = LazyKt.lazy(OnlineSmallEmojiResManager$emojiNameIdMap$2.INSTANCE);
        this.c = new LinkedHashMap();
        this.d = LazyKt.lazy(OnlineSmallEmojiResManager$panelEmojiNameMap$2.INSTANCE);
        this.f = "";
        d();
    }

    public final void b(String r6) {
        d r0 = d.a;
        int r1 = this.g;
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L7;
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L15:
        r0.a(new String[]{r6});
        return;
    L10:
        if (this.f.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        r0.a(new String[]{this.f, r6});
        return;
    L12:
        r3 = false;
    L7:
        r2 = true;
        goto L8
    }

    public final String e(String r5) {
        if (c() == true) goto L5;
        return null;
    L5:
        String r0 = (String) ((LinkedHashMap) this.b.getValue()).get(r5);
        if (r0 != null) goto L9;
        AoLogger.b("OnlineEmojiResManager", new Object[]{" mapResource not found: " + r5});
        return null;
    L9:
        return r0;
    }

    public static final void a(OnlineSmallEmojiResManager r12, OnlineSmallEmojiRes r13, String r14) {
        r12.getClass();
        d r0 = d.a;
        String r1 = r13.getMd5();
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNullParameter(r14, "zipFilePath");
        Intrinsics.checkNotNullParameter(r1, "md5");
        PolarisFileWrapper r3 = new PolarisFileWrapper(r14);
        Unit r8 = null;
        if (r3.exists() == true) goto L6;
        AoLogger.b("OnlineEmojiFileHelper isZipFileValid: zFile not exist: " + r14 + ", " + r1, new Object[0]);
    L22:
        boolean r2 = false;
    L24:
        if (r2 == true) goto L28;
        r0 = null;
    L28:
        if (r0 == null) goto L89;
        String r4 = r13.getMd5();
        Intrinsics.checkNotNull(r4);
        String r5 = d.b(r4);
        Intrinsics.checkNotNullParameter(r14, "zipFilePath");
        Intrinsics.checkNotNullParameter(r5, "outputDirPath");
        PolarisFileWrapper r6 = new PolarisFileWrapper(r5);
        if (r6.exists() == false) goto L32;
        d.c(r5);
    L32:
        r6.mkdirs();
        PolarisFileWrapper r7 = new PolarisFileWrapper(r14);
        if (r7.exists() == true) goto L35;
    L76:
        r7.delete();
        AoLogger.b("OnlineEmojiFileHelper unZipFile zipFile invalid: " + r14 + ", " + r5, new Object[0]);
    L77:
        boolean r9 = false;
    L78:
        if (r9 == false) goto L87;
        AoLogger.b("OnlineEmojiResManager", new Object[]{"unZip success"});
        r12.b(r13.getMd5());
        monitor-enter(com.bytedance.awemeopen.apps.framework.comment.emoji.a.class);
        com.bytedance.awemeopen.apps.framework.comment.emoji.a r10 = com.bytedance.awemeopen.apps.framework.comment.emoji.a.C0069a.a;     // Catch: Throwable -> L84
        monitor-exit(com.bytedance.awemeopen.apps.framework.comment.emoji.a.class);
        r10.a.edit().putString("key_small_emoji_md5", r13.getMd5()).commit();
        r12.d();
    L88:
        r8 = Unit.INSTANCE;
    L84:
        th = move-exception;
        throw th;
    L87:
        AoLogger.b("OnlineEmojiResManager", new Object[]{"unZip failed"});
        d r15 = d.a;
        d.c(r5);
        goto L88
    L35:
        if (StringsKt.endsWith$default(r7.getName(), ".zip", false, 2, null) == false) goto L76;
        PolarisZipFileWrapper r16 = new PolarisZipFileWrapper(r7);     // Catch: Exception -> L74
        Iterator r11 = CollectionsKt.iterator(r16.entries());     // Catch: Throwable -> L69
        r9 = false;
    L40:
        if (r11.hasNext() == false) goto L66;
        ZipEntry r17 = (ZipEntry) r11.next();     // Catch: Throwable -> L69
        if (StringsKt.startsWith$default(r17.getName(), "emoji_", false, 2, null) == false) goto L65;
        if (StringsKt.contains$default(r17.getName(), "../", false, 2, null) == true) goto L65;
        r17.getName();     // Catch: Throwable -> L69
        PolarisFileWrapper r18 = new PolarisFileWrapper(r6, r17.getName());     // Catch: Throwable -> L69
        if (r17.isDirectory() == false) goto L49;
        r18.mkdirs();     // Catch: Throwable -> L69
    L54:
        r9 = true;
        goto L40
    L49:
        InputStream r19 = r16.getInputStream(r17);     // Catch: Throwable -> L69
        PolarisFileOutputStreamWrapper r20 = new PolarisFileOutputStreamWrapper(r18);     // Catch: Throwable -> L60
        ByteStreamsKt.copyTo$default(r19, r20, 0, 2, null);     // Catch: Throwable -> L55
        CloseableKt.closeFinally(r20, null);     // Catch: Throwable -> L60
        CloseableKt.closeFinally(r19, null);     // Catch: Throwable -> L69
        goto L54
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        CloseableKt.closeFinally(r20, th);     // Catch: Throwable -> L60
        throw th;     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        CloseableKt.closeFinally(r19, th);     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L65:
        r17.getName();     // Catch: Throwable -> L69
        goto L40
    L66:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L69
        CloseableKt.closeFinally(r16, null);     // Catch: Exception -> L74
    L69:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Exception -> L74
        throw th;     // Catch: Exception -> L74
    L74:
        e = move-exception;
        AoLogger.b("OnlineEmojiFileHelper unZipFile cause exception: " + e.getMessage(), new Object[0]);
    L89:
        if (r8 != null) goto L91;
        AoLogger.b("OnlineEmojiResManager", new Object[]{"resource zip not valid"});
    L91:
        PolarisFileWrapper r110 = new PolarisFileWrapper(d.b + "tmp/");
        if (r110.isDirectory() == false) goto L94;
        d r111 = d.a;
        d.c(r110.getAbsolutePath());
        return;
    L94:
        r110.delete();
        return;
    L6:
        if (r3.isFile() == true) goto L105;
        AoLogger.b("OnlineEmojiFileHelper isZipFileValid: zFile not a file: " + r14 + ", " + r1, new Object[0]);
        goto L22
    L105:
        MessageDigest r22 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L17
        if (r22 == null) goto L18;
        PolarisFileInputStreamWrapper r23 = new PolarisFileInputStreamWrapper(r3);     // Catch: Exception -> L17
        byte[] r112 = new byte[8192];     // Catch: Exception -> L17
    L12:
        int r113 = r23.read(r112, 0, 8192);     // Catch: Exception -> L17
        if (r113 <= 0) goto L15;
        r22.update(r112, 0, r113);     // Catch: Exception -> L17
        goto L12
    L15:
        r23.close();     // Catch: Exception -> L17
        String r24 = com.bytedance.awemeopen.infra.base.net.a.a(r22.digest());     // Catch: Exception -> L17
    L20:
        if (Intrinsics.areEqual(r1, r24) == true) goto L23;
        AoLogger.b("OnlineEmojiFileHelper isZipFileValid: md5 not match: " + r14 + ", " + r1 + ", " + r24, new Object[0]);
        goto L22
    L23:
        r2 = true;
    L18:
        r24 = null;
        goto L20
    }
}
