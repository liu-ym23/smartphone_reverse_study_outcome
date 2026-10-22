package com.bytedance.lark.pb.todo.v1;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CustomComplete extends Message<CustomComplete, Builder> {
    public static final ProtoAdapter<CustomComplete> ADAPTER = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: android, reason: collision with root package name */
    public final Action f253769android;
    public final Action ios;

    /* JADX INFO: renamed from: pc, reason: collision with root package name */
    public final Action f253770pc;

    public static final class Action extends Message<Action, Builder> {
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final String DEFAULT_HREF = "";
        private static final long serialVersionUID = 0;
        public final String href;
        public final Map<String, String> tip;

        public static final class Builder extends Message.Builder<Action, Builder> {
            public String href;
            public Map<String, String> tip;

            @Override // com.squareup.wire.Message.Builder
            public Action build() {
                return new Action(this.href, this.tip, super.buildUnknownFields());
            }

            public Builder() {
                this.tip = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder href(String r100) {
                this.href = r100;
                return this;
            }

            public Builder tip(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.tip = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Action extends ProtoAdapter<Action> {
            private final ProtoAdapter<Map<String, String>> tip;

            public ProtoAdapter_Action() {
                super(FieldEncoding.LENGTH_DELIMITED, Action.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.tip = ProtoAdapter.newMapAdapter(r100, r100);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Action decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.href = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.href = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.tip.putAll(this.tip.decode(r100));
                goto L3
            L9:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L12:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Action r100) {
                String r101 = r100.href;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + this.tip.encodedSizeWithTag(2, r100.tip)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Action decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Action r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Action r101) throws IOException {
                String r102 = r101.href;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                this.tip.encodeWithTag(r100, 2, r101.tip);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Action r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Action();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.href = this.href;
            r100.tip = Internal.copyOf(AppConstants.BUNDLE_TIP, this.tip);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Action.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Action(String r100, Map<String, String> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public Action(String r100, Map<String, String> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.href = r100;
            this.tip = Internal.immutableCopyOf(AppConstants.BUNDLE_TIP, r101);
        }
    }

    public static final class Builder extends Message.Builder<CustomComplete, Builder> {

        /* JADX INFO: renamed from: android, reason: collision with root package name */
        public Action f253771android;
        public Action ios;

        /* JADX INFO: renamed from: pc, reason: collision with root package name */
        public Action f253772pc;

        @Override // com.squareup.wire.Message.Builder
        public CustomComplete build() {
            return new CustomComplete(this.f253771android, this.ios, this.f253772pc, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder android(Action r100) {
            this.f253771android = r100;
            return this;
        }

        public Builder ios(Action r100) {
            this.ios = r100;
            return this;
        }

        public Builder pc(Action r100) {
            this.f253772pc = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomComplete extends ProtoAdapter<CustomComplete> {
        public ProtoAdapter_CustomComplete() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomComplete.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomComplete decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f253771android = Action.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.ios = Action.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.f253772pc = Action.ADAPTER.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CustomComplete r100) {
            Action r101 = r100.f253769android;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Action.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Action r104 = r100.ios;
            if (r104 == null) goto L9;
            int r105 = Action.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Action r107 = r100.f253770pc;
            if (r107 == null) goto L14;
            r102 = Action.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ CustomComplete decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomComplete r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomComplete r101) throws IOException {
            Action r102 = r101.f253769android;
            if (r102 == null) goto L5;
            Action.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Action r103 = r101.ios;
            if (r103 == null) goto L8;
            Action.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Action r104 = r101.f253770pc;
            if (r104 == null) goto L11;
            Action.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomComplete r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomComplete();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253771android = this.f253769android;
        r100.ios = this.ios;
        r100.f253772pc = this.f253770pc;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomComplete.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomComplete(Action r100, Action r101, Action r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CustomComplete(Action r100, Action r101, Action r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f253769android = r100;
        this.ios = r101;
        this.f253770pc = r102;
    }
}
