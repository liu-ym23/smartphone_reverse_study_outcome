package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MessageLastVisibleInfoPatch extends com.squareup.wire.Message<MessageLastVisibleInfoPatch, Builder> {
    public static final ProtoAdapter<MessageLastVisibleInfoPatch> ADAPTER = null;
    public static final Long DEFAULT_REMOVED_LAST_ID = null;
    public static final Integer DEFAULT_REMOVED_LAST_POSITION = null;
    public static final Long DEFAULT_VISIBLE_ID = null;
    public static final Integer DEFAULT_VISIBLE_POSITION = null;
    private static final long serialVersionUID = 0;
    public final Long mremoved_last_id;
    public final Integer mremoved_last_position;
    public final Long mvisible_id;
    public final Integer mvisible_position;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageLastVisibleInfoPatch, Builder> {
        public Long mremoved_last_id;
        public Integer mremoved_last_position;
        public Long mvisible_id;
        public Integer mvisible_position;

        @Override // com.squareup.wire.Message.Builder
        public MessageLastVisibleInfoPatch build() {
            return new MessageLastVisibleInfoPatch(this.mvisible_id, this.mvisible_position, this.mremoved_last_position, this.mremoved_last_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder removed_last_id(Long r100) {
            this.mremoved_last_id = r100;
            return this;
        }

        public Builder removed_last_position(Integer r100) {
            this.mremoved_last_position = r100;
            return this;
        }

        public Builder visible_id(Long r100) {
            this.mvisible_id = r100;
            return this;
        }

        public Builder visible_position(Integer r100) {
            this.mvisible_position = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageLastVisibleInfoPatch extends ProtoAdapter<MessageLastVisibleInfoPatch> {
        public ProtoAdapter_MessageLastVisibleInfoPatch() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageLastVisibleInfoPatch.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageLastVisibleInfoPatch decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mvisible_id = 0L;
            r101.mvisible_position = 0;
            r101.mremoved_last_position = 0;
            r101.mremoved_last_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mvisible_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mvisible_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mremoved_last_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mremoved_last_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(MessageLastVisibleInfoPatch r100) {
            Long r101 = r100.mvisible_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mvisible_position;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.mremoved_last_position;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.mremoved_last_id;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ MessageLastVisibleInfoPatch decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageLastVisibleInfoPatch r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageLastVisibleInfoPatch r101) throws IOException {
            Long r102 = r101.mvisible_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mvisible_position;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.mremoved_last_position;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.mremoved_last_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageLastVisibleInfoPatch r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageLastVisibleInfoPatch();
        DEFAULT_VISIBLE_ID = 0L;
        DEFAULT_VISIBLE_POSITION = 0;
        DEFAULT_REMOVED_LAST_POSITION = 0;
        DEFAULT_REMOVED_LAST_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mvisible_id = this.mvisible_id;
        r100.mvisible_position = this.mvisible_position;
        r100.mremoved_last_position = this.mremoved_last_position;
        r100.mremoved_last_id = this.mremoved_last_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageLastVisibleInfoPatch.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageLastVisibleInfoPatch(Long r100, Integer r101, Integer r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public MessageLastVisibleInfoPatch(Long r100, Integer r101, Integer r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mvisible_id = r100;
        this.mvisible_position = r101;
        this.mremoved_last_position = r102;
        this.mremoved_last_id = r103;
    }
}
