package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public interface EnumValueOrBuilder extends MessageOrBuilder {
    String getName();

    ByteString getNameBytes();

    int getNumber();

    Option getOptions(int r100);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int r100);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();
}
