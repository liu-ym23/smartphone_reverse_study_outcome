package com.hihonor.mcs.system.diagnosis.core.stability;

import com.hihonor.mcs.system.diagnosis.core.BasePayload;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class StabilityPayload extends BasePayload {
    private static final long serialVersionUID = -5268286100727532531L;
    private List<ANRMetric> anrMetrics;
    private List<CrashMetirc> crashMetircs;
    private List<FdleakMetric> fdleakMetrics;
    private List<KilledMetric> killedMetrics;
    private List<MemoryleakMetric> memoryleakMetrics;
    private List<ThreadleakMetric> threadleakMetrics;
    private List<TombstoneMetric> tombstoneMetrics;

    public StabilityPayload() {
        this.tombstoneMetrics = new ArrayList();
        this.crashMetircs = new ArrayList();
        this.anrMetrics = new ArrayList();
        this.threadleakMetrics = new ArrayList();
        this.memoryleakMetrics = new ArrayList();
        this.fdleakMetrics = new ArrayList();
        this.killedMetrics = new ArrayList();
    }

    public List<ANRMetric> getAnrMetrics() {
        return this.anrMetrics;
    }

    public List<CrashMetirc> getCrashMetircs() {
        return this.crashMetircs;
    }

    public List<FdleakMetric> getFdleakMetrics() {
        return this.fdleakMetrics;
    }

    public List<KilledMetric> getKilledMetrics() {
        return this.killedMetrics;
    }

    public List<MemoryleakMetric> getMemoryleakMetrics() {
        return this.memoryleakMetrics;
    }

    public List<ThreadleakMetric> getThreadleakMetrics() {
        return this.threadleakMetrics;
    }

    public List<TombstoneMetric> getTombstoneMetrics() {
        return this.tombstoneMetrics;
    }

    public void setANRMetrics(ArrayList<ANRMetric> r100) {
        this.anrMetrics = r100;
    }

    public void setCrashMetircs(ArrayList<CrashMetirc> r100) {
        this.crashMetircs = r100;
    }

    public void setFdleakMetrics(ArrayList<FdleakMetric> r100) {
        this.fdleakMetrics = r100;
    }

    public void setKilledMetrics(ArrayList<KilledMetric> r100) {
        this.killedMetrics = r100;
    }

    public void setMemoryleakMetrics(ArrayList<MemoryleakMetric> r100) {
        this.memoryleakMetrics = r100;
    }

    public void setThreadleakMetrics(ArrayList<ThreadleakMetric> r100) {
        this.threadleakMetrics = r100;
    }

    public void setTombstoneMetrics(ArrayList<TombstoneMetric> r100) {
        this.tombstoneMetrics = r100;
    }
}
