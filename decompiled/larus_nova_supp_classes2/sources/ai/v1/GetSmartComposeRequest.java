package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class GetSmartComposeRequest extends Message<GetSmartComposeRequest, Builder> {
    public static final ProtoAdapter<GetSmartComposeRequest> ADAPTER = null;
    public static final String DEFAULT_CONTEXT = "";
    public static final String DEFAULT_HIDDEN_STATE = "";
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_PREFIX = "";
    public static final Scene DEFAULT_SCENE = null;
    public static final String DEFAULT_SCENE_INFO = "";
    public static final ProtoAdapter_GetSmartComposeRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String context;
    public final List<ContextItem> context_v2;
    public final String hidden_state;
    public final String locale;
    public final ClientMessengerContext messenger_context;
    public final String prefix;
    public final Scene scene;
    public final String scene_info;

    public static final class Builder extends Message.Builder<GetSmartComposeRequest, Builder> implements d<GetSmartComposeRequest> {
        public String context;
        public List<ContextItem> context_v2;
        public String hidden_state;
        public String locale;
        public ClientMessengerContext messenger_context;
        public String prefix;
        public Scene scene;
        public String scene_info;

        public GetSmartComposeRequest build() {
            Scene r0 = this.scene;
            if (r0 == null) goto L9;
            if (this.prefix == null) goto L9;
            return new GetSmartComposeRequest(this.scene, this.prefix, this.context, this.locale, this.hidden_state, this.scene_info, this.context_v2, this.messenger_context, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r0, "scene", this.prefix, "prefix"});
        }

        public Builder() {
            this.context_v2 = Internal.newMutableList();
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m16build() {
            return build();
        }

        public Builder context(String r1) {
            this.context = r1;
            return this;
        }

        public Builder context_v2(List<ContextItem> r1) {
            Internal.checkElementsNotNull(r1);
            this.context_v2 = r1;
            return this;
        }

        public Builder hidden_state(String r1) {
            this.hidden_state = r1;
            return this;
        }

        public Builder locale(String r1) {
            this.locale = r1;
            return this;
        }

        public Builder messenger_context(ClientMessengerContext r1) {
            this.messenger_context = r1;
            return this;
        }

        public Builder prefix(String r1) {
            this.prefix = r1;
            return this;
        }

        public Builder scene(Scene r1) {
            this.scene = r1;
            return this;
        }

        public Builder scene_info(String r1) {
            this.scene_info = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_GetSmartComposeRequest extends ProtoAdapter<GetSmartComposeRequest> implements c<GetSmartComposeRequest> {
        public ProtoAdapter_GetSmartComposeRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSmartComposeRequest.class);
        }

        public GetSmartComposeRequest decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.scene = Scene.UNKNOWN;
            r0.prefix = "";
            r0.context = "";
            r0.locale = "";
            r0.hidden_state = "";
            r0.scene_info = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            switch(r3) {
                case 1: goto L20;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L20:
            r0.scene = (Scene) Scene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.messenger_context = (ClientMessengerContext) ClientMessengerContext.ADAPTER.decode(r9);
            goto L3
        L8:
            r0.context_v2.add((ContextItem) ContextItem.ADAPTER.decode(r9));
            goto L3
        L9:
            r0.scene_info = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            r0.hidden_state = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            r0.locale = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L12:
            r0.context = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L13:
            r0.prefix = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(GetSmartComposeRequest r6) {
            int r0 = Scene.ADAPTER.encodedSizeWithTag(1, r6.scene);
            ProtoAdapter r1 = ProtoAdapter.STRING;
            int r2 = r0 + r1.encodedSizeWithTag(2, r6.prefix);
            String r3 = r6.context;
            int r4 = 0;
            if (r3 == null) goto L5;
            int r5 = r1.encodedSizeWithTag(3, r3);
        L6:
            int r7 = r2 + r5;
            String r8 = r6.locale;
            if (r8 == null) goto L9;
            int r9 = r1.encodedSizeWithTag(4, r8);
        L10:
            int r10 = r7 + r9;
            String r11 = r6.hidden_state;
            if (r11 == null) goto L13;
            int r12 = r1.encodedSizeWithTag(5, r11);
        L14:
            int r13 = r10 + r12;
            String r14 = r6.scene_info;
            if (r14 == null) goto L17;
            int r15 = r1.encodedSizeWithTag(6, r14);
        L18:
            int r16 = (r13 + r15) + ContextItem.ADAPTER.asRepeated().encodedSizeWithTag(7, r6.context_v2);
            ClientMessengerContext r17 = r6.messenger_context;
            if (r17 == null) goto L22;
            r4 = ClientMessengerContext.ADAPTER.encodedSizeWithTag(8, r17);
        L22:
            return (r16 + r4) + r6.unknownFields().size();
        L17:
            r15 = 0;
            goto L18
        L13:
            r12 = 0;
            goto L14
        L9:
            r9 = 0;
            goto L10
        L5:
            r5 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m17decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetSmartComposeRequest) r1);
        }

        public void encode(ProtoWriter r4, GetSmartComposeRequest r5) throws IOException {
            Scene.ADAPTER.encodeWithTag(r4, 1, r5.scene);
            ProtoAdapter r0 = ProtoAdapter.STRING;
            r0.encodeWithTag(r4, 2, r5.prefix);
            String r1 = r5.context;
            if (r1 == null) goto L5;
            r0.encodeWithTag(r4, 3, r1);
        L5:
            String r2 = r5.locale;
            if (r2 == null) goto L8;
            r0.encodeWithTag(r4, 4, r2);
        L8:
            String r3 = r5.hidden_state;
            if (r3 == null) goto L11;
            r0.encodeWithTag(r4, 5, r3);
        L11:
            String r6 = r5.scene_info;
            if (r6 == null) goto L14;
            r0.encodeWithTag(r4, 6, r6);
        L14:
            ContextItem.ADAPTER.asRepeated().encodeWithTag(r4, 7, r5.context_v2);
            ClientMessengerContext r7 = r5.messenger_context;
            if (r7 == null) goto L17;
            ClientMessengerContext.ADAPTER.encodeWithTag(r4, 8, r7);
        L17:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetSmartComposeRequest) r2);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene MESSENGER = null;
        public static final Scene UNKNOWN = null;
        private final int value;

        static {
            Scene r0 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Scene r1 = new Scene("MESSENGER", 1, 1);
            MESSENGER = r1;
            $VALUES = new Scene[]{r0, r1};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return MESSENGER;
        L10:
            return UNKNOWN;
        }

        public static Scene valueOf(String r1) {
            return (Scene) a.a(Scene.class, r1);
        }

        private Scene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
        ProtoAdapter_GetSmartComposeRequest r0 = new ProtoAdapter_GetSmartComposeRequest();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_SCENE = Scene.UNKNOWN;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.scene = this.scene;
        r0.prefix = this.prefix;
        r0.context = this.context;
        r0.locale = this.locale;
        r0.hidden_state = this.hidden_state;
        r0.scene_info = this.scene_info;
        r0.context_v2 = Internal.copyOf("context_v2", this.context_v2);
        r0.messenger_context = this.messenger_context;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetSmartComposeRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m15newBuilder() {
        return newBuilder();
    }

    public GetSmartComposeRequest(Scene r11, String r12, String r13, String r14, String r15, String r16, List<ContextItem> r17, ClientMessengerContext r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public GetSmartComposeRequest(Scene r2, String r3, String r4, String r5, String r6, String r7, List<ContextItem> r8, ClientMessengerContext r9, ByteString r10) {
        super(ADAPTER, r10);
        this.scene = r2;
        this.prefix = r3;
        this.context = r4;
        this.locale = r5;
        this.hidden_state = r6;
        this.scene_info = r7;
        this.context_v2 = Internal.immutableCopyOf("context_v2", r8);
        this.messenger_context = r9;
    }
}
