package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.larksuite.framework.thread.n;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f413974a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<C4829a, b> f413975b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<C4829a, Object> f413976c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<c> f413977d = null;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a$a, reason: collision with other inner class name */
    public static final class C4829a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f413978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PageType f413979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f413980c;

        public final String toString() {
            return "DataKey(chatId=" + this.f413978a + ", pageType=" + this.f413979b + ", uuid=" + this.f413980c + ')';
        }

        public final int hashCode() {
            return (this.f413978a.hashCode() * 31) + this.f413979b.hashCode();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(C4829a.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.FullScreenVODataCenter.DataKey");
            C4829a r102 = (C4829a) r100;
            if (Intrinsics.areEqual(this.f413978a, r102.f413978a) == true) goto L16;
            return false;
        L16:
            if (this.f413979b == r102.f413979b) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(this.f413980c, r102.f413980c) == true) goto L21;
            return false;
        L21:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public C4829a(String r100, PageType r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "chatId");
            Intrinsics.checkNotNullParameter(r101, "pageType");
            Intrinsics.checkNotNullParameter(r102, ST.UUID_DEVICE);
            this.f413978a = r100;
            this.f413979b = r101;
            this.f413980c = r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a$b$a, reason: collision with other inner class name */
        public static final class C4830a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(null, null) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "DataUpdateTask(key=null, messageId=null, messageVO=null, message=null)";
        }
    }

    public static abstract class c {
        public c(C4829a r100) {
            Intrinsics.checkNotNullParameter(r100, "dataKey");
        }
    }

    static {
        f413974a = PThreadExecutorsUtils.newSingleThreadExecutor(new n("FullVODataCenter"));
        f413975b = new ConcurrentHashMap();
        f413976c = new ConcurrentHashMap();
        f413977d = new CopyOnWriteArrayList();
    }
}
