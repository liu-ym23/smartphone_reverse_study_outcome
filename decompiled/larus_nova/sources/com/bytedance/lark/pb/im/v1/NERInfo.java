package com.bytedance.lark.pb.im.v1;

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
public final class NERInfo extends Message<NERInfo, Builder> {
    public static final ProtoAdapter<NERInfo> ADAPTER = null;
    public static final Boolean DEFAULT_FORCE_HIGHLIGHT = null;
    public static final Integer DEFAULT_INDEX_BEGIN = null;
    public static final Integer DEFAULT_INDEX_END = null;
    public static final String DEFAULT_LARK_USER_ID = "";
    public static final Boolean DEFAULT_LARK_USER_IN_CHAT = null;
    public static final String DEFAULT_PINYIN = "";
    public static final String DEFAULT_SOURCE_CATEGORY = "";
    public static final Integer DEFAULT_SOURCE_INDEX = null;
    public static final String DEFAULT_TEXT = "";
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Boolean force_highlight;
    public final Integer index_begin;
    public final Integer index_end;
    public final String lark_user_id;
    public final Boolean lark_user_in_chat;
    public final List<String> lark_user_name;
    public final String pinyin;
    public final String source_category;
    public final Integer source_index;
    public final String text;
    public final Type type;

    public static final class Builder extends Message.Builder<NERInfo, Builder> {
        public Boolean force_highlight;
        public Integer index_begin;
        public Integer index_end;
        public String lark_user_id;
        public Boolean lark_user_in_chat;
        public List<String> lark_user_name;
        public String pinyin;
        public String source_category;
        public Integer source_index;
        public String text;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public NERInfo build() {
            return new NERInfo(this.type, this.index_begin, this.index_end, this.text, this.pinyin, this.source_category, this.source_index, this.lark_user_id, this.lark_user_name, this.lark_user_in_chat, this.force_highlight, super.buildUnknownFields());
        }

        public Builder() {
            this.lark_user_name = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder force_highlight(Boolean r100) {
            this.force_highlight = r100;
            return this;
        }

        public Builder index_begin(Integer r100) {
            this.index_begin = r100;
            return this;
        }

        public Builder index_end(Integer r100) {
            this.index_end = r100;
            return this;
        }

        public Builder lark_user_id(String r100) {
            this.lark_user_id = r100;
            return this;
        }

        public Builder lark_user_in_chat(Boolean r100) {
            this.lark_user_in_chat = r100;
            return this;
        }

        public Builder lark_user_name(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.lark_user_name = r100;
            return this;
        }

        public Builder pinyin(String r100) {
            this.pinyin = r100;
            return this;
        }

        public Builder source_category(String r100) {
            this.source_category = r100;
            return this;
        }

        public Builder source_index(Integer r100) {
            this.source_index = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_NERInfo extends ProtoAdapter<NERInfo> {
        public ProtoAdapter_NERInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, NERInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NERInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = Type.PER;
            r101.index_begin = 0;
            r101.index_end = 0;
            r101.text = "";
            r101.pinyin = "";
            r101.source_category = "";
            r101.source_index = 0;
            r101.lark_user_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.lark_user_in_chat = r102;
            r101.force_highlight = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            switch(r104) {
                case 1: goto L23;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L23:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.force_highlight = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.lark_user_in_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.lark_user_name.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.lark_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.source_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.source_category = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.pinyin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.index_end = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.index_begin = ProtoAdapter.INT32.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NERInfo r100) {
            Type r101 = r100.type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.index_begin;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.index_end;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.text;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.pinyin;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.source_category;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.source_index;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.lark_user_id;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            int r124 = (r121 + r123) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(9, r100.lark_user_name);
            Boolean r125 = r100.lark_user_in_chat;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.force_highlight;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r128);
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
        public /* bridge */ /* synthetic */ NERInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NERInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NERInfo r101) throws IOException {
            Type r102 = r101.type;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.index_begin;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.index_end;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.text;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.pinyin;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.source_category;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            Integer r108 = r101.source_index;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.lark_user_id;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 9, r101.lark_user_name);
            Boolean r110 = r101.lark_user_in_chat;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r110);
        L29:
            Boolean r111 = r101.force_highlight;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NERInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type PER = null;
        private final int value;

        static {
            Type r100 = new Type("PER", 0, 1);
            PER = r100;
            $VALUES = new Type[]{r100};
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
            if (r100 == 1) goto L7;
            return null;
        L7:
            return PER;
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
        ADAPTER = new ProtoAdapter_NERInfo();
        DEFAULT_TYPE = Type.PER;
        DEFAULT_INDEX_BEGIN = 0;
        DEFAULT_INDEX_END = 0;
        DEFAULT_SOURCE_INDEX = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_LARK_USER_IN_CHAT = r100;
        DEFAULT_FORCE_HIGHLIGHT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.index_begin = this.index_begin;
        r100.index_end = this.index_end;
        r100.text = this.text;
        r100.pinyin = this.pinyin;
        r100.source_category = this.source_category;
        r100.source_index = this.source_index;
        r100.lark_user_id = this.lark_user_id;
        r100.lark_user_name = Internal.copyOf("lark_user_name", this.lark_user_name);
        r100.lark_user_in_chat = this.lark_user_in_chat;
        r100.force_highlight = this.force_highlight;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NERInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NERInfo(Type r110, Integer r111, Integer r112, String r113, String r114, String r115, Integer r210, String r211, List<String> r212, Boolean r213, Boolean r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public NERInfo(Type r100, Integer r101, Integer r102, String r103, String r104, String r105, Integer r106, String r107, List<String> r110, Boolean r111, Boolean r112, ByteString r113) {
        super(ADAPTER, r113);
        this.type = r100;
        this.index_begin = r101;
        this.index_end = r102;
        this.text = r103;
        this.pinyin = r104;
        this.source_category = r105;
        this.source_index = r106;
        this.lark_user_id = r107;
        this.lark_user_name = Internal.immutableCopyOf("lark_user_name", r110);
        this.lark_user_in_chat = r111;
        this.force_highlight = r112;
    }
}
