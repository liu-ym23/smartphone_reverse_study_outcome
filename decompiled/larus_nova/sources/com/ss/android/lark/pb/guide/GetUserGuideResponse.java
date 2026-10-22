package com.ss.android.lark.pb.guide;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GetUserGuideResponse extends Message<GetUserGuideResponse, Builder> {
    public static final ProtoAdapter<GetUserGuideResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, Long> mfirst_login_time;
    public final Map<String, Long> mfst_login_time;
    public final List<UserGuideViewAreaPair> mpairs;

    public static final class Builder extends Message.Builder<GetUserGuideResponse, Builder> {
        public Map<Long, Long> mfirst_login_time;
        public Map<String, Long> mfst_login_time;
        public List<UserGuideViewAreaPair> mpairs;

        @Override // com.squareup.wire.Message.Builder
        public GetUserGuideResponse build() {
            return new GetUserGuideResponse(this.mpairs, this.mfirst_login_time, this.mfst_login_time, super.buildUnknownFields());
        }

        public Builder() {
            this.mpairs = Internal.newMutableList();
            this.mfirst_login_time = Internal.newMutableMap();
            this.mfst_login_time = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder first_login_time(Map<Long, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfirst_login_time = r100;
            return this;
        }

        public Builder fst_login_time(Map<String, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfst_login_time = r100;
            return this;
        }

        public Builder pairs(List<UserGuideViewAreaPair> r100) {
            Internal.checkElementsNotNull(r100);
            this.mpairs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserGuideResponse extends ProtoAdapter<GetUserGuideResponse> {
        private final ProtoAdapter<Map<Long, Long>> mfirst_login_time;
        private final ProtoAdapter<Map<String, Long>> mfst_login_time;

        public ProtoAdapter_GetUserGuideResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserGuideResponse.class);
            ProtoAdapter<Long> r100 = ProtoAdapter.INT64;
            this.mfirst_login_time = ProtoAdapter.newMapAdapter(r100, r100);
            this.mfst_login_time = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserGuideResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mpairs.add(UserGuideViewAreaPair.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mfirst_login_time.putAll(this.mfirst_login_time.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mfst_login_time.putAll(this.mfst_login_time.decode(r100));
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
        public int encodedSize2(GetUserGuideResponse r100) {
            return ((UserGuideViewAreaPair.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mpairs) + this.mfirst_login_time.encodedSizeWithTag(2, r100.mfirst_login_time)) + this.mfst_login_time.encodedSizeWithTag(3, r100.mfst_login_time)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserGuideResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserGuideResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserGuideResponse r101) throws IOException {
            UserGuideViewAreaPair.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mpairs);
            this.mfirst_login_time.encodeWithTag(r100, 2, r101.mfirst_login_time);
            this.mfst_login_time.encodeWithTag(r100, 3, r101.mfst_login_time);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserGuideResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetUserGuideResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mpairs = Internal.copyOf("mpairs", this.mpairs);
        r100.mfirst_login_time = Internal.copyOf("mfirst_login_time", this.mfirst_login_time);
        r100.mfst_login_time = Internal.copyOf("mfst_login_time", this.mfst_login_time);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserGuideResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserGuideResponse(List<UserGuideViewAreaPair> r100, Map<Long, Long> r101, Map<String, Long> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetUserGuideResponse(List<UserGuideViewAreaPair> r100, Map<Long, Long> r101, Map<String, Long> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mpairs = Internal.immutableCopyOf("mpairs", r100);
        this.mfirst_login_time = Internal.immutableCopyOf("mfirst_login_time", r101);
        this.mfst_login_time = Internal.immutableCopyOf("mfst_login_time", r102);
    }
}
