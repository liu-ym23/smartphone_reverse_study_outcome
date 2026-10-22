package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
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

/* JADX INFO: loaded from: classes20.dex */
public final class Abbreviation extends com.squareup.wire.Message<Abbreviation, Builder> {
    public static final ProtoAdapter<Abbreviation> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Abbrs> abbr_element_ref;

    public static final class Abbrs extends com.squareup.wire.Message<Abbrs, Builder> {
        public static final ProtoAdapter<Abbrs> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<entity> abbrs;

        public static final class Builder extends com.squareup.wire.Message.Builder<Abbrs, Builder> {
            public List<entity> abbrs;

            @Override // com.squareup.wire.Message.Builder
            public Abbrs build() {
                return new Abbrs(this.abbrs, super.buildUnknownFields());
            }

            public Builder() {
                this.abbrs = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder abbrs(List<entity> r100) {
                Internal.checkElementsNotNull(r100);
                this.abbrs = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Abbrs extends ProtoAdapter<Abbrs> {
            public ProtoAdapter_Abbrs() {
                super(FieldEncoding.LENGTH_DELIMITED, Abbrs.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Abbrs decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.abbrs.add(entity.ADAPTER.decode(r100));
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
            public int encodedSize2(Abbrs r100) {
                return entity.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.abbrs) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Abbrs decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Abbrs r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Abbrs r101) throws IOException {
                entity.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.abbrs);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Abbrs r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Abbrs();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.abbrs = Internal.copyOf("abbrs", this.abbrs);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Abbrs.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Abbrs(List<entity> r100) {
            this(r100, ByteString.EMPTY);
        }

        public Abbrs(List<entity> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.abbrs = Internal.immutableCopyOf("abbrs", r100);
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<Abbreviation, Builder> {
        public Map<String, Abbrs> abbr_element_ref;

        @Override // com.squareup.wire.Message.Builder
        public Abbreviation build() {
            return new Abbreviation(this.abbr_element_ref, super.buildUnknownFields());
        }

        public Builder() {
            this.abbr_element_ref = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder abbr_element_ref(Map<String, Abbrs> r100) {
            Internal.checkElementsNotNull(r100);
            this.abbr_element_ref = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Abbreviation extends ProtoAdapter<Abbreviation> {
        private final ProtoAdapter<Map<String, Abbrs>> abbr_element_ref;

        public ProtoAdapter_Abbreviation() {
            super(FieldEncoding.LENGTH_DELIMITED, Abbreviation.class);
            this.abbr_element_ref = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Abbrs.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Abbreviation decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.abbr_element_ref.putAll(this.abbr_element_ref.decode(r100));
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
        public int encodedSize2(Abbreviation r100) {
            return this.abbr_element_ref.encodedSizeWithTag(1, r100.abbr_element_ref) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Abbreviation decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Abbreviation r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Abbreviation r101) throws IOException {
            this.abbr_element_ref.encodeWithTag(r100, 1, r101.abbr_element_ref);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Abbreviation r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class entity extends com.squareup.wire.Message<entity, Builder> {
        public static final ProtoAdapter<entity> ADAPTER = null;
        public static final String DEFAULT_ABBR_ID = "";
        public static final Type DEFAULT_ABBR_TYPE = null;
        public static final Integer DEFAULT_ABBR_VERSION = null;
        private static final long serialVersionUID = 0;
        public final String abbr_id;
        public final Type abbr_type;
        public final Integer abbr_version;
        public final DatetimeEntity datetime;

        public static final class Builder extends com.squareup.wire.Message.Builder<entity, Builder> {
            public String abbr_id;
            public Type abbr_type;
            public Integer abbr_version;
            public DatetimeEntity datetime;

            @Override // com.squareup.wire.Message.Builder
            public entity build() {
                return new entity(this.abbr_id, this.abbr_version, this.abbr_type, this.datetime, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder abbr_id(String r100) {
                this.abbr_id = r100;
                return this;
            }

            public Builder abbr_type(Type r100) {
                this.abbr_type = r100;
                return this;
            }

            public Builder abbr_version(Integer r100) {
                this.abbr_version = r100;
                return this;
            }

            public Builder datetime(DatetimeEntity r100) {
                this.datetime = r100;
                return this;
            }
        }

        public static final class DatetimeEntity extends com.squareup.wire.Message<DatetimeEntity, Builder> {
            public static final ProtoAdapter<DatetimeEntity> ADAPTER = null;
            public static final Integer DEFAULT_DURATION = null;
            public static final Long DEFAULT_END = null;
            public static final String DEFAULT_GRAIN = "";
            public static final Long DEFAULT_START = null;
            private static final long serialVersionUID = 0;
            public final Integer duration;
            public final Long end;
            public final String grain;
            public final Long start;

            public static final class Builder extends com.squareup.wire.Message.Builder<DatetimeEntity, Builder> {
                public Integer duration;
                public Long end;
                public String grain;
                public Long start;

                @Override // com.squareup.wire.Message.Builder
                public DatetimeEntity build() {
                    return new DatetimeEntity(this.start, this.end, this.duration, this.grain, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                    return build();
                }

                public Builder duration(Integer r100) {
                    this.duration = r100;
                    return this;
                }

                public Builder end(Long r100) {
                    this.end = r100;
                    return this;
                }

                public Builder grain(String r100) {
                    this.grain = r100;
                    return this;
                }

                public Builder start(Long r100) {
                    this.start = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_DatetimeEntity extends ProtoAdapter<DatetimeEntity> {
                public ProtoAdapter_DatetimeEntity() {
                    super(FieldEncoding.LENGTH_DELIMITED, DatetimeEntity.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public DatetimeEntity decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.start = 0L;
                    r101.end = 0L;
                    r101.duration = 0;
                    r101.grain = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L18;
                    if (r103 != 1) goto L8;
                    r101.start = ProtoAdapter.INT64.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.end = ProtoAdapter.INT64.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.duration = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L13;
                    r101.grain = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(DatetimeEntity r100) {
                    Long r101 = r100.start;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
                L6:
                    Long r104 = r100.end;
                    if (r104 == null) goto L9;
                    int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
                L10:
                    int r106 = r103 + r105;
                    Integer r107 = r100.duration;
                    if (r107 == null) goto L13;
                    int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
                L14:
                    int r109 = r106 + r108;
                    String r110 = r100.grain;
                    if (r110 == null) goto L18;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
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
                public /* bridge */ /* synthetic */ DatetimeEntity decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(DatetimeEntity r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, DatetimeEntity r101) throws IOException {
                    Long r102 = r101.start;
                    if (r102 == null) goto L5;
                    ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
                L5:
                    Long r103 = r101.end;
                    if (r103 == null) goto L8;
                    ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
                L8:
                    Integer r104 = r101.duration;
                    if (r104 == null) goto L11;
                    ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
                L11:
                    String r105 = r101.grain;
                    if (r105 == null) goto L14;
                    ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
                L14:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DatetimeEntity r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_DatetimeEntity();
                DEFAULT_START = 0L;
                DEFAULT_END = 0L;
                DEFAULT_DURATION = 0;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.start = this.start;
                r100.end = this.end;
                r100.duration = this.duration;
                r100.grain = this.grain;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return DatetimeEntity.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
                return newBuilder();
            }

            public DatetimeEntity(Long r100, Long r101, Integer r102, String r110) {
                this(r100, r101, r102, r110, ByteString.EMPTY);
            }

            public DatetimeEntity(Long r100, Long r101, Integer r102, String r103, ByteString r104) {
                super(ADAPTER, r104);
                this.start = r100;
                this.end = r101;
                this.duration = r102;
                this.grain = r103;
            }
        }

        public static final class ProtoAdapter_entity extends ProtoAdapter<entity> {
            public ProtoAdapter_entity() {
                super(FieldEncoding.LENGTH_DELIMITED, entity.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public entity decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.abbr_id = "";
                r101.abbr_version = 0;
                r101.abbr_type = Type.UNKOWN;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.abbr_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.abbr_version = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.abbr_type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
            L17:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.datetime = DatetimeEntity.ADAPTER.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(entity r100) {
                String r101 = r100.abbr_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.abbr_version;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Type r107 = r100.abbr_type;
                if (r107 == null) goto L13;
                int r108 = Type.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                DatetimeEntity r110 = r100.datetime;
                if (r110 == null) goto L18;
                r102 = DatetimeEntity.ADAPTER.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ entity decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(entity r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, entity r101) throws IOException {
                String r102 = r101.abbr_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.abbr_version;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                Type r104 = r101.abbr_type;
                if (r104 == null) goto L11;
                Type.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                DatetimeEntity r105 = r101.datetime;
                if (r105 == null) goto L14;
                DatetimeEntity.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, entity r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum Type extends Enum<Type> implements WireEnum {
            private static final /* synthetic */ Type[] $VALUES = null;
            public static final Type ACRONYM = null;
            public static final ProtoAdapter<Type> ADAPTER = null;
            public static final Type DATETIME = null;
            public static final Type UNKOWN = null;
            public static final Type WIKI = null;
            private final int value;

            static {
                Type r100 = new Type("UNKOWN", 0, 0);
                UNKOWN = r100;
                Type r101 = new Type("ACRONYM", 1, 1);
                ACRONYM = r101;
                Type r102 = new Type("WIKI", 2, 2);
                WIKI = r102;
                Type r103 = new Type("DATETIME", 3, 3);
                DATETIME = r103;
                $VALUES = new Type[]{r100, r101, r102, r103};
                ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
            }

            public static Type[] values() {
                return (Type[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static Type fromValue(int r100) {
                if (r100 == 0) goto L18;
                if (r100 == 1) goto L16;
                if (r100 == 2) goto L14;
                if (r100 == 3) goto L12;
                return null;
            L12:
                return DATETIME;
            L14:
                return WIKI;
            L16:
                return ACRONYM;
            L18:
                return UNKOWN;
            }

            public static Type valueOf(String r100) {
                return (Type) a.a(Type.class, r100);
            }

            private Type(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_entity();
            DEFAULT_ABBR_VERSION = 0;
            DEFAULT_ABBR_TYPE = Type.UNKOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.abbr_id = this.abbr_id;
            r100.abbr_version = this.abbr_version;
            r100.abbr_type = this.abbr_type;
            r100.datetime = this.datetime;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return entity.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public entity(String r100, Integer r101, Type r102, DatetimeEntity r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public entity(String r100, Integer r101, Type r102, DatetimeEntity r103, ByteString r104) {
            super(ADAPTER, r104);
            this.abbr_id = r100;
            this.abbr_version = r101;
            this.abbr_type = r102;
            this.datetime = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Abbreviation();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.abbr_element_ref = Internal.copyOf("abbr_element_ref", this.abbr_element_ref);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Abbreviation.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Abbreviation(Map<String, Abbrs> r100) {
        this(r100, ByteString.EMPTY);
    }

    public Abbreviation(Map<String, Abbrs> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.abbr_element_ref = Internal.immutableCopyOf("abbr_element_ref", r100);
    }
}
