package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetContactsDoubaoRequest extends Message<GetContactsDoubaoRequest, Builder> {
    public static final ProtoAdapter<GetContactsDoubaoRequest> ADAPTER = null;
    public static final GetContactsScene DEFAULT_SCENE = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_GetContactsDoubaoRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final GetContactsScene scene;
    public final SyncDataStrategy strategy;

    public static final class Builder extends Message.Builder<GetContactsDoubaoRequest, Builder> implements d<GetContactsDoubaoRequest> {
        public GetContactsScene scene;
        public SyncDataStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetContactsDoubaoRequest build() {
            return new GetContactsDoubaoRequest(this.strategy, this.scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scene(GetContactsScene r100) {
            this.scene = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetContactsDoubaoRequest extends ProtoAdapter<GetContactsDoubaoRequest> implements c<GetContactsDoubaoRequest> {
        public ProtoAdapter_GetContactsDoubaoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetContactsDoubaoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetContactsDoubaoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = SyncDataStrategy.LOCAL;
            r101.scene = GetContactsScene.GET_CONTACTS_SCENE_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 3) goto L8;
            r101.scene = GetContactsScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 4) goto L9;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetContactsDoubaoRequest r100) {
            SyncDataStrategy r101 = r100.strategy;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(4, r101);
        L6:
            GetContactsScene r104 = r100.scene;
            if (r104 == null) goto L10;
            r102 = GetContactsScene.ADAPTER.encodedSizeWithTag(3, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetContactsDoubaoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetContactsDoubaoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetContactsDoubaoRequest r101) throws IOException {
            SyncDataStrategy r102 = r101.strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 4, r102);
        L5:
            GetContactsScene r103 = r101.scene;
            if (r103 == null) goto L8;
            GetContactsScene.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetContactsDoubaoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetContactsDoubaoRequest r100 = new ProtoAdapter_GetContactsDoubaoRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = SyncDataStrategy.LOCAL;
        DEFAULT_SCENE = GetContactsScene.GET_CONTACTS_SCENE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.strategy = this.strategy;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetContactsDoubaoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetContactsDoubaoRequest(SyncDataStrategy r100, GetContactsScene r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetContactsDoubaoRequest(SyncDataStrategy r100, GetContactsScene r101, ByteString r102) {
        super(ADAPTER, r102);
        this.strategy = r100;
        this.scene = r101;
    }
}
