package com.bytedance.byted_bach_sdk.input;

/* JADX INFO: loaded from: classes8.dex */
public interface BachAlgorithmInput {
    public static final int BITMAP_INPUT = 1;
    public static final int MULTI_INPUT = 3;
    public static final int RAW_BUFFER_INPUT = 2;

    Object getInput();

    int getInputType();
}
