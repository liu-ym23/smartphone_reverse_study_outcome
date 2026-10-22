package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PushRecordingStartResult extends Message<PushRecordingStartResult, Builder> {
    public static final ProtoAdapter<PushRecordingStartResult> ADAPTER = null;
    public static final String DEFAULT_ERROR = "";
    public static final String DEFAULT_FAIL_TOAST_I18N_KEY = "";
    public static final String DEFAULT_MEETING_ID = "";
    public static final Integer DEFAULT_STATUS = null;
    private static final long serialVersionUID = 0;
    public final String merror;
    public final String mfail_toast_i18n_key;
    public final String mmeeting_id;
    public final Integer mstatus;

    public static final class Builder extends Message.Builder<PushRecordingStartResult, Builder> {
        public String merror;
        public String mfail_toast_i18n_key;
        public String mmeeting_id;
        public Integer mstatus;

        @Override // com.squareup.wire.Message.Builder
        public PushRecordingStartResult build() {
            String r100 = this.mmeeting_id;
            if (r100 == null) goto L7;
            return new PushRecordingStartResult(this.mmeeting_id, this.mstatus, this.mfail_toast_i18n_key, this.merror, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mmeeting_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder error(String r100) {
            this.merror = r100;
            return this;
        }

        public Builder fail_toast_i18n_key(String r100) {
            this.mfail_toast_i18n_key = r100;
            return this;
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder status(Integer r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushRecordingStartResult extends ProtoAdapter<PushRecordingStartResult> {
        public ProtoAdapter_PushRecordingStartResult() {
            super(FieldEncoding.LENGTH_DELIMITED, PushRecordingStartResult.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushRecordingStartResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmeeting_id = "";
            r101.mstatus = 0;
            r101.mfail_toast_i18n_key = "";
            r101.merror = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mstatus = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mfail_toast_i18n_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.merror = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PushRecordingStartResult r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mmeeting_id);
            Integer r103 = r100.mstatus;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mfail_toast_i18n_key;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.merror;
            if (r110 == null) goto L14;
            r104 = r101.encodedSizeWithTag(4, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushRecordingStartResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushRecordingStartResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushRecordingStartResult r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mmeeting_id);
            Integer r103 = r101.mstatus;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mfail_toast_i18n_key;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.merror;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushRecordingStartResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushRecordingStartResult();
        DEFAULT_STATUS = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_id = this.mmeeting_id;
        r100.mstatus = this.mstatus;
        r100.mfail_toast_i18n_key = this.mfail_toast_i18n_key;
        r100.merror = this.merror;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushRecordingStartResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushRecordingStartResult(String r100, Integer r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PushRecordingStartResult(String r100, Integer r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mmeeting_id = r100;
        this.mstatus = r101;
        this.mfail_toast_i18n_key = r102;
        this.merror = r103;
    }
}
