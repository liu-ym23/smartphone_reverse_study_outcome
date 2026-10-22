package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractMessageLite.Builder;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode;

    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {

        public static final class LimitedInputStream extends FilterInputStream {
            private int limit;

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.limit > 0) goto L6;
                return -1;
            L6:
                int r100 = super.read();
                if (r100 < 0) goto L9;
                this.limit--;
            L9:
                return r100;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.limit);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r100) throws IOException {
                long r101 = super.skip(Math.min(r100, this.limit));
                if (r101 < 0) goto L5;
                this.limit = (int) (((long) this.limit) - r101);
            L5:
                return r101;
            }

            public LimitedInputStream(InputStream r100, int r101) {
                super(r100);
                this.limit = r101;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r100, int r101, int r102) throws IOException {
                int r103 = this.limit;
                if (r103 > 0) goto L6;
                return -1;
            L6:
                int r104 = super.read(r100, r101, Math.min(r102, r103));
                if (r104 < 0) goto L9;
                this.limit -= r104;
            L9:
                return r104;
            }
        }

        public Builder() {
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType clone();

        public abstract BuilderType internalMergeFrom(MessageType r100);

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public abstract BuilderType mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException;

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo8531clone() throws CloneNotSupportedException {
            return clone();
        }

        private String getReadingExceptionMessage(String r100) {
            return "Reading " + getClass().getName() + " from a " + r100 + " threw an IOException (should never happen).";
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite r100) {
            return new UninitializedMessageException(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r100) throws IOException {
            return mergeDelimitedFrom(r100, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(MessageLite r100) {
            if (getDefaultInstanceForType().getClass().isInstance(r100) == false) goto L7;
            return (BuilderType) internalMergeFrom((AbstractMessageLite) r100);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r100) throws InvalidProtocolBufferException {
            CodedInputStream r101 = r100.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r101);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r101.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r100) throws IOException {
            CodedInputStream r101 = CodedInputStream.newInstance(r100);
            mergeFrom(r101);
            r101.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream r100) throws IOException {
            return (BuilderType) mergeFrom(r100, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r100) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r100, 0, r100.length);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r100) {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r100) throws IOException {
            return mergeFrom(r100);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100) throws InvalidProtocolBufferException {
            return mergeFrom(r100);
        }

        public static <T> void addAll(Iterable<T> r100, List<? super T> r101) {
            Internal.checkNotNull(r100);
            if ((r100 instanceof LazyStringList) == false) goto L19;
            List<?> r102 = ((LazyStringList) r100).getUnderlyingElements();
            LazyStringList r103 = (LazyStringList) r101;
            int r104 = r101.size();
            Iterator<?> r105 = r102.iterator();
        L6:
            if (r105.hasNext() == false) goto L32;
            Object r106 = r105.next();
            if (r106 == null) goto L9;
            if ((r106 instanceof ByteString) == true) goto L16;
            r103.add((String) r106);
            goto L6
        L16:
            r103.add((ByteString) r106);
            goto L6
        L9:
            String r107 = "Element at index " + (r103.size() - r104) + " is null.";
            int r108 = r103.size() - 1;
        L10:
            if (r108 < r104) goto L13;
            r103.remove(r108);
            r108 = r108 - 1;
            goto L10
        L13:
            throw new NullPointerException(r107);
        L32:
            return;
        L19:
            if ((r100 instanceof PrimitiveNonBoxingCollection) == false) goto L21;
            r101.addAll((Collection) r100);
            return;
        L21:
            addAllCheckingNulls(r100, r101);
        }

        private static <T> void addAllCheckingNulls(Iterable<T> r100, List<? super T> r101) {
            if ((r101 instanceof ArrayList) == true) goto L5;
        L7:
            int r102 = r101.size();
            Iterator<T> r103 = r100.iterator();
        L9:
            if (r103.hasNext() == false) goto L18;
            T r104 = r103.next();
            if (r104 == null) goto L12;
            r101.add(r104);
            goto L9
        L12:
            String r105 = "Element at index " + (r101.size() - r102) + " is null.";
            int r106 = r101.size() - 1;
        L13:
            if (r106 < r102) goto L16;
            ListProtector.remove(r101, r106);
            r106 = r106 - 1;
            goto L13
        L16:
            throw new NullPointerException(r105);
        L18:
            return;
        L5:
            if ((r100 instanceof Collection) == false) goto L7;
            ((ArrayList) r101).ensureCapacity(r101.size() + ((Collection) r100).size());
            goto L7
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            int r102 = r100.read();
            if (r102 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new LimitedInputStream(r100, CodedInputStream.readRawVarint32(r102, r100)), r101);
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            CodedInputStream r102 = r100.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r102, r101);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r102.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("ByteString"), e);
        }

        public static <T> void addAll(Iterable<T> r100, Collection<? super T> r101) {
            addAll(r100, (List) r101);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            CodedInputStream r102 = CodedInputStream.newInstance(r100);
            mergeFrom(r102, r101);
            r102.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return (BuilderType) mergeFrom(r100, 0, r100.length, r101);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException {
            CodedInputStream r103 = CodedInputStream.newInstance(r100, r101, r102);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r103);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r103.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException {
            CodedInputStream r104 = CodedInputStream.newInstance(r100, r101, r102);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r104, r103);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r104.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException(getReadingExceptionMessage("byte array"), e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r100, int r101, int r102, ExtensionRegistryLite r103) throws InvalidProtocolBufferException {
            return mergeFrom(r100, r101, r102, r103);
        }
    }

    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    public AbstractMessageLite() {
        this.memoizedHashCode = 0;
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r100 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r101 = CodedOutputStream.newInstance(r100);     // Catch: IOException -> L4
        writeTo(r101);     // Catch: IOException -> L4
        r101.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r100;
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r100 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r100.getCodedOutput());     // Catch: IOException -> L4
        return r100.build();
    L4:
        e = move-exception;
        throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
    }

    public static void checkByteStringIsUtf8(ByteString r100) throws IllegalArgumentException {
        if (r100.isValidUtf8() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Byte string is not UTF-8.");
    }

    private String getSerializingExceptionMessage(String r100) {
        return "Serializing " + getClass().getName() + " to a " + r100 + " threw an IOException (should never happen).";
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r100) throws IOException {
        int r101 = getSerializedSize();
        CodedOutputStream r102 = CodedOutputStream.newInstance(r100, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(r101) + r101));
        r102.writeRawVarint32(r101);
        writeTo(r102);
        r102.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r100) throws IOException {
        CodedOutputStream r101 = CodedOutputStream.newInstance(r100, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
        writeTo(r101);
        r101.flush();
    }

    public static <T> void addAll(Iterable<T> r100, Collection<? super T> r101) {
        Builder.addAll(r100, (List) r101);
    }

    public static <T> void addAll(Iterable<T> r100, List<? super T> r101) {
        Builder.addAll(r100, r101);
    }
}
