package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class PSTNPhone extends Message<PSTNPhone, Builder> {
    public static final ProtoAdapter<PSTNPhone> ADAPTER = null;
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_NUMBER = "";
    public static final String DEFAULT_NUMBER_DISPLAY = "";
    private static final long serialVersionUID = 0;
    public final String mcountry;
    public final String mnumber;
    public final String mnumber_display;
    public final Type mtype;

    public static final class Builder extends Message.Builder<PSTNPhone, Builder> {
        public String mcountry;
        public String mnumber;
        public String mnumber_display;
        public Type mtype;

        @Override // com.squareup.wire.Message.Builder
        public PSTNPhone build() {
            String r100 = this.mcountry;
            if (r100 == null) goto L11;
            if (this.mtype == null) goto L11;
            if (this.mnumber == null) goto L11;
            return new PSTNPhone(this.mcountry, this.mtype, this.mnumber, this.mnumber_display, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "mcountry", this.mtype, GearStrategyConsts.EV_MEDIA_TYPE, this.mnumber, "mnumber"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder country(String r100) {
            this.mcountry = r100;
            return this;
        }

        public Builder number(String r100) {
            this.mnumber = r100;
            return this;
        }

        public Builder number_display(String r100) {
            this.mnumber_display = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PSTNPhone extends ProtoAdapter<PSTNPhone> {
        public ProtoAdapter_PSTNPhone() {
            super(FieldEncoding.LENGTH_DELIMITED, PSTNPhone.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PSTNPhone decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcountry = "";
            r101.mnumber = "";
            r101.mnumber_display = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mcountry = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mnumber = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mnumber_display = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PSTNPhone r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.mcountry) + Type.ADAPTER.encodedSizeWithTag(2, r100.mtype)) + r101.encodedSizeWithTag(3, r100.mnumber);
            String r103 = r100.mnumber_display;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(4, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PSTNPhone decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PSTNPhone r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PSTNPhone r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mcountry);
            Type.ADAPTER.encodeWithTag(r100, 2, r101.mtype);
            r102.encodeWithTag(r100, 3, r101.mnumber);
            String r103 = r101.mnumber_display;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PSTNPhone r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type CHARGE = null;
        public static final Type FREE = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("FREE", 1, 1);
            FREE = r101;
            Type r102 = new Type("CHARGE", 2, 2);
            CHARGE = r102;
            $VALUES = new Type[]{r100, r101, r102};
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
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CHARGE;
        L12:
            return FREE;
        L14:
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
        ADAPTER = new ProtoAdapter_PSTNPhone();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcountry = this.mcountry;
        r100.mtype = this.mtype;
        r100.mnumber = this.mnumber;
        r100.mnumber_display = this.mnumber_display;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PSTNPhone.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PSTNPhone(String r100, Type r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PSTNPhone(String r100, Type r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mcountry = r100;
        this.mtype = r101;
        this.mnumber = r102;
        this.mnumber_display = r103;
    }
}
