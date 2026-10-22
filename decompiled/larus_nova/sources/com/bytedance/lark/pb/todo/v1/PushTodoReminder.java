package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushTodoReminder extends Message<PushTodoReminder, Builder> {
    public static final ProtoAdapter<PushTodoReminder> ADAPTER = null;
    public static final Long DEFAULT_DUE_TIME = null;
    public static final String DEFAULT_DUE_TIMEZONE = "";
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_ALL_DAY = null;
    public static final String DEFAULT_SUMMARY = "";
    public static final ProtoAdapter_PushTodoReminder RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long due_time;
    public final String due_timezone;
    public final String guid;
    public final Boolean is_all_day;
    public final TodoReminder reminder;
    public final String summary;

    public static final class Builder extends Message.Builder<PushTodoReminder, Builder> implements d<PushTodoReminder> {
        public Long due_time;
        public String due_timezone;
        public String guid;
        public Boolean is_all_day;
        public TodoReminder reminder;
        public String summary;

        @Override // com.squareup.wire.Message.Builder
        public PushTodoReminder build() {
            return new PushTodoReminder(this.guid, this.summary, this.due_time, this.due_timezone, this.is_all_day, this.reminder, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder due_time(Long r100) {
            this.due_time = r100;
            return this;
        }

        public Builder due_timezone(String r100) {
            this.due_timezone = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder is_all_day(Boolean r100) {
            this.is_all_day = r100;
            return this;
        }

        public Builder reminder(TodoReminder r100) {
            this.reminder = r100;
            return this;
        }

        public Builder summary(String r100) {
            this.summary = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushTodoReminder extends ProtoAdapter<PushTodoReminder> implements c<PushTodoReminder> {
        public ProtoAdapter_PushTodoReminder() {
            super(FieldEncoding.LENGTH_DELIMITED, PushTodoReminder.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushTodoReminder decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.summary = "";
            r101.due_time = 0L;
            r101.due_timezone = "";
            r101.is_all_day = Boolean.FALSE;
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
            r101.reminder = TodoReminder.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.is_all_day = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.due_timezone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.due_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            r101.summary = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.guid = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PushTodoReminder r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.summary;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.due_time;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.due_timezone;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_all_day;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            TodoReminder r116 = r100.reminder;
            if (r116 == null) goto L26;
            r102 = TodoReminder.ADAPTER.encodedSizeWithTag(6, r116);
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
        public /* bridge */ /* synthetic */ PushTodoReminder decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushTodoReminder r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushTodoReminder r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.summary;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.due_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.due_timezone;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_all_day;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            TodoReminder r107 = r101.reminder;
            if (r107 == null) goto L20;
            TodoReminder.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushTodoReminder r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushTodoReminder r100 = new ProtoAdapter_PushTodoReminder();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DUE_TIME = 0L;
        DEFAULT_IS_ALL_DAY = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.summary = this.summary;
        r100.due_time = this.due_time;
        r100.due_timezone = this.due_timezone;
        r100.is_all_day = this.is_all_day;
        r100.reminder = this.reminder;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushTodoReminder.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushTodoReminder(String r100, String r110, Long r111, String r112, Boolean r113, TodoReminder r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public PushTodoReminder(String r100, String r101, Long r102, String r103, Boolean r104, TodoReminder r105, ByteString r106) {
        super(ADAPTER, r106);
        this.guid = r100;
        this.summary = r101;
        this.due_time = r102;
        this.due_timezone = r103;
        this.is_all_day = r104;
        this.reminder = r105;
    }
}
