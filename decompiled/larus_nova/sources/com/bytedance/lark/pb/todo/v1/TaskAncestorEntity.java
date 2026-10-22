package com.bytedance.lark.pb.todo.v1;

import com.bytedance.lark.pb.basic.v1.RichContent;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TaskAncestorEntity extends Message<TaskAncestorEntity, Builder> {
    public static final ProtoAdapter<TaskAncestorEntity> ADAPTER = null;
    public static final String DEFAULT_ANCESTOR_GUID = "";
    public static final String DEFAULT_DELETED_ANCESTOR_GUID = "";
    private static final long serialVersionUID = 0;
    public final String ancestor_guid;
    public final RichContent ancestor_summary;
    public final String deleted_ancestor_guid;
    public final RichContent deleted_ancestor_summary;

    public static final class Builder extends Message.Builder<TaskAncestorEntity, Builder> {
        public String ancestor_guid;
        public RichContent ancestor_summary;
        public String deleted_ancestor_guid;
        public RichContent deleted_ancestor_summary;

        @Override // com.squareup.wire.Message.Builder
        public TaskAncestorEntity build() {
            return new TaskAncestorEntity(this.ancestor_guid, this.ancestor_summary, this.deleted_ancestor_guid, this.deleted_ancestor_summary, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ancestor_guid(String r100) {
            this.ancestor_guid = r100;
            return this;
        }

        public Builder ancestor_summary(RichContent r100) {
            this.ancestor_summary = r100;
            return this;
        }

        public Builder deleted_ancestor_guid(String r100) {
            this.deleted_ancestor_guid = r100;
            return this;
        }

        public Builder deleted_ancestor_summary(RichContent r100) {
            this.deleted_ancestor_summary = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TaskAncestorEntity extends ProtoAdapter<TaskAncestorEntity> {
        public ProtoAdapter_TaskAncestorEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TaskAncestorEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TaskAncestorEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.ancestor_guid = "";
            r101.deleted_ancestor_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.ancestor_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.ancestor_summary = RichContent.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.deleted_ancestor_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.deleted_ancestor_summary = RichContent.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TaskAncestorEntity r100) {
            String r101 = r100.ancestor_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            RichContent r104 = r100.ancestor_summary;
            if (r104 == null) goto L9;
            int r105 = RichContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.deleted_ancestor_guid;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            RichContent r110 = r100.deleted_ancestor_summary;
            if (r110 == null) goto L18;
            r102 = RichContent.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TaskAncestorEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TaskAncestorEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TaskAncestorEntity r101) throws IOException {
            String r102 = r101.ancestor_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            RichContent r103 = r101.ancestor_summary;
            if (r103 == null) goto L8;
            RichContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.deleted_ancestor_guid;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            RichContent r105 = r101.deleted_ancestor_summary;
            if (r105 == null) goto L14;
            RichContent.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TaskAncestorEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TaskAncestorEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ancestor_guid = this.ancestor_guid;
        r100.ancestor_summary = this.ancestor_summary;
        r100.deleted_ancestor_guid = this.deleted_ancestor_guid;
        r100.deleted_ancestor_summary = this.deleted_ancestor_summary;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TaskAncestorEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TaskAncestorEntity(String r100, RichContent r101, String r102, RichContent r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TaskAncestorEntity(String r100, RichContent r101, String r102, RichContent r103, ByteString r104) {
        super(ADAPTER, r104);
        this.ancestor_guid = r100;
        this.ancestor_summary = r101;
        this.deleted_ancestor_guid = r102;
        this.deleted_ancestor_summary = r103;
    }
}
