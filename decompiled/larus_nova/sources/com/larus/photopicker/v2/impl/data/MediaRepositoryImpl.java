package com.larus.photopicker.v2.impl.data;

import android.util.LongSparseArray;
import android.util.SparseArray;
import androidx.lifecycle.MutableLiveData;
import com.larus.photopicker.v2.impl.data.model.LazyLoadConfig;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.e0;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;
import pp9.i;

/* JADX INFO: loaded from: classes31.dex */
public final class MediaRepositoryImpl implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f364353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LazyLoadConfig f364354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f364355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutexImpl f364356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f364357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final op9.b f364358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<List<mp9.b>> f364359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData f364360h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f364361a = null;

        static {
            int[] r100 = new int[MediaTab.values().length];
            r100[MediaTab.ALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MediaTab.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MediaTab.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f364361a = r100;
        }
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final MutableLiveData g() {
        return this.f364360h;
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final List<mp9.b> h(mp9.c r210) {
        Intrinsics.checkNotNullParameter(r210, "mediaItem");
        List<mp9.b> r100 = this.f364359g.getValue();
        if (r100 == null) goto L74;
        List r101 = CollectionsKt.toMutableList(r100);
        if (r101 == null) goto L86;
        int r102 = 2;
        int r103 = 1;
        Set r104 = SetsKt.setOf(new Long[]{-1L, Long.valueOf(r210.f514736e)});
        List r105 = r101;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
        boolean r108 = false;
    L9:
        if (r107.hasNext() == false) goto L69;
        mp9.b r110 = (mp9.b) r107.next();
        if (r104.contains(Long.valueOf(r110.f514726a)) == true) goto L13;
        Iterator r111 = r107;
        boolean r112 = r108;
    L65:
        r108 = r112;
    L67:
        r106.add(r110);
        r107 = r111;
        r102 = 2;
        r103 = 1;
        goto L9
    L13:
        Map r113 = MapsKt.toMutableMap(r110.f514731f);
        Map r114 = MapsKt.toMutableMap(r110.f514730e);
        Iterator<Map.Entry<MediaTab, List<mp9.c>>> r115 = r110.f514731f.entrySet().iterator();
        boolean r116 = false;
    L15:
        if (r115.hasNext() == false) goto L63;
        Map.Entry<MediaTab, List<mp9.c>> r117 = r115.next();
        MediaTab r109 = r117.getKey();
        List<mp9.c> r118 = r117.getValue();
        int r119 = a.f364361a[r109.ordinal()];
        if (r119 == r103) goto L30;
        if (r119 == r102) goto L27;
        if (r119 != 3) goto L25;
        if (r210.getType() == MediaType.VIDEO) goto L30;
    L29:
        boolean r120 = false;
    L31:
        if (r120 == true) goto L33;
        Iterator r121 = r107;
        boolean r122 = r108;
    L62:
        r108 = r122;
        r107 = r121;
        r102 = 2;
        r103 = 1;
        goto L15
    L33:
        List<mp9.c> r123 = r118;
        if ((r123 instanceof Collection) == true) goto L36;
    L38:
        Iterator r124 = r123.iterator();
    L40:
        if (r124.hasNext() == false) goto L37;
        mp9.c r125 = (mp9.c) r124.next();
        r122 = r108;
        r121 = r107;
        Iterator r211 = r124;
        if (r125.f514732a != r210.f514732a) goto L44;
    L47:
        boolean r126 = true;
    L48:
        if (r126 == true) goto L49;
        r108 = r122;
        r107 = r121;
        r124 = r211;
        goto L40
    L49:
        boolean r127 = true;
    L52:
        if (r127 == true) goto L62;
        ArrayList r128 = new ArrayList();
        r128.add(r210);
        r128.addAll(r118);
        r113.put(r109, r128);
        Integer r129 = (Integer) r114.get(r109);
        if (r129 != null) goto L59;
        r129 = r110.f514730e.get(r109);
        if (r129 != null) goto L59;
        int r130 = 0;
    L61:
        r114.put(r109, Integer.valueOf(r130 + 1));
        this.f364358f.b(r110.f514726a, r109, r128);
        r116 = true;
    L59:
        r130 = r129.intValue();
        goto L61
    L44:
        if (Intrinsics.areEqual(r125.f514733b, r210.f514733b) == true) goto L47;
        r126 = false;
    L37:
        r121 = r107;
        r122 = r108;
        r127 = false;
        goto L52
    L36:
        if (r123.isEmpty() == false) goto L38;
    L25:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r210.getType() != MediaType.IMAGE) goto L29;
    L30:
        r120 = true;
        goto L31
    L63:
        r111 = r107;
        r112 = r108;
        if (r116 == false) goto L65;
        r110 = mp9.b.a(r110, r110.f514729d + 1, r114, r113, 7);
        r108 = true;
        goto L67
    L69:
        if (r108 == false) goto L72;
        this.f364359g.postValue(r106);
        return r106;
    L72:
        return null;
    L86:
        return null;
    L74:
        return null;
    }

    public MediaRepositoryImpl(ContentResolverMediaSource r100, LazyLoadConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "mediaSource");
        Intrinsics.checkNotNullParameter(r101, "lazyLoadConfig");
        this.f364353a = r100;
        this.f364354b = r101;
        this.f364355c = "MediaRepositoryImpl";
        this.f364356d = kotlinx.coroutines.sync.b.a();
        this.f364358f = new op9.b();
        MutableLiveData<List<mp9.b>> r102 = new MutableLiveData(CollectionsKt.emptyList());
        this.f364359g = r102;
        this.f364360h = r102;
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object a(String r100, Continuation<? super mp9.c> r101) {
        return this.f364353a.a(r100, r101);
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object b(mp9.a r110, Continuation<? super Integer> r111) {
        if ((r111 instanceof MediaRepositoryImpl$getCurPage$1) == false) goto L7;
        MediaRepositoryImpl$getCurPage$1 r100 = (MediaRepositoryImpl$getCurPage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        int r104 = 1;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$1;
        mp9.a r105 = (mp9.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
        kotlinx.coroutines.sync.a r114 = r113;
        r110 = r105;
    L59:
        Long r106 = r110.f514724a;     // Catch: Throwable -> L56
        int r107 = 0;
        if (r106 == null) goto L53;
        long r108 = r106.longValue();     // Catch: Throwable -> L56
        MediaTab r115 = r110.f514725b;     // Catch: Throwable -> L56
        if (r115 != null) goto L24;
        Integer r116 = Boxing.boxInt(0);     // Catch: Throwable -> L56
        r114.unlock(null);
        return r116;
    L24:
        int r109 = this.f364354b.f364368b;     // Catch: Throwable -> L56
        List<mp9.b> r117 = this.f364359g.getValue();     // Catch: Throwable -> L56
        if (r117 != null) goto L29;
        Integer r118 = Boxing.boxInt(0);     // Catch: Throwable -> L56
        r114.unlock(null);
        return r118;
    L29:
        Iterator<T> r119 = r117.iterator();     // Catch: Throwable -> L56
    L31:
        if (r119.hasNext() == false) goto L38;
        Object r120 = r119.next();     // Catch: Throwable -> L56
        if (((mp9.b) r120).f514726a != r108) goto L35;
        boolean r121 = true;
    L36:
        if (r121 == false) goto L31;
    L39:
        mp9.b r122 = (mp9.b) r120;     // Catch: Throwable -> L56
        if (r122 != null) goto L44;
        Integer r123 = Boxing.boxInt(0);     // Catch: Throwable -> L56
        r114.unlock(null);
        return r123;
    L44:
        List<mp9.c> r124 = r122.f514731f.get(r115);     // Catch: Throwable -> L56
        if (r124 == null) goto L47;
        r107 = r124.size();     // Catch: Throwable -> L56
    L47:
        if (r107 == 0) goto L50;
        r104 = 1 + ((r107 - 1) / r109);     // Catch: Throwable -> L56
    L50:
        Integer r125 = Boxing.boxInt(r104);     // Catch: Throwable -> L56
        r114.unlock(null);
        return r125;
    L35:
        r121 = false;
        goto L36
    L38:
        r120 = null;
        goto L39
    L53:
        Integer r126 = Boxing.boxInt(0);     // Catch: Throwable -> L56
        r114.unlock(null);
        return r126;
    L56:
        th = move-exception;
        r114.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r114 = this.f364356d;
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.label = 1;
        if (r114.a(null, r100) != r102) goto L59;
        return r102;
    L7:
        r100 = new MediaRepositoryImpl$getCurPage$1(this, r111);
        goto L8
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object d(mp9.a r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof MediaRepositoryImpl$hasMore$1) == false) goto L7;
        MediaRepositoryImpl$hasMore$1 r100 = (MediaRepositoryImpl$hasMore$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) r100.L$1;
        mp9.a r105 = (mp9.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
        kotlinx.coroutines.sync.a r114 = r113;
        r110 = r105;
    L59:
        Long r106 = r110.f514724a;     // Catch: Throwable -> L56
        boolean r107 = false;
        if (r106 == null) goto L53;
        long r108 = r106.longValue();     // Catch: Throwable -> L56
        MediaTab r115 = r110.f514725b;     // Catch: Throwable -> L56
        if (r115 != null) goto L24;
        Boolean r116 = Boxing.boxBoolean(false);     // Catch: Throwable -> L56
        r114.unlock(null);
        return r116;
    L24:
        List<mp9.b> r109 = this.f364359g.getValue();     // Catch: Throwable -> L56
        if (r109 == null) goto L50;
        Iterator<T> r117 = r109.iterator();     // Catch: Throwable -> L56
    L28:
        if (r117.hasNext() == false) goto L35;
        Object r118 = r117.next();     // Catch: Throwable -> L56
        if (((mp9.b) r118).f514726a != r108) goto L32;
        boolean r119 = true;
    L33:
        if (r119 == false) goto L28;
    L36:
        mp9.b r120 = (mp9.b) r118;     // Catch: Throwable -> L56
        if (r120 == null) goto L50;
        Integer r121 = r120.f514730e.get(r115);     // Catch: Throwable -> L56
        if (r121 == null) goto L41;
        int r122 = r121.intValue();     // Catch: Throwable -> L56
    L42:
        List<mp9.c> r123 = r120.f514731f.get(r115);     // Catch: Throwable -> L56
        if (r123 == null) goto L45;
        int r124 = r123.size();     // Catch: Throwable -> L56
    L46:
        if (r124 < r122) goto L49;
        r104 = false;
    L49:
        r107 = r104;
        goto L50
    L45:
        r124 = 0;
        goto L46
    L41:
        r122 = 0;
        goto L42
    L32:
        r119 = false;
        goto L33
    L35:
        r118 = null;
    L50:
        Boolean r125 = Boxing.boxBoolean(r107);     // Catch: Throwable -> L56
        r114.unlock(null);
        return r125;
    L53:
        Boolean r126 = Boxing.boxBoolean(false);     // Catch: Throwable -> L56
        r114.unlock(null);
        return r126;
    L56:
        th = move-exception;
        r114.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r114 = this.f364356d;
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.label = 1;
        if (r114.a(null, r100) != r102) goto L59;
        return r102;
    L7:
        r100 = new MediaRepositoryImpl$hasMore$1(this, r111);
        goto L8
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object e(List<? extends MediaTab> r100, Continuation<? super List<mp9.b>> r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MediaRepositoryImpl$initMediaFolders$2(this, r100, null), r101);
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final int c(long r100, MediaTab r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "mediaTab");
        op9.b r103 = this.f364358f;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "mediaTab");
        SparseArray<LongSparseArray<Integer>> r104 = r103.f524786b.get(r100, null);
        if (r104 == null) goto L14;
        LongSparseArray<Integer> r105 = r104.get(r101.getId(), null);
        if (r105 == null) goto L15;
        Integer r106 = r105.get(r102, -1);
        if (r106 == null) goto L12;
        r106.intValue();
    L12:
        Intrinsics.checkNotNull(r106);
        return r106.intValue();
    L15:
        return -1;
    L14:
        return -1;
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object f(int r110, int r111, List<? extends MediaTab> r112, Continuation<? super List<mp9.c>> r113) {
        if ((r113 instanceof MediaRepositoryImpl$fastLoadMediaItems$1) == false) goto L7;
        MediaRepositoryImpl$fastLoadMediaItems$1 r100 = (MediaRepositoryImpl$fastLoadMediaItems$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        ResultKt.throwOnFailure(r114);     // Catch: Exception -> L21
    L19:
        List r115 = (List) r114;     // Catch: Exception -> L21
        Lazy r116 = i.f530229a;     // Catch: Exception -> L21
        JSONObject r117 = new JSONObject();     // Catch: Exception -> L21
        int r118 = this.f364357e + 1;     // Catch: Exception -> L21
        this.f364357e = r118;     // Catch: Exception -> L21
        r117.put("notify_times", r118);     // Catch: Exception -> L21
        r117.put("album_size", r115.size());     // Catch: Exception -> L21
        r117.put("data_type", "media");     // Catch: Exception -> L21
        r117.put("is_success", 1);     // Catch: Exception -> L21
        i.b(r117);     // Catch: Exception -> L21
        int r119 = e0.f364440a;     // Catch: Exception -> L21
        e0.d(this.f364355c, "result fastLoadMediaItems: " + r115.size());     // Catch: Exception -> L21
        return r115;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r114);
        int r120 = e0.f364440a;
        e0.d(this.f364355c, "fastLoadMediaItems: " + r110 + ", " + r111 + ", " + r112.size());
        e r121 = this.f364353a;     // Catch: Exception -> L21
        mp9.a r104 = new mp9.a(null, (MediaTab) CollectionsKt.first(r112));     // Catch: Exception -> L21
        r100.label = 1;     // Catch: Exception -> L21
        r114 = r121.c(r110, r111, r104, r100);     // Catch: Exception -> L21
        if (r114 != r102) goto L19;
        return r102;
    L21:
        e = move-exception;
        Lazy r122 = i.f530229a;
        JSONObject r123 = new JSONObject();
        int r124 = this.f364357e + 1;
        this.f364357e = r124;
        r123.put("notify_times", r124);
        r123.put("error_msg", e.getMessage());
        r123.put("data_type", "media");
        r123.put("is_success", 0);
        i.b(r123);
        int r125 = e0.f364440a;
        e0.c(this.f364355c, "fastLoadMediaItems: An error occurred，" + ExceptionsKt.stackTraceToString(e));
        return CollectionsKt.emptyList();
    L7:
        r100 = new MediaRepositoryImpl$fastLoadMediaItems$1(this, r113);
        goto L8
    }

    @Override // com.larus.photopicker.v2.impl.data.d
    public final Object i(int r100, int r110, mp9.a r111, Continuation<? super Unit> r112) {
        if (r111 == null) goto L4;
        Object r101 = BuildersKt.withContext(Dispatchers.getIO(), new MediaRepositoryImpl$loadMore$2(this, r100, r110, r111, null), r112);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r101;
    L9:
        return Unit.INSTANCE;
    L4:
        return Unit.INSTANCE;
    }
}
