package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.entities.ExtensionMode;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullExtensionSettingsResponse extends Message<PullExtensionSettingsResponse, Builder> {
    public static final ProtoAdapter<PullExtensionSettingsResponse> ADAPTER = null;
    public static final Long DEFAULT_MAX_NUM = null;
    public static final Long DEFAULT_MIN_NUM = null;
    public static final Boolean DEFAULT_SHOW_NOTICE = null;
    private static final long serialVersionUID = 0;
    public final Long mmax_num;
    public final Long mmin_num;
    public final ExtensionMode mmode;
    public final Boolean mshow_notice;

    public static final class Builder extends Message.Builder<PullExtensionSettingsResponse, Builder> {
        public Long mmax_num;
        public Long mmin_num;
        public ExtensionMode mmode;
        public Boolean mshow_notice;

        @Override // com.squareup.wire.Message.Builder
        public PullExtensionSettingsResponse build() {
            return new PullExtensionSettingsResponse(this.mmax_num, this.mmin_num, this.mmode, this.mshow_notice, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder max_num(Long r100) {
            this.mmax_num = r100;
            return this;
        }

        public Builder min_num(Long r100) {
            this.mmin_num = r100;
            return this;
        }

        public Builder mode(ExtensionMode r100) {
            this.mmode = r100;
            return this;
        }

        public Builder show_notice(Boolean r100) {
            this.mshow_notice = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullExtensionSettingsResponse extends ProtoAdapter<PullExtensionSettingsResponse> {
        public ProtoAdapter_PullExtensionSettingsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullExtensionSettingsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullExtensionSettingsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmax_num = 0L;
            r101.mmin_num = 0L;
            r101.mshow_notice = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mmax_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mmin_num = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mmode = ExtensionMode.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mshow_notice = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullExtensionSettingsResponse r100) {
            Long r101 = r100.mmax_num;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mmin_num;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ExtensionMode r107 = r100.mmode;
            if (r107 == null) goto L13;
            int r108 = ExtensionMode.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mshow_notice;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ PullExtensionSettingsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullExtensionSettingsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullExtensionSettingsResponse r101) throws IOException {
            Long r102 = r101.mmax_num;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mmin_num;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            ExtensionMode r104 = r101.mmode;
            if (r104 == null) goto L11;
            ExtensionMode.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Boolean r105 = r101.mshow_notice;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullExtensionSettingsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullExtensionSettingsResponse();
        DEFAULT_MAX_NUM = 0L;
        DEFAULT_MIN_NUM = 0L;
        DEFAULT_SHOW_NOTICE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmax_num = this.mmax_num;
        r100.mmin_num = this.mmin_num;
        r100.mmode = this.mmode;
        r100.mshow_notice = this.mshow_notice;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullExtensionSettingsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullExtensionSettingsResponse(Long r100, Long r101, ExtensionMode r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PullExtensionSettingsResponse(Long r100, Long r101, ExtensionMode r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mmax_num = r100;
        this.mmin_num = r101;
        this.mmode = r102;
        this.mshow_notice = r103;
    }
}
