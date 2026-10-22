package com.bytedance.lark.pb.im.v1;

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
public final class ToggleTextOnAudioRequest extends Message<ToggleTextOnAudioRequest, Builder> {
    public static final ProtoAdapter<ToggleTextOnAudioRequest> ADAPTER = null;
    public static final Boolean DEFAULT_HIDE_VOICE2TEXT = null;
    public static final String DEFAULT_MESSAGE_ID = "";
    public static final ProtoAdapter_ToggleTextOnAudioRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean hide_voice2text;
    public final String message_id;

    public static final class Builder extends Message.Builder<ToggleTextOnAudioRequest, Builder> implements d<ToggleTextOnAudioRequest> {
        public Boolean hide_voice2text;
        public String message_id;

        @Override // com.squareup.wire.Message.Builder
        public ToggleTextOnAudioRequest build() {
            String r100 = this.message_id;
            if (r100 == null) goto L9;
            if (this.hide_voice2text == null) goto L9;
            return new ToggleTextOnAudioRequest(this.message_id, this.hide_voice2text, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, MusicAppletPage.KEY_MESSAGE_ID, this.hide_voice2text, "hide_voice2text"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder hide_voice2text(Boolean r100) {
            this.hide_voice2text = r100;
            return this;
        }

        public Builder message_id(String r100) {
            this.message_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ToggleTextOnAudioRequest extends ProtoAdapter<ToggleTextOnAudioRequest> implements c<ToggleTextOnAudioRequest> {
        public ProtoAdapter_ToggleTextOnAudioRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ToggleTextOnAudioRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ToggleTextOnAudioRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.message_id = "";
            r101.hide_voice2text = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.message_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.hide_voice2text = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ToggleTextOnAudioRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.message_id) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.hide_voice2text)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ToggleTextOnAudioRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ToggleTextOnAudioRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ToggleTextOnAudioRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.message_id);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.hide_voice2text);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ToggleTextOnAudioRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ToggleTextOnAudioRequest r100 = new ProtoAdapter_ToggleTextOnAudioRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HIDE_VOICE2TEXT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.message_id = this.message_id;
        r100.hide_voice2text = this.hide_voice2text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ToggleTextOnAudioRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ToggleTextOnAudioRequest(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ToggleTextOnAudioRequest(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.message_id = r100;
        this.hide_voice2text = r101;
    }
}
