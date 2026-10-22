package security.v2;

import annotation.OptionsExt;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
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
public final class EnforceResult extends Message<EnforceResult, Builder> {
    public static final ProtoAdapter<EnforceResult> ADAPTER = null;
    public static final String DEFAULT_EFFECT = "";
    public static final Long DEFAULT_ERROR_CODE = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final List<String> actions;
    public final List<PolicySetResult> applied_policy_set_results;
    public final String effect;
    public final Long error_code;

    public static final class Builder extends Message.Builder<EnforceResult, Builder> {
        public List<String> actions;
        public List<PolicySetResult> applied_policy_set_results;
        public String effect;
        public Long error_code;

        @Override // com.squareup.wire.Message.Builder
        public EnforceResult build() {
            String r100 = this.effect;
            if (r100 == null) goto L7;
            return new EnforceResult(this.effect, this.actions, this.error_code, this.applied_policy_set_results, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "effect"});
        }

        public Builder() {
            this.actions = Internal.newMutableList();
            this.applied_policy_set_results = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder actions(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.actions = r100;
            return this;
        }

        public Builder applied_policy_set_results(List<PolicySetResult> r100) {
            Internal.checkElementsNotNull(r100);
            this.applied_policy_set_results = r100;
            return this;
        }

        public Builder effect(String r100) {
            this.effect = r100;
            return this;
        }

        public Builder error_code(Long r100) {
            this.error_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EnforceResult extends ProtoAdapter<EnforceResult> {
        public ProtoAdapter_EnforceResult() {
            super(FieldEncoding.LENGTH_DELIMITED, EnforceResult.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public EnforceResult decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.effect = "";
            r101.error_code = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.effect = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.actions.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.error_code = ProtoAdapter.INT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.applied_policy_set_results.add(PolicySetResult.ADAPTER.decode(r100));
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
        public int encodedSize2(EnforceResult r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.effect) + r101.asRepeated().encodedSizeWithTag(2, r100.actions);
            Long r103 = r100.error_code;
            if (r103 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(3, r103);
        L7:
            return ((r102 + r104) + PolicySetResult.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.applied_policy_set_results)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EnforceResult decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EnforceResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EnforceResult r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.effect);
            r102.asRepeated().encodeWithTag(r100, 2, r101.actions);
            Long r103 = r101.error_code;
            if (r103 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L5:
            PolicySetResult.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.applied_policy_set_results);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnforceResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EnforceResult();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_ERROR_CODE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.effect = this.effect;
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.error_code = this.error_code;
        r100.applied_policy_set_results = Internal.copyOf("applied_policy_set_results", this.applied_policy_set_results);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EnforceResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EnforceResult(String r100, List<String> r101, Long r102, List<PolicySetResult> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public EnforceResult(String r100, List<String> r101, Long r102, List<PolicySetResult> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.effect = r100;
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r101);
        this.error_code = r102;
        this.applied_policy_set_results = Internal.immutableCopyOf("applied_policy_set_results", r103);
    }
}
