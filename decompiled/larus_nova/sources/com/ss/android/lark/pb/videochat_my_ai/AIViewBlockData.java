package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class AIViewBlockData extends Message<AIViewBlockData, Builder> {
    public static final ProtoAdapter<AIViewBlockData> ADAPTER = null;
    public static final String DEFAULT_AI_VIEW_ID = "";
    public static final String DEFAULT_BLOCK_DATA = "";
    public static final Long DEFAULT_END_TIME = null;
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_LOCATION = "";
    public static final String DEFAULT_MINUTES_TOKEN = "";
    public static final Long DEFAULT_START_TIME = null;
    public static final String DEFAULT_TOPIC = "";
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final String mai_view_id;
    public final AIViewSource mai_view_source;
    public final String mblock_data;
    public final Long mend_time;
    public final String mlocale;
    public final String mlocation;
    public final String mminutes_token;
    public final Long mstart_time;
    public final String mtopic;
    public final Long muser_id;

    public static final enum AIViewSource extends Enum<AIViewSource> implements WireEnum {
        private static final /* synthetic */ AIViewSource[] $VALUES = null;
        public static final ProtoAdapter<AIViewSource> ADAPTER = null;
        public static final AIViewSource MEETING = null;
        public static final AIViewSource MINUTES = null;
        public static final AIViewSource UNKNOWN = null;
        private final int value;

        static {
            AIViewSource r100 = new AIViewSource("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AIViewSource r101 = new AIViewSource("MEETING", 1, 1);
            MEETING = r101;
            AIViewSource r102 = new AIViewSource("MINUTES", 2, 2);
            MINUTES = r102;
            $VALUES = new AIViewSource[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(AIViewSource.class);
        }

        public static AIViewSource[] values() {
            return (AIViewSource[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AIViewSource fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return MINUTES;
        L12:
            return MEETING;
        L14:
            return UNKNOWN;
        }

        public static AIViewSource valueOf(String r100) {
            return (AIViewSource) a.a(AIViewSource.class, r100);
        }

        private AIViewSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<AIViewBlockData, Builder> {
        public String mai_view_id;
        public AIViewSource mai_view_source;
        public String mblock_data;
        public Long mend_time;
        public String mlocale;
        public String mlocation;
        public String mminutes_token;
        public Long mstart_time;
        public String mtopic;
        public Long muser_id;

        @Override // com.squareup.wire.Message.Builder
        public AIViewBlockData build() {
            return new AIViewBlockData(this.mlocale, this.mtopic, this.muser_id, this.mstart_time, this.mend_time, this.mminutes_token, this.mai_view_id, this.mlocation, this.mai_view_source, this.mblock_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_view_id(String r100) {
            this.mai_view_id = r100;
            return this;
        }

        public Builder ai_view_source(AIViewSource r100) {
            this.mai_view_source = r100;
            return this;
        }

        public Builder block_data(String r100) {
            this.mblock_data = r100;
            return this;
        }

        public Builder end_time(Long r100) {
            this.mend_time = r100;
            return this;
        }

        public Builder locale(String r100) {
            this.mlocale = r100;
            return this;
        }

        public Builder location(String r100) {
            this.mlocation = r100;
            return this;
        }

        public Builder minutes_token(String r100) {
            this.mminutes_token = r100;
            return this;
        }

        public Builder start_time(Long r100) {
            this.mstart_time = r100;
            return this;
        }

        public Builder topic(String r100) {
            this.mtopic = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.muser_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AIViewBlockData extends ProtoAdapter<AIViewBlockData> {
        public ProtoAdapter_AIViewBlockData() {
            super(FieldEncoding.LENGTH_DELIMITED, AIViewBlockData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AIViewBlockData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mlocale = "";
            r101.mtopic = "";
            r101.muser_id = 0L;
            r101.mstart_time = 0L;
            r101.mend_time = 0L;
            r101.mminutes_token = "";
            r101.mai_view_id = "";
            r101.mlocation = "";
            r101.mblock_data = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L22;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r101.mai_view_source = AIViewSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mblock_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mlocation = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mai_view_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mminutes_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mend_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.mstart_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.muser_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L18:
            r101.mtopic = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.mlocale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AIViewBlockData r100) {
            String r101 = r100.mlocale;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtopic;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.muser_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.mstart_time;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Long r113 = r100.mend_time;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.INT64.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.mminutes_token;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.mai_view_id;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mlocation;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            AIViewSource r125 = r100.mai_view_source;
            if (r125 == null) goto L37;
            int r126 = AIViewSource.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            String r128 = r100.mblock_data;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(10, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ AIViewBlockData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AIViewBlockData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AIViewBlockData r101) throws IOException {
            String r102 = r101.mlocale;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtopic;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.muser_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.mstart_time;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            Long r106 = r101.mend_time;
            if (r106 == null) goto L17;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.mminutes_token;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            String r108 = r101.mai_view_id;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.mlocation;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            AIViewSource r110 = r101.mai_view_source;
            if (r110 == null) goto L29;
            AIViewSource.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            String r111 = r101.mblock_data;
            if (r111 == null) goto L32;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AIViewBlockData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AIViewBlockData();
        DEFAULT_USER_ID = 0L;
        DEFAULT_START_TIME = 0L;
        DEFAULT_END_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlocale = this.mlocale;
        r100.mtopic = this.mtopic;
        r100.muser_id = this.muser_id;
        r100.mstart_time = this.mstart_time;
        r100.mend_time = this.mend_time;
        r100.mminutes_token = this.mminutes_token;
        r100.mai_view_id = this.mai_view_id;
        r100.mlocation = this.mlocation;
        r100.mai_view_source = this.mai_view_source;
        r100.mblock_data = this.mblock_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AIViewBlockData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AIViewBlockData(String r110, String r111, Long r112, Long r113, Long r114, String r115, String r116, String r210, AIViewSource r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public AIViewBlockData(String r100, String r101, Long r102, Long r103, Long r104, String r105, String r106, String r107, AIViewSource r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mlocale = r100;
        this.mtopic = r101;
        this.muser_id = r102;
        this.mstart_time = r103;
        this.mend_time = r104;
        this.mminutes_token = r105;
        this.mai_view_id = r106;
        this.mlocation = r107;
        this.mai_view_source = r110;
        this.mblock_data = r111;
    }
}
