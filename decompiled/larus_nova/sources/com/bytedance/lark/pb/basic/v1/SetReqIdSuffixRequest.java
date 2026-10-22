package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class SetReqIdSuffixRequest extends com.squareup.wire.Message<SetReqIdSuffixRequest, Builder> {
    public static final ProtoAdapter<SetReqIdSuffixRequest> ADAPTER = null;
    public static final String DEFAULT_SUFFIX = "";
    public static final ProtoAdapter_SetReqIdSuffixRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String suffix;

    public static final class Builder extends com.squareup.wire.Message.Builder<SetReqIdSuffixRequest, Builder> implements b<SetReqIdSuffixRequest> {
        public String suffix;

        @Override // com.squareup.wire.Message.Builder
        public SetReqIdSuffixRequest build() {
            String r100 = this.suffix;
            if (r100 == null) goto L7;
            return new SetReqIdSuffixRequest(this.suffix, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "suffix"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder suffix(String r100) {
            this.suffix = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetReqIdSuffixRequest extends ProtoAdapter<SetReqIdSuffixRequest> implements a<SetReqIdSuffixRequest> {
        public ProtoAdapter_SetReqIdSuffixRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetReqIdSuffixRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetReqIdSuffixRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.suffix = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.suffix = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SetReqIdSuffixRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.suffix) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetReqIdSuffixRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetReqIdSuffixRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetReqIdSuffixRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.suffix);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetReqIdSuffixRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetReqIdSuffixRequest r100 = new ProtoAdapter_SetReqIdSuffixRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.suffix = this.suffix;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetReqIdSuffixRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetReqIdSuffixRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetReqIdSuffixRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.suffix = r100;
    }
}
