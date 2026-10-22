package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.app.Application;
import android.content.Context;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.chat.api.sidebar.ISideBarConversationIconService;
import com.larus.bmhome.chat.component.bottom.bottommenu.MentionFilePickerType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate;
import com.larus.bmhome.chat.component.bottom.core.inputtext.InputReferenceType;
import com.larus.bmhome.chat.component.bottom.core.inputtext.MentionPanelContent;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SkillPanelSearch;
import com.larus.bmhome.chat.component.bottom.core.inputtext.SkillSearchIndex;
import com.larus.bmhome.chat.component.bottom.core.inputtext.k1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.s1;
import com.larus.bmhome.chat.component.bottom.core.inputtext.t1;
import com.larus.bmhome.taskskill.b2;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.main.side_bar.view.SideBarConversationIconSessionImpl;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.larus.nova.R;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import tx9.y1;

/* JADX INFO: loaded from: classes25.dex */
public final class MentionPanelController {
    public static final /* synthetic */ int R = 0;
    public b A;
    public long B;
    public long C;
    public List<be8.b> D;
    public final SkillPanelSearch E;
    public s1 F;
    public final gc8.b G;
    public boolean H;
    public final boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f298776J;
    public final boolean K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    public final m0 P;
    public final MentionPanelController$backCallback$1 Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatInputWithMentionDelegate f298777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f298778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q0 f298779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qp8.e f298780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<MentionFilePickerType, Unit> f298781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<be8.a> f298782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Boolean> f298783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f298784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f298785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<MentionPanelContent> f298786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<Boolean, Unit> f298787k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f298788l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<k1, Boolean> f298789m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public k1 f298790n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<com.larus.bmhome.chat.component.bottom.core.inputtext.d0> f298791o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Job f298792p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Job f298793q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Job f298794r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Job f298795s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f298796t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f0 f298797u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f298798v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public SearchState f298799w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Page f298800x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public MentionSearchDomain f298801y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public MentionSearchDomain f298802z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelController$Page;", "", "<init>", "(Ljava/lang/String;I)V", "ROOT", "REMOTE_DOMAIN", "ATTACHMENT_DOMAIN", "SKILL_DOMAIN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Page extends Enum<Page> {
        public static final Page ATTACHMENT_DOMAIN = null;
        public static final Page REMOTE_DOMAIN = null;
        public static final Page ROOT = null;
        public static final Page SKILL_DOMAIN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Page[] f298803a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f298804b = null;

        public static EnumEntries<Page> getEntries() {
            return f298804b;
        }

        static {
            Page r100 = new Page("ROOT", 0);
            ROOT = r100;
            Page r101 = new Page("REMOTE_DOMAIN", 1);
            REMOTE_DOMAIN = r101;
            Page r102 = new Page("ATTACHMENT_DOMAIN", 2);
            ATTACHMENT_DOMAIN = r102;
            Page r103 = new Page("SKILL_DOMAIN", 3);
            SKILL_DOMAIN = r103;
            Page[] r104 = {r100, r101, r102, r103};
            f298803a = r104;
            f298804b = EnumEntriesKt.enumEntries(r104);
        }

        public static Page[] values() {
            return (Page[]) f298803a.clone();
        }

        public static Page valueOf(String r100) {
            return (Page) r27.a.a(Page.class, r100);
        }

        public Page(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelController$SearchState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "FULL_LOADING", "CONTACT_READY_WAITING_REFERENCES", "READY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SearchState extends Enum<SearchState> {
        public static final SearchState CONTACT_READY_WAITING_REFERENCES = null;
        public static final SearchState FULL_LOADING = null;
        public static final SearchState IDLE = null;
        public static final SearchState READY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SearchState[] f298805a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f298806b = null;

        public static EnumEntries<SearchState> getEntries() {
            return f298806b;
        }

        static {
            SearchState r100 = new SearchState("IDLE", 0);
            IDLE = r100;
            SearchState r101 = new SearchState("FULL_LOADING", 1);
            FULL_LOADING = r101;
            SearchState r102 = new SearchState("CONTACT_READY_WAITING_REFERENCES", 2);
            CONTACT_READY_WAITING_REFERENCES = r102;
            SearchState r103 = new SearchState("READY", 3);
            READY = r103;
            SearchState[] r104 = {r100, r101, r102, r103};
            f298805a = r104;
            f298806b = EnumEntriesKt.enumEntries(r104);
        }

        public static SearchState[] values() {
            return (SearchState[]) f298805a.clone();
        }

        public static SearchState valueOf(String r100) {
            return (SearchState) r27.a.a(SearchState.class, r100);
        }

        public SearchState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f298807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MentionSearchDomain f298808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f298809c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f298807a == r101.f298807a) goto L12;
            return false;
        L12:
            if (this.f298808b == r101.f298808b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f298809c, r101.f298809c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f298807a;
            return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f298808b.hashCode()) * 31) + this.f298809c.hashCode();
        }

        public final String toString() {
            return "PageRequestKey(generation=" + this.f298807a + ", domain=" + this.f298808b + ", cursor=" + this.f298809c + ')';
        }

        public b(long r100, MentionSearchDomain r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "domain");
            Intrinsics.checkNotNullParameter(r102, EffectConfiguration.KEY_CURSOR);
            this.f298807a = r100;
            this.f298808b = r101;
            this.f298809c = r102;
        }
    }

    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f298811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f298812b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f298811a, r101.f298811a) == true) goto L12;
            return false;
        L12:
            if (this.f298812b == r101.f298812b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f298811a.hashCode() * 31;
            if (this.f298812b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "SearchRootPreview(items=" + this.f298811a + ", showMore=" + this.f298812b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends T> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f298811a = r100;
            this.f298812b = r101;
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298813a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f298814b = null;

        static {
            int[] r100 = new int[MentionSearchDomain.values().length];
            r100[MentionSearchDomain.GROUP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[MentionSearchDomain.CONTACT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L39:
            r100[MentionSearchDomain.DRIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[MentionSearchDomain.CONVERSATION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L10:
            f298813a = r100;
            int[] r101 = new int[SearchState.values().length];
            r101[SearchState.READY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L35:
            r101[SearchState.CONTACT_READY_WAITING_REFERENCES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L25:
            r101[SearchState.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L33:
            r101[SearchState.FULL_LOADING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L15:
            f298814b = r101;
        }
    }

    static {
    }

    public static String k() {
        Application r100 = AppHost.f326268a.getApplication();
        if (AccountService.f365697a.isEnterpriseAccount() == false) goto L5;
        int r101 = R.string.larus_groupChats_navBar_header_feishuChat;
    L7:
        return r100.getString(r101);
    L5:
        r101 = R.string.larus_groupChats_navBar_header_convo;
        goto L7
    }

    public final void i() {
        Job r100 = this.f298793q;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.E.a();
        this.F = null;
        this.C++;
        Job r101 = this.f298794r;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.f298794r = null;
        gc8.b r102 = this.G;
        if (r102 == null) goto L11;
        r102.deactivate();
    L11:
        this.B++;
        Job r103 = this.f298792p;
        if (r103 == null) goto L14;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L14:
        q();
        this.f298790n = null;
        this.f298796t = null;
        this.f298798v = false;
        this.f298799w = SearchState.IDLE;
        this.H = false;
        m0 r104 = this.P;
        r104.f298940c = false;
        ExposeXTrackerExtKt.a(r104.f298938a, "mention_panel_option:");
    }

    public final void n() {
        this.E.a();
        this.F = null;
        gc8.b r100 = this.G;
        if (r100 == null) goto L5;
        r100.deactivate();
    L5:
        this.B++;
        this.C++;
        Job r101 = this.f298792p;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        Job r102 = this.f298794r;
        if (r102 == null) goto L11;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L11:
        this.f298794r = null;
        q();
        this.f298790n = null;
        this.f298796t = null;
        this.f298797u = new f0(null, null, null, null, 31);
        this.D = CollectionsKt.emptyList();
        this.H = false;
        this.f298798v = false;
        this.f298799w = SearchState.IDLE;
        m0 r103 = this.P;
        r103.f298940c = false;
        ExposeXTrackerExtKt.a(r103.f298938a, "mention_panel_option:");
        if (this.O == false) goto L15;
        MentionRecommendStore r104 = MentionRecommendStore.f298868a;
        qp8.e r105 = this.f298780d;
        boolean r106 = this.K;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, "config");
        MentionRecommendStore.f(r105, r106);
        return;
    }

    public final void q() {
        Job r100 = this.f298795s;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f298795s = null;
        this.f298802z = null;
        this.A = null;
        this.f298800x = Page.ROOT;
        this.f298801y = null;
        setEnabled(false);
        MentionPanelListView r101 = this.f298779c.f298954a;
        r101.f(true);
        r101.j(0);
        r101.f298823h = null;
    }

    public final f0 j(f0 r100) {
        List<c1> r101 = r100.f298913a;
        List<c1> r102 = null;
        if (this.M == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        List r103 = CollectionsKt.filterNotNull(r101);
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r104 = r100.f298914b;
        if (this.K == true) goto L12;
        r104 = null;
    L12:
        if (r104 != null) goto L14;
        r104 = CollectionsKt.emptyList();
    L14:
        List r105 = CollectionsKt.filterNotNull(r104);
        List<c1> r106 = r100.f298915c;
        if (this.L == true) goto L18;
        r106 = null;
    L18:
        if (r106 != null) goto L20;
        r106 = CollectionsKt.emptyList();
    L20:
        List r107 = CollectionsKt.filterNotNull(r106);
        List<c1> r108 = r100.f298916d;
        if (this.N == false) goto L23;
        r102 = r108;
    L23:
        if (r102 != null) goto L25;
        r102 = CollectionsKt.emptyList();
    L25:
        List r109 = CollectionsKt.filterNotNull(r102);
        Map<MentionSearchDomain, d1> r110 = r100.f298917e;
        LinkedHashMap r111 = new LinkedHashMap();
        Iterator<Map.Entry<MentionSearchDomain, d1>> r112 = r110.entrySet().iterator();
    L27:
        if (r112.hasNext() == false) goto L32;
        Map.Entry<MentionSearchDomain, d1> r113 = r112.next();
        if (l(r113.getKey()) == false) goto L27;
        r111.put(r113.getKey(), r113.getValue());
        goto L27
    L32:
        return f0.a(r103, r105, r107, r109, r111);
    }

    public final boolean l(MentionSearchDomain r100) {
        int r101 = d.f298813a[r100.ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 != 4) goto L12;
        return this.N;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return this.M;
    L19:
        return this.K;
    L16:
        return this.L;
    }

    public final void m(MentionSearchDomain r110) {
        if (l(r110) == true) goto L5;
        return;
    L5:
        Page r100 = this.f298800x;
        Page r101 = Page.REMOTE_DOMAIN;
        if (r100 == r101) goto L8;
        return;
    L8:
        if (this.f298801y == r110) goto L10;
        return;
    L10:
        if (this.f298802z != null) goto L53;
        d1 r102 = this.f298797u.f298917e.get(r110);
        if (r102 == null) goto L47;
        k1 r103 = null;
        if (r102.a() == true) goto L18;
        r102 = null;
    L18:
        if (r102 == null) goto L48;
        String r104 = r102.f298909b;
        if (r104 == null) goto L49;
        String r105 = this.f298796t;
        if (r105 == null) goto L50;
        boolean r106 = true;
        if (r105.length() <= 0) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == false) goto L29;
        String r108 = r105;
    L30:
        if (r108 == null) goto L54;
        long r111 = this.B;
        b r109 = new b(r111, r110, r104);
        k1 r112 = h(r108, r111);
        if (r112 != null) goto L35;
        return;
    L35:
        if (this.f298800x == r101) goto L37;
    L39:
        r106 = false;
    L40:
        if (r106 == false) goto L42;
        r103 = r112;
    L42:
        if (r103 == null) goto L52;
        this.f298802z = r110;
        p(r103);
        this.f298795s = BuildersKt.launch$default(this.f298778b, null, null, new MentionPanelController$loadMore$1(this, r108, r111, r109, r110, r104, null), 3, null);
        return;
    L52:
        return;
    L37:
        if (this.f298801y != r110) goto L39;
    L54:
        return;
    L29:
        r108 = null;
        goto L30
    L26:
        r107 = false;
        goto L27
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    }

    public final void o(MentionSearchDomain r110) {
        if (this.f298800x == Page.ROOT) goto L5;
        return;
    L5:
        if (l(r110) == false) goto L59;
        k1 r100 = this.f298790n;
        if (r100 == null) goto L57;
        boolean r101 = false;
        if (StringsKt.isBlank(r100.f298767c) == true) goto L12;
        SearchState r102 = this.f298799w;
        int r103 = d.f298814b[r102.ordinal()];
        if (r103 == 1) goto L30;
        if (r103 == 2) goto L27;
        if (r103 == 3) goto L29;
        if (r103 == 4) goto L29;
        throw new NoWhenBranchMatchedException();
    L29:
        boolean r104 = false;
    L31:
        if (r104 == true) goto L34;
        r100 = null;
    L34:
        if (r100 == null) goto L58;
        q0 r105 = this.f298779c;
        int r106 = d.f298813a[r110.ordinal()];
        if (r106 == 1) goto L45;
        if (r106 == 2) goto L44;
        if (r106 == 3) goto L43;
        if (r106 != 4) goto L42;
        MentionPanelSection r107 = MentionPanelSection.CONVERSATION;
    L46:
        MentionPanelListView.f r108 = r105.a(r107);
        this.f298779c.b();
        this.f298800x = Page.REMOTE_DOMAIN;
        this.f298801y = r110;
        setEnabled(true);
        d1 r109 = this.f298797u.f298917e.get(r110);
        if (r109 != null) goto L49;
    L51:
        if (r101 == false) goto L53;
        m(r110);
    L54:
        this.f298779c.c(r108);
        return;
    L53:
        p(r100);
        goto L54
    L49:
        if (r109.a() != true) goto L51;
        r101 = true;
        goto L51
    L42:
        throw new NoWhenBranchMatchedException();
    L43:
        r107 = MentionPanelSection.DRIVE;
        goto L46
    L44:
        r107 = MentionPanelSection.CONTACT;
        goto L46
    L45:
        r107 = MentionPanelSection.GROUP;
        goto L46
    L58:
        return;
    L27:
        if (r110 != MentionSearchDomain.CONTACT) goto L29;
    L30:
        r104 = true;
        goto L31
    L12:
        if (this.f298798v == true) goto L29;
        if (r110 == MentionSearchDomain.CONTACT) goto L30;
        if (r110 != MentionSearchDomain.GROUP) goto L29;
    L57:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v139, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v144, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v147, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v149, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v150, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v174, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v73, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r71v0, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController] */
    public final void p(k1 r710) {
        gc8.b r100 = this.G;
        if (r100 == null) goto L16;
        List<c1> r101 = this.f298797u.f298916d;
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L15;
        c1 r104 = (c1) r103.next();
        if (r104 == null) goto L12;
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r105 = r104.f298904a;
        if (r105 == null) goto L12;
        String r106 = r105.f298715a;
    L13:
        if (r106 == null) goto L6;
        r102.add(r106);
    L12:
        r106 = null;
        goto L13
    L15:
        r100.a(r102);
        Unit r107 = Unit.INSTANCE;
    L16:
        String r110 = StringsKt.trim(r710.f298767c).toString();
        if (r110.length() != 0) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L22;
        this.E.a();
        s1 r109 = null;
    L29:
        this.F = r109;
        MentionSearchDomain r111 = this.f298801y;
        if (r111 != null) goto L32;
    L39:
        MentionSearchDomain r112 = null;
    L41:
        if (this.f298800x != Page.ATTACHMENT_DOMAIN) goto L43;
        boolean r113 = true;
    L45:
        if (r110.length() <= 0) goto L47;
        boolean r114 = true;
    L48:
        if (r114 == true) goto L50;
    L52:
        boolean r115 = false;
    L53:
        if (r112 != null) goto L58;
        if (r113 == true) goto L58;
        if (r115 == true) goto L58;
        boolean r116 = false;
    L60:
        if (r112 == null) goto L77;
        List r117 = CollectionsKt.createListBuilder();
        if (l(r112) == false) goto L76;
        int r118 = d.f298813a[r112.ordinal()];
        if (r118 != 1) goto L67;
        f(this, r117, k(), this.f298797u.f298915c, MentionPanelSection.GROUP, null, true, 8);
        goto L76
    L67:
        if (r118 == 2) goto L74;
        if (r118 == 3) goto L73;
        if (r118 != 4) goto L72;
        f(this, r117, AppHost.f326268a.getApplication().getString(R.string.larus_LarkIM_Feed_Chats_Title), this.f298797u.f298916d, MentionPanelSection.CONVERSATION, null, true, 8);
        goto L76
    L72:
        throw new NoWhenBranchMatchedException();
    L73:
        f(this, r117, AppHost.f326268a.getApplication().getString(R.string.larus_input_mention_drive), this.f298797u.f298913a, MentionPanelSection.DRIVE, null, true, 8);
        goto L76
    L74:
        d(this, r117, this.f298797u.f298914b, MentionPanelSection.CONTACT, null, true, 4);
    L76:
        ?? r119 = CollectionsKt.build(r117);
    L214:
        final m0 r120 = this.P;
        if (r110.length() <= 0) goto L217;
        boolean r121 = true;
    L218:
        r120.getClass();
        Intrinsics.checkNotNullParameter(r119, "items");
        Iterable r122 = (Iterable) r119;
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));
        Iterator r124 = r122.iterator();
        final m0 r125 = r120;
        int r210 = 1;
    L220:
        if (r124.hasNext() == false) goto L250;
        final y r126 = (y) r124.next();
        boolean r127 = r126 instanceof y.d;
        if (r127 == false) goto L225;
        h0 r128 = ((y.d) r126).f298979b;
    L227:
        String r129 = r128.f298920a;
        String r130 = r128.f298921b;
        String r131 = r128.f298922c;
        if (Intrinsics.areEqual(r129, "contact") == false) goto L230;
    L233:
        boolean r132 = true;
    L234:
        if (r132 == true) goto L236;
        String r133 = r131;
    L237:
        if (r133 != null) goto L239;
        String r211 = "";
    L240:
        int r134 = r210 + 1;
        final m0.b r135 = new m0.b(r129, r130, r211, r121, r210);
        if (r127 == false) goto L243;
        y.d r136 = (y.d) r126;
        r125.getClass();
        String r310 = m0.a(r135);
        boolean r311 = r121;
        Function0 r137 = new i0(r125, r135);
        Function0 r138 = new j0(r125, r135, r126);
        String r139 = r136.f298978a;
        h0 r140 = r136.f298979b;
        g0 r141 = r136.f298980c;
        List<String> r142 = r136.f298981d;
        String r143 = r136.f298982e;
        int r312 = r134;
        t1 r144 = r136.f298983f;
        Integer r145 = r136.f298984g;
        b2.b r146 = r136.f298985h;
        String r147 = r136.f298986i;
        String r148 = r136.f298987j;
        com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r149 = r136.f298988k;
        com.larus.bmhome.chat.referenceicon.b r150 = r136.f298989l;
        String r151 = r136.f298990m;
        String r152 = r136.f298991n;
        String r153 = r136.f298992o;
        Intrinsics.checkNotNullParameter(r139, "title");
        Intrinsics.checkNotNullParameter(r140, "trace");
        Intrinsics.checkNotNullParameter(r143, "secondaryText");
        Intrinsics.checkNotNullParameter(r138, "action");
        r126 = new y.d(r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r310, r137, r138);
    L246:
        r125 = r120;
        r210 = r312;
    L248:
        r123.add(r126);
        r124 = r124;
        r121 = r311;
        goto L220
    L243:
        r311 = r121;
        r312 = r134;
        if ((r126 instanceof y.c) == false) goto L246;
        String r154 = m0.a(r135);
        Function0 r155 = new k0(r120, r135);
        Function0 r156 = new l0(r120, r135, r126);
        h0 r157 = ((y.c) r126).f298974a;
        Intrinsics.checkNotNullParameter(r157, "trace");
        Intrinsics.checkNotNullParameter(r156, "action");
        r126 = new y.c(r157, r154, r155, r156);
        goto L246
    L239:
        r211 = r133;
        goto L240
    L236:
        r133 = null;
        goto L237
    L230:
        if (Intrinsics.areEqual(r128.f298920a, "group_chat") == true) goto L233;
        r132 = false;
        goto L234
    L225:
        if ((r126 instanceof y.c) == false) goto L247;
        r128 = ((y.c) r126).f298974a;
        goto L227
    L247:
        r311 = r121;
        goto L248
    L250:
        if (r110.length() <= 0) goto L252;
        boolean r158 = true;
    L253:
        if (r158 == false) goto L258;
        if (r116 == true) goto L258;
        if (this.f298799w == SearchState.READY) goto L258;
        boolean r159 = true;
    L260:
        if (r110.length() <= 0) goto L262;
        boolean r160 = true;
    L263:
        if (r160 == false) goto L268;
        if (r116 == true) goto L268;
        if (this.f298799w != SearchState.CONTACT_READY_WAITING_REFERENCES) goto L268;
        boolean r161 = true;
    L270:
        if (r110.length() <= 0) goto L272;
        boolean r162 = true;
    L273:
        if (r162 == false) goto L278;
        if (r116 == true) goto L278;
        if (this.f298799w != SearchState.READY) goto L278;
        boolean r163 = true;
    L279:
        if (r112 != null) goto L281;
    L283:
        boolean r164 = false;
    L285:
        if (r123.isEmpty() == true) goto L301;
        Iterator r165 = r123.iterator();
    L289:
        if (r165.hasNext() == false) goto L301;
        y r166 = (y) r165.next();
        if ((r166 instanceof y.d) == false) goto L293;
    L298:
        boolean r167 = true;
    L299:
        if (r167 == false) goto L289;
        boolean r168 = true;
    L302:
        if (r159 == true) goto L307;
        if (r164 == true) goto L307;
        if (r168 == true) goto L307;
        this.f298787k.invoke(Boolean.FALSE);
        return;
    L307:
        q0 r169 = this.f298779c;
        if (r112 != null) goto L310;
    L333:
        Function0<Unit> r170 = null;
    L334:
        if (r161 == true) goto L340;
        if (r112 != null) goto L337;
    L339:
        boolean r171 = false;
    L341:
        if (r113 == true) goto L356;
        if (r163 == true) goto L356;
        if (r115 == true) goto L356;
        if (r112 != null) goto L346;
    L355:
        boolean r172 = false;
    L357:
        if (r113 == true) goto L362;
        if (r163 == true) goto L362;
        if (r115 == true) goto L362;
        boolean r173 = false;
    L363:
        r169.getClass();
        Intrinsics.checkNotNullParameter(r123, "items");
        Intrinsics.checkNotNullParameter(r110, "highlightKeyword");
        if (r169.f298957d.f299036p == true) goto L440;
        Object r174 = CollectionsKt.firstOrNull(r123);
        if ((r174 instanceof y.a) == false) goto L369;
        y.a r175 = (y.a) r174;
    L370:
        if (r175 == null) goto L375;
        String r176 = r175.f298972a;
        if (r176 == null) goto L375;
        if (r116 == false) goto L375;
    L376:
        r169.f298956c.setText(r176);
        TextView r177 = r169.f298956c;
        if (r176 == null) goto L379;
        boolean r178 = true;
    L380:
        if (r178 == false) goto L382;
        int r179 = 0;
    L383:
        r177.setVisibility(r179);
        MentionPanelListView r180 = r169.f298954a;
        if (r176 == null) goto L386;
        boolean r181 = true;
    L387:
        r180.getClass();
        Intrinsics.checkNotNullParameter(r123, "items");
        Intrinsics.checkNotNullParameter(r110, "highlightKeyword");
        if (r110.length() <= 0) goto L390;
        boolean r182 = true;
    L391:
        if (r182 == true) goto L393;
    L406:
        boolean r183 = false;
    L407:
        r180.f(r183);
        r180.f298821f = r170;
        r180.f298825j = r123;
        r180.f298827l = r110;
        r180.f298828m = r171;
        r180.f298829n = !r181;
        if (r172 == false) goto L417;
        Integer r184 = r180.f298823h;
        if (r184 != null) goto L412;
    L414:
        LinearLayoutManager r185 = null;
        boolean r186 = false;
    L415:
        if (r186 == false) goto L418;
        boolean r187 = true;
    L419:
        List<y> r188 = r180.e();
        r180.f298826k = r188;
        r180.c(r188);
        r180.f298819d.y2(r188, r110, r180.f298829n);
        r180.f298836u.invalidateItemDecorations();
        Integer r189 = r180.f298823h;
        if (r189 == null) goto L422;
        int r190 = r189.intValue();
    L423:
        r180.f298824i = r190;
        Function1<Boolean, Unit> r191 = r180.f298817b;
        if (r173 == false) goto L427;
        if (r187 == false) goto L427;
        boolean r192 = true;
    L428:
        r191.invoke(Boolean.valueOf(r192));
        if (r183 == false) goto L436;
        r180.f298836u.stopScroll();
        RecyclerView.LayoutManager r193 = r180.f298836u.getLayoutManager();
        if ((r193 instanceof LinearLayoutManager) == false) goto L433;
        LinearLayoutManager r194 = (LinearLayoutManager) r193;
    L434:
        if (r194 == null) goto L439;
        r194.scrollToPositionWithOffset(0, 0);
    L439:
        r180.f298836u.addOnLayoutChangeListener(new e0(r180));
        r169.f298957d.i(true);
        goto L440
    L433:
        r194 = r185;
        goto L434
    L436:
        MentionPanelListView.f r195 = r180.f298831p;
        if (r195 == null) goto L439;
        r180.d(r195);
    L427:
        r192 = false;
        goto L428
    L422:
        r190 = RangesKt.coerceAtMost(r180.g(r188), r180.f298822g);
    L418:
        r187 = false;
        goto L419
    L412:
        if (r180.g(r123) >= r184.intValue()) goto L414;
        r185 = null;
        r180.f298823h = null;
        r186 = true;
        goto L415
    L417:
        r185 = null;
        goto L418
    L393:
        if ((!r123.isEmpty()) == false) goto L406;
        if (r123.isEmpty() == true) goto L403;
        Iterator r196 = r123.iterator();
    L399:
        if (r196.hasNext() == false) goto L403;
        if (Intrinsics.areEqual((y) r196.next(), y.b.f298973a) == true) goto L399;
        boolean r197 = false;
    L404:
        if (r197 == false) goto L406;
        r183 = true;
    L403:
        r197 = true;
        goto L404
    L390:
        r182 = false;
        goto L391
    L386:
        r181 = false;
        goto L387
    L382:
        r179 = 8;
        goto L383
    L379:
        r178 = false;
    L375:
        r176 = null;
        goto L376
    L369:
        r175 = null;
    L440:
        this.f298787k.invoke(Boolean.TRUE);
        m0 r198 = this.P;
        if (r198.f298939b.invoke().booleanValue() == true) goto L443;
        return;
    L443:
        if (r198.f298940c == true) goto L465;
        r198.f298940c = true;
        Intrinsics.checkNotNullParameter("chat", "currentPage");
        Intrinsics.checkNotNullParameter("", "skillId");
        JSONObject r199 = new JSONObject();
        r199.put("current_page", "chat");
        r199.put("skill_id", "");
        y1.b("mention_panel_show", r199);
        return;
    L465:
        return;
    L362:
        r173 = true;
        goto L363
    L346:
        if (this.f298802z != null) goto L355;
        d1 r200 = this.f298797u.f298917e.get(r112);
        if (r200 != null) goto L350;
    L352:
        boolean r201 = false;
    L353:
        if (r201 == false) goto L355;
    L350:
        if (r200.f298908a == true) goto L352;
        r201 = true;
    L356:
        r172 = true;
        goto L357
    L337:
        if (this.f298802z != r112) goto L339;
    L340:
        r171 = true;
        goto L341
    L310:
        if (this.f298802z != null) goto L327;
        d1 r202 = this.f298797u.f298917e.get(r112);
        if (r202 != null) goto L314;
    L316:
        boolean r203 = false;
    L317:
        if (r203 == false) goto L327;
        d1 r204 = this.f298797u.f298917e.get(r112);
        if (r204 == null) goto L324;
        String r205 = r204.f298909b;
        if (r205 == null) goto L324;
        boolean r206 = Intrinsics.areEqual(this.A, new b(this.B, r112, r205));
    L325:
        if (r206 == true) goto L327;
        boolean r207 = true;
    L328:
        if (r207 == false) goto L330;
        final MentionSearchDomain r208 = r112;
    L331:
        if (r208 == null) goto L333;
        r170 = new u(this, r208);
        goto L334
    L330:
        r208 = null;
    L324:
        r206 = false;
        goto L325
    L314:
        if (r202.a() != true) goto L316;
        r203 = true;
    L327:
        r207 = false;
        goto L328
    L293:
        if ((r166 instanceof y.c) == true) goto L298;
        if ((r166 instanceof y.b) == true) goto L298;
        r167 = false;
    L301:
        r168 = false;
        goto L302
    L281:
        if (this.f298802z != r112) goto L283;
        r164 = true;
    L278:
        r163 = false;
        goto L279
    L272:
        r162 = false;
    L268:
        r161 = false;
        goto L270
    L262:
        r160 = false;
    L258:
        r159 = false;
        goto L260
    L252:
        r158 = false;
        goto L253
    L217:
        r121 = false;
        goto L218
    L77:
        if (r113 == false) goto L79;
        List r209 = CollectionsKt.createListBuilder();
        b(r209, r110, true);
        r119 = CollectionsKt.build(r209);
        goto L214
    L79:
        if (r115 == false) goto L82;
        List r212 = CollectionsKt.createListBuilder();
        g(r212, r110, true);
        r119 = CollectionsKt.build(r212);
        goto L214
    L82:
        if (r110.length() <= 0) goto L84;
        boolean r213 = true;
    L85:
        if (r213 == false) goto L92;
        if (this.f298799w != SearchState.FULL_LOADING) goto L92;
        r119 = new ArrayList(15);
        int r214 = 0;
    L89:
        if (r214 >= 15) goto L214;
        r119.add(y.b.f298973a);
        r214 = r214 + 1;
    L92:
        if (r110.length() <= 0) goto L94;
        boolean r215 = true;
    L95:
        if (r215 == true) goto L97;
    L109:
        List r216 = CollectionsKt.createListBuilder();
        if (r110.length() != 0) goto L112;
        boolean r217 = true;
    L113:
        if (r217 == true) goto L115;
    L120:
        b(r216, r110, false);
        if (r110.length() <= 0) goto L123;
        boolean r218 = true;
    L124:
        if (r218 == false) goto L176;
        f0 r219 = this.f298797u;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r220 = r219.f298914b;
        Map<MentionSearchDomain, d1> r221 = r219.f298917e;
        MentionSearchDomain r222 = MentionSearchDomain.CONTACT;
        d1 r223 = r221.get(r222);
        if (r223 != null) goto L128;
    L130:
        boolean r224 = false;
    L131:
        c r225 = u(r220, 3, r224, false);
        List r226 = r225.f298811a;
        MentionPanelSection r227 = MentionPanelSection.CONTACT;
        if (r225.f298812b == false) goto L134;
        MentionSearchDomain r228 = r222;
    L135:
        List r229 = r216;
        d(this, r216, r226, r227, r228, false, 8);
        if (this.L == false) goto L149;
        f0 r230 = this.f298797u;
        List<c1> r231 = r230.f298915c;
        Map<MentionSearchDomain, d1> r232 = r230.f298917e;
        MentionSearchDomain r233 = MentionSearchDomain.GROUP;
        d1 r234 = r232.get(r233);
        if (r234 != null) goto L140;
    L142:
        boolean r235 = false;
    L143:
        c r236 = u(r231, 3, r235, false);
        String r237 = k();
        List r238 = r236.f298811a;
        MentionPanelSection r239 = MentionPanelSection.GROUP;
        if (r236.f298812b == false) goto L146;
        MentionSearchDomain r240 = r233;
    L147:
        f(this, r229, r237, r238, r239, r240, false, 16);
        goto L149
    L146:
        r240 = null;
        goto L147
    L140:
        if (r234.f298908a != true) goto L142;
        r235 = true;
    L149:
        g(r229, r110, false);
        if (this.M == false) goto L162;
        f0 r241 = this.f298797u;
        List<c1> r242 = r241.f298913a;
        Map<MentionSearchDomain, d1> r243 = r241.f298917e;
        MentionSearchDomain r244 = MentionSearchDomain.DRIVE;
        d1 r245 = r243.get(r244);
        if (r245 != null) goto L154;
    L156:
        boolean r246 = false;
    L157:
        c r247 = v(this, r242, r246, 4);
        String r248 = AppHost.f326268a.getApplication().getString(R.string.larus_input_mention_drive);
        List r249 = r247.f298811a;
        MentionPanelSection r250 = MentionPanelSection.DRIVE;
        if (r247.f298812b == false) goto L160;
        MentionSearchDomain r251 = r244;
    L161:
        int r1100 = 4;
        f(this, r229, r248, r249, r250, r251, false, 16);
    L164:
        if (this.N == false) goto L213;
        f0 r252 = this.f298797u;
        List<c1> r253 = r252.f298916d;
        Map<MentionSearchDomain, d1> r254 = r252.f298917e;
        MentionSearchDomain r255 = MentionSearchDomain.CONVERSATION;
        d1 r256 = r254.get(r255);
        if (r256 != null) goto L168;
    L170:
        boolean r257 = false;
    L171:
        c r258 = v(this, r253, r257, r1100);
        String r259 = AppHost.f326268a.getApplication().getString(R.string.larus_LarkIM_Feed_Chats_Title);
        List r260 = r258.f298811a;
        MentionPanelSection r261 = MentionPanelSection.CONVERSATION;
        if (r258.f298812b == false) goto L174;
        MentionSearchDomain r262 = r255;
    L175:
        f(this, r229, r259, r260, r261, r262, false, 16);
        goto L213
    L174:
        r262 = null;
        goto L175
    L168:
        if (r256.f298908a != true) goto L170;
        r257 = true;
    L213:
        r119 = CollectionsKt.build(r229);
        goto L214
    L160:
        r251 = null;
        goto L161
    L154:
        if (r245.f298908a != true) goto L156;
        r246 = true;
        goto L157
    L162:
        r1100 = 4;
        goto L164
    L134:
        r228 = null;
        goto L135
    L128:
        if (r223.f298908a != true) goto L130;
        r224 = true;
        goto L131
    L176:
        r229 = r216;
        if (this.f298798v == true) goto L179;
        List r263 = CollectionsKt.filterNotNull(this.f298797u.f298914b);
        List r264 = CollectionsKt.take(r263, 5);
        MentionPanelSection r265 = MentionPanelSection.CONTACT;
        MentionSearchDomain r266 = MentionSearchDomain.CONTACT;
        if (r263.size() <= 5) goto L193;
        boolean r267 = true;
    L194:
        if (r267 == false) goto L196;
        MentionSearchDomain r268 = r266;
    L197:
        d(this, r229, r264, r265, r268, false, 8);
        if (this.L == false) goto L208;
        List r269 = CollectionsKt.filterNotNull(this.f298797u.f298915c);
        String r270 = k();
        List r271 = CollectionsKt.take(r269, 5);
        MentionPanelSection r272 = MentionPanelSection.GROUP;
        MentionSearchDomain r273 = MentionSearchDomain.GROUP;
        if (r269.size() <= 5) goto L202;
        boolean r274 = true;
    L203:
        if (r274 == false) goto L205;
        MentionSearchDomain r275 = r273;
    L206:
        f(this, r229, r270, r271, r272, r275, false, 16);
        goto L208
    L205:
        r275 = null;
        goto L206
    L202:
        r274 = false;
    L208:
        if (this.M == false) goto L211;
        f(this, r229, AppHost.f326268a.getApplication().getString(R.string.larus_input_mention_drive), this.f298797u.f298913a, null, null, false, 28);
    L211:
        if (this.N == false) goto L213;
        f(this, r229, AppHost.f326268a.getApplication().getString(R.string.larus_LarkIM_Feed_Chats_Title), this.f298797u.f298916d, null, null, false, 28);
        goto L213
    L196:
        r268 = null;
        goto L197
    L193:
        r267 = false;
        goto L194
    L179:
        if (this.K == false) goto L182;
        e(r229, AppHost.f326268a.getApplication().getString(R.string.larus_input_mention_contacts));
    L182:
        if (this.L == false) goto L185;
        e(r229, k());
    L185:
        if (this.M == false) goto L188;
        e(r229, AppHost.f326268a.getApplication().getString(R.string.larus_input_mention_drive));
    L188:
        if (this.N == false) goto L213;
        e(r229, AppHost.f326268a.getApplication().getString(R.string.larus_LarkIM_Feed_Chats_Title));
        goto L213
    L123:
        r218 = false;
        goto L124
    L115:
        if (this.I == false) goto L120;
        AppHost.Companion r276 = AppHost.f326268a;
        String r277 = r276.getApplication().getString(R.string.larus_camera);
        String r278 = r276.getApplication().getString(R.string.larus_photos);
        String r279 = r276.getApplication().getString(R.string.larus_accessibility_icon_files);
        r216.add(new y.a(r276.getApplication().getString(R.string.larus_input_slash_header_Add)));
        r216.add(new y.d(r277, new h0("add", "category", r277), null, null, null, null, Integer.valueOf(R.drawable.larus_icon_chat_action_camera), null, null, null, null, null, null, null, null, new p(this), 131004));
        r216.add(new y.d(r278, new h0("add", "category", r278), null, null, null, null, Integer.valueOf(R.drawable.larus_icon_chat_action_album), null, null, null, null, null, null, null, null, new q(this), 131004));
        r216.add(new y.d(r279, new h0("add", "category", r279), null, null, null, null, Integer.valueOf(R.drawable.larus_icon_chat_action_file_01), null, null, null, null, null, null, null, null, new r(this), 131004));
        if (this.f298785i == false) goto L119;
        String r280 = r276.getApplication().getString(R.string.larus_input_slash_header_skills);
        r216.add(new y.d(r280, new h0("add", "category", r280), null, null, null, null, Integer.valueOf(R.drawable.larus_icon_slash_skills), null, null, null, null, null, null, null, null, new s(this), 131004));
    L119:
        String r281 = r276.getApplication().getString(R.string.larus_input_connector);
        r216.add(new y.d(r281, new h0("add", "category", r281), null, null, null, null, Integer.valueOf(R.drawable.larus_icon_slash_connector), null, null, null, null, null, null, null, null, new t(this), 131004));
        goto L120
    L112:
        r217 = false;
        goto L113
    L97:
        if (this.f298799w != SearchState.CONTACT_READY_WAITING_REFERENCES) goto L109;
        List r282 = CollectionsKt.createListBuilder();
        f0 r283 = this.f298797u;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r284 = r283.f298914b;
        Map<MentionSearchDomain, d1> r285 = r283.f298917e;
        MentionSearchDomain r286 = MentionSearchDomain.CONTACT;
        d1 r287 = r285.get(r286);
        if (r287 != null) goto L101;
    L103:
        boolean r288 = false;
    L104:
        c r289 = u(r284, 3, r288, false);
        List r290 = r289.f298811a;
        MentionPanelSection r291 = MentionPanelSection.CONTACT;
        if (r289.f298812b == false) goto L107;
        MentionSearchDomain r292 = r286;
    L108:
        c(r282, r290, r291, r292, true);
        r119 = CollectionsKt.build(r282);
        goto L214
    L107:
        r292 = null;
        goto L108
    L101:
        if (r287.f298908a != true) goto L103;
        r288 = true;
        goto L104
    L94:
        r215 = false;
        goto L95
    L84:
        r213 = false;
    L58:
        r116 = true;
        goto L60
    L50:
        if (this.f298800x != Page.SKILL_DOMAIN) goto L52;
        r115 = true;
        goto L53
    L47:
        r114 = false;
        goto L48
    L43:
        r113 = false;
        goto L45
    L32:
        if (this.f298800x == Page.REMOTE_DOMAIN) goto L34;
    L36:
        boolean r293 = false;
    L37:
        if (r293 == false) goto L39;
        r112 = r111;
        goto L41
    L34:
        if (l(r111) == false) goto L36;
        r293 = true;
        goto L37
    L22:
        Page r294 = this.f298800x;
        if (r294 != Page.ROOT) goto L25;
    L28:
        r109 = this.E.update(this.D, r110, new k(this));
        goto L29
    L25:
        if (r294 == Page.SKILL_DOMAIN) goto L28;
        r109 = this.F;
        goto L29
    L19:
        r108 = false;
        goto L20
    }

    public final void r(MentionFilePickerType r100) {
        k1 r101 = this.f298790n;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f298789m.invoke(r101).booleanValue() == true) goto L8;
        return;
    L8:
        i();
        this.f298788l.invoke();
        this.f298781e.invoke(r100);
    }

    public final void s(com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r100) {
        k1 r101 = this.f298790n;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100.getType() != InputReferenceType.GROUP) goto L13;
        if (this.L == false) goto L11;
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.f() == true) goto L13;
        return;
    L11:
        return;
    L13:
        if (r100.getType() != InputReferenceType.SKILL) goto L19;
        if (this.f298783g.invoke().booleanValue() == true) goto L19;
        Context r102 = this.f298777a.f298729a.getContext();
        t19.s.j(t19.s.f544207a, r102, r102.getString(R.string.larus_bot_ban_notice_error), null, false, 28);
        return;
    L19:
        if (r100.getType() != InputReferenceType.ATTACHMENT) goto L41;
        Iterator<T> r103 = this.f298791o.iterator();
    L22:
        if (r103.hasNext() == false) goto L37;
        Object r104 = r103.next();
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r105 = (com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r104;
        if (Intrinsics.areEqual(r105.f298715a, r100.f298715a) == false) goto L34;
        String r106 = r105.f298718d;
        boolean r107 = true;
        if (r106 != null) goto L28;
    L31:
        boolean r108 = true;
    L32:
        if (r108 == true) goto L34;
    L35:
        if (r107 == false) goto L22;
    L38:
        r100 = (com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r104;
        if (r100 != null) goto L41;
        return;
    L28:
        if (StringsKt.isBlank(r106) == true) goto L31;
        r108 = false;
    L34:
        r107 = false;
        goto L35
    L37:
        r104 = null;
    L41:
        ChatInputWithMentionDelegate r109 = this.f298777a;
        int r110 = r101.f298765a;
        int r111 = r101.f298766b;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.d0> r112 = CollectionsKt.listOf(r100);
        int r113 = ChatInputWithMentionDelegate.f298615m;
        r109.j(r110, r111, r112, false);
        q();
        this.f298790n = null;
        this.f298788l.invoke();
    }

    public final void t(k1 r110) {
        Intrinsics.checkNotNullParameter(r110, "queryRange");
        gc8.b r100 = this.G;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        boolean r101 = false;
        if (this.f298790n != null) goto L8;
        this.P.f298940c = false;
    L8:
        this.f298790n = r110;
        ArrayList r111 = null;
        if (this.H == true) goto L30;
        be8.a r102 = this.f298782f.invoke();
        if (r102 == null) goto L30;
        this.H = true;
        List<be8.b> r103 = r102.iH();
        if ((!r103.isEmpty()) == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L26;
        HashSet r104 = new HashSet();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r103.iterator();
    L21:
        if (r106.hasNext() == false) goto L25;
        Object r107 = r106.next();
        if (r104.add(((be8.b) r107).f18744a) == false) goto L21;
        r105.add(r107);
        goto L21
    L25:
        this.D = r105;
    L26:
        long r108 = this.C;
        String r109 = AccountService.f365697a.getUserId();
        Job r112 = this.f298794r;
        if (r112 == null) goto L29;
        Job.DefaultImpls.cancel$default(r112, null, 1, null);
    L29:
        this.f298794r = BuildersKt.launch$default(this.f298778b, null, null, new MentionPanelController$refreshSkillsIfNeeded$3(r102, r108, this, r109, null), 3, null);
    L30:
        String r113 = StringsKt.trim(r110.f298767c).toString();
        if (Intrinsics.areEqual(this.f298796t, r113) == false) goto L33;
        p(r110);
        return;
    L33:
        Job r114 = this.f298793q;
        if (r114 == null) goto L36;
        Job.DefaultImpls.cancel$default(r114, null, 1, null);
    L36:
        Job r115 = this.f298792p;
        if (r115 == null) goto L39;
        Job.DefaultImpls.cancel$default(r115, null, 1, null);
    L39:
        q();
        long r116 = this.B + 1;
        this.B = r116;
        this.f298796t = r113;
        if (this.O == true) goto L49;
        this.f298797u = new f0(null, null, null, null, 31);
        this.f298798v = false;
        if (r113.length() != 0) goto L44;
        r101 = true;
    L44:
        if (r101 == false) goto L46;
        SearchState r117 = SearchState.IDLE;
    L47:
        this.f298799w = r117;
        p(r110);
        return;
    L46:
        r117 = SearchState.READY;
        goto L47
    L49:
        if (r113.length() != 0) goto L51;
        boolean r118 = true;
    L52:
        if (r118 == false) goto L86;
        MentionRecommendStore.f298868a.getClass();
        String r119 = AccountService.f365697a.getUserId();
        Object r120 = MentionRecommendStore.f298872e;
        monitor-enter(r120);
        MentionRecommendStore.a r121 = MentionRecommendStore.f298873f;     // Catch: Throwable -> L83
        if (r121 == null) goto L60;
        if (Intrinsics.areEqual(r121.f298877a, r119) == false) goto L60;
    L61:
        monitor-exit(r120);
        if (r121 == null) goto L64;
        f0 r122 = r121.f298878b;
    L81:
        if (r122 == null) goto L86;
        f0 r123 = j(r122);
    L88:
        if (r113.length() != 0) goto L90;
        boolean r124 = true;
    L91:
        if (r124 == false) goto L113;
        FLogger r125 = FLogger.f375446a;
        StringBuilder r126 = new StringBuilder("[load] recommend cached=");
        if (r123 == null) goto L95;
        boolean r127 = true;
    L96:
        r126.append(r127);
        r126.append(", cachedContacts=");
        if (r123 == null) goto L112;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r128 = r123.f298914b;
        if (r128 == null) goto L112;
        ArrayList r129 = new ArrayList();
        Iterator<T> r130 = r128.iterator();
    L102:
        if (r130.hasNext() == false) goto L111;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c r131 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c) r130.next();
        if (r131 == null) goto L108;
        qp8.c r132 = r131.f298901a;
        if (r132 == null) goto L108;
        String r133 = r132.f534367a;
    L109:
        if (r133 == null) goto L102;
        r129.add(r133);
    L108:
        r133 = null;
        goto L109
    L111:
        r111 = r129;
    L112:
        r126.append(r111);
        r125.i("MentionPanelController", r126.toString());
        goto L113
    L95:
        r127 = false;
    L113:
        if (r123 != null) goto L115;
        f0 r134 = new f0(null, null, null, null, 31);
    L116:
        this.f298797u = r134;
        if (r113.length() != 0) goto L119;
        boolean r135 = true;
    L120:
        if (r135 == false) goto L123;
        if (r123 != null) goto L123;
        boolean r136 = true;
    L124:
        this.f298798v = r136;
        if (r113.length() != 0) goto L127;
        r101 = true;
    L127:
        if (r101 == false) goto L129;
        SearchState r137 = SearchState.IDLE;
    L130:
        this.f298799w = r137;
        p(r110);
        this.f298792p = BuildersKt.launch$default(this.f298778b, null, null, new MentionPanelController$load$2(r113, this, r116, r123, null), 3, null);
        return;
    L129:
        r137 = SearchState.FULL_LOADING;
    L123:
        r136 = false;
        goto L124
    L119:
        r135 = false;
        goto L120
    L115:
        r134 = r123;
        goto L116
    L90:
        r124 = false;
        goto L91
    L64:
        f0 r138 = MentionRecommendStore.c(r119);
        if (r138 == null) goto L80;
        monitor-enter(r120);
        MentionRecommendStore.a r139 = MentionRecommendStore.f298873f;     // Catch: Throwable -> L77
        if (r139 == null) goto L70;
        String r140 = r139.f298877a;     // Catch: Throwable -> L77
    L72:
        if (Intrinsics.areEqual(r140, r119) == true) goto L74;
        MentionRecommendStore.f298873f = new MentionRecommendStore.a(r119, r138);     // Catch: Throwable -> L77
    L74:
        Unit r141 = Unit.INSTANCE;     // Catch: Throwable -> L77
        monitor-exit(r120);
        r122 = r138;
        goto L81
    L70:
        r140 = null;
    L77:
        th = move-exception;
        throw th;
    L80:
        r122 = null;
    L60:
        r121 = null;
    L83:
        th = move-exception;
        throw th;
    L86:
        r123 = null;
        goto L88
    L51:
        r118 = false;
        goto L52
    }

    public static void e(List r100, String r101) {
        r100.add(new y.a(r101));
        int r102 = 0;
    L4:
        if (r102 >= 5) goto L6;
        r100.add(y.b.f298973a);
        r102 = r102 + 1;
        goto L4
    }

    public final k1 h(String r100, long r101) {
        k1 r102 = this.f298790n;
        if (r102 == null) goto L15;
        if (Intrinsics.areEqual(this.f298796t, r100) == true) goto L7;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L15;
        return r102;
    L7:
        if (this.B != r101) goto L11;
        if (Intrinsics.areEqual(StringsKt.trim(r102.f298767c).toString(), r100) == false) goto L11;
        r103 = true;
    L15:
        return null;
    }

    public static final Object a(MentionPanelController r100, Function1 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MentionPanelController$loadCatching$1) == false) goto L7;
        MentionPanelController$loadCatching$1 r103 = (MentionPanelController$loadCatching$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L19 CancellationException -> L22
    L24:
    L21:
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        r103.label = 1;     // Catch: Throwable -> L19 CancellationException -> L22
        r105 = r101.invoke(r103);     // Catch: Throwable -> L19 CancellationException -> L22
        if (r105 != r106) goto L24;
        return r106;
    L22:
        e = move-exception;
        throw e;
    L19:
        r105 = null;
    L7:
        r103 = new MentionPanelController$loadCatching$1(r100, r102);
        goto L8
    }

    public final void b(List<y> r110, String r111, boolean r112) {
        if (this.f298776J == true) goto L5;
        return;
    L5:
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.d0> r100 = this.f298791o;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L30;
        Object r104 = r102.next();
        com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r105 = (com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r104;
        String r106 = r105.f298718d;
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
    L28:
        if (r103 == false) goto L6;
        r101.add(r104);
        goto L6
    L17:
        if (r111.length() != 0) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L22;
    L25:
        boolean r109 = true;
    L26:
        if (r109 == false) goto L28;
        r103 = true;
        goto L28
    L22:
        if (StringsKt.contains(r105.f298716b, r111, true) == true) goto L25;
        r109 = false;
        goto L26
    L19:
        r108 = false;
        goto L20
    L11:
        if (StringsKt.isBlank(r106) == true) goto L14;
        r107 = false;
        goto L15
    L30:
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r114 = r101.iterator();
    L31:
        List r115 = null;
        boolean r116 = false;
        if (r114.hasNext() == false) goto L34;
        boolean r117 = r116 ? 1 : 0;
        r113.add(new c1((com.larus.bmhome.chat.component.bottom.core.inputtext.d0) r114.next(), r115, r117, 6));
        goto L31
    L34:
        c r118 = v(this, r113, false, 2);
        List r119 = r113;
        if (r112 == true) goto L38;
        r119 = r118.f298811a;
    L38:
        List r120 = r119;
        f(this, r110, AppHost.f326268a.getApplication().getString(R.string.larus_input_contextWindow_header_recentAttachments), r120, MentionPanelSection.ATTACHMENT, null, false, 24);
        if (r112 == false) goto L41;
        return;
    L41:
        if (r118.f298812b == false) goto L51;
        r110.add(new y.c(this.P.b(SlashMentionConfig.MENTION_CONTENT_ATTACHMENT), null, null, new MentionPanelController$addAttachmentSection$1(this)));
        return;
    }

    public final void g(List<y> r210, String r310, boolean r311) {
        if (r310.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        s1 r101 = this.F;
        if (r101 != null) goto L12;
        e(r210, AppHost.f326268a.getApplication().getString(R.string.larus_input_slash_header_skills));
        return;
    L12:
        List<t1> r102 = r101.f299156a;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L14:
        if (r104.hasNext() == false) goto L17;
        r103.add(((t1) r104.next()).f299232a);
        goto L14
    L17:
        if (r103.isEmpty() == false) goto L19;
        return;
    L19:
        c r105 = v(this, r103, false, 6);
        Iterable r106 = r103;
        if (r311 == true) goto L23;
        r106 = r105.f298811a;
    L23:
        boolean r107 = v19.h.f552477a;
        boolean r108 = v19.h.b(this.f298777a.f298729a.getContext());
        r210.add(new y.a(AppHost.f326268a.getApplication().getString(R.string.larus_input_slash_header_skills)));
        Iterator r109 = r106.iterator();
    L24:
        g0 r110 = null;
        if (r109.hasNext() == false) goto L33;
        final be8.b r111 = (be8.b) r109.next();
        String r112 = r111.f18745b;
        h0 r113 = new h0(SlashMentionConfig.SLASH_CONTENT_SKILL, MapController.ITEM_LAYER_TAG, r112);
        String r114 = r111.f18744a;
        if ((!StringsKt.isBlank(r114)) == true) goto L30;
        r114 = null;
    L30:
        if (r114 == null) goto L32;
        r110 = new g0(MentionPanelSection.SKILL, r114);
    L32:
        String r115 = r111.f18747d;
        t1 r116 = (t1) ((LinkedHashMap) r101.f299158c).get(r111.f18744a);
        Integer r117 = Integer.valueOf(R.drawable.larus_icon_slash_skills);
        b2.b r118 = b2.f314255a;
        r210.add(new y.d(r112, r113, r110, null, r115, r116, r117, b2.b(r111.f18744a, r108), null, null, null, null, null, null, null, new x(this, r111), 130824));
        goto L24
    L33:
        if (r311 == false) goto L35;
        return;
    L35:
        if (r105.f298812b == false) goto L43;
        r210.add(new y.c(this.P.b(SlashMentionConfig.SLASH_CONTENT_SKILL), null, null, new MentionPanelController$addSkillSection$2(this)));
        return;
    L43:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static c u(List r100, int r101, boolean r102, boolean r103) {
        List r104 = CollectionsKt.filterNotNull(r100);
        if (r102 == false) goto L5;
    L8:
        boolean r105 = true;
    L9:
        List r106 = r104;
        if (r105 == true) goto L14;
        r101 = r101 + (r103 ? 1 : 0);
    L14:
        return new c(CollectionsKt.take(r106, r101), r105);
    L5:
        if (r104.size() > (r101 + (r103 ? 1 : 0))) goto L8;
        r105 = false;
        goto L9
    }

    public static /* synthetic */ c v(MentionPanelController r100, List r101, boolean r102, int r103) {
        boolean r104 = false;
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r104 = true;
    L8:
        r100.getClass();
        return u(r101, 5, r102, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(List<y> r210, List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r211, MentionPanelSection r212, final MentionSearchDomain r310, boolean r311) {
        if (this.K == true) goto L5;
        return;
    L5:
        List r100 = CollectionsKt.filterNotNull(r211);
        if (r100.isEmpty() == false) goto L10;
        if (r310 != null) goto L10;
        if (r311 == true) goto L10;
        return;
    L10:
        r210.add(new y.a(AppHost.f326268a.getApplication().getString(R.string.larus_input_mention_contacts)));
        Iterator r101 = r100.iterator();
    L11:
        String r102 = null;
        if (r101.hasNext() == false) goto L30;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c r103 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c) r101.next();
        final qp8.c r104 = r103.f298901a;
        String r105 = r104.f534368b;
        h0 r110 = new h0("contact", MapController.ITEM_LAYER_TAG, r105);
        if (r212 == null) goto L21;
        String r106 = r104.f534367a;
        if ((!StringsKt.isBlank(r106)) == true) goto L19;
        r106 = null;
    L19:
        if (r106 == null) goto L21;
        g0 r111 = new g0(r212, r106);
    L22:
        String r112 = r104.f534370d;
        List<String> r107 = r103.f298902b;
        if (r107 == null) goto L25;
        List r113 = CollectionsKt.filterNotNull(r107);
    L27:
        if (StringsKt.isBlank(r104.f534369c) == false) goto L29;
        r102 = "@";
    L29:
        t1 r114 = null;
        Object[] r115 = 0 == true ? 1 : 0;
        Object[] r116 = 0 == true ? 1 : 0;
        r210.add(new y.d(r105, r110, r111, r113, r112, r114, null, r115, r102, r116, null, null, null, r104.f534369c, r104.f534367a, new v(this, r104), 106144));
        goto L11
    L25:
        r113 = null;
    L21:
        r111 = null;
        goto L22
    L30:
        if (r310 == null) goto L36;
        r210.add(new y.c(this.P.b(n0.a(r310)), null, null, new w(this, r310)));
        return;
    }

    public static /* synthetic */ void d(MentionPanelController r100, List r101, List r110, MentionPanelSection r111, MentionSearchDomain r112, boolean r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        MentionPanelSection r102 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        MentionSearchDomain r103 = null;
    L11:
        if ((r114 & 8) == 0) goto L13;
        boolean r104 = false;
    L14:
        r100.c(r101, r110, r102, r103, r104);
        return;
    L13:
        r104 = r113;
        goto L14
    L9:
        r103 = r112;
        goto L11
    L5:
        r102 = r111;
        goto L7
    }

    public static void f(final MentionPanelController r210, List r211, String r310, List r311, MentionPanelSection r312, MentionSearchDomain r313, boolean r314, int r315) {
        if ((r315 & 4) == 0) goto L5;
        MentionPanelSection r100 = null;
    L7:
        if ((r315 & 8) == 0) goto L9;
        MentionSearchDomain r101 = null;
    L10:
        char r102 = 0;
        if ((r315 & 16) == 0) goto L13;
        boolean r103 = false;
    L14:
        r210.getClass();
        List r104 = CollectionsKt.filterNotNull(r311);
        if (r104.isEmpty() == false) goto L19;
        if (r101 != null) goto L19;
        if (r103 == true) goto L19;
        return;
    L19:
        r211.add(new y.a(r310));
        Iterator r105 = r104.iterator();
    L21:
        if (r105.hasNext() == false) goto L89;
        c1 r106 = (c1) r105.next();
        final com.larus.bmhome.chat.component.bottom.core.inputtext.d0 r107 = r106.f298904a;
        String r110 = r107.f298716b;
        InputReferenceType r108 = r107.getType();
        Intrinsics.checkNotNullParameter(r108, "<this>");
        switch(n0.a.f298947a[r108.ordinal()]) {
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            default: goto L25;
        };
    L26:
        String r109 = "conversation";
    L32:
        h0 r111 = new h0(r109, MapController.ITEM_LAYER_TAG, r107.f298716b);
        if (r100 == null) goto L40;
        String r112 = r107.f298715a;
        if ((!StringsKt.isBlank(r112)) == true) goto L38;
        r112 = null;
    L38:
        if (r112 == null) goto L40;
        g0 r113 = new g0(r100, r112);
    L41:
        List<String> r114 = r106.f298905b;
        if (r114 == null) goto L44;
        List r115 = CollectionsKt.filterNotNull(r114);
    L45:
        Long r116 = r106.f298906c;
        if (r116 == null) goto L68;
        long r117 = r116.longValue();
        MentionSearchDomain r316 = r101;
        long r118 = System.currentTimeMillis();
        Calendar r119 = Calendar.getInstance();
        r119.setTimeInMillis(r117 * 1000);
        Calendar r120 = Calendar.getInstance();
        r120.setTimeInMillis(r118);
        Calendar r121 = Calendar.getInstance();
        r121.setTimeInMillis(r118);
        r121.add(6, -1);
        StringCompanionObject r122 = StringCompanionObject.INSTANCE;
        Locale r123 = Locale.ROOT;
        Object[] r124 = new Object[2];
        r124[r102] = Integer.valueOf(r119.get(11));
        r124[1] = Integer.valueOf(r119.get(12));
        String r125 = String.format(r123, "%02d:%02d", Arrays.copyOf(r124, 2));
        int r126 = r119.get(2) + 1;
        int r127 = r119.get(5);
        Intrinsics.checkNotNull(r119);
        Intrinsics.checkNotNull(r120);
        MentionPanelSection r212 = r100;
        Iterator r317 = r105;
        if (r119.get(1) == r120.get(1)) goto L50;
    L52:
        boolean r128 = false;
    L54:
        if (r128 == false) goto L56;
        String r129 = AppHost.f326268a.getApplication().getString(R.string.larus_LarkIM_Common_Today_Text) + ' ' + r125;
    L69:
        if (r129 != null) goto L71;
        r129 = "";
    L71:
        String r130 = r129;
        Integer r131 = com.larus.bmhome.chat.component.bottom.core.inputtext.k0.c(r107.getType());
        if (r107.getType() != InputReferenceType.CONTACT) goto L74;
    L77:
        String r132 = "@";
    L78:
        String r133 = r107.f298723i;
        String r134 = r107.f298724j;
        String r135 = r107.f298719e;
        com.larus.bmhome.chat.component.bottom.core.inputtext.i0 r136 = r107.f298720f;
        com.larus.bmhome.chat.referenceicon.b r137 = r107.f298722h;
        String r138 = r107.f298715a;
        if (r107.getType() == InputReferenceType.CONVERSATION) goto L81;
    L83:
        boolean r139 = false;
    L85:
        if (Boolean.valueOf(r139).booleanValue() == false) goto L87;
        String r213 = r138;
    L88:
        r211.add(new y.d(r110, r111, r113, r115, r130, null, r131, null, r132, r135, r136, r137, r213, r133, r134, new l(r210, r107), 98464));
        r101 = r316;
        r105 = r317;
        r100 = r212;
        r102 = 0;
        goto L21
    L87:
        r213 = null;
        goto L88
    L81:
        if ((!StringsKt.isBlank(r107.f298715a)) == false) goto L83;
        r139 = true;
        goto L85
    L74:
        if (r107.getType() == InputReferenceType.GROUP) goto L77;
        r132 = null;
        goto L78
    L56:
        Intrinsics.checkNotNull(r121);
        if (r119.get(1) == r121.get(1)) goto L59;
    L61:
        boolean r140 = false;
    L62:
        if (r140 == false) goto L65;
        r129 = AppHost.f326268a.getApplication().getString(R.string.larus_LarkIM_Common_Yesterday_Text) + ' ' + r125;
        goto L69
    L65:
        if (r119.get(1) != r120.get(1)) goto L67;
        StringBuilder r141 = new StringBuilder();
        r141.append(r126);
        AppHost.Companion r142 = AppHost.f326268a;
        r141.append(r142.getApplication().getString(R.string.larus_message_time_month));
        r141.append(r127);
        r141.append(r142.getApplication().getString(R.string.larus_message_time_day));
        r141.append(' ');
        r141.append(r125);
        r129 = r141.toString();
        goto L69
    L67:
        StringBuilder r143 = new StringBuilder();
        r143.append(r119.get(1));
        AppHost.Companion r144 = AppHost.f326268a;
        r143.append(r144.getApplication().getString(R.string.larus_message_time_year));
        r143.append(r126);
        r143.append(r144.getApplication().getString(R.string.larus_message_time_month));
        r143.append(r127);
        r143.append(r144.getApplication().getString(R.string.larus_message_time_day));
        r143.append(' ');
        r143.append(r125);
        r129 = r143.toString();
        goto L69
    L59:
        if (r119.get(6) != r121.get(6)) goto L61;
        r140 = true;
        goto L62
    L50:
        if (r119.get(6) != r120.get(6)) goto L52;
        r128 = true;
        goto L54
    L68:
        r212 = r100;
        r316 = r101;
        r317 = r105;
        r129 = null;
        goto L69
    L44:
        r115 = null;
    L40:
        r113 = null;
        goto L41
    L27:
        r109 = "cloud_doc";
        goto L32
    L28:
        r109 = SlashMentionConfig.SLASH_CONTENT_SKILL;
        goto L32
    L29:
        r109 = SlashMentionConfig.MENTION_CONTENT_ATTACHMENT;
        goto L32
    L30:
        r109 = "group_chat";
        goto L32
    L31:
        r109 = "contact";
        goto L32
    L25:
        throw new NoWhenBranchMatchedException();
    L89:
        final MentionSearchDomain r318 = r101;
        if (r318 == null) goto L97;
        r211.add(new y.c(r210.P.b(n0.a(r318)), null, null, new m(r210, r318)));
        return;
    L97:
        return;
    L13:
        r103 = r314;
        goto L14
    L9:
        r101 = r313;
        goto L10
    L5:
        r100 = r312;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.activity.OnBackPressedCallback, com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionPanelController$backCallback$1] */
    /* JADX WARN: Type inference failed for: r9v3, types: [com.larus.bmhome.chat.component.bottom.core.inputtext.mention.n] */
    public MentionPanelController(ChatInputWithMentionDelegate r210, CoroutineScope r211, Fragment r212, q0 r213, qp8.e r214, Function1 r215, Function0 r216, Function0 r217, Function0 r310, boolean r311, Set r312, com.larus.bmhome.chat.component.bottom.core.inputtext.u0 r313, com.larus.bmhome.chat.component.bottom.core.inputtext.v0 r314, Function1 r315, SkillSearchIndex r316) {
        Intrinsics.checkNotNullParameter(r210, "inputDelegate");
        Intrinsics.checkNotNullParameter(r211, "coroutineScope");
        Intrinsics.checkNotNullParameter(r212, "hostFragment");
        Intrinsics.checkNotNullParameter(r213, "panelView");
        Intrinsics.checkNotNullParameter(r214, "officeMentionConfig");
        Intrinsics.checkNotNullParameter(r215, "onSelectFile");
        Intrinsics.checkNotNullParameter(r216, "skillAbilityProvider");
        Intrinsics.checkNotNullParameter(r217, "switchToTaskModeIfNeeded");
        Intrinsics.checkNotNullParameter(r310, "onSwitchToSkillPanel");
        Intrinsics.checkNotNullParameter(r312, "enabledContents");
        Intrinsics.checkNotNullParameter(r313, "onPanelVisibilityChanged");
        Intrinsics.checkNotNullParameter(r314, "onQueryFinished");
        Intrinsics.checkNotNullParameter(r315, "onConsumeQuery");
        Intrinsics.checkNotNullParameter(r316, "skillSearchIndex");
        this.f298777a = r210;
        this.f298778b = r211;
        this.f298779c = r213;
        this.f298780d = r214;
        this.f298781e = r215;
        this.f298782f = r216;
        this.f298783g = r217;
        this.f298784h = r310;
        this.f298785i = r311;
        this.f298786j = r312;
        this.f298787k = r313;
        this.f298788l = r314;
        this.f298789m = r315;
        this.f298791o = CollectionsKt.emptyList();
        this.f298797u = new f0(null, null, null, null, 31);
        this.f298799w = SearchState.IDLE;
        this.f298800x = Page.ROOT;
        this.D = CollectionsKt.emptyList();
        this.E = new SkillPanelSearch(r210.f298729a.getContext(), r211, r316);
        int r100 = gc8.a.f480880a;
        LifecycleOwner r101 = r212.getViewLifecycleOwner();
        MentionPanelController$conversationIconSession$1 r102 = new MentionPanelController$conversationIconSession$1(r213);
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "onIconsChanged");
        ISideBarConversationIconService r103 = (ISideBarConversationIconService) ServiceManager.get().getService(ISideBarConversationIconService.class);
        if (r103 == null) goto L5;
        SideBarConversationIconSessionImpl r104 = r103.a(r101, r102);
    L6:
        this.G = r104;
        this.I = r312.contains(MentionPanelContent.ADD);
        this.f298776J = r312.contains(MentionPanelContent.ATTACHMENT);
        boolean r105 = false;
        if (r312.contains(MentionPanelContent.CONTACT) == false) goto L11;
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.f() == false) goto L11;
        boolean r106 = true;
    L12:
        this.K = r106;
        this.L = r106;
        boolean r107 = r312.contains(MentionPanelContent.DRIVE);
        this.M = r107;
        boolean r108 = r312.contains(MentionPanelContent.CONVERSATION);
        this.N = r108;
        if (r106 == true) goto L16;
        if (r107 == true) goto L16;
        if (r108 == true) goto L16;
    L17:
        this.O = r105;
        this.P = new m0(r210.f298729a.getContext(), new n(this));
        ?? r109 = new MentionPanelController$backCallback$1(this);
        this.Q = r109;
        r212.requireActivity().getOnBackPressedDispatcher().addCallback(r212, r109);
        Function1<? super String, ? extends gc8.c> r110 = new o(this);
        Intrinsics.checkNotNullParameter(r110, ShortVideoSegments.KEY_PROP_PROVIDER);
        MentionPanelListView r111 = r213.f298954a;
        r111.getClass();
        Intrinsics.checkNotNullParameter(r110, ShortVideoSegments.KEY_PROP_PROVIDER);
        r111.f298833r = r110;
        if (r105 == true) goto L20;
        return;
    L20:
        if ((!StringsKt.isBlank(r214.f534374d.invoke())) == false) goto L24;
        MentionRecommendStore.f298868a.getClass();
        Intrinsics.checkNotNullParameter(r214, "config");
        MentionRecommendStore.f(r214, r106);
        return;
    L24:
        return;
    L16:
        r105 = true;
    L11:
        r106 = false;
        goto L12
    L5:
        r104 = null;
        goto L6
    }
}
