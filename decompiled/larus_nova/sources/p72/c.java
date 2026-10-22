package p72;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.comment.event.OpenInputSource;
import com.bytedance.android.livesdk.interactivity.api.emoji.FusionEmojiApi;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u22.m;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements com.bytedance.android.livesdk.interactivity.api.emoji.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f527986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.emoji.a f527987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f527988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.interactivity.api.emoji.a> f527989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f527990f;

    public static final class a {
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f527991a = null;

        static {
            f527991a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return (int) (((com.bytedance.android.livesdk.interactivity.api.emoji.a) r101).f133118a - ((com.bytedance.android.livesdk.interactivity.api.emoji.a) r100).f133118a);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final void c() {
        Collections.sort(this.f527989e, this.f527990f);
        List r100 = CollectionsKt.toList(CollectionsKt.take(this.f527989e, this.f527986b));     // Catch: Exception -> L5
        f.d(new com.bytedance.android.livesdk.sharedpref.e(this.f527985a, ""), GsonHelper.get().toJson(r100));     // Catch: Exception -> L5
    L7:
        Disposable r101 = this.f527988d;
        if (r101 == null) goto L10;
        r101.dispose();
    L10:
        this.f527988d = null;
        return;
    L5:
        e = move-exception;
        SafetyGuard.a(null, e, "FusionEmoji,fun saveFusionEmojiAndQuit occurs error");
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final com.bytedance.android.livesdk.interactivity.api.emoji.a d() {
        com.bytedance.android.livesdk.interactivity.api.emoji.a r100 = this.f527987c;
        this.f527987c = null;
        return r100;
    }

    public final void g() {
    L12:
        e = move-exception;
        SafetyGuard.a(null, e, "FusionEmoji,fun getEmojiFromFile occurs error");
        return;
    L3:
        if (((ArrayList) this.f527989e).isEmpty() == false) goto L18;
        List r100 = (List) GsonHelper.get().fromJson((String) new com.bytedance.android.livesdk.sharedpref.e(this.f527985a, "").getValue(), List.class);     // Catch: Exception -> L12
        if (r100 == null) goto L19;
        Iterator r101 = r100.iterator();     // Catch: Exception -> L12
    L8:
        if (r101.hasNext() == false) goto L10;
        Object r102 = r101.next();     // Catch: Exception -> L12
        com.bytedance.android.livesdk.interactivity.api.emoji.a r103 = (com.bytedance.android.livesdk.interactivity.api.emoji.a) GsonHelper.get().fromJson(GsonHelper.get().toJson(r102), com.bytedance.android.livesdk.interactivity.api.emoji.a.class);     // Catch: Exception -> L12
        ((ArrayList) this.f527989e).add(r103);     // Catch: Exception -> L12
        goto L8
    L10:
        Collections.sort(this.f527989e, this.f527990f);     // Catch: Exception -> L12
        return;
    L19:
        return;
    }

    public c() {
        IMiddlewareUserService r100 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r100 == null) goto L8;
        com.bytedance.android.livesdk.user.e r101 = r100.user();
        if (r101 == null) goto L8;
        String r102 = r101.n();
        if (r102 == null) goto L8;
    L9:
        this.f527985a = r102.concat("_fusion_emoji_list");
        this.f527986b = 14;
        this.f527989e = new ArrayList();
        this.f527990f = b.f527991a;
        g();
        return;
    L8:
        r102 = "null";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final List<com.bytedance.android.livesdk.interactivity.api.emoji.a> f() {
        g();
        return CollectionsKt.take(this.f527989e, this.f527986b);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final void b(List<Long> r100) {
        List<Long> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        ArrayList r103 = new ArrayList();
        List r104 = (List) GsonHelper.get().fromJson((String) new com.bytedance.android.livesdk.sharedpref.e(this.f527985a, "").getValue(), List.class);     // Catch: Exception -> L27
        if (r104 == null) goto L38;
        Iterator r105 = r104.iterator();     // Catch: Exception -> L27
    L16:
        if (r105.hasNext() == false) goto L25;
        Object r106 = r105.next();     // Catch: Exception -> L27
        com.bytedance.android.livesdk.interactivity.api.emoji.a r107 = (com.bytedance.android.livesdk.interactivity.api.emoji.a) GsonHelper.get().fromJson(GsonHelper.get().toJson(r106), com.bytedance.android.livesdk.interactivity.api.emoji.a.class);     // Catch: Exception -> L27
        Long r108 = r107.b();     // Catch: Exception -> L27
        if (r108 == null) goto L20;
        long r109 = r108.longValue();     // Catch: Exception -> L27
    L22:
        if (r100.contains(Long.valueOf(r109)) == true) goto L16;
        r103.add(r107);     // Catch: Exception -> L27
        goto L16
    L20:
        r109 = 0;
        goto L22
    L25:
        f.d(new com.bytedance.android.livesdk.sharedpref.e(this.f527985a, ""), GsonHelper.get().toJson(r103));     // Catch: Exception -> L27
        return;
    L38:
        return;
    L27:
        e = move-exception;
        SafetyGuard.a(null, e, "FusionEmoji,fun deleteBanList occurs error");
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final void a(long r100, com.bytedance.android.livesdk.interactivity.api.emoji.a r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "emoji");
        Iterator<T> r103 = this.f527989e.iterator();
    L4:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        Long r105 = ((com.bytedance.android.livesdk.interactivity.api.emoji.a) r104).b();
        if (r105 != null) goto L9;
    L11:
        boolean r106 = false;
    L12:
        if (r106 == false) goto L4;
    L15:
        com.bytedance.android.livesdk.interactivity.api.emoji.a r107 = (com.bytedance.android.livesdk.interactivity.api.emoji.a) r104;
        if (r107 == null) goto L18;
        r107.f133118a = r102;
        return;
    L18:
        List<com.bytedance.android.livesdk.interactivity.api.emoji.a> r108 = this.f527989e;
        r101.f133118a = r102;
        Unit r109 = Unit.INSTANCE;
        ((ArrayList) r108).add(r101);
        return;
    L9:
        if (r105.longValue() != r100) goto L11;
        r106 = true;
        goto L12
    L14:
        r104 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.emoji.e
    public final void e(long r100, String r101, String r102) {
        String r103 = null;
        if (r101 != null) goto L26;
    L8:
        com.bytedance.android.livesdk.interactivity.api.emoji.a r104 = null;
    L9:
        if (r104 == null) goto L14;
        this.f527987c = r104;
        xs2.b r105 = xs2.b.a();
        m r106 = new m();
        r106.f548441l = OpenInputSource.InputFusionEmojiEvent;
        if (r102 == null) goto L13;
        r106.f548435f = r102;
    L13:
        Unit r107 = Unit.INSTANCE;
        r105.post(r106);
        return;
    L14:
        IRoomContextService r108 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r108 == null) goto L23;
        o r109 = IRoomContextService.a.a(r108, null, 0, 3);
        if (r109 == null) goto L23;
        com.bytedance.live.datacontext.m<IRoom> r110 = r109.getRoom();
        if (r110 == null) goto L23;
        IRoom r111 = r110.getValue();
        if (r111 == null) goto L23;
        r103 = String.valueOf(r111.getRoomId());
    L23:
        if (r103 == null) goto L29;
        this.f527988d = ((FusionEmojiApi) com.bytedance.android.live.network.c.b().e(FusionEmojiApi.class)).getFusionEmojiInfo(MapsKt.mapOf(new Pair[]{TuplesKt.to("room_id", r103), TuplesKt.to("emoji_id", String.valueOf(r100))})).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this, r102), new e(r100, r103));
        return;
    L29:
        return;
    L26:
        r104 = (com.bytedance.android.livesdk.interactivity.api.emoji.a) GsonHelper.get().fromJson(r101, com.bytedance.android.livesdk.interactivity.api.emoji.a.class);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        SafetyGuard.a(null, e, "FusionEmoji,fun inputFusionEmoji occurs error");
        goto L8
    }
}
