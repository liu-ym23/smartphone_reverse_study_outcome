package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class MovableRenderAtProperty extends Message<MovableRenderAtProperty, Builder> {
    public static final ProtoAdapter<MovableRenderAtProperty> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Boolean DEFAULT_IS_ANONYMOUS = null;
    public static final Boolean DEFAULT_IS_HIGHLIGHT = null;
    public static final Boolean DEFAULT_IS_OUTER = null;
    public static final String DEFAULT_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final String content;
    public final Boolean is_anonymous;
    public final Boolean is_highlight;
    public final Boolean is_outer;
    public final String user_id;

    public static final class Builder extends Message.Builder<MovableRenderAtProperty, Builder> {
        public String content;
        public Boolean is_anonymous;
        public Boolean is_highlight;
        public Boolean is_outer;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public MovableRenderAtProperty build() {
            String r100 = this.user_id;
            if (r100 == null) goto L9;
            if (this.content == null) goto L9;
            return new MovableRenderAtProperty(this.user_id, this.content, this.is_outer, this.is_anonymous, this.is_highlight, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.content, "content"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder is_anonymous(Boolean r100) {
            this.is_anonymous = r100;
            return this;
        }

        public Builder is_highlight(Boolean r100) {
            this.is_highlight = r100;
            return this;
        }

        public Builder is_outer(Boolean r100) {
            this.is_outer = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MovableRenderAtProperty extends ProtoAdapter<MovableRenderAtProperty> {
        public ProtoAdapter_MovableRenderAtProperty() {
            super(FieldEncoding.LENGTH_DELIMITED, MovableRenderAtProperty.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public MovableRenderAtProperty decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.is_outer = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.is_anonymous = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.is_highlight = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MovableRenderAtProperty r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.user_id) + r101.encodedSizeWithTag(2, r100.content);
            Boolean r103 = r100.is_outer;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_anonymous;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Boolean r110 = r100.is_highlight;
            if (r110 == null) goto L14;
            r104 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MovableRenderAtProperty decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MovableRenderAtProperty r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MovableRenderAtProperty r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.user_id);
            r102.encodeWithTag(r100, 2, r101.content);
            Boolean r103 = r101.is_outer;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L5:
            Boolean r104 = r101.is_anonymous;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L8:
            Boolean r105 = r101.is_highlight;
            if (r105 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MovableRenderAtProperty r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MovableRenderAtProperty();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_OUTER = r100;
        DEFAULT_IS_ANONYMOUS = r100;
        DEFAULT_IS_HIGHLIGHT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.content = this.content;
        r100.is_outer = this.is_outer;
        r100.is_anonymous = this.is_anonymous;
        r100.is_highlight = this.is_highlight;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MovableRenderAtProperty.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MovableRenderAtProperty(String r100, String r101, Boolean r110, Boolean r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public MovableRenderAtProperty(String r100, String r101, Boolean r102, Boolean r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.user_id = r100;
        this.content = r101;
        this.is_outer = r102;
        this.is_anonymous = r103;
        this.is_highlight = r104;
    }
}
