package kn8;

import com.larus.bmhome.chat.markdown.reference.SearchReferenceData;
import com.larus.bmhome.chat.markdown.reference.Stage;
import com.larus.bmhome.chat.markdown.reference.ToolType;
import com.larus.bmhome.chat.markdown.reference.r;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.Reference;
import java.util.List;
import jn8.j;
import jn8.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f504271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f504272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f504273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kn8.b f504274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public kn8.a f504275e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f504276f;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f504277a = null;

        static {
            int[] r100 = new int[ToolType.values().length];
            r100[ToolType.SearchPlugin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f504277a = r100;
        }
    }

    public static final class b implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f504278a;

        @Override // jn8.k
        public final void b() {
            c r100 = this.f504278a;
            kn8.a r101 = r100.f504275e;
            if (r101 == null) goto L9;
            Function0<Boolean> r102 = r101.f504265e;
            if (r102 == null) goto L9;
            if (r102.invoke().booleanValue() != true) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == true) goto L30;
            Boolean r104 = r100.f504272b;
            Boolean r105 = Boolean.TRUE;
            r100.f504272b = Boolean.valueOf(!Intrinsics.areEqual(r104, r105));
            Function0<Unit> r106 = r100.f504276f;
            if (r106 == null) goto L15;
            r106.invoke();
        L15:
            kn8.b r107 = r100.f504274d;
            if (r107 != null) goto L18;
            return;
        L18:
            if (a.f504277a[r100.b().ordinal()] != 1) goto L20;
            String r108 = "simple_search";
        L21:
            kn8.a r109 = r100.f504275e;
            if (r109 == null) goto L26;
            SearchReferenceData r110 = r109.f504266f;
            if (r110 == null) goto L26;
            Integer r111 = r110.getIdx();
        L27:
            ri8.c r112 = ri8.c.f537890a;
            r107.d(r108, r111, ri8.c.g(Boolean.valueOf(true ^ Intrinsics.areEqual(r100.f504272b, r105))), r100.b().getValue());
            return;
        L26:
            r111 = null;
            goto L27
        L20:
            r108 = "tool_card";
            goto L21
        L30:
            return;
        L9:
            r103 = false;
            goto L10
        }

        public final void e() {
            c r100 = this.f504278a;
            kn8.a r101 = r100.f504275e;
            if (r101 == null) goto L12;
            SearchReferenceData r102 = r101.f504266f;
            if (r102 == null) goto L12;
            if (r.b(r102) == false) goto L12;
            if (r100.f504273c == true) goto L12;
            boolean r103 = true;
        L13:
            if (r103 == false) goto L29;
            kn8.b r104 = r100.f504274d;
            if (r104 != null) goto L17;
        L27:
            r100.f504273c = true;
            return;
        L17:
            if (a.f504277a[r100.b().ordinal()] != 1) goto L19;
            String r105 = "simple_search";
        L20:
            kn8.a r106 = r100.f504275e;
            if (r106 == null) goto L25;
            SearchReferenceData r107 = r106.f504266f;
            if (r107 == null) goto L25;
            Integer r108 = r107.getIdx();
        L26:
            ri8.c r109 = ri8.c.f537890a;
            r104.e(r105, r108, ri8.c.g(Boolean.valueOf(!Intrinsics.areEqual(r100.f504272b, Boolean.TRUE))), r100.b().getValue());
        L25:
            r108 = null;
            goto L26
        L19:
            r105 = "tool_card";
            goto L20
        L29:
            return;
        L12:
            r103 = false;
            goto L13
        }

        public b(c r100) {
            this.f504278a = r100;
        }

        @Override // jn8.k
        public final void a(boolean r110) {
            c r100 = this.f504278a;
            r100.getClass();
            if (r110 == false) goto L5;
            Stage r101 = Stage.Searching;
        L6:
            int r102 = r101.getValue();
            kn8.a r103 = r100.f504275e;
            kn8.a r104 = null;
            if (r103 == null) goto L11;
            SearchReferenceData r105 = r103.f504266f;
            if (r105 == null) goto L11;
            SearchReferenceData r111 = SearchReferenceData.copy$default(r105, null, null, null, null, Integer.valueOf(r102), null, null, null, null, false, 1007, null);
        L12:
            kn8.a r106 = r100.f504275e;
            if (r106 == null) goto L15;
            r104 = new kn8.a(r106.f504261a, r106.f504262b, r106.f504263c, r106.f504264d, r106.f504265e, r111, r106.f504267g, r106.f504268h, r106.f504269i, r106.f504270j);
        L15:
            r100.f504275e = r104;
            return;
        L11:
            r111 = null;
            goto L12
        L5:
            r101 = Stage.Searched;
            goto L6
        }

        @Override // jn8.k
        public final void c(int r100, Reference r101) {
            c r102 = this.f504278a;
            kn8.b r103 = r102.f504274d;
            if (r103 == null) goto L11;
            kn8.a r104 = r102.f504275e;
            if (r104 == null) goto L9;
            SearchReferenceData r105 = r104.f504266f;
            if (r105 == null) goto L9;
            Integer r106 = r105.getIdx();
        L10:
            r103.b(r100, r101, r106);
        L9:
            r106 = null;
        L11:
            kn8.b r107 = r102.f504274d;
            if (r107 == null) goto L15;
            r107.c();
            return;
        }

        @Override // jn8.k
        public final void d(Integer r100, Integer r101, String r102, Reference r103) {
            kn8.b r104 = this.f504278a.f504274d;
            if (r104 == null) goto L6;
            r104.a(r100, r101, r102, r103);
            return;
        }
    }

    public final j a() {
        kn8.a r100 = this.f504275e;
        Boolean r101 = null;
        if (r100 == null) goto L5;
        SearchReferenceData r102 = r100.f504266f;
    L6:
        ToolType r103 = b();
        Boolean r104 = this.f504272b;
        boolean r105 = false;
        boolean r106 = true;
        if (r104 != null) goto L39;
        if (r102 != null) goto L11;
    L9:
        r104 = null;
        goto L39
    L11:
        if (r.d(r103) == true) goto L14;
        Boolean r107 = Boolean.TRUE;
    L13:
        r104 = r107;
        goto L39
    L14:
        List<String> r108 = r102.getQueries();
        if (r108 != null) goto L17;
    L20:
        boolean r109 = true;
    L21:
        if (r109 == false) goto L33;
        List<Reference> r110 = r102.getReference();
        if (r110 != null) goto L25;
    L28:
        boolean r111 = true;
    L29:
        if (r111 == false) goto L33;
        if (r.d(b()) == false) goto L33;
        boolean r112 = true;
    L34:
        if (r112 == false) goto L36;
        r107 = Boolean.TRUE;
        goto L13
    L36:
        kn8.a r113 = this.f504275e;
        if (r113 == null) goto L9;
        r107 = r113.f504269i;
        goto L13
    L25:
        if (r110.isEmpty() == true) goto L28;
        r111 = false;
    L33:
        r112 = false;
        goto L34
    L17:
        if (r108.isEmpty() == true) goto L20;
        r109 = false;
    L39:
        this.f504272b = r104;
        if (r102 == null) goto L66;
        kn8.a r114 = this.f504275e;
        if (r114 == null) goto L47;
        Message r115 = r114.f504262b;
        if (r115 == null) goto L47;
        Integer r116 = Integer.valueOf(r115.getMessageStatusLocal());
    L48:
        if (r116 != null) goto L51;
    L52:
        if (r116 != null) goto L55;
    L57:
        boolean r117 = false;
    L60:
        if (r.c(r102) == false) goto L63;
        if (r117 == false) goto L63;
    L64:
        r105 = true;
    L65:
        r106 = r105;
    L63:
        if (r.a(r102) == false) goto L65;
    L55:
        if (r116.intValue() != 22) goto L57;
    L58:
        r117 = true;
        goto L60
    L51:
        if (r116.intValue() == 23) goto L58;
    L47:
        r116 = null;
    L66:
        kn8.a r118 = this.f504275e;
        if (r118 == null) goto L71;
        Message r119 = r118.f504262b;
        if (r119 == null) goto L71;
        String r120 = r119.getMessageId();
    L72:
        kn8.a r121 = this.f504275e;
        if (r121 == null) goto L75;
        Integer r122 = r121.f504264d;
    L76:
        if (r102 == null) goto L78;
        String r123 = r102.getTitle();
    L79:
        if (r102 == null) goto L81;
        List<Reference> r124 = r102.getReference();
    L82:
        if (r102 == null) goto L84;
        List<String> r125 = r102.getQueries();
    L85:
        if (r102 == null) goto L87;
        String r126 = r102.getSearchLoadingText();
    L88:
        if (r102 == null) goto L90;
        Integer r127 = r102.getStage();
    L91:
        if (r102 == null) goto L93;
        Integer r128 = r102.getIdx();
    L94:
        if (r102 == null) goto L96;
        String r129 = r102.getIcon();
    L97:
        if (r102 == null) goto L99;
        String r130 = r102.getIconDark();
    L100:
        if (r102 == null) goto L102;
        String r131 = r102.getToolType();
    L103:
        Boolean r132 = this.f504272b;
        Boolean r210 = Boolean.valueOf(r106);
        kn8.a r133 = this.f504275e;
        if (r133 == null) goto L106;
        String r211 = r133.f504263c;
    L107:
        if (r133 == null) goto L111;
        Message r134 = r133.f504262b;
        if (r134 == null) goto L111;
        String r212 = r134.getConversationId();
    L112:
        kn8.a r135 = this.f504275e;
        if (r135 == null) goto L117;
        Message r136 = r135.f504262b;
        if (r136 == null) goto L117;
        String r213 = r136.getSenderId();
    L118:
        kn8.a r137 = this.f504275e;
        if (r137 == null) goto L121;
        Integer r214 = r137.f504267g;
    L122:
        if (r137 == null) goto L124;
        Boolean r215 = r137.f504268h;
    L125:
        if (r137 == null) goto L127;
        Boolean r216 = r137.f504268h;
    L128:
        if (r137 == null) goto L131;
        r101 = r137.f504270j;
    L131:
        return new j(r120, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r210, r211, r212, r213, r214, r215, r216, r101);
    L127:
        r216 = null;
        goto L128
    L124:
        r215 = null;
        goto L125
    L121:
        r214 = null;
    L117:
        r213 = null;
    L111:
        r212 = null;
        goto L112
    L106:
        r211 = null;
        goto L107
    L102:
        r131 = null;
        goto L103
    L99:
        r130 = null;
        goto L100
    L96:
        r129 = null;
        goto L97
    L93:
        r128 = null;
        goto L94
    L90:
        r127 = null;
        goto L91
    L87:
        r126 = null;
        goto L88
    L84:
        r125 = null;
        goto L85
    L81:
        r124 = null;
        goto L82
    L78:
        r123 = null;
        goto L79
    L75:
        r122 = null;
    L71:
        r120 = null;
        goto L72
    L5:
        r102 = null;
        goto L6
    }

    public final ToolType b() {
        ToolType.a r100 = ToolType.Companion;
        kn8.a r101 = this.f504275e;
        if (r101 == null) goto L7;
        SearchReferenceData r102 = r101.f504266f;
        if (r102 == null) goto L7;
        String r103 = r102.getToolType();
    L8:
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        r100.getClass();
        return ToolType.a.a(r103);
    L7:
        r103 = null;
        goto L8
    }

    public c() {
        this.f504271a = new b(this);
    }
}
