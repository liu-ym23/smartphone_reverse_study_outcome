package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedButtonData extends com.squareup.wire.Message<FeedButtonData, Builder> {
    public static final ProtoAdapter<FeedButtonData> ADAPTER = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final List<AppFeedCardButton> buttons;
    public final Long version;

    public static final class Builder extends com.squareup.wire.Message.Builder<FeedButtonData, Builder> {
        public List<AppFeedCardButton> buttons;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public FeedButtonData build() {
            return new FeedButtonData(this.buttons, this.version, super.buildUnknownFields());
        }

        public Builder() {
            this.buttons = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder buttons(List<AppFeedCardButton> r100) {
            Internal.checkElementsNotNull(r100);
            this.buttons = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedButtonData extends ProtoAdapter<FeedButtonData> {
        public ProtoAdapter_FeedButtonData() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedButtonData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedButtonData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.buttons.add(AppFeedCardButton.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 10) goto L9;
            r101.version = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(FeedButtonData r100) {
            int r101 = AppFeedCardButton.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.buttons);
            Long r102 = r100.version;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(10, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedButtonData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedButtonData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedButtonData r101) throws IOException {
            AppFeedCardButton.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.buttons);
            Long r102 = r101.version;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 10, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedButtonData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedButtonData();
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.buttons = Internal.copyOf("buttons", this.buttons);
        r100.version = this.version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedButtonData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedButtonData(List<AppFeedCardButton> r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public FeedButtonData(List<AppFeedCardButton> r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.buttons = Internal.immutableCopyOf("buttons", r100);
        this.version = r101;
    }
}
