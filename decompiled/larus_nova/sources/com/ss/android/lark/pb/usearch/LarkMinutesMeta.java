package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Icon;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class LarkMinutesMeta extends Message<LarkMinutesMeta, Builder> {
    public static final ProtoAdapter<LarkMinutesMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_URI = "";
    private static final long serialVersionUID = 0;
    public final Icon micon;
    public final String mid;
    public final String muri;

    public static final class Builder extends Message.Builder<LarkMinutesMeta, Builder> {
        public Icon micon;
        public String mid;
        public String muri;

        @Override // com.squareup.wire.Message.Builder
        public LarkMinutesMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new LarkMinutesMeta(this.mid, this.muri, this.micon, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder icon(Icon r100) {
            this.micon = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder uri(String r100) {
            this.muri = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkMinutesMeta extends ProtoAdapter<LarkMinutesMeta> {
        public ProtoAdapter_LarkMinutesMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkMinutesMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LarkMinutesMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.muri = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.muri = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L11;
            r101.micon = Icon.ADAPTER.decode(r100);
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
        public int encodedSize2(LarkMinutesMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            String r103 = r100.muri;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Icon r107 = r100.micon;
            if (r107 == null) goto L10;
            r104 = Icon.ADAPTER.encodedSizeWithTag(4, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkMinutesMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkMinutesMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkMinutesMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            String r103 = r101.muri;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            Icon r104 = r101.micon;
            if (r104 == null) goto L8;
            Icon.ADAPTER.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkMinutesMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkMinutesMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.muri = this.muri;
        r100.micon = this.micon;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkMinutesMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkMinutesMeta(String r100, String r101, Icon r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public LarkMinutesMeta(String r100, String r101, Icon r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mid = r100;
        this.muri = r101;
        this.micon = r102;
    }
}
