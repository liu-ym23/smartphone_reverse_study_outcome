package xc0;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.m;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f563200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function2 f563201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f563202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f563203d;

    public f(d r100, Function2 r101, String r102, String r103) {
        this.f563200a = r100;
        this.f563201b = r101;
        this.f563202c = r102;
        this.f563203d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        m r102 = null;
        if (TextUtils.isEmpty(r101) == false) goto L17;
        this.f563201b.invoke(Boolean.FALSE, null);
        ALogger.e("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#file empty:" + this.f563202c);
        return;
    L17:
        r102 = (m) GsonHelper.get().fromJson(r101, m.class);     // Catch: Throwable -> L7
    L9:
        if (r102 == null) goto L15;
        d r103 = this.f563200a;
        String r104 = this.f563203d;
        r103.getClass();
        d.a(r104, r102.getSenderEmoji());
        d.a(r104, r102.getPathEmoji());
        d.a(r104, r102.getReceiverEmoji());
        LruCache<String, m> r105 = h.f563206a;
        String r106 = this.f563202c;
        Intrinsics.checkNotNullParameter(r106, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (TextUtils.isEmpty(r106) == true) goto L14;
        h.f563206a.put(r106, r102);
    L14:
        this.f563201b.invoke(Boolean.TRUE, r102);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse success:" + this.f563202c + ",data:" + r102);
        return;
    L15:
        this.f563201b.invoke(Boolean.FALSE, r102);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse failed:" + this.f563202c);
        return;
    L7:
        th = move-exception;
        ALogger.e("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#JSON parse error:" + th);
        goto L9
    }
}
