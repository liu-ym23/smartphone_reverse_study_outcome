package com.ss.ttvideoengine.selector.shift;

import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public interface SpeedShiftConfig {
    IAutoBitrateSet getIAutoBitrateSet();

    List<? extends IBandwidthSet> getIBandwidthSets();

    IGearConfig getIGearConfig();

    List<? extends IGearSet> getIGearSets();
}
