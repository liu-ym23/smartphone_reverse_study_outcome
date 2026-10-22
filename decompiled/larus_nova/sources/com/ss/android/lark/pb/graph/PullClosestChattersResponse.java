package com.ss.android.lark.pb.graph;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class PullClosestChattersResponse extends Message<PullClosestChattersResponse, Builder> {
    public static final ProtoAdapter<PullClosestChattersResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Integer DEFAULT_TOTAL = null;
    private static final long serialVersionUID = 0;
    public final List<ChatterMeta> mchatters;
    public final Boolean mhas_more;
    public final Map<String, RelationshipTypeVector> mrelationship_map;
    public final Integer mtotal;

    public static final class Builder extends Message.Builder<PullClosestChattersResponse, Builder> {
        public List<ChatterMeta> mchatters;
        public Boolean mhas_more;
        public Map<String, RelationshipTypeVector> mrelationship_map;
        public Integer mtotal;

        @Override // com.squareup.wire.Message.Builder
        public PullClosestChattersResponse build() {
            return new PullClosestChattersResponse(this.mchatters, this.mtotal, this.mhas_more, this.mrelationship_map, super.buildUnknownFields());
        }

        public Builder() {
            this.mchatters = Internal.newMutableList();
            this.mrelationship_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatters(List<ChatterMeta> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchatters = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.mhas_more = r100;
            return this;
        }

        public Builder relationship_map(Map<String, RelationshipTypeVector> r100) {
            Internal.checkElementsNotNull(r100);
            this.mrelationship_map = r100;
            return this;
        }

        public Builder total(Integer r100) {
            this.mtotal = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullClosestChattersResponse extends ProtoAdapter<PullClosestChattersResponse> {
        private final ProtoAdapter<Map<String, RelationshipTypeVector>> mrelationship_map;

        public ProtoAdapter_PullClosestChattersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullClosestChattersResponse.class);
            this.mrelationship_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, RelationshipTypeVector.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullClosestChattersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtotal = 0;
            r101.mhas_more = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mchatters.add(ChatterMeta.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtotal = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mhas_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mrelationship_map.putAll(this.mrelationship_map.decode(r100));
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
        public int encodedSize2(PullClosestChattersResponse r100) {
            int r101 = ChatterMeta.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mchatters);
            Integer r102 = r100.mtotal;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT32.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.mhas_more;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return ((r105 + r103) + this.mrelationship_map.encodedSizeWithTag(4, r100.mrelationship_map)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullClosestChattersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullClosestChattersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullClosestChattersResponse r101) throws IOException {
            ChatterMeta.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mchatters);
            Integer r102 = r101.mtotal;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.mhas_more;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            this.mrelationship_map.encodeWithTag(r100, 4, r101.mrelationship_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullClosestChattersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum RelationshipType extends Enum<RelationshipType> implements WireEnum {
        private static final /* synthetic */ RelationshipType[] $VALUES = null;
        public static final ProtoAdapter<RelationshipType> ADAPTER = null;
        public static final RelationshipType RELATIONSHIP_B2B_FRIEND = null;
        public static final RelationshipType RELATIONSHIP_OUTER_FRIEND = null;
        public static final RelationshipType RELATIONSHIP_UNKNOWN = null;
        private final int value;

        static {
            RelationshipType r100 = new RelationshipType("RELATIONSHIP_UNKNOWN", 0, 0);
            RELATIONSHIP_UNKNOWN = r100;
            RelationshipType r101 = new RelationshipType("RELATIONSHIP_B2B_FRIEND", 1, 1);
            RELATIONSHIP_B2B_FRIEND = r101;
            RelationshipType r102 = new RelationshipType("RELATIONSHIP_OUTER_FRIEND", 2, 2);
            RELATIONSHIP_OUTER_FRIEND = r102;
            $VALUES = new RelationshipType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(RelationshipType.class);
        }

        public static RelationshipType[] values() {
            return (RelationshipType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static RelationshipType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return RELATIONSHIP_OUTER_FRIEND;
        L12:
            return RELATIONSHIP_B2B_FRIEND;
        L14:
            return RELATIONSHIP_UNKNOWN;
        }

        public static RelationshipType valueOf(String r100) {
            return (RelationshipType) a.a(RelationshipType.class, r100);
        }

        private RelationshipType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class RelationshipTypeVector extends Message<RelationshipTypeVector, Builder> {
        public static final ProtoAdapter<RelationshipTypeVector> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<RelationshipType> mrelationships;

        public static final class Builder extends Message.Builder<RelationshipTypeVector, Builder> {
            public List<RelationshipType> mrelationships;

            @Override // com.squareup.wire.Message.Builder
            public RelationshipTypeVector build() {
                return new RelationshipTypeVector(this.mrelationships, super.buildUnknownFields());
            }

            public Builder() {
                this.mrelationships = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder relationships(List<RelationshipType> r100) {
                Internal.checkElementsNotNull(r100);
                this.mrelationships = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_RelationshipTypeVector extends ProtoAdapter<RelationshipTypeVector> {
            public ProtoAdapter_RelationshipTypeVector() {
                super(FieldEncoding.LENGTH_DELIMITED, RelationshipTypeVector.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public RelationshipTypeVector decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L7;
                r101.mrelationships.add(RelationshipType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(RelationshipTypeVector r100) {
                return RelationshipType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mrelationships) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ RelationshipTypeVector decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(RelationshipTypeVector r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, RelationshipTypeVector r101) throws IOException {
                RelationshipType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mrelationships);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RelationshipTypeVector r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_RelationshipTypeVector();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mrelationships = Internal.copyOf("mrelationships", this.mrelationships);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return RelationshipTypeVector.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public RelationshipTypeVector(List<RelationshipType> r100) {
            this(r100, ByteString.EMPTY);
        }

        public RelationshipTypeVector(List<RelationshipType> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mrelationships = Internal.immutableCopyOf("mrelationships", r100);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullClosestChattersResponse();
        DEFAULT_TOTAL = 0;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchatters = Internal.copyOf("mchatters", this.mchatters);
        r100.mtotal = this.mtotal;
        r100.mhas_more = this.mhas_more;
        r100.mrelationship_map = Internal.copyOf("mrelationship_map", this.mrelationship_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullClosestChattersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullClosestChattersResponse(List<ChatterMeta> r100, Integer r101, Boolean r102, Map<String, RelationshipTypeVector> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PullClosestChattersResponse(List<ChatterMeta> r100, Integer r101, Boolean r102, Map<String, RelationshipTypeVector> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mchatters = Internal.immutableCopyOf("mchatters", r100);
        this.mtotal = r101;
        this.mhas_more = r102;
        this.mrelationship_map = Internal.immutableCopyOf("mrelationship_map", r103);
    }
}
