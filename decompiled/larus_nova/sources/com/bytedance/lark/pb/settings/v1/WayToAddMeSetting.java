package com.bytedance.lark.pb.settings.v1;

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
public final class WayToAddMeSetting extends Message<WayToAddMeSetting, Builder> {
    public static final ProtoAdapter<WayToAddMeSetting> ADAPTER = null;
    public static final Boolean DEFAULT_CHAT_SETTING = null;
    public static final Boolean DEFAULT_CONTACT_TOKEN_SETTING = null;
    private static final long serialVersionUID = 0;
    public final Boolean chat_setting;
    public final Boolean contact_token_setting;
    public final List<WayToAddMeSettingItem> way_to_add_items;

    public static final class Builder extends Message.Builder<WayToAddMeSetting, Builder> {
        public Boolean chat_setting;
        public Boolean contact_token_setting;
        public List<WayToAddMeSettingItem> way_to_add_items;

        @Override // com.squareup.wire.Message.Builder
        public WayToAddMeSetting build() {
            return new WayToAddMeSetting(this.chat_setting, this.contact_token_setting, this.way_to_add_items, super.buildUnknownFields());
        }

        public Builder() {
            this.way_to_add_items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_setting(Boolean r100) {
            this.chat_setting = r100;
            return this;
        }

        public Builder contact_token_setting(Boolean r100) {
            this.contact_token_setting = r100;
            return this;
        }

        public Builder way_to_add_items(List<WayToAddMeSettingItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.way_to_add_items = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_WayToAddMeSetting extends ProtoAdapter<WayToAddMeSetting> {
        public ProtoAdapter_WayToAddMeSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, WayToAddMeSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public WayToAddMeSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.TRUE;
            r101.chat_setting = r102;
            r101.contact_token_setting = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.chat_setting = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.contact_token_setting = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.way_to_add_items.add(WayToAddMeSettingItem.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(WayToAddMeSetting r100) {
            Boolean r101 = r100.chat_setting;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.contact_token_setting;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + WayToAddMeSettingItem.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.way_to_add_items)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ WayToAddMeSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(WayToAddMeSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, WayToAddMeSetting r101) throws IOException {
            Boolean r102 = r101.chat_setting;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.contact_token_setting;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            WayToAddMeSettingItem.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.way_to_add_items);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WayToAddMeSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_WayToAddMeSetting();
        Boolean r100 = Boolean.TRUE;
        DEFAULT_CHAT_SETTING = r100;
        DEFAULT_CONTACT_TOKEN_SETTING = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_setting = this.chat_setting;
        r100.contact_token_setting = this.contact_token_setting;
        r100.way_to_add_items = Internal.copyOf("way_to_add_items", this.way_to_add_items);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return WayToAddMeSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public WayToAddMeSetting(Boolean r100, Boolean r101, List<WayToAddMeSettingItem> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public WayToAddMeSetting(Boolean r100, Boolean r101, List<WayToAddMeSettingItem> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_setting = r100;
        this.contact_token_setting = r101;
        this.way_to_add_items = Internal.immutableCopyOf("way_to_add_items", r102);
    }
}
