package com.obric.capabilitykit.common;

import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0001QB\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010/J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u0094\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010L\u001a\u00020\u0014J\u0006\u0010M\u001a\u00020NJ\t\u0010O\u001a\u00020\fHÖ\u0001J\t\u0010P\u001a\u00020\u0006HÖ\u0001R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010 R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001e\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006R"}, d2 = {"Lcom/obric/capabilitykit/common/IMAppAction;", "", "id", "", "messageId", "localMessageId", "", "replyId", "questionId", "createTime", "content", "messageType", "", "actionId", "jobId", "version", "ext", "Lcom/obric/capabilitykit/common/IMAppActionExt;", "(JLjava/lang/Long;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;JJILcom/obric/capabilitykit/common/IMAppActionExt;)V", "action", "Lcom/obric/capabilitykit/common/AppAction;", "getActionId", "()J", "setActionId", "(J)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExt", "()Lcom/obric/capabilitykit/common/IMAppActionExt;", "setExt", "(Lcom/obric/capabilitykit/common/IMAppActionExt;)V", "getId", "setId", "getJobId", "setJobId", "getLocalMessageId", "setLocalMessageId", "getMessageId", "setMessageId", "getMessageType", "()Ljava/lang/Integer;", "setMessageType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuestionId", "setQuestionId", "getReplyId", "setReplyId", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/Long;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;JJILcom/obric/capabilitykit/common/IMAppActionExt;)Lcom/obric/capabilitykit/common/IMAppAction;", "equals", "", "other", "getAction", "getVersionInfo", "Lcom/obric/capabilitykit/common/VersionInfo;", "hashCode", "toString", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IMAppAction {
    public static final b Companion = null;
    private static final String TAG = "IMAppAction";
    private static final Lazy<Gson> gson$delegate = null;
    private transient AppAction action;

    @SerializedName("action_id")
    private long actionId;

    @SerializedName("content")
    private String content;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private Long createTime;

    @SerializedName("ext")
    private IMAppActionExt ext;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f396158id;

    @SerializedName(Ext.KEY_JOB_ID)
    private long jobId;

    @SerializedName("local_message_id")
    private String localMessageId;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private Long messageId;

    @SerializedName("message_type")
    private Integer messageType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID)
    private Long questionId;

    @SerializedName(NoticeInfo.KEY_REPLY_ID)
    private long replyId;

    @SerializedName("version")
    private int version;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/google/gson/Gson;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/google/gson/Gson;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a extends Lambda implements Function0<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f396159a = null;

        static {
            f396159a = new a();
        }

        public a() {
            super(0);
        }

        public final Gson a() {
            return new Gson();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Gson invoke() {
            return a();
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {
        public b() {
        }
    }

    static {
        Companion = new b();
        gson$delegate = LazyKt.lazy(a.f396159a);
    }

    public IMAppAction() {
        this(0, null, null, 0, null, null, null, null, 0, 0, 0, null, UnixStat.PERM_MASK, null);
    }

    public IMAppAction(long r100, Long r101, String r102, long r103, Long r110, Long r111, String r112, Integer r113, long r114, long r115, int r116, IMAppActionExt r117) {
        this.f396158id = r100;
        this.messageId = r101;
        this.localMessageId = r102;
        this.replyId = r103;
        this.questionId = r110;
        this.createTime = r111;
        this.content = r112;
        this.messageType = r113;
        this.actionId = r114;
        this.jobId = r115;
        this.version = r116;
        this.ext = r117;
    }

    public /* synthetic */ IMAppAction(long r110, Long r210, String r211, long r212, Long r213, Long r214, String r215, Integer r216, long r217, long r310, int r311, IMAppActionExt r312, int r313, DefaultConstructorMarker r314) {
        if ((r313 & 1) == 0) goto L5;
        long r100 = -1;
    L6:
        IMAppActionExt r101 = null;
        if ((r313 & 2) == 0) goto L9;
        Long r102 = null;
    L11:
        if ((r313 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r313 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r313 & 16) == 0) goto L21;
        Long r105 = null;
    L23:
        if ((r313 & 32) == 0) goto L25;
        Long r111 = null;
    L27:
        if ((r313 & 64) == 0) goto L29;
        String r112 = null;
    L30:
        int r113 = 1;
        if ((r313 & 128) == 0) goto L33;
        Integer r114 = 1;
    L35:
        if ((r313 & 256) == 0) goto L37;
        long r115 = -1;
    L39:
        if ((r313 & 512) == 0) goto L41;
        long r116 = -1;
    L43:
        if ((r313 & 1024) != 0) goto L47;
        r113 = r311;
    L47:
        if ((r313 & 2048) != 0) goto L50;
        r101 = r312;
    L50:
        this(r100, r102, r103, r104, r105, r111, r112, r114, r115, r116, r113, r101);
        return;
    L41:
        r116 = r310;
        goto L43
    L37:
        r115 = r217;
        goto L39
    L33:
        r114 = r216;
        goto L35
    L29:
        r112 = r215;
        goto L30
    L25:
        r111 = r214;
        goto L27
    L21:
        r105 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }

    public static final /* synthetic */ Lazy access$getGson$delegate$cp() {
        return gson$delegate;
    }

    public static /* synthetic */ IMAppAction copy$default(IMAppAction r110, long r111, Long r112, String r210, long r211, Long r212, Long r213, String r214, Integer r215, long r216, long r217, int r310, IMAppActionExt r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        long r100 = r110.f396158id;
    L7:
        if ((r312 & 2) == 0) goto L9;
        Long r101 = r110.messageId;
    L11:
        if ((r312 & 4) == 0) goto L13;
        String r102 = r110.localMessageId;
    L15:
        if ((r312 & 8) == 0) goto L17;
        long r103 = r110.replyId;
    L19:
        if ((r312 & 16) == 0) goto L21;
        Long r104 = r110.questionId;
    L23:
        if ((r312 & 32) == 0) goto L25;
        Long r105 = r110.createTime;
    L27:
        if ((r312 & 64) == 0) goto L29;
        String r113 = r110.content;
    L31:
        if ((r312 & 128) == 0) goto L33;
        Integer r114 = r110.messageType;
    L35:
        if ((r312 & 256) == 0) goto L37;
        long r115 = r110.actionId;
    L39:
        if ((r312 & 512) == 0) goto L41;
        long r116 = r110.jobId;
    L42:
        long r218 = r116;
        if ((r312 & 1024) == 0) goto L45;
        int r117 = r110.version;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        IMAppActionExt r106 = r110.ext;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r113, r114, r115, r218, r117, r106);
    L49:
        r106 = r311;
        goto L51
    L45:
        r117 = r310;
        goto L47
    L41:
        r116 = r217;
        goto L42
    L37:
        r115 = r216;
        goto L39
    L33:
        r114 = r215;
        goto L35
    L29:
        r113 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final long component1() {
        return this.f396158id;
    }

    public final long component10() {
        return this.jobId;
    }

    public final int component11() {
        return this.version;
    }

    public final IMAppActionExt component12() {
        return this.ext;
    }

    public final Long component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.localMessageId;
    }

    public final long component4() {
        return this.replyId;
    }

    public final Long component5() {
        return this.questionId;
    }

    public final Long component6() {
        return this.createTime;
    }

    public final String component7() {
        return this.content;
    }

    public final Integer component8() {
        return this.messageType;
    }

    public final long component9() {
        return this.actionId;
    }

    public final IMAppAction copy(long r110, Long r210, String r211, long r212, Long r213, Long r214, String r215, Integer r216, long r217, long r310, int r311, IMAppActionExt r312) {
        return new IMAppAction(r110, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IMAppAction) == true) goto L8;
        return false;
    L8:
        IMAppAction r101 = (IMAppAction) r100;
        if (this.f396158id == r101.f396158id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localMessageId, r101.localMessageId) == true) goto L18;
        return false;
    L18:
        if (this.replyId == r101.replyId) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.questionId, r101.questionId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.messageType, r101.messageType) == true) goto L33;
        return false;
    L33:
        if (this.actionId == r101.actionId) goto L36;
        return false;
    L36:
        if (this.jobId == r101.jobId) goto L39;
        return false;
    L39:
        if (this.version == r101.version) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final long getActionId() {
        return this.actionId;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final IMAppActionExt getExt() {
        return this.ext;
    }

    public final long getId() {
        return this.f396158id;
    }

    public final long getJobId() {
        return this.jobId;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public final Integer getMessageType() {
        return this.messageType;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public final long getReplyId() {
        return this.replyId;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        long r100 = this.f396158id;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Long r102 = this.messageId;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.localMessageId;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        long r108 = this.replyId;
        int r109 = (((r105 + r107) * 31) + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        Long r110 = this.questionId;
        if (r110 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.createTime;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (r112 + r114) * 31;
        String r116 = this.content;
        if (r116 != null) goto L21;
        int r117 = 0;
    L22:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.messageType;
        if (r119 != null) goto L25;
        int r120 = 0;
    L26:
        long r121 = this.actionId;
        int r122 = (((r118 + r120) * 31) + ((int) (r121 ^ (r121 >>> 32)))) * 31;
        long r123 = this.jobId;
        int r124 = (((r122 + ((int) (r123 ^ (r123 >>> 32)))) * 31) + this.version) * 31;
        IMAppActionExt r125 = this.ext;
        if (r125 == null) goto L31;
        r103 = r125.hashCode();
    L31:
        return r124 + r103;
    L25:
        r120 = r119.hashCode();
        goto L26
    L21:
        r117 = r116.hashCode();
        goto L22
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r110.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final void setActionId(long r100) {
        this.actionId = r100;
    }

    public final void setContent(String r100) {
        this.content = r100;
    }

    public final void setCreateTime(Long r100) {
        this.createTime = r100;
    }

    public final void setExt(IMAppActionExt r100) {
        this.ext = r100;
    }

    public final void setId(long r100) {
        this.f396158id = r100;
    }

    public final void setJobId(long r100) {
        this.jobId = r100;
    }

    public final void setLocalMessageId(String r100) {
        this.localMessageId = r100;
    }

    public final void setMessageId(Long r100) {
        this.messageId = r100;
    }

    public final void setMessageType(Integer r100) {
        this.messageType = r100;
    }

    public final void setQuestionId(Long r100) {
        this.questionId = r100;
    }

    public final void setReplyId(long r100) {
        this.replyId = r100;
    }

    public final void setVersion(int r100) {
        this.version = r100;
    }

    public String toString() {
        return "IMAppAction(id=" + this.f396158id + ", messageId=" + this.messageId + ", localMessageId=" + this.localMessageId + ", replyId=" + this.replyId + ", questionId=" + this.questionId + ", createTime=" + this.createTime + ", content=" + this.content + ", messageType=" + this.messageType + ", actionId=" + this.actionId + ", jobId=" + this.jobId + ", version=" + this.version + ", ext=" + this.ext + ')';
    }

    public final AppAction getAction() {
        AppAction r100 = this.action;
        if (r100 != null) goto L10;
        Companion.getClass();     // Catch: IllegalStateException -> L6
        Object r101 = GsonProtectorUtils.fromJson((Gson) access$getGson$delegate$cp().getValue(), this.content, AppAction.class);     // Catch: IllegalStateException -> L6
        this.action = (AppAction) r101;     // Catch: IllegalStateException -> L6
        return (AppAction) r101;
    L6:
        AppAction r102 = new AppAction("", "", "", null, 0, null, null, null, null, null, 1016, null);
        this.action = r102;
        return r102;
    L10:
        return r100;
    }

    public final VersionInfo getVersionInfo() {
        Companion.getClass();     // Catch: IllegalStateException -> L4
        return (VersionInfo) GsonProtectorUtils.fromJson((Gson) access$getGson$delegate$cp().getValue(), this.content, VersionInfo.class);
    L5:
        return new VersionInfo(0);
    }
}
