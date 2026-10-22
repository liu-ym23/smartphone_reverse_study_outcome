package inject_request.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class InjectRequestHandler extends Message<InjectRequestHandler, Builder> {
    public static final ProtoAdapter<InjectRequestHandler> ADAPTER = null;
    public static final RequestHandleAction DEFAULT_ACTION = null;
    public static final String DEFAULT_KEY = "";
    public static final RequestHandleTarget DEFAULT_TARGET = null;
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    public final RequestHandleAction action;
    public final String key;
    public final RequestHandleTarget target;
    public final String value;

    public static final class Builder extends Message.Builder<InjectRequestHandler, Builder> {
        public RequestHandleAction action;
        public String key;
        public RequestHandleTarget target;
        public String value;

        @Override // com.squareup.wire.Message.Builder
        public InjectRequestHandler build() {
            RequestHandleAction r100 = this.action;
            if (r100 == null) goto L11;
            if (this.target == null) goto L11;
            if (this.value == null) goto L11;
            return new InjectRequestHandler(this.action, this.target, this.key, this.value, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "action", this.target, PickerReporterConstants.KEY.TARGET, this.value, "value"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(RequestHandleAction r100) {
            this.action = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder target(RequestHandleTarget r100) {
            this.target = r100;
            return this;
        }

        public Builder value(String r100) {
            this.value = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_InjectRequestHandler extends ProtoAdapter<InjectRequestHandler> {
        public ProtoAdapter_InjectRequestHandler() {
            super(FieldEncoding.LENGTH_DELIMITED, InjectRequestHandler.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InjectRequestHandler decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.action = RequestHandleAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.target = RequestHandleTarget.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.value = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(InjectRequestHandler r100) {
            int r101 = RequestHandleAction.ADAPTER.encodedSizeWithTag(1, r100.action) + RequestHandleTarget.ADAPTER.encodedSizeWithTag(2, r100.target);
            String r102 = r100.key;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
        L7:
            return ((r101 + r103) + ProtoAdapter.STRING.encodedSizeWithTag(4, r100.value)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ InjectRequestHandler decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InjectRequestHandler r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InjectRequestHandler r101) throws IOException {
            RequestHandleAction.ADAPTER.encodeWithTag(r100, 1, r101.action);
            RequestHandleTarget.ADAPTER.encodeWithTag(r100, 2, r101.target);
            String r102 = r101.key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
        L5:
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r101.value);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InjectRequestHandler r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_InjectRequestHandler();
        DEFAULT_ACTION = RequestHandleAction.VAR_REQUEST_HANDLE_ACTION_ADD;
        DEFAULT_TARGET = RequestHandleTarget.VAR_REQUEST_HANDLE_TARGET_HEADER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action = this.action;
        r100.target = this.target;
        r100.key = this.key;
        r100.value = this.value;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InjectRequestHandler.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InjectRequestHandler(RequestHandleAction r100, RequestHandleTarget r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public InjectRequestHandler(RequestHandleAction r100, RequestHandleTarget r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.action = r100;
        this.target = r101;
        this.key = r102;
        this.value = r103;
    }
}
