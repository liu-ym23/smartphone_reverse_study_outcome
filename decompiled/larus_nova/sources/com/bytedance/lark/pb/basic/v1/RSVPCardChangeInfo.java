package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class RSVPCardChangeInfo extends com.squareup.wire.Message<RSVPCardChangeInfo, Builder> {
    public static final ProtoAdapter<RSVPCardChangeInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_LOCATION_CHANGE = null;
    public static final Boolean DEFAULT_IS_RESOURCE_CHANGE = null;
    public static final Boolean DEFAULT_IS_RRULE_CHANGE = null;
    public static final Boolean DEFAULT_IS_TIME_CHANGE = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_location_change;
    public final Boolean is_resource_change;
    public final Boolean is_rrule_change;
    public final Boolean is_time_change;

    public static final class Builder extends com.squareup.wire.Message.Builder<RSVPCardChangeInfo, Builder> {
        public Boolean is_location_change;
        public Boolean is_resource_change;
        public Boolean is_rrule_change;
        public Boolean is_time_change;

        @Override // com.squareup.wire.Message.Builder
        public RSVPCardChangeInfo build() {
            return new RSVPCardChangeInfo(this.is_rrule_change, this.is_time_change, this.is_location_change, this.is_resource_change, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_location_change(Boolean r100) {
            this.is_location_change = r100;
            return this;
        }

        public Builder is_resource_change(Boolean r100) {
            this.is_resource_change = r100;
            return this;
        }

        public Builder is_rrule_change(Boolean r100) {
            this.is_rrule_change = r100;
            return this;
        }

        public Builder is_time_change(Boolean r100) {
            this.is_time_change = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RSVPCardChangeInfo extends ProtoAdapter<RSVPCardChangeInfo> {
        public ProtoAdapter_RSVPCardChangeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, RSVPCardChangeInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RSVPCardChangeInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_rrule_change = r102;
            r101.is_time_change = r102;
            r101.is_location_change = r102;
            r101.is_resource_change = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.is_rrule_change = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.is_time_change = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.is_location_change = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.is_resource_change = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RSVPCardChangeInfo r100) {
            Boolean r101 = r100.is_rrule_change;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_time_change;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_location_change;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_resource_change;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RSVPCardChangeInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RSVPCardChangeInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RSVPCardChangeInfo r101) throws IOException {
            Boolean r102 = r101.is_rrule_change;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_time_change;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_location_change;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.is_resource_change;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RSVPCardChangeInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RSVPCardChangeInfo();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_RRULE_CHANGE = r100;
        DEFAULT_IS_TIME_CHANGE = r100;
        DEFAULT_IS_LOCATION_CHANGE = r100;
        DEFAULT_IS_RESOURCE_CHANGE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_rrule_change = this.is_rrule_change;
        r100.is_time_change = this.is_time_change;
        r100.is_location_change = this.is_location_change;
        r100.is_resource_change = this.is_resource_change;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RSVPCardChangeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public RSVPCardChangeInfo(Boolean r100, Boolean r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public RSVPCardChangeInfo(Boolean r100, Boolean r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.is_rrule_change = r100;
        this.is_time_change = r101;
        this.is_location_change = r102;
        this.is_resource_change = r103;
    }
}
