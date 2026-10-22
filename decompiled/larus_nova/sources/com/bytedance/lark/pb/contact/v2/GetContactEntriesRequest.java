package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetContactEntriesRequest extends Message<GetContactEntriesRequest, Builder> {
    public static final ProtoAdapter<GetContactEntriesRequest> ADAPTER = null;
    public static final Scene DEFAULT_SCENE = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final ProtoAdapter_GetContactEntriesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Scene scene;
    public final SyncDataStrategy sync_data_strategy;

    public static final class Builder extends Message.Builder<GetContactEntriesRequest, Builder> implements d<GetContactEntriesRequest> {
        public Scene scene;
        public SyncDataStrategy sync_data_strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetContactEntriesRequest build() {
            return new GetContactEntriesRequest(this.sync_data_strategy, this.scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scene(Scene r100) {
            this.scene = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetContactEntriesRequest extends ProtoAdapter<GetContactEntriesRequest> implements c<GetContactEntriesRequest> {
        public ProtoAdapter_GetContactEntriesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetContactEntriesRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetContactEntriesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.sync_data_strategy = SyncDataStrategy.FORCE_SERVER;
            r101.scene = Scene.CONTACTS;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.scene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(GetContactEntriesRequest r100) {
            SyncDataStrategy r101 = r100.sync_data_strategy;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Scene r104 = r100.scene;
            if (r104 == null) goto L10;
            r102 = Scene.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetContactEntriesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetContactEntriesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetContactEntriesRequest r101) throws IOException {
            SyncDataStrategy r102 = r101.sync_data_strategy;
            if (r102 == null) goto L5;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Scene r103 = r101.scene;
            if (r103 == null) goto L8;
            Scene.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetContactEntriesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene CONTACTS = null;
        public static final Scene PICKER = null;
        private final int value;

        static {
            Scene r100 = new Scene("CONTACTS", 0, 0);
            CONTACTS = r100;
            Scene r101 = new Scene("PICKER", 1, 1);
            PICKER = r101;
            $VALUES = new Scene[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return PICKER;
        L10:
            return CONTACTS;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetContactEntriesRequest r100 = new ProtoAdapter_GetContactEntriesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.FORCE_SERVER;
        DEFAULT_SCENE = Scene.CONTACTS;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetContactEntriesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetContactEntriesRequest(SyncDataStrategy r100, Scene r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetContactEntriesRequest(SyncDataStrategy r100, Scene r101, ByteString r102) {
        super(ADAPTER, r102);
        this.sync_data_strategy = r100;
        this.scene = r101;
    }
}
