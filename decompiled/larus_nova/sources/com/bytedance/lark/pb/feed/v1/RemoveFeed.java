package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class RemoveFeed extends Message<RemoveFeed, Builder> {
    public static final ProtoAdapter<RemoveFeed> ADAPTER = null;
    public static final Boolean DEFAULT_CHECK_USER = null;
    public static final Long DEFAULT_FEED_ID = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final Boolean check_user;
    public final Long feed_id;
    public final Long update_time;
    public final Long user_id;

    public static final class Builder extends Message.Builder<RemoveFeed, Builder> {
        public Boolean check_user;
        public Long feed_id;
        public Long update_time;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public RemoveFeed build() {
            return new RemoveFeed(this.feed_id, this.update_time, this.check_user, this.user_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder check_user(Boolean r100) {
            this.check_user = r100;
            return this;
        }

        public Builder feed_id(Long r100) {
            this.feed_id = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RemoveFeed extends ProtoAdapter<RemoveFeed> {
        public ProtoAdapter_RemoveFeed() {
            super(FieldEncoding.LENGTH_DELIMITED, RemoveFeed.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RemoveFeed decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.feed_id = 0L;
            r101.update_time = 0L;
            r101.check_user = Boolean.FALSE;
            r101.user_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.feed_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.check_user = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.user_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(RemoveFeed r100) {
            Long r101 = r100.feed_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.update_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.check_user;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Long r110 = r100.user_id;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ RemoveFeed decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RemoveFeed r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RemoveFeed r101) throws IOException {
            Long r102 = r101.feed_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.update_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.check_user;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Long r105 = r101.user_id;
            if (r105 == null) goto L14;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RemoveFeed r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RemoveFeed();
        DEFAULT_FEED_ID = 0L;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_CHECK_USER = Boolean.FALSE;
        DEFAULT_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_id = this.feed_id;
        r100.update_time = this.update_time;
        r100.check_user = this.check_user;
        r100.user_id = this.user_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RemoveFeed.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RemoveFeed(Long r100, Long r101, Boolean r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public RemoveFeed(Long r100, Long r101, Boolean r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.feed_id = r100;
        this.update_time = r101;
        this.check_user = r102;
        this.user_id = r103;
    }
}
