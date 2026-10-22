package com.larksuite.component.card.component.personlist.avatar;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.Gson;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.PersonListProps;
import com.larksuite.component.card.component.personlist.g;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y6a.h;
import y6a.i;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0002()B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J(\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\bH\u0016J6\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0015\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J0\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001aH\u0002J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Lcom/lynx/tasm/behavior/shadow/MeasureFunc;", "<init>", "()V", "personListProps", "Lcom/larksuite/component/card/component/personlist/PersonListProps;", "avatarSize", "", "avatarGap", "moreTextSize", "moreMaxCount", "moreBgColor", "setContent", "", SlcElement.KEY_PROPS, "Lcom/lynx/react/bridge/ReadableMap;", "onLayout", "left", "top", "width", "height", "measure", "", "node", "Lcom/lynx/tasm/behavior/shadow/LayoutNode;", "", "widthMode", "Lcom/lynx/tasm/behavior/shadow/MeasureMode;", "heightMode", "adjustShowCount", "showCount", "gap", "needShowMore", "", "maxWidth", "avatarShowData", "Lcom/larksuite/component/card/component/personlist/avatar/PersonAvatarGroupShadowNode$PersonAvatarExtraData;", "getExtraBundle", "", "Companion", "PersonAvatarExtraData", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonAvatarGroupShadowNode extends ShadowNode implements h {
    public int A;
    public b B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public PersonListProps f283434v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f283435w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f283436x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f283437y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f283438z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f283439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f283440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<PersonInfo> f283441c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f283442d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f283443e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f283444f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f283445g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f283446h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f283439a == r101.f283439a) goto L12;
            return false;
        L12:
            if (this.f283440b == r101.f283440b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f283441c, r101.f283441c) == true) goto L18;
            return false;
        L18:
            if (this.f283442d == r101.f283442d) goto L21;
            return false;
        L21:
            if (this.f283443e == r101.f283443e) goto L24;
            return false;
        L24:
            if (this.f283444f == r101.f283444f) goto L27;
            return false;
        L27:
            if (this.f283445g == r101.f283445g) goto L30;
            return false;
        L30:
            if (this.f283446h == r101.f283446h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f283439a * 31) + this.f283440b) * 31) + this.f283441c.hashCode()) * 31) + this.f283442d) * 31;
            if (this.f283443e == false) goto L5;
            int r101 = 1231;
        L7:
            return ((((((r100 + r101) * 31) + this.f283444f) * 31) + this.f283445g) * 31) + this.f283446h;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "PersonAvatarExtraData(avatarSize=" + this.f283439a + ", avatarGap=" + this.f283440b + ", personList=" + this.f283441c + ", avatarCount=" + this.f283442d + ", needShowMore=" + this.f283443e + ", moreBgColor=" + this.f283444f + ", moreTextSize=" + this.f283445g + ", moreMaxCount=" + this.f283446h + ')';
        }

        public b(int r100, int r101, List<PersonInfo> r102, int r103, boolean r104, int r105, int r106, int r107) {
            Intrinsics.checkNotNullParameter(r102, "personList");
            this.f283439a = r100;
            this.f283440b = r101;
            this.f283441c = r102;
            this.f283442d = r103;
            this.f283443e = r104;
            this.f283444f = r105;
            this.f283445g = r106;
            this.f283446h = r107;
        }
    }

    static {
    }

    public PersonAvatarGroupShadowNode() {
        i(this);
        g.f283510a.getClass();
        this.f283435w = g.d(null);
        this.f283436x = g.a(null);
        this.f283437y = g.e(null);
        this.f283438z = g.c(null);
        this.A = g.b(null);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final Object m() {
        return this.B;
    }

    @LynxProp(name = SlcElement.KEY_PROPS)
    public final void setContent(ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Gson r101 = com.larksuite.component.card.component.g.f283368a;     // Catch: Throwable -> L5
        PersonListProps r102 = (PersonListProps) com.larksuite.component.card.component.g.c(r100, PersonListProps.class);     // Catch: Throwable -> L5
    L7:
        if (r102 != null) goto L10;
        Log.e("PersonAvatarGroupShadowNode", "setContent fail, content is empty");
        return;
    L10:
        this.f283434v = r102;
        g.f283510a.getClass();
        this.f283435w = g.d(r102);
        this.f283436x = g.a(this.f283434v);
        this.f283437y = g.e(this.f283434v);
        this.f283438z = g.c(this.f283434v);
        this.A = g.b(this.f283434v);
        q();
        return;
    L5:
        th = move-exception;
        Log.e("PersonAvatarGroupShadowNode", "props from lynx transform failed", th);
        r102 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void f(int r100, int r101) {
        TraceEvent.beginSection("PersonAvatarGroupShadowNode.onLayout");
        this.f382206e = false;
        TraceEvent.endSection("PersonAvatarGroupShadowNode.onLayout");
    }

    @Override // y6a.h
    public final long c(LayoutNode r110, float r111, MeasureMode r210, float r211, MeasureMode r212) {
        TraceEvent.beginSection("PersonAvatarGroupShadowNode.measure");
        Log.d("PersonAvatarGroupShadowNode", "\n***************** measure start **********************\n");
        Log.d("PersonAvatarGroupShadowNode", "\n***************** origin width: " + r111 + " height:" + r211 + "  widthMode:" + r210 + "  heightMode:" + r212 + " **********************\n");
        MeasureMode r100 = MeasureMode.UNDEFINED;
        boolean r101 = false;
        if (r210 == r100) goto L17;
        if (r212 == r100) goto L17;
        if (r111 != 0.0f) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L17;
        if (r211 != 0.0f) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L17;
        return i.b(0, 0);
    L13:
        r103 = false;
        goto L14
    L8:
        r102 = false;
    L17:
        PersonListProps r104 = this.f283434v;
        if (r104 == null) goto L47;
        int r105 = (int) (r111 / (this.f283435w - this.f283436x));
        int r106 = r104.getPersons().size();
        int r107 = 5;
        if (r104.getPersons().size() <= r105) goto L30;
        if (r105 > 5) goto L24;
        r107 = r105 - 1;
    L24:
        int r108 = this.f283435w;
        if ((((r108 - this.f283436x) * r107) + r108) <= r111) goto L44;
        if (r107 <= 1) goto L44;
        r107 = r107 - 1;
    L44:
        int r112 = r107;
        boolean r113 = true;
    L46:
        this.B = new b(this.f283435w, this.f283436x, r104.getPersons(), r112, r113, this.A, this.f283437y, this.f283438z);
        goto L47
    L30:
        if (r104.getPersons().size() <= 5) goto L32;
        r101 = true;
    L33:
        int r109 = this.f283435w;
        int r114 = r109 - this.f283436x;
        if (r101 == false) goto L36;
        int r115 = (r114 * r107) + r109;
    L38:
        if (r115 <= r111) goto L42;
        if (r107 <= 1) goto L42;
        r107 = r107 - 1;
    L42:
        if (r107 < r104.getPersons().size()) goto L44;
        r112 = r106;
        r113 = r101;
        goto L46
    L36:
        r115 = ((r107 - 1) * r114) + r109;
        goto L38
    L32:
        r107 = r104.getPersons().size();
    L47:
        TraceEvent.endSection("PersonAvatarGroupShadowNode.measure");
        return i.a(r111, this.f283435w);
    }
}
