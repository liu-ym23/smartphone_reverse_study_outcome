package com.ss.android.lark.todo.impl.features.chatlist.item;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.bytedance.lark.pb.todo.v1.CustomComplete;
import com.bytedance.lark.pb.todo.v1.TaskMode;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoSource;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import v7c.a;

/* JADX INFO: loaded from: classes38.dex */
public final class TodoDisplayItem {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final List<TodoAssignee> E;
    public final boolean F;
    public final GetAnotherNameFormatResponse.FormatRule G;
    public final boolean H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f442237J;
    public final boolean K;
    public final int L;
    public final int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f442238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RichText f442239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RichContent f442240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f442241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f442242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f442243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f442244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f442245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f442246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f442247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MultiCompleteHelper.MultiCompleteType f442248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CustomComplete.Action f442249l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f442250m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f442251n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ChangeStatus f442252o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f442253p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f442254q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f442255r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TitleType f442256s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ChatListTitleType f442257t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f442258u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f442259v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f442260w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f442261x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TodoSource f442262y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TaskMode f442263z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/item/TodoDisplayItem$ChangeStatus;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE", "QUIT", "UNFOLLOWED", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChangeStatus extends Enum<ChangeStatus> {
        public static final ChangeStatus DELETE = null;
        public static final ChangeStatus QUIT = null;
        public static final ChangeStatus UNFOLLOWED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChangeStatus[] f442264a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f442265b = null;

        public static EnumEntries<ChangeStatus> getEntries() {
            return f442265b;
        }

        static {
            ChangeStatus r100 = new ChangeStatus("DELETE", 0);
            DELETE = r100;
            ChangeStatus r101 = new ChangeStatus("QUIT", 1);
            QUIT = r101;
            ChangeStatus r102 = new ChangeStatus("UNFOLLOWED", 2);
            UNFOLLOWED = r102;
            ChangeStatus[] r103 = {r100, r101, r102};
            f442264a = r103;
            f442265b = EnumEntriesKt.enumEntries(r103);
        }

        public static ChangeStatus[] values() {
            return (ChangeStatus[]) f442264a.clone();
        }

        public static ChangeStatus valueOf(String r100) {
            return (ChangeStatus) r27.a.a(ChangeStatus.class, r100);
        }

        public ChangeStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/item/TodoDisplayItem$ChatListTitleType;", "", "<init>", "(Ljava/lang/String;I)V", "ASSIGN_TO_ME", "ASSIGN_OTHER", "COMPLETED", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatListTitleType extends Enum<ChatListTitleType> {
        public static final ChatListTitleType ASSIGN_OTHER = null;
        public static final ChatListTitleType ASSIGN_TO_ME = null;
        public static final ChatListTitleType COMPLETED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatListTitleType[] f442266a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f442267b = null;

        public static EnumEntries<ChatListTitleType> getEntries() {
            return f442267b;
        }

        static {
            ChatListTitleType r100 = new ChatListTitleType("ASSIGN_TO_ME", 0);
            ASSIGN_TO_ME = r100;
            ChatListTitleType r101 = new ChatListTitleType("ASSIGN_OTHER", 1);
            ASSIGN_OTHER = r101;
            ChatListTitleType r102 = new ChatListTitleType("COMPLETED", 2);
            COMPLETED = r102;
            ChatListTitleType[] r103 = {r100, r101, r102};
            f442266a = r103;
            f442267b = EnumEntriesKt.enumEntries(r103);
        }

        public static ChatListTitleType[] values() {
            return (ChatListTitleType[]) f442266a.clone();
        }

        public static ChatListTitleType valueOf(String r100) {
            return (ChatListTitleType) r27.a.a(ChatListTitleType.class, r100);
        }

        public ChatListTitleType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/item/TodoDisplayItem$TitleType;", "", "<init>", "(Ljava/lang/String;I)V", "OVER_DUE", "TODAY", "IN_WEEK", FlowDoraWifiScene.OTHER, "DOING", "DONE", "COMPLETED", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TitleType extends Enum<TitleType> {
        public static final TitleType COMPLETED = null;
        public static final TitleType DOING = null;
        public static final TitleType DONE = null;
        public static final TitleType IN_WEEK = null;
        public static final TitleType OTHER = null;
        public static final TitleType OVER_DUE = null;
        public static final TitleType TODAY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitleType[] f442268a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f442269b = null;

        public static EnumEntries<TitleType> getEntries() {
            return f442269b;
        }

        static {
            TitleType r100 = new TitleType("OVER_DUE", 0);
            OVER_DUE = r100;
            TitleType r101 = new TitleType("TODAY", 1);
            TODAY = r101;
            TitleType r102 = new TitleType("IN_WEEK", 2);
            IN_WEEK = r102;
            TitleType r103 = new TitleType(FlowDoraWifiScene.OTHER, 3);
            OTHER = r103;
            TitleType r104 = new TitleType("DOING", 4);
            DOING = r104;
            TitleType r105 = new TitleType("DONE", 5);
            DONE = r105;
            TitleType r110 = new TitleType("COMPLETED", 6);
            COMPLETED = r110;
            TitleType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f442268a = r111;
            f442269b = EnumEntriesKt.enumEntries(r111);
        }

        public static TitleType[] values() {
            return (TitleType[]) f442268a.clone();
        }

        public static TitleType valueOf(String r100) {
            return (TitleType) r27.a.a(TitleType.class, r100);
        }

        public TitleType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TodoDisplayItem() {
        this(null, null, false, 0, 0, false, null, 0, 0, null, null, false, false, null, false, null, false, null, 0, null, null, null, false, false, false, false, -1, 15);
    }

    public final int hashCode() {
        int r100 = ((this.f442238a.hashCode() * 31) + this.f442239b.hashCode()) * 31;
        RichContent r101 = this.f442240c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        int r105 = 1231;
        if (this.f442241d == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f442242e) * 31;
        long r108 = this.f442243f;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        if (this.f442244g == false) goto L13;
        int r110 = 1231;
    L14:
        int r111 = (((((r109 + r110) * 31) + this.f442245h.hashCode()) * 31) + this.f442246i) * 31;
        long r112 = this.f442247j;
        int r113 = (((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.f442248k.hashCode()) * 31;
        CustomComplete.Action r114 = this.f442249l;
        if (r114 != null) goto L17;
        int r115 = 0;
    L18:
        int r116 = (r113 + r115) * 31;
        if (this.f442250m == false) goto L21;
        int r117 = 1231;
    L22:
        int r118 = (r116 + r117) * 31;
        if (this.f442251n == false) goto L25;
        int r119 = 1231;
    L26:
        int r120 = (((r118 + r119) * 31) + this.f442252o.hashCode()) * 31;
        if (this.f442253p == false) goto L29;
        int r121 = 1231;
    L30:
        int r122 = (r120 + r121) * 31;
        a r123 = this.f442254q;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        if (this.f442255r == false) goto L37;
        int r126 = 1231;
    L38:
        int r127 = (((((r125 + r126) * 31) + this.f442256s.hashCode()) * 31) + this.f442257t.hashCode()) * 31;
        if (this.f442258u == false) goto L41;
        int r128 = 1231;
    L42:
        int r129 = (((((((r127 + r128) * 31) + this.f442259v.hashCode()) * 31) + this.f442260w) * 31) + this.f442261x) * 31;
        TodoSource r130 = this.f442262y;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        TaskMode r133 = this.f442263z;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        if (this.A == false) goto L53;
        int r136 = 1231;
    L54:
        int r137 = (r135 + r136) * 31;
        if (this.B == false) goto L57;
        int r138 = 1231;
    L58:
        int r139 = (r137 + r138) * 31;
        if (this.C == false) goto L61;
        int r140 = 1231;
    L62:
        int r141 = (r139 + r140) * 31;
        if (this.D == false) goto L65;
        int r142 = 1231;
    L66:
        int r143 = (r141 + r142) * 31;
        List<TodoAssignee> r144 = this.E;
        if (r144 == null) goto L70;
        r102 = r144.hashCode();
    L70:
        int r145 = (r143 + r102) * 31;
        if (this.F == false) goto L73;
        int r146 = 1231;
    L74:
        int r147 = (((r145 + r146) * 31) + this.G.hashCode()) * 31;
        if (this.H == false) goto L77;
        int r148 = 1231;
    L78:
        int r149 = (r147 + r148) * 31;
        if (this.I == false) goto L81;
        int r150 = 1231;
    L82:
        int r151 = (r149 + r150) * 31;
        if (this.f442237J == true) goto L87;
        r105 = 1237;
    L87:
        return r151 + r105;
    L81:
        r150 = 1237;
        goto L82
    L77:
        r148 = 1237;
        goto L78
    L73:
        r146 = 1237;
        goto L74
    L65:
        r142 = 1237;
        goto L66
    L61:
        r140 = 1237;
        goto L62
    L57:
        r138 = 1237;
        goto L58
    L53:
        r136 = 1237;
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = 1237;
        goto L42
    L37:
        r126 = 1237;
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = 1237;
        goto L30
    L25:
        r119 = 1237;
        goto L26
    L21:
        r117 = 1237;
        goto L22
    L17:
        r115 = r114.hashCode();
        goto L18
    L13:
        r110 = 1237;
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TodoDisplayItem(guid=" + this.f442238a + ", titleRichText=" + this.f442239b + ", titleRichContent=" + this.f442240c + ", isCompleted=" + this.f442241d + ", attendeeCount=" + this.f442242e + ", endMilliTime=" + this.f442243f + ", isAllDay=" + this.f442244g + ", endTimeStr=" + this.f442245h + ", endTimeColor=" + this.f442246i + ", createMilliTime=" + this.f442247j + ", completeType=" + this.f442248k + ", completeAction=" + this.f442249l + ", isFollowerCheckable=" + this.f442250m + ", isCountBadge=" + this.f442251n + ", changeStatus=" + this.f442252o + ", isDeletable=" + this.f442253p + ", chatItem=" + this.f442254q + ", isTitle=" + this.f442255r + ", titleType=" + this.f442256s + ", chatListTitleType=" + this.f442257t + ", isTitleExpand=" + this.f442258u + ", titleStr=" + this.f442259v + ", titleCount=" + this.f442260w + ", titleRedCount=" + this.f442261x + ", todoSource=" + this.f442262y + ", todoMode=" + this.f442263z + ", isLastItem=" + this.A + ", isFirstItem=" + this.B + ", isLastInSection=" + this.C + ", isFirstInSection=" + this.D + ", assignees=" + this.E + ", timeNewLine=" + this.F + ", nameRule=" + this.G + ", isRepeat=" + this.H + ", isReminder=" + this.I + ", isMileStone=" + this.f442237J + ')';
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if ((r100 instanceof TodoDisplayItem) == false) goto L67;
        boolean r101 = this.f442255r;
        TodoDisplayItem r102 = (TodoDisplayItem) r100;
        if (r101 == r102.f442255r) goto L11;
        return false;
    L11:
        if (r101 == true) goto L38;
        if (Intrinsics.areEqual(this.f442239b, r102.f442239b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f442240c, r102.f442240c) == true) goto L17;
        return false;
    L17:
        if (this.f442241d == r102.f442241d) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f442245h, r102.f442245h) == true) goto L21;
        return false;
    L21:
        if (this.f442246i == r102.f442246i) goto L23;
        return false;
    L23:
        if (this.f442250m == r102.f442250m) goto L25;
        return false;
    L25:
        if (this.f442253p == r102.f442253p) goto L27;
        return false;
    L27:
        if (this.A == r102.A) goto L29;
        return false;
    L29:
        if (this.B == r102.B) goto L31;
        return false;
    L31:
        if (this.C == r102.C) goto L33;
        return false;
    L33:
        if (this.D == r102.D) goto L35;
        return false;
    L35:
        if (this.F != r102.F) goto L61;
    L47:
        return true;
    L61:
        return false;
    L38:
        if (this.f442256s == r102.f442256s) goto L40;
        return false;
    L40:
        if (this.f442258u == r102.f442258u) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f442259v, r102.f442259v) == true) goto L44;
        return false;
    L44:
        if (this.f442260w == r102.f442260w) goto L46;
        return false;
    L46:
        if (this.f442261x == r102.f442261x) goto L47;
        return false;
    L67:
        return false;
    }

    public TodoDisplayItem(String r310, RichText r311, boolean r312, int r313, long r314, boolean r315, String r410, int r411, long r412, MultiCompleteHelper.MultiCompleteType r413, CustomComplete.Action r414, boolean r415, boolean r416, a r417, boolean r418, ChatListTitleType r510, boolean r511, String r512, int r513, TodoSource r514, TaskMode r515, List r516, boolean r517, boolean r518, boolean r519, boolean r610, int r611, int r612) {
        if ((r611 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r611 & 2) == 0) goto L9;
        RichText r101 = c.c("");
    L11:
        if ((r611 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r611 & 16) == 0) goto L17;
        int r103 = 0;
    L18:
        long r104 = 0;
        if ((r611 & 32) == 0) goto L21;
        long r110 = 0;
    L23:
        if ((r611 & 64) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r611 & 128) == 0) goto L29;
        String r111 = "";
    L31:
        if ((r611 & 256) == 0) goto L33;
        int r112 = 0;
    L35:
        if ((r611 & 512) != 0) goto L39;
        r104 = r412;
    L39:
        if ((r611 & 1024) == 0) goto L41;
        MultiCompleteHelper.MultiCompleteType r113 = MultiCompleteHelper.MultiCompleteType.NOT_COMPLETE;
    L43:
        if ((r611 & 2048) == 0) goto L45;
        CustomComplete.Action r106 = null;
    L47:
        if ((r611 & 4096) == 0) goto L49;
        boolean r107 = false;
    L50:
        boolean r316 = r107;
        if ((r611 & 16384) == 0) goto L53;
        ChangeStatus r108 = ChangeStatus.UNFOLLOWED;
    L55:
        if ((r611 & 32768) == 0) goto L57;
        boolean r114 = false;
    L59:
        if ((r611 & 65536) == 0) goto L61;
        a r115 = null;
    L63:
        if ((r611 & 131072) == 0) goto L65;
        boolean r210 = false;
    L67:
        if ((r611 & 262144) == 0) goto L69;
        TitleType r109 = TitleType.OTHER;
    L71:
        if ((r611 & 524288) == 0) goto L73;
        ChatListTitleType r116 = ChatListTitleType.ASSIGN_TO_ME;
    L75:
        if ((1048576 & r611) == 0) goto L77;
        boolean r117 = false;
    L79:
        if ((r611 & 2097152) == 0) goto L81;
        String r118 = "";
    L83:
        if ((r611 & 4194304) == 0) goto L85;
        int r211 = 0;
    L87:
        if ((r611 & 16777216) == 0) goto L89;
        TodoSource r212 = null;
    L91:
        if ((r611 & 33554432) == 0) goto L93;
        TaskMode r213 = null;
    L95:
        if ((r611 & 1073741824) == 0) goto L97;
        List r214 = null;
    L99:
        if ((r611 & Integer.MIN_VALUE) == 0) goto L101;
        boolean r119 = false;
    L103:
        if ((r612 & 1) == 0) goto L105;
        GetAnotherNameFormatResponse.FormatRule r120 = GetAnotherNameFormatResponse.FormatRule.UNKNOWN;
    L107:
        if ((r612 & 2) == 0) goto L109;
        boolean r215 = false;
    L111:
        if ((r612 & 4) == 0) goto L113;
        boolean r216 = false;
    L115:
        if ((r612 & 8) == 0) goto L117;
        boolean r317 = false;
    L118:
        Intrinsics.checkNotNullParameter(r100, "guid");
        Intrinsics.checkNotNullParameter(r101, "titleRichText");
        Intrinsics.checkNotNullParameter(r111, "endTimeStr");
        Intrinsics.checkNotNullParameter(r113, "completeType");
        Intrinsics.checkNotNullParameter(r108, "changeStatus");
        Intrinsics.checkNotNullParameter(r109, "titleType");
        Intrinsics.checkNotNullParameter(r116, "chatListTitleType");
        Intrinsics.checkNotNullParameter(r118, "titleStr");
        Intrinsics.checkNotNullParameter(r120, "nameRule");
        this.f442238a = r100;
        this.f442239b = r101;
        this.f442240c = null;
        this.f442241d = r102;
        this.f442242e = r103;
        this.f442243f = r110;
        this.f442244g = r105;
        this.f442245h = r111;
        this.f442246i = r112;
        this.f442247j = r104;
        this.f442248k = r113;
        this.f442249l = r106;
        this.f442250m = r316;
        this.f442251n = false;
        this.f442252o = r108;
        this.f442253p = r114;
        this.f442254q = r115;
        this.f442255r = r210;
        this.f442256s = r109;
        this.f442257t = r116;
        this.f442258u = r117;
        this.f442259v = r118;
        this.f442260w = r211;
        this.f442261x = 0;
        this.f442262y = r212;
        this.f442263z = r213;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = r214;
        this.F = r119;
        this.G = r120;
        this.H = r215;
        this.I = r216;
        this.f442237J = r317;
        boolean r121 = !TextUtils.isEmpty(r111);
        this.K = !r121;
        if (r121 == false) goto L121;
        int r122 = 0;
    L122:
        this.L = r122;
        if (r102 == false) goto L125;
        int r123 = 0;
    L126:
        this.M = r123;
        return;
    L125:
        r123 = 8;
        goto L126
    L121:
        r122 = 8;
        goto L122
    L117:
        r317 = r610;
        goto L118
    L113:
        r216 = r519;
        goto L115
    L109:
        r215 = r518;
        goto L111
    L105:
        r120 = null;
        goto L107
    L101:
        r119 = r517;
        goto L103
    L97:
        r214 = r516;
        goto L99
    L93:
        r213 = r515;
        goto L95
    L89:
        r212 = r514;
        goto L91
    L85:
        r211 = r513;
        goto L87
    L81:
        r118 = r512;
        goto L83
    L77:
        r117 = r511;
        goto L79
    L73:
        r116 = r510;
        goto L75
    L69:
        r109 = null;
        goto L71
    L65:
        r210 = r418;
        goto L67
    L61:
        r115 = r417;
        goto L63
    L57:
        r114 = r416;
        goto L59
    L53:
        r108 = null;
        goto L55
    L49:
        r107 = r415;
        goto L50
    L45:
        r106 = r414;
        goto L47
    L41:
        r113 = r413;
        goto L43
    L33:
        r112 = r411;
        goto L35
    L29:
        r111 = r410;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r110 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L18
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
