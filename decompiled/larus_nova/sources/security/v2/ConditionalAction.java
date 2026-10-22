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
public final class ConditionalAction extends Message<ConditionalAction, Builder> {
    public static final ProtoAdapter<ConditionalAction> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final List<String> actions;
    public final Condition condition;

    public static final class Builder extends Message.Builder<ConditionalAction, Builder> {
        public List<String> actions;
        public Condition condition;

        @Override // com.squareup.wire.Message.Builder
        public ConditionalAction build() {
            Condition r100 = this.condition;
            if (r100 == null) goto L7;
            return new ConditionalAction(this.condition, this.actions, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "condition"});
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

        public Builder condition(Condition r100) {
            this.condition = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ConditionalAction extends ProtoAdapter<ConditionalAction> {
        public ProtoAdapter_ConditionalAction() {
            super(FieldEncoding.LENGTH_DELIMITED, ConditionalAction.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ConditionalAction decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.condition = Condition.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.actions.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(ConditionalAction r100) {
            return (Condition.ADAPTER.encodedSizeWithTag(1, r100.condition) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.actions)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ConditionalAction decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ConditionalAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ConditionalAction r101) throws IOException {
            Condition.ADAPTER.encodeWithTag(r100, 1, r101.condition);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.actions);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ConditionalAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ConditionalAction();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.condition = this.condition;
        r100.actions = Internal.copyOf(SlcCommonAction.KEY_ACTIONS, this.actions);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ConditionalAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ConditionalAction(Condition r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ConditionalAction(Condition r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.condition = r100;
        this.actions = Internal.immutableCopyOf(SlcCommonAction.KEY_ACTIONS, r101);
    }
}
