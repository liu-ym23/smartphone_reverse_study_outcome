package com.bytedance.lark.pb.contact.v2;

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
public final class GetAddressBookContactListRequest extends Message<GetAddressBookContactListRequest, Builder> {
    public static final ProtoAdapter<GetAddressBookContactListRequest> ADAPTER = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final Long DEFAULT_TIMELINE_MARK = null;
    public static final ProtoAdapter_GetAddressBookContactListRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> contact_points;
    public final SyncDataStrategy strategy;
    public final Long timeline_mark;

    public static final class Builder extends Message.Builder<GetAddressBookContactListRequest, Builder> implements d<GetAddressBookContactListRequest> {
        public List<String> contact_points;
        public SyncDataStrategy strategy;
        public Long timeline_mark;

        @Override // com.squareup.wire.Message.Builder
        public GetAddressBookContactListRequest build() {
            return new GetAddressBookContactListRequest(this.timeline_mark, this.contact_points, this.strategy, super.buildUnknownFields());
        }

        public Builder() {
            this.contact_points = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder contact_points(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.contact_points = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }

        public Builder timeline_mark(Long r100) {
            this.timeline_mark = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAddressBookContactListRequest extends ProtoAdapter<GetAddressBookContactListRequest> implements c<GetAddressBookContactListRequest> {
        public ProtoAdapter_GetAddressBookContactListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAddressBookContactListRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAddressBookContactListRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.timeline_mark = 0L;
            r101.strategy = SyncDataStrategy.FORCE_SERVER;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.timeline_mark = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.contact_points.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(GetAddressBookContactListRequest r100) {
            Long r101 = r100.timeline_mark;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.contact_points);
            SyncDataStrategy r105 = r100.strategy;
            if (r105 == null) goto L10;
            r102 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetAddressBookContactListRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAddressBookContactListRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAddressBookContactListRequest r101) throws IOException {
            Long r102 = r101.timeline_mark;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.contact_points);
            SyncDataStrategy r103 = r101.strategy;
            if (r103 == null) goto L8;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAddressBookContactListRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAddressBookContactListRequest r100 = new ProtoAdapter_GetAddressBookContactListRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_TIMELINE_MARK = 0L;
        DEFAULT_STRATEGY = SyncDataStrategy.FORCE_SERVER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.timeline_mark = this.timeline_mark;
        r100.contact_points = Internal.copyOf("contact_points", this.contact_points);
        r100.strategy = this.strategy;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAddressBookContactListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAddressBookContactListRequest(Long r100, List<String> r101, SyncDataStrategy r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetAddressBookContactListRequest(Long r100, List<String> r101, SyncDataStrategy r102, ByteString r103) {
        super(ADAPTER, r103);
        this.timeline_mark = r100;
        this.contact_points = Internal.immutableCopyOf("contact_points", r101);
        this.strategy = r102;
    }
}
