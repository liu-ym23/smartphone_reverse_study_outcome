package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003J]\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingEntity;", "Ljava/io/Serializable;", "recordingId", "", "openSource", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingPageOpenSource;", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "messageId", "conversationId", "botId", "doubaoStatisticInfo", "Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoStatisticInfo;", "source", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingPageOpenSource;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoStatisticInfo;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;)V", "getRecordingId", "()Ljava/lang/String;", "getOpenSource", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmRecordingPageOpenSource;", "getUiLaunchMode", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "getMessageId$annotations", "()V", "getMessageId", "getConversationId$annotations", "getConversationId", "getBotId$annotations", "getBotId", "getDoubaoStatisticInfo", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/DoubaoStatisticInfo;", "getSource", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmRecordingEntity implements Serializable {
    private final String botId;
    private final String conversationId;
    private final DoubaoStatisticInfo doubaoStatisticInfo;
    private final String messageId;
    private final MmRecordingPageOpenSource openSource;
    private final String recordingId;
    private final MmRecordingSource source;
    private final MmRecordingUILaunchMode uiLaunchMode;

    public static /* synthetic */ MmRecordingEntity copy$default(MmRecordingEntity r100, String r110, MmRecordingPageOpenSource r111, MmRecordingUILaunchMode r112, String r113, String r114, String r115, DoubaoStatisticInfo r116, MmRecordingSource r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.recordingId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        MmRecordingPageOpenSource r102 = r100.openSource;
    L11:
        if ((r118 & 4) == 0) goto L13;
        MmRecordingUILaunchMode r103 = r100.uiLaunchMode;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.messageId;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.conversationId;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.botId;
    L27:
        if ((r118 & 64) == 0) goto L29;
        DoubaoStatisticInfo r107 = r100.doubaoStatisticInfo;
    L31:
        if ((r118 & 128) == 0) goto L33;
        MmRecordingSource r108 = r100.source;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    @Deprecated(message = "use doubaoStatisticInfo")
    public static /* synthetic */ void getBotId$annotations() {
    }

    @Deprecated(message = "use doubaoStatisticInfo")
    public static /* synthetic */ void getConversationId$annotations() {
    }

    @Deprecated(message = "use doubaoStatisticInfo")
    public static /* synthetic */ void getMessageId$annotations() {
    }

    public final String component1() {
        return this.recordingId;
    }

    public final MmRecordingPageOpenSource component2() {
        return this.openSource;
    }

    public final MmRecordingUILaunchMode component3() {
        return this.uiLaunchMode;
    }

    public final String component4() {
        return this.messageId;
    }

    public final String component5() {
        return this.conversationId;
    }

    public final String component6() {
        return this.botId;
    }

    public final DoubaoStatisticInfo component7() {
        return this.doubaoStatisticInfo;
    }

    public final MmRecordingSource component8() {
        return this.source;
    }

    public final MmRecordingEntity copy(String r110, MmRecordingPageOpenSource r111, MmRecordingUILaunchMode r112, String r113, String r114, String r115, DoubaoStatisticInfo r116, MmRecordingSource r117) {
        Intrinsics.checkNotNullParameter(r110, "recordingId");
        Intrinsics.checkNotNullParameter(r111, "openSource");
        Intrinsics.checkNotNullParameter(r112, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r113, "messageId");
        Intrinsics.checkNotNullParameter(r114, "conversationId");
        Intrinsics.checkNotNullParameter(r115, "botId");
        return new MmRecordingEntity(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmRecordingEntity) == true) goto L8;
        return false;
    L8:
        MmRecordingEntity r101 = (MmRecordingEntity) r100;
        if (Intrinsics.areEqual(this.recordingId, r101.recordingId) == true) goto L12;
        return false;
    L12:
        if (this.openSource == r101.openSource) goto L15;
        return false;
    L15:
        if (this.uiLaunchMode == r101.uiLaunchMode) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.doubaoStatisticInfo, r101.doubaoStatisticInfo) == true) goto L30;
        return false;
    L30:
        if (this.source == r101.source) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.recordingId.hashCode() * 31) + this.openSource.hashCode()) * 31) + this.uiLaunchMode.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.conversationId.hashCode()) * 31) + this.botId.hashCode()) * 31;
        DoubaoStatisticInfo r101 = this.doubaoStatisticInfo;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        MmRecordingSource r105 = this.source;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MmRecordingEntity(recordingId=" + this.recordingId + ", openSource=" + this.openSource + ", uiLaunchMode=" + this.uiLaunchMode + ", messageId=" + this.messageId + ", conversationId=" + this.conversationId + ", botId=" + this.botId + ", doubaoStatisticInfo=" + this.doubaoStatisticInfo + ", source=" + this.source + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final DoubaoStatisticInfo getDoubaoStatisticInfo() {
        return this.doubaoStatisticInfo;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final MmRecordingPageOpenSource getOpenSource() {
        return this.openSource;
    }

    public final String getRecordingId() {
        return this.recordingId;
    }

    public final MmRecordingSource getSource() {
        return this.source;
    }

    public final MmRecordingUILaunchMode getUiLaunchMode() {
        return this.uiLaunchMode;
    }

    public MmRecordingEntity(String r100, MmRecordingPageOpenSource r101, MmRecordingUILaunchMode r102, String r103, String r104, String r105, DoubaoStatisticInfo r106, MmRecordingSource r107) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        Intrinsics.checkNotNullParameter(r101, "openSource");
        Intrinsics.checkNotNullParameter(r102, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r103, "messageId");
        Intrinsics.checkNotNullParameter(r104, "conversationId");
        Intrinsics.checkNotNullParameter(r105, "botId");
        this.recordingId = r100;
        this.openSource = r101;
        this.uiLaunchMode = r102;
        this.messageId = r103;
        this.conversationId = r104;
        this.botId = r105;
        this.doubaoStatisticInfo = r106;
        this.source = r107;
    }

    public /* synthetic */ MmRecordingEntity(String r110, MmRecordingPageOpenSource r111, MmRecordingUILaunchMode r112, String r113, String r114, String r115, DoubaoStatisticInfo r116, MmRecordingSource r117, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 4) == 0) goto L5;
        MmRecordingUILaunchMode r100 = MmRecordingUILaunchMode.UNKNOWN;
    L7:
        if ((r210 & 8) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r210 & 16) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r210 & 32) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r210 & 64) == 0) goto L21;
        DoubaoStatisticInfo r104 = null;
    L23:
        if ((r210 & 128) == 0) goto L25;
        MmRecordingSource r118 = null;
    L26:
        this(r110, r111, r100, r101, r102, r103, r104, r118);
        return;
    L25:
        r118 = r117;
        goto L26
    L21:
        r104 = r116;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
