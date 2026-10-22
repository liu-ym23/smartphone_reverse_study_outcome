package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BaikeEntry extends Message<BaikeEntry, Builder> {
    public static final ProtoAdapter<BaikeEntry> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_TEXT_HIGHLIGHTED = "";
    private static final long serialVersionUID = 0;
    public final String mid;
    public final String mtext_highlighted;

    public static final class Builder extends Message.Builder<BaikeEntry, Builder> {
        public String mid;
        public String mtext_highlighted;

        @Override // com.squareup.wire.Message.Builder
        public BaikeEntry build() {
            String r100 = this.mid;
            if (r100 == null) goto L9;
            if (this.mtext_highlighted == null) goto L9;
            return new BaikeEntry(this.mid, this.mtext_highlighted, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid", this.mtext_highlighted, "mtext_highlighted"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder text_highlighted(String r100) {
            this.mtext_highlighted = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BaikeEntry extends ProtoAdapter<BaikeEntry> {
        public ProtoAdapter_BaikeEntry() {
            super(FieldEncoding.LENGTH_DELIMITED, BaikeEntry.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BaikeEntry decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mtext_highlighted = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mtext_highlighted = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(BaikeEntry r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.mid) + r101.encodedSizeWithTag(2, r100.mtext_highlighted)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BaikeEntry decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BaikeEntry r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BaikeEntry r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            r102.encodeWithTag(r100, 2, r101.mtext_highlighted);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BaikeEntry r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BaikeEntry();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mtext_highlighted = this.mtext_highlighted;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BaikeEntry.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BaikeEntry(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public BaikeEntry(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mid = r100;
        this.mtext_highlighted = r101;
    }
}
