package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class CommonDrawer extends Message<CommonDrawer, Builder> {
    public static final ProtoAdapter<CommonDrawer> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<RenderItem> mItemList;

    public static final class Builder extends Message.Builder<CommonDrawer, Builder> {
        public List<RenderItem> mItemList;

        @Override // com.squareup.wire.Message.Builder
        public CommonDrawer build() {
            return new CommonDrawer(this.mItemList, super.buildUnknownFields());
        }

        public Builder() {
            this.mItemList = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ItemList(List<RenderItem> r100) {
            Internal.checkElementsNotNull(r100);
            this.mItemList = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CommonDrawer extends ProtoAdapter<CommonDrawer> {
        public ProtoAdapter_CommonDrawer() {
            super(FieldEncoding.LENGTH_DELIMITED, CommonDrawer.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CommonDrawer decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mItemList.add(RenderItem.ADAPTER.decode(r100));
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
        public int encodedSize2(CommonDrawer r100) {
            return RenderItem.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mItemList) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CommonDrawer decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CommonDrawer r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CommonDrawer r101) throws IOException {
            RenderItem.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mItemList);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CommonDrawer r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CommonDrawer();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mItemList = Internal.copyOf("mItemList", this.mItemList);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CommonDrawer.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CommonDrawer(List<RenderItem> r100) {
        this(r100, ByteString.EMPTY);
    }

    public CommonDrawer(List<RenderItem> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mItemList = Internal.immutableCopyOf("mItemList", r100);
    }
}
