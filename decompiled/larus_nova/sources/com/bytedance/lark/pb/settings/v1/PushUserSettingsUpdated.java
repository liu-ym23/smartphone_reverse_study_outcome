package com.bytedance.lark.pb.settings.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.a;
import we6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class PushUserSettingsUpdated extends Message<PushUserSettingsUpdated, Builder> {
    public static final ProtoAdapter<PushUserSettingsUpdated> ADAPTER = null;
    public static final Long DEFAULT_USER_ID = null;
    public static final FieldOptions FIELD_OPTIONS_USER_ID = null;
    public static final ProtoAdapter_PushUserSettingsUpdated RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long user_id;

    public static final class Builder extends Message.Builder<PushUserSettingsUpdated, Builder> implements b<PushUserSettingsUpdated> {
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public PushUserSettingsUpdated build() {
            Long r100 = this.user_id;
            if (r100 == null) goto L7;
            return new PushUserSettingsUpdated(this.user_id, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushUserSettingsUpdated extends ProtoAdapter<PushUserSettingsUpdated> implements a<PushUserSettingsUpdated> {
        public ProtoAdapter_PushUserSettingsUpdated() {
            super(FieldEncoding.LENGTH_DELIMITED, PushUserSettingsUpdated.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushUserSettingsUpdated decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.user_id = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(PushUserSettingsUpdated r100) {
            return ProtoAdapter.INT64.encodedSizeWithTag(1, r100.user_id) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushUserSettingsUpdated decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushUserSettingsUpdated r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushUserSettingsUpdated r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.user_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushUserSettingsUpdated r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushUserSettingsUpdated r100 = new ProtoAdapter_PushUserSettingsUpdated();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        FIELD_OPTIONS_USER_ID = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushUserSettingsUpdated.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushUserSettingsUpdated(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushUserSettingsUpdated(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.user_id = r100;
    }
}
