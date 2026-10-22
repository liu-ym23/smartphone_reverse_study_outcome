package com.obric.assistant.zeus.plugin.impl;

import android.os.Looper;
import android.os.Process;
import android.util.EventsUtils;
import com.bytedance.crash.Npth;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.plugin_api.PluginService;
import com.obric.assistant.common.spi.alog.IObricAlogService;
import com.obric.assistant.t1;
import com.obric.memorydata.plugin_api.MemoryPlugin;
import com.ss.android.agilelogger.ALogConfig;
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
import org.xmlpull.v1.XmlPullParser;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/zeus/plugin/impl/ZeusObricAlogServiceImpl;", "Lcom/obric/assistant/common/spi/alog/IObricAlogService;", "<init>", "()V", "useOpenNewAnrMonitor", XmlPullParser.NO_NAMESPACE, "isZeusAlogUploadEnable", XmlPullParser.NO_NAMESPACE, "isObricUploadEnable", "subListLodFileEnable", "flushPluginAlog", "getAlogFileDir", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "getAlogFileList", "getAlogFilePathByProcessName", "processName", "getResolvedAlogFilePath", "currentPath", "mergeAlogFileList", "alogFiles", "shouldKeepUploadedAlogFiles", "isObricSubProcess", "modifyObricConfig", "aLogConfig", XmlPullParser.NO_NAMESPACE, "isForbitHighFreqLogs", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ZeusObricAlogServiceImpl implements IObricAlogService {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final void a() {
            int r0 = ZeusObricAlogServiceImpl.a;
            AppHost.Companion r1 = AppHost.a;
            PluginService.getALogFiles(r1.getApplication(), 0, 0);
            if (b.a().e() == true) goto L7;
            new MemoryPlugin().getALogFiles(r1.getApplication(), 0, 0);
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
        return t1.a.getObricLogSettingsConfig().getForbitHighFreqLogs();
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final List<String> b() {
        List r0 = CollectionsKt.listOf(new String[]{"zeus_com.obric.memorydata.plugin/logs", "zeus_com.obric.aiagent.plugin/logs", "logs"});
        String r1 = AppHost.a.getApplication().getFilesDir().getAbsolutePath() + '/';
        List r2 = r0;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r3.add(r1 + ((String) r4.next()));
        goto L4
    L6:
        return r3;
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void e() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L6;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new flushPluginAlog.1(null), 3, null);
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
    public final List<String> a(List<String> r13) {
        Intrinsics.checkNotNullParameter(r13, "alogFiles");
        List<String> r0 = b();
        ArrayList r10 = new ArrayList();
        Iterator r1 = ((ArrayList) r0).iterator();
    L4:
        if (r1.hasNext() == false) goto L24;
        PolarisFileWrapper r2 = new PolarisFileWrapper((String) r1.next());
        if (r2.exists() == true) goto L8;
    L22:
        ?? r3 = CollectionsKt.emptyList();
    L23:
        CollectionsKt.addAll(r10, (Iterable) r3);
        goto L4
    L8:
        if (r2.isDirectory() == false) goto L22;
        File[] r4 = r2.listFiles();
        if (r4 == null) goto L21;
        ArrayList r5 = new ArrayList();
        int r6 = r4.length;
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L17;
        File r8 = r4[r7];
        if (r8.isFile() == false) goto L16;
        r5.add(r8);
    L16:
        r7 = r7 + 1;
        goto L12
    L17:
        r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator r9 = r5.iterator();
    L19:
        if (r9.hasNext() == false) goto L23;
        r3.add(((File) r9.next()).getAbsolutePath());
        goto L19
    L21:
        r3 = CollectionsKt.emptyList();
        goto L23
    L24:
        FLogger.a.i("AlogServiceImpl", "zeus plugin file List: " + CollectionsKt.joinToString$default(r10, null, null, null, 0, null, null, 63, null));
        if (r10.isEmpty() == false) goto L27;
        return r13;
    L27:
        List<String> r14 = CollectionsKt.toMutableList(r13);
        Iterator r11 = r10.iterator();
    L29:
        if (r11.hasNext() == false) goto L33;
        String r12 = (String) r11.next();
        if (r14.contains(r12) == true) goto L29;
        r14.add(r12);
        goto L29
    L33:
        return r14;
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final void h(ALogConfig r7) {
        String r0 = com.bytedance.apm.util.a.a(Process.myPid());
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == true) goto L17;
        if (r0 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == true) goto L17;
        r1 = false;
        goto L17
    L11:
        if (StringsKt.contains$default(r0, "aiagent", false, 2, null) != true) goto L13;
        r3 = true;
    L17:
        if (r1 == false) goto L19;
        r7.setSubProcessMaxDirSizeRatio(1.0f);
    L19:
        r7.setLogDirPath(c(r0, r7.getLogDirPath()));
        return;
    L5:
        if (StringsKt.contains$default(r0, "memory", false, 2, null) != true) goto L7;
        r5 = true;
        goto L8
    }

    @Override // com.obric.assistant.common.spi.alog.IObricAlogService
    public final String c(String r5, String r6) {
        if (r5 == null) goto L16;
        Intrinsics.checkNotNullParameter(r5, "processName");
        String r3 = null;
        if (StringsKt.contains$default(r5, "memory", false, 2, null) == false) goto L7;
        r3 = AppHost.a.getApplication().getFilesDir().getAbsolutePath() + "/zeus_com.obric.memorydata.plugin/logs";
    L12:
        if (r3 != null) goto L15;
        return r6;
    L15:
        return r3;
    L7:
        if (StringsKt.contains$default(r5, "aiagent", false, 2, null) == false) goto L10;
        r3 = AppHost.a.getApplication().getFilesDir().getAbsolutePath() + "/zeus_com.obric.aiagent.plugin/logs";
        goto L12
    L10:
        if (StringsKt.contains$default(r5, "aikernel", false, 2, null) == false) goto L12;
        r3 = AppHost.a.getApplication().getFilesDir().getAbsolutePath() + "/zeus_com.obric.aikernel.plugin/logs";
        goto L12
    L16:
        return r6;
    }
}
