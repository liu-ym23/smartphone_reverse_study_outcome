package com.ss.android.lark.reaction.service.impl;

import android.os.SystemClock;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.PushEmojiPanel;
import com.bytedance.lark.pb.im.v1.PushUserMRUReactions;
import com.bytedance.lark.pb.im.v1.UpdateUserReactionSkinRequest;
import com.bytedance.lark.pb.im.v1.UpdateUserReactionSkinResponse;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import jdb.g;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@UserScope
public final class ReactionOrderService2 extends c0c.c implements m2c.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f439158s = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f439159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rsb.b f439160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rsb.a f439161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m2c.b f439162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f439163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String[] f439164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f439165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DefaultEmojiPanelData f439166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<String> f439167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f439168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f439169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile FetchEmojiPanelState f439170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f439171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<m2c.c> f439172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f439173p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f439174q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f439175r;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/reaction/service/impl/ReactionOrderService2$FetchEmojiPanelState;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "LOADING", "SUCCESS", "reaction-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FetchEmojiPanelState extends Enum<FetchEmojiPanelState> {
        public static final FetchEmojiPanelState INIT = null;
        public static final FetchEmojiPanelState LOADING = null;
        public static final FetchEmojiPanelState SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FetchEmojiPanelState[] f439176a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f439177b = null;

        public static EnumEntries<FetchEmojiPanelState> getEntries() {
            return f439177b;
        }

        static {
            FetchEmojiPanelState r100 = new FetchEmojiPanelState(ErrorCode.INIT, 0);
            INIT = r100;
            FetchEmojiPanelState r101 = new FetchEmojiPanelState("LOADING", 1);
            LOADING = r101;
            FetchEmojiPanelState r102 = new FetchEmojiPanelState("SUCCESS", 2);
            SUCCESS = r102;
            FetchEmojiPanelState[] r103 = {r100, r101, r102};
            f439176a = r103;
            f439177b = EnumEntriesKt.enumEntries(r103);
        }

        public static FetchEmojiPanelState[] values() {
            return (FetchEmojiPanelState[]) f439176a.clone();
        }

        public static FetchEmojiPanelState valueOf(String r100) {
            return (FetchEmojiPanelState) r27.a.a(FetchEmojiPanelState.class, r100);
        }

        public FetchEmojiPanelState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReactionOrderService2 f439178a;

        public b(ReactionOrderService2 r100) {
            this.f439178a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ReactionOrderService2.m(this.f439178a, true);     // Catch: Throwable -> L6
            if (this.f439178a.u() == false) goto L9;
            ReactionOrderService2.m(this.f439178a, false);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements zob.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReactionOrderService2 f439179a;

        public c(ReactionOrderService2 r100) {
            this.f439179a = r100;
        }

        @Override // zob.b
        public final void a(Locale r100, Locale r101) {
            Log.i("ReactionOrderService2", "onLanguageChange, from " + wsb.c.a(r100) + " to " + wsb.c.a(r101));
            this.f439179a.x();
            this.f439179a.fetchData();
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReactionOrderService2 f439180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f439181b;

        public d(ReactionOrderService2 r100, boolean r101) {
            this.f439180a = r100;
            this.f439181b = r101;
        }

        public final void a() {
            List<String> r100 = this.f439180a.f439162e.N(this.f439181b);
            StringBuilder r101 = new StringBuilder("syncMRUReactionList, isFromLocal: ");
            r101.append(this.f439181b);
            r101.append(", result: ");
            if (CollectionUtils.isEmpty(r100) == false) goto L5;
            Object r102 = "[]";
        L6:
            r101.append(r102);
            Log.i("ReactionOrderService2", r101.toString());
            ReactionOrderService2.p(this.f439180a, r100);
            return;
        L5:
            r102 = r100;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated, delete please")
    public final void I2() {
    }

    @Override // m2c.a
    public final synchronized List<String> U2() {
        monitor-enter(this);
        r();     // Catch: Throwable -> L6
        List<String> r100 = this.f439166i.b();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // m2c.a
    public final synchronized DefaultEmojiPanelData a() {
        monitor-enter(this);
        r();     // Catch: Throwable -> L6
        DefaultEmojiPanelData r100 = this.f439166i;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated, delete please", replaceWith = @ReplaceWith(expression = "nothing", imports = {}))
    public final List<String> f() {
        monitor-enter(this);
        List<String> r100 = CollectionsKt.emptyList();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // m2c.a
    public final synchronized List<String> h() {
        monitor-enter(this);
        ArrayList r100 = new ArrayList(this.f439167j);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // c0c.c
    public final void c() {
        Log.i("ReactionOrderService2", MapMonitorConst.EVENT_DESTROY);
        yob.e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        com.ss.android.lark.language.service.impl.a.b.f431098a.k(this.f439173p);
        Disposable r101 = this.f439174q;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f439174q = null;
        Disposable r102 = this.f439175r;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        this.f439175r = null;
    }

    @Override // c0c.c
    public final void e() {
        Log.i("ReactionOrderService2", "onPrepared");
        yob.e.a().getClass();
        int r100 = com.ss.android.lark.language.service.impl.a.f431092f;
        com.ss.android.lark.language.service.impl.a.b.f431098a.c(this.f439173p);
        Disposable r101 = this.f439174q;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f439174q = this.f439159b.i(Command.PUSH_EMOJI_PANEL, PushEmojiPanel.ADAPTER).subscribe(new com.ss.android.lark.reaction.service.impl.b(this), com.ss.android.lark.reaction.service.impl.c.f439184a);
        Disposable r102 = this.f439175r;
        if (r102 == null) goto L8;
        r102.dispose();
    L8:
        this.f439175r = this.f439159b.i(Command.PUSH_USER_MRU_REACTIONS, PushUserMRUReactions.ADAPTER).subscribe(new com.ss.android.lark.reaction.service.impl.d(this), e.f439186a);
        fetchData();
    }

    @Override // m2c.a
    public final void fetchData() {
        Log.i("ReactionOrderService2", "fetchData");
        r();
        Log.i("ReactionOrderService2", "initMRUReactionList");
        md(true);
        md(false);
    }

    public final void r() {
        if (this.f439170m != FetchEmojiPanelState.INIT) goto L6;
        this.f439170m = FetchEmojiPanelState.LOADING;
        Log.i("ReactionOrderService2", "fetchEmojiPanelData, disablePullOptimization: " + u());
        ((ExecutorService) this.f439165h.getValue()).execute(new b(this));
        return;
    }

    public final boolean u() {
        return ((Boolean) this.f439171n.getValue()).booleanValue();
    }

    public final void x() {
        this.f439170m = FetchEmojiPanelState.INIT;
        this.f439166i = new DefaultEmojiPanelData();
        DefaultEmojiPanelData.a r100 = new DefaultEmojiPanelData.a();
        DefaultEmojiPanelData.Type r101 = DefaultEmojiPanelData.Type.DEFAULT;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r100.f432958a = r101;
        ArrayList r102 = new ArrayList();
        String[] r103 = this.f439164g;
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        String r106 = r103[r105];
        r102.add(new Pair(r106, r106));
        r105 = r105 + 1;
        goto L3
    L5:
        r100.c(r102);
        DefaultEmojiPanelData r107 = this.f439166i;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r100, "group");
        ((ArrayList) r107.f432955a).add(r100);
    }

    @Override // m2c.a
    @Deprecated(message = "Deprecated, delete please", replaceWith = @ReplaceWith(expression = "nothing", imports = {}))
    public final List<String> o() {
        return CollectionsKt.emptyList();
    }

    @Override // m2c.a
    public final List<String> N(boolean r100) {
        if (r100 == false) goto L4;
        List<String> r101 = CollectionsKt.toMutableList(h());
        Iterator<String> r102 = U2().iterator();
        String r103 = null;
        String r104 = null;
    L7:
        if (r102.hasNext() == false) goto L19;
        String r105 = r102.next();
        if (r103 != null) goto L13;
        Set<String> r106 = wsb.b.f561114a;
        Intrinsics.checkNotNullParameter(r105, "reactionKey");
        if (wsb.b.f561114a.contains(r105) == false) goto L13;
        r103 = r105;
    L13:
        if (r104 != null) goto L17;
        Set<String> r107 = wsb.b.f561114a;
        Intrinsics.checkNotNullParameter(r105, "reactionKey");
        if (wsb.b.f561115b.contains(r105) == false) goto L17;
        r104 = r105;
    L17:
        if (r103 == null) goto L7;
        if (r104 == null) goto L7;
    L19:
        if (r103 != null) goto L21;
        r103 = "THUMBSUP";
    L21:
        if (r104 != null) goto L23;
        r104 = "ThumbsDown";
    L23:
        r101.remove(r103);
        r101.remove(r104);
        ListProtector.add(r101, 0, r104);
        ListProtector.add(r101, 0, r103);
        return r101;
    L4:
        return h();
    }

    @Override // m2c.a
    public final synchronized boolean j5(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "emojiKey");     // Catch: Throwable -> L17
        if (this.f439169l == this.f439166i.hashCode()) goto L6;
    L7:
        this.f439168k = this.f439166i.a();     // Catch: Throwable -> L17
        this.f439169l = this.f439166i.hashCode();     // Catch: Throwable -> L17
    L8:
        List<String> r101 = this.f439168k;     // Catch: Throwable -> L17
        if (r101 == null) goto L14;
        boolean r102 = r101.contains(r100);     // Catch: Throwable -> L17
        boolean r103 = true;
        if (r102 != true) goto L14;
    L15:
        monitor-exit(this);
        return r103;
    L14:
        r103 = false;
        goto L15
    L6:
        if (this.f439168k != null) goto L8;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // m2c.a
    public final void md(boolean r100) {
        ((ExecutorService) this.f439165h.getValue()).execute(new d(this, r100));
    }

    @Override // m2c.a
    public final void q8(m2c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<m2c.c> r101 = this.f439172o;
        monitor-enter(r101);
        ((ArrayList) this.f439172o).remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void s(List<String> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        Iterator<String> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next();
        if (this.f439161d.i7(r102) == false) goto L7;
        r101.remove();
        goto L7
    }

    @Override // m2c.a
    public final void v2(m2c.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        List<m2c.c> r101 = this.f439172o;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (((ArrayList) this.f439172o).contains(r100) == true) goto L7;
        ((ArrayList) this.f439172o).add(r100);     // Catch: Throwable -> L10
    L7:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.ss.android.lark.reaction.service.impl.ReactionOrderService2$fetchEmojiPanelData$2] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void m(final ReactionOrderService2 r100, final boolean r101) {
        r100.getClass();
        Log.i("ReactionOrderService2", "fetchEmojiPanelData start, isFromLocal: " + r101);
        final long r102 = SystemClock.elapsedRealtime();
        r100.f439162e.o7(r101, new ReactionOrderService2$fetchEmojiPanelData$2(r101, r102, r100));
    }

    public static final void n(ReactionOrderService2 r100, DefaultEmojiPanelData r101) {
        List<m2c.c> r102 = r100.f439172o;
        monitor-enter(r102);
        Iterator r103 = ((ArrayList) r100.f439172o).iterator();     // Catch: Throwable -> L11
    L6:
        if (r103.hasNext() == false) goto L8;
        ((m2c.c) r103.next()).a();     // Catch: Throwable -> L11
        goto L6
    L8:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static final void p(ReactionOrderService2 r100, List r101) {
        r100.getClass();
        List r102 = r101;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L21;
        List<String> r104 = r100.f439167j;
        monitor-enter(r104);
        ((ArrayList) r100.f439167j).clear();     // Catch: Throwable -> L16
        ArrayList r105 = (ArrayList) r100.f439167j;     // Catch: Throwable -> L16
        r105.addAll(r101);     // Catch: Throwable -> L16
        r100.s(r100.f439167j);     // Catch: Throwable -> L16
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r104);
        return;
    L16:
        th = move-exception;
        throw th;
    L21:
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // m2c.a
    public final void Wc(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "staticKey");
        Intrinsics.checkNotNullParameter(r111, "skinedKey");
        Log.i("ReactionOrderService2", "updateEmojiSkinedReactionKey, staticKey: " + r110 + ", skined key: " + r111);
        UpdateUserReactionSkinRequest.Builder r100 = new UpdateUserReactionSkinRequest.Builder().reaction_to_skin_key(Collections.singletonMap(r110, r111));
        l r101 = this.f439159b;
        Intrinsics.checkNotNull(r100);
        t.a(r101.h(new com.bytedance.lark.rustclient.api.d(r100, UpdateUserReactionSkinResponse.ADAPTER, Command.UPDATE_USER_REACTION_SKIN, null, null, null, null, 248)).a(), ReactionOrderService2$updateEmojiSkinedReactionKey$1.INSTANCE, ReactionOrderService2$updateEmojiSkinedReactionKey$2.INSTANCE, ReactionOrderService2$updateEmojiSkinedReactionKey$3.INSTANCE);
        com.ss.android.lark.newemoji.larkemoji.c.f(r110, r111);
        com.ss.android.lark.newemoji.larkemoji.c.b();
    }

    @Inject
    public ReactionOrderService2(m r147, l r148, rsb.b r149, rsb.a r150, m2c.b r151, g r152) {
        Intrinsics.checkNotNullParameter(r147, "passport");
        Intrinsics.checkNotNullParameter(r148, "rustClient");
        Intrinsics.checkNotNullParameter(r149, "emojiService");
        Intrinsics.checkNotNullParameter(r150, "emojiMapManager");
        Intrinsics.checkNotNullParameter(r151, "reactionService");
        Intrinsics.checkNotNullParameter(r152, "userFeatureGatingService");
        super(r147);
        this.f439159b = r148;
        this.f439160c = r149;
        this.f439161d = r150;
        this.f439162e = r151;
        this.f439163f = r152;
        String[] r100 = {"OK", "FACEPALM", "LOL", "Get", "GLANCE", "CRY", "SOB", "FINGERHEART", "THUMBSUP", "Yes", "FISTBUMP", "JIAYI", "DONE", "LOVE", "YouAreTheBest", "LAUGH", "THANKS", "FullMoonFace"};
        this.f439164g = new String[]{"OK", "THUMBSUP", "THANKS", "MUSCLE", "FINGERHEART", "APPLAUSE", "FISTBUMP", "JIAYI", "DONE", "SMILE", "BLUSH", "LAUGH", "SMIRK", "LOL", "FACEPALM", "LOVE", "WINK", "PROUD", "WITTY", "SMART", "SCOWL", "THINKING", "SOB", "CRY", "ERROR", "NOSEPICK", "HAUGHTY", "SLAP", "SPITBLOOD", "TOASTED", "BLACKFACE", "GLANCE", "DULL", "ROSE", "HEART", "PARTY", "INNOCENTSMILE", "SHY", "CHUCKLE", "JOYFUL", "WOW", "TRICK", "YEAH", "ENOUGH", "TEARS", "EMBARRASSED", "KISS", "SMOOCH", "DROOL", "OBSESSED", "MONEY", "TEASE", "SHOWOFF", "COMFORT", "CLAP", "PRAISE", "STRIVE", "XBLUSH", "SILENT", "WAVE", "EATING", "WHAT", "FROWN", "DULLSTARE", "DIZZY", "LOOKDOWN", "WAIL", "CRAZY", "WHIMPER", "HUG", "BLUBBER", "WRONGED", "HUSKY", "SHHH", "SMUG", "ANGRY", "HAMMER", "SHOCKED", "TERROR", "PETRIFIED", "SKULL", "SWEAT", "SPEECHLESS", "SLEEP", "DROWSY", "YAWN", "SICK", "PUKE", "BIGKISS", "BETRAYED", "HEADSET", "DONNOTGO", "EatingFood", "Typing", "Lemon", "Get", "LGTM", "SALUTE", "SHAKE", "HIGHFIVE", "UPPERLEFT", "ThumbsDown", "SLIGHT", "TONGUE", "EYESCLOSED", "BEAR", "BULL", "CALF", "LIPS", "BEER", "CAKE", "GIFT", "CUCUMBER", "Drumstick", "Pepper", "CANDIEDHAWS", "BubbleTea", "Coffee", "Yes", "No", "OKR", "CheckMark", "CrossMark", "MinusOne", "Hundred", "2021", "AWESOMEN", WikiFolderPushPlugin.PIN, "Alarm", "Loudspeaker", "Trophy", "Fire", "RAINBOWPUKE", "Music", "FIREWORKS", "REDPACKET", "FORTUNE", "LUCK", "FIRECRACKER", "HEARTBROKEN", "BOMB", "POOP", "18X", "CLEAVER"};
        this.f439165h = LazyKt.lazy(ReactionOrderService2$threadPool$2.INSTANCE);
        this.f439166i = new DefaultEmojiPanelData();
        ArrayList r101 = new ArrayList();
        this.f439167j = r101;
        this.f439170m = FetchEmojiPanelState.INIT;
        this.f439171n = LazyKt.lazy(new ReactionOrderService2$disablePullOptimization$2(this));
        this.f439172o = new ArrayList();
        this.f439173p = new c(this);
        Log.i("ReactionOrderService2", "init");
        x();
        monitor-enter(r101);
        r101.clear();     // Catch: Throwable -> L8
        r101.addAll(CollectionsKt.listOf(Arrays.copyOf(r100, r100.length)));     // Catch: Throwable -> L8
        s(r101);     // Catch: Throwable -> L8
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r101);
        s.a(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
