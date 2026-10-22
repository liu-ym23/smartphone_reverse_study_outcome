package ai.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class PushComposerSetting extends Message<PushComposerSetting, Builder> {
    public static final ProtoAdapter<PushComposerSetting> ADAPTER = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final ProtoAdapter_PushComposerSetting RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ComposerSetting composer_setting;
    public final Long update_time;

    public static final class Builder extends Message.Builder<PushComposerSetting, Builder> implements d<PushComposerSetting> {
        public ComposerSetting composer_setting;
        public Long update_time;

        public PushComposerSetting build() {
            return new PushComposerSetting(this.composer_setting, this.update_time, super.buildUnknownFields());
        }

        public Builder() {
        }

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Message m28build() {
            return build();
        }

        public Builder composer_setting(ComposerSetting r1) {
            this.composer_setting = r1;
            return this;
        }

        public Builder update_time(Long r1) {
            this.update_time = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PushComposerSetting extends ProtoAdapter<PushComposerSetting> implements c<PushComposerSetting> {
        public ProtoAdapter_PushComposerSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, PushComposerSetting.class);
        }

        public PushComposerSetting decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.update_time = 0L;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L12;
            if (r3 != 1) goto L8;
            r0.composer_setting = (ComposerSetting) ComposerSetting.ADAPTER.decode(r7);
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.update_time = (Long) ProtoAdapter.INT64.decode(r7);
            goto L3
        L9:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L12:
            r7.endMessage(r1);
            return r0.build();
        }

        public int encodedSize(PushComposerSetting r5) {
            ComposerSetting r0 = r5.composer_setting;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ComposerSetting.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            Long r3 = r5.update_time;
            if (r3 == null) goto L10;
            r1 = ProtoAdapter.INT64.encodedSizeWithTag(2, r3);
        L10:
            return (r2 + r1) + r5.unknownFields().size();
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m29decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PushComposerSetting) r1);
        }

        public void encode(ProtoWriter r4, PushComposerSetting r5) throws IOException {
            ComposerSetting r0 = r5.composer_setting;
            if (r0 == null) goto L5;
            ComposerSetting.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            Long r1 = r5.update_time;
            if (r1 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r4, 2, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PushComposerSetting) r2);
        }
    }

    static {
        ProtoAdapter_PushComposerSetting r0 = new ProtoAdapter_PushComposerSetting();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_UPDATE_TIME = 0L;
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.composer_setting = this.composer_setting;
        r0.update_time = this.update_time;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PushComposerSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Message.Builder m27newBuilder() {
        return newBuilder();
    }

    public PushComposerSetting(ComposerSetting r2, Long r3) {
        this(r2, r3, ByteString.EMPTY);
    }

    public PushComposerSetting(ComposerSetting r2, Long r3, ByteString r4) {
        super(ADAPTER, r4);
        this.composer_setting = r2;
        this.update_time = r3;
    }
}
