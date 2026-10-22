package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.DeniedReason;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetRecentVisitTargetsResponseV2 extends Message<GetRecentVisitTargetsResponseV2, Builder> {
    public static final ProtoAdapter<GetRecentVisitTargetsResponseV2> ADAPTER = null;
    public static final ProtoAdapter_GetRecentVisitTargetsResponseV2 RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, DeniedReason> can_not_select_chatter_map;
    public final List<ForwardCommonData> targets;

    public static final class Builder extends Message.Builder<GetRecentVisitTargetsResponseV2, Builder> implements d<GetRecentVisitTargetsResponseV2> {
        public Map<String, DeniedReason> can_not_select_chatter_map;
        public List<ForwardCommonData> targets;

        @Override // com.squareup.wire.Message.Builder
        public GetRecentVisitTargetsResponseV2 build() {
            return new GetRecentVisitTargetsResponseV2(this.targets, this.can_not_select_chatter_map, super.buildUnknownFields());
        }

        public Builder() {
            this.targets = Internal.newMutableList();
            this.can_not_select_chatter_map = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_not_select_chatter_map(Map<String, DeniedReason> r100) {
            Internal.checkElementsNotNull(r100);
            this.can_not_select_chatter_map = r100;
            return this;
        }

        public Builder targets(List<ForwardCommonData> r100) {
            Internal.checkElementsNotNull(r100);
            this.targets = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetRecentVisitTargetsResponseV2 extends ProtoAdapter<GetRecentVisitTargetsResponseV2> implements c<GetRecentVisitTargetsResponseV2> {
        private final ProtoAdapter<Map<String, DeniedReason>> can_not_select_chatter_map;

        public ProtoAdapter_GetRecentVisitTargetsResponseV2() {
            super(FieldEncoding.LENGTH_DELIMITED, GetRecentVisitTargetsResponseV2.class);
            this.can_not_select_chatter_map = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, DeniedReason.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetRecentVisitTargetsResponseV2 decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.targets.add(ForwardCommonData.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.can_not_select_chatter_map.putAll(this.can_not_select_chatter_map.decode(r100));
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
        public int encodedSize2(GetRecentVisitTargetsResponseV2 r100) {
            return (ForwardCommonData.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.targets) + this.can_not_select_chatter_map.encodedSizeWithTag(2, r100.can_not_select_chatter_map)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetRecentVisitTargetsResponseV2 decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetRecentVisitTargetsResponseV2 r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetRecentVisitTargetsResponseV2 r101) throws IOException {
            ForwardCommonData.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.targets);
            this.can_not_select_chatter_map.encodeWithTag(r100, 2, r101.can_not_select_chatter_map);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetRecentVisitTargetsResponseV2 r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetRecentVisitTargetsResponseV2 r100 = new ProtoAdapter_GetRecentVisitTargetsResponseV2();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.targets = Internal.copyOf("targets", this.targets);
        r100.can_not_select_chatter_map = Internal.copyOf("can_not_select_chatter_map", this.can_not_select_chatter_map);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetRecentVisitTargetsResponseV2.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetRecentVisitTargetsResponseV2(List<ForwardCommonData> r100, Map<String, DeniedReason> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetRecentVisitTargetsResponseV2(List<ForwardCommonData> r100, Map<String, DeniedReason> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.targets = Internal.immutableCopyOf("targets", r100);
        this.can_not_select_chatter_map = Internal.immutableCopyOf("can_not_select_chatter_map", r101);
    }
}
