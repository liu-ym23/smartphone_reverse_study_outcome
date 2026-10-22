package com.ss.android.lark.pb.users;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.RichText;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PatchUserMemoRequest extends Message<PatchUserMemoRequest, Builder> {
    public static final ProtoAdapter<PatchUserMemoRequest> ADAPTER = null;
    public static final String DEFAULT_ALIAS = "";
    public static final String DEFAULT_MEMO_PICTURE_KEY = "";
    public static final String DEFAULT_MEMO_TEXT = "";
    public static final String DEFAULT_TARGET_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final String malias;
    public final String mmemo_picture_key;
    public final List<String> mmemo_picture_key_v2;
    public final String mmemo_text;
    public final RichText mmemo_text_v2;
    public final String mtarget_user_id;

    public static final class Builder extends Message.Builder<PatchUserMemoRequest, Builder> {
        public String malias;
        public String mmemo_picture_key;
        public List<String> mmemo_picture_key_v2;
        public String mmemo_text;
        public RichText mmemo_text_v2;
        public String mtarget_user_id;

        @Override // com.squareup.wire.Message.Builder
        public PatchUserMemoRequest build() {
            return new PatchUserMemoRequest(this.mtarget_user_id, this.malias, this.mmemo_text, this.mmemo_picture_key, this.mmemo_text_v2, this.mmemo_picture_key_v2, super.buildUnknownFields());
        }

        public Builder() {
            this.mmemo_picture_key_v2 = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder alias(String r100) {
            this.malias = r100;
            return this;
        }

        public Builder memo_picture_key(String r100) {
            this.mmemo_picture_key = r100;
            return this;
        }

        public Builder memo_picture_key_v2(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmemo_picture_key_v2 = r100;
            return this;
        }

        public Builder memo_text(String r100) {
            this.mmemo_text = r100;
            return this;
        }

        public Builder memo_text_v2(RichText r100) {
            this.mmemo_text_v2 = r100;
            return this;
        }

        public Builder target_user_id(String r100) {
            this.mtarget_user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PatchUserMemoRequest extends ProtoAdapter<PatchUserMemoRequest> {
        public ProtoAdapter_PatchUserMemoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PatchUserMemoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PatchUserMemoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtarget_user_id = "";
            r101.malias = "";
            r101.mmemo_text = "";
            r101.mmemo_picture_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.mmemo_picture_key_v2.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            r101.mmemo_text_v2 = RichText.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mmemo_picture_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mmemo_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.malias = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mtarget_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PatchUserMemoRequest r100) {
            String r101 = r100.mtarget_user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.malias;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mmemo_text;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mmemo_picture_key;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            RichText r113 = r100.mmemo_text_v2;
            if (r113 == null) goto L22;
            r102 = RichText.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            return ((r112 + r102) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(6, r100.mmemo_picture_key_v2)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ PatchUserMemoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PatchUserMemoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PatchUserMemoRequest r101) throws IOException {
            String r102 = r101.mtarget_user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.malias;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mmemo_text;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mmemo_picture_key;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            RichText r106 = r101.mmemo_text_v2;
            if (r106 == null) goto L17;
            RichText.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 6, r101.mmemo_picture_key_v2);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PatchUserMemoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PatchUserMemoRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtarget_user_id = this.mtarget_user_id;
        r100.malias = this.malias;
        r100.mmemo_text = this.mmemo_text;
        r100.mmemo_picture_key = this.mmemo_picture_key;
        r100.mmemo_text_v2 = this.mmemo_text_v2;
        r100.mmemo_picture_key_v2 = Internal.copyOf("mmemo_picture_key_v2", this.mmemo_picture_key_v2);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PatchUserMemoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PatchUserMemoRequest(String r100, String r110, String r111, String r112, RichText r113, List<String> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public PatchUserMemoRequest(String r100, String r101, String r102, String r103, RichText r104, List<String> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mtarget_user_id = r100;
        this.malias = r101;
        this.mmemo_text = r102;
        this.mmemo_picture_key = r103;
        this.mmemo_text_v2 = r104;
        this.mmemo_picture_key_v2 = Internal.immutableCopyOf("mmemo_picture_key_v2", r105);
    }
}
