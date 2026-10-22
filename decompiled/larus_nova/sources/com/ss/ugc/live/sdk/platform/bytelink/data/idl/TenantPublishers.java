package com.ss.ugc.live.sdk.platform.bytelink.data.idl;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes36.dex */
public final class TenantPublishers extends AndroidMessage<TenantPublishers, Builder> {
    public static final ProtoAdapter<TenantPublishers> ADAPTER = null;
    public static final Parcelable.Creator<TenantPublishers> CREATOR = null;
    public static final String DEFAULT_FROM_PAGE = "";
    public static final String DEFAULT_TO_PAGE = "";
    public static final String DEFAULT_TRIGGER_REASON = "";
    public static final Long DEFAULT_UPDATE_TIME_MS = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String from_page;

    @WireField(adapter = "com.ss.ugc.live.sdk.msg.PublisherInfo#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<PublisherInfo> publisher_info_list;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String to_page;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String trigger_reason;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long update_time_ms;

    public static final class Builder extends Message.Builder<TenantPublishers, Builder> {
        public String from_page;
        public List<PublisherInfo> publisher_info_list;
        public String to_page;
        public String trigger_reason;
        public Long update_time_ms;

        @Override // com.squareup.wire.Message.Builder
        public TenantPublishers build() {
            return new TenantPublishers(this.publisher_info_list, this.trigger_reason, this.from_page, this.to_page, this.update_time_ms, super.buildUnknownFields());
        }

        public Builder() {
            this.trigger_reason = "";
            this.from_page = "";
            this.to_page = "";
            this.update_time_ms = 0L;
            this.publisher_info_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder from_page(String r100) {
            this.from_page = r100;
            return this;
        }

        public Builder publisher_info_list(List<PublisherInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.publisher_info_list = r100;
            return this;
        }

        public Builder to_page(String r100) {
            this.to_page = r100;
            return this;
        }

        public Builder trigger_reason(String r100) {
            this.trigger_reason = r100;
            return this;
        }

        public Builder update_time_ms(Long r100) {
            this.update_time_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TenantPublishers extends ProtoAdapter<TenantPublishers> {
        public ProtoAdapter_TenantPublishers() {
            super(FieldEncoding.LENGTH_DELIMITED, TenantPublishers.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TenantPublishers decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.publisher_info_list.add(PublisherInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.trigger_reason(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.from_page(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.to_page(ProtoAdapter.STRING.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.update_time_ms(ProtoAdapter.INT64.decode(r100));
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
        public int encodedSize2(TenantPublishers r100) {
            int r101 = PublisherInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.publisher_info_list);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return ((((r101 + r102.encodedSizeWithTag(2, r100.trigger_reason)) + r102.encodedSizeWithTag(3, r100.from_page)) + r102.encodedSizeWithTag(4, r100.to_page)) + ProtoAdapter.INT64.encodedSizeWithTag(5, r100.update_time_ms)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public TenantPublishers redact2(TenantPublishers r100) {
            Builder r101 = r100.newBuilder();
            Internal.redactElements(r101.publisher_info_list, PublisherInfo.ADAPTER);
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TenantPublishers decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TenantPublishers r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TenantPublishers redact(TenantPublishers r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TenantPublishers r101) throws IOException {
            PublisherInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.publisher_info_list);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.trigger_reason);
            r102.encodeWithTag(r100, 3, r101.from_page);
            r102.encodeWithTag(r100, 4, r101.to_page);
            ProtoAdapter.INT64.encodeWithTag(r100, 5, r101.update_time_ms);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TenantPublishers r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_TenantPublishers r100 = new ProtoAdapter_TenantPublishers();
        ADAPTER = r100;
        CREATOR = AndroidMessage.newCreator(r100);
        DEFAULT_UPDATE_TIME_MS = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L21;
        int r101 = ((unknownFields().hashCode() * 37) + this.publisher_info_list.hashCode()) * 37;
        String r102 = this.trigger_reason;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.from_page;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        String r109 = this.to_page;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Long r112 = this.update_time_ms;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        int r113 = r111 + r103;
        this.hashCode = r113;
        return r113;
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L21:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.publisher_info_list = Internal.copyOf("publisher_info_list", this.publisher_info_list);
        r100.trigger_reason = this.trigger_reason;
        r100.from_page = this.from_page;
        r100.to_page = this.to_page;
        r100.update_time_ms = this.update_time_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        List<PublisherInfo> r101 = this.publisher_info_list;
        if (r101 == null) goto L8;
        if (r101.isEmpty() == true) goto L8;
        r100.append(", publisher_info_list=");
        r100.append(this.publisher_info_list);
    L8:
        if (this.trigger_reason == null) goto L11;
        r100.append(", trigger_reason=");
        r100.append(this.trigger_reason);
    L11:
        if (this.from_page == null) goto L14;
        r100.append(", from_page=");
        r100.append(this.from_page);
    L14:
        if (this.to_page == null) goto L17;
        r100.append(", to_page=");
        r100.append(this.to_page);
    L17:
        if (this.update_time_ms == null) goto L19;
        r100.append(", update_time_ms=");
        r100.append(this.update_time_ms);
    L19:
        StringBuilder r102 = r100.replace(0, 2, "TenantPublishers{");
        r102.append('}');
        return r102.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof TenantPublishers) == true) goto L8;
        return false;
    L8:
        TenantPublishers r101 = (TenantPublishers) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (this.publisher_info_list.equals(r101.publisher_info_list) == false) goto L21;
        if (Internal.equals(this.trigger_reason, r101.trigger_reason) == false) goto L21;
        if (Internal.equals(this.from_page, r101.from_page) == false) goto L21;
        if (Internal.equals(this.to_page, r101.to_page) == false) goto L21;
        if (Internal.equals(this.update_time_ms, r101.update_time_ms) == false) goto L21;
        return true;
    }

    public TenantPublishers(List<PublisherInfo> r100, String r101, String r110, String r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public TenantPublishers(List<PublisherInfo> r100, String r101, String r102, String r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.publisher_info_list = Internal.immutableCopyOf("publisher_info_list", r100);
        this.trigger_reason = r101;
        this.from_page = r102;
        this.to_page = r103;
        this.update_time_ms = r104;
    }
}
