package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CoverDownloadInfo extends Message<CoverDownloadInfo, Builder> {
    public static final ProtoAdapter<CoverDownloadInfo> ADAPTER = null;
    public static final Integer DEFAULT_HEIGHT = null;
    public static final String DEFAULT_POLICY = "equal";
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final Integer height;
    public final String policy;
    public final Integer width;

    public static final class Builder extends Message.Builder<CoverDownloadInfo, Builder> {
        public Integer height;
        public String policy;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public CoverDownloadInfo build() {
            Integer r100 = this.width;
            if (r100 == null) goto L11;
            if (this.height == null) goto L11;
            if (this.policy == null) goto L11;
            return new CoverDownloadInfo(this.width, this.height, this.policy, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "width", this.height, "height", this.policy, "policy"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder policy(String r100) {
            this.policy = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CoverDownloadInfo extends ProtoAdapter<CoverDownloadInfo> {
        public ProtoAdapter_CoverDownloadInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CoverDownloadInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CoverDownloadInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.width = 1280;
            r101.height = 1280;
            r101.policy = CoverDownloadInfo.DEFAULT_POLICY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.policy = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CoverDownloadInfo r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return ((r101.encodedSizeWithTag(1, r100.width) + r101.encodedSizeWithTag(2, r100.height)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.policy)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CoverDownloadInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CoverDownloadInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CoverDownloadInfo r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.width);
            r102.encodeWithTag(r100, 2, r101.height);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.policy);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CoverDownloadInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CoverDownloadInfo();
        DEFAULT_WIDTH = 1280;
        DEFAULT_HEIGHT = 1280;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.width = this.width;
        r100.height = this.height;
        r100.policy = this.policy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CoverDownloadInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CoverDownloadInfo(Integer r100, Integer r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CoverDownloadInfo(Integer r100, Integer r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.width = r100;
        this.height = r101;
        this.policy = r102;
    }
}
