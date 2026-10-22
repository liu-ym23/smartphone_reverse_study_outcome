package com.bytedance.lark.pb.settings.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DoubaoAddFriendSetting extends Message<DoubaoAddFriendSetting, Builder> {
    public static final ProtoAdapter<DoubaoAddFriendSetting> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, Boolean> way_to_add_friend_items;

    public static final class Builder extends Message.Builder<DoubaoAddFriendSetting, Builder> {
        public Map<Integer, Boolean> way_to_add_friend_items;

        @Override // com.squareup.wire.Message.Builder
        public DoubaoAddFriendSetting build() {
            return new DoubaoAddFriendSetting(this.way_to_add_friend_items, super.buildUnknownFields());
        }

        public Builder() {
            this.way_to_add_friend_items = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder way_to_add_friend_items(Map<Integer, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.way_to_add_friend_items = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DoubaoAddFriendSetting extends ProtoAdapter<DoubaoAddFriendSetting> {
        private final ProtoAdapter<Map<Integer, Boolean>> way_to_add_friend_items;

        public ProtoAdapter_DoubaoAddFriendSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, DoubaoAddFriendSetting.class);
            this.way_to_add_friend_items = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DoubaoAddFriendSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.way_to_add_friend_items.putAll(this.way_to_add_friend_items.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DoubaoAddFriendSetting r100) {
            return this.way_to_add_friend_items.encodedSizeWithTag(1, r100.way_to_add_friend_items) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DoubaoAddFriendSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DoubaoAddFriendSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DoubaoAddFriendSetting r101) throws IOException {
            this.way_to_add_friend_items.encodeWithTag(r100, 1, r101.way_to_add_friend_items);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DoubaoAddFriendSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DoubaoAddFriendSetting();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.way_to_add_friend_items = Internal.copyOf("way_to_add_friend_items", this.way_to_add_friend_items);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DoubaoAddFriendSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DoubaoAddFriendSetting(Map<Integer, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public DoubaoAddFriendSetting(Map<Integer, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.way_to_add_friend_items = Internal.immutableCopyOf("way_to_add_friend_items", r100);
    }
}
