package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class AppContext extends Message<AppContext, Builder> {
    public static final ProtoAdapter<AppContext> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final OpenPlatformAppType DEFAULT_APP_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final OpenPlatformAppType app_type;

    public static final class Builder extends Message.Builder<AppContext, Builder> {
        public String app_id;
        public OpenPlatformAppType app_type;

        @Override // com.squareup.wire.Message.Builder
        public AppContext build() {
            String r100 = this.app_id;
            if (r100 == null) goto L9;
            if (this.app_type == null) goto L9;
            return new AppContext(this.app_id, this.app_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_id", this.app_type, "app_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder app_type(OpenPlatformAppType r100) {
            this.app_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppContext extends ProtoAdapter<AppContext> {
        public ProtoAdapter_AppContext() {
            super(FieldEncoding.LENGTH_DELIMITED, AppContext.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public AppContext decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.app_type = OpenPlatformAppType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AppContext r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.app_id) + OpenPlatformAppType.ADAPTER.encodedSizeWithTag(2, r100.app_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AppContext decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppContext r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.app_id);
            OpenPlatformAppType.ADAPTER.encodeWithTag(r100, 2, r101.app_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppContext();
        DEFAULT_APP_TYPE = OpenPlatformAppType.VAR_OPEN_PLATFORM_APP_TYPE_GADGET_APP;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.app_type = this.app_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppContext(String r100, OpenPlatformAppType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public AppContext(String r100, OpenPlatformAppType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.app_id = r100;
        this.app_type = r101;
    }
}
