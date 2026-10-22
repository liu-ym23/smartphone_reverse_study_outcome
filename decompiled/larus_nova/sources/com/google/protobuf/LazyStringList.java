package com.google.protobuf;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString r100);

    void add(byte[] r100);

    boolean addAllByteArray(Collection<byte[]> r100);

    boolean addAllByteString(Collection<? extends ByteString> r100);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int r100);

    ByteString getByteString(int r100);

    Object getRaw(int r100);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList r100);

    void set(int r100, ByteString r101);

    void set(int r100, byte[] r101);
}
