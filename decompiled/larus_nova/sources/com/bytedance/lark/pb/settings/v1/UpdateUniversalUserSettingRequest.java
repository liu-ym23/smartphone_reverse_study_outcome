package com.bytedance.lark.pb.settings.v1;

import com.bytedance.lark.pb.basic.v1.UniversalUserSetting;
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
public final class UpdateUniversalUserSettingRequest extends Message<UpdateUniversalUserSettingRequest, Builder> {
    public static final ProtoAdapter<UpdateUniversalUserSettingRequest> ADAPTER = null;
    public static final ProtoAdapter_UpdateUniversalUserSettingRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UniversalUserSetting> settings;

    public static final class Builder extends Message.Builder<UpdateUniversalUserSettingRequest, Builder> implements d<UpdateUniversalUserSettingRequest> {
        public List<UniversalUserSetting> settings;

        @Override // com.squareup.wire.Message.Builder
        public UpdateUniversalUserSettingRequest build() {
            return new UpdateUniversalUserSettingRequest(this.settings, super.buildUnknownFields());
        }

        public Builder() {
            this.settings = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder settings(List<UniversalUserSetting> r100) {
            Internal.checkElementsNotNull(r100);
            this.settings = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateUniversalUserSettingRequest extends ProtoAdapter<UpdateUniversalUserSettingRequest> implements c<UpdateUniversalUserSettingRequest> {
        public ProtoAdapter_UpdateUniversalUserSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateUniversalUserSettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateUniversalUserSettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.settings.add(UniversalUserSetting.ADAPTER.decode(r100));
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
        public int encodedSize2(UpdateUniversalUserSettingRequest r100) {
            return UniversalUserSetting.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.settings) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateUniversalUserSettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateUniversalUserSettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateUniversalUserSettingRequest r101) throws IOException {
            UniversalUserSetting.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.settings);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateUniversalUserSettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateUniversalUserSettingRequest r100 = new ProtoAdapter_UpdateUniversalUserSettingRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.settings = Internal.copyOf("settings", this.settings);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateUniversalUserSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateUniversalUserSettingRequest(List<UniversalUserSetting> r100) {
        this(r100, ByteString.EMPTY);
    }

    public UpdateUniversalUserSettingRequest(List<UniversalUserSetting> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.settings = Internal.immutableCopyOf("settings", r100);
    }
}
