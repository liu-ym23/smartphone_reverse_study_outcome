package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AckOnboardingHintRequest extends Message<AckOnboardingHintRequest, Builder> {
    public static final ProtoAdapter<AckOnboardingHintRequest> ADAPTER = null;
    public static final String DEFAULT_CONFIG_KEY = "";
    public static final Long DEFAULT_UID = null;
    public static final FieldOptions FIELD_OPTIONS_MUID = null;
    private static final long serialVersionUID = 0;
    public final String mconfig_key;
    public final Long muid;

    public static final class Builder extends Message.Builder<AckOnboardingHintRequest, Builder> {
        public String mconfig_key;
        public Long muid;

        @Override // com.squareup.wire.Message.Builder
        public AckOnboardingHintRequest build() {
            Long r100 = this.muid;
            if (r100 == null) goto L9;
            if (this.mconfig_key == null) goto L9;
            return new AckOnboardingHintRequest(this.muid, this.mconfig_key, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "muid", this.mconfig_key, "mconfig_key"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder config_key(String r100) {
            this.mconfig_key = r100;
            return this;
        }

        public Builder uid(Long r100) {
            this.muid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AckOnboardingHintRequest extends ProtoAdapter<AckOnboardingHintRequest> {
        public ProtoAdapter_AckOnboardingHintRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, AckOnboardingHintRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AckOnboardingHintRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.muid = 0L;
            r101.mconfig_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.muid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mconfig_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AckOnboardingHintRequest r100) {
            return (ProtoAdapter.INT64.encodedSizeWithTag(1, r100.muid) + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.mconfig_key)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AckOnboardingHintRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AckOnboardingHintRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AckOnboardingHintRequest r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.muid);
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.mconfig_key);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AckOnboardingHintRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AckOnboardingHintRequest();
        FIELD_OPTIONS_MUID = new FieldOptions.Builder().FieldInfo("split,type=user").build();
        DEFAULT_UID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muid = this.muid;
        r100.mconfig_key = this.mconfig_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AckOnboardingHintRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AckOnboardingHintRequest(Long r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public AckOnboardingHintRequest(Long r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.muid = r100;
        this.mconfig_key = r101;
    }
}
