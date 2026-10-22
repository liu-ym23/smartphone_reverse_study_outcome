package com.ss.android.lark.pb.todo_entities;

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
public final class DatetimeFieldFilterValue extends Message<DatetimeFieldFilterValue, Builder> {
    public static final ProtoAdapter<DatetimeFieldFilterValue> ADAPTER = null;
    public static final String DEFAULT_DATETIME = "";
    private static final long serialVersionUID = 0;
    public final String mdatetime;
    public final Type mtype;

    public static final class Builder extends Message.Builder<DatetimeFieldFilterValue, Builder> {
        public String mdatetime;
        public Type mtype;

        @Override // com.squareup.wire.Message.Builder
        public DatetimeFieldFilterValue build() {
            return new DatetimeFieldFilterValue(this.mtype, this.mdatetime, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder datetime(String r100) {
            this.mdatetime = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DatetimeFieldFilterValue extends ProtoAdapter<DatetimeFieldFilterValue> {
        public ProtoAdapter_DatetimeFieldFilterValue() {
            super(FieldEncoding.LENGTH_DELIMITED, DatetimeFieldFilterValue.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DatetimeFieldFilterValue decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mdatetime = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mdatetime = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DatetimeFieldFilterValue r100) {
            Type r101 = r100.mtype;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Type.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mdatetime;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DatetimeFieldFilterValue decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DatetimeFieldFilterValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DatetimeFieldFilterValue r101) throws IOException {
            Type r102 = r101.mtype;
            if (r102 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mdatetime;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DatetimeFieldFilterValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type LAST_MONTH = null;
        public static final Type LAST_WEEK = null;
        public static final Type NEXT_MONTH = null;
        public static final Type NEXT_WEEK = null;
        public static final Type THIS_MONTH = null;
        public static final Type THIS_WEEK = null;
        public static final Type TIMESTAMP = null;
        public static final Type TODAY = null;
        public static final Type TOMORROW = null;
        public static final Type UNKNOWN = null;
        public static final Type YESTERDAY = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("TIMESTAMP", 1, 1);
            TIMESTAMP = r101;
            Type r102 = new Type("TODAY", 2, 2);
            TODAY = r102;
            Type r103 = new Type("YESTERDAY", 3, 3);
            YESTERDAY = r103;
            Type r104 = new Type("TOMORROW", 4, 4);
            TOMORROW = r104;
            Type r105 = new Type("THIS_WEEK", 5, 5);
            THIS_WEEK = r105;
            Type r110 = new Type("LAST_WEEK", 6, 6);
            LAST_WEEK = r110;
            Type r111 = new Type("NEXT_WEEK", 7, 7);
            NEXT_WEEK = r111;
            Type r112 = new Type("THIS_MONTH", 8, 8);
            THIS_MONTH = r112;
            Type r113 = new Type("LAST_MONTH", 9, 9);
            LAST_MONTH = r113;
            Type r114 = new Type("NEXT_MONTH", 10, 10);
            NEXT_MONTH = r114;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
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
                case 0: goto L26;
                case 1: goto L24;
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L18;
                case 5: goto L16;
                case 6: goto L14;
                case 7: goto L12;
                case 8: goto L10;
                case 9: goto L8;
                case 10: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return NEXT_MONTH;
        L8:
            return LAST_MONTH;
        L10:
            return THIS_MONTH;
        L12:
            return NEXT_WEEK;
        L14:
            return LAST_WEEK;
        L16:
            return THIS_WEEK;
        L18:
            return TOMORROW;
        L20:
            return YESTERDAY;
        L22:
            return TODAY;
        L24:
            return TIMESTAMP;
        L26:
            return UNKNOWN;
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
        ADAPTER = new ProtoAdapter_DatetimeFieldFilterValue();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtype = this.mtype;
        r100.mdatetime = this.mdatetime;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DatetimeFieldFilterValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DatetimeFieldFilterValue(Type r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DatetimeFieldFilterValue(Type r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtype = r100;
        this.mdatetime = r101;
    }
}
