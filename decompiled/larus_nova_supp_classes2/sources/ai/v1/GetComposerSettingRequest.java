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
public final class GetComposerSettingRequest extends Message<GetComposerSettingRequest, Builder> {
    public static final ProtoAdapter<GetComposerSettingRequest> ADAPTER = null;
    public static final ProtoAdapter_GetComposerSettingRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<GetComposerSettingRequest, Builder> implements d<GetComposerSettingRequest> {
        public GetComposerSettingRequest build() {
            return new GetComposerSettingRequest(super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m10build() {
            return build();
        }
    }

    public static final class ProtoAdapter_GetComposerSettingRequest extends ProtoAdapter<GetComposerSettingRequest> implements c<GetComposerSettingRequest> {
        public ProtoAdapter_GetComposerSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetComposerSettingRequest.class);
        }

        public GetComposerSettingRequest decode(ProtoReader r7) throws IOException {
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

        public int encodedSize(GetComposerSettingRequest r1) {
            return r1.unknownFields().size();
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m11decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((GetComposerSettingRequest) r1);
        }

        public void encode(ProtoWriter r1, GetComposerSettingRequest r2) throws IOException {
            r1.writeBytes(r2.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (GetComposerSettingRequest) r2);
        }
    }

    static {
        ProtoAdapter_GetComposerSettingRequest r0 = new ProtoAdapter_GetComposerSettingRequest();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
    }

    public GetComposerSettingRequest() {
        this(ByteString.EMPTY);
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return GetComposerSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m9newBuilder() {
        return newBuilder();
    }

    public GetComposerSettingRequest(ByteString r2) {
        super(ADAPTER, r2);
    }
}
