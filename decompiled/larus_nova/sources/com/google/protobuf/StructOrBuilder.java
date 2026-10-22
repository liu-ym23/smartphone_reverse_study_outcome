package com.google.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public interface StructOrBuilder extends MessageOrBuilder {
    boolean containsFields(String r100);

    Map<String, Value> getFields();

    int getFieldsCount();

    Map<String, Value> getFieldsMap();

    Value getFieldsOrDefault(String r100, Value r101);

    Value getFieldsOrThrow(String r100);
}
