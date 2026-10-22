package com.ss.android.lark.widget.photopicker.gallery;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.common.TeaEventTrack;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class OriginalMediaHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<String> f447531a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<PhotoItem> f447532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f447533b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends PhotoItem> r100, Runnable r101) {
            this.f447532a = r100;
            this.f447533b = r101;
        }

        public final void a() {
            Log.i("OriginalMediaHandler", "syncMarkOriginalMedia start");
            CopyOnWriteArraySet<String> r100 = OriginalMediaHandler.f447531a;
            List<PhotoItem> r101 = this.f447532a;
            ArrayList r102 = new ArrayList();
            Iterator<T> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L8;
            Object r104 = r103.next();
            if (((PhotoItem) r104).isVideo() == false) goto L4;
            r102.add(r104);
            goto L4
        L8:
            ArrayList r105 = new ArrayList();
            Iterator r106 = r102.iterator();
        L10:
            if (r106.hasNext() == false) goto L15;
            String r107 = ((PhotoItem) r106.next()).getMessageId();
            if (r107 == null) goto L10;
            r105.add(r107);
            goto L10
        L15:
            if ((!r105.isEmpty()) == false) goto L40;
            Map r108 = f.a().H();
            if (r108 == null) goto L40;
            Collection r109 = r108.values();
            if (r109 == null) goto L40;
            Sequence r110 = CollectionsKt.asSequence(r109);
            if (r110 == null) goto L40;
            Sequence r111 = SequencesKt.filter(r110, OriginalMediaHandler$syncMarkOriginalMedia$1.INSTANCE);
            if (r111 == null) goto L40;
            Sequence r112 = SequencesKt.mapNotNull(r111, OriginalMediaHandler$syncMarkOriginalMedia$2.INSTANCE);
            if (r112 == null) goto L40;
            Iterator r113 = r112.iterator();
        L28:
            if (r113.hasNext() == false) goto L40;
            String r114 = (String) r113.next();
            Iterator<T> r115 = r101.iterator();
        L31:
            if (r115.hasNext() == false) goto L35;
            Object r116 = r115.next();
            if (Intrinsics.areEqual(r114, ((PhotoItem) r116).getMessageId()) == false) goto L31;
        L36:
            PhotoItem r117 = (PhotoItem) r116;
            if (r117 == null) goto L39;
            r117.setOriginal(true);
        L39:
            Log.i("OriginalMediaHandler", "syncMarkOriginalMediaIfNeed msgId:" + r114);
            goto L28
        L35:
            r116 = null;
        L40:
            Log.i("OriginalMediaHandler", "syncMarkOriginalMedia end");
            UICallbackExecutor.execute(this.f447533b);
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

    static {
        f447531a = new CopyOnWriteArraySet();
    }

    @JvmStatic
    public static final void a(List<? extends PhotoItem> r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "photoItems");
        Intrinsics.checkNotNullParameter(r101, TeaEventTrack.ACTION_DRAMA_NEXT);
        Log.i("OriginalMediaHandler", "markOriginalMediaIfNeed");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (((PhotoItem) r104).isVideo() == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r102.iterator();
    L10:
        if (r106.hasNext() == false) goto L15;
        String r107 = ((PhotoItem) r106.next()).getMessageId();
        if (r107 == null) goto L10;
        r105.add(r107);
        goto L10
    L15:
        if ((!r105.isEmpty()) == true) goto L17;
        UICallbackExecutor.execute(r101);
    L18:
        Log.i("OriginalMediaHandler", "run next finish");
        return;
    L17:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(r100, r101));
        goto L18
    }

    @JvmStatic
    public static final void b(final Context r100, final String r101, final Runnable r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r102, "default");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r102.run();
        return;
    L6:
        CopyOnWriteArraySet<String> r103 = f447531a;
        if (r103.contains(r101) == false) goto L9;
        return;
    L9:
        r103.add(r101);
        final IGetDataCallback<Message> r104 = new OriginalMediaHandler$routeToFileIfNeed$1(r101, r100, r102);
        final long r105 = System.currentTimeMillis();
        f.d r106 = f.a();
        new OriginalMediaHandler$convertMediaToFileIfNeed$1(r101, r105, r104);
        r106.m8699d();
    }
}
