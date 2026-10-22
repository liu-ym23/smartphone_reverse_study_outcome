package com.ss.android.lark.pb.minutes.v1;

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

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesRecordingSyncSubtitlesRequest extends Message<MinutesRecordingSyncSubtitlesRequest, Builder> {
    public static final ProtoAdapter<MinutesRecordingSyncSubtitlesRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FORCE_SYNC = null;
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final ProtoAdapter_MinutesRecordingSyncSubtitlesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean force_sync;
    public final String language;
    public final String session_id;

    public static final class Builder extends Message.Builder<MinutesRecordingSyncSubtitlesRequest, Builder> implements d<MinutesRecordingSyncSubtitlesRequest> {
        public Boolean force_sync;
        public String language;
        public String session_id;

        @Override // com.squareup.wire.Message.Builder
        public MinutesRecordingSyncSubtitlesRequest build() {
            String r100 = this.session_id;
            if (r100 == null) goto L9;
            if (this.language == null) goto L9;
            return new MinutesRecordingSyncSubtitlesRequest(this.session_id, this.language, this.force_sync, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "session_id", this.language, "language"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder force_sync(Boolean r100) {
            this.force_sync = r100;
            return this;
        }

        public Builder language(String r100) {
            this.language = r100;
            return this;
        }

        public Builder session_id(String r100) {
            this.session_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingSyncSubtitlesRequest extends ProtoAdapter<MinutesRecordingSyncSubtitlesRequest> implements c<MinutesRecordingSyncSubtitlesRequest> {
        public ProtoAdapter_MinutesRecordingSyncSubtitlesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingSyncSubtitlesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MinutesRecordingSyncSubtitlesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.session_id = "";
            r101.language = "";
            r101.force_sync = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.session_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.force_sync = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MinutesRecordingSyncSubtitlesRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.session_id) + r101.encodedSizeWithTag(2, r100.language);
            Boolean r103 = r100.force_sync;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MinutesRecordingSyncSubtitlesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MinutesRecordingSyncSubtitlesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MinutesRecordingSyncSubtitlesRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.session_id);
            r102.encodeWithTag(r100, 2, r101.language);
            Boolean r103 = r101.force_sync;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MinutesRecordingSyncSubtitlesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingSyncSubtitlesRequest r100 = new ProtoAdapter_MinutesRecordingSyncSubtitlesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FORCE_SYNC = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.session_id = this.session_id;
        r100.language = this.language;
        r100.force_sync = this.force_sync;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MinutesRecordingSyncSubtitlesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MinutesRecordingSyncSubtitlesRequest(String r100, String r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public MinutesRecordingSyncSubtitlesRequest(String r100, String r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.session_id = r100;
        this.language = r101;
        this.force_sync = r102;
    }
}
