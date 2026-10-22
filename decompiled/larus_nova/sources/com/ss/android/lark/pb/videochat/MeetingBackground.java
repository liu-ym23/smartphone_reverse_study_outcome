package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.videochat_material.MaterialSource;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class MeetingBackground extends Message<MeetingBackground, Builder> {
    public static final ProtoAdapter<MeetingBackground> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PORTRAIT_URL = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final String mname;
    public final String mportrait_url;
    public final MaterialSource msource;
    public final Type mtype;
    public final String murl;

    public static final class Builder extends Message.Builder<MeetingBackground, Builder> {
        public String mname;
        public String mportrait_url;
        public MaterialSource msource;
        public Type mtype;
        public String murl;

        @Override // com.squareup.wire.Message.Builder
        public MeetingBackground build() {
            Type r100 = this.mtype;
            if (r100 == null) goto L11;
            if (this.mname == null) goto L11;
            if (this.murl == null) goto L11;
            return new MeetingBackground(this.mtype, this.mname, this.murl, this.msource, this.mportrait_url, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, GearStrategyConsts.EV_MEDIA_TYPE, this.mname, "mname", this.murl, "murl"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder portrait_url(String r100) {
            this.mportrait_url = r100;
            return this;
        }

        public Builder source(MaterialSource r100) {
            this.msource = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.mtype = r100;
            return this;
        }

        public Builder url(String r100) {
            this.murl = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingBackground extends ProtoAdapter<MeetingBackground> {
        public ProtoAdapter_MeetingBackground() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingBackground.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingBackground decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mname = "";
            r101.murl = "";
            r101.mportrait_url = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
        L25:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.murl = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.msource = MaterialSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mportrait_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MeetingBackground r100) {
            int r101 = Type.ADAPTER.encodedSizeWithTag(1, r100.mtype);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = (r101 + r102.encodedSizeWithTag(2, r100.mname)) + r102.encodedSizeWithTag(3, r100.murl);
            MaterialSource r104 = r100.msource;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = MaterialSource.ADAPTER.encodedSizeWithTag(4, r104);
        L6:
            int r107 = r103 + r106;
            String r108 = r100.mportrait_url;
            if (r108 == null) goto L10;
            r105 = r102.encodedSizeWithTag(5, r108);
        L10:
            return (r107 + r105) + r100.unknownFields().size();
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MeetingBackground decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingBackground r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingBackground r101) throws IOException {
            Type.ADAPTER.encodeWithTag(r100, 1, r101.mtype);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.mname);
            r102.encodeWithTag(r100, 3, r101.murl);
            MaterialSource r103 = r101.msource;
            if (r103 == null) goto L5;
            MaterialSource.ADAPTER.encodeWithTag(r100, 4, r103);
        L5:
            String r104 = r101.mportrait_url;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingBackground r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type IMAGE = null;
        public static final Type UNKNOWN = null;
        public static final Type VIDEO = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("IMAGE", 1, 1);
            IMAGE = r101;
            Type r102 = new Type("VIDEO", 2, 2);
            VIDEO = r102;
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
            return VIDEO;
        L12:
            return IMAGE;
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
        ADAPTER = new ProtoAdapter_MeetingBackground();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtype = this.mtype;
        r100.mname = this.mname;
        r100.murl = this.murl;
        r100.msource = this.msource;
        r100.mportrait_url = this.mportrait_url;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingBackground.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingBackground(Type r100, String r101, String r110, MaterialSource r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public MeetingBackground(Type r100, String r101, String r102, MaterialSource r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mtype = r100;
        this.mname = r101;
        this.murl = r102;
        this.msource = r103;
        this.mportrait_url = r104;
    }
}
