package oggopus_rust.proto;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FuncParamsX20ec1c846f59d02f extends Message<FuncParamsX20ec1c846f59d02f, Builder> {
    public static final ProtoAdapter<FuncParamsX20ec1c846f59d02f> ADAPTER = null;
    public static final Double DEFAULT_TO_DURATION = null;
    public static final ByteString DEFAULT__MOLTEN_CTX = null;
    private static final long serialVersionUID = 0;
    public final ByteString _molten_ctx;
    public final Double to_duration;

    public static final class Builder extends Message.Builder<FuncParamsX20ec1c846f59d02f, Builder> {
        public ByteString _molten_ctx;
        public Double to_duration;

        @Override // com.squareup.wire.Message.Builder
        public FuncParamsX20ec1c846f59d02f build() {
            Double r100 = this.to_duration;
            if (r100 == null) goto L7;
            return new FuncParamsX20ec1c846f59d02f(this.to_duration, this._molten_ctx, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "to_duration"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder _molten_ctx(ByteString r100) {
            this._molten_ctx = r100;
            return this;
        }

        public Builder to_duration(Double r100) {
            this.to_duration = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FuncParamsX20ec1c846f59d02f extends ProtoAdapter<FuncParamsX20ec1c846f59d02f> {
        public ProtoAdapter_FuncParamsX20ec1c846f59d02f() {
            super(FieldEncoding.LENGTH_DELIMITED, FuncParamsX20ec1c846f59d02f.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FuncParamsX20ec1c846f59d02f decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.to_duration = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L8:
            if (r103 != 255) goto L9;
            r101._molten_ctx = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(FuncParamsX20ec1c846f59d02f r100) {
            int r101 = ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r100.to_duration);
            ByteString r102 = r100._molten_ctx;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(255, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FuncParamsX20ec1c846f59d02f decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FuncParamsX20ec1c846f59d02f r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FuncParamsX20ec1c846f59d02f r101) throws IOException {
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 1, r101.to_duration);
            ByteString r102 = r101._molten_ctx;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 255, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FuncParamsX20ec1c846f59d02f r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FuncParamsX20ec1c846f59d02f();
        DEFAULT_TO_DURATION = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DEFAULT__MOLTEN_CTX = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.to_duration = this.to_duration;
        r100._molten_ctx = this._molten_ctx;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FuncParamsX20ec1c846f59d02f.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FuncParamsX20ec1c846f59d02f(Double r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FuncParamsX20ec1c846f59d02f(Double r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.to_duration = r100;
        this._molten_ctx = r101;
    }
}
