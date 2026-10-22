package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes23.dex */
public abstract class CodedOutputStream extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f275809a = 0;

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        public OutOfSpaceException(String r100) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + r100);
        }

        public OutOfSpaceException(Throwable r100) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", r100);
        }

        public OutOfSpaceException(String r100, Throwable r101) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + r100, r101);
        }
    }

    public static class a extends CodedOutputStream {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f275810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f275811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f275812d;

        @Override // com.google.crypto.tink.shaded.protobuf.c
        public final void a(ByteBuffer r100) throws IOException {
            int r101 = r100.remaining();
            r100.get(this.f275810b, this.f275812d, r101);     // Catch: IndexOutOfBoundsException -> L5
            this.f275812d += r101;     // Catch: IndexOutOfBoundsException -> L5
            return;
        L5:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f275812d), Integer.valueOf(this.f275811c), Integer.valueOf(r101)}), e);
        }

        public a(byte[] r100, int r101) {
            int r102 = 0 + r101;
            if (((0 | r101) | (r100.length - r102)) < 0) goto L7;
            this.f275810b = r100;
            this.f275812d = 0;
            this.f275811c = r102;
            return;
        L7:
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(r100.length), 0, Integer.valueOf(r101)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.c
        public final void b(byte[] r100, int r101, int r102) throws IOException {
            System.arraycopy(r100, r101, this.f275810b, this.f275812d, r102);     // Catch: IndexOutOfBoundsException -> L4
            this.f275812d += r102;     // Catch: IndexOutOfBoundsException -> L4
            return;
        L4:
            e = move-exception;
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f275812d), Integer.valueOf(this.f275811c), Integer.valueOf(r102)}), e);
        }
    }

    static {
        Logger.getLogger(CodedOutputStream.class.getName());
        Class<?> r100 = i.f275897a;
    }

    public CodedOutputStream() {
    }
}
