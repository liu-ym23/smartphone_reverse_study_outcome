package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class LarkFeedListViewObjectFieldValue extends Message<LarkFeedListViewObjectFieldValue, Builder> {
    public static final ProtoAdapter<LarkFeedListViewObjectFieldValue> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_LOAD_MORE = null;
    private static final long serialVersionUID = 0;
    public final Boolean can_load_more;
    public final ListStatus load_status;
    public final ToastStatus toast_status;

    public static final class Builder extends Message.Builder<LarkFeedListViewObjectFieldValue, Builder> {
        public Boolean can_load_more;
        public ListStatus load_status;
        public ToastStatus toast_status;

        @Override // com.squareup.wire.Message.Builder
        public LarkFeedListViewObjectFieldValue build() {
            return new LarkFeedListViewObjectFieldValue(this.load_status, this.toast_status, this.can_load_more, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder can_load_more(Boolean r100) {
            this.can_load_more = r100;
            this.load_status = null;
            this.toast_status = null;
            return this;
        }

        public Builder load_status(ListStatus r100) {
            this.load_status = r100;
            this.toast_status = null;
            this.can_load_more = null;
            return this;
        }

        public Builder toast_status(ToastStatus r100) {
            this.toast_status = r100;
            this.load_status = null;
            this.can_load_more = null;
            return this;
        }
    }

    public static final class ProtoAdapter_LarkFeedListViewObjectFieldValue extends ProtoAdapter<LarkFeedListViewObjectFieldValue> {
        public ProtoAdapter_LarkFeedListViewObjectFieldValue() {
            super(FieldEncoding.LENGTH_DELIMITED, LarkFeedListViewObjectFieldValue.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public LarkFeedListViewObjectFieldValue decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.load_status(ListStatus.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.toast_status(ToastStatus.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.can_load_more(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LarkFeedListViewObjectFieldValue r100) {
            ListStatus r101 = r100.load_status;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ListStatus.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            ToastStatus r104 = r100.toast_status;
            if (r104 == null) goto L9;
            int r105 = ToastStatus.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.can_load_more;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LarkFeedListViewObjectFieldValue decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LarkFeedListViewObjectFieldValue r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, LarkFeedListViewObjectFieldValue r101) throws IOException {
            ListStatus r102 = r101.load_status;
            if (r102 == null) goto L5;
            ListStatus.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ToastStatus r103 = r101.toast_status;
            if (r103 == null) goto L8;
            ToastStatus.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.can_load_more;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LarkFeedListViewObjectFieldValue r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_LarkFeedListViewObjectFieldValue();
        DEFAULT_CAN_LOAD_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.load_status = this.load_status;
        r100.toast_status = this.toast_status;
        r100.can_load_more = this.can_load_more;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return LarkFeedListViewObjectFieldValue.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public LarkFeedListViewObjectFieldValue(ListStatus r100, ToastStatus r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public LarkFeedListViewObjectFieldValue(ListStatus r100, ToastStatus r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        if (Internal.countNonNull(r100, r101, r102) > 1) goto L7;
        this.load_status = r100;
        this.toast_status = r101;
        this.can_load_more = r102;
        return;
    L7:
        throw new IllegalArgumentException("at most one of load_status, toast_status, can_load_more may be non-null");
    }
}
