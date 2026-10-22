package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ContainerTaskFieldAssociations extends Message<ContainerTaskFieldAssociations, Builder> {
    public static final ProtoAdapter<ContainerTaskFieldAssociations> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ContainerTaskFieldAssoc> associations;

    public static final class Builder extends Message.Builder<ContainerTaskFieldAssociations, Builder> {
        public List<ContainerTaskFieldAssoc> associations;

        @Override // com.squareup.wire.Message.Builder
        public ContainerTaskFieldAssociations build() {
            return new ContainerTaskFieldAssociations(this.associations, super.buildUnknownFields());
        }

        public Builder() {
            this.associations = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder associations(List<ContainerTaskFieldAssoc> r100) {
            Internal.checkElementsNotNull(r100);
            this.associations = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContainerTaskFieldAssociations extends ProtoAdapter<ContainerTaskFieldAssociations> {
        public ProtoAdapter_ContainerTaskFieldAssociations() {
            super(FieldEncoding.LENGTH_DELIMITED, ContainerTaskFieldAssociations.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContainerTaskFieldAssociations decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.associations.add(ContainerTaskFieldAssoc.ADAPTER.decode(r100));
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
        public int encodedSize2(ContainerTaskFieldAssociations r100) {
            return ContainerTaskFieldAssoc.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.associations) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContainerTaskFieldAssociations decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContainerTaskFieldAssociations r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContainerTaskFieldAssociations r101) throws IOException {
            ContainerTaskFieldAssoc.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.associations);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContainerTaskFieldAssociations r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContainerTaskFieldAssociations();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.associations = Internal.copyOf("associations", this.associations);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContainerTaskFieldAssociations.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContainerTaskFieldAssociations(List<ContainerTaskFieldAssoc> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ContainerTaskFieldAssociations(List<ContainerTaskFieldAssoc> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.associations = Internal.immutableCopyOf("associations", r100);
    }
}
