package lark_rust_sdk_integrator.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class CommandParam extends Message<CommandParam, Builder> {
    public static final ProtoAdapter<CommandParam> ADAPTER = null;
    public static final String DEFAULT_COMMAND_KEY = "";
    private static final long serialVersionUID = 0;
    public final String command_key;

    public static final class Builder extends Message.Builder<CommandParam, Builder> {
        public String command_key;

        @Override // com.squareup.wire.Message.Builder
        public CommandParam build() {
            String r100 = this.command_key;
            if (r100 == null) goto L7;
            return new CommandParam(this.command_key, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "command_key"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder command_key(String r100) {
            this.command_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CommandParam extends ProtoAdapter<CommandParam> {
        public ProtoAdapter_CommandParam() {
            super(FieldEncoding.LENGTH_DELIMITED, CommandParam.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public CommandParam decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.command_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CommandParam r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.command_key) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CommandParam decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CommandParam r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CommandParam r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.command_key);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CommandParam r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CommandParam();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.command_key = this.command_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CommandParam.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CommandParam(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public CommandParam(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.command_key = r100;
    }
}
