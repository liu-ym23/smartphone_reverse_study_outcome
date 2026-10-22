package com.ss.android.lark.framework.assembly.sp;

import android.app.Application;
import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import com.larksuite.framework.launch.task.LaunchMode;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.SpDefaultSpConfigProviderImpl;
import com.ss.android.lark.diskmanage.storage.KAFileEncryptFileSystem;
import com.ss.android.lark.diskmanage.storage.d;
import com.ss.android.lark.e;
import com.ss.android.lark.framework.assembly.logger.InitLogTask;
import com.ss.android.lark.g;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.FileAccessCompatManager;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFS;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00152\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0015B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u001c\u0010\u0010\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00130\u00120\u0011H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/framework/assembly/sp/InitUniStoreTask;", "Lcom/larksuite/framework/launch/task/AbstractLaunchTask;", "", "<init>", "()V", "lastUid", "", "mUserListApi", "Lcom/ss/android/lark/passport_user/api/container/ILarkUserListApi;", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initKVStorage", "initFileStorage", "getCurrentUserId", "getBuiltInDependency", "", "Ljava/lang/Class;", "Lcom/larksuite/framework/launch/task/ILaunchTask;", "getUserListApi", "Companion", "sp-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitUniStoreTask extends AbstractLaunchTask<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f425727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public yzb.b f425728d;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask
    public final List<Class<? extends ILaunchTask<?>>> i() {
        ArrayList r100 = new ArrayList();
        r100.add(InitLogTask.class);
        return r100;
    }

    @Inject
    public InitUniStoreTask() {
    }

    public static final String j(InitUniStoreTask r100) {
        r100.getClass();
        int r101 = h28.a.f483630a;
        String r102 = "";
        if (LaunchMode.UNAUTHORIZED != null) goto L6;
        String r103 = "";
    L12:
        if (r103 == null) goto L16;
        r102 = r103;
    L16:
        if (Intrinsics.areEqual(r102, r100.f425727c) == true) goto L18;
        r100.f425727c = r102;
        Log.i("InitUniStoreTask", "kv storage getUserId=".concat(r102));
    L18:
        return r102;
    L6:
        if (r100.f425728d != null) goto L8;
        r100.f425728d = (yzb.b) LarkContext.spiByDwarf(yzb.b.class);
    L8:
        yzb.b r104 = r100.f425728d;
        if (r104 == null) goto L11;
        r103 = r104.c();
        goto L12
    L11:
        r103 = null;
        goto L12
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarkKVStorage r101 = LarkKVStorage.f440926a;
        c r102 = new c(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "config");
        com.ss.android.lark.storage.b r103 = new com.ss.android.lark.storage.b(r102);
        g.a r104 = g.f425765a;
        com.ss.android.lark.b r105 = (com.ss.android.lark.b) ClaymoreServiceLoader.loadFirstOrNull(com.ss.android.lark.b.class);
        if (r105 != null) goto L5;
        r105 = new SpDefaultSpConfigProviderImpl();
    L5:
        e r106 = r105.getSpConfig();
        if (r100 == null) goto L10;
        g.f425765a = r103;
        g5c.b r107 = r106.f420584a;
        Log.i("SpInit", "init sp creator: " + r107.type());
        r107.init(r100);
        g5c.c.f480110a = r107;
        int r108 = com.lark.kmp.storage.e.f282696a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.getApplicationContext();
        com.ss.android.lark.storage.monitor.b.f441102a.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.ss.android.lark.storage.monitor.b.f441105d = r100;
        com.ss.android.lark.framework.assembly.sp.a r109 = new com.ss.android.lark.framework.assembly.sp.a();
        Intrinsics.checkNotNullParameter(r109, "reporter");
        com.ss.android.lark.storage.monitor.b.f441103b = r109;
        ExecutorService r110 = CoreThreadPool.getDefault().getCachedThreadPool();
        Intrinsics.checkNotNullParameter(r110, "handler");
        com.ss.android.lark.storage.monitor.b.f441104c = r110;
        b r111 = new b(this);
        Application r112 = LarkFileStorage.f460624a;
        Intrinsics.checkNotNullParameter(r111, "config");
        LarkFileStorage.f460625b = r111;
        FileAccessCompatManager r113 = (FileAccessCompatManager) VFS.f444817a.getValue();
        com.suite.lark.platform.component.storage.file.a r114 = new com.suite.lark.platform.component.storage.file.a();
        r113.getClass();
        Intrinsics.checkNotNullParameter(r114, "fileAccessCompat");
        FileAccessCompatManager.a r115 = (FileAccessCompatManager.a) r113.f444802a.getValue();
        r115.getClass();
        Intrinsics.checkNotNullParameter(r114, "accessCompat");
        r115.f444804b = r114;
        FileSystemManager.a r116 = FileSystemManager.a();
        r116.c(d.f(r100));
        r116.a(new KAFileEncryptFileSystem.KAFileEncryptFileSystemFactory(false, 1, null));
        r116.b(true);
        Log.i("InitUniStoreTask", "init unify storage success");
        return;
    L10:
        throw new IllegalArgumentException("context should not be null");
    }
}
