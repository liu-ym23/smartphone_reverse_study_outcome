package com.bytedance.lark.pb.bitable.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushBitableRecordUiInfo extends Message<PushBitableRecordUiInfo, Builder> {
    public static final ProtoAdapter<PushBitableRecordUiInfo> ADAPTER = null;
    public static final Action DEFAULT_ACTION = null;
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final Integer DEFAULT_SUBMIT_FAILED_ERROR_CODE = null;
    public static final ProtoAdapter_PushBitableRecordUiInfo RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Action action;
    public final String container_id;
    public final Integer submit_failed_error_code;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action HIDE_SUBMIT_FAILED_BANNER = null;
        public static final Action SHOW_SUBMIT_FAILED_BANNER = null;
        public static final Action SUBMIT_FAILED = null;
        private final int value;

        static {
            Action r100 = new Action("SHOW_SUBMIT_FAILED_BANNER", 0, 1);
            SHOW_SUBMIT_FAILED_BANNER = r100;
            Action r101 = new Action("HIDE_SUBMIT_FAILED_BANNER", 1, 2);
            HIDE_SUBMIT_FAILED_BANNER = r101;
            Action r102 = new Action("SUBMIT_FAILED", 2, 3);
            SUBMIT_FAILED = r102;
            $VALUES = new Action[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return SUBMIT_FAILED;
        L13:
            return HIDE_SUBMIT_FAILED_BANNER;
        L15:
            return SHOW_SUBMIT_FAILED_BANNER;
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<PushBitableRecordUiInfo, Builder> implements d<PushBitableRecordUiInfo> {
        public Action action;
        public String container_id;
        public Integer submit_failed_error_code;

        @Override // com.squareup.wire.Message.Builder
        public PushBitableRecordUiInfo build() {
            return new PushBitableRecordUiInfo(this.container_id, this.action, this.submit_failed_error_code, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(Action r100) {
            this.action = r100;
            return this;
        }

        public Builder container_id(String r100) {
            this.container_id = r100;
            return this;
        }

        public Builder submit_failed_error_code(Integer r100) {
            this.submit_failed_error_code = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushBitableRecordUiInfo extends ProtoAdapter<PushBitableRecordUiInfo> implements c<PushBitableRecordUiInfo> {
        public ProtoAdapter_PushBitableRecordUiInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PushBitableRecordUiInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushBitableRecordUiInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_id = "";
            r101.action = Action.SHOW_SUBMIT_FAILED_BANNER;
            r101.submit_failed_error_code = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.container_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.action = Action.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.submit_failed_error_code = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushBitableRecordUiInfo r100) {
            String r101 = r100.container_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Action r104 = r100.action;
            if (r104 == null) goto L9;
            int r105 = Action.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.submit_failed_error_code;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ PushBitableRecordUiInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushBitableRecordUiInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushBitableRecordUiInfo r101) throws IOException {
            String r102 = r101.container_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Action r103 = r101.action;
            if (r103 == null) goto L8;
            Action.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.submit_failed_error_code;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushBitableRecordUiInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushBitableRecordUiInfo r100 = new ProtoAdapter_PushBitableRecordUiInfo();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ACTION = Action.SHOW_SUBMIT_FAILED_BANNER;
        DEFAULT_SUBMIT_FAILED_ERROR_CODE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_id = this.container_id;
        r100.action = this.action;
        r100.submit_failed_error_code = this.submit_failed_error_code;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushBitableRecordUiInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushBitableRecordUiInfo(String r100, Action r101, Integer r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushBitableRecordUiInfo(String r100, Action r101, Integer r102, ByteString r103) {
        super(ADAPTER, r103);
        this.container_id = r100;
        this.action = r101;
        this.submit_failed_error_code = r102;
    }
}
