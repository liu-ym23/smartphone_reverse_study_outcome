package com.bytedance.lark.pb.im.v1;

import com.larus.bmhome.music.applet.MusicAppletPage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PutActionRequest extends Message<PutActionRequest, Builder> {
    public static final ProtoAdapter<PutActionRequest> ADAPTER = null;
    public static final String DEFAULT_ACTION_ID = "";
    public static final Boolean DEFAULT_IS_EPHEMERAL = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final ProtoAdapter_PutActionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String action_id;
    public final Boolean is_ephemeral;
    public final String message_id;
    public final Map<String, String> params;

    public static final class Builder extends Message.Builder<PutActionRequest, Builder> implements d<PutActionRequest> {
        public String action_id;
        public Boolean is_ephemeral;
        public String message_id;
        public Map<String, String> params;

        @Override // com.squareup.wire.Message.Builder
        public PutActionRequest build() {
            String r100 = this.action_id;
            if (r100 == null) goto L9;
            if (this.message_id == null) goto L9;
            return new PutActionRequest(this.action_id, this.params, this.message_id, this.is_ephemeral, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "action_id", this.message_id, MusicAppletPage.KEY_MESSAGE_ID});
        }

        public Builder() {
            this.params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_id(String r100) {
            this.action_id = r100;
            return this;
        }

        public Builder is_ephemeral(Boolean r100) {
            this.is_ephemeral = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutActionRequest extends ProtoAdapter<PutActionRequest> implements c<PutActionRequest> {
        private final ProtoAdapter<Map<String, String>> params;

        public ProtoAdapter_PutActionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutActionRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutActionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.action_id = "";
            r101.message_id = "";
            r101.is_ephemeral = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.action_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.params.putAll(this.params.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.is_ephemeral = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(PutActionRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.action_id) + this.params.encodedSizeWithTag(2, r100.params)) + r101.encodedSizeWithTag(3, r100.message_id);
            Boolean r103 = r100.is_ephemeral;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutActionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutActionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutActionRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.action_id);
            this.params.encodeWithTag(r100, 2, r101.params);
            r102.encodeWithTag(r100, 3, r101.message_id);
            Boolean r103 = r101.is_ephemeral;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutActionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutActionRequest r100 = new ProtoAdapter_PutActionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_EPHEMERAL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action_id = this.action_id;
        r100.params = Internal.copyOf("params", this.params);
        r100.message_id = this.message_id;
        r100.is_ephemeral = this.is_ephemeral;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutActionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutActionRequest(String r100, Map<String, String> r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PutActionRequest(String r100, Map<String, String> r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.action_id = r100;
        this.params = Internal.immutableCopyOf("params", r101);
        this.message_id = r102;
        this.is_ephemeral = r103;
    }
}
