package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface CryptoSDKInfoOrBuilder extends MessageOrBuilder {
    ErrorTrace getErrorTrace(int r100);

    int getErrorTraceCount();

    List<ErrorTrace> getErrorTraceList();

    ErrorTraceOrBuilder getErrorTraceOrBuilder(int r100);

    List<? extends ErrorTraceOrBuilder> getErrorTraceOrBuilderList();

    NormalTrace getNormalTrace(int r100);

    int getNormalTraceCount();

    List<NormalTrace> getNormalTraceList();

    NormalTraceOrBuilder getNormalTraceOrBuilder(int r100);

    List<? extends NormalTraceOrBuilder> getNormalTraceOrBuilderList();

    long getTimestamp();

    int getTrainNum();

    int getVersion();

    boolean hasTimestamp();

    boolean hasTrainNum();

    boolean hasVersion();
}
