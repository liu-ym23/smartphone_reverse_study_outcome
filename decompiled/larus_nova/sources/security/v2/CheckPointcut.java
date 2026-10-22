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
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class CheckPointcut extends Message<CheckPointcut, Builder> {
    public static final ProtoAdapter<CheckPointcut> ADAPTER = null;
    public static final String DEFAULT_CHECK_CONTEXT = "";
    public static final String DEFAULT_POINTCUT_KEY = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final String check_context;
    public final List<String> factors;
    public final String pointcut_key;

    public static final class Builder extends Message.Builder<CheckPointcut, Builder> {
        public String check_context;
        public List<String> factors;
        public String pointcut_key;

        @Override // com.squareup.wire.Message.Builder
        public CheckPointcut build() {
            String r100 = this.pointcut_key;
            if (r100 == null) goto L9;
            if (this.check_context == null) goto L9;
            return new CheckPointcut(this.pointcut_key, this.check_context, this.factors, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "pointcut_key", this.check_context, "check_context"});
        }

        public Builder() {
            this.factors = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder check_context(String r100) {
            this.check_context = r100;
            return this;
        }

        public Builder factors(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.factors = r100;
            return this;
        }

        public Builder pointcut_key(String r100) {
            this.pointcut_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckPointcut extends ProtoAdapter<CheckPointcut> {
        public ProtoAdapter_CheckPointcut() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckPointcut.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public CheckPointcut decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.pointcut_key = "";
            r101.check_context = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.pointcut_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.check_context = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.factors.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(CheckPointcut r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.pointcut_key) + r101.encodedSizeWithTag(2, r100.check_context)) + r101.asRepeated().encodedSizeWithTag(3, r100.factors)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CheckPointcut decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CheckPointcut r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CheckPointcut r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.pointcut_key);
            r102.encodeWithTag(r100, 2, r101.check_context);
            r102.asRepeated().encodeWithTag(r100, 3, r101.factors);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckPointcut r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckPointcut();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pointcut_key = this.pointcut_key;
        r100.check_context = this.check_context;
        r100.factors = Internal.copyOf("factors", this.factors);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CheckPointcut.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CheckPointcut(String r100, String r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CheckPointcut(String r100, String r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.pointcut_key = r100;
        this.check_context = r101;
        this.factors = Internal.immutableCopyOf("factors", r102);
    }
}
