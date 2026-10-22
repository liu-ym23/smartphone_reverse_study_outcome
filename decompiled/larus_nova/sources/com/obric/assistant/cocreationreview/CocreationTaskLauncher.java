package com.obric.assistant.cocreationreview;

import android.os.Bundle;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes32.dex */
public final class CocreationTaskLauncher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CocreationTaskLauncher f387126a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f387127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f387128b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f387127a == r101.f387127a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387128b, r101.f387128b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f387127a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f387128b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "Result(sent=" + this.f387127a + ", errorMessage=" + this.f387128b + ')';
        }

        public a(boolean r100, String r101) {
            this.f387127a = r100;
            this.f387128b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f387129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gd8.g f387130b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f387129a, r101.f387129a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387130b, r101.f387130b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f387129a.hashCode() * 31) + this.f387130b.hashCode();
        }

        public final String toString() {
            return "SendTarget(conversationId=" + this.f387129a + ", sender=" + this.f387130b + ')';
        }

        public b(String r100, gd8.g r101) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "sender");
            this.f387129a = r100;
            this.f387130b = r101;
        }
    }

    static {
        f387126a = new CocreationTaskLauncher();
    }

    public CocreationTaskLauncher() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(e4 r210, String r211, Continuation<? super a> r212) {
        if ((r212 instanceof CocreationTaskLauncher$run$1) == false) goto L7;
        CocreationTaskLauncher$run$1 r100 = (CocreationTaskLauncher$run$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L19;
        if (r104 == 1) goto L16;
        if (r104 != 2) goto L15;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L44 CancellationException -> L47
    L39:
        a r105 = (a) r102;     // Catch: Exception -> L44 CancellationException -> L47
        if (r105 == null) goto L51;
        return r105;
    L51:
        return new a(false, "未收到发送结果，请先查看豆包会话");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Ref.ObjectRef r106 = (Ref.ObjectRef) r100.L$2;
        String r107 = (String) r100.L$1;
        e4 r110 = (e4) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L44 CancellationException -> L47
        String r111 = r107;
    L27:
        b r108 = (b) r102;     // Catch: Exception -> L44 CancellationException -> L47
        if (r108 != null) goto L31;
        int r109 = s3.f387719a;     // Catch: Exception -> L44 CancellationException -> L47
        s3.c("task.run", "readiness timeout waitingFor=" + ((String) r106.element));     // Catch: Exception -> L44 CancellationException -> L47
        return new a(false, "手机模式未就绪，请稍后重试");
    L31:
        Map r112 = MapsKt.plus(ObricActionBarSendServiceDelegate.f392816b.v(), r110.a());     // Catch: Exception -> L44 CancellationException -> L47
        if (Intrinsics.areEqual(r112.get("o_task_type"), "complex_task") == false) goto L43;
        if (Intrinsics.areEqual(r112.get("o_task_state"), "start_complex_task") == false) goto L43;
        int r113 = s3.f387719a;     // Catch: Exception -> L44 CancellationException -> L47
        s3.b("task.run", "phone mode ready, sending textLength=" + r111.length());     // Catch: Exception -> L44 CancellationException -> L47
        CocreationTaskLauncher$run$3 r114 = new CocreationTaskLauncher$run$3(r108, r111, r112, null);     // Catch: Exception -> L44 CancellationException -> L47
        r100.L$0 = null;     // Catch: Exception -> L44 CancellationException -> L47
        r100.L$1 = null;     // Catch: Exception -> L44 CancellationException -> L47
        r100.L$2 = null;     // Catch: Exception -> L44 CancellationException -> L47
        r100.label = 2;     // Catch: Exception -> L44 CancellationException -> L47
        r102 = TimeoutKt.c(60000, r114, r100);     // Catch: Exception -> L44 CancellationException -> L47
        if (r102 != r103) goto L39;
        return r103;
    L43:
        return new a(false, "手机任务暂不可用，请稍后重试");
    L19:
        ResultKt.throwOnFailure(r102);
        IAssistantChatWindow r115 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r115 == null) goto L22;
        Boolean r116 = Boxing.boxBoolean(false);     // Catch: Exception -> L44 CancellationException -> L47
        Bundle r117 = new Bundle();     // Catch: Exception -> L44 CancellationException -> L47
        r117.putBoolean("arg_launch_half_screen", true);     // Catch: Exception -> L44 CancellationException -> L47
        Unit r118 = Unit.INSTANCE;     // Catch: Exception -> L44 CancellationException -> L47
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r115, "cocreation_task_center", false, r116, r117, false, false, null, null, false, false, 1008, null);     // Catch: Exception -> L44 CancellationException -> L47
        r106 = new Ref.ObjectRef();     // Catch: Exception -> L44 CancellationException -> L47
        r106.element = LiveEndPageData.TAG_WINDOW;     // Catch: Exception -> L44 CancellationException -> L47
        CocreationTaskLauncher$run$target$1 r119 = new CocreationTaskLauncher$run$target$1(r115, r106, null);     // Catch: Exception -> L44 CancellationException -> L47
        r100.L$0 = r210;     // Catch: Exception -> L44 CancellationException -> L47
        r111 = r211;
        r100.L$1 = r111;     // Catch: Exception -> L44 CancellationException -> L47
        r100.L$2 = r106;     // Catch: Exception -> L44 CancellationException -> L47
        r100.label = 1;     // Catch: Exception -> L44 CancellationException -> L47
        Object r120 = TimeoutKt.c(15000, r119, r100);     // Catch: Exception -> L44 CancellationException -> L47
        if (r120 != r103) goto L26;
        return r103;
    L26:
        r110 = r210;
        r102 = r120;
        goto L27
    L22:
        return new a(false, "豆包暂不可用，请稍后重试");
    L47:
        e = move-exception;
        throw e;
    L44:
        e = move-exception;
        int r121 = s3.f387719a;
        s3.c("task.run", "launch failed type=".concat(e.getClass().getSimpleName()));
        return new a(false, "任务启动失败，请稍后重试");
    L7:
        r100 = new CocreationTaskLauncher$run$1(this, r212);
        goto L8
    }
}
