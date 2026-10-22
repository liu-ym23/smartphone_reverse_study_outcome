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
public final class MGetTaskContainerMetaDataRequest extends Message<MGetTaskContainerMetaDataRequest, Builder> {
    public static final ProtoAdapter<MGetTaskContainerMetaDataRequest> ADAPTER = null;
    public static final Boolean DEFAULT_NEED_SECTIONS = null;
    public static final ProtoAdapter_MGetTaskContainerMetaDataRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> container_guids;
    public final ContainerMetaDataParams meta_data_params;
    public final Boolean need_sections;

    public static final class Builder extends Message.Builder<MGetTaskContainerMetaDataRequest, Builder> implements d<MGetTaskContainerMetaDataRequest> {
        public List<String> container_guids;
        public ContainerMetaDataParams meta_data_params;
        public Boolean need_sections;

        @Override // com.squareup.wire.Message.Builder
        public MGetTaskContainerMetaDataRequest build() {
            return new MGetTaskContainerMetaDataRequest(this.container_guids, this.need_sections, this.meta_data_params, super.buildUnknownFields());
        }

        public Builder() {
            this.container_guids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_guids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.container_guids = r100;
            return this;
        }

        public Builder meta_data_params(ContainerMetaDataParams r100) {
            this.meta_data_params = r100;
            return this;
        }

        public Builder need_sections(Boolean r100) {
            this.need_sections = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetTaskContainerMetaDataRequest extends ProtoAdapter<MGetTaskContainerMetaDataRequest> implements c<MGetTaskContainerMetaDataRequest> {
        public ProtoAdapter_MGetTaskContainerMetaDataRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetTaskContainerMetaDataRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetTaskContainerMetaDataRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.need_sections = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.container_guids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.need_sections = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.meta_data_params = ContainerMetaDataParams.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MGetTaskContainerMetaDataRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.container_guids);
            Boolean r102 = r100.need_sections;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            ContainerMetaDataParams r106 = r100.meta_data_params;
            if (r106 == null) goto L10;
            r103 = ContainerMetaDataParams.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetTaskContainerMetaDataRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetTaskContainerMetaDataRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetTaskContainerMetaDataRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.container_guids);
            Boolean r102 = r101.need_sections;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            ContainerMetaDataParams r103 = r101.meta_data_params;
            if (r103 == null) goto L8;
            ContainerMetaDataParams.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetTaskContainerMetaDataRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetTaskContainerMetaDataRequest r100 = new ProtoAdapter_MGetTaskContainerMetaDataRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NEED_SECTIONS = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_guids = Internal.copyOf("container_guids", this.container_guids);
        r100.need_sections = this.need_sections;
        r100.meta_data_params = this.meta_data_params;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetTaskContainerMetaDataRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetTaskContainerMetaDataRequest(List<String> r100, Boolean r101, ContainerMetaDataParams r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MGetTaskContainerMetaDataRequest(List<String> r100, Boolean r101, ContainerMetaDataParams r102, ByteString r103) {
        super(ADAPTER, r103);
        this.container_guids = Internal.immutableCopyOf("container_guids", r100);
        this.need_sections = r101;
        this.meta_data_params = r102;
    }
}
