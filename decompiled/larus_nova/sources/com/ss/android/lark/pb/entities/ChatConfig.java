package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatConfig extends com.squareup.wire.Message<ChatConfig, Builder> {
    public static final ProtoAdapter<ChatConfig> ADAPTER = null;
    public static final Boolean DEFAULT_CHATABLE = null;
    public static final Boolean DEFAULT_IN_TOTAL_BADGE = null;
    public static final Boolean DEFAULT_MUTEABLE = null;
    private static final long serialVersionUID = 0;
    public final Boolean mchatable;
    public final Boolean min_total_badge;
    public final Boolean mmuteable;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatConfig, Builder> {
        public Boolean mchatable;
        public Boolean min_total_badge;
        public Boolean mmuteable;

        @Override // com.squareup.wire.Message.Builder
        public ChatConfig build() {
            return new ChatConfig(this.mchatable, this.mmuteable, this.min_total_badge, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chatable(Boolean r100) {
            this.mchatable = r100;
            return this;
        }

        public Builder in_total_badge(Boolean r100) {
            this.min_total_badge = r100;
            return this;
        }

        public Builder muteable(Boolean r100) {
            this.mmuteable = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatConfig extends ProtoAdapter<ChatConfig> {
        public ProtoAdapter_ChatConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.TRUE;
            r101.mchatable = r102;
            r101.mmuteable = r102;
            r101.min_total_badge = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.mchatable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mmuteable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.min_total_badge = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ChatConfig r100) {
            Boolean r101 = r100.mchatable;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mmuteable;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.min_total_badge;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatConfig r101) throws IOException {
            Boolean r102 = r101.mchatable;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mmuteable;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.min_total_badge;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatConfig();
        Boolean r100 = Boolean.TRUE;
        DEFAULT_CHATABLE = r100;
        DEFAULT_MUTEABLE = r100;
        DEFAULT_IN_TOTAL_BADGE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchatable = this.mchatable;
        r100.mmuteable = this.mmuteable;
        r100.min_total_badge = this.min_total_badge;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatConfig(Boolean r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ChatConfig(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mchatable = r100;
        this.mmuteable = r101;
        this.min_total_badge = r102;
    }
}
