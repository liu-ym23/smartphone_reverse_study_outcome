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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpsertTaskContainerResponse extends Message<UpsertTaskContainerResponse, Builder> {
    public static final ProtoAdapter<UpsertTaskContainerResponse> ADAPTER = null;
    public static final ProtoAdapter_UpsertTaskContainerResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ContainerMetaData container_meta_data;
    public final List<TaskContainerSectionRef> container_section_refs;

    public static final class Builder extends Message.Builder<UpsertTaskContainerResponse, Builder> implements d<UpsertTaskContainerResponse> {
        public ContainerMetaData container_meta_data;
        public List<TaskContainerSectionRef> container_section_refs;

        @Override // com.squareup.wire.Message.Builder
        public UpsertTaskContainerResponse build() {
            return new UpsertTaskContainerResponse(this.container_meta_data, this.container_section_refs, super.buildUnknownFields());
        }

        public Builder() {
            this.container_section_refs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_meta_data(ContainerMetaData r100) {
            this.container_meta_data = r100;
            return this;
        }

        public Builder container_section_refs(List<TaskContainerSectionRef> r100) {
            Internal.checkElementsNotNull(r100);
            this.container_section_refs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpsertTaskContainerResponse extends ProtoAdapter<UpsertTaskContainerResponse> implements c<UpsertTaskContainerResponse> {
        public ProtoAdapter_UpsertTaskContainerResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpsertTaskContainerResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpsertTaskContainerResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.container_meta_data = ContainerMetaData.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.container_section_refs.add(TaskContainerSectionRef.ADAPTER.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpsertTaskContainerResponse r100) {
            ContainerMetaData r101 = r100.container_meta_data;
            if (r101 == null) goto L5;
            int r102 = ContainerMetaData.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + TaskContainerSectionRef.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.container_section_refs)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpsertTaskContainerResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpsertTaskContainerResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpsertTaskContainerResponse r101) throws IOException {
            ContainerMetaData r102 = r101.container_meta_data;
            if (r102 == null) goto L5;
            ContainerMetaData.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TaskContainerSectionRef.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.container_section_refs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpsertTaskContainerResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpsertTaskContainerResponse r100 = new ProtoAdapter_UpsertTaskContainerResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_meta_data = this.container_meta_data;
        r100.container_section_refs = Internal.copyOf("container_section_refs", this.container_section_refs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpsertTaskContainerResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpsertTaskContainerResponse(ContainerMetaData r100, List<TaskContainerSectionRef> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpsertTaskContainerResponse(ContainerMetaData r100, List<TaskContainerSectionRef> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.container_meta_data = r100;
        this.container_section_refs = Internal.immutableCopyOf("container_section_refs", r101);
    }
}
