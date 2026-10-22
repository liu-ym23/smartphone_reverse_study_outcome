package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class MovableRenderUrlPreviewInlines extends Message<MovableRenderUrlPreviewInlines, Builder> {
    public static final ProtoAdapter<MovableRenderUrlPreviewInlines> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<MovableRenderUrlPreviewInline> items;

    public static final class Builder extends Message.Builder<MovableRenderUrlPreviewInlines, Builder> {
        public List<MovableRenderUrlPreviewInline> items;

        @Override // com.squareup.wire.Message.Builder
        public MovableRenderUrlPreviewInlines build() {
            return new MovableRenderUrlPreviewInlines(this.items, super.buildUnknownFields());
        }

        public Builder() {
            this.items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder items(List<MovableRenderUrlPreviewInline> r100) {
            Internal.checkElementsNotNull(r100);
            this.items = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MovableRenderUrlPreviewInlines extends ProtoAdapter<MovableRenderUrlPreviewInlines> {
        public ProtoAdapter_MovableRenderUrlPreviewInlines() {
            super(FieldEncoding.LENGTH_DELIMITED, MovableRenderUrlPreviewInlines.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public MovableRenderUrlPreviewInlines decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.items.add(MovableRenderUrlPreviewInline.ADAPTER.decode(r100));
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
        public int encodedSize2(MovableRenderUrlPreviewInlines r100) {
            return MovableRenderUrlPreviewInline.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.items) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MovableRenderUrlPreviewInlines decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MovableRenderUrlPreviewInlines r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MovableRenderUrlPreviewInlines r101) throws IOException {
            MovableRenderUrlPreviewInline.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.items);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MovableRenderUrlPreviewInlines r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MovableRenderUrlPreviewInlines();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.items = Internal.copyOf("items", this.items);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MovableRenderUrlPreviewInlines.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MovableRenderUrlPreviewInlines(List<MovableRenderUrlPreviewInline> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MovableRenderUrlPreviewInlines(List<MovableRenderUrlPreviewInline> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.items = Internal.immutableCopyOf("items", r100);
    }
}
