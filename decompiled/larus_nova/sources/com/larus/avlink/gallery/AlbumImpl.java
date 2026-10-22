package com.larus.avlink.gallery;

import androidx.fragment.app.Fragment;
import com.bytedance.keva.Keva;
import com.larus.avlink.api.IAlbumService;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.view.MineAlbumFragment;
import com.larus.home.impl.sdk.s;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.x0;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\rR\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/avlink/gallery/AlbumImpl;", "Lcom/larus/avlink/api/IAlbumService;", "<init>", "()V", "weakAlbumFragmentReference", "Ljava/lang/ref/WeakReference;", "Lcom/larus/platform/api/IMineAlbumFragment;", "albumFragment", "Lcom/larus/voice_setting/voice/base/ProfileInfoBaseFragment;", "albumEnable", "", "getCurrentAlbumFragment", "hasCompletedMedia", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumImpl implements IAlbumService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f292331b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<x0> f292332a;

    public static final class a {
        public a() {
        }
    }

    public AlbumImpl() {
    }

    static {
        f292331b = new a();
    }

    @Override // com.larus.avlink.api.IAlbumService
    public final Fragment a() {
        MineAlbumFragment r100 = new MineAlbumFragment();
        this.f292332a = new WeakReference(r100);
        return r100;
    }

    @Override // com.larus.avlink.api.IAlbumService
    public final x0 b() {
        WeakReference<x0> r100 = this.f292332a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // com.larus.avlink.api.IAlbumService
    public final boolean c() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r101 = false;
        if (r100 == null) goto L7;
        s r102 = r100.s0();
        if (r102 == null) goto L7;
        boolean r103 = Intrinsics.areEqual(r102.E(), Boolean.TRUE);
    L9:
        if (r103 == true) goto L19;
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r104 == null) goto L15;
        s r105 = r104.s0();
        if (r105 == null) goto L15;
        boolean r106 = Intrinsics.areEqual(r105.D(), Boolean.TRUE);
    L16:
        if (r106 == true) goto L19;
        boolean r107 = false;
    L20:
        f292331b.getClass();
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L23
        Object r109 = Result.m9449constructorimpl(Boolean.valueOf(Keva.getRepo("dora_kv_env", 0).getBoolean("key_dataset_inject_enabled", false)));     // Catch: Throwable -> L23
    L25:
        Boolean r110 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r109) == false) goto L28;
        r109 = r110;
    L28:
        boolean r111 = ((Boolean) r109).booleanValue();
        if (r107 == true) goto L31;
        if (r111 == true) goto L31;
    L32:
        FLogger.f375446a.i("AlbumImpl", "hasDoraE device: " + r107 + ", injectEnabled: " + r111 + ", enable: " + r101);
        return r101;
    L31:
        r101 = true;
    L23:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L15:
        r106 = false;
    L19:
        r107 = true;
    L7:
        r103 = false;
        goto L9
    }

    @Override // com.larus.avlink.api.IAlbumService
    public final Object d(Continuation<? super Boolean> r100) {
        if ((r100 instanceof AlbumImpl$hasCompletedMedia$1) == false) goto L7;
        AlbumImpl$hasCompletedMedia$1 r101 = (AlbumImpl$hasCompletedMedia$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        if (r105 == 0) goto L17;
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L13
    L21:
        List r107 = (List) r103;     // Catch: Exception -> L13
        if ((r107 instanceof Collection) == true) goto L24;
    L26:
        Iterator r108 = r107.iterator();     // Catch: Exception -> L13
    L27:
        if (r108.hasNext() == false) goto L37;
        if (((MediaMetadata) r108.next()).getLifecycleState() != MediaLifecycleState.COMPLETED) goto L32;
        boolean r109 = true;
    L33:
        if (r109 == false) goto L27;
        r106 = true;
        goto L37
    L32:
        r109 = false;
    L37:
        return Boxing.boxBoolean(r106);
    L24:
        if (r107.isEmpty() == false) goto L26;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        AlbumDataBaseHelper r110 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L13
        r101.label = 1;     // Catch: Exception -> L13
        r103 = r110.m(r101);     // Catch: Exception -> L13
        if (r103 != r104) goto L21;
        return r104;
    L13:
        e = move-exception;
        FLogger.f375446a.e("AlbumImpl", "check has completed media exception", e);
    L7:
        r101 = new AlbumImpl$hasCompletedMedia$1(this, r100);
        goto L8
    }
}
