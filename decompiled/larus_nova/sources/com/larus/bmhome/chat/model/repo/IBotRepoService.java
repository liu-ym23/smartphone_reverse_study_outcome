package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.LiveData;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0003KLMJ\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\rJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH¦@¢\u0006\u0002\u0010\u001eJ \u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0016H¦@¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H¦@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0010H¦@¢\u0006\u0002\u0010%J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u000bH&J@\u0010)\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u00102\b\b\u0002\u0010,\u001a\u00020\u00162\b\b\u0002\u0010-\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0010H\u0016JH\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u0001022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0010042\b\b\u0002\u0010*\u001a\u00020\u00162\b\b\u0002\u0010+\u001a\u00020\u00102\b\b\u0002\u0010,\u001a\u00020\u0016H¦@¢\u0006\u0002\u00105J\"\u00106\u001a\u0004\u0018\u00010\u000b2\u0006\u00100\u001a\u00020\u00102\b\b\u0002\u0010*\u001a\u00020\u0016H¦@¢\u0006\u0002\u0010!Jz\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u001d2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\b\b\u0002\u0010>\u001a\u00020\u00162\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010C\u001a\u0004\u0018\u00010DH¦@¢\u0006\u0002\u0010EJ/\u0010F\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u00102\u0017\u0010G\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0H¢\u0006\u0002\bIH¦@¢\u0006\u0002\u0010JR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006N"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/IBotRepoService;", "", "globalSpeakerVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "getGlobalSpeakerVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setGlobalSpeakerVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "updateBotVoice", "Lcom/larus/bmhome/bot/bean/VoiceUpdateResult;", "oldBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "newVoice", "(Lcom/larus/im/bean/bot/BotModel;Lcom/larus/im/bean/bot/SpeakerVoice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "botDeleteEventLive", "Landroidx/lifecycle/LiveData;", "", "getBotDeleteEventLive", "()Landroidx/lifecycle/LiveData;", "botUpdateEventLive", "getBotUpdateEventLive", "deleteBot", "", "bot", "(Lcom/larus/im/bean/bot/BotModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateBotAccessPermission", "Lcom/larus/im/bean/bot/BotUpdateResult;", "botId", "privateStatus", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateBotMessagePush", "messagePush", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireSubjectBotInfo", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/bot/bean/BotSubjectResult;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetBotSubject", "saveBot", "", "findBot", "forceNew", "scene", "syncLocal", "useMainBotCache", "(Ljava/lang/String;ZLjava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadMainBot", "conversationId", "findBots", "", "botIds", "", "(Ljava/util/List;ZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBotByConversationId", "requireRecommendBotData", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "recommendType", "pageIndex", "pageSize", "tagId", "", "withOnBoarding", "oldBotId", "triggerType", "tab", "firstBotId", "source", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "(IIILjava/lang/Long;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/basic/experience/downgrade/api/DowngradeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalBot", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ActionBarConfParam", "ReportActionBarOpParam", "ReportActionBarModeSwitchParam", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBotRepoService {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f307692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f307693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f307694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f307695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f307696e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f307692a, r101.f307692a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f307693b, r101.f307693b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f307694c, r101.f307694c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f307695d, r101.f307695d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f307696e, r101.f307696e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.f307692a.hashCode() * 31) + this.f307693b.hashCode()) * 31) + this.f307694c.hashCode()) * 31) + this.f307695d.hashCode()) * 31;
            String r101 = this.f307696e;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ActionBarConfParam(languageCode=" + this.f307692a + ", botId=" + this.f307693b + ", cvsId=" + this.f307694c + ", scene=" + this.f307695d + ", throughToken=" + this.f307696e + ')';
        }

        public /* synthetic */ a(String r100, String r101, String r102) {
            this(r100, r101, r102, "", null);
        }

        public a(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
            Intrinsics.checkNotNullParameter(r101, "botId");
            Intrinsics.checkNotNullParameter(r102, "cvsId");
            Intrinsics.checkNotNullParameter(r103, "scene");
            this.f307692a = r100;
            this.f307693b = r101;
            this.f307694c = r102;
            this.f307695d = r103;
            this.f307696e = r104;
        }
    }

    public static final class b {
        public static /* synthetic */ Object a(IBotRepoService r100, String r110, boolean r111, String r112, boolean r113, Continuation r114, int r115) {
            if ((r115 & 2) == 0) goto L5;
            boolean r101 = false;
        L7:
            if ((r115 & 4) == 0) goto L9;
            r112 = "default";
        L9:
            String r102 = r112;
            if ((r115 & 8) == 0) goto L12;
            boolean r103 = true;
        L14:
            if ((r115 & 16) == 0) goto L16;
            boolean r104 = true;
        L18:
            return r100.q1(r110, r101, r102, r103, r104, r114);
        L16:
            r104 = false;
            goto L18
        L12:
            r103 = r113;
            goto L14
        L5:
            r101 = r111;
            goto L7
        }

        public static /* synthetic */ Object b(IBotRepoService r110, int r111, int r112, int r113, Long r114, boolean r210, String r211, String r212, String r213, String r214, DowngradeSource r215, Continuation r216, int r217) {
            if ((r217 & 8) == 0) goto L5;
            Long r100 = null;
        L7:
            if ((r217 & 16) == 0) goto L9;
            boolean r101 = true;
        L11:
            if ((r217 & 32) == 0) goto L13;
            String r102 = null;
        L15:
            if ((r217 & 64) == 0) goto L17;
            String r115 = null;
        L19:
            if ((r217 & 128) == 0) goto L21;
            String r116 = null;
        L23:
            if ((r217 & 256) == 0) goto L25;
            String r117 = null;
        L27:
            if ((r217 & 512) == 0) goto L29;
            DowngradeSource r118 = null;
        L31:
            return r110.k1(r111, r112, r113, r100, r101, r102, r115, r116, r117, r118, r216);
        L29:
            r118 = r215;
            goto L31
        L25:
            r117 = r214;
            goto L27
        L21:
            r116 = r213;
            goto L23
        L17:
            r115 = r212;
            goto L19
        L13:
            r102 = r211;
            goto L15
        L9:
            r101 = r210;
            goto L11
        L5:
            r100 = r114;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f307697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.larus.bmhome.actionbar.model.b2 f307698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.larus.bmhome.actionbar.model.b2 f307699c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f307697a, r101.f307697a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f307698b, r101.f307698b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f307699c, r101.f307699c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f307697a.hashCode() * 31;
            com.larus.bmhome.actionbar.model.b2 r101 = this.f307698b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            com.larus.bmhome.actionbar.model.b2 r105 = this.f307699c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportActionBarModeSwitchParam(cvsId=" + this.f307697a + ", fromMode=" + this.f307698b + ", toMode=" + this.f307699c + ')';
        }

        public c(String r100, com.larus.bmhome.actionbar.model.b2 r101, com.larus.bmhome.actionbar.model.b2 r102) {
            Intrinsics.checkNotNullParameter(r100, "cvsId");
            this.f307697a = r100;
            this.f307698b = r101;
            this.f307699c = r102;
        }
    }

    /* JADX INFO: loaded from: classes25.dex */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f307700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f307701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f307702c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f307703d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f307704e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Boolean f307705f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Integer f307706g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f307707h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f307708i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f307700a, r101.f307700a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f307701b, r101.f307701b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f307702c, r101.f307702c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f307703d, r101.f307703d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f307704e, r101.f307704e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f307705f, r101.f307705f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f307706g, r101.f307706g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f307707h, r101.f307707h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f307708i, r101.f307708i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((this.f307700a.hashCode() * 31) + this.f307701b.hashCode()) * 31) + this.f307702c.hashCode()) * 31) + this.f307703d.hashCode()) * 31) + this.f307704e.hashCode()) * 31;
            Boolean r101 = this.f307705f;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Integer r105 = this.f307706g;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f307707h;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f307708i;
            if (r111 == null) goto L19;
            r102 = r111.hashCode();
        L19:
            return r110 + r102;
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportActionBarOpParam(languageCode=" + this.f307700a + ", botId=" + this.f307701b + ", cvsId=" + this.f307702c + ", actionBarKey=" + this.f307703d + ", passThroughField=" + this.f307704e + ", switchReport=" + this.f307705f + ", instructionType=" + this.f307706g + ", msgId=" + this.f307707h + ", scene=" + this.f307708i + ')';
        }

        public d(String r100, String r101, String r102, String r103, String r104, Boolean r105, Integer r106, String r107, String r110) {
            Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
            Intrinsics.checkNotNullParameter(r101, "botId");
            Intrinsics.checkNotNullParameter(r102, "cvsId");
            Intrinsics.checkNotNullParameter(r103, "actionBarKey");
            Intrinsics.checkNotNullParameter(r104, "passThroughField");
            this.f307700a = r100;
            this.f307701b = r101;
            this.f307702c = r102;
            this.f307703d = r103;
            this.f307704e = r104;
            this.f307705f = r105;
            this.f307706g = r106;
            this.f307707h = r107;
            this.f307708i = r110;
        }
    }

    void e1(BotModel r100);

    Object f1(String r100, Continuation<? super com.larus.network.http.a<ub8.c>> r101);

    void g1(String r100, String r101);

    void h1();

    Object i1(List<String> r100, boolean r101, String r102, boolean r103, Continuation<? super Map<String, BotModel>> r104);

    Object j1(String r100, boolean r101, Continuation<? super BotModel> r102);

    Object k1(int r100, int r101, int r102, Long r103, boolean r104, String r105, String r106, String r107, String r108, DowngradeSource r110, Continuation<? super ic8.o0> r111);

    Object l1(String r100, Function1<? super BotModel, BotModel> r101, Continuation<? super Boolean> r102);

    Object m1(String r100, boolean r101, Continuation<? super uc9.t> r102);

    LiveData<BotModel> n1();

    Object o1(String r100, int r101, Continuation<? super uc9.t> r102);

    Object p1(String r100, Continuation<? super com.larus.network.http.a<ub8.c>> r101);

    Object q1(String r100, boolean r101, String r102, boolean r103, boolean r104, Continuation<? super BotModel> r105);

    LiveData<String> r1();

    Object s1(BotModel r100, Continuation<? super Boolean> r101);

    Object t1(BotModel r100, SpeakerVoice r101, Continuation<? super ub8.h> r102);
}
