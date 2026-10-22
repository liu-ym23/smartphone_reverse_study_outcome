package com.ss.android.lark.pb.videochat_my_ai;

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

/* JADX INFO: loaded from: classes37.dex */
public final class AILayoutFishBoneItem extends Message<AILayoutFishBoneItem, Builder> {
    public static final ProtoAdapter<AILayoutFishBoneItem> ADAPTER = null;
    public static final Long DEFAULT_BEGIN_TIME_MS = null;
    public static final Long DEFAULT_END_TIME_MS = null;
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final Long mbegin_time_ms;
    public final Chart mchart;
    public final List<AILayoutFishBoneItem> mchildren;
    public final Long mend_time_ms;
    public final String mid;
    public final ItemType mitem_type;
    public final Text mtext;

    public static final class Builder extends Message.Builder<AILayoutFishBoneItem, Builder> {
        public Long mbegin_time_ms;
        public Chart mchart;
        public List<AILayoutFishBoneItem> mchildren;
        public Long mend_time_ms;
        public String mid;
        public ItemType mitem_type;
        public Text mtext;

        @Override // com.squareup.wire.Message.Builder
        public AILayoutFishBoneItem build() {
            return new AILayoutFishBoneItem(this.mitem_type, this.mchildren, this.mbegin_time_ms, this.mend_time_ms, this.mtext, this.mchart, this.mid, super.buildUnknownFields());
        }

        public Builder() {
            this.mchildren = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder begin_time_ms(Long r100) {
            this.mbegin_time_ms = r100;
            return this;
        }

        public Builder chart(Chart r100) {
            this.mchart = r100;
            return this;
        }

        public Builder children(List<AILayoutFishBoneItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchildren = r100;
            return this;
        }

        public Builder end_time_ms(Long r100) {
            this.mend_time_ms = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder item_type(ItemType r100) {
            this.mitem_type = r100;
            return this;
        }

        public Builder text(Text r100) {
            this.mtext = r100;
            return this;
        }
    }

    public static final class Chart extends Message<Chart, Builder> {
        public static final ProtoAdapter<Chart> ADAPTER = null;
        public static final String DEFAULT_DATA = "";
        public static final String DEFAULT_DESCRIPTION = "";
        public static final Long DEFAULT_ID = null;
        public static final String DEFAULT_LANG = "";
        public static final String DEFAULT_TYPE = "";
        private static final long serialVersionUID = 0;
        public final String mdata;
        public final String mdescription;
        public final Long mid;
        public final String mlang;
        public final List<Long> msentence_ids;
        public final String mtype;

        public static final class Builder extends Message.Builder<Chart, Builder> {
            public String mdata;
            public String mdescription;
            public Long mid;
            public String mlang;
            public List<Long> msentence_ids;
            public String mtype;

            @Override // com.squareup.wire.Message.Builder
            public Chart build() {
                return new Chart(this.mtype, this.mdescription, this.mdata, this.msentence_ids, this.mid, this.mlang, super.buildUnknownFields());
            }

            public Builder() {
                this.msentence_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder data(String r100) {
                this.mdata = r100;
                return this;
            }

            public Builder description(String r100) {
                this.mdescription = r100;
                return this;
            }

            public Builder id(Long r100) {
                this.mid = r100;
                return this;
            }

            public Builder lang(String r100) {
                this.mlang = r100;
                return this;
            }

            public Builder sentence_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.msentence_ids = r100;
                return this;
            }

            public Builder type(String r100) {
                this.mtype = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Chart extends ProtoAdapter<Chart> {
            public ProtoAdapter_Chart() {
                super(FieldEncoding.LENGTH_DELIMITED, Chart.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Chart decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mtype = "";
                r101.mdescription = "";
                r101.mdata = "";
                r101.mid = 0L;
                r101.mlang = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L13;
                switch(r103) {
                    case 1: goto L12;
                    case 2: goto L11;
                    case 3: goto L10;
                    case 4: goto L9;
                    case 5: goto L8;
                    case 6: goto L7;
                    default: goto L6;
                };
            L7:
                r101.mlang = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                r101.mid = ProtoAdapter.INT64.decode(r100);
                goto L3
            L9:
                r101.msentence_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L10:
                r101.mdata = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.mdescription = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                r101.mtype = ProtoAdapter.STRING.decode(r100);
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L13:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Chart r100) {
                String r101 = r100.mtype;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mdescription;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mdata;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                ProtoAdapter<Long> r110 = ProtoAdapter.INT64;
                int r111 = r109 + r110.asRepeated().encodedSizeWithTag(4, r100.msentence_ids);
                Long r112 = r100.mid;
                if (r112 == null) goto L17;
                int r113 = r110.encodedSizeWithTag(5, r112);
            L18:
                int r114 = r111 + r113;
                String r115 = r100.mlang;
                if (r115 == null) goto L22;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r115);
            L22:
                return (r114 + r102) + r100.unknownFields().size();
            L17:
                r113 = 0;
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
            public /* bridge */ /* synthetic */ Chart decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Chart r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Chart r101) throws IOException {
                String r102 = r101.mtype;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mdescription;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mdata;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                ProtoAdapter<Long> r105 = ProtoAdapter.INT64;
                r105.asRepeated().encodeWithTag(r100, 4, r101.msentence_ids);
                Long r106 = r101.mid;
                if (r106 == null) goto L14;
                r105.encodeWithTag(r100, 5, r106);
            L14:
                String r107 = r101.mlang;
                if (r107 == null) goto L17;
                ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
            L17:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Chart r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Chart();
            DEFAULT_ID = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtype = this.mtype;
            r100.mdescription = this.mdescription;
            r100.mdata = this.mdata;
            r100.msentence_ids = Internal.copyOf("msentence_ids", this.msentence_ids);
            r100.mid = this.mid;
            r100.mlang = this.mlang;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Chart.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Chart(String r100, String r110, String r111, List<Long> r112, Long r113, String r114) {
            this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
        }

        public Chart(String r100, String r101, String r102, List<Long> r103, Long r104, String r105, ByteString r106) {
            super(ADAPTER, r106);
            this.mtype = r100;
            this.mdescription = r101;
            this.mdata = r102;
            this.msentence_ids = Internal.immutableCopyOf("msentence_ids", r103);
            this.mid = r104;
            this.mlang = r105;
        }
    }

    public static final enum ItemType extends Enum<ItemType> implements WireEnum {
        private static final /* synthetic */ ItemType[] $VALUES = null;
        public static final ProtoAdapter<ItemType> ADAPTER = null;
        public static final ItemType TYPE_IMAGE = null;
        public static final ItemType TYPE_TEXT = null;
        public static final ItemType TYPE_UNKNOWN = null;
        private final int value;

        static {
            ItemType r100 = new ItemType("TYPE_UNKNOWN", 0, 0);
            TYPE_UNKNOWN = r100;
            ItemType r101 = new ItemType("TYPE_TEXT", 1, 1);
            TYPE_TEXT = r101;
            ItemType r102 = new ItemType("TYPE_IMAGE", 2, 2);
            TYPE_IMAGE = r102;
            $VALUES = new ItemType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ItemType.class);
        }

        public static ItemType[] values() {
            return (ItemType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ItemType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return TYPE_IMAGE;
        L12:
            return TYPE_TEXT;
        L14:
            return TYPE_UNKNOWN;
        }

        public static ItemType valueOf(String r100) {
            return (ItemType) a.a(ItemType.class, r100);
        }

        private ItemType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_AILayoutFishBoneItem extends ProtoAdapter<AILayoutFishBoneItem> {
        public ProtoAdapter_AILayoutFishBoneItem() {
            super(FieldEncoding.LENGTH_DELIMITED, AILayoutFishBoneItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AILayoutFishBoneItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mbegin_time_ms = 0L;
            r101.mend_time_ms = 0L;
            r101.mid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L25;
            if (r103 != 1) goto L8;
            r101.mitem_type = ItemType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mchildren.add(AILayoutFishBoneItem.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mbegin_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mend_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            switch(r103) {
                case 11: goto L17;
                case 12: goto L16;
                case 13: goto L15;
                default: goto L14;
            };
        L15:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mchart = Chart.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.mtext = Text.ADAPTER.decode(r100);
            goto L3
        L14:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L25:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AILayoutFishBoneItem r100) {
            ItemType r101 = r100.mitem_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ItemType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + AILayoutFishBoneItem.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mchildren);
            Long r105 = r100.mbegin_time_ms;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.INT64.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Long r108 = r100.mend_time_ms;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.INT64.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            Text r111 = r100.mtext;
            if (r111 == null) goto L17;
            int r112 = Text.ADAPTER.encodedSizeWithTag(11, r111);
        L18:
            int r113 = r110 + r112;
            Chart r114 = r100.mchart;
            if (r114 == null) goto L21;
            int r115 = Chart.ADAPTER.encodedSizeWithTag(12, r114);
        L22:
            int r116 = r113 + r115;
            String r117 = r100.mid;
            if (r117 == null) goto L26;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(13, r117);
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
        public /* bridge */ /* synthetic */ AILayoutFishBoneItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AILayoutFishBoneItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AILayoutFishBoneItem r101) throws IOException {
            ItemType r102 = r101.mitem_type;
            if (r102 == null) goto L5;
            ItemType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            AILayoutFishBoneItem.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mchildren);
            Long r103 = r101.mbegin_time_ms;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L8:
            Long r104 = r101.mend_time_ms;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L11:
            Text r105 = r101.mtext;
            if (r105 == null) goto L14;
            Text.ADAPTER.encodeWithTag(r100, 11, r105);
        L14:
            Chart r106 = r101.mchart;
            if (r106 == null) goto L17;
            Chart.ADAPTER.encodeWithTag(r100, 12, r106);
        L17:
            String r107 = r101.mid;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 13, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AILayoutFishBoneItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Text extends Message<Text, Builder> {
        public static final ProtoAdapter<Text> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final List<Long> mchapter_ids;
        public final String mcontent;
        public final List<Long> msentence_ids;

        public static final class Builder extends Message.Builder<Text, Builder> {
            public List<Long> mchapter_ids;
            public String mcontent;
            public List<Long> msentence_ids;

            @Override // com.squareup.wire.Message.Builder
            public Text build() {
                return new Text(this.mcontent, this.msentence_ids, this.mchapter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.msentence_ids = Internal.newMutableList();
                this.mchapter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder chapter_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.mchapter_ids = r100;
                return this;
            }

            public Builder content(String r100) {
                this.mcontent = r100;
                return this;
            }

            public Builder sentence_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.msentence_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Text extends ProtoAdapter<Text> {
            public ProtoAdapter_Text() {
                super(FieldEncoding.LENGTH_DELIMITED, Text.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Text decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mcontent = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mcontent = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.msentence_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mchapter_ids.add(ProtoAdapter.INT64.decode(r100));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Text r100) {
                String r101 = r100.mcontent;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
                return ((r102 + r103.asRepeated().encodedSizeWithTag(2, r100.msentence_ids)) + r103.asRepeated().encodedSizeWithTag(3, r100.mchapter_ids)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Text decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Text r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Text r101) throws IOException {
                String r102 = r101.mcontent;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
                r103.asRepeated().encodeWithTag(r100, 2, r101.msentence_ids);
                r103.asRepeated().encodeWithTag(r100, 3, r101.mchapter_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Text r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Text();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mcontent = this.mcontent;
            r100.msentence_ids = Internal.copyOf("msentence_ids", this.msentence_ids);
            r100.mchapter_ids = Internal.copyOf("mchapter_ids", this.mchapter_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Text.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Text(String r100, List<Long> r101, List<Long> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Text(String r100, List<Long> r101, List<Long> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mcontent = r100;
            this.msentence_ids = Internal.immutableCopyOf("msentence_ids", r101);
            this.mchapter_ids = Internal.immutableCopyOf("mchapter_ids", r102);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AILayoutFishBoneItem();
        DEFAULT_BEGIN_TIME_MS = 0L;
        DEFAULT_END_TIME_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mitem_type = this.mitem_type;
        r100.mchildren = Internal.copyOf("mchildren", this.mchildren);
        r100.mbegin_time_ms = this.mbegin_time_ms;
        r100.mend_time_ms = this.mend_time_ms;
        r100.mtext = this.mtext;
        r100.mchart = this.mchart;
        r100.mid = this.mid;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AILayoutFishBoneItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AILayoutFishBoneItem(ItemType r110, List<AILayoutFishBoneItem> r111, Long r112, Long r113, Text r114, Chart r115, String r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public AILayoutFishBoneItem(ItemType r100, List<AILayoutFishBoneItem> r101, Long r102, Long r103, Text r104, Chart r105, String r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mitem_type = r100;
        this.mchildren = Internal.immutableCopyOf("mchildren", r101);
        this.mbegin_time_ms = r102;
        this.mend_time_ms = r103;
        this.mtext = r104;
        this.mchart = r105;
        this.mid = r106;
    }
}
