package com.obric.assistant.zeus.plugin.impl;

import android.os.Looper;
import android.os.Process;
import com.bytedance.crash.Npth;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.plugin_api.PluginService;
import com.obric.assistant.common.spi.alog.IObricAlogService;
import com.obric.assistant.t1;
import com.obric.memorydata.plugin_api.MemoryPlugin;
import com.ss.android.agilelogger.ALogConfig;
import com.ss.bytertc.engine.utils.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import t9a.b;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/zeus/plugin/impl/ZeusObricAlogServiceImpl;", "Lcom/obric/assistant/common/spi/alog/IObricAlogService;", "<init>", "()V", "useOpenNewAnrMonitor", "", "isZeusAlogUploadEnable", "", "isObricUploadEnable", "subListLodFileEnable", "flushPluginAlog", "getAlogFileDir", "", "", "getAlogFileList", "getAlogFilePathByProcessName", "processName", "getResolvedAlogFilePath", "currentPath", "mergeAlogFileList", "alogFiles", "shouldKeepUploadedAlogFiles", "isObricSubProcess", "modifyObricConfig", "aLogConfig", "", "isForbitHighFreqLogs", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZeusObricAlogServiceImpl implements IObricAlogService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f395049a = 0;

    public static final class a {
        public static final void a() {
            int r100 = ZeusObricAlogServiceImpl.f395049a;
            AppHost.Companion r101 = AppHost.f326268a;
            PluginService.getALogFiles(r101.getApplication(), 0, 0);
            if (b.a().e() == true) goto L7;
            new MemoryPlugin().getALogFiles(r101.getApplication(), 0, 0);
            return;
        }

        public a() {
        }
    }

    static {
        new a();
    }

    public ZeusObricAlogServiceImpl() {
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void d() {
        Npth.setOpenNewAnrMonitor(true);
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final boolean f() {
        return true;
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final boolean g() {
        return true;
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final boolean i() {
        return t1.f393353a.getObricLogSettingsConfig().getForbitHighFreqLogs();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final List<String> b() {
        List r100 = CollectionsKt.listOf(new String[]{"zeus_com.obric.memorydata.plugin/logs", "zeus_com.obric.aiagent.plugin/logs", LogUtil.DIR_TAIL});
        String r101 = AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath() + '/';
        List r102 = r100;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r101 + ((String) r104.next()));
        goto L4
    L6:
        return r103;
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void e() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZeusObricAlogServiceImpl$flushPluginAlog$1(null), 3, null);
        return;
    L6:
        a.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.util.ArrayList] */
    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final List<String> a(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "alogFiles");
        List<String> r100 = b();
        ArrayList r111 = new ArrayList();
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L24;
        PolarisFileWrapper r102 = new PolarisFileWrapper((String) r101.next());
        if (r102.exists() == true) goto L8;
    L22:
        ?? r103 = CollectionsKt.emptyList();
    L23:
        CollectionsKt.addAll(r111, (Iterable) r103);
        goto L4
    L8:
        if (r102.isDirectory() == false) goto L22;
        File[] r104 = r102.listFiles();
        if (r104 == null) goto L21;
        ArrayList r105 = new ArrayList();
        int r106 = r104.length;
        int r107 = 0;
    L12:
        if (r107 >= r106) goto L17;
        File r108 = r104[r107];
        if (r108.isFile() == false) goto L16;
        r105.add(r108);
    L16:
        r107 = r107 + 1;
        goto L12
    L17:
        r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r109 = r105.iterator();
    L19:
        if (r109.hasNext() == false) goto L23;
        r103.add(((File) r109.next()).getAbsolutePath());
        goto L19
    L21:
        r103 = CollectionsKt.emptyList();
        goto L23
    L24:
        FLogger.f375446a.i("AlogServiceImpl", "zeus plugin file List: " + CollectionsKt.joinToString$default(r111, null, null, null, 0, null, null, 63, null));
        if (r111.isEmpty() == false) goto L27;
        return r110;
    L27:
        List<String> r112 = CollectionsKt.toMutableList(r110);
        Iterator r113 = r111.iterator();
    L29:
        if (r113.hasNext() == false) goto L33;
        String r114 = (String) r113.next();
        if (r112.contains(r114) == true) goto L29;
        r112.add(r114);
        goto L29
    L33:
        return r112;
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void h(ALogConfig r100) {
        String r101 = com.bytedance.apm.util.a.a(Process.myPid());
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L17;
        if (r101 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L17;
        r102 = false;
        goto L17
    L11:
        if (StringsKt.contains$default(r101, "aiagent", false, 2, null) != true) goto L13;
        r104 = true;
    L17:
        if (r102 == false) goto L19;
        r100.setSubProcessMaxDirSizeRatio(1.0f);
    L19:
        r100.setLogDirPath(c(r101, r100.getLogDirPath()));
        return;
    L5:
        if (StringsKt.contains$default(r101, "memory", false, 2, null) != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final String c(String r100, String r101) {
        if (r100 == null) goto L16;
        Intrinsics.checkNotNullParameter(r100, "processName");
        String r102 = null;
        if (StringsKt.contains$default(r100, "memory", false, 2, null) == false) goto L7;
        r102 = AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath() + "/zeus_com.obric.memorydata.plugin/logs";
    L12:
        if (r102 != null) goto L15;
        return r101;
    L15:
        return r102;
    L7:
        if (StringsKt.contains$default(r100, "aiagent", false, 2, null) == false) goto L10;
        r102 = AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath() + "/zeus_com.obric.aiagent.plugin/logs";
        goto L12
    L10:
        if (StringsKt.contains$default(r100, "aikernel", false, 2, null) == false) goto L12;
        r102 = AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath() + "/zeus_com.obric.aikernel.plugin/logs";
        goto L12
    L16:
        return r101;
    }
}
