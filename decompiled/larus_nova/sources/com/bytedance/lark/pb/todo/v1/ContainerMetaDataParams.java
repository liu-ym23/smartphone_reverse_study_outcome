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
public final class ContainerMetaDataParams extends Message<ContainerMetaDataParams, Builder> {
    public static final ProtoAdapter<ContainerMetaDataParams> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TaskViewParam> view_params;

    public static final class Builder extends Message.Builder<ContainerMetaDataParams, Builder> {
        public List<TaskViewParam> view_params;

        @Override // com.squareup.wire.Message.Builder
        public ContainerMetaDataParams build() {
            return new ContainerMetaDataParams(this.view_params, super.buildUnknownFields());
        }

        public Builder() {
            this.view_params = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder view_params(List<TaskViewParam> r100) {
            Internal.checkElementsNotNull(r100);
            this.view_params = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ContainerMetaDataParams extends ProtoAdapter<ContainerMetaDataParams> {
        public ProtoAdapter_ContainerMetaDataParams() {
            super(FieldEncoding.LENGTH_DELIMITED, ContainerMetaDataParams.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ContainerMetaDataParams decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.view_params.add(TaskViewParam.ADAPTER.decode(r100));
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
        public int encodedSize2(ContainerMetaDataParams r100) {
            return TaskViewParam.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.view_params) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ContainerMetaDataParams decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ContainerMetaDataParams r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ContainerMetaDataParams r101) throws IOException {
            TaskViewParam.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.view_params);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ContainerMetaDataParams r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ContainerMetaDataParams();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.view_params = Internal.copyOf("view_params", this.view_params);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ContainerMetaDataParams.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ContainerMetaDataParams(List<TaskViewParam> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ContainerMetaDataParams(List<TaskViewParam> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.view_params = Internal.immutableCopyOf("view_params", r100);
    }
}
