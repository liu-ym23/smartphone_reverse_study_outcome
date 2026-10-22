package com.ss.android.lark.pb.ai_topic_stream_search;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TopicInfo extends Message<TopicInfo, Builder> {
    public static final ProtoAdapter<TopicInfo> ADAPTER = null;
    public static final String DEFAULT_ROUND_ID = "";
    public static final String DEFAULT_TOPIC_ID = "";
    private static final long serialVersionUID = 0;
    public final String mround_id;
    public final String mtopic_id;

    public static final class Builder extends Message.Builder<TopicInfo, Builder> {
        public String mround_id;
        public String mtopic_id;

        @Override // com.squareup.wire.Message.Builder
        public TopicInfo build() {
            return new TopicInfo(this.mtopic_id, this.mround_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder round_id(String r100) {
            this.mround_id = r100;
            return this;
        }

        public Builder topic_id(String r100) {
            this.mtopic_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TopicInfo extends ProtoAdapter<TopicInfo> {
        public ProtoAdapter_TopicInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TopicInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TopicInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtopic_id = "";
            r101.mround_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mtopic_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mround_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(TopicInfo r100) {
            String r101 = r100.mtopic_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mround_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TopicInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TopicInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TopicInfo r101) throws IOException {
            String r102 = r101.mtopic_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mround_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TopicInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TopicInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtopic_id = this.mtopic_id;
        r100.mround_id = this.mround_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TopicInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TopicInfo(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TopicInfo(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtopic_id = r100;
        this.mround_id = r101;
    }
}
