package com.bytedance.lark.pb.tool.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MagicShareDowngradeStrategy extends Message<MagicShareDowngradeStrategy, Builder> {
    public static final ProtoAdapter<MagicShareDowngradeStrategy> ADAPTER = null;
    public static final Integer DEFAULT_ENGINE_BUFFER_ACTIVE_CONSUME_INTERVAL = null;
    public static final Integer DEFAULT_MEMBER_BUFFER_ACTIVE_CONSUME_INTERVAL = null;
    public static final Integer DEFAULT_SEND_CURSOR_DEBOUNCE = null;
    public static final Integer DEFAULT_UPDATE_CURSOR_LONG_THROTTLE = null;
    public static final Integer DEFAULT_UPDATE_CURSOR_SHORT_THROTTLE = null;
    public static final FieldOptions FIELD_OPTIONS_ENGINE_BUFFER_ACTIVE_CONSUME_INTERVAL = null;
    public static final FieldOptions FIELD_OPTIONS_MEMBER_BUFFER_ACTIVE_CONSUME_INTERVAL = null;
    public static final FieldOptions FIELD_OPTIONS_SEND_CURSOR_DEBOUNCE = null;
    public static final FieldOptions FIELD_OPTIONS_UPDATE_CURSOR_LONG_THROTTLE = null;
    public static final FieldOptions FIELD_OPTIONS_UPDATE_CURSOR_SHORT_THROTTLE = null;
    private static final long serialVersionUID = 0;
    public final Integer engine_buffer_active_consume_interval;
    public final Integer member_buffer_active_consume_interval;
    public final Integer send_cursor_debounce;
    public final Integer update_cursor_long_throttle;
    public final Integer update_cursor_short_throttle;

    public static final class Builder extends Message.Builder<MagicShareDowngradeStrategy, Builder> {
        public Integer engine_buffer_active_consume_interval;
        public Integer member_buffer_active_consume_interval;
        public Integer send_cursor_debounce;
        public Integer update_cursor_long_throttle;
        public Integer update_cursor_short_throttle;

        @Override // com.squareup.wire.Message.Builder
        public MagicShareDowngradeStrategy build() {
            Integer r100 = this.send_cursor_debounce;
            if (r100 == null) goto L15;
            if (this.update_cursor_short_throttle == null) goto L15;
            if (this.update_cursor_long_throttle == null) goto L15;
            if (this.member_buffer_active_consume_interval == null) goto L15;
            if (this.engine_buffer_active_consume_interval == null) goto L15;
            return new MagicShareDowngradeStrategy(this.send_cursor_debounce, this.update_cursor_short_throttle, this.update_cursor_long_throttle, this.member_buffer_active_consume_interval, this.engine_buffer_active_consume_interval, super.buildUnknownFields());
        L15:
            throw Internal.missingRequiredFields(new Object[]{r100, "send_cursor_debounce", this.update_cursor_short_throttle, "update_cursor_short_throttle", this.update_cursor_long_throttle, "update_cursor_long_throttle", this.member_buffer_active_consume_interval, "member_buffer_active_consume_interval", this.engine_buffer_active_consume_interval, "engine_buffer_active_consume_interval"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder engine_buffer_active_consume_interval(Integer r100) {
            this.engine_buffer_active_consume_interval = r100;
            return this;
        }

        public Builder member_buffer_active_consume_interval(Integer r100) {
            this.member_buffer_active_consume_interval = r100;
            return this;
        }

        public Builder send_cursor_debounce(Integer r100) {
            this.send_cursor_debounce = r100;
            return this;
        }

        public Builder update_cursor_long_throttle(Integer r100) {
            this.update_cursor_long_throttle = r100;
            return this;
        }

        public Builder update_cursor_short_throttle(Integer r100) {
            this.update_cursor_short_throttle = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MagicShareDowngradeStrategy extends ProtoAdapter<MagicShareDowngradeStrategy> {
        public ProtoAdapter_MagicShareDowngradeStrategy() {
            super(FieldEncoding.LENGTH_DELIMITED, MagicShareDowngradeStrategy.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MagicShareDowngradeStrategy decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.send_cursor_debounce = 0;
            r101.update_cursor_short_throttle = 0;
            r101.update_cursor_long_throttle = 0;
            r101.member_buffer_active_consume_interval = 0;
            r101.engine_buffer_active_consume_interval = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.send_cursor_debounce = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.update_cursor_short_throttle = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.update_cursor_long_throttle = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.member_buffer_active_consume_interval = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.engine_buffer_active_consume_interval = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MagicShareDowngradeStrategy r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return ((((r101.encodedSizeWithTag(1, r100.send_cursor_debounce) + r101.encodedSizeWithTag(2, r100.update_cursor_short_throttle)) + r101.encodedSizeWithTag(3, r100.update_cursor_long_throttle)) + r101.encodedSizeWithTag(4, r100.member_buffer_active_consume_interval)) + r101.encodedSizeWithTag(5, r100.engine_buffer_active_consume_interval)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MagicShareDowngradeStrategy decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MagicShareDowngradeStrategy r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MagicShareDowngradeStrategy r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.send_cursor_debounce);
            r102.encodeWithTag(r100, 2, r101.update_cursor_short_throttle);
            r102.encodeWithTag(r100, 3, r101.update_cursor_long_throttle);
            r102.encodeWithTag(r100, 4, r101.member_buffer_active_consume_interval);
            r102.encodeWithTag(r100, 5, r101.engine_buffer_active_consume_interval);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MagicShareDowngradeStrategy r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MagicShareDowngradeStrategy();
        FIELD_OPTIONS_SEND_CURSOR_DEBOUNCE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_UPDATE_CURSOR_SHORT_THROTTLE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_UPDATE_CURSOR_LONG_THROTTLE = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_MEMBER_BUFFER_ACTIVE_CONSUME_INTERVAL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_ENGINE_BUFFER_ACTIVE_CONSUME_INTERVAL = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_SEND_CURSOR_DEBOUNCE = 0;
        DEFAULT_UPDATE_CURSOR_SHORT_THROTTLE = 0;
        DEFAULT_UPDATE_CURSOR_LONG_THROTTLE = 0;
        DEFAULT_MEMBER_BUFFER_ACTIVE_CONSUME_INTERVAL = 0;
        DEFAULT_ENGINE_BUFFER_ACTIVE_CONSUME_INTERVAL = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.send_cursor_debounce = this.send_cursor_debounce;
        r100.update_cursor_short_throttle = this.update_cursor_short_throttle;
        r100.update_cursor_long_throttle = this.update_cursor_long_throttle;
        r100.member_buffer_active_consume_interval = this.member_buffer_active_consume_interval;
        r100.engine_buffer_active_consume_interval = this.engine_buffer_active_consume_interval;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MagicShareDowngradeStrategy.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MagicShareDowngradeStrategy(Integer r100, Integer r101, Integer r110, Integer r111, Integer r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public MagicShareDowngradeStrategy(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, ByteString r105) {
        super(ADAPTER, r105);
        this.send_cursor_debounce = r100;
        this.update_cursor_short_throttle = r101;
        this.update_cursor_long_throttle = r102;
        this.member_buffer_active_consume_interval = r103;
        this.engine_buffer_active_consume_interval = r104;
    }
}
