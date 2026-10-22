package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class MobileComposerSetting extends Message<MobileComposerSetting, Builder> {
    public static final ProtoAdapter<MobileComposerSetting> ADAPTER = null;
    public static final Boolean DEFAULT_IS_DOCS_ENABLED = null;
    public static final Boolean DEFAULT_IS_MAIL_ENABLED = null;
    public static final Boolean DEFAULT_IS_MESSENGER_ENABLED = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_docs_enabled;
    public final Boolean is_mail_enabled;
    public final Boolean is_messenger_enabled;

    public static final class Builder extends Message.Builder<MobileComposerSetting, Builder> {
        public Boolean is_docs_enabled;
        public Boolean is_mail_enabled;
        public Boolean is_messenger_enabled;

        public MobileComposerSetting build() {
            return new MobileComposerSetting(this.is_messenger_enabled, this.is_docs_enabled, this.is_mail_enabled, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m25build() {
            return build();
        }

        public Builder is_docs_enabled(Boolean r1) {
            this.is_docs_enabled = r1;
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
    }

    public static final class ProtoAdapter_MobileComposerSetting extends ProtoAdapter<MobileComposerSetting> {
        public ProtoAdapter_MobileComposerSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, MobileComposerSetting.class);
        }

        public MobileComposerSetting decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            Boolean r1 = Boolean.FALSE;
            r0.is_messenger_enabled = r1;
            r0.is_docs_enabled = r1;
            r0.is_mail_enabled = r1;
            long r2 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            if (r3 != 1) goto L8;
            r0.is_messenger_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.is_docs_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.is_mail_enabled = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L11:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r2);
            return r0.build();
        }

        public int encodedSize(MobileComposerSetting r6) {
            Boolean r0 = r6.is_messenger_enabled;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r0);
        L6:
            Boolean r3 = r6.is_docs_enabled;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Boolean r7 = r6.is_mail_enabled;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m26decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MobileComposerSetting) r1);
        }

        public void encode(ProtoWriter r4, MobileComposerSetting r5) throws IOException {
            Boolean r0 = r5.is_messenger_enabled;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r0);
        L5:
            Boolean r1 = r5.is_docs_enabled;
            if (r1 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r4, 2, r1);
        L8:
            Boolean r2 = r5.is_mail_enabled;
            if (r2 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MobileComposerSetting) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MobileComposerSetting();
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_MESSENGER_ENABLED = r0;
        DEFAULT_IS_DOCS_ENABLED = r0;
        DEFAULT_IS_MAIL_ENABLED = r0;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.is_messenger_enabled = this.is_messenger_enabled;
        r0.is_docs_enabled = this.is_docs_enabled;
        r0.is_mail_enabled = this.is_mail_enabled;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MobileComposerSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m24newBuilder() {
        return newBuilder();
    }

    public MobileComposerSetting(Boolean r2, Boolean r3, Boolean r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public MobileComposerSetting(Boolean r2, Boolean r3, Boolean r4, ByteString r5) {
        super(ADAPTER, r5);
        this.is_messenger_enabled = r2;
        this.is_docs_enabled = r3;
        this.is_mail_enabled = r4;
    }
}
