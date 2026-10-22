package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class BannerElement extends Message<BannerElement, Builder> {
    public static final ProtoAdapter<BannerElement> ADAPTER = null;
    public static final String DEFAULT_TRACKING_KEY = "";
    private static final long serialVersionUID = 0;
    public final BannerAction maction;
    public final BannerText mbanner_text;
    public final String mtracking_key;

    public static final class Builder extends Message.Builder<BannerElement, Builder> {
        public BannerAction maction;
        public BannerText mbanner_text;
        public String mtracking_key;

        @Override // com.squareup.wire.Message.Builder
        public BannerElement build() {
            return new BannerElement(this.mbanner_text, this.maction, this.mtracking_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(BannerAction r100) {
            this.maction = r100;
            return this;
        }

        public Builder banner_text(BannerText r100) {
            this.mbanner_text = r100;
            return this;
        }

        public Builder tracking_key(String r100) {
            this.mtracking_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BannerElement extends ProtoAdapter<BannerElement> {
        public ProtoAdapter_BannerElement() {
            super(FieldEncoding.LENGTH_DELIMITED, BannerElement.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BannerElement decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtracking_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mbanner_text = BannerText.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.maction = BannerAction.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mtracking_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(BannerElement r100) {
            BannerText r101 = r100.mbanner_text;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = BannerText.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            BannerAction r104 = r100.maction;
            if (r104 == null) goto L9;
            int r105 = BannerAction.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mtracking_key;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BannerElement decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BannerElement r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BannerElement r101) throws IOException {
            BannerText r102 = r101.mbanner_text;
            if (r102 == null) goto L5;
            BannerText.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            BannerAction r103 = r101.maction;
            if (r103 == null) goto L8;
            BannerAction.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mtracking_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BannerElement r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BannerElement();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mbanner_text = this.mbanner_text;
        r100.maction = this.maction;
        r100.mtracking_key = this.mtracking_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BannerElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BannerElement(BannerText r100, BannerAction r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public BannerElement(BannerText r100, BannerAction r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mbanner_text = r100;
        this.maction = r101;
        this.mtracking_key = r102;
    }
}
