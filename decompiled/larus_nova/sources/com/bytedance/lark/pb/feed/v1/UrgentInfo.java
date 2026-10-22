package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UrgentInfo extends Message<UrgentInfo, Builder> {
    public static final ProtoAdapter<UrgentInfo> ADAPTER = null;
    public static final Long DEFAULT_DISPLAY_TIME = null;
    public static final Long DEFAULT_RANK_TIME = null;
    public static final String DEFAULT_URGENT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final Long display_time;
    public final Long rank_time;
    public final String urgent_content;

    public static final class Builder extends Message.Builder<UrgentInfo, Builder> {
        public Long display_time;
        public Long rank_time;
        public String urgent_content;

        @Override // com.squareup.wire.Message.Builder
        public UrgentInfo build() {
            return new UrgentInfo(this.rank_time, this.display_time, this.urgent_content, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder display_time(Long r100) {
            this.display_time = r100;
            return this;
        }

        public Builder rank_time(Long r100) {
            this.rank_time = r100;
            return this;
        }

        public Builder urgent_content(String r100) {
            this.urgent_content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UrgentInfo extends ProtoAdapter<UrgentInfo> {
        public ProtoAdapter_UrgentInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, UrgentInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UrgentInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.rank_time = 0L;
            r101.display_time = 0L;
            r101.urgent_content = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.display_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.urgent_content = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(UrgentInfo r100) {
            Long r101 = r100.rank_time;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.display_time;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.urgent_content;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ UrgentInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UrgentInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UrgentInfo r101) throws IOException {
            Long r102 = r101.rank_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.display_time;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.urgent_content;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UrgentInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UrgentInfo();
        DEFAULT_RANK_TIME = 0L;
        DEFAULT_DISPLAY_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rank_time = this.rank_time;
        r100.display_time = this.display_time;
        r100.urgent_content = this.urgent_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UrgentInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UrgentInfo(Long r100, Long r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UrgentInfo(Long r100, Long r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.rank_time = r100;
        this.display_time = r101;
        this.urgent_content = r102;
    }
}
