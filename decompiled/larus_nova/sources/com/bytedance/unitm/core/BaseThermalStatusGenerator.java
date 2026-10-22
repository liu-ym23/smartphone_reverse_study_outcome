package com.bytedance.unitm.core;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.unitm.util.TLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseThermalStatusGenerator {
    protected static final float MIN_DELTA = 0.5f;
    protected Context mContext;
    protected IListener mListener;
    protected Looper mLooper;
    protected int mStatus;
    protected float mTemp;
    protected List<Pair<Float, Float>> thermalThresholdList;

    public interface IListener {
        void onStatusGenerate(int r100, float r101);
    }

    public boolean addStatusListener() {
        return false;
    }

    public boolean isEnable() {
        return true;
    }

    public void removeStatusListener() {
    }

    public void setDebugTemp(float r100) {
    }

    public synchronized void reset() {
        monitor-enter(this);
        this.mListener = null;     // Catch: Throwable -> L8
        removeStatusListener();     // Catch: Throwable -> L8
        TLog.d("reset sync this:" + this);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public float getCurrentTemp() {
        return this.mTemp;
    }

    public int getCurrentThermalStatus() {
        return this.mStatus;
    }

    public synchronized boolean setListener(IListener r100) {
        monitor-enter(this);
        this.mListener = r100;     // Catch: Throwable -> L6
        boolean r101 = addStatusListener();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public void setThermalThresholdList(List<Pair<Float, Float>> r100) {
        this.thermalThresholdList = r100;
    }

    public BaseThermalStatusGenerator(Context r100, Looper r101) {
        this.mTemp = -99.0f;
        this.mStatus = -1;
        this.thermalThresholdList = new ArrayList();
        this.mContext = r100;
        if (r101 != null) goto L5;
        r101 = r100.getMainLooper();
    L5:
        this.mLooper = r101;
    }

    public int getThermalStatusFromTemp(float r100, boolean r101) {
        int r102 = this.thermalThresholdList.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L18;
        Pair r105 = (Pair) ListProtector.get(this.thermalThresholdList, r103);
        if (r105 == null) goto L16;
        if (r101 == false) goto L8;
        Object r106 = r105.first;
    L10:
        if (r100 < ((Float) r106).floatValue()) goto L18;
        if (r101 == false) goto L13;
    L15:
        r104 = r103;
        goto L16
    L13:
        if (r103 != this.mStatus) goto L15;
        return r103;
    L8:
        r106 = r105.second;
    L16:
        r103 = r103 + 1;
    L18:
        return r104;
    }
}
