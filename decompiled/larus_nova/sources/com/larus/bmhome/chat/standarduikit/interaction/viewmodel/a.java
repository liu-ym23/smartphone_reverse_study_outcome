package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f309320e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f309321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<b> f309322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<b, Integer> f309323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<b, Function0<Unit>> f309324d;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C4074a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f309325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f309326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f309327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f309328d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f309325a, r101.f309325a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f309326b, r101.f309326b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f309327c, r101.f309327c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f309328d, r101.f309328d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f309325a.hashCode() * 31) + this.f309326b.hashCode()) * 31) + this.f309327c.hashCode()) * 31) + this.f309328d.hashCode();
        }

        public final String toString() {
            return "Key(accountId=" + this.f309325a + ", conversationId=" + this.f309326b + ", messageId=" + this.f309327c + ", blockId=" + this.f309328d + ')';
        }

        public b(String r100, String r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "accountId");
            Intrinsics.checkNotNullParameter(r101, "conversationId");
            Intrinsics.checkNotNullParameter(r102, "messageId");
            Intrinsics.checkNotNullParameter(r103, WikiFolderPushPlugin.BLOCK_ID);
            this.f309325a = r100;
            this.f309326b = r101;
            this.f309327c = r102;
            this.f309328d = r103;
        }
    }

    static {
        f309320e = new a();
    }

    public a() {
        this.f309321a = 512;
        this.f309322b = new LinkedHashSet();
        this.f309323c = new LinkedHashMap();
        this.f309324d = new LinkedHashMap();
    }

    public final synchronized boolean a(b r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L16
        if (this.f309322b.add(r100) == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        this.f309324d.remove(r100);     // Catch: Throwable -> L16
    L10:
        if (this.f309322b.size() <= this.f309321a) goto L13;
        Iterator<b> r101 = this.f309322b.iterator();     // Catch: Throwable -> L16
        r101.next();     // Catch: Throwable -> L16
        r101.remove();     // Catch: Throwable -> L16
        goto L10
    L13:
        monitor-exit(this);
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        monitor-enter(this);
        Integer r101 = (Integer) ((LinkedHashMap) this.f309323c).get(r100);     // Catch: Throwable -> L21
        if (r101 == null) goto L19;
        int r102 = r101.intValue() - 1;     // Catch: Throwable -> L21
        if (r102 <= 0) goto L9;
        this.f309323c.put(r100, Integer.valueOf(r102));     // Catch: Throwable -> L21
    L14:
        Function0<Unit> r103 = null;
    L15:
        monitor-exit(this);
        if (r103 == null) goto L25;
        r103.invoke();
        return;
    L25:
        return;
    L9:
        this.f309323c.remove(r100);     // Catch: Throwable -> L21
        r103 = this.f309324d.remove(r100);     // Catch: Throwable -> L21
        if (r103 == null) goto L14;
        if (this.f309322b.contains(r100) == true) goto L14;
    L19:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
