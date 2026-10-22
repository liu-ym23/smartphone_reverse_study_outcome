package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public interface ListValueOrBuilder extends MessageOrBuilder {
    Value getValues(int r100);

    int getValuesCount();

    List<Value> getValuesList();

    ValueOrBuilder getValuesOrBuilder(int r100);

    List<? extends ValueOrBuilder> getValuesOrBuilderList();
}
