package com.ss.android.lark.pb.ai_engine;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class FeedsbackRequest extends Message<FeedsbackRequest, Builder> {
    public static final ProtoAdapter<FeedsbackRequest> ADAPTER = null;
    public static final String DEFAULT_AI_MESSAGE_ID = "";
    public static final String DEFAULT_ANS_MESSAGE_ID = "";
    public static final String DEFAULT_ANS_MESSAGE_RAWDATA = "";
    public static final String DEFAULT_QUERY_MESSAGE_ID = "";
    public static final String DEFAULT_QUERY_MESSAGE_RAWDATA = "";
    public static final String DEFAULT_SCENARIO = "";
    private static final long serialVersionUID = 0;
    public final String mai_message_id;
    public final String mans_message_id;
    public final String mans_message_rawdata;
    public final FeedsbackData mdata;
    public final WorkMode mmode;
    public final String mquery_message_id;
    public final String mquery_message_rawdata;
    public final String mscenario;

    public static final class Builder extends Message.Builder<FeedsbackRequest, Builder> {
        public String mai_message_id;
        public String mans_message_id;
        public String mans_message_rawdata;
        public FeedsbackData mdata;
        public WorkMode mmode;
        public String mquery_message_id;
        public String mquery_message_rawdata;
        public String mscenario;

        @Override // com.squareup.wire.Message.Builder
        public FeedsbackRequest build() {
            return new FeedsbackRequest(this.mai_message_id, this.mquery_message_id, this.mans_message_id, this.mquery_message_rawdata, this.mans_message_rawdata, this.mdata, this.mmode, this.mscenario, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ai_message_id(String r100) {
            this.mai_message_id = r100;
            return this;
        }

        public Builder ans_message_id(String r100) {
            this.mans_message_id = r100;
            return this;
        }

        public Builder ans_message_rawdata(String r100) {
            this.mans_message_rawdata = r100;
            return this;
        }

        public Builder data(FeedsbackData r100) {
            this.mdata = r100;
            return this;
        }

        public Builder mode(WorkMode r100) {
            this.mmode = r100;
            return this;
        }

        public Builder query_message_id(String r100) {
            this.mquery_message_id = r100;
            return this;
        }

        public Builder query_message_rawdata(String r100) {
            this.mquery_message_rawdata = r100;
            return this;
        }

        public Builder scenario(String r100) {
            this.mscenario = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedsbackRequest extends ProtoAdapter<FeedsbackRequest> {
        public ProtoAdapter_FeedsbackRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedsbackRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedsbackRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mai_message_id = "";
            r101.mquery_message_id = "";
            r101.mans_message_id = "";
            r101.mquery_message_rawdata = "";
            r101.mans_message_rawdata = "";
            r101.mscenario = "";
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
            r101.mmode = WorkMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mscenario = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mdata = FeedsbackData.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mans_message_rawdata = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mquery_message_rawdata = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.mans_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mquery_message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mai_message_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(FeedsbackRequest r100) {
            String r101 = r100.mai_message_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mquery_message_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mans_message_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mquery_message_rawdata;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mans_message_rawdata;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            FeedsbackData r116 = r100.mdata;
            if (r116 == null) goto L25;
            int r117 = FeedsbackData.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            WorkMode r119 = r100.mmode;
            if (r119 == null) goto L29;
            int r120 = WorkMode.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.mscenario;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(8, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ FeedsbackRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedsbackRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedsbackRequest r101) throws IOException {
            String r102 = r101.mai_message_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mquery_message_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mans_message_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mquery_message_rawdata;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mans_message_rawdata;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            FeedsbackData r107 = r101.mdata;
            if (r107 == null) goto L20;
            FeedsbackData.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            WorkMode r108 = r101.mmode;
            if (r108 == null) goto L23;
            WorkMode.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            String r109 = r101.mscenario;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedsbackRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedsbackRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mai_message_id = this.mai_message_id;
        r100.mquery_message_id = this.mquery_message_id;
        r100.mans_message_id = this.mans_message_id;
        r100.mquery_message_rawdata = this.mquery_message_rawdata;
        r100.mans_message_rawdata = this.mans_message_rawdata;
        r100.mdata = this.mdata;
        r100.mmode = this.mmode;
        r100.mscenario = this.mscenario;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedsbackRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedsbackRequest(String r110, String r111, String r112, String r113, String r114, FeedsbackData r115, WorkMode r116, String r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, ByteString.EMPTY);
    }

    public FeedsbackRequest(String r100, String r101, String r102, String r103, String r104, FeedsbackData r105, WorkMode r106, String r107, ByteString r110) {
        super(ADAPTER, r110);
        this.mai_message_id = r100;
        this.mquery_message_id = r101;
        this.mans_message_id = r102;
        this.mquery_message_rawdata = r103;
        this.mans_message_rawdata = r104;
        this.mdata = r105;
        this.mmode = r106;
        this.mscenario = r107;
    }
}
