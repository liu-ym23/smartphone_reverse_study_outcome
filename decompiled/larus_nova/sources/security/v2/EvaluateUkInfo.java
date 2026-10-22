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
public final class EvaluateUkInfo extends Message<EvaluateUkInfo, Builder> {
    public static final ProtoAdapter<EvaluateUkInfo> ADAPTER = null;
    public static final String DEFAULT_EVALUATE_UK = "";
    public static final String DEFAULT_OPERATE_TIME = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final String evaluate_uk;
    public final String operate_time;
    public final List<String> policy_set_keys;

    public static final class Builder extends Message.Builder<EvaluateUkInfo, Builder> {
        public String evaluate_uk;
        public String operate_time;
        public List<String> policy_set_keys;

        @Override // com.squareup.wire.Message.Builder
        public EvaluateUkInfo build() {
            return new EvaluateUkInfo(this.evaluate_uk, this.operate_time, this.policy_set_keys, super.buildUnknownFields());
        }

        public Builder() {
            this.policy_set_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder evaluate_uk(String r100) {
            this.evaluate_uk = r100;
            return this;
        }

        public Builder operate_time(String r100) {
            this.operate_time = r100;
            return this;
        }

        public Builder policy_set_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.policy_set_keys = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EvaluateUkInfo extends ProtoAdapter<EvaluateUkInfo> {
        public ProtoAdapter_EvaluateUkInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, EvaluateUkInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public EvaluateUkInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.evaluate_uk = "";
            r101.operate_time = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.evaluate_uk = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.operate_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.policy_set_keys.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(EvaluateUkInfo r100) {
            String r101 = r100.evaluate_uk;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.operate_time;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.policy_set_keys)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EvaluateUkInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EvaluateUkInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EvaluateUkInfo r101) throws IOException {
            String r102 = r101.evaluate_uk;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.operate_time;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.policy_set_keys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EvaluateUkInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EvaluateUkInfo();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.evaluate_uk = this.evaluate_uk;
        r100.operate_time = this.operate_time;
        r100.policy_set_keys = Internal.copyOf("policy_set_keys", this.policy_set_keys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EvaluateUkInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EvaluateUkInfo(String r100, String r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public EvaluateUkInfo(String r100, String r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.evaluate_uk = r100;
        this.operate_time = r101;
        this.policy_set_keys = Internal.immutableCopyOf("policy_set_keys", r102);
    }
}
