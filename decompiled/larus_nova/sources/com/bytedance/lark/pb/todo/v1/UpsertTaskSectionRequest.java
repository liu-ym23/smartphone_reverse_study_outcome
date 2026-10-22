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
public final class UpsertTaskSectionRequest extends Message<UpsertTaskSectionRequest, Builder> {
    public static final ProtoAdapter<UpsertTaskSectionRequest> ADAPTER = null;
    public static final ProtoAdapter_UpsertTaskSectionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final TaskSection new_section;
    public final TaskSection old_section;

    public static final class Builder extends Message.Builder<UpsertTaskSectionRequest, Builder> implements d<UpsertTaskSectionRequest> {
        public TaskSection new_section;
        public TaskSection old_section;

        @Override // com.squareup.wire.Message.Builder
        public UpsertTaskSectionRequest build() {
            return new UpsertTaskSectionRequest(this.old_section, this.new_section, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder new_section(TaskSection r100) {
            this.new_section = r100;
            return this;
        }

        public Builder old_section(TaskSection r100) {
            this.old_section = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpsertTaskSectionRequest extends ProtoAdapter<UpsertTaskSectionRequest> implements c<UpsertTaskSectionRequest> {
        public ProtoAdapter_UpsertTaskSectionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpsertTaskSectionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpsertTaskSectionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.old_section = TaskSection.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.new_section = TaskSection.ADAPTER.decode(r100);
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
        public int encodedSize2(UpsertTaskSectionRequest r100) {
            TaskSection r101 = r100.old_section;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TaskSection.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            TaskSection r104 = r100.new_section;
            if (r104 == null) goto L10;
            r102 = TaskSection.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpsertTaskSectionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpsertTaskSectionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpsertTaskSectionRequest r101) throws IOException {
            TaskSection r102 = r101.old_section;
            if (r102 == null) goto L5;
            TaskSection.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TaskSection r103 = r101.new_section;
            if (r103 == null) goto L8;
            TaskSection.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpsertTaskSectionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpsertTaskSectionRequest r100 = new ProtoAdapter_UpsertTaskSectionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.old_section = this.old_section;
        r100.new_section = this.new_section;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpsertTaskSectionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpsertTaskSectionRequest(TaskSection r100, TaskSection r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpsertTaskSectionRequest(TaskSection r100, TaskSection r101, ByteString r102) {
        super(ADAPTER, r102);
        this.old_section = r100;
        this.new_section = r101;
    }
}
