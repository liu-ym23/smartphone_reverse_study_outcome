package com.bytedance.lark.pb.onboarding.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class UserGuideViewAreaPair extends Message<UserGuideViewAreaPair, Builder> {
    public static final ProtoAdapter<UserGuideViewAreaPair> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Area area;
    public final List<UserGuideInfo> ordered_infos;

    public static final class Builder extends Message.Builder<UserGuideViewAreaPair, Builder> {
        public Area area;
        public List<UserGuideInfo> ordered_infos;

        @Override // com.squareup.wire.Message.Builder
        public UserGuideViewAreaPair build() {
            return new UserGuideViewAreaPair(this.area, this.ordered_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.ordered_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder area(Area r100) {
            this.area = r100;
            return this;
        }

        public Builder ordered_infos(List<UserGuideInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.ordered_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserGuideViewAreaPair extends ProtoAdapter<UserGuideViewAreaPair> {
        public ProtoAdapter_UserGuideViewAreaPair() {
            super(FieldEncoding.LENGTH_DELIMITED, UserGuideViewAreaPair.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserGuideViewAreaPair decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.area = Area.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.ordered_infos.add(UserGuideInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(UserGuideViewAreaPair r100) {
            Area r101 = r100.area;
            if (r101 == null) goto L5;
            int r102 = Area.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + UserGuideInfo.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.ordered_infos)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UserGuideViewAreaPair decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserGuideViewAreaPair r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserGuideViewAreaPair r101) throws IOException {
            Area r102 = r101.area;
            if (r102 == null) goto L5;
            Area.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            UserGuideInfo.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.ordered_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserGuideViewAreaPair r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserGuideViewAreaPair();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.area = this.area;
        r100.ordered_infos = Internal.copyOf("ordered_infos", this.ordered_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserGuideViewAreaPair.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserGuideViewAreaPair(Area r100, List<UserGuideInfo> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UserGuideViewAreaPair(Area r100, List<UserGuideInfo> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.area = r100;
        this.ordered_infos = Internal.immutableCopyOf("ordered_infos", r101);
    }
}
