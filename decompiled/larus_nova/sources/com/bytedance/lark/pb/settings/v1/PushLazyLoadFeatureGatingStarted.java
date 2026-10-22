package com.bytedance.lark.pb.settings.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class PushLazyLoadFeatureGatingStarted extends Message<PushLazyLoadFeatureGatingStarted, Builder> {
    public static final ProtoAdapter<PushLazyLoadFeatureGatingStarted> ADAPTER = null;
    public static final String DEFAULT_USER_ID = "";
    public static final ProtoAdapter_PushLazyLoadFeatureGatingStarted RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String user_id;

    public static final class Builder extends Message.Builder<PushLazyLoadFeatureGatingStarted, Builder> implements b<PushLazyLoadFeatureGatingStarted> {
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public PushLazyLoadFeatureGatingStarted build() {
            return new PushLazyLoadFeatureGatingStarted(this.user_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushLazyLoadFeatureGatingStarted extends ProtoAdapter<PushLazyLoadFeatureGatingStarted> implements a<PushLazyLoadFeatureGatingStarted> {
        public ProtoAdapter_PushLazyLoadFeatureGatingStarted() {
            super(FieldEncoding.LENGTH_DELIMITED, PushLazyLoadFeatureGatingStarted.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushLazyLoadFeatureGatingStarted decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushLazyLoadFeatureGatingStarted r100) {
            String r101 = r100.user_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushLazyLoadFeatureGatingStarted decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushLazyLoadFeatureGatingStarted r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushLazyLoadFeatureGatingStarted r101) throws IOException {
            String r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushLazyLoadFeatureGatingStarted r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushLazyLoadFeatureGatingStarted r100 = new ProtoAdapter_PushLazyLoadFeatureGatingStarted();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushLazyLoadFeatureGatingStarted.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushLazyLoadFeatureGatingStarted(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushLazyLoadFeatureGatingStarted(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.user_id = r100;
    }
}
