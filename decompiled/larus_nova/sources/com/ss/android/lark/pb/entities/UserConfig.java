package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class UserConfig extends com.squareup.wire.Message<UserConfig, Builder> {
    public static final ProtoAdapter<UserConfig> ADAPTER = null;
    public static final Boolean DEFAULT_PHONE_CALL_ACCESSIBLE = null;
    public static final Boolean DEFAULT_VIDEO_CALL_ACCESSIBLE = null;
    public static final Boolean DEFAULT_VOICE_CALL_ACCESSIBLE = null;
    private static final long serialVersionUID = 0;
    public final AccessibleInfo maccess_phone_call;
    public final AccessibleInfo maccess_urgent;
    public final AccessibleInfo maccess_video_call;
    public final AccessibleInfo maccess_voice_call;
    public final Boolean mphone_call_accessible;
    public final Boolean mvideo_call_accessible;
    public final Boolean mvoice_call_accessible;

    public static final class Builder extends com.squareup.wire.Message.Builder<UserConfig, Builder> {
        public AccessibleInfo maccess_phone_call;
        public AccessibleInfo maccess_urgent;
        public AccessibleInfo maccess_video_call;
        public AccessibleInfo maccess_voice_call;
        public Boolean mphone_call_accessible;
        public Boolean mvideo_call_accessible;
        public Boolean mvoice_call_accessible;

        @Override // com.squareup.wire.Message.Builder
        public UserConfig build() {
            return new UserConfig(this.mphone_call_accessible, this.mvoice_call_accessible, this.mvideo_call_accessible, this.maccess_phone_call, this.maccess_voice_call, this.maccess_video_call, this.maccess_urgent, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder access_phone_call(AccessibleInfo r100) {
            this.maccess_phone_call = r100;
            return this;
        }

        public Builder access_urgent(AccessibleInfo r100) {
            this.maccess_urgent = r100;
            return this;
        }

        public Builder access_video_call(AccessibleInfo r100) {
            this.maccess_video_call = r100;
            return this;
        }

        public Builder access_voice_call(AccessibleInfo r100) {
            this.maccess_voice_call = r100;
            return this;
        }

        public Builder phone_call_accessible(Boolean r100) {
            this.mphone_call_accessible = r100;
            return this;
        }

        public Builder video_call_accessible(Boolean r100) {
            this.mvideo_call_accessible = r100;
            return this;
        }

        public Builder voice_call_accessible(Boolean r100) {
            this.mvoice_call_accessible = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UserConfig extends ProtoAdapter<UserConfig> {
        public ProtoAdapter_UserConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, UserConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UserConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.TRUE;
            r101.mphone_call_accessible = r102;
            r101.mvoice_call_accessible = r102;
            r101.mvideo_call_accessible = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L14;
            switch(r104) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.maccess_urgent = AccessibleInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.maccess_video_call = AccessibleInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.maccess_voice_call = AccessibleInfo.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.maccess_phone_call = AccessibleInfo.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.mvideo_call_accessible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.mvoice_call_accessible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.mphone_call_accessible = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UserConfig r100) {
            Boolean r101 = r100.mphone_call_accessible;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mvoice_call_accessible;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.mvideo_call_accessible;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            AccessibleInfo r110 = r100.maccess_phone_call;
            if (r110 == null) goto L17;
            int r111 = AccessibleInfo.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            AccessibleInfo r113 = r100.maccess_voice_call;
            if (r113 == null) goto L21;
            int r114 = AccessibleInfo.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            AccessibleInfo r116 = r100.maccess_video_call;
            if (r116 == null) goto L25;
            int r117 = AccessibleInfo.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            AccessibleInfo r119 = r100.maccess_urgent;
            if (r119 == null) goto L30;
            r102 = AccessibleInfo.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
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
        public /* bridge */ /* synthetic */ UserConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UserConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UserConfig r101) throws IOException {
            Boolean r102 = r101.mphone_call_accessible;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mvoice_call_accessible;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.mvideo_call_accessible;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            AccessibleInfo r105 = r101.maccess_phone_call;
            if (r105 == null) goto L14;
            AccessibleInfo.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            AccessibleInfo r106 = r101.maccess_voice_call;
            if (r106 == null) goto L17;
            AccessibleInfo.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            AccessibleInfo r107 = r101.maccess_video_call;
            if (r107 == null) goto L20;
            AccessibleInfo.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            AccessibleInfo r108 = r101.maccess_urgent;
            if (r108 == null) goto L23;
            AccessibleInfo.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UserConfig();
        Boolean r100 = Boolean.TRUE;
        DEFAULT_PHONE_CALL_ACCESSIBLE = r100;
        DEFAULT_VOICE_CALL_ACCESSIBLE = r100;
        DEFAULT_VIDEO_CALL_ACCESSIBLE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mphone_call_accessible = this.mphone_call_accessible;
        r100.mvoice_call_accessible = this.mvoice_call_accessible;
        r100.mvideo_call_accessible = this.mvideo_call_accessible;
        r100.maccess_phone_call = this.maccess_phone_call;
        r100.maccess_voice_call = this.maccess_voice_call;
        r100.maccess_video_call = this.maccess_video_call;
        r100.maccess_urgent = this.maccess_urgent;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UserConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public UserConfig(Boolean r110, Boolean r111, Boolean r112, AccessibleInfo r113, AccessibleInfo r114, AccessibleInfo r115, AccessibleInfo r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public UserConfig(Boolean r100, Boolean r101, Boolean r102, AccessibleInfo r103, AccessibleInfo r104, AccessibleInfo r105, AccessibleInfo r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mphone_call_accessible = r100;
        this.mvoice_call_accessible = r101;
        this.mvideo_call_accessible = r102;
        this.maccess_phone_call = r103;
        this.maccess_voice_call = r104;
        this.maccess_video_call = r105;
        this.maccess_urgent = r106;
    }
}
