package com.ss.android.lark.filedetail.impl.detail;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FileHitPointUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f421568a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f421569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f421570b;

        public final void a() {
            Lazy r100 = FileHitPointUtil.f421568a;
            if (FileHitPointUtil.b(this.f421569a).length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L10;
            FileHitPointUtil.a(this.f421570b);
            return;
        L10:
            return;
        L5:
            r101 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(int r100, String r101, FileContent r102, String r103) {
            this.f421569a = r100;
            this.f421570b = r101;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f421571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f421572b;

        public final void a() {
            Lazy r100 = FileHitPointUtil.f421568a;
            if (FileHitPointUtil.b(this.f421571a).length() != 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L10;
            FileHitPointUtil.a(this.f421572b);
            return;
        L10:
            return;
        L5:
            r101 = false;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(int r100, String r101, FileContent r102, String r103) {
            this.f421571a = r100;
            this.f421572b = r101;
        }
    }

    public FileHitPointUtil() {
    }

    public static final String b(int r100) {
        switch(r100) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L3;
        };
    L3:
        return "";
    L4:
        return "favorites";
    L5:
        return "pin";
    L6:
        return "search";
    L7:
        return "chat_history";
    L8:
        return "thread";
    L9:
        return PullConfiguration.PROCESS_NAME_MAIN;
    }

    static {
        f421568a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, FileHitPointUtil$chatDependency$2.INSTANCE);
    }

    public static final Chat a(String r100) {
        if (r100 == null) goto L6;
        ((hfb.b.d) f421568a.getValue()).b();
        return null;
    L6:
        return null;
    }

    @JvmStatic
    public static final void c(String r100, FileContent r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "fileContent");
        Intrinsics.checkNotNullParameter(r103, com.alipay.sdk.m.p.e.f25671s);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(r102, r100, r101, r103));
    }

    @JvmStatic
    public static final void d(String r100, FileContent r101, int r102, FileDownloadState r103, String r104) {
        Intrinsics.checkNotNullParameter(r101, "fileContent");
        Intrinsics.checkNotNullParameter(r103, "state");
        Intrinsics.checkNotNullParameter(r104, com.alipay.sdk.m.p.e.f25671s);
        if (r103 == FileDownloadState.DOWNLOADING) goto L5;
        return;
    L5:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new b(r102, r100, r101, r104));
    }
}
