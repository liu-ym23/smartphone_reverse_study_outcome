package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class VersionRange extends Message<VersionRange, Builder> {
    public static final ProtoAdapter<VersionRange> ADAPTER = null;
    public static final String DEFAULT_END = "";
    public static final String DEFAULT_START = "";
    private static final long serialVersionUID = 0;
    public final String mend;
    public final String mstart;

    public static final class Builder extends Message.Builder<VersionRange, Builder> {
        public String mend;
        public String mstart;

        @Override // com.squareup.wire.Message.Builder
        public VersionRange build() {
            String r100 = this.mstart;
            if (r100 == null) goto L9;
            if (this.mend == null) goto L9;
            return new VersionRange(this.mstart, this.mend, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mstart", this.mend, "mend"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder end(String r100) {
            this.mend = r100;
            return this;
        }

        public Builder start(String r100) {
            this.mstart = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_VersionRange extends ProtoAdapter<VersionRange> {
        public ProtoAdapter_VersionRange() {
            super(FieldEncoding.LENGTH_DELIMITED, VersionRange.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public VersionRange decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mstart = "";
            r101.mend = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mstart = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mend = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(VersionRange r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.mstart) + r101.encodedSizeWithTag(2, r100.mend)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ VersionRange decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(VersionRange r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, VersionRange r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mstart);
            r102.encodeWithTag(r100, 2, r101.mend);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, VersionRange r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_VersionRange();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstart = this.mstart;
        r100.mend = this.mend;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return VersionRange.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public VersionRange(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public VersionRange(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mstart = r100;
        this.mend = r101;
    }
}
