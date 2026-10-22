package com.ss.android.vesdk.effect;

import com.ss.android.vesdk.VEARCoreParam;
import com.ss.android.vesdk.VEBachAlgorithmCallback;
import com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam;
import com.ss.android.vesdk.e0;
import com.ss.android.vesdk.filterparam.VEBaseFilterParam;
import com.ss.android.vesdk.r0;
import com.ss.android.vesdk.s0;
import com.ss.android.vesdk.t0;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public interface IEffect {
    int addTrackAlgorithm(int r100, int r101, VEBaseAlgorithmParam r102, int r103, int r104);

    int addTrackFilter(int r100, int r101, VEBaseFilterParam r102, int r103, int r104);

    int cancelPreloadNodes(List<s0> r100);

    void enableEffectWithCameraFacing(boolean r100, int r101);

    e0 getEffectFilterTime(long r100);

    t0 getPreloadNodesResult();

    void regBachAlgorithmCallback(List<VEBachAlgorithmCallback> r100);

    int removeTrackAlgorithm(int r100);

    int removeTrackFilter(int r100);

    void sendEffectMsg(int r100, long r101, long r102, byte[] r103);

    void setARCoreParam(VEARCoreParam r100);

    <T> int setFilterParam(int r100, String r101, T r102);

    void unregBachAlgorithmCallback();

    int updatePreloadNodes(List<s0> r100, r0 r101);

    int updateTrackAlgorithmParam(int r100, VEBaseAlgorithmParam r101);

    int updateTrackFilterParam(int r100, VEBaseFilterParam r101);

    int updateTrackFilterTime(int r100, int r101, int r102);
}
