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
public final class MinutesRecordingPullSubtitlesRequest extends Message<MinutesRecordingPullSubtitlesRequest, Builder> {
    public static final ProtoAdapter<MinutesRecordingPullSubtitlesRequest> ADAPTER = null;
    public static final Long DEFAULT_COUNT = null;
    public static final Boolean DEFAULT_FORCE_FROM_SERVER = null;
    public static final Boolean DEFAULT_IS_FORWARD = null;
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_SESSION_ID = "";
    public static final Long DEFAULT_TARGET_SEG_ID = null;
    public static final ProtoAdapter_MinutesRecordingPullSubtitlesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long count;
    public final Boolean force_from_server;
    public final Boolean is_forward;
    public final String language;
    public final String session_id;
    public final Long target_seg_id;

    public static final class Builder extends Message.Builder<MinutesRecordingPullSubtitlesRequest, Builder> implements d<MinutesRecordingPullSubtitlesRequest> {
        public Long count;
        public Boolean force_from_server;
        public Boolean is_forward;
        public String language;
        public String session_id;
        public Long target_seg_id;

        @Override // com.squareup.wire.Message.Builder
        public MinutesRecordingPullSubtitlesRequest build() {
            String r100 = this.session_id;
            if (r100 == null) goto L9;
            if (this.language == null) goto L9;
            return new MinutesRecordingPullSubtitlesRequest(this.session_id, this.language, this.force_from_server, this.is_forward, this.target_seg_id, this.count, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "session_id", this.language, "language"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Long r100) {
            this.count = r100;
            return this;
        }

        public Builder force_from_server(Boolean r100) {
            this.force_from_server = r100;
            return this;
        }

        public Builder is_forward(Boolean r100) {
            this.is_forward = r100;
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

        public Builder target_seg_id(Long r100) {
            this.target_seg_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingPullSubtitlesRequest extends ProtoAdapter<MinutesRecordingPullSubtitlesRequest> implements c<MinutesRecordingPullSubtitlesRequest> {
        public ProtoAdapter_MinutesRecordingPullSubtitlesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingPullSubtitlesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MinutesRecordingPullSubtitlesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.session_id = "";
            r101.language = "";
            Boolean r102 = Boolean.FALSE;
            r101.force_from_server = r102;
            r101.is_forward = r102;
            r101.target_seg_id = 0L;
            r101.count = 0L;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L13;
            switch(r104) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.count = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            r101.target_seg_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            r101.is_forward = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.force_from_server = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.session_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MinutesRecordingPullSubtitlesRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.session_id) + r101.encodedSizeWithTag(2, r100.language);
            Boolean r103 = r100.force_from_server;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_forward;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Long r110 = r100.target_seg_id;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            Long r113 = r100.count;
            if (r113 == null) goto L18;
            r104 = ProtoAdapter.INT64.encodedSizeWithTag(6, r113);
        L18:
            return (r112 + r104) + r100.unknownFields().size();
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MinutesRecordingPullSubtitlesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MinutesRecordingPullSubtitlesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MinutesRecordingPullSubtitlesRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.session_id);
            r102.encodeWithTag(r100, 2, r101.language);
            Boolean r103 = r101.force_from_server;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L5:
            Boolean r104 = r101.is_forward;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L8:
            Long r105 = r101.target_seg_id;
            if (r105 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r105);
        L11:
            Long r106 = r101.count;
            if (r106 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 6, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MinutesRecordingPullSubtitlesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MinutesRecordingPullSubtitlesRequest r100 = new ProtoAdapter_MinutesRecordingPullSubtitlesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_FORCE_FROM_SERVER = r101;
        DEFAULT_IS_FORWARD = r101;
        DEFAULT_TARGET_SEG_ID = 0L;
        DEFAULT_COUNT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.session_id = this.session_id;
        r100.language = this.language;
        r100.force_from_server = this.force_from_server;
        r100.is_forward = this.is_forward;
        r100.target_seg_id = this.target_seg_id;
        r100.count = this.count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MinutesRecordingPullSubtitlesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MinutesRecordingPullSubtitlesRequest(String r100, String r110, Boolean r111, Boolean r112, Long r113, Long r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public MinutesRecordingPullSubtitlesRequest(String r100, String r101, Boolean r102, Boolean r103, Long r104, Long r105, ByteString r106) {
        super(ADAPTER, r106);
        this.session_id = r100;
        this.language = r101;
        this.force_from_server = r102;
        this.is_forward = r103;
        this.target_seg_id = r104;
        this.count = r105;
    }
}
