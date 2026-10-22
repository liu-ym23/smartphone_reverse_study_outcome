package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MarqueeFilter extends Message<MarqueeFilter, Builder> {
    public static final ProtoAdapter<MarqueeFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MessageFilter.FromUserFilter mmessage_from_user_filter;
    public final MessageFilter.TimeFilter mmessage_time_filter;

    public static final class Builder extends Message.Builder<MarqueeFilter, Builder> {
        public MessageFilter.FromUserFilter mmessage_from_user_filter;
        public MessageFilter.TimeFilter mmessage_time_filter;

        @Override // com.squareup.wire.Message.Builder
        public MarqueeFilter build() {
            return new MarqueeFilter(this.mmessage_time_filter, this.mmessage_from_user_filter, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder message_from_user_filter(MessageFilter.FromUserFilter r100) {
            this.mmessage_from_user_filter = r100;
            this.mmessage_time_filter = null;
            return this;
        }

        public Builder message_time_filter(MessageFilter.TimeFilter r100) {
            this.mmessage_time_filter = r100;
            this.mmessage_from_user_filter = null;
            return this;
        }
    }

    public static final class ProtoAdapter_MarqueeFilter extends ProtoAdapter<MarqueeFilter> {
        public ProtoAdapter_MarqueeFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, MarqueeFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MarqueeFilter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.message_time_filter(MessageFilter.TimeFilter.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.message_from_user_filter(MessageFilter.FromUserFilter.ADAPTER.decode(r100));
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
        public int encodedSize2(MarqueeFilter r100) {
            MessageFilter.TimeFilter r101 = r100.mmessage_time_filter;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = MessageFilter.TimeFilter.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            MessageFilter.FromUserFilter r104 = r100.mmessage_from_user_filter;
            if (r104 == null) goto L10;
            r102 = MessageFilter.FromUserFilter.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MarqueeFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MarqueeFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MarqueeFilter r101) throws IOException {
            MessageFilter.TimeFilter r102 = r101.mmessage_time_filter;
            if (r102 == null) goto L5;
            MessageFilter.TimeFilter.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            MessageFilter.FromUserFilter r103 = r101.mmessage_from_user_filter;
            if (r103 == null) goto L8;
            MessageFilter.FromUserFilter.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MarqueeFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MarqueeFilter();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmessage_time_filter = this.mmessage_time_filter;
        r100.mmessage_from_user_filter = this.mmessage_from_user_filter;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MarqueeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MarqueeFilter(MessageFilter.TimeFilter r100, MessageFilter.FromUserFilter r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MarqueeFilter(MessageFilter.TimeFilter r100, MessageFilter.FromUserFilter r101, ByteString r102) {
        super(ADAPTER, r102);
        if (Internal.countNonNull(r100, r101) > 1) goto L7;
        this.mmessage_time_filter = r100;
        this.mmessage_from_user_filter = r101;
        return;
    L7:
        throw new IllegalArgumentException("at most one of mmessage_time_filter, mmessage_from_user_filter may be non-null");
    }
}
