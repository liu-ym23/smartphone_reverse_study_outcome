package com.ss.android.lark.todo.impl.features.tasklist.events.item;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.bytedance.lark.pb.todo.v1.TargetType;
import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements MultiItemEntity, com.ss.android.lark.todo.impl.features.tasklist.events.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f444079v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f444080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f444081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TargetType f444082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CharSequence f444083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f444084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f444085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f444086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f444087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CharSequence f444088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CharSequence f444089j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RichText f444090k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<TodoAttachment> f444091l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<TodoAttachment> f444092m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f444093n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f444094o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f444095p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<String> f444096q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, String> f444097r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f444098s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f444099t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f444100u;

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.tasklist.events.item.a$a, reason: collision with other inner class name */
    public static final class C5360a {
        public static List a(a r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "oldItem");
            Intrinsics.checkNotNullParameter(r101, "newItem");
            ArrayList r102 = new ArrayList();
            if (r100.f444082c == r101.f444082c) goto L6;
            r102.add(TaskListEventPayLoadType.EVENT_TARGET_TYPE);
        L6:
            if (Intrinsics.areEqual(r100.f444083d, r101.f444083d) == true) goto L9;
            r102.add(TaskListEventPayLoadType.EVENT_TARGET_NAME);
        L9:
            if (Intrinsics.areEqual(r100.f444085f, r101.f444085f) == true) goto L11;
        L14:
            r102.add(TaskListEventPayLoadType.EVENT_OPERATOR);
        L16:
            if (Intrinsics.areEqual(r100.f444088i, r101.f444088i) == true) goto L19;
            r102.add(TaskListEventPayLoadType.EVENT_TITLE);
        L19:
            if (Intrinsics.areEqual(r100.f444090k, r101.f444090k) == true) goto L22;
            r102.add(TaskListEventPayLoadType.EVENT_DESCRIPTION);
        L22:
            if (Intrinsics.areEqual(r100.f444090k, r101.f444090k) == true) goto L25;
            r102.add(TaskListEventPayLoadType.EVENT_CONTENT);
        L25:
            if (Intrinsics.areEqual(r100.f444081b, r101.f444081b) == true) goto L27;
            r102.add(TaskListEventPayLoadType.EVENT_TIME_STR);
        L27:
            boolean r103 = false;
            if (r100.f444091l.size() == r101.f444091l.size()) goto L30;
            r102.add(TaskListEventPayLoadType.EVENT_ATTACHMENTS);
        L47:
            if (r100.f444092m.size() == r101.f444092m.size()) goto L49;
            r102.add(TaskListEventPayLoadType.EVENT_FILE_ATTACHMENTS);
        L58:
            if (Intrinsics.areEqual(r100.f444084e, r101.f444084e) == true) goto L60;
        L61:
            r102.add(TaskListEventPayLoadType.EVENT_ITEM_CLICK);
        L63:
            if (r100.f444098s == r101.f444098s) goto L65;
        L66:
            r102.add(TaskListEventPayLoadType.EVENT_BACKGROUND);
        L67:
            return r102;
        L65:
            if (r100.f444099t == r101.f444099t) goto L67;
        L60:
            if (Intrinsics.areEqual(r100.f444096q.toString(), r101.f444096q.toString()) == true) goto L63;
        L49:
            int r104 = r100.f444092m.size();
            int r105 = 0;
        L50:
            if (r105 >= r104) goto L55;
            if (Intrinsics.areEqual(((TodoAttachment) ListProtector.get(r100.f444092m, r105)).file_token, ((TodoAttachment) ListProtector.get(r101.f444092m, r105)).file_token) == false) goto L53;
            r105 = r105 + 1;
            goto L50
        L53:
            r103 = true;
        L55:
            if (r103 == false) goto L58;
            r102.add(TaskListEventPayLoadType.EVENT_FILE_ATTACHMENTS);
            goto L58
        L30:
            int r106 = r100.f444091l.size();
            int r107 = 0;
        L31:
            if (r107 >= r106) goto L43;
            TodoAttachment r108 = (TodoAttachment) ListProtector.get(r100.f444091l, r107);
            TodoAttachment r109 = (TodoAttachment) ListProtector.get(r101.f444091l, r107);
            ImageSet r110 = r108.image_set;
            String r111 = null;
            if (r110 == null) goto L35;
            String r112 = r110.key;
        L36:
            ImageSet r113 = r109.image_set;
            if (r113 == null) goto L40;
            r111 = r113.key;
        L40:
            if (Intrinsics.areEqual(r112, r111) == false) goto L41;
            r107 = r107 + 1;
            goto L31
        L41:
            boolean r114 = true;
        L44:
            if (r114 == false) goto L47;
            r102.add(TaskListEventPayLoadType.EVENT_ATTACHMENTS);
            goto L47
        L35:
            r112 = null;
            goto L36
        L43:
            r114 = false;
            goto L44
        L11:
            if (Intrinsics.areEqual(r100.f444086g, r101.f444086g) == false) goto L14;
            if (Intrinsics.areEqual(r100.f444087h, r101.f444087h) == true) goto L16;
            goto L14
        }
    }

    static {
    }

    public a() {
        throw null;
    }

    @Override // com.ss.android.lark.todo.impl.features.tasklist.events.a
    public final void a() {
        this.f444093n = true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f444080a, r101.f444080a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f444081b, r101.f444081b) == true) goto L15;
        return false;
    L15:
        if (this.f444082c == r101.f444082c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f444083d, r101.f444083d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f444084e, r101.f444084e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f444085f, r101.f444085f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f444086g, r101.f444086g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f444087h, r101.f444087h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f444088i, r101.f444088i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f444089j, r101.f444089j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f444090k, r101.f444090k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f444091l, r101.f444091l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f444092m, r101.f444092m) == true) goto L48;
        return false;
    L48:
        if (this.f444093n == r101.f444093n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f444094o, r101.f444094o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f444095p, r101.f444095p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f444096q, r101.f444096q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f444097r, r101.f444097r) == true) goto L63;
        return false;
    L63:
        if (this.f444098s == r101.f444098s) goto L66;
        return false;
    L66:
        if (this.f444099t == r101.f444099t) goto L69;
        return false;
    L69:
        if (this.f444100u == r101.f444100u) goto L71;
        return false;
    L71:
        return true;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public final int getItemType() {
        return 2;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((((((this.f444080a.hashCode() * 31) + this.f444081b.hashCode()) * 31) + this.f444082c.hashCode()) * 31) + this.f444083d.hashCode()) * 31) + this.f444084e.hashCode()) * 31) + this.f444085f.hashCode()) * 31) + this.f444086g.hashCode()) * 31) + this.f444087h.hashCode()) * 31) + this.f444088i.hashCode()) * 31) + this.f444089j.hashCode()) * 31) + this.f444090k.hashCode()) * 31) + this.f444091l.hashCode()) * 31) + this.f444092m.hashCode()) * 31;
        int r101 = 1231;
        if (this.f444093n == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((((((r100 + r102) * 31) + this.f444094o.hashCode()) * 31) + this.f444095p.hashCode()) * 31) + this.f444096q.hashCode()) * 31) + this.f444097r.hashCode()) * 31;
        if (this.f444098s == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f444099t == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f444100u == true) goto L19;
        r101 = 1237;
    L19:
        return r107 + r101;
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskListEventItem(eventGuid=" + this.f444080a + ", timeStr=" + this.f444081b + ", targetType=" + this.f444082c + ", targetName=" + this.f444083d + ", relativeTaskGuid=" + this.f444084e + ", operatorId=" + this.f444085f + ", operatorAvatar=" + this.f444086g + ", operatorName=" + this.f444087h + ", eventTitle=" + this.f444088i + ", eventDescription=" + this.f444089j + ", eventContent=" + this.f444090k + ", attachments=" + this.f444091l + ", fileAttachments=" + this.f444092m + ", isGroupFirstItem=" + this.f444093n + ", groupTitle=" + this.f444094o + ", secondGroupTitle=" + this.f444095p + ", relatedTaskListGuids=" + this.f444096q + ", taskListGuidToName=" + this.f444097r + ", isTopRound=" + this.f444098s + ", isBottomRound=" + this.f444099t + ", isCenterEvent=" + this.f444100u + ')';
    }

    @Override // com.ss.android.lark.todo.impl.features.tasklist.events.a
    public final String b() {
        return this.f444094o;
    }

    @Override // com.ss.android.lark.todo.impl.features.tasklist.events.a
    public final boolean c() {
        return this.f444093n;
    }

    public a(String r110, String r111, TargetType r112, CharSequence r210, String r211, String r212, String r213, String r214, CharSequence r215, CharSequence r216, RichText r217, List r218, List r219, String r310, String r311, List r312, Map r313, boolean r314) {
        Intrinsics.checkNotNullParameter(r110, "eventGuid");
        Intrinsics.checkNotNullParameter(r111, "timeStr");
        Intrinsics.checkNotNullParameter(r112, "targetType");
        Intrinsics.checkNotNullParameter(r210, "targetName");
        Intrinsics.checkNotNullParameter(r211, "relativeTaskGuid");
        Intrinsics.checkNotNullParameter(r212, "operatorId");
        Intrinsics.checkNotNullParameter(r213, "operatorAvatar");
        Intrinsics.checkNotNullParameter(r214, "operatorName");
        Intrinsics.checkNotNullParameter(r215, "eventTitle");
        Intrinsics.checkNotNullParameter(r216, "eventDescription");
        Intrinsics.checkNotNullParameter(r217, "eventContent");
        Intrinsics.checkNotNullParameter(r218, "attachments");
        Intrinsics.checkNotNullParameter(r219, "fileAttachments");
        Intrinsics.checkNotNullParameter(r310, "groupTitle");
        Intrinsics.checkNotNullParameter(r311, "secondGroupTitle");
        Intrinsics.checkNotNullParameter(r312, "relatedTaskListGuids");
        Intrinsics.checkNotNullParameter(r313, "taskListGuidToName");
        this.f444080a = r110;
        this.f444081b = r111;
        this.f444082c = r112;
        this.f444083d = r210;
        this.f444084e = r211;
        this.f444085f = r212;
        this.f444086g = r213;
        this.f444087h = r214;
        this.f444088i = r215;
        this.f444089j = r216;
        this.f444090k = r217;
        this.f444091l = r218;
        this.f444092m = r219;
        this.f444093n = false;
        this.f444094o = r310;
        this.f444095p = r311;
        this.f444096q = r312;
        this.f444097r = r313;
        this.f444098s = true;
        this.f444099t = true;
        this.f444100u = r314;
    }
}
