package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class OncallMeta extends Message<OncallMeta, Builder> {
    public static final ProtoAdapter<OncallMeta> ADAPTER = null;
    public static final String DEFAULT_FAQ_ID = "";
    public static final String DEFAULT_FAQ_TITLE = "";
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final String mfaq_id;
    public final String mfaq_title;
    public final String mid;
    public final List<Integer> mtags;

    public static final class Builder extends Message.Builder<OncallMeta, Builder> {
        public String mfaq_id;
        public String mfaq_title;
        public String mid;
        public List<Integer> mtags;

        @Override // com.squareup.wire.Message.Builder
        public OncallMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new OncallMeta(this.mid, this.mtags, this.mfaq_id, this.mfaq_title, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
            this.mtags = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder faq_id(String r100) {
            this.mfaq_id = r100;
            return this;
        }

        public Builder faq_title(String r100) {
            this.mfaq_title = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder tags(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtags = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OncallMeta extends ProtoAdapter<OncallMeta> {
        public ProtoAdapter_OncallMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, OncallMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OncallMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mfaq_id = "";
            r101.mfaq_title = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtags.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mfaq_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mfaq_title = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(OncallMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, r100.mtags);
            String r103 = r100.mfaq_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mfaq_title;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(4, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OncallMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OncallMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OncallMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 2, r101.mtags);
            String r103 = r101.mfaq_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.mfaq_title;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OncallMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OncallMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mtags = Internal.copyOf("mtags", this.mtags);
        r100.mfaq_id = this.mfaq_id;
        r100.mfaq_title = this.mfaq_title;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OncallMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OncallMeta(String r100, List<Integer> r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public OncallMeta(String r100, List<Integer> r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mid = r100;
        this.mtags = Internal.immutableCopyOf("mtags", r101);
        this.mfaq_id = r102;
        this.mfaq_title = r103;
    }
}
