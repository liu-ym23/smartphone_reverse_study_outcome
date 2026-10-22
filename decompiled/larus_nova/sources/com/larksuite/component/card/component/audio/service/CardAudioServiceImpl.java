package com.larksuite.component.card.component.audio.service;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larksuite.component.card.component.audio.monitor.CardAudioMonitor;
import com.larksuite.component.card.protocol.data.media.AudioInfo;
import com.larksuite.component.card.resources.CardResource;
import com.larksuite.component.card.resources.e;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0003<=>B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J2\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J*\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0014H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0014H\u0016J\b\u0010)\u001a\u00020\u0018H\u0016J\b\u0010*\u001a\u00020\u0018H\u0007J \u0010+\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J(\u0010,\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J9\u0010/\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0002\u00103J\u0018\u00104\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u00105\u001a\u000206H\u0002J(\u00107\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\u000fH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00160\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0016`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larksuite/component/card/component/audio/service/CardAudioServiceImpl;", "Lcom/larksuite/component/card/component/audio/service/ICardAudioService;", "Landroidx/lifecycle/LifecycleObserver;", "serviceContext", "Lcom/larksuite/component/card/service/CardServiceContext;", "<init>", "(Lcom/larksuite/component/card/service/CardServiceContext;)V", "resourceService", "Lcom/larksuite/component/card/resources/ICardResourceService;", "resourceLoadScope", "Lkotlinx/coroutines/CoroutineScope;", "resourceLoadJob", "Lkotlinx/coroutines/Job;", "audioSessions", "Ljava/util/HashMap;", "", "Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity;", "Lkotlin/collections/HashMap;", "observers", "", "Lcom/larksuite/component/card/component/audio/service/ICardAudioStateObserver;", "audioOperations", "Lcom/larksuite/component/card/component/audio/service/CardAudioServiceImpl$AudioOperation;", "play", "", "sessionID", "audioInfo", "Lcom/larksuite/component/card/protocol/data/media/AudioInfo;", "position", "", "monitorData", "Lcom/larksuite/component/card/component/audio/service/ICardAudioService$CardAudioMonitorData;", "playBySeek", "", "pause", "stop", "seek", "getState", "registerStateObserver", "observer", "removeStateObserver", MapMonitorConst.EVENT_DESTROY, "onStop", "loadResourceAndPlay", "doPlay", "resource", "Lcom/larksuite/component/card/resources/CardResource;", "updateAudioState", "state", "Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;", "duration", "(Ljava/lang/String;Lcom/larksuite/component/card/component/audio/service/CardAudioStateEntity$CardAudioStateEnum;Ljava/lang/Integer;Ljava/lang/Integer;)V", "monitorOperateAudioSuccess", WikiFolderPushPlugin.OPT, "Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioOperationEnum;", "monitorOperateAudioFail", "failType", "Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioOperationFailType;", "errorCode", "errorMsg", "AudioPlayerCallback", "AudioOperation", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardAudioServiceImpl implements com.larksuite.component.card.component.audio.service.b, LifecycleObserver {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f283277g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f283278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f283279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Job f283280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, CardAudioStateEntity> f283281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.larksuite.component.card.component.audio.service.c> f283282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, a> f283283f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f283284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CardAudioMonitor.AudioOperationEnum f283285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AudioInfo f283286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.larksuite.component.card.component.audio.service.b.a f283287d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f283284a, r101.f283284a) == true) goto L12;
            return false;
        L12:
            if (this.f283285b == r101.f283285b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f283286c, r101.f283286c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f283287d, r101.f283287d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f283284a.hashCode() * 31) + this.f283285b.hashCode()) * 31;
            AudioInfo r101 = this.f283286c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            com.larksuite.component.card.component.audio.service.b.a r105 = this.f283287d;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "AudioOperation(sessionID=" + this.f283284a + ", operation=" + this.f283285b + ", audioInfo=" + this.f283286c + ", monitorData=" + this.f283287d + ')';
        }

        public a(String r100, CardAudioMonitor.AudioOperationEnum r101, AudioInfo r102, com.larksuite.component.card.component.audio.service.b.a r103) {
            Intrinsics.checkNotNullParameter(r100, "sessionID");
            Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
            this.f283284a = r100;
            this.f283285b = r101;
            this.f283286c = r102;
            this.f283287d = r103;
        }
    }

    public static final class b implements com.ss.android.lark.audio.opus.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f283288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioInfo f283289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<CardAudioServiceImpl> f283290c;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f283291a;

            public a(b r100) {
                this.f283291a = r100;
            }

            public final void a() {
                CardAudioServiceImpl r100 = b.c(this.f283291a);
                if (r100 == null) goto L5;
                b r101 = this.f283291a;
                String r102 = r101.f283288a;
                int r103 = r101.f283289b.getDuration();
                CardAudioStateEntity.CardAudioStateEnum r104 = CardAudioStateEntity.CardAudioStateEnum.ERROR;
                Integer r105 = Integer.valueOf(r103);
                int r106 = CardAudioServiceImpl.f283277g;
                r100.p(r102, r104, 0, r105);
            L5:
                CardAudioServiceImpl r107 = b.c(this.f283291a);
                if (r107 == null) goto L9;
                CardAudioServiceImpl.m(r107, this.f283291a.f283288a, CardAudioMonitor.AudioOperationFailType.PLAYER, -1, "player error");
                return;
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

        /* JADX INFO: renamed from: com.larksuite.component.card.component.audio.service.CardAudioServiceImpl$b$b, reason: collision with other inner class name */
        public static final class RunnableC3896b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f283292a;

            public RunnableC3896b(b r100) {
                this.f283292a = r100;
            }

            public final void a() {
                CardAudioServiceImpl r100 = b.c(this.f283292a);
                if (r100 == null) goto L5;
                b r101 = this.f283292a;
                String r102 = r101.f283288a;
                int r103 = r101.f283289b.getDuration();
                CardAudioServiceImpl.q(r100, r102, CardAudioStateEntity.CardAudioStateEnum.PAUSED, null, Integer.valueOf(r103), 4);
            L5:
                CardAudioServiceImpl r104 = b.c(this.f283292a);
                if (r104 == null) goto L9;
                CardAudioServiceImpl.n(r104, this.f283292a.f283288a, CardAudioMonitor.AudioOperationEnum.PAUSE);
                return;
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

        public static final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f283293a;

            public c(b r100) {
                this.f283293a = r100;
            }

            public final void a() {
                CardAudioServiceImpl r100 = b.c(this.f283293a);
                if (r100 == null) goto L5;
                b r101 = this.f283293a;
                String r102 = r101.f283288a;
                int r103 = r101.f283289b.getDuration();
                CardAudioServiceImpl.q(r100, r102, CardAudioStateEntity.CardAudioStateEnum.PLAYING, null, Integer.valueOf(r103), 4);
            L5:
                CardAudioMonitor.AudioOperationEnum r104 = CardAudioMonitor.AudioOperationEnum.PLAY;
                CardAudioServiceImpl r105 = b.c(this.f283293a);
                if (r105 == null) goto L12;
                HashMap<String, a> r106 = r105.f283283f;
                if (r106 == null) goto L12;
                a r107 = r106.get(this.f283293a.f283288a);
                if (r107 == null) goto L12;
                CardAudioMonitor.AudioOperationEnum r108 = r107.f283285b;
            L13:
                CardAudioMonitor.AudioOperationEnum r109 = CardAudioMonitor.AudioOperationEnum.SEEK;
                if (r108 != r109) goto L16;
                r104 = r109;
            L16:
                CardAudioServiceImpl r110 = b.c(this.f283293a);
                if (r110 == null) goto L20;
                CardAudioServiceImpl.n(r110, this.f283293a.f283288a, r104);
                return;
            L20:
                return;
            L12:
                r108 = null;
                goto L13
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

        public static final class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f283294a;

            public d(b r100) {
                this.f283294a = r100;
            }

            public final void a() {
                CardAudioServiceImpl r100 = b.c(this.f283294a);
                if (r100 == null) goto L5;
                b r101 = this.f283294a;
                String r102 = r101.f283288a;
                int r103 = r101.f283289b.getDuration();
                CardAudioServiceImpl.q(r100, r102, CardAudioStateEntity.CardAudioStateEnum.PLAYING, null, Integer.valueOf(r103), 4);
            L5:
                CardAudioMonitor.AudioOperationEnum r104 = CardAudioMonitor.AudioOperationEnum.PLAY;
                CardAudioServiceImpl r105 = b.c(this.f283294a);
                if (r105 == null) goto L12;
                HashMap<String, a> r106 = r105.f283283f;
                if (r106 == null) goto L12;
                a r107 = r106.get(this.f283294a.f283288a);
                if (r107 == null) goto L12;
                CardAudioMonitor.AudioOperationEnum r108 = r107.f283285b;
            L13:
                CardAudioMonitor.AudioOperationEnum r109 = CardAudioMonitor.AudioOperationEnum.SEEK;
                if (r108 != r109) goto L16;
                r104 = r109;
            L16:
                CardAudioServiceImpl r110 = b.c(this.f283294a);
                if (r110 == null) goto L20;
                CardAudioServiceImpl.n(r110, this.f283294a.f283288a, r104);
                return;
            L20:
                return;
            L12:
                r108 = null;
                goto L13
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

        public static final class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f283295a;

            public e(b r100) {
                this.f283295a = r100;
            }

            public final void a() {
                CardAudioServiceImpl r100 = b.c(this.f283295a);
                if (r100 == null) goto L5;
                b r101 = this.f283295a;
                String r102 = r101.f283288a;
                int r103 = r101.f283289b.getDuration();
                CardAudioStateEntity.CardAudioStateEnum r104 = CardAudioStateEntity.CardAudioStateEnum.STOPPED;
                Integer r105 = Integer.valueOf(r103);
                int r106 = CardAudioServiceImpl.f283277g;
                r100.p(r102, r104, 0, r105);
            L5:
                CardAudioServiceImpl r107 = b.c(this.f283295a);
                if (r107 == null) goto L9;
                CardAudioServiceImpl.n(r107, this.f283295a.f283288a, CardAudioMonitor.AudioOperationEnum.STOP);
                return;
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

        public static final class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f283296a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ float f283297b;

            public f(b r100, float r101) {
                this.f283296a = r100;
                this.f283297b = r101;
            }

            public final void a() {
                int r100 = (int) (this.f283296a.f283289b.getDuration() * this.f283297b);
                CardAudioServiceImpl r101 = b.c(this.f283296a);
                if (r101 == null) goto L8;
                CardAudioStateEntity r102 = r101.getState(this.f283296a.f283288a);
                if (r102 == null) goto L8;
                CardAudioStateEntity.CardAudioStateEnum r103 = r102.getState();
                if (r103 == null) goto L8;
            L9:
                StringBuilder r104 = new StringBuilder();
                int r105 = CardAudioServiceImpl.f283277g;
                r104.append(c.a(this.f283296a.f283288a));
                r104.append("[callback] progress=");
                r104.append(this.f283297b);
                r104.append(", position=");
                r104.append(r100);
                r104.append(", state=");
                r104.append(r103.getValue());
                Log.d("CardAudioService", r104.toString());
                CardAudioServiceImpl r106 = b.c(this.f283296a);
                if (r106 == null) goto L13;
                b r107 = this.f283296a;
                r106.p(r107.f283288a, r103, Integer.valueOf(r100), Integer.valueOf(r107.f283289b.getDuration()));
                return;
            L13:
                return;
            L8:
                r103 = CardAudioStateEntity.CardAudioStateEnum.PLAYING;
                goto L9
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

        @Override // com.ss.android.lark.audio.opus.e.a
        public final void a() {
            StringBuilder r100 = new StringBuilder();
            int r101 = CardAudioServiceImpl.f283277g;
            r100.append(c.a(this.f283288a));
            r100.append("[callback] error");
            Log.e("CardAudioService", r100.toString());
            mz7.b.a(new a(this));
        }

        @Override // com.ss.android.lark.audio.opus.e.a
        public final void pause() {
            StringBuilder r100 = new StringBuilder();
            int r101 = CardAudioServiceImpl.f283277g;
            r100.append(c.a(this.f283288a));
            r100.append("[callback] pause");
            Log.d("CardAudioService", r100.toString());
            mz7.b.a(new RunnableC3896b(this));
        }

        @Override // com.ss.android.lark.audio.opus.e.a
        public final void resume() {
            StringBuilder r100 = new StringBuilder();
            int r101 = CardAudioServiceImpl.f283277g;
            r100.append(c.a(this.f283288a));
            r100.append("[callback] resume");
            Log.d("CardAudioService", r100.toString());
            mz7.b.a(new c(this));
        }

        @Override // com.ss.android.lark.audio.opus.e.a
        public final void start() {
            StringBuilder r100 = new StringBuilder();
            int r101 = CardAudioServiceImpl.f283277g;
            r100.append(c.a(this.f283288a));
            r100.append("[callback] start");
            Log.d("CardAudioService", r100.toString());
            mz7.b.a(new d(this));
        }

        @Override // com.ss.android.lark.audio.opus.e.a
        public final void stop() {
            StringBuilder r100 = new StringBuilder();
            int r101 = CardAudioServiceImpl.f283277g;
            r100.append(c.a(this.f283288a));
            r100.append("[callback] stop");
            Log.d("CardAudioService", r100.toString());
            mz7.b.a(new e(this));
        }

        public static final CardAudioServiceImpl c(b r100) {
            return r100.f283290c.get();
        }

        @Override // com.ss.android.lark.audio.opus.e.a
        public final void b(float r100) {
            mz7.b.a(new f(this, r100));
        }

        public b(String r100, AudioInfo r101, CardAudioServiceImpl r102) {
            Intrinsics.checkNotNullParameter(r100, "sessionID");
            Intrinsics.checkNotNullParameter(r101, "audioInfo");
            Intrinsics.checkNotNullParameter(r102, "audioService");
            this.f283288a = r100;
            this.f283289b = r101;
            this.f283290c = new WeakReference(r102);
        }
    }

    public static final class c {
        public c() {
        }

        public static final String a(String r100) {
            int r101 = CardAudioServiceImpl.f283277g;
            return "[CardAudioService-" + r100 + ']';
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f283298a = null;

        static {
            int[] r100 = new int[CardAudioStateEntity.CardAudioStateEnum.values().length];
            r100[CardAudioStateEntity.CardAudioStateEnum.STOPPED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[CardAudioStateEntity.CardAudioStateEnum.ERROR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[CardAudioStateEntity.CardAudioStateEnum.PAUSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[CardAudioStateEntity.CardAudioStateEnum.PREPARING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[CardAudioStateEntity.CardAudioStateEnum.PLAYING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f283298a = r100;
        }
    }

    static {
        new c();
    }

    @Override // com.larksuite.component.card.service.c
    public final void destroy() {
        Log.i("CardAudioService", "[lifecycle] destroy");
        Job r100 = this.f283280c;
        if (r100 == null) goto L5;
        r100.cancel(new CancellationException("Destroy"));
    L5:
        ((ArrayList) this.f283282e).clear();
        this.f283281d.clear();
        this.f283283f.clear();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        Log.i("CardAudioService", "[lifecycle] stop");
        com.ss.android.lark.audio.opus.e.d().g();
    }

    public CardAudioServiceImpl(com.larksuite.component.card.service.b r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceContext");
        e r101 = (e) r100.f283931c.getService(e.class);
        if (r101 != null) goto L9;
        Log.e("CardAudioService", "CardResourceService is null");
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L8;
        r101 = new com.larksuite.component.card.resources.d();
        goto L9
    L8:
        throw new NullPointerException("CardResourceService is null");
    L9:
        this.f283278a = r101;
        this.f283279b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f283281d = new HashMap();
        this.f283282e = new ArrayList();
        this.f283283f = new HashMap();
        Log.i("CardAudioService", "[lifecycle] init");
        Lifecycle r102 = r100.f283929a;
        if (r102 == null) goto L13;
        r102.addObserver(this);
        return;
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void e(az7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (((ArrayList) this.f283282e).contains(r100) == true) goto L6;
        ((ArrayList) this.f283282e).add(r100);
        return;
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final CardAudioStateEntity getState(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionID");
        return this.f283281d.get(r100);
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void c(String r100, com.larksuite.component.card.component.audio.service.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionID");
        String r102 = null;
        this.f283283f.put(r100, new a(r100, CardAudioMonitor.AudioOperationEnum.STOP, null, r101));
        CardAudioStateEntity r103 = this.f283281d.get(r100);
        if (r103 == null) goto L5;
        CardAudioStateEntity.CardAudioStateEnum r104 = r103.getState();
    L6:
        StringBuilder r105 = new StringBuilder();
        r105.append(c.a(r100));
        r105.append("[stop] current state: ");
        if (r104 == null) goto L9;
        r102 = r104.getValue();
    L9:
        r105.append(r102);
        Log.i("CardAudioService", r105.toString());
        if (r104 != null) goto L12;
        int r106 = -1;
    L14:
        if (r106 != 3) goto L16;
    L23:
        com.ss.android.lark.audio.opus.e.d().m(true);
        return;
    L16:
        if (r106 != 4) goto L18;
        Job r107 = this.f283280c;
        if (r107 == null) goto L25;
        r107.cancel(new CancellationException("Stopped"));
        return;
    L25:
        return;
    L18:
        if (r106 == 5) goto L23;
        return;
    L12:
        r106 = d.f283298a[r104.ordinal()];
        goto L14
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void l(String r100, com.larksuite.component.card.component.audio.service.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionID");
        String r102 = null;
        this.f283283f.put(r100, new a(r100, CardAudioMonitor.AudioOperationEnum.PAUSE, null, r101));
        CardAudioStateEntity r103 = this.f283281d.get(r100);
        if (r103 == null) goto L5;
        CardAudioStateEntity.CardAudioStateEnum r104 = r103.getState();
    L6:
        StringBuilder r105 = new StringBuilder();
        r105.append(c.a(r100));
        r105.append("[pause] current state: ");
        if (r104 == null) goto L9;
        r102 = r104.getValue();
    L9:
        r105.append(r102);
        Log.i("CardAudioService", r105.toString());
        if (r104 != CardAudioStateEntity.CardAudioStateEnum.PLAYING) goto L13;
        com.ss.android.lark.audio.opus.e.d().g();
        return;
    L13:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static final void n(CardAudioServiceImpl r100, String r101, CardAudioMonitor.AudioOperationEnum r102) {
        a r103 = r100.f283283f.get(r101);
        if (r103 == null) goto L18;
        int r104 = CardAudioMonitor.f283270a;
        com.larksuite.component.card.component.audio.service.b.a r105 = r103.f283287d;
        if (r105 == null) goto L8;
        String r106 = r105.f283301a;
        if (r106 == null) goto L8;
    L9:
        String r107 = null;
        if (r105 == null) goto L12;
        String r108 = r105.f283302b;
    L13:
        AudioInfo r109 = r103.f283286c;
        if (r109 == null) goto L16;
        r107 = r109.getKey();
    L16:
        CardAudioMonitor.b(r106, r102, r108, r107);
        return;
    L12:
        r108 = null;
    L8:
        r106 = "";
        goto L9
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void f(String r100, AudioInfo r110, int r111, com.larksuite.component.card.component.audio.service.b.a r112) {
        Intrinsics.checkNotNullParameter(r100, "sessionID");
        Intrinsics.checkNotNullParameter(r110, "audioInfo");
        this.f283283f.put(r100, new a(r100, CardAudioMonitor.AudioOperationEnum.SEEK, r110, r112));
        CardAudioStateEntity r101 = this.f283281d.get(r100);
        StringBuilder r102 = new StringBuilder();
        r102.append(c.a(r100));
        r102.append("[seek], current state: ");
        if (r101 == null) goto L7;
        CardAudioStateEntity.CardAudioStateEnum r103 = r101.getState();
        if (r103 == null) goto L7;
        String r104 = r103.getValue();
    L8:
        r102.append(r104);
        Log.i("CardAudioService", r102.toString());
        if (r101 == null) goto L12;
        CardAudioStateEntity.CardAudioStateEnum r105 = r101.getState();
        if (r105 == null) goto L12;
    L13:
        q(this, r100, null, Integer.valueOf(r111), Integer.valueOf(r110.getDuration()), 2);
        int r106 = d.f283298a[r105.ordinal()];
        if (r106 != 1) goto L16;
    L27:
        j(r100, r110, r111, r112, true);
        return;
    L16:
        if (r106 == 2) goto L27;
        if (r106 != 3) goto L20;
    L22:
        int r107 = r110.getDuration();
        if (r107 != 0) goto L25;
        float r108 = 0.0f;
    L26:
        com.ss.android.lark.audio.opus.e.d().j(r108);
        com.ss.android.lark.audio.opus.e.d().i();
        return;
    L25:
        r108 = r111 / r107;
        goto L26
    L20:
        if (r106 == 5) goto L22;
        return;
    L12:
        r105 = CardAudioStateEntity.CardAudioStateEnum.STOPPED;
    L7:
        r104 = null;
        goto L8
    }

    public final void o(String r100, AudioInfo r110, CardResource r111, int r112) {
        Log.i("CardAudioService", c.a(r100) + " doPlay");
        int r101 = r110.getDuration();
        com.ss.android.lark.audio.a r113 = new com.ss.android.lark.audio.a(r100, "", r101, (int) ((((float) r112) / ((float) r101)) * 100.0f), r111.f283905c);
        CardAudioStateEntity r114 = getState(r100);
        if (r114 == null) goto L5;
        CardAudioStateEntity.CardAudioStateEnum r115 = r114.getState();
    L6:
        CardAudioStateEntity.CardAudioStateEnum r102 = CardAudioStateEntity.CardAudioStateEnum.STARTING;
        if (r115 != r102) goto L10;
        Log.i("CardAudioService", c.a(r100) + " already starting play");
        return;
    L10:
        com.ss.android.lark.audio.opus.e.d().m(true);
        com.ss.android.lark.audio.opus.e.d().n(r113, new b(r100, r110, this));
        q(this, r100, r102, null, Integer.valueOf(r110.getDuration()), 4);
        return;
    L5:
        r115 = null;
        goto L6
    }

    public final void p(String r100, CardAudioStateEntity.CardAudioStateEnum r110, Integer r111, Integer r112) {
        HashMap<String, CardAudioStateEntity> r101 = this.f283281d;
        CardAudioStateEntity r102 = r101.get(r100);
        if (r102 != null) goto L5;
        r102 = new CardAudioStateEntity(null, 0, 0, 7, null);
        r101.put(r100, r102);
    L5:
        CardAudioStateEntity r103 = CardAudioStateEntity.copy$default(r102, null, 0, 0, 7, null);
        boolean r104 = false;
        boolean r105 = true;
        if (r110 != null) goto L8;
    L16:
        boolean r113 = false;
    L17:
        if (r111 != null) goto L19;
    L27:
        if (r112 != null) goto L29;
    L36:
        r105 = r113;
    L37:
        this.f283281d.put(r100, r103);
        if (r105 == true) goto L40;
        return;
    L40:
        if (r103.getState().isLocalState() == true) goto L47;
        Iterator<T> r114 = this.f283282e.iterator();
    L43:
        if (r114.hasNext() == false) goto L48;
        ((com.larksuite.component.card.component.audio.service.c) r114.next()).a(r100, r103);
        goto L43
    L48:
        return;
    L47:
        return;
    L29:
        if (r103.getDuration() == r112.intValue()) goto L31;
        r104 = true;
    L31:
        if (r104 == true) goto L34;
        r112 = null;
    L34:
        if (r112 == null) goto L36;
        r103.setDuration(r112.intValue());
        goto L37
    L19:
        if (r103.getPosition() == r111.intValue()) goto L21;
        boolean r106 = true;
    L22:
        if (r106 == true) goto L25;
        r111 = null;
    L25:
        if (r111 == null) goto L27;
        r103.setPosition(r111.intValue());
        r113 = true;
        goto L27
    L21:
        r106 = false;
        goto L22
    L8:
        if (r103.getState() == r110) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L14;
        r110 = null;
    L14:
        if (r110 == null) goto L16;
        r103.setState(r110);
        r113 = true;
        goto L17
    L10:
        r107 = false;
        goto L11
    }

    public static final void m(CardAudioServiceImpl r100, String r101, CardAudioMonitor.AudioOperationFailType r110, int r111, String r112) {
        a r102 = r100.f283283f.get(r101);
        if (r102 == null) goto L19;
        int r103 = CardAudioMonitor.f283270a;
        com.larksuite.component.card.component.audio.service.b.a r104 = r102.f283287d;
        if (r104 == null) goto L8;
        String r105 = r104.f283301a;
        if (r105 == null) goto L8;
    L9:
        String r106 = r105;
        CardAudioMonitor.AudioOperationEnum r107 = r102.f283285b;
        if (r104 == null) goto L12;
        String r108 = r104.f283302b;
    L13:
        AudioInfo r109 = r102.f283286c;
        if (r109 == null) goto L16;
        String r113 = r109.getKey();
    L17:
        CardAudioMonitor.a(r106, r107, r108, r113, r110, r111, r112);
        return;
    L16:
        r113 = null;
        goto L17
    L12:
        r108 = null;
    L8:
        r105 = "";
        goto L9
    }

    @Override // com.larksuite.component.card.component.audio.service.b
    public final void j(String r110, AudioInfo r111, int r112, com.larksuite.component.card.component.audio.service.b.a r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "sessionID");
        Intrinsics.checkNotNullParameter(r111, "audioInfo");
        if (r114 == false) goto L5;
        CardAudioMonitor.AudioOperationEnum r100 = CardAudioMonitor.AudioOperationEnum.SEEK;
    L6:
        this.f283283f.put(r110, new a(r110, r100, r111, r113));
        CardAudioStateEntity r101 = this.f283281d.get(r110);
        if (r101 == null) goto L10;
        CardAudioStateEntity.CardAudioStateEnum r102 = r101.getState();
        if (r102 == null) goto L10;
    L11:
        Log.i("CardAudioService", c.a(r110) + "[play] current state: " + r102.getValue());
        int r103 = d.f283298a[r102.ordinal()];
        if (r103 != 1) goto L14;
    L19:
        CardResource r104 = this.f283278a.i(r111.getKey());
        if (r104 == null) goto L22;
        Log.i("CardAudioService", c.a(r110) + " play resource hit");
        o(r110, r111, r104, r112);
        return;
    L22:
        Log.i("CardAudioService", c.a(r110) + " resource miss");
        Job r105 = this.f283280c;
        if (r105 == null) goto L25;
        r105.cancel(new CancellationException("Another audio play"));
    L25:
        q(this, r110, CardAudioStateEntity.CardAudioStateEnum.PREPARING, null, Integer.valueOf(r111.getDuration()), 4);
        this.f283280c = BuildersKt.launch$default(this.f283279b, null, null, new CardAudioServiceImpl$loadResourceAndPlay$2(r111, this, r110, r112, null), 3, null);
        return;
    L14:
        if (r103 == 2) goto L19;
        if (r103 != 3) goto L29;
        com.ss.android.lark.audio.opus.e.d().i();
        return;
    L29:
        return;
    L10:
        r102 = CardAudioStateEntity.CardAudioStateEnum.STOPPED;
        goto L11
    L5:
        r100 = CardAudioMonitor.AudioOperationEnum.PLAY;
        goto L6
    }

    public static /* synthetic */ void q(CardAudioServiceImpl r100, String r101, CardAudioStateEntity.CardAudioStateEnum r102, Integer r103, Integer r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = null;
    L11:
        r100.p(r101, r102, r103, r104);
    }
}
