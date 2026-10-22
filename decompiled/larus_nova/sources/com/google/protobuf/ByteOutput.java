package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
public abstract class ByteOutput {
    public ByteOutput() {
    }

    public abstract void write(byte r100) throws IOException;

    public abstract void write(ByteBuffer r100) throws IOException;

    public abstract void write(byte[] r100, int r101, int r102) throws IOException;

    public abstract void writeLazy(ByteBuffer r100) throws IOException;

    public abstract void writeLazy(byte[] r100, int r101, int r102) throws IOException;
}
