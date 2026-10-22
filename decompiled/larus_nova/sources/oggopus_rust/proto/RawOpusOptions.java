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
public final class RawOpusOptions extends Message<RawOpusOptions, Builder> {
    public static final ProtoAdapter<RawOpusOptions> ADAPTER = null;
    public static final Integer DEFAULT_BITRATE_BPS = null;
    public static final Integer DEFAULT_CHANNELS = null;
    public static final Integer DEFAULT_FRAME_MS = null;
    public static final Integer DEFAULT_INPUT_RATE_HZ = null;
    private static final long serialVersionUID = 0;
    public final Integer bitrate_bps;
    public final Integer channels;
    public final Integer frame_ms;
    public final Integer input_rate_hz;

    public static final class Builder extends Message.Builder<RawOpusOptions, Builder> {
        public Integer bitrate_bps;
        public Integer channels;
        public Integer frame_ms;
        public Integer input_rate_hz;

        @Override // com.squareup.wire.Message.Builder
        public RawOpusOptions build() {
            Integer r100 = this.bitrate_bps;
            if (r100 == null) goto L13;
            if (this.frame_ms == null) goto L13;
            if (this.channels == null) goto L13;
            if (this.input_rate_hz == null) goto L13;
            return new RawOpusOptions(this.bitrate_bps, this.frame_ms, this.channels, this.input_rate_hz, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "bitrate_bps", this.frame_ms, "frame_ms", this.channels, "channels", this.input_rate_hz, "input_rate_hz"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bitrate_bps(Integer r100) {
            this.bitrate_bps = r100;
            return this;
        }

        public Builder channels(Integer r100) {
            this.channels = r100;
            return this;
        }

        public Builder frame_ms(Integer r100) {
            this.frame_ms = r100;
            return this;
        }

        public Builder input_rate_hz(Integer r100) {
            this.input_rate_hz = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RawOpusOptions extends ProtoAdapter<RawOpusOptions> {
        public ProtoAdapter_RawOpusOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, RawOpusOptions.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public RawOpusOptions decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.bitrate_bps = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.frame_ms = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.channels = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.input_rate_hz = ProtoAdapter.UINT32.decode(r100);
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
        public int encodedSize2(RawOpusOptions r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.UINT32;
            return (((r101.encodedSizeWithTag(1, r100.bitrate_bps) + r101.encodedSizeWithTag(2, r100.frame_ms)) + r101.encodedSizeWithTag(3, r100.channels)) + r101.encodedSizeWithTag(4, r100.input_rate_hz)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RawOpusOptions decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RawOpusOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RawOpusOptions r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.UINT32;
            r102.encodeWithTag(r100, 1, r101.bitrate_bps);
            r102.encodeWithTag(r100, 2, r101.frame_ms);
            r102.encodeWithTag(r100, 3, r101.channels);
            r102.encodeWithTag(r100, 4, r101.input_rate_hz);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RawOpusOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RawOpusOptions();
        DEFAULT_BITRATE_BPS = 0;
        DEFAULT_FRAME_MS = 0;
        DEFAULT_CHANNELS = 0;
        DEFAULT_INPUT_RATE_HZ = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.bitrate_bps = this.bitrate_bps;
        r100.frame_ms = this.frame_ms;
        r100.channels = this.channels;
        r100.input_rate_hz = this.input_rate_hz;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RawOpusOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RawOpusOptions(Integer r100, Integer r101, Integer r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public RawOpusOptions(Integer r100, Integer r101, Integer r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.bitrate_bps = r100;
        this.frame_ms = r101;
        this.channels = r102;
        this.input_rate_hz = r103;
    }
}
