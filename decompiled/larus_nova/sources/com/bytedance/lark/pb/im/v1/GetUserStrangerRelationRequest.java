package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetUserStrangerRelationRequest extends Message<GetUserStrangerRelationRequest, Builder> {
    public static final ProtoAdapter<GetUserStrangerRelationRequest> ADAPTER = null;
    public static final SyncStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_GetUserStrangerRelationRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SyncStrategy strategy;
    public final List<Long> user_ids;

    public static final class Builder extends Message.Builder<GetUserStrangerRelationRequest, Builder> implements d<GetUserStrangerRelationRequest> {
        public SyncStrategy strategy;
        public List<Long> user_ids;

        @Override // com.squareup.wire.Message.Builder
        public GetUserStrangerRelationRequest build() {
            return new GetUserStrangerRelationRequest(this.user_ids, this.strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.user_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder strategy(SyncStrategy r100) {
            this.strategy = r100;
            return this;
        }

        public Builder user_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetUserStrangerRelationRequest extends ProtoAdapter<GetUserStrangerRelationRequest> implements c<GetUserStrangerRelationRequest> {
        public ProtoAdapter_GetUserStrangerRelationRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetUserStrangerRelationRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetUserStrangerRelationRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = SyncStrategy.TRY_LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.user_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.strategy = SyncStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(GetUserStrangerRelationRequest r100) {
            int r101 = ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r100.user_ids);
            SyncStrategy r102 = r100.strategy;
            if (r102 == null) goto L5;
            int r103 = SyncStrategy.ADAPTER.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetUserStrangerRelationRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetUserStrangerRelationRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetUserStrangerRelationRequest r101) throws IOException {
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 1, r101.user_ids);
            SyncStrategy r102 = r101.strategy;
            if (r102 == null) goto L5;
            SyncStrategy.ADAPTER.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetUserStrangerRelationRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SyncStrategy extends Enum<SyncStrategy> implements WireEnum {
        private static final /* synthetic */ SyncStrategy[] $VALUES = null;
        public static final ProtoAdapter<SyncStrategy> ADAPTER = null;
        public static final SyncStrategy FORCE_SERVER = null;
        public static final SyncStrategy TRY_LOCAL = null;
        private final int value;

        static {
            SyncStrategy r100 = new SyncStrategy("TRY_LOCAL", 0, 1);
            TRY_LOCAL = r100;
            SyncStrategy r101 = new SyncStrategy("FORCE_SERVER", 1, 2);
            FORCE_SERVER = r101;
            $VALUES = new SyncStrategy[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(SyncStrategy.class);
        }

        public static SyncStrategy[] values() {
            return (SyncStrategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SyncStrategy fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return FORCE_SERVER;
        L11:
            return TRY_LOCAL;
        }

        public static SyncStrategy valueOf(String r100) {
            return (SyncStrategy) a.a(SyncStrategy.class, r100);
        }

        private SyncStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_GetUserStrangerRelationRequest r100 = new ProtoAdapter_GetUserStrangerRelationRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = SyncStrategy.TRY_LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_ids = Internal.copyOf("user_ids", this.user_ids);
        r100.strategy = this.strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetUserStrangerRelationRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetUserStrangerRelationRequest(List<Long> r100, SyncStrategy r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetUserStrangerRelationRequest(List<Long> r100, SyncStrategy r101, ByteString r102) {
        super(ADAPTER, r102);
        this.user_ids = Internal.immutableCopyOf("user_ids", r100);
        this.strategy = r101;
    }
}
