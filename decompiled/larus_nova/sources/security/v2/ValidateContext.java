package security.v2;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class ValidateContext extends Message<ValidateContext, Builder> {
    public static final ProtoAdapter<ValidateContext> ADAPTER = null;
    public static final String DEFAULT_ENFORCEMENT_ID = "";
    public static final String DEFAULT_ENFORCE_CONTEXT = "";
    public static final String DEFAULT_POINTCUT_KEY = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final String enforce_context;
    public final String enforcement_id;
    public final String pointcut_key;

    public static final class Builder extends Message.Builder<ValidateContext, Builder> {
        public String enforce_context;
        public String enforcement_id;
        public String pointcut_key;

        @Override // com.squareup.wire.Message.Builder
        public ValidateContext build() {
            String r100 = this.pointcut_key;
            if (r100 == null) goto L9;
            if (this.enforce_context == null) goto L9;
            return new ValidateContext(this.pointcut_key, this.enforce_context, this.enforcement_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "pointcut_key", this.enforce_context, "enforce_context"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enforce_context(String r100) {
            this.enforce_context = r100;
            return this;
        }

        public Builder enforcement_id(String r100) {
            this.enforcement_id = r100;
            return this;
        }

        public Builder pointcut_key(String r100) {
            this.pointcut_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ValidateContext extends ProtoAdapter<ValidateContext> {
        public ProtoAdapter_ValidateContext() {
            super(FieldEncoding.LENGTH_DELIMITED, ValidateContext.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ValidateContext decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.pointcut_key = "";
            r101.enforce_context = "";
            r101.enforcement_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.pointcut_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.enforce_context = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.enforcement_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(ValidateContext r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.pointcut_key) + r101.encodedSizeWithTag(2, r100.enforce_context);
            String r103 = r100.enforcement_id;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ValidateContext decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ValidateContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ValidateContext r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.pointcut_key);
            r102.encodeWithTag(r100, 2, r101.enforce_context);
            String r103 = r101.enforcement_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ValidateContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ValidateContext();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pointcut_key = this.pointcut_key;
        r100.enforce_context = this.enforce_context;
        r100.enforcement_id = this.enforcement_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ValidateContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ValidateContext(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ValidateContext(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.pointcut_key = r100;
        this.enforce_context = r101;
        this.enforcement_id = r102;
    }
}
