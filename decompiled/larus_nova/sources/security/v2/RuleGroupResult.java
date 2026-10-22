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
public final class RuleGroupResult extends Message<RuleGroupResult, Builder> {
    public static final ProtoAdapter<RuleGroupResult> ADAPTER = null;
    public static final String DEFAULT_COMBINE_ALGORITHM = "";
    public static final String DEFAULT_EFFECT = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final List<String> actions;
    public final String combine_algorithm;
    public final String effect;

    public static final class Builder extends Message.Builder<RuleGroupResult, Builder> {
        public List<String> actions;
        public String combine_algorithm;
        public String effect;

        @Override // com.squareup.wire.Message.Builder
        public RuleGroupResult build() {
            return new RuleGroupResult(this.effect, this.actions, this.combine_algorithm, super.buildUnknownFields());
        }

        public Builder() {
            this.actions = Internal.newMutableList();
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

        public Builder combine_algorithm(String r100) {
            this.combine_algorithm = r100;
            return this;
        }

        public Builder effect(String r100) {
            this.effect = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RuleGroupResult extends ProtoAdapter<RuleGroupResult> {
        public ProtoAdapter_RuleGroupResult() {
            super(FieldEncoding.LENGTH_DELIMITED, RuleGroupResult.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public RuleGroupResult decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.effect = "";
            r101.combine_algorithm = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.effect = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.actions.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.combine_algorithm = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(RuleGroupResult r100) {
            String r101 = r100.effect;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<String> r104 = ProtoAdapter.STRING;
            int r105 = r103 + r104.asRepeated().encodedSizeWithTag(2, r100.actions);
            String r106 = r100.combine_algorithm;
            if (r106 == null) goto L10;
            r102 = r104.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RuleGroupResult decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RuleGroupResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RuleGroupResult r101) throws IOException {
            String r102 = r101.effect;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.asRepeated().encodeWithTag(r100, 2, r101.actions);
            String r104 = r101.combine_algorithm;
            if (r104 == null) goto L8;
            r103.encodeWithTag(r100, 3, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RuleGroupResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RuleGroupResult();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.effect = this.effect;
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.combine_algorithm = this.combine_algorithm;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RuleGroupResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RuleGroupResult(String r100, List<String> r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public RuleGroupResult(String r100, List<String> r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.effect = r100;
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r101);
        this.combine_algorithm = r102;
    }
}
