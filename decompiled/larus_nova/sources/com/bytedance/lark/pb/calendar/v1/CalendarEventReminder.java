package com.bytedance.lark.pb.calendar.v1;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class CalendarEventReminder extends Message<CalendarEventReminder, Builder> {
    public static final ProtoAdapter<CalendarEventReminder> ADAPTER = null;
    public static final String DEFAULT_CALENDAR_EVENT_ID = "";
    public static final Method DEFAULT_METHOD = null;
    public static final Integer DEFAULT_MINUTES = null;
    private static final long serialVersionUID = 0;
    public final String calendar_event_id;
    public final Method method;
    public final Integer minutes;

    public static final class Builder extends Message.Builder<CalendarEventReminder, Builder> {
        public String calendar_event_id;
        public Method method;
        public Integer minutes;

        @Override // com.squareup.wire.Message.Builder
        public CalendarEventReminder build() {
            String r100 = this.calendar_event_id;
            if (r100 == null) goto L11;
            if (this.minutes == null) goto L11;
            if (this.method == null) goto L11;
            return new CalendarEventReminder(this.calendar_event_id, this.minutes, this.method, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "calendar_event_id", this.minutes, DocumentType.MINUTES_NAME, this.method, e.f25671s});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder calendar_event_id(String r100) {
            this.calendar_event_id = r100;
            return this;
        }

        public Builder method(Method r100) {
            this.method = r100;
            return this;
        }

        public Builder minutes(Integer r100) {
            this.minutes = r100;
            return this;
        }
    }

    public static final enum Method extends Enum<Method> implements WireEnum {
        private static final /* synthetic */ Method[] $VALUES = null;
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final Method DEFAULT = null;
        public static final Method EMAIL = null;
        public static final Method POPUP = null;
        public static final Method SMS = null;
        private final int value;

        static {
            Method r100 = new Method("DEFAULT", 0, 1);
            DEFAULT = r100;
            Method r101 = new Method(CommonConstant.RETKEY.EMAIL, 1, 2);
            EMAIL = r101;
            Method r102 = new Method("POPUP", 2, 3);
            POPUP = r102;
            Method r103 = new Method(CancelRetainContactInfoFunctions.SMS, 3, 4);
            SMS = r103;
            $VALUES = new Method[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Method.class);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Method fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return SMS;
        L15:
            return POPUP;
        L17:
            return EMAIL;
        L19:
            return DEFAULT;
        }

        public static Method valueOf(String r100) {
            return (Method) a.a(Method.class, r100);
        }

        private Method(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_CalendarEventReminder extends ProtoAdapter<CalendarEventReminder> {
        public ProtoAdapter_CalendarEventReminder() {
            super(FieldEncoding.LENGTH_DELIMITED, CalendarEventReminder.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CalendarEventReminder decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.calendar_event_id = "";
            r101.minutes = 0;
            r101.method = Method.DEFAULT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.calendar_event_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.minutes = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.method = Method.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(CalendarEventReminder r100) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.calendar_event_id) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.minutes)) + Method.ADAPTER.encodedSizeWithTag(3, r100.method)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CalendarEventReminder decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CalendarEventReminder r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CalendarEventReminder r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.calendar_event_id);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.minutes);
            Method.ADAPTER.encodeWithTag(r100, 3, r101.method);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CalendarEventReminder r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CalendarEventReminder();
        DEFAULT_MINUTES = 0;
        DEFAULT_METHOD = Method.DEFAULT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.calendar_event_id = this.calendar_event_id;
        r100.minutes = this.minutes;
        r100.method = this.method;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CalendarEventReminder.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CalendarEventReminder(String r100, Integer r101, Method r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CalendarEventReminder(String r100, Integer r101, Method r102, ByteString r103) {
        super(ADAPTER, r103);
        this.calendar_event_id = r100;
        this.minutes = r101;
        this.method = r102;
    }
}
