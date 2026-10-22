package ic8;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.bean.RecordStreamCache;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001KB\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010C\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u009e\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\u0006HÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\"\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b0\u0010\"\"\u0004\b1\u0010$R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0013\u00106\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b7\u0010\u0015¨\u0006L"}, d2 = {"Lcom/larus/bmhome/chat/bean/RecordCardData;", "", "tips", "", "buttonText", "progress", "", "shouldStartDirectly", "recordMsgGenTime", "", "startRecordInterval", "recordId", "meetingId", "status", "duration", "time", "summaryContent", "Lcom/larus/bmhome/chat/bean/RecordCardData$SummaryContent;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Lcom/larus/bmhome/chat/bean/RecordCardData$SummaryContent;)V", "getTips", "()Ljava/lang/String;", "setTips", "(Ljava/lang/String;)V", "getButtonText", "setButtonText", "getProgress", "()Ljava/lang/Integer;", "setProgress", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getShouldStartDirectly", "setShouldStartDirectly", "getRecordMsgGenTime", "()Ljava/lang/Long;", "setRecordMsgGenTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getStartRecordInterval", "setStartRecordInterval", "getRecordId", "setRecordId", "getMeetingId", "setMeetingId", "getStatus", "setStatus", "getDuration", "setDuration", "getTime", "setTime", "getSummaryContent", "()Lcom/larus/bmhome/chat/bean/RecordCardData$SummaryContent;", "setSummaryContent", "(Lcom/larus/bmhome/chat/bean/RecordCardData$SummaryContent;)V", "asrContent", "getAsrContent", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Lcom/larus/bmhome/chat/bean/RecordCardData$SummaryContent;)Lcom/larus/bmhome/chat/bean/RecordCardData;", "equals", "", "other", "hashCode", "toString", "SummaryContent", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p0 {

    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("meeting_id")
    private String meetingId;

    @SerializedName("progress")
    private Integer progress;

    @SerializedName("record_id")
    private String recordId;

    @SerializedName("record_msg_gen_time")
    private Long recordMsgGenTime;

    @SerializedName("should_start_directly")
    private Integer shouldStartDirectly;

    @SerializedName("start_record_interval")
    private Long startRecordInterval;

    @SerializedName("status")
    private Integer status;

    @SerializedName("summary_content")
    private a summaryContent;

    @SerializedName("time")
    private Long time;

    @SerializedName("tips")
    private String tips;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018Jb\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001a¨\u00062"}, d2 = {"Lcom/larus/bmhome/chat/bean/RecordCardData$SummaryContent;", "", "title", "", "time", "", "duration", "", "audioURL", "content", "meetingId", "generateType", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getAudioURL", "setAudioURL", "getContent", "setContent", "getMeetingId", "setMeetingId", "getGenerateType", "setGenerateType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/bean/RecordCardData$SummaryContent;", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("audio_url")
        private String audioURL;

        @SerializedName("content")
        private String content;

        @SerializedName("duration")
        private Integer duration;

        @SerializedName("generate_type")
        private Integer generateType;

        @SerializedName("meeting_id")
        private String meetingId;

        @SerializedName("time")
        private Long time;

        @SerializedName("title")
        private String title;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.time, r101.time) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.audioURL, r101.audioURL) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.meetingId, r101.meetingId) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.generateType, r101.generateType) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r100 = this.title;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Long r104 = this.time;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.duration;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.audioURL;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.content;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.meetingId;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            Integer r119 = this.generateType;
            if (r119 == null) goto L31;
            r101 = r119.hashCode();
        L31:
            return r118 + r101;
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "SummaryContent(title=" + this.title + ", time=" + this.time + ", duration=" + this.duration + ", audioURL=" + this.audioURL + ", content=" + this.content + ", meetingId=" + this.meetingId + ", generateType=" + this.generateType + ')';
        }

        public a() {
            this.title = null;
            this.time = null;
            this.duration = null;
            this.audioURL = null;
            this.content = null;
            this.meetingId = null;
            this.generateType = null;
        }

        public final String a() {
            return this.content;
        }

        public final Integer b() {
            return this.duration;
        }

        public final Integer c() {
            return this.generateType;
        }

        public final Long d() {
            return this.time;
        }

        public final String e() {
            return this.title;
        }
    }

    public p0() {
        this(null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (Intrinsics.areEqual(this.tips, r101.tips) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.buttonText, r101.buttonText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.progress, r101.progress) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.shouldStartDirectly, r101.shouldStartDirectly) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.recordMsgGenTime, r101.recordMsgGenTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.startRecordInterval, r101.startRecordInterval) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.recordId, r101.recordId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.meetingId, r101.meetingId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.time, r101.time) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.summaryContent, r101.summaryContent) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.tips;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.buttonText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.progress;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.shouldStartDirectly;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.recordMsgGenTime;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.startRecordInterval;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.recordId;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.meetingId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.status;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.duration;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Long r131 = this.time;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        a r134 = this.summaryContent;
        if (r134 == null) goto L51;
        r101 = r134.hashCode();
    L51:
        return r133 + r101;
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecordCardData(tips=" + this.tips + ", buttonText=" + this.buttonText + ", progress=" + this.progress + ", shouldStartDirectly=" + this.shouldStartDirectly + ", recordMsgGenTime=" + this.recordMsgGenTime + ", startRecordInterval=" + this.startRecordInterval + ", recordId=" + this.recordId + ", meetingId=" + this.meetingId + ", status=" + this.status + ", duration=" + this.duration + ", time=" + this.time + ", summaryContent=" + this.summaryContent + ')';
    }

    public final String a() {
        RecordStreamCache r100 = RecordStreamCache.f297434a;
        String r101 = this.recordId;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r102 = r100.get(r101);
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    }

    public final Integer b() {
        return this.duration;
    }

    public final String c() {
        return this.meetingId;
    }

    public final Integer d() {
        return this.status;
    }

    public final a e() {
        return this.summaryContent;
    }

    public final Long f() {
        return this.time;
    }

    public p0(String r100, Integer r101, Integer r102, int r103) {
        if ((r103 & 128) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 256) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 512) == 0) goto L11;
        r102 = null;
    L11:
        this.tips = null;
        this.buttonText = null;
        this.progress = null;
        this.shouldStartDirectly = null;
        this.recordMsgGenTime = null;
        this.startRecordInterval = null;
        this.recordId = null;
        this.meetingId = r100;
        this.status = r101;
        this.duration = r102;
        this.time = null;
        this.summaryContent = null;
    }
}
