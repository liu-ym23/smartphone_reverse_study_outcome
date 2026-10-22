package com.obric.update.impl;

import com.larus.utils.logger.FLogger;
import com.obric.update.api.IObricUpdate;
import com.obric.update.bean.ObricUpdateState;
import com.obric.update.bean.ObricUpdateStateType;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\"\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000eH\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0012\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010(\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u001d2\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020!H\u0016J\u000e\u0010,\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u00020\u000bH\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\u0010\u00103\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u0007H\u0003J\u0010\u00106\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0003J\u0010\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u001dH\u0003J&\u00109\u001a\u00020!2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140\u00172\u0006\u0010;\u001a\u00020\u00192\u0006\u00108\u001a\u00020\u001dH\u0007J\u0018\u0010<\u001a\u00020!2\u0006\u00108\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0007H\u0003J$\u0010=\u001a\u00020!2\u0006\u0010>\u001a\u00020\u00142\b\b\u0002\u0010;\u001a\u00020\u00192\b\b\u0002\u0010?\u001a\u00020\u0019H\u0003J\b\u0010@\u001a\u00020!H\u0003J\b\u0010A\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/obric/update/impl/ObricUpdateImpl;", "Lcom/obric/update/api/IObricUpdate;", "<init>", "()V", "backGroundListener", "Lcom/larus/common/apphost/lifecycle/ActivityStackManager$OnAppBackGroundListener;", "_autoCheck", "", "obricCheckProgressJob", "Lkotlinx/coroutines/Job;", "currentState", "Lcom/obric/update/bean/ObricUpdateState;", "progressObservers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/update/callback/ObricUpdateProgressCallback;", "stateObservers", "Lcom/obric/update/callback/ObricUpdateStateChangedCallback;", "isNeedDownloadDoubaoAfterDownloadAiagent", "currentDownloadingPackageInfoBundle", "", "", "", "currentDownloadingPackageList", "", "currentDownloadingPackageListIndex", "", "lastCheckUpdatedTime", "Ljava/util/concurrent/atomic/AtomicLong;", "checkUpdate", "Lcom/obric/update/bean/ObricUpdatePackageInfo;", "autoCheck", "getCurrentUpdateState", "registerUpdateProgressCallback", "", "callback", "unregisterUpdateProgressCallback", "registerUpdateStateChangedCallback", "unregisterUpdateStateChangedCallback", "startDownload", "packageInfo", "cancelDownload", "isPause", "forceCancelDownload", "manualInstallDoubao", "checkForceUpdateForRomUnmatched", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyProgressChanged", "progress", "setUpdateState", "newState", "canShowDialog", "checkUpdateNow", "needCheckVersion", "checkProgressForAllPackageBeforeCheckVersion", "checkVersionByContentProvider", "startDownloadInternal", "updatePackageInfo", "startNextDownload", "packagesToDownload", "currentIndex", "cancelDownloadInternal", "loopForCheckCurrentDownloadStatus", "packageName", "listSize", "manualInstallImmediately", "checkUpdateForRedDot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUpdateImpl implements IObricUpdate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObricUpdateState f404044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<doa.a> f404045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<doa.b> f404046c;

    public static final class a {
    }

    static {
    }

    public ObricUpdateImpl() {
        this.f404044a = new ObricUpdateState(ObricUpdateStateType.UPDATE_NOT_AVAILABLE, null, null, 6, null);
        this.f404045b = new CopyOnWriteArraySet();
        this.f404046c = new CopyOnWriteArraySet();
        new AtomicLong(0);
    }

    public final void a(ObricUpdateState r100) {
        FLogger.f375446a.i("ObricUpdateImpl", "setUpdateState: " + r100);
        this.f404044a = r100;
        Iterator<doa.b> r101 = this.f404046c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a();
        goto L4
    }
}
