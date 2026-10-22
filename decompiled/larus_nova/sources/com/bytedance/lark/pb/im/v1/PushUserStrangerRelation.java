package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushUserStrangerRelation extends Message<PushUserStrangerRelation, Builder> {
    public static final ProtoAdapter<PushUserStrangerRelation> ADAPTER = null;
    public static final ProtoAdapter_PushUserStrangerRelation RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, PushUserStrangerRelationEntity> stranger_relations;

    public static final class Builder extends Message.Builder<PushUserStrangerRelation, Builder> implements d<PushUserStrangerRelation> {
        public Map<Long, PushUserStrangerRelationEntity> stranger_relations;

        @Override // com.squareup.wire.Message.Builder
        public PushUserStrangerRelation build() {
            return new PushUserStrangerRelation(this.stranger_relations, super.buildUnknownFields());
        }

        public Builder() {
            this.stranger_relations = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder stranger_relations(Map<Long, PushUserStrangerRelationEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.stranger_relations = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUserStrangerRelation extends ProtoAdapter<PushUserStrangerRelation> implements c<PushUserStrangerRelation> {
        private final ProtoAdapter<Map<Long, PushUserStrangerRelationEntity>> stranger_relations;

        public ProtoAdapter_PushUserStrangerRelation() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUserStrangerRelation.class);
            this.stranger_relations = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, PushUserStrangerRelationEntity.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUserStrangerRelation decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.stranger_relations.putAll(this.stranger_relations.decode(r100));
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
        public int encodedSize2(PushUserStrangerRelation r100) {
            return this.stranger_relations.encodedSizeWithTag(1, r100.stranger_relations) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushUserStrangerRelation decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUserStrangerRelation r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUserStrangerRelation r101) throws IOException {
            this.stranger_relations.encodeWithTag(r100, 1, r101.stranger_relations);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUserStrangerRelation r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushUserStrangerRelation r100 = new ProtoAdapter_PushUserStrangerRelation();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.stranger_relations = Internal.copyOf("stranger_relations", this.stranger_relations);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUserStrangerRelation.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUserStrangerRelation(Map<Long, PushUserStrangerRelationEntity> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushUserStrangerRelation(Map<Long, PushUserStrangerRelationEntity> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.stranger_relations = Internal.immutableCopyOf("stranger_relations", r100);
    }
}
