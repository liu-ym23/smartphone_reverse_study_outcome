package com.bytedance.lark.pb.openplatform.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateUniversalCardLocalDataRequestInner extends Message<UpdateUniversalCardLocalDataRequestInner, Builder> {
    public static final ProtoAdapter<UpdateUniversalCardLocalDataRequestInner> ADAPTER = null;
    public static final String DEFAULT_CARD_ID = "";
    public static final String DEFAULT_JSON_DELTA_DATA = "";
    public static final Boolean DEFAULT_NEED_PUSH = null;
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    public final String card_id;
    public final String json_delta_data;
    public final Boolean need_push;
    public final String source_id;
    public final String version;

    public static final class Builder extends Message.Builder<UpdateUniversalCardLocalDataRequestInner, Builder> {
        public String card_id;
        public String json_delta_data;
        public Boolean need_push;
        public String source_id;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public UpdateUniversalCardLocalDataRequestInner build() {
            String r100 = this.card_id;
            if (r100 == null) goto L11;
            if (this.version == null) goto L11;
            if (this.json_delta_data == null) goto L11;
            return new UpdateUniversalCardLocalDataRequestInner(this.card_id, this.version, this.source_id, this.json_delta_data, this.need_push, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "card_id", this.version, "version", this.json_delta_data, "json_delta_data"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder card_id(String r100) {
            this.card_id = r100;
            return this;
        }

        public Builder json_delta_data(String r100) {
            this.json_delta_data = r100;
            return this;
        }

        public Builder need_push(Boolean r100) {
            this.need_push = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.source_id = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateUniversalCardLocalDataRequestInner extends ProtoAdapter<UpdateUniversalCardLocalDataRequestInner> {
        public ProtoAdapter_UpdateUniversalCardLocalDataRequestInner() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateUniversalCardLocalDataRequestInner.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateUniversalCardLocalDataRequestInner decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.card_id = "";
            r101.version = "";
            r101.source_id = "";
            r101.json_delta_data = "";
            r101.need_push = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.source_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.json_delta_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.need_push = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateUniversalCardLocalDataRequestInner r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.card_id) + r101.encodedSizeWithTag(2, r100.version);
            String r103 = r100.source_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = (r102 + r105) + r101.encodedSizeWithTag(4, r100.json_delta_data);
            Boolean r107 = r100.need_push;
            if (r107 == null) goto L10;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateUniversalCardLocalDataRequestInner decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateUniversalCardLocalDataRequestInner r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateUniversalCardLocalDataRequestInner r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.card_id);
            r102.encodeWithTag(r100, 2, r101.version);
            String r103 = r101.source_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r102.encodeWithTag(r100, 4, r101.json_delta_data);
            Boolean r104 = r101.need_push;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateUniversalCardLocalDataRequestInner r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateUniversalCardLocalDataRequestInner();
        DEFAULT_NEED_PUSH = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.card_id = this.card_id;
        r100.version = this.version;
        r100.source_id = this.source_id;
        r100.json_delta_data = this.json_delta_data;
        r100.need_push = this.need_push;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateUniversalCardLocalDataRequestInner.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateUniversalCardLocalDataRequestInner(String r100, String r101, String r110, String r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public UpdateUniversalCardLocalDataRequestInner(String r100, String r101, String r102, String r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.card_id = r100;
        this.version = r101;
        this.source_id = r102;
        this.json_delta_data = r103;
        this.need_push = r104;
    }
}
