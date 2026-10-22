package oggopus_rust.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class OggOpusEncoderInputInfo extends Message<OggOpusEncoderInputInfo, Builder> {
    public static final ProtoAdapter<OggOpusEncoderInputInfo> ADAPTER = null;
    public static final Long DEFAULT_CHANNELS = null;
    public static final Long DEFAULT_RATE = null;
    private static final long serialVersionUID = 0;
    public final Long channels;
    public final Long rate;

    public static final class Builder extends Message.Builder<OggOpusEncoderInputInfo, Builder> {
        public Long channels;
        public Long rate;

        @Override // com.squareup.wire.Message.Builder
        public OggOpusEncoderInputInfo build() {
            Long r100 = this.rate;
            if (r100 == null) goto L9;
            if (this.channels == null) goto L9;
            return new OggOpusEncoderInputInfo(this.rate, this.channels, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "rate", this.channels, "channels"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channels(Long r100) {
            this.channels = r100;
            return this;
        }

        public Builder rate(Long r100) {
            this.rate = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OggOpusEncoderInputInfo extends ProtoAdapter<OggOpusEncoderInputInfo> {
        public ProtoAdapter_OggOpusEncoderInputInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, OggOpusEncoderInputInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public OggOpusEncoderInputInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.rate = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.channels = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(OggOpusEncoderInputInfo r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return (r101.encodedSizeWithTag(1, r100.rate) + r101.encodedSizeWithTag(2, r100.channels)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OggOpusEncoderInputInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OggOpusEncoderInputInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OggOpusEncoderInputInfo r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.rate);
            r102.encodeWithTag(r100, 2, r101.channels);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OggOpusEncoderInputInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OggOpusEncoderInputInfo();
        DEFAULT_RATE = 0L;
        DEFAULT_CHANNELS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.rate = this.rate;
        r100.channels = this.channels;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OggOpusEncoderInputInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OggOpusEncoderInputInfo(Long r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public OggOpusEncoderInputInfo(Long r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.rate = r100;
        this.channels = r101;
    }
}
