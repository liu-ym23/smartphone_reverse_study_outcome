package com.ss.videoarch.strategy;

/* JADX INFO: loaded from: classes38.dex */
public interface IFunctionCalledByStrategyEngine {
    public static final int FUNCTION_CHARACTER_CHANGE = 2;
    public static final int FUNCTION_PRE_CONNECTION = 1;

    <T> T callFunctionByKey(int r100, T r101);
}
