package com.obric.assistant.session.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.session.bean.ErrorCode;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bg\u0018\u0000 +2\u00020\u0001:\u0001+J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u001f\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0001H\u0016¢\u0006\u0002\u0010!J\u001d\u0010\"\u001a\u0004\u0018\u0001H#\"\u0004\b\u0000\u0010#2\u0006\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010$J\u0010\u0010)\u001a\n **\u0004\u0018\u00010\u00030\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010%\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0005R\u0014\u0010'\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005¨\u0006,"}, d2 = {"Lcom/obric/assistant/session/model/ISessionEndPoint;", "", "TAG", "", "getTAG", "()Ljava/lang/String;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "prepareOrder", "", "getPrepareOrder", "()I", "processOrder", "getProcessOrder", "onSessionPrepared", "", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSessionCompleted", "code", "storeData", "key", "value", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlin/Unit;", "getData", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/Object;", "requestFromStr", "getRequestFromStr", "sessionNameStr", "getSessionNameStr", "getTagName", "kotlin.jvm.PlatformType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISessionEndPoint {

    public static final class a {
        public static AudioManager a() {
            Object r100 = AppHost.f326268a.getApplication().getSystemService("audio");
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.media.AudioManager");
            return (AudioManager) r100;
        }

        public static String b(ISessionEndPoint r100) {
            if (Build.VERSION.SDK_INT >= 33) goto L7;
            String r101 = r100.getClass().getName();
            Intrinsics.checkNotNull(r101);
            return r101;
        L7:
            return "AiIsland-【" + r100.getTagName() + 12305;
        }

        public static Pair e(ISessionEndPoint r100) {
            FLogger.f375446a.i(r100.getTAG(), "onSessionProcess");
            return TuplesKt.to(ErrorCode.CONTINUE, "");
        }

        public static Context getContext(ISessionEndPoint r100) {
            ISessionMaintaining r101 = (ISessionMaintaining) ServiceManager.get().getService(ISessionMaintaining.class);
            if (r101 == null) goto L7;
            Context r102 = r101.getContext();
            if (r102 == null) goto L7;
            return r102;
        L7:
            return AppHost.f326268a.getApplication();
        }

        public static void c(ISessionEndPoint r100, ErrorCode r101) {
            Intrinsics.checkNotNullParameter(r101, "code");
            FLogger.f375446a.i(r100.getTAG(), "onSessionCompleted " + r101);
        }

        public static void d(ISessionEndPoint r100, Context r101, Bundle r102) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "args");
            FLogger.f375446a.i(r100.getTAG(), "onSessionPrepared");
        }
    }

    Object d(Bundle r100, Continuation<? super Pair<? extends ErrorCode, String>> r101);

    int f();

    Context getContext();

    String getTAG();

    String getTagName();

    int h();

    void n(ErrorCode r100);

    void p(Context r100, Bundle r101);
}
