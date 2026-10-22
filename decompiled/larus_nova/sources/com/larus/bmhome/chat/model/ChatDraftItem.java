package com.larus.bmhome.chat.model;

import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.bean.message.NestedFileContent;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jg\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/model/ChatDraftItem;", "", "type", "", "content", "key", UserInfo.UPDATE_TIME, "", "fileName", "nestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "resourceId", "fileIdentifier", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/larus/im/bean/message/NestedFileContent;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getContent", "getKey", "getUpdateTime", "()J", "getFileName", "getNestedFileContent", "()Lcom/larus/im/bean/message/NestedFileContent;", "getResourceId", "getFileIdentifier", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatDraftItem {
    public static final a Companion = null;
    private static final long DRAFT_EXPIRED_TIMTE = 0;
    public static final String TYPE_ACTION_BAR_INSTRUCTION = "action_bar_instruction";
    public static final String TYPE_ACTION_BAR_SELECTION = "action_bar_selection";
    public static final String TYPE_MSG_EXT = "msg_ext";
    public static final String TYPE_NESTED_FILE = "nested_file";
    public static final String TYPE_OBRIC_MENTION_SKILL_IDS = "obric_mention_skill_ids";
    public static final String TYPE_OBRIC_SELECTED_SKILL_IDS = "obric_selected_skill_ids";
    public static final String TYPE_REPLY = "reply";
    public static final String TYPE_SUGGESTED_ACTION_OPERATIONS = "suggested_action_operations";
    public static final String TYPE_TASK_MODE_SELECTION = "task_mode_selection";
    public static final String TYPE_TEXT = "text";

    @SerializedName("content")
    private final String content;

    @SerializedName("file_identifier")
    private final String fileIdentifier;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("key")
    private final String key;

    @SerializedName("nested_file_content")
    private final NestedFileContent nestedFileContent;

    @SerializedName("resource_id")
    private final String resourceId;

    @SerializedName("type")
    private final String type;

    @SerializedName("update_time")
    private final long updateTime;

    public static final class a {
        public a() {
        }

        public static ChatDraftItem a(a r110, String r111, String r112, String r113, String r114, NestedFileContent r115, int r116) {
            if ((r116 & 4) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r116 & 8) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r116 & 16) == 0) goto L13;
            NestedFileContent r117 = null;
        L14:
            r110.getClass();
            if (r112 != null) goto L17;
            String r102 = "";
        L18:
            if (r100 != null) goto L20;
            String r103 = "";
        L22:
            return new ChatDraftItem(r111, r102, r103, System.currentTimeMillis(), r101, r117, null, null);
        L20:
            r103 = r100;
            goto L22
        L17:
            r102 = r112;
            goto L18
        L13:
            r117 = r115;
            goto L14
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    public ChatDraftItem() {
        this(null, null, null, 0, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ChatDraftItem copy$default(ChatDraftItem r110, String r111, String r112, String r113, long r114, String r115, NestedFileContent r116, String r117, String r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.type;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.content;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.key;
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r103 = r110.updateTime;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.fileName;
    L23:
        if ((r210 & 32) == 0) goto L25;
        NestedFileContent r105 = r110.nestedFileContent;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.resourceId;
    L31:
        if ((r210 & 128) == 0) goto L33;
        String r107 = r110.fileIdentifier;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.content;
    }

    public final String component3() {
        return this.key;
    }

    public final long component4() {
        return this.updateTime;
    }

    public final String component5() {
        return this.fileName;
    }

    public final NestedFileContent component6() {
        return this.nestedFileContent;
    }

    public final String component7() {
        return this.resourceId;
    }

    public final String component8() {
        return this.fileIdentifier;
    }

    public final ChatDraftItem copy(String r110, String r111, String r112, long r113, String r114, NestedFileContent r115, String r116, String r210) {
        return new ChatDraftItem(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatDraftItem) == true) goto L8;
        return false;
    L8:
        ChatDraftItem r101 = (ChatDraftItem) r100;
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L18;
        return false;
    L18:
        if (this.updateTime == r101.updateTime) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileName, r101.fileName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.nestedFileContent, r101.nestedFileContent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.resourceId, r101.resourceId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.fileIdentifier, r101.fileIdentifier) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.type;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.key;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.updateTime;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        String r112 = this.fileName;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (r111 + r113) * 31;
        NestedFileContent r115 = this.nestedFileContent;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.resourceId;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.fileIdentifier;
        if (r121 == null) goto L31;
        r101 = r121.hashCode();
    L31:
        return r120 + r101;
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r113 = r112.hashCode();
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

    public String toString() {
        return "ChatDraftItem(type=" + this.type + ", content=" + this.content + ", key=" + this.key + ", updateTime=" + this.updateTime + ", fileName=" + this.fileName + ", nestedFileContent=" + this.nestedFileContent + ", resourceId=" + this.resourceId + ", fileIdentifier=" + this.fileIdentifier + ')';
    }

    static {
        Companion = new a();
        DRAFT_EXPIRED_TIMTE = TimeUnit.DAYS.toMillis(30);
    }

    public static final /* synthetic */ long access$getDRAFT_EXPIRED_TIMTE$cp() {
        return DRAFT_EXPIRED_TIMTE;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getFileIdentifier() {
        return this.fileIdentifier;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getKey() {
        return this.key;
    }

    public final NestedFileContent getNestedFileContent() {
        return this.nestedFileContent;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getType() {
        return this.type;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public ChatDraftItem(String r100, String r101, String r102, long r103, String r104, NestedFileContent r105, String r106, String r107) {
        this.type = r100;
        this.content = r101;
        this.key = r102;
        this.updateTime = r103;
        this.fileName = r104;
        this.nestedFileContent = r105;
        this.resourceId = r106;
        this.fileIdentifier = r107;
    }

    public /* synthetic */ ChatDraftItem(String r110, String r111, String r112, long r113, String r114, NestedFileContent r115, String r116, String r117, int r210, DefaultConstructorMarker r211) {
        String r100 = "";
        if ((r210 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r210 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r210 & 16) != 0) goto L22;
        r100 = r114;
    L22:
        String r105 = null;
        if ((r210 & 32) == 0) goto L25;
        NestedFileContent r106 = null;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) != 0) goto L34;
        r105 = r117;
    L34:
        this(r101, r102, r103, r104, r100, r106, r107, r105);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
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
}
