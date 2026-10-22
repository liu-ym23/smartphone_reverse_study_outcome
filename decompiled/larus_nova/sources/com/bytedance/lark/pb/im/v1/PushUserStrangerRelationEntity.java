package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.UserStrangerRelation;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PushUserStrangerRelationEntity extends Message<PushUserStrangerRelationEntity, Builder> {
    public static final ProtoAdapter<PushUserStrangerRelationEntity> ADAPTER = null;
    public static final Boolean DEFAULT_IS_ONLINE_PUSH = null;
    public static final PutStrangerRelationSource DEFAULT_SOURCE = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_online_push;
    public final UserStrangerRelation relation;
    public final PutStrangerRelationSource source;

    public static final class Builder extends Message.Builder<PushUserStrangerRelationEntity, Builder> {
        public Boolean is_online_push;
        public UserStrangerRelation relation;
        public PutStrangerRelationSource source;

        @Override // com.squareup.wire.Message.Builder
        public PushUserStrangerRelationEntity build() {
            return new PushUserStrangerRelationEntity(this.relation, this.source, this.is_online_push, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_online_push(Boolean r100) {
            this.is_online_push = r100;
            return this;
        }

        public Builder relation(UserStrangerRelation r100) {
            this.relation = r100;
            return this;
        }

        public Builder source(PutStrangerRelationSource r100) {
            this.source = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUserStrangerRelationEntity extends ProtoAdapter<PushUserStrangerRelationEntity> {
        public ProtoAdapter_PushUserStrangerRelationEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUserStrangerRelationEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUserStrangerRelationEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source = PutStrangerRelationSource.SOURCE_UNKNOWN;
            r101.is_online_push = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.relation = UserStrangerRelation.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source = PutStrangerRelationSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_online_push = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushUserStrangerRelationEntity r100) {
            UserStrangerRelation r101 = r100.relation;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = UserStrangerRelation.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            PutStrangerRelationSource r104 = r100.source;
            if (r104 == null) goto L9;
            int r105 = PutStrangerRelationSource.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_online_push;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushUserStrangerRelationEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUserStrangerRelationEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUserStrangerRelationEntity r101) throws IOException {
            UserStrangerRelation r102 = r101.relation;
            if (r102 == null) goto L5;
            UserStrangerRelation.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            PutStrangerRelationSource r103 = r101.source;
            if (r103 == null) goto L8;
            PutStrangerRelationSource.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_online_push;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUserStrangerRelationEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushUserStrangerRelationEntity();
        DEFAULT_SOURCE = PutStrangerRelationSource.SOURCE_UNKNOWN;
        DEFAULT_IS_ONLINE_PUSH = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.relation = this.relation;
        r100.source = this.source;
        r100.is_online_push = this.is_online_push;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUserStrangerRelationEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUserStrangerRelationEntity(UserStrangerRelation r100, PutStrangerRelationSource r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushUserStrangerRelationEntity(UserStrangerRelation r100, PutStrangerRelationSource r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.relation = r100;
        this.source = r101;
        this.is_online_push = r102;
    }
}
