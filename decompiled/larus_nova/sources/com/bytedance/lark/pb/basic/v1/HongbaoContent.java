package com.bytedance.lark.pb.basic.v1;

import com.bytedance.android.ec.core.event.a;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class HongbaoContent extends com.squareup.wire.Message<HongbaoContent, Builder> {
    public static final ProtoAdapter<HongbaoContent> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_GRAB = null;
    public static final Boolean DEFAULT_CLICKED = null;
    public static final Boolean DEFAULT_GRABBED = null;
    public static final Boolean DEFAULT_GRABBED_FINISH = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_EXPIRED = null;
    public static final String DEFAULT_SUBJECT = "";
    public static final Integer DEFAULT_TOTAL_NUM = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Boolean can_grab;
    public final Boolean clicked;
    public final HongbaoCover cover;
    public final Boolean grabbed;
    public final Boolean grabbed_finish;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253503id;
    public final Boolean is_expired;
    public final List<Long> preview_user_ids;
    public final String subject;
    public final Integer total_num;
    public final Type type;

    public static final class Builder extends com.squareup.wire.Message.Builder<HongbaoContent, Builder> {
        public Boolean can_grab;
        public Boolean clicked;
        public HongbaoCover cover;
        public Boolean grabbed;
        public Boolean grabbed_finish;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253504id;
        public Boolean is_expired;
        public List<Long> preview_user_ids;
        public String subject;
        public Integer total_num;
        public Type type;

        @Override // com.squareup.wire.Message.Builder
        public HongbaoContent build() {
            String r100 = this.f253504id;
            if (r100 == null) goto L11;
            if (this.subject == null) goto L11;
            if (this.type == null) goto L11;
            return new HongbaoContent(this.f253504id, this.subject, this.type, this.clicked, this.is_expired, this.grabbed, this.grabbed_finish, this.cover, this.can_grab, this.preview_user_ids, this.total_num, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.subject, a.KEY_SUBJECT, this.type, "type"});
        }

        public Builder() {
            this.preview_user_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder can_grab(Boolean r100) {
            this.can_grab = r100;
            return this;
        }

        public Builder clicked(Boolean r100) {
            this.clicked = r100;
            return this;
        }

        public Builder cover(HongbaoCover r100) {
            this.cover = r100;
            return this;
        }

        public Builder grabbed(Boolean r100) {
            this.grabbed = r100;
            return this;
        }

        public Builder grabbed_finish(Boolean r100) {
            this.grabbed_finish = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253504id = r100;
            return this;
        }

        public Builder is_expired(Boolean r100) {
            this.is_expired = r100;
            return this;
        }

        public Builder preview_user_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.preview_user_ids = r100;
            return this;
        }

        public Builder subject(String r100) {
            this.subject = r100;
            return this;
        }

        public Builder total_num(Integer r100) {
            this.total_num = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HongbaoContent extends ProtoAdapter<HongbaoContent> {
        public ProtoAdapter_HongbaoContent() {
            super(FieldEncoding.LENGTH_DELIMITED, HongbaoContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HongbaoContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253504id = "";
            r101.subject = "";
            r101.type = Type.UNKNOWN;
            Boolean r102 = Boolean.FALSE;
            r101.clicked = r102;
            r101.is_expired = r102;
            r101.grabbed = r102;
            r101.grabbed_finish = r102;
            r101.can_grab = Boolean.TRUE;
            r101.total_num = 0;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            switch(r104) {
                case 1: goto L20;
                case 2: goto L19;
                case 3: goto L23;
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
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.total_num = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.preview_user_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L9:
            r101.can_grab = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.cover = HongbaoCover.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.grabbed_finish = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.grabbed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.is_expired = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.clicked = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L19:
            r101.subject = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.f253504id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(HongbaoContent r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.f253503id) + r101.encodedSizeWithTag(2, r100.subject)) + Type.ADAPTER.encodedSizeWithTag(3, r100.type);
            Boolean r103 = r100.clicked;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_expired;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.grabbed;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r110);
        L14:
            int r112 = r109 + r111;
            Boolean r113 = r100.grabbed_finish;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r113);
        L18:
            int r115 = r112 + r114;
            HongbaoCover r116 = r100.cover;
            if (r116 == null) goto L21;
            int r117 = HongbaoCover.ADAPTER.encodedSizeWithTag(8, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.can_grab;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r119);
        L26:
            int r121 = (r118 + r120) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(10, r100.preview_user_ids);
            Integer r122 = r100.total_num;
            if (r122 == null) goto L30;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(11, r122);
        L30:
            return (r121 + r104) + r100.unknownFields().size();
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HongbaoContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HongbaoContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HongbaoContent r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253503id);
            r102.encodeWithTag(r100, 2, r101.subject);
            Type.ADAPTER.encodeWithTag(r100, 3, r101.type);
            Boolean r103 = r101.clicked;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L5:
            Boolean r104 = r101.is_expired;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
        L8:
            Boolean r105 = r101.grabbed;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r105);
        L11:
            Boolean r106 = r101.grabbed_finish;
            if (r106 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r106);
        L14:
            HongbaoCover r107 = r101.cover;
            if (r107 == null) goto L17;
            HongbaoCover.ADAPTER.encodeWithTag(r100, 8, r107);
        L17:
            Boolean r108 = r101.can_grab;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r108);
        L20:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 10, r101.preview_user_ids);
            Integer r109 = r101.total_num;
            if (r109 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 11, r109);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HongbaoContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type B2C_FIX = null;
        public static final Type B2C_RANDOM = null;
        public static final Type COMMERCIAL = null;
        public static final Type EXCLUSIVE = null;
        public static final Type GROUP_FIX = null;
        public static final Type GROUP_RANDOM = null;
        public static final Type P2P = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("P2P", 1, 1);
            P2P = r101;
            Type r102 = new Type("GROUP_FIX", 2, 2);
            GROUP_FIX = r102;
            Type r103 = new Type("GROUP_RANDOM", 3, 3);
            GROUP_RANDOM = r103;
            Type r104 = new Type("COMMERCIAL", 4, 4);
            COMMERCIAL = r104;
            Type r105 = new Type("EXCLUSIVE", 5, 5);
            EXCLUSIVE = r105;
            Type r110 = new Type("B2C_FIX", 6, 6);
            B2C_FIX = r110;
            Type r111 = new Type("B2C_RANDOM", 7, 7);
            B2C_RANDOM = r111;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
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
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return B2C_RANDOM;
        L8:
            return B2C_FIX;
        L10:
            return EXCLUSIVE;
        L12:
            return COMMERCIAL;
        L14:
            return GROUP_RANDOM;
        L16:
            return GROUP_FIX;
        L18:
            return P2P;
        L20:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HongbaoContent();
        DEFAULT_TYPE = Type.UNKNOWN;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_CLICKED = r100;
        DEFAULT_IS_EXPIRED = r100;
        DEFAULT_GRABBED = r100;
        DEFAULT_GRABBED_FINISH = r100;
        DEFAULT_CAN_GRAB = Boolean.TRUE;
        DEFAULT_TOTAL_NUM = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253504id = this.f253503id;
        r100.subject = this.subject;
        r100.type = this.type;
        r100.clicked = this.clicked;
        r100.is_expired = this.is_expired;
        r100.grabbed = this.grabbed;
        r100.grabbed_finish = this.grabbed_finish;
        r100.cover = this.cover;
        r100.can_grab = this.can_grab;
        r100.preview_user_ids = Internal.copyOf("preview_user_ids", this.preview_user_ids);
        r100.total_num = this.total_num;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HongbaoContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public HongbaoContent(String r110, String r111, Type r112, Boolean r113, Boolean r114, Boolean r115, Boolean r210, HongbaoCover r211, Boolean r212, List<Long> r213, Integer r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public HongbaoContent(String r100, String r101, Type r102, Boolean r103, Boolean r104, Boolean r105, Boolean r106, HongbaoCover r107, Boolean r110, List<Long> r111, Integer r112, ByteString r113) {
        super(ADAPTER, r113);
        this.f253503id = r100;
        this.subject = r101;
        this.type = r102;
        this.clicked = r103;
        this.is_expired = r104;
        this.grabbed = r105;
        this.grabbed_finish = r106;
        this.cover = r107;
        this.can_grab = r110;
        this.preview_user_ids = Internal.immutableCopyOf("preview_user_ids", r111);
        this.total_num = r112;
    }
}
