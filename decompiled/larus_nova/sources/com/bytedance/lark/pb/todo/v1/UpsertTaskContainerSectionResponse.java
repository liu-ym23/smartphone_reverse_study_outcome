package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpsertTaskContainerSectionResponse extends Message<UpsertTaskContainerSectionResponse, Builder> {
    public static final ProtoAdapter<UpsertTaskContainerSectionResponse> ADAPTER = null;
    public static final ProtoAdapter_UpsertTaskContainerSectionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskContainerSection container_section;

    public static final class Builder extends Message.Builder<UpsertTaskContainerSectionResponse, Builder> implements d<UpsertTaskContainerSectionResponse> {
        public TaskContainerSection container_section;

        @Override // com.squareup.wire.Message.Builder
        public UpsertTaskContainerSectionResponse build() {
            return new UpsertTaskContainerSectionResponse(this.container_section, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_section(TaskContainerSection r100) {
            this.container_section = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpsertTaskContainerSectionResponse extends ProtoAdapter<UpsertTaskContainerSectionResponse> implements c<UpsertTaskContainerSectionResponse> {
        public ProtoAdapter_UpsertTaskContainerSectionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, UpsertTaskContainerSectionResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpsertTaskContainerSectionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.container_section = TaskContainerSection.ADAPTER.decode(r100);
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
        public int encodedSize2(UpsertTaskContainerSectionResponse r100) {
            TaskContainerSection r101 = r100.container_section;
            if (r101 == null) goto L5;
            int r102 = TaskContainerSection.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpsertTaskContainerSectionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpsertTaskContainerSectionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpsertTaskContainerSectionResponse r101) throws IOException {
            TaskContainerSection r102 = r101.container_section;
            if (r102 == null) goto L5;
            TaskContainerSection.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpsertTaskContainerSectionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpsertTaskContainerSectionResponse r100 = new ProtoAdapter_UpsertTaskContainerSectionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_section = this.container_section;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpsertTaskContainerSectionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpsertTaskContainerSectionResponse(TaskContainerSection r100) {
        this(r100, ByteString.EMPTY);
    }

    public UpsertTaskContainerSectionResponse(TaskContainerSection r100, ByteString r101) {
        super(ADAPTER, r101);
        this.container_section = r100;
    }
}
