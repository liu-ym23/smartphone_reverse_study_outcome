package com.google.protobuf.server;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes23.dex */
public final class FileDescriptorSet extends Message<FileDescriptorSet, Builder> {
    public static final ProtoAdapter<FileDescriptorSet> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<FileDescriptorProto> mfile;

    public static final class Builder extends Message.Builder<FileDescriptorSet, Builder> {
        public List<FileDescriptorProto> mfile;

        @Override // com.squareup.wire.Message.Builder
        public FileDescriptorSet build() {
            return new FileDescriptorSet(this.mfile, super.buildUnknownFields());
        }

        public Builder() {
            this.mfile = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder file(List<FileDescriptorProto> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfile = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FileDescriptorSet extends ProtoAdapter<FileDescriptorSet> {
        public ProtoAdapter_FileDescriptorSet() {
            super(FieldEncoding.LENGTH_DELIMITED, FileDescriptorSet.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FileDescriptorSet decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mfile.add(FileDescriptorProto.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FileDescriptorSet r100) {
            return FileDescriptorProto.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mfile) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FileDescriptorSet decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileDescriptorSet r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileDescriptorSet r101) throws IOException {
            FileDescriptorProto.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mfile);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileDescriptorSet r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FileDescriptorSet();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfile = Internal.copyOf("mfile", this.mfile);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileDescriptorSet.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileDescriptorSet(List<FileDescriptorProto> r100) {
        this(r100, ByteString.EMPTY);
    }

    public FileDescriptorSet(List<FileDescriptorProto> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mfile = Internal.immutableCopyOf("mfile", r100);
    }
}
