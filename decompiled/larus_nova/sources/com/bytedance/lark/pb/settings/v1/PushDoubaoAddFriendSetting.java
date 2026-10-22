package com.bytedance.lark.pb.settings.v1;

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
public final class PushDoubaoAddFriendSetting extends Message<PushDoubaoAddFriendSetting, Builder> {
    public static final ProtoAdapter<PushDoubaoAddFriendSetting> ADAPTER = null;
    public static final Long DEFAULT_SERVER_TIMESTAMP = null;
    public static final ProtoAdapter_PushDoubaoAddFriendSetting RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long server_timestamp;
    public final DoubaoAddFriendSetting setting;

    public static final class Builder extends Message.Builder<PushDoubaoAddFriendSetting, Builder> implements d<PushDoubaoAddFriendSetting> {
        public Long server_timestamp;
        public DoubaoAddFriendSetting setting;

        @Override // com.squareup.wire.Message.Builder
        public PushDoubaoAddFriendSetting build() {
            return new PushDoubaoAddFriendSetting(this.setting, this.server_timestamp, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder server_timestamp(Long r100) {
            this.server_timestamp = r100;
            return this;
        }

        public Builder setting(DoubaoAddFriendSetting r100) {
            this.setting = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushDoubaoAddFriendSetting extends ProtoAdapter<PushDoubaoAddFriendSetting> implements c<PushDoubaoAddFriendSetting> {
        public ProtoAdapter_PushDoubaoAddFriendSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, PushDoubaoAddFriendSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushDoubaoAddFriendSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.server_timestamp = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.setting = DoubaoAddFriendSetting.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.server_timestamp = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(PushDoubaoAddFriendSetting r100) {
            DoubaoAddFriendSetting r101 = r100.setting;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DoubaoAddFriendSetting.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.server_timestamp;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushDoubaoAddFriendSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushDoubaoAddFriendSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushDoubaoAddFriendSetting r101) throws IOException {
            DoubaoAddFriendSetting r102 = r101.setting;
            if (r102 == null) goto L5;
            DoubaoAddFriendSetting.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.server_timestamp;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushDoubaoAddFriendSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushDoubaoAddFriendSetting r100 = new ProtoAdapter_PushDoubaoAddFriendSetting();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SERVER_TIMESTAMP = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.setting = this.setting;
        r100.server_timestamp = this.server_timestamp;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushDoubaoAddFriendSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushDoubaoAddFriendSetting(DoubaoAddFriendSetting r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushDoubaoAddFriendSetting(DoubaoAddFriendSetting r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.setting = r100;
        this.server_timestamp = r101;
    }
}
