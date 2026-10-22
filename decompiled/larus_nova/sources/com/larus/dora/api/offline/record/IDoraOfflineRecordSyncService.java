package com.larus.dora.api.offline.record;

import com.larus.avlink.record.page.RecordMinutesViewModel$syncListener$1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J.\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H¦@¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006\u001b"}, d2 = {"Lcom/larus/dora/api/offline/record/IDoraOfflineRecordSyncService;", "", "configureStorage", "", "config", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordStorageConfig;", "(Lcom/larus/dora/api/offline/record/DoraOfflineRecordStorageConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindContext", "businessType", "", "vuiId", "", "contextType", "contextId", "(ILjava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSyncedRecordings", "", "Lcom/larus/dora/api/offline/record/DoraOfflineSyncedRecording;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSyncedRecording", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSyncedRecording", "registerTransferListener", "", "listener", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferListener;", "unregisterTransferListener", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraOfflineRecordSyncService {
    Object a(String r100, String r101, Continuation r102);

    Object b(String r100, ContinuationImpl r101);

    Object c(ContinuationImpl r100);

    void d(c r100);

    void e(RecordMinutesViewModel$syncListener$1 r100);
}
