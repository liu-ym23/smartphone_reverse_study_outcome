package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0004\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\b\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006'"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TimeProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "startTimeStamp", "", "isCountDown", "", "ntpActionId", "", "isEnd", "endTimeStamp", "<init>", "(Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;)V", "getStartTimeStamp", "()Ljava/lang/Long;", "setStartTimeStamp", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "setCountDown", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNtpActionId", "()Ljava/lang/String;", "setNtpActionId", "(Ljava/lang/String;)V", "setEnd", "getEndTimeStamp", "setEndTimeStamp", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", "other", "", "hashCode", "", "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeProperty extends BaseProperty {
    private Long endTimeStamp;
    private Boolean isCountDown;
    private Boolean isEnd;
    private String ntpActionId;
    private Long startTimeStamp;

    public TimeProperty() {
        this(null, null, null, null, null, 31, null);
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public Props clone() {
        return new TimeProperty(this.startTimeStamp, this.isCountDown, this.ntpActionId, this.isEnd, this.endTimeStamp);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        Long r101 = this.startTimeStamp;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.isCountDown;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.ntpActionId;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.isEnd;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Long r114 = this.endTimeStamp;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final Long getEndTimeStamp() {
        return this.endTimeStamp;
    }

    public final String getNtpActionId() {
        return this.ntpActionId;
    }

    public final Long getStartTimeStamp() {
        return this.startTimeStamp;
    }

    public final Boolean isCountDown() {
        return this.isCountDown;
    }

    public final Boolean isEnd() {
        return this.isEnd;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(TimeProperty.class, r101) == true) goto L13;
        return false;
    L13:
        if (super.equals(r100) == true) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.preview.entity.component.property.TimeProperty");
        TimeProperty r102 = (TimeProperty) r100;
        if (Intrinsics.areEqual(this.startTimeStamp, r102.startTimeStamp) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.isCountDown, r102.isCountDown) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.ntpActionId, r102.ntpActionId) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.isEnd, r102.isEnd) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.endTimeStamp, r102.endTimeStamp) == true) goto L30;
        return false;
    L30:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L37;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        Long r104 = null;
        Long r105 = null;
        Boolean r106 = null;
        String r107 = null;
        Boolean r108 = null;
        if (r103 == ComponentAttribute.start_time_stamp.getValue()) goto L9;
        if (r103 == ComponentAttribute.is_countdown.getValue()) goto L15;
        if (r103 == ComponentAttribute.ntp_action_id.getValue()) goto L21;
        if (r103 == ComponentAttribute.is_end.getValue()) goto L27;
        if (r103 != ComponentAttribute.end_time_stamp.getValue()) goto L6;
        PreviewData r109 = r102.getValue();
        if (r109 == null) goto L36;
        r105 = r109.getLong();
    L36:
        this.endTimeStamp = r105;
        goto L6
    L27:
        PreviewData r110 = r102.getValue();
        if (r110 == null) goto L30;
        r106 = r110.getBoolean();
    L30:
        this.isEnd = r106;
        goto L6
    L21:
        PreviewData r111 = r102.getValue();
        if (r111 == null) goto L24;
        r107 = r111.getString();
    L24:
        this.ntpActionId = r107;
        goto L6
    L15:
        PreviewData r112 = r102.getValue();
        if (r112 == null) goto L18;
        r108 = r112.getBoolean();
    L18:
        this.isCountDown = r108;
        goto L6
    L9:
        PreviewData r113 = r102.getValue();
        if (r113 == null) goto L12;
        r104 = r113.getLong();
    L12:
        this.startTimeStamp = r104;
        goto L6
    }

    public final void setCountDown(Boolean r100) {
        this.isCountDown = r100;
    }

    public final void setEnd(Boolean r100) {
        this.isEnd = r100;
    }

    public final void setEndTimeStamp(Long r100) {
        this.endTimeStamp = r100;
    }

    public final void setNtpActionId(String r100) {
        this.ntpActionId = r100;
    }

    public final void setStartTimeStamp(Long r100) {
        this.startTimeStamp = r100;
    }

    public TimeProperty(Long r100, Boolean r101, String r102, Boolean r103, Long r104) {
        super(Type.TIME);
        this.startTimeStamp = r100;
        this.isCountDown = r101;
        this.ntpActionId = r102;
        this.isEnd = r103;
        this.endTimeStamp = r104;
    }

    public /* synthetic */ TimeProperty(Long r100, Boolean r101, String r102, Boolean r103, Long r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Long r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = Boolean.FALSE;
    L9:
        Boolean r105 = r101;
        if ((r110 & 4) == 0) goto L12;
        String r106 = null;
    L14:
        if ((r110 & 8) == 0) goto L16;
        Boolean r107 = null;
    L18:
        if ((r110 & 16) == 0) goto L20;
        Long r113 = null;
    L21:
        this(r112, r105, r106, r107, r113);
        return;
    L20:
        r113 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L5:
        r112 = r100;
        goto L7
    }
}
