package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class LinkCapsule extends Message<LinkCapsule, Builder> {
    public static final ProtoAdapter<LinkCapsule> ADAPTER = null;
    public static final String DEFAULT_CAPSULE_COLOR = "";
    public static final String DEFAULT_TEXT = "";
    private static final long serialVersionUID = 0;
    public final String capsule_color;
    public final String text;

    public static final class Builder extends Message.Builder<LinkCapsule, Builder> {
        public String capsule_color;
        public String text;

        @Override // com.squareup.wire.Message.Builder
        public LinkCapsule build() {
            String r100 = this.text;
            if (r100 == null) goto L9;
            if (this.capsule_color == null) goto L9;
            return new LinkCapsule(this.text, this.capsule_color, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "text", this.capsule_color, "capsule_color"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder capsule_color(String r100) {
            this.capsule_color = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_LinkCapsule extends ProtoAdapter<LinkCapsule> {
        public ProtoAdapter_LinkCapsule() {
            super(FieldEncoding.LENGTH_DELIMITED, LinkCapsule.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LinkCapsule decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.capsule_color = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(LinkCapsule r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.text) + r101.encodedSizeWithTag(2, r100.capsule_color)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LinkCapsule decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LinkCapsule r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LinkCapsule r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.text);
            r102.encodeWithTag(r100, 2, r101.capsule_color);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LinkCapsule r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LinkCapsule();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.text = this.text;
        r100.capsule_color = this.capsule_color;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LinkCapsule.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LinkCapsule(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public LinkCapsule(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.text = r100;
        this.capsule_color = r101;
    }
}
