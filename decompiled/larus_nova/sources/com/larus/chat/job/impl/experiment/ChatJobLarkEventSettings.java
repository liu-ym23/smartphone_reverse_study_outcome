package com.larus.chat.job.impl.experiment;

import com.bytedance.keva.Keva;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class ChatJobLarkEventSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChatJobLarkEventSettings f325056a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f325057b = null;

    /* JADX INFO: renamed from: com.larus.chat.job.impl.experiment.ChatJobLarkEventSettings$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(Object r100) {
            super(0, r100, ChatJobLarkEventSettings.class, "refresh", "refresh()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChatJobLarkEventSettings r100 = (ChatJobLarkEventSettings) this.receiver;
            ChatJobLarkEventSettings r101 = ChatJobLarkEventSettings.f325056a;
            r100.getClass();
            String r102 = AccountService.f365697a.getUserId();
            if (StringsKt.isBlank(r102) == true) goto L7;
            int r103 = na9.a.f518484a;
            boolean r104 = Intrinsics.areEqual(ga9.a.e("enable_lark_event", "0"), "1");
            ((Keva) ChatJobLarkEventSettings.f325057b.getValue()).storeBoolean("chat_job_enable_lark_event::".concat(r102), r104);
            FLogger.f375446a.i("ChatJobExperiment", "update uid-scoped lark event settings enabled=" + r104);
            return;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public ChatJobLarkEventSettings() {
    }

    static {
        ChatJobLarkEventSettings r100 = new ChatJobLarkEventSettings();
        f325056a = r100;
        f325057b = LazyKt.lazy(new a());
        z2.f365865a.i2(new AnonymousClass1(r100));
    }

    public static boolean a() {
        String r100 = AccountService.f365697a.getUserId();
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Keva) f325057b.getValue()).getBoolean("chat_job_enable_lark_event::".concat(r100), false) == false) goto L7;
        return true;
    }
}
