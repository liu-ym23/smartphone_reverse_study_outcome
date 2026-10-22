package i98;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\nJ\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010%J\u0010\u00109\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010(J¤\u0001\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\u0013HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0019\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b,\u0010\u001d¨\u0006@"}, d2 = {"Lcom/larus/avlink/env/diary/detail/model/DiaryDetail;", "", "id", "", "createTime", "title", "isRecording", "", "statusTag", "content", "", "emotionInfo", "Lcom/larus/avlink/env/diary/model/EmotionInfo;", "summary", "nextUpdateTime", "diaryStyle", "Lcom/larus/avlink/env/diary/style/api/DiaryStyleInfo;", "hasSetStyle", ReportConstant.COMMON_ACTION_TYPE, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Lcom/larus/avlink/env/diary/model/EmotionInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/avlink/env/diary/style/api/DiaryStyleInfo;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getId", "()Ljava/lang/String;", "getCreateTime", "getTitle", "()Z", "getStatusTag", "getContent", "()Ljava/util/List;", "getEmotionInfo", "()Lcom/larus/avlink/env/diary/model/EmotionInfo;", "getSummary", "getNextUpdateTime", "getDiaryStyle", "()Lcom/larus/avlink/env/diary/style/api/DiaryStyleInfo;", "getHasSetStyle", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "blocks", "Lcom/larus/im/bean/message/block/Block;", "getBlocks", "deserializeContentToBlocks", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/util/List;Lcom/larus/avlink/env/diary/model/EmotionInfo;Ljava/lang/String;Ljava/lang/String;Lcom/larus/avlink/env/diary/style/api/DiaryStyleInfo;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/larus/avlink/env/diary/detail/model/DiaryDetail;", "equals", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("action_type")
    private final Integer actionType;

    @SerializedName("contents")
    private final List<String> content;

    @SerializedName("create_time")
    private final String createTime;

    @SerializedName("style_info")
    private final m98.b diaryStyle;

    @SerializedName("emotion_info")
    private final l98.b emotionInfo;

    @SerializedName("has_set_style")
    private final Boolean hasSetStyle;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("diary_id")
    private final String f488803id;

    @SerializedName("is_recording")
    private final boolean isRecording;

    @SerializedName("next_update_time")
    private final String nextUpdateTime;

    @SerializedName("status_tag")
    private final String statusTag;

    @SerializedName("summary")
    private final String summary;

    @SerializedName("title")
    private final String title;

    public a() {
        this(null, null, null, null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f488803id, r101.f488803id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (this.isRecording == r101.isRecording) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.statusTag, r101.statusTag) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.emotionInfo, r101.emotionInfo) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.summary, r101.summary) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.nextUpdateTime, r101.nextUpdateTime) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.diaryStyle, r101.diaryStyle) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.hasSetStyle, r101.hasSetStyle) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f488803id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.createTime;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.title;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.isRecording == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        String r112 = this.statusTag;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        List<String> r115 = this.content;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        l98.b r118 = this.emotionInfo;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.summary;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.nextUpdateTime;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        m98.b r127 = this.diaryStyle;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        Boolean r130 = this.hasSetStyle;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        Integer r133 = this.actionType;
        if (r133 == null) goto L51;
        r101 = r133.hashCode();
    L51:
        return r132 + r101;
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
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
        return "DiaryDetail(id=" + this.f488803id + ", createTime=" + this.createTime + ", title=" + this.title + ", isRecording=" + this.isRecording + ", statusTag=" + this.statusTag + ", content=" + this.content + ", emotionInfo=" + this.emotionInfo + ", summary=" + this.summary + ", nextUpdateTime=" + this.nextUpdateTime + ", diaryStyle=" + this.diaryStyle + ", hasSetStyle=" + this.hasSetStyle + ", actionType=" + this.actionType + ')';
    }

    public final List<Block> c() {
        FLogger r100 = FLogger.f375446a;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        StringBuilder r101 = new StringBuilder("deserializeContentToBlocks: content size = ");     // Catch: Exception -> L32 JsonSyntaxException -> L34
        List<String> r102 = this.content;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r102 == null) goto L6;
        Integer r103 = Integer.valueOf(r102.size());     // Catch: Exception -> L32 JsonSyntaxException -> L34
    L7:
        r101.append(r103);     // Catch: Exception -> L32 JsonSyntaxException -> L34
        r100.d("DiaryDetail", r101.toString());     // Catch: Exception -> L32 JsonSyntaxException -> L34
        List<String> r104 = this.content;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        if (r104 != null) goto L10;
    L13:
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        r100.w("DiaryDetail", "content is null or empty");     // Catch: Exception -> L32 JsonSyntaxException -> L34
        return null;
    L16:
        Gson r106 = new Gson();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        List<String> r107 = this.content;     // Catch: Exception -> L32 JsonSyntaxException -> L34
        ArrayList r108 = new ArrayList();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        Iterator<T> r109 = r107.iterator();     // Catch: Exception -> L32 JsonSyntaxException -> L34
    L18:
        if (r109.hasNext() == false) goto L30;
        String r110 = (String) r109.next();     // Catch: Exception -> L32 JsonSyntaxException -> L34
        FLogger r111 = FLogger.f375446a;     // Catch: Exception -> L26
        StringBuilder r112 = new StringBuilder();     // Catch: Exception -> L26
        r112.append("Parsing block: ");     // Catch: Exception -> L26
        if (r110 == null) goto L23;
        String r113 = StringsKt.take(r110, 100);     // Catch: Exception -> L26
    L24:
        r112.append(r113);     // Catch: Exception -> L26
        r112.append("...");     // Catch: Exception -> L26
        r111.d("DiaryDetail", r112.toString());     // Catch: Exception -> L26
        Block r114 = (Block) r106.fromJson(r110, Block.class);     // Catch: Exception -> L26
    L28:
        if (r114 == null) goto L18;
        r108.add(r114);     // Catch: Exception -> L32 JsonSyntaxException -> L34
        goto L18
    L23:
        r113 = null;
    L26:
        e = move-exception;
        FLogger.f375446a.e("DiaryDetail", "Failed to parse single block: " + e.getMessage());     // Catch: Exception -> L32 JsonSyntaxException -> L34
        r114 = null;
        goto L28
    L30:
        FLogger.f375446a.d("DiaryDetail", "Successfully parsed " + r108.size() + " blocks");     // Catch: Exception -> L32 JsonSyntaxException -> L34
        return r108;
    L10:
        if (r104.isEmpty() == true) goto L13;
        r105 = false;
        goto L14
    L6:
        r103 = null;
    L34:
        e = move-exception;
        FLogger.f375446a.e("DiaryDetail", "Failed to deserialize content to blocks: " + e.getMessage());
        return null;
    L32:
        e = move-exception;
        FLogger.f375446a.e("DiaryDetail", "Error deserializing content to blocks: " + e.getMessage());
        return null;
    }

    public final Integer b() {
        return this.actionType;
    }

    public final List<String> d() {
        return this.content;
    }

    public final String e() {
        return this.createTime;
    }

    public final m98.b f() {
        return this.diaryStyle;
    }

    public final l98.b g() {
        return this.emotionInfo;
    }

    public final Boolean h() {
        return this.hasSetStyle;
    }

    public final String i() {
        return this.f488803id;
    }

    public final String j() {
        return this.nextUpdateTime;
    }

    public final String k() {
        return this.statusTag;
    }

    public final String l() {
        return this.summary;
    }

    public final String m() {
        return this.title;
    }

    public static a a(a r110, Integer r111, int r112) {
        Boolean r100 = null;
        if ((r112 & 1) == 0) goto L5;
        String r101 = r110.f488803id;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r102 = r110.createTime;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r103 = r110.title;
    L15:
        if ((r112 & 8) == 0) goto L17;
        boolean r104 = r110.isRecording;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r105 = r110.statusTag;
    L23:
        if ((r112 & 32) == 0) goto L25;
        List<String> r113 = r110.content;
    L27:
        if ((r112 & 64) == 0) goto L29;
        l98.b r114 = r110.emotionInfo;
    L31:
        if ((r112 & 128) == 0) goto L33;
        String r115 = r110.summary;
    L35:
        if ((r112 & 256) == 0) goto L37;
        String r116 = r110.nextUpdateTime;
    L39:
        if ((r112 & 512) == 0) goto L41;
        m98.b r117 = r110.diaryStyle;
    L43:
        if ((r112 & 1024) == 0) goto L45;
        r100 = r110.hasSetStyle;
    L45:
        Boolean r118 = r100;
        if ((r112 & 2048) == 0) goto L48;
        Integer r119 = r110.actionType;
    L50:
        return new a(r101, r102, r103, r104, r105, r113, r114, r115, r116, r117, r118, r119);
    L48:
        r119 = r111;
        goto L50
    L41:
        r117 = null;
        goto L43
    L37:
        r116 = null;
        goto L39
    L33:
        r115 = null;
        goto L35
    L29:
        r114 = null;
        goto L31
    L25:
        r113 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = false;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ a(String r110, String r111, String r112, String r210, List r211, l98.b r212, String r213, String r214, m98.b r215, Boolean r216, Integer r217, int r218) {
        if ((r218 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r218 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r218 & 16) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r218 & 32) == 0) goto L21;
        List r104 = null;
    L23:
        if ((r218 & 64) == 0) goto L25;
        l98.b r113 = null;
    L27:
        if ((r218 & 128) == 0) goto L29;
        String r114 = null;
    L31:
        if ((r218 & 256) == 0) goto L33;
        String r115 = null;
    L35:
        if ((r218 & 512) == 0) goto L37;
        m98.b r116 = null;
    L39:
        if ((r218 & 1024) == 0) goto L41;
        Boolean r117 = Boolean.FALSE;
    L43:
        if ((r218 & 2048) == 0) goto L45;
        Integer r118 = null;
    L46:
        this(r100, r101, r102, false, r103, r104, r113, r114, r115, r116, r117, r118);
        return;
    L45:
        r118 = r217;
        goto L46
    L41:
        r117 = r216;
        goto L43
    L37:
        r116 = r215;
        goto L39
    L33:
        r115 = r214;
        goto L35
    L29:
        r114 = r213;
        goto L31
    L25:
        r113 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public a(String r100, String r101, String r102, boolean r103, String r104, List<String> r105, l98.b r106, String r107, String r108, m98.b r110, Boolean r111, Integer r112) {
        this.f488803id = r100;
        this.createTime = r101;
        this.title = r102;
        this.isRecording = r103;
        this.statusTag = r104;
        this.content = r105;
        this.emotionInfo = r106;
        this.summary = r107;
        this.nextUpdateTime = r108;
        this.diaryStyle = r110;
        this.hasSetStyle = r111;
        this.actionType = r112;
    }
}
