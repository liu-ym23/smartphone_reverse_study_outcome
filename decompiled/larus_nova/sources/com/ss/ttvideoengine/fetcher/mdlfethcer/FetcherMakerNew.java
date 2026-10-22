package com.ss.ttvideoengine.fetcher.mdlfethcer;

import android.text.TextUtils;
import com.ss.mediakit.fetcher.AVMDLNewFetcherMakerInterface;
import com.ss.mediakit.fetcher.AVMDLURLFetcherInterface;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class FetcherMakerNew implements AVMDLNewFetcherMakerInterface {
    private static final String TAG = "FetcherMakerNew";
    private static FetcherMakerNew mInst;
    private static final List<WeakReference<MDLFetcherListener>> sFetcherListenerList = null;

    private FetcherMakerNew() {
    }

    static {
        sFetcherListenerList = new ArrayList();
    }

    public static FetcherMakerNew getInstance() {
        if (mInst != null) goto L15;
        monitor-enter(FetcherMakerNew.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInst != null) goto L9;
        mInst = new FetcherMakerNew();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FetcherMakerNew.class);     // Catch: Throwable -> L11
    L15:
        return mInst;
    }

    private static synchronized MDLFetcherListener getMDLFetchListener(String r100) {
        monitor-enter(FetcherMakerNew.class);
        Iterator<WeakReference<MDLFetcherListener>> r101 = sFetcherListenerList.iterator();     // Catch: Throwable -> L16
    L6:
        if (r101.hasNext() == false) goto L13;
        MDLFetcherListener r102 = r101.next().get();     // Catch: Throwable -> L16
        if (r102 == null) goto L6;
        if (TextUtils.equals(r100, r102.getId()) == false) goto L6;
        monitor-exit(FetcherMakerNew.class);
        return r102;
    L13:
        monitor-exit(FetcherMakerNew.class);
        return null;
    L16:
        th = move-exception;
        throw th;
    }

    public static synchronized void removeListener(MDLFetcherListener r100) {
        monitor-enter(FetcherMakerNew.class);
        if (r100 != null) goto L8;
        TTVideoEngineLog.i(TAG, "removeListener fetcherListener is null");     // Catch: Throwable -> L23
        monitor-exit(FetcherMakerNew.class);
        return;
    L8:
        TTVideoEngineLog.i(TAG, "removeListener " + r100);     // Catch: Throwable -> L23
        Iterator<WeakReference<MDLFetcherListener>> r101 = sFetcherListenerList.iterator();     // Catch: Throwable -> L23
    L10:
        if (r101.hasNext() == false) goto L21;
        WeakReference<MDLFetcherListener> r102 = r101.next();     // Catch: Throwable -> L23
        if (r102 == null) goto L19;
        if (r102.get() == null) goto L19;
        if (r102.get() != r100) goto L10;
        r101.remove();     // Catch: Throwable -> L23
    L19:
        r101.remove();     // Catch: Throwable -> L23
        goto L10
    L21:
        monitor-exit(FetcherMakerNew.class);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static synchronized void storeListener(MDLFetcherListener r100) {
        monitor-enter(FetcherMakerNew.class);
        if (r100 != null) goto L8;
        TTVideoEngineLog.i(TAG, "storeListener fetcherListener is null");     // Catch: Throwable -> L11
        monitor-exit(FetcherMakerNew.class);
        return;
    L8:
        TTVideoEngineLog.i(TAG, "storeListener " + r100);     // Catch: Throwable -> L11
        sFetcherListenerList.add(new WeakReference(r100));     // Catch: Throwable -> L11
        monitor-exit(FetcherMakerNew.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.mediakit.fetcher.AVMDLNewFetcherMakerInterface
    public AVMDLURLFetcherInterface getFetcher(String r100, String r101, String r102, String r103) {
        TTVideoEngineLog.i(TAG, "getFetcher rawKey " + r100 + ", fileKey " + r101 + ", engineId " + r103);
        MDLFetcherListener r104 = getMDLFetchListener(r103);
        if (r104 != null) goto L6;
        TTVideoEngineLog.e(TAG, "getFetcher MDLFetcherListener is null");
        return null;
    L6:
        MDLFetcherNew r105 = new MDLFetcherNew(r104);
        TTVideoEngineLog.i(TAG, "return fetcher to mdl " + r105);
        return r105;
    }
}
