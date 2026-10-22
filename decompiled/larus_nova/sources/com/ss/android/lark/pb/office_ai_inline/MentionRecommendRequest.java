package com.ss.android.lark.pb.office_ai_inline;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MentionRecommendRequest extends Message<MentionRecommendRequest, Builder> {
    public static final ProtoAdapter<MentionRecommendRequest> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final String DEFAULT_OBJ_TOKEN = "";
    public static final String DEFAULT_TYPE = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final String mobj_token;
    public final Scenario mscenario;
    public final String mtype;

    public static final class Builder extends Message.Builder<MentionRecommendRequest, Builder> {
        public String mcontent;
        public String mobj_token;
        public Scenario mscenario;
        public String mtype;

        @Override // com.squareup.wire.Message.Builder
        public MentionRecommendRequest build() {
            return new MentionRecommendRequest(this.mscenario, this.mobj_token, this.mcontent, this.mtype, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder obj_token(String r100) {
            this.mobj_token = r100;
            return this;
        }

        public Builder scenario(Scenario r100) {
            this.mscenario = r100;
            return this;
        }

        public Builder type(String r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MentionRecommendRequest extends ProtoAdapter<MentionRecommendRequest> {
        public ProtoAdapter_MentionRecommendRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MentionRecommendRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MentionRecommendRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mobj_token = "";
            r101.mcontent = "";
            r101.mtype = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mscenario = Scenario.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mobj_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mcontent = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mtype = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(MentionRecommendRequest r100) {
            Scenario r101 = r100.mscenario;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Scenario.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mobj_token;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mcontent;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mtype;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ MentionRecommendRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MentionRecommendRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MentionRecommendRequest r101) throws IOException {
            Scenario r102 = r101.mscenario;
            if (r102 == null) goto L5;
            Scenario.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mobj_token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mcontent;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mtype;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MentionRecommendRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MentionRecommendRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscenario = this.mscenario;
        r100.mobj_token = this.mobj_token;
        r100.mcontent = this.mcontent;
        r100.mtype = this.mtype;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MentionRecommendRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MentionRecommendRequest(Scenario r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public MentionRecommendRequest(Scenario r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mscenario = r100;
        this.mobj_token = r101;
        this.mcontent = r102;
        this.mtype = r103;
    }
}
