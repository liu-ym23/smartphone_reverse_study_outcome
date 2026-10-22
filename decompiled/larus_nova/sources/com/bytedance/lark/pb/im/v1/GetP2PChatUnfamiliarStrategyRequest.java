package com.bytedance.lark.pb.im.v1;

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
public final class GetP2PChatUnfamiliarStrategyRequest extends Message<GetP2PChatUnfamiliarStrategyRequest, Builder> {
    public static final ProtoAdapter<GetP2PChatUnfamiliarStrategyRequest> ADAPTER = null;
    public static final SyncStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_GetP2PChatUnfamiliarStrategyRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SyncStrategy strategy;

    public static final class Builder extends Message.Builder<GetP2PChatUnfamiliarStrategyRequest, Builder> implements d<GetP2PChatUnfamiliarStrategyRequest> {
        public SyncStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public GetP2PChatUnfamiliarStrategyRequest build() {
            return new GetP2PChatUnfamiliarStrategyRequest(this.strategy, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder strategy(SyncStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetP2PChatUnfamiliarStrategyRequest extends ProtoAdapter<GetP2PChatUnfamiliarStrategyRequest> implements c<GetP2PChatUnfamiliarStrategyRequest> {
        public ProtoAdapter_GetP2PChatUnfamiliarStrategyRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetP2PChatUnfamiliarStrategyRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetP2PChatUnfamiliarStrategyRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.strategy = SyncStrategy.TRY_LOCAL;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.strategy = SyncStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetP2PChatUnfamiliarStrategyRequest r100) {
            SyncStrategy r101 = r100.strategy;
            if (r101 == null) goto L5;
            int r102 = SyncStrategy.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetP2PChatUnfamiliarStrategyRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetP2PChatUnfamiliarStrategyRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetP2PChatUnfamiliarStrategyRequest r101) throws IOException {
            SyncStrategy r102 = r101.strategy;
            if (r102 == null) goto L5;
            SyncStrategy.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetP2PChatUnfamiliarStrategyRequest r101) throws IOException {
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
        ProtoAdapter_GetP2PChatUnfamiliarStrategyRequest r100 = new ProtoAdapter_GetP2PChatUnfamiliarStrategyRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STRATEGY = SyncStrategy.TRY_LOCAL;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.strategy = this.strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetP2PChatUnfamiliarStrategyRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetP2PChatUnfamiliarStrategyRequest(SyncStrategy r100) {
        this(r100, ByteString.EMPTY);
    }

    public GetP2PChatUnfamiliarStrategyRequest(SyncStrategy r100, ByteString r101) {
        super(ADAPTER, r101);
        this.strategy = r100;
    }
}
