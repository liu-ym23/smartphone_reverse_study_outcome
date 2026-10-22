package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public interface TypeOrBuilder extends MessageOrBuilder {
    Field getFields(int r100);

    int getFieldsCount();

    List<Field> getFieldsList();

    FieldOrBuilder getFieldsOrBuilder(int r100);

    List<? extends FieldOrBuilder> getFieldsOrBuilderList();

    String getName();

    ByteString getNameBytes();

    String getOneofs(int r100);

    ByteString getOneofsBytes(int r100);

    int getOneofsCount();

    List<String> getOneofsList();

    Option getOptions(int r100);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int r100);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();

    SourceContext getSourceContext();

    SourceContextOrBuilder getSourceContextOrBuilder();

    Syntax getSyntax();

    int getSyntaxValue();

    boolean hasSourceContext();
}
