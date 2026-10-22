package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class ComposerSetting extends Message<ComposerSetting, Builder> {
    public static final ProtoAdapter<ComposerSetting> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_PERSONALIZE = null;
    public static final Boolean DEFAULT_IS_DOCS_ENABLED = null;
    public static final Boolean DEFAULT_IS_ENABLED = null;
    public static final Boolean DEFAULT_IS_MAIL_ENABLED = null;
    public static final Boolean DEFAULT_IS_MESSENGER_ENABLED = null;
    public static final Integer DEFAULT_TRIGGER_DELAY_MS = null;
    private static final long serialVersionUID = 0;
    public final Boolean can_personalize;
    public final Boolean is_docs_enabled;
    public final Boolean is_enabled;
    public final Boolean is_mail_enabled;
    public final Boolean is_messenger_enabled;
    public final Integer trigger_delay_ms;

    public static final class Builder extends Message.Builder<ComposerSetting, Builder> {
        public Boolean can_personalize;
        public Boolean is_docs_enabled;
        public Boolean is_enabled;
        public Boolean is_mail_enabled;
        public Boolean is_messenger_enabled;
        public Integer trigger_delay_ms;

        public ComposerSetting build() {
            return new ComposerSetting(this.is_enabled, this.can_personalize, this.trigger_delay_ms, this.is_messenger_enabled, this.is_docs_enabled, this.is_mail_enabled, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m4build() {
            return build();
        }

        public Builder can_personalize(Boolean r1) {
            this.can_personalize = r1;
            return this;
        }

        public Builder is_docs_enabled(Boolean r1) {
            this.is_docs_enabled = r1;
            return this;
        }

        public Builder is_enabled(Boolean r1) {
            this.is_enabled = r1;
            return this;
        }

        public Builder is_mail_enabled(Boolean r1) {
            this.is_mail_enabled = r1;
            return this;
        }

        public Builder is_messenger_enabled(Boolean r1) {
            this.is_messenger_enabled = r1;
            return this;
        }

        public Builder trigger_delay_ms(Integer r1) {
            this.trigger_delay_ms = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ComposerSetting extends ProtoAdapter<ComposerSetting> {
        public ProtoAdapter_ComposerSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ComposerSetting.class);
        }

        public ComposerSetting decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.is_enabled = r1;
            r0.can_personalize = r1;
            r0.trigger_delay_ms = 100;
            r0.is_messenger_enabled = r1;
            r0.is_docs_enabled = r1;
            r0.is_mail_enabled = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.is_mail_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            r0.is_docs_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L9:
            r0.is_messenger_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            r0.trigger_delay_ms = (Integer) ProtoAdapter.INT32.decode(r7);
            goto L3
        L11:
            r0.can_personalize = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L12:
            r0.is_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r2);
            return r0.build();
        }

        public int encodedSize(ComposerSetting r6) {
            Boolean r0 = r6.is_enabled;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.can_personalize;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Integer r7 = r6.trigger_delay_ms;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT32.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            Boolean r10 = r6.is_messenger_enabled;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            Boolean r13 = r6.is_docs_enabled;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            Boolean r16 = r6.is_mail_enabled;
            if (r16 == null) goto L26;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r16);
        L26:
            return (r15 + r1) + r6.unknownFields().size();
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m5decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ComposerSetting) r1);
        }

        public void encode(ProtoWriter r4, ComposerSetting r5) throws IOException {
            Boolean r0 = r5.is_enabled;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.can_personalize;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Integer r2 = r5.trigger_delay_ms;
            if (r2 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r2);
        L11:
            Boolean r3 = r5.is_messenger_enabled;
            if (r3 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r4, 4, r3);
        L14:
            Boolean r6 = r5.is_docs_enabled;
            if (r6 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r4, 5, r6);
        L17:
            Boolean r7 = r5.is_mail_enabled;
            if (r7 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r4, 6, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ComposerSetting) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ComposerSetting();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_ENABLED = r0;
        DEFAULT_CAN_PERSONALIZE = r0;
        DEFAULT_TRIGGER_DELAY_MS = 100;
        DEFAULT_IS_MESSENGER_ENABLED = r0;
        DEFAULT_IS_DOCS_ENABLED = r0;
        DEFAULT_IS_MAIL_ENABLED = r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.is_enabled = this.is_enabled;
        r0.can_personalize = this.can_personalize;
        r0.trigger_delay_ms = this.trigger_delay_ms;
        r0.is_messenger_enabled = this.is_messenger_enabled;
        r0.is_docs_enabled = this.is_docs_enabled;
        r0.is_mail_enabled = this.is_mail_enabled;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ComposerSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m3newBuilder() {
        return newBuilder();
    }

    public ComposerSetting(Boolean r9, Boolean r10, Integer r11, Boolean r12, Boolean r13, Boolean r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public ComposerSetting(Boolean r2, Boolean r3, Integer r4, Boolean r5, Boolean r6, Boolean r7, ByteString r8) {
        super(ADAPTER, r8);
        this.is_enabled = r2;
        this.can_personalize = r3;
        this.trigger_delay_ms = r4;
        this.is_messenger_enabled = r5;
        this.is_docs_enabled = r6;
        this.is_mail_enabled = r7;
    }
}
