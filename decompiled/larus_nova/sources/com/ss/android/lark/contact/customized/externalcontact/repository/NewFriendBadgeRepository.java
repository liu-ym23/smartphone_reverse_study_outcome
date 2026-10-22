package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import mtb.k;

/* JADX INFO: loaded from: classes35.dex */
public final class NewFriendBadgeRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f419129a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f419130b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalcontact/repository/NewFriendBadgeRepository$Source;", "", "<init>", "(Ljava/lang/String;I)V", "EXTERNAL_API", "INTERNAL", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Source extends Enum<Source> {
        public static final Source EXTERNAL_API = null;
        public static final Source INTERNAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Source[] f419131a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f419132b = null;

        public static EnumEntries<Source> getEntries() {
            return f419132b;
        }

        static {
            Source r100 = new Source("EXTERNAL_API", 0);
            EXTERNAL_API = r100;
            Source r101 = new Source("INTERNAL", 1);
            INTERNAL = r101;
            Source[] r102 = {r100, r101};
            f419131a = r102;
            f419132b = EnumEntriesKt.enumEntries(r102);
        }

        public static Source[] values() {
            return (Source[]) f419131a.clone();
        }

        public static Source valueOf(String r100) {
            return (Source) r27.a.a(Source.class, r100);
        }

        public Source(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements com.ss.android.lark.contact.customized.externalcontact.repository.a {

        /* JADX INFO: renamed from: com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository$a$a, reason: collision with other inner class name */
        public static final class RunnableC4934a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f419133a;

            public RunnableC4934a(k r100) {
                this.f419133a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                CopyOnWriteArrayList r100 = (CopyOnWriteArrayList) NewFriendBadgeRepository.f419129a.getValue();     // Catch: Throwable -> L7
                k r101 = this.f419133a;     // Catch: Throwable -> L7
                Iterator r102 = r100.iterator();     // Catch: Throwable -> L7
            L4:
                if (r102.hasNext() == false) goto L16;
                ((ltb.b) r102.next()).a(r101);     // Catch: Throwable -> L7
                goto L4
            L16:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L11;
                return;
            L11:
                throw th;
            }
        }

        public a() {
        }

        @Override // com.ss.android.lark.contact.customized.externalcontact.repository.a
        public final void a(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "requestText");
            Log.i("Contact_NewFriendBadge", "onPush badge=" + r100 + " requestText=" + r101);
            k r102 = new k(r100, r101);
            Lazy r103 = NewFriendBadgeRepository.f419129a;
            CoreThreadPool.getDefault().getUIExecutor().execute(new RunnableC4934a(r102));
        }
    }

    static {
        f419129a = LazyKt.lazy(NewFriendBadgeRepository$listeners$2.INSTANCE);
        Intrinsics.checkNotNullParameter("", "requestName");
        f419130b = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository$getBadge$1] */
    public static void a(Source r100, final ltb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Log.i("Contact_NewFriendBadge", "getBadge start source=" + r100);
        ImSdkService.d().L2(new NewFriendBadgeRepository$getBadge$1(r101));
    }
}
