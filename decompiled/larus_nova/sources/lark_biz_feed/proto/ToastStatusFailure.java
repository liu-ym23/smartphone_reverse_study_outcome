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
public final class ToastStatusFailure extends Message<ToastStatusFailure, Builder> {
    public static final ProtoAdapter<ToastStatusFailure> ADAPTER = null;
    public static final Integer DEFAULT_ERROR_CODE = null;
    public static final String DEFAULT_ERROR_MESSAGE = "";
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Integer error_code;
    public final String error_message;
    public final Boolean is_remind;
    public final Long version;

    public static final class Builder extends Message.Builder<ToastStatusFailure, Builder> {
        public Integer error_code;
        public String error_message;
        public Boolean is_remind;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public ToastStatusFailure build() {
            Long r100 = this.version;
            if (r100 == null) goto L13;
            if (this.is_remind == null) goto L13;
            if (this.error_message == null) goto L13;
            if (this.error_code == null) goto L13;
            return new ToastStatusFailure(this.version, this.is_remind, this.error_message, this.error_code, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "version", this.is_remind, "is_remind", this.error_message, "error_message", this.error_code, "error_code"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder error_code(Integer r100) {
            this.error_code = r100;
            return this;
        }

        public Builder error_message(String r100) {
            this.error_message = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ToastStatusFailure extends ProtoAdapter<ToastStatusFailure> {
        public ProtoAdapter_ToastStatusFailure() {
            super(FieldEncoding.LENGTH_DELIMITED, ToastStatusFailure.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ToastStatusFailure decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.version = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.error_message = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.error_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ToastStatusFailure r100) {
            return (((ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.version) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_remind)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.error_message)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r100.error_code)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ToastStatusFailure decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ToastStatusFailure r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ToastStatusFailure r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.version);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_remind);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.error_message);
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r101.error_code);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ToastStatusFailure r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ToastStatusFailure();
        DEFAULT_VERSION = 0L;
        DEFAULT_IS_REMIND = Boolean.FALSE;
        DEFAULT_ERROR_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.version = this.version;
        r100.is_remind = this.is_remind;
        r100.error_message = this.error_message;
        r100.error_code = this.error_code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ToastStatusFailure.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ToastStatusFailure(Long r100, Boolean r101, String r102, Integer r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public ToastStatusFailure(Long r100, Boolean r101, String r102, Integer r103, ByteString r104) {
        super(ADAPTER, r104);
        this.version = r100;
        this.is_remind = r101;
        this.error_message = r102;
        this.error_code = r103;
    }
}
