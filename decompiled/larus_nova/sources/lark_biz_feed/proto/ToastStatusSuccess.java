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
public final class ToastStatusSuccess extends Message<ToastStatusSuccess, Builder> {
    public static final ProtoAdapter<ToastStatusSuccess> ADAPTER = null;
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_remind;
    public final Long version;

    public static final class Builder extends Message.Builder<ToastStatusSuccess, Builder> {
        public Boolean is_remind;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public ToastStatusSuccess build() {
            Long r100 = this.version;
            if (r100 == null) goto L9;
            if (this.is_remind == null) goto L9;
            return new ToastStatusSuccess(this.version, this.is_remind, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "version", this.is_remind, "is_remind"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
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

    public static final class ProtoAdapter_ToastStatusSuccess extends ProtoAdapter<ToastStatusSuccess> {
        public ProtoAdapter_ToastStatusSuccess() {
            super(FieldEncoding.LENGTH_DELIMITED, ToastStatusSuccess.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ToastStatusSuccess decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.version = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ToastStatusSuccess r100) {
            return (ProtoAdapter.UINT64.encodedSizeWithTag(1, r100.version) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.is_remind)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ToastStatusSuccess decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ToastStatusSuccess r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ToastStatusSuccess r101) throws IOException {
            ProtoAdapter.UINT64.encodeWithTag(r100, 1, r101.version);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.is_remind);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ToastStatusSuccess r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ToastStatusSuccess();
        DEFAULT_VERSION = 0L;
        DEFAULT_IS_REMIND = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.version = this.version;
        r100.is_remind = this.is_remind;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ToastStatusSuccess.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ToastStatusSuccess(Long r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ToastStatusSuccess(Long r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.version = r100;
        this.is_remind = r101;
    }
}
