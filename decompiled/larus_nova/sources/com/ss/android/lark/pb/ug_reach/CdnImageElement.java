package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CdnImageElement extends Message<CdnImageElement, Builder> {
    public static final ProtoAdapter<CdnImageElement> ADAPTER = null;
    public static final ByteString DEFAULT_SECRETS = null;
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final ByteString msecrets;
    public final String murl;

    public static final class Builder extends Message.Builder<CdnImageElement, Builder> {
        public ByteString msecrets;
        public String murl;

        @Override // com.squareup.wire.Message.Builder
        public CdnImageElement build() {
            return new CdnImageElement(this.murl, this.msecrets, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder secrets(ByteString r100) {
            this.msecrets = r100;
            return this;
        }

        public Builder url(String r100) {
            this.murl = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CdnImageElement extends ProtoAdapter<CdnImageElement> {
        public ProtoAdapter_CdnImageElement() {
            super(FieldEncoding.LENGTH_DELIMITED, CdnImageElement.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CdnImageElement decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.murl = "";
            r101.msecrets = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.murl = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.msecrets = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(CdnImageElement r100) {
            String r101 = r100.murl;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ByteString r104 = r100.msecrets;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CdnImageElement decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CdnImageElement r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CdnImageElement r101) throws IOException {
            String r102 = r101.murl;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ByteString r103 = r101.msecrets;
            if (r103 == null) goto L8;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CdnImageElement r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CdnImageElement();
        DEFAULT_SECRETS = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.murl = this.murl;
        r100.msecrets = this.msecrets;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CdnImageElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CdnImageElement(String r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CdnImageElement(String r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.murl = r100;
        this.msecrets = r101;
    }
}
