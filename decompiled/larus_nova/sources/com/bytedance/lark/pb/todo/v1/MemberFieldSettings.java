package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MemberFieldSettings extends Message<MemberFieldSettings, Builder> {
    public static final ProtoAdapter<MemberFieldSettings> ADAPTER = null;
    public static final Boolean DEFAULT_MULTIPLE = null;
    private static final long serialVersionUID = 0;
    public final Boolean multiple;

    public static final class Builder extends Message.Builder<MemberFieldSettings, Builder> {
        public Boolean multiple;

        @Override // com.squareup.wire.Message.Builder
        public MemberFieldSettings build() {
            return new MemberFieldSettings(this.multiple, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder multiple(Boolean r100) {
            this.multiple = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MemberFieldSettings extends ProtoAdapter<MemberFieldSettings> {
        public ProtoAdapter_MemberFieldSettings() {
            super(FieldEncoding.LENGTH_DELIMITED, MemberFieldSettings.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MemberFieldSettings decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.multiple = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.multiple = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(MemberFieldSettings r100) {
            Boolean r101 = r100.multiple;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MemberFieldSettings decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MemberFieldSettings r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MemberFieldSettings r101) throws IOException {
            Boolean r102 = r101.multiple;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MemberFieldSettings r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MemberFieldSettings();
        DEFAULT_MULTIPLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.multiple = this.multiple;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MemberFieldSettings.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MemberFieldSettings(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public MemberFieldSettings(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.multiple = r100;
    }
}
