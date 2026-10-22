package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.Chatter;
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
public final class PushFocusChatter extends Message<PushFocusChatter, Builder> {
    public static final ProtoAdapter<PushFocusChatter> ADAPTER = null;
    public static final ProtoAdapter_PushFocusChatter RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Chatter> add_chatters;
    public final List<Long> delete_chatter_ids;

    public static final class Builder extends Message.Builder<PushFocusChatter, Builder> implements d<PushFocusChatter> {
        public List<Chatter> add_chatters;
        public List<Long> delete_chatter_ids;

        @Override // com.squareup.wire.Message.Builder
        public PushFocusChatter build() {
            return new PushFocusChatter(this.delete_chatter_ids, this.add_chatters, super.buildUnknownFields());
        }

        public Builder() {
            this.delete_chatter_ids = Internal.newMutableList();
            this.add_chatters = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder add_chatters(List<Chatter> r100) {
            Internal.checkElementsNotNull(r100);
            this.add_chatters = r100;
            return this;
        }

        public Builder delete_chatter_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.delete_chatter_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushFocusChatter extends ProtoAdapter<PushFocusChatter> implements c<PushFocusChatter> {
        public ProtoAdapter_PushFocusChatter() {
            super(FieldEncoding.LENGTH_DELIMITED, PushFocusChatter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushFocusChatter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.delete_chatter_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.add_chatters.add(Chatter.ADAPTER.decode(r100));
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
        public int encodedSize2(PushFocusChatter r100) {
            return (ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(1, r100.delete_chatter_ids) + Chatter.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.add_chatters)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushFocusChatter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushFocusChatter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushFocusChatter r101) throws IOException {
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 1, r101.delete_chatter_ids);
            Chatter.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.add_chatters);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushFocusChatter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushFocusChatter r100 = new ProtoAdapter_PushFocusChatter();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.delete_chatter_ids = Internal.copyOf("delete_chatter_ids", this.delete_chatter_ids);
        r100.add_chatters = Internal.copyOf("add_chatters", this.add_chatters);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushFocusChatter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushFocusChatter(List<Long> r100, List<Chatter> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PushFocusChatter(List<Long> r100, List<Chatter> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.delete_chatter_ids = Internal.immutableCopyOf("delete_chatter_ids", r100);
        this.add_chatters = Internal.immutableCopyOf("add_chatters", r101);
    }
}
