package com.obric.assistant.special_input;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.OSkill;
import com.obric.assistant.ability.chat.input.SkillSelectSource;
import com.obric.assistant.component.c7;
import com.obric.assistant.spi.keyguard.IKeyguardService;
import com.obric.assistant.spi.keyguard.KeyguardService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 t2\u00020\u00012\u00020\u0002:\u0001tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J,\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070(H\u0016J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0016J \u0010*\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J \u0010-\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00072\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020\u001bH\u0016J\b\u00102\u001a\u00020\u001bH\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\b\u00104\u001a\u00020\u0017H\u0016J\u0012\u00105\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020\u0007H\u0016J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u000e\u00107\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u0010\u00109\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0007H\u0016J\u0016\u0010:\u001a\u00020\u001b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J\b\u0010<\u001a\u00020\u001bH\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0011H\u0016J\u0010\u0010?\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0011H\u0016J\u0010\u0010@\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0015H\u0016J\u0010\u0010A\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0015H\u0016J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0013H\u0016J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u0013H\u0016J\u000e\u0010D\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u0018\u0010G\u001a\u00020\u00172\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020JH\u0016J\u0018\u0010K\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00072\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010L\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0007H\u0016J\b\u0010M\u001a\u00020\u0017H\u0016J\u0010\u0010N\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0007H\u0016J\u0016\u0010O\u001a\u00020\u001b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0016J\b\u0010P\u001a\u00020\u001bH\u0016J\u0012\u0010Q\u001a\u00020\u001b2\b\b\u0002\u0010R\u001a\u00020\u001aH\u0002J\b\u0010S\u001a\u00020\u001bH\u0002J\u001c\u0010T\u001a\u00020\u001b2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u001fH\u0002J\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\u0012\u0010X\u001a\u0004\u0018\u00010\r2\u0006\u0010H\u001a\u00020YH\u0002J\u0012\u0010Z\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020\u0007H\u0002J\u000e\u0010[\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\u0010\u0010\\\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0016\u0010]\u001a\u00020\u00172\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070^H\u0002J\u0010\u0010_\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0007H\u0002J \u0010`\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JH\u0002J\u0012\u0010b\u001a\u0004\u0018\u00010\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0010\u0010c\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JH\u0002J*\u0010d\u001a\u00020\u001b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070e2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u001fH\u0002J \u0010f\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020\r2\u0006\u0010g\u001a\u00020\u00172\u0006\u0010I\u001a\u00020JH\u0002J\u000e\u0010h\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\u0016\u0010i\u001a\u00020\u001b2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\b\u0010k\u001a\u00020\u001bH\u0002J\b\u0010l\u001a\u00020\u001bH\u0002J\b\u0010m\u001a\u00020\u001bH\u0016J\b\u0010n\u001a\u00020\u0007H\u0002J\u0010\u0010o\u001a\u00020\u00172\u0006\u0010p\u001a\u00020qH\u0016J\u0014\u0010r\u001a\u0004\u0018\u00010\u0007*\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\u0014\u0010s\u001a\u0004\u0018\u00010\u0007*\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\r0\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/obric/assistant/special_input/ObricInputSkillComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/chat/input/IObricInputSkillAbility;", "<init>", "()V", "selectedSkillIds", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "mentionedSkillIds", "routeSelectedSkillIds", "routeMentionTemporarySkills", "Ljava/util/LinkedHashMap;", "Lcom/obric/assistant/ability/chat/input/ObricSkillItem;", "Lkotlin/collections/LinkedHashMap;", "selectionChangeListeners", "", "Lcom/obric/assistant/ability/chat/input/SkillSelectionChangeListener;", "displayedSkillListChangeListeners", "Lcom/obric/assistant/ability/chat/input/DisplayedSkillListChangeListener;", "mentionCandidateLoadListeners", "Lcom/obric/assistant/ability/chat/input/MentionCandidateLoadListener;", "skillCacheLoaded", "", "skillCacheListener", "Lkotlin/Function1;", "Lcom/obric/assistant/special_input/SkillCacheSnapshot;", "", "availableSkillList", "", "routeRecognizableSkillMap", "", "rowBaseSkillList", "loadedSkillList", "initialized", "destroyed", "setSkillMessageExt", "conversationId", "content", "extra", "", "buildFinalQuery", "replaceSkillMention", "skillName", "skillId", "isSkillMentionBoundary", "start", "", "end", LiveCommonConstants.REASON_ON_DEDTROY, "initializeIfNeeded", "getLoadedSkillList", "isSkillCacheLoaded", "resolveAvailableSkill", "getPhoneOperationActionBarSkills", "getSelectedSkillIds", "getSelectedSkills", "toggleSkillSelection", "setSelectedSkillIds", "skillIds", "resetSelection", "addSkillSelectionChangeListener", "listener", "removeSkillSelectionChangeListener", "addMentionCandidateLoadListener", "removeMentionCandidateLoadListener", "addDisplayedSkillListChangeListener", "removeDisplayedSkillListChangeListener", "getMentionCandidateSkills", "getMentionedSkillIds", "getMentionedSkills", "addRouteSelectedSkill", SlashMentionConfig.SLASH_CONTENT_SKILL, "source", "Lcom/obric/assistant/ability/chat/input/SkillSelectSource;", "addMentionedSkill", "removeRouteMentionTemporarySkill", "clearRouteMentionTemporarySkills", "removeMentionedSkill", "setMentionedSkillIds", "clearMentionedSkills", "refreshSkillListFromCache", "snapshot", "removeUnavailableRouteMentionTemporarySkills", "reconcileSelectionState", "previousSkillById", "withAllSkillItem", "skillItems", "mapToObricSkillItem", "Lcom/obric/aiagent/assistant/idl/bean/OSkill;", "resolveSkillById", "buildDisplayedSkillList", "moveRouteSkillToFront", "updateRouteSelectedSkillIds", "", "removeRouteSelectedSkill", "removeRouteMentionTemporarySkillInternal", "removeMention", "normalizeSkillId", "isRouteSelectSource", "notifyInvalidatedMentions", "", "notifySelectionChanged", "selected", "snapshotDisplayedSkillList", "notifyDisplayedSkillListChangedIfNeeded", "previousDisplayedSkillList", "notifyDisplayedSkillListChanged", "notifyMentionCandidatesLoaded", "openAllSkillsPage", "buildAllSkillsLogExtras", "isOmniSkillUsable", "syncTimeoutMs", "", "joinSkillIds", "joinSkillNames", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricInputSkillComponent extends ComponentFeature implements paa.c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f392555w = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet<String> f392556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashSet<String> f392557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet<String> f392558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap<String, paa.e> f392559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<paa.f> f392560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<paa.a> f392561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Set<paa.d> f392562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f392563o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function1<s0, Unit> f392564p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<paa.e> f392565q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, paa.e> f392566r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List<paa.e> f392567s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<paa.e> f392568t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f392569u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f392570v;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((paa.e) r101).f528397b.length()), Integer.valueOf(((paa.e) r100).f528397b.length()));
        }
    }

    public static final class c implements oga.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricInputSkillComponent f392571a;

        @Override // oga.a
        public final void onDismissFailed() {
        }

        @Override // oga.a
        public final void onDismissSucceeded() {
            AppHost.Companion r100 = AppHost.f326268a;
            ContextWrapper r101 = r100.a().getCurrentActivity();
            if (r101 != null) goto L5;
            r101 = r100.getApplication();
        L5:
            Intent r102 = new Intent().setClassName(r101.getPackageName(), "com.obric.aiagent.skill.manager.impl.ui.SkillShopStarterActivity");
            ObricInputSkillComponent r103 = this.f392571a;
            int r104 = ObricInputSkillComponent.f392555w;
            r103.getClass();
            JSONObject r105 = new JSONObject();
            r105.put("previous_page", "chat");
            r105.put("enter_method", "obric_omni_click_all_skill");
            Intent r106 = r102.putExtra("log_extras", r105.toString());
            if ((r101 instanceof Activity) == true) goto L16;
            r106.addFlags(268435456);
        L16:
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L10
            r101.startActivity(r106);     // Catch: Throwable -> L10
            Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        L12:
            Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
            if (r109 == null) goto L18;
            FLogger.f375446a.e("ObricInputSkillComponent", "openAllSkillsPage failed", r109);
            t19.s.f544207a.g(AppHost.f326268a.getApplication(), R.string.obric_action_bar_oauto_jump_error, false);
            return;
        L18:
            return;
        L10:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L12
        }

        public c(ObricInputSkillComponent r100) {
            this.f392571a = r100;
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        this.f392570v = true;
        OSkillCache r100 = OSkillCache.f392527a;
        Function1<s0, Unit> r101 = this.f392564p;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "listener");
        OSkillCache.f("removeListener", r101, OSkillCache.i(r101));
        this.f392556h.clear();
        this.f392557i.clear();
        this.f392558j.clear();
        this.f392559k.clear();
        this.f392560l.clear();
        this.f392561m.clear();
        this.f392562n.clear();
        this.f392563o = false;
        this.f392565q = CollectionsKt.emptyList();
        this.f392566r = MapsKt.emptyMap();
        this.f392567s = CollectionsKt.emptyList();
        this.f392568t = CollectionsKt.emptyList();
        this.f392569u = false;
    }

    public final List<paa.e> F2() {
        Iterator<T> r100 = this.f392568t.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (Intrinsics.areEqual(((paa.e) r101).f528396a, "all_skills") == false) goto L4;
    L9:
        paa.e r102 = (paa.e) r101;
        if (r102 == null) goto L12;
        LinkedHashSet<String> r103 = this.f392558j;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L15:
        if (r105.hasNext() == false) goto L19;
        paa.e r106 = m3((String) r105.next());
        if (r106 == null) goto L15;
        r104.add(r106);
        goto L15
    L19:
        HashSet r107 = new HashSet();
        ArrayList r108 = new ArrayList();
        Iterator r109 = r104.iterator();
    L21:
        if (r109.hasNext() == false) goto L25;
        Object r110 = r109.next();
        if (r107.add(((paa.e) r110).f528396a) == false) goto L21;
        r108.add(r110);
        goto L21
    L25:
        List r111 = CollectionsKt.take(r108, 10);
        final HashSet r112 = new HashSet();
        Iterator r113 = r111.iterator();
    L27:
        if (r113.hasNext() == false) goto L29;
        r112.add(((paa.e) r113.next()).f528396a);
        goto L27
    L29:
        List r114 = CollectionsKt.createListBuilder(10);
        r114.addAll(r111);
        Iterator r115 = SequencesKt.take(SequencesKt.filter(CollectionsKt.asSequence(this.f392567s), new k(r112)), 10 - r114.size()).iterator();
    L31:
        if (r115.hasNext() == false) goto L33;
        r114.add((paa.e) r115.next());
        goto L31
    L33:
        List r116 = CollectionsKt.build(r114);
        List r117 = CollectionsKt.createListBuilder(r116.size() + 1);
        r117.add(r102);
        r117.addAll(r116);
        return CollectionsKt.build(r117);
    L12:
        return this.f392568t;
    L8:
        r101 = null;
        goto L9
    }

    public final void L2() {
        if (this.f392570v == false) goto L5;
        return;
    L5:
        if (this.f392569u == true) goto L10;
        this.f392563o = false;
        this.f392565q = CollectionsKt.emptyList();
        this.f392566r = MapsKt.emptyMap();
        this.f392567s = CollectionsKt.emptyList();
        this.f392568t = B3(CollectionsKt.emptyList());
        this.f392569u = true;
        OSkillCache r100 = OSkillCache.f392527a;
        Function1<s0, Unit> r101 = this.f392564p;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "listener");
        int r102 = OSkillCache.i(r101);
        OSkillCache.f392537k.add(new WeakReference(r101));
        OSkillCache.f("addListener", r101, r102);
        OSkillCache.k();
        Y2(OSkillCache.f392540n);
        return;
    }

    public final List<paa.e> p3() {
        if (this.f392569u == false) goto L6;
        return F2();
    L6:
        return CollectionsKt.emptyList();
    }

    @Override // paa.c
    public final void px() {
        IKeyguardService.a.a(KeyguardService.f392886a, new c(this), false, false, false, false, null, 62);
    }

    public ObricInputSkillComponent() {
        this.f392556h = new LinkedHashSet();
        this.f392557i = new LinkedHashSet();
        this.f392558j = new LinkedHashSet();
        this.f392559k = new LinkedHashMap();
        this.f392560l = new LinkedHashSet();
        this.f392561m = new LinkedHashSet();
        this.f392562n = new LinkedHashSet();
        this.f392564p = new ObricInputSkillComponent$skillCacheListener$1(this);
        this.f392565q = CollectionsKt.emptyList();
        this.f392566r = MapsKt.emptyMap();
        this.f392567s = CollectionsKt.emptyList();
        this.f392568t = CollectionsKt.emptyList();
    }

    @Override // paa.c
    public final List<String> AM() {
        L2();
        return CollectionsKt.toList(this.f392556h);
    }

    @Override // paa.c
    public final void CZ() {
        L2();
        if (this.f392557i.isEmpty() == true) goto L5;
    L11:
        List<paa.e> r100 = p3();
        LinkedHashSet<String> r101 = this.f392557i;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L13:
        if (r103.hasNext() == false) goto L17;
        paa.e r104 = m3((String) r103.next());
        if (r104 == null) goto L13;
        r102.add(r104);
        goto L13
    L17:
        LinkedHashSet<String> r105 = this.f392556h;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L19:
        if (r107.hasNext() == false) goto L23;
        paa.e r108 = m3((String) r107.next());
        if (r108 == null) goto L19;
        r106.add(r108);
        goto L19
    L23:
        this.f392557i.clear();
        this.f392556h.clear();
        this.f392558j.clear();
        this.f392559k.clear();
        Iterator r109 = r106.iterator();
    L25:
        if (r109.hasNext() == false) goto L27;
        X2((paa.e) r109.next(), false, SkillSelectSource.MENTION);
        goto L25
    L27:
        ArrayList r110 = new ArrayList();
        Iterator r111 = r102.iterator();
    L29:
        if (r111.hasNext() == false) goto L41;
        Object r112 = r111.next();
        paa.e r113 = (paa.e) r112;
        if (r106.isEmpty() == false) goto L33;
    L32:
        boolean r114 = false;
    L39:
        if (r114 == true) goto L29;
        r110.add(r112);
        goto L29
    L33:
        Iterator r115 = r106.iterator();
    L35:
        if (r115.hasNext() == false) goto L32;
        if (Intrinsics.areEqual(((paa.e) r115.next()).f528396a, r113.f528396a) == false) goto L35;
        r114 = true;
        goto L39
    L41:
        Iterator r116 = r110.iterator();
    L43:
        if (r116.hasNext() == false) goto L45;
        X2((paa.e) r116.next(), false, SkillSelectSource.MENTION);
        goto L43
    L45:
        U2(r100);
        return;
    L5:
        if (this.f392556h.isEmpty() == false) goto L11;
        if (this.f392558j.isEmpty() == false) goto L11;
        if (this.f392559k.isEmpty() == false) goto L11;
    }

    @Override // paa.c
    public final List<paa.e> Nh() {
        L2();
        LinkedHashSet<String> r100 = this.f392557i;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        paa.e r103 = m3((String) r102.next());
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    @Override // paa.c
    public final boolean Yb() {
        L2();
        return this.f392563o;
    }

    @Override // paa.c
    public final List<String> Yg() {
        L2();
        return CollectionsKt.toList(this.f392557i);
    }

    @Override // paa.c
    public final List<paa.e> Zm() {
        L2();
        return this.f392565q;
    }

    @Override // paa.c
    public final List<paa.e> a00() {
        L2();
        LinkedHashSet<String> r100 = this.f392556h;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        paa.e r103 = m3((String) r102.next());
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    @Override // paa.c
    public final List<paa.e> bJ() {
        L2();
        return F2();
    }

    @Override // paa.c
    public final List<paa.e> dj() {
        L2();
        return this.f392568t;
    }

    public static List B3(List r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((paa.e) r103).f528396a, "all_skills") == true) goto L4;
        r101.add(r103);
        goto L4
    L8:
        List r104 = CollectionsKt.createListBuilder(r101.size() + 1);
        r104.add(new paa.e("all_skills", AppHost.f326268a.getApplication().getString(R.string.obric_special_input_skill_all), null, 60));
        r104.addAll(r101);
        return CollectionsKt.build(r104);
    }

    public static paa.e N2(OSkill r100) {
        String r101 = StringsKt.trim(r100.getSlug()).toString();
        String r102 = StringsKt.trim(r100.getDisplayName()).toString();
        if (StringsKt.isBlank(r102) == false) goto L5;
        String r103 = r101;
    L7:
        if (StringsKt.isBlank(r101) == false) goto L9;
        return null;
    L9:
        if (StringsKt.isBlank(r103) == false) goto L12;
        return null;
    L12:
        return new paa.e(r101, r103, r100.getCoverUrl(), r100.getLastUsedAt(), r100.getCreatedAt(), r100.getLastUpdatedAt());
    L5:
        r103 = r102;
        goto L7
    }

    public static String P2(String r100) {
        String r101 = StringsKt.trim(r100).toString();
        if ((!StringsKt.isBlank(r101)) == true) goto L7;
        return null;
    L7:
        return r101;
    }

    @Override // paa.c
    public final void Dd(String r100) {
        Intrinsics.checkNotNullParameter(r100, "skillId");
        L2();
        List<paa.e> r101 = p3();
        String r102 = P2(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        paa.e r103 = m3(r102);
        if (r103 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r103.f528396a, "all_skills") == false) goto L12;
        return;
    L12:
        if (this.f392556h.contains(r102) == true) goto L14;
        this.f392556h.remove("all_skills");
        this.f392556h.add(r102);
        boolean r104 = true;
    L23:
        X2(r103, r104, SkillSelectSource.ROW);
        U2(r101);
        return;
    L14:
        if (this.f392559k.containsKey(r102) == false) goto L17;
        h3(r102, SkillSelectSource.ROW);
        return;
    L17:
        this.f392556h.remove(r102);
        if (this.f392558j.contains(r102) == false) goto L21;
        this.f392558j.remove(r102);
    L21:
        r104 = false;
        goto L23
    }

    @Override // paa.c
    public final paa.e GJ(String r100) {
        Intrinsics.checkNotNullParameter(r100, "skillId");
        L2();
        String r101 = P2(r100);
        Object r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        Iterator<T> r103 = this.f392565q.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((paa.e) r104).f528396a, r101) == false) goto L7;
        r102 = r104;
    L12:
        return (paa.e) r102;
    }

    @Override // paa.c
    public final boolean Kz(String r100) {
        Intrinsics.checkNotNullParameter(r100, "skillId");
        L2();
        return h3(r100, SkillSelectSource.MENTION);
    }

    @Override // paa.c
    public final String MG(String r110) {
        Intrinsics.checkNotNullParameter(r110, "content");
        List<paa.e> r100 = Nh();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L13;
        Object r104 = r102.next();
        paa.e r105 = (paa.e) r104;
        if ((!StringsKt.isBlank(r105.f528396a)) == true) goto L8;
    L10:
        r103 = false;
    L11:
        if (r103 == false) goto L3;
        r101.add(r104);
        goto L3
    L8:
        if ((!StringsKt.isBlank(r105.f528397b)) == false) goto L10;
    L13:
        Iterator r106 = CollectionsKt.sortedWith(r101, new b()).iterator();
    L15:
        if (r106.hasNext() == false) goto L50;
        paa.e r107 = (paa.e) r106.next();
        String r108 = r107.f528397b;
        String r109 = "@" + r108;
        String r111 = "@" + r107.f528396a;
        if (Intrinsics.areEqual(r109, r111) == true) goto L15;
        if (StringsKt.contains$default(r110, r109, false, 2, null) == false) goto L15;
        StringBuilder r112 = new StringBuilder();
        int r113 = 0;
    L23:
        if (r113 >= r110.length()) goto L49;
        int r114 = StringsKt.indexOf$default(r110, r109, r113, false, 4, null);
        if (r114 < 0) goto L26;
        int r115 = r109.length() + r114;
        r112.append(r110, r113, r114);
        if (r114 != 0) goto L30;
    L33:
        boolean r116 = true;
    L35:
        if (r115 != r110.length()) goto L37;
    L40:
        boolean r117 = true;
    L41:
        if (r116 == false) goto L44;
        if (r117 == false) goto L44;
        boolean r118 = true;
    L45:
        if (r118 == false) goto L47;
        r112.append(r111);
    L48:
        r113 = r115;
        goto L23
    L47:
        r112.append(r109);
    L44:
        r118 = false;
        goto L45
    L37:
        if (CharsKt.isWhitespace(r110.charAt(r115)) == true) goto L40;
        r117 = false;
        goto L41
    L30:
        if (CharsKt.isWhitespace(r110.charAt(r114 - 1)) == true) goto L33;
        r116 = false;
        goto L35
    L26:
        r112.append(r110, r113, r110.length());
    L49:
        r110 = r112.toString();
        goto L15
    L50:
        return r110;
    }

    @Override // paa.c
    public final void N40(c7 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f392561m.remove(r100);
    }

    public final void U2(List<paa.e> r100) {
        if (Intrinsics.areEqual(r100, F2()) == false) goto L6;
        return;
    L6:
        if (this.f392561m.isEmpty() == true) goto L12;
        List<paa.e> r101 = F2();
        Iterator<T> r102 = this.f392561m.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        ((paa.a) r102.next()).a(r101);
        goto L10
    L14:
        return;
    }

    public final void Y2(s0 r210) {
        if (this.f392570v == false) goto L6;
        return;
    L6:
        if (r210.f392771b == true) goto L9;
        this.f392563o = false;
        FLogger.f375446a.i("ObricInputSkillComponent", "refreshSkillListFromCache skipped, cache not loaded yet, lastLoadSucceeded=" + r210.f392772c);
        return;
    L9:
        this.f392563o = true;
        List<paa.e> r100 = p3();
        Map r101 = MapsKt.createMapBuilder();
        Iterator<T> r102 = this.f392565q.iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        paa.e r103 = (paa.e) r102.next();
        r101.put(r103.f528396a, r103);
        goto L11
    L13:
        Iterator<T> r104 = this.f392559k.values().iterator();
    L15:
        if (r104.hasNext() == false) goto L17;
        paa.e r105 = (paa.e) r104.next();
        String r106 = r105.f528396a;
        Intrinsics.checkNotNull(r105);
        r101.put(r106, r105);
        goto L15
    L17:
        Map r107 = MapsKt.build(r101);
        List<OSkill> r108 = r210.f392770a;
        ArrayList r109 = new ArrayList();
        Iterator<T> r110 = r108.iterator();
    L19:
        if (r110.hasNext() == false) goto L23;
        Object r111 = r110.next();
        if (((OSkill) r111).getEnabled() == false) goto L19;
        r109.add(r111);
        goto L19
    L23:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r109.iterator();
    L25:
        if (r113.hasNext() == false) goto L33;
        Object r114 = r113.next();
        OSkill r115 = (OSkill) r114;
        String r116 = P2(r115.getSlug());
        if (r115.getAvailable() == false) goto L30;
        if (r116 == null) goto L30;
        boolean r117 = true;
    L31:
        if (r117 == false) goto L25;
        r112.add(r114);
    L30:
        r117 = false;
        goto L31
    L33:
        ArrayList r118 = new ArrayList();
        Iterator r119 = r109.iterator();
    L35:
        if (r119.hasNext() == false) goto L39;
        paa.e r120 = N2((OSkill) r119.next());
        if (r120 == null) goto L35;
        r118.add(r120);
        goto L35
    L39:
        ArrayList r121 = new ArrayList();
        Iterator r122 = r118.iterator();
    L41:
        if (r122.hasNext() == false) goto L45;
        Object r123 = r122.next();
        if (Intrinsics.areEqual(((paa.e) r123).f528396a, "all_skills") == true) goto L41;
        r121.add(r123);
        goto L41
    L45:
        HashSet r124 = new HashSet();
        ArrayList r125 = new ArrayList();
        Iterator r126 = r121.iterator();
    L47:
        if (r126.hasNext() == false) goto L51;
        Object r127 = r126.next();
        if (r124.add(((paa.e) r127).f528396a) == false) goto L47;
        r125.add(r127);
        goto L47
    L51:
        FLogger.f375446a.i("ObricInputSkillComponent", "refreshSkillListFromCache: rawCount=" + r108.size() + ", enabledCount=" + r109.size() + ", availableCount=" + r112.size() + ", routeRecognizableCount=" + r125.size() + ", version=" + r210.f392773d + ", rawSkills=" + CollectionsKt.joinToString$default(r108, null, null, null, 0, null, new l(), 31, null));
        ArrayList r128 = new ArrayList();
        Iterator r129 = r112.iterator();
    L53:
        if (r129.hasNext() == false) goto L57;
        paa.e r130 = N2((OSkill) r129.next());
        if (r130 == null) goto L53;
        r128.add(r130);
        goto L53
    L57:
        HashSet r131 = new HashSet();
        ArrayList r132 = new ArrayList();
        Iterator r133 = r128.iterator();
    L59:
        if (r133.hasNext() == false) goto L63;
        Object r134 = r133.next();
        if (r131.add(((paa.e) r134).f528396a) == false) goto L59;
        r132.add(r134);
        goto L59
    L63:
        FLogger.f375446a.i("ObricInputSkillComponent", "refreshSkillListFromCache: mappedAvailableSkills(size=" + r132.size() + "), skills=" + CollectionsKt.joinToString$default(r132, null, null, null, 0, null, new m(), 31, null));
        this.f392565q = r132;
        LinkedHashMap r135 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r125, 10)), 16));
        Iterator r136 = r125.iterator();
    L65:
        if (r136.hasNext() == false) goto L67;
        Object r137 = r136.next();
        r135.put(((paa.e) r137).f528396a, r137);
        goto L65
    L67:
        this.f392566r = r135;
        Set<String> r138 = this.f392559k.keySet();
        Map<String, paa.e> r139 = this.f392566r;
        ArrayList r140 = new ArrayList();
        Iterator<T> r141 = r138.iterator();
    L69:
        if (r141.hasNext() == false) goto L74;
        Object r142 = r141.next();
        if (r139.containsKey((String) r142) == true) goto L69;
        r140.add(r142);
        goto L69
    L74:
        if (r140.isEmpty() == true) goto L81;
        LinkedHashMap<String, paa.e> r143 = this.f392559k;
        Iterator r144 = r140.iterator();
    L78:
        if (r144.hasNext() == false) goto L80;
        r143.remove((String) r144.next());
        goto L78
    L80:
        FLogger.f375446a.i("ObricInputSkillComponent", "removeUnavailableRouteMentionTemporarySkills: skillIds=" + CollectionsKt.joinToString$default(r140, null, null, null, 0, null, null, 63, null));
    L81:
        this.f392567s = CollectionsKt.take(r132, 10);
        this.f392568t = B3(this.f392565q);
        FLogger.f375446a.i("ObricInputSkillComponent", "refreshSkillListFromCache: rowBaseSkills(size=" + this.f392567s.size() + ")=" + CollectionsKt.joinToString$default(this.f392567s, null, null, null, 0, null, new n(), 31, null));
        Set<String> r145 = this.f392559k.keySet();
        List<paa.e> r146 = this.f392567s;
        HashSet r147 = new HashSet();
        Iterator<T> r148 = r146.iterator();
    L83:
        if (r148.hasNext() == false) goto L85;
        r147.add(((paa.e) r148.next()).f528396a);
        goto L83
    L85:
        Set<String> r149 = r145;
        r147.addAll(r149);
        L2();
        List<paa.e> r150 = this.f392565q;
        HashSet r151 = new HashSet();
        Iterator<T> r152 = r150.iterator();
    L87:
        if (r152.hasNext() == false) goto L89;
        r151.add(((paa.e) r152.next()).f528396a);
        goto L87
    L89:
        r151.addAll(r149);
        Set r153 = CollectionsKt.toSet(this.f392557i);
        LinkedHashSet<String> r154 = this.f392558j;
        ArrayList r155 = new ArrayList();
        Iterator<T> r156 = r154.iterator();
    L91:
        if (r156.hasNext() == false) goto L100;
        Object r157 = r156.next();
        String r158 = (String) r157;
        if (r151.contains(r158) == true) goto L95;
    L97:
        boolean r159 = false;
    L98:
        if (r159 == false) goto L91;
        r155.add(r157);
        goto L91
    L95:
        if (m3(r158) == null) goto L97;
        r159 = true;
        goto L98
    L100:
        z3(r155);
        r147.addAll(this.f392558j);
        this.f392556h.retainAll(r147);
        this.f392556h.addAll(this.f392558j);
        this.f392557i.retainAll(r151);
        Set r160 = SetsKt.minus(r153, this.f392557i);
        ArrayList r161 = new ArrayList();
        Iterator r162 = r160.iterator();
    L102:
        if (r162.hasNext() == false) goto L106;
        Object r163 = r162.next();
        if ((!Intrinsics.areEqual((String) r163, "all_skills")) == false) goto L102;
        r161.add(r163);
        goto L102
    L106:
        ArrayList r164 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r161, 10));
        Iterator r165 = r161.iterator();
    L108:
        if (r165.hasNext() == false) goto L113;
        String r166 = (String) r165.next();
        paa.e r167 = (paa.e) r107.get(r166);
        if (r167 != null) goto L112;
        r167 = new paa.e(r166, r166, null, 60);
    L112:
        r164.add(r167);
        goto L108
    L113:
        Iterator r168 = r164.iterator();
    L115:
        if (r168.hasNext() == false) goto L118;
        X2((paa.e) r168.next(), false, SkillSelectSource.INVALIDATED);
        goto L115
    L118:
        if (this.f392562n.isEmpty() == true) goto L124;
        L2();
        List<paa.e> r169 = this.f392565q;
        Iterator<T> r170 = this.f392562n.iterator();
    L122:
        if (r170.hasNext() == false) goto L124;
        ((paa.d) r170.next()).a(r169);
    L124:
        U2(r100);
    }

    @Override // paa.c
    public final boolean Zu(String r100) {
        Intrinsics.checkNotNullParameter(r100, "skillId");
        L2();
        List<paa.e> r101 = p3();
        String r102 = P2(r100);
        if (r102 != null) goto L5;
        return false;
    L5:
        boolean r103 = this.f392557i.remove(r102);
        if (this.f392558j.contains(r102) == true) goto L8;
        boolean r104 = false;
    L10:
        if (this.f392556h.remove(r102) == false) goto L16;
        paa.e r105 = m3(r102);
        if (r105 == null) goto L14;
        X2(r105, false, SkillSelectSource.MENTION);
    L14:
        U2(r101);
        return true;
    L16:
        if (r103 == false) goto L20;
        paa.e r106 = m3(r102);
        if (r106 == null) goto L20;
        X2(r106, false, SkillSelectSource.MENTION);
    L20:
        U2(r101);
        if (r103 == true) goto L23;
        if (r104 == true) goto L23;
        return false;
    L23:
        return true;
    L8:
        this.f392558j.remove(r102);
        r104 = true;
        goto L10
    }

    @Override // paa.c
    public final void hJ(com.obric.assistant.chat.component.bottom.core.mention.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f392562n.remove(r100);
    }

    @Override // paa.c
    public final void hM(paa.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f392560l.add(r100);
    }

    @Override // paa.c
    public final void lR(c7 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f392561m.add(r100);
    }

    public final paa.e m3(String r100) {
        L2();
        String r101 = P2(r100);
        Object r102 = null;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r101, "all_skills") == false) goto L14;
        Iterator<T> r103 = this.f392568t.iterator();
    L9:
        if (r103.hasNext() == false) goto L21;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((paa.e) r104).f528396a, r101) == false) goto L9;
        r102 = r104;
    L21:
        return (paa.e) r102;
    L14:
        paa.e r105 = GJ(r101);
        if (r105 == null) goto L17;
        return r105;
    L17:
        return this.f392559k.get(r101);
    }

    @Override // paa.c
    public final void nz(com.obric.assistant.chat.component.bottom.core.mention.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f392562n.add(r100);
    }

    @Override // paa.c
    public final void p70(paa.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f392560l.remove(r100);
    }

    @Override // paa.c
    public final void x70(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "skillIds");
        L2();
        List<paa.e> r100 = p3();
        List<paa.e> r101 = this.f392567s;
        HashSet r102 = new HashSet();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(((paa.e) r103.next()).f528396a);
        goto L4
    L6:
        ArrayList r104 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L7:
        boolean r105 = true;
        if (r111.hasNext() == false) goto L19;
        Object r106 = r111.next();
        String r107 = (String) r106;
        if (Intrinsics.areEqual(r107, "all_skills") == false) goto L12;
    L16:
        r105 = false;
    L17:
        if (r105 == false) goto L7;
        r104.add(r106);
        goto L7
    L12:
        if (r102.contains(r107) == true) goto L17;
        if (m3(r107) == null) goto L16;
    L19:
        LinkedHashSet r112 = new LinkedHashSet(r104);
        ArrayList r108 = new ArrayList();
        Iterator r109 = r112.iterator();
    L21:
        if (r109.hasNext() == false) goto L31;
        Object r113 = r109.next();
        String r114 = (String) r113;
        if (r102.contains(r114) == true) goto L25;
    L28:
        boolean r115 = true;
    L29:
        if (r115 == false) goto L21;
        r108.add(r113);
        goto L21
    L25:
        if (this.f392558j.contains(r114) == true) goto L28;
        r115 = false;
        goto L29
    L31:
        Set r116 = CollectionsKt.toSet(this.f392556h);
        this.f392556h.clear();
        this.f392556h.addAll(r112);
        z3(r108);
        Set r117 = SetsKt.minus(r116, r112);
        ArrayList r118 = new ArrayList();
        Iterator r119 = r117.iterator();
    L33:
        if (r119.hasNext() == false) goto L37;
        paa.e r120 = m3((String) r119.next());
        if (r120 == null) goto L33;
        r118.add(r120);
        goto L33
    L37:
        Iterator r121 = r118.iterator();
    L39:
        if (r121.hasNext() == false) goto L41;
        X2((paa.e) r121.next(), false, SkillSelectSource.DRAFT);
        goto L39
    L41:
        Set r122 = SetsKt.minus(r112, r116);
        ArrayList r123 = new ArrayList();
        Iterator r124 = r122.iterator();
    L43:
        if (r124.hasNext() == false) goto L47;
        paa.e r125 = m3((String) r124.next());
        if (r125 == null) goto L43;
        r123.add(r125);
        goto L43
    L47:
        Iterator r126 = r123.iterator();
    L49:
        if (r126.hasNext() == false) goto L51;
        X2((paa.e) r126.next(), true, SkillSelectSource.DRAFT);
        goto L49
    L51:
        U2(r100);
    }

    public final boolean z3(Collection<String> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = P2((String) r102.next());
        if (r103 == null) goto L4;
        r101.add(r103);
        goto L4
    L8:
        List r104 = CollectionsKt.distinct(r101);
        ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L9:
        boolean r107 = true;
        if (r106.hasNext() == false) goto L20;
        Object r108 = r106.next();
        String r109 = (String) r108;
        if (Intrinsics.areEqual(r109, "all_skills") == false) goto L14;
    L16:
        r107 = false;
    L17:
        if (r107 == false) goto L9;
        r105.add(r108);
        goto L9
    L14:
        if (m3(r109) == null) goto L16;
    L20:
        if (Intrinsics.areEqual(CollectionsKt.toList(this.f392558j), r105) == false) goto L22;
        return false;
    L22:
        this.f392558j.clear();
        this.f392558j.addAll(r105);
        return true;
    }

    @Override // paa.c
    public final boolean YW(String r100, SkillSelectSource r101) {
        Intrinsics.checkNotNullParameter(r100, "skillId");
        Intrinsics.checkNotNullParameter(r101, "source");
        L2();
        List<paa.e> r102 = p3();
        String r103 = P2(r100);
        if (r103 != null) goto L6;
        return false;
    L6:
        if (r101 != SkillSelectSource.ROUTE_USE) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        paa.e r105 = m3(r103);
    L15:
        if (r105 != null) goto L17;
    L24:
        return false;
    L17:
        if (Intrinsics.areEqual(r103, "all_skills") == true) goto L24;
        boolean r106 = this.f392557i.add(r103);
        if (r106 == false) goto L22;
        X2(r105, true, r101);
    L22:
        U2(r102);
        return r106;
    L14:
        r105 = GJ(r103);
        goto L15
    L8:
        if (r101 == SkillSelectSource.ROUTE_DEMO) goto L11;
        r104 = false;
        goto L12
    }

    public final boolean h3(String r100, SkillSelectSource r101) {
        String r102 = P2(r100);
        if (r102 != null) goto L5;
        return false;
    L5:
        paa.e r103 = this.f392559k.get(r102);
        if (r103 != null) goto L8;
        return false;
    L8:
        List<paa.e> r104 = p3();
        this.f392559k.remove(r102);
        boolean r105 = this.f392556h.remove(r102);
        boolean r106 = this.f392557i.remove(r102);
        this.f392558j.remove(r102);
        if (r105 == true) goto L11;
        if (r106 == true) goto L11;
    L12:
        U2(r104);
        return true;
    L11:
        X2(r103, false, r101);
        goto L12
    }

    @Override // paa.c
    public final boolean hZ(paa.e r110, SkillSelectSource r111) {
        Intrinsics.checkNotNullParameter(r110, SlashMentionConfig.SLASH_CONTENT_SKILL);
        Intrinsics.checkNotNullParameter(r111, "source");
        L2();
        if (r111 != SkillSelectSource.ROUTE_USE) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        return false;
    L11:
        String r101 = P2(r110.f528396a);
        if (r101 != null) goto L14;
        return false;
    L14:
        String r102 = StringsKt.trim(r110.f528397b).toString();
        if ((!StringsKt.isBlank(r102)) == true) goto L18;
        r102 = null;
    L18:
        String r103 = r102;
        if (r103 != null) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(r101, "all_skills") == false) goto L24;
        return false;
    L24:
        List<paa.e> r112 = p3();
        paa.e r113 = GJ(r101);
        if (r113 != null) goto L27;
        String r104 = r110.f528398c;
        Long r105 = r110.f528399d;
        Long r106 = r110.f528400e;
        Long r107 = r110.f528401f;
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r103, "name");
        paa.e r114 = new paa.e(r101, r103, r104, r105, r106, r107);
    L28:
        paa.e r108 = this.f392559k.get(r101);
        if (r113 != null) goto L31;
        this.f392559k.put(r101, r114);
    L31:
        boolean r109 = this.f392556h.add(r101);
        List r115 = CollectionsKt.createListBuilder(this.f392558j.size() + 1);
        r115.add(r101);
        Iterator<T> r116 = this.f392558j.iterator();
    L33:
        if (r116.hasNext() == false) goto L37;
        Object r117 = r116.next();
        if ((!Intrinsics.areEqual((String) r117, r101)) == false) goto L33;
        r115.add(r117);
        goto L33
    L37:
        boolean r118 = z3(CollectionsKt.build(r115));
        if (r113 == null) goto L40;
    L42:
        boolean r119 = false;
    L43:
        if (r109 == true) goto L45;
        if (r119 == true) goto L45;
    L46:
        U2(r112);
        if (r109 == true) goto L50;
        if (r118 == true) goto L50;
        if (r119 == true) goto L50;
        return false;
    L50:
        return true;
    L45:
        X2(r114, true, r111);
        goto L46
    L40:
        if (Intrinsics.areEqual(r108, r114) == true) goto L42;
        r119 = true;
        goto L43
    L27:
        r114 = r113;
        goto L28
    L5:
        if (r111 == SkillSelectSource.ROUTE_DEMO) goto L8;
        r100 = false;
        goto L9
    }

    public final void X2(paa.e r100, boolean r101, SkillSelectSource r102) {
        Iterator<T> r103 = this.f392560l.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((paa.f) r103.next()).a(r100, r101, r102);
        goto L4
    }

    @Override // paa.c
    public final void pU(String r210, String r211, Map<String, String> r212) {
        Intrinsics.checkNotNullParameter(r210, "conversationId");
        Intrinsics.checkNotNullParameter(r211, "content");
        Intrinsics.checkNotNullParameter(r212, "extra");
        List<paa.e> r100 = Nh();
        String r101 = null;
        if ((!((ArrayList) r100).isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L39;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r103 = r100.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r102.add(((paa.e) r103.next()).f528396a);
        goto L9
    L11:
        r212.put("o_omni_init_skill_ids", new JSONArray(r102).toString());
        r212.put("o_omni_skill_final_query", MG(r211));
        IAIChatRenderTraceService.Companion r104 = IAIChatRenderTraceService.f365896a;
        LinkedHashMap r105 = new LinkedHashMap();
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r107 = r100.iterator();
    L13:
        if (r107.hasNext() == false) goto L15;
        r106.add(((paa.e) r107.next()).f528396a);
        goto L13
    L15:
        ArrayList r110 = new ArrayList();
        Iterator r108 = r106.iterator();
    L17:
        if (r108.hasNext() == false) goto L21;
        Object r109 = r108.next();
        if ((!StringsKt.isBlank((String) r109)) == false) goto L17;
        r110.add(r109);
        goto L17
    L21:
        String r111 = CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r111)) == true) goto L25;
        r111 = null;
    L25:
        r105.put("obric_omni_skill_ids", String.valueOf(r111));
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r113 = r100.iterator();
    L27:
        if (r113.hasNext() == false) goto L29;
        r112.add(((paa.e) r113.next()).f528397b);
        goto L27
    L29:
        ArrayList r114 = new ArrayList();
        Iterator r115 = r112.iterator();
    L31:
        if (r115.hasNext() == false) goto L35;
        Object r116 = r115.next();
        if ((!StringsKt.isBlank((String) r116)) == false) goto L31;
        r114.add(r116);
        goto L31
    L35:
        String r117 = CollectionsKt.joinToString$default(r114, ",", null, null, 0, null, null, 62, null);
        if ((!StringsKt.isBlank(r117)) == false) goto L38;
        r101 = r117;
    L38:
        r105.put("obric_omni_skill_names", String.valueOf(r101));
        Unit r118 = Unit.INSTANCE;
        r104.e(r210, r105);
        CZ();
    L39:
        L2();
        List r119 = CollectionsKt.toList(this.f392559k.keySet());
        if (r119.isEmpty() == true) goto L94;
        List<paa.e> r120 = p3();
        List r121 = r119;
        Set r122 = CollectionsKt.toSet(r121);
        ArrayList r123 = new ArrayList();
        Iterator r124 = r121.iterator();
    L44:
        if (r124.hasNext() == false) goto L48;
        paa.e r125 = m3((String) r124.next());
        if (r125 == null) goto L44;
        r123.add(r125);
        goto L44
    L48:
        HashSet r126 = new HashSet();
        ArrayList r127 = new ArrayList();
        Iterator r128 = r123.iterator();
    L50:
        if (r128.hasNext() == false) goto L54;
        Object r129 = r128.next();
        if (r126.add(((paa.e) r129).f528396a) == false) goto L50;
        r127.add(r129);
        goto L50
    L54:
        Set r130 = r122;
        boolean r131 = this.f392556h.removeAll(r130);
        boolean r132 = this.f392557i.removeAll(r130);
        boolean r133 = this.f392558j.removeAll(r130);
        this.f392559k.clear();
        if (r131 == true) goto L57;
        if (r132 == true) goto L57;
    L61:
        U2(r120);
        if (r131 == true) goto L91;
        if (r132 == true) goto L92;
        if (r133 == true) goto L93;
        r119.isEmpty();
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L57:
        Iterator r134 = r127.iterator();
    L59:
        if (r134.hasNext() == false) goto L61;
        X2((paa.e) r134.next(), false, SkillSelectSource.MENTION);
        goto L59
    }
}
