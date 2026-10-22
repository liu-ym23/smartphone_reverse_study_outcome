package lark_rust_sdk_integrator.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class UserForegroundScope extends Message<UserForegroundScope, Builder> {
    public static final ProtoAdapter<UserForegroundScope> ADAPTER = null;
    public static final Long DEFAULT_CONTAINER_ID = null;
    private static final long serialVersionUID = 0;
    public final Long container_id;

    public static final class Builder extends Message.Builder<UserForegroundScope, Builder> {
        public Long container_id;

        @Override // com.squareup.wire.Message.Builder
        public UserForegroundScope build() {
            Long r100 = this.container_id;
            if (r100 == null) goto L7;
            return new UserForegroundScope(this.container_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "container_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_id(Long r100) {
            this.container_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserForegroundScope extends ProtoAdapter<UserForegroundScope> {
        public ProtoAdapter_UserForegroundScope() {
            super(FieldEncoding.LENGTH_DELIMITED, UserForegroundScope.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public UserForegroundScope decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.container_id = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserForegroundScope r100) {
            return ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.container_id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserForegroundScope decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserForegroundScope r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserForegroundScope r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.container_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserForegroundScope r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserForegroundScope();
        DEFAULT_CONTAINER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_id = this.container_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserForegroundScope.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserForegroundScope(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public UserForegroundScope(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.container_id = r100;
    }
}
