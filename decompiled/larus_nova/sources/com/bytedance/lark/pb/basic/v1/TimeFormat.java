package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TimeFormat extends com.squareup.wire.Message<TimeFormat, Builder> {
    public static final ProtoAdapter<TimeFormat> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SHOW_TO_OTHERS = null;
    public static final StartEndLayout DEFAULT_START_END_LAYOUT = null;
    public static final TimeUnit DEFAULT_TIME_UNIT = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_show_to_others;
    public final StartEndLayout start_end_layout;
    public final TimeUnit time_unit;

    public static final class Builder extends com.squareup.wire.Message.Builder<TimeFormat, Builder> {
        public Boolean is_show_to_others;
        public StartEndLayout start_end_layout;
        public TimeUnit time_unit;

        @Override // com.squareup.wire.Message.Builder
        public TimeFormat build() {
            return new TimeFormat(this.time_unit, this.start_end_layout, this.is_show_to_others, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_show_to_others(Boolean r100) {
            this.is_show_to_others = r100;
            return this;
        }

        public Builder start_end_layout(StartEndLayout r100) {
            this.start_end_layout = r100;
            return this;
        }

        public Builder time_unit(TimeUnit r100) {
            this.time_unit = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TimeFormat extends ProtoAdapter<TimeFormat> {
        public ProtoAdapter_TimeFormat() {
            super(FieldEncoding.LENGTH_DELIMITED, TimeFormat.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TimeFormat decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.time_unit = TimeUnit.SECOND;
            r101.start_end_layout = StartEndLayout.HIDE;
            r101.is_show_to_others = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.time_unit = TimeUnit.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.start_end_layout = StartEndLayout.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.is_show_to_others = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TimeFormat r100) {
            TimeUnit r101 = r100.time_unit;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TimeUnit.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            StartEndLayout r104 = r100.start_end_layout;
            if (r104 == null) goto L9;
            int r105 = StartEndLayout.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_show_to_others;
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
        public /* bridge */ /* synthetic */ TimeFormat decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TimeFormat r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TimeFormat r101) throws IOException {
            TimeUnit r102 = r101.time_unit;
            if (r102 == null) goto L5;
            TimeUnit.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            StartEndLayout r103 = r101.start_end_layout;
            if (r103 == null) goto L8;
            StartEndLayout.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_show_to_others;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimeFormat r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum StartEndLayout extends Enum<StartEndLayout> implements WireEnum {
        private static final /* synthetic */ StartEndLayout[] $VALUES = null;
        public static final ProtoAdapter<StartEndLayout> ADAPTER = null;
        public static final StartEndLayout END_ONLY = null;
        public static final StartEndLayout HIDE = null;
        public static final StartEndLayout NORMAL = null;
        public static final StartEndLayout START_ONLY = null;
        private final int value;

        static {
            StartEndLayout r100 = new StartEndLayout("HIDE", 0, 0);
            HIDE = r100;
            StartEndLayout r101 = new StartEndLayout(EffectConstants.NORMAL, 1, 1);
            NORMAL = r101;
            StartEndLayout r102 = new StartEndLayout("START_ONLY", 2, 2);
            START_ONLY = r102;
            StartEndLayout r103 = new StartEndLayout("END_ONLY", 3, 3);
            END_ONLY = r103;
            $VALUES = new StartEndLayout[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(StartEndLayout.class);
        }

        public static StartEndLayout[] values() {
            return (StartEndLayout[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static StartEndLayout fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return END_ONLY;
        L14:
            return START_ONLY;
        L16:
            return NORMAL;
        L18:
            return HIDE;
        }

        public static StartEndLayout valueOf(String r100) {
            return (StartEndLayout) a.a(StartEndLayout.class, r100);
        }

        private StartEndLayout(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TimeFormat();
        DEFAULT_TIME_UNIT = TimeUnit.SECOND;
        DEFAULT_START_END_LAYOUT = StartEndLayout.HIDE;
        DEFAULT_IS_SHOW_TO_OTHERS = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.time_unit = this.time_unit;
        r100.start_end_layout = this.start_end_layout;
        r100.is_show_to_others = this.is_show_to_others;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TimeFormat.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TimeFormat(TimeUnit r100, StartEndLayout r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TimeFormat(TimeUnit r100, StartEndLayout r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.time_unit = r100;
        this.start_end_layout = r101;
        this.is_show_to_others = r102;
    }
}
