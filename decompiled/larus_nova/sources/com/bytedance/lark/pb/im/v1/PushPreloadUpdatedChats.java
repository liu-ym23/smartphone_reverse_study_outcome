package com.bytedance.lark.pb.im.v1;

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
public final class PushPreloadUpdatedChats extends Message<PushPreloadUpdatedChats, Builder> {
    public static final ProtoAdapter<PushPreloadUpdatedChats> ADAPTER = null;
    public static final ProtoAdapter_PushPreloadUpdatedChats RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<UpdatedItem> updated_items;

    public static final class Builder extends Message.Builder<PushPreloadUpdatedChats, Builder> implements d<PushPreloadUpdatedChats> {
        public List<UpdatedItem> updated_items;

        @Override // com.squareup.wire.Message.Builder
        public PushPreloadUpdatedChats build() {
            return new PushPreloadUpdatedChats(this.updated_items, super.buildUnknownFields());
        }

        public Builder() {
            this.updated_items = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder updated_items(List<UpdatedItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.updated_items = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushPreloadUpdatedChats extends ProtoAdapter<PushPreloadUpdatedChats> implements c<PushPreloadUpdatedChats> {
        public ProtoAdapter_PushPreloadUpdatedChats() {
            super(FieldEncoding.LENGTH_DELIMITED, PushPreloadUpdatedChats.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushPreloadUpdatedChats decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.updated_items.add(UpdatedItem.ADAPTER.decode(r100));
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
        public int encodedSize2(PushPreloadUpdatedChats r100) {
            return UpdatedItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.updated_items) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushPreloadUpdatedChats decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushPreloadUpdatedChats r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushPreloadUpdatedChats r101) throws IOException {
            UpdatedItem.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.updated_items);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushPreloadUpdatedChats r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class UpdatedItem extends Message<UpdatedItem, Builder> {
        public static final ProtoAdapter<UpdatedItem> ADAPTER = null;
        public static final String DEFAULT_ITEM_ID = "";
        private static final long serialVersionUID = 0;
        public final String item_id;

        public static final class Builder extends Message.Builder<UpdatedItem, Builder> {
            public String item_id;

            @Override // com.squareup.wire.Message.Builder
            public UpdatedItem build() {
                String r100 = this.item_id;
                if (r100 == null) goto L7;
                return new UpdatedItem(this.item_id, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "item_id"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder item_id(String r100) {
                this.item_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UpdatedItem extends ProtoAdapter<UpdatedItem> {
            public ProtoAdapter_UpdatedItem() {
                super(FieldEncoding.LENGTH_DELIMITED, UpdatedItem.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UpdatedItem decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.item_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.item_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(UpdatedItem r100) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.item_id) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UpdatedItem decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UpdatedItem r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UpdatedItem r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.item_id);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdatedItem r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UpdatedItem();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.item_id = this.item_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UpdatedItem.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UpdatedItem(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public UpdatedItem(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.item_id = r100;
        }
    }

    static {
        ProtoAdapter_PushPreloadUpdatedChats r100 = new ProtoAdapter_PushPreloadUpdatedChats();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.updated_items = Internal.copyOf("updated_items", this.updated_items);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushPreloadUpdatedChats.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushPreloadUpdatedChats(List<UpdatedItem> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushPreloadUpdatedChats(List<UpdatedItem> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.updated_items = Internal.immutableCopyOf("updated_items", r100);
    }
}
