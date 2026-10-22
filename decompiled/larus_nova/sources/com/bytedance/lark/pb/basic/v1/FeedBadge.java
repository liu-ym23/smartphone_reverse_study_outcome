package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedBadge extends com.squareup.wire.Message<FeedBadge, Builder> {
    public static final ProtoAdapter<FeedBadge> ADAPTER = null;
    public static final Integer DEFAULT_MUTE_BADGE = null;
    public static final Integer DEFAULT_REMIND_BADGE = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Integer mute_badge;
    public final Integer remind_badge;
    public final Long version;

    public static final class Builder extends com.squareup.wire.Message.Builder<FeedBadge, Builder> {
        public Integer mute_badge;
        public Integer remind_badge;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public FeedBadge build() {
            return new FeedBadge(this.remind_badge, this.mute_badge, this.version, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder mute_badge(Integer r100) {
            this.mute_badge = r100;
            return this;
        }

        public Builder remind_badge(Integer r100) {
            this.remind_badge = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedBadge extends ProtoAdapter<FeedBadge> {
        public ProtoAdapter_FeedBadge() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedBadge.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedBadge decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.remind_badge = 0;
            r101.mute_badge = 0;
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.remind_badge = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mute_badge = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.version = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(FeedBadge r100) {
            Integer r101 = r100.remind_badge;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mute_badge;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.version;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedBadge decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedBadge r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedBadge r101) throws IOException {
            Integer r102 = r101.remind_badge;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mute_badge;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.version;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedBadge r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedBadge();
        DEFAULT_REMIND_BADGE = 0;
        DEFAULT_MUTE_BADGE = 0;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.remind_badge = this.remind_badge;
        r100.mute_badge = this.mute_badge;
        r100.version = this.version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedBadge.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedBadge(Integer r100, Integer r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FeedBadge(Integer r100, Integer r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.remind_badge = r100;
        this.mute_badge = r101;
        this.version = r102;
    }
}
