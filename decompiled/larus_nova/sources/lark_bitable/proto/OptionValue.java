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
public final class OptionValue extends Message<OptionValue, Builder> {
    public static final ProtoAdapter<OptionValue> ADAPTER = null;
    public static final String DEFAULT_COLOR = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String color;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f508251id;
    public final String name;

    public static final class Builder extends Message.Builder<OptionValue, Builder> {
        public String color;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f508252id;
        public String name;

        @Override // com.squareup.wire.Message.Builder
        public OptionValue build() {
            String r100 = this.color;
            if (r100 == null) goto L11;
            if (this.f508252id == null) goto L11;
            if (this.name == null) goto L11;
            return new OptionValue(this.color, this.f508252id, this.name, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "color", this.f508252id, "id", this.name, "name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder color(String r100) {
            this.color = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f508252id = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OptionValue extends ProtoAdapter<OptionValue> {
        public ProtoAdapter_OptionValue() {
            super(FieldEncoding.LENGTH_DELIMITED, OptionValue.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public OptionValue decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.f508252id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(OptionValue r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.color) + r101.encodedSizeWithTag(2, r100.f508251id)) + r101.encodedSizeWithTag(3, r100.name)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OptionValue decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OptionValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OptionValue r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.color);
            r102.encodeWithTag(r100, 2, r101.f508251id);
            r102.encodeWithTag(r100, 3, r101.name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OptionValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OptionValue();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.color = this.color;
        r100.f508252id = this.f508251id;
        r100.name = this.name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OptionValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OptionValue(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public OptionValue(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.color = r100;
        this.f508251id = r101;
        this.name = r102;
    }
}
