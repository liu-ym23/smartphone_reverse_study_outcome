package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.HongbaoContent;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class GrabHongbaoRecord extends Message<GrabHongbaoRecord, Builder> {
    public static final ProtoAdapter<GrabHongbaoRecord> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Long DEFAULT_GRAB_AMOUNT = null;
    public static final Long DEFAULT_GRAB_TIME = null;
    public static final HongbaoContent.Type DEFAULT_HONGBAO_TYPE = null;
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_P2P = null;
    public static final String DEFAULT_SENDER_ID = "";
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final CompanyInfo company_info;
    public final Long grab_amount;
    public final Long grab_time;
    public final HongbaoContent.Type hongbao_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253641id;
    public final Boolean is_p2p;
    public final String sender_id;

    public static final class Builder extends Message.Builder<GrabHongbaoRecord, Builder> {
        public String chat_id;
        public CompanyInfo company_info;
        public Long grab_amount;
        public Long grab_time;
        public HongbaoContent.Type hongbao_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253642id;
        public Boolean is_p2p;
        public String sender_id;

        @Override // com.squareup.wire.Message.Builder
        public GrabHongbaoRecord build() {
            String r100 = this.f253642id;
            if (r100 == null) goto L15;
            if (this.grab_amount == null) goto L15;
            if (this.grab_time == null) goto L15;
            if (this.sender_id == null) goto L15;
            if (this.is_p2p == null) goto L15;
            return new GrabHongbaoRecord(this.f253642id, this.grab_amount, this.grab_time, this.sender_id, this.is_p2p, this.chat_id, this.hongbao_type, this.company_info, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.grab_amount, "grab_amount", this.grab_time, "grab_time", this.sender_id, "sender_id", this.is_p2p, "is_p2p"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder company_info(CompanyInfo r100) {
            this.company_info = r100;
            return this;
        }

        public Builder grab_amount(Long r100) {
            this.grab_amount = r100;
            return this;
        }

        public Builder grab_time(Long r100) {
            this.grab_time = r100;
            return this;
        }

        public Builder hongbao_type(HongbaoContent.Type r100) {
            this.hongbao_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253642id = r100;
            return this;
        }

        public Builder is_p2p(Boolean r100) {
            this.is_p2p = r100;
            return this;
        }

        public Builder sender_id(String r100) {
            this.sender_id = r100;
            return this;
        }
    }

    public static final class CompanyInfo extends Message<CompanyInfo, Builder> {
        public static final ProtoAdapter<CompanyInfo> ADAPTER = null;
        public static final String DEFAULT_COMPANY_NAME = "";
        private static final long serialVersionUID = 0;
        public final ImageSetPassThrough company_logo;
        public final String company_name;

        public static final class Builder extends Message.Builder<CompanyInfo, Builder> {
            public ImageSetPassThrough company_logo;
            public String company_name;

            @Override // com.squareup.wire.Message.Builder
            public CompanyInfo build() {
                return new CompanyInfo(this.company_logo, this.company_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder company_logo(ImageSetPassThrough r100) {
                this.company_logo = r100;
                return this;
            }

            public Builder company_name(String r100) {
                this.company_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_CompanyInfo extends ProtoAdapter<CompanyInfo> {
            public ProtoAdapter_CompanyInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, CompanyInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public CompanyInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.company_name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.company_logo = ImageSetPassThrough.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.company_name = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(CompanyInfo r100) {
                ImageSetPassThrough r101 = r100.company_logo;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.company_name;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ CompanyInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(CompanyInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, CompanyInfo r101) throws IOException {
                ImageSetPassThrough r102 = r101.company_logo;
                if (r102 == null) goto L5;
                ImageSetPassThrough.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.company_name;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CompanyInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_CompanyInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.company_logo = this.company_logo;
            r100.company_name = this.company_name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return CompanyInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public CompanyInfo(ImageSetPassThrough r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public CompanyInfo(ImageSetPassThrough r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.company_logo = r100;
            this.company_name = r101;
        }
    }

    public static final class ProtoAdapter_GrabHongbaoRecord extends ProtoAdapter<GrabHongbaoRecord> {
        public ProtoAdapter_GrabHongbaoRecord() {
            super(FieldEncoding.LENGTH_DELIMITED, GrabHongbaoRecord.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GrabHongbaoRecord decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253642id = "";
            r101.grab_amount = 0L;
            r101.grab_time = 0L;
            r101.sender_id = "";
            r101.is_p2p = Boolean.FALSE;
            r101.chat_id = "";
            r101.hongbao_type = HongbaoContent.Type.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            switch(r103) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L20;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r101.hongbao_type = HongbaoContent.Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.company_info = CompanyInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.is_p2p = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.sender_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.grab_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.grab_amount = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.f253642id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GrabHongbaoRecord r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253641id);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            int r104 = (((r102 + r103.encodedSizeWithTag(2, r100.grab_amount)) + r103.encodedSizeWithTag(3, r100.grab_time)) + r101.encodedSizeWithTag(4, r100.sender_id)) + ProtoAdapter.BOOL.encodedSizeWithTag(5, r100.is_p2p);
            String r105 = r100.chat_id;
            int r106 = 0;
            if (r105 == null) goto L5;
            int r107 = r101.encodedSizeWithTag(6, r105);
        L6:
            int r108 = r104 + r107;
            HongbaoContent.Type r109 = r100.hongbao_type;
            if (r109 == null) goto L9;
            int r110 = HongbaoContent.Type.ADAPTER.encodedSizeWithTag(7, r109);
        L10:
            int r111 = r108 + r110;
            CompanyInfo r112 = r100.company_info;
            if (r112 == null) goto L14;
            r106 = CompanyInfo.ADAPTER.encodedSizeWithTag(8, r112);
        L14:
            return (r111 + r106) + r100.unknownFields().size();
        L9:
            r110 = 0;
            goto L10
        L5:
            r107 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GrabHongbaoRecord decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GrabHongbaoRecord r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GrabHongbaoRecord r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253641id);
            ProtoAdapter<Long> r103 = ProtoAdapter.INT64;
            r103.encodeWithTag(r100, 2, r101.grab_amount);
            r103.encodeWithTag(r100, 3, r101.grab_time);
            r102.encodeWithTag(r100, 4, r101.sender_id);
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r101.is_p2p);
            String r104 = r101.chat_id;
            if (r104 == null) goto L5;
            r102.encodeWithTag(r100, 6, r104);
        L5:
            HongbaoContent.Type r105 = r101.hongbao_type;
            if (r105 == null) goto L8;
            HongbaoContent.Type.ADAPTER.encodeWithTag(r100, 7, r105);
        L8:
            CompanyInfo r106 = r101.company_info;
            if (r106 == null) goto L11;
            CompanyInfo.ADAPTER.encodeWithTag(r100, 8, r106);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GrabHongbaoRecord r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GrabHongbaoRecord();
        DEFAULT_GRAB_AMOUNT = 0L;
        DEFAULT_GRAB_TIME = 0L;
        DEFAULT_IS_P2P = Boolean.FALSE;
        DEFAULT_HONGBAO_TYPE = HongbaoContent.Type.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253642id = this.f253641id;
        r100.grab_amount = this.grab_amount;
        r100.grab_time = this.grab_time;
        r100.sender_id = this.sender_id;
        r100.is_p2p = this.is_p2p;
        r100.chat_id = this.chat_id;
        r100.hongbao_type = this.hongbao_type;
        r100.company_info = this.company_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GrabHongbaoRecord.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GrabHongbaoRecord(String r110, Long r111, Long r112, String r113, Boolean r114, String r115, HongbaoContent.Type r116, CompanyInfo r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public GrabHongbaoRecord(String r100, Long r101, Long r102, String r103, Boolean r104, String r105, HongbaoContent.Type r106, CompanyInfo r107, ByteString r110) {
        super(ADAPTER, r110);
        this.f253641id = r100;
        this.grab_amount = r101;
        this.grab_time = r102;
        this.sender_id = r103;
        this.is_p2p = r104;
        this.chat_id = r105;
        this.hongbao_type = r106;
        this.company_info = r107;
    }
}
