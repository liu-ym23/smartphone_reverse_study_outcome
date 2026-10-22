package com.bytedance.lark.pb.ugreach.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ReachPointRelation extends Message<ReachPointRelation, Builder> {
    public static final ProtoAdapter<ReachPointRelation> ADAPTER = null;
    public static final DefenseStrategy DEFAULT_DEFENSE_STRATEGY = null;
    public static final Boolean DEFAULT_IS_CONFLICT = null;
    public static final Boolean DEFAULT_NEED_GRAB = null;
    public static final String DEFAULT_PARENT_ID = "";
    public static final Integer DEFAULT_PRIORITY = null;
    public static final Integer DEFAULT_TTL = null;
    private static final long serialVersionUID = 0;
    public final List<String> child_ids;
    public final DefenseStrategy defense_strategy;
    public final Boolean is_conflict;
    public final Boolean need_grab;
    public final String parent_id;
    public final Integer priority;
    public final Integer ttl;

    public static final class Builder extends Message.Builder<ReachPointRelation, Builder> {
        public List<String> child_ids;
        public DefenseStrategy defense_strategy;
        public Boolean is_conflict;
        public Boolean need_grab;
        public String parent_id;
        public Integer priority;
        public Integer ttl;

        @Override // com.squareup.wire.Message.Builder
        public ReachPointRelation build() {
            return new ReachPointRelation(this.parent_id, this.child_ids, this.is_conflict, this.priority, this.need_grab, this.ttl, this.defense_strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.child_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder child_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.child_ids = r100;
            return this;
        }

        public Builder defense_strategy(DefenseStrategy r100) {
            this.defense_strategy = r100;
            return this;
        }

        public Builder is_conflict(Boolean r100) {
            this.is_conflict = r100;
            return this;
        }

        public Builder need_grab(Boolean r100) {
            this.need_grab = r100;
            return this;
        }

        public Builder parent_id(String r100) {
            this.parent_id = r100;
            return this;
        }

        public Builder priority(Integer r100) {
            this.priority = r100;
            return this;
        }

        public Builder ttl(Integer r100) {
            this.ttl = r100;
            return this;
        }
    }

    public static final enum DefenseStrategy extends Enum<DefenseStrategy> implements WireEnum {
        private static final /* synthetic */ DefenseStrategy[] $VALUES = null;
        public static final ProtoAdapter<DefenseStrategy> ADAPTER = null;
        public static final DefenseStrategy GIVE_UP = null;
        public static final DefenseStrategy ROUNDABOUT = null;
        public static final DefenseStrategy UNKNOWN = null;
        private final int value;

        static {
            DefenseStrategy r100 = new DefenseStrategy("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            DefenseStrategy r101 = new DefenseStrategy("ROUNDABOUT", 1, 1);
            ROUNDABOUT = r101;
            DefenseStrategy r102 = new DefenseStrategy("GIVE_UP", 2, 2);
            GIVE_UP = r102;
            $VALUES = new DefenseStrategy[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(DefenseStrategy.class);
        }

        public static DefenseStrategy[] values() {
            return (DefenseStrategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DefenseStrategy fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return GIVE_UP;
        L12:
            return ROUNDABOUT;
        L14:
            return UNKNOWN;
        }

        public static DefenseStrategy valueOf(String r100) {
            return (DefenseStrategy) a.a(DefenseStrategy.class, r100);
        }

        private DefenseStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ReachPointRelation extends ProtoAdapter<ReachPointRelation> {
        public ProtoAdapter_ReachPointRelation() {
            super(FieldEncoding.LENGTH_DELIMITED, ReachPointRelation.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ReachPointRelation decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.parent_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.is_conflict = r102;
            r101.priority = 0;
            r101.need_grab = r102;
            r101.ttl = 0;
            r101.defense_strategy = DefenseStrategy.UNKNOWN;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L17;
            switch(r104) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L19;
                default: goto L6;
            };
        L19:
            r101.defense_strategy = DefenseStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.ttl = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.need_grab = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.priority = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.is_conflict = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            r101.child_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L16:
            r101.parent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ReachPointRelation r100) {
            String r101 = r100.parent_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.child_ids);
            Boolean r105 = r100.is_conflict;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Integer r108 = r100.priority;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.INT32.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            Boolean r111 = r100.need_grab;
            if (r111 == null) goto L17;
            int r112 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r111);
        L18:
            int r113 = r110 + r112;
            Integer r114 = r100.ttl;
            if (r114 == null) goto L21;
            int r115 = ProtoAdapter.INT32.encodedSizeWithTag(6, r114);
        L22:
            int r116 = r113 + r115;
            DefenseStrategy r117 = r100.defense_strategy;
            if (r117 == null) goto L26;
            r102 = DefenseStrategy.ADAPTER.encodedSizeWithTag(7, r117);
        L26:
            return (r116 + r102) + r100.unknownFields().size();
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ReachPointRelation decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ReachPointRelation r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ReachPointRelation r101) throws IOException {
            String r102 = r101.parent_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.child_ids);
            Boolean r103 = r101.is_conflict;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            Integer r104 = r101.priority;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L11:
            Boolean r105 = r101.need_grab;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            Integer r106 = r101.ttl;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
        L17:
            DefenseStrategy r107 = r101.defense_strategy;
            if (r107 == null) goto L20;
            DefenseStrategy.ADAPTER.encodeWithTag(r100, 7, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReachPointRelation r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ReachPointRelation();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_CONFLICT = r100;
        DEFAULT_PRIORITY = 0;
        DEFAULT_NEED_GRAB = r100;
        DEFAULT_TTL = 0;
        DEFAULT_DEFENSE_STRATEGY = DefenseStrategy.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.parent_id = this.parent_id;
        r100.child_ids = Internal.copyOf("child_ids", this.child_ids);
        r100.is_conflict = this.is_conflict;
        r100.priority = this.priority;
        r100.need_grab = this.need_grab;
        r100.ttl = this.ttl;
        r100.defense_strategy = this.defense_strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ReachPointRelation.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ReachPointRelation(String r110, List<String> r111, Boolean r112, Integer r113, Boolean r114, Integer r115, DefenseStrategy r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ReachPointRelation(String r100, List<String> r101, Boolean r102, Integer r103, Boolean r104, Integer r105, DefenseStrategy r106, ByteString r107) {
        super(ADAPTER, r107);
        this.parent_id = r100;
        this.child_ids = Internal.immutableCopyOf("child_ids", r101);
        this.is_conflict = r102;
        this.priority = r103;
        this.need_grab = r104;
        this.ttl = r105;
        this.defense_strategy = r106;
    }
}
