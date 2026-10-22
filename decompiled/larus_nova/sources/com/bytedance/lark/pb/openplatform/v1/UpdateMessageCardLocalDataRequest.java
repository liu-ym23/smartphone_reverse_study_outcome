package com.bytedance.lark.pb.openplatform.v1;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateMessageCardLocalDataRequest extends Message<UpdateMessageCardLocalDataRequest, Builder> {
    public static final ProtoAdapter<UpdateMessageCardLocalDataRequest> ADAPTER = null;
    public static final String DEFAULT_JSON_DELTA_DATA = "";
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final Boolean DEFAULT_NEED_PUSH = null;
    public static final String DEFAULT_VERSION = "";
    public static final ProtoAdapter_UpdateMessageCardLocalDataRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String json_delta_data;
    public final String message_id;
    public final Boolean need_push;
    public final String version;

    public static final class Builder extends Message.Builder<UpdateMessageCardLocalDataRequest, Builder> implements d<UpdateMessageCardLocalDataRequest> {
        public String json_delta_data;
        public String message_id;
        public Boolean need_push;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public UpdateMessageCardLocalDataRequest build() {
            String r100 = this.message_id;
            if (r100 == null) goto L11;
            if (this.version == null) goto L11;
            if (this.json_delta_data == null) goto L11;
            return new UpdateMessageCardLocalDataRequest(this.message_id, this.version, this.json_delta_data, this.need_push, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID, this.version, "version", this.json_delta_data, "json_delta_data"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder json_delta_data(String r100) {
            this.json_delta_data = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder need_push(Boolean r100) {
            this.need_push = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateMessageCardLocalDataRequest extends ProtoAdapter<UpdateMessageCardLocalDataRequest> implements c<UpdateMessageCardLocalDataRequest> {
        public ProtoAdapter_UpdateMessageCardLocalDataRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateMessageCardLocalDataRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateMessageCardLocalDataRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.version = "";
            r101.json_delta_data = "";
            r101.need_push = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.json_delta_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.need_push = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateMessageCardLocalDataRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.message_id) + r101.encodedSizeWithTag(2, r100.version)) + r101.encodedSizeWithTag(3, r100.json_delta_data);
            Boolean r103 = r100.need_push;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateMessageCardLocalDataRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateMessageCardLocalDataRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateMessageCardLocalDataRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.message_id);
            r102.encodeWithTag(r100, 2, r101.version);
            r102.encodeWithTag(r100, 3, r101.json_delta_data);
            Boolean r103 = r101.need_push;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateMessageCardLocalDataRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateMessageCardLocalDataRequest r100 = new ProtoAdapter_UpdateMessageCardLocalDataRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NEED_PUSH = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.version = this.version;
        r100.json_delta_data = this.json_delta_data;
        r100.need_push = this.need_push;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateMessageCardLocalDataRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateMessageCardLocalDataRequest(String r100, String r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UpdateMessageCardLocalDataRequest(String r100, String r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.message_id = r100;
        this.version = r101;
        this.json_delta_data = r102;
        this.need_push = r103;
    }
}
