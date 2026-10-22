package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class EmptyStateAction extends Message<EmptyStateAction, Builder> {
    public static final ProtoAdapter<EmptyStateAction> ADAPTER = null;
    public static final String DEFAULT_LOCATION = "";
    public static final String DEFAULT_MATERIAL_ID = "";
    public static final String DEFAULT_NOTE_URL = "";
    private static final long serialVersionUID = 0;
    public final EmptyStateType mempty_state_type;
    public final String mlocation;
    public final String mmaterial_id;
    public final String mnote_url;

    public static final class Builder extends Message.Builder<EmptyStateAction, Builder> {
        public EmptyStateType mempty_state_type;
        public String mlocation;
        public String mmaterial_id;
        public String mnote_url;

        @Override // com.squareup.wire.Message.Builder
        public EmptyStateAction build() {
            return new EmptyStateAction(this.mempty_state_type, this.mmaterial_id, this.mnote_url, this.mlocation, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder empty_state_type(EmptyStateType r100) {
            this.mempty_state_type = r100;
            return this;
        }

        public Builder location(String r100) {
            this.mlocation = r100;
            return this;
        }

        public Builder material_id(String r100) {
            this.mmaterial_id = r100;
            return this;
        }

        public Builder note_url(String r100) {
            this.mnote_url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EmptyStateAction extends ProtoAdapter<EmptyStateAction> {
        public ProtoAdapter_EmptyStateAction() {
            super(FieldEncoding.LENGTH_DELIMITED, EmptyStateAction.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EmptyStateAction decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmaterial_id = "";
            r101.mnote_url = "";
            r101.mlocation = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mempty_state_type = EmptyStateType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mmaterial_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mnote_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mlocation = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EmptyStateAction r100) {
            EmptyStateType r101 = r100.mempty_state_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = EmptyStateType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mmaterial_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mnote_url;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mlocation;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ EmptyStateAction decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EmptyStateAction r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EmptyStateAction r101) throws IOException {
            EmptyStateType r102 = r101.mempty_state_type;
            if (r102 == null) goto L5;
            EmptyStateType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mmaterial_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mnote_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mlocation;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmptyStateAction r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EmptyStateAction();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mempty_state_type = this.mempty_state_type;
        r100.mmaterial_id = this.mmaterial_id;
        r100.mnote_url = this.mnote_url;
        r100.mlocation = this.mlocation;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EmptyStateAction.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EmptyStateAction(EmptyStateType r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public EmptyStateAction(EmptyStateType r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mempty_state_type = r100;
        this.mmaterial_id = r101;
        this.mnote_url = r102;
        this.mlocation = r103;
    }
}
