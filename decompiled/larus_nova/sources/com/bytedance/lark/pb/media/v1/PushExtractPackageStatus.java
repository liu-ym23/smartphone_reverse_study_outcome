package com.bytedance.lark.pb.media.v1;

import com.bytedance.lark.pb.basic.v1.LarkError;
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

/* JADX INFO: loaded from: classes20.dex */
public final class PushExtractPackageStatus extends Message<PushExtractPackageStatus, Builder> {
    public static final ProtoAdapter<PushExtractPackageStatus> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final Float DEFAULT_PROGRESS = null;
    public static final ProtoAdapter_PushExtractPackageStatus RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final LarkError error;
    public final String key;
    public final Float progress;
    public final BrowseFolderResponse result;

    public static final class Builder extends Message.Builder<PushExtractPackageStatus, Builder> implements d<PushExtractPackageStatus> {
        public LarkError error;
        public String key;
        public Float progress;
        public BrowseFolderResponse result;

        @Override // com.squareup.wire.Message.Builder
        public PushExtractPackageStatus build() {
            return new PushExtractPackageStatus(this.key, this.progress, this.result, this.error, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder error(LarkError r100) {
            this.error = r100;
            this.progress = null;
            this.result = null;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder progress(Float r100) {
            this.progress = r100;
            this.result = null;
            this.error = null;
            return this;
        }

        public Builder result(BrowseFolderResponse r100) {
            this.result = r100;
            this.progress = null;
            this.error = null;
            return this;
        }
    }

    public static final class ProtoAdapter_PushExtractPackageStatus extends ProtoAdapter<PushExtractPackageStatus> implements c<PushExtractPackageStatus> {
        public ProtoAdapter_PushExtractPackageStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, PushExtractPackageStatus.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushExtractPackageStatus decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.progress(Float.valueOf(0.0f));
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.progress(ProtoAdapter.FLOAT.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.result(BrowseFolderResponse.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.error(LarkError.ADAPTER.decode(r100));
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
        public int encodedSize2(PushExtractPackageStatus r100) {
            String r101 = r100.key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Float r104 = r100.progress;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            BrowseFolderResponse r107 = r100.result;
            if (r107 == null) goto L13;
            int r108 = BrowseFolderResponse.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            LarkError r110 = r100.error;
            if (r110 == null) goto L18;
            r102 = LarkError.ADAPTER.encodedSizeWithTag(4, r110);
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
        public /* bridge */ /* synthetic */ PushExtractPackageStatus decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushExtractPackageStatus r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushExtractPackageStatus r101) throws IOException {
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Float r103 = r101.progress;
            if (r103 == null) goto L8;
            ProtoAdapter.FLOAT.encodeWithTag(r100, 2, r103);
        L8:
            BrowseFolderResponse r104 = r101.result;
            if (r104 == null) goto L11;
            BrowseFolderResponse.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            LarkError r105 = r101.error;
            if (r105 == null) goto L14;
            LarkError.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushExtractPackageStatus r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushExtractPackageStatus r100 = new ProtoAdapter_PushExtractPackageStatus();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_PROGRESS = Float.valueOf(0.0f);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.progress = this.progress;
        r100.result = this.result;
        r100.error = this.error;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushExtractPackageStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushExtractPackageStatus(String r100, Float r101, BrowseFolderResponse r102, LarkError r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushExtractPackageStatus(String r100, Float r101, BrowseFolderResponse r102, LarkError r103, ByteString r104) {
        super(ADAPTER, r104);
        if (Internal.countNonNull(r101, r102, r103) > 1) goto L7;
        this.key = r100;
        this.progress = r101;
        this.result = r102;
        this.error = r103;
        return;
    L7:
        throw new IllegalArgumentException("at most one of progress, result, error may be non-null");
    }
}
