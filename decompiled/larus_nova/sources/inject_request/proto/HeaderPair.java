package inject_request.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class HeaderPair extends Message<HeaderPair, Builder> {
    public static final ProtoAdapter<HeaderPair> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    public final String key;
    public final String value;

    public static final class Builder extends Message.Builder<HeaderPair, Builder> {
        public String key;
        public String value;

        @Override // com.squareup.wire.Message.Builder
        public HeaderPair build() {
            String r100 = this.key;
            if (r100 == null) goto L9;
            if (this.value == null) goto L9;
            return new HeaderPair(this.key, this.value, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.value, "value"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder value(String r100) {
            this.value = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HeaderPair extends ProtoAdapter<HeaderPair> {
        public ProtoAdapter_HeaderPair() {
            super(FieldEncoding.LENGTH_DELIMITED, HeaderPair.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public HeaderPair decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.value = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(HeaderPair r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.key) + r101.encodedSizeWithTag(2, r100.value)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ HeaderPair decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HeaderPair r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HeaderPair r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            r102.encodeWithTag(r100, 2, r101.value);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HeaderPair r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HeaderPair();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.value = this.value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HeaderPair.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HeaderPair(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public HeaderPair(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.key = r100;
        this.value = r101;
    }
}
