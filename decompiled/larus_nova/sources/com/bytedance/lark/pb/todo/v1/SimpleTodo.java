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
public final class SimpleTodo extends Message<SimpleTodo, Builder> {
    public static final ProtoAdapter<SimpleTodo> ADAPTER = null;
    public static final String DEFAULT_ANCESTOR_GUID = "";
    public static final Long DEFAULT_COMPLETED_MILLI_TIME = null;
    public static final Long DEFAULT_DELETED_MILLI_TIME = null;
    public static final String DEFAULT_GUID = "";
    private static final long serialVersionUID = 0;
    public final String ancestor_guid;
    public final Long completed_milli_time;
    public final Long deleted_milli_time;
    public final String guid;
    public final RichContent rich_summary;

    public static final class Builder extends Message.Builder<SimpleTodo, Builder> {
        public String ancestor_guid;
        public Long completed_milli_time;
        public Long deleted_milli_time;
        public String guid;
        public RichContent rich_summary;

        @Override // com.squareup.wire.Message.Builder
        public SimpleTodo build() {
            return new SimpleTodo(this.guid, this.rich_summary, this.completed_milli_time, this.deleted_milli_time, this.ancestor_guid, super.buildUnknownFields());
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

        public Builder completed_milli_time(Long r100) {
            this.completed_milli_time = r100;
            return this;
        }

        public Builder deleted_milli_time(Long r100) {
            this.deleted_milli_time = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder rich_summary(RichContent r100) {
            this.rich_summary = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SimpleTodo extends ProtoAdapter<SimpleTodo> {
        public ProtoAdapter_SimpleTodo() {
            super(FieldEncoding.LENGTH_DELIMITED, SimpleTodo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SimpleTodo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.completed_milli_time = 0L;
            r101.deleted_milli_time = 0L;
            r101.ancestor_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.rich_summary = RichContent.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.completed_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.deleted_milli_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.ancestor_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SimpleTodo r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            RichContent r104 = r100.rich_summary;
            if (r104 == null) goto L9;
            int r105 = RichContent.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.completed_milli_time;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.deleted_milli_time;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.ancestor_guid;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ SimpleTodo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SimpleTodo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SimpleTodo r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            RichContent r103 = r101.rich_summary;
            if (r103 == null) goto L8;
            RichContent.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.completed_milli_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.deleted_milli_time;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.ancestor_guid;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SimpleTodo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SimpleTodo();
        DEFAULT_COMPLETED_MILLI_TIME = 0L;
        DEFAULT_DELETED_MILLI_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.rich_summary = this.rich_summary;
        r100.completed_milli_time = this.completed_milli_time;
        r100.deleted_milli_time = this.deleted_milli_time;
        r100.ancestor_guid = this.ancestor_guid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SimpleTodo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SimpleTodo(String r100, RichContent r101, Long r110, Long r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SimpleTodo(String r100, RichContent r101, Long r102, Long r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.guid = r100;
        this.rich_summary = r101;
        this.completed_milli_time = r102;
        this.deleted_milli_time = r103;
        this.ancestor_guid = r104;
    }
}
