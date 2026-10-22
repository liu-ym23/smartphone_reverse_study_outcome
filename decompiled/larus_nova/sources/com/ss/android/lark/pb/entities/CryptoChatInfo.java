package com.ss.android.lark.pb.entities;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.annotation.Debug;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CryptoChatInfo extends com.squareup.wire.Message<CryptoChatInfo, Builder> {
    public static final ProtoAdapter<CryptoChatInfo> ADAPTER = null;
    public static final Integer DEFAULT_FIRST_POSITION = null;
    public static final Integer DEFAULT_FIRST_POSITION_BADGE_COUNT = null;
    public static final FieldOptions FIELD_OPTIONS_MFIRST_POSITION = null;
    public static final FieldOptions FIELD_OPTIONS_MFIRST_POSITION_BADGE_COUNT = null;
    private static final long serialVersionUID = 0;
    public final Integer mfirst_position;
    public final Integer mfirst_position_badge_count;

    public static final class Builder extends com.squareup.wire.Message.Builder<CryptoChatInfo, Builder> {
        public Integer mfirst_position;
        public Integer mfirst_position_badge_count;

        @Override // com.squareup.wire.Message.Builder
        public CryptoChatInfo build() {
            return new CryptoChatInfo(this.mfirst_position, this.mfirst_position_badge_count, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder first_position(Integer r100) {
            this.mfirst_position = r100;
            return this;
        }

        public Builder first_position_badge_count(Integer r100) {
            this.mfirst_position_badge_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CryptoChatInfo extends ProtoAdapter<CryptoChatInfo> {
        public ProtoAdapter_CryptoChatInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CryptoChatInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CryptoChatInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mfirst_position = 0;
            r101.mfirst_position_badge_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mfirst_position = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mfirst_position_badge_count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(CryptoChatInfo r100) {
            Integer r101 = r100.mfirst_position;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mfirst_position_badge_count;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CryptoChatInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CryptoChatInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CryptoChatInfo r101) throws IOException {
            Integer r102 = r101.mfirst_position;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mfirst_position_badge_count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CryptoChatInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CryptoChatInfo();
        FIELD_OPTIONS_MFIRST_POSITION = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MFIRST_POSITION_BADGE_COUNT = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_FIRST_POSITION = 0;
        DEFAULT_FIRST_POSITION_BADGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfirst_position = this.mfirst_position;
        r100.mfirst_position_badge_count = this.mfirst_position_badge_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CryptoChatInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CryptoChatInfo(Integer r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CryptoChatInfo(Integer r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mfirst_position = r100;
        this.mfirst_position_badge_count = r101;
    }
}
