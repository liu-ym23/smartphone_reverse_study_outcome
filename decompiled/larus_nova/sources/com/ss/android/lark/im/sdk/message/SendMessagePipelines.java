package com.ss.android.lark.im.sdk.message;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.im.sdk.message.send.CompressMediaStep;
import com.ss.android.lark.im.sdk.message.send.FinalSendMessageStep;
import com.ss.android.lark.im.sdk.message.send.i;
import com.ss.android.lark.im.sdk.message.send.j;
import com.ss.android.lark.im.sdk.message.send.k;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class SendMessagePipelines {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.message.send.b f425909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.message.send.e f425910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.message.send.c f425911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f425912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.message.send.h f425913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompressMediaStep f425914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final FinalSendMessageStep f425915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f425916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f425917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f425918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f425919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.ss.android.lark.im.sdk.message.send.c f425920l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f425921m;

    public static final class a {
    }

    public interface b {
        void I(MessageInfo r100);
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendMessagePipelines f425922a;

        public c(SendMessagePipelines r100) {
            this.f425922a = r100;
        }

        @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines.b
        public final void I(MessageInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            SendMessagePipelines.a(this.f425922a, r100);
        }
    }

    public static final class d implements nkb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f425923a = null;

        static {
            f425923a = new d();
        }

        public d() {
        }

        @Override // nkb.a
        public final ChatChatter a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return ImSdkService.d().x1(r100);
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendMessagePipelines f425924a;

        public e(SendMessagePipelines r100) {
            this.f425924a = r100;
        }

        @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines.b
        public final void I(MessageInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            SendMessagePipelines.a(this.f425924a, r100);
        }
    }

    public static final class f implements nkb.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f425925a = null;

        static {
            f425925a = new f();
        }

        public f() {
        }

        @Override // nkb.a
        public final ChatChatter a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return ImSdkService.d().x1(r100);
        }
    }

    public static final class g implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendMessagePipelines f425926a;

        public g(SendMessagePipelines r100) {
            this.f425926a = r100;
        }

        @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines.b
        public final void I(MessageInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            SendMessagePipelines.a(this.f425926a, r100);
        }
    }

    public static final class h implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendMessagePipelines f425927a;

        public h(SendMessagePipelines r100) {
            this.f425927a = r100;
        }

        @Override // com.ss.android.lark.im.sdk.message.SendMessagePipelines.b
        public final void I(MessageInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            SendMessagePipelines.a(this.f425927a, r100);
        }
    }

    public String c() {
        return "ImSdkSendPipelines";
    }

    public jkb.d<k> e() {
        return null;
    }

    static {
        new SendMessagePipelines();
    }

    public SendMessagePipelines() {
        this.f425909a = new com.ss.android.lark.im.sdk.message.send.b();
        com.ss.android.lark.im.sdk.message.c r100 = com.ss.android.lark.im.sdk.message.c.f425934a;
        this.f425910b = new com.ss.android.lark.im.sdk.message.send.e();
        this.f425911c = new com.ss.android.lark.im.sdk.message.send.c(false, new c(this), d.f425923a);
        this.f425912d = new j(i.f425983a);
        this.f425913e = new com.ss.android.lark.im.sdk.message.send.h(new h(this));
        this.f425914f = new CompressMediaStep(new g(this));
        this.f425915g = new FinalSendMessageStep(com.ss.android.lark.im.sdk.message.send.g.f425980a);
        LazyThreadSafetyMode r101 = LazyThreadSafetyMode.SYNCHRONIZED;
        this.f425916h = LazyKt.lazy(r101, new SendMessagePipelines$specialSendMessagePipelineMap$2(this));
        this.f425917i = LazyKt.lazy(r101, new SendMessagePipelines$flowMediaSendMessagePipeline$2(this));
        this.f425918j = LazyKt.lazy(r101, new SendMessagePipelines$doubaoFileSendMessagePipeline$2(this));
        this.f425919k = LazyKt.lazy(r101, new SendMessagePipelines$commonSendMessagePipeline$2(this));
        this.f425920l = new com.ss.android.lark.im.sdk.message.send.c(true, new e(this), f.f425925a);
        this.f425921m = LazyKt.lazy(r101, new SendMessagePipelines$sendLocalPreMessagePipeline$2(this));
    }

    public FinalSendMessageStep b() {
        return this.f425915g;
    }

    public j d() {
        return this.f425912d;
    }

    public static final void a(SendMessagePipelines r100, MessageInfo r101) {
        r100.getClass();
        ImSdkService.e().I(r101);
    }
}
