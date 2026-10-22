package com.bytedance.badger.collect.impl.network.interfaces;

import com.bytedance.badger.collect.impl.model.TTRequest;
import com.bytedance.badger.collect.impl.model.TTResponse;

/* JADX INFO: loaded from: classes47.dex */
public interface IChainHandler {

    /* JADX INFO: renamed from: com.bytedance.badger.collect.impl.network.interfaces.IChainHandler$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long $default$getRetryDelay(IChainHandler r100, int r101) {
            return 1000;
        }

        public static boolean $default$shouldRetry(IChainHandler r100, TTResponse r101, int r102) {
            return false;
        }
    }

    public interface IChain {
        TTRequest getRequest();

        TTResponse process(TTRequest r100);
    }

    long getRetryDelay(int r100);

    TTResponse handle(IChain r100) throws Exception;

    boolean shouldRetry(TTResponse r100, int r101);
}
