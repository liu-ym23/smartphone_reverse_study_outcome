package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00013B\u0007¢\u0006\u0004\b0\u00101J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010\u0017\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016J0\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\u001cH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016J\u0016\u0010!\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016J0\u0010\"\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\u001cH\u0016J0\u0010#\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u001cH\u0016R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R'\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u0011\u0010*R'\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b \u0010*R'\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b\u0007\u0010*¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/a;", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/c;", "", "Lcom/bytedance/android/live/multilink/ktv/SongUniqueInfo;", "getKtvSongUniqueInfoList", "getKtvPublicSongUniqueInfoList", "getKtvPrivateSongUniqueInfoList", "getSelfKtvSongUniqueInfoList", "", "list", "", "updateKtvSongUniqueInfoList", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "getKtvPublicOrderedSongList", "getKtvOrderedSongList", "", "uid", "getKtvCurSelfOrderedSongList", "getKtvPublicFirstOrderedSong", "getKtvPublicSecondOrderedSong", "updateKtvOrderedSongList", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "needObserveOnUi", "Lio/reactivex/functions/Consumer;", "observer", "Lio/reactivex/disposables/Disposable;", "observerKtvOrderedSongListChange", "getKtvSingSongList", "updateKtvSingSongList", "observerKtvSingSongListChange", "observerKtvSongUniqueInfoListChange", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/live/datacontext/m;", "ktvOrderedSongList$delegate", "Lcom/bytedance/live/datacontext/p;", "()Lcom/bytedance/live/datacontext/m;", "ktvOrderedSongList", "ktvSingSongList$delegate", "ktvSingSongList", "ktvSongUniqueInfoList$delegate", "ktvSongUniqueInfoList", "<init>", "()V", "Companion", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class OrderedSongDataContext extends DataContext implements com.bytedance.android.livesdk.ktvimpl.base.orderedsong.a, com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b, c {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final b Companion = null;
    public static final String TAG = "OrderedSongDataContext";
    private final CompositeDisposable compositeDisposable;
    private final p ktvOrderedSongList$delegate;
    private final p ktvSingSongList$delegate;
    private final p ktvSongUniqueInfoList$delegate;

    public static final class a implements Action {
        public final /* synthetic */ OrderedSongDataContext a;

        public a(OrderedSongDataContext r1) {
            this.a = r1;
        }

        public final void run() {
            if (v.a() == false) goto L5;
            ALogger.i(OrderedSongDataContext.TAG, "onCleared ;; " + this.a.getClass().getSimpleName() + " ;; " + this.a.hashCode() + " ;; trace == " + Log.getStackTraceString(new Throwable()));
        L6:
            OrderedSongDataContext.access$getCompositeDisposable$p(this.a).clear();
            return;
        L5:
            ALogger.i(OrderedSongDataContext.TAG, "onCleared ;; " + this.a.getClass().getSimpleName() + " ;; " + this.a.hashCode());
            goto L6
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(OrderedSongDataContext.class, "ktvOrderedSongList", "getKtvOrderedSongList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(OrderedSongDataContext.class, "ktvSingSongList", "getKtvSingSongList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(OrderedSongDataContext.class, "ktvSongUniqueInfoList", "getKtvSongUniqueInfoList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new b();
    }

    private final m<List<MusicPanel>> getKtvOrderedSongList() {
        return (m) this.ktvOrderedSongList$delegate.a(this, $$delegatedProperties[0]);
    }

    private final m<List<MusicPanel>> getKtvSingSongList() {
        return (m) this.ktvSingSongList$delegate.a(this, $$delegatedProperties[1]);
    }

    private final m<List<SongUniqueInfo>> getKtvSongUniqueInfoList() {
        return (m) this.ktvSongUniqueInfoList$delegate.a(this, $$delegatedProperties[2]);
    }

    public OrderedSongDataContext() {
        CompositeDisposable r0 = new CompositeDisposable();
        this.compositeDisposable = r0;
        Disposable r1 = getOnCleared().subscribe(new a(this));
        if (r1 == null) goto L5;
        RxUtilKt.c(r1, r0);
    L5:
        this.ktvOrderedSongList$delegate = q.d(this, new ArrayList());
        this.ktvSingSongList$delegate = q.d(this, new ArrayList());
        this.ktvSongUniqueInfoList$delegate = q.d(this, new ArrayList());
    }

    /* JADX INFO: renamed from: getKtvOrderedSongList, reason: collision with other method in class */
    public List<MusicPanel> m199getKtvOrderedSongList() {
        return (List) getKtvOrderedSongList().getValue();
    }

    public List<SongUniqueInfo> getKtvPrivateSongUniqueInfoList() {
        Iterable r0 = (Iterable) getKtvSongUniqueInfoList().getValue();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((!((SongUniqueInfo) r3).isPublic()) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public MusicPanel getKtvPublicFirstOrderedSong() {
        MusicPanel r0 = (MusicPanel) CollectionsKt.firstOrNull(m200getKtvSingSongList());
        if (r0 == null) goto L10;
        j.l.getClass();
        if (j.a() == true) goto L7;
        return r0;
    L7:
        if (j.d(r0.a) == false) goto L12;
        return null;
    L12:
        return r0;
    L10:
        return r0;
    }

    public List<MusicPanel> getKtvPublicOrderedSongList() {
        List<MusicPanel> r0 = m199getKtvOrderedSongList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((MusicPanel) r3).e == true) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public MusicPanel getKtvPublicSecondOrderedSong() {
        return (MusicPanel) CollectionsKt.getOrNull(m200getKtvSingSongList(), 1);
    }

    public List<SongUniqueInfo> getKtvPublicSongUniqueInfoList() {
        Iterable r0 = (Iterable) getKtvSongUniqueInfoList().getValue();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (((SongUniqueInfo) r3).isPublic() == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    /* JADX INFO: renamed from: getKtvSingSongList, reason: collision with other method in class */
    public List<MusicPanel> m200getKtvSingSongList() {
        return (List) getKtvSingSongList().getValue();
    }

    /* JADX INFO: renamed from: getKtvSongUniqueInfoList, reason: collision with other method in class */
    public List<SongUniqueInfo> m201getKtvSongUniqueInfoList() {
        return (List) getKtvSongUniqueInfoList().getValue();
    }

    public List<SongUniqueInfo> getSelfKtvSongUniqueInfoList() {
        Iterable r0 = (Iterable) getKtvSongUniqueInfoList().getValue();
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((SongUniqueInfo) r3).getUserId(), k.n(IMiddlewareUserService.class).user().n().toString()) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        return r1;
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(OrderedSongDataContext r0) {
        return r0.compositeDisposable;
    }

    public List<MusicPanel> getKtvCurSelfOrderedSongList(String r5) {
        Intrinsics.checkNotNullParameter(r5, "uid");
        List<MusicPanel> r0 = m199getKtvOrderedSongList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        Object r3 = r2.next();
        OrderInfo r4 = ((MusicPanel) r3).d();
        if (r4 == null) goto L11;
        InteractiveSongUserInfo r6 = r4.getTopUser();
        if (r6 == null) goto L11;
        String r7 = r6.getIdString();
        if (r7 == null) goto L11;
    L13:
        if (Intrinsics.areEqual(r7, r5) == false) goto L4;
        r1.add(r3);
    L11:
        r7 = "";
        goto L13
    L15:
        return r1;
    }

    public void updateKtvOrderedSongList(List<MusicPanel> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        if (v.a() == false) goto L5;
        ALogger.i(TAG, "updateKtvOrderedSongList ;; list.size == " + r4.size() + " ;; trace == " + Log.getStackTraceString(new Throwable()));
    L7:
        if (((Boolean) KtvSettingHelper.w.getValue()).booleanValue() == true) goto L9;
        getKtvOrderedSongList().setValue(r4);
        return;
    L9:
        if (isCleared() == true) goto L13;
        getKtvOrderedSongList().setValue(r4);
        return;
    L13:
        return;
    L5:
        ALogger.i(TAG, "updateKtvOrderedSongList ;; list.size == " + r4.size());
        goto L7
    }

    public void updateKtvSingSongList(List<MusicPanel> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        if (((Boolean) KtvSettingHelper.w.getValue()).booleanValue() == true) goto L5;
        getKtvSingSongList().setValue(r2);
        return;
    L5:
        if (isCleared() == true) goto L9;
        getKtvSingSongList().setValue(r2);
        return;
    }

    public void updateKtvSongUniqueInfoList(List<SongUniqueInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        if (((Boolean) KtvSettingHelper.w.getValue()).booleanValue() == true) goto L5;
        getKtvSongUniqueInfoList().setValue(r2);
        return;
    L5:
        if (isCleared() == true) goto L9;
        getKtvSongUniqueInfoList().setValue(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.orderedsong.a
    public Disposable observerKtvOrderedSongListChange(LifecycleOwner r2, boolean r3, Consumer<List<MusicPanel>> r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (r2 == null) goto L7;
        if (r3 == false) goto L12;
        return ((ObservableSubscribeProxy) RxUtilKt.h(getKtvOrderedSongList().a()).as(AutoDispose.bind(r2))).subscribe(r4);
    L12:
        return ((ObservableSubscribeProxy) getKtvOrderedSongList().a().as(AutoDispose.bind(r2))).subscribe(r4);
    L7:
        if (r3 == false) goto L10;
        return RxUtilKt.h(getKtvOrderedSongList().a()).subscribe(r4);
    L10:
        return getKtvOrderedSongList().a().subscribe(r4);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b
    public Disposable observerKtvSingSongListChange(LifecycleOwner r2, boolean r3, Consumer<List<MusicPanel>> r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (r2 == null) goto L7;
        if (r3 == false) goto L12;
        return ((ObservableSubscribeProxy) RxUtilKt.h(getKtvSingSongList().a()).as(AutoDispose.bind(r2))).subscribe(r4);
    L12:
        return ((ObservableSubscribeProxy) getKtvSingSongList().a().as(AutoDispose.bind(r2))).subscribe(r4);
    L7:
        if (r3 == false) goto L10;
        return RxUtilKt.h(getKtvSingSongList().a()).subscribe(r4);
    L10:
        return getKtvSingSongList().a().subscribe(r4);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c
    public Disposable observerKtvSongUniqueInfoListChange(LifecycleOwner r2, boolean r3, Consumer<List<SongUniqueInfo>> r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (r2 == null) goto L7;
        if (r3 == false) goto L12;
        return ((ObservableSubscribeProxy) RxUtilKt.h(getKtvSongUniqueInfoList().a()).as(AutoDispose.bind(r2))).subscribe(r4);
    L12:
        return ((ObservableSubscribeProxy) getKtvSongUniqueInfoList().a().as(AutoDispose.bind(r2))).subscribe(r4);
    L7:
        if (r3 == false) goto L10;
        return RxUtilKt.h(getKtvSongUniqueInfoList().a()).subscribe(r4);
    L10:
        return getKtvSongUniqueInfoList().a().subscribe(r4);
    }
}
