package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.ISingScoringEventHandler;
import com.ss.bytertc.engine.SingScoringManager;
import com.ss.bytertc.engine.data.SingScoringRealtimeInfo;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public class NativeSingScoringEventHandler {
    private static final String TAG = "NativeSingScoringEventHandler";
    private WeakReference<SingScoringManager> mSingScoringManager;

    public NativeSingScoringEventHandler(SingScoringManager r100) {
        this.mSingScoringManager = new WeakReference(r100);
    }

    public void onCurrentScoringInfo(SingScoringRealtimeInfo r100) {
        WeakReference<SingScoringManager> r101 = this.mSingScoringManager;
        if (r101 == null) goto L10;
        SingScoringManager r102 = r101.get();
        if (r102 == null) goto L11;
        ISingScoringEventHandler r103 = r102.getSingScoringEventHandler();
        if (r103 == null) goto L12;
        r103.onCurrentScoringInfo(r100);
        return;
    L12:
        return;
    L11:
        return;
    }
}
