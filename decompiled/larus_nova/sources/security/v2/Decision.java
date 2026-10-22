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
public final class Decision extends Message<Decision, Builder> {
    public static final ProtoAdapter<Decision> ADAPTER = null;
    public static final String DEFAULT_EFFECT = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final List<ConditionalAction> actions;
    public final String effect;

    public static final class Builder extends Message.Builder<Decision, Builder> {
        public List<ConditionalAction> actions;
        public String effect;

        @Override // com.squareup.wire.Message.Builder
        public Decision build() {
            String r100 = this.effect;
            if (r100 == null) goto L7;
            return new Decision(this.effect, this.actions, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "effect"});
        }

        public Builder() {
            this.actions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder actions(List<ConditionalAction> r100) {
            Internal.checkElementsNotNull(r100);
            this.actions = r100;
            return this;
        }

        public Builder effect(String r100) {
            this.effect = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Decision extends ProtoAdapter<Decision> {
        public ProtoAdapter_Decision() {
            super(FieldEncoding.LENGTH_DELIMITED, Decision.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public Decision decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.effect = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.effect = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.actions.add(ConditionalAction.ADAPTER.decode(r100));
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
        public int encodedSize2(Decision r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.effect) + ConditionalAction.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.actions)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Decision decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Decision r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Decision r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.effect);
            ConditionalAction.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.actions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Decision r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Decision();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.effect = this.effect;
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Decision.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Decision(String r100, List<ConditionalAction> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Decision(String r100, List<ConditionalAction> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.effect = r100;
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r101);
    }
}
