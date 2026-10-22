package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class HighPriorityDisplay extends Message<HighPriorityDisplay, Builder> {
    public static final ProtoAdapter<HighPriorityDisplay> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_DISPLAY_TIME = null;
    public static final Long DEFAULT_RANK_TIME = null;
    private static final long serialVersionUID = 0;
    public final String content;
    public final Digest digest;
    public final Long display_time;
    public final Long rank_time;

    public static final class Builder extends Message.Builder<HighPriorityDisplay, Builder> {
        public String content;
        public Digest digest;
        public Long display_time;
        public Long rank_time;

        @Override // com.squareup.wire.Message.Builder
        public HighPriorityDisplay build() {
            return new HighPriorityDisplay(this.content, this.rank_time, this.display_time, this.digest, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder digest(Digest r100) {
            this.digest = r100;
            return this;
        }

        public Builder display_time(Long r100) {
            this.display_time = r100;
            return this;
        }

        public Builder rank_time(Long r100) {
            this.rank_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HighPriorityDisplay extends ProtoAdapter<HighPriorityDisplay> {
        public ProtoAdapter_HighPriorityDisplay() {
            super(FieldEncoding.LENGTH_DELIMITED, HighPriorityDisplay.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HighPriorityDisplay decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.content = "";
            r101.rank_time = 0L;
            r101.display_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.display_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.digest = Digest.ADAPTER.decode(r100);
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
        public int encodedSize2(HighPriorityDisplay r100) {
            String r101 = r100.content;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.rank_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.display_time;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Digest r110 = r100.digest;
            if (r110 == null) goto L18;
            r102 = Digest.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ HighPriorityDisplay decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HighPriorityDisplay r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HighPriorityDisplay r101) throws IOException {
            String r102 = r101.content;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.rank_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.display_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            Digest r105 = r101.digest;
            if (r105 == null) goto L14;
            Digest.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HighPriorityDisplay r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HighPriorityDisplay();
        DEFAULT_RANK_TIME = 0L;
        DEFAULT_DISPLAY_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.content = this.content;
        r100.rank_time = this.rank_time;
        r100.display_time = this.display_time;
        r100.digest = this.digest;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HighPriorityDisplay.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HighPriorityDisplay(String r100, Long r101, Long r102, Digest r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public HighPriorityDisplay(String r100, Long r101, Long r102, Digest r103, ByteString r104) {
        super(ADAPTER, r104);
        this.content = r100;
        this.rank_time = r101;
        this.display_time = r102;
        this.digest = r103;
    }
}
