package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class EraseUserDataRequest extends com.squareup.wire.Message<EraseUserDataRequest, Builder> {
    public static final ProtoAdapter<EraseUserDataRequest> ADAPTER = null;
    public static final Boolean DEFAULT_ERASE_ALL = null;
    public static final ProtoAdapter_EraseUserDataRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean erase_all;
    public final EraseUserInfo user_ids;

    public static final class Builder extends com.squareup.wire.Message.Builder<EraseUserDataRequest, Builder> implements b<EraseUserDataRequest> {
        public Boolean erase_all;
        public EraseUserInfo user_ids;

        @Override // com.squareup.wire.Message.Builder
        public EraseUserDataRequest build() {
            return new EraseUserDataRequest(this.erase_all, this.user_ids, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder erase_all(Boolean r100) {
            this.erase_all = r100;
            this.user_ids = null;
            return this;
        }

        public Builder user_ids(EraseUserInfo r100) {
            this.user_ids = r100;
            this.erase_all = null;
            return this;
        }
    }

    public static final class EraseUserInfo extends com.squareup.wire.Message<EraseUserInfo, Builder> {
        public static final ProtoAdapter<EraseUserInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Long> user_ids;

        public static final class Builder extends com.squareup.wire.Message.Builder<EraseUserInfo, Builder> {
            public List<Long> user_ids;

            @Override // com.squareup.wire.Message.Builder
            public EraseUserInfo build() {
                return new EraseUserInfo(this.user_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.user_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder user_ids(List<Long> r100) {
                Internal.checkElementsNotNull(r100);
                this.user_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EraseUserInfo extends ProtoAdapter<EraseUserInfo> {
            public ProtoAdapter_EraseUserInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, EraseUserInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EraseUserInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.user_ids.add(ProtoAdapter.UINT64.decode(r100));
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
            public int encodedSize2(EraseUserInfo r100) {
                return ProtoAdapter.UINT64.asRepeated().encodedSizeWithTag(1, r100.user_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ EraseUserInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EraseUserInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EraseUserInfo r101) throws IOException {
                ProtoAdapter.UINT64.asRepeated().encodeWithTag(r100, 1, r101.user_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EraseUserInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EraseUserInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_ids = Internal.copyOf("user_ids", this.user_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EraseUserInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public EraseUserInfo(List<Long> r100) {
            this(r100, ByteString.EMPTY);
        }

        public EraseUserInfo(List<Long> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.user_ids = Internal.immutableCopyOf("user_ids", r100);
        }
    }

    public static final class ProtoAdapter_EraseUserDataRequest extends ProtoAdapter<EraseUserDataRequest> implements a<EraseUserDataRequest> {
        public ProtoAdapter_EraseUserDataRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, EraseUserDataRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EraseUserDataRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.erase_all(Boolean.FALSE);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.erase_all(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.user_ids(EraseUserInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(EraseUserDataRequest r100) {
            Boolean r101 = r100.erase_all;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            EraseUserInfo r104 = r100.user_ids;
            if (r104 == null) goto L10;
            r102 = EraseUserInfo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EraseUserDataRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EraseUserDataRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EraseUserDataRequest r101) throws IOException {
            Boolean r102 = r101.erase_all;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            EraseUserInfo r103 = r101.user_ids;
            if (r103 == null) goto L8;
            EraseUserInfo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EraseUserDataRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_EraseUserDataRequest r100 = new ProtoAdapter_EraseUserDataRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ERASE_ALL = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.erase_all = this.erase_all;
        r100.user_ids = this.user_ids;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EraseUserDataRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EraseUserDataRequest(Boolean r100, EraseUserInfo r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public EraseUserDataRequest(Boolean r100, EraseUserInfo r101, ByteString r102) {
        super(ADAPTER, r102);
        if (Internal.countNonNull(r100, r101) > 1) goto L7;
        this.erase_all = r100;
        this.user_ids = r101;
        return;
    L7:
        throw new IllegalArgumentException("at most one of erase_all, user_ids may be non-null");
    }
}
