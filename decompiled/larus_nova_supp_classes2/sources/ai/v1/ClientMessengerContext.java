package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ClientMessengerContext extends Message<ClientMessengerContext, Builder> {
    public static final ProtoAdapter<ClientMessengerContext> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    private static final long serialVersionUID = 0;
    public final String chat_id;

    public static final class Builder extends Message.Builder<ClientMessengerContext, Builder> {
        public String chat_id;

        public ClientMessengerContext build() {
            return new ClientMessengerContext(this.chat_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m1build() {
            return build();
        }

        public Builder chat_id(String r1) {
            this.chat_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ClientMessengerContext extends ProtoAdapter<ClientMessengerContext> {
        public ProtoAdapter_ClientMessengerContext() {
            super(FieldEncoding.LENGTH_DELIMITED, ClientMessengerContext.class);
        }

        public ClientMessengerContext decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.chat_id = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L9;
            if (r3 != 1) goto L7;
            r0.chat_id = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L7:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L9:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(ClientMessengerContext r4) {
            String r0 = r4.chat_id;
            if (r0 == null) goto L5;
            int r1 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L7:
            return r1 + r4.unknownFields().size();
        L5:
            r1 = 0;
            goto L7
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ClientMessengerContext) r1);
        }

        public void encode(ProtoWriter r4, ClientMessengerContext r5) throws IOException {
            String r0 = r5.chat_id;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ClientMessengerContext) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ClientMessengerContext();
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.chat_id = this.chat_id;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ClientMessengerContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m0newBuilder() {
        return newBuilder();
    }

    public ClientMessengerContext(String r2) {
        this(r2, ByteString.EMPTY);
    }

    public ClientMessengerContext(String r2, ByteString r3) {
        super(ADAPTER, r3);
        this.chat_id = r2;
    }
}
