package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import android.text.SpannableStringBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes36.dex */
public final class UserSearchAndMatchStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f430309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f430310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<ChatChatter, String> f430311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function4<String, String, String, Boolean, ccb.d> f430312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<String, String, ChatChatter> f430313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<String, String, Boolean> f430314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MatchMode f430315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f430316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f430317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f430318j;

    public abstract class BaseSearchStrategy implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f430319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile ChatChatter f430320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile SearchStatus f430321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Deferred<Unit>> f430322d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Deferred<? extends Deferred<Unit>> f430323e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ UserSearchAndMatchStrategy f430324f;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public Object a(Continuation<? super Unit> r100) {
            return e(this, r100);
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public boolean b() {
            if (this.f430320b == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public boolean d() {
            if (this.f430321c != SearchStatus.NET_SEARCH_FINISH) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public ChatChatter c() {
            return this.f430320b;
        }

        public BaseSearchStrategy(UserSearchAndMatchStrategy r100, c r101) {
            Intrinsics.checkNotNullParameter(r101, "searchParams");
            this.f430324f = r100;
            this.f430319a = r101;
            this.f430321c = SearchStatus.NOT_SEARCH;
            this.f430322d = new ArrayList();
        }

        public static Object e(BaseSearchStrategy r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1) == false) goto L7;
            UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1 r102 = (UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L20;
            if (r106 == 1) goto L17;
            if (r106 != 2) goto L16;
            r100 = (BaseSearchStrategy) r102.L$0;
            ResultKt.throwOnFailure(r104);     // Catch: Exception -> L35
        L33:
            Log.i(r100.f430324f.f430317i, "[awaitFinish]end requestId:" + r100.f430319a.f430340d);     // Catch: Exception -> L35
        L38:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            r100 = (BaseSearchStrategy) r102.L$0;
            ResultKt.throwOnFailure(r104);     // Catch: Exception -> L35
        L28:
            Deferred r107 = (Deferred) r104;     // Catch: Exception -> L35
        L29:
            Log.i(r100.f430324f.f430317i, "[awaitFinish]wait execute end");     // Catch: Exception -> L35
        L30:
            List<Deferred<Unit>> r108 = r100.f430322d;     // Catch: Exception -> L35
            r102.L$0 = r100;     // Catch: Exception -> L35
            r102.label = 2;     // Catch: Exception -> L35
            if (AwaitKt.a(r108, r102) != r105) goto L33;
            return r105;
        L20:
            ResultKt.throwOnFailure(r104);
            Log.i(r100.f430324f.f430317i, "[awaitFinish]start requestId:" + r100.f430319a.f430340d + " deferred size:" + ((ArrayList) r100.f430322d).size());     // Catch: Exception -> L35
            if (((ArrayList) r100.f430322d).isEmpty() == false) goto L30;
            Log.i(r100.f430324f.f430317i, "[awaitFinish]wait execute start");     // Catch: Exception -> L35
            Deferred<? extends Deferred<Unit>> r109 = r100.f430323e;     // Catch: Exception -> L35
            if (r109 == null) goto L29;
            r102.L$0 = r100;     // Catch: Exception -> L35
            r102.label = 1;     // Catch: Exception -> L35
            r104 = r109.await(r102);     // Catch: Exception -> L35
            if (r104 != r105) goto L28;
            return r105;
        L35:
            e = move-exception;
            Log.e(r100.f430324f.f430317i, "[awaitFinish]error", e);
        L7:
            r102 = new UserSearchAndMatchStrategy$BaseSearchStrategy$awaitFinish$1(r100, r101);
            goto L8
        }
    }

    public final class ClientSearchStrategy extends BaseSearchStrategy {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c f430325g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f430326h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ UserSearchAndMatchStrategy f430327i;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final void startSearch() {
            c r100 = this.f430325g;
            this.f430323e = BuildersKt.async$default(this.f430327i.f430309a, Dispatchers.getIO(), null, new UserSearchAndMatchStrategy$ClientSearchStrategy$startSearch$1$1(this, r100, null), 2, null);
        }

        public ClientSearchStrategy(UserSearchAndMatchStrategy r100, c r101) {
            Intrinsics.checkNotNullParameter(r101, "searchParams");
            this.f430327i = r100;
            super(r100, r101);
            this.f430325g = r101;
            this.f430326h = "ClientSearchStrategy";
        }

        public final void f(ccb.d r100, boolean r101) {
            if ((!((ArrayList) r100.f23346b).isEmpty()) == false) goto L6;
            Log.i(this.f430326h, "[mathUser]inChatUsers searchKey:" + this.f430325g.f430337a.length() + " userId:" + ((ChatChatter) ListProtector.get(r100.f23346b, 0)).getId() + " fromServer:" + r101);
            ChatChatter r102 = (ChatChatter) ListProtector.get(r100.f23346b, 0);
            r102.setOutChatUser(false);
        L9:
            if (r102 != null) goto L11;
            return;
        L11:
            if (r102.isBot() == false) goto L14;
            Log.i(this.f430326h, "[mathUser]searchKey:" + this.f430325g.f430337a.length() + " userId:" + r102.getId() + " is bot");
            return;
        L14:
            if (r101 == false) goto L17;
            this.f430320b = r102;
            return;
        L17:
            if (this.f430320b != null) goto L22;
            this.f430320b = r102;
            return;
        L22:
            return;
        L6:
            if ((!((ArrayList) r100.f23347c).isEmpty()) == false) goto L8;
            Log.i(this.f430326h, "[mathUser]outChatUsers searchKey:" + this.f430325g.f430337a.length() + "  userId:" + ((ChatChatter) ListProtector.get(r100.f23347c, 0)).getId() + " fromServer:" + r101);
            r102 = (ChatChatter) ListProtector.get(r100.f23347c, 0);
            r102.setOutChatUser(this.f430327i.f430316h ^ true);
            goto L9
        L8:
            Log.e(this.f430326h, "[mathUser]searchKey:" + this.f430325g.f430337a.length() + " userId is empty fromServer:" + r101);
            r102 = null;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/UserSearchAndMatchStrategy$SearchStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_SEARCH", "LOCAL_SEARCH_FINISH", "NET_SEARCH_FINISH", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SearchStatus extends Enum<SearchStatus> {
        public static final SearchStatus LOCAL_SEARCH_FINISH = null;
        public static final SearchStatus NET_SEARCH_FINISH = null;
        public static final SearchStatus NOT_SEARCH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SearchStatus[] f430328a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f430329b = null;

        public static EnumEntries<SearchStatus> getEntries() {
            return f430329b;
        }

        static {
            SearchStatus r100 = new SearchStatus("NOT_SEARCH", 0);
            NOT_SEARCH = r100;
            SearchStatus r101 = new SearchStatus("LOCAL_SEARCH_FINISH", 1);
            LOCAL_SEARCH_FINISH = r101;
            SearchStatus r102 = new SearchStatus("NET_SEARCH_FINISH", 2);
            NET_SEARCH_FINISH = r102;
            SearchStatus[] r103 = {r100, r101, r102};
            f430328a = r103;
            f430329b = EnumEntriesKt.enumEntries(r103);
        }

        public static SearchStatus[] values() {
            return (SearchStatus[]) f430328a.clone();
        }

        public static SearchStatus valueOf(String r100) {
            return (SearchStatus) r27.a.a(SearchStatus.class, r100);
        }

        public SearchStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final class ServerSearchStrategy extends BaseSearchStrategy {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c f430330g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f430331h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ UserSearchAndMatchStrategy f430332i;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final void startSearch() {
            String r100 = this.f430330g.f430339c;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L12;
            Log.w(this.f430331h, "[startSearch]userIdFromServer is empty");
            return;
        L12:
            c r102 = this.f430330g;
            String r103 = r102.f430339c;
            UserSearchAndMatchStrategy r104 = this.f430332i;
            this.f430323e = BuildersKt.async$default(r104.f430309a, Dispatchers.getIO(), null, new UserSearchAndMatchStrategy$ServerSearchStrategy$startSearch$1$1(this, r103, r102, r104, null), 2, null);
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }

        public ServerSearchStrategy(UserSearchAndMatchStrategy r100, c r101) {
            Intrinsics.checkNotNullParameter(r101, "searchParams");
            this.f430332i = r100;
            super(r100, r101);
            this.f430330g = r101;
            this.f430331h = "ServerSearchStrategy";
        }
    }

    public interface a {
        Object a(Continuation<? super Unit> r100);

        boolean b();

        ChatChatter c();

        boolean d();

        void startSearch();
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f430333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BaseSearchStrategy f430334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UserSearchAndMatchStrategy f430335c;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f430336a = null;

            static {
                int[] r100 = new int[MatchMode.values().length];
                r100[MatchMode.ClientMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[MatchMode.ServerMode.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[MatchMode.ServerWithClientMode.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f430336a = r100;
            }
        }

        public final synchronized boolean a() {
            monitor-enter(this);
            BaseSearchStrategy r100 = this.f430334b;     // Catch: Throwable -> L10
            if (r100 == null) goto L7;
            boolean r101 = r100.d();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return r101;
        L7:
            r101 = false;
        L10:
            th = move-exception;
            throw th;
        }

        public final synchronized ChatChatter b() {
            monitor-enter(this);
            BaseSearchStrategy r100 = this.f430334b;     // Catch: Throwable -> L10
            if (r100 == null) goto L7;
            ChatChatter r101 = r100.c();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return r101;
        L7:
            r101 = null;
        L10:
            th = move-exception;
            throw th;
        }

        public b(UserSearchAndMatchStrategy r100, c r101) {
            Intrinsics.checkNotNullParameter(r101, "searchParams");
            this.f430335c = r100;
            this.f430333a = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f430337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f430338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f430339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f430340d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f430337a, r101.f430337a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f430338b, r101.f430338b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f430339c, r101.f430339c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f430340d, r101.f430340d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f430337a.hashCode() * 31) + this.f430338b.hashCode()) * 31;
            String r101 = this.f430339c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f430340d.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "SearchParams(searchKey=" + this.f430337a + ", chatId=" + this.f430338b + ", userIdFromServer=" + this.f430339c + ", requestId=" + this.f430340d + ')';
        }

        public c(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "searchKey");
            Intrinsics.checkNotNullParameter(r101, "chatId");
            Intrinsics.checkNotNullParameter(r103, "requestId");
            this.f430337a = r100;
            this.f430338b = r101;
            this.f430339c = r102;
            this.f430340d = r103;
        }
    }

    public final class d extends BaseSearchStrategy {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c f430341g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public BaseSearchStrategy f430342h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f430343i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ UserSearchAndMatchStrategy f430344j;

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.BaseSearchStrategy, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final boolean b() {
            BaseSearchStrategy r100 = this.f430342h;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.b();
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.BaseSearchStrategy, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final ChatChatter c() {
            BaseSearchStrategy r100 = this.f430342h;
            if (r100 != null) goto L7;
            return null;
        L7:
            return r100.c();
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.BaseSearchStrategy, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final boolean d() {
            BaseSearchStrategy r100 = this.f430342h;
            if (r100 != null) goto L7;
            return false;
        L7:
            return r100.d();
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final void startSearch() {
            Log.i(this.f430343i, "[startSearch]userIdFromServer:" + this.f430341g.f430339c);
            String r100 = this.f430341g.f430339c;
            if (r100 != null) goto L5;
        L8:
            boolean r101 = true;
        L9:
            if (r101 == false) goto L11;
            BaseSearchStrategy r102 = new ClientSearchStrategy(this.f430344j, this.f430341g);
        L12:
            r102.startSearch();
            this.f430342h = r102;
            return;
        L11:
            r102 = new ServerSearchStrategy(this.f430344j, this.f430341g);
            goto L12
        L5:
            if (r100.length() == 0) goto L8;
            r101 = false;
            goto L9
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.BaseSearchStrategy, com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.UserSearchAndMatchStrategy.a
        public final Object a(Continuation<? super Unit> r100) {
            BaseSearchStrategy r101 = this.f430342h;
            if (r101 == null) goto L10;
            Object r102 = r101.a(r100);
            if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
            return r102;
        L8:
            return Unit.INSTANCE;
        L10:
            return Unit.INSTANCE;
        }

        public d(UserSearchAndMatchStrategy r100, c r101) {
            Intrinsics.checkNotNullParameter(r101, "searchParams");
            this.f430344j = r100;
            super(r100, r101);
            this.f430341g = r101;
            this.f430343i = "ServerWithClientModeStrategy";
        }
    }

    public final boolean b() {
        Iterator<T> r100 = this.f430318j.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L19;
        b r101 = (b) r100.next();
        String r102 = this.f430317i;
        StringBuilder r103 = new StringBuilder("[hasSearchFinished]searchKey:");
        r103.append(r101.f430333a.f430340d);
        r103.append(" hasResult:");
        monitor-enter(r101);
        BaseSearchStrategy r104 = r101.f430334b;     // Catch: Throwable -> L16
        if (r104 == null) goto L11;
        boolean r105 = r104.b();     // Catch: Throwable -> L16
    L12:
        monitor-exit(r101);
        r103.append(r105);
        r103.append(" hasFinish:");
        r103.append(r101.a());
        Log.i(r102, r103.toString());
        if (r101.a() == true) goto L4;
        return false;
    L11:
        r105 = false;
    L16:
        th = move-exception;
        throw th;
    L19:
        Log.i(this.f430317i, "[hasSearchFinished]ner info.size: " + this.f430318j.size());
        return true;
    }

    public final void c() {
        if ((!this.f430318j.isEmpty()) == false) goto L6;
        Log.i(this.f430317i, "[onSessionEnd]clear searchAndMatchTaskMap");
        this.f430318j.clear();
        return;
    }

    public static String e(com.ss.android.lark.audio.voiceinput.a r100) {
        String r101 = r100.f409201d;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        return r101;
    L11:
        return r100.f409200c;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final void f(com.ss.android.lark.audio.voiceinput.a r100) {
        if (r100 != null) goto L5;
        Log.e(this.f430317i, "[searchUser]asrUserInfo or chatId is null");
        return;
    L5:
        String r101 = e(r100);
        if (this.f430318j.containsKey(r101) == false) goto L9;
        Log.i(this.f430317i, "[searchUser]searchUser task already exist");
        return;
    L9:
        Log.i(this.f430317i, "[searchUser]searchUser ken_len:" + r101.length());
        b r102 = new b(this, new c(r101, this.f430310b, r100.f409204g, com.ss.android.lark.sdk.a.a()));
        this.f430318j.put(r101, r102);
        MatchMode r103 = this.f430315g;
        Intrinsics.checkNotNullParameter(r103, "matchMode");
        Log.i(r102.f430335c.f430317i, "[SearchAndMatchTask]matchMode:" + r103);
        int r104 = b.a.f430336a[r103.ordinal()];
        if (r104 != 1) goto L12;
        BaseSearchStrategy r105 = new ClientSearchStrategy(r102.f430335c, r102.f430333a);
    L20:
        r102.f430334b = r105;
        r105.startSearch();
        return;
    L12:
        if (r104 != 2) goto L14;
        r105 = new ServerSearchStrategy(r102.f430335c, r102.f430333a);
        goto L20
    L14:
        if (r104 != 3) goto L17;
        r105 = new d(r102.f430335c, r102.f430333a);
        goto L20
    L17:
        throw new NoWhenBranchMatchedException();
    }

    public final String d(String r100, int r101, int r102) {
        if (r100 == null) goto L13;
        if (r101 >= r102) goto L13;
        if (r101 >= r100.length()) goto L13;
        return r100.substring(RangesKt.coerceAtLeast(r101, 0), RangesKt.coerceAtMost(r102, r100.length()));
    L11:
        e = move-exception;
        Log.e(this.f430317i, "[safeSubString]subString error", e);
    L13:
        return "";
    }

    public final Pair<RichText, SpannableStringBuilder> a(String r110, List<com.ss.android.lark.audio.voiceinput.a> r111, int r210, Function2<? super String, ? super Integer, ? extends SpannableStringBuilder> r211) {
        ArrayList r100 = new ArrayList();
        List<com.ss.android.lark.audio.voiceinput.a> r101 = r111;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L25;
        SpannableStringBuilder r103 = new SpannableStringBuilder();
        if (r110 != null) goto L14;
        String r104 = "";
    L15:
        int r105 = r104.length();
        if (r210 == (-1)) goto L21;
        if (r210 >= r105) goto L21;
        List<RichTextElement> r106 = com.ss.android.lark.widget.richtext.c.d(d(r104, 0, r210));
        Intrinsics.checkNotNull(r106);
        r100.addAll(r106);
        if (r211 == null) goto L24;
        r103 = r211.invoke(d(r104, r210, r105), 0);
    L24:
        SpannableStringBuilder r107 = r103;
    L115:
        return new Pair(com.ss.android.lark.widget.richtext.c.b(r100), r107);
    L21:
        List<RichTextElement> r108 = com.ss.android.lark.widget.richtext.c.d(r110);
        Intrinsics.checkNotNull(r108);
        r100.addAll(r108);
        if (r211 == null) goto L24;
        r103 = r211.invoke("", Integer.valueOf(r210));
        goto L24
    L14:
        r104 = r110;
        goto L15
    L25:
        SpannableStringBuilder r109 = new SpannableStringBuilder();
        Iterator<T> r112 = r111.iterator();
        int r113 = 0;
    L27:
        if (r112.hasNext() == false) goto L79;
        Object r114 = r112.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        com.ss.android.lark.audio.voiceinput.a r116 = (com.ss.android.lark.audio.voiceinput.a) r114;
        if (r110 == null) goto L37;
        if (r113 != 0) goto L35;
        int r117 = 0;
    L36:
        String r118 = d(r110, r117, r116.f409198a);
    L38:
        if (r118 != null) goto L40;
    L43:
        boolean r119 = true;
    L44:
        if (r119 == true) goto L46;
        List<RichTextElement> r120 = com.ss.android.lark.widget.richtext.c.d(r118);
        Intrinsics.checkNotNull(r120);
        r100.addAll(r120);
    L46:
        b r121 = this.f430318j.get(e(r116));
        if (r121 == null) goto L68;
        monitor-enter(r121);
        BaseSearchStrategy r122 = r121.f430334b;     // Catch: Throwable -> L65
        if (r122 == null) goto L53;
        boolean r123 = r122.b();     // Catch: Throwable -> L65
    L54:
        monitor-exit(r121);
        if (r123 == false) goto L68;
        ChatChatter r124 = r121.b();
        if (r124 == null) goto L64;
        String r125 = this.f430311c.invoke(r124);
        String r126 = r124.getId();
        boolean r127 = r124.isOutChatUser();
        boolean r128 = r124.isAnonymous();
        String r129 = r124.getLocalizedName();
        Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> r130 = RichTextElementCreator.f448209a;
        SpannableStringBuilder r131 = r109;
        Intrinsics.checkNotNullParameter(r129, "originChatterName");
        if (r126 != null) goto L61;
        r126 = "";
    L61:
        if (r125 != null) goto L63;
        r125 = "";
    L63:
        r100.add(RichTextElementCreator.h(RichTextElementCreator.b(r126, r125, r129, r127, r128)));
        r100.add(RichTextElementCreator.e(" "));
        Log.i(this.f430317i, "[buildRichText]user:" + r124.getId() + " isAnonymous:" + r124.isAnonymous() + " isOutOfChatUser:" + r124.isOutChatUser());
    L78:
        r113 = r115;
        r109 = r131;
        goto L27
    L64:
        r131 = r109;
        goto L78
    L53:
        r123 = false;
    L65:
        th = move-exception;
        throw th;
    L68:
        r131 = r109;
        Log.i(this.f430317i, "[buildRichText]asrUserInfo start:" + r116.f409198a + " end:" + r116.f409199b + " not found");
        if (r110 == null) goto L78;
        String r132 = d(r110, r116.f409198a, r116.f409199b);
        if (r132 == null) goto L78;
        if (r132.length() <= 0) goto L75;
        boolean r133 = true;
    L76:
        if (r133 == false) goto L78;
        List<RichTextElement> r134 = com.ss.android.lark.widget.richtext.c.d(r132);
        Intrinsics.checkNotNull(r134);
        r100.addAll(r134);
        goto L78
    L75:
        r133 = false;
        goto L76
    L40:
        if (r118.length() == 0) goto L43;
        r119 = false;
        goto L44
    L35:
        r117 = ((com.ss.android.lark.audio.voiceinput.a) ListProtector.get(r111, r113 - 1)).f409199b;
        goto L36
    L37:
        r118 = null;
        goto L38
    L79:
        SpannableStringBuilder r135 = r109;
        boolean r136 = true;
        int r137 = ((com.ss.android.lark.audio.voiceinput.a) ListProtector.get(r111, r111.size() - 1)).f409199b;
        if (r110 != null) goto L82;
    L112:
        SpannableStringBuilder r138 = r135;
    L113:
        r107 = r138;
        goto L115
    L82:
        if (r137 < r110.length()) goto L118;
    L89:
        String r139 = "";
    L90:
        if (r139 == null) goto L112;
        StringBuilder r140 = new StringBuilder();
        if (r139.length() > 0) goto L95;
        r136 = false;
    L95:
        if (r136 == true) goto L97;
        if (r211 == null) goto L110;
        SpannableStringBuilder r141 = r211.invoke("", Integer.valueOf(r210));
    L109:
        r138 = r141;
    L111:
        Log.i(this.f430317i, r140.toString());
    L110:
        r138 = r135;
        goto L111
    L97:
        if (r210 == (-1)) goto L104;
        if (r210 <= r137) goto L104;
        List<RichTextElement> r142 = com.ss.android.lark.widget.richtext.c.d(d(r110, r137, r210));
        Intrinsics.checkNotNull(r142);
        r100.addAll(r142);
        String r143 = d(r110, r210, r110.length());
        if (r211 == null) goto L102;
        r141 = r211.invoke(r143, Integer.valueOf(r210));
    L103:
        d(r110, r137, r210);
        d(r110, r210, r110.length());
        goto L109
    L102:
        r141 = r135;
    L104:
        List<RichTextElement> r144 = com.ss.android.lark.widget.richtext.c.d(r139);
        Intrinsics.checkNotNull(r144);
        r100.addAll(r144);
        if (r211 == null) goto L110;
        r141 = r211.invoke("", Integer.valueOf(r210));
        goto L109
    L118:
        r139 = r110.substring(RangesKt.coerceAtLeast(r137, 0));     // Catch: Exception -> L87
    L87:
        e = move-exception;
        Log.e(this.f430317i, "[safeSubString]subString error", e);
        goto L89
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserSearchAndMatchStrategy(CoroutineScope r100, String r101, Function1<? super ChatChatter, String> r102, Function4<? super String, ? super String, ? super String, ? super Boolean, ? extends ccb.d> r103, Function2<? super String, ? super String, ? extends ChatChatter> r104, Function2<? super String, ? super String, Boolean> r105, MatchMode r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "viewModelScoped");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r102, "getDisplayName");
        Intrinsics.checkNotNullParameter(r103, "syncSearchMentionChatChatters");
        Intrinsics.checkNotNullParameter(r104, "syncGetChatChatter");
        Intrinsics.checkNotNullParameter(r105, "syncCheckUserIsInChat");
        Intrinsics.checkNotNullParameter(r106, "matchMode");
        this.f430309a = r100;
        this.f430310b = r101;
        this.f430311c = r102;
        this.f430312d = r103;
        this.f430313e = r104;
        this.f430314f = r105;
        this.f430315g = r106;
        this.f430316h = r107;
        this.f430317i = "UserSearchAndMatchStrategy";
        this.f430318j = new ConcurrentHashMap();
    }
}
