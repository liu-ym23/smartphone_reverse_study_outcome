package com.ss.android.lark.chat.chatwindow.chat.model.preload.v2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.biz.im.api.extension.message.f;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.preload.v2.task.OneTimeTask;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import o1c.c;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J`\u0010\u000e\u001a\u00020\u00032\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162 \u0010\u0018\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u001a\u0018\u00010\u0019H\u0002J#\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ#\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0002\u0010\u001eJ \u0010 \u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\f\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019H\u0016J\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006$"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/model/preload/v2/AudioResourceLoadTask;", "Lcom/ss/android/lark/preload/v2/task/OneTimeTask;", "Lcom/ss/android/lark/chat/chatwindow/chat/model/preload/v2/AudioResourceLoadTask$Params;", "", "<init>", "()V", "biz", "Lcom/ss/android/lark/appreciablelib/Biz;", "getBiz", "()Lcom/ss/android/lark/appreciablelib/Biz;", "doPreloadExt", "", "params", "doPreload", "load", "messageInfoList", "", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "forceFetch", "loadTaskContext", "Lcom/ss/android/lark/biz/im/api/extension/message/MessageResourceLoadTaskContext;", "previewId", "", "msgLinkToken", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "getCacheExt", "extra", "", "(Lcom/ss/android/lark/chat/chatwindow/chat/model/preload/v2/AudioResourceLoadTask$Params;Ljava/lang/Object;)Ljava/lang/Boolean;", "getCache", "forceLoad", "getCacheKeys", "Companion", "Params", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioResourceLoadTask extends OneTimeTask<b, Boolean> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f413402q = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Biz f413403p;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<? extends MessageInfo> f413404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f413405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f413406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f413407d;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 15);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f413404a, r101.f413404a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413405b, r101.f413405b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f413406c, r101.f413406c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f413407d, r101.f413407d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f413404a.hashCode() * 31;
            f r101 = this.f413405b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f413406c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f413407d;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(messageInfoSet=" + this.f413404a + ", loadTaskContext=" + this.f413405b + ", previewId=" + this.f413406c + ", msgLinkToken=" + this.f413407d + ')';
        }

        public /* synthetic */ b(Set r100, f r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = SetsKt.emptySet();
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101, null, null);
        }

        public b(Set<? extends MessageInfo> r100, f r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "messageInfoSet");
            this.f413404a = r100;
            this.f413405b = r101;
            this.f413406c = r102;
            this.f413407d = r103;
        }
    }

    static {
    }

    public AudioResourceLoadTask() {
        this.f413403p = Biz.Messenger;
    }

    @Override // o1c.c
    public final Biz getBiz() {
        return this.f413403p;
    }

    public static Set h(b r100) {
        HashSet r101 = new HashSet();
        if (r100 == null) goto L12;
        Set<? extends MessageInfo> r102 = r100.f413404a;
        if (r102 == null) goto L12;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L12;
        MessageInfo r104 = (MessageInfo) r103.next();
        if (r104 == null) goto L8;
        r101.add(r104.getId());
    L12:
        return r101;
    }

    @Override // o1c.a
    public final /* bridge */ /* synthetic */ void d(Object r100) {
        g((b) r100);
    }

    @Override // o1c.a
    public final void e(Object r100) {
        this.f521748m = SystemClock.elapsedRealtime();
        g((b) r100);
    }

    @Override // o1c.a
    public final /* bridge */ /* synthetic */ Set f(Object r100) {
        return h((b) r100);
    }

    public final void g(b r110) {
        final Set r100 = h(r110);
        this.f521748m = SystemClock.elapsedRealtime();
        c.a r101 = this.f521746k;
        if (r101 == null) goto L5;
        r101.e(this, ((HashSet) r100).size());
    L5:
        if (r110 == null) goto L8;
        i(r110.f413404a, false, r110.f413405b, r110.f413406c, r110.f413407d, new AudioResourceLoadTask$doPreload$1$1(this, r100));
        return;
    }

    @Override // o1c.c
    public final Object j(Object r100) {
        if (r100 == null) goto L26;
        Set r101 = SetsKt.setOf((String) r100);
        o1c.b r102 = this.f521749n;
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L10:
        c.a r104 = this.f521746k;
        if (r104 == null) goto L13;
        r104.k(this, r103, MapsKt.mapOf(TuplesKt.to("source_type", "")));
    L13:
        o1c.b r105 = this.f521749n;
        if (r105 != null) goto L16;
    L18:
        boolean r106 = false;
    L19:
        if (r103 == false) goto L25;
        if (r106 == true) goto L25;
        c.a r107 = this.f521746k;
        if (r107 == null) goto L25;
        r107.m(this, MapsKt.mapOf(new Pair[]{TuplesKt.to("source_type", ""), TuplesKt.to("first_hit_interval", Long.valueOf(SystemClock.elapsedRealtime() - this.f521748m))}));
    L25:
        return Boolean.valueOf(r103);
    L16:
        if (r105.c(this, r101) != true) goto L18;
        r106 = true;
        goto L19
    L7:
        if (r102.d(this, r101) != true) goto L9;
        r103 = true;
        goto L10
    L26:
        return Boolean.FALSE;
    }

    @Override // o1c.a, o1c.c
    public final void J1(Object r100, IGetDataCallback r101) {
        b r102 = (b) r100;
        if (r102 == null) goto L6;
        i(r102.f413404a, true, r102.f413405b, r102.f413406c, r102.f413407d, r101);
        return;
    }

    public static void i(Set r110, final boolean r111, final f r112, final String r113, final String r114, final IGetDataCallback r115) {
        Log.i("AudioResourceLoadTask", "load audio forceLoad =" + r111);
        final HashMap r100 = new HashMap();
        final HashMap r101 = new HashMap();
        Iterator r116 = r110.iterator();
    L4:
        if (r116.hasNext() == false) goto L25;
        MessageInfo r102 = (MessageInfo) r116.next();
        if (r102 == null) goto L8;
        Message r103 = r102.getMessage();
    L9:
        if (r103 == null) goto L4;
        if (r102.getMessage().getType() != Message.Type.AUDIO) goto L4;
        Message r104 = r102.getMessage();
        AudioContent r105 = (AudioContent) r104.getContent();
        String r106 = r105.getKey();
        if (TextUtils.isEmpty(r106) == true) goto L4;
        if (r111 == true) goto L21;
        if (TextUtils.isEmpty(r105.getLocalFilePath()) == true) goto L21;
        if (r105.getAudioWaveBytes() != null) goto L4;
    L21:
        if (TextUtils.equals(r104.getId(), r104.getcId()) == true) goto L4;
        String r107 = r104.getId();
        r100.put(r106, r107);
        r101.put(r107, r102);
        goto L4
    L8:
        r103 = null;
        goto L9
    L25:
        if (CollectionUtils.isEmpty(r100) == false) goto L27;
        return;
    L27:
        if (r111 == false) goto L32;
        Iterator r117 = r100.entrySet().iterator();
    L30:
        if (r117.hasNext() == false) goto L32;
        Map.Entry r108 = (Map.Entry) r117.next();
        Log.i("AudioResourceLoadTask", "forceFetch audio key:" + ((String) r108.getKey()) + ", messageId:" + ((String) r108.getValue()));
    L32:
        Log.d("AudioResourceLoadTask", "prepareAudioMessage1:" + r100.size() + ", previewId: " + r113);
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AudioResourceLoadTask$load$2(r111, r100, r113, r114, r101, r112, r115));
    }
}
