package com.larus.bmhome.chat.component.bottom.core.inputtext.slash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.MultiTypePanelTrigger;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SkillPanelSearch;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SkillSearchIndex;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SlashPanelContent;
import com.larus.bmhome.chat.component.bottom.core.inputtext.a1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.b1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.c1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.d0;
import com.larus.bmhome.chat.component.bottom.core.inputtext.d1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.panel.InputPanelListView;
import com.larus.bmhome.chat.component.bottom.core.inputtext.q1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.s1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.z0;
import com.larus.bmhome.taskskill.b2;
import com.larus.bmhome.taskskill.model.SkillType;
import com.larus.common.apphost.AppHost;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.IContextWindowUsageService;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import t19.s;
import tx9.q3;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class SlashPanelController {
    public boolean A;
    public Job B;
    public long C;
    public Job D;
    public View E;
    public boolean F;
    public long G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatInputWithMentionDelegate f299159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f299160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Fragment f299161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r f299162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<be8.a> f299163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f299164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f299165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<k1, Boolean> f299166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Boolean> f299167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<Unit> f299168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Boolean> f299169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<SlashPanelContent> f299170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Boolean> f299171m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1<Boolean, Unit> f299172n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Unit> f299173o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<k1, Boolean> f299174p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function0<Unit> f299175q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Context f299176r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final SkillPanelSearch f299177s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f299178t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f299179u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f299180v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f299181w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public k1 f299182x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<be8.b> f299183y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f299184z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f299185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f299186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f299187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f299188d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f299189e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f299190f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f299185a, r101.f299185a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f299186b, r101.f299186b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f299187c, r101.f299187c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f299188d, r101.f299188d) == true) goto L21;
            return false;
        L21:
            if (this.f299189e == r101.f299189e) goto L24;
            return false;
        L24:
            if (this.f299190f == r101.f299190f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f299185a.hashCode() * 31;
            String r101 = this.f299186b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f299187c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f299188d;
            if (r108 == null) goto L14;
            r102 = r108.hashCode();
        L14:
            int r109 = (r107 + r102) * 31;
            if (this.f299189e == false) goto L17;
            int r110 = 1231;
        L19:
            return ((r109 + r110) * 31) + this.f299190f;
        L17:
            r110 = 1237;
            goto L19
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "OptionTrace(optionLabel=" + this.f299185a + ", optionSubLabel=" + this.f299186b + ", skillOptionId=" + this.f299187c + ", skillTab=" + this.f299188d + ", isSearchResult=" + this.f299189e + ", position=" + this.f299190f + ')';
        }

        public /* synthetic */ b(String r100, int r101) {
            this(r100, null, null, null, false, r101);
        }

        public b(String r100, String r101, String r102, String r103, boolean r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "optionLabel");
            this.f299185a = r100;
            this.f299186b = r101;
            this.f299187c = r102;
            this.f299188d = r103;
            this.f299189e = r104;
            this.f299190f = r105;
        }
    }

    static {
    }

    public final void d() {
        this.f299181w = false;
        this.f299177s.a();
        View r100 = this.E;
        if (r100 == null) goto L5;
        com.larus.bmhome.view.screenmenu.d.b(r100);
    L5:
        this.E = null;
        this.f299162d.f299230e.i(false);
        this.F = false;
        this.G = 0;
        ExposeXTrackerExtKt.a(this.f299176r, "slash_panel_option:");
        this.C++;
        Job r101 = this.B;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.B = null;
        this.f299184z = false;
        this.f299182x = null;
        this.A = false;
    }

    public final boolean c() {
        k1 r100 = this.f299182x;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.f299174p.invoke(r100).booleanValue() == true) goto L8;
        return false;
    L8:
        d();
        return true;
    }

    public final boolean e() {
        if (this.f299164f.invoke().booleanValue() == false) goto L6;
        return true;
    L6:
        s r100 = s.f544207a;
        Context r101 = this.f299176r;
        s.j(r100, r101, r101.getString(R.string.larus_bot_ban_notice_error), null, false, 28);
        return false;
    }

    public final boolean k() {
        if (this.f299181w == false) goto L11;
        k1 r100 = this.f299182x;
        if (r100 == null) goto L7;
        MultiTypePanelTrigger r101 = r100.f298768d;
    L9:
        if (r101 != MultiTypePanelTrigger.SLASH) goto L11;
        return true;
    L7:
        r101 = null;
    L11:
        return false;
    }

    public final String b(b r110) {
        Object[] r100 = new Object[8];
        r100[0] = "slash_panel_option";
        r100[1] = Long.valueOf(this.G);
        r100[2] = r110.f299185a;
        String r101 = r110.f299186b;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100[3] = r101;
        String r103 = r110.f299187c;
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        r100[4] = r103;
        String r104 = r110.f299188d;
        if (r104 == null) goto L12;
        r102 = r104;
    L12:
        r100[5] = r102;
        r100[6] = Boolean.valueOf(r110.f299189e);
        r100[7] = Integer.valueOf(r110.f299190f);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r100), ":", null, null, 0, null, null, 62, null);
    }

    public final void h(String r100) {
        String r101 = StringsKt.trim(r100).toString();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        g(r101, r102);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void i(b r100) {
        if (k() == true) goto L5;
        return;
    L5:
        String r101 = r100.f299185a;
        String r102 = r100.f299186b;
        String r103 = r100.f299187c;
        String r104 = r100.f299188d;
        boolean r105 = r100.f299189e;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter(r101, "optionLabel");
        q3.b("slash_panel_option_click", q3.a(r101, r102, r103, r104, r105));
    }

    public final void j(b r100) {
        if (k() == true) goto L5;
        return;
    L5:
        String r101 = r100.f299185a;
        String r102 = r100.f299186b;
        String r103 = r100.f299187c;
        String r104 = r100.f299188d;
        boolean r105 = r100.f299189e;
        int r106 = r100.f299190f;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter(r101, "optionLabel");
        JSONObject r107 = q3.a(r101, r102, r103, r104, r105);
        r107.put("position", r106);
        q3.b("slash_panel_option_show", r107);
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.slash.f, java.lang.Object] */
    public final void l(k1 r210) {
        Intrinsics.checkNotNullParameter(r210, "queryRange");
        FLogger r100 = FLogger.f375446a;
        r100.i("SlashPanelController", "[show] begin, trigger=" + r210.f298768d + ", queryLength=" + r210.f298767c.length() + ", active=" + this.f299181w + ", panelVisible=" + this.f299171m.invoke().booleanValue() + ", skillEnabled=" + this.f299180v + ", skills=" + this.f299183y.size() + ", loadingSkills=" + this.f299184z + ", skillsRefreshed=" + this.A + ", showSkillManagementOnly=" + this.H);
        if (this.f299181w == true) goto L5;
        this.F = false;
        this.G++;
    L5:
        this.f299181w = true;
        this.f299182x = r210;
        if (this.f299180v == false) goto L15;
        be8.a r101 = this.f299163e.invoke();
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L15;
        boolean r103 = true;
    L16:
        this.H = r103;
        if (this.f299180v == false) goto L39;
        if (r103 == true) goto L39;
        if (this.A == false) goto L22;
        r100.i("SlashPanelController", "[refreshSkillsIfNeeded] skip, reason=alreadyRefreshed, skills=" + this.f299183y.size());
        goto L39
    L22:
        be8.a r104 = this.f299163e.invoke();
        if (r104 != null) goto L25;
        r100.i("SlashPanelController", "[refreshSkillsIfNeeded] skip, reason=missingSkillAbility");
        goto L39
    L25:
        this.A = true;
        List<be8.b> r105 = r104.iH();
        HashSet r106 = new HashSet();
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r105.iterator();
    L27:
        if (r108.hasNext() == false) goto L33;
        Object r109 = r108.next();
        if (r106.add(((be8.b) r109).f18744a) == false) goto L27;
        r107.add(r109);
        goto L27
    L33:
        if ((!r107.isEmpty()) == false) goto L35;
        this.f299183y = r107;
    L35:
        FLogger.f375446a.i("SlashPanelController", "[refreshSkillsIfNeeded] start, cachedSkills=" + r107.size());
        this.f299184z = true;
        Job r110 = this.B;
        if (r110 == null) goto L38;
        Job.DefaultImpls.cancel$default(r110, null, 1, null);
    L38:
        long r111 = 1 + this.C;
        this.C = r111;
        this.B = BuildersKt.launch$default(this.f299160b, null, null, new SlashPanelController$refreshSkillsIfNeeded$1(r104, r111, this, AccountService.f365697a.getUserId(), null), 3, null);
    L39:
        String r112 = r210.f298767c;
        if (this.f299171m.invoke().booleanValue() == false) goto L42;
        h(r112);
    L47:
        FLogger.f375446a.i("SlashPanelController", "[show] end, active=" + this.f299181w + ", panelVisible=" + this.f299171m.invoke().booleanValue() + ", skills=" + this.f299183y.size() + ", loadingSkills=" + this.f299184z + ", showSkillManagementOnly=" + this.H);
        return;
    L42:
        String r113 = StringsKt.trim(r112).toString();
        if (r113.length() != 0) goto L45;
        boolean r114 = true;
    L46:
        g(r113, r114);
        r r115 = this.f299162d;
        final ?? r116 = new f(this);
        r115.getClass();
        Intrinsics.checkNotNullParameter(r116, "action");
        InputPanelListView r117 = r115.f299227b;
        r117.getClass();
        Intrinsics.checkNotNullParameter(r116, "action");
        r117.f299047g.postOnAnimation(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.s(r116));
        goto L47
    L45:
        r114 = false;
        goto L46
    L10:
        if (r101.NV() != true) goto L12;
        r102 = true;
    L15:
        r103 = false;
        goto L16
    }

    public final boolean a(be8.b r210, k1 r211) {
        boolean r100 = true;
        if (this.f299167i.invoke().booleanValue() == false) goto L18;
        be8.a r101 = this.f299163e.invoke();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (e() == true) goto L10;
        return false;
    L10:
        r101.WY(r210);
        if (r211 != null) goto L13;
    L16:
        this.f299168j.invoke();
        return true;
    L13:
        if (c() == false) goto L16;
        this.f299173o.invoke();
        goto L16
    L18:
        EditText r102 = this.f299159a.f298729a;
        if (r211 != null) goto L21;
    L28:
        Intrinsics.checkNotNullParameter(r210, "<this>");
        Set<Integer> r103 = com.larus.bmhome.chat.markdown.richtext.s.f307240a;
        String r110 = com.larus.bmhome.chat.markdown.richtext.s.a(r210.f18744a, Integer.valueOf(r210.getType()), r210.f18746c, r210.f18751h);
        if (r110 != null) goto L49;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("[selectSkill] invalid protocol metadata, type=");
        r105.append(r210.getType());
        r105.append(", hasExternalId=");
        String r106 = r210.f18746c;
        if (r106 != null) goto L33;
    L36:
        boolean r107 = true;
    L37:
        r105.append(!r107);
        r105.append(", hasPath=");
        String r108 = r210.f18751h;
        if (r108 != null) goto L40;
    L43:
        boolean r109 = true;
    L44:
        r105.append(!r109);
        r104.w("SlashPanelController", r105.toString());
        if (r211 == null) goto L47;
        d();
        this.f299173o.invoke();
    L47:
        return false;
    L40:
        if (StringsKt.isBlank(r108) == true) goto L43;
        r109 = false;
        goto L44
    L33:
        if (StringsKt.isBlank(r106) == true) goto L36;
        r107 = false;
        goto L37
    L49:
        if (e() == true) goto L51;
        return false;
    L51:
        ChatInputWithMentionDelegate r111 = this.f299159a;
        if (r211 == null) goto L54;
        int r112 = r211.f298765a;
    L55:
        if (r211 == null) goto L57;
        int r113 = r211.f298766b;
    L58:
        List<d0> r114 = CollectionsKt.listOf(new d0(r210.f18744a, r210.f18745b, InputReferenceType.SKILL, r110, null, null, null, null, null, null, 1008));
        if (r211 == null) goto L61;
        MultiTypePanelTrigger r115 = r211.f298768d;
    L63:
        if (r115 == MultiTypePanelTrigger.EXTERNAL_SKILL) goto L66;
        r100 = false;
    L66:
        boolean r116 = r111.j(r112, r113, r114, r100);
        if (r211 == null) goto L69;
        d();
        this.f299173o.invoke();
    L69:
        return r116;
    L61:
        r115 = null;
        goto L63
    L57:
        r113 = RangesKt.coerceAtLeast(r102.getSelectionEnd(), 0);
        goto L58
    L54:
        r112 = RangesKt.coerceAtLeast(r102.getSelectionStart(), 0);
        goto L55
    L21:
        if (r211.f298768d != MultiTypePanelTrigger.EXTERNAL_SKILL) goto L28;
        if (r102.getSelectionStart() == r211.f298766b) goto L25;
    L26:
        d();
        this.f299173o.invoke();
        return false;
    L25:
        if (r102.getSelectionEnd() == r211.f298766b) goto L28;
        goto L26
    }

    public final void f(be8.b r100, boolean r110) {
        Job r101 = this.D;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L9;
        return;
    L9:
        this.D = BuildersKt.launch$default(this.f299160b, null, null, new SlashPanelController$mutateRecentlyUsed$1(r110, r100, this, null), 3, null);
        return;
    L5:
        if (r101.isActive() != true) goto L7;
        r102 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(String r510, boolean r511) {
        if (this.f299181w == true) goto L5;
        return;
    L5:
        com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d r100 = null;
        if (this.f299180v == false) goto L8;
        s1 r110 = this.f299177s.update(this.f299183y, r510, new com.larus.bmhome.chat.component.bottom.core.inputtext.slash.a(this));
    L9:
        View r101 = this.E;
        if (r101 == null) goto L12;
        com.larus.bmhome.view.screenmenu.d.b(r101);
    L12:
        this.E = null;
        boolean r102 = v19.h.f552477a;
        boolean r111 = v19.h.b(this.f299176r);
        List r112 = CollectionsKt.createListBuilder();
        int r113 = 0;
        boolean r114 = true;
        if (r511 == false) goto L15;
    L16:
        List r103 = CollectionsKt.createListBuilder();
        if (r511 == true) goto L19;
    L27:
        int r104 = 0;
    L28:
        if (r511 == true) goto L30;
    L34:
        int r310 = r104;
    L35:
        if (r511 == true) goto L37;
    L62:
        r310 = r310;
        r103 = r103;
    L63:
        int r105 = r310;
    L65:
        if (this.H == false) goto L67;
        int r106 = r105 + 1;
        final b r107 = new b("skill_management", r105);
        r103.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(this.f299176r.getString(R.string.larus_input_skill_management), false, null, 0.0f, null, Integer.valueOf(R.drawable.larus_icon_slash_skills), null, null, null, null, b(r107), new k(this, r107), null, new l(this, r107), 10206));
    L68:
        List r108 = CollectionsKt.build(r103);
        if ((!r108.isEmpty()) == false) goto L71;
        r112.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.b(this.f299176r.getString(R.string.larus_input_slash_header_quickAccess)));
        r112.addAll(r108);
    L71:
        r113 = r106;
    L73:
        if (this.f299180v == true) goto L75;
    L159:
        List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o> r109 = CollectionsKt.build(r112);
        List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o> r115 = r109;
        boolean r116 = r115 instanceof Collection;
        if (r116 == true) goto L162;
    L164:
        Iterator<T> r117 = r115.iterator();
    L166:
        if (r117.hasNext() == false) goto L176;
        com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o r118 = (com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o) r117.next();
        if ((r118 instanceof com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d) == false) goto L170;
    L173:
        boolean r119 = true;
    L174:
        if (r119 == false) goto L166;
        boolean r120 = true;
    L177:
        if (r116 == true) goto L179;
    L181:
        Iterator<T> r121 = r115.iterator();
        int r122 = 0;
    L183:
        if (r121.hasNext() == false) goto L189;
        if ((((com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o) r121.next()) instanceof com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d) == false) goto L183;
        r122 = r122 + 1;
        if (r122 >= 0) goto L183;
        CollectionsKt.throwCountOverflow();
    L189:
        if (r116 == true) goto L191;
    L193:
        Iterator<T> r123 = r115.iterator();
        int r124 = 0;
    L195:
        if (r123.hasNext() == false) goto L201;
        if ((((com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o) r123.next()) instanceof com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.c) == false) goto L195;
        r124 = r124 + 1;
        if (r124 >= 0) goto L195;
        CollectionsKt.throwCountOverflow();
    L201:
        FLogger r125 = FLogger.f375446a;
        r125.i("SlashPanelController", "[renderSkillItems] queryLength=" + r510.length() + ", includeRootActions=" + r511 + ", active=" + this.f299181w + ", skills=" + this.f299183y.size() + ", loadingSkills=" + this.f299184z + ", items=" + r109.size() + ", rows=" + r122 + ", loadingItems=" + r124 + ", hasSearchResult=" + r120 + ", panelVisible=" + this.f299171m.invoke().booleanValue() + ", showSkillManagementOnly=" + this.H);
        if (r120 == true) goto L205;
        r125.i("SlashPanelController", "[renderSkillItems] hide panel, reason=noSearchResult");
        this.f299172n.invoke(Boolean.FALSE);
        return;
    L205:
        r r126 = this.f299162d;
        r126.getClass();
        Intrinsics.checkNotNullParameter(r109, "items");
        Intrinsics.checkNotNullParameter(r510, "highlightKeyword");
        if (r126.f299230e.f299036p == true) goto L239;
        InputPanelListView r127 = r126.f299227b;
        r127.getClass();
        Intrinsics.checkNotNullParameter(r109, "items");
        Intrinsics.checkNotNullParameter(r510, "highlightKeyword");
        if (r510.length() <= 0) goto L211;
        boolean r128 = true;
    L212:
        if (r128 == true) goto L214;
    L229:
        boolean r129 = false;
    L230:
        r127.f299046f = r109;
        RecyclerView r130 = r127.f299047g;
        r130.setPadding(r130.getPaddingLeft(), c7.b(Integer.valueOf(InputPanelListView.b(r109))), r127.f299047g.getPaddingRight(), c7.b(6));
        InputPanelListView.c r131 = r127.f299043c;
        r131.getClass();
        Intrinsics.checkNotNullParameter(r109, "newItems");
        Intrinsics.checkNotNullParameter(r510, "newHighlightKeyword");
        r131.f299048a = r109;
        r131.f299049b = r510;
        r131.notifyDataSetChanged();
        RecyclerView r132 = r127.f299047g;
        int r133 = c7.b(Integer.valueOf(InputPanelListView.b(r109) + 6));
        Intrinsics.checkNotNullParameter(r109, "items");
        r132.setLayoutParams(new FrameLayout.LayoutParams(-1, RangesKt.coerceAtMost(r133 + (r109.size() * r127.f299044d), r127.f299045e)));
        if (r129 == false) goto L238;
        r127.f299047g.stopScroll();
        RecyclerView.LayoutManager r134 = r127.f299047g.getLayoutManager();
        if ((r134 instanceof LinearLayoutManager) == false) goto L235;
        LinearLayoutManager r135 = (LinearLayoutManager) r134;
    L236:
        if (r135 == null) goto L238;
        r135.scrollToPositionWithOffset(0, 0);
        goto L238
    L235:
        r135 = null;
    L238:
        RecyclerView r136 = r126.f299227b.f299047g;
        FrameLayout.LayoutParams r137 = new FrameLayout.LayoutParams(-1, -1);
        r137.topMargin = r126.f299228c;
        r136.setLayoutParams(r137);
        r126.f299230e.g(false);
        r126.f299230e.i(true);
        goto L239
    L214:
        if ((!r109.isEmpty()) == false) goto L229;
        List<? extends com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o> r138 = r109;
        if ((r138 instanceof Collection) == true) goto L218;
    L220:
        Iterator<T> r139 = r138.iterator();
    L222:
        if (r139.hasNext() == false) goto L226;
        if (Intrinsics.areEqual((com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o) r139.next(), com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.c.f299087a) == true) goto L222;
        boolean r140 = false;
    L227:
        if (r140 == false) goto L229;
        r129 = true;
    L226:
        r140 = true;
        goto L227
    L218:
        if (r138.isEmpty() == false) goto L220;
    L211:
        r128 = false;
    L239:
        this.f299172n.invoke(Boolean.TRUE);
        FLogger.f375446a.i("SlashPanelController", "[renderSkillItems] panel visibility requested=true");
        if (k() == true) goto L242;
        return;
    L242:
        if (this.F == true) goto L274;
        this.F = true;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        JSONObject r141 = new JSONObject();
        r141.put("current_page", "chat");
        q3.b("slash_panel_show", r141);
        return;
    L274:
        return;
    L191:
        if (r115.isEmpty() == false) goto L193;
        r124 = 0;
        goto L201
    L179:
        if (r115.isEmpty() == false) goto L181;
        r122 = 0;
        goto L189
    L170:
        if ((r118 instanceof com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.c) == true) goto L173;
        r119 = false;
    L176:
        r120 = false;
        goto L177
    L162:
        if (r115.isEmpty() == false) goto L164;
    L75:
        if (this.H == true) goto L159;
        if (this.f299184z == true) goto L79;
    L80:
        if (r110 == null) goto L82;
        List<q1> r142 = r110.f299157b;
        if (r510.length() <= 0) goto L94;
        boolean r143 = true;
    L95:
        if (r143 == true) goto L97;
    L99:
        Iterator r144 = r142.iterator();
    L101:
        if (r144.hasNext() == false) goto L159;
        final q1 r145 = (q1) r144.next();
        if (r145.f299147c == false) goto L106;
        String r146 = "rec";
    L110:
        if (r510.length() != 0) goto L112;
        boolean r147 = true;
    L113:
        if (r147 == false) goto L115;
        r112.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.b(r145.f299145a));
    L115:
        Iterator<T> r148 = r145.f299146b.iterator();
        int r210 = r113;
    L117:
        if (r148.hasNext() == false) goto L158;
        final be8.b r149 = (be8.b) r148.next();
        String r150 = r149.f18745b;
        String r151 = r149.f18746c;
        if (r151 != null) goto L121;
    L126:
        r151 = r149.f18744a;
    L127:
        String r211 = r151;
        if (r510.length() <= 0) goto L130;
        boolean r212 = true;
    L131:
        int r152 = r210 + 1;
        final b r153 = new b(SlashMentionConfig.SLASH_CONTENT_SKILL, r150, r211, r146, r212, r210);
        String r154 = r149.f18745b;
        String r155 = r149.f18747d;
        Iterator r156 = r144;
        t1 r311 = (t1) ((LinkedHashMap) r110.f299158c).get(r149.f18744a);
        b2.b r157 = b2.f314255a;
        int r158 = b2.b(r149.f18744a, r111).f314261a;
        if (r510.length() != 0) goto L134;
        boolean r159 = true;
    L135:
        if (r159 == true) goto L137;
    L155:
        String r213 = r146;
    L156:
        m r410 = 0;
    L157:
        r112.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(r154, false, r155, 0.3f, r311, Integer.valueOf(R.drawable.larus_icon_slash_skills), null, Integer.valueOf(r158), null, null, b(r153), new n(this, r153), r410, new o(this, r153, r149), 1858));
        r210 = r152;
        r144 = r156;
        r146 = r213;
        r114 = true;
        goto L117
    L137:
        if (r145.f299147c == true) goto L155;
        if ((!StringsKt.isBlank(r149.f18744a)) == false) goto L151;
        r213 = r146;
        if (r149.getType() != SkillType.LOCAL.getValue()) goto L150;
        String r160 = r149.f18751h;
        if (r160 != null) goto L145;
    L148:
        boolean r161 = true;
    L149:
        if (r161 == false) goto L150;
    L152:
        boolean r162 = false;
    L153:
        if (r162 == false) goto L156;
        r410 = new m(this, r149, r145);
        goto L157
    L145:
        if (StringsKt.isBlank(r160) == true) goto L148;
        r161 = false;
    L150:
        r162 = true;
        goto L153
    L151:
        r213 = r146;
        goto L152
    L134:
        r159 = false;
        goto L135
    L130:
        r212 = false;
        goto L131
    L121:
        if ((StringsKt.isBlank(r151) ^ r114) == true) goto L124;
        r151 = null;
    L124:
        if (r151 == null) goto L126;
    L158:
        r113 = r210;
        goto L101
    L112:
        r147 = false;
        goto L113
    L106:
        if (r145.f299148d == false) goto L108;
        r146 = "freq";
        goto L110
    L108:
        r146 = "common";
        goto L110
    L97:
        if ((!r142.isEmpty()) == false) goto L99;
        r112.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.b(this.f299176r.getString(R.string.larus_input_slash_header_skills)));
        goto L99
    L94:
        r143 = false;
    L82:
        if (r510.length() != 0) goto L84;
        boolean r163 = true;
    L85:
        if (r163 == false) goto L87;
        int r164 = 5;
    L88:
        int r165 = 0;
    L89:
        if (r165 >= r164) goto L159;
        r112.add(com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.c.f299087a);
        r165 = r165 + 1;
        goto L89
    L87:
        r164 = 15;
        goto L88
    L84:
        r163 = false;
        goto L85
    L79:
        if (this.f299183y.isEmpty() == true) goto L82;
    L67:
        r106 = r105;
        goto L68
    L37:
        if (this.f299178t == false) goto L62;
        IContextWindowUsageService.f330273a.getClass();
        final IContextWindowUsageService r166 = IContextWindowUsageService.a.f330275b.getValue();
        if (r166 == null) goto L60;
        v29.c r167 = (v29.c) s1a.a.g(this.f299161c).getAbility(v29.c.class);
        if (r167 == null) goto L60;
        com.larus.contextwindow.api.a r168 = r167.O90();
        if ((r168 instanceof com.larus.contextwindow.api.a.b) == false) goto L47;
        com.larus.contextwindow.api.a.b r169 = (com.larus.contextwindow.api.a.b) r168;
    L48:
        if (r169 == null) goto L60;
        final ContextWindowEntryRequest r170 = r167.dO();
        if (r170 == null) goto L60;
        Drawable r214 = r166.a(this.f299176r, r169);
        if (r214 == null) goto L60;
        final b r171 = new b("quota_status", r310);
        String r172 = AppHost.f326268a.getApplication().getString(R.string.larus_input_slash_header_Usage);
        String r173 = r166.d(this.f299176r, r169);
        if (r173 != null) goto L59;
        r173 = "";
    L59:
        final com.larus.contextwindow.api.a.b r215 = r169;
        r100 = new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(r172, false, r173, 0.3f, null, null, r214, null, null, null, b(r171), new d(this, r171), null, new e(this, r171, r166, r170, r215), 10130);
        goto L60
    L47:
        r169 = null;
    L60:
        if (r100 == null) goto L63;
        r105 = r310 + 1;
        r103.add(r100);
        goto L65
    L30:
        if (this.f299179u == false) goto L34;
        if (this.f299169k.invoke().booleanValue() == false) goto L34;
        final b r174 = new b("select_project", r104);
        r103.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(this.f299176r.getString(R.string.larus_input_slash_chosseProject), false, null, 0.0f, null, Integer.valueOf(R.drawable.larus_dbx_ic_folder), null, null, null, null, b(r174), new i(this, r174), null, new j(this, r174), 10206));
        r310 = r104 + 1;
        goto L35
    L19:
        if (this.f299165g.invoke().booleanValue() == false) goto L27;
        k1 r175 = this.f299182x;
        if (r175 == null) goto L23;
        MultiTypePanelTrigger r176 = r175.f298768d;
    L25:
        if (r176 != MultiTypePanelTrigger.SLASH) goto L27;
        final b r177 = new b("create_ai_doc", r113);
        r103.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.panel.o.d(this.f299176r.getString(R.string.larus_LarkIM_Msg_CreateDoc_Button), false, this.f299176r.getString(R.string.larus_input_slash_create_doc), 0.3f, null, Integer.valueOf(R.drawable.larus_ic_slash_create_doc), null, null, null, null, b(r177), new g(this, r177), null, new h(this, r177), 10194));
        r104 = 1;
        goto L28
    L23:
        r176 = null;
        goto L25
    L15:
        if (this.H == false) goto L73;
    L8:
        r110 = null;
        goto L9
    }

    public SlashPanelController(ChatInputWithMentionDelegate r110, CoroutineScope r111, Fragment r112, r r210, Function0 r211, Function0 r212, Function0 r213, z0 r214, a1 r215, Function0 r216, Function0 r217, Set r218, b1 r219, c1 r310, d1 r311, Function1 r312, Function0 r313, SkillSearchIndex r314) {
        Intrinsics.checkNotNullParameter(r110, "inputDelegate");
        Intrinsics.checkNotNullParameter(r111, "coroutineScope");
        Intrinsics.checkNotNullParameter(r112, "hostFragment");
        Intrinsics.checkNotNullParameter(r210, "panelView");
        Intrinsics.checkNotNullParameter(r211, "skillAbilityProvider");
        Intrinsics.checkNotNullParameter(r212, "switchToTaskModeIfNeeded");
        Intrinsics.checkNotNullParameter(r213, "canCreateDocument");
        Intrinsics.checkNotNullParameter(r214, "onCreateDocument");
        Intrinsics.checkNotNullParameter(r215, "shouldSelectSkillInActionBar");
        Intrinsics.checkNotNullParameter(r216, "onSkillSelectedInActionBar");
        Intrinsics.checkNotNullParameter(r217, "shouldShowProjects");
        Intrinsics.checkNotNullParameter(r218, "enabledContents");
        Intrinsics.checkNotNullParameter(r219, "isPanelVisible");
        Intrinsics.checkNotNullParameter(r310, "onPanelVisibilityChanged");
        Intrinsics.checkNotNullParameter(r311, "onQueryFinished");
        Intrinsics.checkNotNullParameter(r312, "onConsumeQuery");
        Intrinsics.checkNotNullParameter(r313, "onOpenProjectPanel");
        Intrinsics.checkNotNullParameter(r314, "skillSearchIndex");
        this.f299159a = r110;
        this.f299160b = r111;
        this.f299161c = r112;
        this.f299162d = r210;
        this.f299163e = r211;
        this.f299164f = r212;
        this.f299165g = r213;
        this.f299166h = r214;
        this.f299167i = r215;
        this.f299168j = r216;
        this.f299169k = r217;
        this.f299170l = r218;
        this.f299171m = r219;
        this.f299172n = r310;
        this.f299173o = r311;
        this.f299174p = r312;
        this.f299175q = r313;
        Context r100 = r110.f298729a.getContext();
        this.f299176r = r100;
        this.f299177s = new SkillPanelSearch(r100, r111, r314);
        this.f299178t = r218.contains(SlashPanelContent.QUOTA);
        this.f299179u = r218.contains(SlashPanelContent.PROJECT);
        this.f299180v = r218.contains(SlashPanelContent.SKILL);
        this.f299183y = CollectionsKt.emptyList();
    }
}
