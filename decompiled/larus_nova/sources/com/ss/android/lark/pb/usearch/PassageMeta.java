package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PassageMeta extends Message<PassageMeta, Builder> {
    public static final ProtoAdapter<PassageMeta> ADAPTER = null;
    public static final String DEFAULT_EXTRA = "";
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mextra;
    public final String mid;

    public static final class Builder extends Message.Builder<PassageMeta, Builder> {
        public String mextra;
        public String mid;

        @Override // com.squareup.wire.Message.Builder
        public PassageMeta build() {
            return new PassageMeta(this.mid, this.mextra, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder extra(String r100) {
            this.mextra = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PassageMeta extends ProtoAdapter<PassageMeta> {
        public ProtoAdapter_PassageMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, PassageMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PassageMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mextra = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 255) goto L9;
            r101.mextra = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PassageMeta r100) {
            String r101 = r100.mid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mextra;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(255, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PassageMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PassageMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PassageMeta r101) throws IOException {
            String r102 = r101.mid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mextra;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 255, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PassageMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PassageMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mextra = this.mextra;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PassageMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PassageMeta(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PassageMeta(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mid = r100;
        this.mextra = r101;
    }
}
