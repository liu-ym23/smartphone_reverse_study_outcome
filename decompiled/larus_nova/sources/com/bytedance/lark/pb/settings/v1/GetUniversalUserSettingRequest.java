package com.bytedance.lark.pb.settings.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUniversalUserSettingRequest extends Message<GetUniversalUserSettingRequest, Builder> {
    public static final ProtoAdapter<GetUniversalUserSettingRequest> ADAPTER = null;
    public static final Boolean DEFAULT_NEED_ALL_KEYS = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_GetUniversalUserSettingRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> key;
    public final Boolean need_all_keys;
    public final SyncDataStrategy strategy;

    public static final class Builder extends Message.Builder<GetUniversalUserSettingRequest, Builder> implements d<GetUniversalUserSettingRequest> {
        public List<String> key;
        public Boolean need_all_keys;
        public SyncDataStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetUniversalUserSettingRequest build() {
            return new GetUniversalUserSettingRequest(this.key, this.strategy, this.need_all_keys, super.buildUnknownFields());
        }

        public Builder() {
            this.key = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.key = r100;
            return this;
        }

        public Builder need_all_keys(Boolean r100) {
            this.need_all_keys = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUniversalUserSettingRequest extends ProtoAdapter<GetUniversalUserSettingRequest> implements c<GetUniversalUserSettingRequest> {
        public ProtoAdapter_GetUniversalUserSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUniversalUserSettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUniversalUserSettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = SyncDataStrategy.TRY_LOCAL;
            r101.need_all_keys = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.key.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.need_all_keys = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetUniversalUserSettingRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.key);
            SyncDataStrategy r102 = r100.strategy;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.need_all_keys;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUniversalUserSettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUniversalUserSettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUniversalUserSettingRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.key);
            SyncDataStrategy r102 = r101.strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.need_all_keys;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUniversalUserSettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetUniversalUserSettingRequest r100 = new ProtoAdapter_GetUniversalUserSettingRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = SyncDataStrategy.TRY_LOCAL;
        DEFAULT_NEED_ALL_KEYS = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = Internal.copyOf("key", this.key);
        r100.strategy = this.strategy;
        r100.need_all_keys = this.need_all_keys;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUniversalUserSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUniversalUserSettingRequest(List<String> r100, SyncDataStrategy r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetUniversalUserSettingRequest(List<String> r100, SyncDataStrategy r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.key = Internal.immutableCopyOf("key", r100);
        this.strategy = r101;
        this.need_all_keys = r102;
    }
}
