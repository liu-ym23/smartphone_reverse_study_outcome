package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class SetComposerSettingResponse extends Message<SetComposerSettingResponse, Builder> {
    public static final ProtoAdapter<SetComposerSettingResponse> ADAPTER = null;
    public static final ProtoAdapter_SetComposerSettingResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SetComposerSettingResponse, Builder> implements d<SetComposerSettingResponse> {
        public SetComposerSettingResponse build() {
            return new SetComposerSettingResponse(super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m34build() {
            return build();
        }
    }

    public static final class ProtoAdapter_SetComposerSettingResponse extends ProtoAdapter<SetComposerSettingResponse> implements c<SetComposerSettingResponse> {
        public ProtoAdapter_SetComposerSettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SetComposerSettingResponse.class);
        }

        public SetComposerSettingResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L6;
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L6:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(SetComposerSettingResponse r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m35decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((SetComposerSettingResponse) r1);
        }

        public void encode(ProtoWriter r1, SetComposerSettingResponse r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (SetComposerSettingResponse) r2);
        }
    }

    static {
        ProtoAdapter_SetComposerSettingResponse r0 = new ProtoAdapter_SetComposerSettingResponse();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    public SetComposerSettingResponse() {
        this(ByteString.EMPTY);
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return SetComposerSettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m33newBuilder() {
        return newBuilder();
    }

    public SetComposerSettingResponse(ByteString r2) {
        super(ADAPTER, r2);
    }
}
