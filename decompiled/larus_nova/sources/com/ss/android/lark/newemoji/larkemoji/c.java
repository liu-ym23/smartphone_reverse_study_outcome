package com.ss.android.lark.newemoji.larkemoji;

import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.EmojiListView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReentrantLock f433050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, MutableLiveData<String>> f433051b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<ssb.c> f433052c = null;

    static {
        f433050a = new ReentrantLock();
        f433051b = new LinkedHashMap();
        f433052c = new ArrayList();
    }

    public static void b() {
        Unit r100 = (Unit) g(LarkEmojiSource$notifyEmojiDataChange$1.INSTANCE);
    }

    public static MutableLiveData a(String r100) {
        LinkedHashMap r101 = (LinkedHashMap) f433051b;
        Object r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r102 = new MutableLiveData(r100);
        r101.put(r100, r102);
    L6:
        return (MutableLiveData) r102;
    }

    public static void c(final EmojiListView r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Unit r101 = (Unit) g(new LarkEmojiSource$registerEmojiDataChangeListener$1(r100));
    }

    public static b d(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        return null;
    L12:
        return new b(r100, a(r100));
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void e(final ssb.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Unit r101 = (Unit) g(new LarkEmojiSource$unRegisterEmojiDataChangeListener$1(r100));
    }

    public static Object g(Function0 r100) {
        ReentrantLock r101 = f433050a;     // Catch: Throwable -> L6 Exception -> L8
        r101.lock();     // Catch: Throwable -> L6 Exception -> L8
        Object r102 = r100.invoke();     // Catch: Throwable -> L6 Exception -> L8
        r101.unlock();
        return r102;
    L8:
        e = move-exception;
        Log.e("LarkEmojiSource", "withLock: " + e.getMessage());     // Catch: Throwable -> L6
        f433050a.unlock();
        return null;
    L6:
        th = move-exception;
        f433050a.unlock();
        throw th;
    }

    public static void f(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "emojiId");
        Intrinsics.checkNotNullParameter(r101, "updatedSkinedKey");
        Unit r102 = (Unit) g(new LarkEmojiSource$updateReactionSkin$1(r100, r101));
    }
}
