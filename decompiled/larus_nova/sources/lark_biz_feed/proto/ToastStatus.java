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
public final class ToastStatus extends Message<ToastStatus, Builder> {
    public static final ProtoAdapter<ToastStatus> ADAPTER = null;
    public static final Boolean DEFAULT_NONE = null;
    private static final long serialVersionUID = 0;
    public final ToastStatusFailure general_failure;
    public final Boolean none;
    public final ToastStatusFailure on_auto_mute_switch_change_failure;
    public final ToastStatusSuccess on_auto_mute_switch_change_success;
    public final ToastStatusFailure on_no_disturb_switch_change_failure;
    public final ToastStatusSuccess on_no_disturb_switch_change_success;

    public static final class Builder extends Message.Builder<ToastStatus, Builder> {
        public ToastStatusFailure general_failure;
        public Boolean none;
        public ToastStatusFailure on_auto_mute_switch_change_failure;
        public ToastStatusSuccess on_auto_mute_switch_change_success;
        public ToastStatusFailure on_no_disturb_switch_change_failure;
        public ToastStatusSuccess on_no_disturb_switch_change_success;

        @Override // com.squareup.wire.Message.Builder
        public ToastStatus build() {
            return new ToastStatus(this.none, this.on_no_disturb_switch_change_success, this.on_no_disturb_switch_change_failure, this.on_auto_mute_switch_change_success, this.on_auto_mute_switch_change_failure, this.general_failure, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder general_failure(ToastStatusFailure r100) {
            this.general_failure = r100;
            this.none = null;
            this.on_no_disturb_switch_change_success = null;
            this.on_no_disturb_switch_change_failure = null;
            this.on_auto_mute_switch_change_success = null;
            this.on_auto_mute_switch_change_failure = null;
            return this;
        }

        public Builder none(Boolean r100) {
            this.none = r100;
            this.on_no_disturb_switch_change_success = null;
            this.on_no_disturb_switch_change_failure = null;
            this.on_auto_mute_switch_change_success = null;
            this.on_auto_mute_switch_change_failure = null;
            this.general_failure = null;
            return this;
        }

        public Builder on_auto_mute_switch_change_failure(ToastStatusFailure r100) {
            this.on_auto_mute_switch_change_failure = r100;
            this.none = null;
            this.on_no_disturb_switch_change_success = null;
            this.on_no_disturb_switch_change_failure = null;
            this.on_auto_mute_switch_change_success = null;
            this.general_failure = null;
            return this;
        }

        public Builder on_auto_mute_switch_change_success(ToastStatusSuccess r100) {
            this.on_auto_mute_switch_change_success = r100;
            this.none = null;
            this.on_no_disturb_switch_change_success = null;
            this.on_no_disturb_switch_change_failure = null;
            this.on_auto_mute_switch_change_failure = null;
            this.general_failure = null;
            return this;
        }

        public Builder on_no_disturb_switch_change_failure(ToastStatusFailure r100) {
            this.on_no_disturb_switch_change_failure = r100;
            this.none = null;
            this.on_no_disturb_switch_change_success = null;
            this.on_auto_mute_switch_change_success = null;
            this.on_auto_mute_switch_change_failure = null;
            this.general_failure = null;
            return this;
        }

        public Builder on_no_disturb_switch_change_success(ToastStatusSuccess r100) {
            this.on_no_disturb_switch_change_success = r100;
            this.none = null;
            this.on_no_disturb_switch_change_failure = null;
            this.on_auto_mute_switch_change_success = null;
            this.on_auto_mute_switch_change_failure = null;
            this.general_failure = null;
            return this;
        }
    }

    public static final class ProtoAdapter_ToastStatus extends ProtoAdapter<ToastStatus> {
        public ProtoAdapter_ToastStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, ToastStatus.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ToastStatus decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
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
            r101.general_failure(ToastStatusFailure.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.on_auto_mute_switch_change_failure(ToastStatusFailure.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.on_auto_mute_switch_change_success(ToastStatusSuccess.ADAPTER.decode(r100));
            goto L3
        L10:
            r101.on_no_disturb_switch_change_failure(ToastStatusFailure.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.on_no_disturb_switch_change_success(ToastStatusSuccess.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.none(ProtoAdapter.BOOL.decode(r100));
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
        public int encodedSize2(ToastStatus r100) {
            Boolean r101 = r100.none;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            ToastStatusSuccess r104 = r100.on_no_disturb_switch_change_success;
            if (r104 == null) goto L9;
            int r105 = ToastStatusSuccess.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ToastStatusFailure r107 = r100.on_no_disturb_switch_change_failure;
            if (r107 == null) goto L13;
            int r108 = ToastStatusFailure.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ToastStatusSuccess r110 = r100.on_auto_mute_switch_change_success;
            if (r110 == null) goto L17;
            int r111 = ToastStatusSuccess.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ToastStatusFailure r113 = r100.on_auto_mute_switch_change_failure;
            if (r113 == null) goto L21;
            int r114 = ToastStatusFailure.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            ToastStatusFailure r116 = r100.general_failure;
            if (r116 == null) goto L26;
            r102 = ToastStatusFailure.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ ToastStatus decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ToastStatus r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ToastStatus r101) throws IOException {
            Boolean r102 = r101.none;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            ToastStatusSuccess r103 = r101.on_no_disturb_switch_change_success;
            if (r103 == null) goto L8;
            ToastStatusSuccess.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ToastStatusFailure r104 = r101.on_no_disturb_switch_change_failure;
            if (r104 == null) goto L11;
            ToastStatusFailure.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ToastStatusSuccess r105 = r101.on_auto_mute_switch_change_success;
            if (r105 == null) goto L14;
            ToastStatusSuccess.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ToastStatusFailure r106 = r101.on_auto_mute_switch_change_failure;
            if (r106 == null) goto L17;
            ToastStatusFailure.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            ToastStatusFailure r107 = r101.general_failure;
            if (r107 == null) goto L20;
            ToastStatusFailure.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ToastStatus r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ToastStatus();
        DEFAULT_NONE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.none = this.none;
        r100.on_no_disturb_switch_change_success = this.on_no_disturb_switch_change_success;
        r100.on_no_disturb_switch_change_failure = this.on_no_disturb_switch_change_failure;
        r100.on_auto_mute_switch_change_success = this.on_auto_mute_switch_change_success;
        r100.on_auto_mute_switch_change_failure = this.on_auto_mute_switch_change_failure;
        r100.general_failure = this.general_failure;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ToastStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ToastStatus(Boolean r100, ToastStatusSuccess r110, ToastStatusFailure r111, ToastStatusSuccess r112, ToastStatusFailure r113, ToastStatusFailure r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public ToastStatus(Boolean r100, ToastStatusSuccess r101, ToastStatusFailure r102, ToastStatusSuccess r103, ToastStatusFailure r104, ToastStatusFailure r105, ByteString r106) {
        super(ADAPTER, r106);
        if (Internal.countNonNull(r100, r101, r102, r103, new Object[]{r104, r105}) > 1) goto L7;
        this.none = r100;
        this.on_no_disturb_switch_change_success = r101;
        this.on_no_disturb_switch_change_failure = r102;
        this.on_auto_mute_switch_change_success = r103;
        this.on_auto_mute_switch_change_failure = r104;
        this.general_failure = r105;
        return;
    L7:
        throw new IllegalArgumentException("at most one of none, on_no_disturb_switch_change_success, on_no_disturb_switch_change_failure, on_auto_mute_switch_change_success, on_auto_mute_switch_change_failure, general_failure may be non-null");
    }
}
