package com.ss.android.lark.pb.pan;

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
public final class ImageOCRResponse extends Message<ImageOCRResponse, Builder> {
    public static final ProtoAdapter<ImageOCRResponse> ADAPTER = null;
    public static final Integer DEFAULT_HEIGHT = null;
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Integer mheight;
    public final List<Line> mlines;
    public final List<Region> mregions;
    public final Map<Integer, Entities> mtype_to_entities;
    public final Integer mwidth;

    public static final class Builder extends Message.Builder<ImageOCRResponse, Builder> {
        public Integer mheight;
        public List<Line> mlines;
        public List<Region> mregions;
        public Map<Integer, Entities> mtype_to_entities;
        public Integer mwidth;

        @Override // com.squareup.wire.Message.Builder
        public ImageOCRResponse build() {
            Integer r100 = this.mwidth;
            if (r100 == null) goto L9;
            if (this.mheight == null) goto L9;
            return new ImageOCRResponse(this.mlines, this.mregions, this.mtype_to_entities, this.mwidth, this.mheight, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mwidth", this.mheight, "mheight"});
        }

        public Builder() {
            this.mlines = Internal.newMutableList();
            this.mregions = Internal.newMutableList();
            this.mtype_to_entities = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder height(Integer r100) {
            this.mheight = r100;
            return this;
        }

        public Builder lines(List<Line> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlines = r100;
            return this;
        }

        public Builder regions(List<Region> r100) {
            Internal.checkElementsNotNull(r100);
            this.mregions = r100;
            return this;
        }

        public Builder type_to_entities(Map<Integer, Entities> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtype_to_entities = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.mwidth = r100;
            return this;
        }
    }

    public static final class Entities extends Message<Entities, Builder> {
        public static final ProtoAdapter<Entities> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Entity> mlist;

        public static final class Builder extends Message.Builder<Entities, Builder> {
            public List<Entity> mlist;

            @Override // com.squareup.wire.Message.Builder
            public Entities build() {
                return new Entities(this.mlist, super.buildUnknownFields());
            }

            public Builder() {
                this.mlist = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder list(List<Entity> r100) {
                Internal.checkElementsNotNull(r100);
                this.mlist = r100;
                return this;
            }
        }

        public static final class Entity extends Message<Entity, Builder> {
            public static final ProtoAdapter<Entity> ADAPTER = null;
            public static final Integer DEFAULT_REGION_ID = null;
            public static final String DEFAULT_TEXT = "";
            private static final long serialVersionUID = 0;
            public final Map<String, String> mentity_ext;
            public final List<LineMsg> mline_msgs;
            public final Integer mregion_id;
            public final Range mregion_range;
            public final String mtext;

            public static final class Builder extends Message.Builder<Entity, Builder> {
                public Map<String, String> mentity_ext;
                public List<LineMsg> mline_msgs;
                public Integer mregion_id;
                public Range mregion_range;
                public String mtext;

                @Override // com.squareup.wire.Message.Builder
                public Entity build() {
                    String r100 = this.mtext;
                    if (r100 == null) goto L11;
                    if (this.mregion_id == null) goto L11;
                    if (this.mregion_range == null) goto L11;
                    return new Entity(this.mtext, this.mregion_id, this.mregion_range, this.mline_msgs, this.mentity_ext, super.buildUnknownFields());
                L11:
                    throw Internal.missingRequiredFields(new Object[]{r100, "mtext", this.mregion_id, "mregion_id", this.mregion_range, "mregion_range"});
                }

                public Builder() {
                    this.mline_msgs = Internal.newMutableList();
                    this.mentity_ext = Internal.newMutableMap();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder entity_ext(Map<String, String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.mentity_ext = r100;
                    return this;
                }

                public Builder line_msgs(List<LineMsg> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.mline_msgs = r100;
                    return this;
                }

                public Builder region_id(Integer r100) {
                    this.mregion_id = r100;
                    return this;
                }

                public Builder region_range(Range r100) {
                    this.mregion_range = r100;
                    return this;
                }

                public Builder text(String r100) {
                    this.mtext = r100;
                    return this;
                }
            }

            public static final class LineMsg extends Message<LineMsg, Builder> {
                public static final ProtoAdapter<LineMsg> ADAPTER = null;
                public static final Integer DEFAULT_LINE_ID = null;
                private static final long serialVersionUID = 0;
                public final Integer mline_id;
                public final Range mline_range;

                public static final class Builder extends Message.Builder<LineMsg, Builder> {
                    public Integer mline_id;
                    public Range mline_range;

                    @Override // com.squareup.wire.Message.Builder
                    public LineMsg build() {
                        Integer r100 = this.mline_id;
                        if (r100 == null) goto L9;
                        if (this.mline_range == null) goto L9;
                        return new LineMsg(this.mline_id, this.mline_range, super.buildUnknownFields());
                    L9:
                        throw Internal.missingRequiredFields(new Object[]{r100, "mline_id", this.mline_range, "mline_range"});
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ Message build() {
                        return build();
                    }

                    public Builder line_id(Integer r100) {
                        this.mline_id = r100;
                        return this;
                    }

                    public Builder line_range(Range r100) {
                        this.mline_range = r100;
                        return this;
                    }
                }

                public static final class ProtoAdapter_LineMsg extends ProtoAdapter<LineMsg> {
                    public ProtoAdapter_LineMsg() {
                        super(FieldEncoding.LENGTH_DELIMITED, LineMsg.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public LineMsg decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        r101.mline_id = 0;
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L12;
                        if (r103 != 1) goto L8;
                        r101.mline_id = ProtoAdapter.INT32.decode(r100);
                        goto L3
                    L8:
                        if (r103 != 2) goto L9;
                        r101.mline_range = Range.ADAPTER.decode(r100);
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
                    public int encodedSize2(LineMsg r100) {
                        return (ProtoAdapter.INT32.encodedSizeWithTag(1, r100.mline_id) + Range.ADAPTER.encodedSizeWithTag(2, r100.mline_range)) + r100.unknownFields().size();
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ LineMsg decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(LineMsg r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, LineMsg r101) throws IOException {
                        ProtoAdapter.INT32.encodeWithTag(r100, 1, r101.mline_id);
                        Range.ADAPTER.encodeWithTag(r100, 2, r101.mline_range);
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LineMsg r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_LineMsg();
                    DEFAULT_LINE_ID = 0;
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.mline_id = this.mline_id;
                    r100.mline_range = this.mline_range;
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return LineMsg.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                    return newBuilder();
                }

                public LineMsg(Integer r100, Range r101) {
                    this(r100, r101, ByteString.EMPTY);
                }

                public LineMsg(Integer r100, Range r101, ByteString r102) {
                    super(ADAPTER, r102);
                    this.mline_id = r100;
                    this.mline_range = r101;
                }
            }

            public static final class ProtoAdapter_Entity extends ProtoAdapter<Entity> {
                private final ProtoAdapter<Map<String, String>> mentity_ext;

                public ProtoAdapter_Entity() {
                    super(FieldEncoding.LENGTH_DELIMITED, Entity.class);
                    ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                    this.mentity_ext = ProtoAdapter.newMapAdapter(r100, r100);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Entity decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.mtext = "";
                    r101.mregion_id = 0;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L21;
                    if (r103 != 1) goto L8;
                    r101.mtext = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.mregion_id = ProtoAdapter.INT32.decode(r100);
                    goto L3
                L10:
                    if (r103 != 3) goto L12;
                    r101.mregion_range = Range.ADAPTER.decode(r100);
                    goto L3
                L12:
                    if (r103 != 4) goto L14;
                    r101.mline_msgs.add(LineMsg.ADAPTER.decode(r100));
                    goto L3
                L14:
                    if (r103 != 5) goto L15;
                    r101.mentity_ext.putAll(this.mentity_ext.decode(r100));
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
                public int encodedSize2(Entity r100) {
                    return ((((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mtext) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.mregion_id)) + Range.ADAPTER.encodedSizeWithTag(3, r100.mregion_range)) + LineMsg.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mline_msgs)) + this.mentity_ext.encodedSizeWithTag(5, r100.mentity_ext)) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Entity decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Entity r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Entity r101) throws IOException {
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mtext);
                    ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.mregion_id);
                    Range.ADAPTER.encodeWithTag(r100, 3, r101.mregion_range);
                    LineMsg.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mline_msgs);
                    this.mentity_ext.encodeWithTag(r100, 5, r101.mentity_ext);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Entity r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            public static final class Range extends Message<Range, Builder> {
                public static final ProtoAdapter<Range> ADAPTER = null;
                public static final Integer DEFAULT_END = null;
                public static final Integer DEFAULT_START = null;
                private static final long serialVersionUID = 0;
                public final Integer mend;
                public final Integer mstart;

                public static final class Builder extends Message.Builder<Range, Builder> {
                    public Integer mend;
                    public Integer mstart;

                    @Override // com.squareup.wire.Message.Builder
                    public Range build() {
                        Integer r100 = this.mstart;
                        if (r100 == null) goto L9;
                        if (this.mend == null) goto L9;
                        return new Range(this.mstart, this.mend, super.buildUnknownFields());
                    L9:
                        throw Internal.missingRequiredFields(new Object[]{r100, "mstart", this.mend, "mend"});
                    }

                    public Builder() {
                    }

                    @Override // com.squareup.wire.Message.Builder
                    public /* bridge */ /* synthetic */ Message build() {
                        return build();
                    }

                    public Builder end(Integer r100) {
                        this.mend = r100;
                        return this;
                    }

                    public Builder start(Integer r100) {
                        this.mstart = r100;
                        return this;
                    }
                }

                public static final class ProtoAdapter_Range extends ProtoAdapter<Range> {
                    public ProtoAdapter_Range() {
                        super(FieldEncoding.LENGTH_DELIMITED, Range.class);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.squareup.wire.ProtoAdapter
                    public Range decode(ProtoReader r100) throws IOException {
                        Builder r101 = new Builder();
                        r101.mstart = 0;
                        r101.mend = 0;
                        long r102 = r100.beginMessage();
                    L3:
                        int r103 = r100.nextTag();
                        if (r103 == (-1)) goto L12;
                        if (r103 != 1) goto L8;
                        r101.mstart = ProtoAdapter.UINT32.decode(r100);
                        goto L3
                    L8:
                        if (r103 != 2) goto L9;
                        r101.mend = ProtoAdapter.UINT32.decode(r100);
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
                    public int encodedSize2(Range r100) {
                        ProtoAdapter<Integer> r101 = ProtoAdapter.UINT32;
                        return (r101.encodedSizeWithTag(1, r100.mstart) + r101.encodedSizeWithTag(2, r100.mend)) + r100.unknownFields().size();
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ Range decode(ProtoReader r100) throws IOException {
                        return decode(r100);
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ int encodedSize(Range r100) {
                        return encodedSize2(r100);
                    }

                    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                    public void encode2(ProtoWriter r100, Range r101) throws IOException {
                        ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
                        r102.encodeWithTag(r100, 1, r101.mstart);
                        r102.encodeWithTag(r100, 2, r101.mend);
                        r100.writeBytes(r101.unknownFields());
                    }

                    @Override // com.squareup.wire.ProtoAdapter
                    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Range r101) throws IOException {
                        encode2(r100, r101);
                    }
                }

                static {
                    ADAPTER = new ProtoAdapter_Range();
                    DEFAULT_START = 0;
                    DEFAULT_END = 0;
                }

                @Override // com.squareup.wire.Message
                public Builder newBuilder() {
                    Builder r100 = new Builder();
                    r100.mstart = this.mstart;
                    r100.mend = this.mend;
                    r100.addUnknownFields(unknownFields());
                    return r100;
                }

                @Override // com.squareup.wire.Message
                public String toString() {
                    return Range.class.getName() + "@" + Integer.toHexString(hashCode());
                }

                @Override // com.squareup.wire.Message
                public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                    return newBuilder();
                }

                public Range(Integer r100, Integer r101) {
                    this(r100, r101, ByteString.EMPTY);
                }

                public Range(Integer r100, Integer r101, ByteString r102) {
                    super(ADAPTER, r102);
                    this.mstart = r100;
                    this.mend = r101;
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Entity();
                DEFAULT_REGION_ID = 0;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.mtext = this.mtext;
                r100.mregion_id = this.mregion_id;
                r100.mregion_range = this.mregion_range;
                r100.mline_msgs = Internal.copyOf("mline_msgs", this.mline_msgs);
                r100.mentity_ext = Internal.copyOf("mentity_ext", this.mentity_ext);
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Entity.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public Entity(String r100, Integer r101, Range r110, List<LineMsg> r111, Map<String, String> r112) {
                this(r100, r101, r110, r111, r112, ByteString.EMPTY);
            }

            public Entity(String r100, Integer r101, Range r102, List<LineMsg> r103, Map<String, String> r104, ByteString r105) {
                super(ADAPTER, r105);
                this.mtext = r100;
                this.mregion_id = r101;
                this.mregion_range = r102;
                this.mline_msgs = Internal.immutableCopyOf("mline_msgs", r103);
                this.mentity_ext = Internal.immutableCopyOf("mentity_ext", r104);
            }
        }

        public static final class ProtoAdapter_Entities extends ProtoAdapter<Entities> {
            public ProtoAdapter_Entities() {
                super(FieldEncoding.LENGTH_DELIMITED, Entities.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Entities decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mlist.add(Entity.ADAPTER.decode(r100));
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
            public int encodedSize2(Entities r100) {
                return Entity.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mlist) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Entities decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Entities r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Entities r101) throws IOException {
                Entity.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mlist);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Entities r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Entities();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mlist = Internal.copyOf("mlist", this.mlist);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Entities.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Entities(List<Entity> r100) {
            this(r100, ByteString.EMPTY);
        }

        public Entities(List<Entity> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mlist = Internal.immutableCopyOf("mlist", r100);
        }
    }

    public static final enum EntityType extends Enum<EntityType> implements WireEnum {
        private static final /* synthetic */ EntityType[] $VALUES = null;
        public static final ProtoAdapter<EntityType> ADAPTER = null;
        public static final EntityType PHONE = null;
        public static final EntityType UNKNOWN = null;
        public static final EntityType URL = null;
        private final int value;

        static {
            EntityType r100 = new EntityType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            EntityType r101 = new EntityType("PHONE", 1, 1);
            PHONE = r101;
            EntityType r102 = new EntityType("URL", 2, 2);
            URL = r102;
            $VALUES = new EntityType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
        }

        public static EntityType[] values() {
            return (EntityType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static EntityType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return URL;
        L12:
            return PHONE;
        L14:
            return UNKNOWN;
        }

        public static EntityType valueOf(String r100) {
            return (EntityType) a.a(EntityType.class, r100);
        }

        private EntityType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Line extends Message<Line, Builder> {
        public static final ProtoAdapter<Line> ADAPTER = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final Rect mrect;
        public final String mtext;

        public static final class Builder extends Message.Builder<Line, Builder> {
            public Rect mrect;
            public String mtext;

            @Override // com.squareup.wire.Message.Builder
            public Line build() {
                Rect r100 = this.mrect;
                if (r100 == null) goto L9;
                if (this.mtext == null) goto L9;
                return new Line(this.mrect, this.mtext, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "mrect", this.mtext, "mtext"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder rect(Rect r100) {
                this.mrect = r100;
                return this;
            }

            public Builder text(String r100) {
                this.mtext = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Line extends ProtoAdapter<Line> {
            public ProtoAdapter_Line() {
                super(FieldEncoding.LENGTH_DELIMITED, Line.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Line decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mtext = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mrect = Rect.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mtext = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Line r100) {
                return (Rect.ADAPTER.encodedSizeWithTag(1, r100.mrect) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.mtext)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Line decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Line r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Line r101) throws IOException {
                Rect.ADAPTER.encodeWithTag(r100, 1, r101.mrect);
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.mtext);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Line r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Line();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mrect = this.mrect;
            r100.mtext = this.mtext;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Line.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Line(Rect r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Line(Rect r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mrect = r100;
            this.mtext = r101;
        }
    }

    public static final class ProtoAdapter_ImageOCRResponse extends ProtoAdapter<ImageOCRResponse> {
        private final ProtoAdapter<Map<Integer, Entities>> mtype_to_entities;

        public ProtoAdapter_ImageOCRResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ImageOCRResponse.class);
            this.mtype_to_entities = ProtoAdapter.newMapAdapter(ProtoAdapter.UINT32, Entities.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ImageOCRResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mwidth = 0;
            r101.mheight = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mlines.add(Line.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mregions.add(Region.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mtype_to_entities.putAll(this.mtype_to_entities.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mwidth = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mheight = ProtoAdapter.UINT32.decode(r100);
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
        public int encodedSize2(ImageOCRResponse r100) {
            int r101 = (Line.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mlines) + Region.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mregions)) + this.mtype_to_entities.encodedSizeWithTag(3, r100.mtype_to_entities);
            ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
            return ((r101 + r102.encodedSizeWithTag(4, r100.mwidth)) + r102.encodedSizeWithTag(5, r100.mheight)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ImageOCRResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ImageOCRResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ImageOCRResponse r101) throws IOException {
            Line.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mlines);
            Region.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mregions);
            this.mtype_to_entities.encodeWithTag(r100, 3, r101.mtype_to_entities);
            ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
            r102.encodeWithTag(r100, 4, r101.mwidth);
            r102.encodeWithTag(r100, 5, r101.mheight);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ImageOCRResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Rect extends Message<Rect, Builder> {
        public static final ProtoAdapter<Rect> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Point> mpoints;

        public static final class Builder extends Message.Builder<Rect, Builder> {
            public List<Point> mpoints;

            @Override // com.squareup.wire.Message.Builder
            public Rect build() {
                return new Rect(this.mpoints, super.buildUnknownFields());
            }

            public Builder() {
                this.mpoints = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder points(List<Point> r100) {
                Internal.checkElementsNotNull(r100);
                this.mpoints = r100;
                return this;
            }
        }

        public static final class Point extends Message<Point, Builder> {
            public static final ProtoAdapter<Point> ADAPTER = null;
            public static final Integer DEFAULT_X = null;
            public static final Integer DEFAULT_Y = null;
            private static final long serialVersionUID = 0;

            /* JADX INFO: renamed from: mx, reason: collision with root package name */
            public final Integer f438538mx;

            /* JADX INFO: renamed from: my, reason: collision with root package name */
            public final Integer f438539my;

            public static final class Builder extends Message.Builder<Point, Builder> {

                /* JADX INFO: renamed from: mx, reason: collision with root package name */
                public Integer f438540mx;

                /* JADX INFO: renamed from: my, reason: collision with root package name */
                public Integer f438541my;

                @Override // com.squareup.wire.Message.Builder
                public Point build() {
                    Integer r100 = this.f438540mx;
                    if (r100 == null) goto L9;
                    if (this.f438541my == null) goto L9;
                    return new Point(this.f438540mx, this.f438541my, super.buildUnknownFields());
                L9:
                    throw Internal.missingRequiredFields(new Object[]{r100, "mx", this.f438541my, "my"});
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder x(Integer r100) {
                    this.f438540mx = r100;
                    return this;
                }

                public Builder y(Integer r100) {
                    this.f438541my = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Point extends ProtoAdapter<Point> {
                public ProtoAdapter_Point() {
                    super(FieldEncoding.LENGTH_DELIMITED, Point.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Point decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.f438540mx = 0;
                    r101.f438541my = 0;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.f438540mx = ProtoAdapter.UINT32.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.f438541my = ProtoAdapter.UINT32.decode(r100);
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
                public int encodedSize2(Point r100) {
                    ProtoAdapter<Integer> r101 = ProtoAdapter.UINT32;
                    return (r101.encodedSizeWithTag(1, r100.f438538mx) + r101.encodedSizeWithTag(2, r100.f438539my)) + r100.unknownFields().size();
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Point decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Point r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Point r101) throws IOException {
                    ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
                    r102.encodeWithTag(r100, 1, r101.f438538mx);
                    r102.encodeWithTag(r100, 2, r101.f438539my);
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Point r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Point();
                DEFAULT_X = 0;
                DEFAULT_Y = 0;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.f438540mx = this.f438538mx;
                r100.f438541my = this.f438539my;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Point.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public Point(Integer r100, Integer r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public Point(Integer r100, Integer r101, ByteString r102) {
                super(ADAPTER, r102);
                this.f438538mx = r100;
                this.f438539my = r101;
            }
        }

        public static final class ProtoAdapter_Rect extends ProtoAdapter<Rect> {
            public ProtoAdapter_Rect() {
                super(FieldEncoding.LENGTH_DELIMITED, Rect.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Rect decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mpoints.add(Point.ADAPTER.decode(r100));
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
            public int encodedSize2(Rect r100) {
                return Point.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mpoints) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Rect decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Rect r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Rect r101) throws IOException {
                Point.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mpoints);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Rect r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Rect();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mpoints = Internal.copyOf("mpoints", this.mpoints);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Rect.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Rect(List<Point> r100) {
            this(r100, ByteString.EMPTY);
        }

        public Rect(List<Point> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mpoints = Internal.immutableCopyOf("mpoints", r100);
        }
    }

    public static final class Region extends Message<Region, Builder> {
        public static final ProtoAdapter<Region> ADAPTER = null;
        public static final String DEFAULT_TEXT = "";
        private static final long serialVersionUID = 0;
        public final List<Integer> mline_ids;
        public final String mtext;

        public static final class Builder extends Message.Builder<Region, Builder> {
            public List<Integer> mline_ids;
            public String mtext;

            @Override // com.squareup.wire.Message.Builder
            public Region build() {
                String r100 = this.mtext;
                if (r100 == null) goto L7;
                return new Region(this.mtext, this.mline_ids, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "mtext"});
            }

            public Builder() {
                this.mline_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder line_ids(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.mline_ids = r100;
                return this;
            }

            public Builder text(String r100) {
                this.mtext = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Region extends ProtoAdapter<Region> {
            public ProtoAdapter_Region() {
                super(FieldEncoding.LENGTH_DELIMITED, Region.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Region decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mtext = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mtext = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mline_ids.add(ProtoAdapter.UINT32.decode(r100));
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
            public int encodedSize2(Region r100) {
                return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mtext) + ProtoAdapter.UINT32.asRepeated().encodedSizeWithTag(2, r100.mline_ids)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Region decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Region r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Region r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mtext);
                ProtoAdapter.UINT32.asRepeated().encodeWithTag(r100, 2, r101.mline_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Region r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Region();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtext = this.mtext;
            r100.mline_ids = Internal.copyOf("mline_ids", this.mline_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Region.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Region(String r100, List<Integer> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Region(String r100, List<Integer> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mtext = r100;
            this.mline_ids = Internal.immutableCopyOf("mline_ids", r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ImageOCRResponse();
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlines = Internal.copyOf("mlines", this.mlines);
        r100.mregions = Internal.copyOf("mregions", this.mregions);
        r100.mtype_to_entities = Internal.copyOf("mtype_to_entities", this.mtype_to_entities);
        r100.mwidth = this.mwidth;
        r100.mheight = this.mheight;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ImageOCRResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ImageOCRResponse(List<Line> r100, List<Region> r101, Map<Integer, Entities> r110, Integer r111, Integer r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ImageOCRResponse(List<Line> r100, List<Region> r101, Map<Integer, Entities> r102, Integer r103, Integer r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mlines = Internal.immutableCopyOf("mlines", r100);
        this.mregions = Internal.immutableCopyOf("mregions", r101);
        this.mtype_to_entities = Internal.immutableCopyOf("mtype_to_entities", r102);
        this.mwidth = r103;
        this.mheight = r104;
    }
}
