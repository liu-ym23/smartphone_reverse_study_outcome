package com.obric.assistant.common.spi.alog;

import com.ss.android.agilelogger.ALogConfig;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH&J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH&J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\u0013\u001a\u00020\u0005H&J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u0017\u001a\u00020\u0005H&¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/common/spi/alog/IObricAlogService;", "", "useOpenNewAnrMonitor", "", "isZeusAlogUploadEnable", "", "isObricUploadEnable", "subListLodFileEnable", "flushPluginAlog", "getAlogFileDir", "", "", "getAlogFileList", "getAlogFilePathByProcessName", "processName", "getResolvedAlogFilePath", "currentPath", "mergeAlogFileList", "alogFiles", "shouldKeepUploadedAlogFiles", "isObricSubProcess", "modifyObricConfig", "aLogConfig", "isForbitHighFreqLogs", "obric_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAlogService {
    List<String> a(List<String> r100);

    List<String> b();

    String c(String r100, String r101);

    void d();

    void e();

    boolean f();

    boolean g();

    void h(ALogConfig r100);

    boolean i();
}
