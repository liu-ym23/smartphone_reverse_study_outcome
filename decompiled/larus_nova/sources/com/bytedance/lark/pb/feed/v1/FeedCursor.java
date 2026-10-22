package com.bytedance.lark.pb.feed.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedCursor extends Message<FeedCursor, Builder> {
    public static final ProtoAdapter<FeedCursor> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final Long DEFAULT_RANK_TIME = null;
    public static final FieldOptions FIELD_OPTIONS_ID = null;
    public static final FieldOptions FIELD_OPTIONS_RANK_TIME = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253623id;
    public final Long rank_time;

    public static final class Builder extends Message.Builder<FeedCursor, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253624id;
        public Long rank_time;

        @Override // com.squareup.wire.Message.Builder
        public FeedCursor build() {
            return new FeedCursor(this.rank_time, this.f253624id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(Long r100) {
            this.f253624id = r100;
            return this;
        }

        public Builder rank_time(Long r100) {
            this.rank_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedCursor extends ProtoAdapter<FeedCursor> {
        public ProtoAdapter_FeedCursor() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedCursor.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedCursor decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.rank_time = 0L;
            r101.f253624id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.f253624id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(FeedCursor r100) {
            Long r101 = r100.rank_time;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.f253623id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedCursor decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedCursor r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedCursor r101) throws IOException {
            Long r102 = r101.rank_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.f253623id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedCursor r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedCursor();
        FIELD_OPTIONS_RANK_TIME = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_RANK_TIME = 0L;
        DEFAULT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rank_time = this.rank_time;
        r100.f253624id = this.f253623id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedCursor.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedCursor(Long r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FeedCursor(Long r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.rank_time = r100;
        this.f253623id = r101;
    }
}
