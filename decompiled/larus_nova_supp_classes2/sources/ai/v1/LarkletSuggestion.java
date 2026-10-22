package ai.v1;

import androidx.camera.video.AudioStats;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class LarkletSuggestion extends Message<LarkletSuggestion, Builder> {
    public static final ProtoAdapter<LarkletSuggestion> ADAPTER = null;
    public static final Action DEFAULT_ACTION = null;
    public static final Double DEFAULT_CONFIDENCE = null;
    public static final String DEFAULT_LARKLET_NAME = "";
    private static final long serialVersionUID = 0;
    public final Action action;
    public final Double confidence;
    public final String larklet_name;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action DESTROY = null;
        public static final Action LOAD = null;
        private final int value;

        static {
            Action r0 = new Action("LOAD", 0, 0);
            LOAD = r0;
            Action r1 = new Action("DESTROY", 1, 1);
            DESTROY = r1;
            $VALUES = new Action[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return DESTROY;
        L10:
            return LOAD;
        }

        public static Action valueOf(String r1) {
            return (Action) a.a(Action.class, r1);
        }

        private Action(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class Builder extends Message.Builder<LarkletSuggestion, Builder> {
        public Action action;
        public Double confidence;
        public String larklet_name;

        public LarkletSuggestion build() {
            String r0 = this.larklet_name;
            if (r0 == null) goto L9;
            if (this.action == null) goto L9;
            return new LarkletSuggestion(this.larklet_name, this.action, this.confidence, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "larklet_name", this.action, "action"});
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m22build() {
            return build();
        }

        public Builder action(Action r1) {
            this.action = r1;
            return this;
        }

        public Builder confidence(Double r1) {
            this.confidence = r1;
            return this;
        }

        public Builder larklet_name(String r1) {
            this.larklet_name = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkletSuggestion extends ProtoAdapter<LarkletSuggestion> {
        public ProtoAdapter_LarkletSuggestion() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkletSuggestion.class);
        }

        public LarkletSuggestion decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.larklet_name = "";
            r0.action = Action.LOAD;
            r0.confidence = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.larklet_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.action = (Action) Action.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.confidence = (Double) ProtoAdapter.DOUBLE.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(LarkletSuggestion r5) {
            int r0 = ProtoAdapter.STRING.encodedSizeWithTag(1, r5.larklet_name) + Action.ADAPTER.encodedSizeWithTag(2, r5.action);
            Double r1 = r5.confidence;
            if (r1 == null) goto L5;
            int r2 = ProtoAdapter.DOUBLE.encodedSizeWithTag(3, r1);
        L7:
            return (r0 + r2) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m23decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((LarkletSuggestion) r1);
        }

        public void encode(ProtoWriter r4, LarkletSuggestion r5) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.larklet_name);
            Action.ADAPTER.encodeWithTag(r4, 2, r5.action);
            Double r0 = r5.confidence;
            if (r0 == null) goto L5;
            ProtoAdapter.DOUBLE.encodeWithTag(r4, 3, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (LarkletSuggestion) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkletSuggestion();
        DEFAULT_ACTION = Action.LOAD;
        DEFAULT_CONFIDENCE = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.larklet_name = this.larklet_name;
        r0.action = this.action;
        r0.confidence = this.confidence;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return LarkletSuggestion.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m21newBuilder() {
        return newBuilder();
    }

    public LarkletSuggestion(String r2, Action r3, Double r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public LarkletSuggestion(String r2, Action r3, Double r4, ByteString r5) {
        super(ADAPTER, r5);
        this.larklet_name = r2;
        this.action = r3;
        this.confidence = r4;
    }
}
