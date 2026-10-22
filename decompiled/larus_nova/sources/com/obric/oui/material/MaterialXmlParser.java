package com.obric.oui.material;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.obric.oui.color.i0;
import com.obric.oui.color.j0;
import com.obric.oui.graphic.BlendMode;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.FloatSpreadBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes34.dex */
public final class MaterialXmlParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MaterialXmlParser f401400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f401401b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/oui/material/MaterialXmlParser$MaterialState;", "", "", "xmlName", "Ljava/lang/String;", "getXmlName", "()Ljava/lang/String;", "nodeName", "getNodeName", EffectConstants.NORMAL, "PRESS", "HOVER", "CHECKED", "SELECTED", "DISABLE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
    public static final enum MaterialState extends Enum<MaterialState> {
        public static final MaterialState CHECKED = null;
        public static final MaterialState DISABLE = null;
        public static final MaterialState HOVER = null;
        public static final MaterialState NORMAL = null;
        public static final MaterialState PRESS = null;
        public static final MaterialState SELECTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MaterialState[] f401402a = null;
        private final String nodeName;
        private final String xmlName;

        public MaterialState() {
            throw null;
        }

        public static MaterialState valueOf(String r100) {
            return (MaterialState) r27.a.a(MaterialState.class, r100);
        }

        public static MaterialState[] values() {
            return (MaterialState[]) f401402a.clone();
        }

        static {
            MaterialState r100 = new MaterialState(EffectConstants.NORMAL, 0, "normal", null, 2, null);
            NORMAL = r100;
            MaterialState r101 = new MaterialState("PRESS", 1, "press", null, 2, null);
            PRESS = r101;
            MaterialState r102 = new MaterialState("HOVER", 2, "hover", null, 2, null);
            HOVER = r102;
            MaterialState r103 = new MaterialState("CHECKED", 3, "checked", null, 2, null);
            CHECKED = r103;
            MaterialState r104 = new MaterialState("SELECTED", 4, "selected", null, 2, null);
            SELECTED = r104;
            MaterialState r105 = new MaterialState("DISABLE", 5, "disable", null, 2, null);
            DISABLE = r105;
            f401402a = new MaterialState[]{r100, r101, r102, r103, r104, r105};
        }

        public final String getNodeName() {
            return this.nodeName;
        }

        public final String getXmlName() {
            return this.xmlName;
        }

        public MaterialState(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 2) == 0) goto L5;
            r103 = r102;
        L5:
            super(r100, r101);
            this.xmlName = r102;
            this.nodeName = r103;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.obric.oui.color.a[] f401403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final kma.a f401404b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f401403a, r101.f401403a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f401404b, r101.f401404b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.f401403a) * 31) + this.f401404b.hashCode();
        }

        public final String toString() {
            return "ParsedBlendConfigContainer(defaultConfig=" + Arrays.toString(this.f401403a) + ", stateList=" + this.f401404b + ')';
        }

        public a(com.obric.oui.color.a[] r100, kma.a r101) {
            Intrinsics.checkNotNullParameter(r100, "defaultConfig");
            Intrinsics.checkNotNullParameter(r101, "stateList");
            this.f401403a = r100;
            this.f401404b = r101;
        }
    }

    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f401405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f401406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T f401407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final T f401408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final T f401409e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final T f401410f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f401405a, r101.f401405a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f401406b, r101.f401406b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f401407c, r101.f401407c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f401408d, r101.f401408d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f401409e, r101.f401409e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f401410f, r101.f401410f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f401405a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            T r104 = this.f401406b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            T r107 = this.f401407c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            T r110 = this.f401408d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            T r113 = this.f401409e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            T r116 = this.f401410f;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
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
            return "ResolvedStatefulValues(normal=" + this.f401405a + ", pressed=" + this.f401406b + ", hovered=" + this.f401407c + ", checked=" + this.f401408d + ", selected=" + this.f401409e + ", disabled=" + this.f401410f + ')';
        }

        public final boolean a(Function2<? super T, ? super T, Boolean> r100) {
            Intrinsics.checkNotNullParameter(r100, "comparator");
            if (r100.invoke(this.f401405a, this.f401406b).booleanValue() == true) goto L5;
        L13:
            return false;
        L5:
            if (r100.invoke(this.f401405a, this.f401407c).booleanValue() == false) goto L13;
            if (r100.invoke(this.f401405a, this.f401408d).booleanValue() == false) goto L13;
            if (r100.invoke(this.f401405a, this.f401409e).booleanValue() == false) goto L13;
            if (r100.invoke(this.f401405a, this.f401410f).booleanValue() == false) goto L13;
            return true;
        }

        public b(T r100, T r101, T r102, T r103, T r104, T r105) {
            this.f401405a = r100;
            this.f401406b = r101;
            this.f401407c = r102;
            this.f401408d = r103;
            this.f401409e = r104;
            this.f401410f = r105;
        }
    }

    public MaterialXmlParser() {
    }

    static {
        f401400a = new MaterialXmlParser();
        f401401b = new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_selected}, new int[]{R.attr.state_hovered, R.attr.state_selected}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_selected}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static kma.a b(b r100) {
        if (r100.a(MaterialXmlParser$buildBlendConfigStateList$1.INSTANCE) == false) goto L6;
        int r101 = kma.a.f504112b;
        return kma.a.C6574a.c((com.obric.oui.color.a[]) r100.f401405a);
    L6:
        int r102 = kma.a.f504112b;
        int[][] r103 = f401401b;
        com.obric.oui.color.a[] r104 = (com.obric.oui.color.a[]) r100.f401408d;
        com.obric.oui.color.a[] r105 = (com.obric.oui.color.a[]) r100.f401409e;
        com.obric.oui.color.a[][] r106 = {r104, r104, r105, r105, r105, r105, (com.obric.oui.color.a[]) r100.f401406b, (com.obric.oui.color.a[]) r100.f401407c, r104, r105, (com.obric.oui.color.a[]) r100.f401410f, (com.obric.oui.color.a[]) r100.f401405a};
        Intrinsics.checkNotNullParameter(r103, "states");
        Intrinsics.checkNotNullParameter(r106, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        ArrayList r107 = new ArrayList(12);
        int r108 = 0;
    L7:
        if (r108 >= 12) goto L9;
        r107.add(com.obric.oui.color.c.b(r106[r108]));
        r108 = r108 + 1;
        goto L7
    L9:
        Object[] r109 = r107.toArray(new com.obric.oui.color.b[0][]);
        if (r109 == null) goto L32;
        com.obric.oui.color.b[][] r110 = (com.obric.oui.color.b[][]) r109;
        int[] r111 = kma.b.f504114d;
        if (r103.length != r110.length) goto L30;
        if (r103.length == 0) goto L28;
        int r112 = 0;
    L17:
        if (r112 >= r103.length) goto L22;
        if (r103[r112].length == 0) goto L20;
        r112 = r112 + 1;
        goto L17
    L20:
        com.obric.oui.color.b[] r113 = r110[r112];
    L23:
        if (r113 != null) goto L26;
        r113 = r110[0];
    L26:
        return new kma.a(new kma.b(r103, r110, r113));
    L22:
        r113 = null;
        goto L23
    L28:
        throw new IllegalArgumentException("states must not be empty");
    L30:
        throw new IllegalArgumentException("states.size(" + r103.length + ") must equal configs.size(" + r110.length + ")");
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList c(b r100) {
        if (r100.a(MaterialXmlParser$buildColorStateList$1.INSTANCE) == false) goto L7;
        return ColorStateList.valueOf(((Number) r100.f401405a).intValue());
    L7:
        return new ColorStateList(f401401b, new int[]{((Number) r100.f401408d).intValue(), ((Number) r100.f401408d).intValue(), ((Number) r100.f401409e).intValue(), ((Number) r100.f401409e).intValue(), ((Number) r100.f401409e).intValue(), ((Number) r100.f401409e).intValue(), ((Number) r100.f401406b).intValue(), ((Number) r100.f401407c).intValue(), ((Number) r100.f401408d).intValue(), ((Number) r100.f401409e).intValue(), ((Number) r100.f401410f).intValue(), ((Number) r100.f401405a).intValue()});
    }

    public static String h(String r100) {
        return StringsKt.replace$default(StringsKt.trim(r100).toString().toLowerCase(Locale.ROOT), '-', '_', false, 4, null);
    }

    public static com.obric.oui.color.a[] i(XmlPullParser r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.getDepth();
    L3:
        int r103 = r100.next();
        if (r103 == 1) goto L20;
        if (r103 != 2) goto L8;
        if (Intrinsics.areEqual(h(r100.getName()), "blend_config") == true) goto L15;
        v(r100);
        goto L3
    L15:
        com.obric.oui.color.a r104 = k(r100);
        if (r104 == null) goto L3;
        r101.add(r104);
        goto L3
    L8:
        if (r103 != 3) goto L3;
        if (r100.getDepth() != r102) goto L3;
    L20:
        boolean r105 = false;
        Object[] r106 = r101.toArray(new com.obric.oui.color.a[0]);
        if (r106 == null) goto L32;
        if (((com.obric.oui.color.a[]) r106).length != 0) goto L26;
        r105 = true;
    L26:
        if ((!r105) == true) goto L30;
        r106 = null;
    L30:
        return (com.obric.oui.color.a[]) r106;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static a j(XmlPullParser r110) {
        a r100 = r(r110, null);
        if (r100 != null) goto L79;
        boolean r101 = false;
        if (g(r110, new String[]{"color"}) == false) goto L14;
        com.obric.oui.color.a r111 = k(r110);
        if (r111 != null) goto L9;
        com.obric.oui.color.a[] r102 = null;
    L10:
        if (r102 != null) goto L12;
        return null;
    L12:
        int r103 = kma.a.f504112b;
        return new a(r102, kma.a.C6574a.c(r102));
    L9:
        r102 = new com.obric.oui.color.a[]{r111};
        goto L10
    L14:
        ArrayList r104 = new ArrayList();
        int r105 = r110.getDepth();
        com.obric.oui.color.a[] r106 = null;
        com.obric.oui.color.a[] r107 = null;
        com.obric.oui.color.a[] r108 = null;
        com.obric.oui.color.a[] r109 = null;
        com.obric.oui.color.a[] r112 = null;
        com.obric.oui.color.a[] r113 = null;
    L15:
        int r114 = r110.next();
        if (r114 == 1) goto L51;
        if (r114 != 2) goto L20;
        String r115 = h(r110.getName());
        if (Intrinsics.areEqual(r115, "blend_config") == true) goto L27;
        if (Intrinsics.areEqual(r115, MaterialState.NORMAL.getNodeName()) == true) goto L33;
        if (Intrinsics.areEqual(r115, MaterialState.PRESS.getNodeName()) == true) goto L36;
        if (Intrinsics.areEqual(r115, MaterialState.HOVER.getNodeName()) == true) goto L39;
        if (Intrinsics.areEqual(r115, MaterialState.CHECKED.getNodeName()) == true) goto L42;
        if (Intrinsics.areEqual(r115, MaterialState.SELECTED.getNodeName()) == true) goto L45;
        if (Intrinsics.areEqual(r115, MaterialState.DISABLE.getNodeName()) == true) goto L48;
        v(r110);
        goto L15
    L48:
        r113 = i(r110);
        goto L15
    L45:
        r112 = i(r110);
        goto L15
    L42:
        r109 = i(r110);
        goto L15
    L39:
        r108 = i(r110);
        goto L15
    L36:
        r107 = i(r110);
        goto L15
    L33:
        r106 = i(r110);
        goto L15
    L27:
        com.obric.oui.color.a r116 = k(r110);
        if (r116 == null) goto L15;
        r104.add(r116);
        goto L15
    L20:
        if (r114 != 3) goto L15;
        if (r110.getDepth() != r105) goto L15;
    L51:
        if (r106 == null) goto L53;
    L59:
        b r117 = u(r106, r107, r108, r109, r112, r113);
        if (r117 == null) goto L63;
        kma.a r118 = b(r117);
        return new a(com.obric.oui.color.c.a(r118.f504113a.f504118c), r118);
    L63:
        Object[] r119 = r104.toArray(new com.obric.oui.color.a[0]);
        if (r119 == null) goto L78;
        if (((com.obric.oui.color.a[]) r119).length != 0) goto L69;
        r101 = true;
    L69:
        if ((!r101) == true) goto L72;
        r119 = null;
    L72:
        com.obric.oui.color.a[] r120 = (com.obric.oui.color.a[]) r119;
        if (r120 == null) goto L113;
        int r121 = kma.a.f504112b;
        return new a(r120, kma.a.C6574a.c(r120));
    L113:
        return null;
    L78:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L53:
        if ((!r104.isEmpty()) == false) goto L59;
        Object[] r122 = r104.toArray(new com.obric.oui.color.a[0]);
        if (r122 == null) goto L58;
        r106 = (com.obric.oui.color.a[]) r122;
        goto L59
    L58:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L79:
        f401400a.getClass();
        v(r110);
        return r100;
    }

    public static com.obric.oui.color.a k(XmlPullParser r100) {
        Integer r101 = m(d(r100, new String[]{"color"}));
        if (r101 != null) goto L6;
        v(r100);
        return null;
    L6:
        int r102 = r101.intValue();
        Integer r103 = l(d(r100, new String[]{"blend_mode"}));
        if (r103 != null) goto L9;
        int r104 = BlendMode.SRC_OVER.porterDuffMode;
    L10:
        v(r100);
        return new com.obric.oui.color.a(r102, r104);
    L9:
        r104 = r103.intValue();
        goto L10
    }

    public static Integer l(String r100) {
        int r101 = 0;
        if (r100 == null) goto L14;
        String r102 = StringsKt.trim(r100).toString();
        if (r102 == null) goto L14;
        if (r102.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
    L15:
        if (r102 != null) goto L17;
        return null;
    L17:
        Integer r104 = StringsKt.toIntOrNull(r102);
        if (r104 != null) goto L31;
        String r105 = h(r102).toUpperCase(Locale.ROOT);
        BlendMode[] r106 = BlendMode.values();
        int r107 = r106.length;
    L20:
        if (r101 >= r107) goto L25;
        BlendMode r108 = r106[r101];
        MaterialXmlParser r109 = f401400a;
        String r110 = r108.name();
        r109.getClass();
        if (Intrinsics.areEqual(h(r110).toUpperCase(Locale.ROOT), r105) == true) goto L26;
        r101 = r101 + 1;
    L26:
        if (r108 != null) goto L29;
        return null;
    L29:
        return Integer.valueOf(r108.porterDuffMode);
    L25:
        r108 = null;
        goto L26
    L31:
        return Integer.valueOf(r104.intValue());
    L11:
        r103 = false;
    L14:
        r102 = null;
        goto L15
    }

    public static Integer m(String r100) {
        if (r100 == null) goto L14;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L14;
        if (r101.length() <= 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
    L15:
        if (r101 != null) goto L33;
        return null;
    L33:
        if (StringsKt.startsWith$default(r101, "#", false, 2, null) == false) goto L21;
        int r103 = Color.parseColor(r101);     // Catch: Throwable -> L32
    L30:
        return Integer.valueOf(r103);
    L21:
        if (StringsKt.startsWith(r101, "0x", true) == false) goto L23;
        r103 = (int) CastLongProtector.parseLong(r101.substring(2), CharsKt.checkRadix(16));     // Catch: Throwable -> L32
        goto L30
    L23:
        Long r104 = StringsKt.toLongOrNull(r101);     // Catch: Throwable -> L32
        if (r104 != null) goto L26;
        Integer r105 = null;
    L27:
        if (r105 != null) goto L29;
        r103 = Color.parseColor(r101);     // Catch: Throwable -> L32
        goto L30
    L29:
        r103 = r105.intValue();     // Catch: Throwable -> L32
        goto L30
    L26:
        r105 = Integer.valueOf((int) r104.longValue());     // Catch: Throwable -> L32
    L35:
        return null;
    L11:
        r102 = false;
    L14:
        r101 = null;
        goto L15
    }

    public static Integer n(XmlPullParser r100) {
        Integer r101 = m(d(r100, new String[]{"color"}));
        if (r101 != null) goto L30;
        StringBuilder r102 = new StringBuilder();
        int r103 = r100.getDepth();
    L5:
        int r104 = r100.next();
        boolean r105 = true;
        if (r104 == 1) goto L21;
        if (r104 != 2) goto L10;
        v(r100);
        goto L5
    L10:
        if (r104 != 3) goto L12;
        if (r100.getDepth() != r103) goto L5;
    L12:
        if (r104 == 4) goto L16;
        if (r104 != 5) goto L5;
    L16:
        r102.append(r100.getText());
    L21:
        String r106 = StringsKt.trim(r102.toString()).toString();
        if (r106.length() > 0) goto L25;
        r105 = false;
    L25:
        if (r105 == true) goto L29;
        r106 = null;
    L29:
        return m(r106);
    L30:
        int r107 = r101.intValue();
        f401400a.getClass();
        v(r100);
        return Integer.valueOf(r107);
    }

    public static Float o(String r100) {
        if (r100 == null) goto L14;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L14;
        if (r101.length() <= 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
    L15:
        if (r101 != null) goto L18;
        return null;
    L18:
        return StringsKt.toFloatOrNull(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(r101, "dp"), GXTemplateKey.GAIAX_PX), CloudControlInf.SP));
    L11:
        r102 = false;
    L14:
        r101 = null;
        goto L15
    }

    public static i0 s(XmlPullParser r100) {
        Float r101 = o(d(r100, new String[]{"width"}));
        Integer r102 = m(d(r100, new String[]{"color"}));
        Integer r103 = l(d(r100, new String[]{"blend_mode"}));
        v(r100);
        BlendMode r104 = null;
        if (r101 == null) goto L22;
        if (r102 == null) goto L22;
        float r105 = r101.floatValue();
        int r106 = r102.intValue();
        if (r103 == null) goto L18;
        int r107 = r103.intValue();
        BlendMode[] r108 = BlendMode.values();
        int r109 = r108.length;
        int r110 = 0;
    L10:
        if (r110 >= r109) goto L18;
        BlendMode r111 = r108[r110];
        if (r111.porterDuffMode != r107) goto L14;
        boolean r112 = true;
    L15:
        if (r112 == true) goto L16;
        r110 = r110 + 1;
        goto L10
    L16:
        r104 = r111;
        goto L18
    L14:
        r112 = false;
    L18:
        if (r104 != null) goto L21;
        r104 = BlendMode.SRC_OVER;
    L21:
        return new i0(r105, r106, r104);
    L22:
        return null;
    }

    public static i0 t(XmlPullParser r100) {
        if (g(r100, new String[]{"width", "color"}) == true) goto L5;
        int r101 = r100.getDepth();
    L7:
        int r102 = r100.next();
        if (r102 == 1) goto L30;
        if (r102 == 2) goto L18;
        if (r102 != 3) goto L7;
        if (r100.getDepth() != r101) goto L7;
        return null;
    L18:
        if (Intrinsics.areEqual(h(r100.getName()), "stroke") == true) goto L29;
        v(r100);
        return null;
    L29:
        return s(r100);
    L30:
        return null;
    L5:
        return s(r100);
    }

    public static void v(XmlPullParser r100) {
        int r101 = 1;
    L3:
        if (r101 <= 0) goto L13;
        int r102 = r100.next();
        if (r102 == 1) goto L23;
        if (r102 != 2) goto L9;
        r101 = r101 + 1;
        goto L3
    L9:
        if (r102 != 3) goto L3;
        r101 = r101 - 1;
        goto L3
    L23:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c p(XmlPullParser r210) {
        MaterialXmlParser r100 = this;
        Integer r101 = m(f(r100, r210, MaterialState.NORMAL, "fallback_bg_color", 4));
        if (r101 != null) goto L5;
        r101 = m(d(r210, new String[]{"fallback_bg_color"}));
    L5:
        b r102 = u(r101, m(f(r100, r210, MaterialState.PRESS, "fallback_bg_color", 4)), m(f(r100, r210, MaterialState.HOVER, "fallback_bg_color", 4)), m(f(r100, r210, MaterialState.CHECKED, "fallback_bg_color", 4)), m(f(r100, r210, MaterialState.SELECTED, "fallback_bg_color", 4)), m(f(r100, r210, MaterialState.DISABLE, "fallback_bg_color", 4)));
        if (r102 != null) goto L8;
        ColorStateList r103 = null;
    L9:
        String r110 = null;
        c r111 = new c(r103, null, null, null, null, o(d(r210, new String[]{"blur_radius"})), null, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION_REASON3);
        a r104 = r(r210, "blend_configs");
        if (r104 == null) goto L13;
        r111.f401454c = r104.f401403a;
        r111.f401453b = r104.f401404b;
    L13:
        int r105 = r210.getDepth();
    L14:
        int r106 = r210.next();
        if (r106 == 1) goto L396;
        int r107 = 2;
        int r108 = 3;
        if (r106 != 2) goto L18;
        String r109 = h(r210.getName());
        boolean r112 = false;
        switch(r109.hashCode()) {
            case -1622636237: goto L389;
            case -1115483408: goto L378;
            case -891980232: goto L374;
            case -220247165: goto L361;
            case 97532362: goto L304;
            case 737726312: goto L220;
            case 1690590746: goto L131;
            case 1873723302: goto L82;
            case 2053811027: goto L27;
            default: goto L394;
        };
    L27:
        if (r109.equals("shadows") == false) goto L394;
        ArrayList r113 = new ArrayList();
        int r114 = r210.getDepth();
    L30:
        int r115 = r210.next();
        if (r115 == 1) goto L69;
        if (r115 != 2) goto L33;
        if (Intrinsics.areEqual(h(r210.getName()), GXViewKey.VIEW_TYPE_SHADOW_LAYOUT) == false) goto L67;
        Integer r116 = m(d(r210, new String[]{"color"}));
        if (r116 != null) goto L43;
        v(r210);
        Object r117 = r110;
    L64:
        if (r117 == null) goto L68;
        r113.add(r117);
    L68:
        r108 = 3;
        goto L30
    L43:
        int r211 = r116.intValue();
        Float r118 = o(d(r210, new String[]{"x"}));
        if (r118 != null) goto L46;
        float r212 = 0.0f;
    L47:
        Float r119 = o(d(r210, new String[]{"y"}));
        if (r119 != null) goto L50;
        float r213 = 0.0f;
    L51:
        Float r120 = o(d(r210, new String[]{"blur_radius"}));
        if (r120 != null) goto L54;
        float r214 = 0.0f;
    L55:
        Float r121 = o(d(r210, new String[]{"spread"}));
        if (r121 != null) goto L58;
        float r215 = 0.0f;
    L59:
        Integer r122 = l(d(r210, new String[]{"blend_mode"}));
        if (r122 != null) goto L62;
        int r216 = -1;
    L63:
        com.obric.oui.shadow.a r123 = new com.obric.oui.shadow.a(r212, r213, r214, r211, r215, r216);
        v(r210);
        r117 = r123;
        goto L64
    L62:
        r216 = r122.intValue();
        goto L63
    L58:
        r215 = r121.floatValue();
        goto L59
    L54:
        r214 = r120.floatValue();
        goto L55
    L50:
        r213 = r119.floatValue();
        goto L51
    L46:
        r212 = r118.floatValue();
        goto L47
    L67:
        v(r210);
        goto L68
    L33:
        if (r115 != r108) goto L30;
        if (r210.getDepth() != r114) goto L30;
    L69:
        Object[] r124 = r113.toArray(new com.obric.oui.shadow.a[0]);
        if (r124 == null) goto L80;
        if (((com.obric.oui.shadow.a[]) r124).length != 0) goto L74;
        r112 = true;
    L74:
        Object r125 = r124;
        if ((!r112) == true) goto L78;
        r125 = r110;
    L78:
        r111.f401460i = (com.obric.oui.shadow.a[]) r125;
        goto L14
    L80:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L82:
        if (r109.equals("fallback_bg_color") == false) goto L394;
        b r126 = u(m(f(r100, r210, MaterialState.NORMAL, r110, 12)), m(f(r100, r210, MaterialState.PRESS, r110, 12)), m(f(r100, r210, MaterialState.HOVER, r110, 12)), m(f(r100, r210, MaterialState.CHECKED, r110, 12)), m(f(r100, r210, MaterialState.SELECTED, r110, 12)), m(f(r100, r210, MaterialState.DISABLE, r110, 12)));
        if (r126 != null) goto L87;
        Object r127 = r110;
    L88:
        if (r127 != null) goto L128;
        Integer r128 = m(d(r210, new String[]{"color"}));
        if (r128 == null) goto L92;
        v(r210);
        ColorStateList r129 = ColorStateList.valueOf(r128.intValue());
    L129:
        r111.f401452a = r129;
    L395:
        r100 = this;
        r110 = null;
        goto L14
    L92:
        int r130 = r210.getDepth();
        Object r131 = r110;
        Object r217 = r131;
        Object r218 = r217;
        Object r219 = r218;
        Object r220 = r219;
        Object r221 = r220;
    L93:
        int r132 = r210.next();
        if (r132 == 1) goto L121;
        if (r132 != 2) goto L97;
        String r133 = h(r210.getName());
        if (Intrinsics.areEqual(r133, MaterialState.NORMAL.getNodeName()) == true) goto L104;
        if (Intrinsics.areEqual(r133, MaterialState.PRESS.getNodeName()) == true) goto L107;
        if (Intrinsics.areEqual(r133, MaterialState.HOVER.getNodeName()) == true) goto L110;
        if (Intrinsics.areEqual(r133, MaterialState.CHECKED.getNodeName()) == true) goto L113;
        if (Intrinsics.areEqual(r133, MaterialState.SELECTED.getNodeName()) == true) goto L116;
        if (Intrinsics.areEqual(r133, MaterialState.DISABLE.getNodeName()) == true) goto L119;
        v(r210);
        goto L93
    L119:
        r221 = n(r210);
        goto L93
    L116:
        r220 = n(r210);
        goto L93
    L113:
        r219 = n(r210);
        goto L93
    L110:
        r218 = n(r210);
        goto L93
    L107:
        r217 = n(r210);
        goto L93
    L104:
        r131 = n(r210);
        goto L93
    L97:
        if (r132 != 3) goto L93;
        if (r210.getDepth() != r130) goto L93;
    L121:
        if (r131 != null) goto L123;
        Object r222 = r110;
    L124:
        b r134 = u(r222, r217, r218, r219, r220, r221);
        if (r134 != null) goto L127;
        r129 = r110;
        goto L129
    L127:
        r129 = c(r134);
        goto L129
    L123:
        r222 = r131;
        goto L124
    L128:
        f401400a.getClass();
        v(r210);
        r129 = r127;
        goto L129
    L87:
        r127 = c(r126);
        goto L88
    L131:
        if (r109.equals("blur_config") == false) goto L394;
        Float r135 = o(d(r210, new String[]{"blur_radius"}));
        String r136 = d(r210, new String[]{"direction"});
        if (r136 != null) goto L136;
        Integer r137 = r110;
    L164:
        if (r137 != 0) goto L166;
        int r223 = 0;
    L167:
        Float r138 = o(d(r210, new String[]{"alpha"}));
        if (r138 != null) goto L170;
        float r224 = 1.0f;
    L171:
        String r139 = d(r210, new String[]{"curve_type"});
        if (r139 != null) goto L174;
        Integer r140 = r110;
    L206:
        if (r140 != 0) goto L208;
        int r225 = 0;
    L209:
        Float r141 = o(d(r210, new String[]{"end_point"}));
        if (r141 != null) goto L212;
        float r226 = 1.0f;
    L213:
        v(r210);
        if (r135 != null) goto L216;
        com.obric.oui.blur.a r142 = r110;
    L217:
        r111.f401458g = r142;
        goto L395
    L216:
        r142 = new com.obric.oui.blur.a(r135.floatValue(), r223, r224, r225, r226);
        goto L217
    L212:
        r226 = r141.floatValue();
        goto L213
    L208:
        r225 = r140.intValue();
        goto L209
    L174:
        String r143 = h(r139);
        switch(r143.hashCode()) {
            case -1102672091: goto L202;
            case -356211779: goto L198;
            case -32570448: goto L194;
            case 54365080: goto L190;
            case 1672389401: goto L186;
            case 1829408660: goto L182;
            case 1939029025: goto L178;
            default: goto L205;
        };
    L205:
        r140 = StringsKt.toIntOrNull(r139);
        goto L206
    L178:
        if (r143.equals("in_quad") == false) goto L205;
        r140 = 1;
        goto L206
    L182:
        if (r143.equals("inout_cubic") == false) goto L205;
        r140 = 6;
        goto L206
    L186:
        if (r143.equals("out_cubic") == false) goto L205;
        r140 = 5;
        goto L206
    L190:
        if (r143.equals("out_quad") == false) goto L205;
        r140 = 2;
        goto L206
    L194:
        if (r143.equals("in_cubic") == false) goto L205;
        r140 = 4;
        goto L206
    L198:
        if (r143.equals("inout_quad") == false) goto L205;
        r140 = 3;
        goto L206
    L202:
        if (r143.equals("linear") == false) goto L205;
        r140 = 0;
        goto L206
    L170:
        r224 = r138.floatValue();
        goto L171
    L166:
        r223 = r137.intValue();
        goto L167
    L136:
        String r144 = h(r136);
        switch(r144.hashCode()) {
            case -1372950257: goto L160;
            case -1039745817: goto L156;
            case -885896177: goto L152;
            case -149309725: goto L148;
            case 3387192: goto L144;
            case 818060433: goto L140;
            default: goto L163;
        };
    L163:
        r137 = StringsKt.toIntOrNull(r136);
        goto L164
    L140:
        if (r144.equals("progress_rightleft") == false) goto L163;
        r137 = 4;
        goto L164
    L144:
        if (r144.equals("none") == false) goto L163;
        r137 = -1;
        goto L164
    L148:
        if (r144.equals("progress_leftright") == false) goto L163;
        r137 = 3;
        goto L164
    L152:
        if (r144.equals("progress_updown") == false) goto L163;
        r137 = 2;
        goto L164
    L156:
        if (r144.equals("normal") == false) goto L163;
        r137 = 0;
        goto L164
    L160:
        if (r144.equals("progress_downup") == false) goto L163;
        r137 = 1;
        goto L164
    L220:
        if (r109.equals("stroke_statelist") == false) goto L394;
        boolean r145 = g(r210, new String[]{"width", "color"});
        int[] r146 = kma.d.f504121d;
        if (r145 == false) goto L228;
        i0 r147 = s(r210);
        Object r148 = r110;
        if (r147 == null) goto L299;
        j0 r149 = r147.a();
        kma.c r150 = new kma.c(new kma.d(new int[][]{r146}, new j0[]{r149}, r149));
    L300:
        if (r150 == 0) goto L395;
        r111.f401455d = r150;
    L299:
        r150 = r148;
        goto L300
    L228:
        int r151 = r210.getDepth();
        String r152 = r110;
        String r153 = r152;
        String r227 = r153;
        String r228 = r227;
        String r229 = r228;
        String r230 = r229;
        Object r231 = r230;
        Object r154 = r152;
        Object r155 = r153;
        Object r232 = r227;
        Object r233 = r228;
        Object r234 = r229;
        Object r235 = r230;
    L229:
        int r156 = r210.next();
        if (r156 == 1) goto L261;
        if (r156 != r107) goto L233;
        String r157 = h(r210.getName());
        if (Intrinsics.areEqual(r157, "stroke") == false) goto L243;
        r155 = s(r210);
    L241:
        r107 = 2;
        r154 = r154;
        r155 = r155;
        r232 = r232;
        r233 = r233;
        r234 = r234;
        r235 = r235;
        r231 = r231;
        goto L229
    L243:
        if (Intrinsics.areEqual(r157, MaterialState.NORMAL.getNodeName()) == false) goto L246;
        r154 = t(r210);
        goto L241
    L246:
        if (Intrinsics.areEqual(r157, MaterialState.PRESS.getNodeName()) == false) goto L249;
        r232 = t(r210);
        goto L241
    L249:
        if (Intrinsics.areEqual(r157, MaterialState.HOVER.getNodeName()) == false) goto L252;
        r233 = t(r210);
        goto L241
    L252:
        if (Intrinsics.areEqual(r157, MaterialState.CHECKED.getNodeName()) == false) goto L255;
        r234 = t(r210);
        goto L241
    L255:
        if (Intrinsics.areEqual(r157, MaterialState.SELECTED.getNodeName()) == false) goto L258;
        r235 = t(r210);
        goto L241
    L258:
        if (Intrinsics.areEqual(r157, MaterialState.DISABLE.getNodeName()) == false) goto L260;
        r231 = t(r210);
        goto L241
    L260:
        v(r210);
        goto L241
    L233:
        if (r156 != 3) goto L241;
        if (r210.getDepth() != r151) goto L241;
    L261:
        if (r154 != null) goto L263;
        Object r236 = r155;
    L264:
        b r158 = u(r236, r232, r233, r234, r235, r231);
        if (r158 != null) goto L267;
        r150 = 0;
        goto L300
    L267:
        int r159 = kma.c.f504119b;
        i0 r160 = (i0) r158.f401405a;
        i0 r161 = (i0) r158.f401406b;
        i0 r162 = (i0) r158.f401407c;
        i0 r163 = (i0) r158.f401408d;
        i0 r164 = (i0) r158.f401410f;
        if (r160 != null) goto L270;
        j0 r165 = null;
    L271:
        if (r160 != null) goto L273;
        j0 r166 = null;
    L274:
        if (r163 != null) goto L276;
        j0 r167 = null;
    L277:
        if (r161 != null) goto L279;
        j0 r168 = null;
    L280:
        if (r162 != null) goto L282;
        j0 r169 = null;
    L283:
        if (r164 != null) goto L285;
        j0 r170 = null;
    L287:
        if (kma.d.a(r165, r166) == true) goto L289;
    L297:
        kma.d r171 = new kma.d(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new j0[]{r168, r169, r167, r166, r170, r165}, r165);
    L298:
        r148 = new kma.c(r171);
        goto L299
    L289:
        if (kma.d.a(r165, r167) == false) goto L297;
        if (kma.d.a(r165, r168) == false) goto L297;
        if (kma.d.a(r165, r169) == false) goto L297;
        if (kma.d.a(r165, r170) == false) goto L297;
        r171 = new kma.d(new int[][]{r146}, new j0[]{r165}, r165);
        goto L298
    L285:
        r170 = r164.a();
        goto L287
    L282:
        r169 = r162.a();
        goto L283
    L279:
        r168 = r161.a();
        goto L280
    L276:
        r167 = r163.a();
        goto L277
    L273:
        r166 = r160.a();
        goto L274
    L270:
        r165 = r160.a();
        goto L271
    L263:
        r236 = r154;
        goto L264
    L304:
        if (r109.equals("fluid") == false) goto L394;
        Float r172 = o(d(r210, new String[]{"refraction_height"}));
        if (r172 == null) goto L329;
        float r173 = r172.floatValue();
        Float r174 = o(d(r210, new String[]{"refraction_strength"}));
        if (r174 == null) goto L329;
        float r175 = r174.floatValue();
        Float r176 = o(d(r210, new String[]{"highlight_angle"}));
        if (r176 == null) goto L329;
        float r177 = r176.floatValue();
        Float r178 = o(d(r210, new String[]{"highlight_falloff"}));
        if (r178 == null) goto L329;
        float r179 = r178.floatValue();
        Float r180 = o(d(r210, new String[]{"highlight_width"}));
        if (r180 == null) goto L329;
        float r181 = r180.floatValue();
        Float r182 = o(d(r210, new String[]{"highlight_alpha"}));
        if (r182 == null) goto L329;
        float r183 = r182.floatValue();
        Float r184 = o(d(r210, new String[]{"highlight_inset"}));
        if (r184 == null) goto L329;
        float r185 = r184.floatValue();
        Float r186 = o(d(r210, new String[]{"highlight_strength"}));
        if (r186 == null) goto L329;
        float[] r187 = {r173, r175, r177, r179, r181, r183, r185, r186.floatValue()};
        Integer r188 = m(d(r210, new String[]{"first_layer_highlight_color"}));
        Integer r189 = l(d(r210, new String[]{"first_layer_highlight_blend_mode"}));
        Integer r190 = m(d(r210, new String[]{"second_layer_highlight_color"}));
        Integer r191 = l(d(r210, new String[]{"second_layer_highlight_blend_mode"}));
        Float r192 = o(d(r210, new String[]{"chromatic_aberration"}));
        if (r188 != null) goto L338;
        if (r189 != null) goto L338;
        if (r190 != null) goto L338;
        if (r191 != null) goto L338;
        if (r192 != null) goto L338;
        float[] r193 = r187;
    L359:
        v(r210);
        r111.f401461j = new com.obric.oui.fluid.a(r193);
    L338:
        FloatSpreadBuilder r194 = new FloatSpreadBuilder(6);
        r194.addSpread(r187);
        FloatCompanionObject r195 = FloatCompanionObject.INSTANCE;
        if (r188 != null) goto L341;
        int r196 = 0;
    L342:
        r194.add(Float.intBitsToFloat(r196));
        if (r189 != null) goto L345;
        int r197 = BlendMode.SRC_OVER.porterDuffMode;
    L346:
        r194.add(r197);
        if (r190 != null) goto L349;
        int r198 = 0;
    L350:
        r194.add(Float.intBitsToFloat(r198));
        if (r191 != null) goto L353;
        int r199 = BlendMode.SRC_OVER.porterDuffMode;
    L354:
        r194.add(r199);
        if (r192 != null) goto L357;
        float r200 = 0.0f;
    L358:
        r194.add(r200);
        r193 = r194.toArray();
        goto L359
    L357:
        r200 = r192.floatValue();
        goto L358
    L353:
        r199 = r191.intValue();
        goto L354
    L349:
        r198 = r190.intValue();
        goto L350
    L345:
        r197 = r189.intValue();
        goto L346
    L341:
        r196 = r188.intValue();
    L329:
        r193 = null;
        goto L359
    L361:
        if (r109.equals("blend_configs") == false) goto L394;
        a r201 = j(r210);
        if (r201 != null) goto L366;
        com.obric.oui.color.a[] r1100 = null;
    L367:
        r111.f401454c = r1100;
        if (r201 != null) goto L370;
        kma.a r1101 = null;
    L371:
        if (r1101 == null) goto L395;
        r111.f401453b = r201.f401404b;
        goto L395
    L370:
        r1101 = r201.f401404b;
        goto L371
    L366:
        r1100 = r201.f401403a;
        goto L367
    L374:
        if (r109.equals("stroke") == false) goto L394;
        r111.f401456e = s(r210);
        goto L395
    L378:
        if (r109.equals("blend_config") == false) goto L394;
        if (g(r210, new String[]{"color"}) == false) goto L386;
        com.obric.oui.color.a r202 = k(r210);
        if (r202 != null) goto L385;
        com.obric.oui.color.a[] r1102 = null;
    L387:
        r111.f401454c = r1102;
        goto L395
    L385:
        r1102 = new com.obric.oui.color.a[]{r202};
        goto L387
    L386:
        r1102 = i(r210);
        goto L387
    L389:
        if (r109.equals("overlayblend_configs") == false) goto L394;
        a r203 = j(r210);
        if (r203 == null) goto L395;
        r111.f401457f = r203.f401404b;
    L394:
        v(r210);
        goto L395
    L18:
        if (r106 != 3) goto L14;
        if (r210.getDepth() != r105) goto L14;
        return r111;
    L396:
        return r111;
    L8:
        r103 = c(r102);
        goto L9
    }

    public static final c[] a(MaterialXmlParser r100, XmlPullParser r101) {
        r100.getClass();
        ArrayList r102 = new ArrayList();
        int r103 = r101.getDepth();
    L3:
        int r104 = r101.next();
        if (r104 == 1) goto L17;
        if (r104 != 2) goto L8;
        if (Intrinsics.areEqual(h(r101.getName()), "material_config") == true) goto L15;
        v(r101);
        goto L3
    L15:
        r102.add(r100.p(r101));
        goto L3
    L8:
        if (r104 != 3) goto L3;
        if (r101.getDepth() != r103) goto L3;
    L17:
        boolean r105 = false;
        Object[] r106 = r102.toArray(new c[0]);
        if (r106 == null) goto L29;
        if (((c[]) r106).length != 0) goto L23;
        r105 = true;
    L23:
        if ((!r105) == true) goto L27;
        r106 = null;
    L27:
        return (c[]) r106;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static String d(XmlPullParser r100, String... r101) {
        boolean r102 = false;
        if (r101.length != 0) goto L5;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
        return null;
    L9:
        Set r104 = ArraysKt.toSet(r101);
        int r105 = r100.getAttributeCount();
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L29;
        int r107 = r106 + 1;
        String r108 = r100.getAttributeName(r106);
        if (r108 == null) goto L28;
        if (r104.contains(r108) == false) goto L28;
        String r109 = r100.getAttributeValue(r106);
        if (r109 == null) goto L35;
        String r110 = StringsKt.trim(r109).toString();
        if (r110 != null) goto L23;
        return null;
    L23:
        if (r110.length() <= 0) goto L25;
        r102 = true;
    L25:
        if (r102 == true) goto L27;
        return null;
    L27:
        return r110;
    L35:
        return null;
    L28:
        r106 = r107;
        goto L10
    L29:
        return null;
    L5:
        r103 = false;
        goto L7
    }

    public static boolean g(XmlPullParser r100, String... r101) {
        if (d(r100, (String[]) Arrays.copyOf(r101, r101.length)) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static a r(XmlPullParser r100, String r101) {
        if (r101 != null) goto L6;
    L8:
        r101 = null;
    L9:
        b r102 = u(q(r100, r101, MaterialState.NORMAL), q(r100, r101, MaterialState.PRESS), q(r100, r101, MaterialState.HOVER), q(r100, r101, MaterialState.CHECKED), q(r100, r101, MaterialState.SELECTED), q(r100, r101, MaterialState.DISABLE));
        if (r102 != null) goto L12;
        return null;
    L12:
        kma.a r103 = b(r102);
        return new a(com.obric.oui.color.c.a(r103.f504113a.f504118c), r103);
    L6:
        if ((!StringsKt.isBlank(r101)) == false) goto L8;
        goto L8
    }

    public static com.obric.oui.color.a[] q(XmlPullParser r100, String r101, MaterialState r102) {
        Integer r103 = m(e(r100, r102, "color", r101));
        if (r103 != null) goto L5;
        com.obric.oui.color.a r104 = null;
    L10:
        if (r104 != null) goto L13;
        return null;
    L13:
        return new com.obric.oui.color.a[]{r104};
    L5:
        int r105 = r103.intValue();
        Integer r106 = l(e(r100, r102, "blend_mode", r101));
        if (r106 != null) goto L8;
        int r107 = BlendMode.SRC_OVER.porterDuffMode;
    L9:
        r104 = new com.obric.oui.color.a(r105, r107);
        goto L10
    L8:
        r107 = r106.intValue();
        goto L9
    }

    public static String e(XmlPullParser r100, MaterialState r101, String r102, String r103) {
        String r104 = r101.getXmlName();
        List r105 = CollectionsKt.createListBuilder();
        if (r103 != null) goto L5;
    L8:
        boolean r106 = true;
    L10:
        if (r106 == true) goto L15;
        r105.add(r103 + '_' + r104);
        if (r102 == null) goto L15;
        r105.add(r103 + '_' + r104 + '_' + r102);
    L15:
        if (r102 == null) goto L18;
        r105.add(r104 + '_' + r102);
    L18:
        if (r102 != null) goto L20;
        r105.add(r104);
    L20:
        Object[] r107 = CollectionsKt.build(r105).toArray(new String[0]);
        if (r107 == null) goto L25;
        String[] r108 = (String[]) r107;
        return d(r100, (String[]) Arrays.copyOf(r108, r108.length));
    L25:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L5:
        if (StringsKt.isBlank(r103) == true) goto L8;
        r106 = false;
        goto L10
    }

    public static /* synthetic */ String f(MaterialXmlParser r100, XmlPullParser r101, MaterialState r102, String r103, int r104) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        r100.getClass();
        return e(r101, r102, null, r103);
    }

    public static b u(Object r100, Object r101, Object r102, Object r110, Object r111, Object r112) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 != null) goto L7;
        Object r103 = r100;
    L8:
        if (r102 != null) goto L10;
        Object r104 = r103;
    L12:
        if (r110 != null) goto L14;
        Object r105 = r100;
    L15:
        if (r111 != null) goto L17;
        Object r106 = r100;
    L18:
        if (r112 != null) goto L20;
        Object r107 = r100;
    L22:
        return new b(r100, r103, r104, r105, r106, r107);
    L20:
        r107 = r112;
        goto L22
    L17:
        r106 = r111;
        goto L18
    L14:
        r105 = r110;
        goto L15
    L10:
        r104 = r102;
        goto L12
    L7:
        r103 = r101;
        goto L8
    }
}
